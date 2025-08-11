package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMurichim extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR1;
   public ModelRenderer ArmL1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Head2;
   public ModelRenderer Body2;
   public ModelRenderer Head2_1;
   public ModelRenderer Body3;
   public ModelRenderer Chest;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;

   public ModelMurichim() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -8.0F, -0.5F);
      this.Head.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 4, 8, 0.0F);
      this.LegR = new ModelRenderer(this, 41, 42);
      this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
      this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
      this.Head2 = new ModelRenderer(this, 33, 0);
      this.Head2.func_78793_a(0.0F, 0.0F, -0.5F);
      this.Head2.func_78790_a(-3.5F, -8.0F, -3.5F, 7, 4, 8, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 64, 18);
      this.ArmR2.func_78793_a(-2.0F, 2.0F, 0.0F);
      this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
      this.Head2_1 = new ModelRenderer(this, 89, 3);
      this.Head2_1.func_78793_a(0.0F, 0.0F, -0.5F);
      this.Head2_1.func_78790_a(-6.0F, -1.0F, -3.1F, 12, 2, 7, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
      this.Body1.func_78790_a(-7.0F, 0.0F, -3.3F, 14, 8, 7, 0.0F);
      this.LegL = new ModelRenderer(this, 41, 42);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
      this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
      this.EarR = new ModelRenderer(this, 33, 3);
      this.EarR.func_78793_a(-3.1F, -3.2F, -0.8F);
      this.EarR.func_78790_a(-2.0F, -2.8F, 0.0F, 2, 3, 0, 0.0F);
      this.setRotateAngle(this.EarR, -0.17453292F, 0.4886922F, -0.2617994F);
      this.ArmL2 = new ModelRenderer(this, 64, 18);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(2.0F, 2.0F, 0.0F);
      this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
      this.ArmL1 = new ModelRenderer(this, 63, 5);
      this.ArmL1.field_78809_i = true;
      this.ArmL1.func_78793_a(7.5F, -4.7F, 0.0F);
      this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 34);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-5.5F, 6.2F, -3.5F, 11, 6, 6, 0.0F);
      this.EarL = new ModelRenderer(this, 33, 3);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.1F, -3.2F, -0.8F);
      this.EarL.func_78790_a(0.0F, -2.8F, 0.0F, 2, 3, 0, 0.0F);
      this.setRotateAngle(this.EarL, -0.17453292F, -0.4886922F, 0.2617994F);
      this.Body3 = new ModelRenderer(this, 0, 48);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 63, 28);
      this.ArmR3.func_78793_a(0.0F, 4.1F, -0.5F);
      this.ArmR3.func_78790_a(-2.3F, 0.0F, -1.9F, 5, 9, 5, 0.0F);
      this.Chest = new ModelRenderer(this, 35, 33);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-6.0F, 1.8F, -4.1F, 12, 5, 1, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 63, 28);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(0.0F, 4.1F, -0.5F);
      this.ArmL3.func_78790_a(-2.7F, 0.0F, -1.8F, 5, 9, 5, 0.0F);
      this.ArmR1 = new ModelRenderer(this, 63, 5);
      this.ArmR1.func_78793_a(-7.5F, -4.7F, 0.0F);
      this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Head.func_78792_a(this.Head2);
      this.ArmR1.func_78792_a(this.ArmR2);
      this.Body1.func_78792_a(this.Head2_1);
      this.Head.func_78792_a(this.EarR);
      this.ArmL1.func_78792_a(this.ArmL2);
      this.Body1.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.EarL);
      this.Body2.func_78792_a(this.Body3);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Body2.func_78792_a(this.Chest);
      this.ArmL2.func_78792_a(this.ArmL3);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.render(f5);
      this.LegR.render(f5);
      this.Body1.render(f5);
      this.LegL.render(f5);
      this.ArmL1.render(f5);
      this.ArmR1.render(f5);
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
