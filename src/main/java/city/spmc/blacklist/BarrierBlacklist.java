package city.spmc.blacklist;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BarrierBlacklist {
    @EventHandler
    public void click(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.getInventory().contains(Material.BARRIER)) {
            try {
                wait(10);
                p.getInventory().remove(Material.BARRIER);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
    }
}
