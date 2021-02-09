package city.spmc.npcevent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import city.spmc.npc.TPToCity;

public class SpawnNPC {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TPToCity.TpToCity.show(p);
    }
}
