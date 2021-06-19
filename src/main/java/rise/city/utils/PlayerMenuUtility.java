package rise.city.utils;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private Player owner;
    //store the player that will be killed so we can access him in the next menu
    private Player playerToKill;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public Player getPlayerToKill() {
        return playerToKill;
    }

    public void setPlayerToKill(Player playerToKill) {
        this.playerToKill = playerToKill;
    }
}

