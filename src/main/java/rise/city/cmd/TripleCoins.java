package rise.city.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import rise.city.annoations.CommandAnno;
import rise.city.economy.CoinMultipler;

@CommandAnno(cmd = "tc", lastEdited = "18Jun2021", version = 1.0)
public class TripleCoins implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        switch(s) {
            case "true":
                CoinMultipler.TripleCoins = true;
                break;
            case "false":
                CoinMultipler.TripleCoins = false;
                break;
            default:
                CoinMultipler.TripleCoins = false;
                commandSender.sendMessage("Hey, you forgot to type the true/false part! We helped you make it false.");
        }
        return true;
    }
}
