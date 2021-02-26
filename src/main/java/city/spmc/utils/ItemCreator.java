package city.spmc.utils;

import city.spmc.SpiritualCity;
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

public abstract class ItemCreator {
    private int id;
    private RarityMain rarity;
    private Material m;
    public static int Damage;
    public static int Strength;
    private static String name;
    private List<String> ability = new ArrayList();
    public static int mama;
    public static int def;
    public ItemCreator(int id, String name, RarityMain rarity, Material m, int Damage, int Strength, int mama, int def, List<String> ability) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.Damage = Damage;
        this.name = name;
        this.Strength = Strength;
        this.mama = mama;
        this.def = def;
        this.ability = ability;
    }


    public void getLore(ItemStack item) {
        List<String> lore = new ArrayList();
        if (this.rarity == RarityMain.RARE) {
            lore.add(ChatColor.BLUE + "This item is glitched / unfinished / new");
            lore.add(ChatColor.BLUE + "Report the item if there is bugs.");
        }
    }
    public abstract void leftClickAirAction(Player var1, ItemStack var2);

    public abstract void leftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4);

    public abstract void rightClickAirAction(Player var1, ItemStack var2);

    public abstract void rightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4);

    public abstract void shiftLeftClickAirAction(Player var1, ItemStack var2);

    public abstract void shiftLeftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4);

    public abstract void shiftRightClickAirAction(Player var1, ItemStack var2);

    public abstract void shiftRightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4);

    public abstract void hitEntityAction(Player var1, EntityDamageByEntityEvent var2, Entity var3, ItemStack var4);

    public abstract void inInventory(Player var1, ItemStack var2);

    public int getID() {
        return this.id;
    }

    public RarityMain getRarity() {
        return this.rarity;
    }

    public String getName() {
        return this.m.name();
    }
    public static ItemStack fromString(SpiritualCity main, String name, int stackSize) {
        return null;
    }
}
