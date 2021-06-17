package rise.city;

import org.bukkit.Bukkit;
import rise.city.damage.Damage;
import rise.city.damage.HoloDamage;
import rise.city.healthbar.HealthbarHandler;
import rise.city.levels.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rise.city.test.DamageTester;

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
        pm.registerEvents(new DamageTester(), this);
        pm.registerEvents(new HoloDamage(), this);
        pm.registerEvents(new Damage(), this);
        pm.registerEvents(new LevelHandler(), this);
        pm.registerEvents(new HealthbarHandler(), this);
    }
    public void registerRecipes() {
    }


}
