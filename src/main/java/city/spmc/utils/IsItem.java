package city.spmc.utils;

import org.bukkit.inventory.ItemStack;

import static city.spmc.utils.GetStringFromItem.getStringFromItem;

public class IsItem {

    public static boolean isItem(ItemStack item) {
        return getStringFromItem(item, "is-item") != null;
    }

    public static boolean isFromCity(ItemStack item, int id) {
        if (!isItem(item)) {
            return false;
        }
        return false;
    }
}