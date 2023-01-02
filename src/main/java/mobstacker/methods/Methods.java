package mobstacker.methods;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.MobStacker;
import mobstacker.interfaces.SpawnMethod;
import mobstacker.methods.types.ChunkMethod;
import mobstacker.methods.types.RadiusMethod;

public class Methods {

    private static SpawnMethod method;

    public static void start(MobStacker plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("methods.radius-method")) {
            method = new RadiusMethod(config);
            return;
        }

        if (config.getBoolean("methods.chunk-method")) {
            System.out.println("Method: ChunkMethod. Please enable RadiusMethod for better experience");
            method = new ChunkMethod();
            return;
        }
        System.err.println("Please enable any method in config.yml");
        plugin.onDisable();
    }

    public static void spawn(Entity entity) {
        method.check(entity);
    }
}
