package city.spmc.damage;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class Damage implements Listener {
    @EventHandler
    public void de(EntityDamageEvent ev) {
        Player p = (Player) ev.getEntity();
        ItemStack item = p.getInventory().getItemInMainHand();
        PersistentDataContainer itemdata = item.getPersistentDataContainer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey damage = new NamespacedKey((Plugin) this, "damage");
        NamespacedKey strength = new NamespacedKey((Plugin) this, "strength");
        if (data.get(strength, PresistentDataType.INTEGER) + itemdata.get(strength, PersistentDataType.INTEGER) == null) {
             int strength2 = 0;
        }
        else {
             int dam = data.get(strength, PresistentDataType.INTEGER) + itemdata.get(strength, damage, PersistentDataType.INTEGER);
        }
        if (data.get(damage, PresistentDataType.INTEGER) + itemdata.get(damage, PersistentDataType.INTEGER) == null) {
             int dam = (int) ev.getDamage();
        }
        else {
             int dam = data.get(damage, PresistentDataType.INTEGER) + itemdata.get(damage, PersistentDataType.INTEGER);
        }
        ev.setDamage(dam + strength2);
    }
}
