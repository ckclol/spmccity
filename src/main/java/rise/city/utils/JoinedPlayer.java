package rise.city.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.io.PrintWriter;

public class JoinedPlayer implements Listener {

    @EventHandler
    public void onjoin(PlayerJoinEvent e) throws IOException {
        Player p = e.getPlayer();
        PlayerYmlStats.fileCheck(p);
        PrintWriter out = new PrintWriter("players.txt");
        out.println(p.getUniqueId());
    }

}
