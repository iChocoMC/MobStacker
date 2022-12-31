package mobstacker.methods;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.MobStacker;
import mobstacker.methods.types.ChunkMethod;
import mobstacker.methods.types.RadiusMethod;

public abstract class SpawnMethod {
    
    private static SpawnMethod method;

    public static void start(MobStacker plugin, FileConfiguration config) {

        if (config.getBoolean("methods.radius-method")) {
            method = new RadiusMethod(config);
            return;
        } 

        if (config.getBoolean("methods.chunk-method")) {
            method = new ChunkMethod();
            System.out.println("Method: ChunkMethod. Please enable RadiusMethod for better experience");
            return;
        }
        System.err.println("Please enable any method in config.yml");
        plugin.onDisable();
    }

    public static void spawn(Entity entity) {
        method.check(entity);
    }

    public abstract void check(Entity entity);
}
