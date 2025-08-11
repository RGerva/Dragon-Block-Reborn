package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class KintounRender extends Render {
   private final String[] texture = new String[]{"Flying_Nimbus", "Dark_Nimbus"};
   private int type = 0;
   private ModelBase aModel;
   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:armor/halo.png");

   public KintounRender() {
      this.aModel = new KintounModel();
      this.shadowSize = 0.5F;
   }

   public KintounRender(int id) {
      this.type = id;
      this.aModel = new KintounModel();
      this.shadowSize = 0.5F;
   }

   public void renderAModelAt(KintounBaseEntity entity, double d, double d1, double d2, float f, float par9) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1 - 0.7F, (float)d2);
      GL11.glRotatef(90.0F - f, 0.0F, 1.0F, 0.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:npcs/" + this.texture[this.type] + ".png");
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
      this.renderAModelAt((KintounBaseEntity)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return shearedSheepTextures;
   }
}
