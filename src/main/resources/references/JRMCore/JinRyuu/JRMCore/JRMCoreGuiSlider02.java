package JinRyuu.JRMCore;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiSlider02 extends GuiButton {
   public float sliderValue;
   public float sliderMaxValue;
   public boolean dragging;
   public String label;
   private int col;

   public JRMCoreGuiSlider02(int id, int x, int y, int sizex, int sizey, String label, float startingValue, float maxValue, int c) {
      this(id, x, y, sizex, sizey, label, startingValue, maxValue);
      this.col = c;
   }

   public JRMCoreGuiSlider02(int id, int x, int y, int sizex, int sizey, String label, float startingValue, float maxValue) {
      super(id, x, y, sizex, sizey, label);
      this.sliderValue = 1.0F;
      this.sliderMaxValue = 1.0F;
      this.dragging = false;
      this.label = label;
      this.sliderValue = startingValue;
      this.sliderMaxValue = maxValue;
   }

   public int func_146114_a(boolean par1) {
      return 0;
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         FontRenderer fontrenderer = par1Minecraft.field_71466_p;
         ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
         par1Minecraft.func_110434_K().func_110577_a(txx);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_146123_n = par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g;
         int k = this.func_146114_a(this.field_146123_n);
         int l;
         if (this.col != 0) {
            l = this.col;
            float h2 = (float)(l >> 16 & 255) / 255.0F;
            float h3 = (float)(l >> 8 & 255) / 255.0F;
            float h4 = (float)(l & 255) / 255.0F;
            float h1 = 1.0F;
            if (k == 2) {
               int r = (int)(h2 * 254.0F);
               int g = (int)(h3 * 254.0F);
               int b = (int)(h4 * 254.0F);
               float[] hsb = Color.RGBtoHSB(r, g, b, (float[])null);
               float hue = hsb[0];
               float saturation = 0.33F;
               float brightness = hsb[2];
               int rgb = Color.HSBtoRGB(hue, saturation, brightness);
               h2 = (float)(rgb >> 16 & 255) / 255.0F;
               h3 = (float)(rgb >> 8 & 255) / 255.0F;
               h4 = (float)(rgb & 255) / 255.0F;
            }

            GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
         }

         this.func_73729_b(this.field_146128_h, this.field_146129_i, 241, 159, this.field_146120_f, this.field_146121_g);
         this.func_146119_b(par1Minecraft, par2, par3);
         l = 14737632;
         if (!this.field_146124_l) {
            l = -6250336;
         } else if (this.field_146123_n) {
            l = 16777120;
         }

         this.func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
      }

   }

   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         if (this.dragging) {
            this.sliderValue = (float)(par3 - this.field_146129_i) / (float)this.field_146121_g;
            if (this.sliderValue < 0.0F) {
               this.sliderValue = 0.0F;
            }

            if (this.sliderValue > 1.0F) {
               this.sliderValue = 1.0F;
            }
         }

         ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
         par1Minecraft.func_110434_K().func_110577_a(txx);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * (float)this.field_146121_g), 241, 155, this.field_146120_f / 2, 2);
         this.func_73729_b(this.field_146128_h + 2, this.field_146129_i + (int)(this.sliderValue * (float)this.field_146121_g), 256 - (this.field_146120_f - this.field_146120_f / 2), 155, this.field_146120_f - this.field_146120_f / 2, 2);
      }

   }

   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
      if (super.func_146116_c(par1Minecraft, par2, par3)) {
         this.sliderValue = (float)(par3 - this.field_146129_i) / (float)this.field_146121_g;
         if (this.sliderValue < 0.0F) {
            this.sliderValue = 0.0F;
         }

         if (this.sliderValue > 1.0F) {
            this.sliderValue = 1.0F;
         }

         this.dragging = true;
         return true;
      } else {
         return false;
      }
   }

   public void func_146118_a(int par1, int par2) {
      this.dragging = false;
   }
}
