package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelCabba extends ModelBase {
   public ModelRenderer ArmR;
   public ModelRenderer LegR;
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer Hair;
   public ModelRenderer ClothB;
   public ModelRenderer ClothF;
   public ModelRenderer ClothL;
   public ModelRenderer ClothR;
   public ModelRenderer gohan1;
   public ModelRenderer gohan7;
   public ModelRenderer gohan8;
   public ModelRenderer gohan10;
   public ModelRenderer gohan11;
   public ModelRenderer gohan12;
   public ModelRenderer gohan13;
   public ModelRenderer gohan14;
   public ModelRenderer gohan15;
   public ModelRenderer gohan16;
   public ModelRenderer gohan17;
   public ModelRenderer gohan18;
   public ModelRenderer gohan19;
   public ModelRenderer gohan20;
   public ModelRenderer gohan21;
   public ModelRenderer gohan22;

   public ModelCabba() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Hair = new ModelRenderer(this, 0, 0);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(0.5F, -2.9F, -6.5F, 1, 2, 1, 0.0F);
      this.setRotateAngle(this.Hair, -0.4553564F, -0.22759093F, -0.15009831F);
      this.ClothR = new ModelRenderer(this, 30, 33);
      this.ClothR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ClothR.func_78790_a(-3.3F, 9.2F, -1.4F, 1, 9, 3, 0.0F);
      this.setRotateAngle(this.ClothR, 0.0F, 0.0F, 0.04363323F);
      this.LegR = new ModelRenderer(this, 0, 17);
      this.LegR.func_78793_a(-2.0F, 13.0F, 0.0F);
      this.LegR.func_78790_a(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 17);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 13.0F, 0.0F);
      this.LegL.func_78790_a(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 2.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.6F, -4.0F, 8, 8, 8, -0.3F);
      this.ClothB = new ModelRenderer(this, 20, 35);
      this.ClothB.func_78793_a(0.0F, 9.0F, 1.9F);
      this.ClothB.func_78790_a(-1.5F, 0.0F, -0.4F, 3, 9, 1, 0.0F);
      this.setRotateAngle(this.ClothB, 0.11868239F, 0.0F, 0.0F);
      this.ClothL = new ModelRenderer(this, 30, 33);
      this.ClothL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ClothL.func_78790_a(2.6F, 9.0F, -1.4F, 1, 9, 3, 0.0F);
      this.setRotateAngle(this.ClothL, 0.0F, 0.0F, -0.04363323F);
      this.Body = new ModelRenderer(this, 16, 17);
      this.Body.func_78793_a(0.0F, 2.0F, 0.0F);
      this.Body.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 11, 4, 0.0F);
      this.ClothF = new ModelRenderer(this, 20, 35);
      this.ClothF.func_78793_a(0.0F, 9.0F, -1.9F);
      this.ClothF.func_78790_a(-1.5F, 0.0F, -0.4F, 3, 9, 1, 0.0F);
      this.setRotateAngle(this.ClothF, -0.11868239F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 40, 18);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.5F, 4.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -1.5F, 3, 11, 3, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 18);
      this.ArmR.func_78793_a(-5.0F, 4.0F, 0.0F);
      this.ArmR.func_78790_a(-1.5F, -2.0F, -1.5F, 3, 11, 3, 0.0F);
      this.gohan1 = new ModelRenderer(this, 64, 0);
      this.gohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4);
      this.gohan1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan1, -0.1745329F, 0.0F, 0.0F);
      this.gohan7 = new ModelRenderer(this, 64, 0);
      this.gohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3);
      this.gohan7.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan7, -0.3665191F, 0.0F, 0.0F);
      this.gohan8 = new ModelRenderer(this, 64, 0);
      this.gohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2);
      this.gohan8.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan8, -0.5585054F, 0.0F, 0.0F);
      this.gohan10 = new ModelRenderer(this, 64, 0);
      this.gohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4);
      this.gohan10.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan10, -0.2617994F, 0.0F, -0.3665191F);
      this.gohan11 = new ModelRenderer(this, 64, 0);
      this.gohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4);
      this.gohan11.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan11, -0.418879F, 0.0F, -0.3316126F);
      this.gohan12 = new ModelRenderer(this, 64, 0);
      this.gohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3);
      this.gohan12.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan12, -0.5235988F, 0.0F, -0.2268928F);
      this.gohan13 = new ModelRenderer(this, 64, 0);
      this.gohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2);
      this.gohan13.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan13, -0.6283185F, 0.0F, -0.0698132F);
      this.gohan14 = new ModelRenderer(this, 64, 0);
      this.gohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3);
      this.gohan14.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan14, -0.2268928F, 0.0F, 0.4014257F);
      this.gohan15 = new ModelRenderer(this, 64, 0);
      this.gohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4);
      this.gohan15.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan15, -0.4537856F, 0.0F, 0.2617994F);
      this.gohan16 = new ModelRenderer(this, 64, 0);
      this.gohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3);
      this.gohan16.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan16, -0.5410521F, 0.0F, 0.1745329F);
      this.gohan17 = new ModelRenderer(this, 64, 0);
      this.gohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4);
      this.gohan17.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan17, -0.2792527F, 0.0F, 0.0F);
      this.gohan18 = new ModelRenderer(this, 64, 0);
      this.gohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4);
      this.gohan18.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan18, -0.2443461F, 0.2617994F, 0.0174533F);
      this.gohan19 = new ModelRenderer(this, 64, 0);
      this.gohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4);
      this.gohan19.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan19, -0.2443461F, -0.2617994F, 0.0174533F);
      this.gohan20 = new ModelRenderer(this, 64, 0);
      this.gohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4);
      this.gohan20.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan20, -0.1396263F, 0.0F, 0.0F);
      this.gohan21 = new ModelRenderer(this, 64, 0);
      this.gohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3);
      this.gohan21.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan21, -0.122173F, 0.1745329F, 0.0F);
      this.gohan22 = new ModelRenderer(this, 64, 0);
      this.gohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3);
      this.gohan22.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotateAngle(this.gohan22, -0.2443461F, -0.2617994F, 0.0174533F);
      this.Head.func_78792_a(this.Hair);
      this.Body.func_78792_a(this.ClothR);
      this.Body.func_78792_a(this.ClothB);
      this.Body.func_78792_a(this.ClothL);
      this.Body.func_78792_a(this.ClothF);
      this.Head.func_78792_a(this.gohan1);
      this.Head.func_78792_a(this.gohan7);
      this.Head.func_78792_a(this.gohan8);
      this.Head.func_78792_a(this.gohan10);
      this.Head.func_78792_a(this.gohan11);
      this.Head.func_78792_a(this.gohan12);
      this.Head.func_78792_a(this.gohan13);
      this.Head.func_78792_a(this.gohan15);
      this.Head.func_78792_a(this.gohan16);
      this.Head.func_78792_a(this.gohan17);
      this.Head.func_78792_a(this.gohan18);
      this.Head.func_78792_a(this.gohan19);
      this.Head.func_78792_a(this.gohan20);
      this.Head.func_78792_a(this.gohan21);
      this.Head.func_78792_a(this.gohan22);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      float F = 0.8F;
      GL11.glPushMatrix();
      GL11.glScalef(F, F, F);
      GL11.glTranslatef(0.0F, (F - 1.0F) * -0.74F * 3.0F, 0.0F);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.Body.render(f5);
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
      this.ClothF.rotateAngleX = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      ModelRenderer var10000;
      if (this.ClothF.rotateAngleX > 0.0F) {
         var10000 = this.ClothF;
         var10000.rotateAngleX *= -1.0F;
      }

      this.ClothF.rotateAngleY = 0.0F;
      this.ClothB.rotateAngleX = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (0.0F > this.ClothB.rotateAngleX) {
         var10000 = this.ClothB;
         var10000.rotateAngleX *= -1.0F;
      }

      this.ClothB.rotateAngleY = 0.0F;
      this.LegR.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
