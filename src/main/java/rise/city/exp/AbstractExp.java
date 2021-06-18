package rise.city.exp;

import org.bukkit.OfflinePlayer;

public abstract class AbstractExp implements Exp {

    @Override
    public double getLevel(OfflinePlayer player) {
        return getLevel(player);
    }

    @Override
    public int getExp(OfflinePlayer player) {
        return getExp(player);
    }
}
