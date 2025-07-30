package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRedRibbonSoldierGunner extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Hat;
   public ModelRenderer ArmR2;
   public ModelRenderer ArmR3;
   public ModelRenderer Gun1;
   public ModelRenderer Gun2;
   public ModelRenderer Gun4;
   public ModelRenderer Gun3;
   public ModelRenderer Barrel;
   public ModelRenderer ArmL2;
   public ModelRenderer ArmL3;
   public ModelRenderer Ribbon;

   public ModelRedRibbonSoldierGunner() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.Barrel = new ModelRenderer(this, 58, 59);
      this.Barrel.func_78793_a(0.0F, 3.5F, -0.3F);
      this.Barrel.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
      this.ArmR2 = new ModelRenderer(this, 0, 32);
      this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR2, 0.5462881F, -0.22759093F, 0.091106184F);
      this.ArmR = new ModelRenderer(this, 0, 0);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 16);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.ArmL3 = new ModelRenderer(this, 17, 43);
      this.ArmL3.field_78809_i = true;
      this.ArmL3.func_78793_a(1.0F, 4.0F, 0.0F);
      this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL3, -0.13665928F, 0.0F, 0.0F);
      this.Gun2 = new ModelRenderer(this, 55, 51);
      this.Gun2.func_78793_a(0.0F, 5.0F, 0.0F);
      this.Gun2.func_78790_a(-1.0F, -1.6F, -1.3F, 2, 5, 2, 0.0F);
      this.Gun4 = new ModelRenderer(this, 53, 35);
      this.Gun4.func_78793_a(0.0F, -0.9F, 0.4F);
      this.Gun4.func_78790_a(-0.5F, -1.1F, -1.2F, 1, 2, 4, 0.0F);
      this.setRotateAngle(this.Gun4, 0.7285004F, 0.0F, 0.0F);
      this.Gun1 = new ModelRenderer(this, 53, 42);
      this.Gun1.func_78793_a(0.5F, 5.8F, -3.2F);
      this.Gun1.func_78790_a(-1.0F, -1.4F, -1.6F, 2, 5, 3, 0.0F);
      this.setRotateAngle(this.Gun1, -0.10471976F, -0.2268928F, 0.4712389F);
      this.ArmR3 = new ModelRenderer(this, 17, 32);
      this.ArmR3.func_78793_a(-1.0F, 4.4F, -1.7F);
      this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmR3, -2.048842F, -0.31869712F, 0.0F);
      this.ArmL2 = new ModelRenderer(this, 0, 43);
      this.ArmL2.field_78809_i = true;
      this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
      this.setRotateAngle(this.ArmL2, -1.1838568F, 0.8196066F, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 16);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Gun3 = new ModelRenderer(this, 50, 51);
      this.Gun3.func_78793_a(0.0F, 1.7F, -1.5F);
      this.Gun3.func_78790_a(-0.5F, -1.9F, -0.5F, 1, 5, 1, 0.0F);
      this.Ribbon = new ModelRenderer(this, 41, 20);
      this.Ribbon.func_78793_a(2.8F, 0.9F, 0.0F);
      this.Ribbon.func_78790_a(0.0F, -1.9F, 0.0F, 6, 5, 0, 0.0F);
      this.setRotateAngle(this.Ribbon, 0.0F, -0.95609134F, 0.0F);
      this.Body = new ModelRenderer(this, 16, 16);
      this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 0, 0);
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.Hat = new ModelRenderer(this, 24, 2);
      this.Hat.func_78793_a(0.0F, -5.0F, -4.4F);
      this.Hat.func_78790_a(-4.0F, 0.0F, -1.6F, 8, 0, 2, 0.0F);
      this.setRotateAngle(this.Hat, 0.22759093F, 0.0F, 0.0F);
      this.Gun2.func_78792_a(this.Barrel);
      this.ArmR.func_78792_a(this.ArmR2);
      this.ArmL2.func_78792_a(this.ArmL3);
      this.Gun1.func_78792_a(this.Gun2);
      this.Gun1.func_78792_a(this.Gun4);
      this.ArmR3.func_78792_a(this.Gun1);
      this.ArmR2.func_78792_a(this.ArmR3);
      this.ArmL.func_78792_a(this.ArmL2);
      this.Gun1.func_78792_a(this.Gun3);
      this.ArmL2.func_78792_a(this.Ribbon);
      this.Head.func_78792_a(this.Hat);
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
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
   }
}
