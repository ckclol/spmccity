package city.spmc.utils;

import city.spmc.SpiritualCity;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

import static city.spmc.utils.GetStringFromItem.getStringFromItem;
import static city.spmc.utils.IsItem.isItem;

public class GetItem {
    public static ItemCreator getItem(ItemStack item) {
        return !isItem(item) ? null : (ItemCreator) SpiritualCity.items.get(getStringFromItem(item, "uber-name"));
    }

    public static ItemCreator getItem(String name) {
        Iterator var1 = SpiritualCity.items.keySet().iterator();

        ItemCreator creator;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            String key = (String)var1.next();
            creator = (ItemCreator)SpiritualCity.items.get(key);
        } while(!creator.getName().equals(name));

        return creator;
    }
}
