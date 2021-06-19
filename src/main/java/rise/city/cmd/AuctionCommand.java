package rise.city.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import rise.city.RiseCity;
import rise.city.annoations.CommandAnno;
import rise.city.auctionsystem.Auction;

@CommandAnno(cmd = "ah", lastEdited = "19Jun2021", version = 1.0)
public class AuctionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            new Auction(RiseCity.getPlayerMenuUtility(p)).open();
            // ah inventory
        } else {
            System.out.println("You are console");
        }
        return false;
    }
}
