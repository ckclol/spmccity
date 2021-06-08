package rise.city.storage;

import rise.city.utils.ItemCreator;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class ItemDefDam {
    @EventHandler
    public void setitemdefdam(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            NamespacedKey damage = new NamespacedKey((Plugin) this, "damage");
            NamespacedKey strength = new NamespacedKey((Plugin) this, "strength");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer itemdamage = meta.getPersistentDataContainer();
            if (!itemdamage.has(strength, PersistentDataType.INTEGER)) {
                itemdamage.set(damage, PersistentDataType.INTEGER, ItemCreator.getDamage());
                itemdamage.set(strength, PersistentDataType.INTEGER, ItemCreator.getStrength());
            }
        }
    }
}
