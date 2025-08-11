package JinRyuu.JRMCore;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiButtonsA4 extends GuiButton {
   private String string;
   private int type;
   public int col;

   public JRMCoreGuiButtonsA4(int par1, int par2, int par3, int width, int type, int c) {
      super(par1, par2, par3, width, 10, "");
      this.field_146120_f = width;
      this.string = "+";
      this.type = type;
      this.col = c;
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         this.field_146123_n = par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g;
         int var5 = this.func_146114_a(this.field_146123_n);
         int j = this.col == 0 ? 16449280 : this.col;
         FontRenderer var4 = par1Minecraft.field_71466_p;
         ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
         par1Minecraft.func_110434_K().bindTexture(txx);
         float h2 = (float)(j >> 16 & 255) / 255.0F;
         float h3 = (float)(j >> 8 & 255) / 255.0F;
         float h4 = (float)(j & 255) / 255.0F;
         float h1 = 1.0F;
         int var6;
         if (var5 == 2) {
            var6 = (int)(h2 * 254.0F);
            int g = (int)(h3 * 254.0F);
            int b = (int)(h4 * 254.0F);
            float[] hsb = Color.RGBtoHSB(var6, g, b, (float[])null);
            float hue = hsb[0];
            float saturation = 0.33F;
            float brightness = hsb[2];
            int rgb = Color.HSBtoRGB(hue, saturation, brightness);
            h2 = (float)(rgb >> 16 & 255) / 255.0F;
            h3 = (float)(rgb >> 8 & 255) / 255.0F;
            h4 = (float)(rgb & 255) / 255.0F;
         }

         GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
         this.func_73729_b(this.field_146128_h, this.field_146129_i, this.type == 3 ? 50 : (this.type == 2 ? 0 : 60 + (this.type == 0 ? 20 : 0)), 106 + var5 * 10, this.field_146120_f, this.field_146121_g);
         this.func_146119_b(par1Minecraft, par2, par3);
         var6 = 14737632;
         if (!this.field_146124_l) {
            var6 = -6250336;
         } else if (this.field_146123_n) {
            var6 = 16777120;
         }

         this.field_146126_j = this.type == 0 ? "Off" : "On";
      }

   }
}
