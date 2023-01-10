package mobstacker;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mobstacker.api.MobStackerAPI;
import mobstacker.commands.MobStackerCommand;
import mobstacker.listeners.*;
import mobstacker.methods.Methods;

public class MobStacker extends JavaPlugin {

    private boolean toggle = true;

    @Override
    public void onEnable() {

        if (!toggle) {
            return;
        }

        this.saveDefaultConfig();

        new Methods().start(this);
        new MobStackerAPI();

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

    public void setToggle(CommandSender sender) {
        toggle = !toggle;
        sender.sendMessage("The plugin is enable: §a" + toggle);

        this.getServer().getPluginManager().disablePlugin(this);

        if (toggle) {
            this.getServer().getPluginManager().enablePlugin(this);
        }
    }
}
