package city.spmc.rarity;

import org.bukkit.ChatColor;

public enum RarityMain {
    BANNED(ChatColor.WHITE),
    EAGLE(ChatColor.WHITE),
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.GREEN),
    RARE(ChatColor.DARK_GREEN),
    EPIC(ChatColor.LIGHT_PURPLE),
    ELITE(ChatColor.GOLD),
    LEGENDARY(ChatColor.DARK_PURPLE),
    GALAXY(ChatColor.BLACK), //rainbow
    MYTHIC(ChatColor.LIGHT_PURPLE),
    GODLY(ChatColor.GOLD),
    SKYLY(ChatColor.AQUA),
    OCEAN(ChatColor.BLUE),
    ADMIN(ChatColor.RED),
    HAM(ChatColor.LIGHT_PURPLE),
    PUI(ChatColor.DARK_PURPLE);

    private ChatColor color;
    private RarityMain(ChatColor color) {
        this.color = color;
    }
    public ChatColor getColor() {
        return this.color;
    }
    public boolean isRarerThan(RarityMain rarity) {
        int current = this.getIndex();
        int param = rarity.getIndex();
        return current > param;
    }

    public int getIndex() {
        int index = 0;
        RarityMain[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            RarityMain rarity = var2[var4];
            if (this.equals(rarity)) {
                return index;
            }

            ++index;
        }

        return -1;
    }
}
