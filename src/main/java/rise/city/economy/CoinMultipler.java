package rise.city.economy;

import net.milkbowl.vault.economy.AbstractEconomy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import rise.city.RiseCity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class CoinMultipler {

    public boolean DoubleCoins = false;
    public boolean TripleCoins = false;{

        if (DoubleCoins) {
            Scanner s = null;
            try {
                s = new Scanner(new File("players.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
            }
            s.close();
            for (String a : list) {
                UUID id = UUID.fromString(a);
                Player p = Bukkit.getPlayer(id);
                final double amount = RiseCity.getEconomy().getBalance(p);
                final double amountgive = RiseCity.getEconomy().getBalance(p) * 2 + 1;
                for (double i = amount; i<0; i--) {
                    RiseCity.getEconomy().withdrawPlayer(p, 1);
                }
                RiseCity.getEconomy().depositPlayer(p, amountgive);
            }
        }

        if (TripleCoins) {
            Scanner s = null;
            try {
                s = new Scanner(new File("players.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
            }
            s.close();
            for (String a : list) {
                UUID id = UUID.fromString(a);
                Player p = Bukkit.getPlayer(id);
                final double amount = RiseCity.getEconomy().getBalance(p);
                final double amountgive = RiseCity.getEconomy().getBalance(p) * 3 + 1;
                for (double i = amount; i<0; i--) {
                    RiseCity.getEconomy().withdrawPlayer(p, 1);
                }
                RiseCity.getEconomy().depositPlayer(p, amountgive);
            }
        }


    }
}
