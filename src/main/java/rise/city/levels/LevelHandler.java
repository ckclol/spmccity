package rise.city.levels;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class LevelHandler implements Listener {
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        Entity e2 = e.getEntity();
        if (e2 instanceof LivingEntity) {
            Double d = ((LivingEntity) e2).getHealth();
            String name = e2.getCustomName();
            if (d <= 200) {
                e2.setCustomName("Level " + LevelMain.NORMAL + " " + name);
            }
            if (d <= 1000) {
                e2.setCustomName("Level " + LevelMain.MUTATED + " " + name);
            }
            if (d <= 10000) {
                e2.setCustomName("Level " + LevelMain.HARDCORE + " " + name);
            }
            if (d <= 100000) {
                e2.setCustomName("Level " + LevelMain.EXTREME + " " + name);
            }
            if (d <= 1000000) {
                e2.setCustomName("Level " + LevelMain.EPIC + " " + name);
            }
            if (d <= 100000000) {
                e2.setCustomName("Level " + LevelMain.LEGENDARY + " " + name);
            }
            if (d <= 1000000000) {
                e2.setCustomName("Level " + LevelMain.GODLY + " " + name);
            }
            if (d <= 2000000000) {
                e2.setCustomName("Level " + LevelMain.HEAVENLY + " " + name);
            }
            if (d <= 2147483647) {
                e2.setCustomName("Level " + LevelMain.CKC + " " + name);
            }
        }
    }
}
