package city.spmc.damage.crit;

public class CritChance {
  ItemStack item = p.getInventory().getItemInMainHand();
  PersistentDataContainer itemdata = item.getPersistentDataContainer();
  PersistentDataContainer data = p.getPersistentDataContainer(); 
  NamespacedKey e = new NamespacedKey((Plugin) this, "critchance");
  int basecrit = data.get(e, PersistentDataType.INTEGER);
  int i = math.random(1, 100);
  if (i>0 && i<25) {
     // insert crit chance
  }
}
