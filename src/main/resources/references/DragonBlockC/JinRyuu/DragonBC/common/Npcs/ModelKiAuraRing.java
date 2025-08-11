package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiAuraRing extends ModelBiped {
   ModelRenderer low;
   ModelRenderer lowm1;
   ModelRenderer lowm2;
   ModelRenderer lowm3;
   ModelRenderer lowm4;
   ModelRenderer lowm5;
   ModelRenderer lowm6;
   ModelRenderer lowm7;
   ModelRenderer lowm8;

   public ModelKiAuraRing() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.low = new ModelRenderer(this, 32, 0);
      this.low.func_78789_a(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.low.func_78793_a(0.0F, 20.0F, 0.0F);
      this.setRotation(this.low, 0.0F, 0.0F, 0.0F);
      this.lowm1 = new ModelRenderer(this, 0, 0);
      this.lowm1.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm1.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm1.func_78787_b(64, 32);
      this.setRotation(this.lowm1, 0.8726646F, 1.570796F, 0.0F);
      this.lowm2 = new ModelRenderer(this, 0, 0);
      this.lowm2.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm2.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm2.func_78787_b(64, 32);
      this.setRotation(this.lowm2, 0.8726646F, 0.0F, 0.0F);
      this.lowm3 = new ModelRenderer(this, 0, 0);
      this.lowm3.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm3.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm3.func_78787_b(64, 32);
      this.setRotation(this.lowm3, 0.8726646F, -0.7853982F, 0.0F);
      this.lowm4 = new ModelRenderer(this, 0, 0);
      this.lowm4.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm4.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm4.func_78787_b(64, 32);
      this.setRotation(this.lowm4, 0.8726646F, 3.141593F, 0.0F);
      this.lowm5 = new ModelRenderer(this, 0, 0);
      this.lowm5.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm5.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm5.func_78787_b(64, 32);
      this.setRotation(this.lowm5, 0.8726646F, -1.570796F, 0.0F);
      this.lowm6 = new ModelRenderer(this, 0, 0);
      this.lowm6.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm6.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm6.func_78787_b(64, 32);
      this.setRotation(this.lowm6, 0.8726646F, -2.373648F, 0.0F);
      this.lowm7 = new ModelRenderer(this, 0, 0);
      this.lowm7.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm7.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm7.func_78787_b(64, 32);
      this.setRotation(this.lowm7, 0.8726646F, 2.373648F, 0.0F);
      this.lowm8 = new ModelRenderer(this, 0, 0);
      this.lowm8.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm8.func_78793_a(0.0F, 20.0F, 0.0F);
      this.lowm8.func_78787_b(64, 32);
      this.setRotation(this.lowm8, 0.8726646F, 0.7853982F, 0.0F);
      this.low.func_78792_a(this.lowm1);
      this.low.func_78792_a(this.lowm2);
      this.low.func_78792_a(this.lowm3);
      this.low.func_78792_a(this.lowm4);
      this.low.func_78792_a(this.lowm5);
      this.low.func_78792_a(this.lowm6);
      this.low.func_78792_a(this.lowm7);
      this.low.func_78792_a(this.lowm8);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.low.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par31 = 1.0F;
      this.low.rotationPointY = 28.0F;
      this.low.rotateAngleY = -f2 / 5.0F;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.render(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
