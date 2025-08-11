package JinRyuu.DragonBC.common.Npcs.db;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBora extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Hair;
   public ModelRenderer Body2;
   public ModelRenderer Chest;
   public ModelRenderer Body3;

   public ModelBora() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.LegR = new ModelRenderer(this, 0, 43);
      this.LegR.func_78793_a(-2.4F, 10.1F, 0.0F);
      this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -3.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.2F, -4.0F, 8, 8, 8, 0.0F);
      this.Body3 = new ModelRenderer(this, 22, 44);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-5.0F, 9.7F, -2.5F, 10, 4, 5, 0.0F);
      this.ArmL = new ModelRenderer(this, 0, 17);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.8F, -1.7F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 14, 5, -0.2F);
      this.Chest = new ModelRenderer(this, 54, 19);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-5.0F, 1.0F, -2.7F, 10, 4, 1, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 43);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.4F, 10.1F, 0.0F);
      this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
      this.ArmR = new ModelRenderer(this, 0, 17);
      this.ArmR.func_78793_a(-5.8F, -1.7F, 0.0F);
      this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 14, 5, -0.2F);
      this.Body = new ModelRenderer(this, 22, 17);
      this.Body.func_78793_a(0.0F, -3.5F, 0.0F);
      this.Body.func_78790_a(-5.0F, 0.0F, -2.0F, 10, 7, 5, 0.1F);
      this.Hair = new ModelRenderer(this, 33, 0);
      this.Hair.func_78793_a(0.0F, -1.2F, 4.0F);
      this.Hair.func_78790_a(-2.0F, 0.0F, 0.0F, 4, 6, 0, 0.0F);
      this.setRotateAngle(this.Hair, 0.04712389F, 0.0F, 0.0F);
      this.Body2 = new ModelRenderer(this, 23, 31);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-4.5F, 4.7F, -2.4F, 9, 5, 5, 0.0F);
      this.Body2.func_78792_a(this.Body3);
      this.Body.func_78792_a(this.Chest);
      this.Head.func_78792_a(this.Hair);
      this.Body.func_78792_a(this.Body2);
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
      this.Hair.rotateAngleX = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (0.0F > this.Hair.rotateAngleX) {
         ModelRenderer var10000 = this.Hair;
         var10000.rotateAngleX *= -1.0F;
      }

      this.Hair.rotateAngleY = 0.0F;
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
