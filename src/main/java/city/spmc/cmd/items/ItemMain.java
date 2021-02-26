package city.spmc.cmd.items;

import city.spmc.SpiritualCity;
import city.spmc.annoations.CommandAnno;
import city.spmc.utils.ItemCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemMain implements CommandExecutor {
    @CommandAnno(cmd = "cgive", lastEdited = "18Feb2021", version = 1.0)
    private SpiritualCity main = null;

    public ItemMain(SpiritualCity main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if ("give".equals(args)) {
                Player p = (Player) sender;
                int stack = 1;
                if (args.length > 2) {
                    stack = Integer.parseInt(args[2]);
                }
                ItemStack item = ItemCreator.fromString(this.main, args[1], stack);
                p.getInventory().addItem(new ItemStack[]{item});
                p.sendMessage(SpiritualCity.prefix + "Given " + item.getItemMeta().getDisplayName());
            }
        }
        return true;
    }
}