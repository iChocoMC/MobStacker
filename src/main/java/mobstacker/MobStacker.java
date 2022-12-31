package mobstacker;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.commands.MobStackerCommand;
import mobstacker.listeners.*;
import mobstacker.methods.SpawnMethod;

public class MobStacker extends JavaPlugin {
    
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        SpawnMethod.start(this, this.getConfig());

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new CreatureSpawn(this.getConfig()), this);
        pluginManager.registerEvents(new EntityRename(), this);
        pluginManager.registerEvents(new KillCreature(), this);

        this.getCommand("mobstacker").setExecutor(new MobStackerCommand(this));
    }

    public void reloadConfiguration() {
        this.reloadConfig();
        this.onEnable();    
    }
}
