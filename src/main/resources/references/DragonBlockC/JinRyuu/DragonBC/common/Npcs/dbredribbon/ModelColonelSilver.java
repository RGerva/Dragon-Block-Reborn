package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelColonelSilver extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hair;
   public ModelRenderer Head2;
   public ModelRenderer Hair2;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer Hair5;
   public ModelRenderer shape28;
   public ModelRenderer Ribbon;

   public ModelColonelSilver() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Hair5 = new ModelRenderer(this, 17, 56);
      this.Hair5.func_78793_a(4.1F, -6.8F, -1.2F);
      this.Hair5.func_78790_a(-1.4F, -2.8F, -1.9F, 2, 3, 4, 0.0F);
      this.setRotateAngle(this.Hair5, -0.045553092F, 0.091106184F, -0.3642502F);
      this.Hair = new ModelRenderer(this, 0, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair2 = new ModelRenderer(this, 52, 55);
      this.Hair2.func_78793_a(-3.0F, -5.8F, -0.6F);
      this.Hair2.func_78790_a(-1.4F, -3.8F, -3.3F, 2, 4, 4, 0.0F);
      this.setRotateAngle(this.Hair2, 0.024085544F, 0.045553092F, 0.51749015F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair4 = new ModelRenderer(this, 30, 56);
      this.Hair4.func_78793_a(3.9F, -5.3F, 2.4F);
      this.Hair4.func_78790_a(-1.4F, -3.4F, -1.5F, 2, 5, 2, 0.0F);
      this.setRotateAngle(this.Hair4, -0.13665928F, -0.13665928F, -0.31869712F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Ribbon = new ModelRenderer(this, 25, 1);
      this.Ribbon.func_78793_a(0.0F, 1.5F, -2.0F);
      this.Ribbon.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 5, 0, 0.0F);
      this.setRotateAngle(this.Ribbon, -0.18203785F, 0.0F, 0.0F);
      this.Head2 = new ModelRenderer(this, 0, 32);
      this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head2.func_78790_a(-4.5F, -8.9F, -4.5F, 9, 9, 9, 0.0F);
      this.shape28 = new ModelRenderer(this, 49, 50);
      this.shape28.func_78793_a(0.0F, -7.3F, -4.0F);
      this.shape28.func_78790_a(-3.6F, 0.0F, 0.0F, 7, 4, 0, 0.0F);
      this.setRotateAngle(this.shape28, -0.13543755F, 0.0F, 0.0F);
      this.Hair3 = new ModelRenderer(this, 39, 55);
      this.Hair3.func_78793_a(-3.3F, -6.7F, 0.9F);
      this.Hair3.func_78790_a(-1.4F, -4.3F, -1.5F, 3, 5, 3, 0.0F);
      this.setRotateAngle(this.Hair3, 0.045553092F, 0.091106184F, 0.59184116F);
      this.Hair.func_78792_a(this.Hair5);
      this.Head.func_78792_a(this.Hair);
      this.Hair.func_78792_a(this.Hair2);
      this.Hair.func_78792_a(this.Hair4);
      this.Body.func_78792_a(this.Ribbon);
      this.Head.func_78792_a(this.Head2);
      this.Hair.func_78792_a(this.shape28);
      this.Hair.func_78792_a(this.Hair3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.Body.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
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
   }
}
