package city.spmc.damage;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HoloDamage implements Listener {
    @EventHandler
    public void setHologram(EntityDamageEvent event) throws InterruptedException {
        Entity e = event.getEntity();
        Double damd = event.getDamage();
        String dam = String.valueOf(damd);
        Player p = (Player) event.getEntity();
        Player damager = (Player) p.getLastDamageCause();
        ArmorStand armor = (ArmorStand) e.getWorld().spawnEntity(e.getLocation().add(0, -0.5, 0), EntityType.ARMOR_STAND);
        armor.setVisible(false);
        armor.setGravity(false);
        armor.setCustomNameVisible(true);
        armor.setCustomName(ChatColor.GRAY + dam);
        wait(1);
        armor.remove();
    }
}
