package rise.city.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CreateNPC {

    public ArrayList<String> name;
    public int id;
    public EntityType entity;
    public Location loc;
    public String skinurl;
    public World w;

    public CreateNPC(ArrayList<String> name, int id, EntityType entity, Location loc, World w) {
        this.name = name;
        this.id = id;
        this.entity = entity;
        this.loc = loc;
        this.w = w;
        assert entity.getEntityClass() != null;
        Entity e = w.spawn(loc, entity.getEntityClass());
        e.setInvulnerable(true);
        e.setCustomName(String.valueOf(name));
        e.setCustomNameVisible(true);
    }

    public CreateNPC(ArrayList<String> name, int id, String url, Location loc, World w) {
        this.name = name;
        this.id = id;
        this.skinurl = url;
        this.loc = loc;
        this.w = w;
        Player e = (Player) w.spawn(loc, EntityType.PLAYER.getEntityClass());
        e.setInvulnerable(true);
        e.setCustomName(String.valueOf(name));
        e.setCustomNameVisible(true);
    }

}
