package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHit extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer NeckGuard1;
   public ModelRenderer Chest;
   public ModelRenderer LowerCoatSideL;
   public ModelRenderer LowerCoatBackL;
   public ModelRenderer LowerCoatSideR;
   public ModelRenderer LowerCoatBackR;

   public ModelHit() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.NeckGuard1 = new ModelRenderer(this, 34, 6);
      this.NeckGuard1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckGuard1.func_78790_a(-3.5F, -0.8F, -2.6F, 7, 2, 6, 0.0F);
      this.setRotateAngle(this.NeckGuard1, 0.27314404F, 0.0F, 0.0F);
      this.LowerCoatBackR = new ModelRenderer(this, 23, 38);
      this.LowerCoatBackR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LowerCoatBackR.func_78790_a(0.6F, -0.2F, 1.5F, 1, 7, 1, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -0.5F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.LowerCoatSideR = new ModelRenderer(this, 3, 33);
      this.LowerCoatSideR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LowerCoatSideR.func_78790_a(-2.4F, -0.2F, -2.4F, 3, 9, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.LowerCoatBackL = new ModelRenderer(this, 23, 38);
      this.LowerCoatBackL.field_78809_i = true;
      this.LowerCoatBackL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LowerCoatBackL.func_78790_a(-1.4F, -0.2F, 1.5F, 1, 7, 1, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LowerCoatSideL = new ModelRenderer(this, 3, 33);
      this.LowerCoatSideL.field_78809_i = true;
      this.LowerCoatSideL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LowerCoatSideL.func_78790_a(-0.5F, -0.2F, -2.4F, 3, 9, 5, 0.0F);
      this.Chest = new ModelRenderer(this, 19, 33);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-3.5F, 1.1F, -2.5F, 7, 3, 1, 0.0F);
      this.Body.func_78792_a(this.NeckGuard1);
      this.LegR.func_78792_a(this.LowerCoatBackR);
      this.LegR.func_78792_a(this.LowerCoatSideR);
      this.LegL.func_78792_a(this.LowerCoatBackL);
      this.LegL.func_78792_a(this.LowerCoatSideL);
      this.Body.func_78792_a(this.Chest);
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
