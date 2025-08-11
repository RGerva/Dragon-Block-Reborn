package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiWave extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;

   public ModelKiWave() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.func_78789_a(-3.0F, -3.0F, -5.0F, 6, 6, 10);
      this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape2.func_78787_b(128, 128);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.func_78789_a(-3.0F, -5.0F, -3.0F, 6, 10, 6);
      this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape3.func_78787_b(128, 128);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.func_78789_a(-5.0F, -3.0F, -3.0F, 10, 6, 6);
      this.Shape4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape4.func_78787_b(128, 128);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape1.func_78792_a(this.Shape2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par31 = 1.0F;
      this.Shape1.rotateAngleZ = f2;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.render(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
