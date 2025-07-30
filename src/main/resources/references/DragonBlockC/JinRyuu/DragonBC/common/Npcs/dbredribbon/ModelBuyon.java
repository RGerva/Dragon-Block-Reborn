package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelBuyon extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer tail1;
   public ModelRenderer Head2;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;
   public ModelRenderer Body4;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;
   public ModelRenderer tail2;
   public ModelRenderer tail3;
   public ModelRenderer tail4;
   public ModelRenderer tail5;

   public ModelBuyon() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.tail3 = new ModelRenderer(this, 88, 116);
      this.tail3.func_78793_a(0.0F, 0.0F, 4.9F);
      this.tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
      this.ArmR = new ModelRenderer(this, 92, 3);
      this.ArmR.func_78793_a(-8.8F, 2.5F, 2.0F);
      this.ArmR.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.38397244F);
      this.tail2 = new ModelRenderer(this, 67, 116);
      this.tail2.func_78793_a(0.0F, -0.2F, 5.9F);
      this.tail2.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
      this.Body4 = new ModelRenderer(this, 0, 88);
      this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body4.func_78790_a(-7.0F, 20.0F, -3.2F, 14, 2, 9, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 26);
      this.Body1.func_78793_a(0.0F, -0.1F, 0.0F);
      this.Body1.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
      this.ArmL = new ModelRenderer(this, 92, 3);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(8.8F, 2.5F, 2.0F);
      this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.38397244F);
      this.Body2 = new ModelRenderer(this, 0, 46);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 4, 11, 0.0F);
      this.tail5 = new ModelRenderer(this, 111, 109);
      this.tail5.func_78793_a(0.0F, 0.0F, 5.9F);
      this.tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 90, 19);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.8F, 7.1F, -0.3F);
      this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
      this.ArmR2 = new ModelRenderer(this, 90, 19);
      this.ArmR2.func_78793_a(-0.6F, 7.1F, -0.3F);
      this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
      this.tail4 = new ModelRenderer(this, 109, 117);
      this.tail4.func_78793_a(0.0F, 0.0F, 5.9F);
      this.tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
      this.Chest = new ModelRenderer(this, 53, 43);
      this.Chest.func_78793_a(0.0F, 4.2F, -1.7F);
      this.Chest.func_78790_a(-7.0F, -1.9F, -1.4F, 14, 5, 2, 0.0F);
      this.setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
      this.LegR = new ModelRenderer(this, 91, 43);
      this.LegR.func_78793_a(-7.2F, 20.0F, 1.0F);
      this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 4, 8, 0.0F);
      this.tail1 = new ModelRenderer(this, 42, 114);
      this.tail1.func_78793_a(0.0F, 14.4F, 6.5F);
      this.tail1.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F);
      this.Head2 = new ModelRenderer(this, 36, 2);
      this.Head2.func_78793_a(0.0F, -7.2F, -1.0F);
      this.Head2.func_78790_a(-5.8F, -7.0F, 0.0F, 12, 7, 0, 0.0F);
      this.setRotateAngle(this.Head2, 0.27314404F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 64);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-10.0F, 10.6F, -4.5F, 20, 10, 12, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.6F, -0.5F);
      this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 7, 8, 0.0F);
      this.LegL = new ModelRenderer(this, 91, 43);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(7.2F, 20.0F, 1.0F);
      this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 4, 8, 0.0F);
      this.tail2.func_78792_a(this.tail3);
      this.tail1.func_78792_a(this.tail2);
      this.Body3.func_78792_a(this.Body4);
      this.Body1.func_78792_a(this.Body2);
      this.tail4.func_78792_a(this.tail5);
      this.ArmL.func_78792_a(this.ArmL2);
      this.ArmR.func_78792_a(this.ArmR2);
      this.tail3.func_78792_a(this.tail4);
      this.Body1.func_78792_a(this.Chest);
      this.Head.func_78792_a(this.Head2);
      this.Body2.func_78792_a(this.Body3);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 2.3F;
      JGRenderHelper.modelScalePositionHelper(2.3F);
      this.Head.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      this.tail1.func_78785_a(f5);
      GL11.glPopMatrix();
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }

   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      int calc = par7Entity.field_70173_aa;
      if (calc > 100) {
         calc -= 100;
      }

      float r = 360.0F;
      float r2 = 180.0F;
      this.Head.field_78796_g = par4 / (r2 / 3.1415927F);
      this.Head.field_78795_f = par5 / (r2 / 3.1415927F);
      float ex = (float)par7Entity.field_70173_aa;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.tail1.field_78795_f = 0.2F;
      ModelRenderer var10000 = this.tail1;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail2.field_78795_f = 0.2F;
      var10000 = this.tail2;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail3.field_78795_f = 0.2F;
      var10000 = this.tail3;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail4.field_78795_f = 0.2F;
      var10000 = this.tail4;
      var10000.field_78795_f += r4 / 2.0F;
      this.tail5.field_78796_g = 0.2F;
      var10000 = this.tail5;
      var10000.field_78796_g += r4;
      this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
   }
}
