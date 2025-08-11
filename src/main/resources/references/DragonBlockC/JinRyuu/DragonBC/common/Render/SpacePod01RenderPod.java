package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SpacePod01RenderPod extends Render {
   private ModelBase aModel = new SpacePod01Model();
   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");

   public SpacePod01RenderPod() {
      this.shadowSize = 0.5F;
   }

   public void renderAModelAt(SpacePod01Entity entity, double d, double d1, double d2, float f, float par9) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1 + 1.0F, (float)d2);
      GL11.glRotatef(180.0F - f, 0.0F, 1.0F, 0.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");
      this.renderManager.renderEngine.bindTexture(tx);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.aModel.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderAModelAt((SpacePod01Entity)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return shearedSheepTextures;
   }
}
