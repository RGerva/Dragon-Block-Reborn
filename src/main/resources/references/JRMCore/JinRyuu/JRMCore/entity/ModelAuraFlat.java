package JinRyuu.JRMCore.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAuraFlat extends ModelBase {
   public ModelRenderer box;

   public ModelAuraFlat() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.box = new ModelRenderer(this, 0, 0);
      this.box.func_78793_a(0.0F, 0.0F, 0.0F);
      this.box.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 0, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.box.render(f5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.rotateAngleZ = z;
   }
}
