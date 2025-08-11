package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCusPar extends RenderJRMC {
   private ModelPG model1;
   private ModelPS model2;

   public RenderCusPar() {
      super(new ModelAura(), 0.5F);
   }

   public void renderAura(EntityCusPar entity, double parX, double parY, double parZ, float par8, float par9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef((float)(-parX), (float)(-parY) - entity.field_70131_O / 2.0F, (float)parZ);
      GL11.glPushMatrix();
      boolean harom = false;
      int id;
      if (JGConfigClientSettings.CLIENT_GR11 && entity.getdata34() == 0) {
         for(id = entity.getId(); id > 4; id -= 5) {
         }

         this.model1 = new ModelPG(id);
         harom = true;
      }

      if (JGConfigClientSettings.CLIENT_GR10 && entity.getdata34() == 1) {
         for(id = entity.getId(); id > 4; id -= 5) {
         }

         this.model2 = new ModelPS(id);
         harom = true;
      }

      if (!harom) {
         boolean view2 = JRMCoreClient.mc.gameSettings.thirdPersonView == 2;
         GL11.glPushMatrix();
         GL11.glScalef(1.0F, 1.0F, 1.0F);
         ResourceLocation tx = new ResourceLocation(entity.getdata3());
         this.renderManager.renderEngine.bindTexture(tx);
         if (entity.getdata42() == 0) {
            GL11.glRotatef(RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(RenderManager.field_78727_a.field_78732_j * (float)(view2 ? 1 : -1), 1.0F, 0.0F, 0.0F);
         } else if (entity.getdata42() == 1 && entity.hasEnt()) {
            GL11.glRotatef(entity.getEnt().rotationYaw, 0.0F, 1.0F, 0.0F);
         } else if (entity.getdata42() == 2 && entity.hasEnt()) {
            GL11.glRotatef(entity.getEnt().rotationPitch * (float)(view2 ? 1 : -1), 1.0F, 0.0F, 0.0F);
         } else if (entity.getdata42() == 3 && entity.hasEnt()) {
            GL11.glRotatef(entity.getEnt().rotationYaw, 0.0F, 1.0F, 0.0F);
            if (!view2) {
               GL11.glRotatef(entity.getEnt().rotationPitch, -1.0F, 0.0F, 0.0F);
            } else {
               GL11.glRotatef(entity.getEnt().rotationPitch, -1.0F, 0.0F, 0.0F);
            }
         }

         GL11.glTranslatef(entity.getdata43(), entity.getdata44(), entity.getdata45());
         this.fieldPass2(entity);
         GL11.glPopMatrix();
      } else {
         ResourceLocation tx = new ResourceLocation("jinryuumodscore:allw.png");
         this.renderManager.renderEngine.bindTexture(tx);
         GL11.glTranslatef(entity.getdata43(), entity.getdata44(), entity.getdata45());
         this.fieldPass3(0, 0, entity);
      }

      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAura((EntityCusPar)par1Entity, par2, par4, par6, par8, par9);
   }

   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.INSTANCE;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)x, (double)(y + 0.0F), (double)z, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78374_a((double)x, (double)(y + height), (double)z, (double)((float)(u + 0) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + height), (double)z, (double)(((float)u + width) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + 0.0F), (double)z, (double)(((float)u + width) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78381_a();
   }

   private void fieldPass2(EntityCusPar e) {
      GL11.glPushMatrix();
      float scale = this.func_cs(e);
      GL11.glScalef(scale, scale, scale);
      GL11.glEnable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glDepthMask(false);
      int id = e.getId();
      float rot = (float)(e.ticksExisted * 5) * e.getRotation_Sp();
      GL11.glRotatef((e.getRotation() ? rot : 0.0F - rot) + e.getdata39(), 0.0F, 0.0F, 1.0F);
      float rot2 = (float)(e.ticksExisted * 5) * e.getRotation_Sp2() * 2.0F;
      GL11.glRotatef((e.getRotation2() ? rot2 : 0.0F - rot2) + e.getdata40(), 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(e.getdata40(), 0.0F, 1.0F, 0.0F);
      int id_y = id / (256 / e.getdata32());
      int id = id - id_y * (256 / e.getdata32());
      float f = e.getdata28();
      if (e.getdata35() && e.hasEnt() && JRMCoreClient.mc.player != null && e.getEnt().equals(JRMCoreClient.mc.player) && JRMCoreClient.mc.gameSettings.thirdPersonView == 0) {
         f *= (float)JGConfigClientSettings.CLIENT_DA3 / 10.0F;
      }

      float clr1 = this.func_rch(e, e.getdata8(), e.getdata11(), e.getdata14(), (float)e.ticksExisted);
      float clr2 = this.func_rch(e, e.getdata9(), e.getdata12(), e.getdata15(), (float)e.ticksExisted);
      float clr3 = this.func_rch(e, e.getdata10(), e.getdata13(), e.getdata16(), (float)e.ticksExisted);
      GL11.glColor4f(clr1, clr2, clr3, f);
      this.drawTexturedModalRect((float)(-(e.getdata32() / 2)), (float)(-(e.getdata32() / 2)), id * e.getdata32(), id_y * e.getdata32(), (float)e.getdata32(), (float)e.getdata32(), 0.0F);
      GL11.glEnable(2896);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   private void fieldPass3(int guiLeftO, int guiTopO, EntityCusPar e) {
      GL11.glPushMatrix();
      int type = e.getdata34();
      float scale;
      if (type == 0) {
         scale = 0.8F;
      } else {
         scale = 0.5F;
      }

      GL11.glScalef(scale, scale, scale);
      GL11.glEnable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glDepthMask(false);
      float rot = (float)(e.ticksExisted * 5) * e.getRotation_Sp();
      GL11.glRotatef((e.getRotation() ? rot : 0.0F - rot) + e.getdata39(), 0.0F, 0.0F, 1.0F);
      float rot2 = (float)(e.ticksExisted * 5) * e.getRotation_Sp2() * 2.0F;
      GL11.glRotatef((e.getRotation2() ? rot2 : 0.0F - rot2) + e.getdata40(), 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(e.getdata40(), 0.0F, 1.0F, 0.0F);
      float f = e.getdata28();
      if (e.getdata35() && e.hasEnt() && JRMCoreClient.mc.player != null && e.getEnt().equals(JRMCoreClient.mc.player) && JRMCoreClient.mc.gameSettings.thirdPersonView == 0) {
         f *= (float)JGConfigClientSettings.CLIENT_DA3 / 10.0F;
      }

      if (e.getdata34() == 0) {
         GL11.glColor4f(0.3F, 0.55F, 0.25F, f);
      } else {
         GL11.glColor4f(0.56078434F, 0.48235294F, 0.43137255F, f);
      }

      if (type == 0) {
         this.model1.render(e, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      } else {
         this.model2.render(e, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      }

      GL11.glEnable(2896);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   private float func_rch(EntityCusPar entity, float f1, float f2, float f3, float f4) {
      float fl1 = f1;
      if (entity.getdata31() == 1) {
         fl1 = f1 + f2 * f4;
         if (f2 > 0.0F && fl1 > f3) {
            fl1 = f3;
         } else if (f2 < 0.0F && fl1 < f3) {
            fl1 = f3;
         }
      } else if (entity.getdata31() == 2) {
         float szaz;
         float egy;
         float calc;
         if (f1 < f3) {
            szaz = (float)entity.getdata2();
            egy = szaz / 100.0F;
            calc = (float)entity.ticksExisted / egy;
            fl1 = (f3 - f1) / 100.0F * calc + f1;
         } else if (f1 > f3) {
            szaz = (float)entity.getdata2();
            egy = szaz / 100.0F;
            calc = (float)entity.ticksExisted / egy;
            fl1 = f1 - (f1 - f3) / 100.0F * calc;
         }
      }

      return fl1;
   }

   private float func_cs(EntityCusPar entity) {
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      if (entity.getdata4() == 0) {
         f1 = entity.getdata5();
      } else if (entity.getdata4() == 1) {
         f2 = entity.getdata7();
         f3 = entity.getdata6();
         f1 = entity.getdata5() + (float)entity.ticksExisted * f2;
         if (f2 > 0.0F && f1 > f3) {
            f1 = f3;
         } else if (f2 < 0.0F && f1 < f3) {
            f1 = f3;
         }
      } else if (entity.getdata4() == 2) {
         f2 = entity.getdata7();
         f3 = entity.getdata6();
         float szaz = (float)entity.getdata2();
         float egy = szaz / 100.0F;
         float calc = (float)entity.ticksExisted / egy;
         if (f2 > 0.0F) {
            f1 = entity.getdata5() / 100.0F * calc;
         } else if (f2 < 0.0F) {
            f1 = entity.getdata5() - entity.getdata5() / 100.0F * calc;
         }
      }

      return f1;
   }
}
