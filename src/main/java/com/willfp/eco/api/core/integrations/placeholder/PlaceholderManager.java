package com.willfp.eco.api.core.integrations.placeholder;

import com.willfp.eco.core.integrations.placeholder.PlaceholderEntry;
import com.willfp.eco.core.integrations.placeholder.PlaceholderIntegration;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@UtilityClass
public class PlaceholderManager {
    /**
     * All registered placeholders.
     */
    private static final Set<com.willfp.eco.core.integrations.placeholder.PlaceholderEntry> REGISTERED_PLACEHOLDERS = new HashSet<>();

    /**
     * All registered placeholder integrations.
     */
    private static final Set<PlaceholderIntegration> REGISTERED_INTEGRATIONS = new HashSet<>();

    /**
     * Register a new placeholder integration.
     *
     * @param integration The {@link PlaceholderIntegration} to register.
     */
    public static void addIntegration(@NotNull final PlaceholderIntegration integration) {
        integration.registerIntegration();
        REGISTERED_INTEGRATIONS.add(integration);
    }

    /**
     * Register a placeholder.
     *
     * @param expansion The {@link com.willfp.eco.core.integrations.placeholder.PlaceholderEntry} to register.
     */
    public static void registerPlaceholder(@NotNull final com.willfp.eco.core.integrations.placeholder.PlaceholderEntry expansion) {
        REGISTERED_PLACEHOLDERS.removeIf(placeholderEntry -> placeholderEntry.getIdentifier().equalsIgnoreCase(expansion.getIdentifier()));
        REGISTERED_PLACEHOLDERS.add(expansion);
    }

    /**
     * Get the result of a placeholder with respect to a player.
     *
     * @param player     The player to get the result from.
     * @param identifier The placeholder identifier.
     * @return The value of the placeholder.
     */
    public static String getResult(@Nullable final Player player,
                                   @NotNull final String identifier) {
        Optional<com.willfp.eco.core.integrations.placeholder.PlaceholderEntry> matching = REGISTERED_PLACEHOLDERS.stream().filter(expansion -> expansion.getIdentifier().equalsIgnoreCase(identifier)).findFirst();
        if (matching.isEmpty()) {
            return null;
        }
        PlaceholderEntry entry = matching.get();
        if (player == null && entry.requiresPlayer()) {
            return "";
        }
        return entry.getResult(player);
    }

    /**
     * Translate all placeholders with respect to a player.
     *
     * @param text   The text that may contain placeholders to translate.
     * @param player The player to translate the placeholders with respect to.
     * @return The text, translated.
     */
    public static String translatePlaceholders(@NotNull final String text,
                                               @Nullable final Player player) {
        AtomicReference<String> translatedReference = new AtomicReference<>(text);
        REGISTERED_INTEGRATIONS.forEach(placeholderIntegration -> translatedReference.set(placeholderIntegration.translate(translatedReference.get(), player)));
        return translatedReference.get();
    }
}
