package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuuSuper_Fusion extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Head2;
   public ModelRenderer Head3;
   public ModelRenderer Head4;
   public ModelRenderer Head5;
   public ModelRenderer Head6;
   public ModelRenderer Hips;
   public ModelRenderer Torso;
   public ModelRenderer JacketNeck;
   public ModelRenderer Neck;
   public ModelRenderer Chest;
   public ModelRenderer JacketR;
   public ModelRenderer JacketL;
   public ModelRenderer JacketR_1;
   public ModelRenderer JacketL_1;
   public ModelRenderer FootR;
   public ModelRenderer FootL;

   public ModelBuuSuper_Fusion() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 46, 30);
      this.ArmR.func_78793_a(-5.2F, -1.4F, 0.5F);
      this.ArmR.func_78790_a(-2.9F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
      this.JacketL = new ModelRenderer(this, 35, 54);
      this.JacketL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.JacketL.func_78790_a(3.9F, -0.1F, -1.5F, 2, 4, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 28);
      this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
      this.JacketL_1 = new ModelRenderer(this, 48, 48);
      this.JacketL_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.JacketL_1.func_78790_a(2.6F, 0.6F, -2.4F, 2, 5, 5, 0.0F);
      this.JacketNeck = new ModelRenderer(this, 18, 50);
      this.JacketNeck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.JacketNeck.func_78790_a(-3.5F, -0.2F, 0.3F, 7, 2, 4, 0.0F);
      this.FootL = new ModelRenderer(this, 0, 43);
      this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
      this.Torso = new ModelRenderer(this, 21, 19);
      this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Torso.func_78790_a(-4.5F, 0.6F, -1.4F, 9, 5, 4, 0.0F);
      this.FootR = new ModelRenderer(this, 0, 43);
      this.FootR.field_78809_i = true;
      this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
      this.Body = new ModelRenderer(this, 22, 29);
      this.Body.func_78793_a(0.0F, -3.2F, 0.0F);
      this.Body.func_78790_a(-3.5F, 3.1F, -2.2F, 7, 7, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 46, 30);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.3F, -1.4F, 0.5F);
      this.ArmL.func_78790_a(-1.2F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
      this.JacketR_1 = new ModelRenderer(this, 48, 48);
      this.JacketR_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.JacketR_1.func_78790_a(-4.6F, 0.6F, -2.4F, 2, 5, 5, 0.0F);
      this.Head2 = new ModelRenderer(this, 25, 0);
      this.Head2.func_78793_a(0.0F, -6.1F, -1.5F);
      this.Head2.func_78790_a(-1.5F, -4.2F, -1.0F, 3, 4, 3, 0.0F);
      this.setRotateAngle(this.Head2, -0.49392816F, 0.0F, 0.0F);
      this.Head4 = new ModelRenderer(this, 49, 1);
      this.Head4.func_78793_a(0.0F, -5.5F, 0.1F);
      this.Head4.func_78790_a(-1.0F, -5.1F, -0.8F, 2, 5, 2, 0.0F);
      this.setRotateAngle(this.Head4, -0.7285004F, 0.0F, 0.0F);
      this.Head6 = new ModelRenderer(this, 44, 11);
      this.Head6.func_78793_a(0.0F, -5.6F, 0.3F);
      this.Head6.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 1, 0.0F);
      this.setRotateAngle(this.Head6, -0.46251225F, 0.0F, 0.0F);
      this.Neck = new ModelRenderer(this, 4, 16);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.5F, -0.3F, -0.5F, 5, 2, 3, 0.0F);
      this.JacketR = new ModelRenderer(this, 35, 54);
      this.JacketR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.JacketR.func_78790_a(-5.9F, -0.1F, -1.5F, 2, 4, 5, 0.0F);
      this.Chest = new ModelRenderer(this, 0, 22);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-4.1F, 1.7F, -2.0F, 8, 3, 2, 0.0F);
      this.setRotateAngle(this.Chest, -0.06632251F, 0.0F, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 28);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
      this.Head5 = new ModelRenderer(this, 37, 10);
      this.Head5.func_78793_a(0.0F, -4.7F, -0.3F);
      this.Head5.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 2, 0.0F);
      this.setRotateAngle(this.Head5, -0.63739425F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -3.3F, 8, 8, 8, -0.7F);
      this.Head3 = new ModelRenderer(this, 38, 1);
      this.Head3.func_78793_a(0.0F, -3.8F, -0.6F);
      this.Head3.func_78790_a(-1.5F, -6.1F, -0.5F, 3, 6, 2, 0.0F);
      this.setRotateAngle(this.Head3, -0.68294734F, 0.0F, 0.0F);
      this.Hips = new ModelRenderer(this, 19, 41);
      this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hips.func_78790_a(-4.0F, 9.2F, -2.3F, 8, 3, 5, 0.0F);
      this.JacketNeck.func_78792_a(this.JacketL);
      this.JacketL.func_78792_a(this.JacketL_1);
      this.Body.func_78792_a(this.JacketNeck);
      this.LegL.func_78792_a(this.FootL);
      this.Body.func_78792_a(this.Torso);
      this.LegR.func_78792_a(this.FootR);
      this.JacketR.func_78792_a(this.JacketR_1);
      this.Head.func_78792_a(this.Head2);
      this.Head3.func_78792_a(this.Head4);
      this.Head5.func_78792_a(this.Head6);
      this.Body.func_78792_a(this.Neck);
      this.JacketNeck.func_78792_a(this.JacketR);
      this.Torso.func_78792_a(this.Chest);
      this.Head4.func_78792_a(this.Head5);
      this.Head2.func_78792_a(this.Head3);
      this.Body.func_78792_a(this.Hips);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
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
      this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
