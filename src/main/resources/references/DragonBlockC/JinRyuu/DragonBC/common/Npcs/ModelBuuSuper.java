package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuuSuper extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Head2;
   public ModelRenderer Head3;
   public ModelRenderer Head4;
   public ModelRenderer Hips;
   public ModelRenderer Torso;
   public ModelRenderer ChestR;
   public ModelRenderer FootR;
   public ModelRenderer FootL;

   public ModelBuuSuper() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body = new ModelRenderer(this, 22, 29);
      this.Body.func_78793_a(0.0F, -2.7F, 0.0F);
      this.Body.func_78790_a(-3.5F, 2.6F, -1.9F, 7, 7, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 28);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
      this.LegR = new ModelRenderer(this, 0, 28);
      this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
      this.ChestR = new ModelRenderer(this, 0, 22);
      this.ChestR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ChestR.func_78790_a(-4.1F, 1.1F, -1.8F, 8, 3, 2, 0.0F);
      this.setRotateAngle(this.ChestR, -0.077667154F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 48, 19);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.4F, -1.4F, 0.3F);
      this.ArmL.func_78790_a(-1.0F, -1.3F, -1.7F, 4, 12, 4, -0.1F);
      this.FootR = new ModelRenderer(this, 0, 43);
      this.FootR.field_78809_i = true;
      this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
      this.FootL = new ModelRenderer(this, 0, 43);
      this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
      this.Head2 = new ModelRenderer(this, 25, 0);
      this.Head2.func_78793_a(0.0F, -6.9F, -1.8F);
      this.Head2.func_78790_a(-1.0F, -3.4F, -1.4F, 2, 4, 3, 0.0F);
      this.setRotateAngle(this.Head2, -0.3635521F, 0.0F, 0.0F);
      this.Head4 = new ModelRenderer(this, 36, 0);
      this.Head4.func_78793_a(0.0F, -0.1F, 2.4F);
      this.Head4.func_78790_a(-0.5F, -0.5F, -0.3F, 1, 1, 3, 0.0F);
      this.setRotateAngle(this.Head4, -0.63739425F, 0.0F, 0.0F);
      this.Hips = new ModelRenderer(this, 19, 41);
      this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hips.func_78790_a(-4.0F, 8.8F, -2.3F, 8, 3, 5, 0.0F);
      this.Torso = new ModelRenderer(this, 21, 19);
      this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Torso.func_78790_a(-4.5F, 0.1F, -0.9F, 9, 5, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.5F, 0.2F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.1F, 8, 8, 8, -0.6F);
      this.Head3 = new ModelRenderer(this, 36, 0);
      this.Head3.func_78793_a(0.0F, -3.6F, 0.0F);
      this.Head3.func_78790_a(-0.5F, -1.0F, -0.6F, 1, 2, 3, 0.0F);
      this.setRotateAngle(this.Head3, 1.1383038F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 48, 19);
      this.ArmR.func_78793_a(-5.4F, -1.4F, 0.3F);
      this.ArmR.func_78790_a(-3.0F, -1.3F, -1.7F, 4, 12, 4, -0.1F);
      this.Torso.func_78792_a(this.ChestR);
      this.LegR.func_78792_a(this.FootR);
      this.LegL.func_78792_a(this.FootL);
      this.Head.func_78792_a(this.Head2);
      this.Head3.func_78792_a(this.Head4);
      this.Body.func_78792_a(this.Hips);
      this.Body.func_78792_a(this.Torso);
      this.Head2.func_78792_a(this.Head3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body.func_78785_a(f5);
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
      this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
