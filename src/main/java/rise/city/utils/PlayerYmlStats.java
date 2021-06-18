package rise.city.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import rise.city.RiseCity;

import java.io.File;
import java.io.IOException;

public class PlayerYmlStats {

    public static void fileCheck(Player player){

        String playerName = player.getName();
        String playerUuid = player.getUniqueId().toString();
        File f = new File( File.separator + playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()) {
            try {

                playerData.createSection("Data");
                playerData.set("Data.Name", playerName);
                playerData.set("Data.UUID", playerUuid);

                playerData.createSection("Stats");
                playerData.set("Stats.ServerCoins", RiseCity.getEconomy().getBalance(player));
                playerData.set("Stats.XP", RiseCity.getExp().getExp(player));

                playerData.save(f);
            } catch (IOException exception) {

                exception.printStackTrace();
            }
        }

    }
}
