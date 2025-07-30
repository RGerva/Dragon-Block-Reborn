package JinRyuu.JRMCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiSlider00 extends GuiButton {
   public float sliderValue = 1.0F;
   public float sliderMaxValue = 1.0F;
   public boolean dragging = false;
   public String label;

   public JRMCoreGuiSlider00(int id, int x, int y, String label, float startingValue, float maxValue) {
      super(id, x, y, 20, 128, label);
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
         this.func_73729_b(this.field_146128_h, this.field_146129_i, 236 - k * 20, 0, this.field_146120_f, this.field_146121_g);
         this.func_146119_b(par1Minecraft, par2, par3);
         int l = 14737632;
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
            this.sliderValue = (float)(par3 - (this.field_146129_i + 4)) / (float)(this.field_146121_g - 8);
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
         this.func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * (float)(this.field_146121_g - 4)), 216, 0, 20, 2);
         this.func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * (float)(this.field_146121_g - 4)) + 2, 216, 126, 20, 2);
      }

   }

   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
      if (super.func_146116_c(par1Minecraft, par2, par3)) {
         this.sliderValue = (float)(par3 - (this.field_146129_i + 4)) / (float)(this.field_146121_g - 8);
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
