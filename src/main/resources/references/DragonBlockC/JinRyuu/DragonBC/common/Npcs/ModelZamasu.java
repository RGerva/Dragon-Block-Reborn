package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZamasu extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Hair1;
   public ModelRenderer earR;
   public ModelRenderer earL;
   public ModelRenderer Hair2;
   public ModelRenderer Hair3;
   public ModelRenderer Hair4;
   public ModelRenderer Hair5;
   public ModelRenderer earR2;
   public ModelRenderer earL2;
   public ModelRenderer Body2;
   public ModelRenderer ClothF;
   public ModelRenderer Body3;
   public ModelRenderer ShoulderR;
   public ModelRenderer ShoulderL;

   public ModelZamasu() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.earR2 = new ModelRenderer(this, 30, 1);
      this.earR2.func_78793_a(-0.5F, 1.2F, 0.0F);
      this.earR2.func_78790_a(-0.4F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
      this.setRotateAngle(this.earR2, 0.0F, -0.34906584F, -0.34906584F);
      this.LegL = new ModelRenderer(this, 0, 45);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 11.0F, 0.0F);
      this.LegL.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 3, 18);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-1.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
      this.Hair2 = new ModelRenderer(this, 46, 6);
      this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair2.func_78790_a(-1.3F, -11.2F, -5.0F, 2, 2, 6, 0.0F);
      this.earL2 = new ModelRenderer(this, 30, 1);
      this.earL2.field_78809_i = true;
      this.earL2.func_78793_a(0.3F, 1.2F, 0.0F);
      this.earL2.func_78790_a(-0.5F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
      this.setRotateAngle(this.earL2, 0.0F, 0.34906584F, 0.34906584F);
      this.ClothF = new ModelRenderer(this, 25, 51);
      this.ClothF.func_78793_a(0.0F, 9.0F, -2.1F);
      this.ClothF.func_78790_a(-2.0F, 0.0F, 0.1F, 4, 11, 0, 0.0F);
      this.setRotateAngle(this.ClothF, -0.061086524F, 0.0F, 0.0F);
      this.Hair1 = new ModelRenderer(this, 33, 0);
      this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair1.func_78790_a(-1.4F, -9.7F, -4.0F, 3, 3, 6, 0.0F);
      this.Body3 = new ModelRenderer(this, 20, 43);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -1.1F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.3F, -4.0F, 8, 8, 8, -0.5F);
      this.Body2 = new ModelRenderer(this, 23, 36);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 7.0F, -1.7F, 7, 2, 3, 0.0F);
      this.earR = new ModelRenderer(this, 0, 1);
      this.earR.func_78793_a(-3.2F, -1.9F, -1.5F);
      this.earR.func_78790_a(-4.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
      this.setRotateAngle(this.earR, 0.1134464F, 0.5235988F, 0.34906584F);
      this.ArmR = new ModelRenderer(this, 0, 27);
      this.ArmR.func_78793_a(-5.0F, -0.1F, 0.0F);
      this.ArmR.func_78790_a(-1.9F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
      this.Hair3 = new ModelRenderer(this, 46, 0);
      this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair3.func_78790_a(-0.7F, -12.0F, -1.7F, 1, 1, 2, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 3, 18);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-5.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
      this.Hair4 = new ModelRenderer(this, 46, 6);
      this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair4.func_78790_a(-1.5F, -10.6F, -0.6F, 2, 3, 6, 0.0F);
      this.setRotateAngle(this.Hair4, 0.8651597F, 0.0F, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 23);
      this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
      this.earL = new ModelRenderer(this, 0, 4);
      this.earL.func_78793_a(3.2F, -1.9F, -1.5F);
      this.earL.func_78790_a(0.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
      this.setRotateAngle(this.earL, 0.1134464F, -0.5235988F, -0.34906584F);
      this.LegR = new ModelRenderer(this, 0, 45);
      this.LegR.func_78793_a(-1.9F, 11.0F, 0.0F);
      this.LegR.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
      this.Hair5 = new ModelRenderer(this, 46, 0);
      this.Hair5.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair5.func_78790_a(-1.3F, -9.2F, -1.8F, 1, 2, 2, 0.0F);
      this.ArmL = new ModelRenderer(this, 0, 27);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -0.1F, 0.0F);
      this.ArmL.func_78790_a(-1.1F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
      this.earR.func_78792_a(this.earR2);
      this.ArmL.func_78792_a(this.ShoulderL);
      this.Hair1.func_78792_a(this.Hair2);
      this.earL.func_78792_a(this.earL2);
      this.Body1.func_78792_a(this.ClothF);
      this.Head.func_78792_a(this.Hair1);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.earR);
      this.Hair1.func_78792_a(this.Hair3);
      this.ArmR.func_78792_a(this.ShoulderR);
      this.Hair1.func_78792_a(this.Hair4);
      this.Head.func_78792_a(this.earL);
      this.Hair4.func_78792_a(this.Hair5);
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
      this.ClothF.rotateAngleX = -0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
