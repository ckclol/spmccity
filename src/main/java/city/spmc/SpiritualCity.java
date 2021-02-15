package city.spmc;

import city.spmc.event.ItemAbilityEvents;
import city.spmc.item.SpecialBedrock;
import city.spmc.levels.LevelHandler;
import city.spmc.rarity.RarityMain;
import city.spmc.utils.ItemCreator;
import city.spmc.utils.NoLoreVanillaItemCreator;
import city.spmc.utils.VanillaItemCreator;
import city.spmc.vanillaitems.Barrier;
import city.spmc.vanillaitems.Bedrock;
import city.spmc.vanillaitems.Stick;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SpiritualCity extends JavaPlugin {
    private static SpiritualCity instance;
    public static Map<String, ItemCreator> items = new HashMap();
    public static Map<String, VanillaItemCreator> vanillaitems = new HashMap();

    @Override
    public void onEnable() {
        registerVanillaItems();
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
        putItem("haha", new SpecialBedrock(1, RarityMain.EAGLE, Material.BEDROCK, Arrays.asList("dd", "dd")));
    }
    public void registerVanillaItems() {
        putVanillaItem(new Bedrock(RarityMain.GODLY, Material.BEDROCK, Arrays.asList(ChatColor.DARK_RED + "wha... how??? You got it, but for what cost???", ChatColor.AQUA + "Wario looks down at the ground...", "Meme god")));
        putVanillaItem(new Barrier(RarityMain.ELITE, Material.BARRIER, Arrays.asList("get gone in 10 secs")));
        putNoLore(new Stick(RarityMain.COMMON, Material.STICK));
    }
    public static SpiritualCity getInstance() {
        return instance;
    }
    public static void putItem(String name, ItemCreator item) {
        items.put(name, item);
    }
    public static void putVanillaItem(VanillaItemCreator vanillaitems) {
        vanillaitems.put("", vanillaitems);
    }
    public static void putNoLore(NoLoreVanillaItemCreator nolore) {nolore.put("", nolore);}
}
