package mobstacker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.*;

public class EntityRename implements Listener {
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void rename(PlayerInteractEntityEvent event) {

        ItemStack item = event.getPlayer().getItemInHand();

        if (item.getType() != Material.NAME_TAG) {
            return;
        }

        if (isInteger(item.getItemMeta().getDisplayName())) {
            event.setCancelled(true);
        }
    }

    private boolean isInteger(String name) {
        boolean check = false;
        try {
            Integer.parseInt(name);
            check = true;
        } catch (NumberFormatException e) {
            check = false;
        }
        return check;
    }
}
