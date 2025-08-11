package JinRyuu.DragonBC.common.Npcs.dbtournament;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTien2 extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer Chest;
   public ModelRenderer Eye;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer CapeBase;
   public ModelRenderer Cape;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmL2;

   public ModelTien2() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Chest = new ModelRenderer(this, 26, 17);
      this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Chest.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 47, 36);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 29, 36);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Cape = new ModelRenderer(this, 1, 46);
      this.Cape.func_78793_a(0.0F, 1.3F, 2.3F);
      this.Cape.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 16, 0, 0.0F);
      this.ArmL = new ModelRenderer(this, 47, 24);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.1F);
      this.Body2 = new ModelRenderer(this, 1, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 1, 3, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.ArmR = new ModelRenderer(this, 47, 24);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.1F);
      this.Eye = new ModelRenderer(this, 0, 0);
      this.Eye.func_78793_a(0.0F, -5.9F, -4.1F);
      this.Eye.func_78790_a(-1.5F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
      this.LegR = new ModelRenderer(this, 29, 36);
      this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 35);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
      this.Body = new ModelRenderer(this, 1, 17);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.2F);
      this.CapeBase = new ModelRenderer(this, 19, 55);
      this.CapeBase.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeBase.func_78790_a(-3.5F, -0.6F, -2.5F, 7, 2, 5, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 47, 36);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Body.func_78792_a(this.Chest);
      this.ArmR.func_78792_a(this.ArmR2);
      this.CapeBase.func_78792_a(this.Cape);
      this.Body.func_78792_a(this.Body2);
      this.Head.func_78792_a(this.Eye);
      this.Body.func_78792_a(this.Body3);
      this.Body.func_78792_a(this.CapeBase);
      this.ArmL.func_78792_a(this.ArmL2);
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
      this.Cape.rotateAngleX = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (0.0F > this.Cape.rotateAngleX) {
         ModelRenderer var10000 = this.Cape;
         var10000.rotateAngleX *= -1.0F;
      }

      this.Cape.rotateAngleY = 0.0F;
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
