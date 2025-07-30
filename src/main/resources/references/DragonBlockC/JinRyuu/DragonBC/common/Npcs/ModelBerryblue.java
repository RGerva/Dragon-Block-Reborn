package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBerryblue extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer BodyLower;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Skirt;
   public ModelRenderer UpperBody;
   public ModelRenderer Neck;
   public ModelRenderer GrannyBoobs;
   public ModelRenderer ShoulderL;
   public ModelRenderer ShoulderR;

   public ModelBerryblue() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Skirt = new ModelRenderer(this, 3, 37);
      this.Skirt.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Skirt.func_78790_a(-4.5F, 6.0F, -3.5F, 9, 7, 7, 0.0F);
      this.LegR = new ModelRenderer(this, 4, 52);
      this.LegR.func_78793_a(-1.9F, 15.0F, 0.0F);
      this.LegR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
      this.ShoulderR = new ModelRenderer(this, 33, 9);
      this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderR.func_78790_a(-3.6F, -1.2F, -2.0F, 4, 2, 4, 0.0F);
      this.setRotateAngle(this.ShoulderR, 0.0F, 0.0F, -0.10471976F);
      this.LegL = new ModelRenderer(this, 4, 52);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 15.0F, 0.0F);
      this.LegL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 46, 21);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.6F, 9.2F, 0.8F);
      this.ArmL.func_78790_a(-0.6F, -0.9F, -1.5F, 2, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.1308997F);
      this.Neck = new ModelRenderer(this, 6, 14);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -0.5F, -1.3F, 4, 1, 3, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 8.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -6.1F, -3.5F, 8, 6, 7, 0.0F);
      this.BodyLower = new ModelRenderer(this, 1, 27);
      this.BodyLower.func_78793_a(0.0F, 8.0F, 0.0F);
      this.BodyLower.func_78790_a(-4.0F, 3.0F, -3.0F, 8, 3, 6, 0.0F);
      this.GrannyBoobs = new ModelRenderer(this, 24, 24);
      this.GrannyBoobs.func_78793_a(0.0F, 0.0F, 0.0F);
      this.GrannyBoobs.func_78790_a(-3.5F, 0.9F, -0.8F, 7, 4, 3, 0.0F);
      this.setRotateAngle(this.GrannyBoobs, -0.7740535F, 0.0F, 0.0F);
      this.UpperBody = new ModelRenderer(this, 3, 19);
      this.UpperBody.func_78793_a(0.0F, 0.0F, 0.0F);
      this.UpperBody.func_78790_a(-4.0F, 0.0F, -1.2F, 8, 3, 4, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 33, 9);
      this.ShoulderL.field_78809_i = true;
      this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ShoulderL.func_78790_a(-0.6F, -1.2F, -2.0F, 4, 2, 4, 0.0F);
      this.setRotateAngle(this.ShoulderL, 0.0F, 0.0F, 0.10471976F);
      this.ArmR = new ModelRenderer(this, 46, 21);
      this.ArmR.func_78793_a(-4.4F, 9.2F, 0.8F);
      this.ArmR.func_78790_a(-1.5F, -0.9F, -1.5F, 2, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.1308997F);
      this.BodyLower.func_78792_a(this.Skirt);
      this.ArmR.func_78792_a(this.ShoulderR);
      this.UpperBody.func_78792_a(this.Neck);
      this.UpperBody.func_78792_a(this.GrannyBoobs);
      this.BodyLower.func_78792_a(this.UpperBody);
      this.ArmL.func_78792_a(this.ShoulderL);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.BodyLower.func_78785_a(f5);
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
