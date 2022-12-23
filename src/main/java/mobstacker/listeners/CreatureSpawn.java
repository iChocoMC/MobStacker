package mobstacker.listeners;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import mobstacker.utils.MethodsUtil;

public class CreatureSpawn implements Listener {

    private final Set<EntityType> blackListTypes = new HashSet<>();

    public CreatureSpawn(FileConfiguration config) {
        for (String string : config.getStringList("blacklist-entities")) {
            try {
                blackListTypes.add(EntityType.valueOf(string));                
            } catch (Exception e) {
                System.err.println("The entity type: " + string + " doesn't exit");
                continue;
            }
        }
    }

    @EventHandler
    public void spawn(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();
        if (blackListTypes.contains(entity.getType())) {
            return;
        }
        MethodsUtil.spawn(entity);
    }
}
