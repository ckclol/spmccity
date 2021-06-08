package rise.city.ability;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AbilityMain {
    private String name;
    private AbilityType type;
    private String description = "This item wasn't given a description!";
    private int cooldown = 0;

    public AbilityMain(String name, AbilityType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public AbilityMain(String name, AbilityType type, String description, int cooldown) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.cooldown = cooldown;
    }

    public List<String> toLore() {
        List<String> lore = new ArrayList();
        lore.add(ChatColor.GOLD + "Item Ability: " + this.name + " " + ChatColor.YELLOW + ChatColor.BOLD + this.type.getText());
        List<String> desc = Arrays.asList(this.description.split("\n"));
        Iterator var3 = desc.iterator();

        while(var3.hasNext()) {
            String item = (String)var3.next();
            item = ChatColor.GRAY + item;
            lore.add(item);
        }

        if (this.cooldown > 0) {
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + this.cooldown + "s.");
        }

        return lore;
    }
}
