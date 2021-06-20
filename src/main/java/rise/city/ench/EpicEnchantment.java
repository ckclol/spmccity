package rise.city.ench;

import org.api.CustomEnchantment;
import org.api.TagWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.plugin.tagSystem.TagManager;

public class EpicEnchantment implements Listener {

    private final static TagWrapper tagWrapper = TagManager.getInstance().getImplemenation();
    private static CustomEnchantment force;

    public void loadEnchantments() {
        force = new CustomEnchantment("Epic", 30, e -> {
            PlayerInteractEvent event = (PlayerInteractEvent) e;
            Player p = event.getPlayer();
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                p.setAllowFlight(true);
                wait(force.getMaxLv() * 10000);
                p.setAllowFlight(false);
                p.sendMessage("Epic power is gone...");
            }
        });
    }

    @EventHandler
    public void onBlock(PlayerInteractEvent event){
        if (tagWrapper.checkTag(event.getPlayer().getItemInHand(), force.getId())) {
            force.trigger(event);
        }
    }
}
