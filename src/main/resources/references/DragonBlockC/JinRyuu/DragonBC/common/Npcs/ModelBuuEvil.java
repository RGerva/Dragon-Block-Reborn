package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuuEvil extends ModelBase {
   public ModelRenderer Head;
   public ModelRenderer Body1;
   public ModelRenderer LegR;
   public ModelRenderer LegL;
   public ModelRenderer ArmR;
   public ModelRenderer ArmL;
   public ModelRenderer Head2;
   public ModelRenderer Jaw;
   public ModelRenderer Head3;
   public ModelRenderer Head4;
   public ModelRenderer Neck;
   public ModelRenderer Body2;
   public ModelRenderer CapeBase;
   public ModelRenderer Cape3R;
   public ModelRenderer Cape3L;
   public ModelRenderer CapeShoulderR;
   public ModelRenderer CapeShoulderL;
   public ModelRenderer Body3;

   public ModelBuuEvil() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.ArmL = new ModelRenderer(this, 0, 25);
      this.ArmL.field_78809_i = true;
      this.ArmL.func_78793_a(5.0F, -0.5F, 0.0F);
      this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
      this.Body1 = new ModelRenderer(this, 15, 19);
      this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
      this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 5, 4, 0.0F);
      this.ArmR = new ModelRenderer(this, 0, 25);
      this.ArmR.func_78793_a(-5.0F, -0.5F, 0.0F);
      this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
      this.Cape3R = new ModelRenderer(this, 43, 15);
      this.Cape3R.func_78793_a(-0.5F, 1.4F, -1.6F);
      this.Cape3R.func_78790_a(-0.5F, 0.2F, -0.4F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.Cape3R, -0.27314404F, 0.3642502F, 0.8651597F);
      this.LegR = new ModelRenderer(this, 0, 45);
      this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
      this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.CapeBase = new ModelRenderer(this, 43, 23);
      this.CapeBase.func_78793_a(0.0F, 0.3F, 2.3F);
      this.CapeBase.func_78790_a(-4.5F, 0.0F, -0.3F, 9, 19, 1, 0.0F);
      this.setRotateAngle(this.CapeBase, 0.090757124F, 0.0F, 0.0F);
      this.CapeShoulderL = new ModelRenderer(this, 44, 15);
      this.CapeShoulderL.field_78809_i = true;
      this.CapeShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeShoulderL.func_78790_a(2.4F, -0.1F, -2.3F, 3, 1, 5, 0.0F);
      this.Jaw = new ModelRenderer(this, 33, 8);
      this.Jaw.func_78793_a(0.0F, -3.1F, 0.0F);
      this.Jaw.func_78790_a(-3.0F, 2.9F, -3.4F, 6, 2, 3, 0.0F);
      this.CapeShoulderR = new ModelRenderer(this, 44, 15);
      this.CapeShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
      this.CapeShoulderR.func_78790_a(-5.4F, -0.1F, -2.3F, 3, 1, 5, 0.0F);
      this.Body2 = new ModelRenderer(this, 17, 29);
      this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 4, 3, 0.0F);
      this.Cape3L = new ModelRenderer(this, 43, 15);
      this.Cape3L.field_78809_i = true;
      this.Cape3L.func_78793_a(0.4F, 1.4F, -1.6F);
      this.Cape3L.func_78790_a(-1.6F, 0.2F, -0.4F, 2, 4, 0, 0.0F);
      this.setRotateAngle(this.Cape3L, -0.31869712F, -0.40142572F, -0.8196066F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.func_78793_a(0.0F, -4.4F, 0.0F);
      this.Head.func_78790_a(-4.0F, -6.2F, -4.4F, 8, 7, 8, -1.0F);
      this.Body3 = new ModelRenderer(this, 15, 37);
      this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
      this.LegL = new ModelRenderer(this, 0, 45);
      this.LegL.field_78809_i = true;
      this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
      this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
      this.Head4 = new ModelRenderer(this, 44, 0);
      this.Head4.func_78793_a(0.0F, -1.6F, -0.2F);
      this.Head4.func_78790_a(-0.5F, -1.9F, -0.8F, 1, 2, 1, 0.0F);
      this.setRotateAngle(this.Head4, -0.4098033F, 0.0F, 0.0F);
      this.Head2 = new ModelRenderer(this, 25, 0);
      this.Head2.func_78793_a(0.0F, -4.8F, -2.0F);
      this.Head2.func_78790_a(-1.0F, -3.8F, -1.3F, 2, 4, 3, 0.0F);
      this.setRotateAngle(this.Head2, -0.22759093F, 0.0F, 0.0F);
      this.Neck = new ModelRenderer(this, 2, 19);
      this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Neck.func_78790_a(-2.0F, -2.8F, -0.5F, 4, 3, 2, 0.0F);
      this.Head3 = new ModelRenderer(this, 36, 0);
      this.Head3.func_78793_a(0.0F, -3.3F, -0.1F);
      this.Head3.func_78790_a(-0.5F, -1.9F, -1.1F, 1, 2, 2, 0.0F);
      this.setRotateAngle(this.Head3, -0.4553564F, 0.0F, 0.0F);
      this.Body1.func_78792_a(this.Cape3R);
      this.Body1.func_78792_a(this.CapeBase);
      this.Body1.func_78792_a(this.CapeShoulderL);
      this.Head.func_78792_a(this.Jaw);
      this.Body1.func_78792_a(this.CapeShoulderR);
      this.Body1.func_78792_a(this.Body2);
      this.Body1.func_78792_a(this.Cape3L);
      this.Body2.func_78792_a(this.Body3);
      this.Head3.func_78792_a(this.Head4);
      this.Head.func_78792_a(this.Head2);
      this.Body1.func_78792_a(this.Neck);
      this.Head2.func_78792_a(this.Head3);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.LegL.render(f5);
      this.Head.render(f5);
      this.ArmL.render(f5);
      this.ArmR.render(f5);
      this.Body1.render(f5);
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
      float rota = -MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (rota > 0.0F) {
         rota *= -1.0F;
      }

      this.CapeBase.rotateAngleX = -0.23F + rota;
      if (0.0F > this.CapeBase.rotateAngleX) {
         ModelRenderer var10000 = this.CapeBase;
         var10000.rotateAngleX *= -1.0F;
      }

      this.CapeBase.rotateAngleY = 0.0F;
      this.LegR.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.LegL.rotateAngleX = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.ArmR.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      this.ArmL.rotateAngleX = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
      this.LegR.rotateAngleY = 0.0F;
      this.LegL.rotateAngleY = 0.0F;
      this.ArmR.rotateAngleY = 0.0F;
      this.ArmL.rotateAngleY = 0.0F;
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
   }
}
