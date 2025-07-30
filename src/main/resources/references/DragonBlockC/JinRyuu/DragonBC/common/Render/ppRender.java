package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ppRender extends TileEntitySpecialRenderer {
   private ppModel aModel = new ppModel();

   public void renderAModelAt(ppTileEntity tileentity, double d, double d1, double d2, float f) {
      GL11.glPushMatrix();
      int s = 1;
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.0F + (float)s, (float)d2 + 0.5F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:textures/blades/P.png");
      this.func_147499_a(tx);
      GL11.glPushMatrix();
      GL11.glScaled(1.0D, (double)s, 1.0D);
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((ppTileEntity)tileentity, d, d1, d2, f);
   }
}
