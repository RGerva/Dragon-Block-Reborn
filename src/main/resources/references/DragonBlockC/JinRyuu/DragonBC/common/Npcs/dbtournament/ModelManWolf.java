package JinRyuu.DragonBC.common.Npcs.dbtournament;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelManWolf extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Nose;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer MuttonchopsR;
   public ModelRenderer MuttonchopsL;

   public ModelManWolf() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR1 = new ModelRenderer(this, 34, 16);
      this.ArmR1.func_78793_a(-6.5F, 2.0F, 1.0F);
      this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 12, 5, 0.0F);
      this.MuttonchopsR = new ModelRenderer(this, 55, 8);
      this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -2.1F);
      this.MuttonchopsR.func_78790_a(-2.0F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsR, 0.0F, 0.6981317F, 0.08726646F);
      this.MuttonchopsL = new ModelRenderer(this, 55, 8);
      this.MuttonchopsL.field_78809_i = true;
      this.MuttonchopsL.func_78793_a(3.5F, -3.5F, -2.1F);
      this.MuttonchopsL.func_78790_a(0.0F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsL, 0.0F, -0.6981317F, -0.08726646F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, 0.0F, 1.0F);
      this.Body1.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 12, 6, 0.0F);
      this.EarR = new ModelRenderer(this, 47, 8);
      this.EarR.func_78793_a(-3.6F, -4.0F, -1.0F);
      this.EarR.func_78790_a(-2.5F, -3.0F, 0.0F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.34906584F, -0.04363323F);
      this.LegL = new ModelRenderer(this, 1, 40);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.6F, 12.0F, 1.0F);
      this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.1F);
      this.EarL = new ModelRenderer(this, 47, 8);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.0F, -4.0F, -1.0F);
      this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.34906584F, 0.04363323F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.6F);
      this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 34, 16);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(6.5F, 2.0F, 1.0F);
      this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 12, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 1, 40);
      this.LegR.func_78793_a(-2.6F, 12.0F, 1.0F);
      this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.1F);
      this.Nose = new ModelRenderer(this, 46, 0);
      this.Nose.func_78793_a(0.0F, -2.0F, -3.7F);
      this.Nose.func_78790_a(-2.0F, -1.0F, -2.9F, 4, 3, 3, 0.0F);
      this.Head.func_78792_a(this.MuttonchopsR);
      this.Head.func_78792_a(this.MuttonchopsL);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.Head.func_78792_a(this.Nose);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.ArmR1.func_78785_a(f5);
      this.ArmL1.func_78785_a(f5);
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
      this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR1.field_78796_g = 0.0F;
      this.ArmL1.field_78796_g = 0.0F;
   }
}
