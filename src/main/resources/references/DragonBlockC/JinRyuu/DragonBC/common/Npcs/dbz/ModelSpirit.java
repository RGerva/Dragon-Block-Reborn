package JinRyuu.DragonBC.common.Npcs.dbz;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSpirit extends ModelBase {
   public ModelRenderer Body;
   public ModelRenderer Body1;
   public ModelRenderer Body2;
   public ModelRenderer Body3;
   public ModelRenderer Body4;
   public ModelRenderer Body5;
   public ModelRenderer Body6;
   public ModelRenderer Body7;
   public ModelRenderer Body8;
   public ModelRenderer BodyR;
   public ModelRenderer BodyL;
   public ModelRenderer BodyTop;
   public ModelRenderer BodyBot;
   public ModelRenderer BodyFront;
   public ModelRenderer Bodytail1;
   public ModelRenderer Bodytail2;
   public ModelRenderer Bodytail3;
   public ModelRenderer Bodytail4;

   public ModelSpirit() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.Body8 = new ModelRenderer(this, 1, 23);
      this.Body8.func_78793_a(-1.5F, 3.1F, 2.5F);
      this.Body8.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
      this.Body1 = new ModelRenderer(this, 0, 10);
      this.Body1.func_78793_a(-1.8F, -1.6F, -2.2F);
      this.Body1.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.BodyR = new ModelRenderer(this, 1, 23);
      this.BodyR.func_78793_a(-3.2F, 1.8F, 0.4F);
      this.BodyR.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
      this.BodyBot = new ModelRenderer(this, 1, 47);
      this.BodyBot.func_78793_a(-1.1F, 5.7F, 0.4F);
      this.BodyBot.func_78790_a(-2.5F, -1.5F, -2.7F, 5, 3, 5, 0.0F);
      this.Body5 = new ModelRenderer(this, 21, 33);
      this.Body5.func_78793_a(1.2F, 3.1F, -1.6F);
      this.Body5.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
      this.Body6 = new ModelRenderer(this, 0, 33);
      this.Body6.func_78793_a(-2.0F, 2.8F, -2.3F);
      this.Body6.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
      this.Bodytail2 = new ModelRenderer(this, 45, 54);
      this.Bodytail2.func_78793_a(-1.0F, -0.1F, 0.7F);
      this.Bodytail2.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
      this.BodyTop = new ModelRenderer(this, 1, 1);
      this.BodyTop.func_78793_a(0.9F, -4.2F, 0.1F);
      this.BodyTop.func_78790_a(-2.5F, -1.5F, -2.7F, 5, 3, 5, 0.0F);
      this.setRotateAngle(this.BodyTop, 0.0F, 0.0F, -0.011152261F);
      this.BodyFront = new ModelRenderer(this, 21, 24);
      this.BodyFront.func_78793_a(1.4F, 0.4F, -4.9F);
      this.BodyFront.func_78790_a(-2.5F, -2.5F, -1.5F, 4, 5, 3, 0.0F);
      this.Bodytail3 = new ModelRenderer(this, 49, 46);
      this.Bodytail3.func_78793_a(0.0F, 0.9F, 2.7F);
      this.Bodytail3.func_78790_a(-1.5F, -1.5F, -1.9F, 3, 3, 4, 0.0F);
      this.Bodytail4 = new ModelRenderer(this, 53, 39);
      this.Bodytail4.func_78793_a(0.0F, 1.1F, 1.9F);
      this.Bodytail4.func_78790_a(-0.6F, -1.5F, -1.9F, 1, 2, 4, 0.0F);
      this.Body3 = new ModelRenderer(this, 1, 11);
      this.Body3.func_78793_a(1.0F, -1.5F, 2.1F);
      this.Body3.func_78790_a(-3.0F, -3.0F, -2.5F, 6, 6, 5, 0.0F);
      this.Body7 = new ModelRenderer(this, 1, 33);
      this.Body7.func_78793_a(1.5F, 2.9F, 2.7F);
      this.Body7.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
      this.BodyL = new ModelRenderer(this, 36, 22);
      this.BodyL.func_78793_a(3.6F, 0.7F, 0.1F);
      this.BodyL.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
      this.Body4 = new ModelRenderer(this, 26, 12);
      this.Body4.func_78793_a(-1.9F, -0.8F, 2.2F);
      this.Body4.func_78790_a(-2.5F, -3.0F, -2.0F, 5, 6, 4, 0.0F);
      this.Bodytail1 = new ModelRenderer(this, 26, 53);
      this.Bodytail1.func_78793_a(0.6F, 1.8F, 4.9F);
      this.Bodytail1.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
      this.Body = new ModelRenderer(this, 65, 1);
      this.Body.func_78793_a(0.0F, 3.8F, 0.0F);
      this.Body.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
      this.Body2 = new ModelRenderer(this, 25, 11);
      this.Body2.func_78793_a(2.1F, -1.9F, -2.3F);
      this.Body2.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
      this.Body.func_78792_a(this.Body8);
      this.Body.func_78792_a(this.Body1);
      this.Body.func_78792_a(this.BodyR);
      this.Body.func_78792_a(this.BodyBot);
      this.Body.func_78792_a(this.Body5);
      this.Body.func_78792_a(this.Body6);
      this.Bodytail1.func_78792_a(this.Bodytail2);
      this.Body.func_78792_a(this.BodyTop);
      this.Body.func_78792_a(this.BodyFront);
      this.Bodytail2.func_78792_a(this.Bodytail3);
      this.Bodytail3.func_78792_a(this.Bodytail4);
      this.Body.func_78792_a(this.Body3);
      this.Body.func_78792_a(this.Body7);
      this.Body.func_78792_a(this.BodyL);
      this.Body.func_78792_a(this.Body4);
      this.Body.func_78792_a(this.Bodytail1);
      this.Body.func_78792_a(this.Body2);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.Body.func_78785_a(f5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.field_78795_f = x;
      modelRenderer.field_78796_g = y;
      modelRenderer.field_78808_h = z;
   }

   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
      float ex = (float)par7Entity.field_70173_aa;
      float sin = MathHelper.func_76126_a(ex * 0.5F) * 0.01F;
      float sin2 = MathHelper.func_76126_a(ex * 1.0F) * -0.01F;
      float sin3 = MathHelper.func_76126_a(ex * 1.0F) * 0.01F;
      ModelRenderer[] segments = new ModelRenderer[]{this.Body, this.Body1, this.Body2, this.Body3, this.Body4, this.Body5, this.Body6, this.Body7, this.Body8, this.BodyL, this.BodyTop, this.BodyBot, this.BodyFront, this.Bodytail1};

      for(int i = 0; i < segments.length; ++i) {
         segments[i].field_78795_f = sin * (float)(i / 2 == 0 ? 1 : -1);
         segments[i].field_78796_g = sin2 * (float)(i / 2 == 0 ? 1 : -1);
         segments[i].field_78808_h = sin3 * (float)(i / 2 == 0 ? 1 : -1);
      }

   }
}
