package com.willfp.eco.api.internal.gui;

import com.willfp.eco.internal.gui.EcoSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FillerSlot extends EcoSlot {
    /**
     * Create new filler slot.
     *
     * @param itemStack The ItemStack.
     */
    public FillerSlot(@NotNull final ItemStack itemStack) {
        super((player) -> itemStack, null, null, null, null, null);
    }
}
