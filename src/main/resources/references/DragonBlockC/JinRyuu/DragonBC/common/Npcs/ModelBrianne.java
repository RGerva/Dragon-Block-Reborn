package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrianne extends ModelBase {
   public ModelRenderer Head1;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Head2;
   public ModelRenderer Head3;
   public ModelRenderer Head4;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;
   public ModelRenderer Body4;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelBrianne() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Head3 = new ModelRenderer(this, 39, 1);
      this.Head3.func_78793_a(0.0F, -3.4F, 0.0F);
      this.Head3.func_78790_a(-1.0F, -4.1F, -1.0F, 2, 5, 2, 0.0F);
      this.setRotateAngle(this.Head3, -1.3203416F, 0.0F, 0.0F);
      this.Body1 = new ModelRenderer(this, 32, 9);
      this.Body1.func_78793_a(0.0F, -0.5F, 0.0F);
      this.Body1.func_78790_a(-5.0F, 0.1F, -3.7F, 10, 5, 7, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 42);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-1.3F, 5.0F, -2.0F, 4, 7, 4, 0.0F);
      this.Head2 = new ModelRenderer(this, 26, 0);
      this.Head2.func_78793_a(0.0F, -6.3F, 0.0F);
      this.Head2.func_78790_a(-1.5F, -3.8F, -1.5F, 3, 5, 3, 0.0F);
      this.setRotateAngle(this.Head2, -0.5462881F, 0.0F, 0.0F);
      this.Boobs = new ModelRenderer(this, 0, 17);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-6.0F, 3.7F, -1.1F, 12, 4, 3, 0.0F);
      this.setRotateAngle(this.Boobs, -0.8110545F, 0.0F, 0.0F);
      this.Head4 = new ModelRenderer(this, 48, 2);
      this.Head4.func_78793_a(0.0F, -3.4F, 0.0F);
      this.Head4.func_78790_a(-0.5F, -2.9F, 0.1F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.Head4, 1.3203416F, 0.0F, 0.0F);
      this.LegR2 = new ModelRenderer(this, 0, 26);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-3.3F, 0.6F, -3.0F, 6, 5, 6, 0.0F);
      this.ArmL = new ModelRenderer(this, 68, 2);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.0F, 1.9F, -0.2F);
      this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 4, 12, 4, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.19198622F);
      this.Head1 = new ModelRenderer(this, 0, 0);
      this.Head1.func_78793_a(0.0F, -0.3F, 0.0F);
      this.Head1.func_78790_a(-4.0F, -6.7F, -4.0F, 8, 7, 8, -0.4F);
      this.Body4 = new ModelRenderer(this, 67, 23);
      this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body4.func_78790_a(-8.5F, 12.7F, -6.5F, 17, 5, 13, 0.0F);
      this.ArmR = new ModelRenderer(this, 68, 2);
      this.ArmR.func_78793_a(-6.2F, 1.9F, -0.2F);
      this.ArmR.func_78790_a(-2.9F, -1.7F, -1.8F, 4, 12, 4, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.19198622F);
      this.LegR = new ModelRenderer(this, 0, 42);
      this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.5F, 5.0F, -2.0F, 4, 7, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 26, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-7.0F, 8.9F, -5.2F, 14, 4, 10, 0.0F);
      this.Body2 = new ModelRenderer(this, 30, 22);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-5.5F, 5.1F, -4.4F, 11, 4, 8, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 26);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.4F, 0.6F, -3.0F, 6, 5, 6, 0.0F);
      this.Head2.func_78792_a(this.Head3);
      this.Head1.func_78792_a(this.Head2);
      this.Body1.func_78792_a(this.Boobs);
      this.Head3.func_78792_a(this.Head4);
      this.LegR.func_78792_a(this.LegR2);
      this.Body3.func_78792_a(this.Body4);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.LegL.func_78792_a(this.LegL2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head1.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
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
      this.Head1.field_78796_g = par4 / (r2 / 3.1415927F);
      this.Head1.field_78795_f = par5 / (r2 / 3.1415927F);
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
