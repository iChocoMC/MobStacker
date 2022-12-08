package mobstacker;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.listeners.*;
import mobstacker.utils.MethodsUtil;

public class MobStacker extends JavaPlugin {
    
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        MethodsUtil.startUtil(this.getConfig());

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new CreatureSpawn(), this);
        pluginManager.registerEvents(new KillCreature(), this);
        pluginManager.registerEvents(new EntityRename(), this);
    }
}
