package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAura extends RenderDBC {
   private ModelAura aModel;
   private String mdid;

   public RenderAura() {
      super(new ModelAura(), 0.5F);
      this.mdid = "jinryuudragonbc";
      this.aModel = new ModelAura();
   }

   public RenderAura(String mdid) {
      this();
      this.mdid = mdid;
   }

   public void renderAura(EntityAura par1Entity, double parX, double parY, double parZ, float par8, float par9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)parX + 0.0F, (float)parY + 3.0F, (float)parZ + 0.0F);
      boolean rot = par1Entity.getRot();
      if (rot) {
         GL11.glTranslatef(0.0F, -1.5F, 0.0F);
         GL11.glRotatef(-par1Entity.rotationYaw, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(par1Entity.rotationPitch - 90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(0.0F, 1.5F, 0.0F);
      }

      GL11.glPushMatrix();
      float spd = (float)par1Entity.getSpd();
      boolean iner = par1Entity.getInner();
      float spd2 = 18.0F / (spd * 0.05F);
      float var13 = (float)par1Entity.getAge();
      float cr = par1Entity.getCRel();
      float s1 = par1Entity.getState();
      float s = s1 + cr * 0.03F;
      float s2 = par1Entity.getState2() * 0.5F;
      int c = par1Entity.getCol();
      String tex = par1Entity.getTex();
      int cl2 = par1Entity.getColL2();
      String texl2 = par1Entity.getTexL2();
      boolean hasl2 = texl2.length() > 2;
      s += s2;
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation txx2 = new ResourceLocation(this.mdid + ":" + texl2 + ".png");
      ResourceLocation txx = new ResourceLocation(this.mdid + ":" + tex + ".png");
      this.renderManager.renderEngine.bindTexture(txx);
      boolean plyrSP = DBCClient.mc.player.getName().equals(par1Entity.getmot()) && DBCClient.mc.gameSettings.thirdPersonView == 0;
      float p = !plyrSP ? par1Entity.getAlp() : (par1Entity.getInner() ? 0.025F : 0.05F);
      glColor4f(c, p);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glScalef(1.0F + 0.1F * s, 1.0F + 0.07F * s, 1.0F + 0.1F * s);
      GL11.glTranslatef(0.0F, -0.3F - 0.07F * s, 0.0F);
      GL11.glRotatef(var13 * spd2, 0.0F, 1.0F, 0.0F);
      float w = 0.75F;

      for(int i2 = 0; i2 < (iner ? 2 : 1) && (i2 != 1 || !(var13 > 10.0F)); ++i2) {
         for(int i = 0; i < 4; ++i) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)(i * 90), 0.0F, 1.0F, 0.0F);
            if (var13 < 15.0F) {
               this.aModel.renderModel(par1Entity, 0.0625F, var13, (float)i2 * w, spd);
               if (hasl2) {
                  this.renderManager.renderEngine.bindTexture(txx2);
                  glColor4f(cl2, p);
                  this.aModel.renderModel(par1Entity, 0.0625F, var13, (float)i2 * w, spd);
               }
            }

            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glRotatef((float)(i * 90 + 45), 0.0F, 1.0F, 0.0F);
            this.renderManager.renderEngine.bindTexture(txx);
            glColor4f(c, p);
            this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, (float)i2 * w, spd);
            if (hasl2) {
               this.renderManager.renderEngine.bindTexture(txx2);
               glColor4f(cl2, p);
               this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, (float)i2 * w, spd);
            }

            GL11.glPopMatrix();
         }
      }

      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
      if (var13 < (float)par1Entity.getLightLivingTime() && par1Entity.getState() > 4.0F && par1Entity.getState() < 7.0F && !rot) {
         GL11.glPushMatrix();
         Tessellator tessellator = Tessellator.INSTANCE;
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         double[] adouble = new double[8];
         double[] adouble1 = new double[8];
         double d3 = 0.0D;
         double d4 = 0.0D;
         new Random(par1Entity.lightVert);

         for(int i = 7; i >= 0; --i) {
         }

         int k1 = 0;
         float sc = 0.2F;
         Random random1 = new Random(par1Entity.lightVert);

         for(int j = 0; j < 3; ++j) {
            int k = 7;
            int l = 0;
            if (j > 0) {
               k = 7 - j;
            }

            if (j > 0) {
               l = k - 2;
            }

            double d5 = adouble[k] - d3;
            double d6 = adouble1[k] - d4;

            for(int i1 = k; i1 >= l; --i1) {
               double d7 = d5;
               double d8 = d6;
               d5 += (double)(random1.nextInt(31) - 15) * 0.07000000029802322D;
               d6 += (double)(random1.nextInt(31) - 15) * 0.07000000029802322D;
               tessellator.func_78371_b(5);
               float f2 = 0.5F;
               tessellator.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F);
               double d9 = 0.1D + (double)k1 * 0.2D;
               if (j == 0) {
               }

               double d10 = 0.1D + (double)k1 * 0.2D;
               if (j == 0) {
               }

               for(int j1 = 0; j1 < 5; ++j1) {
                  double d11 = parX + 0.0D - d9;
                  double d12 = parZ + 0.0D - d9;
                  if (j1 == 1 || j1 == 2) {
                     d11 += d9 * 2.0D * (double)sc;
                  }

                  if (j1 == 2 || j1 == 3) {
                     d12 += d9 * 2.0D * (double)sc;
                  }

                  double d13 = parX + 0.0D - d10;
                  double d14 = parZ + 0.0D - d10;
                  if (j1 == 1 || j1 == 2) {
                     d13 += d10 * 2.0D * (double)sc;
                  }

                  if (j1 == 2 || j1 == 3) {
                     d14 += d10 * 2.0D * (double)sc;
                  }

                  if (i1 < 8) {
                     tessellator.func_78377_a(d13 + d5 * (double)sc, parY - (double)(i1 * 1 - 7) * (double)sc, d14 + d6 * (double)sc);
                     tessellator.func_78377_a(d11 + d7 * (double)sc, parY - (double)((i1 + 1) * 1 - 7) * (double)sc, d12 + d8 * (double)sc);
                  }
               }

               tessellator.func_78381_a();
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
         GL11.glPopMatrix();
      }

   }

   public static void glColor4f(int c, float a) {
      float h2 = (float)(c >> 16 & 255) / 255.0F;
      float h3 = (float)(c >> 8 & 255) / 255.0F;
      float h4 = (float)(c & 255) / 255.0F;
      float h1 = 1.0F;
      GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, a);
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.ticksExisted + par2;
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAura((EntityAura)par1Entity, par2, par4, par6, par8, par9);
   }
}
