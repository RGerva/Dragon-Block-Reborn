package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAura extends ModelBiped {
   ModelRenderer auro;
   public float inc = 1.6F;
   public float inc2 = 0.0F;
   public float[] offY = new float[]{-12.0F, -17.0F, -22.0F, -27.0F, -33.0F, -38.0F, -41.0F, -44.0F};
   public float[] offZ = new float[]{-8.0F, -5.5F, -3.0F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F};

   public ModelAura() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.auro = new ModelRenderer(this, 0, 0);
      this.auro.addBox(-10.0F, -17.0F, -8.0F, 20, 20, 0);
      this.auro.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.setRotation(this.auro, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.auro.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
      float par3 = f2;
      if (f2 > f) {
         par3 = f2 - f;
      }

      float maxageperc = 100.0F / f;
      float curperc = par3 * maxageperc;
      par3 = curperc * 0.01F * 20.0F;
      this.auro.rotationPointY = 55.0F + par3;
      this.auro.offsetY = -par3 * 0.2F;
      this.auro.offsetZ = par3 < 8.0F ? 0.4F - par3 * 0.1F : -0.3F + (par3 - 7.0F) * 0.053F;
      float ff = par3 * this.inc / 3.2F;
      this.auro.rotateAngleX = 0.8726646F - curperc * 0.01F - f1;
   }

   public void renderModel(Entity entity, float f, float r, float w, float s) {
      this.render(entity, s, w, r, 0.0F, 0.0F, f);
   }

   public int func_78104_a() {
      return 8;
   }
}
