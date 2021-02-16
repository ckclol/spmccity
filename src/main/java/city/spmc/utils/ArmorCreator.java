package city.spmc.utils;

import city.spmc.rarity.RarityMain;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class ArmorCreator {
    private int id;
    private RarityMain rarity;
    private Material m;
    private int def;
    private int mana;
    private List<String> ability = new ArrayList();
    public ArmorCreator(int id, RarityMain rarity, Material m, int mana, int def, List<String> ability) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.mana = mana;
        this. def = def;
        this.ability = ability;
    }
    public void getLore(ItemStack item) {
        List<String> lore = new ArrayList();
        if (this.rarity == RarityMain.RARE) {
            lore.add(ChatColor.BLUE + "This item is glitched / unfinished / new");
            lore.add(ChatColor.BLUE + "Report the item if there is bugs.");
        }
    }
    public abstract void fullArmorBuff(Player var1);

    public abstract void armorBuff(Player var1);
    public int getID() {
        return this.id;
    }

    public RarityMain getRarity() {
        return this.rarity;
    }
}
