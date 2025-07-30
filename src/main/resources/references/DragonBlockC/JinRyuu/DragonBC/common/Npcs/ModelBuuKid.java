package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuuKid extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Head2;
   public ModelRenderer Head3;
   public ModelRenderer Body2;
   public ModelRenderer Neck;
   public ModelRenderer Chest;
   public ModelRenderer Hip;
   public ModelRenderer FeetR;
   public ModelRenderer FeetL;

   public ModelBuuKid() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 30, 26);
      this.ArmR.func_78793_a(-3.8F, 4.8F, 0.4F);
      this.ArmR.func_78790_a(-2.8F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
      this.FeetR = new ModelRenderer(this, 17, 48);
      this.FeetR.field_78809_i = true;
      this.FeetR.func_78793_a(0.4F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-1.5F, -0.2F, -1.5F, 3, 11, 3, 0.0F);
      this.FeetL = new ModelRenderer(this, 17, 48);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(-0.4F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-1.5F, -0.2F, -1.5F, 3, 11, 3, 0.0F);
      this.Chest = new ModelRenderer(this, 24, 21);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-3.0F, 0.4F, -1.7F, 6, 2, 1, 0.0F);
      this.setRotateAngle(this.Chest, -0.057595864F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 4, 32);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-2.5F, 1.5F, -1.6F, 5, 6, 3, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 49);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 13.5F, 0.0F);
      this.LegL.func_78790_a(-2.4F, 0.8F, -2.0F, 4, 6, 4, -0.2F);
      this.Head2 = new ModelRenderer(this, 26, 1);
      this.Head2.func_78793_a(0.0F, -5.5F, -1.9F);
      this.Head2.func_78790_a(-1.0F, -4.0F, -1.1F, 2, 4, 2, 0.0F);
      this.setRotateAngle(this.Head2, -0.5462881F, 0.0F, 0.0F);
      this.Neck = new ModelRenderer(this, 7, 17);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -0.7F, -1.3F, 4, 2, 3, 0.0F);
      this.Body = new ModelRenderer(this, 3, 23);
      this.Body.func_78793_a(0.0F, 3.3F, 0.0F);
      this.Body.func_78790_a(-3.5F, 0.0F, -1.1F, 7, 5, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 30, 26);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(3.8F, 4.8F, 0.4F);
      this.ArmL.func_78790_a(-1.2F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
      this.LegR = new ModelRenderer(this, 0, 49);
      this.LegR.func_78793_a(-1.9F, 13.5F, 0.0F);
      this.LegR.func_78790_a(-1.8F, 0.8F, -2.0F, 4, 6, 4, -0.2F);
      this.Head3 = new ModelRenderer(this, 36, 0);
      this.Head3.func_78793_a(0.0F, -3.8F, -0.2F);
      this.Head3.func_78790_a(-0.5F, -3.6F, -0.7F, 1, 4, 1, 0.0F);
      this.setRotateAngle(this.Head3, -0.7285004F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 2.9F, 0.1F);
      this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 8, 8, -0.7F);
      this.Hip = new ModelRenderer(this, 3, 42);
      this.Hip.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Hip.func_78790_a(-3.0F, 7.0F, -1.5F, 6, 3, 3, 0.0F);
      this.LegR.func_78792_a(this.FeetR);
      this.LegL.func_78792_a(this.FeetL);
      this.Body.func_78792_a(this.Chest);
      this.Body.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.Head2);
      this.Body.func_78792_a(this.Neck);
      this.Head2.func_78792_a(this.Head3);
      this.Body2.func_78792_a(this.Hip);
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
