package rise.city.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import rise.city.addiction.MostAnnoyingAddiction;
import rise.city.annoations.CommandAnno;

@CommandAnno(cmd = "battery", lastEdited = "19Jun2021", version = 1.0)
public class ServerBatteryLife implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage("Current Battery is " + MostAnnoyingAddiction.displayedfloat + "%");
        return true;
    }
}
