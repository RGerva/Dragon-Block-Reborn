package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMercenaryTao extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hair;
   public ModelRenderer Cloth1;
   public ModelRenderer Cloth2;

   public ModelMercenaryTao() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Cloth1 = new ModelRenderer(this, 0, 52);
      this.Cloth1.func_78793_a(0.0F, 10.0F, -1.2F);
      this.Cloth1.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.045378562F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.ArmL = new ModelRenderer(this, 26, 19);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 26, 19);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 35);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body = new ModelRenderer(this, 0, 17);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 35);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Cloth2 = new ModelRenderer(this, 23, 52);
      this.Cloth2.func_78793_a(0.0F, 10.1F, 1.2F);
      this.Cloth2.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
      this.setRotateAngle(this.Cloth2, 0.045378562F, 0.0F, 0.0F);
      this.Hair = new ModelRenderer(this, 35, 3);
      this.Hair.func_78793_a(0.0F, -1.2F, 4.0F);
      this.Hair.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 10, 0, 0.0F);
      this.setRotateAngle(this.Hair, 0.045553092F, 0.0F, 0.0F);
      this.Body.func_78792_a(this.Cloth1);
      this.Body.func_78792_a(this.Cloth2);
      this.Head.func_78792_a(this.Hair);
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
      this.Hair.field_78795_f = 0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.5F * par2;
      if (0.0F > this.Hair.field_78795_f) {
         ModelRenderer var10000 = this.Hair;
         var10000.field_78795_f *= -1.0F;
      }

      this.Hair.field_78796_g = 0.0F;
      this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth2.field_78795_f = 0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? 1 : -1) * 1.0F;
   }
}
