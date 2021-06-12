package rise.city.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class Utils {

    public static ItemStack getSkull(String base64EncodedString) {
        final ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        assert meta != null;
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", base64EncodedString));
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        skull.setItemMeta(meta);
        return skull;
    }
    
    public static String setColor(String string) {
      String s2 = ChatColor.translateAlternateColorCodes('&', string);
        return s2;
    }
    
    public ItemStack createItem(String name, Material mat, ItemStack is, boolean glow, boolean unb, boolean hunb, List<String> lore) {
      ItemStack returned;
      if (is!=null && mat=null) {
        returned = is;
        ItemMeta meta = returned.getItemMeta();
        if (glow) {
          meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
          meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (unb) {
          meta.setUnbreakable(true);
        }
        if (hunb) {
          meta.addItemFlags(ItemFlag.HIDE_UNBREAKBLE);
        }
        if (lore != null) {
          meta.setLore(lore);
        }
      returned.setItemMeta(meta);
      } else if (is=null && mat!=null){
        returned = new ItemStack(mat, 1);
        ItemMeta meta = returned.getItemMeta();
        if (glow) {
          meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
          meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (unb) {
          meta.setUnbreakable(true);
        }
        if (hunb) {
          meta.addItemFlags(ItemFlag.HIDE_UNBREAKBLE);
        }
        if (lore != null) {
          meta.setLore(lore);
        }
      returned.setItemMeta(meta);
      } else {    
        returned = null;
      }
        return returned;
    }

}
