package JinRyuu.JRMCore;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.items.ItemBodysuit;
import JinRyuu.JRMCore.items.ItemHeadwear;
import JinRyuu.JRMCore.items.ItemVanity;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.JGRaceHelper;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import net.minecraft.entity.Entity.EnumEntitySize;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class JRMCoreComTickH {
   public static final int MAX_GROUP_MEMBER_LIMIT = 600;
   private static final Marker JRMCServer = MarkerManager.getMarker("JRMCServer");
   public static final String R = "jrmcRace";
   public static final String P = "jrmcPwrtyp";
   public static final String Cl = "jrmcClass";
   public static final String Acc = "jrmcAccept";
   public static final String St = "jrmcState";
   public static final String St2 = "jrmcState2";
   public static final String Diff = "jrmcDiff";
   public static final String Tm = "jrmcTlmd";
   public static final String DiffRed = "jrmcDiffRed";
   public static final String Ptch = "jrmcPtch";
   public static String[] names = null;
   public static String[] data0 = null;
   public static String[] data1 = null;
   public static String[] data2 = null;
   public static String[] data3 = null;
   public static String[] data4 = null;
   public static String[] data5 = null;
   public static String[] data6 = null;
   public static String[] data7 = null;
   public static String[] data8 = null;
   public static String[] data9 = null;
   public static String[] dat10 = null;
   public static String[] dat11 = null;
   public static String[] dat12 = null;
   public static String[] dat13 = null;
   public static String[] dat14 = null;
   public static String[] dat15 = null;
   public static String[] dat16 = null;
   public static String[] dat17 = null;
   public static String[] dat18 = null;
   public static String[] dat19 = null;
   public static String[] dat20 = null;
   public static String[] dat21 = null;
   public static String[] dat22 = null;
   public static String[] dat23 = null;
   public static String[] dat24 = null;
   public static String[] dat25 = null;
   public static String[] dat26 = null;
   public static String[] dat27 = null;
   public static String[] dat28 = null;
   public static String[] dat29 = null;
   public static String[] dat30 = null;
   public static String[] dat31 = null;
   public static String[] dat32 = null;
   public static String sentNames = null;
   public static String sentData0 = null;
   public static String sentData1 = null;
   public static String sentData2 = null;
   public static String sentData3 = null;
   public static String sentData4 = null;
   public static String sentData5 = null;
   public static String sentData6 = null;
   public static String sentData7 = null;
   public static String sentData8 = null;
   public static String sentData9 = null;
   public static String sentDat10 = null;
   public static String sentDat11 = null;
   public static String sentDat12 = null;
   public static String sentDat13 = null;
   public static String sentDat14 = null;
   public static String sentDat15 = null;
   public static String sentDat16 = null;
   public static String sentDat17 = null;
   public static String sentDat18 = null;
   public static String sentDat19 = null;
   public static String sentDat20 = null;
   public static String sentDat21 = null;
   public static String sentDat22 = null;
   public static String sentDat23 = null;
   public static String sentDat24 = null;
   public static String sentDat25 = null;
   public static String sentDat26 = null;
   public static String sentDat27 = null;
   public static String sentDat28 = null;
   public static String sentDat29 = null;
   public static String sentDat30 = null;
   public static String sentDat31 = null;
   public static String sentDat32 = null;
   private String sentDataX = null;
   public String[] dataX = null;
   public boolean all = false;
   boolean charge = false;
   private static int tick = 0;
   boolean jfc = JRMCoreH.JFC();
   boolean dbc = JRMCoreH.DBC();
   boolean nc = JRMCoreH.NC();
   boolean sao = JRMCoreH.SAOC();
   boolean jyc = JRMCoreH.JYC();
   private boolean gen = true;
   private int genInt;
   public static boolean tna3fu;
   public static boolean start = true;
   public static int bldngsChecker = 300;
   public static boolean bldngChkr = true;
   public static String bs = "";
   public static LinkedHashMap<String, Boolean> lf = new LinkedHashMap();
   public static int cbl = 24000;
   public static int chsn = -1;
   public static boolean op = false;
   private int c = 0;
   public static MinecraftServer server = null;
   private static final Type JSN_TYPE_ss = (new TypeToken<JRMCss>() {
   }).getType();
   protected static float width = 0.6F;
   protected static float height = 1.8F;
   static float serverHeight;
   static float serverEyHeigClc;
   static float serverDefEyHeig;
   static float serveryOffset;
   public static boolean h;

   private void newString(String[] s, int c) {
      if (s == null || s.length != c) {
         s = new String[c];
      }

   }

   public String getLabel() {
      return null;
   }

   private static byte b(int n) {
      return (byte)n;
   }

   private static NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   private static void jrmcData(int d, String s) {
      JRMCoreH.jrmcData(d, s);
   }

   private static void jrmcDataToP(int d, String s, EntityPlayer p) {
      JRMCoreH.jrmcDataToP(d, s, p);
   }

   @SubscribeEvent
   public void onTick(ServerTickEvent event) {
      if (event.phase.equals(Phase.START)) {
         this.onTickInGame();
      }

   }

   private void onTickInGame() {
      JRMCoreH.mld();
      if (!JRMCoreH.paused) {
         server = FMLCommonHandler.instance().getMinecraftServerInstance();
         this.serverTick(server);
      }

   }

   public void serverTick(MinecraftServer server) {
      int playersCount = server.func_71213_z().length;
      this.countbackForLegendary(playersCount);
      this.serverStart(server);
      this.checkBuildingsSpawn(server);
      JRMCoreH.configToClient(server);
      this.savePlayerData(playersCount);
      this.nullifyPlayerData(playersCount);
      this.removeGroupMembers(server);
      ++this.c;
      this.offlineProtector(server, playersCount);
      playersCount = server.func_71213_z().length;
      JRMCoreH.clearEmptyFamiliesNBTData(server);
      if (this.jfc) {
         if (JRMCoreConfig.runFamilyCDataUpdateAsThread) {
            if (FamilyCH.familyCDataThread == null) {
               FamilyCH.familyCDataThread = new FamilyCDataThread();
               FamilyCH.familyCDataThread.start();
            }

            if (FamilyCH.familyCDataThread != null && !FamilyCH.familyCDataThread.run) {
               FamilyCH.familyCDataThread = null;
            }
         } else {
            if (FamilyCH.lastUpdateTick >= JRMCoreConfig.serverPlayerUpdateTick_DataFamilyC * 20 || FamilyCH.familyCNBT == null && FamilyCH.lastUpdateTick >= 40) {
               FamilyCH.familyCNBT = FamilyCH.readFamilyInfoFromNBT(server);
               FamilyCH.lastUpdateTick = 0;
            }

            ++FamilyCH.lastUpdateTick;
         }
      }

      for(int playerID = 0; playerID < playersCount; ++playerID) {
         String usernames = server.func_71213_z()[playerID];
         if (op) {
            Integer os = (Integer)JRMCoreH.osbic.get(usernames);
            if (os != null && os < JRMCoreConfig.osbic * 20) {
               HashMap var10000 = JRMCoreH.osbic;
               os + 1;
               var10000.put(usernames, os);
            } else if (os == null) {
               JRMCoreH.osbic.put(usernames, 1);
            }
         }

         EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, usernames);
         JGPlayerMP jgPlayer = new JGPlayerMP(player);
         NBTTagCompound nbt = jgPlayer.connectBaseNBT();
         if (tick == (int)(100.0F / (float)playersCount * (float)playerID)) {
            byte powerType = nbt.func_74771_c("jrmcPwrtyp");
            if (JRMCoreH.isPowerTypeSAO(powerType)) {
               int sao_lvl = nbt.func_74762_e("saocLvl");
               sao_lvl = sao_lvl < 1 ? 1 : sao_lvl;
            }

            if (this.dbc || this.nc || this.sao) {
               int[] playerAttributes = jgPlayer.getAttributes();
               String[] playerSkills = jgPlayer.getSkills();
               byte race = jgPlayer.getRace();
               if (!JGConfigRaces.CONFIG_MAJIN_ENABLED && JRMCoreH.isRaceMajin(race) && JRMCoreH.isPowerTypeKi(powerType)) {
                  JRMCoreH.resetChar(player);
               }

               if (JRMCoreH.isPowerTypeKi(powerType)) {
                  JRMCoreH.updateFormMasteryVersion(nbt);
               }

               powerType = nbt.func_74771_c("jrmcPwrtyp");
               race = jgPlayer.getRace();
               byte classID = jgPlayer.getClassID();
               byte state = jgPlayer.getState();
               byte state2 = jgPlayer.getState2();
               int curBody = jgPlayer.getHealth();
               int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
               float RRBody = (float)jgPlayer.getHealthRegen(race, classID, powerType);
               int curEnergy = jgPlayer.getEnergy();
               int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs((String[])playerSkills, powerType));
               float RREnergy = (float)jgPlayer.getEnergyRegen(race, classID, powerType);
               int curStam = jgPlayer.getStamina();
               int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
               float RRStam = (float)jgPlayer.getStaminaRegen(race, classID, powerType);
               int resrv = JRMCoreH.getInt(player, "jrmcArcRsrv");
               String absorption = JRMCoreH.getString(player, "jrmcMajinAbsorptionData");
               String SkillXNbt = nbt.func_74779_i("jrmcSSltX");
               String statusEffects = jgPlayer.getStatusEffects();
               int foodlvl = player.func_71024_bL().func_75116_a();
               boolean isFoodLevelNotNull = foodlvl > 0;
               byte alive = nbt.func_74771_c("jrmcAlv");
               byte release = JRMCoreH.getByte(player, "jrmcRelease");
               int strainTemporary = nbt.func_74762_e("jrmcStrainTemp");
               int strainActive = nbt.func_74762_e("jrmcStrainActv");
               int strain = nbt.func_74762_e("jrmcStrain");
               int strainGod = nbt.func_74762_e("jrmcGodStrain");
               int strainPain = nbt.func_74762_e("jrmcGyJ7dp");
               int godPowerTimer = nbt.func_74762_e("jrmcGodPwr");
               int heat = nbt.func_74762_e("jrmcEf8slc");
               double heatD = nbt.func_74769_h("jrmcEf8slcD");
               int ko = nbt.func_74762_e("jrmcHar4va");
               if ((JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType)) && JGRaceHelper.isAboveMaxRacialSkill(nbt)) {
                  JGRaceHelper.setRacialSkillToMax(nbt);
               }

               boolean isLegendaryOn = JRMCoreH.PlyrSettings((EntityPlayer)player, 13) > -1;
               int kiFistLevel = JRMCoreH.SklLvl(12, (String[])playerSkills);
               int lastAttackedTimer = JRMCoreH.SklLvl(15, (String[])playerSkills);
               if (isLegendaryOn) {
                  if (release > 0) {
                     if (kiFistLevel > 0 && lastAttackedTimer > 0) {
                        player.world.func_72956_a(player, "jinryuudragonbc:DBC4.kiblade", 0.65F, 1.0F);
                     } else {
                        JRMCoreH.PlyrSettingsSet((EntityPlayer)player, 13, -1);
                     }
                  } else {
                     JRMCoreH.PlyrSettingsSet((EntityPlayer)player, 13, -1);
                  }
               }

               if (alive == 1 && player.func_71024_bL().func_75121_c()) {
                  player.func_71024_bL().func_75122_a(2, 1.0F);
               }

               if (!JRMCoreConfig.release && release != 50) {
                  JRMCoreH.setByte((int)50, player, "jrmcRelease");
               }

               if (JRMCoreConfig.release && release == 0) {
                  statusEffects = JRMCoreH.StusEfcts(3, statusEffects, (NBTTagCompound)nbt, false);
                  statusEffects = JRMCoreH.StusEfcts(5, statusEffects, (NBTTagCompound)nbt, false);
                  statusEffects = JRMCoreH.StusEfcts(16, statusEffects, (NBTTagCompound)nbt, false);
                  statusEffects = JRMCoreH.StusEfcts(15, statusEffects, (NBTTagCompound)nbt, false);
               }

               if (JRMCoreH.rc_sai(race) && player.field_71093_bK == 0 && player.world.func_130001_d() == 1.0F && player.world.func_72820_D() % 24000L > 12000L) {
                  statusEffects = JRMCoreH.StusEfcts(8, statusEffects, (NBTTagCompound)nbt, true);
               } else {
                  statusEffects = JRMCoreH.StusEfcts(8, statusEffects, (NBTTagCompound)nbt, false);
               }

               if (chsn > -1 && chsn == playerID) {
                  mod_JRMCore.logger.info(usernames + " received the Legendary status effect!");
                  if (playersCount > JRMCoreConfig.selgndc2) {
                     mod_JRMCore.logger.info("Legendary config effect - Lucky player: " + JRMCoreConfig.selgndc + " with " + playersCount + " being online");
                  } else {
                     mod_JRMCore.logger.info("Legendary config effect - Chance being: " + JRMCoreConfig.selgndc + "%");
                  }

                  statusEffects = JRMCoreH.StusEfcts(14, statusEffects, (NBTTagCompound)nbt, true);
                  chsn = -1;
               }

               isLegendaryOn = JRMCoreH.StusEfcts(14, statusEffects);
               boolean cont = lf.containsKey(usernames);
               if (isLegendaryOn && !cont) {
                  lf.put(usernames, true);
               } else if (!isLegendaryOn && cont) {
                  lf.remove(usernames);
               }

               if (lf.size() > JRMCoreConfig.selgnd && lf.keySet().toArray()[lf.size() - 1].equals(usernames)) {
                  statusEffects = JRMCoreH.StusEfcts(14, statusEffects, (NBTTagCompound)nbt, false);
               }

               int i;
               if (powerType == 2) {
                  if (state > 0 && JRMCoreH.StusEfcts(16, statusEffects)) {
                     lastAttackedTimer = JRMCoreH.stat(player, 3, powerType, 4, playerAttributes[3], race, classID, 0.0F);
                     double tr = (double)(0.25F * (float)lastAttackedTimer * (float)release * 0.01F);
                     i = (int)((double)curEnergy - tr < 1.0D ? 0.0D : (double)curEnergy - tr);
                     if (!JRMCoreH.isInCreativeMode(player)) {
                        curEnergy = i;
                        JRMCoreH.setInt((int)i, player, "jrmcEnrgy");
                     }

                     if ((double)i <= tr) {
                        statusEffects = JRMCoreH.StusEfcts(16, statusEffects, (NBTTagCompound)nbt, false);
                        JRMCoreH.setByte((int)0, player, "jrmcRelease");
                        nbt.func_74774_a("jrmcState", (byte)0);
                        state = 0;
                     }
                  }

                  if (state == 0) {
                     statusEffects = JRMCoreH.StusEfcts(16, statusEffects, (NBTTagCompound)nbt, false);
                  }
               }

               lastAttackedTimer = JRMCoreH.getInt(player, "jrmcAttackTimer");
               int epoch = (int)(System.currentTimeMillis() / 1000L);
               int level;
               int i;
               boolean isInBaseState;
               if (powerType == 3) {
                  if (JRMCoreConfig.hregen && isFoodLevelNotNull && curBody < maxBody && epoch > lastAttackedTimer) {
                     double add = (double)maxBody * 0.05D * (double)JRMCoreConfig.hRgnRt * 0.5D;
                     if (add >= 0.0D) {
                        i = (int)((double)curBody + add);
                        JRMCoreH.setInt((int)(i > maxBody ? maxBody : i), player, "jrmcBdy");
                     }
                  } else if (!isFoodLevelNotNull) {
                     level = (int)((double)curBody - (double)maxBody * 0.05D);
                     JRMCoreH.setInt((int)(level <= 0 ? 0 : level), player, "jrmcBdy");
                  }
               } else {
                  level = JRMCoreH.isRaceArcosian(race) ? 4 : 0;
                  isInBaseState = state == level;
                  i = JRMCoreH.SklLvl(9, (EntityPlayer)player);
                  boolean hasGodForm = i > (JRMCoreH.isRaceSaiyan(race) ? 1 : 0);
                  boolean statusEffectTurboSwoop = JRMCoreH.StusEfcts(3, statusEffects) || JRMCoreH.StusEfcts(7, statusEffects);
                  boolean isAuraNotOn = !statusEffects.contains(JRMCoreH.StusEfcts[4]);
                  boolean isKaiokenOn = JRMCoreH.StusEfcts(5, statusEffects);
                  boolean isUltraInstinctOn = JRMCoreH.StusEfcts(19, statusEffects);
                  boolean isMedicationActive = JRMCoreConfig.SklMedCat == 0;
                  boolean isMajinOn = JRMCoreH.StusEfcts(12, statusEffects);
                  int alignment = nbt.func_74771_c("jrmcAlign");
                  boolean isMysticOn = JRMCoreH.StusEfcts(13, statusEffects);
                  int mysticLevel = powerType == 1 ? JRMCoreH.SklLvl(10, powerType, playerSkills) : 0;
                  int mysticTimer = nbt.func_74762_e("jrmcUltmtTm");
                  int majinAbsorptionTimer = nbt.func_74762_e("jrmcMajinAbsorptionTimer");
                  boolean isGoDOn = JRMCoreH.StusEfcts(20, statusEffects);
                  int GoDLevel = powerType == 1 ? JRMCoreH.SklLvl(18, powerType, playerSkills) : 0;
                  boolean isInZeroRelease = release <= 0;
                  boolean hasTurbo;
                  boolean canUse;
                  boolean hasFullPowerSSJ;
                  byte OGstate;
                  if (JRMCoreH.isPowerTypeKi(powerType)) {
                     hasTurbo = JRMCoreH.PlyrSettingsB((NBTTagCompound)nbt, 6);
                     canUse = JRMCoreH.PlyrSettingsB((NBTTagCompound)nbt, 11);
                     boolean isPSettingOn_GoD = JRMCoreH.PlyrSettingsB((NBTTagCompound)nbt, 16);
                     hasFullPowerSSJ = JRMCoreH.PlyrSettingsB((NBTTagCompound)nbt, 0);
                     OGstate = 0;
                     if (hasTurbo) {
                        ++OGstate;
                     }

                     if (canUse) {
                        ++OGstate;
                     }

                     if (isPSettingOn_GoD) {
                        ++OGstate;
                     }

                     if (hasFullPowerSSJ) {
                        ++OGstate;
                     }

                     if (OGstate > 1) {
                        if (hasTurbo) {
                           JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 6);
                        }

                        if (canUse) {
                           JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 11);
                        }

                        if (isPSettingOn_GoD) {
                           JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 16);
                        }

                        if (hasFullPowerSSJ) {
                           JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 0);
                        }
                     }

                     if (canUse && JRMCoreH.SklLvl(16, powerType, playerSkills) == 0) {
                        JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 11);
                     }

                     if (isPSettingOn_GoD && JRMCoreH.SklLvl(18, powerType, playerSkills) == 0) {
                        JRMCoreH.PlyrSettingsRem((NBTTagCompound)nbt, 16);
                     }
                  }

                  String instantTransmissionTimers;
                  byte failSafe;
                  if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType)) {
                     instantTransmissionTimers = JRMCoreH.getFormMasteryData(player);
                     if (isKaiokenOn && !JRMCoreH.hasRequiredFormMasteries(player, instantTransmissionTimers, race, "Kaioken", false)) {
                        state2 = 0;
                        JRMCoreH.setByte((byte)0, player, "jrmcState2");
                        isKaiokenOn = false;
                        statusEffects = JRMCoreH.StusEfcts(5, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (isMysticOn && !JRMCoreH.hasRequiredFormMasteries(player, instantTransmissionTimers, race, "Mystic", false)) {
                        isMysticOn = false;
                        statusEffects = JRMCoreH.StusEfcts(13, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (isUltraInstinctOn && !JRMCoreH.hasRequiredFormMasteries(player, instantTransmissionTimers, race, "UltraInstict", false)) {
                        state2 = 0;
                        JRMCoreH.setByte((byte)0, player, "jrmcState2");
                        isUltraInstinctOn = false;
                        statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (isGoDOn && !JRMCoreH.hasRequiredFormMasteries(player, instantTransmissionTimers, race, "GodOfDestruction", false)) {
                        isGoDOn = false;
                        statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (state > 0 && !JRMCoreH.hasRequiredFormMasteries2(player, instantTransmissionTimers, race, state, state2, false, false, false, false)) {
                        canUse = false;

                        for(failSafe = 100; !canUse && failSafe > 0; --failSafe) {
                           hasFullPowerSSJ = false;
                           if (JRMCoreH.isRaceSaiyan(race)) {
                              hasFullPowerSSJ = JRMCoreH.isSaiyanSuperFullPower(nbt);
                           }

                           OGstate = JRMCoreH.transformationDescendToFormID[race][state];
                           state = JRMCoreH.getTransformationDescendToFormID(race, state, hasFullPowerSSJ);
                           JRMCoreH.setByte((byte)state, player, "jrmcState");
                           canUse = state == 0 || JRMCoreH.hasRequiredFormMasteries2(player, instantTransmissionTimers, race, state, state2, false, false, false, false);
                        }
                     }

                     if (!isInZeroRelease) {
                        JRMCoreH.addToFormMasteriesValue(player, JGConfigDBCFormMastery.FM_GainPassive, JGConfigDBCFormMastery.FM_GainPassive, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, 0);
                     }

                     JRMCoreH.autoLearnFormMastery(player, race);
                  }

                  double lvlLoss;
                  int formID;
                  if (JRMCoreConfig.hregen && isFoodLevelNotNull && curBody < maxBody && (state == 0 && race != 4 || state <= 4 && race == 4) && state2 == 0 && epoch > lastAttackedTimer && heat <= 0) {
                     lvlLoss = JRMCoreH.regenRate(powerType, maxBody, RRBody) * (double)((float)JRMCoreConfig.hRgnRt * 0.5F);
                     if (JRMCoreH.isRaceArcosian(race)) {
                        lvlLoss = JRMCoreH.getKiRegenArcosian(playerAttributes, lvlLoss, state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                     }

                     lvlLoss *= release < 5 ? 1.0D : (release < 10 ? 0.5D : (release < 15 ? 0.25D : 0.0D));
                     if (lvlLoss >= 0.0D) {
                        lvlLoss = lvlLoss < 1.0D ? 1.0D : lvlLoss;
                        if (!isMedicationActive && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
                           formID = JRMCoreH.SklLvl(powerType == 1 ? 7 : 11, powerType, playerSkills);
                           if (formID > 0) {
                              lvlLoss += (double)(JRMCoreConfig.SklMedRate * (float)formID * 0.1F) * lvlLoss;
                           }
                        }

                        formID = (int)((double)curBody + lvlLoss);
                        JRMCoreH.setInt((int)(formID > maxBody ? maxBody : formID), player, "jrmcBdy");
                     }
                  } else if (!isFoodLevelNotNull) {
                     int all = (int)((double)curBody - (double)maxBody * 0.05D);
                     JRMCoreH.setInt((int)(all <= 0 ? 0 : all), player, "jrmcBdy");
                  }

                  float costMulti;
                  float costMulti;
                  int max2;
                  byte EXPERIENCE_PAIN_MODE;
                  if (JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_ENABLED && JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isRaceMajin(race)) {
                     if (!JRMCoreH.isInCreativeMode(player) && isFoodLevelNotNull && curBody < maxBody && !isAuraNotOn) {
                        EXPERIENCE_PAIN_MODE = JGRaceHelper.getRacialSkillLevel(nbt);
                        if (EXPERIENCE_PAIN_MODE > 0) {
                           max2 = JRMCoreH.getMajinFormID(state, isMysticOn, isUltraInstinctOn, isGoDOn);
                           float[] healthGain = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[max2];
                           float[] kiCost = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[max2];
                           float[] staminaCost = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[max2];
                           costMulti = (float)maxBody * healthGain[1] + healthGain[0];
                           costMulti = (float)maxEnergy * kiCost[1] + kiCost[0];
                           float staminaCostFull = (float)maxStam * staminaCost[1] + staminaCost[0];
                           int lvl = EXPERIENCE_PAIN_MODE - 1;
                           costMulti *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[lvl];
                           costMulti *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[lvl];
                           staminaCostFull *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[lvl];
                           if (curEnergy >= (int)costMulti && curStam >= (int)staminaCostFull) {
                              curEnergy -= (int)costMulti;
                              if (curEnergy > maxEnergy) {
                                 curEnergy = maxEnergy;
                              } else if (curEnergy < 0) {
                                 curEnergy = 0;
                              }

                              JRMCoreH.setInt((int)curEnergy, player, "jrmcEnrgy");
                              curStam -= (int)staminaCostFull;
                              if (curStam > maxStam) {
                                 curStam = maxStam;
                              } else if (curStam < 0) {
                                 curStam = 0;
                              }

                              JRMCoreH.setInt((int)curStam, player, "jrmcStamina");
                              curBody += (int)costMulti;
                              if (curBody > maxBody) {
                                 curBody = maxBody;
                              } else if (curBody < 0) {
                                 curBody = 0;
                              }

                              JRMCoreH.setInt((int)curBody, player, "jrmcBdy");
                           }
                        }
                     }

                     if (majinAbsorptionTimer > 0) {
                        --majinAbsorptionTimer;
                        nbt.func_74768_a("jrmcMajinAbsorptionTimer", majinAbsorptionTimer);
                     }
                  }

                  if (JRMCoreConfig.regen && isFoodLevelNotNull && curEnergy < maxEnergy && (state == 0 && race != 4 || state <= 4 && race == 4) && state2 == 0 && epoch > lastAttackedTimer) {
                     lvlLoss = JRMCoreH.regenRate(powerType, maxEnergy, RREnergy) * (double)((float)JRMCoreConfig.rgnRt * 0.75F);
                     if (JRMCoreH.isRaceArcosian(race)) {
                        lvlLoss = JRMCoreH.getKiRegenArcosian(playerAttributes, lvlLoss, state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                     }

                     lvlLoss = lvlLoss * (double)(50 - release) * 0.019999999552965164D;
                     if (lvlLoss >= 0.0D) {
                        lvlLoss = lvlLoss < 1.0D ? 1.0D : lvlLoss;
                        if (!isMedicationActive && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
                           formID = JRMCoreH.SklLvl(powerType == 1 ? 7 : 11, powerType, playerSkills);
                           if (formID > 0) {
                              lvlLoss += (double)(JRMCoreConfig.SklMedRate * (float)formID * 0.1F) * lvlLoss;
                           }
                        }

                        if (!statusEffectTurboSwoop || !(lvlLoss > 0.0D)) {
                           formID = (int)((double)curEnergy + lvlLoss);
                           JRMCoreH.setInt((int)(formID > maxEnergy ? maxEnergy : formID), player, "jrmcEnrgy");
                        }
                     }
                  }

                  if (isFoodLevelNotNull && curStam < maxStam && (!isMedicationActive || isAuraNotOn) && !JRMCoreH.StusEfcts(7, statusEffects)) {
                     lvlLoss = JRMCoreH.regenRate(powerType, maxStam, RRStam) * 16.0D;
                     formID = (int)((double)curStam + lvlLoss);
                     JRMCoreH.setInt((int)(formID > maxStam ? maxStam : formID), player, "jrmcStamina");
                  }

                  int tpLong;
                  if ((state > 0 && race != 4 || race == 4 && state > 4) && curEnergy >= 0) {
                     lvlLoss = (double)(powerType == 2 ? -0.1F : 1.0F);
                     if (!JRMCoreH.isInCreativeMode(player)) {
                        if (JRMCoreH.isRaceFullSaiyan(race)) {
                           lvlLoss = JRMCoreH.getKiRegenSaiyan(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        } else if (JRMCoreH.isRaceHalfSaiyan(race)) {
                           lvlLoss = JRMCoreH.getKiRegenHalfSaiyan(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        } else if (JRMCoreH.isRaceArcosian(race)) {
                           lvlLoss = JRMCoreH.getKiRegenArcosian(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        } else if (JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isRaceNamekian(race)) {
                           lvlLoss = JRMCoreH.getKiRegenNamekian(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        } else if (JRMCoreH.isRaceMajin(race)) {
                           lvlLoss = JRMCoreH.getKiRegenMajin(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        } else if (JRMCoreH.isPowerTypeKi(powerType) && !JRMCoreH.isRaceArcosian(race)) {
                           lvlLoss = JRMCoreH.getKiRegenHuman(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
                        }
                     }

                     failSafe = release < 5 ? 5 : release;
                     lvlLoss *= (double)(powerType == 1 ? (float)failSafe * 0.01F : 1.0F);
                     if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType) && lvlLoss != 0.0D) {
                        tpLong = JRMCoreH.getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
                        double masteryLevel = JRMCoreH.getFormMasteryValue(player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
                        costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, tpLong, JGConfigDBCFormMastery.DATA_ID_COST_MULTI);
                        lvlLoss *= (double)costMulti;
                     }

                     tpLong = (int)((double)curEnergy + lvlLoss < 0.0D ? 0.0D : (double)curEnergy + lvlLoss);
                     JRMCoreH.setInt((int)(tpLong > maxEnergy ? maxEnergy : tpLong), player, "jrmcEnrgy");
                     if (tpLong < 1) {
                        JRMCoreH.setByte((int)0, player, "jrmcRelease");
                        nbt.func_74774_a("jrmcState", (byte)(race == 4 ? 4 : 0));
                        nbt.func_74774_a("jrmcState2", (byte)0);
                        JRMCoreH.setInt((int)((int)((double)curBody + (double)curEnergy + lvlLoss)), player, "jrmcBdy");
                     }
                  }

                  double masteryLevel;
                  if (JRMCoreH.isPowerTypeKi(powerType) && JGConfigDBCGoD.CONFIG_GOD_ENABLED && isGoDOn) {
                     if (alignment > JGConfigDBCGoD.CONFIG_GOD_MAX_ALIGNMENT && isGoDOn) {
                        isGoDOn = false;
                        statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && !JRMCoreH.isInCreativeMode(player)) {
                        hasTurbo = JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA ? jgPlayer.hasStatusEffect(3, statusEffects) : true;
                        if (hasTurbo) {
                           float cost = JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[1] * (float)maxEnergy;
                           cost += JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[0];
                           if (JGConfigDBCFormMastery.FM_Enabled && cost != 0.0F) {
                              formID = JRMCoreH.getFormID("GodOfDestruction", race);
                              masteryLevel = JRMCoreH.getFormMasteryValue(player, formID);
                              costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_GOD_AURA_COST_MULTI);
                              cost *= costMulti;
                           }

                           if (curEnergy > (int)cost) {
                              curEnergy -= (int)cost;
                           } else {
                              if (JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA) {
                                 statusEffects = JRMCoreH.StusEfcts(3, statusEffects, (NBTTagCompound)nbt, false);
                              } else if (isGoDOn) {
                                 isGoDOn = false;
                                 statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                              }

                              curEnergy = 0;
                           }

                           JRMCoreH.setInt((int)curEnergy, player, "jrmcEnrgy");
                        }
                     }
                  } else if (!JGConfigDBCGoD.CONFIG_GOD_ENABLED && isGoDOn) {
                     isGoDOn = false;
                     statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                  }

                  if (JRMCoreH.isPowerTypeKi(powerType) && state2 > 0) {
                     if (isKaiokenOn) {
                        if (!JRMCoreH.isInCreativeMode(player)) {
                           lvlLoss = JRMCoreH.KaiKCost(player) * (double)maxBody;
                           formID = (int)((double)curBody - lvlLoss < 1.0D ? 1.0D : (double)curBody - lvlLoss);
                           JRMCoreH.setInt((int)formID, player, "jrmcBdy");
                           if ((float)formID <= (float)maxBody * 0.1F) {
                              JRMCoreH.setByte((int)0, player, "jrmcRelease");
                              nbt.func_74774_a("jrmcState", (byte)(JRMCoreH.rc_arc(race) ? 4 : 0));
                              nbt.func_74774_a("jrmcState2", (byte)0);
                              state2 = 0;
                              JRMCoreH.setInt((int)formID, player, "jrmcBdy");
                           }
                        }
                     } else if (isUltraInstinctOn) {
                        EXPERIENCE_PAIN_MODE = JGConfigUltraInstinct.CONFIG_UI_LEVELS;
                        max2 = JRMCoreH.SklLvl(16, (EntityPlayer)player);
                        if (EXPERIENCE_PAIN_MODE != 0 && max2 != 0) {
                           if (state2 > EXPERIENCE_PAIN_MODE) {
                              JRMCoreH.setByte((int)EXPERIENCE_PAIN_MODE, player, "jrmcState2");
                           } else if (state2 > max2) {
                              JRMCoreH.setByte((int)max2, player, "jrmcState2");
                           }
                        } else {
                           state2 = 0;
                           JRMCoreH.setByte((byte)0, player, "jrmcState2");
                           if (isUltraInstinctOn) {
                              isUltraInstinctOn = false;
                              statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                           }
                        }
                     }
                  } else if (isKaiokenOn) {
                     statusEffects = JRMCoreH.StusEfcts(5, statusEffects, (NBTTagCompound)nbt, false);
                  } else if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0 && isUltraInstinctOn) {
                     statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                  }

                  JRMCoreH.KaiKStrainAct(player, nbt, state2, strain, strainTemporary, strainActive);
                  if (strainGod > 0) {
                     --strainGod;
                     nbt.func_74768_a("jrmcGodStrain", strainGod);
                  }

                  if (strainPain > 0) {
                     --strainPain;
                     nbt.func_74768_a("jrmcGyJ7dp", strainPain);
                     if (!JRMCoreH.isInCreativeMode(player)) {
                        curBody -= (int)((float)maxBody * 1.0E-4F);
                        if (curBody < 0) {
                           curBody = 0;
                        }

                        JRMCoreH.setInt((int)curBody, player, "jrmcBdy");
                     }
                  }

                  if (godPowerTimer > 0) {
                     --godPowerTimer;
                     nbt.func_74768_a("jrmcGodPwr", godPowerTimer);
                  } else if (state == 11) {
                     nbt.func_74774_a("jrmcState", (byte)0);
                  }

                  if (JRMCoreH.isPowerTypeKi(powerType)) {
                     if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
                        instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
                        String[] values = instantTransmissionTimers.split(";");
                        formID = Integer.parseInt(values[0]);
                        if (formID > 0) {
                           --formID;
                        }

                        tpLong = Integer.parseInt(values[1]);
                        if (tpLong > 0) {
                           --tpLong;
                        }

                        JRMCoreH.setString(formID + ";" + tpLong, player, "jrmcInstantTransmissionTimers");
                     } else {
                        instantTransmissionTimers = "0;0";
                        JRMCoreH.setString(instantTransmissionTimers, player, "jrmcInstantTransmissionTimers");
                     }
                  }

                  double costMulti;
                  if (JRMCoreH.isPowerTypeKi(powerType) && JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
                     double masteryLevel;
                     int pain;
                     if (isUltraInstinctOn) {
                        lvlLoss = 1.0D;
                        double masteryLevel = 0.0D;
                        pain = 0;
                        if (JGConfigDBCFormMastery.FM_Enabled) {
                           pain = JRMCoreH.getFormID("UltraInstict", race);
                           masteryLevel = JRMCoreH.getFormMasteryValue(player, pain);
                           lvlLoss = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, pain, JGConfigDBCFormMastery.DATA_ID_UI_HEALTH_REQ_MULTI);
                        }

                        if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[JRMCoreH.state2UltraInstinct(isKaiokenOn, state2)] > 0) {
                           costMulti = 1.0D;
                           if (JGConfigDBCFormMastery.FM_Enabled) {
                              double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, pain, JGConfigDBCFormMastery.DATA_ID_UI_HEAT_MULTI);
                              costMulti *= costMulti;
                           }

                           heatD += costMulti;
                           heat += (int)heatD;
                           heatD -= (double)((int)heatD);
                           nbt.func_74780_a("jrmcEf8slcD", heatD);
                           nbt.func_74768_a("jrmcEf8slc", heat);
                        }

                        byte[] healthPercentage = JGConfigUltraInstinct.CONFIG_UI_HEALTH_PERCENTAGE;
                        masteryLevel = (double)healthPercentage[JRMCoreH.state2UltraInstinct(isKaiokenOn, state2)] * lvlLoss;
                        if (maxBody > 0 && (double)(curBody / (maxBody / 100)) > masteryLevel || release <= 0) {
                           if (isUltraInstinctOn) {
                              isUltraInstinctOn = false;
                              statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                           }

                           nbt.func_74774_a("jrmcState2", (byte)0);
                           state2 = nbt.func_74771_c("jrmcState2");
                        }
                     } else if (heat > 0) {
                        if (heatD != 0.0D) {
                           nbt.func_74780_a("jrmcEf8slcD", 0.0D);
                           heatD = 0.0D;
                        } else {
                           --heat;
                           nbt.func_74768_a("jrmcEf8slc", heat);
                        }
                     }

                     EXPERIENCE_PAIN_MODE = JGConfigUltraInstinct.CONFIG_UI_EXPERIENCE_PAIN_MODE;
                     byte WAS_IN_PAIN = nbt.func_74771_c("jrmcUIWasInPain");
                     if (EXPERIENCE_PAIN_MODE == 2 && WAS_IN_PAIN > 0) {
                        formID = nbt.func_74762_e("jrmcUIWasInPainDuration");
                        ++formID;
                        nbt.func_74768_a("jrmcUIWasInPainDuration", formID);
                        if (formID > JGConfigUltraInstinct.CONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION) {
                           nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
                           nbt.func_74774_a("jrmcUIWasInPain", (byte)0);
                        }
                     } else {
                        nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
                     }

                     formID = JRMCoreH.state2UltraInstinct(isKaiokenOn, state2);
                     if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[formID] > 0 && heat >= JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[formID]) {
                        nbt.func_74768_a("jrmcEf8slc", 0);
                        nbt.func_74780_a("jrmcEf8slcD", 0.0D);
                        nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
                        byte UI_HighestStateReached = nbt.func_74771_c("jrmcUIStateReach");
                        if (UI_HighestStateReached >= JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION.length) {
                           UI_HighestStateReached = (byte)(JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION.length - 1);
                        }

                        pain = JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION[UI_HighestStateReached] * 60 / 5;
                        if (JGConfigDBCFormMastery.FM_Enabled && pain != 0) {
                           int formID = JRMCoreH.getFormID("UltraInstict", race);
                           masteryLevel = JRMCoreH.getFormMasteryValue(player, formID);
                           double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_PAIN_MULTI);
                           pain = (int)((double)((float)pain) * costMulti);
                        }

                        nbt.func_74768_a("jrmcGyJ7dp", pain);
                        nbt.func_74774_a("jrmcUIWasInPain", (byte)1);
                        state2 = 0;
                        JRMCoreH.setByte((byte)0, player, "jrmcState2");
                        if (isUltraInstinctOn) {
                           isUltraInstinctOn = false;
                           statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                        }
                     }
                  }

                  if (ko > 0) {
                     --ko;
                     nbt.func_74768_a("jrmcHar4va", ko);
                     JRMCoreH.setByte((byte)(state = race == 4 ? (state < 4 ? state : 4) : 0), player, "jrmcState");
                     state2 = 0;
                     JRMCoreH.setByte((byte)0, player, "jrmcState2");
                     release = 0;
                     JRMCoreH.setByte((byte)0, player, "jrmcRelease");
                     curStam = 0;
                     JRMCoreH.setInt((int)0, player, "jrmcStamina");
                     if (isUltraInstinctOn) {
                        isUltraInstinctOn = false;
                        statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (isMysticOn) {
                        isMysticOn = false;
                        statusEffects = JRMCoreH.StusEfcts(13, statusEffects, (NBTTagCompound)nbt, false);
                     }

                     if (isGoDOn) {
                        isGoDOn = false;
                        statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                     }
                  }

                  if (isMajinOn && alignment > 0) {
                     if (alignment > 99) {
                        JRMCoreH.StusEfcts(12, statusEffects, (EntityPlayer)player, false);
                     } else {
                        nbt.func_74774_a("jrmcAlign", (byte)0);
                     }
                  }

                  if (JRMCoreH.isPowerTypeKi(powerType)) {
                     if (isKaiokenOn && strainPain > 0 && curBody > 0 && !JRMCoreH.isInCreativeMode(player)) {
                        curBody = (int)((float)curBody - (float)maxBody * 0.8F);
                        if (curBody < 0) {
                           curBody = 0;
                        }

                        JRMCoreH.setInt((int)curBody, player, "jrmcBdy");
                     }

                     if (isMysticOn && isUltraInstinctOn || isMysticOn && isGoDOn || isGoDOn && isUltraInstinctOn) {
                        if (curBody > 0 && !JRMCoreH.isInCreativeMode(player)) {
                           curBody -= maxBody;
                           if (curBody < 0) {
                              curBody = 0;
                           }

                           JRMCoreH.setInt((int)curBody, player, "jrmcBdy");
                        }

                        if (isUltraInstinctOn) {
                           isUltraInstinctOn = false;
                           statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                        }

                        if (isMysticOn) {
                           isMysticOn = false;
                           statusEffects = JRMCoreH.StusEfcts(13, statusEffects, (NBTTagCompound)nbt, false);
                        }

                        if (isGoDOn) {
                           isGoDOn = false;
                           statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                        }
                     }

                     if (isGoDOn && (GoDLevel <= 0 || !isInBaseState || !hasGodForm)) {
                        statusEffects = JRMCoreH.StusEfcts(20, statusEffects, (NBTTagCompound)nbt, false);
                        if (!hasGodForm) {
                           statusEffects = JRMCoreH.StusEfcts(19, statusEffects, (NBTTagCompound)nbt, false);
                        }
                     }
                  }

                  if (JRMCoreH.isPowerTypeKi(powerType) && mysticLevel > 0) {
                     if (JRMCoreConfig.MystTim > 0.0D) {
                        lvlLoss = (double)((float)(360.0D * JRMCoreConfig.MystTim));
                        if (JGConfigDBCFormMastery.FM_Enabled && lvlLoss != 0.0D) {
                           formID = JRMCoreH.getFormID("Mystic", race);
                           masteryLevel = JRMCoreH.getFormMasteryValue(player, formID);
                           costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_MYSTIC_TIMER_MULTI);
                           lvlLoss *= (double)((float)costMulti);
                        }

                        if ((double)mysticTimer > lvlLoss) {
                           JRMCoreH.SklLvl(10, JRMCoreH.DBCSkillsIDs, playerSkills, player, -1);
                           nbt.func_74768_a("jrmcUltmtTm", 0);
                        } else {
                           ++mysticTimer;
                           nbt.func_74768_a("jrmcUltmtTm", mysticTimer);
                        }
                     }
                  } else if (isMysticOn) {
                     isMysticOn = false;
                     statusEffects = JRMCoreH.StusEfcts(13, statusEffects, (NBTTagCompound)nbt, false);
                  }
               }

               if (curEnergy < 0) {
                  JRMCoreH.setInt((int)0, player, "jrmcEnrgy");
               } else if (curEnergy > maxEnergy) {
                  JRMCoreH.setInt((int)maxEnergy, player, "jrmcEnrgy");
               }

               if (curBody < 0) {
                  JRMCoreH.setInt((int)0, player, "jrmcBdy");
               } else if (curBody > maxBody) {
                  JRMCoreH.setInt((int)maxBody, player, "jrmcBdy");
               }

               if (curStam < 0) {
                  JRMCoreH.setInt((int)0, player, "jrmcStamina");
               } else if (curStam > maxStam) {
                  JRMCoreH.setInt((int)maxStam, player, "jrmcStamina");
               }

               if (JRMCoreH.isInCreativeMode(player)) {
                  if (curBody < maxBody) {
                     JRMCoreH.setInt((int)maxBody, player, "jrmcBdy");
                  }

                  if (curEnergy < maxEnergy) {
                     JRMCoreH.setInt((int)maxEnergy, player, "jrmcEnrgy");
                  }

                  if (curStam < maxStam) {
                     JRMCoreH.setInt((int)maxStam, player, "jrmcStamina");
                  }
               }

               if (JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED) {
                  if (race == 5 && JRMCoreH.isPowerTypeKi(powerType)) {
                     if (absorption != null && absorption.length() != 0 && !absorption.equals("0")) {
                        if (absorption.split(",").length != 3) {
                           String[] prevAbs = jgPlayer.getAbsorption().split(",");
                           String result = "";

                           for(i = 0; i < 3; ++i) {
                              result = result + (prevAbs.length <= i ? (i == 2 ? "0+0" : "0") : prevAbs[i]) + (i + 1 < 3 ? "," : "");
                           }
                        }
                     } else {
                        nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
                     }

                     level = Integer.parseInt(absorption.split(",")[0]);
                     if (level > JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL) {
                        for(i = 0; i < absorption.length(); ++i) {
                           if (absorption.charAt(i) == ',') {
                              String s = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL + "" + absorption.substring(i);
                              nbt.func_74778_a("jrmcMajinAbsorptionData", s);
                              break;
                           }
                        }
                     } else if (level < 0) {
                        nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
                     }
                  } else if (!absorption.equals("0,0,0+0")) {
                     nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
                  }
               }

               if (race == 4) {
                  boolean isUltraInstinctOn = JRMCoreH.StusEfcts(19, statusEffects);
                  isInBaseState = JRMCoreH.StusEfcts(13, statusEffects);
                  boolean isGoDOn = JRMCoreH.StusEfcts(20, statusEffects);
                  int stateID = JRMCoreH.getArcosianFormID(state, isInBaseState, isUltraInstinctOn, isGoDOn);
                  if (JRMCoreConfig.ArcosianPPGrowth[stateID] > 0 && release < 50) {
                     nbt.func_74768_a("jrmcArcRsrv", resrv = JRMCoreH.updateArcosianPowerPoints(resrv, SkillXNbt, state, stateID));
                  }

                  if (release == 100 && JRMCoreConfig.ArcosianPPCost[stateID] > 0 && resrv > 0) {
                     int formID = JRMCoreH.getCurrentFormID(race, state, state2, false, isInBaseState, isUltraInstinctOn, isGoDOn);
                     float ppCost = (float)(JRMCoreConfig.ArcosianPPCost[stateID] < 0 ? 0 : JRMCoreConfig.ArcosianPPCost[stateID]);
                     if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType) && ppCost != 0.0F) {
                        double masteryLevel = JRMCoreH.getFormMasteryValue(player, formID);
                        int arcosianPPID = JGConfigDBCFormMastery.getDataID_ArcosianPPCostMulti(race, formID);
                        double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, arcosianPPID);
                        ppCost *= (float)costMulti;
                     }

                     resrv -= (int)ppCost;
                     nbt.func_74768_a("jrmcArcRsrv", resrv);
                  }
               }

               level = JRMCoreH.getInt(player, "jrmcReviveTmer");
               isInBaseState = true;
               if (this.dbc) {
                  if (JRMCoreHDBC.FreeRev() && level > 0) {
                     JRMCoreH.setInt((int)(level - 1), player, "jrmcReviveTmer");
                  }

                  isInBaseState = JRMCoreHDBC.DBCboolPlyrDimNotOtherworld(player);
               }

               i = nbt.func_74762_e("jrmcAlCntr");
               if (isInBaseState && i < 500000) {
                  nbt.func_74768_a("jrmcAlCntr", i + 1);
               }

               this.updateFusion(player, nbt, curBody, curEnergy, statusEffects);
            }
         }

         if (this.updateEveryXTick(50)) {
            this.updateMeditation(player, jgPlayer, nbt);
         }

         if (this.updateEveryXTick(10)) {
            this.updatePlayersData(server, playerID, player, jgPlayer, nbt);
         }
      }

      if (JRMCoreH.DBC()) {
         JRMCoreHDBC.DBCCommonTickHandlerWorldGenBuildingsResetted(server);
      }

      if (JRMCoreH.NC()) {
         JRMCoreHNC.NCCommonTickHandlerWorldGenBuildingsResetted(server);
      }

      this.sendPlayerData(server, playersCount);
      if (tick >= 100) {
         tick = -1;
      }

      ++tick;
   }

   public boolean updateEveryXTick(int updateTick) {
      return JRMCoreH.updateEveryXTick(tick, updateTick);
   }

   public static void rd() {
      File j = new File(JRMCore.configDir, "jingames.dat");
      if (j.exists()) {
         try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(j));
            JRMCss data = (JRMCss)gson.fromJson(reader, JSN_TYPE_ss);
            JRMCoreConfig.ssc = JRMCoreConfig.cssc = data.sc;
            JRMCoreConfig.ssurl = JRMCoreConfig.cssurl = data.su;
            JRMCoreConfig.ssurl2 = JRMCoreConfig.cssurl2 = data.su2;
            mod_JRMCore.logger.info("Sloaded!");
            return;
         } catch (FileNotFoundException var5) {
            var5.printStackTrace();
         }
      }

   }

   private void send(String[] playerData, String finalSendData, int players, int dataID) {
      if (playerData != null) {
         String playerDatas = ":";

         int dividePerPlayercount;
         for(dividePerPlayercount = 0; dividePerPlayercount < players; ++dividePerPlayercount) {
            if (playerData[dividePerPlayercount] != null) {
               playerDatas = playerDatas + ":" + playerData[dividePerPlayercount];
            }
         }

         playerDatas = playerDatas.replaceAll("::", "");
         if (!playerDatas.equals(finalSendData) && !playerDatas.equals(":")) {
            if (dataID == 32) {
               dividePerPlayercount = JGConfigDBCFormMastery.FM_Data_Separation_Per_Player;
               if (players > dividePerPlayercount) {
                  int segments = players / dividePerPlayercount;
                  if ((float)players / (float)dividePerPlayercount % (float)dividePerPlayercount != 0.0F) {
                     ++segments;
                  }

                  int iLastID = 0;

                  for(int j = 0; j < segments; ++j) {
                     playerDatas = ":";

                     for(int i = 0; i < players / segments || j == segments - 1 && iLastID < players; ++i) {
                        if (playerData.length > iLastID && playerData[iLastID] != null) {
                           playerDatas = playerDatas + ":" + playerData[iLastID];
                        }

                        ++iLastID;
                     }

                     playerDatas = playerDatas.replaceAll("::", "");
                     String segmentS = "::" + j + "/" + segments + "/" + players + "/" + iLastID + "::";
                     jrmcData(dataID, segmentS + playerDatas);
                  }
               } else {
                  jrmcData(dataID, playerDatas);
               }
            } else {
               jrmcData(dataID, playerDatas);
            }

            sdm(playerDatas, dataID);
         }

         adn(dataID);
      }

   }

   private void sendToP(String[] playerData, String finalSendData, int players, int dataID, MinecraftServer server) {
      if (playerData != null) {
         String playerDatas = ":";

         int i;
         for(i = 0; i < players; ++i) {
            if (playerData[i] != null) {
               playerDatas = playerDatas + ":" + playerData[i];
            }
         }

         playerDatas = playerDatas.replaceAll("::", "");
         if (!playerDatas.equals(finalSendData) && !playerDatas.equals(":")) {
            for(i = 0; i < players; ++i) {
               EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[i]);
               String playerDataI = playerData[i];
               String[] finalSendDatas = finalSendData != null ? finalSendData.split(":") : null;
               if (playerData.length - 1 >= i && (finalSendDatas == null || finalSendDatas.length <= i || !playerDataI.equals(finalSendDatas[i]))) {
                  jrmcDataToP(dataID, playerDataI, player);
               }
            }

            sdm(playerDatas, dataID);
         }

         adn(dataID);
      }

   }

   public static void sdm(String d, int dataID) {
      if (dataID == 0) {
         sentData0 = d;
      } else if (dataID == -1) {
         sentNames = d;
      } else if (dataID == 1) {
         sentData1 = d;
      } else if (dataID == 2) {
         sentData2 = d;
      } else if (dataID == 3) {
         sentData3 = d;
      } else if (dataID == 4) {
         sentData4 = d;
      } else if (dataID == 5) {
         sentData5 = d;
      } else if (dataID == 6) {
         sentData6 = d;
      } else if (dataID == 7) {
         sentData7 = d;
      } else if (dataID == 8) {
         sentData8 = d;
      } else if (dataID == 9) {
         sentData9 = d;
      } else if (dataID == 10) {
         sentDat10 = d;
      } else if (dataID == 11) {
         sentDat11 = d;
      } else if (dataID == 12) {
         sentDat12 = d;
      } else if (dataID == 13) {
         sentDat13 = d;
      } else if (dataID == 14) {
         sentDat14 = d;
      } else if (dataID == 15) {
         sentDat15 = d;
      } else if (dataID == 16) {
         sentDat16 = d;
      } else if (dataID == 17) {
         sentDat17 = d;
      } else if (dataID == 18) {
         sentDat18 = d;
      } else if (dataID == 19) {
         sentDat19 = d;
      } else if (dataID == 20) {
         sentDat20 = d;
      } else if (dataID == 21) {
         sentDat21 = d;
      } else if (dataID == 22) {
         sentDat22 = d;
      } else if (dataID == 23) {
         sentDat23 = d;
      } else if (dataID == 24) {
         sentDat24 = d;
      } else if (dataID == 25) {
         sentDat25 = d;
      } else if (dataID == 26) {
         sentDat26 = d;
      } else if (dataID == 27) {
         sentDat27 = d;
      } else if (dataID == 28) {
         sentDat28 = d;
      } else if (dataID == 29) {
         sentDat29 = d;
      } else if (dataID == 30) {
         sentDat30 = d;
      } else if (dataID == 31) {
         sentDat31 = d;
      } else if (dataID == 32) {
         sentDat32 = d;
      }

   }

   public static void adn(int dataID) {
      if (dataID == 0) {
         data0 = null;
      } else if (dataID == -1) {
         names = null;
      } else if (dataID == 1) {
         data1 = null;
      } else if (dataID == 2) {
         data2 = null;
      } else if (dataID == 3) {
         data3 = null;
      } else if (dataID == 4) {
         data4 = null;
      } else if (dataID == 5) {
         data5 = null;
      } else if (dataID == 6) {
         data6 = null;
      } else if (dataID == 7) {
         data7 = null;
      } else if (dataID == 8) {
         data8 = null;
      } else if (dataID == 9) {
         data9 = null;
      } else if (dataID == 10) {
         dat10 = null;
      } else if (dataID == 11) {
         dat11 = null;
      } else if (dataID == 12) {
         dat12 = null;
      } else if (dataID == 13) {
         dat13 = null;
      } else if (dataID == 14) {
         dat14 = null;
      } else if (dataID == 15) {
         dat15 = null;
      } else if (dataID == 16) {
         dat16 = null;
      } else if (dataID == 17) {
         dat17 = null;
      } else if (dataID == 18) {
         dat18 = null;
      } else if (dataID == 19) {
         dat19 = null;
      } else if (dataID == 20) {
         dat20 = null;
      } else if (dataID == 21) {
         dat21 = null;
      } else if (dataID == 22) {
         dat22 = null;
      } else if (dataID == 23) {
         dat23 = null;
      } else if (dataID == 24) {
         dat24 = null;
      } else if (dataID == 25) {
         dat25 = null;
      } else if (dataID == 26) {
         dat26 = null;
      } else if (dataID == 27) {
         dat27 = null;
      } else if (dataID == 28) {
         dat28 = null;
      } else if (dataID == 29) {
         dat29 = null;
      } else if (dataID == 30) {
         dat30 = null;
      } else if (dataID == 31) {
         dat31 = null;
      } else if (dataID == 32) {
         dat32 = null;
      }

   }

   public static int U5TBbT(String l) {
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

   public static int T5yLLW(int b) {
      String k = "3B9ACA00";
      return b > U5TBbT(k) * (h ? 2 : 1) ? U5TBbT(k) * (h ? 2 : 1) : b;
   }

   protected static void sS(EntityPlayer p, float par1, float par2) {
      float f2;
      if (par1 != p.field_70130_N || par2 != p.field_70131_O) {
         f2 = p.field_70130_N;
         p.field_70130_N = par1;
         p.field_70131_O = par2;
         p.boundingBox.field_72336_d = p.boundingBox.field_72340_a + (double)p.field_70130_N;
         p.boundingBox.field_72334_f = p.boundingBox.field_72339_c + (double)p.field_70130_N;
         p.boundingBox.field_72337_e = p.boundingBox.field_72338_b + (double)p.field_70131_O;
      }

      f2 = par1 % 2.0F;
      if ((double)f2 < 0.375D) {
         p.field_70168_am = EnumEntitySize.SIZE_1;
      } else if ((double)f2 < 0.75D) {
         p.field_70168_am = EnumEntitySize.SIZE_2;
      } else if ((double)f2 < 1.0D) {
         p.field_70168_am = EnumEntitySize.SIZE_3;
      } else if ((double)f2 < 1.375D) {
         p.field_70168_am = EnumEntitySize.SIZE_4;
      } else if ((double)f2 < 1.75D) {
         p.field_70168_am = EnumEntitySize.SIZE_5;
      } else {
         p.field_70168_am = EnumEntitySize.SIZE_6;
      }

   }

   public void countbackForLegendary(int playersCount) {
      if (this.dbc && playersCount > 0 && lf.size() < JRMCoreConfig.selgnd && JRMCoreConfig.selgndc2 > 0) {
         --cbl;
         if (cbl < 0) {
            double random = Math.random();
            if (playersCount > JRMCoreConfig.selgndc2 || random < (double)((float)JRMCoreConfig.selgndc * 0.01F)) {
               Random rnd = new Random();
               chsn = rnd.nextInt(playersCount);
            }

            cbl = 24000;
         }
      }

   }

   public void serverStart(MinecraftServer server) {
      if (start) {
         tna3fu = server.func_71266_T();
         JRMCoreM.om(server);
         rd();
         bs = JRMCoreH.bsrwi(server);
         if (this.nc) {
            JRMCoreHNC.WorldGenBuildingsSpawnCheck(server);
         }

         if (this.dbc) {
            JRMCoreHDBC.WorldGenBuildingsSpawnCheck(server);
         }

         start = false;
         if (JRMCoreConfig.osbic > 0) {
            op = true;
            JRMCoreH.osbic = new HashMap();
         }
      }

   }

   public void checkBuildingsSpawn(MinecraftServer server) {
      if (bldngChkr && JRMCoreConfig.BuildingSpawnCheck) {
         if (this.dbc && bldngsChecker <= 0) {
            JRMCoreHDBC.spawnBuilds(server);
            if (this.nc) {
               JRMCoreHNC.spawnBuilds(server);
            }

            bldngsChecker = 300;
         } else {
            --bldngsChecker;
         }
      }

   }

   public void savePlayerData(int playersCount) {
      if (names == null || names.length != playersCount) {
         names = new String[playersCount];
      }

      if (data0 == null || data0.length != playersCount) {
         data0 = new String[playersCount];
      }

      if (data1 == null || data1.length != playersCount) {
         data1 = new String[playersCount];
      }

      if (data2 == null || data2.length != playersCount) {
         data2 = new String[playersCount];
      }

      if (data3 == null || data3.length != playersCount) {
         data3 = new String[playersCount];
      }

      if (data4 == null || data4.length != playersCount) {
         data4 = new String[playersCount];
      }

      if (this.dbc || this.nc || this.sao) {
         if (data5 == null || data5.length != playersCount) {
            data5 = new String[playersCount];
         }

         if (data6 == null || data6.length != playersCount) {
            data6 = new String[playersCount];
         }

         if (data7 == null || data7.length != playersCount) {
            data7 = new String[playersCount];
         }

         if (data8 == null || data8.length != playersCount) {
            data8 = new String[playersCount];
         }

         if (data9 == null || data9.length != playersCount) {
            data9 = new String[playersCount];
         }

         if (dat10 == null || dat10.length != playersCount) {
            dat10 = new String[playersCount];
         }

         if (dat11 == null || dat11.length != playersCount) {
            dat11 = new String[playersCount];
         }

         if (dat12 == null || dat12.length != playersCount) {
            dat12 = new String[playersCount];
         }

         if (dat13 == null || dat13.length != playersCount) {
            dat13 = new String[playersCount];
         }

         if (dat14 == null || dat14.length != playersCount) {
            dat14 = new String[playersCount];
         }

         if (dat15 == null || dat15.length != playersCount) {
            dat15 = new String[playersCount];
         }

         if (dat16 == null || dat16.length != playersCount) {
            dat16 = new String[playersCount];
         }

         if (dat17 == null || dat17.length != playersCount) {
            dat17 = new String[playersCount];
         }

         if (dat18 == null || dat18.length != playersCount) {
            dat18 = new String[playersCount];
         }

         if (dat19 == null || dat19.length != playersCount) {
            dat19 = new String[playersCount];
         }

         if (dat20 == null || dat20.length != playersCount) {
            dat20 = new String[playersCount];
         }

         if (dat21 == null || dat21.length != playersCount) {
            dat21 = new String[playersCount];
         }

         if (dat22 == null || dat22.length != playersCount) {
            dat22 = new String[playersCount];
         }

         if (dat23 == null || dat23.length != playersCount) {
            dat23 = new String[playersCount];
         }

         if (dat24 == null || dat24.length != playersCount) {
            dat24 = new String[playersCount];
         }

         if (dat25 == null || dat25.length != playersCount) {
            dat25 = new String[playersCount];
         }
      }

      if (this.jfc) {
         if (dat26 == null || dat26.length != playersCount) {
            dat26 = new String[playersCount];
         }

         if (dat27 == null || dat27.length != playersCount) {
            dat27 = new String[playersCount];
         }

         if (dat28 == null || dat28.length != playersCount) {
            dat28 = new String[playersCount];
         }

         if (dat29 == null || dat29.length != playersCount) {
            dat29 = new String[playersCount];
         }

         if (dat30 == null || dat30.length != playersCount) {
            dat30 = new String[playersCount];
         }
      }

      if (JRMCoreConfig.JRMCABonusOn && (dat31 == null || dat31.length != playersCount)) {
         dat31 = new String[playersCount];
      }

      if (JGConfigDBCFormMastery.FM_Enabled && this.dbc && (dat32 == null || dat32.length != playersCount)) {
         dat32 = new String[playersCount];
      }

   }

   public void nullifyPlayerData(int playersCount) {
      if (playersCount == 0 && sentNames != null) {
         sentNames = null;
         sentData0 = null;
         sentData1 = null;
         sentData2 = null;
         sentData3 = null;
         sentData4 = null;
         sentData5 = null;
         sentData6 = null;
         sentData7 = null;
         sentData8 = null;
         sentData9 = null;
         sentDat10 = null;
         sentDat11 = null;
         sentDat12 = null;
         sentDat13 = null;
         sentDat14 = null;
         sentDat15 = null;
         sentDat16 = null;
         sentDat17 = null;
         sentDat18 = null;
         sentDat19 = null;
         sentDat20 = null;
         sentDat21 = null;
         sentDat22 = null;
         sentDat23 = null;
         sentDat24 = null;
         sentDat25 = null;
         sentDat26 = null;
         sentDat27 = null;
         sentDat28 = null;
         sentDat29 = null;
         sentDat30 = null;
         sentDat31 = null;
         sentDat32 = null;
         names = null;
         data0 = null;
         data1 = null;
         data2 = null;
         data3 = null;
         data4 = null;
         data5 = null;
         data6 = null;
         data7 = null;
         data8 = null;
         data9 = null;
         dat10 = null;
         dat11 = null;
         dat12 = null;
         dat13 = null;
         dat14 = null;
         dat15 = null;
         dat16 = null;
         dat17 = null;
         dat18 = null;
         dat19 = null;
         dat20 = null;
         dat21 = null;
         dat22 = null;
         dat23 = null;
         dat24 = null;
         dat25 = null;
         dat26 = null;
         dat27 = null;
         dat28 = null;
         dat29 = null;
         dat30 = null;
         dat31 = null;
         dat32 = null;
      }

   }

   public void removeGroupMembers(MinecraftServer server) {
      if (this.c > 600) {
         HashMap<EntityPlayer, Integer> playerSagaIDs = new HashMap();
         Iterator var3 = server.func_71203_ab().field_72404_b.iterator();

         while(var3.hasNext()) {
            Object entityObject = var3.next();
            EntityPlayer player = (EntityPlayer)entityObject;
            int sagaID = JRMCoreH.getInt(player, "JRMCGID");
            playerSagaIDs.put(player, JRMCoreH.getInt(player, "JRMCGID"));
         }

         var3 = playerSagaIDs.keySet().iterator();

         while(var3.hasNext()) {
            EntityPlayer player = (EntityPlayer)var3.next();
            int id = 0;
            EntityPlayer previousMember = null;

            EntityPlayer player1;
            for(Iterator var7 = playerSagaIDs.keySet().iterator(); var7.hasNext(); previousMember = player1) {
               player1 = (EntityPlayer)var7.next();
               if (((Integer)playerSagaIDs.get(player)).equals(playerSagaIDs.get(player1))) {
                  if (id > 10) {
                     String n = JRMCoreH.getString(player1, "JRMCGLIDs");
                     if (!n.equalsIgnoreCase(player1.getName())) {
                        JRMCoreH.setString(" ", player1, "JRMCGLIDs");
                        JRMCoreH.setInt((int)0, player1, "JRMCGID");
                     } else if (previousMember != null) {
                        JRMCoreH.setString(" ", previousMember, "JRMCGLIDs");
                        JRMCoreH.setInt((int)0, previousMember, "JRMCGID");
                        playerSagaIDs.put(previousMember, 0);
                     }
                  }

                  ++id;
               }
            }
         }

         this.c = 0;
      }

   }

   public void offlineProtector(MinecraftServer server, int playersCount) {
      if (op) {
         playersCount = server.func_71213_z().length;
         HashMap<String, Integer> lo = new HashMap();

         for(int playerID = 0; playerID < playersCount; ++playerID) {
            String nm = server.func_71213_z()[playerID];
            Integer os = (Integer)JRMCoreH.osbic.get(nm);
            if (os != null && os >= JRMCoreConfig.osbic * 20) {
               lo.put(nm, JRMCoreConfig.osbic * 20);
            } else if (os != null) {
               lo.put(nm, os);
            }
         }

         JRMCoreH.osbic = lo;
      }

   }

   public void sendPlayerData(MinecraftServer server, int playersCount) {
      this.send(names, sentNames, playersCount, -1);
      this.send(data0, sentData0, playersCount, 0);
      this.send(data1, sentData1, playersCount, 1);
      this.send(data2, sentData2, playersCount, 2);
      this.send(data3, sentData3, playersCount, 3);
      this.send(data4, sentData4, playersCount, 4);
      if (this.dbc || this.nc || this.sao) {
         this.send(data5, sentData5, playersCount, 5);
         this.send(data6, sentData6, playersCount, 6);
         this.sendToP(data7, sentData7, playersCount, 7, server);
         this.send(data8, sentData8, playersCount, 8);
         this.send(data9, sentData9, playersCount, 9);
         this.send(dat10, sentDat10, playersCount, 10);
         this.send(dat11, sentDat11, playersCount, 11);
         this.send(dat12, sentDat12, playersCount, 12);
         this.send(dat13, sentDat13, playersCount, 13);
         this.send(dat14, sentDat14, playersCount, 14);
         this.sendToP(dat15, sentDat15, playersCount, 15, server);
         this.send(dat16, sentDat16, playersCount, 16);
         this.sendToP(dat17, sentDat17, playersCount, 17, server);
         this.send(dat18, sentDat18, playersCount, 18);
         this.send(dat19, sentDat19, playersCount, 19);
         this.sendToP(dat20, sentDat20, playersCount, 20, server);
         this.sendToP(dat21, sentDat21, playersCount, 21, server);
         this.sendToP(dat22, sentDat22, playersCount, 22, server);
         this.send(dat23, sentDat23, playersCount, 23);
         this.sendToP(dat24, sentDat24, playersCount, 24, server);
         this.sendToP(dat25, sentDat25, playersCount, 25, server);
      }

      if (this.jfc) {
         this.send(dat26, sentDat26, playersCount, 26);
         this.sendToP(dat27, sentDat27, playersCount, 27, server);
         this.sendToP(dat28, sentDat28, playersCount, 28, server);
         this.sendToP(dat29, sentDat29, playersCount, 29, server);
         this.send(dat30, sentDat30, playersCount, 30);
      }

      if (JRMCoreConfig.JRMCABonusOn) {
         this.send(dat31, sentDat31, playersCount, 31);
      }

      if (JGConfigDBCFormMastery.FM_Enabled && this.dbc) {
         this.send(dat32, sentDat32, playersCount, 32);
      }

   }

   public void updateFusion(EntityPlayerMP player, NBTTagCompound nbt, int curBody, int curEnergy, String statusEffects) {
      String fusionMembers = nbt.func_74779_i("jrmcFuzion");
      if (fusionMembers.length() == 0) {
         fusionMembers = " ";
         nbt.func_74778_a("jrmcFuzion", " ");
      }

      if (!fusionMembers.equals(" ")) {
         String[] fusionParticipants = fusionMembers.split(",");
         if (fusionParticipants.length == 3) {
            boolean isController = fusionParticipants[0].equalsIgnoreCase(player.getName());
            boolean isSpectator = fusionParticipants[1].equalsIgnoreCase(player.getName());
            if (isController || isSpectator) {
               EntityPlayer fusedPlayer = player.world.getPlayerEntityByName(fusionParticipants[isController ? 0 : 1]);
               boolean isFusedPlayerNotNull = fusedPlayer != null;
               if (isFusedPlayerNotNull) {
                  EntityPlayer otherFusedPlayer = player.world.getPlayerEntityByName(fusionParticipants[isController ? 1 : 0]);
                  boolean isOtherFusedPlayerNotNull = otherFusedPlayer != null;
                  int fusionTime = Integer.parseInt(fusionParticipants[2]) - 1;
                  boolean fused = true;
                  if (isOtherFusedPlayerNotNull) {
                     NBTTagCompound nbt2 = JRMCoreH.nbt(otherFusedPlayer);
                     String fusionMembers2 = nbt2.func_74779_i("jrmcFuzion");
                     String[] fusionParticipants2 = fusionMembers2.split(",");
                     if (fusionParticipants2.length == 3) {
                        if (isSpectator && fusionTime > 0 && player.func_70032_d(otherFusedPlayer) > 5.0F) {
                           player.func_70107_b(otherFusedPlayer.posX, otherFusedPlayer.posY, otherFusedPlayer.posZ);
                        }
                     } else if (fusionParticipants2.length == 1) {
                        fused = false;
                        nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                        JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt, false);
                        JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt, false);
                        nbt2.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                        JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt2, false);
                        JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt2, false);
                     }
                  } else {
                     nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                     JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt, false);
                     JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt, false);
                     fused = false;
                  }

                  if (fused) {
                     if (fusionTime <= 0) {
                        nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                        JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt, false);
                        JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt, false);
                     } else {
                        if (fusedPlayer.field_71093_bK != player.field_71093_bK) {
                           fusionTime = 0;
                        }

                        nbt.func_74778_a("jrmcFuzion", fusionParticipants[0] + "," + fusionParticipants[1] + "," + fusionTime);
                        if (isSpectator) {
                           nbt.func_74768_a("jrmcBdy", curBody);
                           nbt.func_74768_a("jrmcEnrgy", curEnergy);
                        }
                     }
                  }
               } else {
                  nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                  JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt, false);
                  JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt, false);
               }
            }
         } else if (fusionParticipants.length == 1) {
            int fusionOverTime = Integer.parseInt(fusionParticipants[0]) - 1;
            if (fusionOverTime <= 0) {
               nbt.func_74778_a("jrmcFuzion", " ");
            } else {
               nbt.func_74778_a("jrmcFuzion", "" + fusionOverTime);
            }
         }
      } else {
         if (JRMCoreH.StusEfcts(10, statusEffects)) {
            JRMCoreH.StusEfcts(10, (NBTTagCompound)nbt, false);
         }

         if (JRMCoreH.StusEfcts(11, statusEffects)) {
            JRMCoreH.StusEfcts(11, (NBTTagCompound)nbt, false);
         }
      }

   }

   public void updateMeditation(EntityPlayerMP player, JGPlayerMP jgPlayer, NBTTagCompound nbt) {
      byte powerType = nbt.func_74771_c("jrmcPwrtyp");
      if (JRMCoreConfig.SklMedCat == 0 && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
         String statusEffects = nbt.func_74779_i("jrmcStatusEff");
         if (statusEffects.contains(JRMCoreH.StusEfcts[4])) {
            int foodLevel = player.func_71024_bL().func_75116_a();
            boolean isFoodAboveZero = foodLevel > 0;
            if (isFoodAboveZero) {
               byte race = jgPlayer.getRace();
               byte classID = jgPlayer.getClassID();
               int[] playerAttributes = jgPlayer.getAttributes();
               String[] playerSkills = jgPlayer.getSkills();
               int curEnergy = jgPlayer.getEnergy();
               int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs((String[])playerSkills, powerType));
               if (curEnergy < maxEnergy) {
                  byte release = JRMCoreH.getByte(player, "jrmcRelease");
                  float RREnergy = (float)jgPlayer.getEnergyRegen(race, classID, powerType);
                  int curStam = jgPlayer.getStamina();
                  jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
                  float RRStam = (float)jgPlayer.getStaminaRegen(race, classID, powerType);
                  int meditationSkillLvl = JRMCoreH.SklLvl(powerType == 1 ? 7 : 11, powerType, playerSkills);
                  if (meditationSkillLvl > 0) {
                     double add = JRMCoreH.regenRate(powerType, maxEnergy, RREnergy) * (double)(JRMCoreConfig.SklMedRate * 10.0F * (float)meditationSkillLvl * 0.1F);
                     add = add * (double)release * 0.009999999776482582D;
                     if (add >= 0.0D) {
                        add = add < 1.0D ? 1.0D : add;
                        int all = (int)((double)curEnergy + add);
                        if ((double)curStam > add * 0.5D * JRMCoreConfig.dat5698) {
                           JRMCoreH.setInt((int)(all > maxEnergy ? maxEnergy : all), player, "jrmcEnrgy");
                           if (!JRMCoreH.isInCreativeMode(player)) {
                              JRMCoreH.setInt((int)((int)((double)curStam - add * 0.5D * JRMCoreConfig.dat5698)), player, "jrmcStamina");
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void updatePlayersData(MinecraftServer server, int playerID, EntityPlayerMP player, JGPlayerMP jgPlayer, NBTTagCompound nbt) {
      byte powerType = nbt.func_74771_c("jrmcPwrtyp");
      int sao_lvl = 0;
      int sao_exp = 0;
      if (powerType == 3) {
         sao_lvl = nbt.func_74762_e("saocLvl");
         sao_lvl = sao_lvl < 1 ? 1 : sao_lvl;
         sao_exp = nbt.func_74762_e("saocExp");
      }

      byte race = jgPlayer.getRace();
      int[] playerAttributes = jgPlayer.getAttributes();
      String dns = nbt.func_74779_i("jrmcDNS");
      byte rage = nbt.func_74771_c("jrmcSaiRg");
      int heat = nbt.func_74762_e("jrmcEf8slc");
      byte release = JRMCoreH.getByte(player, "jrmcRelease");
      byte alive = nbt.func_74771_c("jrmcAlv");
      String statusEffects = nbt.func_74779_i("jrmcStatusEff");
      int resrv = JRMCoreH.getInt(player, "jrmcArcRsrv");
      String absorption = JRMCoreH.getString(player, "jrmcMajinAbsorptionData");
      int strnAct = nbt.func_74762_e("jrmcStrainActv");
      int ac = nbt.func_74762_e("jrmcAlCntr");
      int strn = nbt.func_74762_e("jrmcStrain");
      int strng = nbt.func_74762_e("jrmcGodStrain");
      int strnp = nbt.func_74762_e("jrmcGyJ7dp");
      int gp = nbt.func_74762_e("jrmcGodPwr");
      int ko = nbt.func_74762_e("jrmcHar4va");
      boolean dead = alive == 1;
      byte i;
      if (this.dbc && dead && JRMCoreHDBC.DBCboolPlyrDimNotOtherworld(player) && player.func_70089_S() && !player.field_71075_bZ.field_75098_d && player != null) {
         byte alignmentID = 1;
         if (nbt.func_74781_a("jrmcAlign") != null) {
            i = nbt.func_74771_c("jrmcAlign");
            if (i > 66) {
               alignmentID = 0;
            } else if (i < 33) {
               alignmentID = 2;
            }
         }

         player.field_70154_o = null;
         player.field_70153_n = null;
         ChunkCoordinates chunkcoordinates = new ChunkCoordinates((int)DBCConfig.DeathDim[alignmentID][0], (int)DBCConfig.DeathDim[alignmentID][1], (int)DBCConfig.DeathDim[alignmentID][2]);
         if (player.getBedLocation(JRMCoreHDBC.otherworld()) != chunkcoordinates) {
            player.setSpawnChunk(chunkcoordinates, true, JRMCoreHDBC.otherworld());
         }

         JRMCoreHDBC.WorldTper(server, player, JRMCoreHDBC.otherworld());
         player.func_70634_a(DBCConfig.DeathDim[alignmentID][0], DBCConfig.DeathDim[alignmentID][1], DBCConfig.DeathDim[alignmentID][2]);
         player.func_71023_q(1);
         mod_JRMCore.logger.info(player.getName() + " Has died and gone to Otherworld.");
      }

      if (!player.field_71075_bZ.field_75098_d && (this.dbc || this.nc || this.sao) && powerType > 0 && nbt.func_74762_e("jrmcBdy") <= 0) {
         player.func_70097_a(DamageSource.field_76380_i, 6.0F);
      }

      if (!player.func_70608_bn()) {
         float f1 = 0.9375F;
         float f2 = 1.0F;
         float f3 = 1.0F;
         boolean noC = !JRMCoreH.DBC();
         if (JRMCoreH.dnsGender(JRMCoreH.dns) <= 1) {
            f1 = 0.73F + (noC ? 0.27F : 0.0F);
         }

         if (JRMCoreH.dnsGender(JRMCoreH.dns) >= 2) {
            f1 = 0.7F + (noC ? 0.27F : 0.0F);
         }

         float yc = 1.0F;
         float f1r;
         if (JRMCoreH.JYC()) {
            f1r = nbt.func_74760_g("JRYCAge");
            if (f1r <= 6.0F) {
               yc = 0.5F;
            }

            if (f1r > 6.0F && f1r <= 52.0F) {
               yc = (3.0F - (1.0F + (1.0F - (f1r - 6.0F) / 46.0F))) * 0.5F;
            }

            if (f1r > 53.0F) {
               yc = 1.0F;
            }

            yc = yc < 0.54347825F ? 0.54347825F : yc;
         }

         if (JRMCoreH.DBC() && JRMCoreConfig.sizes) {
            f1r = f1;
            byte state = nbt.func_74771_c("jrmcState");
            f1 += JRMCoreHDBC.DBCsizeBasedOnCns(playerAttributes);
            if (!JRMCoreH.isPowerTypeChakra(powerType)) {
               boolean divine = race == 3 ? jgPlayer.hasStatusEffect(17, jgPlayer.getStatusEffects()) : false;
               f2 = JRMCoreHDBC.DBCsizeBasedOnRace(race, state, divine);
               f3 = JRMCoreHDBC.DBCsizeBasedOnRace2(race, state, divine);
            }

            if (JRMCoreH.rSai(race) && (state == 7 || state == 8)) {
               release = 50;
               f1 = f1r;
            }

            float f3a = (f3 - 1.0F) * (float)release * 0.02F + 1.0F;
            f3 = f3a > f3 ? f3 : (f3 > 1.0F ? f3a : f3);
            float f2a = (f2 - 1.0F) * (float)release * 0.02F + 1.0F;
            f2 = f2 > 1.0F ? f2a : f2;
            float f1a1 = (f1 - f1r) * (release <= 50 ? 0.25F : 0.5F);
            float f1ac = f1a1 * (float)release * 0.02F;
            float f1ao = f1 - f1r - f1a1 + f1ac + f1r;
            f1 = f1ao;
            String Fzn = nbt.func_74779_i("jrmcFuzion");
            if (Fzn.contains(",")) {
               String[] FznA = Fzn.split(",");
               if (FznA.length == 3) {
                  boolean isp2 = FznA[1].equalsIgnoreCase(player.getName());
                  if (isp2) {
                     f1 = 0.0F;
                  }
               }
            }
         }

         f1r = height * f1 * f3 * yc;
         float clientWdth2 = width * f1 * f2 * f3 * yc;
         sS(player, clientWdth2, f1r);
         player.eyeHeight = player.getDefaultEyeHeight() * f1 * f3 * yc;
      }

      if (nbt.func_74781_a("jrmcAlign") == null) {
         nbt.func_74774_a("jrmcAlign", (byte)67);
      }

      if (nbt.func_74771_c("jrmcAlign") > 100) {
         nbt.func_74774_a("jrmcAlign", (byte)100);
      }

      if (nbt.func_74771_c("jrmcAlign") < 0) {
         nbt.func_74774_a("jrmcAlign", (byte)0);
      }

      if (nbt.func_74781_a("jrmcSSltX") == null) {
         nbt.func_74778_a("jrmcSSltX", "pty");
      }

      if (nbt.func_74781_a("jrmcSSltY") == null) {
         nbt.func_74778_a("jrmcSSltY", "pty");
      }

      if (nbt.func_74781_a("jrmcSSltZ") == null) {
         nbt.func_74778_a("jrmcSSltZ", "pty");
      }

      if ((race == 1 || race == 2 || race == 4) && nbt.func_74779_i("jrmcSSltX").contains("pty")) {
         nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(race, nbt.func_74771_c("jrmcClass"), nbt.func_74771_c("jrmcPwrtyp")));
      }

      if (nbt.func_74779_i("jrmcSSltY").contains("pty")) {
         nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(race, nbt.func_74771_c("jrmcClass"), nbt.func_74771_c("jrmcPwrtyp")));
      }

      String t1;
      String k;
      if (nbt.func_74781_a("jrmcSSlts") == null || nbt.func_74781_a(JRMCoreH.SkillsNbt[0]) != null) {
         k = "";
         mod_JRMCore.logger.info("The player " + player.getName() + " has been converted to the new skill list!");
         mod_JRMCore.logger.info("Old Skill list content");

         for(i = 0; i < JRMCoreH.SkillsNbt.length; ++i) {
            if (nbt.func_74781_a(JRMCoreH.SkillsNbt[i]) == null) {
               nbt.func_74778_a(JRMCoreH.SkillsNbt[i], "pty");
            }

            t1 = nbt.func_74779_i(JRMCoreH.SkillsNbt[i]);
            if (!t1.equals("pty") && t1.length() > 2) {
               mod_JRMCore.logger.info("Skill: " + JRMCoreH.SklName(t1, powerType == 1 ? JRMCoreH.DBCSkillsIDs : JRMCoreH.NCSkillIDs, powerType == 1 ? JRMCoreH.DBCSkillNames : JRMCoreH.NCSkillNames) + " lvl: " + (Integer.parseInt(t1.substring(2)) + 1));
            }

            k = k + t1 + ",";
         }

         if (k.length() == 0) {
            nbt.func_74778_a("jrmcSSlts", ",");
         } else {
            k = JRMCoreH.cleanUpCommas(k.replaceAll("pty", ""));
            nbt.func_74778_a("jrmcSSlts", k.length() < 3 ? "," : k);

            for(i = 0; i < JRMCoreH.SkillsNbt.length; ++i) {
               nbt.func_82580_o(JRMCoreH.SkillsNbt[i]);
            }

            mod_JRMCore.logger.info("New skill list: " + k);
            mod_JRMCore.logger.info("Converting ended in success!");
         }
      }

      k = nbt.func_74779_i("jrmcSSlts");
      String ts = ",";

      for(byte i = 0; i < JRMCoreH.AttrbtNbtI.length; ++i) {
         ts = ts + "," + T5yLLW(playerAttributes[i]);
      }

      ts = ts.replaceAll(",,", "");
      t1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[0]));
      String t2 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[1]));
      String t3 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[2]));
      String t4 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[3]));
      String Techs5 = nbt.func_74779_i(JRMCoreH.techNbt[4]);
      String Techs6 = nbt.func_74779_i(JRMCoreH.techNbt[5]);
      String Techs7 = nbt.func_74779_i(JRMCoreH.techNbt[6]);
      String Techs8 = nbt.func_74779_i(JRMCoreH.techNbt[7]);
      String pm = Techs5 + "," + Techs6 + "," + Techs7 + "," + Techs8;
      int dr = nbt.func_74762_e("jrmcDiffRed");
      if (dr > 0) {
         nbt.func_74768_a("jrmcDiffRed", dr - 1);
         if (dr == 1) {
            nbt.func_74774_a("jrmcDiff", (byte)0);
         }
      }

      short htc = nbt.func_74765_d("jrmcHTCTmO");
      if (htc > 0) {
         nbt.func_74777_a("jrmcHTCTmO", (short)(htc - 1));
      }

      String plyStn = nbt.func_74779_i("jrmcSettings");
      if (plyStn.length() == 0 || !JRMCoreH.smnmlt(plyStn)) {
         plyStn = " ";
         nbt.func_74778_a("jrmcSettings", " ");
      }

      if (statusEffects.length() == 0) {
         statusEffects = " ";
         nbt.func_74778_a("jrmcStatusEff", " ");
      }

      String Fzn = nbt.func_74779_i("jrmcFuzion");
      if (Fzn.length() == 0 || Fzn.contains(".")) {
         Fzn = " ";
         nbt.func_74778_a("jrmcFuzion", " ");
      }

      if (nbt.func_74781_a("jrmcTpint") == null) {
         int tp = nbt.func_74765_d("jrmcTp");
         nbt.func_74768_a("jrmcTpint", tp);
         nbt.func_74777_a("jrmcTp", (short)0);
      }

      if (nbt.func_74781_a("tpgbfokt") == null) {
         int costTp = 0;
         String[] s2 = t1.contains(";") ? t1.toString().split(";") : null;
         int tp;
         if (s2 != null) {
            tp = JRMCoreH.costEnAt(s2);
            costTp += 20 + tp / 2;
         }

         s2 = t2.contains(";") ? t2.toString().split(";") : null;
         if (s2 != null) {
            tp = JRMCoreH.costEnAt(s2);
            costTp += 20 + tp / 2;
         }

         s2 = t3.contains(";") ? t3.toString().split(";") : null;
         if (s2 != null) {
            tp = JRMCoreH.costEnAt(s2);
            costTp += 20 + tp / 2;
         }

         s2 = t4.contains(";") ? t4.toString().split(";") : null;
         if (s2 != null) {
            tp = JRMCoreH.costEnAt(s2);
            costTp += 20 + tp / 2;
         }

         tp = nbt.func_74762_e("jrmcTpint") + costTp;
         nbt.func_74768_a("jrmcTpint", tp);
         nbt.func_74778_a(JRMCoreH.techNbt[0], " ");
         nbt.func_74778_a(JRMCoreH.techNbt[1], " ");
         nbt.func_74778_a(JRMCoreH.techNbt[2], " ");
         nbt.func_74778_a(JRMCoreH.techNbt[3], " ");
         t1 = nbt.func_74779_i(JRMCoreH.techNbt[0]);
         t2 = nbt.func_74779_i(JRMCoreH.techNbt[1]);
         t3 = nbt.func_74779_i(JRMCoreH.techNbt[2]);
         t4 = nbt.func_74779_i(JRMCoreH.techNbt[3]);
         nbt.func_74778_a("tpgbfokt", "done");
      }

      if (release == 0 && rage > 0) {
         nbt.func_74774_a("jrmcSaiRg", (byte)0);
         rage = 0;
      }

      boolean nosao = powerType != 3;
      boolean issao = powerType == 3;
      float lastGravity = 1.0F;
      float IWeight = 0.0F;
      ItemStack stackbody = null;
      ItemStack stackhead = null;
      ItemStack[] stack_vanities = new ItemStack[8];
      boolean hasWatch = false;
      int s4afg = 0;
      int kiWeaponID;
      if (this.dbc) {
         kiWeaponID = JRMCoreH.getInt(player, "jrmcGravZoneLast");
         lastGravity = JRMCoreH.getFloat(player, "jrmcGravForce");
         int epoch = (int)(System.currentTimeMillis() / 1000L);
         if (epoch > kiWeaponID) {
            lastGravity = 0.0F;
            JRMCoreH.setFloat((int)0, player, "jrmcGravForce");
         }

         lastGravity = JRMCoreHDBC.gravity(player, lastGravity);
         IWeight = JRMCoreH.weightExtra(playerAttributes, lastGravity, player);
         stackbody = ExtendedPlayer.get(player).inventory.func_70301_a(1);
         stackhead = ExtendedPlayer.get(player).inventory.func_70301_a(2);

         int i;
         for(i = 0; i < 8; ++i) {
            stack_vanities[i] = ExtendedPlayer.get(player).inventory.func_70301_a(3 + i);
         }

         if (stackbody != null && stackbody.func_77958_k() - stackbody.func_77960_j() == 0) {
            ExtendedPlayer.get(player).inventory.func_70299_a(1, (ItemStack)null);
         }

         if (stackhead != null && stackhead.func_77958_k() - stackhead.func_77960_j() == 0) {
            ExtendedPlayer.get(player).inventory.func_70299_a(2, (ItemStack)null);
         }

         for(i = 0; i < 8; ++i) {
            if (stack_vanities[i] != null && stack_vanities[i].func_77958_k() - stack_vanities[i].func_77960_j() == 0) {
               ExtendedPlayer.get(player).inventory.func_70299_a(3 + i, (ItemStack)null);
            }
         }

         if (stackbody != null && !(stackbody.func_77973_b() instanceof ItemBodysuit)) {
            stackbody = null;
         }

         if (stackhead != null && !(stackhead.func_77973_b() instanceof ItemHeadwear)) {
            stackhead = null;
         }

         for(i = 0; i < 8; ++i) {
            if (stack_vanities[i] != null && !(stack_vanities[i].func_77973_b() instanceof ItemVanity)) {
               stack_vanities[i] = null;
            }
         }

         s4afg = JRMCoreHDBC.DBCgetConfigDBGT() ? nbt.func_74762_e("jrmcAfGFtStFT") : 0;
      }

      if (this.jyc) {
         hasWatch = player.field_71071_by.func_146028_b(JRMCoreHJYC.JYCgetItemWatch());
      }

      kiWeaponID = 0;
      if (this.dbc) {
         kiWeaponID = JRMCoreH.PlyrSettings((EntityPlayer)player, 13);
      }

      String w = this.dbc ? JRMCoreH.ItemWeightOn(ExtendedPlayer.get(player).inventory.func_70301_a(0)) + "" : "-1,0";
      if (nbt.func_74781_a("jrmcSsnoc") == null) {
         nbt.func_74768_a("jrmcSsnoc", (int)(Math.random() * 1.6777215E7D));
      }

      String au = "";
      String glid = nbt.func_74779_i("JRMCGLIDs");
      String gidi = nbt.func_74779_i("JRMCGIDis");
      String stack_van = "";

      for(int i = 0; i < 8; ++i) {
         if (this.dbc && stack_vanities[i] != null) {
            stack_van = stack_van + Item.func_150891_b(stack_vanities[i].func_77973_b()) + "," + ((ItemVanity)stack_vanities[i].func_77973_b()).getColor(stack_vanities[i]) + ";";
         } else {
            stack_van = stack_van + "-1;";
         }
      }

      names[playerID] = "" + player.getName();
      data0[playerID] = "" + ac + ";" + gp;
      data1[playerID] = race + ";" + dns + ";" + nbt.func_74771_c("jrmcPwrtyp") + ";" + nbt.func_74771_c("jrmcClass") + ";" + nbt.func_74771_c("jrmcAccept") + ";" + w + ";" + (this.dbc && stackbody != null ? Item.func_150891_b(stackbody.func_77973_b()) + "," + ((ItemBodysuit)stackbody.func_77973_b()).getColor(stackbody) : -1) + ";" + (this.dbc && stackhead != null ? Item.func_150891_b(stackhead.func_77973_b()) : -1) + ";" + stack_van + (this.jyc && hasWatch ? 1 : -1) + ";" + kiWeaponID + "; ";
      data3[playerID] = "" + nbt.func_74771_c("jrmcStnd");
      if (this.dbc || this.nc || this.sao) {
         data2[playerID] = "" + nbt.func_74771_c("jrmcState") + ";" + nbt.func_74771_c("jrmcState2");
         data4[playerID] = "" + rage + ";" + heat + ";" + (ko > 0 ? 1 : 0);
         data5[playerID] = "" + nbt.func_74771_c("jrmcAlign") + ";" + nbt.func_74762_e("jrmcAuraColor") + ";" + nbt.func_74762_e("jrmcSsnoc");
         data6[playerID] = "" + k + ";" + nbt.func_74779_i("jrmcSSltX") + ";" + nbt.func_74779_i("jrmcSSltY") + ";" + nbt.func_74779_i("jrmcSSltZ") + ";" + pm;
         if (nosao) {
            data7[playerID] = "" + t1 + ";;" + t2 + ";;" + t3 + ";;" + t4;
         }

         if (nosao) {
            dat15[playerID] = "";
         }

         if (nosao) {
            dat16[playerID] = "" + (race == 4 ? ((au = nbt.func_74779_i("jrmcDNSAU")).length() > 6 ? au : " ") : " ");
         }

         if (nosao) {
            dat17[playerID] = "";
         }

         data8[playerID] = "" + nbt.func_74762_e("jrmcBdy");
         data9[playerID] = "" + nbt.func_74762_e("jrmcEnrgy");
         dat10[playerID] = "" + nbt.func_74771_c("jrmcRelease") + ";" + nbt.func_74762_e("jrmcStamina");
         if (nosao) {
            dat11[playerID] = "" + nbt.func_74762_e("jrmcTpint");
         }

         dat12[playerID] = "" + nbt.func_74771_c("jrmcExp");
         dat13[playerID] = "" + alive + ";" + nbt.func_74779_i("jrmcSettings") + ";" + resrv + ";" + absorption;
         dat14[playerID] = "" + ts;
         dat18[playerID] = "" + nbt.func_74771_c("jrmcDiff") + ";" + nbt.func_74771_c("jrmcPtch") + ";" + Fzn;
         dat19[playerID] = "" + nbt.func_74771_c("jrmcTlmd") + ";" + statusEffects;
         if (nosao) {
            dat20[playerID] = "" + nbt.func_74765_d("jrmcGTrnng") + ";" + nbt.func_74779_i("jrmcSettings") + ";" + lastGravity + ";" + IWeight + ";" + strn + ";" + strnAct + ";" + strng + ";" + s4afg + ";" + strnp + ";" + ko;
         }

         if (nosao) {
            dat21[playerID] = "" + nbt.func_74779_i("JRMCmissionSyncVers");
         }

         if (nosao) {
            dat22[playerID] = "" + nbt.func_74779_i("JRMCmissionSync");
         }

         dat23[playerID] = "" + nbt.func_74762_e("JRMCGID");
         if (nosao) {
            dat24[playerID] = "" + (glid.length() > 2 ? glid : " ") + ";" + (gidi.length() > 2 ? gidi : " ");
         }

         if (nosao) {
            dat25[playerID] = "" + nbt.func_74779_i("JTCCBattleData");
         }

         if (issao) {
            data7[playerID] = "" + nbt.func_74762_e("saocCol");
            dat11[playerID] = "" + sao_lvl + ";" + nbt.func_74762_e("saocAp");
            dat15[playerID] = "" + sao_exp;
         }
      }

      String attributeTag;
      int i;
      String jrmcabonus;
      if (this.jfc && FamilyCH.familyCNBT != null) {
         jrmcabonus = JRMCoreH.getString(player, FamilyCH.FID);
         String[] fida = jrmcabonus.split(",");
         String fn = fida[0];
         attributeTag = "0";
         String afm = "";
         String mfd = JRMCoreH.getDataFromNBT(fn + ",0", FamilyCH.familyCNBT);
         if (!mfd.contains("!")) {
            afm = "0";
         } else {
            String[] mfD = mfd.split("!");
            attributeTag = mfD[0];
            i = Integer.parseInt(mfD[2]);

            for(int i = 0; i <= i; ++i) {
               afm = afm + ";" + JRMCoreH.getDataFromNBT(fn + "," + i, FamilyCH.familyCNBT);
            }

            afm = afm.length() > 0 ? afm.substring(1) : afm;
         }

         afm = afm.replaceAll(":", "\\+");
         String pr = nbt.func_74779_i(FamilyCH.prID);
         String[] s = pr.split(";");
         String prc = s.length > 3 ? s[4] : s[0];
         dat26[playerID] = attributeTag;
         dat27[playerID] = afm;
         dat28[playerID] = (jrmcabonus.length() > 2 ? jrmcabonus : 0) + ";" + nbt.func_74779_i(FamilyCH.FIDi) + ";" + nbt.func_74779_i(FamilyCH.FIDa);
         dat29[playerID] = pr;
         dat30[playerID] = prc;
      }

      if (JRMCoreConfig.JRMCABonusOn) {
         jrmcabonus = "";
         String resultBonus = "";

         for(int i = 0; i < JRMCoreH.attrInit[1].length; ++i) {
            attributeTag = nbt.func_74779_i("jrmcAttrBonus" + ComJrmcaBonus.ATTRIBUTES_SHORT[i]);
            if (attributeTag.length() == 0) {
               attributeTag = "n";
            }

            jrmcabonus = jrmcabonus + attributeTag + "=";
            resultBonus = resultBonus + attributeTag + "=";
         }

         if (jrmcabonus.contains("nbt_") || jrmcabonus.contains("NBT_")) {
            String[] attributes = jrmcabonus.split("\\=");

            for(int j = 0; j < JRMCoreH.attrInit[1].length; ++j) {
               boolean containedNBT = false;
               String[] bonus = attributes[j].split("\\|");
               String[][] bonusValues = new String[bonus.length][2];
               if ((attributes[j].contains("nbt_") || attributes[j].contains("NBT_")) && bonus.length > 0 && bonus[0].length() > 0) {
                  for(i = 0; i < bonus.length; ++i) {
                     String[] bonusValue = bonus[i].split("\\;");
                     bonusValues[i][0] = bonusValue[0];
                     bonusValues[i][1] = bonusValue[1];
                     if (bonusValues[i][1].contains("nbt_") || bonusValues[i][1].contains("NBT_")) {
                        containedNBT = true;
                        String method = bonusValues[i][1].substring(0, 1);

                        try {
                           String value = bonusValues[i][1].substring("nbt_".length() + 1);
                           double resultValue = nbt.func_74769_h(value);
                           bonus[i] = bonusValues[i][0] + ";" + method + resultValue;
                        } catch (Exception var70) {
                        }
                     }
                  }
               }

               if (containedNBT) {
                  attributes[j] = "";

                  for(i = 0; i < bonus.length; ++i) {
                     attributes[j] = attributes[j] + bonus[i] + (i == bonus.length - 1 ? "" : "|");
                  }

                  resultBonus = "";

                  for(i = 0; i < attributes.length; ++i) {
                     if (attributes[i].length() == 0) {
                        attributes[i] = "null";
                     }

                     resultBonus = resultBonus + attributes[i] + "=";
                  }
               }
            }
         }

         dat31[playerID] = resultBonus;
      }

      if (this.dbc && JGConfigDBCFormMastery.FM_Enabled) {
         jrmcabonus = JRMCoreH.getFormMasteryData(player, "0.00");
         dat32[playerID] = jrmcabonus;
      }

      ++this.genInt;
      if (this.genInt >= 120) {
         this.genInt = 0;
         if (JRMCoreH.DBC()) {
            JRMCoreHDBC.DBCCommonTickHandlerNPCSpawnCheck(player);
         }

         if (JRMCoreH.NC()) {
            JRMCoreHNC.NCCommonTickHandlerNPCSpawnCheck(player);
         }
      }

   }

   static {
      serverHeight = height;
      serverEyHeigClc = 0.18F;
      serverDefEyHeig = serverHeight - serverEyHeigClc;
      serveryOffset = height - serverHeight;
      h = false;
   }
}
