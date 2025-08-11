package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.JGRenderHelper;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class RenderEnergyAttackKi extends RenderEnergyAttack<EntityEnergyAtt> {
   private ModelEnergy ener = new ModelEnergy();

   public void renderEnergy(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9) {
      this.transparent = false;
      this.updateEffect(entity);
      byte type = entity.getType();
      int shrink = entity.getShrink();
      float rotation = this.handleRotationFloat(entity, par9);
      int color = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol[5] : JRMCoreH.techCol4[entity.getCol()]) : JRMCoreH.techCol[entity.getCol()];
      int color2 = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol4[entity.getCol()] : JRMCoreH.techCol[entity.getCol()]) : (entity.getCol2() == -1 ? JRMCoreH.techCol2[entity.getCol()] : JRMCoreH.techCol3[entity.getCol2()]);
      double sx = (double)entity.strtX();
      double sy = (double)entity.strtY();
      double sz = (double)entity.strtZ();
      double x = sx - entity.posX;
      double y = sy - entity.posY;
      double z = sz - entity.posZ;
      if (shrink > 0) {
         this.updateEffect2(entity);
      } else {
         entity.dist = (double)MathHelper.func_76133_a(x * x + y * y + z * z);
         entity.finalDist = entity.dist;
      }

      float scale = entity.getSize() * ((float)JGConfigClientSettings.CLIENT_Ki_Scale / 10.0F);
      this.mode = 0;
      this.setVisuals((EntityEnergyAtt)entity, type, (short)0, color, color2, scale, this.mode);
      if (JGConfigClientSettings.CLIENT_Ki_3d[type]) {
         this.render_3d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, color2, rotation);
      } else {
         this.render_2d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, color2, rotation);
      }

   }

   public void updateEffect(EntityEnergyAtt entity) {
      if (!JRMCoreClient.mc.func_147113_T()) {
         if (!entity.added) {
            ++entity.animation_id;
            entity.animation_start = System.nanoTime() / 10000000L;
            entity.added = true;
            if (entity.render_scale < entity.render_scale_max) {
               entity.render_scale += entity.render_scale_max / 10.0F;
            }

            if (entity.render_scale > entity.render_scale_max) {
               entity.render_scale = entity.render_scale_max;
            }

            if (this.random_texture && entity.animation_random != null) {
               int size = entity.animation_random.size();
               entity.animation_random.clear();

               for(int i = 0; i < size; ++i) {
                  entity.animation_random.add((int)(Math.random() * (double)entity.animation_random_Max));
               }
            }
         }

         if (entity.animation_id >= entity.animation_id_Max) {
            entity.animation_id = 0;
         }

         if (System.nanoTime() / 10000000L - entity.animation_start > (long)entity.animation_speed) {
            entity.added = false;
         }
      }

   }

   public void updateEffect2(EntityEnergyAtt entity) {
      if (!JRMCoreClient.mc.func_147113_T()) {
         if (!entity.added2) {
            entity.animation_start2 = System.nanoTime() / 10000000L;
            entity.added2 = true;
            if (!entity.isShield() && !entity.isExplosion()) {
               float shrinking = (float)entity.finalDist / 500.0F;
               double d = entity.dist - (double)((float)entity.getSpe() * shrinking);
               entity.dist = d < 0.0D ? 0.0D : d;
               float egy = (float)entity.finalDist / 100.0F;
               float current = (float)entity.dist / egy / 100.0F;
               entity.waveScale = current;
            } else {
               entity.waveScale = 0.3F;
            }
         }

         if (System.nanoTime() / 10000000L - entity.animation_start2 > 1L) {
            entity.added2 = false;
         }
      }

   }

   public void setVisuals(EntityEnergyAtt entity, byte type, short effect, int color, int color2, float scale, byte mode) {
      float scale_all = scale;
      entity.animation_id_Max = 1;
      entity.animation_random_Max = 1;
      entity.animation_speed = 7;
      this.rendermode_tail = 0;
      this.render_head = true;
      this.render_head_connect = true;
      this.render_middle = true;
      this.render_noise = true;
      this.render_tail = true;
      this.render_tail_connect = true;
      this.rotate_head = true;
      this.rotate_head_connect = true;
      this.rotate_middle = true;
      this.rotate_noise = true;
      this.rotate_tail = true;
      this.rotate_tail_connect = true;
      this.scaling_head = true;
      this.scaling_tail = true;
      this.scale_head_more = 0.0F;
      this.scale_tail_more = 0.0F;
      this.head_follow = false;
      this.tail_follow = false;
      this.random_texture = false;
      this.rotationSpeed = 40.0F;
      this.modifierTranslation = entity.dist / 2.0D + (double)(scale * (1.0F / scale));
      this.detail = 4;
      this.brightness = 200;
      this.alpha = 1.0F * ((float)JGConfigClientSettings.CLIENT_Ki_Visibility / 10.0F);
      if (this.mode == 0) {
         this.setColors(color, this.alpha);
         this.setColors2(color2);
         this.texture = (entity.destroyer ? "dbc_god/" : "dbc/") + this.texture_type[type] + "/";
         if (entity.isWave()) {
            this.render_middle = false;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.head_follow = true;
            this.tail_follow = true;
            this.scale_tail_more = 0.1F;
         } else if (entity.isBlast()) {
            scale_all = scale * 0.5F;
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = true;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.head_follow = false;
            this.tail_follow = true;
            this.rendermode_tail = 2;
         } else if (entity.isDisk()) {
            this.rendermode_tail = 1;
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = false;
            this.scaling_head = false;
            this.scaling_tail = false;
         } else if (entity.isLaser()) {
            scale_all = scale * 0.5F;
            this.render_middle = false;
            this.head_follow = true;
            this.tail_follow = true;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.scale_tail_more = 0.15F;
         } else if (entity.isLargeBlast()) {
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = true;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.head_follow = false;
            this.tail_follow = true;
            this.rendermode_tail = 2;
         } else if (entity.isSpiral()) {
            this.head_follow = true;
            this.tail_follow = true;
            scale_all = scale * 0.5F;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.scale_tail_more = 0.15F;
         } else if (entity.isBarrage()) {
            scale_all = scale * 0.25F;
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = true;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.head_follow = false;
            this.tail_follow = true;
            this.rendermode_tail = 2;
         } else if (entity.isShield()) {
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = false;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.tail_follow = true;
            this.rendermode_tail = 2;
            this.transparent = true;
         } else if (entity.isExplosion()) {
            this.render_head = false;
            this.render_head_connect = false;
            this.render_middle = false;
            this.render_noise = false;
            this.render_tail = true;
            this.render_tail_connect = false;
            this.scaling_head = false;
            this.scaling_tail = false;
            this.tail_follow = true;
            this.rendermode_tail = 2;
            this.transparent = true;
         }
      }

      this.scale_head = 1.0F * scale_all * (1.0F + this.scale_head_more) * entity.waveScale;
      this.scale_head_connect = 1.0F * scale_all * entity.waveScale;
      this.scale_middle = 1.0F * scale_all * entity.waveScale;
      this.scale_noise = 1.0F * scale_all * entity.waveScale;
      this.scale_tail = 1.0F * scale_all * (1.0F + scale_all * this.scale_tail_more);
      this.scale_tail_connect = 1.0F * scale_all * entity.waveScale;
   }

   public void render_2d(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
      Tessellator tessellator = Tessellator.INSTANCE;
      long time = entity.world.func_82737_E();
      float particleScale = 1.0F;
      float middle_start = 0.4F;
      float middle_max = 10.0F;
      this.glStart();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDepthMask(true);
      GL11.glDisable(2896);
      if (this.transparent) {
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.003921569F);
         GL11.glDepthMask(false);
      }

      float X = 0.0F;
      float Y = 0.0F;
      float Z = 0.0F;
      float position = entity.waveScale;
      position *= position;
      X = (float)(-(entity.posX - sx) * 0.5D) * position;
      Y = (float)(-(entity.posY - sy) * 0.5D) * position;
      Z = (float)(-(entity.posZ - sz) * 0.5D) * position;
      if (X == 0.0F) {
         X = 0.0F;
      }

      if (Y == 0.0F) {
         Y = 0.0F;
      }

      if (Z == 0.0F) {
         Z = 0.0F;
      }

      this.glRotate(entity, par2 + (double)X, par4 + (double)Y, par6 + (double)Z, par9);
      GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
      float particleMiddleWidth = 1.0F;
      float wave_start_size = 1.0F;
      float wave_end_size = 1.0F;
      int texture_id = 0;
      int j;
      float rotationY;
      float correction;
      float size_divider;
      float size_divider;
      float size;
      float rotationX;
      if (this.render_middle) {
         for(j = 0; j < this.detail; ++j) {
            rotationY = 2.32F * particleScale;
            correction = 0.86F;
            float scl = (float)entity.dist;
            int segments = (int)(scl / (rotationY * 0.86F));
            size_divider = (float)segments / 10.0F;
            size_divider = this.scaling_tail ? (size_divider < 5.0F ? 5.0F : size_divider) : 5.0F;
            size = 10.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.001F, 0.0F, 0.001F);
            this.apply_detail_rotation(j);
            float Translate_middle = -1.0F;
            GL11.glTranslatef(0.0F, -1.0F, 0.0F);
            if (this.rotate_middle) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
            }

            for(int k = 0; k < segments + 1; ++k) {
               float size = 1.0F;
               if (this.scaling_tail) {
                  size = (float)k / size_divider + 0.4F;
                  if (size > 10.0F) {
                     size = 10.0F;
                  }

                  particleMiddleWidth = size;
                  if (size > wave_end_size) {
                     wave_end_size = size;
                  }

                  if (k == 0) {
                     wave_start_size = size;
                  }
               }

               if (this.random_texture && entity.animation_random != null) {
                  if (entity.animation_random.size() > k) {
                     texture_id = (Integer)entity.animation_random.get(k);
                  } else {
                     entity.animation_random.add((int)(Math.random() * (double)entity.animation_random_Max));
                  }
               } else {
                  texture_id = entity.animation_id % entity.animation_id_Max;
               }

               FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("middle", texture_id));
               double length = entity.dist;
               if (length > (double)rotationY) {
                  length = (double)rotationY;
               }

               double minus = (double)(-scl / 2.0F + (float)(segments - k) * rotationY * 0.86F);
               float height = 1.0F;
               float height2 = 0.0F;
               if (k == 0) {
                  float scale0 = (float)((double)segments - minus);
                  if (scale0 < 0.0F) {
                     scale0 = 0.0F;
                  }

                  height = scale0;
                  if (scale0 > 1.0F) {
                     height = 1.0F;
                  }

                  minus += (double)(-(1.0F - height));
               }

               JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * particleMiddleWidth * this.scale_middle, 0.0F, particleScale * height, (float)(-minus), this.red2, this.green2, this.blue2, this.alpha);
            }

            if (segments > entity.lastSegments) {
               entity.lastSegments = segments;
            }

            if (segments < entity.lastSegments) {
               float size = 1.0F;
               if (this.scaling_tail) {
                  size = (float)entity.lastSegments / size_divider + 0.4F;
                  if (size > 10.0F) {
                     size = 10.0F;
                  }

                  particleMiddleWidth = size;
                  if (size > wave_end_size) {
                     wave_end_size = size;
                  }
               }
            }

            GL11.glPopMatrix();
         }
      } else if (this.scaling_tail) {
         rotationX = 2.32F * particleScale;
         rotationY = 0.86F;
         correction = (float)entity.dist;
         int segments = (int)(correction / (rotationX * 0.86F));
         float div = (float)segments / 10.0F;
         size_divider = this.scaling_tail ? (div < 5.0F ? 5.0F : div) : 5.0F;
         size_divider = 10.0F;
         size = 0.0F / size_divider + 0.4F;
         if (size > 10.0F) {
            size = 10.0F;
         }

         wave_start_size = size;
         size = (float)segments / size_divider + 0.4F;
         if (size > 10.0F) {
            size = 10.0F;
         }

         if (size > wave_end_size) {
            wave_end_size = size;
         }
      }

      if (this.render_noise) {
         for(j = 0; j < this.detail; ++j) {
            GL11.glPushMatrix();
            if (this.rotate_noise) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
            }

            texture_id = entity.animation_id % entity.animation_id_Max;
            FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("noise", texture_id));
            this.apply_detail_rotation(j);
            JGRenderHelper.draw_tessellator2(tessellator, this.brightness, particleScale * this.scale_noise, 0.0F, (float)(entity.dist / 2.0D), 0.0F, this.red, this.green, this.blue, this.alpha);
            GL11.glPopMatrix();
         }
      }

      boolean view2;
      if (this.render_head) {
         if (!this.head_follow) {
            for(j = 0; j < 2; ++j) {
               GL11.glPushMatrix();
               if (this.rotate_head) {
                  GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
               }

               GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
               texture_id = entity.animation_id % entity.animation_id_Max;
               FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("head", texture_id));
               GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
               GL11.glRotatef((float)(j * 360 / 2), 0.0F, 1.0F, 0.0F);
               JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
               GL11.glPopMatrix();
            }
         } else {
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
            rotationX = entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9;
            GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
            rotationY = entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F;
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
            view2 = JRMCoreClient.mc.gameSettings.thirdPersonView == 2;
            GL11.glRotatef(-this.renderManager.field_78735_i, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-this.renderManager.field_78732_j * (float)(view2 ? -1 : 1), 1.0F, 0.0F, 0.0F);
            texture_id = entity.animation_id % entity.animation_id_Max;
            FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("head", texture_id));
            GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
            if (this.rotate_head) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
            }

            JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
            GL11.glPopMatrix();
         }
      }

      if (this.render_head_connect) {
         for(j = 0; j < this.detail; ++j) {
            GL11.glPushMatrix();
            if (this.rotate_head_connect) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
            }

            GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
            texture_id = entity.animation_id % entity.animation_id_Max;
            FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("head_connect", texture_id));
            this.apply_detail_rotation(j);
            JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head_connect, particleScale, this.red, this.green, this.blue, this.alpha);
            GL11.glPopMatrix();
         }
      }

      if (this.render_tail) {
         if (this.rendermode_tail == 0 && !this.tail_follow || this.rendermode_tail == 2 && !this.tail_follow) {
            for(j = 0; j < 2; ++j) {
               GL11.glPushMatrix();
               if (this.rendermode_tail == 2) {
                  GL11.glTranslated(0.0D, -1.0D, 0.0D);
                  GL11.glTranslated(0.0D, 0.0D, 0.25D);
               }

               if (this.rotate_tail) {
                  GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
               }

               GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
               texture_id = entity.animation_id % entity.animation_id_Max;
               FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("tail", texture_id));
               GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
               GL11.glRotatef((float)(j * 360 / 2), 0.0F, 1.0F, 0.0F);
               JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
               GL11.glPopMatrix();
            }
         } else if ((this.rendermode_tail != 0 || !this.tail_follow) && (this.rendermode_tail != 2 || !this.tail_follow)) {
            if (this.rendermode_tail == 1) {
               for(j = 0; (float)j < scale * 5.0F; ++j) {
                  for(int i = 0; i < 2; ++i) {
                     GL11.glPushMatrix();
                     GL11.glTranslated(0.0D, -1.0D, 0.0D);
                     GL11.glTranslated(0.0D, 0.0D, 0.25D);
                     GL11.glTranslated(0.0D, 0.0D, (double)j * 0.01D);
                     GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
                     if (this.rotate_tail) {
                        GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
                     }

                     texture_id = entity.animation_id % entity.animation_id_Max;
                     FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("tail", texture_id));
                     GL11.glRotatef((float)(i * 360 / 2), 0.0F, 1.0F, 0.0F);
                     JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
                     GL11.glPopMatrix();
                  }
               }
            }
         } else {
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
            if (this.rendermode_tail == 2) {
               GL11.glTranslated(0.0D, -1.0D, 0.0D);
               GL11.glTranslated(0.0D, 0.0D, 0.25D);
            }

            rotationX = entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9;
            GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
            rotationY = entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F;
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
            view2 = JRMCoreClient.mc.gameSettings.thirdPersonView == 2;
            GL11.glRotatef(-this.renderManager.field_78735_i, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-this.renderManager.field_78732_j * (float)(view2 ? -1 : 1), 1.0F, 0.0F, 0.0F);
            texture_id = entity.animation_id % entity.animation_id_Max;
            FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("tail", texture_id));
            GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
            if (this.rotate_tail) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
            }

            JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
            GL11.glPopMatrix();
         }
      }

      if (this.render_tail_connect) {
         for(j = 0; j < this.detail; ++j) {
            GL11.glPushMatrix();
            if (this.rendermode_tail == 2) {
               GL11.glTranslated(0.0D, -1.0D, 0.0D);
               GL11.glTranslated(0.0D, 0.0D, 0.25D);
            }

            if (this.rotate_tail_connect) {
               GL11.glRotatef((float)time % (360.0F / this.rotationSpeed) * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
            }

            GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
            texture_id = entity.animation_id % entity.animation_id_Max;
            FMLClientHandler.instance().getClient().field_71446_o.bindTexture(this.set_resource("tail_connect", texture_id));
            this.apply_detail_rotation(j);
            JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail_connect, particleScale * (this.rendermode_tail == 2 ? this.scale_tail_connect : 1.0F), this.red, this.green, this.blue, this.alpha);
            GL11.glPopMatrix();
         }
      }

      if (this.transparent) {
         GL11.glDisable(3042);
         GL11.glDepthMask(true);
      }

      GL11.glEnable(2896);
      this.glEnd();
   }

   public void render_3d(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
      this.shadowSize = 0.0F;
      int shrink = entity.getShrink();
      byte type = entity.getType();
      byte perc = entity.getPerc();
      int dam = entity.getDam();
      byte[] sts = entity.getSts();
      byte den = entity.getDen();
      float var13 = this.handleRotationFloat(entity, par9);
      double x = sx - entity.posX;
      double y = sy - entity.posY;
      double z = sz - entity.posZ;
      if (shrink > 0) {
         this.updateEffect2(entity);
      } else {
         entity.dist = (double)MathHelper.func_76133_a(x * x + y * y + z * z);
         entity.finalDist = entity.dist;
      }

      float size = entity.getSize() * ((float)JGConfigClientSettings.CLIENT_Ki_Scale / 10.0F);
      boolean dual_color = JGConfigClientSettings.CLIENT_DA9;
      if (type == 1 || type == 5 || type == 6) {
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(size, size, size);
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

      if (type == 7 || type == 8) {
         GL11.glPushMatrix();
         float szaz = 120.0F;
         float egy = szaz / 100.0F;
         float offtr = (float)entity.ticksExisted / egy / 100.0F;
         offtr = 1.0F - offtr;
         offtr /= 10.0F;
         GL11.glEnable(3042);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.003921569F);
         GL11.glDepthMask(false);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         float alph = type == 7 ? 0.05F : offtr;
         JGRenderHelper.tex(this.renderManager, color, alph);
         GL11.glScalef(size, size, size);
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13 / 2.0F, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color, alph);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13 / 2.0F, false);
         }

         GL11.glDisable(3042);
         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

      if (type == 2) {
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(size, size, size);
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

      if (type == 3) {
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(1.0F, 1.0F, 1.0F);
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

      if (type == 4) {
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, JRMCoreH.techCol[4], this.alpha);
         GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel((byte)0, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel((byte)0, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

      if (type == 0) {
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(size, size, size);
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
         GL11.glPushMatrix();
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glRotatef(entity.field_70126_B + (entity.rotationYaw - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entity.field_70127_C + (entity.rotationPitch - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
         JGRenderHelper.tex(this.renderManager, color, this.alpha);
         GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
         if (dual_color) {
            GL11.glDepthMask(false);
         }

         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         if (dual_color) {
            JGRenderHelper.tex(this.renderManager, color2, this.alpha);
            GL11.glScalef(0.8F, 0.8F, 0.8F);
            this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
         }

         GL11.glEnable(2896);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         if (dual_color) {
            GL11.glDepthMask(true);
         }

         GL11.glPopMatrix();
      }

   }
}
