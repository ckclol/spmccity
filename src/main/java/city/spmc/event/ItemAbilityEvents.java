package city.spmc.event;

import city.spmc.utils.GetItem;
import city.spmc.utils.ItemCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemAbilityEvents implements Listener {
    @EventHandler
    public void onPlayerAbility(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemCreator create = GetItem.getItem(item);
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            create.leftClickAirAction(player, item);
        }
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            create.leftClickBlockAction(player, e, e.getClickedBlock(), item);
        }
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            create.rightClickAirAction(player, item);
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            create.rightClickBlockAction(player, e, e.getClickedBlock(), item);
        }
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            if (!player.isSneaking()) {
                create.shiftLeftClickAirAction(player, item);
            }
        }
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (!player.isSneaking()) {
                create.shiftLeftClickBlockAction(player, e, e.getClickedBlock(), item);
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (!player.isSneaking()) {
                create.shiftRightClickAirAction(player, item);
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (!player.isSneaking()) {
                create.shiftRightClickBlockAction(player, e, e.getClickedBlock(), item);
            }
        }
    }
}
