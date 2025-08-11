package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTagoma extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer NeckGuard1;
   public ModelRenderer Body3;
   public ModelRenderer NeckGuard2;
   public ModelRenderer ShoulderR;
   public ModelRenderer ShoulderL;

   public ModelTagoma() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body3 = new ModelRenderer(this, 20, 37);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 18);
      this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
      this.Neck = new ModelRenderer(this, 7, 22);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -0.4F, -0.8F, 4, 1, 2, 0.0F);
      this.Body2 = new ModelRenderer(this, 23, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 5.0F, -1.5F, 7, 4, 3, 0.0F);
      this.NeckGuard1 = new ModelRenderer(this, 0, 55);
      this.NeckGuard1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckGuard1.func_78790_a(-4.0F, -1.0F, -0.3F, 8, 3, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 33, 8);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-1.0F, -1.5F, -1.8F, 6, 3, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.NeckGuard2 = new ModelRenderer(this, 25, 56);
      this.NeckGuard2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckGuard2.func_78790_a(-4.0F, -3.0F, 1.7F, 8, 2, 3, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 33, 8);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-5.0F, -1.5F, -1.8F, 6, 3, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 47, 19);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -0.7F, 0.0F);
      this.ArmL.func_78790_a(-1.1F, -1.3F, -1.8F, 3, 12, 4, -0.1F);
      this.ArmR = new ModelRenderer(this, 47, 19);
      this.ArmR.func_78793_a(-5.0F, -0.7F, 0.0F);
      this.ArmR.func_78790_a(-1.9F, -1.3F, -1.8F, 3, 12, 4, -0.1F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.1F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.7F, -4.0F, 8, 8, 8, -0.5F);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Neck);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.NeckGuard1);
      this.ArmL.func_78792_a(this.ShoulderL);
      this.NeckGuard1.func_78792_a(this.NeckGuard2);
      this.ArmR.func_78792_a(this.ShoulderR);
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
