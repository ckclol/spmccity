package rise.city.test;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageTester implements Listener {
    @EventHandler
    public void DamageTester(EntityDamageEvent e) {
        System.out.println(e.getDamage());
    }
}
