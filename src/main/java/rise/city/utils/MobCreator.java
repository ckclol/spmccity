package rise.city.utils;

import rise.city.levels.LevelMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public abstract class MobCreator {
    private int id;
    private LevelMain lvl;
    private String mobname;
    private EntityType et;
    private List<String> ability = new ArrayList();
    public MobCreator(int id, LevelMain lvl, String mobname, EntityType et, List ability) {
        this.id = id;
        this.lvl = lvl;
        this.et = et;
        this.mobname = mobname;
        this.ability = ability;
    }

    public MobCreator(int id, LevelMain lvl, String mobname, EntityType et) {
        this.id = id;
        this.lvl = lvl;
        this.et = et;
        this.mobname = mobname;
    }

    public void getLevel(EntityType entity) {
        if (this.lvl == LevelMain.EXTREME) {
            Bukkit.broadcastMessage("This mob is tough!!!");
        }
    }

    public int getID() {
        return this.id;
    }

    public LevelMain getLvl() {
        return this.lvl;
    }

    public String getName() {
        return this.mobname;
    }


}
