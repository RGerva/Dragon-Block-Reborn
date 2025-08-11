package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKahseral extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hat;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Mic;

   public ModelKahseral() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 33, 8);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
      this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 33, 8);
      this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
      this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hat = new ModelRenderer(this, 0, 33);
      this.Hat.func_78793_a(0.0F, -6.2F, 0.0F);
      this.Hat.func_78790_a(-4.8F, -2.7F, -4.5F, 9, 3, 9, 0.0F);
      this.setRotateAngle(this.Hat, -0.08726646F, 0.0F, -0.06806784F);
      this.Mic = new ModelRenderer(this, 42, 11);
      this.Mic.func_78793_a(4.0F, -1.7F, -4.0F);
      this.Mic.func_78790_a(-4.0F, -0.4F, -0.1F, 4, 1, 0, 0.0F);
      this.setRotateAngle(this.Mic, 0.0F, -0.06806784F, -0.10646509F);
      this.Head.func_78792_a(this.EarL);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.Hat);
      this.Head.func_78792_a(this.Mic);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body.render(f5);
      this.LegR.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.LegL.render(f5);
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
