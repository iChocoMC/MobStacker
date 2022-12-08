package mobstacker.methods;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.utils.IntegerUtil;
import mobstacker.utils.MethodsUtil;

public class ChunkMethod extends MethodsUtil {

    @Override
    public void check(Entity entity, String customName) {

        int amount = 1;
        EntityType type = entity.getType();

        if (customName != null) {
            amount = Integer.parseInt(customName);
        }

        for (Entity otherEntity : entity.getLocation().getChunk().getEntities()) {

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