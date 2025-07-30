package JinRyuu.DragonBC.common.Render;

import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class namekian_throneRender extends TileEntitySpecialRenderer {
   private namekian_throneModel aModel = new namekian_throneModel();

   public void renderAModelAt(namekian_throneTileEntity tileentity, double d, double d1, double d2, float f) {
      int id = tileentity.func_145831_w().func_72805_g(tileentity.field_145851_c, tileentity.field_145848_d, tileentity.field_145849_e);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef((float)(90 * id), 0.0F, 1.0F, 0.0F);
      ResourceLocation tx = new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/tile/namekian_throne.png");
      this.func_147499_a(tx);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((namekian_throneTileEntity)tileentity, d, d1, d2, f);
   }
}
