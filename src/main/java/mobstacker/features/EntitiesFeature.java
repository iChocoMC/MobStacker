package mobstacker.features;

import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.interfaces.Feature;

public class EntitiesFeature implements Feature {

    private final HashSet<EntityType> blacklist;

    public EntitiesFeature(FileConfiguration config) {
        List<String> list = config.getStringList("blacklist-entities");
        blacklist = new HashSet<>(list.size()+1);

        for (String string : list) {
            try {
                blacklist.add(EntityType.valueOf(string));
            } catch (Exception e) {
                Bukkit.getLogger().warning("The entity type: " + string + " don't exit");
                continue;
            }
        }
    }

    @Override
    public boolean execute(Entity entity) {
        return blacklist.contains(entity.getType());
    }
}
