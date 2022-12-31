package mobstacker.listeners;

import java.util.LinkedList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import mobstacker.features.Feature;
import mobstacker.features.blacklist.EntitiesFeature;
import mobstacker.features.blacklist.WorldsFeature;
import mobstacker.methods.SpawnMethod;

public class CreatureSpawn implements Listener {

    private final LinkedList<Feature> features = new LinkedList<>();

    public CreatureSpawn(FileConfiguration config) {
        if (config.getBoolean("features.blacklist-entities")) {
            features.add(new EntitiesFeature(config));
        }
        if (config.getBoolean("features.blacklist-worlds")) {
            features.add(new WorldsFeature(config));
        }
    }

    @EventHandler
    public void spawn(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();
        for (Feature feature : features) {
            if (feature.execute(entity)) {
                return;
            }
        }
        SpawnMethod.spawn(entity);
    }
}
