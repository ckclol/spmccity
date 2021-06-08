package rise.city.damage;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class Damage implements Listener {
    @EventHandler
    public void de(EntityDamageEvent ev) {
        Player p = (Player) ev.getEntity();
        ItemStack item = p.getInventory().getItemInMainHand();
        ItemMeta meta =  item.getItemMeta();
        PersistentDataContainer itemdata = meta.getPersistentDataContainer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey damage = new NamespacedKey((Plugin) this, "damage");
        NamespacedKey strength = new NamespacedKey((Plugin) this, "strength");
        int st = 0;
        int dam = 0;
        if (data.get(strength, PersistentDataType.INTEGER) + itemdata.get(strength, PersistentDataType.INTEGER) == 0) {
             st = 0;
        }
        else {
             st = data.get(strength, PersistentDataType.INTEGER) + itemdata.get(strength, PersistentDataType.INTEGER);
        }
        if (data.get(damage, PersistentDataType.INTEGER) + itemdata.get(damage, PersistentDataType.INTEGER) == 0) {
             dam = (int) ev.getDamage();
        }
        else {
             dam = data.get(damage, PersistentDataType.INTEGER) + itemdata.get(damage, PersistentDataType.INTEGER);
        }
        ev.setDamage(dam + st);
    }
}
