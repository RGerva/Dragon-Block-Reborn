package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNinjaMurasaki extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hair1;
   public ModelRenderer Hair2;
   public ModelRenderer Sword1;
   public ModelRenderer Body2;
   public ModelRenderer Sword2;
   public ModelRenderer Body3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmR2;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelNinjaMurasaki() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.LegL = new ModelRenderer(this, 28, 34);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 46, 29);
      this.ArmR2.func_78793_a(-1.1F, 5.0F, 0.0F);
      this.ArmR2.func_78790_a(-1.4F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
      this.Hair1 = new ModelRenderer(this, 28, 1);
      this.Hair1.func_78793_a(0.0F, -7.3F, 2.9F);
      this.Hair1.func_78790_a(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
      this.setRotateAngle(this.Hair1, -0.8651597F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 43, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 3.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 46, 29);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.9F, 5.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.4F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
      this.LegR2 = new ModelRenderer(this, 28, 49);
      this.LegR2.func_78793_a(-0.1F, 10.0F, 0.0F);
      this.LegR2.func_78790_a(-1.4F, 0.0F, -2.9F, 3, 2, 5, 0.0F);
      this.Body = new ModelRenderer(this, 1, 19);
      this.Body.func_78793_a(0.0F, 1.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.5F, -4.0F, 8, 9, 8, -0.5F);
      this.Body2 = new ModelRenderer(this, 1, 32);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 8.0F, -1.5F, 7, 1, 3, 0.0F);
      this.LegR = new ModelRenderer(this, 28, 34);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, 0.0F);
      this.Sword2 = new ModelRenderer(this, 17, 57);
      this.Sword2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Sword2.func_78790_a(-2.8F, -2.0F, -0.7F, 0, 4, 2, 0.0F);
      this.Sword1 = new ModelRenderer(this, 22, 60);
      this.Sword1.func_78793_a(-2.5F, 2.6F, 2.6F);
      this.Sword1.func_78790_a(-8.8F, -1.0F, 0.2F, 21, 2, 0, 0.0F);
      this.setRotateAngle(this.Sword1, 0.0F, 0.034906585F, 0.7740535F);
      this.ArmR = new ModelRenderer(this, 43, 16);
      this.ArmR.func_78793_a(-5.0F, 3.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F);
      this.LegL2 = new ModelRenderer(this, 28, 49);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 10.0F, 0.0F);
      this.LegL2.func_78790_a(-1.4F, 0.0F, -2.9F, 3, 2, 5, 0.0F);
      this.Hair2 = new ModelRenderer(this, 35, 1);
      this.Hair2.func_78793_a(0.0F, -4.1F, 0.0F);
      this.Hair2.func_78790_a(-3.0F, -3.1F, 0.0F, 6, 6, 0, 0.0F);
      this.setRotateAngle(this.Hair2, 1.5707964F, 0.0F, 0.0F);
      this.ArmR.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.Hair1);
      this.ArmL.func_78792_a(this.ArmL2);
      this.LegR.func_78792_a(this.LegR2);
      this.Body.func_78792_a(this.Body2);
      this.Body2.func_78792_a(this.Body3);
      this.Sword1.func_78792_a(this.Sword2);
      this.Body.func_78792_a(this.Sword1);
      this.LegL.func_78792_a(this.LegL2);
      this.Hair1.func_78792_a(this.Hair2);
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
   }
}
