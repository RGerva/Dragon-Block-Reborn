package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelYakon extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer body2;
   ModelRenderer leftarm;
   ModelRenderer leftarm1;
   ModelRenderer leftarm2;
   ModelRenderer leftarm3;
   ModelRenderer rightarm;
   ModelRenderer rightarm1;
   ModelRenderer rightarm2;
   ModelRenderer rightarm3;
   ModelRenderer leftleg;
   ModelRenderer leftleg1;
   ModelRenderer leftleg2;
   ModelRenderer leftleg3;
   ModelRenderer rightleg;
   ModelRenderer rightleg1;
   ModelRenderer rightleg2;
   ModelRenderer rightleg3;
   ModelRenderer back1;
   ModelRenderer back2;
   ModelRenderer back3;
   ModelRenderer back4;
   ModelRenderer tail;
   private float F;

   public ModelYakon(float f) {
      this();
      this.F = f;
   }

   public ModelYakon() {
      this.F = 1.0F;
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.func_78789_a(-4.0F, -4.0F, -5.0F, 8, 8, 5);
      this.head.func_78793_a(0.0F, -6.0F, -4.0F);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 0, 29);
      this.body.func_78789_a(-4.0F, 8.0F, -2.0F, 8, 8, 4);
      this.body.func_78793_a(0.0F, -8.0F, 0.0F);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.body2 = new ModelRenderer(this, 0, 13);
      this.body2.func_78789_a(-6.0F, 0.0F, -4.0F, 12, 8, 8);
      this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.body2, 0.0F, 0.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 40, 0);
      this.leftarm.func_78789_a(0.0F, -3.0F, -3.0F, 6, 6, 6);
      this.leftarm.func_78793_a(6.0F, -5.0F, 0.0F);
      this.leftarm.field_78809_i = true;
      this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
      this.leftarm1 = new ModelRenderer(this, 40, 12);
      this.leftarm1.func_78789_a(0.0F, 3.0F, -2.0F, 4, 7, 4);
      this.leftarm1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftarm1.field_78809_i = true;
      this.setRotation(this.leftarm1, 0.0F, 0.0F, 0.0F);
      this.leftarm2 = new ModelRenderer(this, 64, 0);
      this.leftarm2.func_78789_a(0.0F, 6.0F, -12.0F, 4, 4, 10);
      this.leftarm2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftarm2.field_78809_i = true;
      this.setRotation(this.leftarm2, 0.0F, 0.0F, 0.0F);
      this.leftarm3 = new ModelRenderer(this, 56, 14);
      this.leftarm3.func_78789_a(1.0F, 7.0F, -13.0F, 2, 2, 8);
      this.leftarm3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftarm3.field_78809_i = true;
      this.setRotation(this.leftarm3, -0.1745329F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 0);
      this.rightarm.func_78789_a(-6.0F, -3.0F, -3.0F, 6, 6, 6);
      this.rightarm.func_78793_a(-6.0F, -5.0F, 0.0F);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
      this.rightarm1 = new ModelRenderer(this, 40, 12);
      this.rightarm1.func_78789_a(-4.0F, 3.0F, -2.0F, 4, 7, 4);
      this.rightarm1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm1, 0.0F, 0.0F, 0.0F);
      this.rightarm2 = new ModelRenderer(this, 64, 0);
      this.rightarm2.func_78789_a(-4.0F, 6.0F, -12.0F, 4, 4, 10);
      this.rightarm2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm2, 0.0F, 0.0F, 0.0F);
      this.rightarm3 = new ModelRenderer(this, 56, 14);
      this.rightarm3.func_78789_a(-3.0F, 7.0F, -13.0F, 2, 2, 8);
      this.rightarm3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm3, -0.1745329F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 41);
      this.leftleg.func_78789_a(0.0F, -2.0F, -10.0F, 4, 4, 12);
      this.leftleg.func_78793_a(4.0F, 8.0F, 0.0F);
      this.leftleg.field_78809_i = true;
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.leftleg1 = new ModelRenderer(this, 22, 47);
      this.leftleg1.func_78789_a(0.0F, 4.0F, -9.0F, 4, 4, 10);
      this.leftleg1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftleg1.field_78809_i = true;
      this.setRotation(this.leftleg1, -0.3490659F, 0.0F, 0.0174533F);
      this.leftleg2 = new ModelRenderer(this, 40, 42);
      this.leftleg2.func_78789_a(0.0F, 4.0F, 1.0F, 4, 11, 4);
      this.leftleg2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftleg2.field_78809_i = true;
      this.setRotation(this.leftleg2, -0.3665191F, 0.0F, 0.0174533F);
      this.leftleg3 = new ModelRenderer(this, 20, 39);
      this.leftleg3.func_78789_a(0.0F, 14.0F, -8.0F, 4, 2, 6);
      this.leftleg3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftleg3.field_78809_i = true;
      this.setRotation(this.leftleg3, 0.0F, 0.0F, 0.0174533F);
      this.rightleg = new ModelRenderer(this, 0, 41);
      this.rightleg.func_78789_a(-4.0F, -2.0F, -10.0F, 4, 4, 12);
      this.rightleg.func_78793_a(-4.0F, 8.0F, 0.0F);
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.rightleg1 = new ModelRenderer(this, 22, 47);
      this.rightleg1.func_78789_a(-4.0F, 4.0F, -9.0F, 4, 4, 10);
      this.rightleg1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg1, -0.3490659F, 0.0F, 0.0174533F);
      this.rightleg2 = new ModelRenderer(this, 40, 42);
      this.rightleg2.func_78789_a(-4.0F, 4.0F, 1.0F, 4, 11, 4);
      this.rightleg2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg2, -0.3665191F, 0.0F, 0.0174533F);
      this.rightleg3 = new ModelRenderer(this, 20, 39);
      this.rightleg3.func_78789_a(-4.0F, 14.0F, -8.0F, 4, 2, 6);
      this.rightleg3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg3, 0.0F, 0.0F, 0.0174533F);
      this.back1 = new ModelRenderer(this, 40, 32);
      this.back1.func_78789_a(1.0F, 1.0F, 1.0F, 4, 4, 6);
      this.back1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back1, 0.5235988F, 0.2617994F, 0.0F);
      this.back2 = new ModelRenderer(this, 40, 32);
      this.back2.func_78789_a(-5.0F, 1.0F, 1.0F, 4, 4, 6);
      this.back2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back2, 0.5235988F, -0.2617994F, 0.0F);
      this.back3 = new ModelRenderer(this, 40, 23);
      this.back3.func_78789_a(1.0F, 5.0F, 1.0F, 3, 3, 6);
      this.back3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back3, 0.2617994F, 0.2617994F, 0.0F);
      this.back4 = new ModelRenderer(this, 40, 23);
      this.back4.func_78789_a(-4.0F, 5.0F, 2.0F, 3, 3, 6);
      this.back4.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back4, 0.2617994F, -0.2617994F, 0.0F);
      this.tail = new ModelRenderer(this, 56, 38);
      this.tail.func_78789_a(-2.0F, 8.0F, -3.0F, 4, 12, 4);
      this.tail.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.tail, 0.3316126F, 0.0F, 0.0F);
      this.leftarm.func_78792_a(this.leftarm1);
      this.leftarm.func_78792_a(this.leftarm2);
      this.leftarm.func_78792_a(this.leftarm3);
      this.rightarm.func_78792_a(this.rightarm1);
      this.rightarm.func_78792_a(this.rightarm2);
      this.rightarm.func_78792_a(this.rightarm3);
      this.leftleg.func_78792_a(this.leftleg1);
      this.leftleg.func_78792_a(this.leftleg2);
      this.leftleg.func_78792_a(this.leftleg3);
      this.rightleg.func_78792_a(this.rightleg1);
      this.rightleg.func_78792_a(this.rightleg2);
      this.rightleg.func_78792_a(this.rightleg3);
      this.body.func_78792_a(this.body2);
      this.body.func_78792_a(this.back1);
      this.body.func_78792_a(this.back2);
      this.body.func_78792_a(this.back3);
      this.body.func_78792_a(this.back4);
      this.body.func_78792_a(this.tail);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      GL11.glPushMatrix();
      GL11.glScalef(this.F, this.F, this.F);
      GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
      this.head.render(f5);
      this.body.render(f5);
      this.rightarm.render(f5);
      this.leftarm.render(f5);
      this.rightleg.render(f5);
      this.leftleg.render(f5);
      GL11.glPopMatrix();
   }

   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      this.head.rotateAngleY = par4 / 57.295776F;
      this.head.rotateAngleX = par5 / 57.295776F;
      this.rightarm.rotateAngleX = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
      this.leftarm.rotateAngleX = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.rightarm.rotateAngleZ = 0.0F;
      this.leftarm.rotateAngleZ = 0.0F;
      this.rightleg.rotateAngleX = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
      this.leftleg.rotateAngleX = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;
      ModelRenderer var10000;
      if (this.field_78093_q) {
         var10000 = this.rightarm;
         var10000.rotateAngleX += -0.62831855F;
         var10000 = this.leftarm;
         var10000.rotateAngleX += -0.62831855F;
         this.rightleg.rotateAngleX = -1.2566371F;
         this.leftleg.rotateAngleX = -1.2566371F;
         this.rightleg.rotateAngleY = 0.31415927F;
         this.leftleg.rotateAngleY = -0.31415927F;
      }

      this.rightarm.rotateAngleY = 0.0F;
      this.leftarm.rotateAngleY = 0.0F;
      if (this.field_78095_p > -9990.0F) {
         float var8 = this.field_78095_p;
         this.body.rotateAngleY = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.rotateAngleY) * 5.0F;
         this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.rotateAngleY) * 5.0F;
         this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.rotateAngleY) * 5.0F;
         this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.rotateAngleY) * 5.0F;
         var10000 = this.rightarm;
         var10000.rotateAngleY += this.body.rotateAngleY;
         var10000 = this.leftarm;
         var10000.rotateAngleY += this.body.rotateAngleY;
         var10000 = this.leftarm;
         var10000.rotateAngleX += this.body.rotateAngleY;
         var8 = 1.0F - this.field_78095_p;
         var8 *= var8;
         var8 *= var8;
         var8 = 1.0F - var8;
         float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
         float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
         this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
         var10000 = this.rightarm;
         var10000.rotateAngleY += this.body.rotateAngleY * 2.0F;
         this.rightarm.rotateAngleZ = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
      }

      var10000 = this.rightarm;
      var10000.rotateAngleZ += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.leftarm;
      var10000.rotateAngleZ -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.rightarm;
      var10000.rotateAngleX += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
      var10000 = this.leftarm;
      var10000.rotateAngleX -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
   }
}
