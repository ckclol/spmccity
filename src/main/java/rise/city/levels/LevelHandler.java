package rise.city.levels;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import rise.city.utils.Utils;

public class LevelHandler implements Listener {
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        Entity e2 = e.getEntity();
        if (e2 instanceof LivingEntity) {
            Double d = ((LivingEntity) e2).getHealth();
            String name = e2.getCustomName();
            // will fix soon...
        }
    }
}
