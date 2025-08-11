package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class hair extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape5;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public hair() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 16, 16, 16);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(128, 128);
      this.Shape1.field_78809_i = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 32);
      this.Shape5.func_78789_a(0.0F, 0.0F, 0.0F, 7, 7, 10);
      this.Shape5.func_78793_a(6.0F, 0.0F, 9.0F);
      this.Shape5.func_78787_b(128, 128);
      this.Shape5.field_78809_i = true;
      this.setRotation(this.Shape5, 1.27409F, 0.3141593F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 64, 0);
      this.Shape3.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 10);
      this.Shape3.func_78793_a(8.0F, 4.0F, -6.0F);
      this.Shape3.func_78787_b(128, 128);
      this.Shape3.field_78809_i = true;
      this.setRotation(this.Shape3, -0.2268928F, -0.2617994F, 0.0F);
      this.Shape3.field_78809_i = false;
      this.Shape4 = new ModelRenderer(this, 64, 0);
      this.Shape4.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 10);
      this.Shape4.func_78793_a(7.0F, 10.0F, -7.0F);
      this.Shape4.func_78787_b(128, 128);
      this.Shape4.field_78809_i = true;
      this.setRotation(this.Shape4, -0.1047198F, -0.1396263F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 32);
      this.Shape6.func_78789_a(0.0F, 0.0F, 0.0F, 7, 7, 10);
      this.Shape6.func_78793_a(6.0F, 2.0F, 12.0F);
      this.Shape6.func_78787_b(128, 128);
      this.Shape6.field_78809_i = true;
      this.setRotation(this.Shape6, 0.5410521F, 0.296706F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 0, 49);
      this.Shape7.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 8);
      this.Shape7.func_78793_a(6.0F, 8.0F, 15.0F);
      this.Shape7.func_78787_b(128, 128);
      this.Shape7.field_78809_i = true;
      this.setRotation(this.Shape7, 0.0698132F, 0.296706F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 0, 62);
      this.Shape8.func_78789_a(0.0F, 0.0F, 0.0F, 4, 4, 8);
      this.Shape8.func_78793_a(8.0F, -8.0F, 12.0F);
      this.Shape8.func_78787_b(128, 128);
      this.Shape8.field_78809_i = true;
      this.setRotation(this.Shape8, 0.8028515F, 0.296706F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 0, 62);
      this.Shape9.func_78789_a(0.0F, 0.0F, 0.0F, 4, 4, 8);
      this.Shape9.func_78793_a(10.0F, -2.0F, 19.0F);
      this.Shape9.func_78787_b(128, 128);
      this.Shape9.field_78809_i = true;
      this.setRotation(this.Shape9, 0.2094395F, 0.296706F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.Shape1.render(f5);
      this.Shape5.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape6.render(f5);
      this.Shape7.render(f5);
      this.Shape8.render(f5);
      this.Shape9.render(f5);
   }

   public void renderModel(float f1) {
      this.Shape1.render(f1);
      this.Shape3.render(f1);
      this.Shape4.render(f1);
      this.Shape5.render(f1);
      this.Shape6.render(f1);
      this.Shape7.render(f1);
      this.Shape8.render(f1);
      this.Shape9.render(f1);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }
}
