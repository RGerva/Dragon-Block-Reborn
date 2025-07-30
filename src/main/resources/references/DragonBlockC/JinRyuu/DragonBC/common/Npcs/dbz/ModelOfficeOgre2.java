package JinRyuu.DragonBC.common.Npcs.dbz;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOfficeOgre2 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer HornM1;
   public ModelRenderer HornR1;
   public ModelRenderer HornL1;
   public ModelRenderer Glasses;
   public ModelRenderer HornM2;
   public ModelRenderer HornR2;
   public ModelRenderer HornL2;
   public ModelRenderer Tie;

   public ModelOfficeOgre2() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Glasses = new ModelRenderer(this, 29, 19);
      this.Glasses.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Glasses.func_78790_a(-4.5F, -5.3F, -4.3F, 9, 3, 7, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 35);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 18, 35);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
      this.Tie = new ModelRenderer(this, 1, 0);
      this.Tie.func_78793_a(0.0F, 0.0F, -2.2F);
      this.Tie.func_78790_a(-1.0F, 0.0F, 0.0F, 2, 7, 0, 0.0F);
      this.setRotateAngle(this.Tie, -0.017453292F, 0.0F, 0.0F);
      this.HornM1 = new ModelRenderer(this, 25, 4);
      this.HornM1.func_78793_a(0.0F, -8.0F, 0.0F);
      this.HornM1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
      this.ArmR = new ModelRenderer(this, 18, 35);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
      this.HornM2 = new ModelRenderer(this, 34, 4);
      this.HornM2.func_78793_a(0.0F, -1.7F, 0.0F);
      this.HornM2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
      this.HornR1 = new ModelRenderer(this, 25, 0);
      this.HornR1.func_78793_a(-3.0F, -7.4F, 0.0F);
      this.HornR1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
      this.setRotateAngle(this.HornR1, 0.0F, 0.0F, -0.4537856F);
      this.HornR2 = new ModelRenderer(this, 34, 0);
      this.HornR2.func_78793_a(0.0F, -1.7F, 0.0F);
      this.HornR2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 35);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.HornL2 = new ModelRenderer(this, 34, 0);
      this.HornL2.func_78793_a(0.0F, -1.7F, 0.0F);
      this.HornL2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
      this.Body = new ModelRenderer(this, 0, 17);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.HornL1 = new ModelRenderer(this, 25, 0);
      this.HornL1.func_78793_a(3.0F, -7.4F, 0.0F);
      this.HornL1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
      this.setRotateAngle(this.HornL1, 0.0F, 0.0F, 0.4537856F);
      this.Head.func_78792_a(this.Glasses);
      this.Body.func_78792_a(this.Tie);
      this.Head.func_78792_a(this.HornM1);
      this.HornM1.func_78792_a(this.HornM2);
      this.Head.func_78792_a(this.HornR1);
      this.HornR1.func_78792_a(this.HornR2);
      this.HornL1.func_78792_a(this.HornL2);
      this.Head.func_78792_a(this.HornL1);
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
