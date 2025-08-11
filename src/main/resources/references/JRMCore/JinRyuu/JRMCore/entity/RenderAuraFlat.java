package JinRyuu.JRMCore.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAuraFlat extends RenderJRMC {
   public RenderAuraFlat(ModelBase model, float f) {
      super(model, f);
   }

   public void doRender(EntityAuraFlat entity, double d, double d1, double d2, float d3, float f) {
      float f5 = 0.0625F;
      this.func_110776_a(this.getEntityTexture(entity));
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      entity.update();
      float scale = 0.5F;
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
      GL11.glColor4f((float)entity.aura.getRed() / 255.0F, (float)entity.aura.getGreen() / 255.0F, (float)entity.aura.getBlue() / 255.0F, entity.transparency.lastValue);
      GL11.glTranslatef((float)entity.posX, (float)entity.posY, (float)entity.posZ);
      GL11.glRotatef((float)((int)entity.posX * 30), 0.0F, 0.0F, 1.0F);
      GL11.glRotatef((float)((int)entity.posZ * 30), 1.0F, 0.0F, 0.0F);
      this.mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return ((EntityAuraFlat)entity).getTexture();
   }

   public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
      this.doRender((EntityAuraFlat)entity, d0, d1, d2, f, f1);
   }
}
