package JinRyuu.JRMCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiSliderX00 extends GuiButton {
   public static float sliderValue = 1.0F;
   public float sliderMaxValue;
   public boolean dragging;
   public String label;
   private boolean mc0;
   private boolean mainTexture;

   public JRMCoreGuiSliderX00(int id, int x, int y, boolean mc0, float startingValue, float maxValue, boolean mainTexture) {
      super(id, x, y, 15, 115, "");
      this.sliderMaxValue = 1.0F;
      this.dragging = false;
      this.label = "";
      sliderValue = startingValue;
      this.sliderMaxValue = maxValue;
      this.mc0 = mc0;
      this.mainTexture = mainTexture;
   }

   public JRMCoreGuiSliderX00(int id, int x, int y, boolean mc0, float startingValue, float maxValue) {
      this(id, x, y, mc0, startingValue, maxValue, true);
   }

   public int func_146114_a(boolean par1) {
      return 0;
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         FontRenderer fontrenderer = par1Minecraft.field_71466_p;
         ResourceLocation txx = new ResourceLocation(this.mainTexture ? JRMCoreGuiScreen.button1 : JRMCoreGuiScreen.button2);
         par1Minecraft.func_110434_K().func_110577_a(txx);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_146123_n = par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g;
         int k = this.func_146114_a(this.field_146123_n);
         this.func_73729_b(this.field_146128_h, this.field_146129_i, 216 - k * 20, 128, this.field_146120_f, this.field_146121_g);
         this.func_146119_b(par1Minecraft, par2, par3);
         int l = 14737632;
         if (!this.field_146124_l) {
            l = -6250336;
         } else if (this.field_146123_n) {
            l = 16777120;
         }

         this.func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
         if (this.mc0 && super.func_146116_c(par1Minecraft, par2, par3)) {
            sliderValue = (float)(par3 - (this.field_146129_i + 4)) / (float)(this.field_146121_g - 8);
            if (sliderValue < 0.0F) {
               sliderValue = 0.0F;
            }

            if (sliderValue > 1.0F) {
               sliderValue = 1.0F;
            }
         }
      }

   }

   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         if (this.dragging) {
            sliderValue = (float)(par3 - (this.field_146129_i + 4)) / (float)(this.field_146121_g - 8);
            if (sliderValue < 0.0F) {
               sliderValue = 0.0F;
            }

            if (sliderValue > 1.0F) {
               sliderValue = 1.0F;
            }
         }

         ResourceLocation txx = new ResourceLocation(this.mainTexture ? JRMCoreGuiScreen.button1 : JRMCoreGuiScreen.button2);
         par1Minecraft.func_110434_K().func_110577_a(txx);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_73729_b(this.field_146128_h, this.field_146129_i + (int)(sliderValue * (float)(this.field_146121_g - 4)), 241, 155, 15, 2);
         this.func_73729_b(this.field_146128_h, this.field_146129_i + (int)(sliderValue * (float)(this.field_146121_g - 4)) + 2, 241, 157, 15, 2);
      }

   }

   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
      return false;
   }

   public void func_146118_a(int par1, int par2) {
   }
}
