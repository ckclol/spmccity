package rise.city;

import org.bukkit.entity.EntityType;
import rise.city.item.*;
import rise.city.levels.*;
import rise.city.mob.*;
import rise.city.rarity.*;
import rise.city.utils.*;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class RiseCity extends JavaPlugin {
    private static RiseCity instance;
    public static Map<String, ItemCreator> items = new HashMap();
    public static Map<String, MobCreator> mobs = new HashMap();

    @Override
    public void onEnable() {
        registerItems();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void registerCommands() {

    }
    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LevelHandler(), this);
    }
    public void registerItems() {
        putItem("Galaxy Helmet", new GalaxyHelmet(4, "Galaxy Helmet", RarityMain.GALAXY, Material.GOLDEN_HELMET, 200, 200, 25000));
        putItem("Sun Part", new SunPart(1, "Sun Part", RarityMain.MYTHIC, Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjRkNzY1MWU5ZGViNWMyODEzODIwZmVkMzExZDU0MTExOWYzMTU1ZWFhYjU0OWQzYWQ1MmQyMDJiYzNmMGU3In19fQ==")));
        putItem("Apple Block", new AppleBlock(2, "Apple Block", RarityMain.GALAXY, Material.REDSTONE_BLOCK, 1, 1, 0, 0, null));
        putItem("Crafting Table", new CraftingTable(3, "Crafting Table", RarityMain.COMMON, Material.CRAFTING_TABLE));
    }
    public void registerMob() {
        putMob("Simple Enderman", new EndermanSimple(1, LevelMain.NORMAL, "Simple Enderman", EntityType.ENDERMAN));
    }
    public static RiseCity getInstance() {
        return instance;
    }
    public static void putItem(String name, ItemCreator item) {
        items.put(name, item);
    }
    public static void putMob(String name, MobCreator mob) {
        mobs.put(name, mob);
    }

}