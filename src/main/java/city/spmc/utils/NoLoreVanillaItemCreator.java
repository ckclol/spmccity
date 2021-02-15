package city.spmc.utils;

import city.spmc.rarity.RarityMain;
import org.bukkit.Material;

public abstract class NoLoreVanillaItemCreator {
    private RarityMain rarity;
    private Material m;
    public NoLoreVanillaItemCreator(RarityMain rarity, Material m) {
        this.rarity = rarity;
        this.m = m;
    }
    public String getName() {
        return this.m.name();
    }


    public void put(String s, NoLoreVanillaItemCreator nolore) {
    }
}
