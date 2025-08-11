package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Villages.builds;
import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreSafe;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.StatCollector;

public class ComRespCon extends CommandBase {
   public String func_71517_b() {
      return "dbcbuildings";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length <= 0) {
         throw new WrongUsageException("/dbcbuildings (respawn)", new Object[0]);
      } else {
         String s = par2ArrayOfStr[0];
         boolean respawn = s.toLowerCase().contentEquals("respawn");
         boolean reset = s.toLowerCase().contentEquals("reset");
         s = "";
         if (reset && par2ArrayOfStr.length > 1) {
            s = par2ArrayOfStr[1];
         } else {
            reset = false;
         }

         EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
         JRMCoreSafe safe = new JRMCoreSafe(entityplayermp.world);
         if (!respawn && !reset) {
            throw new WrongUsageException("Buildings Respawn failure", new Object[0]);
         } else {
            safe.saveSpawnList("false ", safe.OWDataDir, "edp.dbc");
            safe.saveSpawnList("false ", safe.OWDataDir, "swk.dbc");
            safe.saveSpawnList("false ", safe.dataDir, "kl.dbc");
            JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
            int[] ClAr = new int[3];
            if (DBCH.genCA.contains(";")) {
               for(int i = 0; i < 3; ++i) {
                  ClAr[i] = Integer.parseInt(DBCH.genCA.split(";")[i]);
               }
            }

            int[] Gkhs = new int[3];
            if (DBCH.genGH.contains(";")) {
               for(int i = 0; i < 3; ++i) {
                  Gkhs[i] = Integer.parseInt(DBCH.genGH.split(";")[i]);
               }
            }

            int[] FzSp = new int[3];
            if (DBCH.genFS.contains(";")) {
               for(int i = 0; i < 3; ++i) {
                  FzSp[i] = Integer.parseInt(DBCH.genFS.split(";")[i]);
               }
            }

            int[] BS = new int[3];
            if (DBCH.genBS.contains(";")) {
               for(int i = 0; i < 3; ++i) {
                  BS[i] = Integer.parseInt(DBCH.genBS.split(";")[i]);
               }
            }

            int[] GURU = new int[3];
            if (DBCH.genGuru.contains(";")) {
               for(int i = 0; i < 3; ++i) {
                  GURU[i] = Integer.parseInt(DBCH.genGuru.split(";")[i]);
               }
            }

            int[][] ps = new int[][]{ClAr, Gkhs, FzSp, BS, GURU};

            for(int i = 0; i < ps.length; ++i) {
               int[] npc = ps[i];
               if (WorldGeneratorDB.DBbuildsdim[i] == entityplayermp.field_71093_bK && npc.length > 2) {
                  builds v = WorldGeneratorDB.DBbuilds[i];
                  v.setWorld(entityplayermp.world);
                  v.setRespawn(true);
                  int buildingID = -1;
                  if (!respawn && reset && s.equals("babidi") && i == 3) {
                     buildingID = 3;
                     int j2 = entityplayermp.world.func_72976_f(npc[0] + builds.SizeX / 2, npc[2] + builds.SizeZ / 2);
                     npc[1] = j2 - builds.SizeY;
                  }

                  if (npc[0] != 0 || npc[1] != 0 || npc[2] != 0) {
                     if (buildingID > -1) {
                        WorldGeneratorDB.DBbuildsSpawn(buildingID, true);
                        String d = npc[0] + ";" + npc[1] + ";" + npc[2];
                        WorldGeneratorDB.DBbuildsGen(buildingID, d);
                     }

                     v.func_76484_a(entityplayermp.world, entityplayermp.world.field_73012_v, npc[0], npc[1], npc[2]);
                     this.notifyAdmins(par1ICommandSender, StatCollector.func_74838_a(WorldGeneratorDB.DBbuildsNams2(i)) + " has been respawned.", new Object[0]);
                  }
               }
            }

            JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
            JRMCoreHDBC.DBCCommonTickHandlerNPCSpawnCheck(entityplayermp);
            this.notifyAdmins(par1ICommandSender, "Buildings Respawn was Set. Now you must go close to a new chunk to activate it.", new Object[]{entityplayermp.getName()});
         }
      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "/dbcbuildings (respawn)";
   }
}
