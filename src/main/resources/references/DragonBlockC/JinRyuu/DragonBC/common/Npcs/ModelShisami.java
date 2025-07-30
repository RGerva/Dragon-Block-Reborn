package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelShisami extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Chest;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer rhorn;
   public ModelRenderer lhorn;
   public ModelRenderer earL;
   public ModelRenderer earR;
   public ModelRenderer rhorn2;
   public ModelRenderer rhorn3;
   public ModelRenderer rhorn4;
   public ModelRenderer lhorn2;
   public ModelRenderer lhorn3;
   public ModelRenderer lhorn4;
   public ModelRenderer Belly;
   public ModelRenderer Neck;
   public ModelRenderer ShoulderR;
   public ModelRenderer ShoulderL;

   public ModelShisami() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.earL = new ModelRenderer(this, 33, 8);
      this.earL.field_78809_i = true;
      this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earL.func_78790_a(2.7F, -5.8F, -3.2F, 4, 3, 0, 0.0F);
      this.setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
      this.lhorn4 = new ModelRenderer(this, 58, 1);
      this.lhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.lhorn4.func_78790_a(7.9F, -11.9F, -3.4F, 1, 1, 2, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 42, 15);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-5.0F, -1.7F, -2.4F, 6, 3, 5, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 42, 15);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-1.1F, -1.7F, -2.4F, 6, 3, 5, 0.0F);
      this.ArmL = new ModelRenderer(this, 46, 24);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.8F, -3.4F, 0.8F);
      this.ArmL.func_78790_a(-1.0F, -1.6F, -2.0F, 5, 14, 4, 0.0F);
      this.lhorn3 = new ModelRenderer(this, 51, 3);
      this.lhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.lhorn3.func_78790_a(6.7F, -11.4F, -2.8F, 2, 2, 2, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 43);
      this.LegR.func_78793_a(-3.0F, 8.8F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 5, 15, 5, 0.0F);
      this.lhorn2 = new ModelRenderer(this, 40, 1);
      this.lhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.lhorn2.func_78790_a(6.2F, -9.9F, -2.3F, 2, 3, 3, 0.0F);
      this.Belly = new ModelRenderer(this, 21, 42);
      this.Belly.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Belly.func_78790_a(-5.0F, 4.8F, -2.0F, 10, 9, 5, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -5.2F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.lhorn = new ModelRenderer(this, 25, 1);
      this.lhorn.func_78793_a(0.0F, 0.0F, 0.0F);
      this.lhorn.func_78790_a(3.5F, -8.7F, -2.0F, 4, 3, 3, 0.0F);
      this.Neck = new ModelRenderer(this, 22, 20);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-3.0F, -0.5F, -1.2F, 6, 1, 4, 0.0F);
      this.rhorn4 = new ModelRenderer(this, 58, 1);
      this.rhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.rhorn4.func_78790_a(-8.7F, -11.9F, -3.4F, 1, 1, 2, 0.0F);
      this.Chest = new ModelRenderer(this, 9, 29);
      this.Chest.func_78793_a(0.0F, -5.0F, 0.0F);
      this.Chest.func_78790_a(-6.0F, 0.0F, -2.3F, 12, 5, 6, 0.0F);
      this.ArmR = new ModelRenderer(this, 46, 24);
      this.ArmR.func_78793_a(-6.9F, -3.4F, 0.8F);
      this.ArmR.func_78790_a(-4.1F, -1.6F, -2.0F, 5, 14, 4, 0.0F);
      this.rhorn2 = new ModelRenderer(this, 40, 1);
      this.rhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.rhorn2.func_78790_a(-8.2F, -9.9F, -2.3F, 2, 3, 3, 0.0F);
      this.rhorn3 = new ModelRenderer(this, 51, 3);
      this.rhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.rhorn3.func_78790_a(-8.6F, -11.4F, -2.8F, 2, 2, 2, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 43);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 8.8F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 5, 15, 5, 0.0F);
      this.rhorn = new ModelRenderer(this, 25, 1);
      this.rhorn.func_78793_a(0.0F, 0.0F, 0.0F);
      this.rhorn.func_78790_a(-7.5F, -8.7F, -2.0F, 4, 3, 3, 0.0F);
      this.earR = new ModelRenderer(this, 33, 8);
      this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.earR.func_78790_a(-6.5F, -5.8F, -3.2F, 4, 3, 0, 0.0F);
      this.setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
      this.Head.func_78792_a(this.earL);
      this.lhorn3.func_78792_a(this.lhorn4);
      this.ArmR.func_78792_a(this.ShoulderR);
      this.ArmL.func_78792_a(this.ShoulderL);
      this.lhorn2.func_78792_a(this.lhorn3);
      this.lhorn.func_78792_a(this.lhorn2);
      this.Chest.func_78792_a(this.Belly);
      this.Head.func_78792_a(this.lhorn);
      this.Chest.func_78792_a(this.Neck);
      this.rhorn3.func_78792_a(this.rhorn4);
      this.rhorn.func_78792_a(this.rhorn2);
      this.rhorn2.func_78792_a(this.rhorn3);
      this.Head.func_78792_a(this.rhorn);
      this.Head.func_78792_a(this.earR);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Chest.func_78785_a(f5);
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
