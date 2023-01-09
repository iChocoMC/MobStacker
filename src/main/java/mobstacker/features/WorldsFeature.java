package mobstacker.features;

import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import mobstacker.interfaces.Feature;

public class WorldsFeature implements Feature {

    private final HashSet<World> blacklist;

    public WorldsFeature(FileConfiguration config) {
        List<String> list = config.getStringList("blacklist-worlds");
        blacklist = new HashSet<>(list.size()+1);

        for (String string : list) {

            World world = Bukkit.getWorld(string);

            if (world == null) {
                System.err.println("The world: " + string + " don't exit");
                continue;
            }
            blacklist.add(world);
        }
    }

    @Override
    public boolean execute(Entity entity) {
        return blacklist.contains(entity.getWorld());
    }
}
