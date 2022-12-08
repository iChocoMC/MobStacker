package mobstacker;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.listeners.*;
import mobstacker.utils.MethodsUtil;

public class MobStacker extends JavaPlugin{
    
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        try {
            MethodsUtil.startUtil(this.getConfig());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new CreatureSpawn(), this);
        pluginManager.registerEvents(new KillCreature(), this);
        pluginManager.registerEvents(new EntityRename(), this);
    }
}
