package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityDBCGood;
import JinRyuu.DragonBC.common.Npcs.EntityDBCNeut;
import JinRyuu.JRMCore.JRMCoreCliTicH;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHC;
import JinRyuu.JRMCore.mod_JRMCore;
import JinRyuu.JRMCore.entity.EntitySafeZone;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import org.lwjgl.opengl.GL11;

public class DBCEH {
   public static final int ksm_default = 0;
   public static final int ksm_onlyPly = 1;
   public static final int ksm_onlyMob = 2;
   public static final int ksm_showall = 3;
   public static final int ksm_off = 4;
   public static int kisnsMd = 0;
   public String lastRender = "";

   public void renderSense(int hp, int maxhp, int ki, int maxki, int align, Post event) {
      double X = event.x;
      double Y = event.y;
      double Z = event.z;
      EntityPlayer p = mod_JRMCore.proxy.getPlayerClient();
      Entity entity = event.entity;
      if (entity instanceof EntityPlayer && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0) {
         EntityPlayer player = (EntityPlayer)entity;

         for(int pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
            if (JRMCoreH.dat18 != null && JRMCoreH.dat18.length > pl && JRMCoreH.dat18[pl] != null) {
               String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
               if (fullFusionData.length >= 3) {
                  String[] fusionData = fullFusionData[2].split(",");
                  if (fusionData.length == 3) {
                     EntityPlayer fusionSpectator = player.field_70170_p.func_72924_a(fusionData[1]);
                     if (fusionSpectator != null && fusionSpectator.func_70005_c_().equals(player.func_70005_c_())) {
                        return;
                     }
                  }
               }
            }
         }
      }

      int kiSenseLvl = JRMCoreH.SklLvl(6);
      double distance = entity.func_70068_e(p);
      float f2 = (float)(30 + kiSenseLvl * 10);
      if (distance < (double)(f2 * f2) && (!(entity.field_70163_u < 61.0D) || Y > (double)(-kiSenseLvl * 4))) {
         float width = 39.0F;
         float maxperc = width / (float)maxki;
         float var20 = maxperc * (float)ki;
         if (var20 > width) {
            var20 = width;
         }

         maxperc = width / (float)maxhp;
         float var21 = maxperc * (float)hp;
         if (var21 > width) {
            var21 = width;
         }

         long res = JRMCoreH.gkap(JRMCoreH.bpc(entity), "sns;" + entity.func_70005_c_() + ";" + entity.func_145782_y());
         long bps = JRMCoreHC.BPC_ME;
         long pwr = res > bps ? res / bps : bps / res;
         long bpsa = JRMCoreHC.BPC_ME2;
         long pwra = res > bpsa ? res / bpsa : bpsa / res;
         boolean loo = JRMCoreCliTicH.lockOn != null && JRMCoreConfig.lockon;
         if (loo) {
            if (!loo) {
               return;
            }
         } else if (res <= 5L || res < bps && kisnsMd != 3 && bps / res > 100L) {
            return;
         }

         FontRenderer fontrenderer = RenderManager.field_78727_a.func_78716_a();
         float f = 1.6F;
         float f1 = 0.016666668F * f;
         GL11.glPushMatrix();
         float angle = (float)Math.toDegrees(Math.atan2(0.0D - event.z, 0.0D - event.x));
         double rtx = Math.sin((double)(angle / 57.295776F));
         double rty = Math.cos((double)(angle / 57.295776F));
         GL11.glTranslatef((float)(X + 0.0D * rtx), (float)Y + entity.field_70131_O + 1.75F - entity.field_70131_O * 0.75F + 0.5F, (float)(Z - 0.0D * rty));
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         boolean t = DBCClient.mc.field_71474_y.field_74320_O == 2;
         GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(t ? -RenderManager.field_78727_a.field_78732_j : RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
         double ikr = (double)(RenderManager.field_78727_a.field_78735_i % 180.0F / 57.295776F);
         GL11.glScalef(-f1, -f1, f1);
         distance = (double)entity.func_70032_d(p);
         if (distance > 10.0D) {
            GL11.glScaled(distance / 10.0D, distance / 10.0D, distance / 10.0D);
         }

         GL11.glDisable(2896);
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         int Ypos = -40;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
         ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjdbcAssts + ":kisense.png");
         JRMCoreClient.mc.field_71446_o.func_110577_a(guiLocation);
         this.drawTexturedModalRect(0.0F, (float)(0 + Ypos), 0, 0, 21.0F, 41.0F, 0.0F);
         int red = 16522030;
         int blu = 654591;
         int pur = 13478142;
         int ora = 16737280;
         int darkred = 7208960;
         int yel = 16574610;
         int bc1;
         switch(align) {
         case 0:
            bc1 = blu;
            break;
         case 1:
            bc1 = pur;
            break;
         case 2:
            bc1 = red;
            break;
         default:
            bc1 = pur;
         }

         glColor4f(bc1, 1.0F);
         this.drawTexturedModalRect(1.0F, (float)(39 - (int)var20 + 1 + Ypos), 25, 0, (float)(10 + (kiSenseLvl > 1 ? 0 : 9)), (float)((int)var20), 0.0F);
         if (kiSenseLvl > 1) {
            glColor4f(7208960, 1.0F);
            this.drawTexturedModalRect(11.0F, (float)(39 - (int)var21 + 1 + Ypos), 35, 0, 9.0F, (float)((int)var21), 0.0F);
         }

         if (kiSenseLvl > 3) {
            width = 41.0F;
            maxperc = width / 10.0F;
            float var22 = maxperc * (float)(pwr > 10L ? 10L : pwr);
            if (var22 > width) {
               var22 = width;
            }

            glColor4f(res > bps ? 16737280 : 654591, 1.0F);
            this.drawTexturedModalRect(-3.0F, (float)(41 - (int)var22 + Ypos), 21, 0, 3.0F, (float)((int)var22), 0.0F);
            if (pwr > 10L && kiSenseLvl > 6) {
               maxperc = width / 100.0F;
               var22 = maxperc * (float)(pwr > 100L ? 100L : pwr);
               if (var22 > width) {
                  var22 = width;
               }

               this.drawTexturedModalRect(-4.0F, (float)(41 - (int)var22 + Ypos), 24, 0, 1.0F, (float)((int)var22), 0.0F);
            }

            maxperc = width / 10.0F;
            var22 = maxperc * (float)(pwra > 10L ? 10L : pwra);
            if (var22 > width) {
               var22 = width;
            }

            glColor4f(res > bpsa ? 16737280 : 654591, 1.0F);
            this.drawTexturedModalRect(21.0F, (float)(41 - (int)var22 + Ypos), 21, 0, 3.0F, (float)((int)var22), 0.0F);
            if (pwra > 10L && kiSenseLvl > 6) {
               maxperc = width / 100.0F;
               var22 = maxperc * (float)(pwra > 100L ? 100L : pwra);
               if (var22 > width) {
                  var22 = width;
               }

               this.drawTexturedModalRect(24.0F, (float)(41 - (int)var22 + Ypos), 24, 0, 1.0F, (float)((int)var22), 0.0F);
            }
         }

         if (kiSenseLvl > 9) {
            String n = entity.func_70005_c_();
            String[] d10 = JRMCoreH.data(n, 10, "0;0").split(";");
            String[] d2 = JRMCoreH.data(n, 2, "0;0").split(";");
            String[] d1 = JRMCoreH.data(n, 1, "0;0").split(";");
            int inc = 0;
            String d = hp + "";
            int ho = Ypos - inc * 9;
            int hpw = fontrenderer.func_78256_a(d);
            fontrenderer.func_78276_b(d, (int)(13.0F - (float)hpw / 2.0F), -8 + ho, 0);
            fontrenderer.func_78276_b(d, (int)(11.0F - (float)hpw / 2.0F), -8 + ho, 0);
            fontrenderer.func_78276_b(d, (int)(12.0F - (float)hpw / 2.0F), -7 + ho, 0);
            fontrenderer.func_78276_b(d, (int)(12.0F - (float)hpw / 2.0F), -9 + ho, 0);
            fontrenderer.func_78276_b(d, 12 - hpw / 2, -8 + ho, 14812441);
            int var67 = inc + 1;
         }

         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
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

   public static void glColor4f(int c, int c2, float p, float a) {
      float h2 = (float)(c >> 16 & 255) / 255.0F;
      float h3 = (float)(c >> 8 & 255) / 255.0F;
      float h4 = (float)(c & 255) / 255.0F;
      float h22 = (float)(c2 >> 16 & 255) / 255.0F;
      float h32 = (float)(c2 >> 8 & 255) / 255.0F;
      float h42 = (float)(c2 & 255) / 255.0F;
      float percentComplete = p > 1.0F ? 1.0F : p;
      float percentGone = 1.0F - percentComplete;
      float red = h2 * percentGone + h22 * percentComplete;
      float green = h3 * percentGone + h32 * percentComplete;
      float blue = h4 * percentGone + h42 * percentComplete;
      GL11.glColor4f(red, green, blue, a);
   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void onRenderLivingEvent(Post event) {
      boolean plyr = event.entity instanceof EntityPlayer;
      boolean loo = JRMCoreCliTicH.lockOn != null && JRMCoreConfig.lockon;
      boolean lo = loo && event.entity.equals(JRMCoreCliTicH.lockOn);
      if (JRMCoreH.Pwrtyp == 1 && JRMCoreH.SklLvl(6) > 0 && kisnsMd != 4) {
         if (!(event.entity instanceof EntitySafeZone) && event.entity instanceof EntityCreature) {
            label93: {
               if (loo) {
                  if (!lo) {
                     break label93;
                  }
               } else if (kisnsMd == 1) {
                  break label93;
               }

               int align = 1;
               if (event.entity instanceof EntityMob) {
                  align = 2;
               } else if (event.entity instanceof EntityDBCEvil) {
                  align = 2;
               } else if (event.entity instanceof EntityDBCNeut) {
                  align = 1;
               } else if (event.entity instanceof EntityDBCGood) {
                  align = 0;
               } else if (event.entity instanceof EntityDBC) {
                  align = 1;
               } else if (event.entity instanceof EntityDBC) {
                  align = 1;
               }

               this.renderSense((int)event.entity.func_110143_aJ(), (int)event.entity.func_110138_aP(), 100, 100, align, event);
            }
         }

         if (plyr) {
            if (loo) {
               if (!lo) {
                  return;
               }
            } else if (kisnsMd == 2) {
               return;
            }

            if (!JRMCoreClient.mc.field_71439_g.func_70005_c_().equals(event.entity.func_70005_c_()) && JRMCoreH.dnn(14) && JRMCoreH.dnn(8) && JRMCoreH.dnn(9) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
               EntityPlayer p = (EntityPlayer)event.entity;
               int hp = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 8, "200"));
               int ki = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 9, "200"));
               int[] atr = JRMCoreH.PlyrAttrbtsC((EntityPlayer)event.entity);
               String[] s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
               int race = Integer.parseInt(s[0]);
               int pwr = Integer.parseInt(s[2]);
               int cls = Integer.parseInt(s[3]);
               s = JRMCoreH.data(event.entity.func_70005_c_(), 6, "pty;pty;pty;pty").split(";");
               String[] PlyrSkills = s[0].split(",");
               int maxhp = JRMCoreH.stat(p, 2, pwr, 2, atr[2], race, cls, 0.0F);
               int maxki = JRMCoreH.stat(p, 5, pwr, 5, atr[5], race, cls, JRMCoreH.SklLvl_KiBs(PlyrSkills, pwr));
               int align = JRMCoreH.Algnmnt(Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 5, "50;0").split(";")[0]));
               this.renderSense(hp, maxhp, ki, maxki, align, event);
            }
         }
      }

   }

   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)x, (double)(y + 0.0F), (double)z, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78374_a((double)x, (double)(y + height), (double)z, (double)((float)(u + 0) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + height), (double)z, (double)(((float)u + width) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + 0.0F), (double)z, (double)(((float)u + width) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78381_a();
   }

   @SubscribeEvent
   public void gldsog(BreakEvent event) {
      if (event.block == BlocksDBC.ppBlock) {
         event.setCanceled(true);
      }

   }
}
