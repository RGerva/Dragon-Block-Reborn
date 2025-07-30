package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRylibeu extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Wings;
   public ModelRenderer FeelerR;
   public ModelRenderer FeelerL;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer WingL1;
   public ModelRenderer WingR1;
   public ModelRenderer WingR2;
   public ModelRenderer WingL2;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelRylibeu() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.ArmL = new ModelRenderer(this, 32, 29);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 2.5F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.WingL2 = new ModelRenderer(this, 85, 2);
      this.WingL2.field_78809_i = true;
      this.WingL2.func_78793_a(0.0F, -4.4F, 3.7F);
      this.WingL2.func_78790_a(-1.0F, -1.4F, 0.0F, 9, 24, 0, 0.0F);
      this.setRotateAngle(this.WingL2, 0.04886922F, -0.13665928F, -0.045727625F);
      this.FeelerL = new ModelRenderer(this, 29, 0);
      this.FeelerL.field_78809_i = true;
      this.FeelerL.func_78793_a(1.5F, -6.3F, -3.5F);
      this.FeelerL.func_78790_a(0.0F, -0.7F, -4.0F, 0, 2, 4, 0.0F);
      this.setRotateAngle(this.FeelerL, 0.0F, -0.54105204F, 0.0F);
      this.ArmR = new ModelRenderer(this, 32, 29);
      this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.WingR2 = new ModelRenderer(this, 85, 2);
      this.WingR2.func_78793_a(0.0F, -4.4F, 3.7F);
      this.WingR2.func_78790_a(-8.2F, -1.4F, 0.0F, 9, 24, 0, 0.0F);
      this.setRotateAngle(this.WingR2, 0.04886922F, 0.13665928F, 0.045727625F);
      this.Wings = new ModelRenderer(this, 0, 0);
      this.Wings.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Wings.func_78790_a(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
      this.EarL = new ModelRenderer(this, 38, 3);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.6F, -3.5F, 0.0F);
      this.EarL.func_78790_a(-0.5F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.43633232F, -0.2268928F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.6F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 38, 3);
      this.EarR.func_78793_a(-3.6F, -3.5F, 0.0F);
      this.EarR.func_78790_a(-4.4F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.43633232F, 0.2268928F);
      this.Body3 = new ModelRenderer(this, 0, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 7.8F, -2.0F, 7, 3, 4, 0.0F);
      this.WingL1 = new ModelRenderer(this, 66, 2);
      this.WingL1.field_78809_i = true;
      this.WingL1.func_78793_a(0.0F, -4.4F, 3.7F);
      this.WingL1.func_78790_a(0.3F, -6.0F, 0.0F, 9, 24, 0, 0.0F);
      this.setRotateAngle(this.WingL1, 0.0F, 0.0F, -0.091106184F);
      this.WingR1 = new ModelRenderer(this, 66, 2);
      this.WingR1.func_78793_a(0.0F, -4.4F, 3.7F);
      this.WingR1.func_78790_a(-9.1F, -6.0F, 0.0F, 9, 24, 0, 0.0F);
      this.setRotateAngle(this.WingR1, 0.0F, 0.0F, 0.091106184F);
      this.FeelerR = new ModelRenderer(this, 29, 0);
      this.FeelerR.func_78793_a(-1.5F, -6.3F, -3.5F);
      this.FeelerR.func_78790_a(0.0F, -0.7F, -4.0F, 0, 2, 4, 0.0F);
      this.setRotateAngle(this.FeelerR, 0.0F, 0.54105204F, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 27);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
      this.Boobs = new ModelRenderer(this, 19, 27);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.Wings.func_78792_a(this.WingL2);
      this.Head.func_78792_a(this.FeelerL);
      this.Wings.func_78792_a(this.WingR2);
      this.Head.func_78792_a(this.Wings);
      this.Head.func_78792_a(this.EarL);
      this.Head.func_78792_a(this.EarR);
      this.Body2.func_78792_a(this.Body3);
      this.Wings.func_78792_a(this.WingL1);
      this.Wings.func_78792_a(this.WingR1);
      this.Head.func_78792_a(this.FeelerR);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.Boobs);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Body1.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
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
