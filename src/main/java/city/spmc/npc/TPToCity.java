package city.spmc.npc;

import city.spmc.SpiritualCity;
import net.jitse.npclib.NPCLib;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import net.jitse.npclib.api.skin.MineSkinFetcher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Arrays;

public class TPToCity implements Listener {
    public static NPC TpToCity;
    private SpiritualCity SpiritualCity;
    private NPCLib npclib;
    public TPToCity(SpiritualCity SpiritualCity) {
        this.SpiritualCity = SpiritualCity;
        this.npclib = new NPCLib(SpiritualCity);
        load();
    }

    private void load() {
        int skinId = 287653549;
        MineSkinFetcher.fetchSkinFromIdAsync(skinId, skin ->{
            TpToCity = npclib.createNPC(Arrays.asList(ChatColor.GOLD + "" + ChatColor.BOLD + "City", ChatColor.GREEN + "Click To Join!"));
            TpToCity.setLocation(new Location(Bukkit.getWorlds().get(0), 0 ,0 ,0 ,0 ,0));
            TpToCity.setSkin(skin);
            TpToCity.create();
        });
    }
    @EventHandler
    public void onNPCInteract(NPCInteractEvent e) {
        Player player = e.getWhoClicked();
        if (e.getNPC() == TpToCity) {
            player.sendMessage("Server in progress...");
        }
    }
}
