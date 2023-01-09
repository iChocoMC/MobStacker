package mobstacker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import org.bukkit.inventory.ItemStack;

import mobstacker.utils.IntegerUtil;

import org.bukkit.Material;

public class EntityRename implements Listener {
    
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void rename(PlayerInteractEntityEvent event) {

        ItemStack item = event.getPlayer().getItemInHand();

        if (item.getType() != Material.NAME_TAG) {
            return;
        }

        if (IntegerUtil.parseInt(item.getItemMeta().getDisplayName()) != 1) {
            event.setCancelled(true);
        }
    }
}
