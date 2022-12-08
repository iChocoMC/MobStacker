package mobstacker.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.methods.*;

public abstract class MethodsUtil {
    
    private static MethodsUtil method;

    public static void startUtil(FileConfiguration config) {
        boolean radiusMethod = config.getBoolean("radius-method.enable");
        boolean chunkMethod = config.getBoolean("chunk-method.enable");

        if (radiusMethod) {
            method = new RadiusMethod(config);
            return;
        }
        if (chunkMethod) {
            method = new ChunkMethod();
            return;
        }
        method = new ChunkMethod();
    }

    public static void spawn(Entity entity) {
        method.check(entity, entity.getCustomName());
    }

    public abstract void check(Entity entity, String customName);
}
