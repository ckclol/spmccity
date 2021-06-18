package rise.city.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import rise.city.annoations.CommandAnno;
import rise.city.economy.CoinMultipler;

@CommandAnno(cmd = "dc", lastEdited = "18Jun2021", version = 1.0)
public class DoubleCoins implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        switch(s) {
            case "true":
                CoinMultipler.DoubleCoins = true;
                break;
            case "false":
                CoinMultipler.DoubleCoins = false;
                break;
            default:
                CoinMultipler.DoubleCoins = false;
                commandSender.sendMessage("Hey, you forgot to type the true/false part! We helped you make it false.");
        }
        return true;
    }
}
