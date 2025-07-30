package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Hair01Render extends TileEntitySpecialRenderer {
   private hair aModel = new hair();

   public void renderAModelAt(Hair01TileEntity tileentity1, double d, double d1, double d2, float f) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:armor/hair.png");
      this.func_147499_a(tx);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((Hair01TileEntity)tileentity, d, d1, d2, f);
   }
}
