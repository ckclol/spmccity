package rise.city.auctionsystem;

import me.kodysimpson.simpapi.menu.AbstractPlayerMenuUtility;
import me.kodysimpson.simpapi.menu.Menu;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class Auction extends Menu {

    public Auction(AbstractPlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Auction House";
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

        Inventory inv = e.getClickedInventory();

        switch (e.getCurrentItem().getType()) {

        }

    }

    @Override
    public void setMenuItems() {

    }
}
