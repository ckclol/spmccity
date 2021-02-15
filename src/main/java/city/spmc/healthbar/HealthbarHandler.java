package city.spmc.healthbar;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HealthbarHandler implements Listener {
    @EventHandler
    public void onEntityDamaged(EntityDamageEvent e) {
        Entity e2 = e.getEntity();
        if (e2 instanceof LivingEntity) {
            Double health = ((LivingEntity) e2).getHealth();
            Double max = ((LivingEntity) e2).getMaxHealth();
            String name = e2.getCustomName();
            e2.setCustomNameVisible(false);
            e2.setCustomName("");
            e2.setCustomNameVisible(true);
            e2.setCustomName(name + " " + health + " / " + max);
        }
    }
}
