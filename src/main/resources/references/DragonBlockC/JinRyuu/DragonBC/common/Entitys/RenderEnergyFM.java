package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.DragonBC.common.Npcs.ModelEnergy;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnergyFM extends RenderDBC {
   private ModelEnergy ener = new ModelEnergy();
   private double dist;

   public RenderEnergyFM() {
      super(new ModelEnergy(), 0.5F);
   }

   public void renderEnergy(EntityEnergyFM par1Entity, double par2, double par4, double par6, float par8, float par9) {
      int shrink = par1Entity.getShrink();
      int col = JRMCoreH.techCol[1];
      boolean b = false;
      if (par1Entity.shootingEntity != null) {
         b = par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.field_71439_g.func_145782_y();
      }

      float var13 = this.handleRotationFloat(par1Entity, par9);
      double sx = (double)par1Entity.strtX();
      double sy = (double)par1Entity.strtY();
      double sz = (double)par1Entity.strtZ();
      double x = sx - par1Entity.field_70165_t;
      double y = sy - par1Entity.field_70163_u;
      double z = sz - par1Entity.field_70161_v;
      double var10000 = sx - (double)par1Entity.trgtX();
      var10000 = sy - (double)par1Entity.trgtY();
      var10000 = sz - (double)par1Entity.trgtZ();
      if (shrink > 0) {
         double d = this.dist - (double)((float)par1Entity.getSpe() * 0.05F);
         this.dist = d < 0.0D ? 0.0D : d;
      } else {
         this.dist = (double)MathHelper.func_76133_a(x * x + y * y + z * z);
      }

      int sbh = (int)(par1Entity.field_70163_u > 80.0D ? par1Entity.field_70163_u - 80.0D : 1.0D) * 4;
      float var20 = 1.0F + (float)(sbh / 5 * 100) * 0.02F * 0.15F;
      double sx2 = sx - JRMCoreClient.mc.field_71439_g.field_70165_t;
      double sy2 = sy - JRMCoreClient.mc.field_71439_g.field_70163_u;
      double sz2 = sz - JRMCoreClient.mc.field_71439_g.field_70161_v;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      OpenGlHelper.func_148821_a(770, 771, 1, 0);
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      this.tex(col);
      GL11.glScalef(var20 / 2.0F, var20 / 2.0F, var20 / 2.0F);
      this.ener.renderModel((byte)1, par1Entity, 0.0F, 0.0F, 0.0625F, var13, false);
      GL11.glDepthMask(true);
      GL11.glEnable(2896);
      GL11.glDisable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public void tex(int col) {
      float h2 = (float)(col >> 16 & 255) / 255.0F;
      float h3 = (float)(col >> 8 & 255) / 255.0F;
      float h4 = (float)(col & 255) / 255.0F;
      GL11.glColor4f(h2, h3, h4, 0.5F);
      ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
      this.field_76990_c.field_78724_e.func_110577_a(txx);
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.field_70173_aa + par2;
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderEnergy((EntityEnergyFM)par1Entity, par2, par4, par6, par8, par9);
   }
}
