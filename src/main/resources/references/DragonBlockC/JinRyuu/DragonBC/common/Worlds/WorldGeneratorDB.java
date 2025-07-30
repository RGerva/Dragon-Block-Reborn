package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterJin;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKami;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKarin;
import JinRyuu.DragonBC.common.Npcs.EntityMasterPiccolo;
import JinRyuu.DragonBC.common.Npcs.EntityMasterVegeta;
import JinRyuu.DragonBC.common.Villages.ChkInSt;
import JinRyuu.DragonBC.common.Villages.KiLt;
import JinRyuu.DragonBC.common.Villages.KnTr;
import JinRyuu.DragonBC.common.Villages.SnkWy;
import JinRyuu.DragonBC.common.Villages.TiCha;
import JinRyuu.DragonBC.common.Villages.bs;
import JinRyuu.DragonBC.common.Villages.builds;
import JinRyuu.DragonBC.common.Villages.ca;
import JinRyuu.DragonBC.common.Villages.fs;
import JinRyuu.DragonBC.common.Villages.gh;
import JinRyuu.DragonBC.common.Villages.kh;
import JinRyuu.DragonBC.common.Worlds.structures.StructureGuru;
import JinRyuu.DragonBC.common.Worlds.structures.StructureTOP1;
import JinRyuu.DragonBC.common.Worlds.structures.StructureTOP2;
import JinRyuu.DragonBC.common.Worlds.structures.StructureZenoExpo;
import JinRyuu.JRMCore.JRMCoreComTickH;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.blocks.BlocksJRMC;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorDB implements IWorldGenerator {
   protected WorldGenerator ChkInSt;
   protected WorldGenerator KiLt;
   protected WorldGenerator SnkWy;
   protected WorldGenerator TiCha;
   protected WorldGenerator KnTr;
   protected WorldGenerator WorldGen_TOPArena;
   protected WorldGenerator WorldGen_TOPZeno;
   protected WorldGenerator WorldGen_ZenoExpo;
   public static boolean KiLtSpawn = true;
   public static boolean KiLtTCSpawn = true;
   public static boolean ChkInStSpawn = true;
   public static boolean SnkWySpawn = true;
   public static boolean TiChaSpawn = true;
   public static boolean TiChaKLSpawn = true;
   public static boolean KnTrSpawn = true;
   public static boolean WorldGen_TOPArena_Done = true;
   public static boolean WorldGen_TOPZeno_Done = true;
   public static boolean WorldGen_Zeno_Done = true;
   public static boolean FSSpawn = true;
   public static boolean KHSpawn = true;
   public static boolean CASpawn = true;
   public static boolean GHSpawn = true;
   public static boolean BSSpawn = true;
   public static boolean WorldGen_GuruHouse_Done = true;
   public static builds[] DBbuilds = new builds[]{new ca(), new gh(), new fs(), new bs(), new StructureGuru()};
   public static int[] DBbuildsdim;

   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
      switch(world.field_73011_w.field_76574_g) {
      case -1:
         this.generateNether(world, random, chunkX * 16, chunkZ * 16);
         break;
      case 0:
         this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
         break;
      case 20:
         this.generateNamek(world, random, chunkX * 16, chunkZ * 16);
         break;
      case 22:
         this.generateOW(world, random, chunkX * 16, chunkZ * 16);
         break;
      case 23:
         this.generateTC(world, random, chunkX * 16, chunkZ * 16);
         break;
      case 24:
         this.generateNR(world, random, chunkX * 16, chunkZ * 16);
      }

   }

   private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
      int RPX;
      int RPZ;
      int i;
      if (world.field_73011_w.field_76574_g == 0) {
         for(RPX = 0; RPX < 10; ++RPX) {
            RPZ = BlockX + random.nextInt(16);
            int RPZ = BlockZ + random.nextInt(16);
            i = 10 + random.nextInt(127);
            (new WorldGenMinable(BlocksDBC.BlockOreWrenai, 8)).func_76484_a(world, random, RPZ, i, RPZ);
         }

         if (JRMCoreConfig.BuildingSpawnCheck && world.func_147439_a(86, 216, 50) != BlocksJRMC.BlockColoredStone && KiLtSpawn) {
            KiLtSpawn = false;
            this.KiLt = new KiLt();
            this.KiLt.func_76484_a(world, world.field_73012_v, 0, 0, 0);
            world.func_147465_d(43, 216, 37, BlocksJRMC.BlockColoredStone, 0, 3);
            world.func_147465_d(77, 167, 42, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147449_b(78, 217, 32, BlocksJRMC.stoneSingleSlab);
            world.func_147449_b(76, 217, 32, BlocksJRMC.stoneSingleSlab);
            world.func_147465_d(78, 218, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(78, 219, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(78, 220, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(76, 218, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(76, 219, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(76, 220, 32, Blocks.field_150350_a, 0, 3);
            world.func_147465_d(79, 218, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(79, 219, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(79, 220, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(79, 221, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(75, 218, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(75, 219, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(75, 220, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            world.func_147465_d(75, 221, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            if (world.func_147439_a(80, 134, 34) != BlocksJRMC.BlockFence && KnTrSpawn) {
               KnTrSpawn = false;
               this.KnTr = new KnTr();
               this.KnTr.func_76484_a(world, world.field_73012_v, 0, 0, 0);
               world.func_147465_d(77, 133, 45, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(77, 134, 45, BlocksJRMC.BlockColoredStone, 0, 3);
            }

            if (world.func_147439_a(77, 219, 8) != BlocksDBC.BlockTCPort && KiLtTCSpawn) {
               KiLtTCSpawn = false;
               world.func_147465_d(77, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(77, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(77, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(76, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(76, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(78, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(78, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(78, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(76, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               world.func_147465_d(76, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(77, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(78, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(75, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(75, 219, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(75, 218, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(75, 217, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(79, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(79, 219, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(79, 218, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               world.func_147465_d(79, 217, 8, BlocksJRMC.BlockColoredStone, 0, 3);
            }
         }

         if (JRMCoreConfig.NPCSpawnCheck) {
            AxisAlignedBB par2AxisAlignedBB = AxisAlignedBB.func_72330_a(56.0D, 10.0D, 20.0D, 116.0D, 240.0D, 80.0D);
            List enma = world.func_72872_a(EntityMasterKami.class, par2AxisAlignedBB);
            if (enma.isEmpty()) {
               EntityMasterKami namekian03 = new EntityMasterKami(world);
               namekian03.func_70012_b(86.0D, 217.0D, 50.0D, 0.0F, 0.0F);
               world.func_72838_d(namekian03);
            }

            par2AxisAlignedBB = AxisAlignedBB.func_72330_a(85.0D, 10.0D, 91.0D, 89.0D, 240.0D, 95.0D);
            enma = world.func_72872_a(EntityMasterPiccolo.class, par2AxisAlignedBB);
            if (enma.isEmpty()) {
               EntityMasterPiccolo namekian03 = new EntityMasterPiccolo(world);
               namekian03.func_70012_b(87.0D, 217.0D, 93.0D, 0.0F, 0.0F);
               world.func_72838_d(namekian03);
            }

            par2AxisAlignedBB = AxisAlignedBB.func_72330_a(71.0D, 10.0D, 8.0D, 75.0D, 240.0D, 12.0D);
            enma = world.func_72872_a(EntityMasterVegeta.class, par2AxisAlignedBB);
            if (enma.isEmpty()) {
               EntityMasterVegeta namekian03 = new EntityMasterVegeta(world);
               namekian03.func_70012_b(73.0D, 217.0D, 10.0D, 0.0F, 0.0F);
               world.func_72838_d(namekian03);
            }

            AxisAlignedBB knaabb = AxisAlignedBB.func_72330_a(70.0D, 120.0D, 30.0D, 90.0D, 140.0D, 50.0D);
            List kn = world.func_72872_a(EntityMasterKarin.class, knaabb);
            if (kn.isEmpty()) {
               EntityMasterKarin k = new EntityMasterKarin(world);
               k.func_70012_b(80.0D, 133.0D, 40.0D, 0.0F, 0.0F);
               world.func_72838_d(k);
            }
         }
      }

      RPX = BlockX + random.nextInt(16);
      RPZ = BlockZ + random.nextInt(16);
      int RPY = 62;
      int k;
      if (world.func_72807_a(RPX, RPZ) == BiomeGenBase.field_76771_b || world.func_72807_a(RPX, RPZ) == BiomeGenBase.field_150575_M || DBCH.genKH.length() < 3) {
         boolean may = true;
         if (KHSpawn && world.func_147439_a(RPX, RPY, RPZ) == Blocks.field_150355_j && world.func_147439_a(RPX, RPY + 1, RPZ).func_149688_o() == Material.field_151579_a) {
            k = 62;

            int s;
            for(s = RPY; s > 35; --s) {
               if (s < k) {
                  k = s;
               }

               if (world.func_147439_a(RPX, s, RPZ) != Blocks.field_150355_j) {
                  may = false;
                  break;
               }
            }

            if (may) {
               s = JRMCoreConfig.buildingSpawnAreaSize;
               int s2 = 30;
               AxisAlignedBB ab = AxisAlignedBB.func_72330_a((double)RPX - (double)s, 64.0D, (double)RPZ - (double)s, (double)RPX + (double)s, (double)(63 + s > 200 ? 200 : 63 + s), (double)RPZ + (double)s);
               List list = world.func_147461_a(ab);
               boolean bo = true;

               for(int i1 = 0; i1 < 8 && bo; ++i1) {
                  bo = world.func_72807_a(RPX + (i1 != 0 && i1 != 2 && i1 != 6 ? (i1 != 4 && i1 != 5 ? -s * 2 : 0) : s * 2), RPZ + (i1 != 0 && i1 != 1 && i1 != 5 ? (i1 != 6 && i1 != 7 ? -s * 2 : 0) : s * 2)) == BiomeGenBase.field_76771_b || world.func_72807_a(RPX + (i1 != 0 && i1 != 2 && i1 != 6 ? (i1 != 4 && i1 != 5 ? -s * 2 : 0) : s * 2), RPZ + (i1 != 0 && i1 != 1 && i1 != 5 ? (i1 != 6 && i1 != 7 ? -s * 2 : 0) : s * 2)) == BiomeGenBase.field_150575_M;
               }

               if (list.size() == 0 && bo && DBCH.khrwi(FMLCommonHandler.instance().getMinecraftServerInstance()).length() < 3) {
                  KHSpawn = false;
                  String d = RPX + ";" + (RPY + 1) + ";" + RPZ;
                  MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                  DBCH.khwwi(server, d, false);
                  DBCH.genKH = d;
                  WorldGenerator kh = new kh();
                  kh.func_76484_a(world, random, RPX - s2, RPY - 3, RPZ - s2);
                  int cur = server.func_71233_x();

                  for(int pl = 0; pl < cur; ++pl) {
                     EntityPlayerMP p = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                     String t1 = JRMCoreH.cly + JRMCoreH.trl("dbc.worldgen.buildings.beenfound");
                     String t2 = JRMCoreH.cly + JRMCoreH.trl("dbc.com.loc.kame");
                     String tf = String.format(t1, t2);
                     p.func_145747_a(new ChatComponentText(JRMCoreH.cly + tf));
                  }
               }
            }
         }
      }

      int num = random.nextInt(15);
      int buildingID = 1;
      if (this.DBbuildsSpawn(buildingID) && num == 0) {
         i = BlockX + random.nextInt(16);
         k = BlockZ + random.nextInt(16);
         this.buildingSpawn(world, random, i, k, buildingID, BiomeGenBase.field_76772_c, WorldGeneratorDB.Type.NORMAL);
      }

      buildingID = 0;
      if (this.DBbuildsSpawn(buildingID) && num == 1) {
         i = BlockX + random.nextInt(16);
         k = BlockZ + random.nextInt(16);
         this.buildingSpawn(world, random, i, k, buildingID, BiomeGenBase.field_76772_c, WorldGeneratorDB.Type.NORMAL);
      }

      buildingID = 3;
      if (this.DBbuildsSpawn(buildingID) && num == 3) {
         i = BlockX + random.nextInt(16);
         k = BlockZ + random.nextInt(16);
         this.buildingSpawn(world, random, i, k, buildingID, BiomeGenBase.field_76772_c, WorldGeneratorDB.Type.UNDER);
      }

   }

   public static String DBbuildsNams(int i) {
      if (i == 0) {
         return DBCH.ca;
      } else if (i == 1) {
         return DBCH.gh;
      } else if (i == 2) {
         return DBCH.fs;
      } else if (i == 3) {
         return DBCH.bs;
      } else {
         return i == 4 ? DBCH.guruh : "";
      }
   }

   public static String DBbuildsNams2(int i) {
      if (i == 0) {
         return "dbc.com.loc.cell";
      } else if (i == 1) {
         return "dbc.com.loc.goku";
      } else if (i == 2) {
         return "dbc.com.loc.freeza";
      } else if (i == 3) {
         return "dbc.com.loc.babidi";
      } else {
         return i == 4 ? "dbc.com.loc.guruhouse" : "";
      }
   }

   public static String DBbuildsGen(int i) {
      if (i == 0) {
         DBCH.genCA = DBCH.carwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genCA;
      } else if (i == 1) {
         DBCH.genGH = DBCH.ghrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genGH;
      } else if (i == 2) {
         DBCH.genFS = DBCH.fsrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genFS;
      } else if (i == 3) {
         DBCH.genBS = DBCH.bsrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genBS;
      } else if (i == 4) {
         DBCH.genGuru = DBCH.guruhrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genGuru;
      } else {
         return "";
      }
   }

   public static void DBbuildsGen(int i, String d) {
      if (i == 0) {
         DBCH.genCA = d;
         DBCH.cawwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false);
      } else if (i == 1) {
         DBCH.genGH = d;
         DBCH.ghwwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false);
      } else if (i == 2) {
         DBCH.genFS = d;
         DBCH.fswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false);
      } else if (i == 3) {
         DBCH.genBS = d;
         DBCH.bswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false);
      } else if (i == 4) {
         DBCH.genGuru = d;
         DBCH.guruhwwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false);
      }

   }

   public boolean DBbuildsSpawn(int i) {
      if (i == 0) {
         return CASpawn;
      } else if (i == 1) {
         return GHSpawn;
      } else if (i == 2) {
         return FSSpawn;
      } else if (i == 3) {
         return BSSpawn;
      } else {
         return i == 4 ? WorldGen_GuruHouse_Done : false;
      }
   }

   public static void DBbuildsSpawn(int i, boolean d) {
      if (i == 0) {
         CASpawn = d;
      } else if (i == 1) {
         GHSpawn = d;
      } else if (i == 2) {
         FSSpawn = d;
      } else if (i == 3) {
         BSSpawn = d;
      } else if (i == 4) {
         WorldGen_GuruHouse_Done = d;
      }

   }

   public void buildingSpawn(World world, Random random, int i, int k, int gen, BiomeGenBase biome, WorldGeneratorDB.Type type) {
      if (this.DBbuildsSpawn(gen) && world.field_73011_w.field_76574_g == DBbuildsdim[gen] && world.func_72807_a(i, k) == biome) {
         if (world.func_147439_a(86, 216, 50) == BlocksJRMC.BlockColoredStone) {
         }

         String bg = DBbuildsGen(gen);
         if (bg.length() > 2) {
            DBbuildsSpawn(gen, false);
         } else if (bg.length() == 1) {
            builds v = DBbuilds[gen];
            int s = JRMCoreConfig.buildingSpawnAreaSize;
            boolean bo = JRMCoreHDBC.checkForBuildsAound(world, i, k, s);

            int j;
            for(j = 0; j < 5; ++j) {
               if (world.func_72807_a(i + (j != 0 && j != 1 ? builds.SizeX : 0), k + (j != 0 && j != 2 ? builds.SizeZ : 0)) != biome) {
                  bo = false;
                  break;
               }
            }

            if (bo) {
               j = world.func_72976_f(i, k);
               if (j > 67) {
                  int j2;
                  for(j2 = 0; j2 < 5; ++j2) {
                     int j2 = world.func_72976_f(i + (j2 != 0 && j2 != 1 ? builds.SizeX : 0), k + (j2 != 0 && j2 != 2 ? builds.SizeZ : 0));
                     if (world.func_147439_a(i + (j2 != 0 && j2 != 1 ? builds.SizeX : 0), j2 - 1, k + (j2 != 0 && j2 != 2 ? builds.SizeZ : 0)) == Blocks.field_150355_j) {
                        bo = false;
                        break;
                     }
                  }

                  if (bo && type == WorldGeneratorDB.Type.UNDER) {
                     j2 = world.func_72976_f(i + builds.SizeX / 2, k + builds.SizeZ / 2);
                     if (world.func_147439_a(i + builds.SizeX / 2, j2, k + builds.SizeZ / 2) == Blocks.field_150355_j || j2 < 60) {
                        bo = false;
                     }

                     j = j2 - builds.SizeY;
                  }

                  if (bo) {
                     DBbuildsSpawn(gen, true);
                     String d = i + ";" + j + ";" + k;
                     DBbuildsGen(gen, d);
                     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                     int cur = server.func_71233_x();

                     for(int pl = 0; pl < cur; ++pl) {
                        EntityPlayerMP p = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                        String t1 = JRMCoreH.cly + JRMCoreH.trl("dbc.worldgen.buildings.beenfound");
                        String t2 = JRMCoreH.cly + JRMCoreH.trl(DBbuildsNams(gen));
                        String tf = String.format(t1, t2);
                        p.func_145747_a(new ChatComponentText(JRMCoreH.cly + tf));
                     }

                     v.setWorld(world);
                     JRMCoreComTickH.bldngsChecker = 300;
                     JRMCoreComTickH.bldngChkr = true;
                  }
               }
            }
         }
      }

   }

   private void generateNether(World world, Random random, int i, int j) {
   }

   private void generateNamek(World world, Random random, int BlockX, int BlockZ) {
      if (world.field_73011_w.field_76574_g == DBCConfig.planetNamek) {
         int buildingID = 2;
         int i;
         int k;
         if (this.DBbuildsSpawn(buildingID)) {
            i = BlockX + random.nextInt(16);
            k = BlockZ + random.nextInt(16);
            this.buildingSpawn(world, random, i, k, buildingID, BiomeGenBaseDBC.Namek, WorldGeneratorDB.Type.NORMAL);
         }

         buildingID = 4;
         if (this.DBbuildsSpawn(buildingID)) {
            i = BlockX + random.nextInt(16);
            k = BlockZ + random.nextInt(16);
            this.buildingSpawn(world, random, i, k, buildingID, BiomeGenBaseDBC.Namek, WorldGeneratorDB.Type.NORMAL);
         }

         for(int x = 0; x < 10; ++x) {
            int RPX = BlockX + random.nextInt(16);
            int RPZ = BlockZ + random.nextInt(16);
            int RPY = 10 + random.nextInt(127);
            (new WorldGenMinable(BlocksDBC.BlockOreWrenai, 6)).func_76484_a(world, random, RPX, RPY, RPZ);
         }
      }

   }

   private void generateNR(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
      if (w.field_73011_w.field_76574_g == 24 && JRMCoreConfig.BuildingSpawnCheck) {
         if (w.func_147439_a(179, 136, 71) != BlocksDBC.BlockKachiKachin[4] && WorldGen_TOPZeno_Done) {
            WorldGen_TOPZeno_Done = false;
            this.WorldGen_TOPZeno = new StructureTOP2();
            this.WorldGen_TOPZeno.func_76484_a(w, w.field_73012_v, 0, 0, 0);
         }

         if (w.func_147439_a(6, 135, 70) != BlocksDBC.BlockKachiKachin[1] && WorldGen_TOPArena_Done) {
            WorldGen_TOPArena_Done = false;
            this.WorldGen_TOPArena = new StructureTOP1();
            this.WorldGen_TOPArena.func_76484_a(w, w.field_73012_v, 0, 0, 0);
         }

         if (w.func_147439_a(386, 55, 87) != BlocksDBC.BlockKachiKachin[4] && WorldGen_Zeno_Done) {
            WorldGen_Zeno_Done = false;
            this.WorldGen_ZenoExpo = new StructureZenoExpo();
            this.WorldGen_ZenoExpo.func_76484_a(w, w.field_73012_v, 0, 0, 0);
         }
      }

   }

   private void generateTC(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
      if (w.field_73011_w.field_76574_g == 23 && JRMCoreConfig.BuildingSpawnCheck && w.func_147439_a(55, 34, 8) != BlocksJRMC.BlockColoredStone && TiChaSpawn) {
         TiChaSpawn = false;
         this.TiCha = new TiCha();
         this.TiCha.func_76484_a(w, w.field_73012_v, 0, 0, 0);
         if (w.func_147439_a(53, 37, 8) != BlocksDBC.BlockTCPort && TiChaKLSpawn) {
            TiChaKLSpawn = false;
            w.func_147465_d(54, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(55, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(54, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(55, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(53, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(53, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(53, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(54, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
            w.func_147465_d(55, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
         }
      }

   }

   private void generateOW(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
      if (w.field_73011_w.field_76574_g == 22) {
         int k;
         int firstBlockXCoord;
         int firstBlockYCoord;
         int firstBlockZCoord;
         for(k = 0; k < 10; ++k) {
            firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
            firstBlockYCoord = randomGenerator.nextInt(40);
            firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreJJay, 12)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
         }

         for(k = 0; k < 10; ++k) {
            firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
            firstBlockYCoord = randomGenerator.nextInt(40);
            firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreDlog, 8)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
         }

         for(k = 0; k < 10; ++k) {
            firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
            firstBlockYCoord = randomGenerator.nextInt(40);
            firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreLehnori, 8)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
         }

         for(k = 0; k < 10; ++k) {
            firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
            firstBlockYCoord = randomGenerator.nextInt(40);
            firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreDnomaid, 7, Blocks.field_150353_l)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
         }

         if (JRMCoreConfig.BuildingSpawnCheck) {
            if (w.func_147439_a(75, 90, 127) != BlocksJRMC.BlockColoredStone && ChkInStSpawn) {
               ChkInStSpawn = false;
               this.ChkInSt = new ChkInSt();
               this.ChkInSt.func_76484_a(w, w.field_73012_v, 0, 0, 0);
            }

            if (w.func_147439_a(75, 90, -5) != BlocksJRMC.BlockColoredStone && SnkWySpawn) {
               SnkWySpawn = false;
               this.SnkWy = new SnkWy();
               this.SnkWy.func_76484_a(w, w.field_73012_v, 0, 0, 0);
            }
         }

         if (JRMCoreConfig.NPCSpawnCheck) {
            AxisAlignedBB par2AxisAlignedBB = AxisAlignedBB.func_72330_a(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
            List enma = w.func_72872_a(EntityMasterEnma.class, par2AxisAlignedBB);
            if (enma.isEmpty()) {
               EntityMasterEnma namekian03 = new EntityMasterEnma(w);
               namekian03.func_70012_b(75.0D, 91.0D, 53.0D, 0.0F, 0.0F);
               w.func_72838_d(namekian03);
            }

            AxisAlignedBB aabbkaio = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
            List kaio = w.func_72872_a(EntityMasterKaio.class, aabbkaio);
            if (kaio.isEmpty()) {
               EntityMasterKaio namekian03 = new EntityMasterKaio(w);
               namekian03.func_70012_b(107.0D, 116.0D, -3719.0D, 0.0F, 0.0F);
               w.func_72838_d(namekian03);
            }

            AxisAlignedBB aabbjin = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3742.0D, 127.0D, 140.0D, -3702.0D);
            List jin = w.func_72872_a(EntityMasterJin.class, aabbjin);
            if (jin.isEmpty()) {
               EntityMasterJin namekian03 = new EntityMasterJin(w);
               namekian03.func_70012_b(107.0D, 116.0D, -3722.0D, 0.0F, 0.0F);
               w.func_72838_d(namekian03);
            }
         }
      }

   }

   static {
      DBbuildsdim = new int[]{0, 0, DBCConfig.planetNamek, 0, DBCConfig.planetNamek};
   }

   public static enum Type {
      NORMAL,
      UNDER,
      WATER;
   }
}
