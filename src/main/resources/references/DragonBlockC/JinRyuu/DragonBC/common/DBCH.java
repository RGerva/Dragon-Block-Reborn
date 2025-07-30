package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPduo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DBCH {
   public static String genKH = "";
   public static String genCA = "";
   public static String genGH = "";
   public static String genFS = "";
   public static String genGuru = "";
   public static String genBS = "";
   public static int[] genKHnpc1 = new int[]{-5, 0, -18};
   public static int[] genCAnpc1 = new int[]{2, 2, 10};
   public static int[] genGHnpc1 = new int[]{8, 1, 31};
   public static int[] genGHnpc2 = new int[]{10, 1, 8};
   public static int[] genFSnpc1 = new int[]{2, 1, 15};
   public static int[] genBSnpc1 = new int[]{14, 1, 20};
   public static int[] genGurunpc1 = new int[]{9, 5, 10};
   public static String wi = "wi.dbc";
   public static String kh = "KameHouse";
   public static String khn1 = "KameHouseNPC1";
   public static String ca = "CellArena";
   public static String can1 = "CellArenaNPC1";
   public static String gh = "GokuHouse";
   public static String ghn1 = "GokuHouseNPC1";
   public static String fs = "FreizaShip";
   public static String fsn1 = "FreizaShipNPC1";
   public static String bs = "BabidiShip";
   public static String guruh = "GuruHouse";
   public static boolean HTCtrain = false;
   public static int KPminX = 75;
   public static int KPminY = 110;
   public static int KPminZ = -3757;
   public static int KPmaxX = 132;
   public static int KPmaxY = 150;
   public static int KPmaxZ = -3702;
   public static int[] Kami = new int[]{86, 217, 50, 0};
   public static int[] Karn = new int[]{80, 133, 40, 0};
   public static int[] Enma = new int[]{75, 91, 53, 0};
   public static int[] KaiO = new int[]{107, 116, -3719, 0};
   public static int[] TrnksF = new int[]{72, 217, 27, 0};
   public static int[] Jin = new int[]{107, 116, -3722, 0};
   public static int[] Whis1 = new int[]{69, 217, 60, 0};
   public static int[] Whis2 = new int[]{6, 135, 70, 0};
   public static float RotYaw = 0.0F;
   public static float RotPic = 0.0F;
   public static int cbge = 0;
   public static int planetEarth = 0;
   public static int planetNamek = 20;
   public static int planetVegeta = 21;
   public static int otherWorld = 22;
   public static int dimTimeChamber = 23;
   public static int dimNullRealm = 24;
   public static HashMap<Integer, String> plntNms = new HashMap();
   public static ArrayList<String> wishS = new ArrayList();
   public static ArrayList<String> wishP = new ArrayList();
   public static int mult = 1;

   public static void wwi(MinecraftServer server, String d, String rid, boolean b) {
      String wd = "/data";
      JRMCoreH.wd(server, d, rid + "", wd, wi, b);
   }

   public static String rwi(MinecraftServer server, String id) {
      String wd = "/data";
      return JRMCoreH.rd(server, id + "", wd, wi);
   }

   public static void khwwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, kh, b);
   }

   public static String khrwi(MinecraftServer server) {
      return rwi(server, kh);
   }

   public static void khn1wwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, khn1, b);
   }

   public static String khn1rwi(MinecraftServer server) {
      return rwi(server, khn1);
   }

   public static void cawwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, ca, b);
   }

   public static String carwi(MinecraftServer server) {
      return rwi(server, ca);
   }

   public static void can1wwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, can1, b);
   }

   public static String can1rwi(MinecraftServer server) {
      return rwi(server, can1);
   }

   public static void ghwwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, gh, b);
   }

   public static String ghrwi(MinecraftServer server) {
      return rwi(server, gh);
   }

   public static void ghn1wwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, ghn1, b);
   }

   public static String ghn1rwi(MinecraftServer server) {
      return rwi(server, ghn1);
   }

   public static void fswwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, fs, b);
   }

   public static String fsrwi(MinecraftServer server) {
      return rwi(server, fs);
   }

   public static void fsn1wwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, fsn1, b);
   }

   public static String fsn1rwi(MinecraftServer server) {
      return rwi(server, fsn1);
   }

   public static void bswwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, bs, b);
   }

   public static String bsrwi(MinecraftServer server) {
      return rwi(server, bs);
   }

   public static void guruhwwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, guruh, b);
   }

   public static String guruhrwi(MinecraftServer server) {
      return rwi(server, guruh);
   }

   public static boolean mvng() {
      float p = DBCClient.mc.field_71439_g.field_70125_A < 0.0F ? (float)((int)DBCClient.mc.field_71439_g.field_70125_A * -1) : (float)((int)DBCClient.mc.field_71439_g.field_70125_A);
      float y = DBCClient.mc.field_71439_g.field_70177_z < 0.0F ? (float)((int)DBCClient.mc.field_71439_g.field_70177_z * -1) : (float)((int)DBCClient.mc.field_71439_g.field_70177_z);
      boolean var10000;
      if (p > RotPic && p > RotPic + 0.1F || p < RotPic && p < RotPic - 0.1F || y > RotYaw && y > RotYaw + 0.1F || y < RotYaw && y < RotYaw - 0.1F) {
         var10000 = true;
      } else {
         var10000 = false;
      }

      return DBCClient.mc.field_71439_g.field_70159_w > 0.005D || DBCClient.mc.field_71439_g.field_70179_y > 0.005D || DBCClient.mc.field_71439_g.field_70159_w < -0.005D || DBCClient.mc.field_71439_g.field_70179_y < -0.005D || DBCClient.mc.field_71439_g.field_70181_x > 0.005D;
   }

   public static boolean lkng() {
      float p = DBCClient.mc.field_71439_g.field_70125_A < 0.0F ? (float)((int)DBCClient.mc.field_71439_g.field_70125_A * -1) : (float)((int)DBCClient.mc.field_71439_g.field_70125_A);
      float y = DBCClient.mc.field_71439_g.field_70177_z < 0.0F ? (float)((int)DBCClient.mc.field_71439_g.field_70177_z * -1) : (float)((int)DBCClient.mc.field_71439_g.field_70177_z);
      boolean rotat = p > RotPic && p > RotPic + 0.1F || p < RotPic && p < RotPic - 0.1F || y > RotYaw && y > RotYaw + 0.1F || y < RotYaw && y < RotYaw - 0.1F;
      return rotat;
   }

   public static void dbcWish(int id, EntityPlayer p) {
   }

   public static void DBCDeath(EntityPlayer Player) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      byte d;
      if (!mod_DragonBC.DeathSystemOff) {
         d = JRMCoreH.getByte(Player, "jrmcAlv");
         if (d != 1) {
            JRMCoreH.setByte(1, Player, "jrmcAlv");
            JRMCoreH.setInt(DBCConfig.RevTm, Player, "jrmcReviveTmer");
         }
      }

      if (Player != null) {
         JRMCoreH.setInt(0, Player, "jrmcAlCntr");
         mod_DragonBC.logger.info(Player.func_70005_c_() + " has died");
         d = JRMCoreH.getByte(Player, "jrmcDiff");
         byte pwr = JRMCoreH.getByte(Player, "jrmcPwrtyp");
         byte rc = JRMCoreH.getByte(Player, "jrmcRace");
         byte cl = JRMCoreH.getByte(Player, "jrmcClass");
         byte st = JRMCoreH.getByte(Player, "jrmcState");
         JRMCoreH.setByte(rc == 4 ? (st > 4 ? 4 : st) : 0, Player, "jrmcState");
         JRMCoreH.setByte(0, Player, "jrmcState2");
         String ste = JRMCoreH.getString(Player, "jrmcStatusEff");
         if (!JRMCoreH.StusEfcts(9, ste) && !JRMCoreH.StusEfcts(2, ste) && !JRMCoreH.StusEfcts(6, ste) && !JRMCoreH.StusEfcts(21, ste)) {
            JRMCoreH.setString(" ", Player, "jrmcStatusEff");
         } else {
            String s = "";
            JRMCoreH.StusEfcts(9, s, Player, JRMCoreH.StusEfcts(9, ste));
            JRMCoreH.StusEfcts(2, s, Player, JRMCoreH.StusEfcts(2, ste));
            JRMCoreH.StusEfcts(6, s, Player, JRMCoreH.StusEfcts(6, ste));
            JRMCoreH.StusEfcts(21, s, Player, JRMCoreH.StusEfcts(21, ste));
         }

         JRMCoreH.setInt(0, Player, "jrmcHar4va");
         JRMCoreH.setString("0,0,0+0", Player, "jrmcMajinAbsorptionData");
         if (d > 0 && pwr == 1) {
            for(int i1 = 0; i1 < d; ++i1) {
               for(int i = 0; i < 2; ++i) {
                  int r;
                  int atr;
                  int atrs;
                  for(r = 0; r < 20; ++r) {
                     atr = (new Random()).nextInt(6);
                     atrs = JRMCoreH.getInt(Player, JRMCoreH.AttrbtNbtI[atr]);
                     int atrs = JRMCoreH.attributeStart(pwr, atr, rc, cl);
                     if (atrs > atrs) {
                        mod_DragonBC.logger.info("Because of death, " + Player.func_70005_c_() + " also lost a " + JRMCoreH.attrNms(pwr, atr) + " point.");
                        break;
                     }
                  }

                  for(r = 0; r < 6; ++r) {
                     atr = JRMCoreH.getInt(Player, JRMCoreH.AttrbtNbtI[r]);
                     atrs = JRMCoreH.attributeStart(pwr, r, rc, cl);
                     if (atr < atrs) {
                        JRMCoreH.setInt(atrs, Player, JRMCoreH.AttrbtNbtI[r]);
                     }
                  }
               }
            }
         }
      }

   }

   public static void DBCUpdate(EntityPlayer Player) {
   }

   public static void dragonSum(Entity e) {
      double x = e.field_70165_t;
      double y = e.field_70163_u;
      double z = e.field_70161_v;
      int r = 100;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(x - (double)r, y - (double)r, z - (double)r, x + (double)r, y + (double)r, z + (double)r);
      List lst = e.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
      if (!lst.isEmpty()) {
         JRMCoreHDBC.dragonSum = 100;
      }

   }

   public static String NpcSpawnLoc(int x, int y, int z, World w) {
      int k = 0;

      label33:
      for(int i = 3; i < 6; ++i) {
         for(int j2 = 0; j2 < 6; ++j2) {
            for(int j = y + 5; j > 1; --j) {
               if (w.func_147437_c(x + i, j, z + j2) && !w.func_147437_c(x + i, j - 1, z + j2)) {
                  x += i;
                  y = j;
                  z += j2;
                  int var9 = k + 1;
                  break label33;
               }
            }
         }
      }

      double X = (double)x + 0.5D;
      double Z = (double)z + 0.5D;
      return X + ";" + y + ";" + Z;
   }

   public static void DBSpawn(EntityPlayer player, long wt) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      if (mod_DragonBC.DBSpawnEnabled) {
         int m = 48;
         int t = DBTime("morning") ? 1 : (DBTime("evening") ? 11996 : 6001);
         if (wt == (long)t) {
            int did = player.field_71093_bK;
            Random ran = new Random();
            int rate = did == DBCConfig.planetEarth ? DBCConfig.eDBrate : (did == DBCConfig.planetNamek ? DBCConfig.nDBrate : 10);
            int r = ran.nextInt(rate);
            if (r == 0) {
               Block dbs = did == DBCConfig.planetEarth ? BlocksDBC.BlockDragonBallStone : (did == DBCConfig.planetNamek ? BlocksDBC.BlockNamekDragonBallStone : null);
               Block db = did == DBCConfig.planetEarth ? BlocksDBC.BlockDragonBall : (did == DBCConfig.planetNamek ? BlocksDBC.BlockNamekDragonBall : null);
               Block blockID = null;
               int dbnum = 0;
               int l1 = MathHelper.func_76128_c(player.field_70165_t);
               int i11 = MathHelper.func_76128_c(player.field_70161_v);

               int i;
               int k;
               int j;
               for(i = l1 - m; i <= l1 + m; ++i) {
                  for(k = i11 - m; k <= i11 + m; ++k) {
                     for(j = 109; j >= 64; --j) {
                        if (player.field_70170_p.func_147439_a(i, j, k) == db) {
                           ++dbnum;
                        }

                        if (player.field_70170_p.func_147439_a(i, j, k) == dbs) {
                           ++dbnum;
                        }
                     }
                  }
               }

               i = MathHelper.func_76128_c(player.field_70165_t + (double)player.field_70170_p.field_73012_v.nextInt(m) + (double)(player.field_70170_p.field_73012_v.nextInt(m) * -1));
               k = MathHelper.func_76128_c(player.field_70161_v + (double)player.field_70170_p.field_73012_v.nextInt(m) + (double)(player.field_70170_p.field_73012_v.nextInt(m) * -1));

               for(j = 109; j >= 64; --j) {
                  if (!player.field_70170_p.func_147437_c(i, j, k) && player.field_70170_p.func_147439_a(i, j, k) != dbs && player.field_70170_p.func_147439_a(i, j, k) != db && (player.field_70170_p.func_147439_a(i, j, k) == Blocks.field_150349_c || player.field_70170_p.func_147439_a(i, j, k) == Blocks.field_150354_m || player.field_70170_p.func_147439_a(i, j, k) == BlocksDBC.BlockNamekGrass)) {
                     mod_DragonBC var10001 = mod_DragonBC.instance;
                     if (dbnum < mod_DragonBC.DBSpawnChance) {
                        player.field_70170_p.func_147465_d(i, j + 1, k, dbs, 0, 3);
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   private static boolean DBTime(String s) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      return mod_DragonBC.DBSpawnTime.contains(s);
   }

   public static void packDuo(int t, int i) {
      PD.sendToServer(new DBCPduo(t, i));
   }

   public static void plntNmsInit() {
      plntNms.put(DBCConfig.planetEarth, "Earth");
      plntNms.put(DBCConfig.planetNamek, "Namek");
      plntNms.put(DBCConfig.planetVegeta, "Vegeta");
      plntNms.put(DBCConfig.otherWorld, "OtherWorld");
      plntNms.put(DBCConfig.dimTimeChamber, "TimeChamber");
      plntNms.put(DBCConfig.dimNullRealm, "Null Realm");
   }

   public static void wishInit() {
      wishS.add("minecraft:diamond;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemWarenai;+;" + 5 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemSenzu;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemKatchin;+;" + 1 * mult + ";+;0");
      wishS.add("revive");
      wishS.add("reviventp");
      wishS.add("reviveall");
      wishS.add("kicolor");
      wishS.add("arcultformcolor");
      if (JRMCoreH.JYC()) {
         wishS.add("young");
         wishS.add("child");
         wishS.add("old");
      }

      wishS.add("jinryuudragonblockc:ItemJanembaEssence;+;" + 5 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemSmallClub;+;" + 1 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemEvilSpear;+;" + 1 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemPP;+;" + 1 * mult + ";+;0");
      wishP.add("minecraft:diamond;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemWarenai;+;" + 5 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemSenzu;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemKatchin;+;" + 1 * mult + ";+;0");
      wishP.add("revive");
      wishP.add("reviventp");
      wishP.add("kicolor");
      wishP.add("arcultformcolor");
      if (JRMCoreH.JYC()) {
         wishP.add("young");
         wishP.add("child");
         wishP.add("old");
      }

      wishP.add("jinryuudragonblockc:ItemJanembaEssence;+;" + 5 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemSmallClub;+;" + 1 * mult + ";+;0");
   }

   public static void toDrop(int o, LivingDropsEvent e) {
      Entity mob = e.entityLiving;
      int r = e.entityLiving.field_70170_p.field_73012_v.nextInt(100);
      Item[] i = r < 5 ? ItemsDBC.ItemsOutfit1 : (r < 10 ? ItemsDBC.ItemsOutfit2 : (r < 15 ? ItemsDBC.ItemsOutfit3 : ItemsDBC.ItemsOutfit0));
      ItemStack stack = new ItemStack(i[o], 1, 1);
      if (r < 20 && stack != null && stack.field_77994_a != 0 && stack.func_77973_b() != null) {
         EntityItem entityitem = new EntityItem(mob.field_70170_p, mob.field_70165_t, mob.field_70163_u, mob.field_70161_v, stack);
         entityitem.field_145804_b = 10;
         e.drops.add(entityitem);
      }

   }

   public static void onEventDrop(LivingDropsEvent e) {
      if (e.entityLiving instanceof EntityCyborg16) {
         toDrop(0, e);
      }

      if (e.entityLiving instanceof EntityCyborg17) {
         toDrop(1, e);
      }

      if (e.entityLiving instanceof EntityCyborg18) {
         toDrop(2, e);
      }

      if (e.entityLiving instanceof EntityCyborg19) {
         toDrop(3, e);
      }

      if (e.entityLiving instanceof EntityCyborg20) {
         toDrop(4, e);
      }

      if (e.entityLiving instanceof EntityDarbura) {
         toDrop(5, e);
      }

      if (e.entityLiving instanceof EntityBuuFat) {
         toDrop(6, e);
      }

      if (e.entityLiving instanceof EntityBuuSuper) {
         toDrop(7, e);
      }

   }
}
