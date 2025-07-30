package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZeno extends ModelBase {
   public ModelRenderer Body1;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Head;
   public ModelRenderer Body2;
   public ModelRenderer ShoulderR;
   public ModelRenderer ShoulderL;
   public ModelRenderer EarR;
   public ModelRenderer EarL;

   public ModelZeno() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 8.2F, 0.0F);
      this.Head.func_78790_a(-4.0F, -5.6F, -3.6F, 8, 6, 7, -0.2F);
      this.LegR = new ModelRenderer(this, 30, 22);
      this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
      this.LegR.func_78790_a(-1.1F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 27, 13);
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(3.1F, 1.0F, -1.9F, 3, 2, 4, 0.0F);
      this.setRotateAngle(this.ShoulderL, 0.0F, 0.0F, -0.13665928F);
      this.EarL = new ModelRenderer(this, 0, 0);
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(3.7F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
      this.Body2 = new ModelRenderer(this, 37, 0);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-4.0F, 4.1F, -2.4F, 8, 7, 5, 0.0F);
      this.EarR = new ModelRenderer(this, 0, 0);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-4.7F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 27, 13);
      this.ShoulderR.field_78809_i = true;
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-6.2F, 1.0F, -1.9F, 3, 2, 4, 0.0F);
      this.setRotateAngle(this.ShoulderR, 0.0F, 0.0F, 0.13665928F);
      this.ArmL = new ModelRenderer(this, 42, 22);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.2F, 9.5F, 0.1F);
      this.ArmL.func_78790_a(-0.6F, -0.6F, -1.6F, 2, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.15358898F);
      this.LegL = new ModelRenderer(this, 30, 22);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
      this.LegL.func_78790_a(-1.1F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 14);
      this.Body1.func_78793_a(0.0F, 8.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.3F, -2.4F, 8, 4, 5, -0.1F);
      this.ArmR = new ModelRenderer(this, 42, 22);
      this.ArmR.func_78793_a(-4.1F, 9.5F, 0.1F);
      this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.15358898F);
      this.Body1.func_78792_a(this.ShoulderL);
      this.Head.func_78792_a(this.EarL);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.EarR);
      this.Body1.func_78792_a(this.ShoulderR);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
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
