package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class MedPodDoor1Model extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;

   public MedPodDoor1Model() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 8, 16, 4);
      this.Shape1.func_78793_a(-8.0F, 0.0F, 0.0F);
      this.Shape1.func_78787_b(64, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 24, 0);
      this.Shape2.func_78789_a(0.0F, 0.0F, 0.0F, 8, 16, 4);
      this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Shape2.func_78787_b(64, 32);
      this.Shape2.field_78809_i = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.render2(entity, f, f1, f2, f3, f4, f5);
   }

   private void render2(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      int meta = (int)f4;
      int moving = (int)f3;
      if (meta != 3 && meta != 7) {
         if (meta != 1 && meta != 5) {
            if (meta != 0 && meta != 4) {
               if (meta == 2 || meta == 6) {
                  GL11.glPushMatrix();
                  GL11.glTranslatef(0.0F - (float)moving * 0.02F, 0.0F, 0.0F);
                  this.Shape1.func_78785_a(f5);
                  GL11.glPopMatrix();
                  GL11.glPushMatrix();
                  GL11.glTranslatef(0.0F + (float)moving * 0.02F, 0.0F, 0.0F);
                  this.Shape2.func_78785_a(f5);
                  GL11.glPopMatrix();
               }
            } else {
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F - (float)moving * 0.02F, 0.0F, 0.0F);
               this.Shape1.func_78785_a(f5);
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F + (float)moving * 0.02F, 0.0F, 0.0F);
               this.Shape2.func_78785_a(f5);
               GL11.glPopMatrix();
            }
         } else {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F - (float)moving * 0.02F, 0.0F, 0.0F);
            this.Shape1.func_78785_a(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F + (float)moving * 0.02F, 0.0F, 0.0F);
            this.Shape2.func_78785_a(f5);
            GL11.glPopMatrix();
         }
      } else {
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F - (float)moving * 0.02F, 0.0F, 0.0F);
         this.Shape1.func_78785_a(f5);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F + (float)moving * 0.02F, 0.0F, 0.0F);
         this.Shape2.func_78785_a(f5);
         GL11.glPopMatrix();
      }

   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
   }

   public void renderModel(int v, int m, float f) {
      this.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, (float)v, (float)m, f);
   }
}
