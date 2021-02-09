package city.spmc.utils;

import city.spmc.rarity.RarityMain;
import org.bukkit.Material;
import java.util.List;

public abstract class VanillaItemCreator {
    private RarityMain rarity;
    private List<String> lore;
    private Material m;
    public VanillaItemCreator(RarityMain rarity, Material m, List<String> lore) {
        this.rarity = rarity;
        this.m = m;
        this.lore = lore;
    }
    public String getName() {
        return this.m.name();
    }


    public void put(String s, VanillaItemCreator vanillaitems) {
    }
}
