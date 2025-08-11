package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPorunga2 extends RenderDBC {
   private ModelPorunga aModel = new ModelPorunga();

   public RenderPorunga2() {
      super(new ModelPorunga(), 0.5F);
      this.aModel.whis_granted = true;
   }

   public void renderPorunga(EntityPorunga2 par1Entity, double par2, double par4, double par6, float par8, float par9) {
      GL11.glPushMatrix();
      this.func_77044_a(par1Entity, par9);
      float size = this.handleSizeFloat(par1Entity, par9);
      Random rand = new Random();
      float randfloat = (float)((double)rand.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 3.5F, (float)par6 + 0.0F);
      GL11.glRotatef(-(par1Entity.field_70126_B + (par1Entity.rotationYaw - par1Entity.field_70126_B) * par9 - 180.0F), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation txx = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");
      this.renderManager.renderEngine.bindTexture(txx);
      GL11.glEnable(2977);
      GL11.glPushMatrix();
      GL11.glScalef(size, size, size);
      this.aModel.renderModel2(par1Entity, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   protected float handleSizeFloat(Entity par1Entity, float par2) {
      float ticksExsisted = 3.0F - (float)par1Entity.ticksExisted * 0.02F;
      if (ticksExsisted < 0.0F) {
         ticksExsisted = 0.0F;
      }

      return ticksExsisted;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderPorunga((EntityPorunga2)par1Entity, par2, par4, par6, par8, par9);
   }
}
