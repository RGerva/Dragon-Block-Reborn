package JinRyuu.JRMCore.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAura extends ModelBiped {
   ModelRenderer auro;
   public float inc = 1.6F;
   public float inc2 = 0.0F;
   public float[] offY = new float[]{-12.0F, -17.0F, -22.0F, -27.0F, -33.0F, -38.0F, -41.0F, -44.0F};
   public float[] offZ = new float[]{-8.0F, -5.5F, -3.0F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F};

   public ModelAura() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.auro = new ModelRenderer(this, 0, 0);
      this.auro.func_78789_a(-10.0F, -17.0F, -8.0F, 20, 20, 0);
      this.auro.func_78793_a(0.0F, 20.0F, 0.0F);
      this.setRotation(this.auro, 0.0F, 0.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.auro.func_78785_a(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par3 = f2;
      if (f2 > f) {
         par3 = f2 - f;
      }

      float maxageperc = 100.0F / f;
      float curperc = par3 * maxageperc;
      par3 = curperc * 0.01F * 20.0F;
      this.auro.field_78797_d = 55.0F + par3;
      this.auro.field_82908_p = -par3 * 0.2F;
      this.auro.field_82907_q = par3 < 8.0F ? 0.4F - par3 * 0.1F : -0.3F + (par3 - 7.0F) * 0.053F;
      float ff = par3 * this.inc / 3.2F;
      this.auro.field_78795_f = 0.8726646F - curperc * 0.01F - f1;
   }

   public void renderModel(Entity entity, float f, float r, float w, float s) {
      this.func_78088_a(entity, s, w, r, 0.0F, 0.0F, f);
   }

   public int func_78104_a() {
      return 8;
   }
}
