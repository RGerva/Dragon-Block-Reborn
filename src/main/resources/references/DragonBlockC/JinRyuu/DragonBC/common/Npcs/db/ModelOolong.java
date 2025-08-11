package JinRyuu.DragonBC.common.Npcs.db;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOolong extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer EarR1;
   public ModelRenderer EarL1;
   public ModelRenderer Head_1;
   public ModelRenderer EarR2;
   public ModelRenderer EarL2;

   public ModelOolong() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head_1 = new ModelRenderer(this, 35, 0);
      this.Head_1.func_78793_a(0.0F, -3.0F, -2.8F);
      this.Head_1.func_78790_a(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
      this.ArmR = new ModelRenderer(this, 17, 33);
      this.ArmR.func_78793_a(-5.0F, 8.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -0.6F, -1.4F, 3, 8, 3, 0.2F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 7.2F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.1F, -3.6F, 8, 8, 7, 0.0F);
      this.EarR1 = new ModelRenderer(this, 31, 24);
      this.EarR1.func_78793_a(-3.9F, -6.6F, 0.0F);
      this.EarR1.func_78790_a(-2.0F, -2.5F, 0.0F, 4, 4, 1, 0.0F);
      this.setRotateAngle(this.EarR1, 0.13665928F, 0.18203785F, -0.91053826F);
      this.EarR2 = new ModelRenderer(this, 31, 31);
      this.EarR2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.EarR2.func_78790_a(-2.0F, -0.5F, -3.0F, 4, 1, 4, 0.0F);
      this.EarL2 = new ModelRenderer(this, 31, 31);
      this.EarL2.field_78809_i = true;
      this.EarL2.func_78793_a(0.0F, -3.0F, 0.0F);
      this.EarL2.func_78790_a(-2.0F, -0.5F, -3.0F, 4, 1, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 16.5F, 0.0F);
      this.LegL.func_78790_a(-2.1F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
      this.Body = new ModelRenderer(this, 1, 15);
      this.Body.func_78793_a(0.0F, 7.1F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 17, 33);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 8.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -0.6F, -1.5F, 3, 8, 3, 0.2F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-2.0F, 16.5F, 0.0F);
      this.LegR.func_78790_a(-1.9F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
      this.EarL1 = new ModelRenderer(this, 31, 24);
      this.EarL1.field_78809_i = true;
      this.EarL1.func_78793_a(3.9F, -6.6F, 0.0F);
      this.EarL1.func_78790_a(-2.0F, -2.5F, 0.0F, 4, 4, 1, 0.0F);
      this.setRotateAngle(this.EarL1, 0.13665928F, -0.18203785F, 0.91053826F);
      this.Head.func_78792_a(this.Head_1);
      this.Head.func_78792_a(this.EarR1);
      this.EarR1.func_78792_a(this.EarR2);
      this.EarL1.func_78792_a(this.EarL2);
      this.Head.func_78792_a(this.EarL1);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.render(f5);
      this.Body.render(f5);
      this.ArmR.render(f5);
      this.ArmL.render(f5);
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
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
