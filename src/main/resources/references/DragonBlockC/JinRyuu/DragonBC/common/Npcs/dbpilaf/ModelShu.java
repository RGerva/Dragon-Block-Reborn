package JinRyuu.DragonBC.common.Npcs.dbpilaf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelShu extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL;
   public ModelRenderer LegR;
   public ModelRenderer tail1;
   public ModelRenderer Head_1;
   public ModelRenderer EarR;
   public ModelRenderer EarL;
   public ModelRenderer Sword;
   public ModelRenderer Sword2;
   public ModelRenderer LegL_1;
   public ModelRenderer LegR_1;
   public ModelRenderer tail2;
   public ModelRenderer tail3;

   public ModelShu() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.LegR = new ModelRenderer(this, 1, 42);
      this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
      this.LegR.func_78790_a(-2.1F, 0.0F, -2.4F, 4, 5, 5, 0.0F);
      this.EarR = new ModelRenderer(this, 31, 1);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-3.4F, -10.4F, -0.1F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
      this.LegL = new ModelRenderer(this, 1, 42);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
      this.LegL.func_78790_a(-1.9F, 0.0F, -2.4F, 4, 5, 5, 0.0F);
      this.EarL = new ModelRenderer(this, 31, 1);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(0.4F, -10.4F, 0.1F, 3, 4, 0, 0.0F);
      this.setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
      this.tail1 = new ModelRenderer(this, 42, 1);
      this.tail1.func_78793_a(0.0F, 16.1F, 2.7F);
      this.tail1.func_78790_a(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
      this.setRotateAngle(this.tail1, -0.01379388F, 0.0F, 0.0F);
      this.Sword = new ModelRenderer(this, 27, 16);
      this.Sword.func_78793_a(-0.7F, 2.6F, 3.5F);
      this.Sword.func_78790_a(-8.8F, -1.0F, 0.2F, 18, 2, 0, 0.0F);
      this.setRotateAngle(this.Sword, 0.0F, 0.098262034F, 0.63739425F);
      this.LegL_1 = new ModelRenderer(this, 2, 53);
      this.LegL_1.field_78809_i = true;
      this.LegL_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL_1.func_78790_a(-1.5F, 5.0F, -2.0F, 3, 2, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 1, 31);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(4.5F, 9.0F, 0.0F);
      this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 3, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.04363323F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, 8.3F, 0.0F);
      this.Head.func_78790_a(-4.0F, -6.8F, -4.1F, 8, 7, 7, -0.2F);
      this.ArmR = new ModelRenderer(this, 1, 31);
      this.ArmR.func_78793_a(-4.6F, 9.0F, 0.0F);
      this.ArmR.func_78790_a(-2.3F, -0.6F, -1.4F, 3, 7, 3, 0.0F);
      this.setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.04363323F);
      this.Body = new ModelRenderer(this, 1, 15);
      this.Body.func_78793_a(0.0F, 8.0F, 0.0F);
      this.Body.func_78790_a(-4.0F, 0.3F, -3.0F, 8, 9, 6, 0.0F);
      this.tail2 = new ModelRenderer(this, 48, 2);
      this.tail2.func_78793_a(0.0F, 0.1F, 1.4F);
      this.tail2.func_78790_a(-1.5F, -1.4F, -0.5F, 3, 3, 5, 0.0F);
      this.setRotateAngle(this.tail2, 0.06021386F, 0.0F, 0.0F);
      this.Sword2 = new ModelRenderer(this, 31, 17);
      this.Sword2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Sword2.func_78790_a(-3.9F, -2.0F, -0.7F, 0, 4, 2, 0.0F);
      this.tail3 = new ModelRenderer(this, 53, 10);
      this.tail3.func_78793_a(0.0F, 0.0F, 4.2F);
      this.tail3.func_78790_a(-1.0F, -0.9F, -0.6F, 2, 2, 3, 0.0F);
      this.Head_1 = new ModelRenderer(this, 32, 7);
      this.Head_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head_1.func_78790_a(-1.5F, -2.9F, -5.9F, 3, 3, 2, 0.0F);
      this.LegR_1 = new ModelRenderer(this, 2, 53);
      this.LegR_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR_1.func_78790_a(-1.5F, 5.0F, -2.0F, 3, 2, 4, 0.0F);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.Body.func_78792_a(this.Sword);
      this.LegL.func_78792_a(this.LegL_1);
      this.tail1.func_78792_a(this.tail2);
      this.Sword.func_78792_a(this.Sword2);
      this.tail2.func_78792_a(this.tail3);
      this.Head.func_78792_a(this.Head_1);
      this.LegR.func_78792_a(this.LegR_1);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body.render(f5);
      this.ArmR.render(f5);
      this.ArmL.render(f5);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.LegR.render(f5);
      this.tail1.render(f5);
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
      this.tail1.rotateAngleX = 0.2F;
      ModelRenderer var10000 = this.tail1;
      var10000.rotateAngleX += r4 / 2.0F;
      this.tail2.rotateAngleX = 0.2F;
      var10000 = this.tail2;
      var10000.rotateAngleX += r4 / 2.0F;
      this.tail3.rotateAngleX = 0.2F;
      var10000 = this.tail3;
      var10000.rotateAngleX += r4 / 2.0F;
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
