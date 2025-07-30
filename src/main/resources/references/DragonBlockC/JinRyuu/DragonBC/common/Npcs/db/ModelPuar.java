package JinRyuu.DragonBC.common.Npcs.db;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPuar extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer EarR2;
   public ModelRenderer EarL2;
   public ModelRenderer Body2;
   public ModelRenderer tail1;
   public ModelRenderer tail2;
   public ModelRenderer tail3;
   public ModelRenderer tail4;
   public ModelRenderer tail5;

   public ModelPuar() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.EarL2 = new ModelRenderer(this, 31, 7);
      this.EarL2.field_78809_i = true;
      this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL2.func_78790_a(0.4F, -9.3F, 0.0F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarL2, -0.006981317F, 0.0F, 0.0F);
      this.tail4 = new ModelRenderer(this, 42, 1);
      this.tail4.func_78793_a(0.0F, 0.2F, 2.6F);
      this.tail4.func_78790_a(-1.0F, -1.1F, 0.0F, 2, 2, 3, 0.0F);
      this.EarL = new ModelRenderer(this, 31, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(0.4F, -10.5F, 0.1F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
      this.tail3 = new ModelRenderer(this, 42, 1);
      this.tail3.func_78793_a(0.0F, 0.0F, 2.6F);
      this.tail3.func_78790_a(-1.0F, -0.9F, -0.1F, 2, 2, 3, 0.0F);
      this.LegL = new ModelRenderer(this, 4, 37);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.4F, 22.0F, 0.3F);
      this.LegL.func_78790_a(-1.5F, 0.0F, -4.3F, 3, 2, 6, 0.0F);
      this.tail1 = new ModelRenderer(this, 42, 1);
      this.tail1.func_78793_a(0.0F, 5.0F, 3.3F);
      this.tail1.func_78790_a(-1.0F, -0.8F, -0.8F, 2, 2, 3, 0.0F);
      this.tail2 = new ModelRenderer(this, 42, 1);
      this.tail2.func_78793_a(0.0F, 0.1F, 2.2F);
      this.tail2.func_78790_a(-1.0F, -0.9F, -0.2F, 2, 2, 3, 0.0F);
      this.EarR = new ModelRenderer(this, 31, 1);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-3.4F, -10.5F, -0.1F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 4, 37);
      this.LegR.func_78793_a(-2.4F, 22.0F, 0.3F);
      this.LegR.func_78790_a(-1.5F, 0.0F, -4.3F, 3, 2, 6, 0.0F);
      this.tail5 = new ModelRenderer(this, 52, 0);
      this.tail5.func_78793_a(0.0F, -0.1F, 2.9F);
      this.tail5.func_78790_a(-1.0F, -1.0F, -0.1F, 2, 2, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 15.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -5.7F, -4.1F, 8, 6, 7, -0.2F);
      this.Body1 = new ModelRenderer(this, 3, 15);
      this.Body1.func_78793_a(0.0F, 14.7F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.3F, -2.5F, 7, 3, 5, 0.0F);
      this.EarR2 = new ModelRenderer(this, 31, 7);
      this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR2.func_78790_a(-3.4F, -9.3F, -0.2F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarR2, -0.006981317F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 1, 24);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-4.0F, 3.3F, -3.0F, 8, 4, 6, 0.0F);
      this.ArmL = new ModelRenderer(this, 33, 17);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(3.8F, 15.9F, 0.0F);
      this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 2, 4, 3, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.21327923F);
      this.ArmR = new ModelRenderer(this, 33, 17);
      this.ArmR.func_78793_a(-3.8F, 15.9F, 0.0F);
      this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 4, 3, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.1972222F);
      this.EarL.func_78792_a(this.EarL2);
      this.tail3.func_78792_a(this.tail4);
      this.Head.func_78792_a(this.EarL);
      this.tail2.func_78792_a(this.tail3);
      this.Body1.func_78792_a(this.tail1);
      this.tail1.func_78792_a(this.tail2);
      this.Head.func_78792_a(this.EarR);
      this.tail4.func_78792_a(this.tail5);
      this.EarR.func_78792_a(this.EarR2);
      this.Body1.func_78792_a(this.Body2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
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
