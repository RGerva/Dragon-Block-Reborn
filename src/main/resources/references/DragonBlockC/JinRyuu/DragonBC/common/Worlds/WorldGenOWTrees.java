package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenOWTrees extends WorldGenerator {
   private final int minTreeHeight;
   private final boolean growVines;
   private final int metaWood;
   private final int metaLeaves;

   public WorldGenOWTrees(boolean par1) {
      this(par1, 8, 0, 0, false);
   }

   public WorldGenOWTrees(boolean par1, int par2, int par3, int par4, boolean par5) {
      super(par1);
      this.minTreeHeight = par2;
      this.metaWood = par3;
      this.metaLeaves = par4;
      this.growVines = par5;
   }

   public boolean func_76484_a(World world, Random rand, int i, int j, int k) {
      int height = 4 + rand.nextInt(4);
      int sizex = 3 + rand.nextInt(5);
      int sizez = 3 + rand.nextInt(5);
      int sxh = sizex / 2;
      int szh = sizez / 2;
      if (world.func_147437_c(i, j, k) && !world.func_147437_c(i, j - 1, k)) {
         int sizey = 4 + rand.nextInt(4);

         int i2;
         for(i2 = 0; i2 < sizex; ++i2) {
            for(int j2 = 0; j2 < sizez; ++j2) {
               for(int k2 = 0; k2 < sizey; ++k2) {
                  this.setBlock(world, i + i2 - sxh, j + height - 3 + k2, k + j2 - szh, Blocks.field_150362_t);
               }
            }
         }

         for(i2 = 0; i2 < height; ++i2) {
            this.setBlock(world, i + 0, j + i2, k + 0, Blocks.field_150364_r);
         }
      }

      return true;
   }

   private void setBlock(World world, int i, int j, int k, Block b) {
      if (world.func_72904_c(i, j, k, i, j, k)) {
         this.func_150516_a(world, i, j, k, b, 0);
      }

   }

   protected boolean func_150523_a(Block p_150523_1_) {
      return p_150523_1_.func_149688_o() == Material.field_151579_a || p_150523_1_.func_149688_o() == Material.field_151584_j || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == Blocks.field_150345_g || p_150523_1_ == Blocks.field_150395_bd;
   }

   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {
   }

   protected boolean isReplaceable(World world, int x, int y, int z) {
      Block block = world.func_147439_a(x, y, z);
      return block.isAir(world, x, y, z) || block.isLeaves(world, x, y, z) || block.isWood(world, x, y, z) || this.func_150523_a(block);
   }
}
