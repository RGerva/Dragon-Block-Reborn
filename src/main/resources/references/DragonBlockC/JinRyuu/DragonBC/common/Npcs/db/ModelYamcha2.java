package JinRyuu.DragonBC.common.Npcs.db;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelYamcha2 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer HairBack1;
   public ModelRenderer Hair;
   public ModelRenderer HairBack2;
   public ModelRenderer Hair8;
   public ModelRenderer Hair9;
   public ModelRenderer Hair1;
   public ModelRenderer Hair2;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer Hair5;
   public ModelRenderer Hair6;
   public ModelRenderer Hair7;
   public ModelRenderer Hair11;
   public ModelRenderer Hair12;
   public ModelRenderer Hair13;
   public ModelRenderer Hair14;

   public ModelYamcha2() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair11 = new ModelRenderer(this, 49, 0);
      this.Hair11.func_78793_a(2.4F, -6.6F, -2.3F);
      this.Hair11.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 3, 0.0F);
      this.setRotateAngle(this.Hair11, -0.7007497F, 0.091106184F, 1.4114478F);
      this.Hair8 = new ModelRenderer(this, 39, 0);
      this.Hair8.func_78793_a(1.5F, -0.4F, 0.0F);
      this.Hair8.func_78790_a(-1.0F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
      this.Hair13 = new ModelRenderer(this, 31, 1);
      this.Hair13.func_78793_a(-0.1F, -7.6F, -3.9F);
      this.Hair13.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair13, 2.4130921F, 0.091106184F, 0.18203785F);
      this.Hair9 = new ModelRenderer(this, 39, 0);
      this.Hair9.func_78793_a(-1.4F, -0.4F, 0.0F);
      this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
      this.Hair7 = new ModelRenderer(this, 50, 8);
      this.Hair7.func_78793_a(0.2F, -7.0F, -1.9F);
      this.Hair7.func_78790_a(-0.5F, -2.3F, -0.8F, 1, 2, 2, 0.0F);
      this.setRotateAngle(this.Hair7, 0.0F, 0.0F, 0.3970624F);
      this.Hair3 = new ModelRenderer(this, 39, 0);
      this.Hair3.func_78793_a(-2.0F, -2.8F, 2.5F);
      this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.6953392F);
      this.Hair2 = new ModelRenderer(this, 37, 6);
      this.Hair2.func_78793_a(-1.3F, -6.7F, -2.0F);
      this.Hair2.func_78790_a(-4.1F, -1.6F, -0.8F, 3, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair2, 0.0F, -0.47403142F, 0.043284167F);
      this.Hair6 = new ModelRenderer(this, 49, 0);
      this.Hair6.func_78793_a(0.0F, -6.5F, -1.5F);
      this.Hair6.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
      this.setRotateAngle(this.Hair6, -0.091106184F, -0.091106184F, -0.7285004F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair4 = new ModelRenderer(this, 30, 0);
      this.Hair4.func_78793_a(1.9F, -7.0F, 2.1F);
      this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair4, -0.22968534F, -0.2375393F, 0.93462384F);
      this.HairBack1 = new ModelRenderer(this, 1, 33);
      this.HairBack1.func_78793_a(0.0F, 0.0F, 2.7F);
      this.HairBack1.func_78790_a(-2.0F, 0.0F, -0.5F, 4, 3, 2, 0.0F);
      this.Hair1 = new ModelRenderer(this, 30, 0);
      this.Hair1.func_78793_a(-2.0F, -7.1F, -2.8F);
      this.Hair1.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair1, 0.22759093F, -0.091106184F, -0.3642502F);
      this.Hair12 = new ModelRenderer(this, 32, 1);
      this.Hair12.func_78793_a(-1.6F, -7.9F, -3.9F);
      this.Hair12.func_78790_a(-1.0F, -2.6F, -0.8F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair12, 2.5953045F, 0.13665928F, 0.18203785F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair = new ModelRenderer(this, 0, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
      this.HairBack2 = new ModelRenderer(this, 0, 40);
      this.HairBack2.func_78793_a(0.0F, 2.8F, 0.3F);
      this.HairBack2.func_78790_a(-1.5F, 0.0F, -0.5F, 3, 3, 1, 0.0F);
      this.setRotateAngle(this.HairBack2, 0.091106184F, 0.0F, 0.0F);
      this.Hair14 = new ModelRenderer(this, 31, 1);
      this.Hair14.func_78793_a(2.4F, -7.8F, -3.9F);
      this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair14, 2.6862361F, -0.3642502F, -0.13665928F);
      this.Hair5 = new ModelRenderer(this, 39, 0);
      this.Hair5.func_78793_a(2.2F, -2.8F, 2.5F);
      this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
      this.setRotateAngle(this.Hair5, 0.0F, 0.0F, -0.7876671F);
      this.Hair.func_78792_a(this.Hair11);
      this.HairBack1.func_78792_a(this.Hair8);
      this.Hair.func_78792_a(this.Hair13);
      this.HairBack1.func_78792_a(this.Hair9);
      this.Hair.func_78792_a(this.Hair7);
      this.Hair.func_78792_a(this.Hair3);
      this.Hair.func_78792_a(this.Hair2);
      this.Hair.func_78792_a(this.Hair6);
      this.Hair.func_78792_a(this.Hair4);
      this.Head.func_78792_a(this.HairBack1);
      this.Hair.func_78792_a(this.Hair1);
      this.Hair.func_78792_a(this.Hair12);
      this.Head.func_78792_a(this.Hair);
      this.HairBack1.func_78792_a(this.HairBack2);
      this.Hair.func_78792_a(this.Hair14);
      this.Hair.func_78792_a(this.Hair5);
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
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
   }
}
