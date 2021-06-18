package rise.city;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import rise.city.damage.Damage;
import rise.city.damage.HoloDamage;
import rise.city.exp.Exp;
import rise.city.healthbar.HealthbarHandler;
import rise.city.levels.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rise.city.test.DamageTester;

import java.util.logging.Logger;

public final class RiseCity extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    private static Exp exp = null;

    @Override
    public void onEnable() {
        registerRecipes();
        registerEvents();
        registerCommands();
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
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

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupExp() {
        RegisteredServiceProvider<Exp> rsp = getServer().getServicesManager().getRegistration(Exp.class);
        if (rsp == null) {
            return false;
        }
        exp = rsp.getProvider();
        return exp != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Exp getExp() {
        return exp;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

}
