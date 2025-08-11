package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelObni extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hair;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Nose;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;

   public ModelObni() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 45, 12);
      this.ArmR.func_78793_a(-5.0F, -2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 14, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 51, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(4.0F, -4.0F, 0.0F);
      this.EarL.func_78790_a(0.0F, -2.0F, -1.6F, 1, 4, 3, 0.0F);
      this.LegL = new ModelRenderer(this, 43, 32);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 45, 12);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 14, 4, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 30);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 4, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 43, 32);
      this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, -4.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.0F);
      this.Nose = new ModelRenderer(this, 25, 2);
      this.Nose.func_78793_a(0.0F, -3.3F, -3.4F);
      this.Nose.func_78790_a(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
      this.setRotateAngle(this.Nose, -0.13665928F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 39);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 3, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 51, 1);
      this.EarR.func_78793_a(-4.0F, -4.0F, 0.0F);
      this.EarR.func_78790_a(-1.0F, -2.0F, -1.6F, 1, 4, 3, 0.0F);
      this.Chest = new ModelRenderer(this, 26, 21);
      this.Chest.func_78793_a(0.0F, 3.3F, -1.0F);
      this.Chest.func_78790_a(-3.5F, -2.0F, -1.4F, 7, 4, 1, 0.0F);
      this.setRotateAngle(this.Chest, -0.06981317F, 0.0F, 0.0F);
      this.Hair = new ModelRenderer(this, 34, 2);
      this.Hair.func_78793_a(0.0F, 0.0F, 4.0F);
      this.Hair.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 7, 0, 0.0F);
      this.Head.func_78792_a(this.EarL);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.Nose);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.EarR);
      this.Body1.func_78792_a(this.Chest);
      this.Head.func_78792_a(this.Hair);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.ArmR.render(f5);
      this.LegL.render(f5);
      this.ArmL.render(f5);
      this.LegR.render(f5);
      this.Head.render(f5);
      this.Body1.render(f5);
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
