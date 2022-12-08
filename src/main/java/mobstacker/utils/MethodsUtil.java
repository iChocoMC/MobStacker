package mobstacker.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.methods.*;

public abstract class MethodsUtil {
    
    private static MethodsUtil method;

    public static void startUtil(FileConfiguration config) throws Exception {
        boolean chunkMethod = config.getBoolean("enable-chunk-method");
        boolean radiusMethod = config.getBoolean("radius-method.enable");

        if (radiusMethod) {
            method = new RadiusMethod(config);
            return;
        }
        if (chunkMethod) {
            method = new ChunkMethod();
            return;
        }
        method = new ChunkMethod();
        throw new Exception("Please enable any method in config.yml, default method: chunkMethod");
    }

    public static void spawn(Entity entity) {
        method.check(entity);
    }

    public abstract void check(Entity entity);
}
