package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAura2 extends RenderDBC {
   private ModelAura aModel;
   private ModelAuraG bModel;
   private String mdid;
   private boolean au_fel;
   private int au_i;
   private long time_start;
   private final float seb;
   private final int lvnm;
   private float[][] lightVertRotation;
   private int lightVertN;

   public RenderAura2() {
      super(new ModelAura(), 0.5F);
      this.mdid = "jinryuudragonbc";
      this.au_fel = true;
      this.au_i = 0;
      this.time_start = 0L;
      this.seb = 0.03F;
      this.lvnm = 10;
      this.lightVertRotation = new float[10][7];
      this.aModel = new ModelAura();
      this.bModel = new ModelAuraG();
   }

   public RenderAura2(String mdid) {
      this();
      this.mdid = mdid;
   }

   public void renderAura(EntityAura2 par1Entity, double parX, double parY, double parZ, float par8, float par9) {
      float var13 = (float)par1Entity.getAge();
      boolean rot = par1Entity.getRot();
      this.field_76989_e = 0.0F;
      if (par1Entity.kettleMode != 1) {
         if (JGConfigClientSettings.CLIENT_DA20) {
            if (JGConfigClientSettings.CLIENT_DA14 && par1Entity.getBol6() == -1) {
               this.func_tad(par1Entity, parX, parY, parZ, par8, par9);
            } else if (JGConfigClientSettings.CLIENT_DA12) {
               this.lightning(par1Entity, parX, parY, parZ, par9, 1.0F, var13, rot);
            }
         } else if (JGConfigClientSettings.CLIENT_DA14) {
            this.func_tad(par1Entity, parX, parY, parZ, par8, par9);
         } else if (JGConfigClientSettings.CLIENT_DA12) {
            this.lightning(par1Entity, parX, parY, parZ, par9, 1.0F, var13, rot);
         }

      }
   }

   private void func_tad(EntityAura2 par1Entity, double parX, double parY, double parZ, float par8, float par9) {
      if (!DBCClient.mc.func_147113_T()) {
         int cl3 = par1Entity.getColL3();
         boolean cl3b = cl3 > 0;
         if (cl3b) {
            if (System.nanoTime() / 100000000L - this.time_start > 1L) {
               if (this.au_fel) {
                  if (this.au_i >= 8) {
                     this.au_fel = false;
                     --this.au_i;
                  } else {
                     ++this.au_i;
                  }
               } else if (this.au_i <= 0) {
                  this.au_fel = true;
                  ++this.au_i;
               } else {
                  --this.au_i;
               }

               this.time_start = System.nanoTime() / 100000000L;
            }
         } else if (System.nanoTime() / 10000000L - this.time_start > 1L) {
            if (this.au_fel) {
               if (this.au_i >= 5) {
                  this.au_fel = false;
                  --this.au_i;
               } else {
                  ++this.au_i;
               }
            } else if (this.au_i <= 0) {
               this.au_fel = true;
               ++this.au_i;
            } else {
               --this.au_i;
            }

            this.time_start = System.nanoTime() / 10000000L;
         }
      }

      if (this.au_i > 8) {
         this.au_i = 8;
      } else if (this.au_i < 0) {
         this.au_i = 0;
      }

      this.field_76989_e = 0.0F;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)parX + 0.0F, (float)parY + 3.0F, (float)parZ + 0.0F);
      boolean rot = par1Entity.getRot();
      if (rot) {
         GL11.glTranslatef(0.0F, -1.5F, 0.0F);
         GL11.glRotatef(-par1Entity.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(par1Entity.field_70125_A - 90.0F, 1.0F, 0.0F, 0.0F);
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
      int cl3 = par1Entity.getColL3();
      String texl2 = par1Entity.getTexL2();
      String texl3 = par1Entity.getTexL3();
      boolean hasl2 = texl2.length() > 2;
      s += s2;
      boolean cl3b = cl3 > 0;
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation txx3 = new ResourceLocation(this.mdid + ":" + texl3 + ".png");
      ResourceLocation txx2 = new ResourceLocation(this.mdid + ":" + texl2 + ".png");
      ResourceLocation txx = new ResourceLocation(this.mdid + ":" + tex + ".png");
      GL11.glEnable(3042);
      float f4 = 0.5F;
      GL11.glColor4f(f4, f4, f4, 1.0F);
      GL11.glDisable(2896);
      GL11.glBlendFunc(1, 1);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      this.field_76990_c.field_78724_e.func_110577_a(txx);
      boolean plyrSP = DBCClient.mc.field_71439_g.func_70005_c_().equals(par1Entity.getmot()) && DBCClient.mc.field_71474_y.field_74320_O == 0;
      float p = !plyrSP ? par1Entity.getAlp() * ((float)JGConfigClientSettings.CLIENT_DA21 / 10.0F) : (par1Entity.getInner() ? 0.025F * ((float)JGConfigClientSettings.CLIENT_DA21 / 10.0F) : 0.05F * ((float)JGConfigClientSettings.CLIENT_DA21 / 10.0F));
      glColor4f(c, p);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glScalef(1.0F + 0.1F * s + (float)this.au_i * 0.03F, 1.0F + 0.07F * s, 1.0F + 0.1F * s + (float)this.au_i * 0.03F);
      GL11.glTranslatef(0.0F, -0.3F - 0.07F * s, 0.0F);
      GL11.glRotatef(var13 * spd2, 0.0F, 1.0F, 0.0F);
      boolean spawn = true;
      float w = 0.75F;

      for(int i2 = 0; i2 < (iner ? 2 : 1) && (i2 != 1 || !(var13 > (cl3b ? spd / 2.0F : 10.0F))); ++i2) {
         for(int i = 0; i < 4; ++i) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)(i * 90), 0.0F, 1.0F, 0.0F);
            if (var13 < 15.0F) {
               glColor4f(c, p);
               if (spawn) {
                  this.aModel.renderModel(par1Entity, 0.0625F, var13, (float)i2 * w, spd);
               }

               if (hasl2) {
                  this.field_76990_c.field_78724_e.func_110577_a(txx2);
                  glColor4f(cl2, p);
                  if (spawn) {
                     this.aModel.renderModel(par1Entity, 0.0625F, var13, (float)i2 * w, spd);
                  }
               }
            }

            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glRotatef((float)(i * 90 + 45), 0.0F, 1.0F, 0.0F);
            this.field_76990_c.field_78724_e.func_110577_a(cl3b && i2 == 1 ? txx3 : txx);
            if (cl3b && i2 == 1) {
               cf(c, cl3, p);
            } else {
               glColor4f(c, p);
            }

            if (spawn) {
               this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, (float)i2 * w, spd);
            }

            if (hasl2) {
               this.field_76990_c.field_78724_e.func_110577_a(txx2);
               glColor4f(cl2, p);
               if (spawn) {
                  this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, (float)i2 * w, spd);
               }
            }

            GL11.glPopMatrix();
            if (cl3b) {
               GL11.glPushMatrix();
               GL11.glScalef(0.7F, 0.7F, 0.7F);
               GL11.glTranslatef(0.0F, 0.95F, 0.0F);
               GL11.glRotatef((float)(i * 90 + 45), 0.0F, 1.0F, 0.0F);
               this.field_76990_c.field_78724_e.func_110577_a(txx3);
               glColor4f(cl3, p);
               if (spawn) {
                  this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, (float)i2 * w, spd);
               }

               GL11.glPopMatrix();
            }
         }
      }

      GL11.glAlphaFunc(516, 0.1F);
      GL11.glDisable(3042);
      GL11.glEnable(2896);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
      if (JGConfigClientSettings.CLIENT_DA12) {
         this.lightning(par1Entity, parX, parY, parZ, par9, 1.0F, var13, rot);
      }

   }

   private void lightning(EntityAura2 e, double par2, double par4, double par6, float par9, float var20, float var13, boolean rot) {
      if (var13 < (float)e.getLightLivingTime() && e.getState() > 4.0F && e.getState() < 7.0F && !rot) {
         GL11.glPushMatrix();
         Tessellator tessellator2 = Tessellator.field_78398_a;
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         double[] adouble = new double[8];
         double[] adouble1 = new double[8];
         double d3 = 0.0D;
         double d4 = 0.0D;
         GL11.glTranslatef((float)par2, (float)par4 + e.field_70131_O / 2.0F, (float)par6);
         int k1 = 0;
         int nu = (int)(Math.random() * 10.0D) + 1;
         int nu2 = 1;
         if (!JRMCoreClient.mc.func_147113_T()) {
            this.lightVertN = (int)(Math.random() * 10.0D);
         }

         for(int i = 0; i < this.lightVertN; ++i) {
            if (!JRMCoreClient.mc.func_147113_T()) {
               this.lightVertRotation[i][0] = (float)(Math.random() * 1.0D);
               this.lightVertRotation[i][1] = (float)(Math.random() * 1.0D);
               this.lightVertRotation[i][2] = (float)(Math.random() * 1.0D);
               this.lightVertRotation[i][3] = (float)(Math.random() * 1.2000000476837158D) - 0.6F;
               this.lightVertRotation[i][4] = (float)(Math.random() * (double)e.field_70131_O) - e.field_70131_O / 2.0F;
               this.lightVertRotation[i][5] = (float)(Math.random() * 1.2000000476837158D) - 0.6F;
               this.lightVertRotation[i][6] = (float)(Math.random() * 0.20000000298023224D);
            }

            float sc = 0.05F + this.lightVertRotation[i][6];
            GL11.glRotatef(360.0F * this.lightVertRotation[i][0], 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(360.0F * this.lightVertRotation[i][1], 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(360.0F * this.lightVertRotation[i][2], 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(this.lightVertRotation[i][3], this.lightVertRotation[i][4], this.lightVertRotation[i][5]);
            Random random1 = new Random(e.lightVert[i]);

            for(int j = 0; j < nu2; ++j) {
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
                  tessellator2.func_78371_b(5);
                  float f2 = 0.5F;
                  if (!e.getBol7()) {
                     tessellator2.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.35F);
                  } else {
                     tessellator2.func_78369_a(1.0F * f2, 0.05F * f2, 0.1F * f2, 0.5F);
                  }

                  double d9 = 0.1D + (double)k1 * 0.2D;
                  double d10 = 0.1D + (double)k1 * 0.2D;

                  for(int j1 = 0; j1 < 5; ++j1) {
                     double d11 = 0.0D - d9;
                     double d12 = 0.0D - d9;
                     if (j1 == 1 || j1 == 2) {
                        d11 += d9 * 2.0D * (double)sc;
                     }

                     if (j1 == 2 || j1 == 3) {
                        d12 += d9 * 2.0D * (double)sc;
                     }

                     double d13 = 0.0D - d10;
                     double d14 = 0.0D - d10;
                     if (j1 == 1 || j1 == 2) {
                        d13 += d10 * 2.0D * (double)sc;
                     }

                     if (j1 == 2 || j1 == 3) {
                        d14 += d10 * 2.0D * (double)sc;
                     }

                     if (i1 < 8) {
                        tessellator2.func_78377_a(d13 + d5 * (double)sc, -((double)(i1 * 1 - 7)) * (double)sc, d14 + d6 * (double)sc);
                        tessellator2.func_78377_a(d11 + d7 * (double)sc, -((double)((i1 + 1) * 1 - 7)) * (double)sc, d12 + d8 * (double)sc);
                     }
                  }

                  tessellator2.func_78381_a();
               }
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

   public static void cf(int x, int y, float a) {
      float h2 = (float)(x >> 16 & 255) / 255.0F;
      float h3 = (float)(x >> 8 & 255) / 255.0F;
      float h4 = (float)(x & 255) / 255.0F;
      float y2 = (float)(y >> 16 & 255) / 255.0F;
      float y3 = (float)(y >> 8 & 255) / 255.0F;
      float y4 = (float)(y & 255) / 255.0F;
      float pc = 0.5F;
      pc = pc > 1.0F ? 1.0F : pc;
      float pg = 1.0F - pc;
      float ga = h2 * pg + y2 * pc;
      float hr = h3 * pg + y3 * pc;
      float ah = h4 * pg + y4 * pc;
      GL11.glColor4f(ga, hr, ah, a);
   }

   protected float handleRotationFloat(Entity par1Entity, float par2) {
      return (float)par1Entity.field_70173_aa + par2;
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAura((EntityAura2)par1Entity, par2, par4, par6, par8, par9);
   }
}
