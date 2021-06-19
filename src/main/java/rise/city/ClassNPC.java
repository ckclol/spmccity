package rise.city;

import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.NPCPool;
import com.github.juliarn.npc.event.PlayerNPCHideEvent;
import com.github.juliarn.npc.event.PlayerNPCInteractEvent;
import com.github.juliarn.npc.event.PlayerNPCShowEvent;
import com.github.juliarn.npc.modifier.AnimationModifier;
import com.github.juliarn.npc.modifier.EquipmentModifier;
import com.github.juliarn.npc.modifier.LabyModModifier;
import com.github.juliarn.npc.modifier.MetadataModifier;
import com.github.juliarn.npc.profile.Profile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import rise.city.utils.Utils;

import java.util.Random;
import java.util.UUID;

public class ClassNPC implements Listener {

    private final NPCPool npcPool;

    private final Random random;

    /**
     * @param plugin The plugin which uses the lib
     */
    public ClassNPC(Plugin plugin) {
        this.npcPool = NPCPool.builder(plugin)
                .spawnDistance(60)
                .actionDistance(30)
                .tabListRemoveTicks(20)
                .build();
        this.random = new Random();

        // we are handling NPC events here
        Bukkit.getPluginManager().registerEvents(this, plugin);

        // making the NPCs randomly sneak and unsneak every second
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (NPC npc : this.npcPool.getNPCs()) {
                npc.metadata()
                        .queue(MetadataModifier.EntityMetadata.SNEAKING, this.random.nextBoolean())
                        // sending the change to all players
                        .send();
            }
        }, 20L, 20L);
    }

    /**
     * Appends a new NPC to the pool.
     *
     * @param location       The location the NPC will be spawned at
     */
    public void appendNPC(Location location, String id, boolean initplr, boolean lookplr) {
        NPC npc = NPC.builder().profile(this.createProfile(id)).location(location).imitatePlayer(initplr).lookAtPlayer(lookplr).build(this.npcPool);
    }

    /**
     * Creates an example profile for NPCs.
     *
     * @return The new profile
     */
    public Profile createProfile(String id) {
        Profile profile = new Profile(UUID.fromString(id));
        profile.complete();
        profile.setName(Bukkit.getOfflinePlayer(UUID.fromString(id)).getName());
        profile.setUniqueId(new UUID(this.random.nextLong(), 0));
        return profile;
    }

    /**
     * Doing something when a NPC is shown for a certain player.
     * @param event The event instance
     */
    @EventHandler
    public void handleNPCShow(PlayerNPCShowEvent event) {
        NPC npc = event.getNPC();
        event.send(npc.animation().queue(AnimationModifier.EntityAnimation.SWING_MAIN_ARM), npc.labymod().queue(LabyModModifier.LabyModAction.EMOTE, 3), npc.equipment().queue(EquipmentModifier.CHEST, new ItemStack(Material.DIAMOND_CHESTPLATE, 1)).queue(EquipmentModifier.MAINHAND, new ItemStack(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjRkNzY1MWU5ZGViNWMyODEzODIwZmVkMzExZDU0MTExOWYzMTU1ZWFhYjU0OWQzYWQ1MmQyMDJiYzNmMGU3In19fQ=="))), npc.metadata().queue(MetadataModifier.EntityMetadata.SKIN_LAYERS, true).queue(MetadataModifier.EntityMetadata.SNEAKING, true));
    }

    /**
     * Doing something when a NPC is hidden for a certain player.
     *
     * @param event The event instance
     */
    @EventHandler
    public void handleNPCHide(PlayerNPCHideEvent event) {
        Player player = event.getPlayer();
        NPC npc = event.getNPC();

        // if the player has been excluded from seeing the NPC, removing him from the excluded players
        if (event.getReason() == PlayerNPCHideEvent.Reason.EXCLUDED) {
            npc.removeExcludedPlayer(player);
        }
    }

    /**
     * Doing something when a player interacts with a NPC.
     *
     * @param event The event instance
     */
    @EventHandler
    public void handleNPCInteract(PlayerNPCInteractEvent event) {
        Player player = event.getPlayer();
        NPC npc = event.getNPC();

        // checking if the player hit the NPC
        if (event.getUseAction() == PlayerNPCInteractEvent.EntityUseAction.ATTACK) {
            player.sendMessage("Why are you hitting me? :(");
            npc.rotation().queueLookAt(player.getEyeLocation()).send(player);
        }
    }

}
