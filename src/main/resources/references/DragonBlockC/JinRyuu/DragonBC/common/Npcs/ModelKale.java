package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKale extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer HairBand;
   public ModelRenderer HairFront1;
   public ModelRenderer Hair2;
   public ModelRenderer HairFront2;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelKale() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmL = new ModelRenderer(this, 32, 29);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 2.5F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.Boobs = new ModelRenderer(this, 19, 27);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 7.9F, -2.0F, 7, 3, 4, 0.0F);
      this.HairFront1 = new ModelRenderer(this, 54, 1);
      this.HairFront1.func_78793_a(1.3F, 0.4F, -3.0F);
      this.HairFront1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
      this.setRotateAngle(this.HairFront1, 0.27314404F, -0.3000221F, -0.22759093F);
      this.Hair2 = new ModelRenderer(this, 37, 0);
      this.Hair2.func_78793_a(-0.4F, -4.2F, 1.6F);
      this.Hair2.func_78790_a(-1.2F, -5.4F, -2.0F, 2, 5, 3, 0.0F);
      this.setRotateAngle(this.Hair2, -0.3642502F, -0.13665928F, -0.091106184F);
      this.HairFront2 = new ModelRenderer(this, 54, 5);
      this.HairFront2.func_78793_a(0.1F, 0.1F, -0.8F);
      this.HairFront2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairFront2, 0.0F, 0.0F, -0.31869712F);
      this.Body2 = new ModelRenderer(this, 0, 27);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.6F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair4 = new ModelRenderer(this, 48, 11);
      this.Hair4.func_78793_a(-0.7F, -2.0F, 0.0F);
      this.Hair4.func_78790_a(-1.2F, -4.1F, -0.9F, 2, 4, 2, 0.0F);
      this.setRotateAngle(this.Hair4, -0.8651597F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.ArmR = new ModelRenderer(this, 32, 29);
      this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.Hair3 = new ModelRenderer(this, 37, 9);
      this.Hair3.func_78793_a(1.2F, 0.6F, -0.2F);
      this.Hair3.func_78790_a(-1.2F, -5.4F, -2.0F, 2, 5, 3, 0.0F);
      this.setRotateAngle(this.Hair3, -0.3642502F, 0.13665928F, 0.18203785F);
      this.HairBand = new ModelRenderer(this, 26, 0);
      this.HairBand.func_78793_a(0.0F, -4.6F, -1.1F);
      this.HairBand.func_78790_a(-1.5F, -5.0F, 1.0F, 3, 2, 2, 0.0F);
      this.setRotateAngle(this.HairBand, -0.7285004F, 0.045553092F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body1.func_78792_a(this.Boobs);
      this.Body2.func_78792_a(this.Body3);
      this.HairBand.func_78792_a(this.HairFront1);
      this.HairBand.func_78792_a(this.Hair2);
      this.HairFront1.func_78792_a(this.HairFront2);
      this.Body1.func_78792_a(this.Body2);
      this.Hair3.func_78792_a(this.Hair4);
      this.Hair2.func_78792_a(this.Hair3);
      this.Head.func_78792_a(this.HairBand);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.Body1.render(f5);
      this.LegR.render(f5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }

   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      int calc = par7Entity.ticksExisted;
      if (calc > 100) {
         calc -= 100;
      }

      float r = 360.0F;
      float r2 = 180.0F;
      this.Head.rotateAngleY = par4 / (r2 / 3.1415927F);
      this.Head.rotateAngleX = par5 / (r2 / 3.1415927F);
      float ex = (float)par7Entity.ticksExisted;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.LegR.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
