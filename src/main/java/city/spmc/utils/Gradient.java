package city.spmc.utils;

public class Gradient {
   public void createGradient(String text, String hex, String hex2, int steps) {
      int[] rgb1 = Color.decode(hex);
      int red = rgb1[0];
      int green = rgb1[1];
      int blue = rgb1[2];
      int[] rgb2 = Color.decode(hex2);
      int red2 = rgb2[0];
      int green2 = rgb2[1];
      int blue2 = rgb2[2];
      int rsa = (red2 - red) / steps;
      int gsa = (green2 - green) / steps;
      int bsa = (blue2 - blue) / steps;
      int cr = red;
      int cg = green;
      int cb = blue;
      char[] chars = text.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (i = 0; i < steps; i++) {
         int rr = cr += rsa;
         int gr = cg += gsa;
         int br = cb += bsa;
         System.out.println(rr, gr, br);
         String redr = String.format("%02X", rr);
         String grer = String.format("%02X", gr);
         String blur = String.format("%02X", br);
         sb.append("#"+redr+grer+blur+chars[i]);
        }
      sb.append("#"+String.format("%02X", red2)+String.format("%02X", green2)+String.format("%02X", blue2)+chars[chars.length-1]);
      String result = sb.toString();
      return ChatEventListener.translateAlternateColorCodes(result);
    }
   private String rgbGradient(String str, Color from, Color to, Interpolator interpolator) {

    // interpolate each component separately 
    final double[] red = interpolator.interpolate(from.getRed(), to.getRed(), str.length());
    final double[] green = interpolator.interpolate(from.getGreen(), to.getGreen(), str.length());
    final double[] blue = interpolator.interpolate(from.getBlue(), to.getBlue(), str.length());

    final StringBuilder builder = new StringBuilder();

    // create a string that matches the input-string but has
    // the different color applied to each char
    for (int i = 0; i < str.length(); i++) {
        builder.append(ChatColor.of(new Color(
                (int) Math.round(red[i]),
                (int) Math.round(green[i]),
                (int) Math.round(blue[i]))))
                .append(str.charAt(i));
    }

    return builder.toString();
}
   private String multiRgbGradient(String str, Color[] colors, @Nullable double[] portions, Interpolator interpolator) {
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
        builder.append(rgbGradient(
                str.substring(strIndex, strIndex + (int) (p[i] * str.length())),
                colors[i],
                colors[i + 1],
                interpolator));
        strIndex += p[i] * str.length();
    }
    return builder.toString();
}
}
