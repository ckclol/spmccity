package city.spmc.utils;

import city.spmc.SpiritualCity;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

import static city.spmc.utils.GetStringFromItem.getStringFromItem;
import static city.spmc.utils.IsItem.isItem;

public class GetVanillaItem {
    public static VanillaItemCreator getItem(ItemStack item) {
        return !isItem(item) ? null : SpiritualCity.vanillaitems.get(getStringFromItem(item, "uber-name"));
    }

    public static VanillaItemCreator getItem(String name) {
        Iterator var1 = SpiritualCity.items.keySet().iterator();

        VanillaItemCreator creator;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            String key = (String)var1.next();
            creator = SpiritualCity.vanillaitems.get(key);
        } while(!creator.getName().equals(name));

        return creator;
    }
}
