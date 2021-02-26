package city.spmc.utils;

import com.google.common.base.Preconditions;
import javafx.animation.Interpolator;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Arrays;

public class Gradient {
   public static String rgbGradient(String str, Color from, Color to, Interpolator interpolator) {
    final double red = interpolator.interpolate(from.getRed(), to.getRed(), str.length());
    final double green = interpolator.interpolate(from.getGreen(), to.getGreen(), str.length());
    final double blue = interpolator.interpolate(from.getBlue(), to.getBlue(), str.length());

    final StringBuilder builder = new StringBuilder();


    for (int i = 0; i < str.length(); i++) {
        builder.append(ChatColor.of(new Color((int) Math.round(red), (int) Math.round(green), (int) Math.round(blue)))).append(str.charAt(i));
    }

    return builder.toString();
}
   public static String multiRgbGradient(String str, Color[] colors, @Nullable double[] portions, Interpolator interpolator) {
    final double[] p;
    if (portions == null) {
        p = new double[colors.length - 1];
        Arrays.fill(p, 1 / (double) p.length);
    } else {
        p = portions;
    }

    Preconditions.checkArgument(colors.length >= 2);
    Preconditions.checkArgument(p.length == colors.length - 1);

    final StringBuilder builder = new StringBuilder();
    int strIndex = 0;

    for (int i = 0; i < colors.length - 1; i++) {
        builder.append(rgbGradient(str.substring(strIndex, strIndex + (int) (p[i] * str.length())), colors[i], colors[i + 1], Interpolator.LINEAR));
        strIndex += p[i] * str.length();
    }
    return builder.toString();
}
}
