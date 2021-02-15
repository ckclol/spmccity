package city.spmc.mob;

import city.spmc.levels.LevelMain;
import city.spmc.utils.MobCreator;
import org.bukkit.entity.EntityType;

import java.util.List;

public class EndermanSimple extends MobCreator {
    public EndermanSimple(int id, LevelMain lvl, String mobname, EntityType et, List ability) {
        super(id, lvl, mobname, et, ability);
    }

}
