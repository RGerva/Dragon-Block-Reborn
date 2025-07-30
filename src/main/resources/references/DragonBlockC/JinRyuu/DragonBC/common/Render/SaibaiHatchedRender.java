package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SaibaiHatchedRender extends TileEntitySpecialRenderer {
   private SaibaiHatchedModel aModel = new SaibaiHatchedModel();

   public void renderAModelAt(SaibaiHatchedTileEntity tileentity, double d, double d1, double d2, float f) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:saibaihatched.png");
      this.func_147499_a(tx);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((SaibaiHatchedTileEntity)tileentity, d, d1, d2, f);
   }
}
