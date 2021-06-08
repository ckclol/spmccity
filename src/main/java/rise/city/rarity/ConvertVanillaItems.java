package rise.city.rarity;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ConvertVanillaItems {
    @EventHandler
    public void click(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.getInventory().contains(Material.BEDROCK)) {
            p.getInventory().remove(Material.BARRIER);
            p.sendMessage(ChatColor.RED + "There were a glitched item in your inventory.");
        }
    }
}

