package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFr6 extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer body2;
   ModelRenderer body3;
   ModelRenderer tail1;
   ModelRenderer tail2;

   public ModelFr6() {
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.head.func_78787_b(128, 64);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 64, 0);
      this.body.func_78789_a(-5.0F, 0.0F, -2.0F, 10, 5, 5);
      this.body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.body.func_78787_b(128, 64);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.func_78789_a(-5.0F, -2.0F, -2.0F, 5, 12, 5);
      this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.rightarm.func_78787_b(128, 64);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.field_78809_i = true;
      this.leftarm.func_78789_a(0.0F, -2.0F, -2.0F, 5, 12, 5);
      this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
      this.leftarm.func_78787_b(128, 64);
      this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.rightleg.func_78787_b(128, 64);
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.field_78809_i = true;
      this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
      this.leftleg.func_78787_b(128, 64);
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.body2 = new ModelRenderer(this, 64, 12);
      this.body2.func_78789_a(-4.5F, 1.0F, -1.933333F, 9, 4, 1);
      this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.body2.func_78787_b(128, 64);
      this.setRotation(this.body2, -0.1745329F, 0.0F, 0.0F);
      this.body3 = new ModelRenderer(this, 16, 16);
      this.body3.func_78789_a(-3.5F, 5.0F, -2.0F, 7, 7, 4);
      this.body3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.body3.func_78787_b(128, 64);
      this.setRotation(this.body3, 0.0F, 0.0F, 0.0F);
      this.tail1 = new ModelRenderer(this, 32, 48);
      this.tail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12);
      this.tail1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.tail1.func_78787_b(128, 64);
      this.setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
      this.tail2 = new ModelRenderer(this, 32, 48);
      this.tail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12);
      this.tail2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.tail2.func_78787_b(128, 64);
      this.setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
      this.body.func_78792_a(this.body2);
      this.body.func_78792_a(this.body3);
      this.body.func_78792_a(this.tail1);
      this.body.func_78792_a(this.tail2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.head.func_78785_a(f5);
      this.body.func_78785_a(f5);
      this.rightarm.func_78785_a(f5);
      this.leftarm.func_78785_a(f5);
      this.rightleg.func_78785_a(f5);
      this.leftleg.func_78785_a(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      this.head.field_78796_g = par4 / 57.295776F;
      this.head.field_78795_f = par5 / 57.295776F;
      this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
      this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.rightarm.field_78808_h = 0.0F;
      this.leftarm.field_78808_h = 0.0F;
      this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
      this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
      this.rightleg.field_78796_g = 0.0F;
      this.leftleg.field_78796_g = 0.0F;
      ModelRenderer var10000;
      if (this.field_78093_q) {
         var10000 = this.rightarm;
         var10000.field_78795_f += -0.62831855F;
         var10000 = this.leftarm;
         var10000.field_78795_f += -0.62831855F;
         this.rightleg.field_78795_f = -1.2566371F;
         this.leftleg.field_78795_f = -1.2566371F;
         this.rightleg.field_78796_g = 0.31415927F;
         this.leftleg.field_78796_g = -0.31415927F;
      }

      this.rightarm.field_78796_g = 0.0F;
      this.leftarm.field_78796_g = 0.0F;
      if (this.field_78095_p > -9990.0F) {
         float var8 = this.field_78095_p;
         this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
         this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
         this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
         this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
         var10000 = this.rightarm;
         var10000.field_78796_g += this.body.field_78796_g;
         var10000 = this.leftarm;
         var10000.field_78796_g += this.body.field_78796_g;
         var10000 = this.leftarm;
         var10000.field_78795_f += this.body.field_78796_g;
         var8 = 1.0F - this.field_78095_p;
         var8 *= var8;
         var8 *= var8;
         var8 = 1.0F - var8;
         float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
         float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
         this.rightarm.field_78795_f = (float)((double)this.rightarm.field_78795_f - ((double)var9 * 1.2D + (double)var10));
         var10000 = this.rightarm;
         var10000.field_78796_g += this.body.field_78796_g * 2.0F;
         this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
      }

      var10000 = this.rightarm;
      var10000.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.leftarm;
      var10000.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.rightarm;
      var10000.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
      var10000 = this.leftarm;
      var10000.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
   }
}
