package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelRoshi extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer turtleshell;
   ModelRenderer staff;
   ModelRenderer staff2;
   private float F;

   public ModelRoshi(float f) {
      this();
      this.F = f;
   }

   public ModelRoshi() {
      this.F = 1.0F;
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.func_78789_a(-4.0F, -12.0F, -4.0F, 8, 8, 8);
      this.head.func_78793_a(0.0F, 8.0F, 0.0F);
      this.head.func_78787_b(64, 64);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 0, 16);
      this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 10, 4);
      this.body.func_78793_a(0.0F, 4.0F, 0.0F);
      this.body.func_78787_b(64, 64);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 16, 30);
      this.rightarm.func_78789_a(-3.0F, -3.0F, -8.0F, 4, 4, 10);
      this.rightarm.func_78793_a(-5.0F, 7.0F, 0.0F);
      this.rightarm.func_78787_b(64, 64);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 24, 16);
      this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 10, 4);
      this.leftarm.func_78793_a(5.0F, 6.0F, 0.0F);
      this.leftarm.func_78787_b(64, 64);
      this.leftarm.field_78809_i = true;
      this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
      this.rightleg = new ModelRenderer(this, 0, 30);
      this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 10, 4);
      this.rightleg.func_78793_a(-2.0F, 14.0F, 0.0F);
      this.rightleg.func_78787_b(64, 64);
      this.rightleg.field_78809_i = true;
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 30);
      this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 10, 4);
      this.leftleg.func_78793_a(2.0F, 14.0F, 0.0F);
      this.leftleg.func_78787_b(64, 64);
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.turtleshell = new ModelRenderer(this, 36, 48);
      this.turtleshell.func_78789_a(-5.0F, -1.0F, 2.0F, 10, 12, 4);
      this.turtleshell.func_78793_a(0.0F, 0.0F, 0.0F);
      this.turtleshell.func_78787_b(64, 64);
      this.setRotation(this.turtleshell, 0.0F, 0.0F, 0.0F);
      this.staff = new ModelRenderer(this, 60, 0);
      this.staff.func_78789_a(-1.0F, -4.0F, -7.0F, 1, 22, 1);
      this.staff.func_78793_a(0.0F, 0.0F, 0.0F);
      this.staff.func_78787_b(64, 32);
      this.setRotation(this.staff, 0.0F, 0.0F, 0.0F);
      this.staff2 = new ModelRenderer(this, 48, 0);
      this.staff2.func_78789_a(0.0F, -5.0F, -9.0F, 1, 1, 5);
      this.staff2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.staff2.func_78787_b(64, 32);
      this.setRotation(this.staff2, 0.0F, 0.1745329F, 0.0174533F);
      this.rightarm.func_78792_a(this.staff);
      this.rightarm.func_78792_a(this.staff2);
      this.body.func_78792_a(this.turtleshell);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      GL11.glScalef(this.F, this.F, this.F);
      GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
      this.head.func_78785_a(f5);
      this.body.func_78785_a(f5);
      this.rightarm.func_78785_a(f5);
      this.leftarm.func_78785_a(f5);
      this.rightleg.func_78785_a(f5);
      this.leftleg.func_78785_a(f5);
      GL11.glPopMatrix();
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
