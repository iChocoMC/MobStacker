package mobstacker.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mobstacker.MobStacker;
import mobstacker.api.MobStackerAPI;

public class MobStackerCommand implements CommandExecutor {
    
    private final MobStacker plugin;

    public MobStackerCommand(MobStacker plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("mobstacker.command")) {
            sender.sendMessage("§cYou don't have permissions for execute this command");
            return true;
        }
        
        if (args.length < 1) {
            sender.sendMessage(correctUsage());
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                plugin.reloadConfiguration();
                sender.sendMessage("§aPlugin reloaded! §7| §fiChocoMC_");
            break;

            case "stats":
                MobStackerAPI.statsEntities(sender);
            break;

            case "deleteall":
                deleteAllEntities(args, sender);
            break;

            default:
                sender.sendMessage(correctUsage());
        }
        return false;
    }

    private String correctUsage() {
        return 
            "\n " + "§aMobStacker §7| §fiChocoMC_" +
            "\n" +
            "\n     §a/mobstacker:" +
            "\n         §estats §7| §fGet all stacked mobs in all worlds" +
            "\n         §ereload §7| §fReload config.yml" +
            "\n         §edeleteall §7| §fDelete all entities in world";
    }

    private void deleteAllEntities(String[] args, CommandSender sender) {

        World world;

        if (!(sender instanceof Player)) {

            if (args.length != 3) {
                sender.sendMessage("§fFormat: §a/mobstacker deleteall §e(world)");
                return;
            }

            world = Bukkit.getWorld(args[2]);

            if (world == null) {
                sender.sendMessage("The world " + args[2] + " don't exist");
                return;
            }

        } else {
            Player player = (Player)sender;
            world = player.getWorld();
        }
        MobStackerAPI.deleteAllEntities(sender, world);
    }
}