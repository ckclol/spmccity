package rise.city.auctionsystem;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import rise.city.utils.Menu;
import rise.city.utils.PlayerMenuUtility;

public class Auction extends Menu {

    public Auction(PlayerMenuUtility playerMenuUtility) {
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
    public void handleMenu(InventoryClickEvent e) {

        Inventory inv = e.getClickedInventory();

        switch (e.getCurrentItem().getType()) {

        }

    }

    @Override
    public void setMenuItems() {

    }
}
