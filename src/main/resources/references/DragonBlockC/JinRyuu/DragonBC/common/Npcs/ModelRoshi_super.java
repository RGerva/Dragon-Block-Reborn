package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRoshi_super extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer UpperBody;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Beard1;
   public ModelRenderer Beard2;
   public ModelRenderer Belt;
   public ModelRenderer Lowerbody;
   public ModelRenderer Neck;
   public ModelRenderer Belt2;
   public ModelRenderer Belt3;
   public ModelRenderer Belt4;
   public ModelRenderer FeetR;
   public ModelRenderer FeetL;

   public ModelRoshi_super() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 30, 26);
      this.ArmR.func_78793_a(-3.9F, 5.6F, 0.1F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
      this.FeetL = new ModelRenderer(this, 17, 53);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
      this.UpperBody = new ModelRenderer(this, 3, 23);
      this.UpperBody.func_78793_a(0.0F, 4.0F, 0.1F);
      this.UpperBody.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 49);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.Belt4 = new ModelRenderer(this, 2, 36);
      this.Belt4.func_78793_a(0.6F, 0.5F, 0.0F);
      this.Belt4.func_78790_a(-0.5F, 0.0F, -0.1F, 1, 5, 0, 0.0F);
      this.setRotateAngle(this.Belt4, -0.045553092F, -1.1838568F, -0.091106184F);
      this.Belt = new ModelRenderer(this, 6, 35);
      this.Belt.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Belt.func_78790_a(-3.1F, 5.2F, -1.5F, 6, 2, 3, 0.0F);
      this.Belt3 = new ModelRenderer(this, 2, 36);
      this.Belt3.func_78793_a(0.0F, 0.6F, 0.0F);
      this.Belt3.func_78790_a(-0.4F, 0.0F, -0.5F, 1, 5, 0, 0.0F);
      this.setRotateAngle(this.Belt3, -0.14660765F, -0.31869712F, -0.0418879F);
      this.FeetR = new ModelRenderer(this, 17, 53);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
      this.Lowerbody = new ModelRenderer(this, 4, 41);
      this.Lowerbody.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Lowerbody.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 3, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 49);
      this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.Beard2 = new ModelRenderer(this, 35, 10);
      this.Beard2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Beard2.func_78790_a(-1.5F, -1.8F, -3.7F, 3, 4, 1, 0.0F);
      this.Belt2 = new ModelRenderer(this, 0, 33);
      this.Belt2.func_78793_a(3.0F, 6.8F, -1.7F);
      this.Belt2.func_78790_a(-1.4F, 0.0F, -0.4F, 2, 1, 2, 0.0F);
      this.Neck = new ModelRenderer(this, 7, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.2F, -1.2F, 4, 2, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 30, 26);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(3.9F, 5.6F, 0.1F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
      this.Beard1 = new ModelRenderer(this, 35, 6);
      this.Beard1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Beard1.func_78790_a(-1.9F, -2.4F, -4.0F, 4, 2, 1, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 4.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
      this.LegL.func_78792_a(this.FeetL);
      this.Belt2.func_78792_a(this.Belt4);
      this.UpperBody.func_78792_a(this.Belt);
      this.Belt2.func_78792_a(this.Belt3);
      this.LegR.func_78792_a(this.FeetR);
      this.UpperBody.func_78792_a(this.Lowerbody);
      this.Beard1.func_78792_a(this.Beard2);
      this.Belt.func_78792_a(this.Belt2);
      this.UpperBody.func_78792_a(this.Neck);
      this.Head.func_78792_a(this.Beard1);
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
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
