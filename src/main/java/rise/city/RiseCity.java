package rise.city;

import org.bukkit.entity.EntityType;
import rise.city.event.ItemAbilityEvents;
import rise.city.item.AppleBlock;
import rise.city.item.CraftingTable;
import rise.city.levels.LevelHandler;
import rise.city.levels.LevelMain;
import rise.city.mob.EndermanSimple;
import rise.city.rarity.RarityMain;
import rise.city.utils.ItemCreator;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rise.city.utils.MobCreator;

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
        pm.registerEvents(new ItemAbilityEvents(), this);
        pm.registerEvents(new LevelHandler(), this);
    }
    public void registerItems() {
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