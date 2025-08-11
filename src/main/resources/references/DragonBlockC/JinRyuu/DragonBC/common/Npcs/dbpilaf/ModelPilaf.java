package JinRyuu.DragonBC.common.Npcs.dbpilaf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPilaf extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Head_1;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Tuft;

   public ModelPilaf() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 9.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -6.7F, -4.1F, 8, 7, 7, -0.2F);
      this.ArmR = new ModelRenderer(this, 17, 33);
      this.ArmR.func_78793_a(-4.5F, 10.7F, 0.5F);
      this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 7, 3, 0.2F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.04363323F);
      this.Head_1 = new ModelRenderer(this, 35, 0);
      this.Head_1.func_78793_a(0.0F, -6.3F, 0.0F);
      this.Head_1.func_78790_a(-1.0F, -1.8F, -1.1F, 2, 2, 2, 0.0F);
      this.LegL = new ModelRenderer(this, 1, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
      this.LegL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
      this.EarL = new ModelRenderer(this, 26, 0);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.2F, -2.7F, -1.8F);
      this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.7853982F, 0.0F);
      this.EarR = new ModelRenderer(this, 26, 0);
      this.EarR.func_78793_a(-3.2F, -2.7F, -1.8F);
      this.EarR.func_78790_a(-4.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.7853982F, 0.0F);
      this.Body = new ModelRenderer(this, 1, 15);
      this.Body.func_78793_a(0.0F, 8.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 1.0F, -3.0F, 8, 11, 6, 0.0F);
      this.ArmL = new ModelRenderer(this, 17, 33);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.5F, 10.7F, 0.5F);
      this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 2, 7, 3, 0.2F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.04363323F);
      this.LegR = new ModelRenderer(this, 1, 33);
      this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
      this.LegR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
      this.Tuft = new ModelRenderer(this, 32, 5);
      this.Tuft.func_78793_a(0.0F, 0.7F, 3.0F);
      this.Tuft.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 3, 7, 0.0F);
      this.Head.func_78792_a(this.Head_1);
      this.Head.func_78792_a(this.EarL);
      this.Head.func_78792_a(this.EarR);
      this.Body.func_78792_a(this.Tuft);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body.render(f5);
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
