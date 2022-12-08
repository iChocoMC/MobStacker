package mobstacker.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.methods.ChunkMethod;

public abstract class SpawnUtil {
    
    private static SpawnUtil method;

    public static void startUtil(FileConfiguration config) {
        method = new ChunkMethod();
    }

    public static void spawn(Entity entity) {
        method.check(entity);
    }

    public abstract void check(Entity entity);
}
