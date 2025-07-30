package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiDisk extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;

   public ModelKiDisk() {
      this.field_78090_t = 128;
      this.field_78089_u = 32;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(-10.0F, -1.0F, -10.0F, 20, 2, 20);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(128, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.func_78789_a(-7.0F, -0.5F, -12.0F, 14, 1, 24);
      this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape2.func_78787_b(128, 32);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.func_78789_a(-12.0F, -0.5F, -7.0F, 24, 1, 14);
      this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape3.func_78787_b(128, 32);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape1.func_78792_a(this.Shape2);
      this.Shape1.func_78792_a(this.Shape3);
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
      this.Shape1.field_78796_g = 2.0F + f2;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
