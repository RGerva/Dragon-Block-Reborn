package JinRyuu.JRMCore.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPunch extends RenderJRMC {
   private ModelKiExplosion aModel = new ModelKiExplosion();

   public RenderPunch() {
      super(new ModelKiExplosion(), 0.5F);
   }

   public void renderPunch(EntityPunch par1Entity, double par2, double par4, double par6, float par8, float par9) {
      GL11.glPushMatrix();
      float var13 = this.handleRotationFloat(par1Entity, par9);
      Random rand = new Random();
      float randfloat = (float)((double)rand.nextInt(5) * 0.1D);
      float var20 = 0.001F;
      GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 0.0F, (float)par6 + 0.0F);
      GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.rotationYaw - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.rotationPitch - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      ResourceLocation txx = new ResourceLocation("jinryuudragonbc:Ki/ki.png");
      this.renderManager.renderEngine.bindTexture(txx);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      GL11.glScalef(var20, var20, var20);
      this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
      GL11.glPopMatrix();
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderPunch((EntityPunch)par1Entity, par2, par4, par6, par8, par9);
   }
}
