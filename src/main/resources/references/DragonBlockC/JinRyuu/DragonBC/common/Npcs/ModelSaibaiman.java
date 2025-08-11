package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelSaibaiman extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;

   public ModelSaibaiman() {
      this.field_78090_t = 64;
      this.field_78089_u = 32;
      float var1 = 8.0F;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.head.func_78793_a(0.0F, 0.0F + var1, 0.0F);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F);
      this.body.func_78793_a(0.0F, 8.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
      this.rightarm.func_78793_a(-5.0F, 10.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
      this.leftarm.func_78793_a(5.0F, 10.0F, 0.0F);
      this.leftarm.field_78809_i = true;
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.rightleg.func_78793_a(-2.0F, 16.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
      this.leftleg.func_78793_a(2.0F, 16.0F, 0.0F);
      this.leftleg.field_78809_i = true;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      if (this.field_78091_s) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
         GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
         this.head.render(f5);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
         this.body.render(f5);
         this.rightarm.render(f5);
         this.leftarm.render(f5);
         this.rightleg.render(f5);
         this.leftleg.render(f5);
         GL11.glPopMatrix();
      } else {
         this.head.render(f5);
         this.body.render(f5);
         this.rightarm.render(f5);
         this.leftarm.render(f5);
         this.rightleg.render(f5);
         this.leftleg.render(f5);
      }

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

      if (this.field_78119_l != 0) {
         this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - 0.31415927F * (float)this.field_78119_l;
      }

      if (this.field_78120_m != 0) {
         this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - 0.31415927F * (float)this.field_78120_m;
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
