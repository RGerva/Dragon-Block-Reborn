package JinRyuu.DragonBC.common.Npcs.db;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMasterRoshi2 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Beard;
   public ModelRenderer Beard2;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;
   public ModelRenderer FeetL;
   public ModelRenderer FeetR;

   public ModelMasterRoshi2() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Body2 = new ModelRenderer(this, 0, 31);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-4.5F, 5.0F, -2.0F, 9, 5, 4, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 62, 27);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-4.1F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
      this.LegR = new ModelRenderer(this, 33, 32);
      this.LegR.func_78793_a(-2.5F, 10.0F, 0.0F);
      this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
      this.Chest = new ModelRenderer(this, 34, 16);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-5.0F, 1.0F, -2.5F, 10, 4, 1, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 42);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.0F, 9.5F, -2.4F, 10, 4, 5, 0.0F);
      this.FeetL = new ModelRenderer(this, 34, 50);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
      this.ArmL = new ModelRenderer(this, 62, 17);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(6.7F, -2.2F, 0.5F);
      this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 62, 27);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-0.9F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
      this.ArmR = new ModelRenderer(this, 62, 17);
      this.ArmR.func_78793_a(-6.7F, -2.2F, 0.5F);
      this.ArmR.func_78790_a(-4.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
      this.Body = new ModelRenderer(this, 0, 17);
      this.Body.func_78793_a(0.0F, -3.5F, 0.0F);
      this.Body.func_78790_a(-6.0F, 0.0F, -1.9F, 12, 7, 5, 0.0F);
      this.FeetR = new ModelRenderer(this, 34, 50);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.7F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
      this.ArmR3 = new ModelRenderer(this, 61, 39);
      this.ArmR3.func_78793_a(-1.4F, 6.4F, -0.8F);
      this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
      this.setRotateAngle(this.ArmR3, -0.22759093F, 0.0F, 0.0F);
      this.LegL = new ModelRenderer(this, 33, 32);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.5F, 10.0F, 0.0F);
      this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
      this.Beard = new ModelRenderer(this, 27, 2);
      this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
      this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 61, 39);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(1.4F, 6.4F, -0.8F);
      this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
      this.setRotateAngle(this.ArmL3, -0.18203785F, 0.0F, 0.0F);
      this.Beard2 = new ModelRenderer(this, 33, 9);
      this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
      this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
      this.Body.func_78792_a(this.Body2);
      this.ArmR.func_78792_a(this.ArmR2);
      this.Body.func_78792_a(this.Chest);
      this.Body2.func_78792_a(this.Body3);
      this.LegL.func_78792_a(this.FeetL);
      this.ArmL.func_78792_a(this.ArmL2);
      this.LegR.func_78792_a(this.FeetR);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Head.func_78792_a(this.Beard);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Beard.func_78792_a(this.Beard2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
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
