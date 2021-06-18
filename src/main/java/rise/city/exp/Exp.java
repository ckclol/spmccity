package rise.city.exp;

import org.bukkit.OfflinePlayer;

public interface Exp {

    public boolean isEnabled();

    public double getLevel(OfflinePlayer player);

    public int getExp(OfflinePlayer player);

}
