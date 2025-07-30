package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class KintounModel extends ModelBase {
   public ModelRenderer Base;
   public ModelRenderer FrontL;
   public ModelRenderer FrontR;
   public ModelRenderer SideL1;
   public ModelRenderer SideR;
   public ModelRenderer BackR1;
   public ModelRenderer BackL1;
   public ModelRenderer Bottom;
   public ModelRenderer SideL2;
   public ModelRenderer BackR2;
   public ModelRenderer Tail1;
   public ModelRenderer Tail2;

   public KintounModel() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.SideL2 = new ModelRenderer(this, 48, 11);
      this.SideL2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.SideL2.func_78790_a(4.4F, -2.1F, -10.1F, 5, 4, 6, 0.0F);
      this.Base = new ModelRenderer(this, 0, 0);
      this.Base.func_78793_a(0.0F, -9.7F, 0.0F);
      this.Base.func_78790_a(-5.0F, -5.1F, -5.2F, 10, 10, 11, 0.0F);
      this.Tail1 = new ModelRenderer(this, 20, 48);
      this.Tail1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Tail1.func_78790_a(-1.5F, -3.4F, 12.7F, 5, 4, 6, 0.0F);
      this.Bottom = new ModelRenderer(this, 43, 0);
      this.Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Bottom.func_78790_a(-2.8F, 4.0F, -3.8F, 6, 2, 9, 0.0F);
      this.BackR1 = new ModelRenderer(this, 60, 41);
      this.BackR1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BackR1.func_78790_a(-7.3F, -5.5F, 2.9F, 7, 8, 10, 0.0F);
      this.Tail2 = new ModelRenderer(this, 0, 50);
      this.Tail2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Tail2.func_78790_a(-3.9F, -2.4F, 12.4F, 5, 4, 9, 0.0F);
      this.BackL1 = new ModelRenderer(this, 94, 41);
      this.BackL1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BackL1.func_78790_a(-0.5F, -3.7F, 4.8F, 7, 8, 10, 0.0F);
      this.SideL1 = new ModelRenderer(this, 60, 11);
      this.SideL1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.SideL1.func_78790_a(3.1F, -4.2F, -4.9F, 7, 8, 10, 0.0F);
      this.FrontL = new ModelRenderer(this, 0, 22);
      this.FrontL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FrontL.func_78790_a(-0.4F, -5.5F, -12.7F, 7, 8, 10, 0.0F);
      this.FrontR = new ModelRenderer(this, 35, 22);
      this.FrontR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.FrontR.func_78790_a(-6.4F, -4.1F, -11.3F, 7, 8, 10, 0.0F);
      this.SideR = new ModelRenderer(this, 94, 11);
      this.SideR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.SideR.func_78790_a(-9.5F, -4.8F, -6.4F, 7, 8, 10, 0.0F);
      this.BackR2 = new ModelRenderer(this, 48, 41);
      this.BackR2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.BackR2.func_78790_a(-4.6F, 1.2F, 4.1F, 5, 4, 6, 0.0F);
      this.SideL1.func_78792_a(this.SideL2);
      this.BackL1.func_78792_a(this.Tail1);
      this.Base.func_78792_a(this.Bottom);
      this.Base.func_78792_a(this.BackR1);
      this.Tail1.func_78792_a(this.Tail2);
      this.Base.func_78792_a(this.BackL1);
      this.Base.func_78792_a(this.SideL1);
      this.Base.func_78792_a(this.FrontL);
      this.Base.func_78792_a(this.FrontR);
      this.Base.func_78792_a(this.SideR);
      this.BackR1.func_78792_a(this.BackR2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
      GL11.glTranslatef(0.2F, 0.5F, 0.0F);
      float ex = (float)entity.field_70173_aa;
      float cosi = MathHelper.func_76134_b(ex * 0.2F) * 0.02F;
      float cosi2 = MathHelper.func_76134_b(ex * 0.2F) * 0.01F * -1.0F;
      GL11.glTranslatef(cosi, cosi, 0.0F);
      this.Base.func_78785_a(f5);
      GL11.glPopMatrix();
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }

   public void renderModel(float f5) {
      this.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
   }

   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
      float ex = (float)par7Entity.field_70173_aa;
      float cosi = MathHelper.func_76134_b(ex * 0.5F) * 0.2F;
      float cosi2 = MathHelper.func_76134_b(ex * 0.5F) * 0.1F;
      this.FrontL.field_78795_f = -cosi * f2 * -1.0F;
      this.FrontL.field_78796_g = -cosi * f2 * -1.0F;
      this.FrontR.field_78795_f = -cosi2 * f2;
      this.FrontR.field_78796_g = -cosi2 * f2;
      this.SideL1.field_78795_f = -cosi * f2 * -1.0F;
      this.SideL1.field_78796_g = -cosi * f2 * -1.0F;
      this.SideR.field_78795_f = -cosi2 * f2;
      this.SideR.field_78796_g = -cosi2 * f2;
      this.BackR1.field_78795_f = -cosi * f2 * -1.0F;
      this.BackR1.field_78796_g = -cosi * f2 * -1.0F;
      this.BackL1.field_78795_f = -cosi2 * f2;
      this.BackL1.field_78796_g = -cosi2 * f2;
      this.Bottom.field_78795_f = -cosi * f2 * -1.0F;
      this.Bottom.field_78796_g = -cosi * f2 * -1.0F;
      this.SideL2.field_78795_f = -cosi2 * f2;
      this.SideL2.field_78796_g = -cosi2 * f2;
      this.BackR2.field_78795_f = -cosi * f2 * -1.0F;
      this.BackR2.field_78796_g = -cosi * f2 * -1.0F;
      this.Tail1.field_78795_f = -cosi2 * f2;
      this.Tail1.field_78796_g = -cosi2 * f2;
      this.Tail2.field_78795_f = -cosi * f2 * -1.0F;
      this.Tail2.field_78796_g = -cosi * f2 * -1.0F;
   }
}
