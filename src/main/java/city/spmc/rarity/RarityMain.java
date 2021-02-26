package city.spmc.rarity;

import javafx.animation.Interpolator;
import org.bukkit.ChatColor;
import city.spmc.utils.Gradient;

import java.awt.*;

public enum RarityMain {
    EAGLE(Gradient.rgbGradient("EAGLE", new Color(35, 140, 145), new Color(115, 154, 156), Interpolator.LINEAR)),
    COMMON(Gradient.rgbGradient("COMMON", new Color(255, 255, 255), new Color(255, 255, 255), Interpolator.LINEAR)),
    UNCOMMON(Gradient.rgbGradient("UNCOMMON", new Color(54, 191, 36), new Color(90, 117, 87),Interpolator.LINEAR)),
    RARE(Gradient.rgbGradient("RARE", new Color(15, 28, 171), new Color(86, 93, 168), Interpolator.LINEAR)),
    EPIC(Gradient.rgbGradient("EPIC", new Color(81, 28, 145), new Color(101, 11, 212), Interpolator.LINEAR)),
    ELITE(Gradient.rgbGradient("ELITE", new Color(136, 138, 51), new Color(99, 138, 28), Interpolator.LINEAR)),
    LEGENDARY(Gradient.rgbGradient("LEGENDARY", new Color(148, 48, 171), new Color(119, 61, 133), Interpolator.LINEAR)),
    GALAXY(Gradient.multiRgbGradient("GALAXY", new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK}, null, Interpolator.LINEAR)),
    MYTHIC(Gradient.rgbGradient("MYTHIC", new Color(190,	56,	243), new Color(53, 41, 189), Interpolator.LINEAR)),
    GODLY(Gradient.rgbGradient("GODLY", new Color(251, 176, 52), new Color(255, 221, 0), Interpolator.LINEAR)),
    SKYLY(Gradient.rgbGradient("SLYLY", new Color(9, 198, 245), new Color(4, 93, 233), Interpolator.LINEAR)),
    OCEAN(Gradient.rgbGradient("OCEAN", new Color(9, 198, 245), new Color(4, 93, 233), Interpolator.LINEAR)),
    ADMIN(Gradient.rgbGradient("ADMIN", new Color(186, 111, 19), new Color(154, 19, 168), Interpolator.LINEAR));

    private String gradient;
    private RarityMain(String gradient) {
        this.gradient = gradient;
    }

    public String getGradient() {
        return this.gradient;
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
