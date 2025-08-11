package JinRyuu.DragonBC.common.Npcs;

import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelDragon extends ModelBase {
   public ModelRenderer bodyM;
   public ModelRenderer HeadM;
   public ModelRenderer[] body1;
   public ModelRenderer[] body2;
   public ModelRenderer[] body3;
   public ModelRenderer Head1;
   public ModelRenderer HeadSnout;
   public ModelRenderer HeadM2;
   public ModelRenderer body4;
   public ModelRenderer body5;
   public ModelRenderer hornLB;
   public ModelRenderer hornRB;
   public ModelRenderer hornL;
   public ModelRenderer hornL1;
   public ModelRenderer hornL2;
   public ModelRenderer hornR;
   public ModelRenderer hornR1;
   public ModelRenderer hornR2;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR1;
   public ModelRenderer FingerR1;
   public ModelRenderer FingerR2;
   public ModelRenderer FingerR3;
   public ModelRenderer FingerR0;
   public ModelRenderer ArmL1;
   public ModelRenderer FingerL1;
   public ModelRenderer FingerL2;
   public ModelRenderer FingerL3;
   public ModelRenderer FingerL0;
   public ModelRenderer[] whiskR;
   public ModelRenderer[] whiskL;
   ArrayList<ModelRenderer> models = new ArrayList();
   ArrayList<ModelRenderer> wiskerr = new ArrayList();
   ArrayList<ModelRenderer> wiskerl = new ArrayList();

   public ModelDragon() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.HeadM = new ModelRenderer(this, 40, 0);
      this.HeadM.func_78793_a(0.0F, 0.0F, 0.0F);
      this.HeadM.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 7, 10, 0.0F);
      this.setRotate(this.HeadM, -1.54F, 0.0F, 0.0F);
      this.HeadSnout = new ModelRenderer(this, 80, 0);
      this.HeadSnout.func_78793_a(0.0F, 0.0F, -10.0F);
      this.HeadSnout.func_78790_a(-4.0F, -1.0F, -12.0F, 8, 3, 12, 0.0F);
      this.Head1 = new ModelRenderer(this, 40, 17);
      this.Head1.func_78793_a(0.0F, 4.0F, -8.0F);
      this.Head1.func_78790_a(-4.0F, -2.0F, -14.0F, 8, 3, 16, 0.0F);
      this.HeadM2 = new ModelRenderer(this, 74, 15);
      this.HeadM2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.HeadM2.func_78790_a(-5.0F, 2.0F, -6.0F, 10, 3, 6, 0.0F);
      this.bodyM = new ModelRenderer(this, 0, 0);
      this.bodyM.func_78793_a(0.0F, -80.0F, 0.0F);
      this.bodyM.func_78790_a(0.0F, 0.0F, 5.0F, 0, 0, 0, 0.0F);
      this.whiskL = new ModelRenderer[8];
      this.whiskR = new ModelRenderer[8];

      int i;
      for(i = 0; i < this.whiskL.length; ++i) {
         this.whiskL[i] = new ModelRenderer(this, 40, 17);
         this.whiskL[i].func_78793_a(3.8F, i == 0 ? 0.5F : 0.0F, i == 0 ? -10.0F : 0.0F);
         this.whiskL[i].func_78790_a(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
         if (i > 0 && i < this.whiskL.length) {
            this.whiskL[i - 1].func_78792_a(this.whiskL[i]);
         }

         this.wiskerl.add(this.whiskL[i]);
      }

      for(i = 0; i < this.whiskR.length; ++i) {
         this.whiskR[i] = new ModelRenderer(this, 40, 17);
         this.whiskR[i].func_78793_a(-3.8F, i == 0 ? -0.5F : 0.0F, i == 0 ? -10.0F : 0.0F);
         this.whiskR[i].func_78790_a(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
         if (i > 0 && i < this.whiskR.length) {
            this.whiskR[i - 1].func_78792_a(this.whiskR[i]);
         }

         this.wiskerr.add(this.whiskR[i]);
      }

      this.hornL2 = new ModelRenderer(this, 0, 0);
      this.hornL2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.hornL2.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
      this.setRotate(this.hornL2, 0.68294734F, 0.0F, 0.0F);
      this.FingerR1 = new ModelRenderer(this, 0, 84);
      this.FingerR1.func_78793_a(-15.0F, -1.6F, -0.5F);
      this.FingerR1.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerR1, 0.0F, -0.59184116F, 0.5009095F);
      this.hornLB = new ModelRenderer(this, 40, 23);
      this.hornLB.func_78793_a(2.5F, -3.5F, -4.0F);
      this.hornLB.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotate(this.hornLB, -0.8196066F, 0.27314404F, 0.0F);
      this.FingerR3 = new ModelRenderer(this, 0, 84);
      this.FingerR3.func_78793_a(-14.0F, 1.5F, -0.5F);
      this.FingerR3.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerR3, 0.0F, -0.59184116F, -0.8196066F);
      this.FingerL1 = new ModelRenderer(this, 0, 84);
      this.FingerL1.field_78809_i = true;
      this.FingerL1.func_78793_a(15.0F, -1.6F, -0.5F);
      this.FingerL1.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerL1, 0.0F, 0.57595867F, -0.5009095F);
      this.ArmR1 = new ModelRenderer(this, 0, 76);
      this.ArmR1.func_78793_a(-14.0F, 0.0F, 0.0F);
      this.ArmR1.func_78790_a(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
      this.setRotate(this.ArmR1, 0.0F, -1.0471976F, 0.0F);
      this.hornR = new ModelRenderer(this, 106, 15);
      this.hornR.func_78793_a(0.0F, -6.0F, 0.0F);
      this.hornR.func_78790_a(-1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F);
      this.FingerL2 = new ModelRenderer(this, 0, 84);
      this.FingerL2.field_78809_i = true;
      this.FingerL2.func_78793_a(15.0F, 0.5F, -0.5F);
      this.FingerL2.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerL2, 0.0F, 0.59184116F, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 0, 76);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(14.0F, 0.0F, 0.0F);
      this.ArmL1.func_78790_a(0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
      this.setRotate(this.ArmL1, 0.0F, 1.0016445F, 0.0F);
      this.hornRB = new ModelRenderer(this, 40, 23);
      this.hornRB.func_78793_a(-2.5F, -3.5F, -4.0F);
      this.hornRB.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotate(this.hornRB, -0.8196066F, -0.27314404F, 0.0F);
      this.hornL1 = new ModelRenderer(this, 0, 0);
      this.hornL1.func_78793_a(0.0F, -4.0F, 0.0F);
      this.hornL1.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
      this.setRotate(this.hornL1, -0.63739425F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 0, 68);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.0F, 12.0F, 0.0F);
      this.ArmL.func_78790_a(-0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
      this.FingerL3 = new ModelRenderer(this, 0, 84);
      this.FingerL3.field_78809_i = true;
      this.FingerL3.func_78793_a(14.0F, 1.6F, -0.5F);
      this.FingerL3.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerL3, 0.0F, 0.59184116F, 0.5009095F);
      this.FingerR2 = new ModelRenderer(this, 0, 84);
      this.FingerR2.func_78793_a(-15.0F, 0.5F, -0.5F);
      this.FingerR2.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerR2, 0.0F, -0.59184116F, 0.0F);
      this.hornL = new ModelRenderer(this, 106, 15);
      this.hornL.func_78793_a(0.0F, -6.0F, 0.0F);
      this.hornL.func_78790_a(-1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F);
      this.hornR2 = new ModelRenderer(this, 0, 0);
      this.hornR2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.hornR2.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
      this.setRotate(this.hornR2, 0.68294734F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 0, 68);
      this.ArmR.func_78793_a(-4.0F, 12.0F, 0.0F);
      this.ArmR.func_78790_a(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
      this.FingerL0 = new ModelRenderer(this, 0, 84);
      this.FingerL0.field_78809_i = true;
      this.FingerL0.func_78793_a(13.0F, -1.0F, -0.5F);
      this.FingerL0.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerL0, 0.0F, 0.59184116F, -1.548107F);
      this.hornR1 = new ModelRenderer(this, 0, 0);
      this.hornR1.func_78793_a(0.0F, -4.0F, 0.0F);
      this.hornR1.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
      this.setRotate(this.hornR1, -0.63739425F, 0.0F, 0.0F);
      this.FingerR0 = new ModelRenderer(this, 0, 84);
      this.FingerR0.func_78793_a(-13.0F, -1.0F, -0.5F);
      this.FingerR0.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
      this.setRotate(this.FingerR0, 0.0F, -0.59184116F, 1.548107F);
      this.HeadM.func_78792_a(this.hornLB);
      this.HeadM.func_78792_a(this.hornRB);
      this.hornL.func_78792_a(this.hornL2);
      this.hornRB.func_78792_a(this.hornR);
      this.hornL.func_78792_a(this.hornL1);
      this.hornLB.func_78792_a(this.hornL);
      this.hornR.func_78792_a(this.hornR2);
      this.hornR.func_78792_a(this.hornR1);
      this.ArmR1.func_78792_a(this.FingerR0);
      this.ArmL1.func_78792_a(this.FingerL0);
      this.ArmL1.func_78792_a(this.FingerL3);
      this.ArmR1.func_78792_a(this.FingerR2);
      this.ArmL1.func_78792_a(this.FingerL2);
      this.ArmR1.func_78792_a(this.FingerR1);
      this.ArmR1.func_78792_a(this.FingerR3);
      this.ArmL1.func_78792_a(this.FingerL1);
      this.ArmL.func_78792_a(this.ArmL1);
      this.ArmR.func_78792_a(this.ArmR1);
      this.body1 = new ModelRenderer[12];
      this.body2 = new ModelRenderer[8];
      this.body3 = new ModelRenderer[4];

      for(i = 0; i < this.body1.length; ++i) {
         this.body1[i] = new ModelRenderer(this, 0, 34);
         this.body1[i].func_78793_a(0.0F, i == 0 ? 0.0F : 23.0F, 0.0F);
         this.body1[i].func_78790_a(-5.0F, 0.0F, -5.0F, 10, 24, 10, 0.0F);
         if (i > 0 && i < this.body1.length) {
            this.body1[i - 1].func_78792_a(this.body1[i]);
         }

         this.models.add(this.body1[i]);
      }

      for(i = 0; i < this.body2.length; ++i) {
         this.body2[i] = new ModelRenderer(this, 40, 36);
         this.body2[i].func_78793_a(0.0F, i == 0 ? 23.0F : 17.0F, 0.0F);
         this.body2[i].func_78790_a(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F);
         if (i > 0 && i < this.body2.length) {
            this.body2[i - 1].func_78792_a(this.body2[i]);
         }

         this.models.add(this.body2[i]);
      }

      for(i = 0; i < this.body3.length; ++i) {
         this.body3[i] = new ModelRenderer(this, 72, 36);
         this.body3[i].func_78793_a(0.0F, i == 0 ? 16.0F : 15.0F, 0.0F);
         this.body3[i].func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
         if (i > 0 && i < this.body3.length) {
            this.body3[i - 1].func_78792_a(this.body3[i]);
         }

         this.models.add(this.body3[i]);
      }

      this.body4 = new ModelRenderer(this, 96, 36);
      this.body4.func_78793_a(0.0F, 15.0F, 0.0F);
      this.body4.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.body5 = new ModelRenderer(this, 112, 36);
      this.body5.func_78793_a(0.0F, 13.0F, 0.0F);
      this.body5.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
      this.models.add(this.body4);
      this.models.add(this.body5);
      this.bodyM.func_78792_a(this.body1[0]);
      this.body1[this.body1.length - 1].func_78792_a(this.body2[0]);
      this.body2[this.body2.length - 1].func_78792_a(this.body3[0]);
      this.body3[this.body3.length - 1].func_78792_a(this.body4);
      this.body4.func_78792_a(this.body5);
      this.HeadSnout.func_78792_a(this.whiskL[0]);
      this.HeadSnout.func_78792_a(this.whiskR[0]);
      this.bodyM.func_78792_a(this.HeadM);
      this.HeadM.func_78792_a(this.Head1);
      this.HeadM.func_78792_a(this.HeadSnout);
      this.HeadM.func_78792_a(this.HeadM2);
      this.body1[1].func_78792_a(this.ArmL);
      this.body1[1].func_78792_a(this.ArmR);
      this.body1[11].func_78792_a(this.ArmL);
      this.body1[11].func_78792_a(this.ArmR);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      this.bodyM.render(f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
   }

   public void setRotate(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }

   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      this.HeadM.rotateAngleY = par4 / 57.295776F;
      this.HeadM.rotateAngleX = par5 / 57.295776F * 1.2F;
      float r = MathHelper.func_76126_a(par3 * 0.02F) * 0.1F;
      float r2 = MathHelper.func_76134_b(par3 * 0.02F) * 0.1F;
      float r3 = MathHelper.func_76134_b(par3 * 0.14F) * 0.1F;
      this.ArmL.rotateAngleY = 0.3F + r2 * 2.0F;
      this.ArmR.rotateAngleY = -0.3F - r2 * 2.0F;
      this.ArmL1.rotateAngleY = 0.6F + r2 * 2.0F;
      this.ArmR1.rotateAngleY = -0.6F - r2 * 2.0F;
      this.body4.rotateAngleY = 0.0F;
      this.body4.rotateAngleX = 0.0F;
      this.body5.rotateAngleY = 0.0F;
      this.body5.rotateAngleX = 0.0F;

      int i;
      ModelRenderer o;
      for(i = 0; i < this.wiskerr.size(); ++i) {
         o = (ModelRenderer)this.wiskerr.get(i);
         if (o != null) {
            if (i != 0 && i != 1) {
               if (i != 2 && i != 3) {
                  if (i != 4 && i != 5 && i != 6) {
                     if (i != 7 && i != 8) {
                        o.rotateAngleZ = -0.0F;
                        o.rotateAngleX = -0.0F;
                        o.rotateAngleY = -0.0F;
                     } else {
                        o.rotateAngleZ = -0.75F - r * 1.05F;
                        o.rotateAngleX = -0.2F - r2 * 0.5F;
                     }
                  } else {
                     o.rotateAngleZ = 0.2F + 0.1F * (float)i - r * 1.05F;
                     o.rotateAngleX = -0.3F + 0.1F * (float)i - r * 0.5F;
                  }
               } else {
                  o.rotateAngleZ = -0.45F + r2 * 1.05F;
                  o.rotateAngleX = -0.3F + r * 0.5F;
               }
            } else {
               o.rotateAngleZ = 0.2F - r2 * 1.05F;
               o.rotateAngleX = -0.0F + r * 0.75F;
            }
         }
      }

      for(i = 0; i < this.wiskerl.size(); ++i) {
         o = (ModelRenderer)this.wiskerl.get(i);
         if (o != null) {
            if (i != 0 && i != 1) {
               if (i != 2 && i != 3) {
                  if (i != 4 && i != 5 && i != 6) {
                     if (i != 7 && i != 8) {
                        o.rotateAngleZ = -0.0F;
                        o.rotateAngleX = -0.0F;
                        o.rotateAngleY = -0.0F;
                     } else {
                        o.rotateAngleZ = 0.75F + r2 * 1.05F;
                        o.rotateAngleX = -0.2F - r * 0.75F;
                     }
                  } else {
                     o.rotateAngleZ = -0.2F - 0.1F * (float)i + r * 1.05F;
                     o.rotateAngleX = -0.3F + 0.1F * (float)i - r2 * 0.75F;
                  }
               } else {
                  o.rotateAngleZ = 0.45F - r * 1.05F;
                  o.rotateAngleX = -0.3F + r2 * 0.75F;
               }
            } else {
               o.rotateAngleZ = -0.2F - r2 * 1.05F;
               o.rotateAngleX = -0.0F + r * 0.75F;
            }
         }
      }

      this.Head1.rotateAngleZ = -0.0F;
      this.Head1.rotateAngleX = 0.15F + r2 * 0.5F;
      this.bodyM.rotationPointY = -200.0F + r * 40.0F;

      for(i = 0; i < this.models.size(); ++i) {
         if (i == 0) {
            o = (ModelRenderer)this.models.get(i);
            o.rotateAngleZ = 0.0F;
            o.rotateAngleX = 2.0F;
         } else if (i != 1 && i != 2 && i != 3) {
            if (i != 4 && i != 5 && i != 6) {
               if (i != 7 && i != 8 && i != 9) {
                  if (i != 10 && i != 11 && i != 12) {
                     if (i != 13 && i != 14 && i != 15) {
                        if (i != 16 && i != 17 && i != 18) {
                           if (i != 19 && i != 20 && i != 21) {
                              if (i != 22 && i != 23) {
                                 if (i != 24 && i != 25) {
                                    o = (ModelRenderer)this.models.get(i);
                                    o.rotateAngleZ = -0.0F;
                                    o.rotateAngleX = -0.0F;
                                    o.rotateAngleY = -0.0F;
                                 } else {
                                    o = (ModelRenderer)this.models.get(i);
                                    o.rotateAngleZ = -0.2F + r * 0.75F;
                                    o.rotateAngleX = 0.1F;
                                 }
                              } else {
                                 o = (ModelRenderer)this.models.get(i);
                                 o.rotateAngleZ = 1.0F - r * 0.75F;
                                 o.rotateAngleX = 0.5F;
                              }
                           } else {
                              o = (ModelRenderer)this.models.get(i);
                              o.rotateAngleZ = -0.5F + r * 0.75F;
                              o.rotateAngleX = -0.75F;
                           }
                        } else {
                           o = (ModelRenderer)this.models.get(i);
                           o.rotateAngleZ = 0.75F - r * 0.75F;
                           o.rotateAngleX = -0.5F;
                        }
                     } else {
                        o = (ModelRenderer)this.models.get(i);
                        o.rotateAngleZ = 0.5F + r * 0.75F;
                        o.rotateAngleX = 0.75F;
                     }
                  } else {
                     o = (ModelRenderer)this.models.get(i);
                     o.rotateAngleZ = -0.5F - r * 0.75F;
                     o.rotateAngleX = -0.25F;
                  }
               } else {
                  o = (ModelRenderer)this.models.get(i);
                  o.rotateAngleZ = -0.75F + r * 0.75F;
                  o.rotateAngleX = -0.3F;
               }
            } else {
               o = (ModelRenderer)this.models.get(i);
               o.rotateAngleZ = 0.9F - r * 0.75F;
               o.rotateAngleX = -0.7F;
            }
         } else {
            o = (ModelRenderer)this.models.get(i);
            o.rotateAngleZ = -0.9F + r * 0.75F;
            o.rotateAngleX = -0.5F;
         }
      }

   }
}
