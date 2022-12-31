package mobstacker.methods.types;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.methods.SpawnMethod;
import mobstacker.utils.IntegerUtil;

public class ChunkMethod extends SpawnMethod {

    @Override
    public void check(Entity entity) {

        int amount = 1;
        EntityType type = entity.getType();

        for (Entity otherEntity : entity.getLocation().getChunk().getEntities()) {

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