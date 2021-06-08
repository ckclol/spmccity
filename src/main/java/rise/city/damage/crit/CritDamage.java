package rise.city.damage.crit;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class CritDamage {
    public static double crit;

    @EventHandler
    public void crit(EntityDamageEvent e) {
       double damage = e.getDamage();
       Player p = (Player) e.getEntity();
       ItemStack item = p.getInventory().getItemInMainHand();
       ItemMeta meta =  item.getItemMeta();
       PersistentDataContainer itemdata = meta.getPersistentDataContainer();
       PersistentDataContainer data = p.getPersistentDataContainer();
       NamespacedKey critdam = new NamespacedKey((Plugin) this, "critdamage");
       crit = (damage * ((data.get(critdam, PersistentDataType.DOUBLE) + itemdata.get(critdam, PersistentDataType.DOUBLE)) / 100));
    }
}
