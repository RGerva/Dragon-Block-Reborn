package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAuraRing extends RenderDBC {
   private ModelKiAuraRing aModel = new ModelKiAuraRing();

   public RenderAuraRing() {
      super(new ModelKiAuraRing(), 0.5F);
   }

   public void renderAuraRing(EntityAuraRing par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      float a = (float)par1Entity.getAge();
      float cr = par1Entity.getCRel();
      float s = par1Entity.getState() + cr * 0.03F;
      float s2 = par1Entity.getState2() * 0.5F;
      s += s2;
      GL11.glPushMatrix();
      float var13 = this.handleRotationFloat(par1Entity, par9);
      float size = this.handleSizeFloat(par1Entity, par9);
      Random rand = new Random();
      float randfloat = (float)((double)rand.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 3.2F, (float)par6 + 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation txx = new ResourceLocation("jinryuudragonbc:auraring.png");
      this.renderManager.renderEngine.bindTexture(txx);
      RenderAura.glColor4f(par1Entity.color, par1Entity.update_alpha());
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glScalef(size, 1.0F, size);
      GL11.glTranslatef(0.0F, 0.0F - 0.15F * s, 0.0F);
      GL11.glScalef(1.0F + 0.1F * s, 1.0F + 0.05F * s, 1.0F + 0.1F * s);
      GL11.glRotatef(a * 18.0F, 0.0F, 1.0F, 0.0F);
      this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   protected float handleSizeFloat(Entity par1Entity, float par2) {
      float ticksExsisted = ((float)par1Entity.ticksExisted + par2) / 2.0F;
      return ticksExsisted;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAuraRing((EntityAuraRing)par1Entity, par2, par4, par6, par8, par9);
   }
}
