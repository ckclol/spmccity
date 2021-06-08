package rise.city.damage.crit;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HoloCritDamage implements Listener {
    @EventHandler
    public void holo(EntityDamageEvent e) throws InterruptedException {
        Entity e2 = e.getEntity();
        Double damd = e.getDamage();
        String dam = String.valueOf(damd);
        Player p = (Player) e.getEntity();
        Player damager = (Player) p.getLastDamageCause();
        ArmorStand armor = (ArmorStand) e2.getWorld().spawnEntity(e2.getLocation().add(0, -0.5, 0), EntityType.ARMOR_STAND);
        armor.setVisible(false);
        armor.setGravity(false);
        armor.setCustomNameVisible(true);
        armor.setCustomName(ChatColor.RED + dam);
        wait(1);
        armor.remove();
    }
}
