package JinRyuu.DragonBC.common.Npcs.dbbaba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDevil extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer tail1;
   public ModelRenderer HornL;
   public ModelRenderer HornR;
   public ModelRenderer HornL2;
   public ModelRenderer HornL3;
   public ModelRenderer HornR2;
   public ModelRenderer HornR3;
   public ModelRenderer WingR;
   public ModelRenderer WingL;
   public ModelRenderer tail2;
   public ModelRenderer tail3;
   public ModelRenderer tail4;
   public ModelRenderer tail5;

   public ModelDevil() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.WingL = new ModelRenderer(this, 0, 34);
      this.WingL.field_78809_i = true;
      this.WingL.func_78793_a(2.9F, 2.0F, 2.0F);
      this.WingL.func_78790_a(0.0F, -9.0F, 0.0F, 19, 19, 0, 0.0F);
      this.setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.HornL2 = new ModelRenderer(this, 42, 8);
      this.HornL2.field_78809_i = true;
      this.HornL2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.HornL2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.HornL2, -0.12217305F, 0.0F, 0.12217305F);
      this.tail2 = new ModelRenderer(this, 32, 0);
      this.tail2.func_78793_a(0.0F, 0.0F, 4.0F);
      this.tail2.func_78790_a(-0.5F, -0.0F, 0.0F, 1, 0, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.tail5 = new ModelRenderer(this, 32, 5);
      this.tail5.func_78793_a(0.0F, 0.0F, 4.0F);
      this.tail5.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 0, 3, 0.0F);
      this.HornR3 = new ModelRenderer(this, 51, 9);
      this.HornR3.func_78793_a(0.0F, -3.2F, 0.0F);
      this.HornR3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HornR3, -0.08726646F, 0.0F, -0.08726646F);
      this.HornR = new ModelRenderer(this, 42, 1);
      this.HornR.func_78793_a(-2.1F, -7.3F, -1.3F);
      this.HornR.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
      this.setRotateAngle(this.HornR, -0.43633232F, 0.0F, -0.04363323F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.tail3 = new ModelRenderer(this, 32, 0);
      this.tail3.func_78793_a(0.0F, 0.0F, 4.0F);
      this.tail3.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.tail1 = new ModelRenderer(this, 32, 0);
      this.tail1.func_78793_a(0.0F, 10.4F, 1.9F);
      this.tail1.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.tail4 = new ModelRenderer(this, 32, 0);
      this.tail4.func_78793_a(0.0F, 0.0F, 4.0F);
      this.tail4.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.HornR2 = new ModelRenderer(this, 42, 8);
      this.HornR2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.HornR2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.HornR2, -0.12217305F, 0.0F, -0.13665928F);
      this.HornL = new ModelRenderer(this, 42, 1);
      this.HornL.field_78809_i = true;
      this.HornL.func_78793_a(2.1F, -7.3F, -1.3F);
      this.HornL.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
      this.setRotateAngle(this.HornL, -0.43633232F, 0.0F, 0.08726646F);
      this.WingR = new ModelRenderer(this, 0, 34);
      this.WingR.func_78793_a(-2.9F, 2.0F, 2.0F);
      this.WingR.func_78790_a(-19.0F, -9.0F, 0.0F, 19, 19, 0, 0.0F);
      this.setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
      this.HornL3 = new ModelRenderer(this, 51, 9);
      this.HornL3.field_78809_i = true;
      this.HornL3.func_78793_a(0.0F, -3.2F, 0.0F);
      this.HornL3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HornL3, -0.08726646F, 0.0F, 0.08726646F);
      this.Body.func_78792_a(this.WingL);
      this.HornL.func_78792_a(this.HornL2);
      this.tail1.func_78792_a(this.tail2);
      this.tail4.func_78792_a(this.tail5);
      this.HornR2.func_78792_a(this.HornR3);
      this.Head.func_78792_a(this.HornR);
      this.tail2.func_78792_a(this.tail3);
      this.tail3.func_78792_a(this.tail4);
      this.HornR.func_78792_a(this.HornR2);
      this.Head.func_78792_a(this.HornL);
      this.Body.func_78792_a(this.WingR);
      this.HornL2.func_78792_a(this.HornL3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.Body.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      this.tail1.func_78785_a(f5);
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
      this.tail1.field_78795_f = 0.2F;
      ModelRenderer var10000 = this.tail1;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail2.field_78795_f = 0.2F;
      var10000 = this.tail2;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail3.field_78795_f = 0.2F;
      var10000 = this.tail3;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail4.field_78795_f = 0.2F;
      var10000 = this.tail4;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail5.field_78796_g = 0.2F;
      var10000 = this.tail5;
      var10000.field_78796_g += r4;
      this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
   }
}
