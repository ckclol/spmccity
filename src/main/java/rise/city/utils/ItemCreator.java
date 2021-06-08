package rise.city.utils;

import rise.city.RiseCity;
import rise.city.rarity.RarityMain;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemCreator {
    private static int Damage;
    private int id;
    private RarityMain rarity;
    private Material m;
    private ItemStack is;
    private static String name;
    private List<String> ability = new ArrayList();
    private List<String> lore = new ArrayList();
    int Mana;
    static int Strength;
    public ItemCreator(int id, String name, RarityMain rarity, Material m, List<String> ability) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.name = name;
        this.ability = ability;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack is, List<String> ability) {
        this.id = id;
        this.rarity = rarity;
        this.is = is;
        this.name = name;
        this.ability = ability;
    }

    public ItemCreator(int id, String name, RarityMain rarity, Material m, List<String> ability, List<String> lore) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.name = name;
        this.ability = ability;
        this.lore = lore;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack is, List<String> ability, List<String> lore) {
        this.id = id;
        this.rarity = rarity;
        this.is = is;
        this.name = name;
        this.ability = ability;
        this.lore = lore;
    }

    public ItemCreator(int id, String name, RarityMain rarity, Material m, List<String> ability, int damage, int strength, int mana) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.name = name;
        this.ability = ability;
        this.Damage = damage;
        this.Strength = strength;
        this.Mana = mana;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack is, List<String> ability, int damage, int strength, int mana) {
        this.id = id;
        this.rarity = rarity;
        this.is = is;
        this.name = name;
        this.ability = ability;
        this.Damage = damage;
        this.Strength = strength;
        this.Mana = mana;
    }

    public ItemCreator(int id, String name, RarityMain rarity, Material m, List<String> ability, int damage, int strength, int mana, List<String> lore) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.name = name;
        this.ability = ability;
        this.Damage = damage;
        this.Strength = strength;
        this.Mana = mana;
        this.lore = lore;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack m, List<String> ability, int damage, int strength, int mana, List<String> lore) {
        this.id = id;
        this.rarity = rarity;
        this.is = m;
        this.name = name;
        this.ability = ability;
        this.Damage = damage;
        this.Strength = strength;
        this.Mana = mana;
        this.lore = lore;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack m, int damage, int strength, int mana, List<String> lore) {
        this.id = id;
        this.rarity = rarity;
        this.is = m;
        this.name = name;
        this.Damage = damage;
        this.Strength = strength;
        this.Mana = mana;
        this.lore = lore;
    }

    public ItemCreator(int id, String name, RarityMain rarity, Material m) {
        this.id = id;
        this.rarity = rarity;
        this.m = m;
        this.name = name;
    }

    public ItemCreator(int id, String name, RarityMain rarity, ItemStack m) {
        this.id = id;
        this.rarity = rarity;
        this.is = m;
        this.name = name;
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

    public RarityMain getRarity() {
        return this.rarity;
    }

    public String getName() {
        return this.m.name();
    }

    public static ItemStack fromString(RiseCity main, String name, int stackSize) {
        return null;
    }

    public static int getDamage() {
        return Damage;
    }

    public static int getStrength() {
        return Strength;
    }

    public int getMana() {
        return Mana;
    }
}
