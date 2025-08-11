package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightning extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;

   public ModelLightning() {
      this.field_78090_t = 256;
      this.field_78089_u = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(64, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 42);
      this.Shape2.func_78789_a(-15.0F, -15.0F, -15.0F, 30, 30, 30);
      this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape2.func_78787_b(64, 32);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par31 = 1.0F;
      this.Shape1.rotationPointY = 3.0F;
      this.Shape1.rotateAngleY = f2 * 2.0F;
      this.Shape2.rotationPointY = 3.0F;
      this.Shape2.rotateAngleY = -f2 * 2.0F;
      this.Shape2.rotateAngleX = -f2 / 3.0F;
      this.Shape2.rotateAngleZ = -f2 / 3.0F;
      this.Shape1.rotateAngleX = -f2 / 3.0F;
      this.Shape1.rotateAngleZ = -f2 / 3.0F;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.render(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
