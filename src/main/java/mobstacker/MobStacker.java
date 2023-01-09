package mobstacker;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.commands.MobStackerCommand;
import mobstacker.listeners.*;
import mobstacker.methods.Methods;

public class MobStacker extends JavaPlugin {
    
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        Methods.start(this);

        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new CreatureSpawn(this.getConfig()), this);
        pluginManager.registerEvents(new EntityRename(), this);
        pluginManager.registerEvents(new KillCreature(), this);

        if (this.getConfig().getBoolean("remove-entities-on-unload-chunk")) {
            pluginManager.registerEvents(new ChunkUnload(), this);
        }

        this.getCommand("mobstacker").setExecutor(new MobStackerCommand(this));
    }

    public void reloadConfiguration() {
        this.reloadConfig();
        this.onEnable();    
    }
}
