package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBiarra extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR1;
   public ModelRenderer LegL1;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Head2;
   public ModelRenderer Body2;
   public ModelRenderer ChestJewelL;
   public ModelRenderer ChestJewelR;
   public ModelRenderer Body3;
   public ModelRenderer Body3_1;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmJewelR;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;
   public ModelRenderer ArmJewelL;
   public ModelRenderer LegR2;
   public ModelRenderer LegR3;
   public ModelRenderer LegL2;
   public ModelRenderer LegL3;

   public ModelBiarra() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body3 = new ModelRenderer(this, 0, 48);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.5F, 15.0F, -2.9F, 11, 6, 7, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 101, 2);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(7.0F, -11.5F, 0.5F);
      this.ArmL1.func_78790_a(0.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.setRotateAngle(this.ArmL1, 0.04363323F, 0.0F, 0.0F);
      this.ChestJewelR = new ModelRenderer(this, 38, 0);
      this.ChestJewelR.func_78793_a(-5.6F, 8.8F, -3.3F);
      this.ChestJewelR.func_78790_a(-1.0F, -0.9F, -1.0F, 2, 2, 1, 0.0F);
      this.ArmJewelL = new ModelRenderer(this, 29, 0);
      this.ArmJewelL.field_78809_i = true;
      this.ArmJewelL.func_78793_a(2.8F, 4.7F, 0.4F);
      this.ArmJewelL.func_78790_a(0.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
      this.LegL2 = new ModelRenderer(this, 66, 17);
      this.LegL2.func_78793_a(0.0F, 7.0F, 0.0F);
      this.LegL2.func_78790_a(-3.0F, 0.0F, -2.6F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.LegL2, 0.04363323F, 0.0F, 0.02617994F);
      this.ChestJewelL = new ModelRenderer(this, 38, 0);
      this.ChestJewelL.func_78793_a(5.6F, 8.8F, -3.3F);
      this.ChestJewelL.func_78790_a(-1.0F, -0.9F, -1.0F, 2, 2, 1, 0.0F);
      this.LegR1 = new ModelRenderer(this, 67, 3);
      this.LegR1.func_78793_a(-3.2F, 6.5F, 0.0F);
      this.LegR1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 7, 6, 0.0F);
      this.setRotateAngle(this.LegR1, -0.04363323F, 0.0F, 0.05235988F);
      this.LegR3 = new ModelRenderer(this, 61, 35);
      this.LegR3.func_78793_a(0.0F, 8.9F, 0.0F);
      this.LegR3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 10, 0.0F);
      this.setRotateAngle(this.LegR3, 0.0F, 0.0F, -0.02617994F);
      this.ArmL2 = new ModelRenderer(this, 102, 15);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(3.0F, 2.9F, 0.0F);
      this.ArmL2.func_78790_a(-2.2F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.06981317F);
      this.LegL3 = new ModelRenderer(this, 61, 35);
      this.LegL3.func_78793_a(0.0F, 8.9F, 0.0F);
      this.LegL3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 10, 0.0F);
      this.setRotateAngle(this.LegL3, 0.0F, 0.0F, 0.02617994F);
      this.LegL1 = new ModelRenderer(this, 67, 3);
      this.LegL1.field_78809_i = true;
      this.LegL1.func_78793_a(3.2F, 6.5F, 0.0F);
      this.LegL1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 7, 6, 0.0F);
      this.setRotateAngle(this.LegL1, -0.04363323F, 0.0F, -0.05235988F);
      this.Body3_1 = new ModelRenderer(this, 32, 48);
      this.Body3_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3_1.func_78790_a(-4.0F, 11.8F, -3.6F, 8, 4, 1, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 13);
      this.Body1.func_78793_a(0.0F, -14.5F, 0.0F);
      this.Body1.func_78790_a(-7.0F, 0.0F, -3.8F, 14, 12, 9, 0.0F);
      this.Head2 = new ModelRenderer(this, 45, 4);
      this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head2.func_78790_a(-1.0F, -5.4F, -2.8F, 2, 1, 7, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 102, 15);
      this.ArmR2.func_78793_a(-3.0F, 2.9F, 0.0F);
      this.ArmR2.func_78790_a(-2.7F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.06981317F);
      this.ArmL3 = new ModelRenderer(this, 101, 29);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(0.0F, 7.3F, -0.5F);
      this.ArmL3.func_78790_a(-2.7F, 0.0F, -2.4F, 6, 13, 6, 0.0F);
      this.setRotateAngle(this.ArmL3, -0.2617994F, 0.0F, 0.034906585F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -14.5F, -0.3F);
      this.Head.func_78790_a(-3.5F, -5.0F, -2.3F, 7, 5, 6, 0.0F);
      this.EarR = new ModelRenderer(this, 29, 5);
      this.EarR.func_78793_a(-3.5F, -3.0F, 0.4F);
      this.EarR.func_78790_a(-1.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
      this.LegR2 = new ModelRenderer(this, 66, 17);
      this.LegR2.func_78793_a(0.0F, 7.0F, 0.0F);
      this.LegR2.func_78790_a(-3.0F, 0.0F, -2.6F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.LegR2, 0.04363323F, 0.0F, -0.02617994F);
      this.ArmR3 = new ModelRenderer(this, 101, 29);
      this.ArmR3.func_78793_a(0.0F, 7.3F, -0.5F);
      this.ArmR3.func_78790_a(-3.2F, 0.0F, -2.4F, 6, 13, 6, 0.0F);
      this.setRotateAngle(this.ArmR3, -0.2617994F, 0.0F, -0.034906585F);
      this.Body2 = new ModelRenderer(this, 0, 36);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 3, 7, 0.0F);
      this.ArmJewelR = new ModelRenderer(this, 29, 0);
      this.ArmJewelR.func_78793_a(-2.8F, 4.7F, 0.4F);
      this.ArmJewelR.func_78790_a(-1.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 101, 2);
      this.ArmR1.func_78793_a(-7.0F, -11.5F, 0.5F);
      this.ArmR1.func_78790_a(-6.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.setRotateAngle(this.ArmR1, 0.04363323F, 0.0F, 0.0F);
      this.EarL = new ModelRenderer(this, 29, 5);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.5F, -3.0F, 0.4F);
      this.EarL.func_78790_a(0.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.ChestJewelR);
      this.ArmL3.func_78792_a(this.ArmJewelL);
      this.LegL1.func_78792_a(this.LegL2);
      this.Body1.func_78792_a(this.ChestJewelL);
      this.LegR2.func_78792_a(this.LegR3);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.LegL2.func_78792_a(this.LegL3);
      this.Body3.func_78792_a(this.Body3_1);
      this.Head.func_78792_a(this.Head2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Head.func_78792_a(this.EarR);
      this.LegR1.func_78792_a(this.LegR2);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Body1.func_78792_a(this.Body2);
      this.ArmR3.func_78792_a(this.ArmJewelR);
      this.Head.func_78792_a(this.EarL);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.LegL1.render(f5);
      this.Head.render(f5);
      this.ArmL1.render(f5);
      this.ArmR1.render(f5);
      this.Body1.render(f5);
      this.LegR1.render(f5);
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
      this.LegR1.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL1.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR1.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR1.rotateAngleY = 0.0F;
      this.LegL1.rotateAngleY = 0.0F;
      this.ArmR1.rotateAngleY = 0.0F;
      this.ArmL1.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
