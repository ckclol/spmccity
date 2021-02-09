package city.spmc.utils;

import city.spmc.SpiritualCity;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class GetStringFromItem {
    public static String getStringFromItem(ItemStack host, String key) {
        NamespacedKey k = new NamespacedKey(SpiritualCity.getInstance(), key);
        if (host == null) {
            return null;
        } else if (!host.hasItemMeta()) {
            return null;
        }
        return key;
    }

}
