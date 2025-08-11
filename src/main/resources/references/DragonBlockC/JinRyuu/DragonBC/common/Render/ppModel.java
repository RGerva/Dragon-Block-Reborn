package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ppModel extends ModelBase {
   ModelRenderer sw;

   public ppModel() {
      this.field_78090_t = 128;
      this.field_78089_u = 32;
      this.sw = new ModelRenderer(this, 0, 0);
      this.sw.func_78789_a(-0.5F, -16.0F, -0.5F, 1, 16, 1);
      this.sw.func_78793_a(0.0F, 0.0F, 0.0F);
      this.sw.func_78787_b(64, 32);
      this.setRotation(this.sw, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.sw.render(f5);
   }

   public void renderModel(float f5) {
      this.sw.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, (Entity)null);
   }
}
