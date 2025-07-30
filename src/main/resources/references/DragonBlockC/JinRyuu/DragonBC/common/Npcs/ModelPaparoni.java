package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPaparoni extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Hair1;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Beard;
   public ModelRenderer Hair2;
   public ModelRenderer HairR1;
   public ModelRenderer HairL1;
   public ModelRenderer HairR2;
   public ModelRenderer HairR3;
   public ModelRenderer HairL2;
   public ModelRenderer HairL3;
   public ModelRenderer Body3;
   public ModelRenderer Body2;
   public ModelRenderer Body4;
   public ModelRenderer Neckerchief;

   public ModelPaparoni() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body1 = new ModelRenderer(this, 0, 17);
      this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 29);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.5F, 7.0F, -1.6F, 7, 3, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 26, 36);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.6F, -0.5F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -1.8F, -2.0F, 4, 14, 4, -0.3F);
      this.HairR2 = new ModelRenderer(this, 56, 13);
      this.HairR2.func_78793_a(0.0F, 2.8F, 0.0F);
      this.HairR2.func_78790_a(-0.7F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
      this.setRotateAngle(this.HairR2, -0.13665928F, 0.0F, 0.045553092F);
      this.ArmR = new ModelRenderer(this, 26, 36);
      this.ArmR.func_78793_a(-4.6F, -0.5F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -1.8F, -2.0F, 4, 14, 4, -0.3F);
      this.HairR3 = new ModelRenderer(this, 57, 18);
      this.HairR3.func_78793_a(0.0F, 1.9F, 0.0F);
      this.HairR3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HairR3, -0.13665928F, 0.0F, 0.045553092F);
      this.LegL = new ModelRenderer(this, 1, 45);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 11.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
      this.HairL3 = new ModelRenderer(this, 57, 18);
      this.HairL3.func_78793_a(0.0F, 1.9F, 0.0F);
      this.HairL3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HairL3, -0.13665928F, 0.0F, -0.045553092F);
      this.HairL1 = new ModelRenderer(this, 57, 8);
      this.HairL1.func_78793_a(4.2F, 2.8F, -0.7F);
      this.HairL1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HairL1, -0.13665928F, 0.0F, -0.045553092F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -2.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Hair2 = new ModelRenderer(this, 50, 1);
      this.Hair2.func_78793_a(0.0F, 0.0F, -3.9F);
      this.Hair2.func_78790_a(-1.5F, -1.4F, -2.9F, 3, 3, 3, 0.0F);
      this.HairL2 = new ModelRenderer(this, 56, 13);
      this.HairL2.func_78793_a(0.0F, 2.8F, 0.0F);
      this.HairL2.func_78790_a(-0.5F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
      this.setRotateAngle(this.HairL2, -0.13665928F, 0.0F, -0.045553092F);
      this.EarL = new ModelRenderer(this, 27, 3);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.6F, -3.5F, -0.5F);
      this.EarL.func_78790_a(-0.5F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.43633232F, -0.2268928F);
      this.Neckerchief = new ModelRenderer(this, 28, 29);
      this.Neckerchief.func_78793_a(0.0F, 0.0F, -1.4F);
      this.Neckerchief.func_78790_a(-1.5F, -0.1F, -0.2F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.Neckerchief, -0.06981317F, 0.0F, 0.0F);
      this.Beard = new ModelRenderer(this, 33, 12);
      this.Beard.func_78793_a(0.0F, -0.7F, -4.1F);
      this.Beard.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
      this.setRotateAngle(this.Beard, -0.02094395F, 0.0F, 0.0F);
      this.EarR = new ModelRenderer(this, 27, 3);
      this.EarR.func_78793_a(-3.6F, -3.5F, -0.5F);
      this.EarR.func_78790_a(-4.4F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.43633232F, 0.2268928F);
      this.Hair1 = new ModelRenderer(this, 33, 1);
      this.Hair1.func_78793_a(0.0F, -8.0F, 0.0F);
      this.Hair1.func_78790_a(-2.0F, -2.8F, -4.0F, 4, 3, 7, 0.0F);
      this.HairR1 = new ModelRenderer(this, 57, 8);
      this.HairR1.func_78793_a(-4.0F, 2.8F, -0.7F);
      this.HairR1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.HairR1, -0.13665928F, 0.0F, 0.045553092F);
      this.Body2 = new ModelRenderer(this, 25, 18);
      this.Body2.func_78793_a(0.0F, 0.0F, -0.2F);
      this.Body2.func_78790_a(-3.5F, 0.0F, -1.5F, 7, 7, 3, 0.0F);
      this.LegR = new ModelRenderer(this, 1, 45);
      this.LegR.func_78793_a(-2.0F, 11.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
      this.Body4 = new ModelRenderer(this, 0, 36);
      this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body4.func_78790_a(-4.0F, 10.0F, -2.0F, 8, 3, 4, 0.0F);
      this.Body1.func_78792_a(this.Body3);
      this.HairR1.func_78792_a(this.HairR2);
      this.HairR2.func_78792_a(this.HairR3);
      this.HairL2.func_78792_a(this.HairL3);
      this.Hair1.func_78792_a(this.HairL1);
      this.Hair1.func_78792_a(this.Hair2);
      this.HairL1.func_78792_a(this.HairL2);
      this.Head.func_78792_a(this.EarL);
      this.Body2.func_78792_a(this.Neckerchief);
      this.Head.func_78792_a(this.Beard);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.Hair1);
      this.Hair1.func_78792_a(this.HairR1);
      this.Body1.func_78792_a(this.Body2);
      this.Body3.func_78792_a(this.Body4);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Body1.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
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
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
