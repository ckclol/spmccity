package rise.city;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public enum Mobs {
    ;

    private String name;
    private double maxHealth, spawnChance;
    private EntityType type;
    private List<Loot> lt = new ArrayList<Loot>();

    Mobs() {

    }

}