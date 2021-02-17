package city.spmc.rarity;

import org.bukkit.ChatColor;
import city.spmc.utils.Gradient;

public enum RarityMain {
    BANNED(ChatColor.WHITE),
    EAGLE(ChatColor.WHITE),
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.GREEN),
    RARE(ChatColor.DARK_GREEN),
    EPIC(ChatColor.LIGHT_PURPLE),
    ELITE(ChatColor.GOLD),
    LEGENDARY(ChatColor.DARK_PURPLE),
    GALAXY(Gradient.multiRgbGradient("GALAXY", {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.AQUA, Color.BLUE, Color.PURPLE}, 7, main::linear);
    MYTHIC(ChatColor.LIGHT_PURPLE),
    GODLY(ChatColor.GOLD),
    SKYLY(ChatColor.AQUA),
    OCEAN(Gradient,rgbGradient("OCEAN", ocean1, ocean2, main::linear),
    ADMIN(ChatColor.RED);

    private ChatColor color;
    private Gradient gradient;
    private RarityMain(ChatColor color) {
        this.color = color;
    }
    private RarityMain(Gradient gradient) {
        this.gradient = gradient;
    }
    public ChatColor getColor() {
        return this.color;
    }
    public Gradient getGradient() {
        return this.gradient;
    }
    public Color ocean1 = new Color(9, 198, 245);
    public Color ocean2 = new Color(4, 93, 233);
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
