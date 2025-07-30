package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBotamo extends ModelBase {
   public ModelRenderer BodyBelly;
   public ModelRenderer LegR1;
   public ModelRenderer LegL1;
   public ModelRenderer Head;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer BodyBottom;
   public ModelRenderer BodyTorso;
   public ModelRenderer BodyTop;
   public ModelRenderer LegR2;
   public ModelRenderer LegR3;
   public ModelRenderer LegL2;
   public ModelRenderer LegL3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;

   public ModelBotamo() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.LegR1 = new ModelRenderer(this, 77, 35);
      this.LegR1.func_78793_a(-3.1F, 14.1F, 0.0F);
      this.LegR1.func_78790_a(-1.4F, -0.6F, -1.5F, 3, 4, 3, 0.0F);
      this.Head = new ModelRenderer(this, 71, 0);
      this.Head.func_78793_a(0.0F, -5.6F, 0.0F);
      this.Head.func_78790_a(-3.5F, -4.3F, -4.1F, 7, 5, 6, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 95, 18);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.7F, 0.7F, -2.6F, 3, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.18203785F);
      this.BodyBelly = new ModelRenderer(this, 10, 27);
      this.BodyBelly.func_78793_a(0.0F, -5.6F, 0.0F);
      this.BodyBelly.func_78790_a(-8.5F, 7.5F, -8.0F, 17, 10, 14, 0.0F);
      this.LegL2 = new ModelRenderer(this, 75, 43);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 3.2F, -2.0F, 4, 5, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 68, 0);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-4.3F, -4.3F, -1.3F, 1, 2, 2, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 94, 10);
      this.ArmR1.func_78793_a(-8.2F, -3.7F, 1.8F);
      this.ArmR1.func_78790_a(-1.7F, -1.6F, -2.6F, 4, 3, 4, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 94, 29);
      this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR3.func_78790_a(-2.9F, 6.4F, -2.6F, 4, 8, 4, 0.0F);
      this.setRotateAngle(this.ArmR3, 0.0F, 0.0F, -0.091106184F);
      this.EarL = new ModelRenderer(this, 68, 0);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(3.3F, -4.3F, -1.3F, 1, 2, 2, 0.0F);
      this.LegR2 = new ModelRenderer(this, 75, 43);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 3.2F, -2.0F, 4, 5, 4, 0.0F);
      this.LegL1 = new ModelRenderer(this, 77, 35);
      this.LegL1.field_78809_i = true;
      this.LegL1.func_78793_a(3.3F, 14.2F, 0.0F);
      this.LegL1.func_78790_a(-1.5F, -0.6F, -1.5F, 3, 4, 3, 0.0F);
      this.BodyBottom = new ModelRenderer(this, 19, 52);
      this.BodyBottom.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BodyBottom.func_78790_a(-6.0F, 17.4F, -5.7F, 12, 2, 10, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 95, 18);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-1.7F, 0.7F, -2.6F, 3, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.18203785F);
      this.BodyTorso = new ModelRenderer(this, 17, 11);
      this.BodyTorso.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BodyTorso.func_78790_a(-7.0F, 2.9F, -4.9F, 14, 5, 10, 0.0F);
      this.BodyTop = new ModelRenderer(this, 22, 0);
      this.BodyTop.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BodyTop.func_78790_a(-6.0F, 0.2F, -2.6F, 12, 3, 7, 0.0F);
      this.LegL3 = new ModelRenderer(this, 72, 53);
      this.LegL3.field_78809_i = true;
      this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL3.func_78790_a(-2.5F, 8.0F, -3.9F, 5, 2, 6, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 94, 29);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL3.func_78790_a(-1.4F, 6.4F, -2.6F, 4, 8, 4, 0.0F);
      this.setRotateAngle(this.ArmL3, 0.0F, 0.0F, 0.091106184F);
      this.LegR3 = new ModelRenderer(this, 72, 53);
      this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR3.func_78790_a(-2.5F, 8.0F, -3.9F, 5, 2, 6, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 94, 10);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.5F, -3.7F, 1.8F);
      this.ArmL1.func_78790_a(-2.7F, -1.6F, -2.6F, 4, 3, 4, 0.0F);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.LegL1.func_78792_a(this.LegL2);
      this.Head.func_78792_a(this.EarR);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Head.func_78792_a(this.EarL);
      this.LegR1.func_78792_a(this.LegR2);
      this.BodyBelly.func_78792_a(this.BodyBottom);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.BodyBottom.func_78792_a(this.BodyTorso);
      this.BodyTorso.func_78792_a(this.BodyTop);
      this.LegL2.func_78792_a(this.LegL3);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.LegR2.func_78792_a(this.LegR3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL1.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL1.func_78785_a(f5);
      this.ArmR1.func_78785_a(f5);
      this.BodyBelly.func_78785_a(f5);
      this.LegR1.func_78785_a(f5);
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
      this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR1.field_78796_g = 0.0F;
      this.LegL1.field_78796_g = 0.0F;
      this.ArmR1.field_78796_g = 0.0F;
      this.ArmL1.field_78796_g = 0.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
