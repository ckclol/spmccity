package city.spmc.item;

import city.spmc.utils.ItemCreator;
import city.spmc.rarity.RarityMain;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SpecialBedrock extends ItemCreator {

    public SpecialBedrock(int id, RarityMain rarity, Material m, List<String> ability) {
        super(id, rarity, m, ability);
    }

    @Override
    public void leftClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void leftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void rightClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void rightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void shiftLeftClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void shiftLeftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void shiftRightClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void shiftRightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void hitEntityAction(Player var1, EntityDamageByEntityEvent var2, Entity var3, ItemStack var4) {

    }
}
