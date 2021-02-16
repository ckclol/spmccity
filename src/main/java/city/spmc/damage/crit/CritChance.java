package city.spmc.damage.crit;

public class CritChance {
  @EventHandler
  public void addcrit(EntityDamageEvent ev) {
  Player p = (Player) ev.getEntity(); 
  ItemStack item = p.getInventory().getItemInMainHand();
  PersistentDataContainer itemdata = item.getPersistentDataContainer();
  PersistentDataContainer data = p.getPersistentDataContainer(); 
  NamespacedKey e = new NamespacedKey((Plugin) this, "critchance");
  int basecrit = data.get(e, PersistentDataType.INTEGER);
  int itemcrit = itemdata.get(e, PersistentDataType.INTEGER);
  int totalcrit = basecrit + itemcrit;
  int i = math.random(1, 100);
  if (i>0 && i<totalcrit) {
      int damage = ev.getDamage();
      ev.setDamage(damage + crit);
     } 
  }
}
