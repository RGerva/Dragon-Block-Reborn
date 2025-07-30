package JinRyuu.DragonBC.common.Npcs.dbsbroly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCheelai extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Bag;
   public ModelRenderer Scouter;
   public ModelRenderer Body2;
   public ModelRenderer Boobs;
   public ModelRenderer Body3;

   public ModelCheelai() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.LegL = new ModelRenderer(this, 0, 46);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 18);
      this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
      this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
      this.Boobs = new ModelRenderer(this, 19, 31);
      this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Boobs.func_78790_a(-3.0F, 2.1F, -0.7F, 6, 3, 2, 0.0F);
      this.setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 32, 35);
      this.ArmR.func_78793_a(-4.3F, 2.8F, 0.0F);
      this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
      this.Body3 = new ModelRenderer(this, 0, 38);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 46);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Bag = new ModelRenderer(this, 34, 3);
      this.Bag.func_78793_a(-2.5F, 10.4F, 0.0F);
      this.Bag.func_78790_a(-2.0F, -0.9F, -2.3F, 2, 4, 5, 0.0F);
      this.setRotateAngle(this.Bag, 0.0F, 0.0F, 0.20943952F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
      this.Scouter = new ModelRenderer(this, 51, 4);
      this.Scouter.func_78793_a(0.0F, 1.4F, 0.0F);
      this.Scouter.func_78790_a(2.2F, -6.5F, -1.6F, 2, 4, 3, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 30);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 32, 35);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.3F, 2.8F, 0.0F);
      this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
      this.Body1.func_78792_a(this.Boobs);
      this.Body2.func_78792_a(this.Body3);
      this.Body3.func_78792_a(this.Bag);
      this.Head.func_78792_a(this.Scouter);
      this.Body1.func_78792_a(this.Body2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Body1.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
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
   }
}
