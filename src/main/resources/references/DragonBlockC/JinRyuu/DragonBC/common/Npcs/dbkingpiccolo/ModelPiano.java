package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPiano extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer Head2;
   public ModelRenderer Beak;
   public ModelRenderer Head3;
   public ModelRenderer Beak2;
   public ModelRenderer Cloth;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;
   public ModelRenderer FeetR;
   public ModelRenderer FeetL;

   public ModelPiano() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 27, 24);
      this.ArmR.func_78793_a(-4.6F, 10.4F, 0.1F);
      this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 7, 4, -0.3F);
      this.LegR = new ModelRenderer(this, 0, 40);
      this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
      this.Body = new ModelRenderer(this, 0, 23);
      this.Body.func_78793_a(0.0F, 9.0F, 0.1F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 8, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 27, 38);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(1.1F, 4.4F, 0.1F);
      this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 9.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -6.9F, -4.0F, 8, 8, 8, -1.0F);
      this.ArmL = new ModelRenderer(this, 27, 24);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.6F, 10.4F, 0.1F);
      this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 7, 4, -0.3F);
      this.Head2 = new ModelRenderer(this, 51, 2);
      this.Head2.func_78793_a(0.0F, -3.6F, 0.8F);
      this.Head2.func_78790_a(-0.5F, -3.6F, -2.3F, 1, 3, 5, 0.0F);
      this.setRotateAngle(this.Head2, 0.4553564F, 0.0F, 0.0F);
      this.FeetL = new ModelRenderer(this, 1, 54);
      this.FeetL.field_78809_i = true;
      this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetL.func_78790_a(-1.5F, 5.0F, -2.5F, 3, 2, 4, 0.0F);
      this.Beak = new ModelRenderer(this, 34, 5);
      this.Beak.func_78793_a(0.0F, -1.7F, -2.3F);
      this.Beak.func_78790_a(-2.5F, -1.5F, -2.6F, 5, 3, 3, 0.0F);
      this.setRotateAngle(this.Beak, 0.13962634F, 0.0F, 0.0F);
      this.Head3 = new ModelRenderer(this, 51, 11);
      this.Head3.func_78793_a(0.0F, -1.6F, 2.7F);
      this.Head3.func_78790_a(-0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F);
      this.FeetR = new ModelRenderer(this, 1, 54);
      this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FeetR.func_78790_a(-1.5F, 5.0F, -2.5F, 3, 2, 4, 0.0F);
      this.Beak2 = new ModelRenderer(this, 34, 12);
      this.Beak2.func_78793_a(0.0F, 0.5F, -2.9F);
      this.Beak2.func_78790_a(-2.0F, -1.0F, -2.7F, 4, 2, 3, 0.0F);
      this.Cloth = new ModelRenderer(this, 45, 23);
      this.Cloth.func_78793_a(0.0F, 0.0F, -2.7F);
      this.Cloth.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 5, 0, 0.0F);
      this.setRotateAngle(this.Cloth, -0.05235988F, 0.0F, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 27, 38);
      this.ArmR2.func_78793_a(-1.0F, 4.5F, 0.1F);
      this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 40);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
      this.ArmL.func_78792_a(this.ArmL2);
      this.Head.func_78792_a(this.Head2);
      this.LegL.func_78792_a(this.FeetL);
      this.Head.func_78792_a(this.Beak);
      this.Head2.func_78792_a(this.Head3);
      this.LegR.func_78792_a(this.FeetR);
      this.Beak.func_78792_a(this.Beak2);
      this.Body.func_78792_a(this.Cloth);
      this.ArmR.func_78792_a(this.ArmR2);
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
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
