package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiLeser extends ModelBiped {
   ModelRenderer Shape1;

   public ModelKiLeser() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(-1.0F, -1.0F, -10.0F, 2, 2, 20);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.func_78785_a(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par31 = 1.0F;
      this.Shape1.field_78798_e = f2;
      this.Shape1.field_78808_h = f2;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
