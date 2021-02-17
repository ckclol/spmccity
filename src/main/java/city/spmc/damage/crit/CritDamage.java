package city.spmc.damage.crit;

public class CritDamage {
    @EventHandler
    public void crit(EntityDamageEvent e) {
       double damage = e.getDamage();
       Player p = (Player) e.getEntity();ItemStack item = p.getInventory().getItemInMainHand();
       ItemMeta meta =  item.getItemMeta();
       PersistentDataContainer itemdata = meta.getPersistentDataContainer();
       PersistentDataContainer data = p.getPersistentDataContainer();
       NamespacedKey critdam = new NamespacedKey((Plugin) this, "critdamage");
       public double crit = (damage * ((data.get(critdam, PersistentDataType.DOUBLE) + itemdata.get(critdam, PersistentDataType.DOUBLE)) / 100);
    }
}
