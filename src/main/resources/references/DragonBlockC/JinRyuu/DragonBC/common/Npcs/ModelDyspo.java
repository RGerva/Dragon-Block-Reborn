package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDyspo extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Snout1;
   public ModelRenderer Snout2;
   public ModelRenderer SnoutSideR;
   public ModelRenderer SnoutSideL;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer Body3;

   public ModelDyspo() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.EarL = new ModelRenderer(this, 31, 0);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(0.9F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
      this.setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
      this.Snout2 = new ModelRenderer(this, 42, 11);
      this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Snout2.func_78790_a(-0.5F, 1.1F, -5.4F, 1, 2, 1, 0.0F);
      this.setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
      this.Snout1 = new ModelRenderer(this, 41, 14);
      this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Snout1.func_78790_a(-1.5F, -3.4F, -5.4F, 3, 3, 2, 0.0F);
      this.Body2 = new ModelRenderer(this, 23, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 3, 3, 0.0F);
      this.ArmL = new ModelRenderer(this, 50, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 18);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
      this.SnoutSideL = new ModelRenderer(this, 47, 11);
      this.SnoutSideL.field_78809_i = true;
      this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.SnoutSideL.func_78790_a(-1.7F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
      this.setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-1.8F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -0.4F, 0.0F);
      this.Head.func_78790_a(-3.5F, -8.0F, -4.0F, 7, 8, 8, -0.1F);
      this.Body3 = new ModelRenderer(this, 20, 37);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 50, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.8F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
      this.SnoutSideR = new ModelRenderer(this, 47, 11);
      this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.SnoutSideR.func_78790_a(-0.2F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
      this.setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
      this.Neck = new ModelRenderer(this, 42, 6);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -0.9F, -0.8F, 4, 2, 2, 0.0F);
      this.EarR = new ModelRenderer(this, 31, 0);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-5.0F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
      this.setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
      this.Head.func_78792_a(this.EarL);
      this.Snout1.func_78792_a(this.Snout2);
      this.Head.func_78792_a(this.Snout1);
      this.Body1.func_78792_a(this.Body2);
      this.Snout1.func_78792_a(this.SnoutSideL);
      this.Body2.func_78792_a(this.Body3);
      this.Snout1.func_78792_a(this.SnoutSideR);
      this.Body1.func_78792_a(this.Neck);
      this.Head.func_78792_a(this.EarR);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.Body1.render(f5);
      this.LegR.render(f5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }

   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      int calc = par7Entity.ticksExisted;
      if (calc > 100) {
         calc -= 100;
      }

      float r = 360.0F;
      float r2 = 180.0F;
      this.Head.rotateAngleY = par4 / (r2 / 3.1415927F);
      this.Head.rotateAngleX = par5 / (r2 / 3.1415927F);
      float ex = (float)par7Entity.ticksExisted;
      float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
      r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
      r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
      this.LegR.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
