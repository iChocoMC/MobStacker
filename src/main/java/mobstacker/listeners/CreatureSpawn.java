package mobstacker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import mobstacker.utils.SpawnUtil;

public class CreatureSpawn implements Listener {

    @EventHandler
    public void spawn(CreatureSpawnEvent event) {
        SpawnUtil.spawn(event.getEntity());
    }
}
