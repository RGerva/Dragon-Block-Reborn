package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLavender extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Tail1;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Snout;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer EarR2;
   public ModelRenderer EarL2;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Fur;
   public ModelRenderer Body3;
   public ModelRenderer Tail2;
   public ModelRenderer Tail3;
   public ModelRenderer Tail4;
   public ModelRenderer Tail5;
   public ModelRenderer LegR2;
   public ModelRenderer LegR2_1;

   public ModelLavender() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmL = new ModelRenderer(this, 0, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -0.5F, -1.4F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
      this.Body2 = new ModelRenderer(this, 20, 29);
      this.Body2.func_78793_a(0.0F, 7.5F, 0.0F);
      this.Body2.func_78790_a(-3.5F, -0.7F, -1.5F, 7, 4, 4, 0.0F);
      this.setRotateAngle(this.Body2, -0.2617994F, 0.0F, 0.0F);
      this.Tail4 = new ModelRenderer(this, 52, 32);
      this.Tail4.func_78793_a(0.0F, 0.0F, 5.8F);
      this.Tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
      this.setRotateAngle(this.Tail4, 0.27314404F, 0.0F, 0.0F);
      this.Tail1 = new ModelRenderer(this, 54, 9);
      this.Tail1.func_78793_a(0.0F, 9.2F, 1.0F);
      this.Tail1.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
      this.setRotateAngle(this.Tail1, -0.4098033F, 0.0F, 0.0F);
      this.LegR2_1 = new ModelRenderer(this, 0, 50);
      this.LegR2_1.func_78793_a(0.1F, 6.0F, 1.3F);
      this.LegR2_1.func_78790_a(-2.0F, -1.5F, -0.6F, 4, 9, 4, 0.0F);
      this.setRotateAngle(this.LegR2_1, 0.4886922F, 0.0F, 0.0F);
      this.Tail5 = new ModelRenderer(this, 54, 38);
      this.Tail5.func_78793_a(0.0F, 0.0F, 2.9F);
      this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
      this.setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
      this.EarL2 = new ModelRenderer(this, 49, 2);
      this.EarL2.field_78809_i = true;
      this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL2.func_78790_a(-1.7F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
      this.LegR2 = new ModelRenderer(this, 0, 50);
      this.LegR2.func_78793_a(-0.1F, 6.0F, 1.3F);
      this.LegR2.func_78790_a(-2.0F, -1.5F, -0.6F, 4, 9, 4, 0.0F);
      this.setRotateAngle(this.LegR2, 0.4886922F, 0.0F, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 16);
      this.Body1.func_78793_a(0.0F, -3.0F, -1.9F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.4F, 8, 8, 4, 0.0F);
      this.setRotateAngle(this.Body1, 0.17453292F, 0.0F, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 39);
      this.LegL.func_78793_a(2.6F, 10.6F, -1.6F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.LegL, -0.4886922F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 39);
      this.LegR.func_78793_a(-2.5F, 10.6F, -1.6F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.LegR, -0.4886922F, 0.0F, 0.0F);
      this.EarR = new ModelRenderer(this, 27, 2);
      this.EarR.func_78793_a(-3.0F, -5.3F, -1.1F);
      this.EarR.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.27925268F, -0.6981317F);
      this.ArmR = new ModelRenderer(this, 0, 16);
      this.ArmR.func_78793_a(-5.0F, -0.5F, -1.4F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 27, 2);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.1F, -5.3F, -1.1F);
      this.EarL.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.27925268F, 0.6981317F);
      this.Tail2 = new ModelRenderer(this, 48, 14);
      this.Tail2.func_78793_a(0.0F, 0.0F, 2.3F);
      this.Tail2.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
      this.setRotateAngle(this.Tail2, -0.59184116F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -1.6F, -3.0F);
      this.Head.func_78790_a(-4.0F, -5.8F, -4.9F, 8, 7, 8, 0.0F);
      this.setRotateAngle(this.Head, 0.045553092F, 0.0F, 0.0F);
      this.EarR2 = new ModelRenderer(this, 49, 2);
      this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR2.func_78790_a(-1.3F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
      this.Body3 = new ModelRenderer(this, 19, 40);
      this.Body3.func_78793_a(0.0F, 3.1F, 0.4F);
      this.Body3.func_78790_a(-4.0F, 0.2F, -2.0F, 8, 3, 4, 0.0F);
      this.setRotateAngle(this.Body3, 0.08726646F, 0.0F, 0.0F);
      this.Snout = new ModelRenderer(this, 36, 1);
      this.Snout.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Snout.func_78790_a(-2.0F, -2.5F, -6.9F, 4, 3, 2, 0.0F);
      this.Chest = new ModelRenderer(this, 33, 9);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-4.0F, 2.1F, -2.5F, 8, 4, 1, 0.0F);
      this.Fur = new ModelRenderer(this, 45, 44);
      this.Fur.func_78793_a(0.0F, 0.9F, -3.0F);
      this.Fur.func_78790_a(-2.5F, 0.2F, -0.5F, 5, 4, 2, 0.0F);
      this.Tail3 = new ModelRenderer(this, 44, 22);
      this.Tail3.func_78793_a(0.0F, 0.0F, 4.4F);
      this.Tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
      this.setRotateAngle(this.Tail3, 0.4553564F, 0.0F, 0.0F);
      this.Body1.func_78792_a(this.Body2);
      this.Tail3.func_78792_a(this.Tail4);
      this.LegR.func_78792_a(this.LegR2_1);
      this.Tail4.func_78792_a(this.Tail5);
      this.EarL.func_78792_a(this.EarL2);
      this.LegL.func_78792_a(this.LegR2);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.Tail1.func_78792_a(this.Tail2);
      this.EarR.func_78792_a(this.EarR2);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.Snout);
      this.Body1.func_78792_a(this.Chest);
      this.Body1.func_78792_a(this.Fur);
      this.Tail2.func_78792_a(this.Tail3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      this.Tail1.func_78785_a(f5);
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
      this.Tail1.field_78795_f = 0.2F;
      ModelRenderer var10000 = this.Tail1;
      var10000.field_78795_f += r4 / 2.0F;
      this.Tail2.field_78795_f = 0.2F;
      var10000 = this.Tail2;
      var10000.field_78795_f += r4 / 2.0F;
      this.Tail3.field_78795_f = 0.2F;
      var10000 = this.Tail3;
      var10000.field_78795_f += r4 / 2.0F;
      this.Tail4.field_78795_f = 0.2F;
      var10000 = this.Tail4;
      var10000.field_78795_f += r4 / 2.0F;
      this.Tail5.field_78796_g = 0.2F;
      var10000 = this.Tail5;
      var10000.field_78796_g += r4;
      this.LegR.field_78795_f = -0.4F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
