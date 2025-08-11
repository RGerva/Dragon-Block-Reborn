package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiMakanko extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public ModelKiMakanko() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.Shape1 = new ModelRenderer(this, 0, 8);
      this.Shape1.func_78789_a(-3.0F, -3.0F, -7.0F, 6, 6, 14);
      this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 8);
      this.Shape2.func_78789_a(-2.0F, -2.0F, -8.0F, 4, 4, 16);
      this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape2.func_78787_b(128, 128);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 8);
      this.Shape3.func_78789_a(-2.0F, -4.0F, -6.0F, 4, 8, 12);
      this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape3.func_78787_b(128, 128);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 8);
      this.Shape4.func_78789_a(-4.0F, -2.0F, -6.0F, 8, 4, 12);
      this.Shape4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape4.func_78787_b(128, 128);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 0);
      this.Shape5.func_78789_a(6.0F, -3.0F, -5.0F, 1, 6, 1);
      this.Shape5.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape5.func_78787_b(128, 128);
      this.setRotation(this.Shape5, -0.3490659F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.func_78789_a(7.0F, -3.0F, -3.0F, 1, 6, 1);
      this.Shape6.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape6.func_78787_b(128, 128);
      this.setRotation(this.Shape6, -0.3490659F, 0.0F, -0.7853982F);
      this.Shape7 = new ModelRenderer(this, 0, 0);
      this.Shape7.func_78789_a(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
      this.Shape7.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape7.func_78787_b(128, 128);
      this.setRotation(this.Shape7, 0.0F, 0.4537856F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 0, 0);
      this.Shape8.func_78789_a(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
      this.Shape8.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape8.func_78787_b(128, 128);
      this.setRotation(this.Shape8, 0.0F, 0.4014257F, -0.7853982F);
      this.Shape9 = new ModelRenderer(this, 0, 0);
      this.Shape9.func_78789_a(-7.0F, -3.0F, 3.0F, 1, 6, 1);
      this.Shape9.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape9.func_78787_b(128, 128);
      this.setRotation(this.Shape9, 0.3490659F, 0.0F, 0.0F);
      this.Shape1.func_78792_a(this.Shape2);
      this.Shape1.func_78792_a(this.Shape3);
      this.Shape1.func_78792_a(this.Shape4);
      this.Shape7.func_78792_a(this.Shape5);
      this.Shape7.func_78792_a(this.Shape6);
      this.Shape7.func_78792_a(this.Shape8);
      this.Shape7.func_78792_a(this.Shape9);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape7.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par31 = 1.0F;
      this.Shape1.rotateAngleZ = f2;
      this.Shape7.rotateAngleZ = -f2;
   }

   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
      this.render(entity, 0.0F, 0.0F, r, par8, par9, f);
   }
}
