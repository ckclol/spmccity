package com.willfp.eco.api.core;

import com.willfp.eco.core.EcoPlugin;
import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public abstract class PluginDependent {
    /**
     * The {@link com.willfp.eco.core.EcoPlugin} that is stored.
     */
    @Getter(AccessLevel.PROTECTED)
    private final com.willfp.eco.core.EcoPlugin plugin;

    /**
     * Pass an {@link com.willfp.eco.core.EcoPlugin} in order to interface with it.
     *
     * @param plugin The plugin to manage.
     */
    protected PluginDependent(@NotNull final EcoPlugin plugin) {
        this.plugin = plugin;
    }
}
