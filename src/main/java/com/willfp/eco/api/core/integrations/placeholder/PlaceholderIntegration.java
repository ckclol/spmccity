package com.willfp.eco.api.core.integrations.placeholder;

import com.willfp.eco.core.integrations.Integration;
import com.willfp.eco.core.integrations.placeholder.PlaceholderManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PlaceholderIntegration extends Integration {
    /**
     * Register the integration with the specified plugin.
     * Not to be confused with internal registration in {@link PlaceholderManager#addIntegration(PlaceholderIntegration)}.
     */
    void registerIntegration();

    /**
     * Translate all the placeholders in a string with respect to a player.
     *
     * @param text   The text to translate.
     * @param player The player to translate with respect to.
     * @return The string, translated.
     */
    String translate(@NotNull String text,
                     @Nullable Player player);
}
