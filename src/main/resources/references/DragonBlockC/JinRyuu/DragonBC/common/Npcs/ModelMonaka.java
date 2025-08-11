package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMonaka extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer UpperBody;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer earR;
   public ModelRenderer earL;
   public ModelRenderer Lowerbody;
   public ModelRenderer Neck;
   public ModelRenderer FeetR;
   public ModelRenderer FeetL;

   public ModelMonaka() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Neck = new ModelRenderer(this, 7, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-1.5F, -0.8F, -0.8F, 3, 2, 2, 0.0F);
      this.UpperBody = new ModelRenderer(this, 3, 23);
      this.UpperBody.func_78793_a(0.0F, 4.0F, 0.0F);
      this.UpperBody.func_78790_a(-3.5F, 0.0F, -1.4F, 7, 7, 3, 0.0F);
      this.earR = new ModelRenderer(this, 33, 8);
      this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earR.func_78790_a(-5.4F, -4.5F, -2.7F, 3, 2, 1, 0.0F);
      this.setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
      this.ArmL = new ModelRenderer(this, 30, 26);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(3.7F, 5.2F, 0.1F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, -0.8F);
      this.ArmR = new ModelRenderer(this, 30, 26);
      this.ArmR.func_78793_a(-3.7F, 5.1F, 0.1F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, -0.8F);
      this.LegL = new ModelRenderer(this, 0, 49);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 13.7F, 0.0F);
      this.LegL.func_78790_a(-2.0F, -0.8F, -2.0F, 4, 10, 4, -0.8F);
      this.earL = new ModelRenderer(this, 33, 8);
      this.earL.field_78809_i = true;
      this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earL.func_78790_a(2.3F, -4.6F, -2.7F, 3, 2, 1, 0.0F);
      this.setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 49);
      this.LegR.func_78793_a(-1.9F, 13.7F, 0.0F);
      this.LegR.func_78790_a(-2.0F, -0.8F, -2.0F, 4, 10, 4, -0.8F);
      this.Head = new ModelRenderer(this, 0, 1);
      this.Head.func_78793_a(0.0F, 4.3F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.1F, -4.2F, 8, 7, 8, -0.6F);
      this.FeetR = new ModelRenderer(this, 17, 53);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-1.5F, 8.3F, -2.5F, 3, 2, 4, 0.0F);
      this.FeetL = new ModelRenderer(this, 17, 53);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-1.5F, 8.3F, -2.5F, 3, 2, 4, 0.0F);
      this.Lowerbody = new ModelRenderer(this, 4, 36);
      this.Lowerbody.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Lowerbody.func_78790_a(-3.5F, 6.8F, -2.0F, 7, 3, 4, 0.0F);
      this.UpperBody.func_78792_a(this.Neck);
      this.Head.func_78792_a(this.earR);
      this.Head.func_78792_a(this.earL);
      this.LegR.func_78792_a(this.FeetR);
      this.LegL.func_78792_a(this.FeetL);
      this.UpperBody.func_78792_a(this.Lowerbody);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.UpperBody.render(f5);
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
