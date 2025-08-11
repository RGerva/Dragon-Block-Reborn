package JinRyuu.DragonBC.common.Npcs.dbbaba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGrandpaGohan extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Beard;
   public ModelRenderer Head2;
   public ModelRenderer Halo;
   public ModelRenderer Mask;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;
   public ModelRenderer FeetR;
   public ModelRenderer FeetL;

   public ModelGrandpaGohan() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head2 = new ModelRenderer(this, 0, 0);
      this.Head2.func_78793_a(0.0F, -7.0F, 0.0F);
      this.Head2.func_78790_a(-1.0F, -1.8F, -1.0F, 2, 2, 2, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 27, 38);
      this.ArmR2.func_78793_a(-1.0F, 6.5F, 0.1F);
      this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 40);
      this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.Beard = new ModelRenderer(this, 27, 2);
      this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
      this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
      this.Halo = new ModelRenderer(this, 38, 1);
      this.Halo.func_78793_a(0.0F, -12.4F, 1.6F);
      this.Halo.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 0, 8, 0.0F);
      this.setRotateAngle(this.Halo, -0.4553564F, 0.0F, 0.0F);
      this.Mask = new ModelRenderer(this, 48, 11);
      this.Mask.func_78793_a(0.0F, -5.0F, -3.5F);
      this.Mask.func_78790_a(-3.5F, -4.6F, 0.0F, 7, 9, 0, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 27, 38);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(1.1F, 6.4F, 0.1F);
      this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
      this.FeetL = new ModelRenderer(this, 1, 54);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 27, 24);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.6F, 5.5F, 0.1F);
      this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
      this.LegL = new ModelRenderer(this, 0, 40);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
      this.ArmR = new ModelRenderer(this, 27, 24);
      this.ArmR.func_78793_a(-4.6F, 5.5F, 0.1F);
      this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
      this.FeetR = new ModelRenderer(this, 1, 54);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
      this.Body = new ModelRenderer(this, 0, 23);
      this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 11, 5, 0.0F);
      this.Head.func_78792_a(this.Head2);
      this.ArmR.func_78792_a(this.ArmR2);
      this.Head.func_78792_a(this.Beard);
      this.Head.func_78792_a(this.Halo);
      this.Head.func_78792_a(this.Mask);
      this.ArmL.func_78792_a(this.ArmL2);
      this.LegL.func_78792_a(this.FeetL);
      this.LegR.func_78792_a(this.FeetR);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.render(f5);
      this.Body.render(f5);
      this.ArmR.render(f5);
      this.ArmL.render(f5);
      this.LegL.render(f5);
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
   }
}
