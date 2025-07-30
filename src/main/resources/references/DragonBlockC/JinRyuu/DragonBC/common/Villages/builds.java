package JinRyuu.DragonBC.common.Villages;

import JinRyuu.JRMCore.blocks.BlocksJRMC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class builds extends WorldGenerator {
   protected boolean notComplete = false;
   protected int x = 0;
   protected int y = 0;
   protected int z = 0;
   protected int r = 0;
   protected int flp = 0;
   protected boolean check = false;
   public static int SizeX = 0;
   public static int SizeZ = 0;
   public static int SizeY = 0;
   public static int MidPointX = 0;
   public static int MidPointZ = 0;
   protected Block air;
   protected Block b56;
   protected Block b97;
   protected Block c;
   protected Block c2;
   protected Block s;
   protected Block f;
   protected Block stairCompactCobblestone;
   protected Block stairCompactPlanks;
   protected Block stoneSingleSlab;
   protected Block woodSingleSlab;
   protected Block fence;
   protected Block planks;
   protected Block leaves;
   protected Block glass;
   protected Block wood;
   protected Block stone;
   protected Block sand;
   protected Block sandstone;
   protected Block grass;
   protected Block dirt;
   protected Block oak_stairs;
   protected Block doorWood;
   protected Block iron_door;
   protected Block iron_block;
   protected Block torchWood;
   protected Block glowStone;
   protected Block bookShelf;
   protected Block stoneDoubleSlab;
   protected Block signWall;
   protected Block blockSteel;
   protected Block ladder;
   protected Block stoneBrick;
   protected Block woodDoubleSlab;
   protected Block sandStone;
   protected Block b116;
   protected Block b121;
   protected Block b113;
   protected World w;
   protected boolean respawn;

   public void b(int par2, int par3, int par4, Block par5) {
      this.b(par2, par3, par4, par5, 0);
   }

   protected void b(int par2, int par3, int par4, Block par5, int par6) {
      this.func_150516_a(this.w, par2, par3, par4, par5, par6);
   }

   public boolean getNotComplete() {
      return this.notComplete;
   }

   public void setR(int i) {
      this.r = i;
   }

   public void setFlp(int i) {
      this.flp = i;
   }

   public void setCheck(boolean b) {
      this.check = b;
   }

   protected Block[] GetValidSpawnBlocks() {
      return new Block[]{Blocks.field_150349_c};
   }

   public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
      this.w = world;
      int distanceToAir = 0;

      for(Block checkID = world.func_147439_a(i, j, k); checkID != Blocks.field_150350_a; checkID = world.func_147439_a(i, j + distanceToAir, k)) {
         ++distanceToAir;
      }

      if (distanceToAir > 6) {
         return false;
      } else {
         j += distanceToAir - 1;
         Block blockID = world.func_147439_a(i, j, k);
         Block blockIDAbove = world.func_147439_a(i, j + 1, k);
         Block blockIDBelow = world.func_147439_a(i, j - 1, k);
         Block[] var10 = this.GetValidSpawnBlocks();
         int var11 = var10.length;

         for(int var12 = 0; var12 < var11; ++var12) {
            Block x = var10[var12];
            if (blockIDAbove != Blocks.field_150350_a) {
               return false;
            }

            if (blockID == x) {
               return true;
            }

            if (blockID == Blocks.field_150433_aE && blockIDBelow == x) {
               return true;
            }
         }

         return false;
      }
   }

   public builds() {
      this.air = Blocks.field_150350_a;
      this.b56 = BlocksJRMC.stoneSingleSlab2;
      this.b97 = Blocks.field_150344_f;
      this.c = BlocksJRMC.BlockColoredStone2;
      this.c2 = BlocksJRMC.BlockColoredStone2;
      this.s = BlocksJRMC.stoneSingleSlab2;
      this.f = BlocksJRMC.BlockFence2;
      this.stairCompactCobblestone = Blocks.field_150446_ar;
      this.stairCompactPlanks = Blocks.field_150476_ad;
      this.stoneSingleSlab = Blocks.field_150333_U;
      this.woodSingleSlab = Blocks.field_150376_bx;
      this.fence = Blocks.field_150422_aJ;
      this.planks = Blocks.field_150344_f;
      this.leaves = Blocks.field_150362_t;
      this.glass = Blocks.field_150359_w;
      this.wood = Blocks.field_150364_r;
      this.stone = Blocks.field_150348_b;
      this.sand = Blocks.field_150354_m;
      this.sandstone = Blocks.field_150322_A;
      this.grass = Blocks.field_150349_c;
      this.dirt = Blocks.field_150346_d;
      this.oak_stairs = Blocks.field_150476_ad;
      this.doorWood = Blocks.field_150466_ao;
      this.iron_door = Blocks.field_150454_av;
      this.iron_block = Blocks.field_150339_S;
      this.torchWood = Blocks.field_150350_a;
      this.glowStone = Blocks.field_150426_aN;
      this.bookShelf = Blocks.field_150342_X;
      this.stoneDoubleSlab = Blocks.field_150417_aV;
      this.signWall = Blocks.field_150444_as;
      this.blockSteel = Blocks.field_150339_S;
      this.ladder = Blocks.field_150468_ap;
      this.stoneBrick = Blocks.field_150417_aV;
      this.woodDoubleSlab = Blocks.field_150344_f;
      this.sandStone = Blocks.field_150322_A;
      this.b116 = Blocks.field_150457_bL;
      this.b121 = BlocksJRMC.BlockStairs2;
      this.b113 = Blocks.field_150467_bQ;
      this.respawn = false;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      return false;
   }

   public void setWorld(World world) {
      this.w = world;
   }

   public boolean generateBuilding(World world, Random random, int i, int j, int k) {
      return false;
   }

   public void setRespawn(boolean b) {
      this.respawn = b;
   }
}
