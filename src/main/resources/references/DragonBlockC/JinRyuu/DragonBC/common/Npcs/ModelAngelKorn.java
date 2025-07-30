package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAngelKorn extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer NeckRing;
   public ModelRenderer Body3;
   public ModelRenderer ClothF;
   public ModelRenderer ClothB;
   public ModelRenderer ClothF2;
   public ModelRenderer ClothB2;
   public ModelRenderer NeckRing_1;
   public ModelRenderer NeckRing_2;
   public ModelRenderer NeckRing_3;
   public ModelRenderer NeckRing_4;
   public ModelRenderer NeckRing_5;
   public ModelRenderer NeckRing_6;
   public ModelRenderer NeckRing_7;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;
   public ModelRenderer ShoulderR;
   public ModelRenderer ShoulderL;

   public ModelAngelKorn() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body2 = new ModelRenderer(this, 23, 31);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
      this.Neck = new ModelRenderer(this, 7, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 33, 9);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-2.8F, -2.4F, -1.7F, 4, 4, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
      this.NeckRing_3 = new ModelRenderer(this, 0, 56);
      this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
      this.setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
      this.ClothF2 = new ModelRenderer(this, 33, 46);
      this.ClothF2.func_78793_a(0.0F, 5.0F, 0.0F);
      this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
      this.setRotateAngle(this.ClothF2, 0.04712389F, 0.0F, 0.0F);
      this.LegR2 = new ModelRenderer(this, 17, 47);
      this.LegR2.field_78809_i = true;
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 18);
      this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
      this.ClothB = new ModelRenderer(this, 44, 46);
      this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
      this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
      this.setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
      this.NeckRing_1 = new ModelRenderer(this, 0, 56);
      this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
      this.setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
      this.NeckRing_6 = new ModelRenderer(this, 19, 54);
      this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
      this.setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
      this.NeckRing_4 = new ModelRenderer(this, 0, 56);
      this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
      this.setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
      this.NeckRing_2 = new ModelRenderer(this, 19, 54);
      this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
      this.setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
      this.NeckRing_5 = new ModelRenderer(this, 0, 56);
      this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
      this.setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
      this.ArmR = new ModelRenderer(this, 50, 16);
      this.ArmR.func_78793_a(-5.0F, -1.2F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
      this.NeckRing = new ModelRenderer(this, 0, 53);
      this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
      this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
      this.setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 50, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -1.2F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
      this.LegL2 = new ModelRenderer(this, 17, 47);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
      this.Body3 = new ModelRenderer(this, 20, 37);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
      this.ClothB2 = new ModelRenderer(this, 33, 46);
      this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
      this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
      this.setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
      this.NeckRing_7 = new ModelRenderer(this, 0, 56);
      this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
      this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
      this.setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
      this.ClothF = new ModelRenderer(this, 44, 46);
      this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
      this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
      this.setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 33, 9);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-1.0F, -2.4F, -1.7F, 4, 4, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
      this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.Neck);
      this.ArmR.func_78792_a(this.ShoulderR);
      this.NeckRing_2.func_78792_a(this.NeckRing_3);
      this.ClothF.func_78792_a(this.ClothF2);
      this.LegR.func_78792_a(this.LegR2);
      this.Body3.func_78792_a(this.ClothB);
      this.NeckRing.func_78792_a(this.NeckRing_1);
      this.NeckRing_5.func_78792_a(this.NeckRing_6);
      this.NeckRing_3.func_78792_a(this.NeckRing_4);
      this.NeckRing_1.func_78792_a(this.NeckRing_2);
      this.NeckRing_4.func_78792_a(this.NeckRing_5);
      this.Body1.func_78792_a(this.NeckRing);
      this.LegL.func_78792_a(this.LegL2);
      this.Body2.func_78792_a(this.Body3);
      this.ClothB.func_78792_a(this.ClothB2);
      this.NeckRing_6.func_78792_a(this.NeckRing_7);
      this.Body3.func_78792_a(this.ClothF);
      this.ArmL.func_78792_a(this.ShoulderL);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
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
      this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
