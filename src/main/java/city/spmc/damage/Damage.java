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
    public void damage(EntityDamageEvent ev) {
        Player p = (Player) ev.getEntity();
        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey strength = new NamespacedKey((Plugin) this, "strength");
        int strengthd = data.get(strength, PersistentDataType.INTEGER);
        int dam2 = (int) ev.getDamage();
        ev.setDamage(dam2 + strengthd);
        if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
            dam2 = 50;
        }
    }
}
