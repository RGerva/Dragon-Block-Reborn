package JinRyuu.DragonBC.common.m;

import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSakuraTree extends WorldGenAbstractTree {
   public boolean b = false;

   public WorldGenSakuraTree() {
      super(false);
      this.b = false;
   }

   public WorldGenSakuraTree(boolean b) {
      super(false);
      this.b = b;
   }

   public boolean func_76484_a(World world, Random random, int x, int y, int z) {
      if (this.b) {
         while(world.func_147437_c(x, y, z) && y > 2) {
            --y;
         }
      } else {
         --y;
      }

      Block block = world.func_147439_a(x, y, z);
      if (block != Blocks.field_150349_c && block != Blocks.field_150346_d) {
         return false;
      } else if (world.func_147437_c(x, y, z) && !world.func_147437_c(x, y + 2, z)) {
         return false;
      } else {
         int baselength = 3 + random.nextInt(4);
         int branches = 1;
         int h = 1;
         block.onPlantGrow(world, x, y, z, x, y, z);
         if (world.func_72904_c(x - 8, y, z - 8, x + 10, y + 8, z + 8)) {
            int dec;
            for(dec = 0; dec < baselength; ++dec) {
               this.buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 0);
               ++h;
            }

            dec = random.nextInt(3);
            int c;
            int i;
            if (dec == 0) {
               c = 1;

               for(i = 0; i < branches; ++i) {
                  this.generateTreeOne(world, random, x, y + h, z, c);
                  ++c;
                  h += 2;
               }
            } else if (dec == 1) {
               c = 1;

               for(i = 0; i < branches; ++i) {
                  this.generateTreeTwo(world, random, x, y + h, z, c);
                  ++c;
                  h += 2;
               }
            } else if (dec == 2) {
               c = 1;

               for(i = 0; i < branches; ++i) {
                  this.generateTreeThree(world, random, x, y + h, z, c);
                  ++c;
                  h += 2;
               }
            }
         }

         return true;
      }
   }

   public void generateTreeTwo(World world, Random random, int x, int y, int z, int p) {
      for(int h = 0; h < 5; ++h) {
         for(int i = -1; i < 2; ++i) {
            for(int j = -1; j < 2; ++j) {
               this.buildBlock(world, x + i, y + h, z + j, ModdedBlocks.SakuraLeaves, 0);
            }
         }
      }

      this.buildBlock(world, x, y, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 1, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 2, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 4, z + 1, Blocks.field_150350_a, 0);
      this.buildBlock(world, x + 1, y + 4, z + 1, Blocks.field_150350_a, 0);
      this.buildBlock(world, x - 2, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
   }

   public void generateTreeOne(World world, Random random, int x, int y, int z, int p) {
      for(int i = -1; i < 2; ++i) {
         for(int j = -1; j < 2; ++j) {
            this.buildBlock(world, x + i, y, z + j, ModdedBlocks.SakuraLeaves, 0);
         }
      }

      this.buildBlock(world, x - 1, y, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 1, y, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 2, y + 1, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 1, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
   }

   public void generateTreeThree(World world, Random random, int x, int y, int z, int p) {
      int h;
      for(h = 1; h < 8; ++h) {
         for(int i = -1; i < 2; ++i) {
            for(int j = -1; j < 2; ++j) {
               this.buildBlock(world, x + i, y + h, z + j, ModdedBlocks.SakuraLeaves, 0);
            }
         }
      }

      for(h = 0; h < 7; ++h) {
         this.buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 0);
      }

      this.buildBlock(world, x + 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 1, y + 2, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 3, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 2, y + 3, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 3, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 2, y + 4, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 4, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 2, y + 4, z + 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 5, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x, y + 5, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 4, y + 5, z + 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 1, y + 5, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 5, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 5, z - 1, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 5, z - 2, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x + 3, y + 6, z, ModdedBlocks.SakuraLogs, 0);
      this.buildBlock(world, x - 3, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y - 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y - 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 5, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 5, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 2, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x - 1, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 4, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 1, y + 7, z + 1, Blocks.field_150350_a, 0);
      this.buildBlock(world, x + 2, y + 7, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 3, y + 7, z, ModdedBlocks.SakuraLeaves, 0);
      this.buildBlock(world, x + 2, y + 7, z - 1, ModdedBlocks.SakuraLeaves, 0);
   }

   public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
      if (world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z).isLeaves(world, x, y, z)) {
         this.func_150516_a(world, x, y, z, block, meta);
      }

   }
}
