package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDrum extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Head_1;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Cloth2;
   public ModelRenderer Cloth;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;

   public ModelDrum() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.LegL = new ModelRenderer(this, 96, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.6F, 10.0F, 1.0F);
      this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
      this.Cloth2 = new ModelRenderer(this, 50, 42);
      this.Cloth2.func_78793_a(0.0F, 12.0F, -3.1F);
      this.Cloth2.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
      this.setRotateAngle(this.Cloth2, -0.05235988F, 0.0F, 0.0F);
      this.EarR = new ModelRenderer(this, 32, 1);
      this.EarR.func_78793_a(-3.5F, -4.4F, -1.0F);
      this.EarR.func_78790_a(-3.5F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
      this.Chest = new ModelRenderer(this, 47, 31);
      this.Chest.func_78793_a(0.0F, 4.2F, -1.5F);
      this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
      this.setRotateAngle(this.Chest, -0.05235988F, 0.0F, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 92, 1);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.8F, -2.5F, 1.7F);
      this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.20943952F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.4F, 0.3F);
      this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
      this.LegR = new ModelRenderer(this, 96, 33);
      this.LegR.func_78793_a(-3.6F, 10.0F, 1.0F);
      this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
      this.Head_1 = new ModelRenderer(this, 35, 0);
      this.Head_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head_1.func_78790_a(0.0F, -7.5F, -3.1F, 0, 6, 8, 0.0F);
      this.Cloth = new ModelRenderer(this, 2, 51);
      this.Cloth.func_78793_a(0.0F, 12.9F, 3.0F);
      this.Cloth.func_78790_a(-8.0F, -0.9F, -2.9F, 16, 7, 6, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 90, 15);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.6F, 5.3F, -0.3F);
      this.ArmL2.func_78790_a(-2.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
      this.ArmR2 = new ModelRenderer(this, 90, 15);
      this.ArmR2.func_78793_a(-0.6F, 5.3F, -0.3F);
      this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
      this.EarL = new ModelRenderer(this, 32, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.8F, -4.4F, -1.0F);
      this.EarL.func_78790_a(0.0F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-7.5F, 8.0F, -3.1F, 15, 7, 9, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 16);
      this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
      this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 92, 1);
      this.ArmR1.func_78793_a(-8.8F, -2.5F, 1.7F);
      this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.20943952F);
      this.Body2.func_78792_a(this.Cloth2);
      this.Head.func_78792_a(this.EarR);
      this.Body1.func_78792_a(this.Chest);
      this.Head.func_78792_a(this.Head_1);
      this.Body2.func_78792_a(this.Cloth);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.EarL);
      this.Body1.func_78792_a(this.Body2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.render(f5);
      this.Body1.render(f5);
      this.ArmR1.render(f5);
      this.ArmL1.render(f5);
      this.LegL.render(f5);
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
      this.ArmR1.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR1.rotateAngleY = 0.0F;
      this.ArmL1.rotateAngleY = 0.0F;
      this.Cloth2.rotateAngleX = -0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegL.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegL.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
