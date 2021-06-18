package rise.city.cmd.warps;

import rise.city.annoations.CommandAnno;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@CommandAnno(cmd = "warp", lastEdited = "18Jun2021", version = 0.2)
public class Warps implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // warp.yml
        switch(label) {
            case "a":
                break;
        }
        return true;
    }
}