package jingames.jrhc.setup.helper;

import com.ibm.icu.math.BigDecimal;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

public class GuiHelper {
   public static String cldb = "§1";
   public static String cldg = "§2";
   public static String cla = "§3";
   public static String cldr = "§4";
   public static String cldp = "§5";
   public static String clgd = "§6";
   public static String clgy = "§7";
   public static String cldgy = "§8";
   public static String clbe = "§9";
   public static String clb = "§0";
   public static String cllg = "§a";
   public static String cllb = "§b";
   public static String cllr = "§c";
   public static String clpr = "§d";
   public static String cly = "§e";
   public static String clw = "§f";

   public static void drawString(GuiGraphics p_93237_, Font p_93238_, String p_93239_, int p_93240_, int p_93241_, int p_93242_, boolean shadow) {
      p_93237_.drawString(p_93238_, p_93239_, p_93240_, p_93241_, p_93242_, shadow);
   }

   public static float round(float d, int decimalPlace) {
      return round(d, decimalPlace, 4);
   }

   public static float round(float d, int decimalPlace, int rm) {
      BigDecimal bd = new BigDecimal(Float.toString(d));
      bd = bd.setScale(decimalPlace, rm);
      return bd.floatValue();
   }

   public static double round(double d, int decimalPlace) {
      return round(d, decimalPlace, 4);
   }

   public static double round(double d, int decimalPlace, int rm) {
      BigDecimal bd = new BigDecimal(Double.toString(d));
      bd = bd.setScale(decimalPlace, rm);
      return bd.doubleValue();
   }
}
