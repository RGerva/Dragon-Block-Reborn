package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelKaleSSJ extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Hair;
   public ModelRenderer HairR2;
   public ModelRenderer HairR1;
   public ModelRenderer HairFrontL1;
   public ModelRenderer HairL1;
   public ModelRenderer HairR3;
   public ModelRenderer HairL2;
   public ModelRenderer HairL3;
   public ModelRenderer HairFrontR1;
   public ModelRenderer HairFrontL2;
   public ModelRenderer HairFrontR2;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelKaleSSJ() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Hair = new ModelRenderer(this, 26, 0);
      this.Hair.func_78793_a(0.0F, -4.6F, -1.1F);
      this.Hair.func_78790_a(-1.5F, -7.0F, -2.6F, 3, 6, 2, 0.0F);
      this.setRotateAngle(this.Hair, -0.53215086F, 0.045553092F, 0.0F);
      this.HairL1 = new ModelRenderer(this, 37, 0);
      this.HairL1.func_78793_a(1.4F, -0.3F, 0.2F);
      this.HairL1.func_78790_a(-1.9F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.HairL1, -0.40142572F, 0.045553092F, 0.2268928F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.HairR1 = new ModelRenderer(this, 37, 0);
      this.HairR1.func_78793_a(-1.1F, -0.2F, -0.4F);
      this.HairR1.func_78790_a(-2.6F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
      this.setRotateAngle(this.HairR1, -0.40142572F, -0.13665928F, -0.2268928F);
      this.HairFrontL1 = new ModelRenderer(this, 54, 1);
      this.HairFrontL1.func_78793_a(1.3F, -0.4F, -2.7F);
      this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
      this.setRotateAngle(this.HairFrontL1, 0.27314404F, -0.3000221F, -0.22759093F);
      this.HairR2 = new ModelRenderer(this, 31, 12);
      this.HairR2.func_78793_a(-2.7F, -0.1F, -0.1F);
      this.HairR2.func_78790_a(-1.0F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
      this.setRotateAngle(this.HairR2, 0.6981317F, -0.6981317F, -0.2268928F);
      this.HairL2 = new ModelRenderer(this, 31, 12);
      this.HairL2.func_78793_a(2.9F, -0.1F, -0.1F);
      this.HairL2.func_78790_a(-3.3F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
      this.setRotateAngle(this.HairL2, 0.6981317F, 0.6981317F, 0.2268928F);
      this.ArmL = new ModelRenderer(this, 32, 29);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.5F, 0.0F);
      this.ArmL.func_78790_a(-1.5F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.Body2 = new ModelRenderer(this, 0, 27);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 4.3F, -1.5F, 6, 4, 3, 0.0F);
      this.HairL3 = new ModelRenderer(this, 50, 12);
      this.HairL3.func_78793_a(2.7F, 1.7F, 2.7F);
      this.HairL3.func_78790_a(-2.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
      this.setRotateAngle(this.HairL3, 0.715585F, 0.5009095F, 0.4098033F);
      this.HairFrontR2 = new ModelRenderer(this, 54, 5);
      this.HairFrontR2.func_78793_a(0.4F, 0.0F, -0.8F);
      this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairFrontR2, -0.07679449F, -0.13665928F, 1.4114478F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.9F, 8, 5, 4, -0.2F);
      this.ArmR = new ModelRenderer(this, 32, 29);
      this.ArmR.func_78793_a(-5.0F, 2.5F, 0.0F);
      this.ArmR.func_78790_a(-2.5F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.Boobs = new ModelRenderer(this, 19, 27);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 1.5F, -0.6F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.HairR3 = new ModelRenderer(this, 50, 12);
      this.HairR3.func_78793_a(-3.2F, 1.7F, 2.7F);
      this.HairR3.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
      this.setRotateAngle(this.HairR3, 0.715585F, -0.5009095F, -0.4098033F);
      this.HairFrontR1 = new ModelRenderer(this, 54, 1);
      this.HairFrontR1.func_78793_a(-0.9F, 0.1F, -2.8F);
      this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
      this.setRotateAngle(this.HairFrontR1, 0.045553092F, 0.091106184F, -0.05863736F);
      this.HairFrontL2 = new ModelRenderer(this, 54, 5);
      this.HairFrontL2.func_78793_a(0.1F, 0.1F, -0.8F);
      this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairFrontL2, 0.0F, 0.0F, -0.31869712F);
      this.Body3 = new ModelRenderer(this, 0, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 7.9F, -2.0F, 7, 3, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Head.func_78792_a(this.Hair);
      this.Hair.func_78792_a(this.HairL1);
      this.Hair.func_78792_a(this.HairR1);
      this.Hair.func_78792_a(this.HairFrontL1);
      this.Hair.func_78792_a(this.HairR2);
      this.Hair.func_78792_a(this.HairL2);
      this.Body1.func_78792_a(this.Body2);
      this.Hair.func_78792_a(this.HairL3);
      this.HairFrontR1.func_78792_a(this.HairFrontR2);
      this.Body1.func_78792_a(this.Boobs);
      this.Hair.func_78792_a(this.HairR3);
      this.Hair.func_78792_a(this.HairFrontR1);
      this.HairFrontL1.func_78792_a(this.HairFrontL2);
      this.Body2.func_78792_a(this.Body3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 1.3F;
      JGRenderHelper.modelScalePositionHelper(1.3F);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      GL11.glPopMatrix();
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
