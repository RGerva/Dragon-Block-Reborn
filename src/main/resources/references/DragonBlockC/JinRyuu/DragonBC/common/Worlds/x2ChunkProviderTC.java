package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Post;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Pre;

public class x2ChunkProviderTC implements IChunkProvider {
   private Random rand;
   private NoiseGeneratorOctaves noiseGen1;
   private NoiseGeneratorOctaves noiseGen2;
   private NoiseGeneratorOctaves noiseGen3;
   private NoiseGeneratorPerlin noisePerl;
   public NoiseGeneratorOctaves noiseGen5;
   public NoiseGeneratorOctaves noiseGen6;
   public NoiseGeneratorOctaves mobSpawnerNoise;
   private World worldObj;
   private final boolean mapFeaturesEnabled;
   private WorldType worldType;
   private final double[] noiseArray;
   private final float[] parabolicField;
   private double[] stoneNoise = new double[256];
   private MapGenBase caveGenerator = new MapGenCaves();
   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
   private MapGenBase ravineGenerator = new MapGenRavine();
   private BiomeGenBase[] biomesForGeneration;
   double[] noise3;
   double[] noise1;
   double[] noise2;
   double[] noise5;
   int[][] field_73219_j = new int[32][32];

   public x2ChunkProviderTC(World world, long seed, boolean mapFeaturesEnabled) {
      this.worldObj = world;
      this.mapFeaturesEnabled = mapFeaturesEnabled;
      this.worldType = world.func_72912_H().func_76067_t();
      this.rand = new Random(seed);
      this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
      this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
      this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
      this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
      this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
      this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
      this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
      this.noiseArray = new double[825];
      this.parabolicField = new float[25];

      for(int j = -2; j <= 2; ++j) {
         for(int k = -2; k <= 2; ++k) {
            float f = 10.0F / MathHelper.func_76129_c((float)(j * j + k * k) + 0.2F);
            this.parabolicField[j + 2 + (k + 2) * 5] = f;
         }
      }

      NoiseGenerator[] noiseGens = new NoiseGenerator[]{this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noisePerl, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise};
      noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
      this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
      this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
      this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
      this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
      this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
      this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
      this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
   }

   public void func_147424_a(int par1, int par2, Block[] blocks) {
      byte b0 = 63;
      this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
      this.func_147423_a(par1 * 4, 0, par2 * 4);

      for(int k = 0; k < 4; ++k) {
         int l = k * 5;
         int i1 = (k + 1) * 5;

         for(int j1 = 0; j1 < 4; ++j1) {
            int k1 = (l + j1) * 33;
            int l1 = (l + j1 + 1) * 33;
            int i2 = (i1 + j1) * 33;
            int j2 = (i1 + j1 + 1) * 33;

            for(int k2 = 0; k2 < 32; ++k2) {
               double d0 = 0.125D;
               double d1 = this.noiseArray[k1 + k2];
               double d2 = this.noiseArray[l1 + k2];
               double d3 = this.noiseArray[i2 + k2];
               double d4 = this.noiseArray[j2 + k2];
               double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
               double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
               double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
               double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;

               for(int l2 = 0; l2 < 8; ++l2) {
                  double d9 = 0.25D;
                  double d10 = d1;
                  double d11 = d2;
                  double d12 = (d3 - d1) * d9;
                  double d13 = (d4 - d2) * d9;

                  for(int i3 = 0; i3 < 4; ++i3) {
                     int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                     short short1 = 256;
                     j3 -= short1;
                     double d14 = 0.25D;
                     double d16 = (d11 - d10) * d14;
                     double d15 = d10 - d16;

                     for(int k3 = 0; k3 < 4; ++k3) {
                        if ((d15 += d16) > 0.0D) {
                           blocks[j3 += short1] = Blocks.field_150348_b;
                        } else if (k2 * 8 + l2 < b0) {
                           blocks[j3 += short1] = Blocks.field_150355_j;
                        } else {
                           blocks[j3 += short1] = null;
                        }
                     }

                     d10 += d12;
                     d11 += d13;
                  }

                  d1 += d5;
                  d2 += d6;
                  d3 += d7;
                  d4 += d8;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int par1, int par2, Block[] blocks, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
      ReplaceBiomeBlocks event = new ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.getResult() != Result.DENY) {
         double d0 = 0.03125D;
         this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (double)(par1 * 16), (double)(par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

         for(int k = 0; k < 16; ++k) {
            for(int l = 0; l < 16; ++l) {
               BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
               this.genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
            }
         }

      }
   }

   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      this.genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   public void genBiomeModdedTerrain(BiomeGenBaseDBC bgb, World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y, double z) {
      Block block = bgb.field_76752_A;
      byte b0 = (byte)(bgb.field_150604_aj & 255);
      Block block1 = bgb.field_76753_B;
      int k = -1;
      int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
      int i1 = x & 15;
      int j1 = y & 15;
      int k1 = replacableBlock.length / 256;

      for(int l1 = 255; l1 >= 0; --l1) {
         int i2 = (j1 * 16 + i1) * k1 + l1;
         Block var38;
         if (l1 <= 0 + random.nextInt(5)) {
            replacableBlock[i2] = Blocks.field_150357_h;
         } else {
            var38 = replacableBlock[i2];
            if (var38 != null && var38.func_149688_o() != Material.field_151579_a) {
               if (var38 == Blocks.field_150348_b) {
                  if (k == -1) {
                     if (l <= 0) {
                        block = null;
                        b0 = 0;
                        block1 = Blocks.field_150348_b;
                     } else if (l1 >= 59 && l1 <= 64) {
                        block = bgb.field_76752_A;
                        b0 = (byte)(bgb.field_150604_aj & 255);
                        block1 = bgb.field_76753_B;
                     }

                     if (l1 < 63 && (block == null || block.func_149688_o() == Material.field_151579_a)) {
                        if (bgb.func_150564_a(x, l1, y) < 0.15F) {
                           block = Blocks.field_150432_aD;
                           b0 = 0;
                        } else {
                           block = Blocks.field_150355_j;
                           b0 = 0;
                        }
                     }

                     k = l;
                     if (l1 >= 62) {
                        replacableBlock[i2] = block;
                        aByte[i2] = b0;
                     } else if (l1 < 56 - l) {
                        block = null;
                        block1 = Blocks.field_150348_b;
                        replacableBlock[i2] = Blocks.field_150351_n;
                     } else {
                        replacableBlock[i2] = block1;
                     }
                  } else if (k > 0) {
                     --k;
                     replacableBlock[i2] = block1;
                     if (k == 0 && block1 == Blocks.field_150354_m) {
                        k = random.nextInt(4) + Math.max(0, l1 - 63);
                        block1 = Blocks.field_150322_A;
                     }
                  }
               }
            } else {
               k = -1;
            }
         }

         var38 = replacableBlock[i2];
         if (l1 > 31 && l1 < 200 && var38 == Blocks.field_150348_b) {
            replacableBlock[i2] = Blocks.field_150350_a;
         }

         if (l1 <= 31 && l1 > 0 && var38 == Blocks.field_150348_b) {
            replacableBlock[i2] = BlocksDBC.BlockTCFloor;
         }

         if (l1 < 200 && var38 == Blocks.field_150355_j) {
            replacableBlock[i2] = Blocks.field_150350_a;
         }
      }

   }

   public Chunk func_73158_c(int par1, int par2) {
      return this.func_73154_d(par1, par2);
   }

   public Chunk func_73154_d(int par1, int par2) {
      this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
      Block[] ablock = new Block[65536];
      byte[] abyte = new byte[65536];
      this.func_147424_a(par1, par2, ablock);
      this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
      this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
      this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
      this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
      if (this.mapFeaturesEnabled) {
         this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
      }

      Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
      byte[] abyte1 = chunk.func_76605_m();

      for(int k = 0; k < abyte1.length; ++k) {
         abyte1[k] = (byte)this.biomesForGeneration[k].field_76756_M;
      }

      chunk.func_76603_b();
      return chunk;
   }

   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
      this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
      this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
      this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
      this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
      int l = 0;
      int i1 = 0;

      for(int j1 = 0; j1 < 5; ++j1) {
         for(int k1 = 0; k1 < 5; ++k1) {
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            byte b0 = 2;
            BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

            for(int l1 = -b0; l1 <= b0; ++l1) {
               for(int i2 = -b0; i2 <= b0; ++i2) {
                  BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                  float f3 = biomegenbase1.field_76748_D;
                  float f4 = biomegenbase1.field_76749_E;
                  if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
                     f3 = 1.0F + f3 * 2.0F;
                     f4 = 1.0F + f4 * 4.0F;
                  }

                  float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
                  if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
                     f5 /= 2.0F;
                  }

                  f += f4 * f5;
                  f1 += f3 * f5;
                  f2 += f5;
               }
            }

            f /= f2;
            f1 /= f2;
            f = f * 0.9F + 0.1F;
            f1 = (f1 * 4.0F - 1.0F) / 8.0F;
            double d12 = this.noise5[i1] / 8000.0D;
            if (d12 < 0.0D) {
               d12 = -d12 * 0.3D;
            }

            d12 = d12 * 3.0D - 2.0D;
            if (d12 < 0.0D) {
               d12 /= 2.0D;
               if (d12 < -1.0D) {
                  d12 = -1.0D;
               }

               d12 /= 1.4D;
               d12 /= 2.0D;
            } else {
               if (d12 > 1.0D) {
                  d12 = 1.0D;
               }

               d12 /= 8.0D;
            }

            ++i1;
            double d13 = (double)f1;
            double d14 = (double)f;
            d13 += d12 * 0.2D;
            d13 = d13 * 8.5D / 8.0D;
            double d5 = 8.5D + d13 * 4.0D;

            for(int j2 = 0; j2 < 33; ++j2) {
               double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
               if (d6 < 0.0D) {
                  d6 *= 4.0D;
               }

               double d7 = this.noise1[l] / 512.0D;
               double d8 = this.noise2[l] / 512.0D;
               double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
               double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
               if (j2 > 29) {
                  double d11 = (double)((float)(j2 - 29) / 3.0F);
                  d10 = d10 * (1.0D - d11) + -10.0D * d11;
               }

               this.noiseArray[l] = d10;
               ++l;
            }
         }
      }

   }

   public boolean func_73149_a(int par1, int par2) {
      return true;
   }

   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
      BlockFalling.field_149832_M = true;
      int k = par2 * 16;
      int l = par3 * 16;
      this.worldObj.func_72807_a(k + 16, l + 16);
      this.rand.setSeed(this.worldObj.func_72905_C());
      long i1 = this.rand.nextLong() / 2L * 2L + 1L;
      long j1 = this.rand.nextLong() / 2L * 2L + 1L;
      this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.func_72905_C());
      boolean flag = false;
      MinecraftForge.EVENT_BUS.post(new Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
      MinecraftForge.EVENT_BUS.post(new Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
      BlockFalling.field_149832_M = false;
   }

   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
      return true;
   }

   public void func_104112_b() {
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "RandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
      BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
      return par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4) ? this.scatteredFeatureGenerator.func_82667_a() : biomegenbase.func_76747_a(par1EnumCreatureType);
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int par1, int par2) {
      if (this.mapFeaturesEnabled) {
      }

   }

   public ChunkPosition func_147416_a(World world, String arg1, int arg2, int arg3, int arg4) {
      return null;
   }
}
