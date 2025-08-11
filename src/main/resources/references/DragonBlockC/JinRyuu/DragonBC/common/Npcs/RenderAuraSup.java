package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAuraSup extends RenderDBC {
   private ModelAura aModel = new ModelAura();
   private int field_77068_a;

   public RenderAuraSup() {
      super(new ModelAura(), 0.5F);
   }

   public void renderAuraSup(EntityAuraSup par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      GL11.glPushMatrix();
      float var13 = this.handleRotationFloat(par1Entity, par9);
      Random rand = new Random();
      float randfloat = (float)((double)rand.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 1.5F, (float)par6 + 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation txx = new ResourceLocation("jinryuudragonbc:auras.png");
      this.renderManager.renderEngine.bindTexture(txx);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);

      for(int i = 0; i < 8; ++i) {
         GL11.glPushMatrix();
         GL11.glRotatef((float)(i * 45), 0.0F, 1.0F, 0.0F);
         this.aModel.renderModel(par1Entity, 0.0625F, var13, 0.0F, 20.0F);
         GL11.glPopMatrix();
      }

      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAuraSup((EntityAuraSup)par1Entity, par2, par4, par6, par8, par9);
   }
}
