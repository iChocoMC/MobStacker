package mobstacker.api;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mobstacker.methods.Methods;
import mobstacker.utils.IntegerUtil;

public class MobStackerAPI {

    private static MobStackerAPI api;

    public MobStackerAPI() {
        api = this;
    }

    /*
     * Delete all entities in world
     */
    public void deleteAllEntities(CommandSender sender, World world) {
        int amount = 0;

        for (Entity entity : world.getEntities()) {
            if (entity.getType() != EntityType.PLAYER) {
                amount++;
                entity.remove();
            }
        }
        sender.sendMessage("Entities deleted: §e" + amount);
    }

    /*
     * Delete all entities with a specified type in world
     */
    public void deleteAllEntitiesType(String type, CommandSender sender, World world) {
        EntityType entityType = EntityType.valueOf(type);

        if (entityType == null) {
            sender.sendMessage("The type " + entityType + " don't exist");
            return;
        }

        int amount = 0;
        for (Entity entity : world.getEntities()) {
            if (entity.getType() == entityType) {
                amount++;
                entity.remove();
            }
        }
        sender.sendMessage("Entities deleted: §e" + amount);
    }


    /*
     * Stack a entity
     */
    public void stackEntity(Entity entity) {
        Methods.spawn(entity);
    }

    /*
     * Get all stacked entities in all worlds
     */
    public void statsEntities(CommandSender sender) {
        String statsWorld = "§eStacked Entitis §7- §a§lWorlds§7:";

        for (World world : Bukkit.getWorlds()) {
            int stackedEntitis = 0;

            for (Entity entity : world.getEntities()) {
                int amount = IntegerUtil.parseInt(entity.getCustomName());

                if (amount != 1) {
                    stackedEntitis += amount;
                }
            }
            statsWorld = statsWorld + ("\n §a" + world.getName() + "§7: §e" + stackedEntitis);
        }
        sender.sendMessage(statsWorld);
    }

    public static MobStackerAPI getAPI() {
        return api;
    }
}
