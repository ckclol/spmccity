package rise.city;

import me.kodysimpson.simpapi.menu.AbstractPlayerMenuUtility;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.api.EnchantRegister;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.plugin.commands.CommandNode;
import org.plugin.tagSystem.TagManager;
import rise.city.cmd.*;
import rise.city.cmd.ItemMain;
import rise.city.damage.Damage;
import rise.city.damage.HoloDamage;
import rise.city.exp.Exp;
import rise.city.healthbar.HealthbarHandler;
import rise.city.levels.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rise.city.test.DamageTester;

import java.util.HashMap;
import java.util.logging.Logger;

public final class RiseCity extends JavaPlugin {

    private static final RiseCity plugin = new RiseCity();
    private static final HashMap<Player, AbstractPlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
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
        setupExp();
        EnchantRegister.setPlugin(plugin);

        //Sets the version interface
        TagManager.getInstance().createInstance();
    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }
    public void registerCommands() {
        this.getCommand("cench").setExecutor(new CommandNode());
        this.getCommand("dc").setExecutor(new DoubleCoins());
        this.getCommand("tc").setExecutor(new TripleCoins());
        this.getCommand("ah").setExecutor(new AuctionCommand());
        this.getCommand("warp").setExecutor(new ItemMain());
        this.getCommand("battery").setExecutor(new ServerBatteryLife());

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

    public static AbstractPlayerMenuUtility getPlayerMenuUtility(Player p) {
        AbstractPlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {
            playerMenuUtility = new AbstractPlayerMenuUtility(p) {
                @Override
                public Player getOwner() {
                    return super.getOwner();
                }
            };
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p); //Return the object by using the provided player
        }
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

    public static RiseCity getPlugin() {
        return plugin;
    }
    
}
