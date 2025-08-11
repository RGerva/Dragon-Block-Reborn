package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGanos extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hat1;
   public ModelRenderer Hair;
   public ModelRenderer Hat2;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelGanos() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Hat1 = new ModelRenderer(this, 32, 0);
      this.Hat1.func_78793_a(0.0F, -5.3F, 0.0F);
      this.Hat1.func_78790_a(-4.0F, -3.0F, -4.0F, 8, 3, 8, 0.0F);
      this.setRotateAngle(this.Hat1, -0.09128072F, 0.0F, 0.0F);
      this.Hair = new ModelRenderer(this, 39, 24);
      this.Hair.func_78793_a(0.0F, -4.0F, 3.5F);
      this.Hair.func_78790_a(-6.0F, -0.3F, 0.0F, 12, 7, 0, 0.0F);
      this.Body1 = new ModelRenderer(this, 1, 17);
      this.Body1.func_78793_a(0.0F, 2.0F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
      this.Hat2 = new ModelRenderer(this, 33, 12);
      this.Hat2.func_78793_a(0.0F, 0.0F, -3.5F);
      this.Hat2.func_78790_a(-3.5F, -0.8F, -0.7F, 7, 2, 8, 0.0F);
      this.setRotateAngle(this.Hat2, 0.036651913F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 23, 24);
      this.ArmR.func_78793_a(-4.3F, 3.3F, 0.0F);
      this.ArmR.func_78790_a(-2.2F, -1.3F, -1.8F, 3, 10, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.0F, -2.0F, 7, 2, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 23, 24);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 3.3F, 0.0F);
      this.ArmL.func_78790_a(-0.8F, -1.3F, -1.8F, 3, 10, 4, 0.0F);
      this.Body2 = new ModelRenderer(this, 3, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 6.0F, -1.6F, 6, 2, 3, 0.0F);
      this.LegR2 = new ModelRenderer(this, 18, 53);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-1.5F, 5.0F, -1.4F, 3, 7, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 53);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 2.3F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.7F);
      this.LegL2 = new ModelRenderer(this, 18, 53);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-1.5F, 5.0F, -1.4F, 3, 7, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 53);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
      this.Head.func_78792_a(this.Hat1);
      this.Head.func_78792_a(this.Hair);
      this.Hat1.func_78792_a(this.Hat2);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.LegR.func_78792_a(this.LegR2);
      this.LegL.func_78792_a(this.LegL2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body1.render(f5);
      this.ArmR.render(f5);
      this.ArmL.render(f5);
      this.LegL.render(f5);
      this.Head.render(f5);
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
