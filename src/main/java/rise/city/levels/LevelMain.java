package rise.city.levels;

import org.bukkit.ChatColor;

public enum LevelMain {
    NORMAL(200, ChatColor.WHITE),
    MUTATED(1000, ChatColor.RED),
    HARDCORE(10000, ChatColor.DARK_RED),
    EXTREME(100000, ChatColor.AQUA),
    EPIC(1000000, ChatColor.DARK_PURPLE),
    LEGENDARY(100000000, ChatColor.GOLD),
    GODLY(1000000000, ChatColor.GRAY);

    int mh;
    ChatColor cc;

    LevelMain(int mh, ChatColor cc) {
        this.cc = cc;
        this.mh = mh;
    }

    public static int getHealth(LevelMain lvl) {
        return lvl.mh;
    }

    public ChatColor getCc(LevelMain lvl) {
        return lvl.cc;
    }

//normal for less then 200 hearts, white
    //mutated for less then 1k hearts, red
    //hardcore for less then 10k hearts, dark red
    //extreme for less then 100k hearts, aqua
    //epic for less then 1m hearts, dark purple
    //legendary for less then 100m hearts, gold
    //godly for less then 1b hearts, gray
    //heavenly for less then 64b hearts, light purple
    //ckc for less then 1t hesrts, lime
}
