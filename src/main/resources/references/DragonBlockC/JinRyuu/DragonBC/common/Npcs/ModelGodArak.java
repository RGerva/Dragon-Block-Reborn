package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGodArak extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Hair;
   public ModelRenderer WhiskersR1;
   public ModelRenderer WhiskersR1_1;
   public ModelRenderer WhiskersR2;
   public ModelRenderer WhiskersR3;
   public ModelRenderer WhiskersR4;
   public ModelRenderer WhiskersR2_1;
   public ModelRenderer WhiskersR3_1;
   public ModelRenderer WhiskersR4_1;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer Cloth1;
   public ModelRenderer Body3;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;
   public ModelRenderer ArmRingR1;
   public ModelRenderer ArmRingR2;
   public ModelRenderer ArmRingL1;
   public ModelRenderer ArmRingL2;

   public ModelGodArak() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.WhiskersR1_1 = new ModelRenderer(this, 31, 1);
      this.WhiskersR1_1.func_78793_a(3.8F, -3.1F, -0.7F);
      this.WhiskersR1_1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR1_1, 0.27314404F, -0.4553564F, -1.1383038F);
      this.ArmR = new ModelRenderer(this, 50, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.Body2 = new ModelRenderer(this, 23, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 5.0F, -3.1F, 7, 3, 5, 0.0F);
      this.ArmRingL2 = new ModelRenderer(this, 25, 51);
      this.ArmRingL2.field_78809_i = true;
      this.ArmRingL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingL2.func_78790_a(-0.4F, 7.4F, -2.3F, 4, 1, 5, 0.0F);
      this.setRotateAngle(this.ArmRingL2, 0.0F, 0.0F, 0.10471976F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
      this.Hair = new ModelRenderer(this, 0, 45);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(-3.5F, -11.8F, -2.6F, 7, 5, 6, 0.0F);
      this.setRotateAngle(this.Hair, -0.034906585F, 0.0F, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 16);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 18);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 5, 4, 0.0F);
      this.WhiskersR3 = new ModelRenderer(this, 31, 1);
      this.WhiskersR3.func_78793_a(0.8F, 0.0F, -0.2F);
      this.WhiskersR3.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR3, 0.0F, 0.091106184F, -0.13665928F);
      this.ArmRingL1 = new ModelRenderer(this, 25, 51);
      this.ArmRingL1.field_78809_i = true;
      this.ArmRingL1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingL1.func_78790_a(-1.3F, 6.4F, -2.3F, 4, 1, 5, 0.0F);
      this.Body3 = new ModelRenderer(this, 21, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.0F, -2.9F, 7, 4, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
      this.Neck = new ModelRenderer(this, 42, 6);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.6F, -0.8F, 4, 2, 2, 0.0F);
      this.WhiskersR1 = new ModelRenderer(this, 31, 1);
      this.WhiskersR1.func_78793_a(-3.8F, -3.1F, -0.7F);
      this.WhiskersR1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR1, 0.27314404F, 0.4553564F, 1.1383038F);
      this.Cloth1 = new ModelRenderer(this, 47, 51);
      this.Cloth1.func_78793_a(0.0F, 9.9F, -2.5F);
      this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 8, 0, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.057595864F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -1.2F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.0F, -4.3F, 8, 7, 8, 0.0F);
      this.WhiskersR3_1 = new ModelRenderer(this, 31, 1);
      this.WhiskersR3_1.func_78793_a(-0.9F, 0.0F, -0.2F);
      this.WhiskersR3_1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR3_1, 0.0F, 0.098087505F, 0.12967797F);
      this.ArmL = new ModelRenderer(this, 50, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.WhiskersR2 = new ModelRenderer(this, 31, 1);
      this.WhiskersR2.func_78793_a(1.2F, 0.5F, 0.1F);
      this.WhiskersR2.func_78790_a(-0.7F, -0.1F, -0.3F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR2, 0.0F, 0.045553092F, -0.091106184F);
      this.LegR2 = new ModelRenderer(this, 0, 16);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.WhiskersR4 = new ModelRenderer(this, 31, 1);
      this.WhiskersR4.func_78793_a(1.0F, 0.0F, -0.1F);
      this.WhiskersR4.func_78790_a(-0.6F, 0.1F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR4, 0.0F, 0.0F, -0.18203785F);
      this.WhiskersR4_1 = new ModelRenderer(this, 31, 1);
      this.WhiskersR4_1.func_78793_a(-0.8F, 0.0F, -0.1F);
      this.WhiskersR4_1.func_78790_a(-0.6F, 0.1F, -0.2F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR4_1, 0.0F, 0.0F, 0.12618731F);
      this.WhiskersR2_1 = new ModelRenderer(this, 31, 1);
      this.WhiskersR2_1.func_78793_a(-0.9F, 0.3F, 0.1F);
      this.WhiskersR2_1.func_78790_a(-0.7F, -0.1F, -0.3F, 1, 3, 0, 0.0F);
      this.setRotateAngle(this.WhiskersR2_1, 0.0F, -0.026005406F, 0.06667158F);
      this.ArmRingR2 = new ModelRenderer(this, 25, 51);
      this.ArmRingR2.field_78809_i = true;
      this.ArmRingR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingR2.func_78790_a(-3.6F, 7.4F, -2.3F, 4, 1, 5, 0.0F);
      this.setRotateAngle(this.ArmRingR2, 0.0F, 0.0F, -0.10471976F);
      this.ArmRingR1 = new ModelRenderer(this, 25, 51);
      this.ArmRingR1.field_78809_i = true;
      this.ArmRingR1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmRingR1.func_78790_a(-2.7F, 6.4F, -2.3F, 4, 1, 5, 0.0F);
      this.Head.func_78792_a(this.WhiskersR1_1);
      this.Body1.func_78792_a(this.Body2);
      this.ArmRingL1.func_78792_a(this.ArmRingL2);
      this.Head.func_78792_a(this.Hair);
      this.LegL.func_78792_a(this.LegL2);
      this.WhiskersR2.func_78792_a(this.WhiskersR3);
      this.ArmL.func_78792_a(this.ArmRingL1);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Neck);
      this.Head.func_78792_a(this.WhiskersR1);
      this.Body1.func_78792_a(this.Cloth1);
      this.WhiskersR2_1.func_78792_a(this.WhiskersR3_1);
      this.WhiskersR1.func_78792_a(this.WhiskersR2);
      this.LegR.func_78792_a(this.LegR2);
      this.WhiskersR3.func_78792_a(this.WhiskersR4);
      this.WhiskersR3_1.func_78792_a(this.WhiskersR4_1);
      this.WhiskersR1_1.func_78792_a(this.WhiskersR2_1);
      this.ArmRingR1.func_78792_a(this.ArmRingR2);
      this.ArmR.func_78792_a(this.ArmRingR1);
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
      this.Cloth1.rotateAngleX = -0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
