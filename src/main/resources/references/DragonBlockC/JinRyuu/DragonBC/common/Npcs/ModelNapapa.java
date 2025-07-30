package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNapapa extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Beard;
   public ModelRenderer Nose;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Hair;
   public ModelRenderer MuttonchopsR;
   public ModelRenderer MuttonchopsL;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;
   public ModelRenderer BeltKnot;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;

   public ModelNapapa() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -7.8F, 0.0F);
      this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 7, 9, 0.0F);
      this.LegL = new ModelRenderer(this, 91, 43);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(4.3F, 10.0F, 1.0F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.5F, 6, 14, 7, 0.0F);
      this.Hair = new ModelRenderer(this, 51, 3);
      this.Hair.func_78793_a(0.0F, -6.1F, 0.0F);
      this.Hair.func_78790_a(-1.5F, -3.6F, -5.2F, 3, 4, 11, 0.0F);
      this.setRotateAngle(this.Hair, -0.13665928F, 0.0F, 0.0F);
      this.MuttonchopsR = new ModelRenderer(this, 55, 8);
      this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -2.1F);
      this.MuttonchopsR.func_78790_a(-1.2F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsR, 0.0F, 0.68294734F, 0.31869712F);
      this.EarR = new ModelRenderer(this, 55, 3);
      this.EarR.func_78793_a(-4.0F, -3.5F, -1.1F);
      this.EarR.func_78790_a(-1.4F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.68294734F, -0.31869712F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -7.9F, 0.6F);
      this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 8, 8, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 33);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-8.0F, 7.0F, -4.1F, 16, 8, 11, 0.0F);
      this.LegR = new ModelRenderer(this, 91, 43);
      this.LegR.func_78793_a(-4.2F, 10.0F, 1.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.5F, 6, 14, 7, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 90, 19);
      this.ArmR2.func_78793_a(-0.6F, 7.9F, -0.3F);
      this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 11, 6, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
      this.Beard = new ModelRenderer(this, 44, 5);
      this.Beard.func_78793_a(0.0F, -0.7F, -4.1F);
      this.Beard.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
      this.setRotateAngle(this.Beard, -0.0052359877F, 0.0F, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 92, 3);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.5F, -5.3F, 2.0F);
      this.ArmL1.func_78790_a(-1.2F, -2.0F, -2.5F, 4, 10, 5, 0.0F);
      this.setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.38397244F);
      this.BeltKnot = new ModelRenderer(this, 56, 48);
      this.BeltKnot.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BeltKnot.func_78790_a(-3.0F, 11.9F, 6.9F, 6, 3, 2, 0.0F);
      this.MuttonchopsL = new ModelRenderer(this, 55, 8);
      this.MuttonchopsL.field_78809_i = true;
      this.MuttonchopsL.func_78793_a(3.6F, -3.5F, -2.1F);
      this.MuttonchopsL.func_78790_a(-1.1F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsL, 0.0F, -0.68294734F, -0.31869712F);
      this.EarL = new ModelRenderer(this, 55, 3);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(4.0F, -3.5F, -1.1F);
      this.EarL.func_78790_a(-0.5F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.68294734F, 0.31869712F);
      this.Body3 = new ModelRenderer(this, 0, 52);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-7.5F, 14.8F, -3.2F, 15, 3, 9, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 92, 3);
      this.ArmR1.func_78793_a(-8.2F, -5.3F, 2.0F);
      this.ArmR1.func_78790_a(-3.0F, -2.0F, -2.5F, 4, 10, 5, 0.0F);
      this.setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.38397244F);
      this.Nose = new ModelRenderer(this, 46, 0);
      this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Nose.func_78790_a(-1.0F, -4.1F, -4.6F, 2, 2, 2, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 90, 19);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.7F, 7.9F, -0.3F);
      this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 11, 6, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
      this.Chest = new ModelRenderer(this, 50, 28);
      this.Chest.func_78793_a(0.0F, 3.7F, -1.7F);
      this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
      this.setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
      this.Head.func_78792_a(this.Hair);
      this.Head.func_78792_a(this.MuttonchopsR);
      this.Head.func_78792_a(this.EarR);
      this.Body1.func_78792_a(this.Body2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.Beard);
      this.Body2.func_78792_a(this.BeltKnot);
      this.Head.func_78792_a(this.MuttonchopsL);
      this.Head.func_78792_a(this.EarL);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.Nose);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Body1.func_78792_a(this.Chest);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
      this.ArmL1.func_78785_a(f5);
      this.ArmR1.func_78785_a(f5);
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
      this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR1.field_78796_g = 0.0F;
      this.ArmL1.field_78796_g = 0.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
