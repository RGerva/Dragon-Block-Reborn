package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelMajorMetallitron extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Hair;
   public ModelRenderer Body2;
   public ModelRenderer RoboticsNeck;
   public ModelRenderer Body3;
   public ModelRenderer Chest;
   public ModelRenderer Body4;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer RoboticsArmR;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;
   public ModelRenderer RoboticsArmL;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelMajorMetallitron() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body3 = new ModelRenderer(this, 0, 48);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-5.5F, 6.2F, -2.9F, 11, 6, 6, 0.0F);
      this.Body4 = new ModelRenderer(this, 72, 12);
      this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body4.func_78790_a(-6.0F, 7.0F, -3.4F, 12, 5, 7, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 92, 27);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(7.5F, -5.2F, 0.2F);
      this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Chest = new ModelRenderer(this, 35, 33);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-6.0F, 2.0F, -3.4F, 12, 5, 1, 0.0F);
      this.LegL2 = new ModelRenderer(this, 66, 0);
      this.LegL2.func_78793_a(3.1F, 2.1F, 0.0F);
      this.LegL2.func_78790_a(-1.0F, -2.0F, -2.5F, 2, 5, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 92, 40);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(1.7F, 2.0F, 0.0F);
      this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
      this.LegR2 = new ModelRenderer(this, 66, 0);
      this.LegR2.func_78793_a(-3.2F, 2.1F, 0.0F);
      this.LegR2.func_78790_a(-1.0F, -2.0F, -2.5F, 2, 5, 5, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -7.8F, -0.5F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.2F);
      this.LegR = new ModelRenderer(this, 41, 42);
      this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
      this.LegL = new ModelRenderer(this, 41, 42);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
      this.RoboticsArmR = new ModelRenderer(this, 81, 1);
      this.RoboticsArmR.func_78793_a(-0.5F, 0.5F, 0.5F);
      this.RoboticsArmR.func_78790_a(-2.0F, 0.2F, -2.0F, 4, 3, 4, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 93, 50);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(0.0F, 4.2F, -0.5F);
      this.ArmL3.func_78790_a(-2.1F, 0.0F, -1.8F, 5, 8, 5, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 67, 40);
      this.ArmR2.func_78793_a(-1.7F, 2.0F, 0.0F);
      this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
      this.Hair = new ModelRenderer(this, 32, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.RoboticsNeck = new ModelRenderer(this, 81, 1);
      this.RoboticsNeck.func_78793_a(0.0F, 0.5F, 0.5F);
      this.RoboticsNeck.func_78790_a(-2.0F, -1.1F, -2.0F, 4, 3, 4, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 67, 50);
      this.ArmR3.func_78793_a(0.0F, 4.2F, -0.5F);
      this.ArmR3.func_78790_a(-2.9F, 0.0F, -1.9F, 5, 8, 5, 0.0F);
      this.RoboticsArmL = new ModelRenderer(this, 97, 1);
      this.RoboticsArmL.func_78793_a(0.4F, 0.5F, 0.5F);
      this.RoboticsArmL.func_78790_a(-2.0F, 0.2F, -2.0F, 4, 3, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
      this.Body1.func_78790_a(-6.5F, 0.0F, -2.5F, 13, 8, 6, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 66, 27);
      this.ArmR1.func_78793_a(-7.5F, -5.2F, 0.2F);
      this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Body2.func_78792_a(this.Body3);
      this.Body1.func_78792_a(this.Body2);
      this.Body2.func_78792_a(this.Body4);
      this.Body2.func_78792_a(this.Chest);
      this.LegL.func_78792_a(this.LegL2);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.LegR.func_78792_a(this.LegR2);
      this.ArmR3.func_78792_a(this.RoboticsArmR);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.Hair);
      this.Body1.func_78792_a(this.RoboticsNeck);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.ArmL3.func_78792_a(this.RoboticsArmL);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 2.0F;
      JGRenderHelper.modelScalePositionHelper(2.0F);
      this.Head.render(f5);
      this.Body1.render(f5);
      this.ArmR1.render(f5);
      this.ArmL1.render(f5);
      this.LegL.render(f5);
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
   }
}
