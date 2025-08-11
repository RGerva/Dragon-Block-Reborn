package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelBuuFat extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer body2;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer headtail1;
   ModelRenderer headtail2;
   ModelRenderer headtail3;
   ModelRenderer cape;
   private float F;

   public ModelBuuFat(float f) {
      this();
      this.F = f;
   }

   public ModelBuuFat() {
      this.F = 1.0F;
      this.field_78090_t = 128;
      this.field_78089_u = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 0, 16);
      this.body.func_78789_a(-6.0F, 0.0F, -3.0F, 12, 8, 6);
      this.body.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.body2 = new ModelRenderer(this, 0, 30);
      this.body2.func_78789_a(-7.0F, 8.0F, -4.0F, 14, 8, 8);
      this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.body2, 0.0F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 36, 16);
      this.rightarm.func_78789_a(-5.0F, -2.0F, -2.0F, 4, 10, 4);
      this.rightarm.func_78793_a(-6.0F, 2.0F, 0.0F);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.1745329F);
      this.leftarm = new ModelRenderer(this, 36, 16);
      this.leftarm.func_78789_a(1.0F, -2.0F, -2.0F, 4, 10, 4);
      this.leftarm.func_78793_a(6.0F, 2.0F, 0.0F);
      this.leftarm.field_78809_i = true;
      this.setRotation(this.leftarm, 0.0F, 0.0F, -0.1745329F);
      this.rightleg = new ModelRenderer(this, 0, 46);
      this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 8, 4);
      this.rightleg.func_78793_a(-4.0F, 16.0F, 0.0F);
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 46);
      this.leftleg.func_78789_a(0.0F, 0.0F, -2.0F, 4, 8, 4);
      this.leftleg.func_78793_a(2.0F, 16.0F, 0.0F);
      this.leftleg.field_78809_i = true;
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.headtail1 = new ModelRenderer(this, 52, 0);
      this.headtail1.func_78789_a(-2.0F, -10.0F, -6.0F, 4, 5, 4);
      this.headtail1.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.headtail1, -0.6283185F, 0.0F, 0.0F);
      this.headtail2 = new ModelRenderer(this, 40, 0);
      this.headtail2.func_78789_a(-1.5F, -12.0F, -8.0F, 3, 4, 3);
      this.headtail2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.headtail2, -0.8901179F, 0.0F, 0.0F);
      this.headtail3 = new ModelRenderer(this, 32, 0);
      this.headtail3.func_78789_a(-1.0F, -12.0F, -11.0F, 2, 4, 2);
      this.headtail3.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.headtail3, -1.22173F, 0.0F, 0.0F);
      this.cape = new ModelRenderer(this, 44, 30);
      this.cape.func_78789_a(-7.0F, 1.0F, 3.0F, 14, 20, 0);
      this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.cape, 0.2268928F, 0.0F, 0.0F);
      this.head.func_78792_a(this.headtail1);
      this.head.func_78792_a(this.headtail2);
      this.head.func_78792_a(this.headtail3);
      this.body.func_78792_a(this.cape);
      this.body.func_78792_a(this.body2);
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
      this.rightarm.rotateAngleZ = 0.1745329F;
      this.leftarm.rotateAngleZ = -0.1745329F;
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
      float rota;
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
         rota = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
         this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)rota));
         var10000 = this.rightarm;
         var10000.rotateAngleY += this.body.rotateAngleY * 2.0F;
      }

      rota = -MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
      if (rota > 0.0F) {
         rota *= -1.0F;
      }

      this.cape.rotateAngleX = -0.23F + rota;
      if (0.0F > this.cape.rotateAngleX) {
         var10000 = this.cape;
         var10000.rotateAngleX *= -1.0F;
      }

      this.cape.rotateAngleY = 0.0F;
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
