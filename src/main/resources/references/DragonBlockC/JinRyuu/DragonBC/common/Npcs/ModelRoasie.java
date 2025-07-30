package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRoasie extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Head2;
   public ModelRenderer Head3;
   public ModelRenderer Head4;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelRoasie() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body3 = new ModelRenderer(this, 0, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 8, 4, -0.2F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.Head2 = new ModelRenderer(this, 39, 0);
      this.Head2.func_78793_a(0.0F, -6.4F, -1.3F);
      this.Head2.func_78790_a(-1.5F, -5.7F, -1.1F, 3, 7, 3, 0.0F);
      this.setRotateAngle(this.Head2, -0.95609134F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 30);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 7.8F, -1.6F, 6, 1, 3, 0.0F);
      this.ArmR = new ModelRenderer(this, 32, 35);
      this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.Head3 = new ModelRenderer(this, 40, 11);
      this.Head3.func_78793_a(0.0F, -5.0F, 0.1F);
      this.Head3.func_78790_a(-1.0F, -6.4F, -1.1F, 2, 7, 2, 0.0F);
      this.setRotateAngle(this.Head3, -0.95609134F, 0.0F, 0.0F);
      this.Head4 = new ModelRenderer(this, 42, 21);
      this.Head4.func_78793_a(0.0F, -6.4F, 0.0F);
      this.Head4.func_78790_a(-0.5F, -4.5F, -0.7F, 1, 5, 1, 0.0F);
      this.setRotateAngle(this.Head4, 0.68294734F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.EarR = new ModelRenderer(this, 28, 1);
      this.EarR.func_78793_a(-3.0F, -3.0F, -0.5F);
      this.EarR.func_78790_a(-1.1F, -2.0F, -0.3F, 1, 3, 2, 0.0F);
      this.ArmL = new ModelRenderer(this, 32, 35);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.EarL = new ModelRenderer(this, 28, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.0F, -3.0F, -0.5F);
      this.EarL.func_78790_a(0.2F, -2.0F, -0.3F, 1, 3, 2, 0.0F);
      this.Boobs = new ModelRenderer(this, 19, 31);
      this.Boobs.func_78793_a(0.0F, -0.3F, 0.0F);
      this.Boobs.func_78790_a(-2.5F, 1.8F, -0.5F, 5, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.Head2);
      this.Body1.func_78792_a(this.Body2);
      this.Head2.func_78792_a(this.Head3);
      this.Head3.func_78792_a(this.Head4);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.Body1.func_78792_a(this.Boobs);
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
