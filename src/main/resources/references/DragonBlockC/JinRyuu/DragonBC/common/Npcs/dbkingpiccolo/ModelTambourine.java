package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTambourine extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Head2;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Cloth;
   public ModelRenderer WingL;
   public ModelRenderer WingR;
   public ModelRenderer Cloth2;

   public ModelTambourine() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.Cloth2 = new ModelRenderer(this, 41, 0);
      this.Cloth2.func_78793_a(0.0F, 8.5F, -2.1F);
      this.Cloth2.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
      this.setRotateAngle(this.Cloth2, -0.05235988F, 0.0F, 0.0F);
      this.Cloth = new ModelRenderer(this, 55, 3);
      this.Cloth.func_78793_a(0.0F, 9.0F, 0.4F);
      this.Cloth.func_78790_a(-4.5F, 0.0F, -2.3F, 9, 6, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 27, 17);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.WingR = new ModelRenderer(this, 29, 39);
      this.WingR.func_78793_a(-3.0F, 3.0F, 2.6F);
      this.WingR.func_78790_a(-19.0F, -14.0F, 0.0F, 21, 22, 0, 0.0F);
      this.setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
      this.EarR = new ModelRenderer(this, 32, 1);
      this.EarR.func_78793_a(-3.5F, -4.4F, -1.0F);
      this.EarR.func_78790_a(-3.5F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
      this.Head2 = new ModelRenderer(this, 35, -1);
      this.Head2.func_78793_a(0.0F, -4.8F, 0.9F);
      this.Head2.func_78790_a(0.0F, -4.0F, -4.0F, 0, 8, 8, 0.0F);
      this.WingL = new ModelRenderer(this, 29, 39);
      this.WingL.field_78809_i = true;
      this.WingL.func_78793_a(1.0F, 3.0F, 2.6F);
      this.WingL.func_78790_a(0.0F, -14.0F, 0.0F, 21, 22, 0, 0.0F);
      this.setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
      this.ArmR = new ModelRenderer(this, 27, 17);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 2, 39);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 2, 39);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 32, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(3.8F, -4.4F, -1.0F);
      this.EarL.func_78790_a(0.0F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Body = new ModelRenderer(this, 1, 19);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.Body.func_78792_a(this.Cloth2);
      this.Body.func_78792_a(this.Cloth);
      this.Body.func_78792_a(this.WingR);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.Head2);
      this.Body.func_78792_a(this.WingL);
      this.Head.func_78792_a(this.EarL);
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
      this.Cloth2.rotateAngleX = -0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegR.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegL.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      this.Cloth.rotateAngleX = 0.15F + this.LegL.rotateAngleX * (float)(this.LegR.rotateAngleX >= 0.0F ? -1 : 1) * 1.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
