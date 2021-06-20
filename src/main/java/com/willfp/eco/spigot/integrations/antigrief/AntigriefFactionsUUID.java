package com.willfp.eco.spigot.integrations.antigrief;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.perms.PermissibleAction;
import com.willfp.eco.core.integrations.antigrief.AntigriefWrapper;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AntigriefFactionsUUID implements AntigriefWrapper {
    @Override
    public boolean canBreakBlock(@NotNull final Player player,
                                 @NotNull final Block block) {
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);
        FLocation flocation = new FLocation(block.getLocation());
        Faction faction = Board.getInstance().getFactionAt(flocation);

        if (!faction.hasAccess(fplayer, PermissibleAction.DESTROY)) {
            return fplayer.isAdminBypassing();
        }
        return true;
    }

    @Override
    public boolean canCreateExplosion(@NotNull final Player player,
                                      @NotNull final Location location) {
        FLocation flocation = new FLocation(location);
        Faction faction = Board.getInstance().getFactionAt(flocation);

        return !faction.noExplosionsInTerritory();
    }

    @Override
    public boolean canPlaceBlock(@NotNull final Player player,
                                 @NotNull final Block block) {
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);
        FLocation flocation = new FLocation(block.getLocation());
        Faction faction = Board.getInstance().getFactionAt(flocation);

        if (!faction.hasAccess(fplayer, PermissibleAction.BUILD)) {
            return fplayer.isAdminBypassing();
        }
        return true;
    }

    @Override
    public boolean canInjure(@NotNull final Player player,
                             @NotNull final LivingEntity victim) {
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);
        FLocation flocation = new FLocation(victim.getLocation());
        Faction faction = Board.getInstance().getFactionAt(flocation);

        if (victim instanceof Player) {
            if (faction.isPeaceful()) {
                return fplayer.isAdminBypassing();
            }
        } else {
            if (faction.hasAccess(fplayer, PermissibleAction.DESTROY)) {
                return fplayer.isAdminBypassing();
            }
        }
        return true;
    }

    @Override
    public String getPluginName() {
        return "FactionsUUID";
    }
}
