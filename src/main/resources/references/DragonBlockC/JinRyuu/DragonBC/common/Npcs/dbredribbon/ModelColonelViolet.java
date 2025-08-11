package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelColonelViolet extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Googles;
   public ModelRenderer Body3;
   public ModelRenderer Holster;

   public ModelColonelViolet() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Googles = new ModelRenderer(this, 26, 2);
      this.Googles.func_78793_a(0.0F, 0.7F, -1.7F);
      this.Googles.func_78790_a(-3.0F, 0.0F, 0.0F, 6, 3, 0, 0.0F);
      this.setRotateAngle(this.Googles, -0.5691519F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 18, 47);
      this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
      this.ArmR.func_78790_a(-1.9F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
      this.Body2 = new ModelRenderer(this, 0, 30);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
      this.Boobs = new ModelRenderer(this, 19, 31);
      this.Boobs.func_78793_a(0.0F, -0.5F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 2.0F, -0.6F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
      this.Holster = new ModelRenderer(this, 34, 7);
      this.Holster.func_78793_a(-2.4F, 8.5F, -0.4F);
      this.Holster.func_78790_a(-1.5F, -1.6F, -1.3F, 1, 5, 3, 0.0F);
      this.setRotateAngle(this.Holster, 0.5462881F, 0.0F, 0.22759093F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
      this.ArmL = new ModelRenderer(this, 18, 47);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
      this.ArmL.func_78790_a(-1.1F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
      this.Body1.func_78792_a(this.Googles);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.Boobs);
      this.Body3.func_78792_a(this.Holster);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.render(f5);
      this.Body1.render(f5);
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
