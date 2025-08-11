package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelToppo_GoD extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Moustache;
   public ModelRenderer Nose;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;

   public ModelToppo_GoD() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.LegR = new ModelRenderer(this, 44, 45);
      this.LegR.func_78793_a(-2.5F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 5, 12, 6, 0.0F);
      this.EarR = new ModelRenderer(this, 33, 8);
      this.EarR.func_78793_a(-4.0F, -3.0F, -1.1F);
      this.EarR.func_78790_a(-1.4F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.68294734F, -0.31869712F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -5.2F, 0.0F);
      this.Body1.func_78790_a(-7.0F, 0.0F, -3.6F, 14, 8, 8, 0.0F);
      this.EarL = new ModelRenderer(this, 33, 8);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(4.0F, -3.0F, -1.1F);
      this.EarL.func_78790_a(-0.5F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.68294734F, 0.31869712F);
      this.ArmR1 = new ModelRenderer(this, 63, 5);
      this.ArmR1.func_78793_a(-8.0F, -2.0F, 0.5F);
      this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 53);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-6.0F, 13.0F, -4.3F, 12, 1, 8, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 64, 18);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-4.5F, 2.8F, -2.5F, 5, 4, 5, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.9F, -0.9F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Nose = new ModelRenderer(this, 0, 0);
      this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Nose.func_78790_a(-1.0F, -3.8F, -5.2F, 2, 2, 2, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 63, 28);
      this.ArmR3.func_78793_a(-2.0F, 6.4F, 0.0F);
      this.ArmR3.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 63, 5);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.0F, -2.0F, 0.5F);
      this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 64, 18);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-0.5F, 2.8F, -2.5F, 5, 4, 5, 0.0F);
      this.Moustache = new ModelRenderer(this, 26, 0);
      this.Moustache.func_78793_a(0.0F, -2.5F, -4.2F);
      this.Moustache.func_78790_a(-4.5F, 0.0F, 0.0F, 9, 6, 0, 0.0F);
      this.Chest = new ModelRenderer(this, 32, 34);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-6.0F, 1.8F, -4.6F, 12, 5, 1, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-5.5F, 6.2F, -3.8F, 11, 11, 7, 0.0F);
      this.LegL = new ModelRenderer(this, 44, 45);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.5F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -3.0F, 5, 12, 6, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 63, 28);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(2.0F, 6.4F, 0.0F);
      this.ArmL3.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.Body2.func_78792_a(this.Body3);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.Nose);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Head.func_78792_a(this.Moustache);
      this.Body2.func_78792_a(this.Chest);
      this.Body1.func_78792_a(this.Body2);
      this.ArmL2.func_78792_a(this.ArmL3);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 1.6F;
      JGRenderHelper.modelScalePositionHelper(1.6F);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL1.render(f5);
      this.ArmR1.render(f5);
      this.Body1.render(f5);
      this.LegR.render(f5);
      GL11.glPopMatrix();
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
      this.ArmR1.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL1.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR1.rotateAngleY = 0.0F;
      this.ArmL1.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
