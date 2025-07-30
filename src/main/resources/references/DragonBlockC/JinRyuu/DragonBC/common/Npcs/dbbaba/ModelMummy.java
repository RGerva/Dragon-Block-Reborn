package JinRyuu.DragonBC.common.Npcs.dbbaba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMummy extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Body2;

   public ModelMummy() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
      this.Head.func_78790_a(-4.0F, -8.1F, -4.0F, 8, 8, 8, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
      this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 47, 1);
      this.ArmR1.func_78793_a(-8.8F, -3.0F, 1.7F);
      this.ArmR1.func_78790_a(-3.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
      this.LegL = new ModelRenderer(this, 49, 23);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.6F, 10.0F, 1.5F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-6.5F, 8.0F, -2.2F, 13, 7, 7, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 47, 1);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.8F, -3.0F, 1.7F);
      this.ArmL1.func_78790_a(-1.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
      this.LegR = new ModelRenderer(this, 49, 23);
      this.LegR.func_78793_a(-3.6F, 10.0F, 1.5F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
      this.Body1.func_78792_a(this.Body2);
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
