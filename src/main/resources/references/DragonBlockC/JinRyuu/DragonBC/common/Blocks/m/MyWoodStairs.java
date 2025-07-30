package JinRyuu.DragonBC.common.Blocks.m;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class MyWoodStairs extends BlockStairs {
   protected MyWoodStairs(Block sakuraStairs, int meta) {
      super(ModdedBlocks.SakuraPlank, meta);
      this.field_149783_u = true;
   }

   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
      return 40;
   }

   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
      return 5;
   }
}
