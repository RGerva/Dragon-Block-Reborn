package JinRyuu.JRMCore.m;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class mBoard extends ModelBase {
   public ModelRenderer shape1;

   public mBoard() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      byte size = true;
      this.shape1 = new ModelRenderer(this, 0, -30);
      this.shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.shape1.func_78790_a(0.0F, -5.0F, -30.0F, 0, 10, 30, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.shape1.render(f5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.rotateAngleZ = z;
   }

   public void render(ModelRenderer a, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      a.render(f5);
   }

   public void renderModel(byte type, Entity entity, float par8, float par9, float f, float r, boolean b) {
      this.render(this.shape1, entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
