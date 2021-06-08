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

public class CritChance {
  @EventHandler
  public void addcrit(EntityDamageEvent ev) {
  Player p = (Player) ev.getEntity();
  ItemStack item = p.getInventory().getItemInMainHand();
  ItemMeta meta = item.getItemMeta();
  PersistentDataContainer itemdata = meta.getPersistentDataContainer();
  PersistentDataContainer data = p.getPersistentDataContainer(); 
  NamespacedKey e = new NamespacedKey((Plugin) this, "critchance");
  int basecrit = data.get(e, PersistentDataType.INTEGER);
  int itemcrit = itemdata.get(e, PersistentDataType.INTEGER);
  int totalcrit = basecrit + itemcrit;
  int i = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
  if (i>0 && i<totalcrit) {
      int damage = (int) ev.getDamage();
      ev.setDamage(damage + CritDamage.crit);
     } 
  }
}
