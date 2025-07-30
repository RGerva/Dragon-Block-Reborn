package JinRyuu.JRMCore;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.client.notification.JGNotification;
import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
import JinRyuu.JRMCore.client.notification.JGNotificationHandlerC;
import JinRyuu.JRMCore.entity.EntityCusPar;
import JinRyuu.JRMCore.entity.EntityJRMCexpl;
import JinRyuu.JRMCore.entity.ExplosionJRMC;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
import JinRyuu.JRMCore.server.config.core.JGConfigSkills;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class JRMCorePacHanC {
   public double explosionX;
   public double explosionY;
   public double explosionZ;
   public float explosionSize;
   public List chunkPositionRecords;
   public float playerVelocityX;
   public float playerVelocityY;
   public float playerVelocityZ;
   public boolean expGriOff;
   public double expDam;
   public Entity origin;
   public byte type;

   public void handleExpl(double explosionX, double explosionY, double explosionZ, float explosionSize, boolean expGriOff, double expDam, Entity origin, List chunkPositionRecords, float playerVelocityX, float playerVelocityY, float playerVelocityZ, EntityPlayer p, byte type) {
      this.explosionX = explosionX;
      this.explosionY = explosionY;
      this.explosionZ = explosionZ;
      this.explosionSize = explosionSize;
      this.expGriOff = expGriOff;
      this.expDam = expDam;
      this.chunkPositionRecords = chunkPositionRecords;
      int var3 = (int)this.explosionX;
      int var4 = (int)this.explosionY;
      int var5 = (int)this.explosionZ;
      this.playerVelocityX = playerVelocityX;
      this.playerVelocityY = playerVelocityY;
      this.playerVelocityZ = playerVelocityZ;
      this.type = type;
      this.origin = origin;
      if (p != null && this.origin != null && p.field_71093_bK == this.origin.field_71093_bK) {
         this.handleExplosion();
      }

   }

   public void handleExplosion() {
      ExplosionJRMC var2 = new ExplosionJRMC(JRMCoreClient.mc.field_71441_e, (Entity)null, this.explosionX, this.explosionY, this.explosionZ, this.explosionSize, this.expGriOff, this.expDam, this.origin, this.type);
      var2.field_77281_g = this.chunkPositionRecords;
      var2.func_77279_a(false);
      EntityClientPlayerMP var10000 = JRMCoreClient.mc.field_71439_g;
      var10000.field_70159_w += (double)this.playerVelocityX;
      var10000 = JRMCoreClient.mc.field_71439_g;
      var10000.field_70181_x += (double)this.playerVelocityY;
      var10000 = JRMCoreClient.mc.field_71439_g;
      var10000.field_70179_y += (double)this.playerVelocityZ;
      EntityJRMCexpl aura = new EntityJRMCexpl(JRMCoreClient.mc.field_71441_e, this.type);
      if (aura != null) {
         aura.func_70012_b(this.explosionX, this.explosionY, this.explosionZ, 0.0F, 0.0F);
         aura.explsiz = this.explosionSize;
         JRMCoreClient.mc.field_71441_e.func_72838_d(aura);
      }

   }

   public void handleQuadI(byte b1, int b2, int b3, int b4) {
   }

   public void handleQuad(int b1, int b2, int b3, int b4, EntityPlayer p) {
      if (b1 == 10) {
         if (b2 == 1 && b3 == 0) {
            JRMCoreH.trngTPlmt = b4;
         } else if (b2 == 2 && b3 == 1) {
            JRMCoreH.trngTPlmt2 = b4;
         }
      }

   }

   public void handleData(int dataID, String d, EntityPlayer p) {
      String s;
      int i;
      if (dataID == 80) {
         s = !d.isEmpty() && !d.equalsIgnoreCase("error") ? d : "0";
         i = Integer.parseInt(s);
         JRMCoreH.ServerPoints = i;
      }

      if (dataID == 1) {
         if (d == "::") {
            JRMCoreH.plyrsArnd = null;
         } else {
            JRMCoreH.plyrsArnd = d.toString().replaceAll("::", "").split(":");
         }
      }

      int i;
      int i;
      int a;
      String[] k;
      String[] s2;
      if (dataID >= -1 && dataID <= 40) {
         if (dataID != 32) {
            JRMCoreH.rdc(d.toString().replaceAll("::", "").split(":"), dataID);
         } else if (d.startsWith("::")) {
            JRMCoreH.dat32 = null;
            k = d.toString().substring(2).split("::");
            s2 = k[0].split("/");
            i = Integer.parseInt(s2[0]);
            i = Integer.parseInt(s2[1]);
            int players = Integer.parseInt(s2[2]);
            a = Integer.parseInt(s2[3]);
            if (i == 0) {
               JRMCoreH.dat32Segmented = new String[players];
            }

            String[] dataFinal = k[1].replaceAll("::", "").split(":");

            for(int i = 0; i < dataFinal.length; ++i) {
               JRMCoreH.dat32Segmented[a + i] = dataFinal[i];
            }

            if (i == i - 1) {
               JRMCoreH.dat32 = JRMCoreH.dat32Segmented;
            }
         } else {
            JRMCoreH.rdc(d.toString().replaceAll("::", "").split(":"), dataID);
         }
      }

      if (dataID == -1) {
         JRMCoreH.plyrs = d.replaceAll("::", "").split(":");
      }

      if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreClient.mc.field_71439_g != null) {
         int pl;
         if (dataID == 1) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.data1[pl].split(";");
                  JRMCoreH.Race = Byte.parseByte(s2[0]);
                  JRMCoreH.dns = s2[1];
                  JRMCoreH.Pwrtyp = Byte.parseByte(s2[2]);
                  JRMCoreH.Class = Byte.parseByte(s2[3]);
                  JRMCoreH.Accepted = Byte.parseByte(s2[4]);
                  ExtendedPlayer props = ExtendedPlayer.get(JRMCoreClient.mc.field_71439_g);
                  JRMCoreH.dnsH = props.getHairCode();
                  break;
               }
            }
         }

         if (dataID == 2) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.data2[pl].split(";");
                  JRMCoreH.State = Byte.parseByte(s2[0]);
                  JRMCoreH.State2 = Byte.parseByte(s2[1]);
                  break;
               }
            }
         }

         String[] si;
         if (dataID == 7) {
            s = JRMCoreH.data7[0];
            if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.Accepted == 1) {
               JRMCoreH.sao_col = Integer.parseInt(s);
            } else {
               s2 = s.contains(";;") ? s.toString().split(";;") : null;
               if (s2 != null) {
                  for(i = 0; i < s2.length; ++i) {
                     si = s2[i].contains(";") ? s2[i].toString().split(";") : null;
                     switch(i) {
                     case 0:
                        JRMCoreH.tech1 = si;
                        break;
                     case 1:
                        JRMCoreH.tech2 = si;
                        break;
                     case 2:
                        JRMCoreH.tech3 = si;
                        break;
                     case 3:
                        JRMCoreH.tech4 = si;
                     }
                  }
               } else {
                  JRMCoreH.tech4 = null;
                  JRMCoreH.tech3 = null;
                  JRMCoreH.tech2 = null;
                  JRMCoreH.tech1 = null;
               }
            }
         }

         if (dataID == 15) {
            s = JRMCoreH.dat15[0];
            if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.Accepted == 1) {
               JRMCoreH.sao_exp = Integer.parseInt(s);
            }
         }

         String[] s3;
         if (dataID == 6) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_()) && JRMCoreH.data6.length >= JRMCoreH.plyrs.length) {
                  s2 = JRMCoreH.data6[pl].split(";");
                  JRMCoreH.PlyrSkillX = s2[1];
                  JRMCoreH.PlyrSkillY = s2[2];
                  JRMCoreH.PlyrSkillZ = s2[3];
                  s3 = s2[0].split(",");
                  JRMCoreH.PlyrSkills = s3;
                  si = s2[4].split(",");
                  int[] i = new int[si.length];

                  for(a = 0; a < si.length; ++a) {
                     i[a] = si[a].length() > 0 && !si[a].equals(" ") ? Integer.parseInt(si[a]) : -1;
                  }

                  JRMCoreH.techPM = i;
                  break;
               }
            }
         }

         String s;
         if (dataID == 8) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s = JRMCoreH.data8[pl];
                  JRMCoreH.curBody = Integer.parseInt(s);
                  break;
               }
            }
         }

         if (dataID == 9) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s = JRMCoreH.data9[pl];
                  JRMCoreH.curEnergy = Integer.parseInt(s);
                  break;
               }
            }
         }

         if (dataID == 10) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.dat10[pl].split(";");
                  JRMCoreH.curRelease = Byte.parseByte(s2[0]);
                  JRMCoreH.curStamina = Integer.parseInt(s2[1]);
                  break;
               }
            }
         }

         if (dataID == 4) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.data4[pl].split(";");
                  JRMCoreH.TransSaiCurRg = Byte.parseByte(s2[0]);
                  JRMCoreH.cura = Integer.parseInt(s2[1]);
                  break;
               }
            }
         }

         if (dataID == 5) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.data5[pl].split(";");
                  JRMCoreH.align = Byte.parseByte(s2[0]);
                  break;
               }
            }
         }

         byte pwr;
         if (dataID == 11) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.data1[pl].split(";");
                  int pwr = Byte.parseByte(s2[2]);
                  pwr = Byte.parseByte(s2[4]);
                  if (pwr == 3 && pwr == 1) {
                     s2 = JRMCoreH.dat11[pl].split(";");
                     JRMCoreH.sao_level = Integer.parseInt(s2[0]);
                     JRMCoreH.sao_ap = Integer.parseInt(s2[1]);
                     break;
                  }

                  String st = JRMCoreH.dat11[pl];
                  JRMCoreH.curTP = Integer.parseInt(st);
                  break;
               }
            }
         }

         if (dataID == 12) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s = JRMCoreH.dat12[pl];
                  JRMCoreH.curExp = Integer.parseInt(s);
                  break;
               }
            }
         }

         if (dataID == 14) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.dat14[pl].split(",");
                  int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];

                  for(i = 0; i < PlyrAttrbts.length; ++i) {
                     PlyrAttrbts[i] = Integer.parseInt(s2[i]);
                  }

                  JRMCoreH.PlyrAttrbts = PlyrAttrbts;
                  pwr = JRMCoreH.Pwrtyp;
                  byte rce = JRMCoreH.Race;
                  byte cls = JRMCoreH.Class;
                  JRMCoreH.maxBody = JRMCoreH.stat(p, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
                  JRMCoreH.maxEnergy = JRMCoreH.stat(p, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
                  JRMCoreH.maxStamina = JRMCoreH.stat(p, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
                  break;
               }
            }
         }

         if (dataID == 18) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s = JRMCoreH.dat18[pl];
                  s3 = s.split(";");
                  JRMCoreH.Dffclty = Byte.parseByte(s3[0]);
                  JRMCoreH.PtchVc = Byte.parseByte(s3[1]);
                  JRMCoreH.FznDC = s3[2];
                  break;
               }
            }
         }

         if (dataID == 19) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s2 = JRMCoreH.dat19[pl].split(";");
                  JRMCoreH.TlMd = Byte.parseByte(s2[0]);
                  break;
               }
            }
         }

         if (dataID == 20) {
            k = JRMCoreH.dat20[0].split(";");
            JRMCoreH.GTrnngCB = Integer.parseInt(k[0]);
            if (k.length > 1) {
               JRMCoreH.PlyrSettings = k[1];
            }

            JRMCoreH.GravZone = Float.parseFloat(k[2]);
            JRMCoreH.WeightOn = Float.parseFloat(k[3]);
            if (k.length > 7) {
               JRMCoreH.s4ft = Integer.parseInt(k[7]);
            }

            if (k.length > 8) {
               JRMCoreH.pnp = Integer.parseInt(k[8]);
            }

            if (k.length > 9) {
               JRMCoreH.ko = Integer.parseInt(k[9]);
            }

            JRMCoreH.kob = JRMCoreH.ko > 0;
            JRMCoreH.pnh = JRMCoreH.pnp > 0;
         }

         if (dataID == 21) {
            JRMCoreH.MSDV = JRMCoreH.dat21[0];
         }

         if (dataID == 22) {
            JRMCoreH.MSD = JRMCoreH.dat22[0];
         }

         if (dataID == 23) {
            for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  s = JRMCoreH.dat23[pl];
                  JRMCoreH.GID = Integer.parseInt(s);
                  break;
               }
            }

            int[] j = new int[JRMCoreH.dat23.length];

            for(i = 0; i < JRMCoreH.dat23.length; ++i) {
               j[i] = Integer.parseInt(JRMCoreH.dat23[i]);
            }

            JRMCoreH.GIDs = j;
            JRMCoreH.GMN = 0;
            if (JRMCoreH.GID > 0) {
               for(i = 0; i < JRMCoreH.plyrs.length; ++i) {
                  if (JRMCoreH.GIDs[i] == JRMCoreH.GID) {
                     ++JRMCoreH.GMN;
                  }
               }
            }
         }

         if (dataID == 24) {
            k = JRMCoreH.dat24[0].split(";");
            JRMCoreH.GLID = k[0];
            JRMCoreH.GIDi = k[1];
         }

         if (dataID == 25) {
            s = JRMCoreH.dat25[0];
            JRMCoreH.GIDi = s;
         }

         if (JRMCoreH.JFC()) {
            if (dataID == 26) {
               k = new String[JRMCoreH.dat26.length];

               for(i = 0; i < JRMCoreH.dat26.length; ++i) {
                  k[i] = JRMCoreH.dat26[i];
               }

               FamilyCH.famNams = k;
            }

            if (dataID == 27) {
               s = JRMCoreH.dat27[0];
               s = s.replaceAll("\\+", ":");
               s2 = new String[]{s};
               s3 = s.contains(";") ? s.split(";") : s2;
               FamilyCH.famMem = s3;
            }

            if (dataID == 28) {
               s = JRMCoreH.dat28[0];
               s2 = s.contains(";") ? s.toString().split(";") : null;
               if (s2 != null) {
                  s3 = s2[0].length() < 2 ? null : s2[0].split(",");
                  FamilyCH.FamP = s3 != null ? s3[1] : "";
                  FamilyCH.FamID = s2[0].length() < 2 ? 0 : 1;
                  FamilyCH.prop = s2.length >= 2 ? s2[1] : "";
                  FamilyCH.adop = s2.length >= 3 ? s2[2] : "";
               }
            }

            if (dataID == 29) {
               s = JRMCoreH.dat29[0];
               JRMCoreH.proc = s;
            }

            if (dataID == 30) {
               k = new String[JRMCoreH.dat30.length];

               for(i = 0; i < JRMCoreH.dat30.length; ++i) {
                  k[i] = JRMCoreH.dat30[i];
               }

               JRMCoreH.preg = k;
            }
         }

         if (dataID == 31 && JRMCoreConfig.JRMCABonusOn) {
            JRMCoreH.bonusAttributes = d;
         }
      }

   }

   public void handleData2(String c, String d, EntityPlayer p) {
      String[] r = c.split(";");
      ArrayList<String> a = Lists.newArrayList();

      for(int i = 0; i < r.length; ++i) {
         a.add(r[i]);
      }

      JRMCoreM.missionsC.put(r[0], (JRMCoreMsn)(new Gson()).fromJson(d, JRMCoreM.JSN_TYPE_MSN));
      JRMCoreM.missionsCD.put(r[0], a);
   }

   public void handleTri(ByteBuf buffer) {
      boolean dPnlty = false;
      int maxTrnExp = 0;
      boolean plntVegeta = false;
      boolean flyAnyLvl = false;
      boolean expGriOff = false;
      boolean DeathSystemOff = false;
      boolean DBSpawnEnabled = false;
      String DBSpawnTime = "";
      boolean SagaSystemOn = false;
      boolean SagaSysSpawnPods = false;
      boolean NPCSpawnCheck = false;
      boolean BuildingSpawnCheck = false;
      int buildingSpawnAreaSize = false;
      int pgut = 0;
      int pt = 0;
      int SklMedCat = false;
      float SklMedRate = 0.0F;
      int senzuCool = 0;
      float Reinc = 0.0F;
      boolean GodForm = false;
      boolean FreeRev = false;
      int TechExpNeed = 0;
      int TechCostMod = 0;
      String ncCSklsLvlO = "";
      String ncSklsLvlO = "";
      String TransGtsDmgO = "";
      boolean TPGainOn = true;
      float TPlimitIncreasesWithPlayerLevel = 0.5F;
      float TPMultiplier = 0.01F;
      int TPDailyLimit = true;
      float ComboTimer = 3.0F;
      boolean ConstantClickOn = true;
      int RandomMovementSpeed = true;
      boolean TPGainOn2 = true;
      float TPlimitIncreasesWithPlayerLevel2 = 0.5F;
      float TPMultiplier2 = 0.01F;
      int TPDailyLimit2 = true;
      int StartLife = true;
      float[] KeySpawnSpeed = new float[4];
      float[] KeySpeed = new float[4];
      int[] KeyLifeTaken = new int[4];
      int count = false;
      int[][] KeyTypeIDs = new int[4][];
      int StatPasDef = true;
      int mjn = true;
      int lgnd = true;
      String lgndb = "";
      double atcm = 1.6D;
      int AttributeUpgradeCost_StartMinus = true;
      int AttributeUpgradeCost_Min = true;
      float[] AttributeUpgradeCost_AttributeMulti = new float[]{1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F};
      String s1 = "";
      String s2 = "";
      String s3 = "";
      boolean dat5711 = false;
      String mods = ByteBufUtils.readUTF8String(buffer);
      HashMap<String, Boolean> dataH = new HashMap();
      JRMCoreH.modsC = (HashMap)(new Gson()).fromJson(mods, dataH.getClass());
      JRMCoreComTickH.tna3fu = buffer.readBoolean();
      if (JRMCoreH.DBC()) {
         maxTrnExp = buffer.readInt();
         plntVegeta = buffer.readBoolean();
         flyAnyLvl = buffer.readBoolean();
         DeathSystemOff = buffer.readBoolean();
         DBSpawnEnabled = buffer.readBoolean();
         DBSpawnTime = ByteBufUtils.readUTF8String(buffer);
         SagaSystemOn = buffer.readBoolean();
         SagaSysSpawnPods = buffer.readBoolean();
         senzuCool = buffer.readInt();
         Reinc = buffer.readFloat();
         GodForm = buffer.readBoolean();
         FreeRev = buffer.readBoolean();
         TechExpNeed = buffer.readInt();
         TechCostMod = buffer.readInt();
      }

      if (JRMCoreH.JYC()) {
         pgut = buffer.readInt();
      }

      if (JRMCoreH.JFC()) {
         pt = buffer.readInt();
      }

      if (JRMCoreH.NC()) {
         ncCSklsLvlO = ByteBufUtils.readUTF8String(buffer);
         ncSklsLvlO = ByteBufUtils.readUTF8String(buffer);
         TransGtsDmgO = ByteBufUtils.readUTF8String(buffer);
      }

      String vlblRSklsLvlO = ByteBufUtils.readUTF8String(buffer);
      String vlblSklsLvlO = ByteBufUtils.readUTF8String(buffer);
      String TransKaiDmgO = ByteBufUtils.readUTF8String(buffer);
      String TransKaiDrainOLevel = ByteBufUtils.readUTF8String(buffer);
      String TransKaiDrainORace = ByteBufUtils.readUTF8String(buffer);
      String TransMngDmgO = ByteBufUtils.readUTF8String(buffer);
      String TransKaiNmsO = ByteBufUtils.readUTF8String(buffer);
      String TransSaiStBnPO = ByteBufUtils.readUTF8String(buffer);
      String TransHalfSaiStBnPO = ByteBufUtils.readUTF8String(buffer);
      String TransFrStBnPO = ByteBufUtils.readUTF8String(buffer);
      String TransHmStBnPO = ByteBufUtils.readUTF8String(buffer);
      String TransNaStBnPO = ByteBufUtils.readUTF8String(buffer);
      String TransMaStBnPO = ByteBufUtils.readUTF8String(buffer);
      String vlblRSklsMRO = ByteBufUtils.readUTF8String(buffer);
      String vlblSklsMRO = ByteBufUtils.readUTF8String(buffer);
      String ncCSklsMRO = ByteBufUtils.readUTF8String(buffer);
      String ncSklsMRO = ByteBufUtils.readUTF8String(buffer);
      boolean OverAtrLimitO = buffer.readBoolean();
      String MysticDamMulti = ByteBufUtils.readUTF8String(buffer);
      String ArcoPP = ByteBufUtils.readUTF8String(buffer);
      String ArcoPP2 = ByteBufUtils.readUTF8String(buffer);
      String ArcoPP3 = ByteBufUtils.readUTF8String(buffer);
      String ArcoPP4 = ByteBufUtils.readUTF8String(buffer);
      String ArcoPP5 = ByteBufUtils.readUTF8String(buffer);
      String AttrBonusPerRacialSkill = ByteBufUtils.readUTF8String(buffer);
      int ArcoPP6 = buffer.readInt();
      String tpGainRate = ByteBufUtils.readUTF8String(buffer);
      String tpGain = ByteBufUtils.readUTF8String(buffer);
      expGriOff = buffer.readBoolean();
      int SklMedCat = buffer.readInt();
      SklMedRate = buffer.readFloat();
      boolean SklMedStop = buffer.readBoolean();
      boolean regen = buffer.readBoolean();
      boolean release = buffer.readBoolean();
      int tpgn = buffer.readInt();
      int attrMx = buffer.readInt();
      String regenRate = ByteBufUtils.readUTF8String(buffer);
      String hRegenRate = ByteBufUtils.readUTF8String(buffer);
      boolean sizes = buffer.readBoolean();
      String ssurl = ByteBufUtils.readUTF8String(buffer);
      String ssurl2 = ByteBufUtils.readUTF8String(buffer);
      String ssc = ByteBufUtils.readUTF8String(buffer);
      boolean sfzns = buffer.readBoolean();
      NPCSpawnCheck = buffer.readBoolean();
      BuildingSpawnCheck = buffer.readBoolean();
      int buildingSpawnAreaSize = buffer.readInt();
      TPGainOn = buffer.readBoolean();
      TPlimitIncreasesWithPlayerLevel = buffer.readFloat();
      TPMultiplier = buffer.readFloat();
      int TPDailyLimit = buffer.readInt();
      ComboTimer = buffer.readFloat();
      ConstantClickOn = buffer.readBoolean();
      int RandomMovementSpeed = buffer.readInt();
      TPGainOn2 = buffer.readBoolean();
      TPlimitIncreasesWithPlayerLevel2 = buffer.readFloat();
      TPMultiplier2 = buffer.readFloat();
      int TPDailyLimit2 = buffer.readInt();
      int StartLife = buffer.readInt();

      int i;
      for(i = 0; i < 4; ++i) {
         KeySpawnSpeed[i] = buffer.readFloat();
         KeySpeed[i] = buffer.readFloat();
         KeyLifeTaken[i] = buffer.readInt();
         int count = buffer.readInt();
         KeyTypeIDs[i] = new int[count];

         for(int j = 0; j < count; ++j) {
            KeyTypeIDs[i][j] = buffer.readInt();
         }
      }

      int StatPasDef = buffer.readInt();
      int mjn = buffer.readInt();
      atcm = buffer.readDouble();
      int AttributeUpgradeCost_StartMinus = buffer.readInt();
      int AttributeUpgradeCost_Min = buffer.readInt();

      for(i = 0; i < JRMCoreConfig.AttributeUpgradeCost_AttributeMulti.length; ++i) {
         AttributeUpgradeCost_AttributeMulti[i] = (float)buffer.readDouble();
      }

      int lgnd = buffer.readInt();
      lgndb = ByteBufUtils.readUTF8String(buffer);
      boolean lockon = buffer.readBoolean();
      double Flngspd = buffer.readDouble();
      if (JRMCoreH.DBC()) {
         s1 = ByteBufUtils.readUTF8String(buffer);
         s2 = ByteBufUtils.readUTF8String(buffer);
         s3 = ByteBufUtils.readUTF8String(buffer);
      }

      if (JRMCoreH.DBC() || JRMCoreH.NC()) {
         dat5711 = buffer.readBoolean();
      }

      if (JRMCoreH.DBC()) {
         JRMCoreHDBC.DBCsetConfigmaxTrnExp(maxTrnExp);
         JRMCoreHDBC.DBCsetConfigplntVegeta(plntVegeta);
         JRMCoreHDBC.DBCsetConfigflyAnyLvl(flyAnyLvl);
         JRMCoreHDBC.DBCsetConfigDeathSystemOff(DeathSystemOff);
         JRMCoreHDBC.DBCsetConfigDBSpawnEnabled(DBSpawnEnabled);
         JRMCoreHDBC.DBCsetConfigDBSpawnTime(DBSpawnTime);
         JRMCoreHDBC.DBCsetConfigDBSagaSystemOn(SagaSystemOn);
         JRMCoreHDBC.DBCsetConfigDBSagaSysSpawnPods(SagaSysSpawnPods);
         JRMCoreHDBC.DBCsetConfigsenzuCool(senzuCool);
         JRMCoreHDBC.DBCsetConfigReinc(Reinc);
         JRMCoreHDBC.DBCsetConfigGodform(GodForm);
         JRMCoreHDBC.FreeRevSet(FreeRev);
         JRMCoreHDBC.DBCsetConfigTechExpNeed(TechExpNeed);
         JRMCoreHDBC.DBCsetConfigTechCostMod(TechCostMod);
      }

      if (JRMCoreH.JYC()) {
         JRMCoreHJYC.JYCsetConfigpgut(pgut);
      }

      if (JRMCoreH.JFC()) {
         JRMCoreHJFC.setConfigpt(pt);
      }

      int[][] data = new int[20][];
      float[] dataF = new float[80];
      float[][] dataFMatrix = new float[6][17];
      int[] dataI = new int[40];
      String[] dataS = new String[20];
      float[][] dataFF = new float[20][];
      double[][] dataDD = new double[20][];
      if (JRMCoreH.NC()) {
         JRMCoreH.NCRacialSkillTPCost = (int[][])(new Gson()).fromJson(ncCSklsLvlO, data.getClass());
         JRMCoreH.NCSkillTPCost = (int[][])(new Gson()).fromJson(ncSklsLvlO, data.getClass());
         JRMCoreH.TransGtsDmg = (float[])(new Gson()).fromJson(TransGtsDmgO, dataF.getClass());
      }

      JRMCoreH.DBCRacialSkillTPCost = (int[][])(new Gson()).fromJson(vlblRSklsLvlO, data.getClass());
      JRMCoreH.DBCSkillTPCost = (int[][])(new Gson()).fromJson(vlblSklsLvlO, data.getClass());
      JRMCoreH.TransMngDmg = (float[])(new Gson()).fromJson(TransMngDmgO, dataF.getClass());
      JRMCoreH.TransKaiDmg = (float[])(new Gson()).fromJson(TransKaiDmgO, dataF.getClass());
      JRMCoreH.TransKaiDrainLevel = (float[])(new Gson()).fromJson(TransKaiDrainOLevel, dataF.getClass());
      JRMCoreH.TransKaiDrainRace = (float[])(new Gson()).fromJson(TransKaiDrainORace, dataF.getClass());
      JRMCoreH.TransKaiNms = (String[])(new Gson()).fromJson(TransKaiNmsO, dataS.getClass());
      JRMCoreH.TransSaiStBnP = (float[][])(new Gson()).fromJson(TransSaiStBnPO, dataFF.getClass());
      JRMCoreH.TransHalfSaiStBnP = (float[][])(new Gson()).fromJson(TransHalfSaiStBnPO, dataFF.getClass());
      JRMCoreH.TransFrStBnP = (float[][])(new Gson()).fromJson(TransFrStBnPO, dataFF.getClass());
      JRMCoreH.TransHmStBnP = (float[][])(new Gson()).fromJson(TransHmStBnPO, dataFF.getClass());
      JRMCoreH.TransNaStBnP = (float[][])(new Gson()).fromJson(TransNaStBnPO, dataFF.getClass());
      JRMCoreH.TransMaStBnP = (float[][])(new Gson()).fromJson(TransMaStBnPO, dataFF.getClass());
      JRMCoreH.DBCRacialSkillMindCost = (int[][])(new Gson()).fromJson(vlblRSklsMRO, data.getClass());
      JRMCoreH.DBCSkillMindCost = (int[][])(new Gson()).fromJson(vlblSklsMRO, data.getClass());
      JRMCoreH.NCRacialSkillMindCost = (int[][])(new Gson()).fromJson(ncCSklsMRO, data.getClass());
      JRMCoreH.NCSkillMindCost = (int[][])(new Gson()).fromJson(ncSklsMRO, data.getClass());
      JRMCoreConfig.OverAtrLimit = OverAtrLimitO;
      JRMCoreConfig.MysticDamMulti = (float[])(new Gson()).fromJson(MysticDamMulti, dataF.getClass());
      JRMCoreConfig.ArcosianPPMax = (int[])(new Gson()).fromJson(ArcoPP, dataI.getClass());
      JRMCoreConfig.ArcosianPPGrowth = (int[])(new Gson()).fromJson(ArcoPP2, dataI.getClass());
      JRMCoreConfig.ArcosianPPCost = (int[])(new Gson()).fromJson(ArcoPP3, dataI.getClass());
      JRMCoreConfig.ArcosianPPDamMulti = (float[])(new Gson()).fromJson(ArcoPP4, dataF.getClass());
      JRMCoreConfig.ArcosianPPDamMultiPoint = (float[])(new Gson()).fromJson(ArcoPP5, dataF.getClass());
      JRMCoreConfig.AttibuteBonusPerRacialSkill = (float[][])(new Gson()).fromJson(AttrBonusPerRacialSkill, dataFMatrix.getClass());
      JRMCoreConfig.ArcosianPPDamMultiHighest = ArcoPP6;
      JRMCoreConfig.TPGainRateRace = (float[])(new Gson()).fromJson(tpGainRate, dataF.getClass());
      JRMCoreConfig.TPGainRace = (float[])(new Gson()).fromJson(tpGain, dataF.getClass());
      JRMCoreConfig.expGriOff = expGriOff;
      JRMCoreConfig.SklMedCat = SklMedCat;
      JRMCoreConfig.SklMedRate = SklMedRate;
      JRMCoreConfig.releaseStop = SklMedStop;
      JRMCoreConfig.regen = regen;
      JRMCoreConfig.release = release;
      JRMCoreConfig.tpgn = tpgn;
      JRMCoreConfig.tmx = nQp65G(attrMx);
      JRMCoreConfig.regenRate = regenRate;
      JRMCoreConfig.hRegenRate = hRegenRate;
      JRMCoreConfig.sizes = sizes;
      JRMCoreConfig.ssurl = ssurl;
      JRMCoreConfig.ssurl2 = ssurl2;
      JRMCoreConfig.ssc = ssc;
      JRMCoreConfig.sfzns = sfzns;
      JRMCoreConfig.NPCSpawnCheck = NPCSpawnCheck;
      JRMCoreConfig.BuildingSpawnCheck = BuildingSpawnCheck;
      JRMCoreConfig.buildingSpawnAreaSize = buildingSpawnAreaSize;
      JGConfigMiniGameConcentration.TPGainOn = TPGainOn;
      JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel = TPlimitIncreasesWithPlayerLevel;
      JGConfigMiniGameConcentration.TPMultiplier = TPMultiplier;
      JGConfigMiniGameConcentration.TPDailyLimit = TPDailyLimit;
      JGConfigMiniGameConcentration.ComboTimer = ComboTimer;
      JGConfigMiniGameConcentration.ConstantClickOn = ConstantClickOn;
      JGConfigMiniGameConcentration.RandomMovementSpeed = RandomMovementSpeed;
      JGConfigMiniGameAirBoxing.TPGainOn = TPGainOn2;
      JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel = TPlimitIncreasesWithPlayerLevel2;
      JGConfigMiniGameAirBoxing.TPMultiplier = TPMultiplier2;
      JGConfigMiniGameAirBoxing.TPDailyLimit = TPDailyLimit2;
      JGConfigMiniGameAirBoxing.StartLife = StartLife;
      JGConfigMiniGameAirBoxing.KeySpawnSpeed = KeySpawnSpeed;
      JGConfigMiniGameAirBoxing.KeySpeed = KeySpeed;
      JGConfigMiniGameAirBoxing.KeyLifeTaken = KeyLifeTaken;
      JGConfigMiniGameAirBoxing.KeyTypeIDs = KeyTypeIDs;
      JRMCoreConfig.StatPasDef = StatPasDef;
      JRMCoreConfig.mjn = mjn;
      JRMCoreConfig.atcm = atcm;
      JRMCoreConfig.AttributeUpgradeCost_StartMinus = AttributeUpgradeCost_StartMinus;
      JRMCoreConfig.AttributeUpgradeCost_Min = AttributeUpgradeCost_Min;
      JRMCoreConfig.AttributeUpgradeCost_AttributeMulti = AttributeUpgradeCost_AttributeMulti;
      JRMCoreConfig.lgnd = lgnd;
      JRMCoreConfig.lgndb = lgndb;
      JRMCoreConfig.lockon = lockon;
      JRMCoreConfig.Flngspd = Flngspd;
      int i;
      int i;
      int ceaesl;
      if (JRMCoreH.DBC()) {
         String[] str = s1.split(" ");

         for(i = 0; i < JRMCoreConfig.dat5695.length; ++i) {
            JRMCoreConfig.dat5695[i] = Boolean.parseBoolean(str[i]);
         }

         String[] str2 = s2.split(";");

         for(i = 0; i < JRMCoreConfig.dat5696.length; ++i) {
            str = str2[i].split(" ");

            for(ceaesl = 0; ceaesl < JRMCoreConfig.dat5696[ceaesl].length; ++ceaesl) {
               JRMCoreConfig.dat5696[i][ceaesl] = Double.parseDouble(str[ceaesl]);
            }
         }

         str = s3.split(" ");

         for(i = 0; i < JRMCoreConfig.dat5709.length; ++i) {
            JRMCoreConfig.dat5709[i] = Boolean.parseBoolean(str[i]);
         }
      }

      if (JRMCoreH.DBC() || JRMCoreH.NC()) {
         JRMCoreConfig.dat5711 = dat5711;
      }

      int k;
      byte extendedPlayerBlock;
      boolean letgo;
      if (JRMCoreH.DBC()) {
         extendedPlayerBlock = buffer.readByte();
         JGConfigUltraInstinct.CONFIG_UI_LEVELS = extendedPlayerBlock;
         JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION = new int[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
         JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE = new boolean[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
         JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI = new int[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
         JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE = new float[JGConfigUltraInstinct.CONFIG_UI_LEVELS][JRMCoreH.Races.length];
         JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE = new byte[JGConfigUltraInstinct.CONFIG_UI_LEVELS][2];
         JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE = new byte[JGConfigUltraInstinct.CONFIG_UI_LEVELS][2];

         for(i = 0; i < JGConfigUltraInstinct.CONFIG_UI_LEVELS; ++i) {
            i = buffer.readInt();
            JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[i] = i;
            letgo = buffer.readBoolean();
            JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[i] = letgo;
            int attribute_multi = buffer.readInt();
            JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI[i] = attribute_multi;

            for(k = 0; k < JRMCoreH.Races.length; ++k) {
               float attribute_multi2 = buffer.readFloat();
               JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE[i][k] = attribute_multi2;
            }

            for(k = 0; k < 2; ++k) {
               byte dodge_rate = buffer.readByte();
               JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE[i][k] = dodge_rate;
               byte attack_rate = buffer.readByte();
               JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE[i][k] = attack_rate;
            }
         }
      }

      extendedPlayerBlock = buffer.readByte();
      byte extendedPlayerOther = buffer.readByte();
      byte extendedPlayerHair = buffer.readByte();
      JRMCoreConfig.ExtendedPlayerBlockID = extendedPlayerBlock;
      JRMCoreConfig.ExtendedPlayerOtherID = extendedPlayerOther;
      JRMCoreConfig.ExtendedPlayerHairID = extendedPlayerHair;
      float cealbm;
      int raceID;
      boolean aai2;
      boolean configValue5;
      if (JRMCoreH.DBC()) {
         letgo = buffer.readBoolean();
         DBCConfig.CanWhisTeleport = letgo;
         cealbm = buffer.readFloat();
         DBCConfig.EnmaScale = cealbm;
         float GuruScale = buffer.readFloat();
         DBCConfig.GuruScale = GuruScale;

         for(raceID = 0; raceID < JRMCoreConfig.ContinuesKiAttacks.length; ++raceID) {
            configValue5 = buffer.readBoolean();
            JRMCoreConfig.ContinuesKiAttacks[raceID] = configValue5;
         }

         aai2 = buffer.readBoolean();
         JRMCoreConfig.KiAttackScalesWithUser = aai2;
      }

      boolean targetSlow;
      if (JRMCoreH.NC()) {
         for(ceaesl = 0; ceaesl < JRMCoreConfig.ContinuesJutsuAttacks.length; ++ceaesl) {
            targetSlow = buffer.readBoolean();
            JRMCoreConfig.ContinuesJutsuAttacks[ceaesl] = targetSlow;
         }

         letgo = buffer.readBoolean();
         JRMCoreConfig.JutsuScalesWithUser = letgo;
      }

      if (JRMCoreH.DBC() || JRMCoreH.NC()) {
         letgo = buffer.readBoolean();
         JRMCoreConfig.WavesShrinkOnceLetGo = letgo;
         targetSlow = buffer.readBoolean();
         JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown = targetSlow;
         k = buffer.readInt();
         JRMCoreConfig.ContinuesEnergyAttackTimer = k;
      }

      ceaesl = buffer.readInt();
      cealbm = buffer.readFloat();
      JRMCoreConfig.eaesl = ceaesl;
      JRMCoreConfig.ealbm = cealbm;
      if (JRMCoreH.DBC()) {
         k = buffer.readInt();
         DBCConfig.NullRealmMinimumHeight = k;

         for(raceID = 0; raceID < 9; ++raceID) {
            double ContinuesCost = buffer.readDouble();
            JRMCoreConfig.dat5696[raceID][2] = ContinuesCost;
         }

         aai2 = buffer.readBoolean();
         DBCConfig.NullRealmBGColorNodeGreen = aai2;
         configValue5 = buffer.readBoolean();
         JRMCoreConfig.PlayerFlyingDragDownOn = configValue5;
      }

      int j;
      boolean aai29;
      int racials;
      if (JRMCoreH.DBC()) {
         for(k = 0; k < JRMCoreH.Races.length; ++k) {
            for(raceID = 0; raceID < JRMCoreH.ClassesDBC.length; ++raceID) {
               for(racials = 0; racials < JRMCoreH.attrInit[1].length; ++racials) {
                  double configValue = buffer.readDouble();
                  JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[k][raceID][racials] = configValue;
                  int configValue2 = buffer.readInt();
                  JGConfigRaces.CONFIG_RACES_ATTRIBUTE_START[k][raceID][racials] = configValue2;
               }

               for(racials = 0; racials < JRMCoreH.statNames[1].length; ++racials) {
                  float configValue = buffer.readFloat();
                  JGConfigRaces.CONFIG_RACES_STATS_MULTI[k][raceID][racials] = configValue;
                  j = buffer.readInt();
                  JGConfigRaces.CONFIG_RACES_STAT_BONUS[k][raceID][racials] = j;
               }
            }
         }

         aai29 = buffer.readBoolean();
         JGConfigRaces.CONFIG_MAJIN_ENABLED = aai29;
         aai2 = buffer.readBoolean();
         JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED = aai2;
         configValue5 = buffer.readBoolean();
         JGConfigRaces.CONFIG_MAJIN_PURE_PINK_SKIN = configValue5;
         boolean configValue6 = buffer.readBoolean();
         JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = configValue6;

         for(j = 0; j < JRMCoreH.TransNms[5].length + 3; ++j) {
            float configValue3 = buffer.readFloat();
            JGConfigRaces.CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[j] = configValue3;
            float configValue4 = buffer.readFloat();
            JGConfigRaces.CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[j] = configValue4;
         }
      }

      aai29 = buffer.readBoolean();
      JRMCoreConfig.JRMCABonusOn = aai29;
      aai29 = buffer.readBoolean();
      JRMCoreConfig.ShadowDummyScaleToTarget = aai29;
      int j;
      if (JRMCoreH.DBC()) {
         aai29 = buffer.readBoolean();
         JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG = aai29;
         aai2 = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG = aai2;
         racials = buffer.readInt();
         JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[racials];

         String s;
         for(j = 0; j < racials; ++j) {
            s = ByteBufUtils.readUTF8String(buffer);
            JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES[j] = s;
         }

         racials = buffer.readInt();
         JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES = new String[racials];

         for(j = 0; j < racials; ++j) {
            s = ByteBufUtils.readUTF8String(buffer);
            JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES[j] = s;
         }

         float f = buffer.readFloat();
         JGConfigDBCGoD.CONFIG_GOD_IGNORE_DAMAGE_MULTI = f;
         boolean b = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_IGNORE_PROJECTILES_ENABLED = b;
         b = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_ENABLED = b;
         b = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED = b;
         b = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA = b;
         b = buffer.readBoolean();
         JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED = b;
         f = buffer.readFloat();
         JGConfigDBCGoD.CONFIG_GOD_ENERGY_DAMAGE_MULTI = f;
         f = buffer.readFloat();
         JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI = f;

         for(j = 0; j < JRMCoreH.Races.length; ++j) {
            f = buffer.readFloat();
            JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI_RACE[j] = f;
         }
      }

      JRMCoreConfig.BuildingBlocksRenderAsNormalBlock = buffer.readBoolean();
      JGConfigSkills.GlobalSkillTPMultiplier = buffer.readFloat();
      JGConfigSkills.GlobalSkillMindMultiplier = buffer.readFloat();
      JGConfigSkills.GlobalSkillTPMultiplierFirst = buffer.readFloat();
      JGConfigSkills.GlobalSkillMindMultiplierFirst = buffer.readFloat();
      JGConfigSkills.GlobalSkillTPMultiplierWithLevel = buffer.readBoolean();
      JGConfigSkills.GlobalSkillMindMultiplierWithLevel = buffer.readBoolean();
      if (JRMCoreH.NC()) {
         JRMCoreConfig.NCExplosionTagTickTimer = buffer.readInt();
      }

      int formID;
      if (JRMCoreH.DBC()) {
         k = buffer.readInt();
         DBCConfig.AaiForceDifficulty = k;
         aai2 = buffer.readBoolean();
         DBCConfig.AaiDisabled = aai2;
         racials = buffer.readInt();
         DBCConfig.EnemyDefaultAttackTimer = racials;
         formID = buffer.readInt();
         DBCConfig.EnemyDefaultShortRangeAttackTimer = formID;
         double aai5 = buffer.readDouble();
         DBCConfig.EnemyDefaultMoveSpeed = aai5;
         boolean aai6 = buffer.readBoolean();
         DBCConfig.KiAttackGoThroughInvulnerableEnemies = aai6;
         boolean aai7 = buffer.readBoolean();
         DBCConfig.InstantTransformOn = aai7;
         boolean aai8 = buffer.readBoolean();
         DBCConfig.SingleFormDescendOn = aai8;

         boolean aai11;
         for(int i = 0; i < DBCConfig.IsInstantTransformEnabled.length; ++i) {
            aai11 = buffer.readBoolean();
            DBCConfig.IsInstantTransformEnabled[i] = aai11;
         }

         boolean aai10 = buffer.readBoolean();
         DBCConfig.KaiokenSingleFormDescendOn = aai10;
         aai11 = buffer.readBoolean();
         DBCConfig.MoveWhileTransforming = aai11;
         boolean aai12 = buffer.readBoolean();
         DBCConfig.MoveWhileInstantTransforming = aai12;

         for(int i = 0; i < JGConfigDBCAAiDifficulty.DIFFICULTIES.length; ++i) {
            double aai13 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.GroundDashSpeedMulti[i] = aai13;
            double aai14 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.GroundDashSpeedMulti2[i] = aai14;
            double aai15 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.GroundDashLimit[i] = aai15;
            double aai16 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.JumpMulti[i] = aai16;
            double aai17 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.JumpMulti2[i] = aai17;
            double aai18 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.JumpLimit[i] = aai18;
            double aai19 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.JumpLimit2[i] = aai19;
            double aai27 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.JumpRate[i] = aai27;
            double aai20 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.FlyingDashMulti[i] = aai20;
            double aai21 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.FlyingDashLimit[i] = aai21;
            double aai22 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.KiAttackChargeMulti[i] = aai22;
            double aai23 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.KiAttackChargeLimit[i] = aai23;
            int aai24 = buffer.readInt();
            JGConfigDBCAAiDifficulty.TeleportRateMin[i] = aai24;
            int aai25 = buffer.readInt();
            JGConfigDBCAAiDifficulty.TeleportRateMax[i] = aai25;
            double aai26 = buffer.readDouble();
            JGConfigDBCAAiDifficulty.SpeedMulti[i] = aai26;
         }

         boolean aai27 = buffer.readBoolean();
         DBCConfig.MysticKaiokenOn = aai27;

         int i;
         for(i = 0; i < JRMCoreH.Races.length; ++i) {
            for(int j = 0; j < JRMCoreConfig.KaiokenFormHealthCost[i].length; ++j) {
               float aai29 = buffer.readFloat();
               JRMCoreConfig.KaiokenFormHealthCost[i][j] = aai29;
            }
         }

         for(i = 0; i < 2; ++i) {
            boolean aai29 = buffer.readBoolean();
            JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[i] = aai29;
         }
      }

      aai29 = buffer.readBoolean();
      JGConfigDBCFormMastery.FM_Enabled = aai29;

      for(raceID = 0; raceID < JRMCoreH.Races.length; ++raceID) {
         racials = JRMCoreH.trans[raceID].length;

         for(formID = 0; formID < JGConfigDBCFormMastery.FormMasteries[raceID].length; ++formID) {
            boolean racial = formID < racials;
            String form = racial ? JRMCoreH.trans[raceID][formID] : JRMCoreH.transNonRacial[formID - racials];
            if (!racial || !JRMCoreH.isRaceSaiyan(raceID) || !form.equals(JRMCoreH.trans[raceID][12]) && !form.equals(JRMCoreH.trans[raceID][13])) {
               for(j = 0; j < 3; ++j) {
                  double aai30 = buffer.readDouble();
                  ((Object[])JGConfigDBCFormMastery.FormMasteries[raceID][formID].data.get(JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI))[j] = aai30 + "";
               }
            }
         }
      }

   }

   public void handleFall(byte b, EntityPlayer p) {
   }

   public void handleRls(byte b, EntityPlayer p) {
   }

   public void handleTech(byte b, String s, EntityPlayer p) {
      if (b >= 0 && b <= 3) {
         String[] s2 = s.contains(";") ? s.toString().split(";") : null;
         if (b == 0) {
            JRMCoreH.tech1 = s2;
         }

         if (b == 1) {
            JRMCoreH.tech2 = s2;
         }

         if (b == 2) {
            JRMCoreH.tech3 = s2;
         }

         if (b == 3) {
            JRMCoreH.tech4 = s2;
         }
      }

   }

   public void handleAttck(byte b, EntityPlayer p) {
   }

   public void handleCost(short s, EntityPlayer p) {
   }

   public void handleStats2(int curTP, int curExp, byte align, int[] plyrAttrbts, EntityPlayer p) {
      JRMCoreH.curTP = curTP;
      JRMCoreH.curExp = curExp;
      JRMCoreH.align = align;
      JRMCoreH.PlyrAttrbts = plyrAttrbts;
      byte pwr = JRMCoreH.Pwrtyp;
      byte rce = JRMCoreH.Race;
      byte cls = JRMCoreH.Class;
      JRMCoreH.maxBody = JRMCoreH.stat(p, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
      JRMCoreH.maxEnergy = JRMCoreH.stat(p, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
      JRMCoreH.maxStamina = JRMCoreH.stat(p, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
   }

   public static int aqMWr(String l) {
      String w = "0123456789ABCDEF";
      l = l.toUpperCase();
      int a = 0;

      for(int i = 0; i < l.length(); ++i) {
         char c = l.charAt(i);
         int d = w.indexOf(c);
         a = 16 * a + d;
      }

      return a;
   }

   public static int nQp65G(int b) {
      String r = "64";
      String k = "3B9ACA00";
      return b > aqMWr(k) ? aqMWr(k) : (b < aqMWr(r) ? 0 : b);
   }

   public void handleStats3(String PlyrSkills, String x, String y, String z, EntityPlayer p) {
      JRMCoreH.PlyrSkillX = x;
      JRMCoreH.PlyrSkillY = y;
      JRMCoreH.PlyrSkillZ = z;
      JRMCoreH.PlyrSkills = PlyrSkills.split(",");
   }

   public void handleStats(int curBody, int curEnergy, int curStamina, byte curRelease, byte b) {
      JRMCoreH.curBody = curBody;
      JRMCoreH.curEnergy = curEnergy;
      JRMCoreH.curStamina = curStamina;
      JRMCoreH.curRelease = curRelease;
      JRMCoreH.TransSaiCurRg = b;
   }

   public void handleUpgrade(byte b, EntityPlayer p) {
   }

   public void handleCol(int i, byte b, EntityPlayer p) {
   }

   public void handleChar(byte b, int b2, EntityPlayer p) {
   }

   public void handleTick(int jrmcpg, String jrmcp, EntityPlayer p) {
      String[] s;
      Entity e;
      float scale;
      float a;
      if (jrmcpg == 4) {
         s = jrmcp.split(";");
         if (s.length > 2) {
            e = p.field_70170_p.func_73045_a(Integer.parseInt(s[0]));
            if (e != null) {
               if (JGConfigClientSettings.CLIENT_DA15) {
                  scale = 1.0F;
                  a = 1.0F;
                  float scale = (float)e.field_70173_aa * (e.field_70131_O / 100.0F);
                  Entity pl = e;
                  double x = 0.0D;
                  double y = (double)(e.field_70131_O * 0.6F);
                  double z = 0.0D;
                  Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", e.field_70170_p, 0.4F, 0.4F, e.field_70165_t, e.field_70163_u, e.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 4.0D) + 12, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 35, 1, (float)(Math.random() * 0.019999999552965164D) + 0.04F, (float)(Math.random() * 0.029999999329447746D) + 0.06F, (float)(Math.random() * 0.003000000026077032D) + 0.001F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                  ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                  e.field_70170_p.func_72838_d(entity7);
                  int num = (int)(Math.random() * 4.0D) + 1;

                  for(int i = 0; i < num; ++i) {
                     Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", e.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 4.0D) + 4, 4, 4, 64, true, (float)(Math.random() * 0.4000000059604645D) + 0.4F, false, 0.0F, 1, "", 22, 1, (float)(Math.random() * 0.019999999552965164D) + 0.03F, (float)(Math.random() * 0.029999999329447746D) + 0.05F, (float)(Math.random() * 0.0020000000949949026D) + 0.001F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                     ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                     e.field_70170_p.func_72838_d(entity7);
                  }
               }

               JRMCoreH.damInd.put(e.field_70165_t + ":" + (e.field_70163_u + (double)e.field_70131_O) + ":" + e.field_70161_v, s[2] + ":100");
            }
         }
      } else if (jrmcpg == 50) {
         if (JGConfigClientSettings.instantTransmissionParticles) {
            s = jrmcp.split(";");
            if (s.length > 3) {
               e = p.field_70170_p.func_73045_a(Integer.parseInt(s[0]));
               if (e != null) {
                  scale = 0.025F * e.field_70131_O;
                  a = 0.25F;
                  double x = 0.0D;
                  double y = (double)(e.field_70131_O * 0.5F);
                  double z = 0.0D;
                  double x2 = Double.parseDouble(s[1]);
                  double y2 = Double.parseDouble(s[2]);
                  double z2 = Double.parseDouble(s[3]);
                  Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles2.png", e.field_70170_p, 0.4F, 0.4F, x2, y2, z2, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 3.0D), 0, 0, 64, false, 0.0F, false, 0.0F, 1, "", 10, 1, scale, scale / 50.0F, -scale / 20.0F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, a, 0.0F, 0.0F, 0.0F, a / 5.0F, false, -1, false, (Entity)null);
                  e.field_70170_p.func_72838_d(entity);
               }
            }
         }
      } else if (jrmcpg != 5) {
         if (jrmcpg == 20) {
            p.openGui(mod_JRMCore.instance, 2, p.field_70170_p, (int)p.field_70165_t, (int)p.field_70163_u, (int)p.field_70161_v);
            JRMCoreH.ask = jrmcp;
         } else if (jrmcpg == 22) {
            p.openGui(mod_JRMCore.instance, 3, p.field_70170_p, (int)p.field_70165_t, (int)p.field_70163_u, (int)p.field_70161_v);
            JRMCoreH.ask = jrmcp;
         } else if (jrmcpg == 1) {
            if (jrmcp == "::") {
               JRMCoreH.plyrsArnd = null;
            } else {
               JRMCoreH.plyrsArnd = jrmcp.toString().replaceAll("::", "").split(":");
            }
         }
      }

   }

   public void handleNotification(EntityPlayer p, String title, String description, byte category, byte icon, byte renderLocation, int iconColor) {
      this.handleNotification(title, description, category, icon, renderLocation, iconColor);
   }

   public void handleNotification(String title, String description, byte category, byte icon, byte renderLocation, int iconColor) {
      if (JGNotificationGUI.categoryState[category] != 2 && JGNotificationGUI.categoryState[0] != 2) {
         JGNotificationHandlerC.addNotification(new JGNotification(title, description, category, icon, renderLocation, iconColor));
      }

   }
}
