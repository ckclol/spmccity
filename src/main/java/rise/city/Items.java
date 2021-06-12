package rise.city;

import org.bukkit.inventory.ItemStack;
import rise.city.rarity.RarityMain;
import rise.city.utils.Utils;

import java.util.Arrays;

public enum Items {
  SUN_PART("&eSun Part", Utils.createItemStackItem("&eSun Part", Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjRkNzY1MWU5ZGViNWMyODEzODIwZmVkMzExZDU0MTExOWYzMTU1ZWFhYjU0OWQzYWQ1MmQyMDJiYzNmMGU3In19fQ=="), true, false, false, Arrays.asList("&cWell,", "You have reached endgame huh?"), RarityMain.GALAXY, 0, 0, 0));
  private String name;
  private ItemStack item;
  
  Items(String name, ItemStack item) {
    this.name = name;
    this.item = item;

  }

  public String getName(Items items) {
    return Utils.setColor(items.name);
  }
  
  public ItemStack getItem(Items items) {
    return items.item;
  }

}
