package mobstacker.listeners;

import java.util.LinkedList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import mobstacker.features.EntitiesFeature;
import mobstacker.features.WorldsFeature;
import mobstacker.interfaces.Feature;
import mobstacker.methods.Methods;

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
        Methods.spawn(entity);
    }
}
