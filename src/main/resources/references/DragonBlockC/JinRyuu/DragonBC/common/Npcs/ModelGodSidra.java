package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelGodSidra extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer earL;
   public ModelRenderer earR;
   public ModelRenderer Hair1;
   public ModelRenderer Nose;
   public ModelRenderer Beard1;
   public ModelRenderer Hair2;
   public ModelRenderer Beard2;
   public ModelRenderer Beard3;
   public ModelRenderer Body2;
   public ModelRenderer Cloth1;
   public ModelRenderer Body3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmRingR1;
   public ModelRenderer ArmRingR2;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmRingL1;
   public ModelRenderer ArmRingL2;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelGodSidra() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.LegR2 = new ModelRenderer(this, 0, 37);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-3.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 90, 38);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-2.8F, 4.7F, -2.0F, 4, 8, 4, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 90, 38);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.2F, 4.7F, -2.0F, 4, 8, 4, 0.0F);
      this.ArmRingL1 = new ModelRenderer(this, 88, 51);
      this.ArmRingL1.field_78809_i = true;
      this.ArmRingL1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingL1.func_78790_a(-1.4F, 8.3F, -2.5F, 5, 1, 5, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -5.9F, -4.6F, 8, 6, 8, -0.1F);
      this.LegL2 = new ModelRenderer(this, 0, 37);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
      this.ArmRingL2 = new ModelRenderer(this, 88, 51);
      this.ArmRingL2.field_78809_i = true;
      this.ArmRingL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingL2.func_78790_a(0.1F, 9.4F, -2.5F, 5, 1, 5, 0.0F);
      this.setRotateAngle(this.ArmRingL2, 0.0F, 0.0F, 0.15009831F);
      this.Hair2 = new ModelRenderer(this, 91, 16);
      this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair2.func_78790_a(-3.0F, -3.0F, 4.6F, 6, 9, 1, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 91, 28);
      this.ArmR1.func_78793_a(-6.5F, 1.6F, -0.5F);
      this.ArmR1.func_78790_a(-2.1F, -1.4F, -1.5F, 3, 6, 3, 0.2F);
      this.earL = new ModelRenderer(this, 1, 1);
      this.earL.field_78809_i = true;
      this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earL.func_78790_a(1.0F, -6.1F, -1.5F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.earL, -0.12217305F, -0.13613568F, 0.5462881F);
      this.earR = new ModelRenderer(this, 1, 1);
      this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earR.func_78790_a(-3.0F, -6.1F, -1.5F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.earR, -0.12217305F, 0.13613568F, -0.5462881F);
      this.Body2 = new ModelRenderer(this, 37, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-6.0F, 5.0F, -4.7F, 12, 5, 9, 0.0F);
      this.Beard2 = new ModelRenderer(this, 5, 27);
      this.Beard2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Beard2.func_78790_a(-3.0F, 1.4F, -5.3F, 6, 1, 1, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 53);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.1F, 6.0F, -2.6F, 5, 6, 5, 0.0F);
      this.Hair1 = new ModelRenderer(this, 89, 1);
      this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair1.func_78790_a(-4.0F, -3.8F, 2.7F, 8, 12, 2, 0.0F);
      this.Body1 = new ModelRenderer(this, 38, 14);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-5.5F, 0.0F, -4.0F, 11, 5, 8, 0.0F);
      this.Nose = new ModelRenderer(this, 25, 4);
      this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Nose.func_78790_a(-1.0F, -3.0F, -5.9F, 2, 1, 2, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 91, 28);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(6.5F, 1.6F, -0.5F);
      this.ArmL1.func_78790_a(-0.9F, -1.4F, -1.5F, 3, 6, 3, 0.2F);
      this.ArmRingR1 = new ModelRenderer(this, 88, 51);
      this.ArmRingR1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingR1.func_78790_a(-3.5F, 8.3F, -2.5F, 5, 1, 5, 0.0F);
      this.Body3 = new ModelRenderer(this, 39, 44);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.5F, 9.1F, -4.1F, 11, 3, 8, 0.0F);
      this.Cloth1 = new ModelRenderer(this, 54, 0);
      this.Cloth1.func_78793_a(0.0F, 10.0F, -4.2F);
      this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.2F, 5, 10, 0, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.04363323F, 0.0F, 0.0F);
      this.ArmRingR2 = new ModelRenderer(this, 88, 51);
      this.ArmRingR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingR2.func_78790_a(-4.9F, 9.4F, -2.5F, 5, 1, 5, 0.0F);
      this.setRotateAngle(this.ArmRingR2, 0.0F, 0.0F, -0.15009831F);
      this.LegR = new ModelRenderer(this, 0, 53);
      this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.9F, 6.0F, -2.5F, 5, 6, 5, 0.0F);
      this.Beard1 = new ModelRenderer(this, 4, 20);
      this.Beard1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Beard1.func_78790_a(-4.0F, -1.5F, -5.3F, 8, 3, 2, 0.0F);
      this.Beard3 = new ModelRenderer(this, 5, 15);
      this.Beard3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Beard3.func_78790_a(-3.0F, -2.2F, -5.6F, 6, 2, 2, 0.0F);
      this.LegR.func_78792_a(this.LegR2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.ArmL2.func_78792_a(this.ArmRingL1);
      this.LegL.func_78792_a(this.LegL2);
      this.ArmRingL1.func_78792_a(this.ArmRingL2);
      this.Hair1.func_78792_a(this.Hair2);
      this.Head.func_78792_a(this.earL);
      this.Head.func_78792_a(this.earR);
      this.Body1.func_78792_a(this.Body2);
      this.Beard1.func_78792_a(this.Beard2);
      this.Head.func_78792_a(this.Hair1);
      this.Head.func_78792_a(this.Nose);
      this.ArmR2.func_78792_a(this.ArmRingR1);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Cloth1);
      this.ArmRingR1.func_78792_a(this.ArmRingR2);
      this.Head.func_78792_a(this.Beard1);
      this.Beard1.func_78792_a(this.Beard3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 0.8F;
      JGRenderHelper.modelScalePositionHelper(0.8F);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL1.func_78785_a(f5);
      this.ArmR1.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      GL11.glPopMatrix();
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }

   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      int calc = par7Entity.field_70173_aa;
      if (calc > 100) {
         calc -= 100;
      }

      float r = 360.0F;
      float r2 = 180.0F;
      this.Head.field_78796_g = par4 / (r2 / 3.1415927F);
      this.Head.field_78795_f = par5 / (r2 / 3.1415927F);
      float ex = (float)par7Entity.field_70173_aa;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR1.field_78796_g = 0.0F;
      this.ArmL1.field_78796_g = 0.0F;
      this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
