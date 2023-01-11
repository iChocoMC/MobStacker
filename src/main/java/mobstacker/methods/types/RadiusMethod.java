package mobstacker.methods.types;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.interfaces.SpawnMethod;
import mobstacker.utils.IntegerUtil;

public class RadiusMethod implements SpawnMethod {

    private final int x, y, z;

    public RadiusMethod(FileConfiguration config) {
        x = config.getInt("radius-method.x");
        y = config.getInt("radius-method.y");
        z = config.getInt("radius-method.z");
    }

    @Override
    public void check(Entity entity) {

        int amount = 1;
        EntityType type = entity.getType();
        List<Entity> entities = entity.getNearbyEntities(x, y, z);

        for (Entity otherEntity : entities) {

            if (otherEntity.getType() != type) {
                continue;
            }
            amount+=IntegerUtil.parseInt(otherEntity.getCustomName());
            otherEntity.remove();
        }

        if (amount != 1) {
            entity.setCustomName(""+amount);
        }
    }
}