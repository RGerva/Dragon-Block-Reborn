package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBeerusMonaka3 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer earR;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer Cape1;
   public ModelRenderer CapeBack;
   public ModelRenderer CapeSideR;
   public ModelRenderer CapeSideL;
   public ModelRenderer CapeFront;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelBeerusMonaka3() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
      this.Head.func_78790_a(-4.1F, -7.7F, -4.0F, 8, 8, 8, 0.0F);
      this.Body2 = new ModelRenderer(this, 17, 37);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-4.0F, 8.0F, -2.3F, 8, 4, 5, 0.0F);
      this.CapeBack = new ModelRenderer(this, 43, 18);
      this.CapeBack.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeBack.func_78790_a(-4.5F, 8.2F, -1.1F, 9, 8, 1, 0.0F);
      this.setRotateAngle(this.CapeBack, 0.09250245F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 33, 47);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.8F, 1.5F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
      this.CapeSideR = new ModelRenderer(this, 47, 35);
      this.CapeSideR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeSideR.func_78790_a(-4.7F, 8.1F, -4.9F, 2, 4, 5, 0.0F);
      this.Body1 = new ModelRenderer(this, 18, 23);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 8, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 39);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.1F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-1.9F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
      this.ArmR = new ModelRenderer(this, 17, 47);
      this.ArmR.func_78793_a(-4.8F, 1.5F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
      this.CapeSideL = new ModelRenderer(this, 47, 35);
      this.CapeSideL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeSideL.func_78790_a(2.7F, 8.2F, -4.9F, 2, 4, 5, 0.0F);
      this.earR = new ModelRenderer(this, 33, 4);
      this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earR.func_78790_a(-6.5F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
      this.setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
      this.Neck = new ModelRenderer(this, 23, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.0F, -0.8F, 4, 2, 2, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 55);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
      this.Cape1 = new ModelRenderer(this, 34, 8);
      this.Cape1.func_78793_a(0.0F, 0.3F, 2.3F);
      this.Cape1.func_78790_a(-4.5F, 5.3F, -5.2F, 9, 3, 6, 0.0F);
      this.CapeFront = new ModelRenderer(this, 45, 28);
      this.CapeFront.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeFront.func_78790_a(-4.1F, 8.2F, -5.0F, 8, 5, 1, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 39);
      this.LegR.func_78793_a(-2.1F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.1F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
      this.LegR2 = new ModelRenderer(this, 0, 55);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
      this.Body1.func_78792_a(this.Body2);
      this.Cape1.func_78792_a(this.CapeBack);
      this.Cape1.func_78792_a(this.CapeSideR);
      this.Cape1.func_78792_a(this.CapeSideL);
      this.Head.func_78792_a(this.earR);
      this.Body1.func_78792_a(this.Neck);
      this.LegL.func_78792_a(this.LegL2);
      this.Body1.func_78792_a(this.Cape1);
      this.Cape1.func_78792_a(this.CapeFront);
      this.LegR.func_78792_a(this.LegR2);
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
      this.LegR.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
