package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelFrog extends ModelBase {
   public ModelRenderer Body1;
   public ModelRenderer ArmL;
   public ModelRenderer ArmR;
   public ModelRenderer LegL1;
   public ModelRenderer LegR1;
   public ModelRenderer Body2;
   public ModelRenderer Head1;
   public ModelRenderer Body3;
   public ModelRenderer Tail1;
   public ModelRenderer Tail2;
   public ModelRenderer Head2;
   public ModelRenderer AntennaR;
   public ModelRenderer AntennaL;
   public ModelRenderer Head3;
   public ModelRenderer AntennaR_1;
   public ModelRenderer AntennaR_2;
   public ModelRenderer AntennaL_1;
   public ModelRenderer AntennaR_3;
   public ModelRenderer LegL2;
   public ModelRenderer LegR2;

   public ModelFrog() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmR = new ModelRenderer(this, 30, 8);
      this.ArmR.field_78809_i = true;
      this.ArmR.func_78793_a(-3.1F, 17.8F, -3.4F);
      this.ArmR.func_78790_a(-2.3F, -1.0F, -0.9F, 2, 8, 3, 0.0F);
      this.setRotateAngle(this.ArmR, -0.3630285F, 0.0F, 0.23387411F);
      this.Tail1 = new ModelRenderer(this, 0, 37);
      this.Tail1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Tail1.func_78790_a(-2.5F, 2.2F, 11.4F, 5, 3, 2, 0.0F);
      this.setRotateAngle(this.Tail1, 0.071733035F, 0.0F, 0.0F);
      this.Head1 = new ModelRenderer(this, 42, 2);
      this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head1.func_78790_a(-3.0F, 0.2F, -10.0F, 6, 5, 4, 0.0F);
      this.setRotateAngle(this.Head1, 0.13665928F, 0.0F, 0.0F);
      this.Tail2 = new ModelRenderer(this, 0, 43);
      this.Tail2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Tail2.func_78790_a(-1.5F, 3.4F, 13.2F, 3, 2, 4, 0.0F);
      this.setRotateAngle(this.Tail2, 0.045553092F, 0.0F, 0.0F);
      this.AntennaR = new ModelRenderer(this, 31, 0);
      this.AntennaR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaR.func_78790_a(-3.1F, -5.4F, -5.0F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaR, 0.8552113F, -0.090757124F, 0.0F);
      this.Body2 = new ModelRenderer(this, 0, 0);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.5F, -0.3F, -6.2F, 7, 6, 6, 0.0F);
      this.setRotateAngle(this.Body2, 0.13665928F, 0.0F, 0.0F);
      this.AntennaL = new ModelRenderer(this, 31, 0);
      this.AntennaL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaL.func_78790_a(2.2F, -5.4F, -5.0F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaL, 0.8552113F, 0.090757124F, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 13);
      this.Body1.func_78793_a(0.0F, 14.7F, 0.0F);
      this.Body1.func_78790_a(-4.5F, -0.4F, -0.2F, 9, 6, 9, 0.0F);
      this.setRotateAngle(this.Body1, -0.091106184F, 0.0F, 0.0F);
      this.Body3 = new ModelRenderer(this, 0, 29);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-3.0F, 0.8F, 8.7F, 6, 4, 3, 0.0F);
      this.setRotateAngle(this.Body3, -0.15009831F, 0.0F, 0.0F);
      this.AntennaR_2 = new ModelRenderer(this, 31, 0);
      this.AntennaR_2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaR_2.func_78790_a(-3.1F, -4.7F, -0.2F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaR_2, -0.22759093F, 0.0F, 0.0F);
      this.AntennaL_1 = new ModelRenderer(this, 31, 0);
      this.AntennaL_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaL_1.func_78790_a(2.2F, -4.6F, -3.1F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaL_1, -0.4098033F, 0.0F, 0.0F);
      this.LegR1 = new ModelRenderer(this, 20, 31);
      this.LegR1.field_78809_i = true;
      this.LegR1.func_78793_a(-3.9F, 18.6F, 7.4F);
      this.LegR1.func_78790_a(-3.8F, -2.3F, -7.2F, 3, 4, 8, 0.0F);
      this.setRotateAngle(this.LegR1, -0.13665928F, 0.18203785F, 0.0F);
      this.LegL2 = new ModelRenderer(this, 22, 47);
      this.LegL2.func_78793_a(1.4F, 1.3F, -6.0F);
      this.LegL2.func_78790_a(-0.9F, -0.8F, -0.3F, 2, 2, 7, 0.0F);
      this.setRotateAngle(this.LegL2, -0.59166664F, 0.0F, 0.0F);
      this.Head2 = new ModelRenderer(this, 43, 12);
      this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head2.func_78790_a(-2.5F, 2.1F, -12.7F, 5, 3, 4, 0.0F);
      this.ArmL = new ModelRenderer(this, 30, 8);
      this.ArmL.func_78793_a(3.6F, 17.8F, -3.4F);
      this.ArmL.func_78790_a(-0.3F, -1.0F, -0.9F, 2, 8, 3, 0.0F);
      this.setRotateAngle(this.ArmL, -0.3642502F, 0.0F, -0.22759093F);
      this.AntennaR_1 = new ModelRenderer(this, 31, 0);
      this.AntennaR_1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaR_1.func_78790_a(-3.1F, -4.6F, -3.1F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaR_1, -0.4098033F, 0.0F, 0.0F);
      this.Head3 = new ModelRenderer(this, 45, 20);
      this.Head3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Head3.func_78790_a(-2.0F, -5.4F, -12.4F, 4, 2, 4, 0.0F);
      this.setRotateAngle(this.Head3, 0.59184116F, 0.0F, 0.0F);
      this.AntennaR_3 = new ModelRenderer(this, 31, 0);
      this.AntennaR_3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.AntennaR_3.func_78790_a(2.2F, -4.7F, -0.2F, 1, 1, 4, 0.0F);
      this.setRotateAngle(this.AntennaR_3, -0.22759093F, 0.0F, 0.0F);
      this.LegL1 = new ModelRenderer(this, 20, 31);
      this.LegL1.func_78793_a(4.7F, 18.6F, 7.4F);
      this.LegL1.func_78790_a(0.0F, -2.3F, -7.2F, 3, 4, 8, 0.0F);
      this.setRotateAngle(this.LegL1, -0.13665928F, -0.18203785F, 0.0F);
      this.LegR2 = new ModelRenderer(this, 22, 47);
      this.LegR2.field_78809_i = true;
      this.LegR2.func_78793_a(-2.3F, 1.3F, -6.0F);
      this.LegR2.func_78790_a(-1.0F, -0.8F, -0.3F, 2, 2, 7, 0.0F);
      this.setRotateAngle(this.LegR2, -0.59166664F, 0.0F, 0.0F);
      this.Body3.func_78792_a(this.Tail1);
      this.Body1.func_78792_a(this.Head1);
      this.Tail1.func_78792_a(this.Tail2);
      this.Head1.func_78792_a(this.AntennaR);
      this.Body1.func_78792_a(this.Body2);
      this.Head1.func_78792_a(this.AntennaL);
      this.Body2.func_78792_a(this.Body3);
      this.AntennaR_1.func_78792_a(this.AntennaR_2);
      this.AntennaL.func_78792_a(this.AntennaL_1);
      this.LegL1.func_78792_a(this.LegL2);
      this.Head1.func_78792_a(this.Head2);
      this.AntennaR.func_78792_a(this.AntennaR_1);
      this.Head2.func_78792_a(this.Head3);
      this.AntennaL_1.func_78792_a(this.AntennaR_3);
      this.LegR1.func_78792_a(this.LegR2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      if (entity.field_70122_E && entity.field_70181_x < 0.2D) {
         this.LegL1.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.2F * f1;
         this.LegR1.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.2F * f1;
         this.setRotateAngle(this.LegL2, -0.59166664F, 0.0F, 0.0F);
         this.setRotateAngle(this.LegR2, -0.59166664F, 0.0F, 0.0F);
      } else {
         this.LegL1.field_78795_f = 2.3F;
         this.LegR1.field_78795_f = 2.3F;
         this.LegL2.field_78795_f = -3.0F;
         this.LegR2.field_78795_f = -3.0F;
      }

      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glTranslatef(0.0F, 1.4F, 0.0F);
      this.ArmR.func_78785_a(f5);
      this.Body1.func_78785_a(f5);
      this.LegR1.func_78785_a(f5);
      this.ArmL.func_78785_a(f5);
      this.LegL1.func_78785_a(f5);
      GL11.glPopMatrix();
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }
}
