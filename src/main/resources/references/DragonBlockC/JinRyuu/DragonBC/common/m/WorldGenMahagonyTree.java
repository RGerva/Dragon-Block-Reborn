package JinRyuu.DragonBC.common.m;

import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenMahagonyTree extends WorldGenAbstractTree {
   public boolean b = false;

   public WorldGenMahagonyTree() {
      super(false);
      this.b = false;
   }

   public WorldGenMahagonyTree(boolean b) {
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
         int singlebranches = 1;
         int multibranches = 1 + random.nextInt(2);
         int treeTwoTop = 0;
         if (multibranches == 1) {
            treeTwoTop = 3;
         } else if (multibranches == 2) {
            treeTwoTop = 6;
         }

         int h = 1;
         block.onPlantGrow(world, x, y, z, x, y, z);
         if (world.func_72904_c(x - 8, y, z - 8, x + 10, y + 8, z + 8)) {
            int dec;
            for(dec = 0; dec < baselength; ++dec) {
               this.buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 1);
               ++h;
            }

            dec = random.nextInt(5);
            int c;
            int Br1;
            int Br2;
            int Br3;
            int Br4;
            if (dec != 0 && dec != 4) {
               if (dec == 1) {
                  c = 1;
                  Br1 = random.nextInt(2);
                  Br2 = random.nextInt(2);
                  Br3 = random.nextInt(2);
                  Br4 = random.nextInt(2);
                  int Br5 = random.nextInt(2);
                  int Br6 = random.nextInt(2);

                  for(int i = 0; i < multibranches; ++i) {
                     if (i == 0) {
                        this.generateTreeTwoTrunk(world, random, x, y + h, z, c);
                        if (Br1 == 1) {
                           this.generateTreeTwoBranchOne(world, random, x, y + h, z, c);
                        }

                        if (Br2 == 1) {
                           this.generateTreeTwoBranchTwo(world, random, x, y + h, z, c);
                        }

                        if (Br3 == 1) {
                           this.generateTreeTwoBranchThree(world, random, x, y + h, z, c);
                        }

                        if (Br4 == 1) {
                           this.generateTreeTwoBranchFour(world, random, x, y + h, z, c);
                        }

                        if (Br5 == 1) {
                           this.generateTreeTwoBranchFive(world, random, x, y + h, z, c);
                        }

                        if (Br6 == 1) {
                           this.generateTreeTwoBranchSix(world, random, x, y + h, z, c);
                        }
                     }

                     Br1 = random.nextInt(2);
                     Br2 = random.nextInt(2);
                     Br3 = random.nextInt(2);
                     Br4 = random.nextInt(2);
                     Br5 = random.nextInt(2);
                     Br6 = random.nextInt(2);
                     ++c;
                     h += 2;
                     if (i == 1) {
                        this.generateTreeTwoTrunk(world, random, x, y + 1 + h, z, c);
                        if (Br1 == 1) {
                           this.generateTreeTwoBranchOne(world, random, x, y + 1 + h, z, c);
                        }

                        if (Br2 == 1) {
                           this.generateTreeTwoBranchTwo(world, random, x, y + 1 + h, z, c);
                        }

                        if (Br3 == 1) {
                           this.generateTreeTwoBranchThree(world, random, x, y + 1 + h, z, c);
                        }

                        if (Br4 == 1) {
                           this.generateTreeTwoBranchFour(world, random, x, y + 1 + h, z, c);
                        }

                        if (Br5 == 1) {
                           this.generateTreeTwoBranchFive(world, random, x, y + 1 + h, z, c);
                        }

                        if (Br6 == 1) {
                           this.generateTreeTwoBranchSix(world, random, x, y + 1 + h, z, c);
                        }
                     }
                  }

                  this.generateTreeTwoTop(world, random, x, y + treeTwoTop + h, z, c);
               } else if (dec == 2 || dec == 3) {
                  int c = 1;

                  for(Br1 = 0; Br1 < multibranches; ++Br1) {
                     this.generateTreeThree(world, random, x, y + h, z, c);
                  }
               }
            } else {
               c = 1;
               Br1 = random.nextInt(2);
               Br2 = random.nextInt(2);
               Br3 = random.nextInt(2);

               for(Br4 = 0; Br4 < singlebranches; ++Br4) {
                  this.generateTreeOneBranchOne(world, random, x, y + h, z, c);
                  if (Br1 == 1) {
                     this.generateTreeOneBranchTwo(world, random, x, y + h, z, c);
                  }

                  if (Br2 == 1) {
                     this.generateTreeOneBranchThree(world, random, x, y + h, z, c);
                  }

                  if (Br3 == 1) {
                     this.generateTreeOneBranchFour(world, random, x, y + h, z, c);
                  }

                  ++c;
                  h += 2;
               }
            }
         }

         return true;
      }
   }

   public void generateTreeOneBranchOne(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 1, z + 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 2, z + 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 2, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 3, z + 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeOneBranchTwo(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 1, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 1, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 7, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 7, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeOneBranchThree(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 1, z + 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 1, z + 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 2, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 3, z + 6, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 3, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 9, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 9, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeOneBranchFour(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y + 1, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 1, z - 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 2, z - 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 3, z - 6, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 3, z - 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 9, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 9, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoTrunk(World world, Random random, int x, int y, int z, int p) {
      for(int i = 0; i < 5; ++i) {
         this.buildBlock(world, x, y + i, z, ModdedBlocks.SakuraLogs, 1);
      }

   }

   public void generateTreeTwoBranchOne(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x + 1, y, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 5, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 7, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 7, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 6, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoBranchTwo(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x + 1, y, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 3, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 4, y + 4, z - 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 5, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 5, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoBranchThree(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 3, z - 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 4, z - 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 5, y + 4, z - 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoBranchFour(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 1, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 5, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 6, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 8, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 7, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoBranchFive(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 4, z + 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 4, z + 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 1, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 2, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x + 3, y + 5, z + 6, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 5, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 5, z + 8, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 6, z + 7, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoBranchSix(World world, Random random, int x, int y, int z, int p) {
      this.buildBlock(world, x, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 2, y + 4, z + 3, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 3, y + 4, z + 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 5, z + 4, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 4, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 5, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x - 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 3, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 6, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 4, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 6, z + 4, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 5, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 6, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeTwoTop(World world, Random random, int x, int y, int z, int p) {
      for(int h = 1; h < 3; ++h) {
         for(int i = -1; i < 2; ++i) {
            for(int j = -1; j < 2; ++j) {
               this.buildBlock(world, x + i, y + h, z + j, ModdedBlocks.SakuraLeaves, 1);
            }
         }
      }

      this.buildBlock(world, x, y, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLogs, 1);
      this.buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
   }

   public void generateTreeThree(World world, Random random, int x, int y, int z, int p) {
      int i;
      int j;
      for(i = 2; i < 5; ++i) {
         for(j = -1; j < 2; ++j) {
            for(int j = -1; j < 2; ++j) {
               this.buildBlock(world, x + 1 + j, y + i, z + j, ModdedBlocks.SakuraLeaves, 1);
            }
         }
      }

      for(i = 0; i < 4; ++i) {
         this.buildBlock(world, x + 1, y + i, z, ModdedBlocks.SakuraLogs, 1);
      }

      for(i = -2; i < 3; ++i) {
         for(j = -2; j < 3; ++j) {
            this.buildBlock(world, x + 1 + i, y + 2, z + j, ModdedBlocks.SakuraLeaves, 1);
         }
      }

      this.buildBlock(world, x, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 1, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x + 2, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
      this.buildBlock(world, x - 1, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
   }

   public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
      if (world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z).isLeaves(world, x, y, z)) {
         this.func_150516_a(world, x, y, z, block, meta);
      }

   }
}
