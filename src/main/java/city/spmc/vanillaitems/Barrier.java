package city.spmc.vanillaitems;

import city.spmc.rarity.RarityMain;
import city.spmc.utils.VanillaItemCreator;
import org.bukkit.Material;

import java.util.List;

public class Barrier extends VanillaItemCreator {
    public Barrier(RarityMain rarity, Material m, List<String> lore) {
        super(rarity, m, lore);
    }
}
