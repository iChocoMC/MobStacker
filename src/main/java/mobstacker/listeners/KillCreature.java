package mobstacker.listeners;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillCreature implements Listener {
    
    @EventHandler
    public void kill(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity.getCustomName() == null) {
            return;
        }

        if (!(entity instanceof Creature)) { 
            return;
        }

        int amount = Integer.parseInt(entity.getCustomName()) - 1;

        if (amount > 0) {
            Entity newEntity = entity.getWorld().spawnEntity(entity.getLocation(), entity.getType());
            newEntity.setCustomName(""+amount);
        }
    }
}