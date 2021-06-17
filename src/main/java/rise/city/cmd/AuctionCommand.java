package rise.city.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import rise.city.annoations.CommandAnno;

@CommandAnno(cmd = "ah", lastEdited = "17Jun2021", version = 1.0)
public class AuctionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            // ah inventory
        } else {
            System.out.println("You are console");
        }
        return false;
    }
}
