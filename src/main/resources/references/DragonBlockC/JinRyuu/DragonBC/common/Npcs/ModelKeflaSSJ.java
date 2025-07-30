package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKeflaSSJ extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Hair;
   public ModelRenderer Hair1;
   public ModelRenderer Hair2;
   public ModelRenderer HairFrontL1;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer Hair5;
   public ModelRenderer HairFrontR1;
   public ModelRenderer Hair6;
   public ModelRenderer Hair7;
   public ModelRenderer Hair8;
   public ModelRenderer Hair9;
   public ModelRenderer Hair10;
   public ModelRenderer Hair11;
   public ModelRenderer HairFrontL2;
   public ModelRenderer HairFrontR2;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelKeflaSSJ() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Hair1 = new ModelRenderer(this, 36, 0);
      this.Hair1.field_78809_i = true;
      this.Hair1.func_78793_a(-0.2F, -7.0F, -0.3F);
      this.Hair1.func_78790_a(-1.0F, -6.2F, -1.1F, 2, 7, 2, 0.0F);
      this.setRotateAngle(this.Hair1, 0.4098033F, 0.0F, -0.27314404F);
      this.HairFrontR1 = new ModelRenderer(this, 56, 1);
      this.HairFrontR1.func_78793_a(-1.5F, -6.0F, -3.8F);
      this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -1.7F, 2, 1, 2, 0.0F);
      this.setRotateAngle(this.HairFrontR1, 0.4098033F, 0.8651597F, 0.0F);
      this.Hair4 = new ModelRenderer(this, 45, 12);
      this.Hair4.func_78793_a(-2.6F, -6.2F, -0.8F);
      this.Hair4.func_78790_a(-4.7F, -1.6F, -1.4F, 5, 3, 3, 0.0F);
      this.setRotateAngle(this.Hair4, 0.0F, -0.13665928F, -0.31869712F);
      this.Hair2 = new ModelRenderer(this, 45, 0);
      this.Hair2.func_78793_a(-1.1F, -6.5F, -2.3F);
      this.Hair2.func_78790_a(-1.1F, -6.5F, -1.5F, 2, 7, 3, 0.0F);
      this.setRotateAngle(this.Hair2, 0.91053826F, 0.91053826F, 0.0F);
      this.Hair7 = new ModelRenderer(this, 46, 30);
      this.Hair7.func_78793_a(-1.1F, -7.3F, 0.7F);
      this.Hair7.func_78790_a(-2.6F, -6.3F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.Hair7, -0.40142572F, -0.13665928F, -0.2268928F);
      this.Hair9 = new ModelRenderer(this, 44, 19);
      this.Hair9.func_78793_a(2.9F, -4.1F, -0.1F);
      this.Hair9.func_78790_a(-3.3F, -1.9F, -0.7F, 4, 4, 6, 0.0F);
      this.setRotateAngle(this.Hair9, 0.6981317F, 0.6981317F, 0.2268928F);
      this.ArmL = new ModelRenderer(this, 23, 33);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.4F, 2.5F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.ArmR = new ModelRenderer(this, 23, 33);
      this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
      this.ArmR.func_78790_a(-2.8F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.Body2 = new ModelRenderer(this, 0, 27);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
      this.HairFrontR2 = new ModelRenderer(this, 56, 5);
      this.HairFrontR2.func_78793_a(0.4F, 0.0F, -1.7F);
      this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairFrontR2, -0.8196066F, 0.0F, 0.0F);
      this.Hair3 = new ModelRenderer(this, 25, 0);
      this.Hair3.func_78793_a(0.7F, -5.0F, -1.0F);
      this.Hair3.func_78790_a(-1.9F, -6.5F, -2.0F, 3, 5, 2, 0.0F);
      this.setRotateAngle(this.Hair3, 0.18203785F, -0.18203785F, 0.5009095F);
      this.Hair11 = new ModelRenderer(this, 34, 18);
      this.Hair11.func_78793_a(-2.1F, -1.8F, 0.4F);
      this.Hair11.func_78790_a(-1.0F, -0.6F, 0.1F, 2, 1, 4, 0.0F);
      this.setRotateAngle(this.Hair11, 0.3642502F, -0.5009095F, -0.4098033F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair10 = new ModelRenderer(this, 34, 18);
      this.Hair10.field_78809_i = true;
      this.Hair10.func_78793_a(2.5F, -2.0F, 0.4F);
      this.Hair10.func_78790_a(-1.0F, -1.0F, -0.1F, 2, 1, 4, 0.0F);
      this.setRotateAngle(this.Hair10, 0.045553092F, 0.5009095F, 0.4098033F);
      this.HairFrontL2 = new ModelRenderer(this, 56, 5);
      this.HairFrontL2.func_78793_a(0.1F, 0.1F, -1.7F);
      this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 5, 1, 0.0F);
      this.setRotateAngle(this.HairFrontL2, -0.5009095F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 7.9F, -1.9F, 7, 3, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.Hair = new ModelRenderer(this, 0, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(0.0F, -1.2F, 0.0F, 1, 1, 1, 0.0F);
      this.Hair8 = new ModelRenderer(this, 46, 30);
      this.Hair8.func_78793_a(1.4F, -6.3F, 0.7F);
      this.Hair8.func_78790_a(-1.9F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.Hair8, -0.40142572F, 0.045553092F, 0.2268928F);
      this.Boobs = new ModelRenderer(this, 19, 27);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.Hair6 = new ModelRenderer(this, 44, 19);
      this.Hair6.func_78793_a(-2.7F, -4.3F, -0.1F);
      this.Hair6.func_78790_a(-1.0F, -1.9F, -0.5F, 4, 4, 6, 0.0F);
      this.setRotateAngle(this.Hair6, 0.6981317F, -0.6981317F, -0.2268928F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
      this.HairFrontL1 = new ModelRenderer(this, 56, 1);
      this.HairFrontL1.func_78793_a(1.4F, -6.1F, -3.4F);
      this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -2.0F, 2, 1, 2, 0.0F);
      this.setRotateAngle(this.HairFrontL1, 0.22759093F, -0.5462881F, 0.0F);
      this.Hair5 = new ModelRenderer(this, 33, 10);
      this.Hair5.func_78793_a(2.9F, -5.8F, -2.3F);
      this.Hair5.func_78790_a(-0.7F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
      this.setRotateAngle(this.Hair5, 0.0F, -0.27314404F, 0.3642502F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair.func_78792_a(this.Hair1);
      this.Hair.func_78792_a(this.HairFrontR1);
      this.Hair.func_78792_a(this.Hair4);
      this.Hair.func_78792_a(this.Hair2);
      this.Hair.func_78792_a(this.Hair7);
      this.Hair.func_78792_a(this.Hair9);
      this.Body1.func_78792_a(this.Body2);
      this.HairFrontR1.func_78792_a(this.HairFrontR2);
      this.Hair.func_78792_a(this.Hair3);
      this.Hair.func_78792_a(this.Hair11);
      this.Hair.func_78792_a(this.Hair10);
      this.HairFrontL1.func_78792_a(this.HairFrontL2);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.Hair);
      this.Hair.func_78792_a(this.Hair8);
      this.Body1.func_78792_a(this.Boobs);
      this.Hair.func_78792_a(this.Hair6);
      this.Hair.func_78792_a(this.HairFrontL1);
      this.Hair.func_78792_a(this.Hair5);
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
