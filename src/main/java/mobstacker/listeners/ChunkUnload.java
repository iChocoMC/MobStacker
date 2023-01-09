package mobstacker.listeners;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkUnload implements Listener {
    
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void unload(ChunkUnloadEvent event) {
        for (Entity entity : event.getChunk().getEntities()) {
            if (!(entity instanceof Creature)) {
                continue;
            }
            entity.remove();
        }
    }
}