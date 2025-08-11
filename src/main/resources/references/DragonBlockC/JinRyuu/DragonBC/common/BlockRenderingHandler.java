package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class BlockRenderingHandler implements ISimpleBlockRenderingHandler {
   public static final double POSITION_FIX = -0.5D;
   private static ArtGravDevTileEntity generator = new ArtGravDevTileEntity();

   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
   }

   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
      Tessellator tes = Tessellator.INSTANCE;
      return false;
   }

   public static void RenderStaticTileEntity(IBlockAccess world, int x, int y, int z, RenderBlocks blocksRenderer, TileEntity tile) {
   }

   public int getRenderId() {
      return 0;
   }

   public boolean shouldRender3DInInventory(int modelId) {
      return true;
   }
}
