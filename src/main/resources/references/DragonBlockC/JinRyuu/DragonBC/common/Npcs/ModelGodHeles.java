package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGodHeles extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hat;
   public ModelRenderer HairR;
   public ModelRenderer HairL;
   public ModelRenderer HairB;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;
   public ModelRenderer Cloth1;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelGodHeles() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 21, 23);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
      this.Cloth1 = new ModelRenderer(this, 24, 50);
      this.Cloth1.func_78793_a(0.0F, 11.0F, -1.6F);
      this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.04712389F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 46, 26);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 49);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-0.9F, 0.2F, -1.8F, 3, 8, 4, 0.3F);
      this.Body3 = new ModelRenderer(this, 20, 40);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 32);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hat = new ModelRenderer(this, 33, 1);
      this.Hat.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hat.func_78790_a(-4.0F, -12.6F, -4.5F, 8, 7, 8, 0.0F);
      this.setRotateAngle(this.Hat, -0.08726646F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 23, 33);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-2.9F, 5.0F, -1.6F, 6, 3, 3, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.4F);
      this.LegR2 = new ModelRenderer(this, 0, 32);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.HairB = new ModelRenderer(this, 67, 17);
      this.HairB.func_78793_a(0.0F, 0.0F, 0.0F);
      this.HairB.func_78790_a(-3.0F, -5.9F, 3.0F, 6, 7, 1, 0.0F);
      this.setRotateAngle(this.HairB, 0.02443461F, 0.0F, 0.0F);
      this.Boobs = new ModelRenderer(this, 1, 24);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.5F, 1.6F, -1.2F, 7, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.4537856F, 0.0F, 0.0F);
      this.Neck = new ModelRenderer(this, 6, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.6F, -0.8F, 4, 2, 2, 0.0F);
      this.ArmL = new ModelRenderer(this, 46, 26);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.HairR = new ModelRenderer(this, 67, 2);
      this.HairR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.HairR.func_78790_a(-4.0F, -6.2F, -3.2F, 1, 7, 7, 0.0F);
      this.setRotateAngle(this.HairR, 0.0F, 0.0F, 0.02443461F);
      this.HairL = new ModelRenderer(this, 67, 2);
      this.HairL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.HairL.func_78790_a(3.0F, -6.2F, -3.2F, 1, 7, 7, 0.0F);
      this.setRotateAngle(this.HairL, 0.0F, 0.0F, -0.02443461F);
      this.LegR = new ModelRenderer(this, 0, 49);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.1F, 0.2F, -1.8F, 3, 8, 4, 0.3F);
      this.Body1.func_78792_a(this.Cloth1);
      this.Body1.func_78792_a(this.Body3);
      this.LegL.func_78792_a(this.LegL2);
      this.Head.func_78792_a(this.Hat);
      this.Body1.func_78792_a(this.Body2);
      this.LegR.func_78792_a(this.LegR2);
      this.Head.func_78792_a(this.HairB);
      this.Body1.func_78792_a(this.Boobs);
      this.Body1.func_78792_a(this.Neck);
      this.Head.func_78792_a(this.HairR);
      this.Head.func_78792_a(this.HairL);
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
