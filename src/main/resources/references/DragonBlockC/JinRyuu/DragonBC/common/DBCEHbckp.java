package JinRyuu.DragonBC.common;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.mod_JRMCore;
import com.jin_ryuu.SwordArtC.Main;
import com.jin_ryuu.SwordArtC.proxy.Client;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import org.lwjgl.opengl.GL11;

public class DBCEHbckp {
   public long bpc(Entity e) {
      if (!(e instanceof EntityCreature)) {
         return e instanceof EntityPlayer ? JRMCoreH.bpc((EntityPlayer)e, e.func_70005_c_()) : 1L;
      } else {
         int atr = (int)(((EntityCreature)e).func_110138_aP() / JRMCoreH.statInc(1, 2, 1, 0, 0, 0.0F) * 6.0F);
         long res = 1L;

         for(int t = 0; t <= atr; ++t) {
            res += (long)JRMCoreH.attrCst(t);
         }

         return res;
      }
   }

   public void renderSense(int hp, int maxhp, int ki, int maxki, Post event) {
      double X = event.x;
      double Y = event.y;
      double Z = event.z;
      EntityPlayer p = Main.proxy.getPlayerClient();
      double d3 = event.entity.func_70068_e(p);
      float f2 = p.func_70093_af() ? 40.0F : 20.0F;
      if (d3 < (double)(f2 * f2)) {
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

         long res = this.bpc(event.entity);
         long bps = JRMCoreH.bpc(JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp);
         long pwr = res > bps ? res / bps : bps / res;
         String disp = (res > bps ? "+" : "-") + (pwr > 100L ? "100^x" : pwr + "x");
         long bpsa = JRMCoreH.bpc(JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp, 100);
         long pwra = res > bpsa ? res / bps : bpsa / res;
         String dispa = (res > bpsa ? "+" : "-") + (pwra > 100L ? "100^x" : pwra + "x");
         FontRenderer fontrenderer = RenderManager.field_78727_a.func_78716_a();
         float f = 1.6F;
         float f1 = 0.016666668F * f;
         GL11.glPushMatrix();
         float angle = (float)Math.toDegrees(Math.atan2(0.0D - event.z, 0.0D - event.x));
         double rtx = Math.sin((double)(angle / 57.295776F));
         double rty = Math.cos((double)(angle / 57.295776F));
         GL11.glTranslatef((float)(X + 1.5D * rtx), (float)Y + event.entity.field_70131_O + 1.75F - event.entity.field_70131_O * 0.75F + 0.5F, (float)(Z - 1.5D * rty));
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
         double ikr = (double)(RenderManager.field_78727_a.field_78735_i % 180.0F / 57.295776F);
         GL11.glScalef(-f1, -f1, f1);
         d3 = (double)event.entity.func_70032_d(p);
         if (d3 > 10.0D) {
            GL11.glScaled(d3 / 10.0D, d3 / 10.0D, d3 / 10.0D);
         }

         GL11.glDisable(2896);
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
         ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjdbcAssts + ":kisense.png");
         Client.mc.field_71446_o.func_110577_a(guiLocation);
         this.drawTexturedModalRect(0.0F, 0.0F, 0, 0, 21.0F, 41.0F, 0.0F);
         int bc1 = 654591;
         if (JRMCoreH.align > 66) {
            bc1 = 654591;
         } else if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
            bc1 = 13478142;
         } else if (JRMCoreH.align < 33) {
            bc1 = 16522030;
         }

         int s = (JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.State > 0 ? 16574610 : bc1;
         glColor4f(s, 1.0F);
         this.drawTexturedModalRect(1.0F, (float)(39 - (int)var20 + 1), 24, 0, 10.0F, (float)((int)var20), 0.0F);
         glColor4f(7208960, 1.0F);
         this.drawTexturedModalRect(11.0F, (float)(39 - (int)var21 + 1), 34, 0, 9.0F, (float)((int)var21), 0.0F);
         width = 41.0F;
         maxperc = width / 10.0F;
         float var22 = maxperc * (float)(pwr > 10L ? 10L : pwr);
         if (var22 > width) {
            var22 = width;
         }

         glColor4f(res > bps ? 16737280 : 654591, 1.0F);
         this.drawTexturedModalRect(-3.0F, (float)(41 - (int)var22), 21, 0, 3.0F, (float)((int)var22), 0.0F);
         var22 = maxperc * (float)(pwra > 10L ? 10L : pwra);
         if (var22 > width) {
            var22 = width;
         }

         glColor4f(res > bpsa ? 16737280 : 654591, 1.0F);
         this.drawTexturedModalRect(21.0F, (float)(41 - (int)var22), 21, 0, 3.0F, (float)((int)var22), 0.0F);
         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
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
      if (JRMCoreH.Pwrtyp == 1 && (event.entity instanceof EntityCreature || plyr)) {
         this.renderSense((int)event.entity.func_110143_aJ(), (int)event.entity.func_110138_aP(), 100, 100, event);
      }

      if (event.entity instanceof EntityPlayer && JRMCoreH.Pwrtyp == 1) {
         int hp = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 8, "200"));
         int ki = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 9, "200"));
         int[] atr = JRMCoreH.PlyrAttrbtsC((EntityPlayer)event.entity);
         String[] s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
         int cls = Integer.parseInt(s[3]);
         int race = Integer.parseInt(s[0]);
         int maxhp = JRMCoreH.stat(event.entity, 2, 1, 2, atr[2], race, cls, 0.0F);
         int maxki = JRMCoreH.stat(event.entity, 5, 1, 5, atr[5], race, cls, 0.0F);
         this.renderSense(hp, maxhp, ki, maxki, event);
         EntityPlayer p = mod_JRMCore.proxy.getPlayerClient();
         double d3 = event.entity.func_70068_e(p);
         float f2 = p.func_70093_af() ? 4.0F : 8.0F;
         if (d3 < (double)(f2 * f2)) {
            double X = event.x;
            double Y = event.y;
            double Z = event.z;
            float width = 120.0F;
            float maxperc = width / (float)maxhp;
            float var20 = maxperc * (float)hp;
            if (var20 > width) {
               var20 = width;
            }

            float r = var20 > 50.0F ? 0.58F : (var20 > 25.0F ? 1.0F : 1.0F);
            float g = var20 > 50.0F ? 0.83F : (var20 > 25.0F ? 1.0F : 0.2F);
            float b = var20 > 50.0F ? 0.23F : (var20 > 25.0F ? 0.2F : 0.2F);
            FontRenderer fontrenderer = JRMCoreClient.mc.field_71466_p;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)X, (float)Y + event.entity.field_70131_O + 1.75F - event.entity.field_70131_O * 0.75F, (float)Z);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-30.0F, 0.0F, 0.0F, 1.0F);
            float f1 = 0.0116F;
            GL11.glScalef(-f1, -f1, f1);
            GL11.glDisable(2896);
            GL11.glTranslatef(-width / 2.0F - event.entity.field_70130_N * 40.0F, 1.0F / f1, 0.0F - event.entity.field_70130_N * 80.0F);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjsaoc + ":gui2.png");
            JRMCoreClient.mc.field_71446_o.func_110577_a(guiLocation);
            this.drawTexturedModalRect(0.0F, -1.0F, 0, 43, 126.0F, 15.0F, 0.0F);
            GL11.glColor4f(r, g, b, 1.0F);
            this.drawTexturedModalRect(4.0F, 1.0F, 0, 58, var20, 11.0F, -0.01F);
            GL11.glTranslatef(width, 0.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawTexturedModalRect(0.0F, -1.0F, 126, 43, -126.0F, 15.0F, 0.0F);
            GL11.glColor4f(r, g, b, 1.0F);
            this.drawTexturedModalRect((float)((int)var20) - width - 2.0F, 1.0F, (int)var20, 58, -var20, 11.0F, 0.01F);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
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
   public void onLivingDropsEvent(LivingDropsEvent event) {
   }
}
