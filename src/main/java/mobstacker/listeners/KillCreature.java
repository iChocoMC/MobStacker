package mobstacker.listeners;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import mobstacker.utils.IntegerUtil;

public class KillCreature implements Listener {

    @EventHandler
    public void kill(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof Creature)) {
            return;
        }

        int amount = IntegerUtil.parseInt(entity.getCustomName()) - 1;

        if (amount < 1) {
            return;
        }

        entity = entity.getWorld().spawn(entity.getLocation(), entity.getClass());

        if (amount != 1) {
            entity.setCustomName(""+amount);
            return;
        }
        entity.setCustomName(null);
    }
}