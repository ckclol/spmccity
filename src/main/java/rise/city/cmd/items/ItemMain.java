package rise.city.cmd.items;

import rise.city.RiseCity;
import rise.city.annoations.CommandAnno;
import rise.city.utils.ItemCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemMain implements CommandExecutor {
    @CommandAnno(cmd = "cgive", lastEdited = "18Feb2021", version = 1.0)
    private RiseCity main = null;

    public ItemMain(RiseCity main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }
}