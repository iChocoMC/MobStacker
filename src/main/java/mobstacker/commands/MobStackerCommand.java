package mobstacker.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

import mobstacker.MobStacker;
import mobstacker.utils.IntegerUtil;

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
        
        if (args.length != 1) {
            sender.sendMessage(correctUsage());
            return true;
        }
        switch (args[0]) {
            case "reload":
                plugin.reloadConfiguration();
                sender.sendMessage("§aPlugin reloaded! §7| §fiChocoMC_");
            break;

            case "stats":
                sender.sendMessage(stackedEntities());
            break;

            default:
                sender.sendMessage(correctUsage());
        }        
        return false;
    }

    public static String correctUsage() {
        return 
            "\n " + "§aMobStacker §7| §fiChocoMC_" +
            "\n" +
            "\n     §a/mobstacker:" +
            "\n         §estats §7| §fGet all stacked mobs in all worlds" +
            "\n         §ereload §7| §fReload config.yml";
    }

    public static String stackedEntities() {
        String statsWorld = "§eStacked Entitis §7- §a§lWorlds§7:";

        for (World world : Bukkit.getWorlds()) {
            int stackedEntitis = 0;

            for (Entity entity : world.getEntities()) {
            
                int amount = IntegerUtil.parseInt(entity.getCustomName());
 
                if (amount == 1) {
                    continue;
                }

                stackedEntitis += amount;
            }

            statsWorld = statsWorld + ("\n §a" + world.getName() + "§7: §e" + stackedEntitis);
        }
        return statsWorld;
    }
}