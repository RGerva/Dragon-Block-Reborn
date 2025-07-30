package JinRyuu.DragonBC.common.Npcs.dbsbroly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDBSParagus2 extends ModelBase {
   public ModelRenderer Hair;
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Beard;
   public ModelRenderer Bag;
   public ModelRenderer ShoulderL;
   public ModelRenderer ShoulderR;

   public ModelDBSParagus2() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Beard = new ModelRenderer(this, 28, 1);
      this.Beard.func_78793_a(0.0F, -2.7F, -3.8F);
      this.Beard.func_78790_a(-3.0F, -0.1F, -0.25F, 6, 5, 0, 0.0F);
      this.ArmR = new ModelRenderer(this, 40, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 0, 33);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-1.1F, -2.1F, -2.5F, 6, 4, 5, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 0, 33);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-4.9F, -2.1F, -2.5F, 6, 4, 5, 0.0F);
      this.Hair = new ModelRenderer(this, 0, 43);
      this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hair.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.2F);
      this.ArmL = new ModelRenderer(this, 40, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Bag = new ModelRenderer(this, 39, 3);
      this.Bag.func_78793_a(3.5F, 9.0F, 0.0F);
      this.Bag.func_78790_a(-0.6F, -0.9F, -2.3F, 2, 4, 5, 0.0F);
      this.setRotateAngle(this.Bag, 0.0F, 0.0F, -0.09599311F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.Head.func_78792_a(this.Beard);
      this.ArmL.func_78792_a(this.ShoulderL);
      this.ArmR.func_78792_a(this.ShoulderR);
      this.Hair.func_78792_a(this.Head);
      this.Body.func_78792_a(this.Bag);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Hair.func_78785_a(f5);
      this.Body.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL.func_78785_a(f5);
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
      this.Hair.field_78796_g = par4 / (r2 / 3.1415927F);
      this.Hair.field_78795_f = par5 / (r2 / 3.1415927F);
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
