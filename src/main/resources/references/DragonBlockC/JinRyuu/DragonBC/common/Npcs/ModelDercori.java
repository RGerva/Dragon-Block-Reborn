package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDercori extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmL1;
   public ModelRenderer ArmR1;
   public ModelRenderer Hair;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Hair2;
   public ModelRenderer HairFrontL1;
   public ModelRenderer HairFrontR1;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer HairFrontL2;
   public ModelRenderer HairFrontR2;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer Body4;
   public ModelRenderer Body5;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmR2;

   public ModelDercori() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Hair3 = new ModelRenderer(this, 37, 9);
      this.Hair3.func_78793_a(1.2F, 0.6F, -0.2F);
      this.Hair3.func_78790_a(-1.2F, -6.9F, -1.7F, 2, 6, 3, 0.0F);
      this.setRotateAngle(this.Hair3, -0.5009095F, 0.13665928F, 0.18203785F);
      this.ArmR2 = new ModelRenderer(this, 64, 19);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 64, 6);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(4.7F, -2.0F, 0.0F);
      this.ArmL1.func_78790_a(-1.1F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
      this.setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.0418879F);
      this.Hair2 = new ModelRenderer(this, 37, 0);
      this.Hair2.func_78793_a(-0.4F, -3.0F, 1.6F);
      this.Hair2.func_78790_a(-1.2F, -6.5F, -1.5F, 2, 6, 3, 0.0F);
      this.setRotateAngle(this.Hair2, -0.045553092F, -0.13665928F, -0.091106184F);
      this.ArmR1 = new ModelRenderer(this, 64, 6);
      this.ArmR1.func_78793_a(-4.7F, -2.0F, 0.0F);
      this.ArmR1.func_78790_a(-2.9F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
      this.setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.0418879F);
      this.Hair4 = new ModelRenderer(this, 48, 11);
      this.Hair4.func_78793_a(-0.7F, -2.0F, 0.0F);
      this.Hair4.func_78790_a(-1.2F, -6.0F, -0.9F, 2, 6, 2, 0.0F);
      this.setRotateAngle(this.Hair4, -1.0016445F, 0.0F, 0.0F);
      this.Body5 = new ModelRenderer(this, 32, 47);
      this.Body5.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body5.func_78790_a(-5.0F, 19.0F, -2.6F, 10, 8, 6, 0.0F);
      this.HairFrontR2 = new ModelRenderer(this, 54, 5);
      this.HairFrontR2.func_78793_a(0.1F, 0.1F, -0.8F);
      this.HairFrontR2.func_78790_a(-3.3F, -0.6F, -0.1F, 4, 8, 0, 0.0F);
      this.setRotateAngle(this.HairFrontR2, 0.0F, 0.0F, 0.17627825F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F);
      this.Body4 = new ModelRenderer(this, 0, 50);
      this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body4.func_78790_a(-4.5F, 13.0F, -2.3F, 9, 6, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 64, 19);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.2F);
      this.Hair = new ModelRenderer(this, 26, 0);
      this.Hair.func_78793_a(0.0F, -6.2F, -0.4F);
      this.Hair.func_78790_a(-1.5F, -4.1F, 1.0F, 3, 2, 2, 0.0F);
      this.setRotateAngle(this.Hair, -0.7285004F, 0.045553092F, 0.0F);
      this.HairFrontL1 = new ModelRenderer(this, 54, 1);
      this.HairFrontL1.func_78793_a(1.5F, 1.5F, -3.0F);
      this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
      this.setRotateAngle(this.HairFrontL1, 0.6981317F, -0.2617994F, -0.08726646F);
      this.HairFrontL2 = new ModelRenderer(this, 54, 5);
      this.HairFrontL2.field_78809_i = true;
      this.HairFrontL2.func_78793_a(0.1F, 0.1F, -0.8F);
      this.HairFrontL2.func_78790_a(-0.8F, -0.6F, -0.1F, 4, 8, 0, 0.0F);
      this.setRotateAngle(this.HairFrontL2, 0.0F, 0.0F, -0.25307274F);
      this.HairFrontR1 = new ModelRenderer(this, 54, 1);
      this.HairFrontR1.func_78793_a(-1.5F, 1.5F, -3.0F);
      this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
      this.setRotateAngle(this.HairFrontR1, 0.6981317F, 0.18325958F, 0.08726646F);
      this.Body2 = new ModelRenderer(this, 0, 31);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 6.0F, -1.6F, 7, 3, 3, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 40);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 4, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 0, 0);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.5F, -3.0F, -1.5F);
      this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.7853982F, 0.0F);
      this.EarR = new ModelRenderer(this, 0, 0);
      this.EarR.func_78793_a(-3.5F, -3.0F, -1.5F);
      this.EarR.func_78790_a(-4.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.7853982F, 0.0F);
      this.Hair2.func_78792_a(this.Hair3);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Hair.func_78792_a(this.Hair2);
      this.Hair3.func_78792_a(this.Hair4);
      this.Body4.func_78792_a(this.Body5);
      this.HairFrontR1.func_78792_a(this.HairFrontR2);
      this.Body3.func_78792_a(this.Body4);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Head.func_78792_a(this.Hair);
      this.Hair.func_78792_a(this.HairFrontL1);
      this.HairFrontL1.func_78792_a(this.HairFrontL2);
      this.Hair.func_78792_a(this.HairFrontR1);
      this.Body1.func_78792_a(this.Body2);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.EarL);
      this.Head.func_78792_a(this.EarR);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.ArmL1.render(f5);
      this.ArmR1.render(f5);
      this.Body1.render(f5);
      this.Head.render(f5);
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
      float ex = (float)par7Entity.ticksExisted;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.ArmR1.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR1.rotateAngleY = 0.0F;
      this.ArmL1.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
