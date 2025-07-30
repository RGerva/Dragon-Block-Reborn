package JinRyuu.DragonBC.common.Npcs.dbbaba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVampire extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Hair;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;

   public ModelVampire() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body = new ModelRenderer(this, 17, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 0, 54);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.6981317F, 0.12217305F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 19);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair = new ModelRenderer(this, 32, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(-4.0F, -12.0F, -4.0F, 8, 4, 8, 0.0F);
      this.ArmR = new ModelRenderer(this, 0, 0);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 0, 43);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.6981317F, -0.12217305F, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 19);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 17, 54);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(1.0F, 4.0F, -1.5F);
      this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL3, -1.6580628F, 0.034906585F, 0.0F);
      this.Body3 = new ModelRenderer(this, 17, 35);
      this.Body3.func_78793_a(0.0F, 3.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 3, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 1, 2);
      this.EarR.func_78793_a(-3.8F, -4.4F, -1.5F);
      this.EarR.func_78790_a(-3.0F, -3.7F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.87266463F, 0.0F);
      this.Body2 = new ModelRenderer(this, 18, 27);
      this.Body2.func_78793_a(0.0F, 6.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 3, 4, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 17, 43);
      this.ArmR3.func_78793_a(-1.0F, 4.0F, -1.5F);
      this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR3, -1.6580628F, -0.034906585F, 0.0F);
      this.ArmL = new ModelRenderer(this, 0, 0);
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.EarL = new ModelRenderer(this, 1, 2);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.8F, -4.4F, -1.5F);
      this.EarL.func_78790_a(0.0F, -3.7F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.0F);
      this.ArmL.func_78792_a(this.ArmL2);
      this.Head.func_78792_a(this.Hair);
      this.ArmR.func_78792_a(this.ArmR2);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.EarR);
      this.Body.func_78792_a(this.Body2);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Head.func_78792_a(this.EarL);
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
