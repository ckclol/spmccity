package rise.city.inventory;

import me.kodysimpson.simpapi.menu.AbstractPlayerMenuUtility;
import me.kodysimpson.simpapi.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import rise.city.RiseCity;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class PageInventorySample extends Menu {

    public PageInventorySample(AbstractPlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Choose a Player to Murder";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public boolean cancelAllClicks() {
        return false;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        ArrayList<Player> players = new ArrayList<Player>(getServer().getOnlinePlayers());

        if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            AbstractPlayerMenuUtility playerMenuUtility = RiseCity.getPlayerMenuUtility(p);
            new PageInventorySample(playerMenuUtility).open();

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {

            //close inventory
            p.closeInventory();

        }
    }

    @Override
    public void setMenuItems() {

        ArrayList<Player> players = new ArrayList<Player>(getServer().getOnlinePlayers());

        if (players != null && !players.isEmpty()) {
        }
    }
}