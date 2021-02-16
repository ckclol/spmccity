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
}
