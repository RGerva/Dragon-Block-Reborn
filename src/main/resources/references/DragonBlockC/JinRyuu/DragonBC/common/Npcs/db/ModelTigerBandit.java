package JinRyuu.DragonBC.common.Npcs.db;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelTigerBandit extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Nose;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer MuttonchopsR;
   public ModelRenderer MuttonchopsL;
   public ModelRenderer Body2;
   public ModelRenderer Armor;
   public ModelRenderer Sheat;
   public ModelRenderer ArmR2;
   public ModelRenderer ShoulderSpikeR;
   public ModelRenderer Sword1;
   public ModelRenderer Hilt1;
   public ModelRenderer ArmL2;
   public ModelRenderer ShoulderSpikeL;

   public ModelTigerBandit() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.MuttonchopsL = new ModelRenderer(this, 55, 8);
      this.MuttonchopsL.field_78809_i = true;
      this.MuttonchopsL.func_78793_a(3.5F, -3.5F, -0.8F);
      this.MuttonchopsL.func_78790_a(0.0F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsL, 0.0F, -0.6981317F, -0.08726646F);
      this.Sheat = new ModelRenderer(this, 48, 18);
      this.Sheat.func_78793_a(7.3F, 13.0F, 1.0F);
      this.Sheat.func_78790_a(0.0F, -2.6F, -5.2F, 1, 5, 15, 0.0F);
      this.setRotateAngle(this.Sheat, -0.3642502F, -0.03508112F, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 92, 1);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.8F, -3.2F, 1.7F);
      this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.20943952F);
      this.ShoulderSpikeR = new ModelRenderer(this, 89, 1);
      this.ShoulderSpikeR.func_78793_a(-1.0F, -1.6F, 0.0F);
      this.ShoulderSpikeR.func_78790_a(-1.5F, -3.3F, 0.0F, 3, 3, 0, 0.0F);
      this.ShoulderSpikeL = new ModelRenderer(this, 89, 1);
      this.ShoulderSpikeL.field_78809_i = true;
      this.ShoulderSpikeL.func_78793_a(1.0F, -1.6F, 0.0F);
      this.ShoulderSpikeL.func_78790_a(-1.5F, -3.3F, 0.0F, 3, 3, 0, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
      this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 38);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-7.5F, 8.0F, -3.1F, 15, 7, 9, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 90, 15);
      this.ArmR2.func_78793_a(-0.6F, 5.3F, -0.3F);
      this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
      this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
      this.MuttonchopsR = new ModelRenderer(this, 55, 8);
      this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -0.8F);
      this.MuttonchopsR.func_78790_a(-2.0F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.MuttonchopsR, 0.0F, 0.6981317F, 0.08726646F);
      this.ArmR1 = new ModelRenderer(this, 92, 1);
      this.ArmR1.func_78793_a(-8.8F, -3.2F, 1.7F);
      this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
      this.setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.20943952F);
      this.Sword1 = new ModelRenderer(this, 46, -6);
      this.Sword1.func_78793_a(0.0F, 6.9F, -0.6F);
      this.Sword1.func_78790_a(0.0F, -2.6F, -13.8F, 0, 5, 19, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 90, 15);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.6F, 5.3F, -0.3F);
      this.ArmL2.func_78790_a(-2.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
      this.LegL = new ModelRenderer(this, 91, 36);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.6F, 10.0F, 1.0F);
      this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
      this.Nose = new ModelRenderer(this, 46, 0);
      this.Nose.func_78793_a(0.0F, -2.0F, -2.1F);
      this.Nose.func_78790_a(-2.0F, -1.0F, -4.6F, 4, 3, 4, 0.0F);
      this.EarR = new ModelRenderer(this, 47, 8);
      this.EarR.func_78793_a(-3.8F, -5.4F, -1.0F);
      this.EarR.func_78790_a(-2.5F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.34906584F, 0.34906584F);
      this.Armor = new ModelRenderer(this, 49, 42);
      this.Armor.func_78793_a(0.0F, 15.0F, -3.1F);
      this.Armor.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
      this.EarL = new ModelRenderer(this, 47, 8);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.2F, -5.4F, -1.0F);
      this.EarL.func_78790_a(0.0F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.34906584F, -0.34906584F);
      this.Hilt1 = new ModelRenderer(this, 48, 25);
      this.Hilt1.func_78793_a(0.0F, 0.2F, -2.2F);
      this.Hilt1.func_78790_a(-2.5F, -2.8F, 0.0F, 5, 5, 0, 0.0F);
      this.LegR = new ModelRenderer(this, 91, 36);
      this.LegR.func_78793_a(-3.6F, 10.0F, 1.0F);
      this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
      this.Head.func_78792_a(this.MuttonchopsL);
      this.Body2.func_78792_a(this.Sheat);
      this.ArmR1.func_78792_a(this.ShoulderSpikeR);
      this.ArmL1.func_78792_a(this.ShoulderSpikeL);
      this.Body1.func_78792_a(this.Body2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.MuttonchopsR);
      this.ArmR2.func_78792_a(this.Sword1);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Head.func_78792_a(this.Nose);
      this.Head.func_78792_a(this.EarR);
      this.Body2.func_78792_a(this.Armor);
      this.Head.func_78792_a(this.EarL);
      this.Sword1.func_78792_a(this.Hilt1);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 1.5F;
      JGRenderHelper.modelScalePositionHelper(1.5F);
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
      this.Armor.rotateAngleX = -0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
   }
}
