package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.m.mEnergy5;
import JinRyuu.JRMCore.m.mEnergy7;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnergyAttJ2 extends RenderJRMC {
   private mEnergy5 ener = new mEnergy5();
   private mEnergy7 ener2 = new mEnergy7();
   private final String[] jutsus = new String[]{"rasengan", "chidori", "FireStyle_FireBall", "Earth Wall", "Mud Wall", "Water Pistol"};
   private double dist;

   public RenderEnergyAttJ2() {
      super(new mEnergy5(), 0.5F);
   }

   public void renderEnergy(EntityEnergyAttJ2 par1Entity, double par2, double par4, double par6, float par8, float par9) {
      if (par1Entity.getjtsre() > 2) {
         byte type = par1Entity.getType();
         byte perc = par1Entity.getPerc();
         int dam = par1Entity.getDam();
         byte den = par1Entity.getDen();
         int col = par1Entity.getCol();
         float size = par1Entity.getSizePerc();
         boolean b = false;
         if (par1Entity.shootingEntity != null) {
            b = par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.player.func_145782_y();
         }

         this.handleRotationFloat(par1Entity, par9);
         double sx = (double)par1Entity.strtX();
         double sy = (double)par1Entity.strtY();
         double sz = (double)par1Entity.strtZ();
         double x = sx - par1Entity.posX;
         double y = sy - par1Entity.posY;
         double z = sz - par1Entity.posZ;
         double var10000 = sx - (double)par1Entity.trgtX();
         var10000 = sy - (double)par1Entity.trgtY();
         var10000 = sz - (double)par1Entity.trgtZ();
         if (par1Entity.getShrink()) {
            this.dist -= (double)(par1Entity.getSpe() * 20.0F);
         } else {
            this.dist = (double)MathHelper.func_76133_a(x * x + y * y + z * z);
         }

         float var20 = size * 2.0F;
         if (var20 > 30.0F) {
            var20 = 30.0F;
         }

         if (type == 1) {
            GL11.glPushMatrix();
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            if (par1Entity.getjtsre() != 3) {
               GL11.glDepthMask(false);
            }

            GL11.glTranslatef((float)par2, (float)par4, (float)par6);
            GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            ResourceLocation tx;
            float seb_szaz;
            float seb_one;
            float max;
            float ti;
            float curr;
            if (par1Entity.getjtsre() == 3) {
               tx = new ResourceLocation("jinryuunarutoc:jutsu/" + this.jutsus[par1Entity.getjtsre() - 1] + ".png");
               this.renderManager.renderEngine.bindTexture(tx);
               seb_szaz = 10.0F;
               seb_one = seb_szaz / 100.0F;
               max = 15.0F;
               ti = (float)par1Entity.ticksExisted;
               curr = ti * seb_one;
               curr = curr >= max ? max : curr;
               GL11.glTranslatef(0.0F, -curr / 2.0F, 0.0F);
               GL11.glScalef(curr, curr, curr);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glRotatef((float)(par1Entity.ticksExisted * 10), 1.0F, 1.0F, 0.0F);
               this.ener.render(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
               GL11.glColor4f(1.0F, 0.8F, 0.8F, 0.4F);
               GL11.glScalef(1.2F, 1.2F, 1.2F);
               GL11.glRotatef((float)(par1Entity.ticksExisted * 5), 0.0F, 1.0F, 1.0F);
               this.ener.render(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            } else if (par1Entity.getjtsre() == 6) {
               tx = new ResourceLocation("jinryuumodscore:allw.png");
               this.renderManager.renderEngine.bindTexture(tx);
               GL11.glDepthMask(true);
               seb_szaz = 10.0F;
               seb_one = seb_szaz / 100.0F;
               max = 1.0F;
               ti = (float)par1Entity.ticksExisted;
               curr = ti * seb_one;
               curr = curr >= max ? max : curr;
               GL11.glTranslatef(0.0F, -curr / 2.0F, 0.0F);
               GL11.glScalef(curr, curr, curr);
               GL11.glColor4f(0.3F, 0.6F, 0.8F, 0.7F);
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-par1Entity.rotationYaw, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(par1Entity.rotationPitch, 0.0F, 0.0F, 1.0F);
               this.ener2.render(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
               GL11.glDepthMask(true);
               GL11.glColor4f(0.3F, 0.45F, 0.8F, 0.5F);
               GL11.glScalef(curr * 1.2F, curr * 1.2F, curr * 1.2F);
               this.ener2.render(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }

            GL11.glDisable(3042);
            GL11.glDisable(2977);
            GL11.glPopMatrix();
         }
      }

   }

   public void tex(int col) {
      float h2 = (float)(col >> 16 & 255) / 255.0F;
      float h3 = (float)(col >> 8 & 255) / 255.0F;
      float h4 = (float)(col & 255) / 255.0F;
      GL11.glColor4f(h2, h3, h4, 0.5F);
      ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
      this.renderManager.renderEngine.bindTexture(txx);
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderEnergy((EntityEnergyAttJ2)par1Entity, par2, par4, par6, par8, par9);
   }
}
