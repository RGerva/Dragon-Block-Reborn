package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKakunsa extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer tail1;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Hair;
   public ModelRenderer Head2;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;
   public ModelRenderer tail2;
   public ModelRenderer tail3;
   public ModelRenderer tail4;
   public ModelRenderer tail5;

   public ModelKakunsa() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmL = new ModelRenderer(this, 32, 35);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.tail1 = new ModelRenderer(this, 42, 19);
      this.tail1.func_78793_a(0.0F, 11.4F, 1.6F);
      this.tail1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail1, 1.0011208F, 0.0F, 0.0F);
      this.Head2 = new ModelRenderer(this, 32, 0);
      this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head2.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, 0.0F);
      this.ArmR = new ModelRenderer(this, 32, 35);
      this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.tail4 = new ModelRenderer(this, 42, 19);
      this.tail4.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail4.func_78790_a(-0.5F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail4, 0.20507619F, 0.0F, 0.0F);
      this.tail3 = new ModelRenderer(this, 42, 19);
      this.tail3.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail3, -0.18203785F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
      this.Boobs = new ModelRenderer(this, 19, 31);
      this.Boobs.func_78793_a(0.0F, -0.3F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 2.0F, -0.7F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
      this.EarR = new ModelRenderer(this, 28, 1);
      this.EarR.func_78793_a(-3.0F, -3.4F, -0.5F);
      this.EarR.func_78790_a(-5.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.6981317F, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.EarL = new ModelRenderer(this, 28, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.0F, -3.4F, -0.5F);
      this.EarL.func_78790_a(0.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.6981317F, 0.0F);
      this.tail2 = new ModelRenderer(this, 42, 19);
      this.tail2.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail2, -0.18203785F, 0.0F, 0.0F);
      this.Hair = new ModelRenderer(this, 25, 17);
      this.Hair.func_78793_a(0.0F, -0.1F, 3.95F);
      this.Hair.func_78790_a(-3.5F, -0.3F, 0.0F, 7, 7, 0, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 30);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
      this.tail5 = new ModelRenderer(this, 42, 19);
      this.tail5.func_78793_a(0.0F, 3.1F, 0.0F);
      this.tail5.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail5, 0.27314404F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.Head.func_78792_a(this.Head2);
      this.tail3.func_78792_a(this.tail4);
      this.tail2.func_78792_a(this.tail3);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Boobs);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.tail1.func_78792_a(this.tail2);
      this.Head.func_78792_a(this.Hair);
      this.Body1.func_78792_a(this.Body2);
      this.tail4.func_78792_a(this.tail5);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body1.render(f5);
      this.ArmR.render(f5);
      this.ArmL.render(f5);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.LegR.render(f5);
      this.tail1.render(f5);
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
      this.tail2.rotateAngleX = 0.2F;
      ModelRenderer var10000 = this.tail2;
      var10000.rotateAngleX += r4 / 2.0F;
      this.tail3.rotateAngleX = 0.2F;
      var10000 = this.tail3;
      var10000.rotateAngleX += r4 / 2.0F;
      this.tail4.rotateAngleX = 0.2F;
      var10000 = this.tail4;
      var10000.rotateAngleX += r4 / 2.0F;
      this.tail5.rotateAngleY = 0.2F;
      var10000 = this.tail5;
      var10000.rotateAngleY += r4;
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
