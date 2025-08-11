package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.Npcs.ModelEnergy;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import JinRyuu.JRMCore.JRMCoreClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderMajinAbsorption extends RenderDBC {
   private ModelEnergy ener = new ModelEnergy();

   public RenderMajinAbsorption() {
      super(new ModelEnergy(), 0.0F);
   }

   public void renderEnergy(EntityMajinAbsorption par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.shadowSize = 0.0F;
      if (par1Entity != null && par1Entity.shootingEntity != null) {
         int col = par1Entity.getBodyColor();
         boolean b = false;
         if (par1Entity.shootingEntity != null) {
            b = par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.player.func_145782_y();
         }

         float var13 = this.handleRotationFloat(par1Entity, par9);
         double x = par1Entity.posX;
         double y = par1Entity.posY;
         double z = par1Entity.posZ;
         boolean hasTarget = par1Entity.getMode() == 1;
         boolean isComingBack = par1Entity.getMode() == 2;
         float BASE_SCALE = 1.0F;
         float size = par1Entity.targetH > par1Entity.targetW ? par1Entity.targetH : par1Entity.targetW;
         float sin = (float)(Math.sin((double)var13) / 2.0D);
         float scaleH = hasTarget ? size * 0.65F + 0.5F + sin / 2.0F : 1.0F + sin;
         float scaleW = hasTarget ? size * 0.65F + 0.5F - sin / 2.0F : 1.0F - sin;
         if (!DBCClient.mc.func_147113_T()) {
            label88: {
               label70: {
                  par1Entity.visualH += (double)(scaleH / 20.0F * (isComingBack ? -3.0F : 0.3F));
                  if (isComingBack) {
                     if (!(par1Entity.visualH < (double)scaleH)) {
                        break label70;
                     }
                  } else if (!(par1Entity.visualH > (double)scaleH)) {
                     break label70;
                  }

                  par1Entity.visualH = (double)scaleH;
               }

               par1Entity.visualW += (double)(scaleW / 20.0F * (isComingBack ? -3.0F : 0.3F));
               if (isComingBack) {
                  if (!(par1Entity.visualW < (double)scaleW)) {
                     break label88;
                  }
               } else if (!(par1Entity.visualW > (double)scaleW)) {
                  break label88;
               }

               par1Entity.visualW = (double)scaleW;
            }
         }

         GL11.glPushMatrix();
         GL11.glDisable(2896);
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.rotationYaw - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.rotationPitch - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         this.tex(col);
         GL11.glScaled(par1Entity.visualW, par1Entity.visualH, par1Entity.visualW);
         this.ener.renderModel((byte)1, par1Entity, 0.0F, 0.0F, 0.0625F, var13, false);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
   }

   public void tex(int col) {
      float h2 = (float)(col >> 16 & 255) / 255.0F;
      float h3 = (float)(col >> 8 & 255) / 255.0F;
      float h4 = (float)(col & 255) / 255.0F;
      GL11.glColor4f(h2, h3, h4, 1.0F);
      ResourceLocation txx = new ResourceLocation("jinryuudragonbc:majin_absorption.png");
      this.renderManager.renderEngine.bindTexture(txx);
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return ((float)par1Entity.ticksExisted + par2) / 2.0F;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderEnergy((EntityMajinAbsorption)par1Entity, par2, par4, par6, par8, par9);
   }
}
