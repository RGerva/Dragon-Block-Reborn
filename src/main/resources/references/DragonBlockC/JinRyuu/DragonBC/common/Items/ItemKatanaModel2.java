package JinRyuu.DragonBC.common.Items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ItemKatanaModel2 extends ModelBase {
   public ModelRenderer Hilt;
   public ModelRenderer PommelDeco1;
   public ModelRenderer Guard1;
   public ModelRenderer Edge1;
   public ModelRenderer PommelDeco2;
   public ModelRenderer GuardSide1;
   public ModelRenderer GuardSide2;
   public ModelRenderer Edge2;
   public ModelRenderer Edge3;
   public ModelRenderer Edge4;
   public ModelRenderer Edge5;

   public ItemKatanaModel2() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      this.PommelDeco1 = new ModelRenderer(this, 0, 15);
      this.PommelDeco1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.PommelDeco1.func_78790_a(-1.5F, 4.9F, -1.5F, 3, 1, 3, 0.0F);
      this.GuardSide2 = new ModelRenderer(this, 37, 3);
      this.GuardSide2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.GuardSide2.func_78790_a(4.6F, -3.8F, -1.0F, 3, 1, 2, 0.0F);
      this.setRotateAngle(this.GuardSide2, 0.0F, 0.0F, -0.31869712F);
      this.PommelDeco2 = new ModelRenderer(this, 0, 20);
      this.PommelDeco2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.PommelDeco2.func_78790_a(-0.5F, 5.8F, -0.5F, 1, 1, 1, 0.0F);
      this.Edge4 = new ModelRenderer(this, 36, 19);
      this.Edge4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Edge4.func_78790_a(-1.5F, -27.7F, -0.5F, 3, 8, 1, 0.0F);
      this.Guard1 = new ModelRenderer(this, 18, 0);
      this.Guard1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Guard1.func_78790_a(-3.5F, -5.1F, -1.5F, 7, 1, 3, 0.0F);
      this.Edge3 = new ModelRenderer(this, 25, 17);
      this.Edge3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Edge3.func_78790_a(-2.0F, -19.7F, -0.5F, 4, 11, 1, 0.0F);
      this.Hilt = new ModelRenderer(this, 0, 0);
      this.Hilt.func_78793_a(0.0F, 13.0F, 0.0F);
      this.Hilt.func_78790_a(-1.0F, -5.7F, -1.0F, 2, 12, 2, 0.0F);
      this.Edge5 = new ModelRenderer(this, 45, 18);
      this.Edge5.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Edge5.func_78790_a(-1.0F, -37.7F, -0.5F, 2, 10, 1, 0.0F);
      this.Edge1 = new ModelRenderer(this, 8, 24);
      this.Edge1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Edge1.func_78790_a(-1.0F, -7.7F, -0.5F, 2, 2, 1, 0.0F);
      this.Edge2 = new ModelRenderer(this, 16, 25);
      this.Edge2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Edge2.func_78790_a(-1.5F, -8.7F, -0.5F, 3, 1, 1, 0.0F);
      this.GuardSide1 = new ModelRenderer(this, 9, 3);
      this.GuardSide1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.GuardSide1.func_78790_a(-7.6F, -3.8F, -1.0F, 3, 1, 2, 0.0F);
      this.setRotateAngle(this.GuardSide1, 0.0F, 0.0F, 0.31869712F);
      this.Hilt.func_78792_a(this.PommelDeco1);
      this.Guard1.func_78792_a(this.GuardSide2);
      this.PommelDeco1.func_78792_a(this.PommelDeco2);
      this.Edge3.func_78792_a(this.Edge4);
      this.Hilt.func_78792_a(this.Guard1);
      this.Edge2.func_78792_a(this.Edge3);
      this.Edge4.func_78792_a(this.Edge5);
      this.Hilt.func_78792_a(this.Edge1);
      this.Edge1.func_78792_a(this.Edge2);
      this.Guard1.func_78792_a(this.GuardSide1);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.Hilt.func_78785_a(f5);
   }

   public void render() {
      float par1 = 0.0625F;
      this.Hilt.func_78785_a(par1);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }
}
