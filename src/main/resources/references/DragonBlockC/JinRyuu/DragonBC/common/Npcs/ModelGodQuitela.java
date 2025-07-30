package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.JGRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelGodQuitela extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer tail;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer EarL;
   public ModelRenderer EarR;
   public ModelRenderer Snout1;
   public ModelRenderer Snout2;
   public ModelRenderer Neck;
   public ModelRenderer Body3;
   public ModelRenderer Cloth1;
   public ModelRenderer tail_1;
   public ModelRenderer tail_2;
   public ModelRenderer tail_3;
   public ModelRenderer tail_4;
   public ModelRenderer LegR2;
   public ModelRenderer LegL2;

   public ModelGodQuitela() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.tail = new ModelRenderer(this, 42, 1);
      this.tail.func_78793_a(0.0F, 10.3F, 1.5F);
      this.tail.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail, 1.0011208F, 0.0F, 0.0F);
      this.EarR = new ModelRenderer(this, 27, 0);
      this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarR.func_78790_a(-8.5F, -10.9F, 1.9F, 6, 6, 1, 0.0F);
      this.setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
      this.ArmR = new ModelRenderer(this, 50, 16);
      this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.EarL = new ModelRenderer(this, 27, 0);
      this.EarL.field_78809_i = true;
      this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.EarL.func_78790_a(2.5F, -10.9F, 1.9F, 6, 6, 1, 0.0F);
      this.setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
      this.ArmL = new ModelRenderer(this, 50, 16);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
      this.LegR = new ModelRenderer(this, 0, 33);
      this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
      this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
      this.tail_2 = new ModelRenderer(this, 42, 1);
      this.tail_2.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail_2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail_2, -0.18203785F, 0.0F, 0.0F);
      this.Neck = new ModelRenderer(this, 40, 6);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -1.3F, -1.5F, 4, 2, 3, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
      this.Head.func_78790_a(-4.5F, -8.0F, -4.0F, 9, 8, 8, 0.0F);
      this.tail_3 = new ModelRenderer(this, 42, 1);
      this.tail_3.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail_3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail_3, 0.27314404F, 0.0F, 0.0F);
      this.LegL2 = new ModelRenderer(this, 0, 16);
      this.LegL2.field_78809_i = true;
      this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Cloth1 = new ModelRenderer(this, 54, 0);
      this.Cloth1.func_78793_a(0.0F, 10.0F, -1.6F);
      this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
      this.setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
      this.tail_4 = new ModelRenderer(this, 42, 1);
      this.tail_4.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail_4.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail_4, 0.27314404F, 0.0F, 0.0F);
      this.Snout1 = new ModelRenderer(this, 41, 14);
      this.Snout1.func_78793_a(0.0F, 0.0F, 0.3F);
      this.Snout1.func_78790_a(-1.5F, -3.4F, -5.4F, 3, 3, 2, 0.0F);
      this.Body1 = new ModelRenderer(this, 20, 18);
      this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.1F, 8, 8, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 33);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
      this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
      this.Snout2 = new ModelRenderer(this, 42, 11);
      this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Snout2.func_78790_a(-0.5F, 1.1F, -5.4F, 1, 2, 1, 0.0F);
      this.setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 20, 37);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
      this.tail_1 = new ModelRenderer(this, 42, 1);
      this.tail_1.func_78793_a(0.0F, 2.6F, 0.0F);
      this.tail_1.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
      this.setRotateAngle(this.tail_1, -0.18203785F, 0.0F, 0.0F);
      this.LegR2 = new ModelRenderer(this, 0, 16);
      this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.Head.func_78792_a(this.EarR);
      this.Head.func_78792_a(this.EarL);
      this.tail_1.func_78792_a(this.tail_2);
      this.Body1.func_78792_a(this.Neck);
      this.tail_2.func_78792_a(this.tail_3);
      this.LegL.func_78792_a(this.LegL2);
      this.Body1.func_78792_a(this.Cloth1);
      this.tail_3.func_78792_a(this.tail_4);
      this.Head.func_78792_a(this.Snout1);
      this.Snout1.func_78792_a(this.Snout2);
      this.Body1.func_78792_a(this.Body3);
      this.tail.func_78792_a(this.tail_1);
      this.LegR.func_78792_a(this.LegR2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      float F = 0.65F;
      JGRenderHelper.modelScalePositionHelper(0.65F);
      this.LegL.func_78785_a(f5);
      this.Head.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegR.func_78785_a(f5);
      GL11.glPopMatrix();
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
      this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegR.field_78796_g = 0.0F;
      this.LegL.field_78796_g = 0.0F;
      this.ArmR.field_78796_g = 0.0F;
      this.ArmL.field_78796_g = 0.0F;
      this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * (float)(this.LegR.field_78795_f >= 0.0F ? -1 : 1) * 1.0F;
      super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
