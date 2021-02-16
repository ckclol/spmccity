package city.spmc.utils;

public class Gradient {
   public void createGradient(String hex, String hex2, int steps) {
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
      for (i = 0; i < steps; i++) {
         int rr = cr += rsa;
         int gr = cg += gsa;
         int br = cb += bsa;
         System.out.println(rr, gr, br);
        }
    }
}
