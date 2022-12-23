package mobstacker.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.MobStacker;
import mobstacker.methods.*;

public abstract class MethodsUtil {
    
    private static MethodsUtil method;

    public static void startUtil(MobStacker plugin, FileConfiguration config) {

        if (config.getBoolean("radius-method.enable")) {
            method = new RadiusMethod(config);
            return;
        } 

        if (config.getBoolean("radius-method.enable")) {
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
