package mobstacker.methods;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import mobstacker.utils.SpawnUtil;

public class ChunkMethod extends SpawnUtil {

    @Override
    public void check(Entity entity) {

        int amount = 1;
        Location location = entity.getLocation();

        if (entity.getCustomName() != null) {
            amount = Integer.parseInt(entity.getCustomName());
        }

        for (Entity otherEntity : location.getChunk().getEntities()) {

            if (otherEntity.getType() != entity.getType()) {
                continue;
            }
                
            if (otherEntity.getCustomName() == null) {
                amount++;
                otherEntity.remove();
                continue;
            }
            amount+= Integer.parseInt(otherEntity.getCustomName());
            otherEntity.remove();
        }
        if (amount != 1) {
            entity.setCustomName(""+amount);
        }
    }
}
