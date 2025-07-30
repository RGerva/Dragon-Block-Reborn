package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSorrel extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Hat1;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Hat2;
   public ModelRenderer Body2;
   public ModelRenderer Scarf;
   public ModelRenderer Body3;
   public ModelRenderer tail;
   public ModelRenderer Scarf2;
   public ModelRenderer Scarf3;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelSorrel() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Scarf = new ModelRenderer(this, 43, 8);
      this.Scarf.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Scarf.func_78790_a(-2.5F, -0.5F, -2.5F, 5, 1, 5, 0.0F);
      this.Hat2 = new ModelRenderer(this, 37, 48);
      this.Hat2.func_78793_a(0.0F, 0.6F, -4.0F);
      this.Hat2.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 0, 2, 0.0F);
      this.setRotateAngle(this.Hat2, 0.33056536F, 0.0F, 0.0F);
      this.tail = new ModelRenderer(this, 23, 39);
      this.tail.func_78793_a(0.0F, 8.4F, 1.8F);
      this.tail.func_78790_a(-1.0F, -1.0F, -0.2F, 2, 2, 2, 0.0F);
      this.setRotateAngle(this.tail, -0.045553092F, 0.0F, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 2.6F, 0.0F);
      this.Body1.func_78790_a(-3.0F, 0.0F, -1.9F, 6, 5, 4, -0.2F);
      this.Scarf2 = new ModelRenderer(this, 55, 16);
      this.Scarf2.func_78793_a(1.0F, 0.2F, 2.4F);
      this.Scarf2.func_78790_a(-1.4F, 0.0F, 0.0F, 3, 7, 0, 0.0F);
      this.setRotateAngle(this.Scarf2, 0.1675516F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 27);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-2.5F, 4.8F, -1.6F, 5, 3, 3, 0.0F);
      this.LegR2 = new ModelRenderer(this, 0, 41);
      this.LegR2.func_78793_a(0.0F, 0.5F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, -0.3F, -2.5F, 4, 4, 5, 0.0F);
      this.setRotateAngle(this.LegR2, 0.0F, 0.0F, 0.04363323F);
      this.Hat1 = new ModelRenderer(this, 31, 51);
      this.Hat1.func_78793_a(0.0F, -3.9F, 0.0F);
      this.Hat1.func_78790_a(-4.0F, -3.4F, -4.0F, 8, 4, 8, 0.0F);
      this.setRotateAngle(this.Hat1, -0.09128072F, 0.089186326F, 0.0F);
      this.EarL = new ModelRenderer(this, 35, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.1F, -5.7F, 0.0F);
      this.EarL.func_78790_a(-2.0F, -8.5F, 0.0F, 4, 9, 0, 0.0F);
      this.setRotateAngle(this.EarL, -0.17453292F, 0.0F, 0.08726646F);
      this.LegR = new ModelRenderer(this, 0, 51);
      this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-1.4F, 3.2F, -2.0F, 3, 9, 4, -0.2F);
      this.Body3 = new ModelRenderer(this, 0, 34);
      this.Body3.func_78793_a(0.0F, 0.5F, 0.0F);
      this.Body3.func_78790_a(-3.0F, 7.3F, -2.0F, 6, 2, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 2.5F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.7F);
      this.LegL2 = new ModelRenderer(this, 0, 41);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.5F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, -0.3F, -2.5F, 4, 4, 5, 0.0F);
      this.setRotateAngle(this.LegL2, 0.0F, 0.0F, -0.04363323F);
      this.LegL = new ModelRenderer(this, 0, 51);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.8F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-1.6F, 3.2F, -2.0F, 3, 9, 4, -0.2F);
      this.Scarf3 = new ModelRenderer(this, 55, 23);
      this.Scarf3.func_78793_a(0.0F, 6.8F, 0.0F);
      this.Scarf3.func_78790_a(-1.4F, 0.0F, 0.0F, 3, 10, 0, 0.0F);
      this.setRotateAngle(this.Scarf3, 0.0837758F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 23, 20);
      this.ArmR.func_78793_a(-3.8F, 3.8F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.3F, -1.8F, 3, 11, 4, -0.3F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.EarR = new ModelRenderer(this, 35, 1);
      this.EarR.func_78793_a(-3.4F, -5.7F, 0.0F);
      this.EarR.func_78790_a(-2.0F, -8.5F, 0.0F, 4, 9, 0, 0.0F);
      this.setRotateAngle(this.EarR, -0.17453292F, 0.0F, -0.08726646F);
      this.ArmL = new ModelRenderer(this, 38, 20);
      this.ArmL.func_78793_a(3.8F, 3.8F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 3, 11, 4, -0.3F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.Body1.func_78792_a(this.Scarf);
      this.Hat1.func_78792_a(this.Hat2);
      this.Body3.func_78792_a(this.tail);
      this.Scarf.func_78792_a(this.Scarf2);
      this.Body1.func_78792_a(this.Body2);
      this.LegR.func_78792_a(this.LegR2);
      this.Head.func_78792_a(this.Hat1);
      this.Head.func_78792_a(this.EarL);
      this.Body2.func_78792_a(this.Body3);
      this.LegL.func_78792_a(this.LegL2);
      this.Scarf2.func_78792_a(this.Scarf3);
      this.Head.func_78792_a(this.EarR);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.ArmR.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
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
      float ex = (float)par7Entity.field_70173_aa;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.Scarf2.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      ModelRenderer var10000;
      if (0.0F > this.Scarf2.field_78795_f) {
         var10000 = this.Scarf2;
         var10000.field_78795_f *= -1.0F;
      }

      this.Scarf2.field_78796_g = 0.0F;
      this.Scarf3.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (0.0F > this.Scarf3.field_78795_f) {
         var10000 = this.Scarf3;
         var10000.field_78795_f *= -1.0F;
      }

      this.Scarf3.field_78796_g = 0.0F;
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
