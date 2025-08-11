package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKingPiccolo extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Head2;
   public ModelRenderer TentacleL;
   public ModelRenderer TentacleR;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Head3;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer FeetL;
   public ModelRenderer FeetR;

   public ModelKingPiccolo() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.FeetR = new ModelRenderer(this, 64, 41);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
      this.EarL = new ModelRenderer(this, 34, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.8F, -4.5F, -1.0F);
      this.EarL.func_78790_a(0.0F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
      this.Body = new ModelRenderer(this, 1, 24);
      this.Body.func_78793_a(0.0F, -7.0F, 0.0F);
      this.Body.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 9, 6, 0.0F);
      this.ArmR = new ModelRenderer(this, 41, 19);
      this.ArmR.func_78793_a(-6.0F, -4.9F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.5F, 4, 15, 5, 0.0F);
      this.ArmL = new ModelRenderer(this, 41, 19);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.0F, -4.9F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 4, 15, 5, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 50);
      this.Body3.func_78793_a(0.0F, 11.0F, 0.0F);
      this.Body3.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 4, 6, 0.0F);
      this.EarR = new ModelRenderer(this, 34, 1);
      this.EarR.func_78793_a(-3.5F, -4.5F, -1.0F);
      this.EarR.func_78790_a(-3.5F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
      this.TentacleR = new ModelRenderer(this, 25, -1);
      this.TentacleR.func_78793_a(-1.5F, -6.0F, -4.0F);
      this.TentacleR.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
      this.setRotateAngle(this.TentacleR, 0.0F, 0.6981317F, 0.0F);
      this.FeetL = new ModelRenderer(this, 64, 41);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
      this.TentacleL = new ModelRenderer(this, 25, -1);
      this.TentacleL.field_78809_i = true;
      this.TentacleL.func_78793_a(1.5F, -6.0F, -4.0F);
      this.TentacleL.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
      this.setRotateAngle(this.TentacleL, 0.0F, -0.6981317F, 0.0F);
      this.LegL = new ModelRenderer(this, 40, 40);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.5F, 8.0F, 0.0F);
      this.LegL.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
      this.Body2 = new ModelRenderer(this, 1, 41);
      this.Body2.func_78793_a(0.0F, 9.5F, 0.0F);
      this.Body2.func_78790_a(-4.5F, -0.5F, -2.5F, 9, 2, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 40, 40);
      this.LegR.func_78793_a(-2.5F, 8.0F, 0.0F);
      this.LegR.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -7.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Head3 = new ModelRenderer(this, 66, 1);
      this.Head3.func_78793_a(0.0F, -0.6F, 0.5F);
      this.Head3.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 7, 0.0F);
      this.Head2 = new ModelRenderer(this, 33, 1);
      this.Head2.func_78793_a(0.0F, -5.8F, 1.7F);
      this.Head2.func_78790_a(-3.5F, -3.0F, -5.0F, 7, 8, 9, 0.0F);
      this.LegR.func_78792_a(this.FeetR);
      this.Head.func_78792_a(this.EarL);
      this.Body.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.TentacleR);
      this.LegL.func_78792_a(this.FeetL);
      this.Head.func_78792_a(this.TentacleL);
      this.Body.func_78792_a(this.Body2);
      this.Head2.func_78792_a(this.Head3);
      this.Head.func_78792_a(this.Head2);
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
