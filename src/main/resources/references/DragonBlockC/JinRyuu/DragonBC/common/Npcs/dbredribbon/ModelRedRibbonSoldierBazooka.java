package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRedRibbonSoldierBazooka extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer Bazooka1;
   public ModelRenderer Bazooka2;
   public ModelRenderer Bazooka3;
   public ModelRenderer Bazooka4;
   public ModelRenderer Bazooka5;
   public ModelRenderer Bazooka6;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;
   public ModelRenderer Ribbon;

   public ModelRedRibbonSoldierBazooka() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Bazooka4 = new ModelRenderer(this, 49, 45);
      this.Bazooka4.func_78793_a(0.0F, 0.0F, 2.0F);
      this.Bazooka4.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 2, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 0, 32);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR2, -1.0871656F, -0.3642502F, 0.0F);
      this.Bazooka3 = new ModelRenderer(this, 49, 53);
      this.Bazooka3.func_78793_a(0.0F, -1.2F, 3.9F);
      this.Bazooka3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 2, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.Bazooka2 = new ModelRenderer(this, 34, 55);
      this.Bazooka2.func_78793_a(0.0F, 1.1F, 0.8F);
      this.Bazooka2.func_78790_a(-0.9F, 0.4F, 0.0F, 2, 3, 1, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 0, 43);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(-1.2F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL2, -1.2292354F, 0.91053826F, 0.3642502F);
      this.ArmL = new ModelRenderer(this, 0, 0);
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 17, 32);
      this.ArmR3.func_78793_a(-1.0F, 4.0F, 0.0F);
      this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR3, -1.1124729F, 0.091106184F, 0.0F);
      this.Ribbon = new ModelRenderer(this, 41, 20);
      this.Ribbon.func_78793_a(2.8F, 0.9F, 0.0F);
      this.Ribbon.func_78790_a(0.0F, -1.9F, 0.0F, 6, 5, 0, 0.0F);
      this.setRotateAngle(this.Ribbon, 0.0F, -0.95609134F, 0.0F);
      this.ArmR = new ModelRenderer(this, 0, 0);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Bazooka6 = new ModelRenderer(this, 51, 33);
      this.Bazooka6.func_78793_a(0.0F, 0.0F, 1.9F);
      this.Bazooka6.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 17, 43);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(1.0F, 4.0F, 0.0F);
      this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.Bazooka5 = new ModelRenderer(this, 49, 38);
      this.Bazooka5.func_78793_a(0.0F, 0.0F, 1.9F);
      this.Bazooka5.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 2, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Bazooka1 = new ModelRenderer(this, 27, 45);
      this.Bazooka1.func_78793_a(-0.2F, 4.1F, -2.0F);
      this.Bazooka1.func_78790_a(-1.5F, -1.5F, -10.2F, 3, 3, 15, 0.0F);
      this.setRotateAngle(this.Bazooka1, -0.9822713F, -0.22759093F, 0.18203785F);
      this.Bazooka3.func_78792_a(this.Bazooka4);
      this.ArmR.func_78792_a(this.ArmR2);
      this.Bazooka2.func_78792_a(this.Bazooka3);
      this.Bazooka1.func_78792_a(this.Bazooka2);
      this.ArmL.func_78792_a(this.ArmL2);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.ArmL2.func_78792_a(this.Ribbon);
      this.Bazooka5.func_78792_a(this.Bazooka6);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Bazooka4.func_78792_a(this.Bazooka5);
      this.ArmR3.func_78792_a(this.Bazooka1);
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
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
   }
}
