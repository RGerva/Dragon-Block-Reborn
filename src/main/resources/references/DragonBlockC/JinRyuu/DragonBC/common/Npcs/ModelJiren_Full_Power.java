package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelJiren_Full_Power extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer Chest;
   public ModelRenderer TornCloth;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;

   public ModelJiren_Full_Power() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -8.5F, 0.0F);
      this.Body1.func_78790_a(-7.5F, 0.0F, -3.3F, 15, 8, 7, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 63, 5);
      this.ArmR1.func_78793_a(-8.0F, -5.2F, 0.0F);
      this.ArmR1.func_78790_a(-5.3F, -3.3F, -3.0F, 6, 6, 7, 0.0F);
      this.LegL = new ModelRenderer(this, 41, 41);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.0F, 8.5F, 0.0F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-6.0F, 6.0F, -3.5F, 12, 6, 6, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 48);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
      this.EarL = new ModelRenderer(this, 33, 8);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
      this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
      this.LegR = new ModelRenderer(this, 41, 41);
      this.LegR.func_78793_a(-3.0F, 8.5F, 0.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 67, 31);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(0.0F, 4.3F, -0.2F);
      this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.8F, 5, 9, 5, 0.0F);
      this.TornCloth = new ModelRenderer(this, 68, 48);
      this.TornCloth.func_78793_a(0.0F, 0.0F, 0.0F);
      this.TornCloth.func_78790_a(-6.5F, 12.4F, -3.5F, 13, 1, 7, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 67, 31);
      this.ArmR3.func_78793_a(0.0F, 4.3F, -0.2F);
      this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 9, 5, 0.0F);
      this.Chest = new ModelRenderer(this, 38, 33);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-6.0F, 1.2F, -4.1F, 12, 6, 1, 0.0F);
      this.EarR = new ModelRenderer(this, 33, 8);
      this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
      this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 65, 19);
      this.ArmR2.func_78793_a(-2.0F, 2.0F, 0.0F);
      this.ArmR2.func_78790_a(-2.7F, -0.2F, -2.5F, 5, 5, 6, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 65, 19);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(2.0F, 2.0F, 0.0F);
      this.ArmL2.func_78790_a(-2.3F, -0.2F, -2.5F, 5, 5, 6, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -8.5F, -0.5F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 63, 5);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.0F, -5.2F, 0.0F);
      this.ArmL1.func_78790_a(-0.7F, -3.3F, -3.0F, 6, 6, 7, 0.0F);
      this.Body1.func_78792_a(this.Body2);
      this.Body2.func_78792_a(this.Body3);
      this.Head.func_78792_a(this.EarL);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Body3.func_78792_a(this.TornCloth);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Body2.func_78792_a(this.Chest);
      this.Head.func_78792_a(this.EarR);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.ArmL1.func_78792_a(this.ArmL2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 1.1F;
      JGRenderHelper.modelScalePositionHelper(1.1F);
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
