package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelGodIwan extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hat;
   public ModelRenderer earL;
   public ModelRenderer earR;
   public ModelRenderer BeardNeck;
   public ModelRenderer Body2;
   public ModelRenderer Cloth1;
   public ModelRenderer Body3;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelGodIwan() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body2 = new ModelRenderer(this, 37, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-6.0F, 5.0F, -4.7F, 12, 5, 9, 0.0F);
      this.Body1 = new ModelRenderer(this, 38, 14);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-5.5F, 0.0F, -4.0F, 11, 5, 8, 0.0F);
      this.earL = new ModelRenderer(this, 1, 1);
      this.earL.field_78809_i = true;
      this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earL.func_78790_a(1.1F, -7.5F, -0.5F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.earL, 0.0F, -0.13613568F, 0.5462881F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.5F, -5.1F, -4.6F, 9, 5, 8, 0.0F);
      this.Hat = new ModelRenderer(this, 37, 4);
      this.Hat.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hat.func_78790_a(-2.5F, -7.9F, -2.4F, 5, 3, 5, 0.0F);
      this.Cloth1 = new ModelRenderer(this, 83, 24);
      this.Cloth1.func_78793_a(0.0F, 9.9F, -4.5F);
      this.Cloth1.func_78790_a(-3.5F, 0.0F, -0.1F, 7, 11, 0, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.057595864F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 39, 44);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.5F, 9.1F, -4.1F, 11, 3, 8, 0.0F);
      this.LegR2 = new ModelRenderer(this, 0, 37);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-3.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
      this.earR = new ModelRenderer(this, 1, 1);
      this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earR.func_78790_a(-3.1F, -7.5F, -0.5F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.earR, 0.0F, 0.13613568F, -0.5462881F);
      this.ArmL = new ModelRenderer(this, 70, 5);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.4F, 1.7F, -0.2F);
      this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 4, 11, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 70, 5);
      this.ArmR.func_78793_a(-6.4F, 1.7F, -0.2F);
      this.ArmR.func_78790_a(-3.1F, -1.7F, -1.8F, 4, 11, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 53);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.1F, 6.0F, -2.6F, 5, 6, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 53);
      this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.9F, 6.0F, -2.5F, 5, 6, 5, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 37);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
      this.BeardNeck = new ModelRenderer(this, 6, 20);
      this.BeardNeck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BeardNeck.func_78790_a(-4.5F, -0.1F, -5.3F, 9, 5, 3, 0.0F);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.earL);
      this.Head.func_78792_a(this.Hat);
      this.Body1.func_78792_a(this.Cloth1);
      this.Body2.func_78792_a(this.Body3);
      this.LegR.func_78792_a(this.LegR2);
      this.Head.func_78792_a(this.earR);
      this.LegL.func_78792_a(this.LegL2);
      this.Head.func_78792_a(this.BeardNeck);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 0.65F;
      JGRenderHelper.modelScalePositionHelper(0.65F);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
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
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
