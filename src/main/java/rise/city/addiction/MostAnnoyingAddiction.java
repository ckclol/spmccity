package rise.city.addiction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MostAnnoyingAddiction implements Listener {

    // batterylife is actually real battery and if reset = 1%

    public float battery = 1F;
    public float batterylife = 2F;
    public float savedbattery = 2F;
    public static float displayedfloat;

    @EventHandler
    public void batterylife(PlayerJoinEvent e) {
            batterylife = batterylife - 0.01F;
        displayedfloat = batterylife / battery;
    }

    {

        if (batterylife == 0F) {
            Bukkit.broadcastMessage(ChatColor.RED + "Server Battery 0%");
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.kickPlayer(ChatColor.RED + "Server Battery 0%");
                batterylife = savedbattery - 0.01F;
                savedbattery = batterylife;
                displayedfloat = batterylife / battery;
            }
        }

        if (displayedfloat >= 1F) {
            displayedfloat = 1F;
        }

    }
}