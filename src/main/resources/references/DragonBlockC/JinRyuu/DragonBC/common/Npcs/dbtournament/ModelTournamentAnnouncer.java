package JinRyuu.DragonBC.common.Npcs.dbtournament;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTournamentAnnouncer extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Arm;
   public ModelRenderer Hair1;
   public ModelRenderer Hair2;
   public ModelRenderer Glasses;
   public ModelRenderer Body2;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer Mic1;
   public ModelRenderer Mic2;

   public ModelTournamentAnnouncer() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.3F);
      this.Body = new ModelRenderer(this, 0, 17);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 34);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Hair2 = new ModelRenderer(this, 43, 43);
      this.Hair2.func_78793_a(0.0F, -6.0F, 0.0F);
      this.Hair2.func_78790_a(-2.0F, -2.5F, -4.2F, 4, 3, 6, 0.0F);
      this.Glasses = new ModelRenderer(this, 32, 0);
      this.Glasses.func_78793_a(0.0F, 0.3F, 0.0F);
      this.Glasses.func_78790_a(-4.0F, -6.2F, -3.9F, 8, 3, 8, 0.0F);
      this.Arm = new ModelRenderer(this, 0, 0);
      this.Arm.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.Arm.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 34);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 18, 53);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR2, -0.5462881F, -0.5009095F, 0.0F);
      this.Mic1 = new ModelRenderer(this, 49, 14);
      this.Mic1.func_78793_a(0.7F, 5.1F, -0.2F);
      this.Mic1.func_78790_a(-0.5F, -2.2F, -0.5F, 1, 5, 1, 0.0F);
      this.setRotateAngle(this.Mic1, 1.5025539F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 27, 18);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 0.1F, -1.8F, 7, 7, 3, 0.0F);
      this.Hair1 = new ModelRenderer(this, 40, 56);
      this.Hair1.func_78793_a(0.0F, -5.3F, 3.1F);
      this.Hair1.func_78790_a(-4.0F, -2.7F, -3.0F, 8, 4, 4, 0.0F);
      this.ArmR3 = new ModelRenderer(this, 0, 53);
      this.ArmR3.func_78793_a(-1.0F, 4.0F, 0.0F);
      this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR3, -1.0927507F, -0.22759093F, 0.0F);
      this.Mic2 = new ModelRenderer(this, 54, 13);
      this.Mic2.func_78793_a(0.0F, -2.6F, 0.0F);
      this.Mic2.func_78790_a(-1.0F, -1.5F, -1.0F, 2, 2, 2, 0.0F);
      this.ArmL = new ModelRenderer(this, 18, 34);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Head.func_78792_a(this.Hair2);
      this.Head.func_78792_a(this.Glasses);
      this.Arm.func_78792_a(this.ArmR2);
      this.ArmR3.func_78792_a(this.Mic1);
      this.Body.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.Hair1);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.Mic1.func_78792_a(this.Mic2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Head.func_78785_a(f5);
      this.Body.func_78785_a(f5);
      this.Arm.func_78785_a(f5);
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
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
   }
}
