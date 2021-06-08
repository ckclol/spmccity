package rise.city.cmd.extremecookie;

import rise.city.annoations.CommandAnno;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AuctionCommand implements CommandExecutor {
    @CommandAnno(cmd = "auction", lastEdited = "17feb2021", version = 1.0)
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
