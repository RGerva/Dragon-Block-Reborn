package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DragonBlock01Render extends TileEntitySpecialRenderer {
   private DragonBlock01Model aModel = new DragonBlock01Model();

   public void renderAModelAt(DragonBlock01TileEntity tileentity, double d, double d1, double d2, float f) {
      GL11.glPushMatrix();
      Block b = tileentity.func_145838_q();
      if (b == BlocksDBC.BlockDragonBall) {
         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.51F, (float)d2 + 0.5F);
      } else if (b == BlocksDBC.BlockNamekDragonBall) {
         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 3.01F, (float)d2 + 0.5F);
         GL11.glScalef(2.0F, 2.0F, 2.0F);
      }

      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:dragon_ball.png");
      this.func_147499_a(tx);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((DragonBlock01TileEntity)tileentity, d, d1, d2, f);
   }
}
