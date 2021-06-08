package rise.city.cmd.warps;

import rise.city.annoations.CommandAnno;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Warps implements CommandExecutor {
    @CommandAnno(cmd = "warp", lastEdited = "17Feb2021", version = 0.2)
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}