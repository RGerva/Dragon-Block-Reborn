package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGanos2 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Hair1;
   public ModelRenderer Beak1;
   public ModelRenderer Hat2;
   public ModelRenderer Hair2;
   public ModelRenderer Beak2;
   public ModelRenderer Beak3;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer Chest;
   public ModelRenderer FeathersR;
   public ModelRenderer FeathersL;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelGanos2() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Hair2 = new ModelRenderer(this, 96, 32);
      this.Hair2.field_78809_i = true;
      this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair2.func_78790_a(-6.0F, -3.8F, -0.1F, 12, 10, 0, 0.0F);
      this.Beak1 = new ModelRenderer(this, 33, 8);
      this.Beak1.func_78793_a(0.0F, -3.4F, -3.4F);
      this.Beak1.func_78790_a(-2.5F, 0.9F, -1.9F, 5, 2, 2, 0.0F);
      this.LegL2 = new ModelRenderer(this, 66, 42);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.5F, 7.0F, -2.0F, 5, 9, 6, 0.0F);
      this.FeathersL = new ModelRenderer(this, 72, 21);
      this.FeathersL.func_78793_a(3.3F, 4.6F, 2.2F);
      this.FeathersL.func_78790_a(0.0F, -4.8F, -0.3F, 0, 7, 5, 0.0F);
      this.setRotateAngle(this.FeathersL, 0.0F, 0.6981317F, 0.0F);
      this.LegL = new ModelRenderer(this, 41, 42);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.0F, 8.0F, 0.0F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 6, 0.0F);
      this.LegR2 = new ModelRenderer(this, 66, 42);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.5F, 7.0F, -2.0F, 5, 9, 6, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -6.7F, 0.0F);
      this.Body1.func_78790_a(-6.0F, 0.0F, -3.3F, 12, 8, 7, 0.0F);
      this.Beak2 = new ModelRenderer(this, 48, 8);
      this.Beak2.func_78793_a(0.0F, 0.9F, -1.1F);
      this.Beak2.func_78790_a(-2.0F, -1.1F, -2.4F, 4, 3, 4, 0.0F);
      this.Chest = new ModelRenderer(this, 40, 26);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-5.5F, 0.9F, -4.1F, 11, 5, 1, 0.0F);
      this.FeathersR = new ModelRenderer(this, 72, 21);
      this.FeathersR.func_78793_a(-3.5F, 4.6F, 2.2F);
      this.FeathersR.func_78790_a(0.0F, -4.8F, -0.3F, 0, 7, 5, 0.0F);
      this.setRotateAngle(this.FeathersR, 0.0F, -0.6981317F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 48);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.5F, 10.7F, -3.0F, 11, 4, 6, 0.0F);
      this.ArmR = new ModelRenderer(this, 72, 3);
      this.ArmR.func_78793_a(-6.0F, -5.0F, 0.0F);
      this.ArmR.func_78790_a(-5.0F, -2.0F, -3.0F, 5, 16, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 41, 42);
      this.LegR.func_78793_a(-3.0F, 8.0F, 0.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 6, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-5.0F, 6.8F, -3.1F, 10, 4, 6, 0.0F);
      this.Hat2 = new ModelRenderer(this, 41, 16);
      this.Hat2.func_78793_a(0.0F, -6.3F, -0.5F);
      this.Hat2.func_78790_a(-3.5F, -1.0F, -3.0F, 7, 1, 7, 0.0F);
      this.setRotateAngle(this.Hat2, 0.14014994F, 0.0F, 0.0F);
      this.Beak3 = new ModelRenderer(this, 48, 1);
      this.Beak3.func_78793_a(0.0F, 0.1F, 0.0F);
      this.Beak3.func_78790_a(-1.0F, -1.6F, -1.7F, 2, 2, 4, 0.0F);
      this.setRotateAngle(this.Beak3, 0.4098033F, 0.0F, 0.0F);
      this.Hair1 = new ModelRenderer(this, 96, 2);
      this.Hair1.func_78793_a(0.0F, -4.2F, 3.6F);
      this.Hair1.func_78790_a(-7.5F, -7.3F, 0.0F, 15, 26, 0, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -6.5F, 0.3F);
      this.Head.func_78790_a(-4.0F, -7.0F, -3.5F, 8, 7, 7, -0.2F);
      this.ArmL = new ModelRenderer(this, 72, 3);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.0F, -5.0F, 0.0F);
      this.ArmL.func_78790_a(0.0F, -2.0F, -3.0F, 5, 16, 5, 0.0F);
      this.Hair1.func_78792_a(this.Hair2);
      this.Head.func_78792_a(this.Beak1);
      this.LegL.func_78792_a(this.LegL2);
      this.ArmL.func_78792_a(this.FeathersL);
      this.LegR.func_78792_a(this.LegR2);
      this.Beak1.func_78792_a(this.Beak2);
      this.Body2.func_78792_a(this.Chest);
      this.ArmR.func_78792_a(this.FeathersR);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.Hat2);
      this.Beak2.func_78792_a(this.Beak3);
      this.Head.func_78792_a(this.Hair1);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Body1.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
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
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
