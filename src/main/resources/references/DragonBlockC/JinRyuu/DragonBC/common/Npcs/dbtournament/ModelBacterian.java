package JinRyuu.DragonBC.common.Npcs.dbtournament;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelBacterian extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer HairSideR;
   public ModelRenderer HairSideL;
   public ModelRenderer hair;
   public ModelRenderer HairBack1;
   public ModelRenderer Hair1;
   public ModelRenderer Hair2;
   public ModelRenderer Hair3;
   public ModelRenderer HairBack2;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;

   public ModelBacterian() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 0, 16);
      this.Body1.func_78793_a(0.0F, -6.5F, 0.0F);
      this.Body1.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
      this.hair = new ModelRenderer(this, 0, 0);
      this.hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.hair.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 90, 19);
      this.ArmR2.func_78793_a(-0.6F, 7.9F, -0.3F);
      this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 10, 6, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
      this.ArmR1 = new ModelRenderer(this, 92, 3);
      this.ArmR1.func_78793_a(-8.2F, -4.3F, 2.0F);
      this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
      this.setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.38397244F);
      this.ArmL2 = new ModelRenderer(this, 90, 19);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.8F, 7.9F, -0.3F);
      this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 10, 6, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
      this.Body3 = new ModelRenderer(this, 0, 52);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-8.0F, 16.0F, -3.2F, 16, 3, 9, 0.0F);
      this.HairBack1 = new ModelRenderer(this, 44, 0);
      this.HairBack1.func_78793_a(0.0F, -2.7F, 2.7F);
      this.HairBack1.func_78790_a(-5.0F, 0.0F, -0.5F, 10, 4, 2, 0.0F);
      this.setRotateAngle(this.HairBack1, 0.62587506F, 0.0F, 0.0F);
      this.Hair1 = new ModelRenderer(this, 37, 1);
      this.Hair1.func_78793_a(0.6F, -6.5F, -3.4F);
      this.Hair1.func_78790_a(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair1, 2.4130921F, 0.307527F, 0.18203785F);
      this.HairSideR = new ModelRenderer(this, 37, 0);
      this.HairSideR.func_78793_a(-3.4F, -1.7F, -2.1F);
      this.HairSideR.func_78790_a(-1.2F, -0.4F, 0.0F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairSideR, -0.6981317F, 0.17453292F, 0.31869712F);
      this.Hair2 = new ModelRenderer(this, 37, 1);
      this.Hair2.func_78793_a(-3.5F, -6.6F, -3.9F);
      this.Hair2.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair2, 2.5953045F, 0.091106184F, 0.18203785F);
      this.Body2 = new ModelRenderer(this, 0, 32);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 9, 11, 0.0F);
      this.Chest = new ModelRenderer(this, 52, 23);
      this.Chest.func_78793_a(0.0F, 3.7F, -1.7F);
      this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
      this.setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 91, 43);
      this.LegR.func_78793_a(-4.8F, 11.0F, 1.0F);
      this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
      this.HairBack2 = new ModelRenderer(this, 43, 7);
      this.HairBack2.func_78793_a(0.0F, 3.7F, 0.9F);
      this.HairBack2.func_78790_a(-4.0F, 0.0F, -0.5F, 8, 4, 1, 0.0F);
      this.setRotateAngle(this.HairBack2, -0.48223448F, 0.0F, 0.0F);
      this.HairSideL = new ModelRenderer(this, 37, 0);
      this.HairSideL.field_78809_i = true;
      this.HairSideL.func_78793_a(3.6F, -1.8F, -2.1F);
      this.HairSideL.func_78790_a(-1.1F, -0.2F, 0.0F, 2, 4, 1, 0.0F);
      this.setRotateAngle(this.HairSideL, -0.6981317F, -0.17453292F, -0.31869712F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -6.2F, 0.9F);
      this.Head.func_78790_a(-4.5F, -7.2F, -4.0F, 9, 7, 8, 0.0F);
      this.LegL = new ModelRenderer(this, 91, 43);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(4.8F, 11.0F, 1.0F);
      this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 92, 3);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(8.2F, -4.3F, 2.0F);
      this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
      this.setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.38397244F);
      this.Hair3 = new ModelRenderer(this, 37, 1);
      this.Hair3.func_78793_a(3.7F, -6.6F, -3.9F);
      this.Hair3.func_78790_a(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.Hair3, 2.7317894F, -0.091106184F, -0.18203785F);
      this.Head.func_78792_a(this.hair);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Body2.func_78792_a(this.Body3);
      this.hair.func_78792_a(this.HairBack1);
      this.hair.func_78792_a(this.Hair1);
      this.Head.func_78792_a(this.HairSideR);
      this.hair.func_78792_a(this.Hair2);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.Chest);
      this.HairBack1.func_78792_a(this.HairBack2);
      this.Head.func_78792_a(this.HairSideL);
      this.hair.func_78792_a(this.Hair3);
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
   }
}
