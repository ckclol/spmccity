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

    @Override
    public void onEnable() {
        registerRecipes();
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
    public void registerRecipes() {
    }

}
