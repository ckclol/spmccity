package rise.city.cmd;

import rise.city.annoations.CommandAnno;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ItemMain implements CommandExecutor {
    @CommandAnno(cmd = "cgive", lastEdited = "18Feb2021", version = 1.0)

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }
}