package mobstacker.methods;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.utils.IntegerUtil;
import mobstacker.utils.MethodsUtil;

public class RadiusMethod extends MethodsUtil {

    private final int x, y, z;

    public RadiusMethod(FileConfiguration config) {
        x = config.getInt("radius-method.x");
        y = config.getInt("radius-method.y");
        z = config.getInt("radius-method.z");
    }

    @Override
    public void check(Entity entity, String customName) {

        int amount = 1;
        EntityType type = entity.getType();

        if (customName != null) {
            amount = Integer.parseInt(customName);
        }

        for (Entity otherEntity : entity.getNearbyEntities(x, y, z)) {

            if (otherEntity.getType() != type) {
                continue;
            }

            if (otherEntity.getCustomName() == null) {
                amount++;
                otherEntity.remove();
                continue;
            }
            amount+= IntegerUtil.parseInt(otherEntity.getCustomName());
            otherEntity.remove();
        }

        if (amount != 1) {
            entity.setCustomName(""+amount);
        }
    }
}