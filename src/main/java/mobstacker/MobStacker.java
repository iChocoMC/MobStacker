package mobstacker;

import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.listeners.CreatureSpawn;
import mobstacker.utils.SpawnUtil;

public class MobStacker extends JavaPlugin{
    
    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new CreatureSpawn(), this);
        SpawnUtil.startUtil(this.getConfig());
    }
}
