package mobstacker.methods.types;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.interfaces.SpawnMethod;
import mobstacker.utils.IntegerUtil;

public class ChunkMethod implements SpawnMethod {

    @Override
    public void check(Entity entity) {

        int amount = 1;
        EntityType type = entity.getType();
        Entity[] entities = entity.getLocation().getChunk().getEntities();

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