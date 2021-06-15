package rise.city.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import rise.city.levels.LevelMain;
import rise.city.rarity.RarityMain;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
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

    public static String convertLevel(LevelMain lvl) {
        String l = new String("null");
        switch (lvl) {
            case NORMAL:
                l = "Level 1 ";
                break;
            case MUTATED:
                l = "Level 25 ";
                break;
            case HARDCORE:
                l = "Level 50 ";
                break;
            case EXTREME:
                l = "Level 69 ";
                break;
            case EPIC:
                l = "Level 200 ";
                break;
            case LEGENDARY:
                l = "Level 6969 ";
                break;
            case GODLY:
                l = "Level 69420 ";
                break;
        }
        return l;
    }

    public static String convertRarity(RarityMain r) {
        String r2;
        switch (r) {
            case EAGLE:
                r2 = RarityMain.getGradient(RarityMain.EAGLE);
                break;
            case COMMON:
                r2 = RarityMain.getGradient(RarityMain.COMMON);
                break;
            case UNCOMMON:
                r2 = RarityMain.getGradient(RarityMain.UNCOMMON);
                break;
            case RARE:
                r2 = RarityMain.getGradient(RarityMain.RARE);
                break;
            case EPIC:
                r2 = RarityMain.getGradient(RarityMain.EPIC);
                break;
            case ELITE:
                r2 = RarityMain.getGradient(RarityMain.ELITE);
                break;
            case LEGENDARY:
                r2 = RarityMain.getGradient(RarityMain.LEGENDARY);
                break;
            case GALAXY:
                r2 = RarityMain.getGradient(RarityMain.GALAXY);
                break;
            case MYTHIC:
                r2 = RarityMain.getGradient(RarityMain.MYTHIC);
                break;
            case GODLY:
                r2 = RarityMain.getGradient(RarityMain.GODLY);
                break;
            case SKYLY:
                r2 = RarityMain.getGradient(RarityMain.SKYLY);
                break;
            case OCEAN:
                r2 = RarityMain.getGradient(RarityMain.OCEAN);
                break;
            case ADMIN:
                r2 = RarityMain.getGradient(RarityMain.ADMIN);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + r);
        }
        return r2;
    }

    public static String setColor(String string) {
      String s2 = ChatColor.translateAlternateColorCodes('&', string);
        return s2;
    }
    
    public static ItemStack createMaterialItem(String name, Material mat, boolean glow, boolean unb, boolean hunb, List<String> lore, RarityMain rarity, int damage, int strength, int defence) {
      ItemStack returned;
        returned = new ItemStack(mat, 1);
        ItemMeta meta = returned.getItemMeta();
          meta.setDisplayName(setColor(name));
        if (glow) {
          meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
          meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (unb) {
          meta.setUnbreakable(true);
        }
        if (hunb) {
          meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        if (lore != null) {
            List<String> l2 = null;
            for (String ab : lore) {
                l2 = Arrays.asList(convertRarity(rarity), ab);
            }
            meta.setLore(l2);
        }
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier("generic.armor_toughness", defence, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", damage + strength, AttributeModifier.Operation.ADD_NUMBER));
      returned.setItemMeta(meta);
        return returned;
    }

    public static ItemStack createItemStackItem(String name, ItemStack is, boolean glow, boolean unb, boolean hunb, List<String> lore, RarityMain rarity, int damage, int strength, int defence) {
        ItemStack returned;
            returned = is;
            ItemMeta meta = returned.getItemMeta();
            meta.setDisplayName(setColor(name));
            if (glow) {
                meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (unb) {
                meta.setUnbreakable(true);
            }
            if (hunb) {
                meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            if (lore != null) {
                List<String> l2 = null;
                for (String ab : lore) {
                    l2 = Arrays.asList(convertRarity(rarity), ab);
                }
                meta.setLore(l2);
            }
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier("generic.armor_toughness", defence, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", damage + strength, AttributeModifier.Operation.ADD_NUMBER));
            returned.setItemMeta(meta);
        return returned;
    }

}
