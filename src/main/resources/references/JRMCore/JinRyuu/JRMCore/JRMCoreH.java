package JinRyuu.JRMCore;

import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import JinRyuu.DragonBC.common.Npcs.EntityDragon;
import JinRyuu.DragonBC.common.Npcs.EntityPorunga;
import JinRyuu.DragonBC.common.Render.KintounEntity;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.ExplosionJRMC;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.items.ItemHeadwear;
import JinRyuu.JRMCore.p.JRMCorePAttck;
import JinRyuu.JRMCore.p.JRMCorePChar;
import JinRyuu.JRMCore.p.JRMCorePCost;
import JinRyuu.JRMCore.p.JRMCorePData;
import JinRyuu.JRMCore.p.JRMCorePExpl;
import JinRyuu.JRMCore.p.JRMCorePFall;
import JinRyuu.JRMCore.p.JRMCorePQuad;
import JinRyuu.JRMCore.p.JRMCorePQuadI;
import JinRyuu.JRMCore.p.JRMCorePRls;
import JinRyuu.JRMCore.p.JRMCorePStats;
import JinRyuu.JRMCore.p.JRMCorePStats2;
import JinRyuu.JRMCore.p.JRMCorePStats3;
import JinRyuu.JRMCore.p.JRMCorePStats3b;
import JinRyuu.JRMCore.p.JRMCorePTech;
import JinRyuu.JRMCore.p.JRMCorePTick;
import JinRyuu.JRMCore.p.JRMCorePTri;
import JinRyuu.JRMCore.p.JRMCorePTrib;
import JinRyuu.JRMCore.p.JRMCorePUpgrade;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
import JinRyuu.JRMCore.p.DBC.DBCPduo;
import JinRyuu.JRMCore.server.JGMathHelper;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.JGRaceHelper;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
import JinRyuu.JRMCore.server.config.core.JGConfigSkills;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import JinRyuu.NarutoC.common.NCCommonTickHandler;
import JinRyuu.NarutoC.common.NCH;
import JinRyuu.NarutoC.common.Worlds.WorldGeneratorNC;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.gson.Gson;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class JRMCoreH {
   public static final byte RACE_HUMAN = 0;
   public static final byte RACE_SAIYAN = 1;
   public static final byte RACE_HALF_SAIYAN = 2;
   public static final byte RACE_NAMEKIAN = 3;
   public static final byte RACE_ARCOSIAN = 4;
   public static final byte RACE_MAJIN = 5;
   public static final byte RACE_BASE_HUMAN = 0;
   public static final byte RACE_BASE_SAIYAN = 0;
   public static final byte RACE_BASE_HALF_SAIYAN = 0;
   public static final byte RACE_BASE_NAMEKIAN = 0;
   public static final byte RACE_BASE_ARCOSIAN = 4;
   public static final byte RACE_BASE_MAJIN = 0;
   public static String tjnc = "jinryuunarutoc";
   public static String tjdbc = "jinryuudragonblockc";
   public static String tjdbcAssts = "jinryuudragonbc";
   public static String tjyc = "jinryuuyearsc";
   public static String tjycAssts = "jinryuujyearsc";
   public static String tjfc = "jinryuufamilyc";
   public static String tjrmc = "jinryuujrmcore";
   public static String tjsaoc = "jinryuusaoc";
   public static String tjjrmc = "jinryuumodscore";
   public static String tjbc = "jinryuubleachc";
   public static HashMap<String, Integer> osbic = new HashMap();
   public static int pg = 0;
   public static String[] p = null;
   public static Entity targ = null;
   public static Entity targNPC = null;
   public static String ask = null;
   public static final String RACE_NAME_HUMAN = "Human";
   public static final String RACE_NAME_SAIYAN = "Saiyan";
   public static final String RACE_NAME_HALF_SAIYAN = "Half-Saiyan";
   public static final String RACE_NAME_NAMEKIAN = "Namekian";
   public static final String RACE_NAME_ARCOSIAN = "Arcosian";
   public static final String RACE_NAME_MAJIN = "Majin";
   public static final String[] Races = new String[]{"Human", "Saiyan", "Half-Saiyan", "Namekian", "Arcosian", "Majin"};
   public static final int RACES;
   public static final String[] RaceAllow;
   public static final String[] RaceCanHaveHair;
   public static final String[] RaceCanHavePwr;
   public static final int[] RaceCustomSkin;
   public static final int[] RaceHairColor;
   public static final int[] RaceGenders;
   public static final int[] Specials;
   public static final String race = "Race";
   public static final String gender = "Gender";
   public static final String hair = "Hair";
   public static final String[] skinTyps;
   public static final String bodytype = "BodyType";
   public static final int[][][] defbodycols;
   public static final int[][] defeyecols;
   public static final int[][] customSknLimits;
   public static final int[] customSknLimitsBCP;
   public static final int hairLengthG2 = 786;
   public static final int hairLengthG1 = 392;
   public static final String[] defHairPrsts;
   public static final String facenose = "Nose";
   public static final String facemouth = "Mouth";
   public static final String eyes = "Eyes";
   public static final String color = "Color";
   public static final String tail = "Tail";
   public static final String pwrtyp = "PowerType";
   public static final String[] Genders;
   public static final String[] GenderAllow;
   public static final String[] Years;
   public static final int[] YearsD;
   public static final String[] Hairs;
   public static final String[] HairsT;
   public static final String[] Hairs2;
   public static final String[] Hairs2T;
   public static final String[] StateNames;
   public static final String[] DifficultyNames;
   public static final String[] DifficultySNmes;
   public static final String[] DifficultyDesc;
   public static final String KaioDiffRed = "KaioDiffRed";
   public static final String[] Pwrtyps;
   public static final String[] PwrtypAllow;
   public static final String[] PwrtypDesc;
   public static final String[] Classes;
   public static final String[] ClassesDesc;
   public static final String[] ClassesDBC;
   public static final String[] ClassesDBCDesc;
   public static final String[] Clans;
   public static final String[] ClansDesc;
   public static final String[] ClassNames;
   public static int BPMode;
   public static int kiAmount;
   public static double kiMultip;
   public static int dbcHealthCur;
   public static String[] dbcBP;
   public static int jrmcExp;
   public static int dbcEvilness;
   public static int dbcHealth;
   public static int dbcTrainPoint;
   public static int kiMax;
   public static int kiChargRa;
   public static int kiDash;
   public static int kiPunch;
   public static int kiJump;
   public static int kiFly;
   public static int kiAsclvl;
   public static int kiAscPow;
   public static int DSpeed;
   public static int minKi;
   public static String SEvil;
   public static String SHealth;
   public static String STrainPoint;
   public static String SkiMax;
   public static String SkiChargRa;
   public static String SkiDash;
   public static String SkiPunch;
   public static String SkiJump;
   public static String SkiFly;
   public static String SkiAsclvl;
   public static String SkiAscPow;
   public static int kiKaioKen;
   public static int kiInSuper;
   public static int KABigBang;
   public static int KABlast;
   public static int KABurningAtt;
   public static int KADeathBeam;
   public static int KADodon;
   public static int KAEnergyDisk;
   public static int KAFinalFlash;
   public static int KAFingerLaser;
   public static int KAGalicGun;
   public static int KAKameHame;
   public static int KAKameHame10x;
   public static int KAMakanko;
   public static int KAMasenko;
   public static int KAPlanetDest;
   public static int KASpiritBomb;
   public static int KTKaioken;
   public static int KASelected;
   public static int KACharge;
   public static int KAFired;
   public static int KAFireStop;
   public static int Senzu;
   public static boolean driF;
   public static boolean driB;
   public static boolean driU;
   public static boolean driD;
   public static boolean dbchalo;
   public static String[] dbcpd;
   public static String[] dbcSuperOn;
   public static String[] dbcLieDown;
   public static String Har;
   public static String Col;
   public static double forw;
   public static final String MOB_NBT_SPAWNINITIATED_CHP = "jrmcSpawnInitiatedCHP";
   public static final String MOB_NBT_SPAWNINITIATED_CAT = "jrmcSpawnInitiatedCAT";
   public static final String MOB_NBT_SPAWNINITIATED_CMT = "jrmcSpawnInitiatedCMT";
   public static final String MOB_NBT_SPAWNINITIATED_IMP = "jrmcSpawnInitiatedIMP";
   public static int ChakraAmount;
   public static double ChakraMultip;
   public static String hsp;
   public static int jutsumode;
   public static int handsealfailed;
   public static int jutsu;
   public static int jutsuinfo;
   public static String[] ncDou;
   public static int ncBodyCur;
   public static int ncExp;
   public static int ncEvil;
   public static int ncBody;
   public static int ncTP;
   public static int ncChMax;
   public static int ncChRa;
   public static int ncSpe;
   public static int ncTai;
   public static int ncTaiJump;
   public static int ncNinj;
   public static int ncGenj;
   public static int ncPow;
   public static String Sbody;
   public static String Stp;
   public static String SchMax;
   public static String SchRa;
   public static String Sspe;
   public static String Stai;
   public static String StaiJump;
   public static String SNinj;
   public static String SGenj;
   public static String SPow;
   public static String[] plyrsArnd;
   public static final String JTCCBattleData = "JTCCBattleData";
   public static final String JTCCBattleDataP1 = "JTCCBattleDataP1";
   public static final String JTCCBattleDataP2 = "JTCCBattleDataP2";
   public static final String JTCCBattleOps = "JTCCBattleOps";
   public static final String JTCCCCD = "JTCCCCD";
   public static final String JTCCDD = "JTCCDD";
   public static final String MissionSyncData = "JRMCmissionSync";
   public static final String MissionSyncDataVers = "JRMCmissionSyncVers";
   public static final String SagaSideDBC = "JRMCSideSaga";
   public static final String SagaSideTimesDBC = "JRMCSideSagaTimes";
   public static final String SagaMainDBC = "DBCSagaSys";
   public static final String SagaMainTimesDBC = "DBCSagaTimes";
   public static final String SagaGID = "JRMCGID";
   public static final String SagaGLID = "JRMCGLIDs";
   public static final String SagaGIDi = "JRMCGIDis";
   public static final String AttackTimer = "jrmcAttackTimer";
   public static final String AttackLstPlyrTm = "jrmcAttackLstPlyrTm";
   public static final String AttackLstPlyrNam = "jrmcAttackLstPlyrNam";
   public static final String SenzuCC = "jrmcSenzuCC";
   public static final String GravZoneLast = "jrmcGravZoneLast";
   public static final String GravZoneForce = "jrmcGravForce";
   public static final String Age = "JRYCAge";
   public static final String DNS = "jrmcDNS";
   public static final String DNSAU = "jrmcDNSAU";
   public static final String DNSH = "jrmcDNSH";
   public static final String R = "jrmcRace";
   public static final String P = "jrmcPwrtyp";
   public static final String Cl = "jrmcClass";
   public static final String Acc = "jrmcAccept";
   public static final String St = "jrmcState";
   public static final String St2 = "jrmcState2";
   public static final String StE = "jrmcStatusEff";
   public static final String senzu = "DBCSenzu";
   public static final String firing = "jrmcFrng";
   public static final String Diff = "jrmcDiff";
   public static final String Tm = "jrmcTlmd";
   public static final String master = "jrmcMaster";
   public static final String plyrSttngs = "jrmcSettings";
   public static final String AuraCol = "jrmcAuraColor";
   public static final String StrainTemp = "jrmcStrainTemp";
   public static final String Strain = "jrmcStrain";
   public static final String StrainActv = "jrmcStrainActv";
   public static final String GodStrain = "jrmcGodStrain";
   public static final String GodPwr = "jrmcGodPwr";
   public static final String S4afgft = "jrmcAfGFtStFT";
   public static final String Pain = "jrmcGyJ7dp";
   public static final String Heat = "jrmcEf8slc";
   public static final String KO = "jrmcHar4va";
   public static final String HeatD = "jrmcEf8slcD";
   public static final String SsnoCol = "jrmcSsnoc";
   public static final String DiffRed = "jrmcDiffRed";
   public static final String Ptch = "jrmcPtch";
   public static final String TrngTPlmt = "jrmcTPlimit";
   public static final String TrngTPlmt2 = "jrmcTPlimit2";
   public static final String SklSlt0 = "jrmcSSlt0";
   public static final String SklSlt1 = "jrmcSSlt1";
   public static final String SklSlt2 = "jrmcSSlt2";
   public static final String SklSlt3 = "jrmcSSlt3";
   public static final String SklSlt4 = "jrmcSSlt4";
   public static final String SklSlt5 = "jrmcSSlt5";
   public static final String SklSlt6 = "jrmcSSlt6";
   public static final String SklSlt7 = "jrmcSSlt7";
   public static final String SklSlt8 = "jrmcSSlt8";
   public static final String SklSlt9 = "jrmcSSlt9";
   public static final String SklSltX = "jrmcSSltX";
   public static final String SklSltY = "jrmcSSltY";
   public static final String[] AttrbtNbt;
   public static final String[] AttrbtNbtI;
   public static final String[] AttrbtNbtR;
   public static final String SkillXNbt = "jrmcSSltX";
   public static final String SkillYNbt = "jrmcSSltY";
   public static final String SkillZNbt = "jrmcSSltZ";
   public static final String[] SkillsNbt;
   public static final String SkillsNbt2 = "jrmcSSlts";
   public static final String CurBody = "jrmcBdy";
   public static final String CurEnergy = "jrmcEnrgy";
   public static final String CurStamina = "jrmcStamina";
   public static final String CurRelease = "jrmcRelease";
   public static final String Align = "jrmcAlign";
   public static final String Karma = "jrmcKarma";
   public static final String KllCG = "jrmcKillCountGood";
   public static final String KllCN = "jrmcKillCountNeut";
   public static final String KllCE = "jrmcKillCountEvil";
   public static final String DiedTimes = "jrmcDiedTimes";
   public static final String GTrnng = "jrmcGTrnng";
   public static final String htcTmO = "jrmcHTCTmO";
   public static final String alCntr = "jrmcAlCntr";
   public static final String inventoryLiving = "InventoryLiving";
   public static final String inventoryDead = "InventoryDead";
   public static final String RevTmr = "jrmcReviveTmer";
   public static final String Rencrnt = "jrmcRencrnt";
   public static final String RevtpInit = "jrmcRevtpInit";
   public static final String LastDamageDealt = "jrmcLastDamageDealt";
   public static final String LastDamageReceived = "jrmcLastDamageReceived";
   public static final String LastAttacker = "jrmcLastAttacker";
   public static final String[] FAttrbtNbt;
   public static final String FAge = "JRYCAgeF";
   public static final String FDNS = "jrmcDNSF";
   public static final String FDNSH = "jrmcDNSHF";
   public static final String FTP = "jrmcTpF";
   public static final String FUSION = "jrmcFuzion";
   public static final String FUSION_DEATH = "jrmcFuzionDeath";
   public static final String Majin = "jrmcMajin";
   public static final String MysticTimer = "jrmcUltmtTm";
   public static final String alive = "jrmcAlv";
   public static final String stand = "jrmcStnd";
   public static final String Wishes = "jrmcWishes";
   public static final String Drgn = "jrmcDrgn";
   public static final String dj = "jrmcdj";
   public static final String NBT_UI_HighestStateReached = "jrmcUIStateReach";
   public static final String NBT_UI_WasInPain = "jrmcUIWasInPain";
   public static final String NBT_UI_WasInPainDuration = "jrmcUIWasInPainDuration";
   public static final String NBT_InstantTransmissionTimers = "jrmcInstantTransmissionTimers";
   public static final String NBT_FormMasteryRacial = "jrmcFormMasteryRacial";
   public static final String NBT_FormMasteryDefault = "Base,0";
   public static final String NBT_FormMasteryDefaultNonRacial = "Kaioken,0";
   public static final String NBT_FormMasteryNonRacial = "jrmcFormMasteryNonRacial";
   public static final String NBT_MajinAbsorptionData = "jrmcMajinAbsorptionData";
   public static final String NBT_MajinAbsorptionTimer = "jrmcMajinAbsorptionTimer";
   public static String bonusAttributes;
   public static String FznDC;
   public static int Master;
   public static String MSD;
   public static String MSDV;
   public static int SagaProg;
   public static int SagaTimes;
   public static int SagaSideProg;
   public static int[] SagaSideTimes;
   public static int GID;
   public static String GLID;
   public static int[] GIDs;
   public static String GIDi;
   public static int GMN;
   public static HashMap<Integer, ArrayList<String>> nwl;
   public static int ServerPoints;
   public static int trngTPlmt;
   public static int trngTPlmt2;
   public static int revTmr;
   public static String revtpInit;
   public static int wishes;
   public static byte Race;
   public static String dns;
   public static String dnsau;
   public static String dnsH;
   public static byte Pwrtyp;
   public static byte Class;
   public static byte Accepted;
   public static byte State;
   public static byte State2;
   public static byte Dffclty;
   public static byte TlMd;
   public static byte PtchVc;
   public static int GTrnngCB;
   public static float WeightOn;
   public static float GravZone;
   public static int s4ft;
   public static float age;
   public static int curBody;
   public static int curEnergy;
   public static int curStamina;
   public static int maxBody;
   public static int maxEnergy;
   public static int maxStamina;
   public static byte curRelease;
   public static int curTP;
   public static int curExp;
   public static int curn;
   public static int cura;
   public static int ko;
   public static boolean kob;
   public static int pnp;
   public static boolean pnh;
   public static short charged;
   public static byte chrgPrc;
   public static byte channel;
   public static byte wave;
   public static boolean mrAtts;
   public static byte EnAtSlct;
   public static float curTech1CD;
   public static float curTech2CD;
   public static float curTech3CD;
   public static float curTech4CD;
   public static float curTech5CD;
   public static float curTech6CD;
   public static float curTech7CD;
   public static float curTech8CD;
   public static boolean isShtng;
   public static boolean isChrgng;
   public static float cast;
   public static byte align;
   public static int karma;
   public static float[] techniqueCooldowns;
   public static String PlyrSettings;
   public static int[] PlyrAttrbts;
   public static String PlyrSkillX;
   public static String PlyrSkillY;
   public static String PlyrSkillZ;
   public static String[] PlyrSkills;
   public static final String[] StusEfcts;
   private static final String[] PlyrSttngs;
   public static final String[] vlblRSkls;
   public static int[][] DBCRacialSkillTPCost;
   public static int[][] cDBCRacialSkillTPCost;
   public static int[][] DBCRacialSkillMindCost;
   public static int[][] cDBCRacialSkillMindCost;
   public static final String[] vlblRSklsNms;
   public static final String[] vlblCSkls;
   public static final int[][] vlblCSklsLvl;
   public static final String[] vlblCSklsNms;
   public static final String[] DBCSkillsIDs;
   public static final int[] vlblSklsUps;
   public static int[][] DBCSkillTPCost;
   public static int[][] cDBCSkillTPCost;
   public static int[][] DBCSkillMindCost;
   public static int[][] cDBCSkillMindCost;
   public static final String[] DBCSkillNames;
   public static final float SklLvl_KiBsM = 0.01F;
   public static String[] inIll;
   public static final String[] ncRSkls;
   public static final int[][] ncRSklsLvl;
   public static final String[] ncRSklsNms;
   public static final String[] ncCSkls;
   public static final String[] NCRacialSkillAbilityNames;
   public static int[][] NCRacialSkillTPCost;
   public static int[][] cNCRacialSkillTPCost;
   public static int[][] NCRacialSkillMindCost;
   public static int[][] cNCRacialSkillMindCost;
   public static final String[] NCSkillIDs;
   public static final int[] ncSklsUps;
   public static int[][] NCSkillTPCost;
   public static int[][] cNCSkillTPCost;
   public static int[][] NCSkillMindCost;
   public static int[][] cNCSkillMindCost;
   public static final String[] NCSkillNames;
   public static final String[] NCRankNames;
   public static String[] tech1;
   public static String[] tech2;
   public static String[] tech3;
   public static String[] tech4;
   public static int[] techPM;
   public static String[] plyrs;
   public static String[] data0;
   public static String[] data1;
   public static String[] data2;
   public static String[] data3;
   public static String[] data4;
   public static String[] data5;
   public static String[] data6;
   public static String[] data7;
   public static String[] data8;
   public static String[] data9;
   public static String[] dat10;
   public static String[] dat11;
   public static String[] dat12;
   public static String[] dat13;
   public static String[] dat14;
   public static String[] dat15;
   public static String[] dat16;
   public static String[] dat17;
   public static String[] dat18;
   public static String[] dat19;
   public static String[] dat20;
   public static String[] dat21;
   public static String[] dat22;
   public static String[] dat23;
   public static String[] dat24;
   public static String[] dat25;
   public static String[] dat26;
   public static String[] dat27;
   public static String[] dat28;
   public static String[] dat29;
   public static String[] dat30;
   public static String[] dat31;
   public static String[] dat32;
   public static String[] dat32Segmented;
   public static final int BPCH_Original = 0;
   public static final int BPCH_Previous = 1;
   public static final int BPCH_Current = 2;
   public static final int BPCH_ResetTime = 3;
   public static final int BPCH_TimeCurrent = 4;
   public static final int BPCH_TimePrevious = 5;
   private static HashMap<String, Object[]> tacx;
   public static final String[] techNbt;
   public static final String techNbtLearn = "jrmcTechLearn";
   public static final short TransSaiMxRg = 100;
   public static final String TransSaiRgNbt = "jrmcSaiRg";
   public static final String ArcRsrvNbt = "jrmcArcRsrv";
   public static final int[] ArcRsrvGrowth;
   public static final int[] ArcRsrvMaxSkll;
   public static int[] ArcRsrvPowCst;
   public static byte TransSaiCurRg;
   public static float[][] TransSaiStBnP;
   public static float[][] TransSaiStBnPO;
   public static int[][] TransSaiStBnF;
   public static float[][] TransHalfSaiStBnP;
   public static float[][] TransHalfSaiStBnPO;
   public static int[][] TransHalfSaiStBnF;
   public static float[][] TransFrStBnP;
   public static float[][] TransFrStBnPO;
   public static int[][] TransFrStBnF;
   public static float[][] TransHmStBnP;
   public static float[][] TransHmStBnPO;
   public static int[][] TransHmStBnF;
   public static float[][] TransNaStBnP;
   public static float[][] TransNaStBnPO;
   public static int[][] TransNaStBnF;
   public static float[][] TransMaStBnP;
   public static float[][] TransMaStBnPO;
   public static int[][] TransMaStBnF;
   public static float[][] DoujutsuPowerBonusMulti;
   public static int[][] DoujutsuPowerBonusFlat;
   public static final String[][] TransNms;
   public static final String[][] trans;
   public static final String[][] TransNmsM;
   public static final byte[][] transformationDescendToFormID;
   public static final String[] majinRacialSkillNames;
   public static final String trans_KAIOKEN = "Kaioken";
   public static final String trans_MYSTIC = "Mystic";
   public static final String trans_ULTRA_INSTINCT = "UltraInstict";
   public static final String trans_GOD_OF_DESTRUCTION = "GodOfDestruction";
   public static final int trans_KAIOKEN_ID = 0;
   public static final int trans_MYSTIC_ID = 1;
   public static final int trans_UI_ID = 2;
   public static final int trans_GOD_ID = 3;
   public static final String[] transNonRacial;
   public static final String[] TransSaiUpNam;
   public static final short[] TransSaiTre;
   public static final float[] TransSaiBlk;
   public static final float[] TransSaiSz;
   public static float[] TransSaiRgnO;
   public static float[] TransSaiRgn;
   public static float[] TransHalfSaiRgnO;
   public static float[] TransHalfSaiRgn;
   public static final float Kkm = 0.01F;
   public static final short[] TransFrSkn;
   public static final short[] TransFrSkn2;
   public static final short[] TransFrHrn;
   public static final float[] TransFrBlk;
   public static final float[] TransFrSz;
   public static float[] TransFrRgnO;
   public static float[] TransFrRgn;
   public static float[] TransHmRgnO;
   public static float[] TransHmRgn;
   public static final float[] TransHmBlk;
   public static final float[] TransHmSz;
   public static float[] TransNaRgnO;
   public static float[] TransNaRgn;
   public static final float[] TransNaBlk;
   public static final float[] TransNaSz;
   public static final float[] TransMaBulk;
   public static final float[] TransMaSize;
   public static float[] TransMaRgnO;
   public static float[] TransMaRgn;
   public static final String[] TransGtsNms;
   public static float[] TransGtsDmg;
   public static float[] TransGtsDmgO;
   public static String[] TransKaiNms;
   public static String[] TransKaiNmsO;
   public static float[] TransKaiDmg;
   public static float[] TransKaiDmgO;
   public static float[] TransKaiDrainRace;
   public static float[] TransKaiDrainORace;
   public static float[] TransKaiDrainLevel;
   public static float[] TransKaiDrainOLevel;
   public static float[] TransMngDmg;
   public static float[] TransMngDmgO;
   public static final String[] AlgnmntNms;
   public static final int[] techCol;
   public static final int[] techCol2;
   public static final int[] techCol3;
   public static final int[] techCol4;
   public static final String[] techColName;
   public static final byte techMult = 20;
   public static final int[] techBase;
   public static final int[] techMin;
   public static final int[] techMax;
   public static final int[] techUpg;
   public static final int[] techNCBase;
   public static final int[] techNCMin;
   public static final int[] techNCMax;
   public static final int[] techNCUpg;
   public static final byte TECH_AMOUNT_CUSTOM = 4;
   public static final byte TECH_AMOUNT_FIX = 4;
   public static final byte TECH_AMOUNT = 8;
   public static final int tech_statmod_sped = 0;
   public static final int tech_statmod_damg = 1;
   public static final int tech_statmod_cost = 2;
   public static final int tech_statmod_cast = 3;
   public static final int tech_statmod_cool = 4;
   public static final int tech_statmod_dens = 5;
   public static final int tech_statmod_size = 6;
   public static final String[] techDBCstatmods;
   private static final byte[] tech_stats;
   public static final int tech_type_wave = 0;
   public static final int tech_type_ball = 1;
   public static final int tech_type_disk = 2;
   public static final int tech_type_laser = 3;
   public static final int tech_type_spiral = 4;
   public static final int tech_type_large = 5;
   public static final int tech_type_barrage = 6;
   public static final int tech_type_defensive_kiai = 7;
   public static final int tech_type_offensive_kiai = 8;
   public static final String[] techDBCName;
   public static final String[] techDBCTypes;
   public static final float[] techDBCaddTYCost;
   public static final float[] techDBCct;
   public static final float[] techDBCcd;
   public static final String[] techDBCEffects;
   public static final String[] techDBCAcquired;
   public static final String[] techDBCSpeed;
   public static final float[] techDBCaddSPCost;
   public static final byte[] techDBCstatsDefault;
   public static final String[] techName;
   public static final String[] techTypes;
   public static final String[] techEffects;
   public static final String[] techAcquired;
   public static final String[] techSpeed;
   public static final String[] techSndIncBeam;
   public static final String[] techSndFireBeam;
   public static final String[] techSndMoveBeam;
   public static final String[] techSndIncDisk;
   public static final String[] techSndFireDisk;
   public static final String[] techSndMoveDisk;
   public static final String[] techSndFireLeser;
   public static final String[] techSndPMInc;
   public static final String[] techSndPMIncFire;
   public static final String[] techSndPMFire;
   public static final String[] techSndPMMove;
   public static final String techTPCost = "TP Current/Cost";
   public static final int masterNone = 0;
   public static final int masterGeneral = 1;
   public static final int masterRoshi = 2;
   public static final int masterShen = 3;
   public static final int masterKorin = 4;
   public static final int masterKami = 5;
   public static final int masterKai = 6;
   public static final int masterKrillin = 7;
   public static final int masterPiccolo = 8;
   public static final int masterVegeta = 9;
   public static final int masterTrunks = 10;
   public static final int masterFreiza = 11;
   public static final int masterCell = 12;
   public static final int masterGoku = 13;
   public static final int masterGohan = 14;
   public static final int masterBabidi = 15;
   public static final int masterJin = 16;
   public static final int masterGuru = 17;
   public static final int masterWhis = 18;
   public static final String[] Masters;
   public static final String[][] pmdbc;
   public static final int tech_element_fire = 0;
   public static final int tech_element_wind = 1;
   public static final int tech_element_lightning = 2;
   public static final int tech_element_earth = 3;
   public static final int tech_element_water = 4;
   public static final String[] techNCName;
   public static final String[] techNCTypes;
   public static final String[] techNCEffects;
   public static final String[] techNCAcquired;
   public static final String[] techNCDam;
   public static final String[] techNCClassn;
   public static final String[] techNCSpeed;
   public static final String[] techNCBunshintyp;
   public static final String[] techNCSndIncAff;
   public static final String[] techNCSndIncTyp;
   public static final String[] techNCSndIncCls;
   public static final String[] techNCSndIncSpec;
   public static final String[] techNCSndIncBeam;
   public static final String[] techNCSndIncDisk;
   public static final String[] techNCSndFireBeam;
   public static final String[] techNCSndFireDisk;
   public static final String[] techNCSndMoveBeam;
   public static final String[] techNCSndMoveDisk;
   public static final String[] techNCSndIncPM;
   public static final String[] techNCSndHitPM;
   public static final String[] techNCSndFirePM;
   public static final int[] techNCCol;
   public static final int[] techNCCostP;
   public static final String[] techNCEffHS;
   public static final String[] techNCCCHS;
   public static final int techNCCD = 100;
   public static final String hsF = "323";
   public static final String hsD = "132";
   public static final String hsL = "213";
   public static final String hsE = "312";
   public static final String hsW = "121";
   public static final String hsG = "231";
   public static final String hsY = "313";
   public static final String hsN = "131";
   public static final String hsT = "212";
   public static final String hsR = "133";
   public static final String hsH = "232";
   public static String[] techNCPreMadeSeals;
   public static final String[] NarutoNPCnames;
   public static final int[] NarutoNPCclans;
   public static final String[] MastersNC;
   public static final String[][] pmj;
   public static final String[] dmgMlTyps;
   public static final String EXP = "jrmcExp";
   public static final String TP = "jrmcTp";
   public static final String TPint = "jrmcTpint";
   public static final String tp = "Training Points";
   public static final String cost = "Cost";
   public static final String AP = "jrmcAp";
   public static final int MaxAttribute = 1000000000;
   public static final int MaxTP = 2000000000;
   public static final String[][] statNames;
   public static final String[][] attrInit;
   public static final String[][] attrNms;
   public static final String[][] attrDsc;
   public static final String[][] attrStat;
   public static final float[][] statInc;
   public static final int[][][] attrStart;
   static Splitter splitter;
   static Joiner joiner;
   public static final int TP_COST_UPGRADE_LOCK = -1;
   public static final int maxCalculatableAttribute = 6000000;
   public static HashMap<Integer, Long> attrCstH;
   public static final int[][] statIncBonusRaceDBC;
   public static final int[][][] statIncBonusClass;
   public static String[] sao_skillSlot;
   public static String[] sao_skills;
   public static int sao_level;
   public static int sao_exp;
   public static int sao_ap;
   public static int sao_sp;
   public static int sao_col;
   public static final String SAO_EXP = "saocExp";
   public static final String SAO_LVL = "saocLvl";
   public static final String SAO_AP = "saocAp";
   public static final String SAO_SP = "saocSp";
   public static final String SAO_SS = "saocSklslt";
   public static final String SAO_SM = "saocSklmp";
   public static final String SAO_COL = "saocCol";
   public static final int SAO_MAXCHAR_LVL = 250;
   public static final float SAO_MAXSKILL_LVL = 1000.0F;
   public static Map saoSkls;
   public static final String[] SAO_SkillMap_Cats;
   public static final String[] SAO_SkillMap_Weapons;
   public static final String[] SAO_SkillMap_WeaponTypes;
   public static final String[] SAO_Weapon_Cat_Sword;
   public static final String[] SAO_Weapon_Cat_Curved;
   public static final String[] SAO_Weapon_Cat_Dagger;
   public static final String[] SAO_Weapon_Cat_Rapier;
   public static final String[] SAO_Weapon_Cat_Axe;
   public static final String[] SAO_Weapon_Cat_Spear;
   public static final String[] SAO_Weapon_Cat_BattleAxe;
   public static final String[] SAO_Weapon_Cat_WarHammer;
   public static final String[] SAO_Weapon_Cat_Sword2;
   public static final String[] SAO_Weapon_Cat_Katana;
   public static final String[] SAO_SkillMap_Armors;
   public static HashMap<String, String> damInd;
   public static final String[] TrnngOptns;
   public static String[] jfcData0;
   public static String[] jfcaa;
   public static String[] jfcms;
   public static String[] jfcmt;
   public static String[] jfccp;
   public static String[] jfccs;
   public static String proc;
   public static String[] preg;
   public static HashMap<String, Boolean> modsC;
   public static HashMap<String, Boolean> modsS;
   public static float Perc10;
   public static float Perc15;
   public static float Perc20;
   public static boolean DBCresetted;
   public static boolean NCresetted;
   public static String difp;
   public static final int TP_GAIN_MODE = -1;
   private static final String[] NAMES;
   private static final BigInteger THOUSAND;
   private static final NavigableMap<BigInteger, String> MAP;
   public static String[] ltnb;
   public static String cldb;
   public static String cldg;
   public static String cla;
   public static String cldr;
   public static String cldp;
   public static String clgd;
   public static String clgy;
   public static String cldgy;
   public static String clbe;
   public static String clb;
   public static String cllg;
   public static String cllb;
   public static String cllr;
   public static String clpr;
   public static String cly;
   public static String clw;
   public static final ChatStyle CHAT_STYLE_YELLOW;
   public static double explosionX;
   public static double explosionY;
   public static double explosionZ;
   public static float explosionSize;
   public static List chunkPositionRecords;
   private static float playerVelocityX;
   private static float playerVelocityY;
   private static float playerVelocityZ;
   public static double expDam;
   public static Entity origin1;
   public static byte extype;
   static String wi;
   static String bs;
   static String wip;
   public static HashMap<String, String> modAssetIDs;
   public static boolean paused;
   public static HashMap<String, String> turih;
   public static long mem;
   public static boolean familyCEmptyFamiliesCleared;
   public static String previousServerFolder;

   public static boolean DGE(Entity e) {
      return DBC() && !(e instanceof EntityDBCKami) && !(e instanceof SpacePod01Entity) && !(e instanceof KintounEntity) && !(e instanceof EntityDragon) && !(e instanceof EntityPorunga);
   }

   public static int PlyrState2(EntityPlayer p) {
      int on = 0;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(p.func_70005_c_())) {
               String[] s2 = data2[pl].split(";");
               on = Integer.parseInt(s2[1]);
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         on = getByte(p, "jrmcState2");
      }

      return on;
   }

   public static byte PlyrPwr(EntityPlayer p) {
      byte on = 0;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(p.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               on = Byte.parseByte(s[2]);
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(p, "pres");
         on = aPlayer.func_74771_c("jrmcPwrtyp");
      }

      return on;
   }

   public static byte clsTypOn(EntityPlayer par1EntityPlayer) {
      byte on = 0;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               on = Byte.parseByte(s[3]);
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = aPlayer.func_74771_c("jrmcClass");
      }

      return on;
   }

   public static boolean HairExists(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      on = armTypSaiyansOn(par1EntityPlayer);
      return on;
   }

   public static boolean saiyanBlood(String[] s) {
      return s[4].contains("1") && userKi(s) && (s[0].contains("1") || s[0].contains("2"));
   }

   public static boolean userNatur(String[] s) {
      return s[2].contains("0");
   }

   public static boolean userKi(String[] s) {
      return s[2].contains("1");
   }

   public static boolean userChakra(String[] s) {
      return s[2].contains("2");
   }

   public static boolean userSwordArt(String[] s) {
      return s[2].contains("3");
   }

   public static boolean state(String s, int i) {
      return s.contains("" + i);
   }

   public static boolean saiyanBlood(NBTTagCompound nbt) {
      return nbt.func_74771_c("jrmcAccept") == 1 && kiUser(nbt) && rc_sai(nbt.func_74771_c("jrmcRace"));
   }

   public static boolean NaturUser(NBTTagCompound nbt) {
      return nbt.func_74771_c("jrmcPwrtyp") == 0;
   }

   public static boolean kiUser(NBTTagCompound nbt) {
      return nbt.func_74771_c("jrmcPwrtyp") == 1;
   }

   public static boolean chakraUser(NBTTagCompound nbt) {
      return nbt.func_74771_c("jrmcPwrtyp") == 2;
   }

   public static boolean state(NBTTagCompound nbt, int i) {
      return nbt.func_74771_c("jrmcState") == (byte)i;
   }

   public static boolean isRaceSaiyan() {
      return Race == 1 || Race == 2;
   }

   public static boolean isRaceNamekian() {
      return Race == 3;
   }

   public static boolean isRaceHuman() {
      return Race == 0;
   }

   public static boolean isRaceHumanOrNamekian() {
      return isRaceHuman() || isRaceNamekian();
   }

   public static boolean isRaceArcosian() {
      return Race == 4;
   }

   public static boolean isRaceMajin() {
      return Race == 5;
   }

   public static boolean isRaceHalfSaiyan(int r) {
      return r == 2;
   }

   public static boolean isRaceFullSaiyan(int r) {
      return r == 1;
   }

   public static boolean isRaceSaiyan(int r) {
      return r == 1 || r == 2;
   }

   public static boolean isRaceNamekian(int r) {
      return r == 3;
   }

   public static boolean isRaceHuman(int r) {
      return r == 0;
   }

   public static boolean isRaceHumanOrNamekian(int r) {
      return isRaceHuman(r) || isRaceNamekian(r);
   }

   public static boolean isRaceArcosian(int r) {
      return r == 4;
   }

   public static boolean isRaceMajin(int r) {
      return r == 5;
   }

   public static boolean rc_sai(int r) {
      return isRaceSaiyan(r);
   }

   public static boolean rc_humNam(int r) {
      return isRaceHumanOrNamekian(r);
   }

   public static boolean rc_hum(int r) {
      return isRaceHuman(r);
   }

   public static boolean rc_nam(int r) {
      return isRaceNamekian(r);
   }

   public static boolean rc_arc(int r) {
      return isRaceArcosian(r);
   }

   public static boolean rc_maj(int r) {
      return isRaceMajin(r);
   }

   public static boolean isInState(int state) {
      return State == (byte)state;
   }

   public static boolean isInState(int currentState, int state) {
      return currentState == state;
   }

   public static int getBaseForm(int race) {
      return rc_arc(race) ? 4 : 0;
   }

   public static boolean isInBaseForm(int race, int state) {
      return state == getBaseForm(race);
   }

   public static boolean rc_bs(int r, int s) {
      return isInBaseForm(r, s);
   }

   public static boolean rc_sai() {
      return Race == 1 || Race == 2;
   }

   public static boolean rc_humNam() {
      return Race == 0 || Race == 3;
   }

   public static boolean rc_hum() {
      return Race == 0;
   }

   public static boolean rc_nam() {
      return Race == 3;
   }

   public static boolean rc_arc() {
      return Race == 4;
   }

   public static boolean rc_bs() {
      return State == (rc_arc() ? 4 : 0);
   }

   public static boolean race_match(int race, int race2) {
      return isRaceSaiyan(race) && isRaceSaiyan(race2) || isRaceHuman(race) && isRaceHuman(race2) || isRaceArcosian(race) && isRaceArcosian(race2) || isRaceNamekian(race) && isRaceNamekian(race2) || isRaceMajin(race) && isRaceMajin(race2);
   }

   public static boolean isPowerTypeKi(int powerType) {
      return powerType == 1;
   }

   public static boolean isPowerTypeChakra(int powerType) {
      return powerType == 2;
   }

   public static boolean isPowerTypeSAO(int powerType) {
      return powerType == 3;
   }

   public static boolean isPowerTypeKi() {
      return Pwrtyp == 1;
   }

   public static boolean isPowerTypeChakra() {
      return Pwrtyp == 2;
   }

   public static boolean isPowerTypeSAO() {
      return Pwrtyp == 3;
   }

   public static boolean pwr_ki(int powerType) {
      return isPowerTypeKi(powerType);
   }

   public static boolean pwr_cha(int powerType) {
      return isPowerTypeChakra(powerType);
   }

   public static boolean pwr_sa(int powerType) {
      return isPowerTypeSAO(powerType);
   }

   public static boolean pwr_ki() {
      return isPowerTypeKi();
   }

   public static boolean pwr_cha() {
      return isPowerTypeChakra();
   }

   public static boolean pwr_sa() {
      return isPowerTypeSAO();
   }

   public static boolean armTypSaiyansOn(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s)) {
                  if (state((String)s2[0], 0)) {
                     kiInSuper = 0;
                  }

                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer);
      }

      return on;
   }

   public static boolean armTypNormOn(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s) && state((String)s2[0], 0)) {
                  kiInSuper = 0;
                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer) && state((NBTTagCompound)aPlayer, 0);
      }

      return on;
   }

   public static boolean armTypSuperOn(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s) && !state((String)s2[0], 0)) {
                  kiInSuper = 0;
                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer) && !state((NBTTagCompound)aPlayer, 0);
      }

      return on;
   }

   public static boolean armTypSS1On(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s) && state((String)s2[0], 1)) {
                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer) && state((NBTTagCompound)aPlayer, 1);
      }

      return on;
   }

   public static boolean armTypSS2On(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s) && state((String)s2[0], 2)) {
                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer) && state((NBTTagCompound)aPlayer, 2);
      }

      return on;
   }

   public static boolean armTypSS3On(EntityPlayer par1EntityPlayer) {
      boolean on = false;
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT && plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
               String[] s = data1[pl].split(";");
               String[] s2 = data2[pl].split(";");
               if (saiyanBlood(s) && state((String)s2[0], 3)) {
                  on = true;
               }
               break;
            }
         }
      }

      if (side == Side.SERVER) {
         NBTTagCompound aPlayer = nbt(par1EntityPlayer, "pres");
         on = saiyanBlood(aPlayer) && state((NBTTagCompound)aPlayer, 3);
      }

      return on;
   }

   public static boolean armTypScoutAllOn(ItemStack stackhead) {
      return stackhead.func_77973_b() instanceof ItemHeadwear;
   }

   public static boolean armTypScoutOn(ItemStack var9) {
      boolean on = false;
      on = armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("1");
      return on;
   }

   public static boolean armTypScoutAOn(ItemStack var9) {
      boolean on = false;
      on = armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("2");
      return on;
   }

   public static boolean armTypScoutBOn(ItemStack var9) {
      boolean on = false;
      on = armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("3");
      return on;
   }

   public static NBTTagCompound nbt(Entity entity) {
      return nbt(entity, "");
   }

   public static NBTTagCompound nbt(Entity entity, String s) {
      NBTTagCompound nbt = null;
      if (s.contains("pres") && entity instanceof EntityPlayer) {
         NBTTagCompound var10000 = entity.getEntityData();
         EntityPlayer var10001 = (EntityPlayer)entity;
         if (!var10000.func_74764_b("PlayerPersisted")) {
            nbt = new NBTTagCompound();
            var10000 = entity.getEntityData();
            var10001 = (EntityPlayer)entity;
            var10000.func_74782_a("PlayerPersisted", nbt);
         } else {
            var10000 = entity.getEntityData();
            var10001 = (EntityPlayer)entity;
            nbt = var10000.func_74775_l("PlayerPersisted");
         }
      } else if (entity != null) {
         nbt = entity.getEntityData();
      }

      return nbt;
   }

   public static NBTTagCompound nbt(EntityPlayer p) {
      return nbt(p, "pres");
   }

   public static short getShort(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74765_d(string);
   }

   public static void setShort(int s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74777_a(string, (short)s);
   }

   public static void setShort(short s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74777_a(string, s);
   }

   public static void setShort(byte s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74777_a(string, (short)s);
   }

   public static void setShort(float s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74777_a(string, (short)((int)s));
   }

   public static byte getByte(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74771_c(string);
   }

   public static void setByte(int s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74774_a(string, (byte)s);
   }

   public static void setByte(short s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74774_a(string, (byte)s);
   }

   public static void setByte(byte s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74774_a(string, s);
   }

   public static void setByte(float s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74774_a(string, (byte)((int)s));
   }

   public static int getInt(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74762_e(string);
   }

   public static void setInt(int s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74768_a(string, s);
   }

   public static void setInt(short s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74768_a(string, s);
   }

   public static void setInt(byte s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74768_a(string, s);
   }

   public static void setInt(float s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74768_a(string, (int)s);
   }

   public static float getFloat(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74760_g(string);
   }

   public static void setFloat(int s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74776_a(string, (float)s);
   }

   public static void setFloat(short s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74776_a(string, (float)s);
   }

   public static void setFloat(byte s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74776_a(string, (float)s);
   }

   public static void setFloat(float s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74776_a(string, s);
   }

   public static String getString(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74779_i(string);
   }

   public static void setString(String s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74778_a(string, s);
   }

   public static long getLong(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74763_f(string);
   }

   public static void setLong(long s, EntityPlayer Player, String string) {
      nbt(Player, "pres").func_74772_a(string, (long)((int)s));
   }

   public static NBTBase getTag(EntityPlayer Player, String string) {
      return nbt(Player, "pres").func_74781_a(string);
   }

   public static boolean inAir(EntityPlayer plyr) {
      return !plyr.field_70122_E;
   }

   public static byte parseByte(String i) {
      return Byte.parseByte(i);
   }

   public static short parseShort(String i) {
      return Short.parseShort(i);
   }

   public static int parseInt(String i) {
      return Integer.parseInt(i);
   }

   public static float parseFloat(String i) {
      return Float.parseFloat(i);
   }

   public static double parseDouble(String i) {
      return Double.parseDouble(i);
   }

   public static boolean isAprilFoolsModeOn() {
      if (JGConfigClientSettings.CLIENT_DA17) {
         return true;
      } else {
         boolean apr = false;

         try {
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.getTime();
            String[] date = cal.getTime().toString().split(" ");
            if (date[1].equals("Apr") && date[2].equals("01")) {
               apr = true;
            }
         } catch (Exception var3) {
         }

         return apr;
      }
   }

   public static float calculateEnergyScale(float damage, float maxDamage, float perc, byte[] sts, byte density, float minScale, float maxScale) {
      if (density < 1) {
         density = 1;
      }

      if (damage > maxDamage) {
         damage = maxDamage;
      }

      float damEgy = maxDamage / 100.0F;
      float damPercentage = damage / damEgy;
      float scaleEgy = maxScale / 100.0F;
      float scaleDam = damPercentage * scaleEgy;
      float scale = minScale + scaleDam;
      scale /= (float)density;
      scale *= perc;
      if (sts != null && sts.length > 0) {
         scale *= 1.0F + tech_statmod(sts, 6);
      }

      return scale;
   }

   public static int getEnegyDamageC(String[] t, byte[] sts) {
      int[] PlyrAttrbts = PlyrAttrbts();
      byte pwr = Pwrtyp;
      byte rc = Race;
      byte cls = Class;
      byte curRel = curRelease;
      byte state = State;
      byte state2 = State2;
      String[] PlyrSkills = JRMCoreH.PlyrSkills;
      String sklx = PlyrSkillX;
      int resrv = getArcRsrv();
      String absorption = getMajinAbsorption();
      boolean mj = StusEfctsMe(12);
      boolean lg = StusEfctsMe(14);
      boolean kk = StusEfctsMe(5);
      boolean mc = StusEfctsMe(13);
      boolean mn = StusEfctsMe(19);
      boolean gd = StusEfctsMe(20);
      boolean v = StusEfctsMe(10) || StusEfctsMe(11);
      int WIL = getPlayerAttribute(mod_JRMCore.proxy.getPlayerClient(), PlyrAttrbts, 3, state, state2, rc, sklx, curRel, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills, v, absorption);
      int stat = stat(mod_JRMCore.proxy.getPlayerClient(), 3, pwr, 4, WIL, rc, cls, 0.0F);
      int dam1 = techDBCdmg(t, stat, sts);
      return dam1 / 2;
   }

   public static int getEnegyDamage(EntityPlayer p, String[] t, byte[] sts) {
      int[] PlyrAttrbts = PlyrAttrbts(p);
      byte curRel = getByte(p, "jrmcRelease");
      String[] PlyrSkills = getString(p, "jrmcSSlts").split(",");
      byte pwr = getByte(p, "jrmcPwrtyp");
      byte rc = getByte(p, "jrmcRace");
      byte cls = getByte(p, "jrmcClass");
      byte state = getByte(p, "jrmcState");
      byte state2 = getByte(p, "jrmcState2");
      String sklx = getString(p, "jrmcSSltX");
      int resrv = getInt(p, "jrmcArcRsrv");
      String absorption = getString(p, "jrmcMajinAbsorptionData");
      String ste = getString(p, "jrmcStatusEff");
      boolean mj = StusEfcts(12, ste);
      boolean lg = StusEfcts(14, ste);
      boolean kk = StusEfcts(5, ste);
      boolean mc = StusEfcts(13, ste);
      boolean mn = StusEfcts(19, ste);
      boolean gd = StusEfcts(20, ste);
      boolean v = StusEfcts(10, ste) || StusEfcts(11, ste);
      int WIL = getPlayerAttribute(p, PlyrAttrbts, 3, state, state2, rc, sklx, curRel, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills, v, absorption);
      int stat = stat(p, 3, pwr, 4, WIL, rc, cls, 0.0F);
      int dam1 = techDBCdmg(t, stat, sts);
      return dam1 / 2;
   }

   public static void a1t3(EntityPlayer e) {
      int epoch = (int)(System.currentTimeMillis() / 1000L) + 30;
      setInt(epoch, e, "jrmcAttackTimer");
   }

   public static boolean aliveState(int pl) {
      return dat13[pl].split(";")[0].contains("1");
   }

   public static boolean aliveState() {
      if (plyrs != null && plyrs.length > 0 && dnn(13)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(mod_JRMCore.proxy.getPlayerClient().func_70005_c_())) {
               return aliveState(pl);
            }
         }
      }

      return false;
   }

   public static boolean plyrSttngsClient(int plytSttngs, int pl) {
      if (dat13 != null && dat13.length > pl) {
         String[] s = dat13[pl].split(";");
         return s[1].contains(PlyrSttngs[plytSttngs]);
      } else {
         return false;
      }
   }

   public static float SklLvl_KiBs(EntityPlayer p, int w) {
      return w == 1 ? (float)SklLvl(13, (EntityPlayer)p) * 0.01F : 0.0F;
   }

   public static float SklLvl_KiBs(int w) {
      return w == 1 ? (float)SklLvl(13) * 0.01F : 0.0F;
   }

   public static float SklLvl_KiBs(String[] s, int w) {
      return w == 1 ? (float)SklLvl(13, (String[])s) * 0.01F : 0.0F;
   }

   public static float SklLvl_Fd(EntityPlayer p, int w) {
      float e = p.field_70143_R;
      return e;
   }

   public static String StusEfctsClient2(String id) {
      if (dnn(19)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(id)) {
               String[] s = dat19[pl].split(";");
               return s[1];
            }
         }
      }

      return "";
   }

   public static String StusEfctsClient(EntityPlayer p) {
      return data(p.func_70005_c_(), 19, "0; ;");
   }

   public static String StusEfctsClient(int pl) {
      if (dat19 != null && dat19.length > pl) {
         String[] s = dat19[pl].split(";");
         return s[1];
      } else {
         return "";
      }
   }

   public static boolean StusEfcts(int ste, String se) {
      return se.contains(StusEfcts[ste]);
   }

   public static boolean StusEfctsClient(int ste, EntityPlayer p) {
      return StusEfctsClient(p).contains(StusEfcts[ste]);
   }

   public static boolean StusEfctsClient(int ste, int pl) {
      return StusEfctsClient(pl).contains(StusEfcts[ste]);
   }

   public static String StusEfctsMe() {
      return StusEfctsClient2(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
   }

   public static boolean StusEfctsMe(int ste) {
      return StusEfctsMe().contains(StusEfcts[ste]);
   }

   public static void StusEfcts(int i, String s, EntityPlayer p, boolean b) {
      String bns = StusEfcts[i];
      if (!b && s.contains(bns)) {
         s = s.contains(bns) ? s.replace(bns, "") : s;
         setString(s, p, "jrmcStatusEff");
      } else {
         if (b) {
            s = s + bns;
            setString(s, p, "jrmcStatusEff");
         }

      }
   }

   public static void StusEfcts(int i, EntityPlayer p, boolean b) {
      String bns = StusEfcts[i];
      String s = getString(p, "jrmcStatusEff");
      if (!b && s.contains(bns)) {
         s = s.contains(bns) ? s.replace(bns, "") : s;
         setString(s, p, "jrmcStatusEff");
      } else {
         if (b) {
            setString(s + bns, p, "jrmcStatusEff");
         }

      }
   }

   public static String StusEfcts(int i, String s, NBTTagCompound nbt, boolean b) {
      String bns = StusEfcts[i];
      if (!b && s.contains(bns)) {
         s = s.contains(bns) ? s.replace(bns, "") : s;
         nbt.func_74778_a("jrmcStatusEff", s);
         return s;
      } else if (b) {
         nbt.func_74778_a("jrmcStatusEff", s + bns);
         return s + bns;
      } else {
         return s;
      }
   }

   public static String StusEfcts(int i, NBTTagCompound nbt, boolean b) {
      String bns = StusEfcts[i];
      String s = nbt.func_74779_i("jrmcStatusEff");
      if (!b && s.contains(bns)) {
         s = s.contains(bns) ? s.replace(bns, "") : s;
         nbt.func_74778_a("jrmcStatusEff", s);
         return s;
      } else if (b) {
         nbt.func_74778_a("jrmcStatusEff", s + bns);
         return s + bns;
      } else {
         return s;
      }
   }

   public static boolean isFused() {
      return isPowerTypeKi() && (StusEfctsMe(10) || StusEfctsMe(11));
   }

   public static boolean isFused(Entity Player) {
      NBTTagCompound nbt = nbt(Player, "pres");
      byte powerType = nbt.func_74771_c("jrmcPwrtyp");
      if (isPowerTypeKi(powerType)) {
         String Fzn = nbt.func_74779_i("jrmcFuzion");
         if (Fzn.contains(",") && Fzn.split(",").length == 3) {
            return true;
         } else {
            String StE = nbt.func_74779_i("jrmcStatusEff");
            boolean fused = StusEfcts(10, StE) || StusEfcts(11, StE);
            return fused;
         }
      } else {
         return false;
      }
   }

   public static boolean isFusionSpectator(Entity Player) {
      if (Player != null && Player instanceof EntityPlayer) {
         NBTTagCompound nbt = nbt(Player, "pres");
         byte powerType = nbt.func_74771_c("jrmcPwrtyp");
         if (isPowerTypeKi(powerType)) {
            String Fzn = nbt.func_74779_i("jrmcFuzion");
            if (Fzn.contains(",")) {
               String[] fusionMembers = Fzn.split(",");
               if (fusionMembers.length == 3) {
                  return fusionMembers[1].equalsIgnoreCase(Player.func_70005_c_());
               }
            }
         }
      }

      return false;
   }

   public static EntityPlayer getFusionSpectatorPartnerC(EntityPlayer player) {
      if (curRelease != 0 && StusEfctsMe(11) && !kob && isFused() && plyrs != null && plyrs.length > 0 && dnn(18)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(player.func_70005_c_())) {
               String[] fullFusionData = dat18[pl].split(";");
               if (fullFusionData.length >= 3) {
                  String[] fusionData = fullFusionData[2].split(",");
                  if (fusionData.length == 3) {
                     EntityPlayer playerPartner = player.field_70170_p.func_72924_a(fusionData[0]);
                     if (player != null) {
                        return playerPartner;
                     }
                  }
               }
               break;
            }
         }
      }

      return null;
   }

   public static EntityPlayer isFusionSpectatorPartnerC(EntityPlayer player) {
      return getFusionSpectatorPartnerC(player);
   }

   public static float SklInc(float j) {
      return 60.0F / (60.0F + j) * j * 3.0F;
   }

   public static float SklInc100(float j) {
      return 50.0F / (50.0F + j) * j * 3.0F;
   }

   public static float SklInc(float j, int m) {
      float i = 100.0F / (float)m;
      j *= i;
      return 50.0F / (50.0F + j) * j * 3.0F;
   }

   public static int SklLvl(int sn) {
      switch(Pwrtyp) {
      case 1:
         return SklLvlC(sn, DBCSkillsIDs);
      case 2:
         return SklLvlC(sn, NCSkillIDs);
      default:
         return 0;
      }
   }

   public static int SklLvl(int sn, byte pwr) {
      switch(pwr) {
      case 1:
         return SklLvlC(sn, DBCSkillsIDs);
      case 2:
         return SklLvlC(sn, NCSkillIDs);
      default:
         return 0;
      }
   }

   public static int SklLvlC(int sn, String[] s) {
      if (s == null) {
         return 0;
      } else {
         int n = 0;
         if (PlyrSkills != null) {
            for(byte i = 0; i < PlyrSkills.length; ++i) {
               String curSkl = PlyrSkills[i];
               if (curSkl != null && curSkl.length() > 2 && s.length > sn && curSkl.contains(s[sn]) && !curSkl.contains("pty")) {
                  n = 1 + Integer.parseInt(curSkl.substring(2));
                  break;
               }
            }
         }

         return n;
      }
   }

   public static int SklLvl(int sn, String[] ps) {
      return SklLvl(sn, DBCSkillsIDs, ps);
   }

   public static int SklLvl(int sn, EntityPlayer p) {
      return SklLvl(sn, PlyrPwr(p) == 1 ? DBCSkillsIDs : NCSkillIDs, PlyrSkills(p));
   }

   public static int SklLvl(int sn, int pwr, String[] ps) {
      return SklLvl(sn, pwr == 1 ? DBCSkillsIDs : NCSkillIDs, ps);
   }

   public static int SklLvl(int sn, String[] s, String[] ps) {
      if (ps != null && s != null) {
         int n = 0;

         for(byte i = 0; i < ps.length; ++i) {
            if (ps[i] != null && s[sn] != null && ps[i].contains(s[sn]) && ps[i].length() > 2) {
               int n = Integer.parseInt(ps[i].replaceAll(s[sn], ""));
               n = SklLvl_m(sn, s, n) + 1;
               return n;
            }
         }

         return n;
      } else {
         return 0;
      }
   }

   public static int SklLvl_m(int sn, String[] s, int n) {
      if (s.equals(DBCSkillsIDs) && n - 1 > SklInit(s[sn], s, vlblSklsUps)) {
         return SklInit(s[sn], s, vlblSklsUps) + 1;
      } else {
         return s.equals(NCSkillIDs) && n - 1 > SklInit(s[sn], s, ncSklsUps) ? SklInit(s[sn], s, ncSklsUps) + 1 : n;
      }
   }

   public static int SklLvl_m(String sn, String[] s, int n) {
      if (s.equals(DBCSkillsIDs) && n - 1 > SklInit(sn, s, vlblSklsUps)) {
         return SklInit(sn, s, vlblSklsUps) + 1;
      } else {
         return s.equals(NCSkillIDs) && n - 1 > SklInit(sn, s, ncSklsUps) ? SklInit(sn, s, ncSklsUps) + 1 : n;
      }
   }

   public static void SklLvl(int sn, String[] s, String[] ps, EntityPlayer p, int inc) {
      if (ps != null && s != null) {
         int n = false;
         String psa = "";

         int i;
         for(i = 0; i < ps.length; ++i) {
            psa = psa + ps[i] + ",";
         }

         for(i = 0; i < ps.length; ++i) {
            if (ps[i].contains(s[sn]) && ps[i].length() > 2) {
               int n = Integer.parseInt(ps[i].replaceAll(s[sn], "")) + inc;
               if (n < 0) {
                  psa = psa.replace(ps[i] + ",", "");
               } else {
                  n = n > 9 ? 9 : (n < 0 ? 0 : n);
                  n = SklLvl_m(sn, s, n);
                  psa = psa.replace(ps[i] + ",", s[sn] + n + ",");
               }
               break;
            }
         }

         setString(psa, p, "jrmcSSlts");
      }
   }

   public static int SklLvlX(EntityPlayer player) {
      return SklLvlX(getByte(player, "jrmcPwrtyp"), getString(player, "jrmcSSltX"));
   }

   public static int SklLvlX(int powerType, String playerSkills) {
      return SklLvl(powerType == 1 ? vlblRSkls : ncRSkls, playerSkills);
   }

   public static int SklLvlY(int powerType, String playerSkills) {
      return SklLvl(powerType == 1 ? vlblCSkls : ncCSkls, playerSkills);
   }

   public static int SklLvl(String[] s, String ps) {
      if (ps != null && s != null) {
         int n = 0;
         if (ps.length() > 2 && !ps.contains("pty")) {
            n = 1 + Integer.parseInt(ps.substring(2));
         }

         return n;
      } else {
         return 0;
      }
   }

   public static int SklInit(String curSkl, String[] s1, int[] s2) {
      int s = 8;

      for(int i = 0; i < s1.length; ++i) {
         if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
            s = i == 16 ? JGConfigUltraInstinct.CONFIG_UI_LEVELS - 2 : s2[i];
            break;
         }
      }

      return s;
   }

   public static String SklName(String curSkl, String[] s1, String[] s2) {
      String s = "error";

      for(int i = 0; i < s1.length; ++i) {
         if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
            s = s2[i];
            break;
         }
      }

      return s;
   }

   public static String SklName(String curSkl, String[] s1, String[] s2, int r) {
      String s = "error";

      for(int i = 0; i < s1.length; ++i) {
         if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
            s = s2[r];
            break;
         }
      }

      return s;
   }

   public static int SklID(String skillName, String[] skills) {
      if (skillName == null) {
         return -1;
      } else {
         if (skillName.length() > 1) {
            for(byte i = 0; i < skills.length; ++i) {
               if (skillName.length() > 1 && skills[i].contains(skillName.substring(0, 2))) {
                  return i;
               }
            }
         }

         return -1;
      }
   }

   public static double[] frmt_d(double[] d, double i, double x) {
      double[] n = new double[d.length];

      for(int j = 0; j < d.length; ++j) {
         n[j] = d[j] < i ? i : (d[j] > x ? x : d[j]);
      }

      return n;
   }

   public static int[] frmt_d(int[] d, int i, int x) {
      int[] n = new int[d.length];

      for(int j = 0; j < d.length; ++j) {
         n[j] = d[j] < i ? i : (d[j] > x ? x : d[j]);
      }

      return n;
   }

   public static boolean SklSlt(int[] PlyrAttrbts, int h) {
      return canAffordSkill(PlyrAttrbts[4], h);
   }

   public static String SklGveX(byte rc, byte cls, byte pwr) {
      String ret = "pty";
      if (pwr == 1) {
         ret = vlblRSkls[0] + "0";
      } else if (pwr == 2) {
      }

      return ret;
   }

   public static String SklGveY(byte rc, byte cls, byte pwr) {
      String ret = "pty";
      if (pwr == 1) {
         if (rc == 1 || rc == 2) {
            ret = "Sai";
         }
      } else if (pwr == 2 && rc == 0 && ncCSkls[cls].length() > 0) {
         ret = ncCSkls[cls] + "0";
      }

      return ret;
   }

   public static String[] data(int i) {
      switch(i) {
      case -1:
         return plyrs;
      case 0:
         return data0;
      case 1:
         return data1;
      case 2:
         return data2;
      case 3:
         return data3;
      case 4:
         return data4;
      case 5:
         return data5;
      case 6:
         return data6;
      case 7:
         return data7;
      case 8:
         return data8;
      case 9:
         return data9;
      case 10:
         return dat10;
      case 11:
         return dat11;
      case 12:
         return dat12;
      case 13:
         return dat13;
      case 14:
         return dat14;
      case 15:
         return dat15;
      case 16:
         return dat16;
      case 17:
         return dat17;
      case 18:
         return dat18;
      case 19:
         return dat19;
      case 20:
         return dat20;
      case 21:
         return dat21;
      case 22:
         return dat22;
      case 23:
         return dat23;
      case 24:
         return dat24;
      case 25:
         return dat25;
      case 26:
         return dat26;
      case 27:
         return dat27;
      case 28:
         return dat28;
      case 29:
         return dat29;
      case 30:
         return dat30;
      case 31:
         return dat31;
      case 32:
         return dat32;
      default:
         return plyrs;
      }
   }

   public static void rdc(String[] d, int c) {
      if (c == 0) {
         data0 = d;
      } else if (c == -1) {
         plyrs = d;
      } else if (c == 1) {
         data1 = d;
      } else if (c == 2) {
         data2 = d;
      } else if (c == 3) {
         data3 = d;
      } else if (c == 4) {
         data4 = d;
      } else if (c == 5) {
         data5 = d;
      } else if (c == 6) {
         data6 = d;
      } else if (c == 7) {
         data7 = d;
      } else if (c == 8) {
         data8 = d;
      } else if (c == 9) {
         data9 = d;
      } else if (c == 10) {
         dat10 = d;
      } else if (c == 11) {
         dat11 = d;
      } else if (c == 12) {
         dat12 = d;
      } else if (c == 13) {
         dat13 = d;
      } else if (c == 14) {
         dat14 = d;
      } else if (c == 15) {
         dat15 = d;
      } else if (c == 16) {
         dat16 = d;
      } else if (c == 17) {
         dat17 = d;
      } else if (c == 18) {
         dat18 = d;
      } else if (c == 19) {
         dat19 = d;
      } else if (c == 20) {
         dat20 = d;
      } else if (c == 21) {
         dat21 = d;
      } else if (c == 22) {
         dat22 = d;
      } else if (c == 23) {
         dat23 = d;
      } else if (c == 24) {
         dat24 = d;
      } else if (c == 25) {
         dat25 = d;
      } else if (c == 26) {
         dat26 = d;
      } else if (c == 27) {
         dat27 = d;
      } else if (c == 28) {
         dat28 = d;
      } else if (c == 29) {
         dat29 = d;
      } else if (c == 30) {
         dat30 = d;
      } else if (c == 31) {
         dat31 = d;
      } else if (c == 32) {
         dat32 = d;
      }

   }

   public static boolean dnn(int c) {
      boolean b = false;
      if (plyrs != null) {
         if (c == 0 && data0 != null && data0.length >= plyrs.length) {
            b = true;
         } else if (c == -1 && plyrs != null) {
            b = true;
         } else if (c == 1 && data1 != null && data1.length >= plyrs.length) {
            b = true;
         } else if (c == 2 && data2 != null && data2.length >= plyrs.length) {
            b = true;
         } else if (c == 3 && data3 != null && data3.length >= plyrs.length) {
            b = true;
         } else if (c == 4 && data4 != null && data4.length >= plyrs.length) {
            b = true;
         } else if (c == 5 && data5 != null && data5.length >= plyrs.length) {
            b = true;
         } else if (c == 6 && data6 != null && data6.length >= plyrs.length) {
            b = true;
         } else if (c == 7 && data7 != null && data7.length >= plyrs.length) {
            b = true;
         } else if (c == 8 && data8 != null && data8.length >= plyrs.length) {
            b = true;
         } else if (c == 9 && data9 != null && data9.length >= plyrs.length) {
            b = true;
         } else if (c == 10 && dat10 != null && dat10.length >= plyrs.length) {
            b = true;
         } else if (c == 11 && dat11 != null && dat11.length >= plyrs.length) {
            b = true;
         } else if (c == 12 && dat12 != null && dat12.length >= plyrs.length) {
            b = true;
         } else if (c == 13 && dat13 != null && dat13.length >= plyrs.length) {
            b = true;
         } else if (c == 14 && dat14 != null && dat14.length >= plyrs.length) {
            b = true;
         } else if (c == 15 && dat15 != null && dat15.length >= plyrs.length) {
            b = true;
         } else if (c == 16 && dat16 != null && dat16.length >= plyrs.length) {
            b = true;
         } else if (c == 17 && dat17 != null && dat17.length >= plyrs.length) {
            b = true;
         } else if (c == 18 && dat18 != null && dat18.length >= plyrs.length) {
            b = true;
         } else if (c == 19 && dat19 != null && dat19.length >= plyrs.length) {
            b = true;
         } else if (c == 20 && dat20 != null && dat20.length >= plyrs.length) {
            b = true;
         } else if (c == 21 && dat21 != null && dat21.length >= plyrs.length) {
            b = true;
         } else if (c == 22 && dat22 != null && dat22.length >= plyrs.length) {
            b = true;
         } else if (c == 23 && dat23 != null && dat23.length >= plyrs.length) {
            b = true;
         } else if (c == 24 && dat24 != null && dat24.length >= plyrs.length) {
            b = true;
         } else if (c == 25 && dat25 != null && dat25.length >= plyrs.length) {
            b = true;
         } else if (c == 26 && dat26 != null && dat26.length >= plyrs.length) {
            b = true;
         } else if (c == 27 && dat27 != null && dat27.length >= plyrs.length) {
            b = true;
         } else if (c == 28 && dat28 != null && dat28.length >= plyrs.length) {
            b = true;
         } else if (c == 29 && dat29 != null && dat29.length >= plyrs.length) {
            b = true;
         } else if (c == 30 && dat30 != null && dat30.length >= plyrs.length) {
            b = true;
         } else if (c == 31 && dat31 != null && dat31.length >= plyrs.length) {
            b = true;
         } else if (c == 32 && dat32 != null && dat32.length >= plyrs.length) {
            b = true;
         }
      }

      return b;
   }

   public static String data(int i, String d) {
      return data(mod_JRMCore.proxy.getPlayerClient().func_70005_c_(), i, d);
   }

   public static String data(String p, int i, String d) {
      if (dnn(i)) {
         HashMap<String, Integer> l = new HashMap();

         for(int j = 0; j < plyrs.length; ++j) {
            l.put(plyrs[j], j);
         }

         if (l.get(p) != null) {
            return data(i)[(Integer)l.get(p)];
         }
      }

      return d;
   }

   public static String dataP(int i, String d) {
      return data(i) != null ? data(i)[0] : d;
   }

   public static String data(int p, int i, String d) {
      return dnn(i) ? data(i)[p] : d;
   }

   public static long bpc(Entity e) {
      long l;
      if (e instanceof EntityCreature) {
         int atr = (int)(((EntityCreature)e).func_110138_aP() / statInc(1, 2, 1, 0, 0, 0.0F));
         l = 1L;
         l = (long)(atr * 10 + atr * 4 + atr * 6 + atr * 10 + atr * 5);
         l = l < 2L ? 2L : l;
         if (BPMode == 1) {
            l *= l / 2L;
         }

         return l < 1L ? 1L : l;
      } else if (e instanceof EntityPlayer) {
         String[] s = data(e.func_70005_c_(), 0, "0;0;0").split(";");
         l = bpc((EntityPlayer)e, e.func_70005_c_());
         return l < 5L ? 5L : l;
      } else {
         return 1L;
      }
   }

   public static long bpc(String p) {
      return bpc(p, (byte)1);
   }

   public static long bpc(EntityPlayer player, String p) {
      return bpc(player, p, (byte)1);
   }

   public static long bpc(String p, byte pt) {
      return bpc((EntityPlayer)null, p, pt, -1);
   }

   public static long bpc(EntityPlayer player, String p, byte pt) {
      return bpc(player, p, pt, -1);
   }

   public static long bpc(String playerID, byte powerType, int rl) {
      return bpc((EntityPlayer)null, playerID, powerType, rl);
   }

   public static long bpc(EntityPlayer player, String playerID, byte powerType, int rl) {
      long in = 1L;
      if (dnn(1) && dnn(10) && dnn(2) && dnn(14) && dnn(6)) {
         for(int i = 0; i < plyrs.length; ++i) {
            if (playerID.equals(plyrs[i])) {
               String[] d0 = data(playerID, 0, "0;0").split(";");
               int alvc = Integer.parseInt(d0[0]);
               int gp = Integer.parseInt(d0[1]);
               String[] s = data1[i].split(";");
               int pwr = Integer.parseInt(s[2]);
               int race = Integer.parseInt(s[0]);
               s = data6[i].split(";");
               String sX = s[1];
               String sY = s[2];
               String sZ = s[3];
               String[] PlyrSkills = s[0].split(",");
               int cr = rl >= 0 ? rl : Integer.parseInt(dat10[i].split(";")[0]);
               int stam = Integer.parseInt(dat10[i].split(";")[1]);
               int st = Integer.parseInt(data2[i].split(";")[0]);
               int st2 = Integer.parseInt(data2[i].split(";")[1]);
               int resrv = getArcRsrv(i);
               String[] a = dat14[i].split(",");
               int[] PlyrAttrbts = new int[a.length];
               boolean mj = StusEfctsClient(12, i);
               boolean lg = StusEfctsClient(14, i);
               boolean kk = StusEfctsClient(5, i);
               boolean mc = StusEfctsClient(13, i);
               boolean vb = StusEfctsClient(17, i);
               boolean mn = StusEfctsClient(19, i);
               boolean gd = StusEfctsClient(20, i);

               for(int i1 = 0; i1 < PlyrAttrbts.length; ++i1) {
                  PlyrAttrbts[i1] = Integer.parseInt(a[i1]);
               }

               long sr = (long)PlyrAttrbts[0];
               long de = (long)PlyrAttrbts[1];
               long co = (long)PlyrAttrbts[2];
               long wi = (long)PlyrAttrbts[3];
               long mi = (long)PlyrAttrbts[4];
               long cc = (long)PlyrAttrbts[5];
               boolean c = StusEfctsClient(10, i) || StusEfctsClient(11, i);
               if (pwr == 1) {
                  boolean sgf = SklLvl(9) > 0 || gp > 0 || vb;
                  if (JRMCoreHDBC.godKiUser(race, st) && !sgf) {
                     st = 0;
                  }

                  String absorption = dnn(6) ? getMajinAbsorptionValue(playerID) + "" : "0";
                  sr = (long)getPlayerAttribute(player, PlyrAttrbts, 0, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
                  de = (long)getPlayerAttribute(player, PlyrAttrbts, 1, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
                  wi = (long)getPlayerAttribute(player, PlyrAttrbts, 3, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
               }

               long f = sr + de + co;
               long m = wi + mi + cc;
               ++alvc;
               if (isPowerTypeKi(powerType)) {
                  long res = 0L;
                  res = sr * 10L + de * 4L + co * 6L + wi * 10L + cc * 5L;
                  res = res < 2L ? 2L : res;
                  if (BPMode == 1) {
                     res = res / 2L * (res / 100L) * (res / 100L);
                  }

                  double re = (double)cr * 0.01D;
                  res = (long)((double)res * re);
                  res = res < 5L ? 5L : res;
                  in = res;
               } else if (isPowerTypeChakra(powerType)) {
                  int n = 0;

                  for(byte i1 = 0; i1 < PlyrSkills.length; ++i1) {
                     String curSkl = PlyrSkills[i1];
                     if (curSkl.length() > 2 && !curSkl.contains("pty")) {
                        n += Integer.parseInt(curSkl.substring(2)) * 5;
                     }
                  }

                  float flt = 0.001388F;
                  int b = (int)((float)alvc * flt + (float)f + (float)m + (float)n);
                  in = (long)b;
               }
               break;
            }
         }
      }

      return in;
   }

   public static long time(double m) {
      return (long)((double)System.currentTimeMillis() * 0.04D * m);
   }

   public static long gkap(long in, String p) {
      return gkap(in, p, 40, 1.0D);
   }

   public static long gkap(long in, String p, int c, double m) {
      Object[] ny = (Object[])tacx.get(p);
      if (ny != null) {
         long bo = (Long)ny[0];
         long bp = (Long)ny[1];
         long bc = (Long)ny[2];
         int br = (Integer)ny[3];
         long btc = (Long)ny[4];
         long btp = (Long)ny[5];
         long bs;
         Object[] no;
         long bt;
         if (in != bo) {
            bc = (bo - bp) / (long)br;
            bt = btc - btp;
            bs = bt * bc + bp;
            no = new Object[]{in, bs, bc, c, time(m), time(m)};
            tacx.put(p, no);
            return bs;
         }

         if (btp + (long)br > time(m)) {
            bc = (bo - bp) / (long)br;
            bt = btc - btp;
            bs = bt * bc + bp;
            no = new Object[]{in, bp, bc, c, time(m), btp};
            tacx.put(p, no);
            return bs;
         }

         Object[] no = new Object[]{in, bo, in, c, time(m), time(m)};
         tacx.put(p, no);
      } else {
         Object[] no = new Object[]{in, in, in, c, time(m), time(m)};
         tacx.put(p, no);
      }

      return in;
   }

   public static int updateArcosianPowerPoints(int resrv, String SklX, int st, int stateID) {
      int skl = SklLvlX(1, SklX) - 1;
      skl = skl < 0 ? 0 : skl;
      int arg = (int)((double)JRMCoreConfig.ArcosianPPGrowth[stateID] * JRMCoreConfig.appm);
      return resrv + arg > JRMCoreConfig.ArcosianPPMax[skl] ? JRMCoreConfig.ArcosianPPMax[skl] : resrv + arg;
   }

   public static int updateArcosianPowerPoints(int resrv, String SklX, int st, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      int stateID = getArcosianFormID(st, isMysticOn, isUltraInstinctOn, isGoDOn);
      return updateArcosianPowerPoints(resrv, SklX, st, stateID);
   }

   public static int ArcRsrvMaxSkll(int resrv, String SklX, int st) {
      return updateArcosianPowerPoints(resrv, SklX, st, st);
   }

   public static int getArcRsrv(int pl) {
      return dnn(13) && dat13.length > pl ? Integer.parseInt(dat13[pl].split(";")[2]) : 0;
   }

   public static int getArcRsrvID(String id) {
      for(int pl = 0; pl < plyrs.length; ++pl) {
         if (plyrs[pl].equals(id) && dnn(13)) {
            return Integer.parseInt(dat13[pl].split(";")[2]);
         }
      }

      return 0;
   }

   public static int getArcRsrv() {
      return getArcRsrvID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
   }

   public static int getArcosianPowerPointBoost(int curentPow, int state, int currentRelease, int currentReserv, int stateID) {
      if (state > 3 && currentRelease == 100 && currentReserv > 0) {
         boolean addPointValue = JRMCoreConfig.ArcosianPPDamMultiPoint[stateID] != -1.0F;
         int result = (int)((float)curentPow * JRMCoreConfig.ArcosianPPDamMulti[stateID] * (addPointValue ? 1.0F + getArcosianReserveMaxPointPercentage(currentReserv) * JRMCoreConfig.ArcosianPPDamMultiPoint[stateID] : 1.0F));
         return result;
      } else {
         return curentPow;
      }
   }

   public static int ArcRsrvPowBst(int curentPow, int state, int currentRelease, int currentReserv) {
      return getArcosianPowerPointBoost(curentPow, state, currentRelease, currentReserv, state);
   }

   public static float getArcosianReserveMaxPointPercentage(int currentReserv) {
      float highest = (float)JRMCoreConfig.ArcosianPPMax[JRMCoreConfig.ArcosianPPDamMultiHighest];
      return (float)currentReserv / highest;
   }

   public static int getMajinAbsorptionValueS(String absorptionData) {
      String[] data = absorptionData.split(",");
      String value = data.length >= 3 ? data[0] : absorptionData;
      return Integer.parseInt(value);
   }

   public static String getMajinAbsorptionID(String playerName) {
      if (dnn(13)) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs.length > pl && plyrs[pl] != null && plyrs[pl].equals(playerName) && dat13.length > pl && dat13[pl] != null) {
               String[] data = dat13[pl].split(";");
               if (data.length > 3) {
                  return data[3];
               }
               break;
            }
         }
      }

      return "0";
   }

   public static int getMajinAbsorptionValue(String playerName) {
      String data = getMajinAbsorptionID(playerName);
      return Integer.parseInt(data.split(",")[0]);
   }

   public static String getMajinAbsorption() {
      return getMajinAbsorptionID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
   }

   public static int getMajinAbsorptionValue() {
      String data = getMajinAbsorptionID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
      return Integer.parseInt(data.split(",")[0]);
   }

   public static boolean rSai(int r) {
      return isRaceSaiyan(r);
   }

   public static boolean rSai() {
      return Race == 1 || Race == 2;
   }

   public static boolean tailHas(int r) {
      return r != 2 && r != 3 && r != 4;
   }

   public static final String TransNms(int i1, int i2, boolean v, boolean my, boolean ui) {
      return getTransformationName(i1, i2, v, my, ui, false);
   }

   public static final String getTransformationName(int i1, int i2, boolean v, boolean my, boolean ui, boolean gd) {
      if (my) {
         return "PotUnleashed";
      } else if (ui) {
         return "UInstinct";
      } else if (!gd) {
         if (rc_sai(i1) && i2 == 10 && v) {
            return "SuperR";
         } else if (rc_sai(i1) && i2 == 15 && v) {
            return "SuperRS";
         } else if (rc_sai(i1) && TransNms[i1][i2].equals("Super4") && isAprilFoolsModeOn()) {
            return "Super5";
         } else {
            return rc_sai(i1) && TransNms[i1][i2].equals("Super") && isAprilFoolsModeOn() ? "SuperFalse" : TransNms[i1][i2];
         }
      } else {
         return rc_sai(i1) && isAprilFoolsModeOn() ? "UltraEgo" : "GoDestruction";
      }
   }

   public static byte getTransformationDescendToFormID(byte race, byte state, boolean hasFullPowerSSJ) {
      byte result = transformationDescendToFormID[race][state];
      if (isRaceSaiyan(race) && (result == 1 || result == 4)) {
         result = (byte)(hasFullPowerSSJ ? 4 : 1);
      }

      return result;
   }

   public static boolean isSaiyanSuperFullPower(NBTTagCompound nbt) {
      String s1 = nbt.func_74779_i("jrmcSSltX");
      int racialSkillLevel = SklLvlX(1, s1);
      return racialSkillLevel >= 5;
   }

   public static String getNBTFormMasteryRacialKey(int race) {
      return "jrmcFormMasteryRacial_" + Races[race];
   }

   public static String[] getNBTFormMasteryRacialKeys(int race) {
      String[] NBT = new String[]{getNBTFormMasteryRacialKey(race), "jrmcFormMasteryNonRacial"};
      return NBT;
   }

   public static String getNBTFormMasteryRacialKey(boolean racial, int race) {
      String[] NBT = new String[]{getNBTFormMasteryRacialKey(race), "jrmcFormMasteryNonRacial"};
      return NBT[racial ? 0 : 1];
   }

   public static boolean hasNBTFormMasteryRacial(NBTTagCompound nbt) {
      int race = nbt.func_74771_c("jrmcRace");
      String nbtKey = getNBTFormMasteryRacialKey(race);
      return nbt.func_74764_b(nbtKey) || nbt.func_74779_i(nbtKey).equals("Base,0");
   }

   public static boolean hasNBTFormMasteryNonRacial(NBTTagCompound nbt) {
      return nbt.func_74764_b("jrmcFormMasteryNonRacial") || nbt.func_74779_i("jrmcFormMasteryNonRacial").equals("Kaioken,0") || nbt.func_74779_i("jrmcFormMasteryNonRacial").equals("Base,0");
   }

   public static String getDefaultFormMasteryRacialText(int race) {
      String mastery = "";
      int length = trans[race].length;

      for(int i = 0; i < length; ++i) {
         mastery = mastery + trans[race][i] + ",0" + (i + 1 < length ? ";" : "");
      }

      return mastery;
   }

   public static String getDefaultFormMasteryNonRacialText() {
      String mastery = "";
      int length = transNonRacial.length;

      for(int i = 0; i < length; ++i) {
         mastery = mastery + transNonRacial[i] + ",0" + (i + 1 < length ? ";" : "");
      }

      return mastery;
   }

   public static int getFormID(String formID, int race, boolean addRacials) {
      int i = 0;
      String[] var4 = transNonRacial;
      int var5 = var4.length;

      int var6;
      String form;
      for(var6 = 0; var6 < var5; ++var6) {
         form = var4[var6];
         if (formID.equals(form)) {
            return i + (addRacials ? trans[race].length : 0);
         }

         ++i;
      }

      i = 0;
      var4 = trans[race];
      var5 = var4.length;

      for(var6 = 0; var6 < var5; ++var6) {
         form = var4[var6];
         if (formID.equals(form)) {
            return i;
         }

         ++i;
      }

      return 0;
   }

   public static int getFormID(String formID, int race) {
      return getFormID(formID, race, true);
   }

   public static boolean isCurrentFormID(String checkedFormID, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      if (state2 > 0) {
         if (isKaiokenOn && checkedFormID.equals("Kaioken")) {
            return true;
         }

         if (isUltraInstinctOn && checkedFormID.equals("UltraInstict")) {
            return true;
         }
      }

      if (isMysticOn && checkedFormID.equals("Mystic")) {
         return true;
      } else {
         return isGoDOn && checkedFormID.equals("GodOfDestruction");
      }
   }

   public static String getCurrentFormName(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      int baseState = isRaceArcosian(race) ? 4 : 0;
      String currentFormID = "";
      if (isMysticOn) {
         currentFormID = transNonRacial[1];
      } else if (isGoDOn) {
         currentFormID = transNonRacial[3];
      } else if (state == baseState && !isUltraInstinctOn) {
         currentFormID = "Base";
      } else if (state > baseState || isRaceArcosian(race) && state < baseState && !isUltraInstinctOn) {
         currentFormID = trans[race][state];
      } else if (state2 > 0) {
         if (isKaiokenOn) {
            currentFormID = transNonRacial[0];
         } else if (isUltraInstinctOn) {
            currentFormID = transNonRacial[2];
         } else {
            currentFormID = trans[race][state];
         }
      }

      return currentFormID;
   }

   public static int getCurrentFormID(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      int baseState = isRaceArcosian(race) ? 4 : 0;
      int currentFormID = 0;
      if (isMysticOn) {
         currentFormID = trans[race].length + 1;
      } else if (isGoDOn) {
         currentFormID = trans[race].length + 3;
      } else if (state == baseState && !isUltraInstinctOn) {
         currentFormID = baseState;
      } else if (state > baseState || isRaceArcosian(race) && state < baseState && !isUltraInstinctOn) {
         currentFormID = state;
      } else if (state2 > 0) {
         if (isKaiokenOn) {
            currentFormID = trans[race].length + 0;
         } else if (isUltraInstinctOn) {
            currentFormID = trans[race].length + 2;
         } else {
            currentFormID = state;
         }
      }

      return currentFormID;
   }

   public static boolean isCurrentFormRacial(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      int baseState = isRaceArcosian(race) ? 4 : 0;
      if (!isMysticOn && !isGoDOn) {
         if (state2 > 0 && (isKaiokenOn || isUltraInstinctOn)) {
            return false;
         } else if (state == baseState && !isUltraInstinctOn) {
            return true;
         } else {
            return state > 0 ? true : true;
         }
      } else {
         return false;
      }
   }

   public static void updateFormMasteryVersion(NBTTagCompound nbt) {
      if (nbt.func_74764_b("jrmcFormMasteryRacial")) {
         String mastery = nbt.func_74779_i("jrmcFormMasteryRacial");
         if (mastery != null && mastery.length() > 0) {
            int oldMasteryRace = true;
            String[] masteryData = mastery.split(";");
            int races = Races.length;

            for(int raceID = 0; raceID < races; ++raceID) {
               int forms = trans[raceID].length;
               if (forms == masteryData.length) {
                  boolean sameForms = true;

                  for(int formID = 0; formID < forms; ++formID) {
                     String formName = masteryData[formID].split(",")[0];
                     if (!formName.equals(trans[raceID][formID])) {
                        sameForms = false;
                        break;
                     }
                  }

                  if (sameForms) {
                     nbt.func_74778_a(getNBTFormMasteryRacialKey(raceID), mastery);
                     break;
                  }
               }
            }
         }

         nbt.func_82580_o("jrmcFormMasteryRacial");
      }

   }

   public static String convertFormMasteryToFormat(String formMastery, String decimalFormat) {
      DecimalFormat format = new DecimalFormat(decimalFormat);
      String[] data = formMastery.split(";");
      String newFormMastery = "";

      for(int i = 0; i < data.length; ++i) {
         String[] values = data[i].split(",");
         double value = Double.parseDouble(format.format(Double.parseDouble(values[1])).replace(",", "."));
         newFormMastery = newFormMastery + values[0] + "," + (value == (double)((int)value) ? (int)value + "" : value) + (i + 1 < data.length ? ";" : "");
      }

      return newFormMastery;
   }

   public static String getFormMasteryData(EntityPlayer player) {
      return getFormMasteryData(player, "");
   }

   public static String getFormMasteryData(EntityPlayer player, String decimalFormat) {
      if (player != null && player.field_70170_p != null) {
         if (!player.field_70170_p.field_72995_K) {
            JGPlayerMP jgPlayer = new JGPlayerMP(player);
            jgPlayer.connectBaseNBT();
            String mastery = "";
            updateFormMasteryVersion(jgPlayer.getNBT());
            if (isFused(player)) {
               String Fzn = jgPlayer.getNBT().func_74779_i("jrmcFuzion");
               if (Fzn.contains(",")) {
                  String[] FznA = Fzn.split(",");
                  if (FznA.length == 3) {
                     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                     EntityPlayer p1 = getPlayerForUsername(server, FznA[0]);
                     EntityPlayer p2 = getPlayerForUsername(server, FznA[1]);
                     if (p1 != null && p2 != null) {
                        jgPlayer = new JGPlayerMP(p1);
                        jgPlayer.connectBaseNBT();
                        if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
                           mastery = mastery + getDefaultFormMasteryRacialText(jgPlayer.getRace());
                        } else {
                           mastery = mastery + jgPlayer.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
                        }

                        mastery = mastery + ";";
                        if (!hasNBTFormMasteryNonRacial(jgPlayer.getNBT())) {
                           mastery = mastery + getDefaultFormMasteryNonRacialText();
                        } else {
                           mastery = mastery + jgPlayer.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
                        }

                        JGPlayerMP jgPlayerPartner = new JGPlayerMP(p2);
                        jgPlayerPartner.connectBaseNBT();
                        if (jgPlayerPartner.getRace() == jgPlayer.getRace()) {
                           updateFormMasteryVersion(jgPlayerPartner.getNBT());
                           String masteryPartner = "";
                           if (!hasNBTFormMasteryRacial(jgPlayerPartner.getNBT())) {
                              masteryPartner = masteryPartner + getDefaultFormMasteryRacialText(jgPlayerPartner.getRace());
                           } else {
                              masteryPartner = masteryPartner + jgPlayerPartner.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
                           }

                           masteryPartner = masteryPartner + ";";
                           if (!hasNBTFormMasteryNonRacial(jgPlayerPartner.getNBT())) {
                              masteryPartner = masteryPartner + getDefaultFormMasteryNonRacialText();
                           } else {
                              masteryPartner = masteryPartner + jgPlayerPartner.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
                           }

                           String[] p1Mastery = mastery.split(";");
                           String[] p2Mastery = masteryPartner.split(";");
                           mastery = "";
                           int length = p1Mastery.length;
                           int length2 = p2Mastery.length;
                           if (length == length2) {
                              for(int i = 0; i < length; ++i) {
                                 String[] values = p1Mastery[i].split(",");
                                 String[] values2 = p2Mastery[i].split(",");
                                 double result = (Double.parseDouble(values[1]) + Double.parseDouble(values2[1])) * 1.0D;
                                 mastery = mastery + values[0] + "," + result + (i + 1 < length ? ";" : "");
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (mastery == null || mastery.length() == 0) {
               mastery = "";
               if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
                  mastery = mastery + getDefaultFormMasteryRacialText(jgPlayer.getRace());
               } else {
                  mastery = mastery + jgPlayer.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
               }

               mastery = mastery + ";";
               if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
                  mastery = mastery + getDefaultFormMasteryNonRacialText();
               } else {
                  mastery = mastery + jgPlayer.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
               }
            }

            return decimalFormat != null && decimalFormat.length() != 0 ? convertFormMasteryToFormat(mastery, decimalFormat) : mastery;
         }

         if (dnn(32) && plyrs != null) {
            String playerName = mod_JRMCore.proxy.getPlayerClient().func_70005_c_();
            if (playerName == null || playerName.length() == 0) {
               return "";
            }

            for(int pl = 0; pl < plyrs.length; ++pl) {
               if (plyrs[pl] != null && plyrs[pl].equals(playerName)) {
                  if (dat32 != null && dat32.length > pl) {
                     return dat32[pl];
                  }
                  break;
               }
            }
         }
      }

      return "Base,0";
   }

   public static String getFormMasteryData() {
      String data = getFormMasteryData(mod_JRMCore.proxy.getPlayerClient());
      if (data != null && data.length() > 0 && data.contains(";")) {
         int race = Race;
         int state = State;
         int state2 = State2;
         boolean isKaiokenOn = StusEfctsMe(5);
         boolean isMysticOn = StusEfctsMe(13);
         boolean isUltraInstinctOn = StusEfctsMe(19);
         boolean isGoDOn = StusEfctsMe(20);
         int formID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
         String[] dataArray = data.split(";");
         if (dataArray.length > formID) {
            return dataArray[formID];
         }
      }

      return "Base,0";
   }

   public static String getFormMasteryData(EntityPlayer player, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      String data = getFormMasteryData(player);
      if (data != null && data.length() > 0 && data.contains(";")) {
         int formID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
         String[] dataArray = data.split(";");
         if (dataArray.length > formID) {
            return dataArray[formID];
         }
      }

      return "";
   }

   public static String getFormMasteryNameFromData(String data) {
      if (data != null && data.length() > 0 && data.contains(",")) {
         String[] formData = data.split(",");
         return formData[0];
      } else {
         return "";
      }
   }

   public static double getFormMasteryValueFromData(String data) {
      if (data != null && data.length() > 0 && data.contains(",")) {
         String[] formData = data.split(",");
         double currFormValue = Double.parseDouble(formData[1]);
         return currFormValue;
      } else {
         return 0.0D;
      }
   }

   public static double getFormMasteryValue(EntityPlayer player, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      String data = getFormMasteryData(player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      return getFormMasteryValueFromData(data);
   }

   public static double getFormMasteryValue(EntityPlayer player, int formID) {
      String data = getFormMasteryData(player);
      if (data != null && data.length() > 0 && data.contains(";")) {
         String[] dataArray = data.split(";");
         if (dataArray.length > formID) {
            String[] formData = dataArray[formID].split(",");
            double currFormValue = Double.parseDouble(formData[1]);
            return currFormValue;
         }
      }

      return 0.0D;
   }

   public static double getFormMasteryValue(EntityPlayer player) {
      if (dnn(1) && dnn(2) && dnn(19) && dnn(32) && plyrs != null) {
         if (player == null) {
            return 0.0D;
         }

         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl] != null && plyrs[pl].equals(player.func_70005_c_())) {
               if (dat32 != null && dat32.length > pl) {
                  int race = Integer.parseInt(data1[pl].split(";")[0]);
                  int state = Integer.parseInt(data2[pl].split(";")[0]);
                  int state2 = Integer.parseInt(data2[pl].split(";")[1]);
                  String statusEffects = dat19[pl].split(";")[1];
                  boolean isKaiokenOn = StusEfcts(5, statusEffects);
                  boolean isMysticOn = StusEfcts(13, statusEffects);
                  boolean isUltraInstinctOn = StusEfcts(19, statusEffects);
                  boolean isGoDOn = StusEfcts(20, statusEffects);
                  return getFormMasteryValue(player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
               }
               break;
            }
         }
      }

      return 0.0D;
   }

   public static double getFormMasteryValue() {
      int race = Race;
      int state = State;
      int state2 = State2;
      boolean isKaiokenOn = StusEfctsMe(5);
      boolean isMysticOn = StusEfctsMe(13);
      boolean isUltraInstinctOn = StusEfctsMe(19);
      boolean isGoDOn = StusEfctsMe(20);
      return getFormMasteryValue(mod_JRMCore.proxy.getPlayerClient(), race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
   }

   public static int getFormIDFromName(int race, String formName) {
      int formID = false;
      int length = trans[race].length;

      int i;
      for(i = 0; i < length; ++i) {
         if (trans[race][i].equals(formName)) {
            return i;
         }
      }

      length = transNonRacial.length;

      for(i = 0; i < length; ++i) {
         if (transNonRacial[i].equals(formName)) {
            return i + trans[race].length;
         }
      }

      return 0;
   }

   public static void changeFormMasteryValue(EntityPlayer player, double value, boolean add, int race, int formID, boolean racial, int gainMultiID) {
      if (JGConfigDBCFormMastery.FM_Enabled) {
         if (!isFused(player)) {
            JGPlayerMP jgPlayer = new JGPlayerMP(player);
            NBTTagCompound nbt = jgPlayer.connectBaseNBT();
            String nbtKey = getNBTFormMasteryRacialKey(racial, race);
            String nbtKeyRacial = getNBTFormMasteryRacialKey(true, race);
            String nbtKeyNonRacial = getNBTFormMasteryRacialKey(false, race);
            boolean hasNBTRacial = nbt.func_74764_b(nbtKeyRacial) && !nbt.func_74779_i(nbtKeyRacial).equals("Base,0") && !nbt.func_74779_i(nbtKeyRacial).equals("Kaioken,0") && nbt.func_74779_i(nbtKeyRacial).contains(",");
            boolean hasNBTNonRacial = nbt.func_74764_b(nbtKeyNonRacial) && !nbt.func_74779_i(nbtKeyNonRacial).equals("Kaioken,0") && !nbt.func_74779_i(nbtKeyNonRacial).equals("Base,0") && nbt.func_74779_i(nbtKeyNonRacial).contains(",");
            String addToOther;
            if (!hasNBTRacial) {
               addToOther = getDefaultFormMasteryRacialText(race);
               nbt.func_74778_a(nbtKeyRacial, addToOther);
            }

            if (!hasNBTNonRacial) {
               addToOther = getDefaultFormMasteryNonRacialText();
               nbt.func_74778_a(nbtKeyNonRacial, addToOther);
            }

            addToOther = "";
            String[] masteries = nbt.func_74779_i(nbtKey).split(";");
            int length = masteries.length;

            String[] otherData;
            int formIDOther;
            int id;
            String nbtKeyOther;
            double valueOther;
            for(int i = 0; i < length; ++i) {
               if (i == formID - (racial ? 0 : trans[race].length)) {
                  otherData = masteries[i].split(",");
                  if (otherData.length > 1) {
                     double result = value;
                     double prevLevel;
                     if (add) {
                        prevLevel = Double.parseDouble(otherData[1]);
                        int j;
                        if (gainMultiID > -1) {
                           int gainID = JGConfigDBCFormMastery.DATA_ID_GAIN_PASSIVE + gainMultiID;
                           value = JGConfigDBCFormMastery.getDouble(race, formID, gainID, 0);
                           double multipliedGain = JGConfigDBCFormMastery.getMultipliedGain(prevLevel, value, gainID, race, formID);
                           j = jgPlayer.getAttributes()[4];
                           double mindMulti = JGConfigDBCFormMastery.getMindGainMulti(gainMultiID, j, gainMultiID, race, formID);
                           result = multipliedGain * mindMulti;
                        }

                        nbtKeyOther = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_GAIN_TO_OTHER_MASTERIES, 0);
                        if (nbtKeyOther != null && nbtKeyOther.contains(",") && nbtKeyOther.length() > 0) {
                           String[] masteryGainsOther = nbtKeyOther.split(";");
                           formIDOther = masteryGainsOther.length;

                           for(j = 0; j < formIDOther; ++j) {
                              String[] valuesOther = masteryGainsOther[j].split(",");
                              String nameOther = valuesOther[0];
                              id = 0;
                              boolean found = false;
                              String[] allForms = getFormMasteryData(player).split(";");
                              int lengthAll = allForms.length;

                              for(int k = 0; k < lengthAll; ++k) {
                                 String name = allForms[k].split(",")[0];
                                 if (name.equals(nameOther)) {
                                    id = k;
                                    found = true;
                                    break;
                                 }
                              }

                              if (found && id != -1 && id != formID) {
                                 valueOther = Double.parseDouble(valuesOther[1]) * result;
                                 addToOther = addToOther + id + "," + valueOther + "," + (id < trans[race].length) + (j + 1 < length ? ";" : "");
                              }
                           }
                        }

                        result += prevLevel;
                     }

                     prevLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_MAX_LEVEL, 0);
                     if (result > prevLevel) {
                        result = prevLevel;
                     }

                     masteries[i] = otherData[0] + "," + result;
                  }
                  break;
               }
            }

            String mastery = "";

            for(int i = 0; i < length; ++i) {
               mastery = mastery + masteries[i] + (i + 1 < length ? ";" : "");
            }

            nbt.func_74778_a(nbtKey, mastery);
            if (addToOther.length() > 0) {
               otherData = addToOther.split(";");
               int lengthOther = otherData.length;

               for(int i = 0; i < lengthOther; ++i) {
                  String[] otherDataValues = otherData[i].split(",");
                  boolean isRacialOther = Boolean.parseBoolean(otherDataValues[2]);
                  nbtKeyOther = getNBTFormMasteryRacialKey(isRacialOther, race);
                  boolean hasNBTOther = nbt.func_74764_b(nbtKey) && !nbt.func_74779_i(nbtKey).equals("Base,0") && !nbt.func_74779_i(nbtKey).equals("Kaioken,0");
                  if (!hasNBTOther) {
                     mastery = isRacialOther ? getDefaultFormMasteryRacialText(race) : getDefaultFormMasteryNonRacialText();
                     nbt.func_74778_a(nbtKey, mastery);
                  }

                  formIDOther = Integer.parseInt(otherDataValues[0]);
                  double multiOther = Double.parseDouble(otherDataValues[1]);
                  String[] masteryBefore = nbt.func_74779_i(nbtKeyOther).split(";");
                  length = masteryBefore.length;
                  mastery = "";

                  for(id = 0; id < length; ++id) {
                     String[] masteryValuesAfter = masteryBefore[id].split(",");
                     double masteryValueBefore = Double.parseDouble(masteryValuesAfter[1]);
                     valueOther = masteryValueBefore + (id == formIDOther - (isRacialOther ? 0 : trans[race].length) ? multiOther : 0.0D);
                     double FM_LevelMax = JGConfigDBCFormMastery.getDouble(race, id + (isRacialOther ? 0 : trans[race].length), JGConfigDBCFormMastery.DATA_ID_MAX_LEVEL, 0);
                     if (valueOther > FM_LevelMax) {
                        valueOther = FM_LevelMax;
                     }

                     mastery = mastery + masteryValuesAfter[0] + "," + valueOther + (id + 1 < length ? ";" : "");
                  }

                  nbt.func_74778_a(nbtKeyOther, mastery);
               }
            }

         }
      }
   }

   public static void addToFormMasteryValue(EntityPlayer player, double value, int race, int FormID, boolean racial, int gainMultiID) {
      changeFormMasteryValue(player, value, true, race, FormID, racial, gainMultiID);
   }

   public static void setFormMasteryValue(EntityPlayer player, double value, int race, int FormID, boolean racial) {
      changeFormMasteryValue(player, value, false, race, FormID, racial, -1);
   }

   public static void addToFormMasteryValue(EntityPlayer player, double value, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
      int currentFormID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      boolean racial = isCurrentFormRacial(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      changeFormMasteryValue(player, value, true, race, currentFormID, racial, gainMultiID);
   }

   public static void setFormMasteryValue(EntityPlayer player, double value, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      int currentFormID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      boolean racial = isCurrentFormRacial(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      changeFormMasteryValue(player, value, false, race, currentFormID, racial, -1);
   }

   public static void changeFormMasteriesValue(EntityPlayer player, double value, double valueKK, boolean add, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
      if (add) {
         addToFormMasteryValue(player, value, race, state, state2, false, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID);
      } else {
         setFormMasteryValue(player, value, race, state, state2, false, isMysticOn, isUltraInstinctOn, isGoDOn);
      }

      boolean isInKaioken = isCurrentFormID("Kaioken", race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      if (isKaiokenOn && isInKaioken) {
         int kaiokenID = getFormID("Kaioken", race);
         if (add) {
            addToFormMasteryValue(player, valueKK, race, kaiokenID, false, gainMultiID);
         } else {
            setFormMasteryValue(player, valueKK, race, kaiokenID, false);
         }

         getFormMasteryValue(player, kaiokenID);
      }

   }

   public static void addToFormMasteriesValue(EntityPlayer player, double value, double valueKK, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
      changeFormMasteriesValue(player, value, valueKK, true, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID);
   }

   public static void setFormMasteriesValue(EntityPlayer player, double value, double valueKK, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
      changeFormMasteriesValue(player, value, valueKK, false, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID);
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery, int formID, boolean sayChat) {
      if (JGConfigDBCFormMastery.FM_Enabled && requiredMastery.contains(",") && requiredMastery.length() > 0) {
         String[] formData = data.split(";");
         String[] formDataR = requiredMastery.split(";");
         int i = 0;
         String[] var8 = formData;
         int var9 = formData.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            String s = var8[var10];
            if (formID == -1 || formID == i) {
               String[] formDataValues = s.split(",");
               String[] var13 = formDataR;
               int var14 = formDataR.length;

               for(int var15 = 0; var15 < var14; ++var15) {
                  String sR = var13[var15];
                  String[] formDataValuesR = sR.split(",");
                  if (formDataValues[0].equals(formDataValuesR[0])) {
                     double formValue = Double.parseDouble(formDataValues[1]);
                     double formValueR = Double.parseDouble(formDataValuesR[1]);
                     if (formValue < formValueR) {
                        if (sayChat) {
                           player.func_145747_a((new ChatComponentText("Failed to Transform! Form Mastery Requirement needed: " + formDataValuesR[0] + " Lvl: " + formDataValuesR[1])).func_150255_a(DBCPacketHandlerServer.styleRed));
                        } else {
                           player.func_145747_a((new ChatComponentText("Failed to hold Form! Form Mastery Requirement needed: " + formDataValuesR[0] + " Lvl: " + formDataValuesR[1])).func_150255_a(DBCPacketHandlerServer.styleRed));
                        }

                        return false;
                     }
                     break;
                  }
               }
            }

            ++i;
         }
      }

      return true;
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery, int formID) {
      return hasRequiredFormMasteries(player, data, requiredMastery, formID, true);
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, String formName, boolean sayChat) {
      int formID = getFormIDFromName(race, formName);
      String FM_RequiredMastery = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_REQUIRED_MASTERIES, 0);
      return FM_RequiredMastery == null ? true : hasRequiredFormMasteries(player, data, FM_RequiredMastery, -1, sayChat);
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, String formName) {
      return hasRequiredFormMasteries(player, data, race, formName, true);
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, int formID) {
      String FM_RequiredMastery = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_REQUIRED_MASTERIES, 0);
      return FM_RequiredMastery == null ? true : hasRequiredFormMasteries(player, data, FM_RequiredMastery, -1);
   }

   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery) {
      return hasRequiredFormMasteries(player, data, requiredMastery, -1);
   }

   public static boolean hasRequiredFormMasteries2(EntityPlayer player, String data, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      String formName = getCurrentFormName(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
      return hasRequiredFormMasteries(player, data, race, formName, false);
   }

   public static void autoLearnFormMastery(EntityPlayer player, int race) {
      if (JGConfigDBCFormMastery.FM_Enabled) {
         if (!isFused(player)) {
            String[] data = getFormMasteryData(player).split(";");
            int formID = 0;
            String[] var4 = data;
            int var5 = data.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String mastery = var4[var6];
               String[] values = mastery.split(",");
               double value = Double.parseDouble(values[1]);
               String FM_AutoLearnOnLevel = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_AUTO_LEARN_ON_LEVEL, 0);
               if (FM_AutoLearnOnLevel != null && FM_AutoLearnOnLevel.length() > 0 && FM_AutoLearnOnLevel.contains(",")) {
                  String[] autoUnlocks = FM_AutoLearnOnLevel.split(";");
                  String[] var13 = autoUnlocks;
                  int var14 = autoUnlocks.length;

                  for(int var15 = 0; var15 < var14; ++var15) {
                     String autoUnlock = var13[var15];
                     String[] valuesUnlock = autoUnlock.split(",");
                     double valueUnlock = Double.parseDouble(valuesUnlock[2]);
                     if (value >= valueUnlock) {
                        String nameUnlock = valuesUnlock[0];
                        String nameUnlockID = nameUnlock;
                        int levelID = Integer.parseInt(valuesUnlock[1]);
                        if (levelID < 0) {
                           levelID = 0;
                        }

                        JGPlayerMP jgPlayer = new JGPlayerMP(player);
                        jgPlayer.connectBaseNBT();
                        NBTTagCompound nbt = jgPlayer.getNBT();
                        String nameFullUnlock;
                        int id;
                        if (nameUnlock.equals("Racial")) {
                           nameFullUnlock = nbt.func_74779_i("jrmcSSltX");
                           id = SklLvlX(1, nameFullUnlock);
                           int maxLevel = JGRaceHelper.getMaxRacialSkillLevel(DBC(), NC(), (byte)race);
                           if (levelID > maxLevel) {
                              levelID = maxLevel;
                           }

                           if (id < levelID + 1 && nameFullUnlock.length() > 2 && !nameFullUnlock.contains("pty")) {
                              String name = nameFullUnlock.substring(0, 2);
                              nbt.func_74778_a("jrmcSSltX", name + levelID);
                              player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Racial Skill Level " + levelID)).func_150255_a(DBCPacketHandlerServer.styleYellow));
                           }
                        } else {
                           --levelID;
                           if (levelID < 0) {
                              levelID = 0;
                           }

                           nameFullUnlock = "";
                           id = 0;
                           String[] var27 = DBCSkillsIDs;
                           int maxLevel = var27.length;

                           for(int var29 = 0; var29 < maxLevel; ++var29) {
                              String ids = var27[var29];
                              if (ids.equals(nameUnlockID)) {
                                 nameFullUnlock = DBCSkillNames[id];
                                 break;
                              }

                              ++id;
                           }

                           boolean isUI = id == 16;
                           maxLevel = isUI ? JGConfigUltraInstinct.CONFIG_UI_LEVELS : vlblSklsUps[id] + 1;
                           if (levelID > maxLevel) {
                              levelID = maxLevel;
                           }

                           String[] s1 = nbt.func_74779_i("jrmcSSlts").split(",");
                           id = 0;
                           boolean foundSkill = false;
                           boolean learn = false;
                           String[] var32 = s1;
                           int var33 = s1.length;

                           int var34;
                           String name;
                           for(var34 = 0; var34 < var33; ++var34) {
                              String skill = var32[var34];
                              if (skill.length() > 2) {
                                 name = skill.substring(0, 2);
                                 if (name.equals(nameUnlockID)) {
                                    foundSkill = true;
                                    int skillLevel = Integer.parseInt(skill.substring(2, 3));
                                    if (skillLevel < levelID) {
                                       s1[id] = name + levelID;
                                       player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Skill " + nameFullUnlock + " Level " + (levelID + (isUI ? 0 : 1)))).func_150255_a(DBCPacketHandlerServer.styleYellow));
                                       learn = true;
                                    }
                                 }
                              }

                              ++id;
                           }

                           String skills = "";
                           String[] var44 = s1;
                           var34 = s1.length;

                           for(int var45 = 0; var45 < var34; ++var45) {
                              name = var44[var45];
                              if (s1.length > 0) {
                                 skills = skills + name + ",";
                              }
                           }

                           if (!foundSkill) {
                              skills = skills + nameUnlockID + levelID + ",";
                              player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Skill " + nameFullUnlock + " Level " + (levelID + (isUI ? 0 : 1)))).func_150255_a(DBCPacketHandlerServer.styleYellow));
                              learn = true;
                           }

                           if (learn) {
                              nbt.func_74778_a("jrmcSSlts", skills);
                           }
                        }
                     }
                  }
               }

               ++formID;
            }

         }
      }
   }

   public static int mstc_sai(int skl) {
      int[] in = new int[]{1, 1, 1, 4, 5, 6, 6, 6};
      return in[skl];
   }

   public static int mstc_arc() {
      return 5;
   }

   public static int mstc_humnam() {
      return 1;
   }

   public static double ev_oob(float[][] f, int a1, int a2) {
      if (f.length <= a1) {
         a1 = f.length - 1;
      }

      if (f[a1].length <= a2) {
         a2 = f[a1].length - 1;
      }

      return (double)f[a1][a2];
   }

   public static double ev_oob(int[][] f, int a1, int a2) {
      if (f.length <= a1) {
         a1 = f.length - 1;
      }

      if (f[a1].length <= a2) {
         a2 = f[a1].length - 1;
      }

      return (double)f[a1][a2];
   }

   public static String ev_oob(String[][] f, int a1, int a2) {
      if (f.length <= a1) {
         a1 = f.length - 1;
      }

      if (f[a1].length <= a2) {
         a2 = f[a1].length - 1;
      }

      return f[a1][a2];
   }

   public static boolean inBaseForm(int race, int state) {
      return race == 4 ? state == 4 : state == 0;
   }

   public static int TransSaiPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
      return getAttributeSaiyan((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
   }

   public static int TransSaiPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
      return getAttributeSaiyan((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
   }

   public static int getAttributeSaiyan(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      int race = true;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 1, false, mystic, ultraInstinct, GoD) : 1.0D;
      float[][] flatPercentage = isPowerTypeKi ? TransSaiStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransSaiStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(1, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(1, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[1] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int per;
      if (isPowerTypeKi) {
         if (mysticLvl > 0 && mystic) {
            float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[1][trans[1].length] * (float)skl;
            secondaryMulti = (double)(JRMCoreConfig.MysticDamMulti[1] == -1.0F ? flatPercentage[mstc_sai(skl)][atr] * (1.0F + AttibuteBonusPerRacialSkill) : JRMCoreConfig.MysticDamMulti[1] + AttibuteBonusPerRacialSkill);
         } else {
            per = JRMCoreConfig.AttibuteBonusPerRacialSkill[1].length - 1;
            secondaryMulti = (double)(1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[1][Math.min(st, per)] * (float)skl);
         }
      } else {
         secondaryMulti = 1.0D;
      }

      per = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt;
      if (isPowerTypeKi && mysticLvl > 0 && mystic) {
         flt = (int)((float)curAtr[atr] + (float)flatBonus[mstc_sai(skl)][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[1][trans[1].length] * (float)skl) * (float)atrLimit * 0.001F);
      } else {
         flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      }

      flt = flt > checkLimit() ? checkLimit() : flt;
      per = per <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : per;
      return per;
   }

   public static int getAttributeHalfSaiyan(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      int race = true;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 2, false, mystic, ultraInstinct, GoD) : 1.0D;
      float[][] flatPercentage = isPowerTypeKi ? TransHalfSaiStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransHalfSaiStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(2, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(2, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[2] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int per;
      if (isPowerTypeKi) {
         if (mysticLvl > 0 && mystic) {
            float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[2][trans[2].length] * (float)skl;
            secondaryMulti = (double)(JRMCoreConfig.MysticDamMulti[2] == -1.0F ? flatPercentage[mstc_sai(skl)][atr] * (1.0F + AttibuteBonusPerRacialSkill) : JRMCoreConfig.MysticDamMulti[2] + AttibuteBonusPerRacialSkill);
         } else {
            per = JRMCoreConfig.AttibuteBonusPerRacialSkill[2].length - 1;
            secondaryMulti = (double)(1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[2][Math.min(st, per)] * (float)skl);
         }
      } else {
         secondaryMulti = 1.0D;
      }

      per = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt;
      if (isPowerTypeKi && mysticLvl > 0 && mystic) {
         flt = (int)((float)curAtr[atr] + (float)flatBonus[mstc_sai(skl)][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[2][trans[2].length] * (float)skl) * (float)atrLimit * 0.001F);
      } else {
         flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      }

      flt = flt > checkLimit() ? checkLimit() : flt;
      per = per <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : per;
      return per;
   }

   public static int TransFrPwr(int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v) {
      return getAttributeArcosian((EntityPlayer)null, curAtr, atr, st, rg, e, skl, mystic, mysticLvl, v, false, -1, false);
   }

   public static int TransFrPwr(int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
      return getAttributeArcosian((EntityPlayer)null, curAtr, atr, st, rg, e, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
   }

   public static int getAttributeArcosian(EntityPlayer player, int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      int race = true;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 4, false, mystic, ultraInstinct, GoD) : 1.0D;
      float[][] flatPercentage = isPowerTypeKi ? TransFrStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransFrStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(4, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(4, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[4] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int per;
      if (isPowerTypeKi && mysticLvl > 0 && mystic) {
         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[4][trans[4].length] * (float)skl;
         secondaryMulti = (double)(JRMCoreConfig.MysticDamMulti[4] == -1.0F ? flatPercentage[mstc_arc()][atr] * (1.0F + AttibuteBonusPerRacialSkill) : JRMCoreConfig.MysticDamMulti[4] + AttibuteBonusPerRacialSkill);
      } else {
         per = JRMCoreConfig.AttibuteBonusPerRacialSkill[4].length - 1;
         secondaryMulti = (double)(1.0F + (isPowerTypeKi ? JRMCoreConfig.AttibuteBonusPerRacialSkill[4][Math.min(st, per)] * (float)skl : 0.0F));
      }

      per = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt;
      if (isPowerTypeKi && mysticLvl > 0 && mystic) {
         flt = (int)((float)curAtr[atr] + (float)flatBonus[mstc_arc()][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[4][trans[4].length] * (float)skl) * (float)atrLimit * 0.001F);
      } else {
         flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      }

      flt = flt > checkLimit() ? checkLimit() : flt;
      per = per <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : per;
      per = getArcosianPowerPointBoost(per, st, rg, e, getArcosianFormID(st, mystic, ultraInstinct, GoD));
      return per;
   }

   public static int TransHmPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
      return getAttributeHuman((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
   }

   public static int TransHmPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
      return getAttributeHuman((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
   }

   public static int getAttributeHuman(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      int race = false;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 0, false, mystic, ultraInstinct, GoD) : 1.0D;
      float[][] flatPercentage = isPowerTypeKi ? TransHmStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransHmStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, mysticLvl > 0 && mystic ? 1 : st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, mysticLvl > 0 && mystic ? 1 : st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(0, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(0, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[0] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int attributeBonusMaxID;
      if (isPowerTypeKi) {
         if (mysticLvl > 0 && mystic) {
            float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[0][trans[0].length] * (float)skl;
            secondaryMulti = (double)((JRMCoreConfig.MysticDamMulti[0] == -1.0F ? 1.0F : JRMCoreConfig.MysticDamMulti[0]) + AttibuteBonusPerRacialSkill);
         } else {
            attributeBonusMaxID = JRMCoreConfig.AttibuteBonusPerRacialSkill[0].length - 1;
            secondaryMulti = (double)(1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[0][Math.min(st, attributeBonusMaxID)] * (float)skl);
         }
      } else {
         secondaryMulti = 1.0D;
      }

      attributeBonusMaxID = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      flt = flt > checkLimit() ? checkLimit() : flt;
      attributeBonusMaxID = attributeBonusMaxID <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : attributeBonusMaxID;
      return attributeBonusMaxID;
   }

   public static int TransNaPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
      return getAttributeNamekian((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
   }

   public static int TransNaPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
      return getAttributeNamekian((EntityPlayer)null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
   }

   public static int getAttributeNamekian(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      int race = true;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 3, false, mystic, ultraInstinct, GoD) : 1.0D;
      float[][] flatPercentage = isPowerTypeKi ? TransNaStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransNaStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, mysticLvl > 0 && mystic ? 1 : st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, mysticLvl > 0 && mystic ? 1 : st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(3, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(3, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[3] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int attributeBonusMaxID;
      if (isPowerTypeKi) {
         if (mysticLvl > 0 && mystic) {
            float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[3][trans[3].length] * (float)skl;
            secondaryMulti = (double)((JRMCoreConfig.MysticDamMulti[3] == -1.0F ? 1.0F : JRMCoreConfig.MysticDamMulti[3]) + AttibuteBonusPerRacialSkill);
         } else {
            attributeBonusMaxID = JRMCoreConfig.AttibuteBonusPerRacialSkill[3].length - 1;
            secondaryMulti = (double)(1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[3][Math.min(st, attributeBonusMaxID)] * (float)skl);
         }
      } else {
         secondaryMulti = 1.0D;
      }

      attributeBonusMaxID = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      flt = flt > checkLimit() ? checkLimit() : flt;
      attributeBonusMaxID = attributeBonusMaxID <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : attributeBonusMaxID;
      return attributeBonusMaxID;
   }

   public static int getAttributeMajin(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
      return getAttributeMajin(player, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, GoD, "");
   }

   public static int getAttributeMajin(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD, String majinAbs) {
      int race = true;
      boolean isPowerTypeKi = isPowerTypeKi(powertype);
      double formMasteryMulti = !ultraInstinct && !GoD ? getFormMasteryAttributeMulti(player, st, 0, 5, false, mystic, ultraInstinct, GoD) : 1.0D;
      if (isPowerTypeKi && majinAbs.length() > 0 && JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED) {
         int stateID = getMajinFormID(st, mystic, ultraInstinct, GoD);
         float attributeMulti = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[stateID] * (float)getMajinAbsorptionValueS(majinAbs);
         if (JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS) {
            formMasteryMulti *= 1.0D + (double)attributeMulti;
         } else {
            formMasteryMulti += (double)attributeMulti;
         }
      }

      float[][] flatPercentage = isPowerTypeKi ? TransMaStBnP : DoujutsuPowerBonusMulti;
      int[][] flatBonus = isPowerTypeKi ? TransMaStBnF : DoujutsuPowerBonusFlat;
      double stateBonusPercentage = ev_oob(flatPercentage, mysticLvl > 0 && mystic ? 1 : st, atr) * formMasteryMulti;
      double stateBonusFlat = ev_oob(flatBonus, mysticLvl > 0 && mystic ? 1 : st, atr);
      if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(5, st)) {
         stateBonusPercentage = 1.0D;
      } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(5, st)) {
         stateBonusPercentage = 1.0D;
      } else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[5] != -1.0F) {
         stateBonusPercentage = 1.0D * formMasteryMulti;
      }

      int atrLimit = checkLimit();
      atrLimit = atrLimit > 1000 ? 1000 : atrLimit;
      double secondaryMulti;
      int attributeBonusMaxID;
      if (isPowerTypeKi) {
         if (mysticLvl > 0 && mystic) {
            float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[5][trans[5].length] * (float)skl;
            secondaryMulti = (double)((JRMCoreConfig.MysticDamMulti[5] == -1.0F ? 1.0F : JRMCoreConfig.MysticDamMulti[5]) + AttibuteBonusPerRacialSkill);
         } else {
            attributeBonusMaxID = JRMCoreConfig.AttibuteBonusPerRacialSkill[5].length - 1;
            secondaryMulti = (double)(1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[5][Math.min(st, attributeBonusMaxID)] * (float)skl);
         }
      } else {
         secondaryMulti = 1.0D;
      }

      attributeBonusMaxID = (int)(stateBonusPercentage * (double)curAtr[atr] * secondaryMulti);
      int flt = (int)((double)curAtr[atr] + stateBonusFlat * (double)atrLimit * 0.0010000000474974513D);
      flt = flt > checkLimit() ? checkLimit() : flt;
      attributeBonusMaxID = attributeBonusMaxID <= flt && stateBonusFlat != 0.0D && atr != 4 ? flt : attributeBonusMaxID;
      return attributeBonusMaxID;
   }

   public static boolean lgndb(int r, int st) {
      String[] b = JRMCoreConfig.lgndb.split(",");

      for(int i = 0; i < b.length; ++i) {
         if (b[i].equalsIgnoreCase(ev_oob(trans, r, st))) {
            return true;
         }
      }

      return false;
   }

   public static boolean lgndb() {
      return lgndb(Race, State);
   }

   public static boolean lgndb2() {
      return StusEfctsMe(14) && lgndb(Race, State);
   }

   public static boolean lgndb(String se, int r, int s) {
      return StusEfcts(14, se) && lgndb(r, s);
   }

   public static boolean lgndb(int p, int r, int s) {
      return StusEfctsClient(14, p) && lgndb(r, s);
   }

   public static boolean lgndb(EntityPlayer p, int r, int s) {
      return StusEfctsClient(14, p) && lgndb(r, s);
   }

   public static int TransPwrModAtr(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, int powerType, String[] Skls, boolean isFused) {
      return getPlayerAttribute((EntityPlayer)null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, false, false, powerType, Skls, isFused, "0");
   }

   public static int TransPwrModAtr(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, boolean uiOn, int powerType, String[] Skls, boolean isFused) {
      return getPlayerAttribute((EntityPlayer)null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, false, false, powerType, Skls, isFused, "0");
   }

   public static int getPlayerAttribute(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, boolean uiOn, boolean GoDOn, int powerType, String[] Skls, boolean isFused) {
      return getPlayerAttribute((EntityPlayer)null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, uiOn, GoDOn, powerType, Skls, isFused, "0");
   }

   public static int getPlayerAttribute(EntityPlayer player, int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn, int powerType, String[] Skls, boolean isFused, String majinAbs) {
      int skillX = powerType == 1 ? SklLvlX(1, SklX) - 1 : 0;
      int mysticLvl = powerType == 1 ? SklLvl(10, 1, Skls) : 0;
      int result = false;
      int result;
      switch(race) {
      case 0:
         result = getAttributeHuman(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn);
         break;
      case 1:
         result = getAttributeSaiyan(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn);
         break;
      case 2:
         result = getAttributeHalfSaiyan(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn);
         break;
      case 3:
         result = getAttributeNamekian(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn);
         break;
      case 4:
         result = getAttributeArcosian(player, currAttributes, attribute, st, currRelease, arcRel, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn);
         break;
      case 5:
         result = getAttributeMajin(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn, majinAbs);
         break;
      default:
         result = currAttributes[attribute];
      }

      double formMasteryMulti;
      if (powerType == 1 && GoDOn) {
         formMasteryMulti = getFormMasteryAttributeMulti(player, "GodOfDestruction", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
         result = (int)((float)result * (float)((double)(JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI * JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI_RACE[race]) * formMasteryMulti));
      }

      if (powerType == 1 && uiOn) {
         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
            formMasteryMulti = getFormMasteryAttributeMulti(player, "UltraInstict", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
            int uiLevel = state2UltraInstinct(false, (byte)st2);
            result = (int)((double)result * (double)((float)JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI[uiLevel] * 0.01F * JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE[uiLevel][race]) * 1.0D * formMasteryMulti);
         }
      } else if (powerType == 1 && st2 < TransKaiDmg.length) {
         formMasteryMulti = 1.0D;
         if (st2 > 0 && kaiokenOn) {
            formMasteryMulti = getFormMasteryAttributeMulti(player, "Kaioken", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
         }

         result = (int)((double)result * (double)TransKaiDmg[st2] * 1.0D * formMasteryMulti + (double)(majinOn ? (float)(result * JRMCoreConfig.mjn) * 0.01F : 0.0F) + (double)(!legendOn || !lgndb(race, st) && !mysticOn ? 0.0F : (float)(result * JRMCoreConfig.lgnd) * 0.01F));
      }

      if (powerType == 2 && st2 < TransGtsDmg.length) {
         result = (int)((double)result * (double)TransGtsDmg[st2] * 1.0D);
      }

      if (!JRMCoreConfig.OverAtrLimit) {
         result = result > checkLimit() ? checkLimit() : result;
      }

      result = (int)((double)result > Double.MAX_VALUE ? Double.MAX_VALUE : (double)result);
      return result;
   }

   public static double getFormMasteryAttributeMulti(EntityPlayer player, int st, int st2, int race, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn) {
      boolean hasFormMastery = JGConfigDBCFormMastery.FM_Enabled && player != null;
      double formMasteryMulti = 0.0D;
      if (hasFormMastery) {
         boolean isInKaioken = isCurrentFormID("Kaioken", race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
         int formID;
         double FM_DamageMultiFlat;
         double FM_DamageMultiPerLevel;
         double FM_DamageMultiMax;
         double masteryValue;
         double masteryResult;
         if (isInKaioken) {
            formID = getFormIDFromName(race, isInKaioken ? "Kaioken" : "");
            FM_DamageMultiFlat = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
            FM_DamageMultiPerLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
            FM_DamageMultiMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
            masteryValue = getFormMasteryValue(player, formID);
            masteryResult = FM_DamageMultiPerLevel * masteryValue + FM_DamageMultiFlat;
            if (masteryResult > FM_DamageMultiMax) {
               masteryResult = FM_DamageMultiMax;
            }

            formMasteryMulti += masteryResult;
         }

         formID = getCurrentFormID(race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
         FM_DamageMultiFlat = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
         FM_DamageMultiPerLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
         FM_DamageMultiMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
         masteryValue = getFormMasteryValue(player, race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
         masteryResult = FM_DamageMultiPerLevel * masteryValue + FM_DamageMultiFlat;
         if (masteryResult > FM_DamageMultiMax) {
            masteryResult = FM_DamageMultiMax;
         }

         formMasteryMulti += masteryResult;
         return formMasteryMulti;
      } else {
         return 1.0D;
      }
   }

   public static double getFormMasteryAttributeMulti(EntityPlayer player, String formName, int st, int st2, int race, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn) {
      boolean hasFormMastery = JGConfigDBCFormMastery.FM_Enabled && player != null && formName != null && formName.length() > 0;
      double formMasteryMulti = 0.0D;
      if (hasFormMastery) {
         boolean isInForm = isCurrentFormID(formName, race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
         if (isInForm) {
            int formID = getFormIDFromName(race, isInForm ? formName : "");
            double FM_DamageMultiFlat = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
            double FM_DamageMultiPerLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
            double FM_DamageMultiMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
            double masteryValue = getFormMasteryValue(player, formID);
            double masteryResult = FM_DamageMultiPerLevel * masteryValue + FM_DamageMultiFlat;
            if (masteryResult > FM_DamageMultiMax) {
               masteryResult = FM_DamageMultiMax;
            }

            formMasteryMulti += masteryResult;
         }

         return formMasteryMulti;
      } else {
         return 1.0D;
      }
   }

   public static int weightModifier(int[] curAtr, int atr, float weight) {
      int i = (int)((float)curAtr[atr] - weight);
      return i < 0 ? 0 : i;
   }

   public static float weightPerc(int atr, EntityPlayer p) {
      float lastGravity = getFloat(p, "jrmcGravForce");
      lastGravity = JRMCoreHDBC.gravity(p, lastGravity);
      int[] PlyrAttrbts = PlyrAttrbts(p);
      float IWeight = weightExtra(PlyrAttrbts, lastGravity, p);
      return 0.5F + weightPerc(PlyrAttrbts, atr, IWeight, p) * 0.5F;
   }

   public static float weightPerc(int atr) {
      boolean c = StusEfctsMe(10) || StusEfctsMe(11);
      float f = atr == 0 ? 0.5F + weightPerc(PlyrAttrbts, atr, WeightOn, c) * 0.5F : weightPerc(PlyrAttrbts, atr, WeightOn, c);
      return f;
   }

   public static float weightPerc(int atr, float weight) {
      float w = (float)atr - weight;
      w /= (float)atr;
      return w < 0.05F ? 0.05F : (w > 1.0F ? 1.0F : w);
   }

   public static float weightPerc(int[] curAtr, int atr, float weight, EntityPlayer p) {
      int pwr = getByte(p, "jrmcPwrtyp");
      int rc = getByte(p, "jrmcRace");
      int st = getByte(p, "jrmcState");
      int st2 = getByte(p, "jrmcState2");
      int rl = getByte(p, "jrmcRelease");
      String sklx = getString(p, "jrmcSSltX");
      int resrv = getInt(p, "jrmcArcRsrv");
      String absorption = getString(p, "jrmcMajinAbsorptionData");
      String ste = getString(p, "jrmcStatusEff");
      boolean mj = StusEfcts(12, ste);
      boolean lg = StusEfcts(14, ste);
      boolean kk = StusEfcts(5, ste);
      boolean mc = StusEfcts(13, ste);
      boolean mn = StusEfcts(19, ste);
      boolean gd = StusEfcts(20, ste);
      int a = curAtr[atr];
      if (pwr != 3 && pwr > 0) {
         String s = getString(p, "jrmcStatusEff");
         boolean c = StusEfcts(10, s) || StusEfcts(11, s);
         a = getPlayerAttribute(p, curAtr, atr, st, st2, rc, sklx, rl, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills(p), c, absorption);
      }

      return weightPerc(a, weight);
   }

   public static float weightPerc(int[] curAtr, int atr, float weight, boolean b) {
      int a = curAtr[atr];
      if (Pwrtyp != 3 && Pwrtyp > 0) {
         a = getPlayerAttribute(mod_JRMCore.proxy.getPlayerClient(), curAtr, atr, State, State2, Race, PlyrSkillX, curRelease, getArcRsrv(), StusEfctsMe(14), StusEfctsMe(12), StusEfctsMe(5), StusEfctsMe(13), StusEfctsMe(19), StusEfctsMe(20), Pwrtyp, PlyrSkills, b, getMajinAbsorption());
      }

      return weightPerc(a, weight);
   }

   public static float weightOfPlayerBody(int[] curAtr, boolean g) {
      float am = (float)(1 / checkLimit());
      float body = 1.0F + (float)curAtr[2] * am * 100.0F + (float)curAtr[0] * am * 50.0F + (float)curAtr[1] * am * 25.0F;
      return body;
   }

   public static float weightExtra(int[] curAtr, float grav, EntityPlayer p) {
      float weight = getItemWeight(p);
      String s = getString(p, "jrmcStatusEff");
      float body = weightOfPlayerBody(curAtr, StusEfcts(10, s) || StusEfcts(11, s));
      return (body + weight) * grav - body;
   }

   public static float getItemWeight(EntityPlayer player) {
      ExtendedPlayer p = ExtendedPlayer.get(player);
      ItemStack is = p.inventory.func_70301_a(0);
      if (is != null) {
         NBTTagList nbttaglist = ItemWeightStatsNBTTag(is);
         if (nbttaglist != null) {
            int i = 0;
            if (i < nbttaglist.func_74745_c()) {
               float weight = nbttaglist.func_150305_b(i).func_74760_g("weight");
               return weight;
            }
         }
      }

      return 0.0F;
   }

   public static double TransSaiRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
      return getKiRegenSaiyan(curAtr, r, st, SklX, cr, resrv, false, false);
   }

   public static double TransSaiRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
      return getKiRegenSaiyan(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
   }

   public static double getKiRegenSaiyan(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st > 0) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         c = (double)((float)might * TransSaiRgn[st]);
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(1, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(1, st)) {
            regen = 1.0F;
         } else {
            regen = TransSaiRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double getKiRegenHalfSaiyan(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st > 0) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         c = (double)((float)might * TransHalfSaiRgn[st]);
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(2, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(2, st)) {
            regen = 1.0F;
         } else {
            regen = TransHalfSaiRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double TransFrRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
      return getKiRegenArcosian(curAtr, r, st, SklX, cr, resrv, false, false);
   }

   public static double TransFrRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
      return getKiRegenArcosian(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
   }

   public static double getKiRegenArcosian(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st >= 5) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         int skl = SklLvlX(1, SklX);
         if (skl != 0) {
            double m;
            if (st == 6) {
               m = (double)(1.0F - 0.1F * ((float)skl - 6.0F));
            } else {
               m = (double)(1.0F - 0.1F * ((float)skl - 3.0F));
            }

            c = (double)((float)might * TransFrRgn[st]) * m;
         }
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(4, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(4, st)) {
            regen = 1.0F;
         } else {
            regen = TransFrRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double TransHmRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
      return getKiRegenHuman(curAtr, r, st, SklX, cr, resrv, false, false);
   }

   public static double TransHmRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
      return getKiRegenHuman(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
   }

   public static double getKiRegenHuman(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st > 0) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         c = (double)((float)might * TransHmRgn[st]);
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(0, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(0, st)) {
            regen = 1.0F;
         } else {
            regen = TransHmRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double TransNaRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
      return getKiRegenNamekian(curAtr, r, st, SklX, cr, resrv, false, false);
   }

   public static double TransNaRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
      return getKiRegenNamekian(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
   }

   public static double getKiRegenNamekian(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st > 0) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         c = (double)((float)might * TransNaRgn[st]);
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(3, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(3, st)) {
            regen = 1.0F;
         } else {
            regen = TransNaRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double getKiRegenMajin(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
      double c = 0.0D;
      if (st > 0) {
         int might = (int)((float)(getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[0]) * 0.4F + (float)(getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[1]) * 0.25F + (float)(getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, (String[])null, false) - curAtr[3]) * 0.35F);
         c = (double)((float)might * TransMaRgn[st]);
      } else {
         float regen;
         if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(5, st)) {
            regen = 1.0F;
         } else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(5, st)) {
            regen = 1.0F;
         } else {
            regen = TransMaRgn[st];
         }

         c = r * (double)regen;
      }

      return c;
   }

   public static double EGtsCost(EntityPlayer p) {
      int[] a = PlyrAttrbts(p);
      int skl = SklLvl(0, (EntityPlayer)p);
      int rc = getByte(p, "jrmcRace");
      int st = getByte(p, "jrmcState");
      int st2 = getByte(p, "jrmcState2");
      int strnTmp = getInt(p, "jrmcStrainTemp");
      int strn = getInt(p, "jrmcStrain");
      int might = a[0] / 2 + a[3] / 2;
      int cons = a[2];
      double c = (double)(10 - SklLvl(12, (EntityPlayer)p) + st2) * 0.01D;
      float kc = EGtsFBal(rc, st, st2, skl, strn);
      c += (double)(JRMCoreConfig.sskai ? 0.0F : kc);
      double r = 1.0D / (double)cons * (double)might * c;
      return r;
   }

   public static float EGtsFBal(int rc, int st, int st2, int skl, int strn) {
      float ret = (float)st;
      if (strn > 0) {
         ret = (float)(skl + st);
         return ret * 0.75F;
      } else {
         return ret;
      }
   }

   public static void EGtsStrainAct(NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
      if (strnAct > 0) {
         --strnAct;
         nbt.func_74768_a("jrmcStrainActv", strnAct);
      }

      if (st2 == 0 && strn > 0) {
         --strn;
         nbt.func_74768_a("jrmcStrain", strn);
      }

      if (!JRMCoreConfig.sskai && (st2 == 0 || strnAct <= 0) && strnTmp > 0) {
         strn += strnTmp;
         strn = strn > 239 ? 239 : strn;
         int strnAct = false;
         nbt.func_74768_a("jrmcStrainActv", 0);
         nbt.func_74768_a("jrmcStrain", strn);
         nbt.func_74768_a("jrmcStrainTemp", 0);
      }

   }

   public static double EGtsDmg(EntityPlayer p) {
      return (double)TransGtsDmg[PlyrState2(p)];
   }

   public static double EGtsDmg() {
      return (double)TransGtsDmg[State2];
   }

   public static double KaiKCost(EntityPlayer p) {
      int[] attributes = PlyrAttrbts(p);
      int skl = SklLvlX(1, getString(p, "jrmcSSltX"));
      int race = getByte(p, "jrmcRace");
      int state = getByte(p, "jrmcState");
      int state2 = getByte(p, "jrmcState2");
      int strnTmp = getInt(p, "jrmcStrainTemp");
      int strn = getInt(p, "jrmcStrain");
      boolean mystic = StusEfcts(13, getString(p, "jrmcStatusEff"));
      int might = attributes[0] / 2 + attributes[3] / 2;
      int cons = attributes[2];
      double c = (double)(10 - SklLvl(8, (EntityPlayer)p) + state2) * 0.01D;
      float kc = KaiKFBal(race, state, state2, skl, strn);
      c += (double)(JRMCoreConfig.sskai ? 0.0F : kc);
      int kaiokenState = !DBC() ? 0 : (mystic ? JRMCoreConfig.KaiokenFormHealthCost[race].length - 1 : state);
      double cost = 1.0D / (double)cons * (double)might * c * (double)TransKaiDrainRace[race] * (double)TransKaiDrainLevel[state2] * (double)(DBC() ? JRMCoreConfig.KaiokenFormHealthCost[race][kaiokenState] : 1.0F);
      if (JGConfigDBCFormMastery.FM_Enabled) {
         int kkID = getFormID("Kaioken", race);
         double kkMasteryLevel = getFormMasteryValue(p, kkID);
         float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(kkMasteryLevel, race, kkID, JGConfigDBCFormMastery.DATA_ID_KAIOKEN_HEALTH_COST_MULTI);
         cost *= (double)costMulti;
      }

      return cost;
   }

   public static float KaiKFBal(int rc, int st, int st2, int skl, int strn) {
      float ret = (float)st;
      if (strn > 0) {
         if (rc_arc(rc)) {
            st -= 4;
            st = st < 0 ? 0 : st * 3;
            ret = (float)st;
         } else if (rc_humNam(rc)) {
            ret = (float)(skl + st);
         }

         return ret * 0.75F;
      } else {
         if (rc_sai(rc)) {
            if (st == 10 && st2 < 4) {
               ret = 1.2F;
            } else {
               ret = 0.6F * (float)st;
            }
         } else if (rc_humNam(rc)) {
            if (st == 3 && st2 < 4) {
               ret = 0.9F;
            } else if (st == 3) {
               ret = (float)st * 2.4F;
            } else {
               ret = (float)st;
            }
         } else if (isRaceMajin(rc)) {
            if (st == 4 && st2 < 4) {
               ret = 0.9F;
            } else if (st == 4) {
               ret = (float)st * 2.4F;
            } else {
               ret = (float)st;
            }
         } else if (rc_arc(rc)) {
            if (st == 7 && st2 < 4) {
               ret = 1.35F;
            } else {
               st -= 4;
               st = st < 0 ? 0 : st * 3;
               ret = 0.6F * (float)st;
            }
         }

         return ret;
      }
   }

   public static void KaiKStrainAct(NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
      KaiKStrainAct((EntityPlayer)null, nbt, st2, strn, strnTmp, strnAct);
   }

   public static void KaiKStrainAct(EntityPlayer player, NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
      if (strnAct > 0) {
         --strnAct;
         nbt.func_74768_a("jrmcStrainActv", strnAct);
      }

      if (st2 == 0 && strn > 0) {
         --strn;
         nbt.func_74768_a("jrmcStrain", strn);
      }

      if (!JRMCoreConfig.sskai && (st2 == 0 || strnAct <= 0) && strnTmp > 0) {
         strn += strnTmp;
         strn = strn > 239 ? 239 : strn;
         int strnAct = false;
         nbt.func_74768_a("jrmcStrainActv", 0);
         nbt.func_74768_a("jrmcStrain", strn);
         nbt.func_74768_a("jrmcStrainTemp", 0);
      }

   }

   public static double KaiKDmg(EntityPlayer p) {
      return (double)TransKaiDmg[PlyrState2(p)];
   }

   public static double KaiKDmg() {
      return (double)TransKaiDmg[State2];
   }

   public static double NngDmg(EntityPlayer p) {
      return (double)TransMngDmg[1];
   }

   public static double NmgDmg() {
      return (double)TransMngDmg[1];
   }

   public static int Algnmnt(int a) {
      if (a > 66) {
         return 0;
      } else {
         return a <= 66 && a >= 33 ? 1 : 2;
      }
   }

   public static boolean Algnmnt_Good(int a) {
      return Algnmnt(a) == 0;
   }

   public static boolean Algnmnt_Neut(int a) {
      return Algnmnt(a) == 1;
   }

   public static boolean Algnmnt_Evil(int a) {
      return Algnmnt(a) == 2;
   }

   public static int Algnmnt_rc(int a) {
      return Algnmnt_Good(a) ? 11075583 : (Algnmnt_Evil(a) ? 16646144 : 14526719);
   }

   public static byte[] tech_statmods(String s) {
      String[] sp = s.split(",");
      byte[] rs = new byte[sp.length];

      for(int i = 0; i < sp.length; ++i) {
         rs[i] = Byte.parseByte(sp[i]);
      }

      return rs;
   }

   public static String tech_statmods_Rev(String[] s) {
      String sp = "";

      for(int i = 0; i < s.length; ++i) {
         sp = sp + "," + s[i];
      }

      return sp.substring(1);
   }

   public static float tech_statmod(byte[] rs, int sm) {
      switch(sm) {
      case 0:
         return (float)tech_stats[rs[sm]] * 0.02F;
      case 1:
         return (float)tech_stats[rs[sm]] * 0.01F;
      case 2:
         return (float)(-tech_stats[rs[sm]]) * 0.01F;
      case 3:
         return (float)(-tech_stats[rs[sm]]) * 0.01F;
      case 4:
         return (float)(-tech_stats[rs[sm]]) * 0.01F;
      case 5:
         return (float)rs[sm];
      case 6:
         return (float)tech_stats[rs[sm]] * 0.02F;
      default:
         return 0.0F;
      }
   }

   public static int techDBCty(String[] t) {
      return Integer.parseInt(t[3]);
   }

   public static float techDBCct(String[] t, byte[] sts) {
      int ty = Integer.parseInt(t[3]);
      float ct = ty == 6 ? techDBCct[ty] : (float)Integer.parseInt(t[5]) / 20.0F + techDBCct[ty];
      return ct + ct * tech_statmod(sts, 3);
   }

   public static float techDBCctWc(String[] t, byte[] sts) {
      return techDBCct(t, sts) * 20.0F;
   }

   public static float techDBCcd(String[] t, byte[] sts) {
      int ty = Integer.parseInt(t[3]);
      return techDBCcd[ty] + techDBCcd[ty] * tech_statmod(sts, 4);
   }

   public static int techDBCdmg(String[] t, int w) {
      return (int)((double)Integer.parseInt(t[5]) * 0.01D * (double)w);
   }

   public static int techDBCdmg(String[] t, int w, byte[] sts) {
      double dm = (double)Integer.parseInt(t[5]) * 0.01D * (double)w;
      return (int)(dm + dm * (double)tech_statmod(sts, 1));
   }

   public static int techDBCkic(String[] listOfAttacks, int playerStat, byte[] kiAttackStats) {
      int ty = Integer.parseInt(listOfAttacks[3]);
      int sp = Integer.parseInt(listOfAttacks[4]);
      int ef = Integer.parseInt(listOfAttacks[6]) + 1;
      double ct = (double)techDBCdmg(listOfAttacks, playerStat) * (double)techDBCaddTYCost[ty] * (double)techDBCaddSPCost[sp] * (double)ef;
      int dm = (int)(ct + ct * (double)tech_statmod(kiAttackStats, 2));
      return (int)((double)dm * (DBC() ? (double)JRMCoreHDBC.DBCgetConfigTechCostMod() : 100.0D) * 0.009999999776482582D);
   }

   public static int techDBCtpc(String[] t) {
      return techDBCtpc(t, false);
   }

   public static int techDBCtpc(String[] t, boolean teach) {
      int dm = Integer.parseInt(t[5]);
      int ty = Integer.parseInt(t[3]);
      int cl = Integer.parseInt(t[10]);
      int sp = Integer.parseInt(t[4]);
      int ef = Integer.parseInt(t[6]) + 1;
      int lv = 1;
      int up = 1;
      if (t.length >= 17 && teach) {
         lv += Integer.parseInt(t[17]);
         up += Integer.parseInt(t[18]);
      }

      return (int)((float)(dm * 10) * techDBCaddTYCost[ty] * techDBCaddSPCost[sp] * (float)ef * (float)lv * (float)up + (float)(cl > 0 ? 100 : 0));
   }

   public static String[] tech_conv(String[] t) {
      if (t != null && t.length > 3) {
         String[] tn = new String[20];

         for(int i = 0; i < tn.length; ++i) {
            if (i >= t.length) {
               if (i == 19) {
                  tn[i] = "0,0,0,0,0,0,0";
               } else {
                  tn[i] = "0";
               }
            } else {
               tn[i] = t[i];
            }
         }

         return tn;
      } else {
         return t;
      }
   }

   public static String tech_conv(String tr) {
      String[] t = tech_conv(tr.split(";"));
      String te = "";

      for(int i = 0; i < t.length; ++i) {
         te = te + ";" + t[i];
      }

      return te.substring(1);
   }

   public static String tech_teach(String[] t) {
      String[] tn = tech_conv(t);
      String te = "";

      for(int i = 0; i < t.length; ++i) {
         if (i == 1) {
            te = te + ";0";
         } else {
            te = te + ";" + tn[i];
         }
      }

      return te.substring(1);
   }

   public static String tech_teach(String tr) {
      String[] t = tr.split(";");
      return tech_teach(t);
   }

   public static String tech_upgrd(String[] t, int id) {
      String[] tn = tech_conv(t);
      int curap = Integer.parseInt(tn[18]);
      byte[] sts = tech_statmods(tn[19]);
      String[] stss = new String[sts.length];
      if (curap > 0) {
         --curap;

         for(int i = 0; i < stss.length; ++i) {
            if (i == id) {
               stss[i] = "" + (sts[i] + 1);
            } else {
               stss[i] = "" + sts[i];
            }
         }

         tn[18] = "" + curap;
         tn[19] = "" + tech_statmods_Rev(stss);
      }

      String te = "";

      for(int i = 0; i < t.length; ++i) {
         te = te + ";" + tn[i];
      }

      return te.substring(1);
   }

   public static String tech_upgrd(String tr, int id) {
      String[] t = tr.split(";");
      return tech_upgrd(t, id);
   }

   public static String tech_expgiv(String[] t, int expgained) {
      String[] tn = tech_conv(t);
      int curlvl;
      if (tn.length > 3) {
         int curexp = Integer.parseInt(tn[16]);
         curlvl = Integer.parseInt(tn[17]);
         int curap = Integer.parseInt(tn[18]);
         String curst = tn[19];

         for(boolean b = true; b && curlvl < 10; curexp = 0) {
            int expneed = tech_expNeeded(curlvl, curexp);
            if (expgained < expneed) {
               curexp += expgained;
               b = false;
               break;
            }

            expgained -= expneed;
            ++curlvl;
            ++curap;
         }

         if (curlvl >= 10) {
         }

         tn[16] = "" + curexp;
         tn[17] = "" + curlvl;
         tn[18] = "" + curap;
         tn[19] = "" + curst;
      }

      String te = "";

      for(curlvl = 0; curlvl < tn.length; ++curlvl) {
         te = te + ";" + tn[curlvl];
      }

      return te.substring(1);
   }

   public static String tech_expgiv(String tr, int e) {
      String[] t = tr.split(";");
      return tech_expgiv(t, e);
   }

   public static int tech_getexpFor(int i) {
      ++i;
      return i * i * (DBC() ? JRMCoreHDBC.DBCgetConfigTechExpNeed() : 15);
   }

   public static int tech_expNeeded(int lvl, int exp) {
      return tech_getexpFor(lvl) - exp;
   }

   public static int tech_getlvl(String[] t) {
      return 20 != t.length ? 0 : Integer.parseInt(t[17]);
   }

   public static int tech_getlvl(String tr) {
      String[] t = tr.split(";");
      return tech_getlvl(t);
   }

   public static int tech_getexp(String[] t) {
      return 20 != t.length ? 0 : Integer.parseInt(t[16]);
   }

   public static int tech_getexp(String tr) {
      String[] t = tr.split(";");
      return tech_getexp(t);
   }

   public static int tech_getupg(String[] t) {
      return 20 != t.length ? 0 : Integer.parseInt(t[18]);
   }

   public static int tech_getupg(String tr) {
      String[] t = tr.split(";");
      return tech_getupg(t);
   }

   public static int techNCty(String[] t) {
      return Integer.parseInt(t[3]);
   }

   public static String techNCHS(String[] t) {
      if (t[8].length() == 5) {
         return t[8];
      } else {
         int ef = Integer.parseInt(t[6]);
         int ty = Integer.parseInt(t[3]) + 1;
         int sp = Integer.parseInt(t[4]) + 1;
         int cc = Integer.parseInt(t[7]);
         String ctb = techNCCCHS[cc];
         return techNCEffHS[ef] + sp + ty + ctb;
      }
   }

   public static int cbtdmg(int ae, int ad, int te, int td) {
      if (te == ae + 1 && ae <= 4 || te == 0 && ae == 4) {
         return (int)((float)td * 0.25F);
      } else if (te == ae) {
         return td > ad ? td + ad : 0;
      } else {
         return td;
      }
   }

   public static int cbadmg(int ae, int ad, int te, int td) {
      if (te == ae) {
         return ad > td ? td + ad : 0;
      } else {
         return ad;
      }
   }

   public static String[] techs(byte i) {
      if (i < 4 && tech(i) != null) {
         return tech(i);
      } else if (i >= 4 && techsPM(i - 4) >= 0) {
         return Pwrtyp == 2 ? pmj[techsPM(i - 4)] : (Pwrtyp == 1 ? pmdbc[techsPM(i - 4)] : null);
      } else {
         return null;
      }
   }

   public static String techs(byte i, int f) {
      if (i < 4 && tech(i) != null) {
         return f == 8 ? techNCHS(tech(i)) : tech(i)[f];
      } else if (i >= 4 && techsPM(i - 4) >= 0) {
         return Pwrtyp == 2 ? pmj[techsPM(i - 4)][f] : (Pwrtyp == 1 ? pmdbc[techsPM(i - 4)][f] : "");
      } else {
         return "";
      }
   }

   public static int techsPM(int j) {
      return j >= 0 && techPM != null && techPM.length > j ? techPM[j] : -1;
   }

   public static boolean techOwnd(int i, byte pwr) {
      return techOwnd(i, pwr == 1 ? pmdbc : pmj);
   }

   public static boolean techOwnd(int i, String[][] s) {
      for(byte it = 0; it < 4; ++it) {
         int pm = techsPM(it);
         if (s.length > i && pm == i) {
            return true;
         }
      }

      return false;
   }

   public static int[] PlyrAttrbtsC(EntityPlayer p) {
      String d = data(p.func_70005_c_(), 14, "10,10,10,10,10,10");
      if (d == "") {
         return new int[]{10, 10, 10, 10, 10, 10};
      } else {
         String[] a = d.split(",");
         int[] PlyrAttrbts = new int[a.length];

         for(int i1 = 0; i1 < PlyrAttrbts.length; ++i1) {
            PlyrAttrbts[i1] = Integer.parseInt(a[i1]);
         }

         return PlyrAttrbts;
      }
   }

   public static int[] PlyrAttrbts() {
      return PlyrAttrbts;
   }

   public static int[] PlyrAttrbts(EntityPlayer p) {
      return PlyrAttrbts(p, true);
   }

   public static int[] PlyrAttrbts(EntityPlayer p, boolean fused) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         NBTTagCompound nbt = nbt(p);
         if (fused) {
            String Fzn = nbt.func_74779_i("jrmcFuzion");
            if (Fzn.contains(",")) {
               String[] FznA = Fzn.split(",");
               if (FznA.length == 3) {
                  MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                  EntityPlayer p1 = getPlayerForUsername(server, FznA[0]);
                  EntityPlayer p2 = getPlayerForUsername(server, FznA[1]);
                  if (p1 != null && p2 != null) {
                     return PlyrAttrbts(p1, p2);
                  }

                  nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                  NBTTagCompound nbt2;
                  if (p1 != null) {
                     nbt2 = nbt((EntityPlayer)p1);
                     StusEfcts(10, (NBTTagCompound)nbt2, false);
                     StusEfcts(11, (NBTTagCompound)nbt2, false);
                  }

                  if (p2 != null) {
                     nbt2 = nbt((EntityPlayer)p2);
                     StusEfcts(10, (NBTTagCompound)nbt2, false);
                     StusEfcts(11, (NBTTagCompound)nbt2, false);
                  }
               }
            }
         }

         int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];

         for(byte i = 0; i < AttrbtNbt.length; ++i) {
            if (nbt.func_74781_a(AttrbtNbtI[i]) == null & nbt.func_74781_a(AttrbtNbt[i]) != null) {
               nbt.func_74768_a(AttrbtNbtI[i], nbt.func_74765_d(AttrbtNbt[i]));
               nbt.func_82580_o(AttrbtNbt[i]);
            } else if (nbt.func_74781_a(AttrbtNbtI[i]) == null) {
               nbt.func_74768_a(AttrbtNbtI[i], 1);
            }

            int r = etXq4V(nbt.func_74762_e(AttrbtNbtI[i]));
            PlyrAttrbts[i] = r;
         }

         return PlyrAttrbts;
      } else {
         return JRMCoreH.PlyrAttrbts;
      }
   }

   public static String[] PlyrSkills(EntityPlayer p) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         NBTTagCompound nbt = nbt(p);
         if (nbt.func_74781_a("jrmcSSlts") == null) {
            nbt.func_74778_a("jrmcSSlts", ",");
         }

         String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
         return PlyrSkills;
      } else {
         return JRMCoreH.PlyrSkills;
      }
   }

   public static boolean PlyrSettingsI(EntityPlayer p, int ps, int i) {
      return PlyrSettings(p, ps) == i;
   }

   public static boolean PlyrSettingsB(EntityPlayer p, int ps) {
      return PlyrSettings(p, ps) >= 0;
   }

   public static int PlyrSettings(EntityPlayer p, int ps) {
      String n = getString(p, "jrmcSettings").trim();

      for(int i = 0; i < n.length() / 2; ++i) {
         String c = sa(n, i * 2);
         if (c.equals(PlyrSttngs[ps])) {
            return saI(n, i * 2 + 1);
         }
      }

      return -1;
   }

   public static boolean PlyrSettingsI(NBTTagCompound nbt, int ps, int i) {
      return PlyrSettings(nbt, ps) == i;
   }

   public static boolean PlyrSettingsB(NBTTagCompound nbt, int ps) {
      return PlyrSettings(nbt, ps) >= 0;
   }

   public static int PlyrSettings(NBTTagCompound nbt, int ps) {
      String n = nbt.func_74779_i("jrmcSettings").trim();

      for(int i = 0; i < n.length() / 2; ++i) {
         String c = sa(n, i * 2);
         if (c.equals(PlyrSttngs[ps])) {
            return saI(n, i * 2 + 1);
         }
      }

      return -1;
   }

   public static void PlyrSettingsRem(EntityPlayer p, int ps) {
      String n = getString(p, "jrmcSettings").trim();

      for(int i = 0; i < n.length() / 2; ++i) {
         String c = sa(n, i * 2);
         if (c.equals(PlyrSttngs[ps])) {
            String x = sa(n, i * 2 + 1);
            setString(n.replaceAll(c + x, ""), p, "jrmcSettings");
            return;
         }
      }

   }

   public static void PlyrSettingsRem(NBTTagCompound nbt, int ps) {
      String n = nbt.func_74779_i("jrmcSettings").trim();

      for(int i = 0; i < n.length() / 2; ++i) {
         String c = sa(n, i * 2);
         if (c.equals(PlyrSttngs[ps])) {
            String x = sa(n, i * 2 + 1);
            nbt.func_74778_a("jrmcSettings", n.replaceAll(c + x, ""));
            return;
         }
      }

   }

   public static void PlyrSettingsSet(EntityPlayer p, int ps, int pi) {
      if (pi == -1) {
         PlyrSettingsRem(p, ps);
      } else {
         String n = getString(p, "jrmcSettings").trim();

         for(int i = 0; i < n.length() / 2; ++i) {
            String c = sa(n, i * 2);
            if (c.equals(PlyrSttngs[ps])) {
               String x = sa(n, i * 2 + 1);
               setString(n.replaceAll(c + x, c + pi), p, "jrmcSettings");
               return;
            }
         }

         setString(n + PlyrSttngs[ps] + pi, p, "jrmcSettings");
      }
   }

   public static void PlyrSettingsOn(EntityPlayer p, int ps) {
      PlyrSettingsSet((EntityPlayer)p, ps, 0);
   }

   public static void PlyrSettingsSet(NBTTagCompound nbt, int ps, int pi) {
      if (pi == -1) {
         PlyrSettingsRem(nbt, ps);
      } else {
         String n = nbt.func_74779_i("jrmcSettings").trim();

         for(int i = 0; i < n.length() / 2; ++i) {
            String c = sa(n, i * 2);
            if (c.equals(PlyrSttngs[ps])) {
               String x = sa(n, i * 2 + 1);
               nbt.func_74778_a("jrmcSettings", n.replaceAll(c + x, c + pi));
               return;
            }
         }

         nbt.func_74778_a("jrmcSettings", n + PlyrSttngs[ps] + pi);
      }
   }

   public static void PlyrSettingsOn(NBTTagCompound nbt, int ps) {
      PlyrSettingsSet((NBTTagCompound)nbt, ps, 0);
   }

   public static boolean PlyrSettingsI(int ps, int i) {
      return PlyrSettings(ps) == i;
   }

   public static boolean PlyrSettingsB(int ps) {
      return PlyrSettings(ps) >= 0;
   }

   public static int PlyrSettings(int ps) {
      String n = PlyrSettings;

      for(int i = 0; i < n.length() / 2; ++i) {
         String c = sa(n, i * 2);
         if (c.equals(PlyrSttngs[ps])) {
            return saI(n, i * 2 + 1);
         }
      }

      return -1;
   }

   public static int[] PlyrAttrbts(EntityPlayer p, EntityPlayer p2) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         NBTTagCompound nbt = nbt(p);
         NBTTagCompound nbt2 = nbt(p2);
         int[] PlyrAttrbts = PlyrAttrbts(p, false);
         int[] PlyrAttrbts2 = PlyrAttrbts(p2, false);
         int[] PlyrAttrbtsF = new int[JRMCoreH.PlyrAttrbts.length];

         for(byte i = 0; i < AttrbtNbt.length; ++i) {
            if (i != 4) {
               float attributeMulti = JRMCoreConfig.fusionAttributeMultis[i];
               PlyrAttrbtsF[i] = PlyrAttrbts[i] < PlyrAttrbts2[i] ? (int)((float)PlyrAttrbts[i] * attributeMulti) : (int)((float)PlyrAttrbts2[i] * attributeMulti);
            } else {
               PlyrAttrbtsF[i] = PlyrAttrbts[i] < PlyrAttrbts2[i] ? PlyrAttrbts[i] : PlyrAttrbts2[i];
            }
         }

         return PlyrAttrbtsF;
      } else {
         return JRMCoreH.PlyrAttrbts;
      }
   }

   public static int costEnAt(String[] tech) {
      return costEnAt(tech, -1);
   }

   public static short costEnAt(String[] tech, int men) {
      short cost = 0;
      byte tcost;
      byte density;
      if (tech != null && men < 0) {
         tcost = Byte.parseByte(tech[3]);
         density = Byte.parseByte(tech[4]);
         short dam = Short.parseShort(tech[5]);
         byte effect = Byte.parseByte(tech[6]);
         short casttime = (short)(techBase[8] - Short.parseShort(tech[8]));
         short cooldown = (short)(techBase[9] - Short.parseShort(tech[9]));
         byte color = Byte.parseByte(tech[10]);
         byte density = Byte.parseByte(tech[11]);
         int costInt = (int)((1.0F + (float)dam * 0.5F) * ((float)effect + 1.0F) * ((float)tcost + 1.0F) * (float)density * 0.1F * (float)density + (float)casttime + (float)cooldown);
         cost = (short)(costInt > getMaxTP() ? getMaxTP() : costInt);
      } else if (tech != null && tech.length > 12) {
         tcost = Byte.parseByte(tech[7]);
         density = Byte.parseByte(tech[11]);
         int costInt = 1 + (int)((float)tcost * 0.01F * (float)men * (float)density);
         cost = (short)(costInt > getMaxTP() ? getMaxTP() : costInt);
      }

      return cost <= 1 ? 1 : cost;
   }

   public static void swapCD(byte from, byte to) {
      float CDFrom = techCD(from);
      float CDTo = techCD(to);
      setCDAt(from, CDTo);
      setCDAt(to, CDFrom);
      updateOldCooldownValue(from);
      updateOldCooldownValue(to);
   }

   public static void setCDAt(byte id, float cd) {
      techniqueCooldowns[id] = cd;
   }

   public static boolean cDEnAt(byte id, float cd) {
      if (DBC() && DBCClientTickHandler.isPlayerInCreativeMode()) {
         return true;
      } else {
         cd *= 10.0F;
         boolean cd1 = true;
         if (techniqueCooldowns[id] == 0.0F) {
            techniqueCooldowns[id] = cd;
            updateOldCooldownValue(id);
            cd1 = true;
         }

         return cd1;
      }
   }

   public static float curCDEnAt(byte id) {
      return techCD(id);
   }

   public static String[] tech(int id) {
      String[] tech = null;
      if (id == 0 && tech1 != null) {
         tech = tech1;
      }

      if (id == 1 && tech2 != null) {
         tech = tech2;
      }

      if (id == 2 && tech3 != null) {
         tech = tech3;
      }

      if (id == 3 && tech4 != null) {
         tech = tech4;
      }

      if (id >= 4 && id < 8 && techPM != null && techsPM(id - 4) >= 0) {
         tech = (Pwrtyp == 1 ? pmdbc : (Pwrtyp == 2 ? pmj : pmj))[techsPM(id - 4)];
      }

      return tech_conv(tech);
   }

   public static float techCD(byte id) {
      return techniqueCooldowns[id];
   }

   public static void resetCD(byte id) {
      if (techniqueCooldowns[id] > 0.0F) {
         techniqueCooldowns[id] = 0.0F;
      }

   }

   public static void updateAllOldCooldownValues() {
      for(int i = 0; i < techniqueCooldowns.length; ++i) {
         updateOldCooldownValue(i);
      }

   }

   public static void updateOldCooldownValue(int id) {
      if (id == 0) {
         curTech1CD = techniqueCooldowns[id];
      } else if (id == 1) {
         curTech2CD = techniqueCooldowns[id];
      } else if (id == 2) {
         curTech3CD = techniqueCooldowns[id];
      } else if (id == 3) {
         curTech4CD = techniqueCooldowns[id];
      } else if (id == 4) {
         curTech5CD = techniqueCooldowns[id];
      } else if (id == 5) {
         curTech6CD = techniqueCooldowns[id];
      } else if (id == 6) {
         curTech7CD = techniqueCooldowns[id];
      } else if (id == 7) {
         curTech8CD = techniqueCooldowns[id];
      }

   }

   public static int getMaxTP() {
      return 2000000000;
   }

   public static String attrNms(int g, int a) {
      return trl("jrmc", attrNms[g][a]);
   }

   public static String attrDsc(int g, int a) {
      return trl("jrmc", attrDsc[g][a]);
   }

   public static final String attrStat(int g, int a) {
      return trl("jrmc", attrStat[g][a]);
   }

   public static int attrStart(int powerType, int attribute, int race) {
      return attributeStart(powerType, attribute, race, 0);
   }

   public static int attributeStart(int powerType, int attribute, int race, int classID) {
      int[][][] attributes;
      if (powerType == 1) {
         attributes = JGConfigRaces.CONFIG_RACES_ATTRIBUTE_START;
         attribute = attributes[race][classID].length > attribute ? attribute : attributes[race][classID].length - 1;
         race = attributes.length > race ? race : attributes.length - 1;
         return attributes[race][classID][attribute];
      } else {
         attributes = attrStart;
         attribute = attributes[powerType].length > attribute ? attribute : attributes[powerType].length - 1;
         race = attributes[powerType][attribute].length > race ? race : attributes[powerType][attribute].length - 1;
         return attributes[powerType][attribute][race];
      }
   }

   public static float[] getStatIncreases(int powerType, int race, int classID) {
      return powerType == 1 ? JGConfigRaces.CONFIG_RACES_STATS_MULTI[race][classID] : statInc[powerType];
   }

   public static int getStatBonus(int powerType, int race, int classID, int stat, boolean classBonusOnly) {
      if (powerType == 1) {
         return classBonusOnly ? 0 : JGConfigRaces.CONFIG_RACES_STAT_BONUS[race][classID][stat];
      } else {
         return classBonusOnly ? statIncBonusRaceDBC[stat][race] : statIncBonusClass[powerType][stat][classID];
      }
   }

   public static double regenRate(int powerType, int maxStat, float race) {
      return powerType != 1 && powerType != 2 ? 1.0D + (double)maxStat * 0.02D * (double)race * 0.01D : 1.0D + (double)maxStat * 0.01D * (double)race * 0.01D;
   }

   public static String cleanUpCommas(String string) {
      return joiner.join(splitter.split(string));
   }

   public static int skillSlot_MindUsed() {
      int[][] rSklsMR = (int[][])null;
      int[][] cSklsMR = (int[][])null;
      String[] cSkls;
      String[] skls;
      int[][] sklsMR;
      String var5;
      if (isPowerTypeChakra()) {
         cSkls = ncCSkls;
         cSklsMR = NCRacialSkillMindCost;
         skls = NCSkillIDs;
         sklsMR = NCSkillMindCost;
         var5 = "nc";
      } else {
         rSklsMR = DBCRacialSkillMindCost;
         cSkls = vlblCSkls;
         skls = DBCSkillsIDs;
         sklsMR = DBCSkillMindCost;
         var5 = "dbc";
      }

      return skillSlot_SpentMindRequirement(PlyrSkills, skls, sklsMR) + skillSlot_SpentMindRequirement_X(PlyrSkillX, Race, rSklsMR) + skillSlot_SpentMindRequirement(PlyrSkillY, cSkls, cSklsMR);
   }

   public static int skillSlot_AvailableMindLeft() {
      return PlyrAttrbts[4] - skillSlot_MindUsed();
   }

   public static boolean skillSlot_EnoughMindLeft() {
      return canAffordSkill(PlyrAttrbts[4], skillSlot_MindUsed());
   }

   public static int skillSlot_SpentMindRequirement(String playerSkills, String[] premadeSkills, int[][] mindRequirements) {
      return playerSkills != null && mindRequirements != null && premadeSkills != null && playerSkills != "" && !playerSkills.equals("") && !playerSkills.equals("pty") ? skillSlot_SpentMindRequirement(new String[]{playerSkills}, premadeSkills, mindRequirements, false) : 0;
   }

   public static int skillSlot_SpentMindRequirement(String[] playerSkills, String[] premadeSkills, int[][] mindRequirements) {
      return skillSlot_SpentMindRequirement(playerSkills, premadeSkills, mindRequirements, true);
   }

   public static int skillSlot_SpentMindRequirement(String[] playerSkills, String[] premadeSkills, int[][] mindRequirements, boolean granted) {
      int z = granted ? 1 : 0;
      int haveSkillLvls = 0;

      for(byte i = 0; i < playerSkills.length; ++i) {
         if (playerSkills[i].length() > 2) {
            int l = Integer.parseInt(playerSkills[i].substring(2)) + z;

            for(int j = 0; j < l; ++j) {
               haveSkillLvls += skillMindRequirement(playerSkills[i].substring(0, 2) + j, premadeSkills, mindRequirements, granted);
            }
         }
      }

      return haveSkillLvls;
   }

   public static int skillSlot_SpentMindRequirement_X(String playerRacialSkill, int skills, int[][] mindRequirements) {
      if (playerRacialSkill != null && mindRequirements != null && playerRacialSkill != "" && !playerRacialSkill.equals("") && !playerRacialSkill.equals("pty")) {
         int haveSkillLvls = 0;
         if (playerRacialSkill.length() > 2) {
            int racialSkillLevel = Integer.parseInt(playerRacialSkill.substring(2));

            for(int j = 0; j <= racialSkillLevel; ++j) {
               haveSkillLvls += skillMindRequirement_X(playerRacialSkill.substring(0, 2) + j, skills, mindRequirements, true);
            }
         }

         return haveSkillLvls;
      } else {
         return 0;
      }
   }

   public static int skillMindRequirement(String skill, String[] skills, int[][] mindRequirements) {
      return skillMindRequirement(skill, skills, mindRequirements, false);
   }

   public static int skillMindRequirement(String skill, String[] skills, int[][] mindRequirements, boolean granted) {
      for(byte i = 0; i < skills.length; ++i) {
         if (skill.contains(skills[i])) {
            int z = !granted ? 1 : 0;
            int lvl = skill.length() > 2 ? Integer.parseInt(skill.substring(2)) + z : 0;
            int a = SklID(skill, skills);
            if (a >= 0) {
               int[] mindRequirement = mindRequirements[a];
               float f;
               if (mindRequirement.length - 1 > -1) {
                  f = (float)(mindRequirement.length > lvl ? mindRequirement[lvl] : mindRequirement[mindRequirement.length - 1]);
               } else {
                  f = 1.0F;
               }

               float x = f * JGConfigSkills.GlobalSkillMindMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? lvl + 1 : 1);
               return (int)(x < (float)z ? (float)z : x);
            }
            break;
         }
      }

      return 0;
   }

   public static int skillMindRequirement_X(String playerRacialSkill, int race, int[][] mindRequirements) {
      return skillMindRequirement_X(playerRacialSkill, race, mindRequirements, false);
   }

   public static int skillMindRequirement_X(String playerRacialSkill, int race, int[][] mindRequirements, boolean granted) {
      if (playerRacialSkill.length() > 1) {
         int z = !granted ? 1 : 0;
         int lvl = playerRacialSkill.length() > 2 ? Integer.parseInt(playerRacialSkill.substring(2)) + z : 0;
         if (race >= 0) {
            int[] mindRequirement = mindRequirements[race];
            if (lvl == 0) {
               return 0;
            }

            --lvl;
            float f = (float)(mindRequirement.length > lvl ? mindRequirement[lvl] : mindRequirement[mindRequirement.length - 1]);
            float x = f * JGConfigSkills.GlobalSkillMindMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? lvl + 1 : 1);
            return (int)(x < (float)z ? (float)z : x);
         }
      }

      return 0;
   }

   public static int skillTPCost(String skill, String[] skills, int[][] tpCosts) {
      return skillTPCost(skill, skills, tpCosts, false);
   }

   public static int skillTPCost(String skill, String[] skills, int[][] tpCosts, boolean granted) {
      for(byte i = 0; i < skills.length; ++i) {
         if (skill.contains(skills[i])) {
            int z = !granted ? 1 : 0;
            int lvl = skill.length() > 2 ? Integer.parseInt(skill.substring(2)) + z : 0;
            int a = SklID(skill, skills);
            if (a >= 0) {
               int[] tpCost = tpCosts[a];
               float f;
               if (tpCost.length - 1 > -1) {
                  f = (float)(tpCost.length > lvl ? tpCost[lvl] : tpCost[tpCost.length - 1]);
               } else {
                  f = 1.0F;
               }

               float x = f * JGConfigSkills.GlobalSkillTPMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? lvl + 1 : 1);
               return (int)(x < -1.0F ? -1.0F : x);
            }
            break;
         }
      }

      return 0;
   }

   public static int skillTPCost_X(String playerRacialSkill, int race, int[][] tpCosts) {
      return skillTPCost_X(playerRacialSkill, race, tpCosts, false);
   }

   public static int skillTPCost_X(String playerRacialSkill, int race, int[][] tpCosts, boolean granted) {
      if (playerRacialSkill.length() > 1) {
         int z = !granted ? 1 : 0;
         int lvl = playerRacialSkill.length() > 2 ? Integer.parseInt(playerRacialSkill.substring(2)) + z : 0;
         if (race >= 0) {
            int[] tpCost = tpCosts[race];
            if (lvl == 0) {
               return 0;
            }

            --lvl;
            float f = (float)(tpCost.length > lvl ? tpCost[lvl] : tpCost[tpCost.length - 1]);
            float x = f * JGConfigSkills.GlobalSkillTPMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? lvl + 1 : 1);
            return (int)(x < -1.0F ? -1.0F : x);
         }
      }

      return 0;
   }

   public static int getSkillTPCost(int skillID, int lvl, boolean dbc) {
      return dbc ? getDBCSkillTPCost(skillID, lvl) : getNCSkillTPCost(skillID, lvl);
   }

   public static int getDBCSkillTPCost(int skillID, int lvl) {
      return (int)((float)DBCSkillTPCost[skillID][lvl] * JGConfigSkills.GlobalSkillTPMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? lvl + 1 : 1));
   }

   public static int getNCSkillTPCost(int skillID, int lvl) {
      return (int)((float)NCSkillTPCost[skillID][lvl] * JGConfigSkills.GlobalSkillTPMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? lvl + 1 : 1));
   }

   public static int getSkillMindCost(int skillID, int lvl, boolean dbc) {
      return dbc ? getDBCSkillMindCost(skillID, lvl) : getNCSkillMindCost(skillID, lvl);
   }

   public static int getDBCSkillMindCost(int skillID, int lvl) {
      return (int)((float)DBCSkillMindCost[skillID][lvl] * JGConfigSkills.GlobalSkillMindMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? lvl + 1 : 1));
   }

   public static int getNCSkillMindCost(int skillID, int lvl) {
      return (int)((float)NCSkillMindCost[skillID][lvl] * JGConfigSkills.GlobalSkillMindMultiplier * (lvl == 0 ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (float)(JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? lvl + 1 : 1));
   }

   public static boolean skillSlots(int mindRequirement, int haveSkillLvls) {
      return canAffordSkill(mindRequirement, haveSkillLvls);
   }

   public static boolean canAffordSkill(int mindAttribute, int haveSkillLvls) {
      return mindAttribute >= haveSkillLvls;
   }

   public static HashMap<Integer, Long> attrCstH() {
      HashMap<Integer, Long> attrCstH = new HashMap();
      long res = 1L;

      for(int i = 0; i <= 6000000; ++i) {
         attrCstH.put(i, res += (long)attrCst(i));
      }

      long res2 = 0L;

      for(int i = 0; i < 60; ++i) {
         res2 += (long)attrCst(i);
      }

      attrCstH.put(-1, res2);
      return attrCstH;
   }

   public static int attrCstO(int att) {
      int am = (int)((double)att * JRMCoreConfig.atcm);
      int dec = JRMCoreConfig.AttributeUpgradeCost_StartMinus - att < 0 ? 0 : JRMCoreConfig.AttributeUpgradeCost_StartMinus - att;
      int c = am - dec;
      return c < JRMCoreConfig.AttributeUpgradeCost_Min ? JRMCoreConfig.AttributeUpgradeCost_Min : (c > getMaxTP() ? getMaxTP() : c);
   }

   public static long attrCstE(int att) {
      if (att > 6000000) {
         att = 6000000;
      }

      return attrCstH != null ? (Long)attrCstH.get(att) : (Long)(attrCstH = attrCstH()).get(att);
   }

   public static long attrCstEP(int att) {
      if (att > 6000000) {
         att = 6000000;
      }

      return attrCstH != null ? (Long)attrCstH.get(att) - (Long)attrCstH.get(-1) : (Long)(attrCstH = attrCstH()).get(att) - (Long)attrCstH.get(-1);
   }

   public static int am(int id) {
      return attributeMultiplier(id);
   }

   public static int attributeMultiplier(int id) {
      switch(id) {
      case 0:
         return 1;
      case 1:
         return 10;
      case 2:
         return 100;
      case 3:
         return 1000;
      default:
         return 1;
      }
   }

   public static int attrCst(int att, int count) {
      int attributes = att;
      if (att < getMaxTP() && att > 0) {
         int attributeCost = 0;
         int attributeMultiplier = attributeMultiplier(count);

         for(int j = 0; j < attributeMultiplier; ++j) {
            int ac = attrCst(attributes++);
            attributeCost += ac;
            if (ac == 0) {
               return 0;
            }
         }

         if (attributeCost <= 0) {
            return 0;
         } else if (attributeCost > getMaxTP()) {
            return 0;
         } else {
            return attributeCost;
         }
      } else {
         return count == 0 ? getMaxTP() : 0;
      }
   }

   public static int attrCst(int att) {
      if (checkLimit() * 6 <= att) {
         return 0;
      } else {
         int am = (int)((double)att * JRMCoreConfig.atcm);
         int dec = JRMCoreConfig.AttributeUpgradeCost_StartMinus - att < 0 ? 0 : JRMCoreConfig.AttributeUpgradeCost_StartMinus - att;
         int c = am - dec;
         int a = c < JRMCoreConfig.AttributeUpgradeCost_Min ? JRMCoreConfig.AttributeUpgradeCost_Min : (c > getMaxTP() ? getMaxTP() : c);
         return a;
      }
   }

   public static boolean acm(int[] attrbts) {
      int att = attrbts[0] + attrbts[1] + attrbts[2] + attrbts[3] + attrbts[4] + attrbts[5];
      return JRMCoreConfig.tmx * 6 <= att;
   }

   public static int attrCst(int[] attrbts, int count) {
      int att = attributeCostAboveLimit(attrbts);
      return attrCst(att, count);
   }

   public static int attributeCostAboveLimit(int[] attributes) {
      float result = 0.0F;

      for(int i = 0; i < 6; ++i) {
         if (JRMCoreConfig.AttributeUpgradeCost_AttributeMulti[i] > 0.0F) {
            float attribute = (float)attributes[i] * JRMCoreConfig.AttributeUpgradeCost_AttributeMulti[i];
            result += attribute;
            if (result >= (float)getMaxTP() || result <= 0.0F) {
               return getMaxTP();
            }
         }
      }

      return (int)result;
   }

   public static int getPlayerLevel(int[] playerAttributes) {
      return getPlayerLevel(playerAttributes[0] + playerAttributes[1] + playerAttributes[2] + playerAttributes[3] + playerAttributes[4] + playerAttributes[5]);
   }

   public static int attrLvl(int[] PlyrAttrbts) {
      return getPlayerLevel(PlyrAttrbts);
   }

   public static int getPlayerLevel(int all) {
      int i = all / 5 - 11;
      return i < 0 ? 0 : i;
   }

   public static int attrLvl(int all) {
      return getPlayerLevel(all);
   }

   public static int attrLvlNext(int[] PlyrAttrbts) {
      int all = PlyrAttrbts[0] + PlyrAttrbts[1] + PlyrAttrbts[2] + PlyrAttrbts[3] + PlyrAttrbts[4] + PlyrAttrbts[5];
      return 5 - (all - all / 5 * 5);
   }

   public static float spdFrm(int a, int s, float r, boolean t, boolean i, int st, int st2, float aa) {
      float prc = 0.5F + (t ? 0.5F : 0.0F) + (0.075F * (float)s + (float)(a / checkLimit()) + (float)st * 0.02F + (float)st2 * 0.1F + 0.5F) * r * 0.01F;
      return prc * aa;
   }

   public static String[] cl(int pwr) {
      String[] cl = PwrtypAllow[pwr].contains("DBC") ? ClassesDBC : (PwrtypAllow[pwr].contains("NC") ? Clans : Classes);
      return cl;
   }

   public static int statMindC() {
      double mind = (double)PlyrAttrbts[4];
      return (int)mind;
   }

   public static String getBonusAttributes(String player, int attributeID) {
      if (plyrs != null) {
         if (player == null || player.length() == 0) {
            player = mod_JRMCore.proxy.getPlayerClient().func_70005_c_();
         }

         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl] != null && plyrs[pl].equals(player)) {
               if (dat31 != null && dat31.length > pl && dat31[pl].split("\\=").length == 6) {
                  return dat31[pl].split("\\=")[attributeID];
               }
               break;
            }
         }
      }

      return "";
   }

   public static String getBonusAttributes(int attributeID) {
      return getBonusAttributes((String)null, attributeID);
   }

   public static int stat(Entity player, int attributeID, int powerType, int stat, int attribute, int race, int classID, float skillBonus) {
      float[] attributes = getStatIncreases(powerType, race, classID);
      stat = attributes.length > stat ? stat : attributes.length - 1;
      double bs = (double)(attributes[stat] * (float)attribute);
      int value = (int)round(bs + (double)getStatBonus(powerType, race, classID, stat, false) * 0.01D * bs + (double)getStatBonus(powerType, race, classID, stat, true) * 0.01D * bs + bs * (double)skillBonus, 0, 0);
      if (JRMCoreConfig.JRMCABonusOn && attributeID > -1 && attributeID <= 5 && player instanceof EntityPlayer) {
         String nbtValue = "NONE";
         if (!player.field_70170_p.field_72995_K) {
            NBTTagCompound nbt = nbt((EntityPlayer)player, "pres");
            nbtValue = nbt.func_74779_i("jrmcAttrBonus" + ComJrmcaBonus.ATTRIBUTES_SHORT[attributeID]);
         } else {
            nbtValue = getBonusAttributes(player.func_70005_c_(), attributeID);
         }

         if (!nbtValue.equals("NONE") && !nbtValue.equals("n")) {
            double bonusValueResult = (double)value;
            String[] bonus = nbtValue.split("\\|");
            String[][] bonusValues = new String[bonus.length][2];
            if (bonus.length > 0 && bonus[0].length() > 0) {
               for(int i = 0; i < bonus.length; ++i) {
                  if (bonus[i].length() > 1) {
                     String[] bonusValue = bonus[i].split("\\;");
                     bonusValues[i][1] = bonusValue[1];

                     double value2;
                     try {
                        value2 = Double.parseDouble(bonusValues[i][1].substring(1));
                        bonusValueResult = JGMathHelper.StringMethod(bonusValues[i][1].substring(0, 1), bonusValueResult, value2);
                     } catch (Exception var22) {
                        value2 = 1.0D;
                     }
                  }
               }
            }

            value = (int)bonusValueResult;
         }
      }

      if (powerType == 1 && attributeID > -1 && attributeID <= 5) {
         double multiplier = JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[race][classID][attributeID];
         value = (int)((double)value * multiplier);
      }

      return value;
   }

   public static int stat(int attributeID, int g, int s, int a, int r, int c, float b) {
      return stat((Entity)null, attributeID, g, s, a, r, c, b);
   }

   public static int stat(int g, int s, int a, int r, int c, float b) {
      return stat(-1, g, s, a, r, c, b);
   }

   public static int stat(int attributeID, EntityPlayer en, int s, int a, float b) {
      int g = getByte(en, "jrmcPwrtyp");
      int r = getByte(en, "jrmcRace");
      int c = getByte(en, "jrmcClass");
      return stat(attributeID, g, s, a, r, c, b);
   }

   public static int stat(EntityPlayer en, int s, int a, float b) {
      int g = getByte(en, "jrmcPwrtyp");
      int r = getByte(en, "jrmcRace");
      int c = getByte(en, "jrmcClass");
      return stat(g, s, a, r, c, b);
   }

   public static float statInc(int powerType, int stat, int attribute, int race, int classID, float skillBonus) {
      float[] attributes = getStatIncreases(powerType, race, classID);
      stat = attributes.length > stat ? stat : attributes.length - 1;
      float bs = attributes[stat] * (float)attribute;
      return round(bs + (float)getStatBonus(powerType, race, classID, stat, false) * 0.01F * bs + (float)getStatBonus(powerType, race, classID, stat, true) * 0.01F * bs + bs * skillBonus, 1, 1);
   }

   public static String algnCur(byte align) {
      String c = "";
      if (align > 66) {
         c = clbe;
      }

      if (align <= 66 && align >= 33) {
         c = cldp;
      }

      if (align < 33) {
         c = cldr;
      }

      return trl(c + AlgnmntNms[Algnmnt(align)]);
   }

   public static void sao_addlevel(int addlvl, EntityPlayer p) {
      int curexp = getInt(p, "saocExp");
      int curlvl = getInt(p, "saocLvl");
      curlvl = curlvl < 1 ? 1 : curlvl;
      int curap = getInt(p, "saocAp");
      int lvltoreach = curlvl + addlvl;

      for(boolean b = true; b; curexp = 0) {
         if (lvltoreach <= curlvl + addlvl) {
            b = false;
            break;
         }

         ++curlvl;
         curap += 3;
      }

      setInt(curexp, p, "saocExp");
      setInt(curlvl, p, "saocLvl");
      setInt(curap, p, "saocAp");
   }

   public static void sao_expgain(int expgained, EntityPlayer p) {
      int curexp = getInt(p, "saocExp");
      int curlvl = getInt(p, "saocLvl");
      curlvl = curlvl < 1 ? 1 : curlvl;
      int curap = getInt(p, "saocAp");
      boolean b = true;

      while(b && curlvl < 255) {
         int expneed = SAOexpNeeded(curlvl, curexp);
         if (expgained < expneed) {
            curexp += expgained;
            b = false;
            break;
         }

         expgained -= expneed;
         ++curlvl;
         curap += 3;
         curexp = 0;
         p.func_145747_a((new ChatComponentText("Congratulations!! LV UP! " + (curlvl - 1) + " > " + curlvl)).func_150255_a(JRMCoreEH.color));
      }

      if (curlvl >= 255) {
         p.func_145747_a((new ChatComponentText("Congratulations!! You Reached Max Level!")).func_150255_a(JRMCoreEH.color));
      }

      setInt(curexp, p, "saocExp");
      setInt(curlvl, p, "saocLvl");
      setInt(curap, p, "saocAp");
   }

   public static void sao_colgain(int colgained, EntityPlayer p) {
      int curcol = getInt(p, "saocCol");
      setInt(curcol + colgained, p, "saocCol");
   }

   public static int SAOCExpForLvl(int lvl) {
      return (int)(Math.pow((double)lvl, 2.0D) * 20.0D);
   }

   public static int SAOmaxExpGain(int lvl) {
      return 18 * lvl;
   }

   public static int SAOmaxColGain(int lvl) {
      return 15 * lvl;
   }

   public static int SAOexpNeeded(int lvl, int exp) {
      return SAOCExpForLvl(lvl) - exp;
   }

   public static int SAOCSklSlt(int lvl) {
      return 2 + (lvl > 5 ? 1 : 0) + (lvl > 19 ? lvl / 10 - 1 : 0);
   }

   public static int SAOSklMastery(String sklName, String[] sao_skillSlot) {
      int m = 0;

      for(int i = 0; i < sao_skillSlot.length; ++i) {
         if (sao_skillSlot[i].contains(sklName)) {
            String[] skl = sao_skillSlot[i].split(":");
            m = Integer.parseInt(skl[2]);
         }
      }

      return m;
   }

   public static int SAOSklLvl(String sklName, String[] sao_skillSlot) {
      int m = 0;

      for(int i = 0; i < sao_skillSlot.length; ++i) {
         if (sao_skillSlot[i].contains(sklName)) {
            String[] skl = sao_skillSlot[i].split(":");
            m = Integer.parseInt(skl[1]);
         }
      }

      return m;
   }

   public static String TrnngOptnsNam(int i) {
      return trl("jrmc", TrnngOptns[i]);
   }

   public static String TrnngOptnsDesc(int i) {
      return trl("jrmc", TrnngOptns[i] + "Desc");
   }

   public static String TeleportSound(int p) {
      return p == 1 ? "jinryuudragonbc:DBC2.tp" : (p == 2 ? "jinryuunarutoc:NC1.bunshin" : "");
   }

   public static boolean HairsT(int s, String t) {
      return HairsT[s].equals(t);
   }

   public static boolean HairsT(int s, int s2) {
      return HairsT[s].equals(HairsT[s2]);
   }

   public static boolean Allow(String allow) {
      return allow.contains("All") || allow.contains("DBC") && DBC() || allow.contains("HHC") && HHC() || allow.contains("JRFC") && JFC() || allow.contains("NC") && NC() || allow.contains("JYC") && JYC() || allow.contains("JBRA") && JBRA() || allow.contains("SAOC") && SAOC() || allow.contains("RoNC") && RoNC();
   }

   public static void mld() {
      if (modsS == null) {
         modsS = new HashMap();
         modsS.put(tjdbc, DBC());
         modsS.put(tjnc, NC());
         modsS.put(tjfc, JFC());
         modsS.put(tjyc, JYC());
         modsS.put(tjsaoc, SAOC());
         modsS.put(tjbc, BC());
         modsC = modsS;
      }

   }

   public static boolean iml(String tj) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT) {
         return modsC != null ? (Boolean)modsC.get(tj) : Loader.isModLoaded(tj);
      } else {
         return Loader.isModLoaded(tj);
      }
   }

   public static boolean DBC() {
      return iml(tjdbc);
   }

   public static boolean NC() {
      return iml(tjnc);
   }

   public static boolean JFC() {
      return iml(tjfc);
   }

   public static boolean JYC() {
      return iml(tjyc);
   }

   public static boolean JBRA() {
      return Loader.isModLoaded("jinryuubetterrenderaddon");
   }

   public static boolean HHC() {
      return Loader.isModLoaded("jinryuuhalfbreedhumanc");
   }

   public static boolean JHDSE() {
      return Loader.isModLoaded("jinryuu_hdskins_extended");
   }

   public static boolean RoNC() {
      return Loader.isModLoaded("aoiandjinryuuronc");
   }

   public static boolean SAOC() {
      return iml(tjsaoc);
   }

   public static boolean BC() {
      return iml(tjbc);
   }

   public static String Vers(String id) {
      String c = "";
      Iterator var2 = Loader.instance().getModList().iterator();

      while(var2.hasNext()) {
         ModContainer mod = (ModContainer)var2.next();
         if (mod.getModId().equals(id)) {
            c = mod.getVersion();
            break;
         }
      }

      return c;
   }

   public static String Nams(String id) {
      String c = "";
      if (id.equals("jinryuujrmcore")) {
         c = "JinRyuu's JRMCore";
      }

      if (id.equals("jinryuudragonblockc")) {
         c = DragonBCmodName();
      }

      if (id.equals("jinryuunarutoc")) {
         c = NarutoCmodName();
      }

      if (id.equals("jinryuufamilyc")) {
         c = FamilyCmodName();
      }

      if (id.equals("jinryuujyearsc")) {
         c = JYearsCmodName();
      }

      if (id.equals("jinryuubetterrenderaddon")) {
         c = JBRAmodName();
      }

      if (id.equals("jinryuuhdskinsextended")) {
         c = JHDSkinsmodName();
      }

      if (id.equals("aoiandjinryuuronc")) {
         c = RoNCmodName();
      }

      if (id.equals("jinryuusaoc")) {
         c = SAOCmodName();
      }

      if (id.equals("jinryuubleachc")) {
         c = BCmodName();
      }

      return c;
   }

   public static final String DragonBCmodName() {
      return "Dragon Block C";
   }

   public static final String NarutoCmodName() {
      return "Naruto C";
   }

   public static final String FamilyCmodName() {
      return "JinRyuu's Family C";
   }

   public static final String JYearsCmodName() {
      return "JinRyuu's JYears C";
   }

   public static final String JBRAmodName() {
      return "JinRyuu's Better Render Addon";
   }

   public static final String JHDSkinsmodName() {
      return "JinRyuu's HD Skins";
   }

   public static final String RoNCmodName() {
      return "Rise of Nature C";
   }

   public static final String SAOCmodName() {
      return "Sword Art Online C";
   }

   public static final String BCmodName() {
      return "JinRyuu's Bleach C";
   }

   public static final String DragonBCmodVer() {
      return "1.4.85";
   }

   public static final String NarutoCmodVer() {
      return "0.7.18";
   }

   public static final String FamilyCmodVer() {
      return "1.2.18";
   }

   public static final String JYearsCmodVer() {
      return "1.2.5";
   }

   public static final String JBRAmodVer() {
      return "1.6.52";
   }

   public static final String JHDSkinsmodVer() {
      return "1.3.1";
   }

   public static final String SAOCmodVer() {
      return "0.0.6";
   }

   public static String format_leadingZero(int l, Object... args) {
      return String.format("%0" + l + "d", args);
   }

   public static String format_lz2(Object... args) {
      return String.format("%02d", args);
   }

   public static String format_remTim(int t) {
      int s = t / 1 % 60;
      int m = t / 60 % 60 + 1;
      int h = t / 3600 % 24 + 1;
      int d = t / 86400 + 1;
      if (t < 60) {
         return s + "s";
      } else if (t < 3600) {
         return m + "m";
      } else if (t < 86400) {
         return h + "h";
      } else {
         return t < 86400 ? d + "d" : "";
      }
   }

   public static float round(float d, int decimalPlace) {
      return round(d, decimalPlace, 4);
   }

   public static float round(float d, int decimalPlace, int rm) {
      BigDecimal bd = new BigDecimal(Float.toString(d));
      bd = bd.setScale(decimalPlace, rm);
      return bd.floatValue();
   }

   public static double round(double d, int decimalPlace) {
      return round(d, decimalPlace, 4);
   }

   public static double round(double d, int decimalPlace, int rm) {
      BigDecimal bd = new BigDecimal(Double.toString(d));
      bd = bd.setScale(decimalPlace, rm);
      return bd.doubleValue();
   }

   public static String[] jfcPDat(String i) {
      String[] s = null;
      if (plyrs != null && jfcData0 != null) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(i)) {
               s = jfcData0[pl].toString().split(";");
               break;
            }
         }
      }

      return s;
   }

   public static int jrmcPDta1(String i, int a) {
      int g = 0;
      if (plyrs != null && data1 != null) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(i)) {
               String[] s = data1[pl].split(";");
               g = Integer.parseInt(s[a]);
               break;
            }
         }
      }

      return g;
   }

   public static String jrmcPDtaDNS(String i) {
      if (plyrs != null && data1 != null) {
         for(int pl = 0; pl < plyrs.length; ++pl) {
            if (plyrs[pl].equals(i)) {
               String s = data1[pl].split(";")[1];
               return s;
            }
         }
      }

      return null;
   }

   public static void configToClient(MinecraftServer server) {
      if (JRMCoreConfig.playerCount != server.func_71233_x()) {
         PD.sendToAll(new JRMCorePTrib());
         JRMCoreConfig.playerCount = server.func_71233_x();
      }

   }

   public static void configToClient(ByteBuf b) {
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(modsS));
      b.writeBoolean(JRMCoreComTickH.tna3fu);
      if (DBC()) {
         b.writeInt(JRMCoreHDBC.DBCgetConfigcmaxTrnExp());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcplntVegeta());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcflyAnyLvl());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcDeathSystemOff());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcDBSpawnEnabled());
         ByteBufUtils.writeUTF8String(b, JRMCoreHDBC.DBCgetConfigcDBSpawnTime());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcSagaSystemOn());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcSagaSysSpawnPods());
         b.writeInt(JRMCoreHDBC.DBCgetConfigcsenzuCool());
         b.writeFloat(JRMCoreHDBC.DBCgetConfigcReinc());
         b.writeBoolean(JRMCoreHDBC.DBCgetConfigcGodform());
         b.writeBoolean(JRMCoreHDBC.FreeRevC());
         b.writeInt(JRMCoreHDBC.DBCgetConfigcTechExpNeed());
         b.writeInt(JRMCoreHDBC.DBCgetConfigcTechCostMod());
      }

      if (JYC()) {
         b.writeInt(JRMCoreHJYC.JYCgetConfigcpgut());
      }

      if (JFC()) {
         b.writeInt(JRMCoreHJFC.getConfigcpt());
      }

      if (NC()) {
         ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCRacialSkillTPCost));
         ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCSkillTPCost));
         ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransGtsDmgO));
      }

      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCRacialSkillTPCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCSkillTPCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDmgO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDrainOLevel));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDrainORace));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransMngDmgO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiNmsO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransSaiStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransHalfSaiStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransFrStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransHmStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransNaStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransMaStBnPO));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCRacialSkillMindCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCSkillMindCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCRacialSkillMindCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCSkillMindCost));
      b.writeBoolean(JRMCoreConfig.OverAtrLimitO);
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cMysticDamMulti));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPMax));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPGrowth));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPCost));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPDamMulti));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPDamMultiPoint));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cAttibuteBonusPerRacialSkill));
      b.writeInt(JRMCoreConfig.cArcosianPPDamMultiHighest);
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cTPGainRateRace));
      ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cTPGainRace));
      b.writeBoolean(JRMCoreConfig.cexpGriOff);
      b.writeInt(JRMCoreConfig.cSklMedCat);
      b.writeFloat(JRMCoreConfig.cSklMedRate);
      b.writeBoolean(JRMCoreConfig.creleaseStop);
      b.writeBoolean(JRMCoreConfig.cregen);
      b.writeBoolean(JRMCoreConfig.crelease);
      b.writeInt(JRMCoreConfig.ctpgn);
      b.writeInt(etXq4V(JRMCoreConfig.ctmx));
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cregenRate);
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.chRegenRate);
      b.writeBoolean(JRMCoreConfig.csizes);
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssurl);
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssurl2);
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssc);
      b.writeBoolean(JRMCoreConfig.csfzns);
      b.writeBoolean(JRMCoreConfig.cNPCSpawnCheck);
      b.writeBoolean(JRMCoreConfig.cBuildingSpawnCheck);
      b.writeInt(JRMCoreConfig.cbuildingSpawnAreaSize);
      b.writeBoolean(JGConfigMiniGameConcentration.cTPGainOn);
      b.writeFloat(JGConfigMiniGameConcentration.cTPlimitIncreasesWithPlayerLevel);
      b.writeFloat(JGConfigMiniGameConcentration.cTPMultiplier);
      b.writeInt(JGConfigMiniGameConcentration.cTPDailyLimit);
      b.writeFloat(JGConfigMiniGameConcentration.cComboTimer);
      b.writeBoolean(JGConfigMiniGameConcentration.cConstantClickOn);
      b.writeInt(JGConfigMiniGameConcentration.cRandomMovementSpeed);
      b.writeBoolean(JGConfigMiniGameAirBoxing.cTPGainOn);
      b.writeFloat(JGConfigMiniGameAirBoxing.cTPlimitIncreasesWithPlayerLevel);
      b.writeFloat(JGConfigMiniGameAirBoxing.cTPMultiplier);
      b.writeInt(JGConfigMiniGameAirBoxing.cTPDailyLimit);
      b.writeInt(JGConfigMiniGameAirBoxing.cStartLife);

      int i;
      int j;
      int formID;
      for(i = 0; i < 4; ++i) {
         b.writeFloat(JGConfigMiniGameAirBoxing.cKeySpawnSpeed[i]);
         b.writeFloat(JGConfigMiniGameAirBoxing.cKeySpeed[i]);
         b.writeInt(JGConfigMiniGameAirBoxing.cKeyLifeTaken[i]);
         j = JGConfigMiniGameAirBoxing.cKeyTypeIDs[i].length;
         b.writeInt(j);

         for(formID = 0; formID < j; ++formID) {
            b.writeInt(JGConfigMiniGameAirBoxing.cKeyTypeIDs[i][formID]);
         }
      }

      b.writeInt(JRMCoreConfig.cStatPasDef);
      b.writeInt(JRMCoreConfig.cmjn);
      b.writeDouble(JRMCoreConfig.catcm);
      b.writeInt(JRMCoreConfig.cAttributeUpgradeCost_StartMinus);
      b.writeInt(JRMCoreConfig.cAttributeUpgradeCost_Min);
      float[] var7 = JRMCoreConfig.cAttributeUpgradeCost_AttributeMulti;
      j = var7.length;

      for(formID = 0; formID < j; ++formID) {
         double d = (double)var7[formID];
         b.writeDouble(d);
      }

      b.writeInt(JRMCoreConfig.clgnd);
      ByteBufUtils.writeUTF8String(b, JRMCoreConfig.clgndb);
      b.writeBoolean(JRMCoreConfig.clockon);
      b.writeDouble(JRMCoreConfig.cFlngspd);
      if (DBC()) {
         String s = "";

         for(j = 0; j < JRMCoreConfig.cdat5695.length; ++j) {
            s = s + JRMCoreConfig.cdat5695[j];
            if (j + 1 < JRMCoreConfig.cdat5695.length) {
               s = s + " ";
            }
         }

         ByteBufUtils.writeUTF8String(b, s);
         s = "";

         for(j = 0; j < JRMCoreConfig.cdat5696.length; ++j) {
            for(formID = 0; formID < JRMCoreConfig.cdat5696[formID].length; ++formID) {
               s = s + JRMCoreConfig.cdat5696[j][formID];
               if (formID + 1 < JRMCoreConfig.cdat5696.length) {
                  s = s + " ";
               }
            }

            if (j + 1 < JRMCoreConfig.cdat5696.length) {
               s = s + ";";
            }
         }

         ByteBufUtils.writeUTF8String(b, s);
         s = "";

         for(j = 0; j < JRMCoreConfig.cdat5709.length; ++j) {
            s = s + JRMCoreConfig.cdat5709[j];
            if (j + 1 < JRMCoreConfig.cdat5709.length) {
               s = s + " ";
            }
         }

         ByteBufUtils.writeUTF8String(b, s);
      }

      if (DBC() || NC()) {
         b.writeBoolean(JRMCoreConfig.cdat5711);
      }

      if (DBC()) {
         b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_LEVELS);

         for(i = 0; i < JGConfigUltraInstinct.cCONFIG_UI_LEVELS; ++i) {
            b.writeInt(JGConfigUltraInstinct.cCONFIG_UI_HEAT_DURATION[i]);
            b.writeBoolean(JGConfigUltraInstinct.cCONFIG_UI_HAIR_WHITE[i]);
            b.writeInt(JGConfigUltraInstinct.cCONFIG_UI_ATTRIBUTE_MULTI[i]);

            for(j = 0; j < Races.length; ++j) {
               b.writeFloat(JGConfigUltraInstinct.cCONFIG_UI_ATTRIBUTE_MULTI_RACE[i][j]);
            }

            for(j = 0; j < 2; ++j) {
               b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_DODGE_RATE[i][j]);
               b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_ATTACK_RATE[i][j]);
            }
         }
      }

      b.writeByte(JRMCoreConfig.cExtendedPlayerBlockID);
      b.writeByte(JRMCoreConfig.cExtendedPlayerOtherID);
      b.writeByte(JRMCoreConfig.cExtendedPlayerHairID);
      if (DBC()) {
         b.writeBoolean(DBCConfig.cCanWhisTeleport);
         b.writeFloat(DBCConfig.cEnmaScale);
         b.writeFloat(DBCConfig.cGuruScale);

         for(i = 0; i < JRMCoreConfig.cContinuesKiAttacks.length; ++i) {
            b.writeBoolean(JRMCoreConfig.cContinuesKiAttacks[i]);
         }

         b.writeBoolean(JRMCoreConfig.cKiAttackScalesWithUser);
      }

      if (NC()) {
         for(i = 0; i < JRMCoreConfig.cContinuesJutsuAttacks.length; ++i) {
            b.writeBoolean(JRMCoreConfig.cContinuesJutsuAttacks[i]);
         }

         b.writeBoolean(JRMCoreConfig.cJutsuScalesWithUser);
      }

      if (DBC() || NC()) {
         b.writeBoolean(JRMCoreConfig.cWavesShrinkOnceLetGo);
         b.writeBoolean(JRMCoreConfig.cContinuesEnergyAttackTargetSlowdown);
         b.writeInt(JRMCoreConfig.cContinuesEnergyAttackTimer);
      }

      b.writeInt(JRMCoreConfig.ceaesl);
      b.writeFloat(JRMCoreConfig.cealbm);
      if (DBC()) {
         b.writeInt(DBCConfig.cNullRealmMinimumHeight);

         for(i = 0; i < 9; ++i) {
            b.writeDouble(JRMCoreConfig.cdat5696[i][2]);
         }

         b.writeBoolean(DBCConfig.cNullRealmBGColorNodeGreen);
         b.writeBoolean(JRMCoreConfig.cPlayerFlyingDragDownOn);
      }

      if (DBC()) {
         for(i = 0; i < Races.length; ++i) {
            for(j = 0; j < ClassesDBC.length; ++j) {
               for(formID = 0; formID < attrInit[1].length; ++formID) {
                  b.writeDouble(JGConfigRaces.cCONFIG_RACES_ATTRIBUTE_MULTI[i][j][formID]);
                  b.writeInt(JGConfigRaces.cCONFIG_RACES_ATTRIBUTE_START[i][j][formID]);
               }

               for(formID = 0; formID < statNames[1].length; ++formID) {
                  b.writeFloat(JGConfigRaces.cCONFIG_RACES_STATS_MULTI[i][j][formID]);
                  b.writeInt(JGConfigRaces.cCONFIG_RACES_STAT_BONUS[i][j][formID]);
               }
            }
         }

         b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ENABLED);
         b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ABSORPTION_ENABLED);
         b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_PURE_PINK_SKIN);
         b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS);

         for(i = 0; i < TransNms[5].length + 3; ++i) {
            b.writeFloat(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i]);
            b.writeFloat(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i]);
         }
      }

      b.writeBoolean(JRMCoreConfig.cJRMCABonusOn);
      b.writeBoolean(JRMCoreConfig.cShadowDummyScaleToTarget);
      if (DBC()) {
         b.writeBoolean(JGConfigUltraInstinct.cCONFIG_UI_IGNORE_BASE_CONFIG);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_BASE_CONFIG);
         b.writeInt(JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES.length);

         for(i = 0; i < JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES.length; ++i) {
            ByteBufUtils.writeUTF8String(b, JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES[i]);
         }

         b.writeInt(JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES.length);

         for(i = 0; i < JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES.length; ++i) {
            ByteBufUtils.writeUTF8String(b, JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES[i]);
         }

         b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_DAMAGE_MULTI);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_ENABLED);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_AURA_ENABLED);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_AURA_ENABLED_WITH_AURA);
         b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_ENERGY_ENABLED);
         b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ENERGY_DAMAGE_MULTI);
         b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ATTRIBUTE_MULTI);

         for(i = 0; i < Races.length; ++i) {
            b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i]);
         }
      }

      b.writeBoolean(JRMCoreConfig.cBuildingBlocksRenderAsNormalBlock);
      b.writeFloat(JGConfigSkills.cGlobalSkillTPMultiplier);
      b.writeFloat(JGConfigSkills.cGlobalSkillMindMultiplier);
      b.writeFloat(JGConfigSkills.cGlobalSkillTPMultiplierFirst);
      b.writeFloat(JGConfigSkills.cGlobalSkillMindMultiplierFirst);
      b.writeBoolean(JGConfigSkills.cGlobalSkillTPMultiplierWithLevel);
      b.writeBoolean(JGConfigSkills.cGlobalSkillMindMultiplierWithLevel);
      if (NC()) {
         b.writeInt(JRMCoreConfig.cNCExplosionTagTickTimer);
      }

      if (DBC()) {
         b.writeInt(DBCConfig.cAaiForceDifficulty);
         b.writeBoolean(DBCConfig.cAaiDisabled);
         b.writeInt(DBCConfig.cEnemyDefaultAttackTimer);
         b.writeInt(DBCConfig.cEnemyDefaultShortRangeAttackTimer);
         b.writeDouble(DBCConfig.cEnemyDefaultMoveSpeed);
         b.writeBoolean(DBCConfig.cKiAttackGoThroughInvulnerableEnemies);
         b.writeBoolean(DBCConfig.cInstantTransformOn);
         b.writeBoolean(DBCConfig.cSingleFormDescendOn);

         for(i = 0; i < DBCConfig.cIsInstantTransformEnabled.length; ++i) {
            b.writeBoolean(DBCConfig.cIsInstantTransformEnabled[i]);
         }

         b.writeBoolean(DBCConfig.cKaiokenSingleFormDescendOn);
         b.writeBoolean(DBCConfig.cMoveWhileTransforming);
         b.writeBoolean(DBCConfig.cMoveWhileInstantTransforming);

         for(i = 0; i < JGConfigDBCAAiDifficulty.DIFFICULTIES.length; ++i) {
            b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashSpeedMulti[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashSpeedMulti2[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashLimit[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cJumpMulti[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cJumpMulti2[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cJumpLimit[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cJumpLimit2[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cJumpRate[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cFlyingDashMulti[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cFlyingDashLimit[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cKiAttackChargeMulti[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cKiAttackChargeLimit[i]);
            b.writeInt(JGConfigDBCAAiDifficulty.cTeleportRateMin[i]);
            b.writeInt(JGConfigDBCAAiDifficulty.cTeleportRateMax[i]);
            b.writeDouble(JGConfigDBCAAiDifficulty.cSpeedMulti[i]);
         }

         b.writeBoolean(DBCConfig.cMysticKaiokenOn);

         for(i = 0; i < Races.length; ++i) {
            for(j = 0; j < JRMCoreConfig.KaiokenFormHealthCost[i].length; ++j) {
               b.writeFloat(JRMCoreConfig.cKaiokenFormHealthCost[i][j]);
            }
         }

         for(i = 0; i < 2; ++i) {
            b.writeBoolean(JGConfigDBCInstantTransmission.CCONFIG_INSTANT_TRANSMISSION_ENABLED[i]);
         }
      }

      b.writeBoolean(JGConfigDBCFormMastery.cFM_Enabled);

      for(i = 0; i < Races.length; ++i) {
         j = trans[i].length;

         for(formID = 0; formID < JGConfigDBCFormMastery.cFormMasteries[i].length; ++formID) {
            boolean racial = formID < j;
            String form = racial ? trans[i][formID] : transNonRacial[formID - j];
            if (!racial || !isRaceSaiyan(i) || !form.equals(trans[i][12]) && !form.equals(trans[i][13])) {
               for(int j = 0; j < 3; ++j) {
                  b.writeDouble(JGConfigDBCFormMastery.cFormMasteries[i][formID].getDouble(0, j));
               }
            }
         }
      }

   }

   public static float getMaxEnergyDamage() {
      float max = (float)JRMCoreConfig.tmx * 10.0F;
      if (max < 0.0F) {
         max = (float)JRMCoreConfig.tmx;
      }

      return max;
   }

   public static int state2UltraInstinct(byte state2) {
      return state2UltraInstinct(false, state2);
   }

   public static int state2UltraInstinct(boolean kaioken, byte state2) {
      return !kaioken && state2 != 0 && state2 <= JGConfigUltraInstinct.CONFIG_UI_LEVELS ? state2 - 1 : 0;
   }

   public static float getHeatPercentageClient() {
      if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
         int heat_current = cura;
         int state2 = state2UltraInstinct(StusEfctsMe(5), State2);
         int heat_max = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[state2];
         if (heat_max == 0) {
            return 100.0F;
         } else {
            float heat_one = (float)heat_max / 100.0F;
            float heat_current_percentage = (float)heat_current / heat_one;
            if (heat_current_percentage < 0.0F) {
               heat_current_percentage *= -1.0F;
            }

            return heat_current_percentage;
         }
      } else {
         return 0.0F;
      }
   }

   public static float getHeatPercentage(EntityPlayer player, byte status2) {
      if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
         int heatCurrent = getByte(player, "jrmcEf8slc");
         int heatMax = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[status2];
         if (heatMax == 0) {
            return 100.0F;
         } else {
            float heatOne = (float)heatMax / 100.0F;
            float heatPercentage = (float)heatCurrent / heatOne;
            if (heatPercentage < 0.0F) {
               heatPercentage *= -1.0F;
            }

            return heatPercentage;
         }
      } else {
         return 0.0F;
      }
   }

   public static byte getUltraInstinctRate(EntityPlayer player, byte status2, byte[][] rates) {
      if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
         byte max = rates[status2][1];
         if (max == 0) {
            return 0;
         } else {
            byte min = rates[status2][0];
            byte diff = (byte)(max - min);
            if (diff == 0) {
               return min;
            } else {
               float heatPercentage = getHeatPercentage(player, status2);
               int current = (byte)((int)((float)diff * heatPercentage * 0.01F + (float)diff));
               if (current < 0) {
                  current *= -1;
               }

               if (current > 100) {
                  current = 100;
               }

               return (byte)current;
            }
         }
      } else {
         return 0;
      }
   }

   public static byte getUltraInstinctDodgeRate(EntityPlayer player, byte status2) {
      return getUltraInstinctRate(player, status2, JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE);
   }

   public static byte getUltraInstinctCounterRate(EntityPlayer player, byte status2) {
      return getUltraInstinctRate(player, status2, JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE);
   }

   public static boolean canUltraInstinctDodgeSource(DamageSource source) {
      return !JGConfigUltraInstinct.CONFIG_UI_CANT_DODGE.contains(source.func_76355_l());
   }

   public static boolean canUltraInstinctCounterSource(DamageSource source) {
      return JGConfigUltraInstinct.CONFIG_UI_CAN_COUNTER.contains(source.func_76355_l());
   }

   public static float Perc(int d) {
      return d == 1 ? Perc10 : (d == 2 ? Perc15 : 1.0F);
   }

   public static void expPls(EntityPlayer player, int value) {
      int xpLimit = 10;
      int tpGain = 1;
      byte exp;
      if (DBC()) {
         exp = getByte(player, "jrmcDiff");
         JGPlayerMP jgPlayer = new JGPlayerMP(player);
         jgPlayer.connectBaseNBT();
         int race = jgPlayer.getRace();
         tpGain = (int)((float)JRMCoreConfig.tpgn * JRMCoreConfig.TPGainRace[race]);
      }

      exp = getByte(player, "jrmcExp");
      int tp = getInt(player, "jrmcTpint");
      if (tp < getMaxTP()) {
         if (exp + value >= xpLimit) {
            for(int i = 0; i < (exp + value) / xpLimit; ++i) {
               if (i == (exp + value) / xpLimit - 1) {
                  setInt(tp + (i + 1) * tpGain, player, "jrmcTpint");
               }
            }
         }

         int add = exp + value - (exp + value) / xpLimit * xpLimit;
         setByte(add, player, "jrmcExp");
      }

   }

   public static void triForce(int i, int j, int k) {
      PD.sendToServer(new JRMCorePTri((byte)i, (byte)j, (byte)k));
   }

   static void jrmct(int t, String s, EntityPlayer p) {
      PD.sendTo(new JRMCorePTick(t, s), (EntityPlayerMP)p);
   }

   public static void jrmct(int t) {
   }

   public static void jrmctAll(int t, String s) {
      PD.sendToAll(new JRMCorePTick(t, s));
   }

   public static void jrmcDataFC(int c, String d) {
      PD.sendToServer(new JRMCorePData(c, d));
   }

   public static void jrmcData(int c, String d) {
      PD.sendToAll(new JRMCorePData(c, d));
   }

   public static void jrmcDataToP(int c, String d, EntityPlayer p) {
      PD.sendTo(new JRMCorePData(c, d), (EntityPlayerMP)p);
   }

   public static void Char(byte b, byte b2) {
      PD.sendToServer(new JRMCorePChar(b, b2));
   }

   public static void Upg(byte b) {
      PD.sendToServer(new JRMCorePUpgrade(b));
   }

   public static void Attck(byte b) {
      PD.sendToServer(new JRMCorePAttck(b));
   }

   public static void Rls(byte b) {
      PD.sendToServer(new JRMCorePRls(b));
   }

   public static void Cost(int cost2) {
      PD.sendToServer(new JRMCorePCost((short)cost2));
   }

   public static void Stats(EntityPlayer p, int curBody, int curEnergy, int curStamina, byte curRelease, byte b) {
      PD.sendTo(new JRMCorePStats(curBody, curEnergy, curStamina, curRelease, b), (EntityPlayerMP)p);
   }

   public static void Stats2(EntityPlayer p, int curTP, int curExp, byte align, int[] plyrAttrbts2) {
      PD.sendTo(new JRMCorePStats2(curTP, curExp, align, plyrAttrbts2), (EntityPlayerMP)p);
   }

   public static void Stats3(EntityPlayer p, String PlyrSkills, String x, String y, String z) {
      PD.sendTo(new JRMCorePStats3b(PlyrSkills, x, y, z), (EntityPlayerMP)p);
   }

   public static void Tech(EntityPlayer p, byte n, String t) {
      PD.sendTo(new JRMCorePTech(n, t), (EntityPlayerMP)p);
   }

   public static void Tech(byte n, String t) {
      PD.sendToServer(new JRMCorePTech(n, t));
   }

   public static void Skll(byte op, byte id) {
      PD.sendToServer(new JRMCorePStats3(op, id, (byte)1));
   }

   public static void Skll(byte op, byte id, byte bn) {
      PD.sendToServer(new JRMCorePStats3(op, id, bn));
   }

   public static void Anim(int i) {
      PD.sendToServer(new JRMCorePFall((byte)i));
   }

   public static void resetDBCworldgen() {
      WorldGeneratorDB.KiLtSpawn = true;
      WorldGeneratorDB.KiLtTCSpawn = true;
      WorldGeneratorDB.ChkInStSpawn = true;
      WorldGeneratorDB.SnkWySpawn = true;
      WorldGeneratorDB.TiChaSpawn = true;
      WorldGeneratorDB.TiChaKLSpawn = true;
      WorldGeneratorDB.KnTrSpawn = true;
      WorldGeneratorDB.WorldGen_TOPArena_Done = true;
      WorldGeneratorDB.WorldGen_TOPZeno_Done = true;
      WorldGeneratorDB.WorldGen_Zeno_Done = true;
      WorldGeneratorDB.KHSpawn = true;
      WorldGeneratorDB.CASpawn = true;
      WorldGeneratorDB.GHSpawn = true;
      WorldGeneratorDB.FSSpawn = true;
      WorldGeneratorDB.BSSpawn = true;
      WorldGeneratorDB.WorldGen_GuruHouse_Done = true;
      DBCH.genCA = "";
      DBCH.genKH = "";
      DBCH.genGH = "";
      DBCH.genFS = "";
      DBCH.genBS = "";
      DBCH.genGuru = "";
   }

   public static void resetNCworldgen() {
      WorldGeneratorNC.KonohaSpawn = true;
      NCH.genKnvl = "";
      NCCommonTickHandler.sentDatnc0 = null;
      NCCommonTickHandler.sentDatnc1 = null;
   }

   public static void resetDedSer() {
      DBCresetted = true;
      NCresetted = true;
      if (DBC()) {
         resetDBCworldgen();
      }

      if (NC()) {
         resetNCworldgen();
      }

      JRMCoreComTickH.bldngChkr = true;
      JRMCoreComTickH.start = true;
      JRMCoreComTickH.bldngsChecker = 300;
      JRMCoreComTickH.sentData0 = null;
      JRMCoreComTickH.sentData1 = null;
      JRMCoreComTickH.sentData2 = null;
      JRMCoreComTickH.sentData3 = null;
      JRMCoreComTickH.sentData4 = null;
      JRMCoreComTickH.sentData5 = null;
      JRMCoreComTickH.sentData6 = null;
      JRMCoreComTickH.sentData7 = null;
      JRMCoreComTickH.sentData8 = null;
      JRMCoreComTickH.sentData9 = null;
      JRMCoreComTickH.sentDat10 = null;
      JRMCoreComTickH.sentDat11 = null;
      JRMCoreComTickH.sentDat12 = null;
      JRMCoreComTickH.sentDat13 = null;
      JRMCoreComTickH.sentDat14 = null;
      JRMCoreComTickH.sentDat15 = null;
      JRMCoreComTickH.sentDat16 = null;
      JRMCoreComTickH.sentDat17 = null;
      JRMCoreComTickH.sentDat18 = null;
      JRMCoreComTickH.sentDat19 = null;
      JRMCoreComTickH.sentDat20 = null;
      JRMCoreComTickH.sentDat21 = null;
      JRMCoreComTickH.sentDat22 = null;
      JRMCoreComTickH.sentDat23 = null;
      JRMCoreComTickH.sentDat24 = null;
      JRMCoreComTickH.sentDat25 = null;
      JRMCoreComTickH.sentDat26 = null;
      JRMCoreComTickH.sentDat27 = null;
      JRMCoreComTickH.sentDat28 = null;
      JRMCoreComTickH.sentDat29 = null;
      JRMCoreComTickH.sentDat30 = null;
      JRMCoreComTickH.sentDat31 = null;
      JRMCoreComTickH.sentDat32 = null;
      if (JFC()) {
      }

   }

   public static void resetChar(EntityPlayer p) {
      resetChar(p, false, false, false, 0.0F);
   }

   public static void resetChar(EntityPlayer p, boolean keepSkills, boolean keepTechs) {
      resetChar(p, keepSkills, keepTechs, false, 0.0F);
   }

   public static void resetChar(EntityPlayer p, boolean keepSkills, boolean keepTechs, boolean keepMasteries, float perc) {
      String nam = p.func_70005_c_();
      String[] pw = new String[]{"NotSelected", "DBC", "NC", "SAO"};
      int pwr = getByte(p, "jrmcPwrtyp");
      mod_JRMCore.logger.info("Character reset for " + nam);
      mod_JRMCore.logger.info("Power User: " + pw[pwr]);
      mod_JRMCore.logger.info("Alignment: " + getByte(p, "jrmcAlign"));
      mod_JRMCore.logger.info("Race: " + Races[getByte(p, "jrmcRace")]);
      mod_JRMCore.logger.info("Class: " + cl(getByte(p, "jrmcPwrtyp"))[getByte(p, "jrmcClass")]);

      for(int i = 0; i < attrNms[pwr].length; ++i) {
         mod_JRMCore.logger.info(attrNms(pwr, i) + ": " + getInt(p, AttrbtNbtI[i]));
      }

      String[] PlyrSkills = getString(p, "jrmcSSlts").split(",");

      byte j;
      for(j = 0; j < PlyrSkills.length; ++j) {
         String skl = PlyrSkills[j];
         if (skl.length() > 2) {
            mod_JRMCore.logger.info("Skill: " + SklName(skl, pwr == 1 ? DBCSkillsIDs : NCSkillIDs, pwr == 1 ? DBCSkillNames : NCSkillNames) + " lvl: " + (Integer.parseInt(skl.substring(2)) + 1));
         }
      }

      if (!keepMasteries) {
         mod_JRMCore.logger.info("Form Masteries (Racial): " + getString(p, getNBTFormMasteryRacialKey(getByte(p, "jrmcRace"))));
         mod_JRMCore.logger.info("Form Masteries (Non-Racial): " + getString(p, "jrmcFormMasteryNonRacial"));
      }

      setByte((int)67, p, "jrmcAlign");
      setInt((int)0, p, "jrmcKarma");
      setByte((int)0, p, "jrmcKillCountGood");
      setByte((int)0, p, "jrmcKillCountNeut");
      setByte((int)0, p, "jrmcKillCountEvil");
      setByte((int)0, p, "jrmcDiedTimes");
      setByte((int)0, p, "jrmcRelease");
      setByte((int)0, p, "jrmcPwrtyp");
      setByte((int)0, p, "jrmcClass");
      setInt((int)1, p, AttrbtNbtI[0]);
      setInt((int)1, p, AttrbtNbtI[1]);
      setInt((int)1, p, AttrbtNbtI[2]);
      setInt((int)1, p, AttrbtNbtI[3]);
      setInt((int)1, p, AttrbtNbtI[4]);
      setInt((int)1, p, AttrbtNbtI[5]);
      setByte((int)0, p, "jrmcState");
      setByte((int)0, p, "jrmcState2");
      setByte((int)0, p, "jrmcSaiRg");
      setByte((int)-1, p, "jrmcTlmd");
      setByte((int)0, p, "jrmcAccept");
      setByte((int)0, p, "jrmcDiff");
      setInt((int)99, p, "DBCSagaSys");
      setString(" ", p, "jrmcStatusEff");
      setString(" ", p, "jrmcSettings");
      setString(" ", p, "JRMCmissionSync");
      setString(" ", p, "JRMCmissionSyncVers");
      setString(" ", p, "jrmcDNSAU");
      setInt((int)0, p, "jrmcAfGFtStFT");
      if (getShort(p, "jrmcGTrnng") > 200) {
         setShort((int)200, p, "jrmcGTrnng");
      }

      setString("pty", p, "jrmcSSltX");
      setString("pty", p, "jrmcSSltY");
      if (!keepSkills) {
         setString(",", p, "jrmcSSlts");
      }

      if (!keepTechs) {
         for(j = 0; j < techNbt.length; ++j) {
            setString(" ", p, techNbt[j]);
         }
      }

      if (!keepMasteries) {
         setString("Base,0", p, getNBTFormMasteryRacialKey(getByte(p, "jrmcRace")));
         setString("Kaioken,0", p, "jrmcFormMasteryNonRacial");
      }

      setShort((int)0, p, "jrmcGTrnng");
      setByte((int)0, p, "jrmcUIStateReach");
      setByte((int)0, p, "jrmcUIWasInPain");
      setByte((int)0, p, "jrmcUIWasInPainDuration");
      setString("0;0", p, "jrmcInstantTransmissionTimers");
      setInt((int)0, p, "saocAp");
      setInt((int)0, p, "saocCol");
      setInt((int)0, p, "saocExp");
      setInt((int)1, p, "saocLvl");
   }

   public static void resetChar() {
      DBCresetted = true;
      int[] att = new int[]{0, 0, 0, 0, 0, 0};
      int[] var10000 = new int[]{0, 0, 0, 0, 0, 0};
      PlyrAttrbts = att;
      Race = 0;
      dns = "0";
      Pwrtyp = 0;
      Class = 0;
      State = 0;
      plyrsArnd = null;
      curBody = 0;
      curEnergy = 0;
      maxBody = 0;
      maxEnergy = 0;
      curRelease = 0;
      curTP = 0;
      curExp = 0;
      State2 = 0;
      Dffclty = 0;
      TlMd = 0;
      PtchVc = 0;
      GTrnngCB = 0;
      align = 0;
      karma = 0;
      WeightOn = 0.0F;
      GravZone = 1.0F;
      PlyrSettings = "";
      PlyrSkillX = "";
      PlyrSkillY = "";
      PlyrSkillZ = "";
      String[] str = new String[]{"", "", "", "", "", "", "", "", "", ""};
      PlyrSkills = str;
      tech1 = null;
      tech2 = null;
      tech3 = null;
      tech4 = null;
      techPM = null;
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
      JRMCoreConfig.ssc = "empty";
      JRMCoreConfig.ssurl = "empty";
      JRMCoreConfig.ssurl2 = "empty";
      JRMCoreConfig.sfzns = JRMCoreConfig.csfzns;
      JRMCoreGuiScreen.CanRace = true;
      JRMCoreGuiScreen.CanGender = true;
      JRMCoreGuiScreen.CanHair = true;
      JRMCoreGuiScreen.CanColor = true;
      JRMCoreGuiScreen.CanSpecial = true;
      JRMCoreGuiScreen.CanPwr = true;
      JRMCoreGuiScreen.CanClass = true;
      JRMCoreGuiScreen.RaceSlcted = 0;
      JRMCoreGuiScreen.GenderSlcted = 0;
      JRMCoreGuiScreen.HairSlcted = 10;
      JRMCoreGuiScreen.ColorSlcted = 0;
      JRMCoreGuiScreen.BrghtSlcted = 0.8F;
      JRMCoreGuiScreen.BodyTypeSlcted = 0;
      JRMCoreGuiScreen.PwrtypSlcted = 0;
      JRMCoreGuiScreen.ClassSlcted = 0;
      JRMCoreGuiScreen.tail = true;
      JRMCoreM.missionsC = new HashMap();
      JRMCoreM.missionsCD = new HashMap();
      MSD = "";
      MSDV = "";
      hsp = "";
      jutsumode = 0;
      handsealfailed = 0;
      jutsu = 0;
      jutsuinfo = 0;
      ncDou = null;
      SagaProg = 0;
      SagaTimes = 0;
      SagaSideProg = 0;
      SagaSideTimes = null;
      GID = 0;
      GLID = " ";
      GIDs = null;
      GIDi = " ";
      GMN = 0;
      ServerPoints = 0;
      PtchVc = 0;
      if (JFC()) {
      }

   }

   public static int jrmcEnergyDam(Entity Player, int dbcA, DamageSource s) {
      if (!Player.field_70170_p.field_72995_K && Player instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)Player;
         ExtendedPlayer props = ExtendedPlayer.get(player);
         boolean block = props.getBlocking() == 1;
         int[] PlyrAttrbts = PlyrAttrbts(player);
         NBTTagCompound nbt = nbt(player, "pres");
         byte st = nbt.func_74771_c("jrmcState");
         int t = SklLvl(4, (EntityPlayer)player);
         byte rc = nbt.func_74771_c("jrmcRace");
         byte pwr = nbt.func_74771_c("jrmcPwrtyp");
         byte cls = nbt.func_74771_c("jrmcClass");
         byte rls = getByte(player, "jrmcRelease");
         int def = (int)((float)stat(player, 1, pwr, 1, PlyrAttrbts[1], rc, cls, 0.0F) * 0.5F);
         def = block ? def : 0;
         int ta = 0;
         if (s != null && s.func_76346_g() instanceof EntityPlayer) {
            String[] ops = PlyrSkills((EntityPlayer)s.func_76346_g());
            ta = SklLvl(14, 1, ops);
         }

         int d = (int)((float)(def * rls) * 0.01F);
         int p = (int)((float)(d * ta) * 0.01F);
         dbcA = (int)((float)(dbcA - (d - p)) * (1.0F - 0.03F * (float)t));
         dbcA = dbcA <= 0 ? 1 : dbcA;
         int curBody = getInt(player, "jrmcEnrgy");
         int all = curBody - dbcA;
         setInt(all < 0 ? 0 : all, player, "jrmcEnrgy");
      }

      return dbcA;
   }

   public static int jrmcDam(Entity Player, int dbcA, DamageSource s, byte t) {
      if (!Player.field_70170_p.field_72995_K && Player instanceof EntityPlayer && t == 2) {
         Random ran = new Random();
         int r = ran.nextInt(4);
         if (r == 0) {
            Player.field_70170_p.func_72956_a(Player, "jinryuudragonbc:DBC4.disckill", 1.0F, 1.0F);
            setByte((byte)4, (EntityPlayer)Player, "jrmcTlmd");
            int state = getByte((EntityPlayer)Player, "jrmcState");
            if (state == 7 || state == 8 || state == 14) {
               setByte((int)0, (EntityPlayer)Player, "jrmcState");
            }
         }
      }

      return jrmcDam(Player, dbcA, s);
   }

   public static int jrmcDam(Entity Player, int dbcA, DamageSource s) {
      if (!Player.field_70170_p.field_72995_K && Player instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)Player;
         boolean dse = s != null && s.func_76346_g() != null && s.func_76346_g() instanceof EntityPlayer;
         if (!player.field_71075_bZ.field_75098_d) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            boolean block = props.getBlocking() == 1;
            int[] PlyrAttrbts = PlyrAttrbts(player);
            NBTTagCompound nbt = nbt(player, "pres");
            byte state = nbt.func_74771_c("jrmcState");
            byte state2 = nbt.func_74771_c("jrmcState2");
            String sklx = getString(player, "jrmcSSltX");
            int t = SklLvl(4, (EntityPlayer)player);
            byte race = nbt.func_74771_c("jrmcRace");
            byte powerType = nbt.func_74771_c("jrmcPwrtyp");
            byte classID = nbt.func_74771_c("jrmcClass");
            byte release = getByte(player, "jrmcRelease");
            int resrv = getInt(player, "jrmcArcRsrv");
            String absorption = getString(player, "jrmcMajinAbsorptionData");
            int currStamina = getInt(player, "jrmcStamina");
            int currEnergy = getInt(player, "jrmcEnrgy");
            String ste = getString(player, "jrmcStatusEff");
            boolean mj = StusEfcts(12, ste);
            boolean lg = StusEfcts(14, ste);
            boolean mc = StusEfcts(13, ste);
            boolean kk = StusEfcts(5, ste);
            boolean mn = StusEfcts(19, ste);
            boolean gd = StusEfcts(20, ste);
            boolean lf = s != null && s == DamageSource.field_76379_h;
            int DEX = PlyrAttrbts[1];
            int CON = PlyrAttrbts[2];
            String[] ps = PlyrSkills(player);
            double per = 1.0D;
            int def = false;
            String x = getString(player, "jrmcStatusEff");
            boolean c = StusEfcts(10, x) || StusEfcts(11, x);
            if (powerType != 3 && powerType > 0) {
               DEX = getPlayerAttribute(player, PlyrAttrbts, 1, state, state2, race, sklx, release, resrv, lg, mj, kk, mc, mn, gd, powerType, ps, c, absorption);
            }

            int kiProtection = 0;
            int kiProtectionCost = 0;
            boolean kiProtectOn = false;
            int staminaCost;
            int defensePenetration;
            int dbcAO;
            int defense;
            int def;
            int defensePen2;
            if (pwr_ki(powerType)) {
               staminaCost = getPlayerAttribute(player, PlyrAttrbts, 2, state, state2, race, sklx, release, resrv, lg, mj, kk, mc, mn, gd, powerType, ps, c, absorption);
               per = (double)(staminaCost > CON ? staminaCost : CON) / ((double)CON * 1.0D);
               def = stat(player, 1, powerType, 1, DEX, race, classID, 0.0F);
               defensePenetration = PlyrAttrbts[5];
               dbcAO = stat(player, 5, powerType, 5, defensePenetration, race, classID, SklLvl_KiBs((String[])ps, powerType));
               def = (int)((double)def * (double)release * 0.01D * (double)weightPerc(1, player));
               kiProtectOn = !PlyrSettingsB((EntityPlayer)player, 10);
               defense = SklLvl(11, (String[])ps);
               if (kiProtectOn) {
                  kiProtection = (int)((double)defense * 0.005D * (double)dbcAO * (double)release * 0.01D);
                  if (kiProtection < 1) {
                     kiProtection = 1;
                  }

                  kiProtection = (int)((double)kiProtection * DBCConfig.cnfKDd);
                  float damage = (float)dbcA / 3.0F / (float)(dbcA + "").length();
                  if (damage < 1.0F) {
                     damage = 1.0F;
                  }

                  kiProtectionCost = (int)((double)defense * (double)release * 0.01D * (double)damage);
                  if (kiProtectionCost < 1) {
                     kiProtectionCost = 1;
                  }

                  kiProtectionCost = (int)((double)kiProtectionCost * DBCConfig.cnfKDc);
               }

               def += kiProtection;
            } else if (pwr_cha(powerType)) {
               staminaCost = SklLvl(0, 2, ps);
               defensePenetration = SklLvlY(2, getString(player, "jrmcSSltY"));
               def = stat(player, 1, powerType, 1, DEX, race, classID, (float)staminaCost * 0.04F + (float)state * 0.25F);
               def = (int)((double)(def * release) * 0.01D);
               if (classID == 2) {
                  String StE = nbt.func_74779_i("jrmcStatusEff");
                  if (StusEfcts(16, StE)) {
                     defense = PlyrAttrbts[3];
                     defensePen2 = stat(player, 3, powerType, 5, defense, race, classID, 0.0F);
                     def += (int)((double)defensePen2 * 0.25D * (double)release * 0.01D);
                  }
               }
            } else if (pwr_sa(powerType)) {
               def = 0;
            } else {
               def = stat(player, 1, powerType, 1, DEX, race, classID, 0.0F);
            }

            staminaCost = (int)((float)(def - kiProtection) * 0.05F);
            if (block && currStamina >= staminaCost) {
               defensePenetration = (int)(Math.random() * 2.0D) + 1;
               player.field_70170_p.func_72956_a(player, "jinryuudragonbc:DBC4.block" + defensePenetration, 0.5F, 0.9F / (player.field_70170_p.field_73012_v.nextFloat() * 0.6F + 0.9F));
               if (!isInCreativeMode(player)) {
                  setInt(currStamina - staminaCost < 0 ? 0 : currStamina - staminaCost, player, "jrmcStamina");
               }
            } else {
               def = (int)((float)((def - kiProtection) * JRMCoreConfig.StatPasDef) * 0.01F) + kiProtection;
            }

            if (currEnergy >= kiProtectionCost) {
               if (!isInCreativeMode(player)) {
                  setInt(currEnergy - kiProtectionCost < 0 ? 0 : currEnergy - kiProtectionCost, player, "jrmcEnrgy");
               }
            } else {
               def -= kiProtection;
            }

            if (JRMCoreConfig.DebugInfo || difp.length() > 0 && player.func_70005_c_().equalsIgnoreCase(difp)) {
               mod_JRMCore.logger.info(player.func_70005_c_() + " receives Damage: Original=" + dbcA);
            }

            defensePenetration = 0;
            if (s != null && dse) {
               String[] ops = PlyrSkills((EntityPlayer)s.func_76346_g());
               defensePenetration = SklLvl(14, 1, ops);
            } else if (s != null && s.func_76346_g() instanceof EntityLivingBase) {
               defensePenetration = 10;
            }

            dbcAO = dbcA;
            defense = lf ? 0 : def;
            defensePen2 = (int)((float)(defense * defensePenetration) * 0.01F);
            double e = (double)(1.0F - 0.03F * (float)t);
            String ss = "A=" + defense + (defensePen2 > 0 ? "-" + defensePenetration + "%" : "") + ", SEM=" + (1.0F - 0.03F * (float)t);
            dbcA = (int)((double)(dbcA - (defense - defensePen2)) * e);
            dbcA = dbcA < 1 ? 1 : dbcA;
            if ((double)((float)(dbcAO * defensePenetration) * 0.01F) * e > (double)dbcA) {
               dbcA = (int)((double)((float)(dbcAO * defensePenetration) * 0.01F) * e);
            }

            dbcA = (int)((double)dbcA / per);
            if (JRMCoreConfig.DebugInfo || difp.length() > 0 && player.func_70005_c_().equalsIgnoreCase(difp)) {
               mod_JRMCore.logger.info(player.func_70005_c_() + " DM: A=" + dbcA + ", DF Div:" + per + ", " + ss);
            }

            if (DBC()) {
               ItemStack stackbody = ExtendedPlayer.get(player).inventory.func_70301_a(1);
               ItemStack stackhead = ExtendedPlayer.get(player).inventory.func_70301_a(2);
               if (stackbody != null) {
                  stackbody.func_77972_a(1, player);
               }

               if (stackhead != null) {
                  stackhead.func_77972_a(1, player);
               }
            }

            int curBody = getInt(player, "jrmcBdy");
            int all = curBody - dbcA;
            int set = all < 0 ? 0 : all;
            if (dse) {
               boolean friendlyFist = PlyrSettingsB((EntityPlayer)((EntityPlayer)s.func_76346_g()), 12);
               if (friendlyFist && !s.func_76355_l().equals("MajinAbsorption") && !s.func_76346_g().equals(Player)) {
                  int ko = getInt(player, "jrmcHar4va");
                  set = all < 20 ? 20 : all;
                  if (ko <= 0 && set == 20) {
                     setInt((int)6, player, "jrmcHar4va");
                     setByte(race == 4 ? (state < 4 ? state : 4) : 0, player, "jrmcState");
                     setByte((int)0, player, "jrmcState2");
                     setByte((int)0, player, "jrmcRelease");
                     setInt((int)0, player, "jrmcStamina");
                     StusEfcts(19, ste, (EntityPlayer)player, false);
                  }

                  dbcA -= all;
               }
            }

            if (!isInCreativeMode(player)) {
               setInt(set, player, "jrmcBdy");
            }
         }
      }

      return dbcA;
   }

   public static void jrmcExp(Entity shootingEntity, int e) {
      jrmcExp(shootingEntity, e, -1);
   }

   public static void jrmcExp(Entity shootingEntity, int e, int expGainMode) {
      if (shootingEntity != null && !shootingEntity.field_70170_p.field_72995_K && shootingEntity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)shootingEntity;
         Random rand = new Random();
         MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
         int groundID = getInt(player, "JRMCGID");
         if (server.func_71213_z() != null && server.func_71213_z().length > 0) {
            int membersCount = 0;

            int tpGain;
            for(int pl = 0; pl < server.func_71213_z().length; ++pl) {
               EntityPlayerMP en = getPlayerForUsername(server, server.func_71213_z()[pl]);
               tpGain = getInt(en, "JRMCGID");
               if (tpGain == groundID) {
                  ++membersCount;
               }
            }

            JGPlayerMP jgPlayer = new JGPlayerMP(player);
            jgPlayer.connectBaseNBT();
            int race = jgPlayer.getRace();
            tpGain = expGainMode == -1 ? JRMCoreConfig.tpgn : JRMCoreConfig.getTPGainEnergy(expGainMode);
            tpGain = (int)((float)tpGain * JRMCoreConfig.TPGainRace[race]);
            int tp;
            if (membersCount > 0 && e >= membersCount && groundID != 0) {
               int var10000 = e / membersCount;

               for(int pl = 0; pl < server.func_71213_z().length; ++pl) {
                  EntityPlayerMP en = getPlayerForUsername(server, server.func_71213_z()[pl]);
                  tp = getInt(en, "JRMCGID");
                  String elid = getString(en, "JRMCGLIDs");
                  if (tp == groundID) {
                     int release = getByte(en, "jrmcRelease");
                     if (release >= 5) {
                        int rc = getByte(en, "jrmcRace");
                        int st = getByte(en, "jrmcState");
                        int tp = getInt(en, "jrmcTpint");
                        byte d = getByte(en, "jrmcDiff");
                        int t = expgnrt(rc, st, d, en);
                        t = (int)((float)t - (float)membersCount * 2.0F);
                        int randomInt = rand.nextInt(100);
                        if (randomInt < t) {
                           int result = tp + tpGain * e;
                           if (result > getMaxTP()) {
                              result = getMaxTP();
                           }

                           setInt((int)result, en, "jrmcTpint");
                        }

                        if (elid.equalsIgnoreCase(en.func_70005_c_())) {
                        }
                     }
                  }
               }
            } else {
               int release = getByte(player, "jrmcRelease");
               if (release >= 5) {
                  int rc = getByte(player, "jrmcRace");
                  int st = getByte(player, "jrmcState");
                  tp = getInt(player, "jrmcTpint");
                  byte d = getByte(player, "jrmcDiff");
                  int t = expgnrt(rc, st, d, player);
                  int randomInt = rand.nextInt(100);
                  if (randomInt < t) {
                     int result = tp + tpGain * e;
                     if (result > getMaxTP()) {
                        result = getMaxTP();
                     }

                     setInt(result, player, "jrmcTpint");
                  }
               }
            }
         }
      }

   }

   public static int expgnrt(int rc, int st, int d, EntityPlayer p) {
      float w = 1.0F;
      if (DBC()) {
         Side side = FMLCommonHandler.instance().getEffectiveSide();
         if (side == Side.SERVER) {
            float lastGravity = getFloat(p, "jrmcGravForce");
            lastGravity = JRMCoreHDBC.gravity(p, lastGravity);
            int[] PlyrAttrbts = PlyrAttrbts(p);
            float IWeight = weightExtra(PlyrAttrbts, lastGravity, p);
            w = weightPerc(PlyrAttrbts, 1, IWeight, p);
         } else {
            boolean c = StusEfctsMe(10) || StusEfctsMe(11);
            w = weightPerc(JRMCoreH.PlyrAttrbts, 1, WeightOn, c);
         }
      }

      int rt = (rc != 0 && rc != 3 ? (rc == 4 && st < 4 ? (st + 1) * 4 : 20) : 25) + d * 5;
      return (int)((float)rt + 32.0F * (1.0F - w) * 0.5F);
   }

   public static String techSnds(int t, int st, int sn) {
      String s = "";

      try {
         if (t == 0 || t == 1 || t == 5 || t == 4 || t == 6 || t == 7 || t == 8) {
            if (st == 0) {
               s = "DBC4." + techSndIncBeam[sn];
            }

            if (st == 1) {
               s = "DBC4." + techSndFireBeam[sn];
            }

            if (st == 2) {
               s = "DBC4." + techSndMoveBeam[sn];
            }
         }

         if (t == 2) {
            if (st == 0) {
               s = "DBC4." + techSndIncDisk[sn];
            }

            if (st == 1) {
               s = "DBC4." + techSndFireDisk[sn];
            }

            if (st == 2) {
               s = "DBC4." + techSndMoveDisk[sn];
            }
         }

         if (t == 3 && st == 1) {
            s = "DBC4." + techSndFireLeser[sn];
         }

         if (t == 10) {
            if (st == 0 && sn >= 0) {
               s = techSndPMInc[sn];
            }

            if (st == 1 && sn >= 0) {
               s = techSndPMFire[sn];
            }

            if (st == 2 && sn >= 0) {
               s = techSndPMMove[sn];
            }

            if (st == 3 && sn >= 0) {
               s = techSndPMIncFire[sn];
            }
         }
      } catch (Exception var5) {
         if (t == 0 || t == 1 || t == 5 || t == 4 || t == 6 || t == 7 || t == 8) {
            if (st == 0) {
               s = "DBC4." + techSndIncBeam[0];
            }

            if (st == 1) {
               s = "DBC4." + techSndFireBeam[0];
            }

            if (st == 2) {
               s = "DBC4." + techSndMoveBeam[0];
            }
         }

         if (t == 2) {
            if (st == 0) {
               s = "DBC4." + techSndIncDisk[0];
            }

            if (st == 1) {
               s = "DBC4." + techSndFireDisk[0];
            }

            if (st == 2) {
               s = "DBC4." + techSndMoveDisk[0];
            }
         }

         if (t == 3 && st == 1) {
            s = "DBC4." + techSndFireLeser[0];
         }

         if (t == 10) {
            if (st == 0 && sn >= 0) {
               s = techSndPMInc[0];
            }

            if (st == 1 && sn >= 0) {
               s = techSndPMFire[0];
            }

            if (st == 2 && sn >= 0) {
               s = techSndPMMove[0];
            }

            if (st == 3 && sn >= 0) {
               s = techSndPMIncFire[0];
            }
         }
      }

      return s;
   }

   public static void KAsounds(Entity m, int selc) {
      PD.sendToServer(new DBCPduo(selc + 1, m.func_145782_y()));
   }

   public static void quad(int i, int j, int k, int l) {
      PD.sendToServer(new JRMCorePQuad(i, j, k, l));
   }

   public static void quadI(int i, int j, int k, int l) {
      PD.sendToServer(new JRMCorePQuadI((byte)i, j, k, l));
   }

   public static String numSep(long c2, char s) {
      DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
      symbols.setGroupingSeparator(s);
      DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
      return formatter.format(c2);
   }

   public static String numSep(long c2) {
      return numSep(c2, ',');
   }

   public static String createString(BigInteger number) {
      Entry<BigInteger, String> entry = MAP.floorEntry(number);
      if (entry == null) {
         return "Nearly nothing";
      } else {
         BigInteger key = (BigInteger)entry.getKey();
         BigInteger d = key.divide(THOUSAND);
         BigInteger m = number.divide(d);
         float f = m.floatValue() / 1000.0F;
         float rounded = (float)((int)((double)f * 100.0D)) / 100.0F;
         return rounded % 1.0F == 0.0F ? (int)rounded + " " + (String)entry.getValue() : rounded + " " + (String)entry.getValue();
      }
   }

   public static void test(String numberString, String string) {
   }

   public static String numSepShort(long c2) {
      if (c2 > 100000000L) {
         BigInteger n = new BigInteger(c2 + "");
         return createString(n);
      } else {
         return numSep(c2);
      }
   }

   public static String numSepShort2(long c2) {
      return String.format("%,8d", c2);
   }

   public static int txt(String s, String c, int i, boolean b, int l, int t, int c2) {
      return txt(s, c, i, b, l, t, c2, 0, 0);
   }

   public static int txt(String s, String c, int i, boolean b, int l, int t, int c2, int c3, int c4) {
      if (c2 == 0) {
         c2 = 245;
      }

      s = s.replaceAll("/n", "\n");
      FontRenderer var8 = JRMCoreClient.mc.field_71466_p;
      List lt = var8.func_78271_c(s, c2);
      Iterator iterator = lt.iterator();
      int i2 = 0;
      int i3 = 0;

      for(byte j = 10; iterator.hasNext(); ++i2) {
         String s1 = (String)iterator.next();
         if (b && c3 <= i2 && lt.size() - c4 > i2) {
            if (i != 0 && i2 == 0) {
               i3 = i;
            }

            var8.func_78276_b(c + s1, l, t + i2 * j + i3, 0);
         }
      }

      i2 = (int)((float)i2 + round((float)i * 0.1F, 0));
      return i2;
   }

   public static int txtH(String s, String c, int i, boolean b, int l, int t, int c2, List n) {
      return txtH(s, c, i, b, l, t, c2, 0, 0, n);
   }

   public static int txtH(String s, String c, int i, boolean b, int l, int t, int c2, int c3, int c4, List n) {
      if (c2 == 0) {
         c2 = 245;
      }

      s = s.replaceAll("/n", "\n");
      FontRenderer var8 = JRMCoreClient.mc.field_71466_p;
      List lt = var8.func_78271_c(s, c2);
      Iterator iterator = lt.iterator();
      int i2 = 0;
      int i3 = 0;

      for(byte j = 10; iterator.hasNext(); ++i2) {
         String s1 = (String)iterator.next();
         if (b && c3 <= i2 && c4 > i2) {
            if (i != 0 && i2 == 0) {
               i3 = i;
            }

            Matcher matcher = JRMCoreHC.paturl.matcher(s1);
            if (matcher.find()) {
               int matchStart = matcher.start(1);
               int matchEnd = matcher.end();
               JRMCoreGuiScreen.urlToOpen = matcher.group();
               int jw = var8.func_78256_a(s1);
               n.add(new JRMCoreGuiButtons01(198, l, t + i2 * j + i3, jw, s1, techCol[1]));
            }

            var8.func_78276_b(c + s1, l, t + i2 * j + i3, 0);
         }
      }

      i2 = (int)((float)i2 + round((float)i * 0.1F, 0));
      return i2;
   }

   public static void tpalgn(EntityPlayer Player, int tp, int algn) {
      MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
      int gid = getInt(Player, "JRMCGID");
      int saga = getInt(Player, "DBCSagaSys");
      int i;
      if (gid == 0) {
         setByte(algn, Player, "jrmcAlign");
         i = getInt(Player, "jrmcTpint") + tp;
         setInt(i > getMaxTP() ? getMaxTP() : i, Player, "jrmcTpint");
      } else if (server1.func_71213_z() != null && server1.func_71213_z().length > 0) {
         i = 0;

         int pl;
         EntityPlayerMP en;
         int egid;
         int esaga;
         for(pl = 0; pl < server1.func_71213_z().length; ++pl) {
            en = getPlayerForUsername(server1, server1.func_71213_z()[pl]);
            egid = getInt(en, "JRMCGID");
            esaga = getInt(en, "DBCSagaSys");
            if (egid == gid && saga == esaga) {
               ++i;
               int a = getByte(en, "jrmcAlign");
               if (algn > a) {
                  setByte((int)(a + 5 > 100 ? 100 : a + 5), en, "jrmcAlign");
               }

               if (algn < a) {
                  setByte((int)(a - 5 < 0 ? 0 : a - 5), en, "jrmcAlign");
               }

               if (algn == a) {
                  setByte((int)a, en, "jrmcAlign");
               }
            }
         }

         tp = tp / i == 0 ? 1 : tp / i;

         for(pl = 0; pl < server1.func_71213_z().length; ++pl) {
            en = getPlayerForUsername(server1, server1.func_71213_z()[pl]);
            egid = getInt(en, "JRMCGID");
            esaga = getInt(en, "DBCSagaSys");
            if (egid == gid && saga == esaga) {
               int tp1 = getInt(en, "jrmcTpint") + tp;
               setInt((int)(tp1 > getMaxTP() ? getMaxTP() : tp1), en, "jrmcTpint");
            }
         }
      }

   }

   public static int ctb(int num, int b) {
      int iResult = num % b;

      for(int iMultiplier = 10; (num /= b) > 0; iMultiplier *= 10) {
         iResult += num % b * iMultiplier;
      }

      return iResult;
   }

   public static int cfb(int s, int b) {
      int i = 0;

      for(int s2 = 0; s2 != s; ++i) {
         s2 = ctb(i, b);
      }

      return i - 1;
   }

   public static int letToNum(String s1, String s2) {
      int i1 = 0;
      int i2 = 0;
      int i = false;

      for(int f = 0; f < ltnb.length; ++f) {
         if (s1.equals(ltnb[f])) {
            i1 = f;
         }

         if (s2.equals(ltnb[f])) {
            i2 = f;
         }
      }

      int i = i1 * ltnb.length + i2;
      return i;
   }

   public static String numToLet(int i) {
      String s = "00";
      String s1 = "";
      String s2 = "";
      int i1 = i / ltnb.length;
      int i2 = i1 * ltnb.length;
      int i3 = i - i2;

      for(int f = 0; f < ltnb.length; ++f) {
         if (i1 == f) {
            s1 = ltnb[f];
         }

         if (i3 == f) {
            s2 = ltnb[f];
         }
      }

      s = s1 + s2;
      return s;
   }

   public static int letToNum5(String s1, String s2, String s3, String s4, String s5) {
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      int i = false;

      for(int f = 0; f < ltnb.length; ++f) {
         if (s1.equals(ltnb[f])) {
            i1 = f;
         }

         if (s2.equals(ltnb[f])) {
            i2 = f;
         }

         if (s3.equals(ltnb[f])) {
            i3 = f;
         }

         if (s4.equals(ltnb[f])) {
            i4 = f;
         }

         if (s5.equals(ltnb[f])) {
            i5 = f;
         }
      }

      int i = (((i1 * ltnb.length + i2) * ltnb.length + i3) * ltnb.length + i4) * ltnb.length + i5;
      return i;
   }

   public static String numToLet5(int i) {
      String s = "00";
      String s1 = "";
      String s2 = "";
      String s3 = "";
      String s4 = "";
      String s5 = "";
      int i11 = i / ltnb.length;
      int i12 = i11 * ltnb.length;
      int i13 = i - i12;
      int i21 = i11 / ltnb.length;
      int i22 = i21 * ltnb.length;
      int i23 = i11 - i22;
      int i31 = i21 / ltnb.length;
      int i32 = i31 * ltnb.length;
      int i33 = i21 - i32;
      int i41 = i31 / ltnb.length;
      int i42 = i41 * ltnb.length;
      int i43 = i31 - i42;

      for(int f = 0; f < ltnb.length; ++f) {
         if (i41 == f) {
            s1 = ltnb[f];
         }

         if (i43 == f) {
            s2 = ltnb[f];
         }

         if (i33 == f) {
            s3 = ltnb[f];
         }

         if (i23 == f) {
            s4 = ltnb[f];
         }

         if (i13 == f) {
            s5 = ltnb[f];
         }
      }

      s = s1 + s2 + s3 + s4 + s5;
      return s;
   }

   public static boolean isn(String i) {
      return i.matches(".*\\d+.*");
   }

   public static boolean smnmlt(String i) {
      return i.replaceAll("\\D+", "").length() == i.replaceAll("\\d", "").length();
   }

   public static void wld(String stringValue, String nbtID, String fileName, boolean delete) {
      try {
         File file = new File(JRMCore.configDir, fileName);
         NBTTagCompound nbttagcompound = new NBTTagCompound();
         if (!file.exists()) {
            file.createNewFile();
         } else {
            nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
         }

         if (delete) {
            nbttagcompound.func_82580_o(nbtID);
         } else {
            nbttagcompound.func_74778_a(nbtID, stringValue);
         }

         CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public static String rld(String id, String f) {
      String d = "";
      File file = new File(JRMCore.configDir, f);
      boolean var12 = false;

      NBTTagCompound nbttagcompound;
      label101: {
         try {
            var12 = true;
            if (!file.exists()) {
               file.createNewFile();
               nbttagcompound = new NBTTagCompound();
               CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
               var12 = false;
            } else {
               var12 = false;
            }
            break label101;
         } catch (IOException var16) {
            var16.printStackTrace();
            var12 = false;
         } finally {
            if (var12) {
               try {
                  NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                  if (nbttagcompound.func_74764_b(id)) {
                     nbttagcompound.func_74779_i(id);
                  } else {
                     d = "0";
                  }
               } catch (IOException var13) {
                  var13.printStackTrace();
               }

            }
         }

         try {
            nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
            if (nbttagcompound.func_74764_b(id)) {
               d = nbttagcompound.func_74779_i(id);
            } else {
               d = "0";
            }

            return d;
         } catch (IOException var14) {
            var14.printStackTrace();
            return d;
         }
      }

      try {
         nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
         if (nbttagcompound.func_74764_b(id)) {
            d = nbttagcompound.func_74779_i(id);
         } else {
            d = "0";
         }
      } catch (IOException var15) {
         var15.printStackTrace();
      }

      return d;
   }

   public static void wd(MinecraftServer server, String d, String id, String fd, String f, boolean b) {
      try {
         File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
         NBTTagCompound nbttagcompound = new NBTTagCompound();
         if (!file.exists()) {
            file.createNewFile();
         } else {
            nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
         }

         if (b) {
            nbttagcompound.func_82580_o(id);
         } else {
            nbttagcompound.func_74778_a(id, d);
         }

         CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
      } catch (Exception var8) {
      }

   }

   public static void wd(MinecraftServer server, String fd, String f) {
      try {
         File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
         NBTTagCompound nbttagcompound = new NBTTagCompound();
         if (!file.exists()) {
            file.createNewFile();
         }

         CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
      } catch (Exception var5) {
      }

   }

   public static String rd(MinecraftServer server, String id, String fd, String f) {
      String d = "";
      if (server != null && server.field_71305_c.length > 0 && server.func_71218_a(0) != null && server.func_71218_a(0).getChunkSaveLocation() != null) {
         File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
         boolean var14 = false;

         NBTTagCompound nbttagcompound;
         label117: {
            try {
               var14 = true;
               if (!file.exists()) {
                  file.createNewFile();
                  nbttagcompound = new NBTTagCompound();
                  CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                  var14 = false;
               } else {
                  var14 = false;
               }
               break label117;
            } catch (IOException var18) {
               var14 = false;
            } finally {
               if (var14) {
                  try {
                     NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                     if (nbttagcompound.func_74764_b(id)) {
                        nbttagcompound.func_74779_i(id);
                     } else {
                        d = "0";
                     }
                  } catch (IOException var15) {
                  }

               }
            }

            try {
               nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
               if (nbttagcompound.func_74764_b(id)) {
                  d = nbttagcompound.func_74779_i(id);
               } else {
                  d = "0";
               }

               return d;
            } catch (IOException var16) {
               return d;
            }
         }

         try {
            nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
            if (nbttagcompound.func_74764_b(id)) {
               d = nbttagcompound.func_74779_i(id);
            } else {
               d = "0";
            }
         } catch (IOException var17) {
         }
      }

      return d;
   }

   public static int lbs(String[] s, int i, FontRenderer fr, int gl, int gt) {
      return lbs(s, i, fr, gl, gt, 245, "§0");
   }

   public static int lbs(String[] s, int i, FontRenderer fr, int gl, int gt, int w, String c) {
      for(int i1 = 0; i1 < s.length; ++i1) {
         for(Iterator iterator = fr.func_78271_c(s[i1], 245).iterator(); iterator.hasNext(); ++i) {
            String s1 = (String)iterator.next();
            fr.func_78276_b(c + s1, gl + 6, gt + 5 + i * 10, 0);
         }
      }

      return i;
   }

   public static ExplosionJRMC newExpl(World worldObj, Entity entity, double par2, double par4, double par6, float par8, boolean par9, double dam, Entity origin, byte type) {
      ExplosionJRMC var10 = new ExplosionJRMC(worldObj, entity, par2, par4, par6, par8, JRMCoreConfig.expGriOff, dam, origin, type);
      var10.field_77286_a = par9;
      var10.func_77278_a();
      var10.func_77279_a(true);
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         Iterator var12 = worldObj.field_73010_i.iterator();

         while(var12.hasNext()) {
            EntityPlayer var13 = (EntityPlayer)var12.next();
            if (var13.func_70092_e(par2, par4, par6) < 4096.0D) {
               expCliPack(var13, par2, par4, par6, par8, var10.field_77281_g, (Vec3)var10.func_77277_b().get((EntityPlayerMP)var13), JRMCoreConfig.expGriOff, dam, origin, type);
            }
         }
      }

      return var10;
   }

   public static int F5CsTH(String l) {
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

   public static int rtXq4V(boolean n) {
      return checkLimit();
   }

   public static int checkLimit() {
      int b = JRMCoreConfig.tmx;
      String r = "64";
      String k = "3B9ACA00";
      return b > F5CsTH(k) ? F5CsTH(k) : (b < F5CsTH(r) ? 0 : b);
   }

   public static int etXq4V(int b) {
      String k = "3B9ACA00";
      return b > F5CsTH(k) ? F5CsTH(k) : b;
   }

   public static void expCliPack(Entity player, double par1, double par3, double par5, float par7, List par8List, Vec3 par9Vec3, boolean expGriOff, double dam, Entity origin, byte type) {
      explosionX = par1;
      explosionY = par3;
      explosionZ = par5;
      explosionSize = par7;
      JRMCoreConfig.expGriOff = expGriOff;
      expDam = dam;
      origin1 = origin;
      chunkPositionRecords = new ArrayList(par8List);
      if (par9Vec3 != null) {
         playerVelocityX = 0.0F;
         playerVelocityY = 0.0F;
         playerVelocityZ = 0.0F;
      }

      extype = type;
      if (player != null && origin != null) {
         PD.sendToDimension(new JRMCorePExpl(explosionX, explosionY, explosionZ, explosionSize, JRMCoreConfig.expGriOff, expDam, origin, chunkPositionRecords, playerVelocityX, playerVelocityY, playerVelocityZ, type), origin.field_71093_bK);
      }

   }

   public static String trlai(String s1, String s2) {
      s1 = (String)modAssetIDs.get(s1);
      return s1 + s2;
   }

   public static String trlai(String s1) {
      return s1;
   }

   public static String trlws(String s1, String s2) {
      s1 = (String)modAssetIDs.get(s1);
      return trl(s1 + s2);
   }

   public static String trl(String s1, String s2) {
      s1 = (String)modAssetIDs.get(s1);
      return trl(s1 + s2);
   }

   public static String trl(String s1) {
      return StatCollector.func_74838_a(s1);
   }

   public static String trl(String s1, String s2, Object... args) {
      return cct(trl(s1, s2), args);
   }

   public static String trl(String s1, Object... args) {
      return cct(trl(s1), args);
   }

   public static String cct(String s1, Object... args) {
      return (new ChatComponentTranslation(s1, args)).func_150260_c();
   }

   public static EntityPlayerMP getPlayerForUsername(MinecraftServer server, String s) {
      return server.func_71203_ab().func_152612_a(s);
   }

   public static Item getItemByText(String p_147179_1_) {
      Item item = (Item)Item.field_150901_e.func_82594_a(p_147179_1_);
      if (item == null) {
         try {
            Item item1 = Item.func_150899_d(Integer.parseInt(p_147179_1_));
            if (item1 != null) {
               ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("commands.generic.deprecatedId", new Object[]{Item.field_150901_e.func_148750_c(item1)});
               chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
            }

            item = item1;
         } catch (NumberFormatException var4) {
         }
      }

      return item;
   }

   public static int d(String s, int i) {
      return i == 3 ? ltn5(sa(s, 6), sa(s, 7), sa(s, 8), sa(s, 9), sa(s, 10)) : ltn(sa(s, i == 0 ? 0 : (i == 1 ? 2 : (i == 2 ? 4 : 11))), sa(s, i == 0 ? 1 : (i == 1 ? 3 : (i == 2 ? 5 : 12))));
   }

   public static String sa(String s1, int s2) {
      return s1.charAt(s2) + "";
   }

   public static int saI(String s1, int s2) {
      return Integer.parseInt(s1.charAt(s2) + "");
   }

   public static int ltn(String s1, String s2) {
      return letToNum(s1, s2);
   }

   public static int ltn5(String s1, String s2, String s3, String s4, String s5) {
      return letToNum5(s1, s2, s3, s4, s5);
   }

   private static String ntl(int i) {
      return numToLet(i);
   }

   private static String ntl5(int i) {
      return numToLet5(i);
   }

   public static int dnsRace(String s) {
      int i = 0;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsGender(String s) {
      int i = 2;
      return s != null && s.length() > i ? Integer.parseInt(sa(s, i)) : 0;
   }

   public static int dnsHairB(String s) {
      int i = 3;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 10;
   }

   public static int dnsHairF(String s) {
      int i = 5;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsHairC(String s) {
      int i = 7;
      return s != null && s.length() > i ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsBreast(String s) {
      int i = 12;
      return s != null && s.length() > i ? Integer.parseInt(sa(s, i)) : 0;
   }

   public static int dnsSkinT(String s) {
      int i = 13;
      return s != null && s.length() > i ? Integer.parseInt(sa(s, i)) : 0;
   }

   public static int dnsBodyT(String s) {
      int i = 14;
      return s != null && s.length() > i + 6 ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsBodyCM(String s) {
      int i = 16;
      return s != null && s.length() > i + 6 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsBodyC1(String s) {
      int i = 21;
      return s != null && s.length() > i + 6 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsBodyC2(String s) {
      int i = 26;
      return s != null && s.length() > i + 6 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsBodyC3(String s) {
      int i = 31;
      return s != null && s.length() > i + 6 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsFaceN(String s) {
      int i = 36;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsFaceM(String s) {
      int i = 38;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsEyes(String s) {
      int i = 40;
      return s != null && s.length() > i ? ltn(sa(s, i), sa(s, i + 1)) : 0;
   }

   public static int dnsEyeC1(String s) {
      int i = 42;
      return s != null && s.length() > i ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsEyeC2(String s) {
      int i = 47;
      return s != null && s.length() > i ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static int dnsBodyC1_0(String s) {
      int i = 14;
      return s != null && s.length() > i ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
   }

   public static String dnsGenderSet(String s, String w) {
      int i = 2;
      return s != null && s.length() > i ? s.substring(0, i) + w + s.substring(i + 1) : "0";
   }

   public static String dnsHairBSet(String s, int w) {
      int i = 3;
      return s != null && s.length() > i ? s.substring(0, i) + ntl(w) + s.substring(i + 2) : "0";
   }

   public static String dnsHairFSet(String s, int w) {
      int i = 5;
      return s != null && s.length() > i ? s.substring(0, i) + ntl(w) + s.substring(i + 2) : "0";
   }

   public static String dnsHairCSet(String s, int w) {
      int i = 7;
      return s != null && s.length() > i ? s.substring(0, i) + ntl5(w) + s.substring(i + 5) : "0";
   }

   public static int dnsHair1(String s, int n) {
      if (s != null && s.length() > n - 1) {
         int value = 0;

         try {
            value = Integer.parseInt(sa(s, n));
         } catch (Exception var4) {
         }

         return value;
      } else {
         return 0;
      }
   }

   public static int dnsHair2(String s, int n) {
      if (s != null && s.length() > n) {
         int value = 0;

         try {
            value = Integer.parseInt(sa(s, n) + sa(s, n + 1));
         } catch (Exception var4) {
         }

         return value;
      } else {
         return 0;
      }
   }

   public static String dnsHair1set(String s, int n, String w) {
      return s != null && s.length() > n - 1 ? s.substring(0, n) + w + s.substring(n + 1) : "0";
   }

   public static String dnsHair2set(String s, int n, String w) {
      return s != null && s.length() > n ? s.substring(0, n) + w + s.substring(n + 2) : "0";
   }

   public static float dnsHairG(String s) {
      return (float)(s.length() == 786 ? Integer.parseInt(sa(s, 784) + sa(s, 785)) : (s.length() == 392 ? 10 : 0)) * 0.1F;
   }

   public static String dnsHairG1toG2(String s) {
      String g2 = "";
      if (s.length() == 392) {
         for(int face = 0; face < 56; ++face) {
            int l = dnsHair1(s, face * 7) * 11 - 10;
            l = l < 0 ? 0 : l;
            int X = dnsHair2(s, face * 7 + 1);
            int Y = dnsHair2(s, face * 7 + 3);
            int Z = dnsHair2(s, face * 7 + 5);
            String L = "" + (l < 10 ? "0" + l : l);
            g2 = g2 + L + "" + X + "" + Y + "" + Z + "505000";
         }

         g2 = g2 + "20";
      } else if (s.length() == 784) {
         g2 = s + "20";
      } else {
         g2 = s;
      }

      return g2;
   }

   public static int dnsauCM(String s) {
      int i = 0;
      return s != null && s.length() > i + 4 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 14208118;
   }

   public static int dnsauC1(String s) {
      int i = 5;
      return s != null && s.length() > i + 4 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 10317733;
   }

   public static int dnsauC2(String s) {
      int i = 10;
      return s != null && s.length() > i + 4 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 6966676;
   }

   public static int dnsauC3(String s) {
      int i = 15;
      return s != null && s.length() > i + 4 ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 11045420;
   }

   public static void wwi(MinecraftServer server, String d, String rid, boolean b) {
      String wd = "/data";
      wd(server, d, rid + "", wd, wi, b);
   }

   public static String rwi(MinecraftServer server, String id) {
      String wd = "/data";
      return rd(server, id + "", wd, wi);
   }

   public static void bswwi(MinecraftServer server, String d, boolean b) {
      wwi(server, d, bs, b);
   }

   public static String bsrwi(MinecraftServer server) {
      return rwi(server, bs);
   }

   public static void wwip(MinecraftServer server, String d, String rid, boolean b) {
      String wd = "/data";
      wd(server, d, rid + "", wd, wip, b);
   }

   public static String rwip(MinecraftServer server, String id) {
      String wd = "/data";
      return rd(server, id + "", wd, wip);
   }

   public static void init() {
      modAssetIDs.put("nc", tjnc + ".");
      modAssetIDs.put("dbc", tjdbc + ".");
      modAssetIDs.put("fc", tjfc + ".");
      modAssetIDs.put("yc", tjyc + ".");
      modAssetIDs.put("jrmc", tjrmc + ".");
      modAssetIDs.put("saoc", tjsaoc + ".");
      modAssetIDs.put("bc", tjbc + ".");
   }

   public static void addItemWeightStats(ItemStack p_92115_1_, Object... args) {
      NBTTagList nbttaglist = ItemWeightStatsNBTTag(p_92115_1_);

      for(int i = 0; i < nbttaglist.func_74745_c(); ++i) {
         NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(i);
         if (nbttagcompound.func_74760_g("weight") == 0.0F) {
            return;
         }
      }

      NBTTagCompound nbttagcompound1 = new NBTTagCompound();
      nbttagcompound1.func_74776_a("weight", Float.parseFloat("" + args[0]));
      nbttaglist.func_74742_a(nbttagcompound1);
      if (!p_92115_1_.func_77942_o()) {
         p_92115_1_.func_77982_d(new NBTTagCompound());
      }

      p_92115_1_.func_77978_p().func_74782_a("DBCItemWeightStats", nbttaglist);
   }

   public static NBTTagList ItemWeightStatsNBTTag(ItemStack p_92110_1_) {
      return p_92110_1_.field_77990_d != null && p_92110_1_.field_77990_d.func_74764_b("DBCItemWeightStats") ? (NBTTagList)p_92110_1_.field_77990_d.func_74781_a("DBCItemWeightStats") : new NBTTagList();
   }

   public static float getItemWeight(ItemStack is) {
      NBTTagList nbttaglist = ItemWeightStatsNBTTag(is);
      if (nbttaglist != null) {
         int i = 0;
         if (i < nbttaglist.func_74745_c()) {
            float weight = nbttaglist.func_150305_b(i).func_74760_g("weight");
            return weight;
         }
      }

      return 0.0F;
   }

   public static String ItemWeightOn(ItemStack itemStack) {
      return itemStack != null && DBC() ? JRMCoreHDBC.ItemWeightOn(itemStack) + "," + itemStack.func_77960_j() : "-1,0";
   }

   public static void log(String d) {
      System.out.println(d);
   }

   public static void log(int d) {
      log("" + d);
   }

   public static void log(double d) {
      log("" + d);
   }

   public static void log(long d) {
      log("" + d);
   }

   public static void log(float d) {
      log("" + d);
   }

   public static void log(short d) {
      log("" + d);
   }

   public static void log(byte d) {
      log("" + d);
   }

   public static EntityPlayer getClosestPlayerToEntity(Entity p_72890_1_, double p_72890_2_) {
      return getClosestPlayer(p_72890_1_, p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
   }

   public static EntityPlayer getClosestPlayer(Entity p_72890_1_, double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
      double d4 = -1.0D;
      EntityPlayer entityplayer = null;

      for(int i = 0; i < p_72890_1_.field_70170_p.field_73010_i.size(); ++i) {
         EntityPlayer entityplayer1 = (EntityPlayer)p_72890_1_.field_70170_p.field_73010_i.get(i);
         if (!p_72890_1_.equals(entityplayer1)) {
            double d5 = entityplayer1.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
            if ((p_72977_7_ < 0.0D || d5 < p_72977_7_ * p_72977_7_) && (d4 == -1.0D || d5 < d4)) {
               d4 = d5;
               entityplayer = entityplayer1;
            }
         }
      }

      return entityplayer;
   }

   public static String turihr(String u) {
      return turih.get(u) != null ? (String)turih.get(u) : "";
   }

   public static void tur(final String u) {
      turih.put(u, "loading");
      Thread one = new Thread() {
         public void run() {
            String rvf = u;
            String line = null;
            String lines = "";
            int empty = false;
            int count = false;
            StringBuilder content = new StringBuilder();

            try {
               URL url = new URL(u);
               InputStreamReader isr = new InputStreamReader(url.openStream());
               BufferedReader reader = new BufferedReader(isr);

               while((line = reader.readLine()) != null) {
                  content.append(line);
               }

               JRMCoreH.turih.put(u, content.toString());
               reader.close();
               isr.close();
            } catch (Exception var10) {
               JRMCoreH.turih.put(u, "error");
            }

            this.interrupt();
         }
      };
      one.start();
   }

   public static boolean updateEveryXTick(int tick, int updateTick) {
      if (updateTick == 1) {
         return true;
      } else {
         int tickMod = tick / updateTick * updateTick;
         return tick == (tickMod == 0 ? updateTick : tickMod);
      }
   }

   public static boolean isInCreativeMode(Entity player) {
      return player instanceof EntityPlayer ? ((EntityPlayer)player).field_71075_bZ.field_75098_d : false;
   }

   public static void playerUsedInstantTransmission(EntityPlayer entity) {
      if (entity != null) {
         jrmctAll(50, entity.func_145782_y() + ";" + entity.field_70165_t + ";" + entity.field_70163_u + ";" + entity.field_70161_v);
      }

   }

   public static int getMajinFormID(int state, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      return isMysticOn ? 5 : (isUltraInstinctOn ? 6 : (isGoDOn ? 7 : state));
   }

   public static int getArcosianFormID(int state, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
      return isMysticOn ? 8 : (isUltraInstinctOn ? 9 : (isGoDOn ? 10 : state));
   }

   public static void clearEmptyFamiliesNBTData(MinecraftServer server) {
      if (JFC()) {
         if (!familyCEmptyFamiliesCleared) {
            String emptyFamily = ",0!l,e!0";
            String emptyFamilyNew = "EMPTY";
            String f = FamilyCH.fif;
            String fd = "/data";
            if (server != null && server.field_71305_c.length > 0 && server.func_71218_a(0) != null && server.func_71218_a(0).getChunkSaveLocation() != null) {
               File file = new File(server.func_71218_a(0).getChunkSaveLocation() + "/data", f);
               boolean var28 = false;

               int deletedFamilies;
               NBTTagCompound nbttagcompound;
               String content;
               String[] families;
               int length;
               int i;
               String[] familyValues;
               boolean hasIt;
               label356: {
                  try {
                     var28 = true;
                     if (!file.exists()) {
                        file.createNewFile();
                        NBTTagCompound nbttagcompound = new NBTTagCompound();
                        CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                        var28 = false;
                     } else {
                        var28 = false;
                     }
                     break label356;
                  } catch (IOException var32) {
                     var28 = false;
                  } finally {
                     if (var28) {
                        try {
                           int deletedFamilies = 0;
                           NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                           String content = nbttagcompound.toString().replace(":\"", "");
                           String[] families = content.split("\",");
                           if (families != null && families.length > 0) {
                              int length = families.length;
                              families[0] = families[0].substring(1);
                              families[length - 1] = families[length - 1].substring(families[length - 1].length()) + "";

                              for(int i = 0; i < length; ++i) {
                                 families[i] = families[i].replace(",0!l,e!0", ",EMPTY");
                                 String[] familyValues = families[i].split(",");
                                 boolean hasIt = familyValues != null && familyValues.length > 2 && familyValues[2].equals("EMPTY") && nbttagcompound.func_74764_b(familyValues[0] + ",0");
                                 if (hasIt) {
                                    nbttagcompound.func_82580_o(familyValues[0] + ",0");
                                    ++deletedFamilies;
                                 }
                              }
                           }

                           familyCEmptyFamiliesCleared = true;
                           previousServerFolder = server.func_71270_I();
                           log("Family C Removed Empty Families: " + deletedFamilies);
                           if (deletedFamilies > 0) {
                              CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                           }
                        } catch (IOException var29) {
                        }

                     }
                  }

                  try {
                     deletedFamilies = 0;
                     nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                     content = nbttagcompound.toString().replace(":\"", "");
                     families = content.split("\",");
                     if (families != null && families.length > 0) {
                        length = families.length;
                        families[0] = families[0].substring(1);
                        families[length - 1] = families[length - 1].substring(families[length - 1].length()) + "";

                        for(i = 0; i < length; ++i) {
                           families[i] = families[i].replace(",0!l,e!0", ",EMPTY");
                           familyValues = families[i].split(",");
                           hasIt = familyValues != null && familyValues.length > 2 && familyValues[2].equals("EMPTY") && nbttagcompound.func_74764_b(familyValues[0] + ",0");
                           if (hasIt) {
                              nbttagcompound.func_82580_o(familyValues[0] + ",0");
                              ++deletedFamilies;
                           }
                        }
                     }

                     familyCEmptyFamiliesCleared = true;
                     previousServerFolder = server.func_71270_I();
                     log("Family C Removed Empty Families: " + deletedFamilies);
                     if (deletedFamilies > 0) {
                        CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                        return;
                     }
                  } catch (IOException var30) {
                  }

                  return;
               }

               try {
                  deletedFamilies = 0;
                  nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                  content = nbttagcompound.toString().replace(":\"", "");
                  families = content.split("\",");
                  if (families != null && families.length > 0) {
                     length = families.length;
                     families[0] = families[0].substring(1);
                     families[length - 1] = families[length - 1].substring(families[length - 1].length()) + "";

                     for(i = 0; i < length; ++i) {
                        families[i] = families[i].replace(",0!l,e!0", ",EMPTY");
                        familyValues = families[i].split(",");
                        hasIt = familyValues != null && familyValues.length > 2 && familyValues[2].equals("EMPTY") && nbttagcompound.func_74764_b(familyValues[0] + ",0");
                        if (hasIt) {
                           nbttagcompound.func_82580_o(familyValues[0] + ",0");
                           ++deletedFamilies;
                        }
                     }
                  }

                  familyCEmptyFamiliesCleared = true;
                  previousServerFolder = server.func_71270_I();
                  log("Family C Removed Empty Families: " + deletedFamilies);
                  if (deletedFamilies > 0) {
                     CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                  }
               } catch (IOException var31) {
               }
            }
         } else if (server != null && server.func_71270_I() != null && !server.func_71270_I().equals(previousServerFolder)) {
            familyCEmptyFamiliesCleared = false;
         }
      } else {
         familyCEmptyFamiliesCleared = true;
      }

   }

   public static NBTTagCompound readNBTFile(MinecraftServer server, String fileDirectory, String fileName) {
      if (server != null && server.field_71305_c.length > 0 && server.func_71218_a(0) != null && server.func_71218_a(0).getChunkSaveLocation() != null) {
         File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fileDirectory, fileName);
         boolean var12 = false;

         NBTTagCompound nbttagcompound;
         label85: {
            try {
               var12 = true;
               if (!file.exists()) {
                  file.createNewFile();
                  nbttagcompound = new NBTTagCompound();
                  CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
                  var12 = false;
               } else {
                  var12 = false;
               }
               break label85;
            } catch (IOException var16) {
               var12 = false;
            } finally {
               if (var12) {
                  try {
                     NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                     return nbttagcompound;
                  } catch (IOException var13) {
                  }
               }
            }

            try {
               nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
               return nbttagcompound;
            } catch (IOException var14) {
               return null;
            }
         }

         try {
            nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
            return nbttagcompound;
         } catch (IOException var15) {
         }
      }

      return null;
   }

   public static String getDataFromNBT(String id, NBTTagCompound nbttagcompound) {
      return nbttagcompound.func_74764_b(id) ? nbttagcompound.func_74779_i(id) : "0";
   }

   static {
      RACES = Races.length;
      RaceAllow = new String[]{"All", "DBC", "DBC", "DBC", "DBC", "DBC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC"};
      RaceCanHaveHair = new String[]{"H", "H", "H", "A", "R", "H", "H", "H", "H", "H", "H", "H", "H", "H"};
      RaceCanHavePwr = new String[]{"0123", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012"};
      RaceCustomSkin = new int[]{2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2};
      RaceHairColor = new int[]{-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
      RaceGenders = new int[]{2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
      Specials = new int[]{1, 4, 4, 3, 3, 5, 5, 4, 1, 3, 4, 4, 3, 1};
      skinTyps = new String[]{"DefaultSkin", "CustomSkin"};
      defbodycols = new int[][][]{{{16297621, 6498048}, {16297621, 6498048}, {16297621, 6498048}, {5095183, 13796998, 12854822}, {15460342, 16111595, 8533141, 16550015}, {16757199, 15766205}}, {{15979704, 6498048}, {15979704, 6498048}, {15979704, 6498048}, {4566029, 14191242, 14363435}, {15460342, 15188457, 287340, 16550015}, {16752073, 16028862}}, {{13014656, 6498048}, {13014656, 6498048}, {13014656, 6498048}, {4896782, 12875121, 12920870}, {15460342, 10442657, 3625381, 13125463}, {16483508, 15825582}}, {{12622942, 6498048}, {12622942, 6498048}, {12622942, 6498048}, {0}, {0}, {14383492, 13987449}}, {{10112303, 6498048}, {10112303, 6498048}, {10112303, 6498048}, {0}, {0}, {11433702, 10776284}}, {{7225375, 6498048}, {7225375, 6498048}, {7225375, 6498048}, {0}, {0}, {7907292, 7578067}}, {{3677711, 6498048}, {3677711, 6498048}, {3677711, 6498048}, {0}, {0}, {7916929, 7652472}}};
      defeyecols = new int[][]{{1, 1, 1, 1, 14617612, 14551628}, {4896782, 1, 4896782, 4896782, 1, 8235495}, {14617612, 1, 14617612, 14617612, 4896782, 16777215}};
      customSknLimits = new int[][]{{1, 1, 5, 5, 6, 2}, {1, 1, 5, 5, 6, 0}, {1, 2, 5, 5, 6, 2}, {3, 3, 5, 5, 3, 2}, {3, 4, 5, 6, 2, 2}, {1, 1, 5, 5, 6, 2}};
      customSknLimitsBCP = new int[]{7, 7, 7, 3, 3, 7};
      defHairPrsts = new String[]{"345050555050801250505550501901505055505080235050455050803450505550508001505055505080015050555050802350505550508034505055505080125050555050800150505550508023505055505080015050555050800150505550506712505045505080015050455050800150504550508023505045505080345050455050801250504550508001505045505080235050455050800150504550508001505045505061015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050630155505050506701555050505061015550505050671170505050503814705050505041147050505050411770505050503817705050505041207050505050412070505050504117705050505041227050505050412570505050504125705050505041207050505050412070505050503225705050505041257050505050412270505050503420", "18080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080804808080180808018080801808080180808018080804808080180808018080801808080180808018080801808080180808018080801808080180808028080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080", "33843554384754461805224154501455050143505014550501435050143505014350501435050050505505050550505055145505014350501455050145505014550501455050145505005050450505045050504515050501505050150505015050501475049147504914750501475050152505015250501525050152505005550501475050147505005550503631847363184726318522631850267194727218502701850270185027019501701850270185027018501505050150505015050501505050", "08080180181919019191901819190505055050505505050550505055050505505050550505055050505505050550505055050504505050450505045050504505050450505045050504505050450505045050504505550504785050478505005550500555050474505047450500555050055505047150504715050055505005550500555050055505005550500325050425505042550500345050030505042350504235050038505003450504215050421505003450500695050419505041950500285050", "225067556150391150675561502311503245615023205032456150361750505450507117505054505071175050545050711750505450507101505054505071025050545050710150505450507100505054505071005050545050710050505450507122505045505071225050455050722250504550507222505045505072015050455050720150504550507201505045505072005050455050720050504550507200505045505072225445505050712254475050507122545250505071225454505050710154455050507101544950505071015450505050710154545050507100545050505071005450505050710054505050507100545050505071005450505050710054505050507100545050505071005450505050712850505650507465505074801930655050251819303750504550507437505056505074685050748018326850502519183234505045505074345050565050746850507480183868505025181838345050455050743450505650507480505074801843805050251819433450504550507420", "025050545050210250505450501801505045505021025050475050180147507467503248505072675043255250726750360150505667501922475071675038255050716750380152507167503202475071675032025250716750300050507167503000505047655036205250276550362250502765503620475027655036225250306550363150503065503622475030655034015250276550250147502765503000505027655036175050505050803150505050508028505050505080225050505050801750505050508022505050505080255050505050801750505050508000505050505080005050505050800050505050508000505050505080005050505050800050505050508000505050505080005050505050803154508067504931545080615028285450766150472854506561506551525080675038655250806150786052507861503451525069615050625050806950528250508061503485505078615030625050696150585149508069506157495080615080624950786150805149506961504920"};
      Genders = new String[]{"Male", "Female"};
      GenderAllow = new String[]{"JRFC", "JRFC"};
      Years = new String[]{"Child", "Teen", "YoungAdult", "Adult", "MiddleAged", "Senior"};
      YearsD = new int[]{0, 25, 40, 52};
      Hairs = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "00"};
      HairsT = new String[]{"A", "B", "B", "C", "B", "C", "D", "B", "B", "A", "B", "A", "C", "C", "E", "C"};
      Hairs2 = new String[]{"01", "02", "03", "04", "05"};
      Hairs2T = new String[]{"A", "B", "B", "C", "B", "C", "D"};
      StateNames = new String[]{"Normal", "Super", "Super", "Super"};
      DifficultyNames = new String[]{"Normal", "Hard", "Insane"};
      DifficultySNmes = new String[]{"N", "H", "I"};
      DifficultyDesc = new String[]{"NormalDesc", "HardDesc", "InsaneDesc"};
      Pwrtyps = new String[]{"Natural", "Ki", "Chakra", "SwordArt"};
      PwrtypAllow = new String[]{"All", "DBC", "NC", "SAOC"};
      PwrtypDesc = new String[]{"NaturalDesc", "KiDesc", "ChakraDesc", "SwordartDesc"};
      Classes = new String[]{"Survival"};
      ClassesDesc = new String[]{"SurvivalDesc"};
      ClassesDBC = new String[]{"MartialArtist", "Spiritualist", "Warrior"};
      ClassesDBCDesc = new String[]{"MartialArtistDesc", "SpiritualistDesc", "WarriorDesc"};
      Clans = new String[]{"Clanless", "Hyuuga", "Uchiha"};
      ClansDesc = new String[]{"ClanlessDesc", "HyuugaDesc", "UchihaDesc"};
      ClassNames = new String[]{"Class", "Class", "Clan", "None"};
      kiAmount = 0;
      kiMultip = 0.0D;
      dbcHealthCur = 0;
      dbcBP = null;
      jrmcExp = 0;
      dbcEvilness = 0;
      dbcHealth = 0;
      dbcTrainPoint = 0;
      kiMax = 0;
      kiChargRa = 0;
      kiDash = 0;
      kiPunch = 0;
      kiJump = 0;
      kiFly = 0;
      kiAsclvl = 0;
      kiAscPow = 0;
      DSpeed = 0;
      minKi = 1;
      SEvil = "e.dbc";
      SHealth = "h.dbc";
      STrainPoint = "t.dbc";
      SkiMax = "m.dbc";
      SkiChargRa = "r.dbc";
      SkiDash = "d.dbc";
      SkiPunch = "p.dbc";
      SkiJump = "j.dbc";
      SkiFly = "f.dbc";
      SkiAsclvl = "l.dbc";
      SkiAscPow = "a.dbc";
      kiKaioKen = 0;
      kiInSuper = 0;
      KABigBang = 0;
      KABlast = 0;
      KABurningAtt = 0;
      KADeathBeam = 0;
      KADodon = 0;
      KAEnergyDisk = 0;
      KAFinalFlash = 0;
      KAFingerLaser = 0;
      KAGalicGun = 0;
      KAKameHame = 0;
      KAKameHame10x = 0;
      KAMakanko = 0;
      KAMasenko = 0;
      KAPlanetDest = 0;
      KASpiritBomb = 0;
      KTKaioken = 0;
      KASelected = 0;
      KACharge = 0;
      KAFired = 0;
      KAFireStop = 0;
      Senzu = 0;
      driF = false;
      driB = false;
      driU = false;
      driD = false;
      dbchalo = false;
      dbcLieDown = new String[]{"dbcLie", "dbcStand"};
      Har = "_A01";
      Col = "_C0";
      ChakraAmount = 0;
      ChakraMultip = 0.0D;
      hsp = "";
      jutsumode = 0;
      handsealfailed = 0;
      jutsu = 0;
      jutsuinfo = 0;
      ncDou = null;
      ncBodyCur = 0;
      ncExp = 0;
      ncEvil = 0;
      ncBody = 0;
      ncTP = 0;
      ncChMax = 0;
      ncChRa = 0;
      ncSpe = 0;
      ncTai = 0;
      ncTaiJump = 0;
      ncNinj = 0;
      ncGenj = 0;
      ncPow = 0;
      Sbody = "h.dbc";
      Stp = "t.dbc";
      SchMax = "x.dbc";
      SchRa = "c.dbc";
      Sspe = "d.dbc";
      Stai = "p.dbc";
      StaiJump = "j.dbc";
      SNinj = "n.dbc";
      SGenj = "g.dbc";
      SPow = "a.dbc";
      plyrsArnd = null;
      AttrbtNbt = new String[]{"jrmcStr", "jrmcDex", "jrmcCns", "jrmcWil", "jrmcInt", "jrmcCnc"};
      AttrbtNbtI = new String[]{"jrmcStrI", "jrmcDexI", "jrmcCnsI", "jrmcWilI", "jrmcIntI", "jrmcCncI"};
      AttrbtNbtR = new String[]{"jrmcStrR", "jrmcDexR", "jrmcCnsR", "jrmcWilR", "jrmcIntR", "jrmcCncR"};
      SkillsNbt = new String[]{"jrmcSSlt0", "jrmcSSlt1", "jrmcSSlt2", "jrmcSSlt3", "jrmcSSlt4", "jrmcSSlt5", "jrmcSSlt6", "jrmcSSlt7", "jrmcSSlt8", "jrmcSSlt9"};
      FAttrbtNbt = new String[]{"jrmcStrF", "jrmcDexF", "jrmcCnsF", "jrmcWilF", "jrmcIntF", "jrmcCncF"};
      FznDC = "";
      Master = 0;
      MSD = "";
      MSDV = "";
      SagaProg = 0;
      SagaTimes = 0;
      SagaSideProg = 0;
      SagaSideTimes = null;
      GID = 0;
      GLID = " ";
      GIDs = null;
      GIDi = " ";
      GMN = 0;
      nwl = new HashMap();
      ServerPoints = 0;
      trngTPlmt = 0;
      trngTPlmt2 = 0;
      revTmr = 0;
      revtpInit = "";
      wishes = 0;
      Race = 0;
      dns = "0";
      dnsau = "0";
      dnsH = "0";
      Pwrtyp = 0;
      Class = 0;
      Accepted = 0;
      State = 0;
      State2 = 0;
      Dffclty = 0;
      TlMd = 0;
      PtchVc = 0;
      GTrnngCB = 0;
      WeightOn = 0.0F;
      GravZone = 1.0F;
      s4ft = 0;
      age = 0.0F;
      curBody = 0;
      curEnergy = 0;
      curStamina = 0;
      maxBody = 0;
      maxEnergy = 0;
      maxStamina = 0;
      curRelease = 0;
      curTP = 0;
      curExp = 0;
      curn = 0;
      cura = 0;
      ko = 0;
      kob = false;
      pnp = 0;
      pnh = false;
      charged = 0;
      chrgPrc = 0;
      channel = 0;
      wave = 0;
      mrAtts = false;
      EnAtSlct = 0;
      curTech1CD = 0.0F;
      curTech2CD = 0.0F;
      curTech3CD = 0.0F;
      curTech4CD = 0.0F;
      curTech5CD = 0.0F;
      curTech6CD = 0.0F;
      curTech7CD = 0.0F;
      curTech8CD = 0.0F;
      isShtng = false;
      isChrgng = false;
      cast = 0.0F;
      align = 0;
      karma = 0;
      techniqueCooldowns = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F};
      PlyrSettings = "";
      PlyrAttrbts = new int[]{0, 0, 0, 0, 0, 0};
      PlyrSkillX = "";
      PlyrSkillY = "";
      PlyrSkillZ = "";
      PlyrSkills = new String[10];
      StusEfcts = new String[]{"F", "R", "T", "B", "A", "K", "M", "S", "O", "D", "Z", "I", "J", "C", "L", "E", "U", "V", "P", "N", "G", "H"};
      PlyrSttngs = new String[]{"K", "R", "D", "G", "Z", "B", "M", "E", "O", "F", "P", "U", "I", "S", "A", "C", "H"};
      vlblRSkls = new String[]{"TR"};
      DBCRacialSkillTPCost = new int[Races.length][];
      cDBCRacialSkillTPCost = new int[Races.length][];
      DBCRacialSkillMindCost = new int[Races.length][];
      cDBCRacialSkillMindCost = new int[Races.length][];
      vlblRSklsNms = new String[]{"HiddenPotential", "SuperForm", "SuperForm", "PowerBoost", "Transformations", "Abilities"};
      vlblCSkls = new String[]{"HL"};
      vlblCSklsLvl = new int[][]{{10}};
      vlblCSklsNms = new String[]{"Heal"};
      DBCSkillsIDs = new String[]{"FZ", "JP", "DS", "FL", "EN", "OC", "KS", "MD", "KK", "GF", "OK", "KP", "KF", "KB", "DF", "KI", "UI", "IT", "GD"};
      vlblSklsUps = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, -1, 8, -1};
      DBCSkillTPCost = new int[DBCSkillsIDs.length][];
      cDBCSkillTPCost = new int[DBCSkillsIDs.length][];
      DBCSkillMindCost = new int[DBCSkillsIDs.length][];
      cDBCSkillMindCost = new int[DBCSkillsIDs.length][];
      DBCSkillNames = new String[]{"Fusion", "Jump", "Dash", "Fly", "Endurance", "PotentialUnlock", "KiSense", "Meditation", "Kaioken", "GodForm", "OldKaiUnlock", "KiProtection", "KiFist", "KiBoost", "DefensePenetration", "KiInfuse", "UltraInstinct", "InstantTransmission", "GodOfDestruction"};
      inIll = null;
      ncRSkls = new String[]{""};
      ncRSklsLvl = new int[][]{{10, 25, 35, 30, 50, 100, 200, 500, 1000}};
      ncRSklsNms = new String[]{""};
      ncCSkls = new String[]{"", "BG", "SG"};
      NCRacialSkillAbilityNames = new String[]{"", "Byakugan", "Sharingan"};
      NCRacialSkillTPCost = new int[Clans.length][];
      cNCRacialSkillTPCost = new int[Clans.length][];
      NCRacialSkillMindCost = new int[Clans.length][];
      cNCRacialSkillMindCost = new int[Clans.length][];
      NCSkillIDs = new String[]{"TJ", "NJ", "GJ", "CC", "AF", "AD", "AL", "AE", "AW", "MN", "PU", "MD", "EG"};
      ncSklsUps = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
      NCSkillTPCost = new int[NCSkillIDs.length][];
      cNCSkillTPCost = new int[NCSkillIDs.length][];
      NCSkillMindCost = new int[NCSkillIDs.length][];
      cNCSkillMindCost = new int[NCSkillIDs.length][];
      NCSkillNames = new String[]{"Taijutsu", "Ninjutsu", "Genjutsu", "ChakraControl", "AffinityFire", "AffinityWind", "AffinityLightning", "AffinityEarth", "AffinityWater", "IryoNinjutsu", "PotentialUnlock", "Meditation", "EightGates"};
      NCRankNames = new String[]{"", "Academy Student", "Genin", "Chunin", "Jonin", "Anbu", "Kage"};
      tech1 = null;
      tech2 = null;
      tech3 = null;
      tech4 = null;
      techPM = null;
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
      dat32Segmented = null;
      tacx = new HashMap();
      techNbt = new String[]{"jrmcTech1", "jrmcTech2", "jrmcTech3", "jrmcTech4", "jrmcTech5", "jrmcTech6", "jrmcTech7", "jrmcTech8", "jrmcTech9"};
      ArcRsrvGrowth = new int[]{6, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0};
      ArcRsrvMaxSkll = new int[]{0, 500, 1000, 1000, 1500, 2000, 2500};
      ArcRsrvPowCst = new int[]{0, 0, 0, 0, 20, 30, 60, 90, 70, 100, 100};
      TransSaiCurRg = 0;
      TransSaiStBnP = new float[11][];
      TransSaiStBnPO = new float[11][];
      TransSaiStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {30, 30, 0, 30, 0, 0}, {50, 50, 0, 50, 0, 0}, {60, 45, 0, 60, 0, 0}, {45, 45, 0, 45, 0, 0}, {75, 75, 0, 75, 0, 0}, {100, 100, 0, 100, 0, 0}, {20, 20, 0, 20, 0, 0}, {50, 50, 0, 50, 0, 0}, {110, 110, 0, 110, 0, 0}, {150, 150, 0, 150, 0, 0}, {130, 130, 0, 130, 0, 0}, {80, 80, 0, 80, 0, 0}, {110, 110, 0, 110, 0, 0}, {115, 115, 0, 115, 0, 0}, {160, 160, 0, 160, 0, 0}};
      TransHalfSaiStBnP = new float[11][];
      TransHalfSaiStBnPO = new float[11][];
      TransHalfSaiStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {30, 30, 0, 30, 0, 0}, {50, 50, 0, 50, 0, 0}, {60, 45, 0, 60, 0, 0}, {45, 45, 0, 45, 0, 0}, {75, 75, 0, 75, 0, 0}, {100, 100, 0, 100, 0, 0}, {20, 20, 0, 20, 0, 0}, {50, 50, 0, 50, 0, 0}, {110, 110, 0, 110, 0, 0}, {150, 150, 0, 150, 0, 0}, {130, 130, 0, 130, 0, 0}, {80, 80, 0, 80, 0, 0}, {110, 110, 0, 110, 0, 0}, {115, 115, 0, 115, 0, 0}, {160, 160, 0, 160, 0, 0}};
      TransFrStBnP = new float[10][];
      TransFrStBnPO = new float[10][];
      TransFrStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {150, 150, 0, 150, 0, 0}};
      TransHmStBnP = new float[10][];
      TransHmStBnPO = new float[10][];
      TransHmStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {120, 120, 0, 120, 0, 0}};
      TransNaStBnP = new float[10][];
      TransNaStBnPO = new float[10][];
      TransNaStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {120, 120, 0, 120, 0, 0}};
      TransMaStBnP = new float[10][];
      TransMaStBnPO = new float[10][];
      TransMaStBnF = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {120, 120, 0, 120, 0, 0}};
      DoujutsuPowerBonusMulti = new float[][]{{1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F}, {1.1F, 1.1F, 1.1F, 1.1F, 1.0F, 1.0F}, {1.2F, 1.2F, 1.2F, 1.2F, 1.0F, 1.0F}, {1.3F, 1.3F, 1.3F, 1.3F, 1.0F, 1.0F}, {1.4F, 1.4F, 1.4F, 1.4F, 1.0F, 1.0F}, {1.5F, 1.5F, 1.5F, 1.5F, 1.0F, 1.0F}, {1.6F, 1.6F, 1.6F, 1.6F, 1.0F, 1.0F}, {1.7F, 1.7F, 1.7F, 1.7F, 1.0F, 1.0F}, {1.8F, 1.8F, 1.8F, 1.8F, 1.0F, 1.0F}, {1.9F, 1.9F, 1.9F, 1.9F, 1.0F, 1.0F}};
      DoujutsuPowerBonusFlat = new int[][]{{1, 1, 0, 1, 0, 0}, {2, 3, 0, 2, 0, 0}, {3, 4, 0, 3, 0, 0}, {3, 5, 0, 3, 0, 0}, {4, 6, 0, 4, 0, 0}, {5, 8, 0, 5, 0, 0}, {6, 10, 0, 6, 0, 0}, {7, 11, 0, 7, 0, 0}, {8, 13, 0, 8, 0, 0}, {9, 15, 0, 9, 0, 0}};
      TransNms = new String[][]{{"Base", "HForm1", "HForm2", "HFormG"}, {"Base", "Super", "SuperG2", "SuperG3", "SuperFP", "Super2", "Super3", "Oozaru", "OozaruS", "SuperG", "SuperB", "SuperGR", "SuperL", "SuperLB", "Super4", "SuperBS"}, {"Base", "Super", "SuperG2", "SuperG3", "SuperFP", "Super2", "Super3", "Oozaru", "OozaruS", "SuperG", "SuperB", "SuperGR", "SuperL", "SuperLB", "Super4", "SuperBS"}, {"Base", "NForm1", "NForm2", "NFormG"}, {"Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Form6", "FormG"}, {"Base", "MForm1", "MForm2", "MForm3", "MFormG"}};
      trans = new String[][]{{"Base", "Full", "Buffed", "God"}, {"Base", "SS", "SSG2", "SSG3", "SSFullPow", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "LSS", "LSS2", "SS4", "SSBE"}, {"Base", "SS", "SSG2", "SSG3", "SSFullPow", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "LSS", "LSS2", "SS4", "SSBE"}, {"Base", "Full", "Giant", "God"}, {"Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Ultimate", "God"}, {"Base", "Evil", "Full", "Pure", "God"}};
      TransNmsM = new String[][]{{"Base", "Full", "Buffed", "God"}, {"Base", "SS", "SSG2", "SSG3", "SS", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "SS", "SS2", "SS4", "SSBE"}, {"Base", "SS", "SSG2", "SSG3", "SS", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "SS", "SS2", "SS4", "SSBE"}, {"Base", "Full", "Giant", "God"}, {"Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Ultimate", "God"}, {"Base", "Evil", "Full", "Pure", "God"}};
      transformationDescendToFormID = new byte[][]{{0, 0, 0, 0}, {0, 0, 1, 2, 0, 4, 5, 0, 0, 0, 9, 0, 0, 0, 0, 10}, {0, 0, 1, 1, 0, 1, 5, 0, 0, 0, 9, 0, 0, 0, 0, 10}, {0, 0, 0, 0}, {0, 0, 1, 2, 3, 4, 4, 4}, {0, 0, 0, 0, 0}};
      majinRacialSkillNames = new String[]{"SuperRegeneration", "Evil", "Full", "Absorption", "Pure"};
      transNonRacial = new String[]{"Kaioken", "Mystic", "UltraInstict", "GodOfDestruction"};
      TransSaiUpNam = new String[]{"Need for Power", "Further Ascending Theory", "Not Enough", "Back to the Basics", "Even More Power", "The Real Power", "Everything Reached!"};
      TransSaiTre = new short[]{0, 1, 2, 3, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 4, 2};
      TransSaiBlk = new float[]{1.0F, 1.05F, 1.1F, 1.2F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 0.95F, 0.95F, 0.95F, 1.1F, 1.2F, 1.05F, 1.05F};
      TransSaiSz = new float[]{1.0F, 1.02F, 1.1F, 1.2F, 1.02F, 1.04F, 1.06F, 3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.1F, 1.2F, 1.04F, 1.02F};
      TransSaiRgnO = new float[]{1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F};
      TransSaiRgn = new float[]{1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F};
      TransHalfSaiRgnO = new float[]{1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F};
      TransHalfSaiRgn = new float[]{1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F};
      TransFrSkn = new short[]{0, 0, 0, 0, 1, 2, 3, 1};
      TransFrSkn2 = new short[]{0, 0, 0, 2, 1, 3, 1, 1};
      TransFrHrn = new short[]{0, 0, 1, 2, 3, 4, 3, 3};
      TransFrBlk = new float[]{1.0F, 1.0F, 1.0F, 1.1F, 1.0F, 1.1F, 1.05F, 0.95F};
      TransFrSz = new float[]{0.95F, 1.0F, 1.2F, 1.3F, 1.0F, 1.1F, 1.0F, 1.0F};
      TransFrRgnO = new float[]{3.0F, 2.5F, 2.0F, 1.5F, 1.0F, -0.5F, -1.0F, -0.5F};
      TransFrRgn = new float[]{3.0F, 2.5F, 2.0F, 1.5F, 1.0F, -0.5F, -1.0F, -0.5F};
      TransHmRgnO = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransHmRgn = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransHmBlk = new float[]{1.0F, 1.05F, 1.1F, 0.95F};
      TransHmSz = new float[]{1.0F, 1.05F, 1.2F, 1.0F};
      TransNaRgnO = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransNaRgn = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransNaBlk = new float[]{1.0F, 1.05F, 1.05F, 0.95F};
      TransNaSz = new float[]{1.0F, 1.05F, 3.0F, 1.0F};
      TransMaBulk = new float[]{1.0F, 0.95F, 1.02F, 1.0F, 0.95F};
      TransMaSize = new float[]{1.0F, 1.0F, 1.2F, 0.8F, 1.0F};
      TransMaRgnO = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransMaRgn = new float[]{1.0F, -0.5F, -0.25F, -0.5F};
      TransGtsNms = new String[]{"noGate", "Gate1", "Gate2", "Gate3", "Gate4", "Gate5", "Gate6", "Gate7", "Gate8"};
      TransGtsDmg = new float[]{1.0F, 1.2F, 1.4F, 1.6F, 1.8F, 2.0F, 2.25F, 2.5F, 3.0F};
      TransGtsDmgO = new float[]{1.0F, 1.2F, 1.4F, 1.6F, 1.8F, 2.0F, 2.25F, 2.5F, 3.0F};
      TransKaiNms = new String[]{"1", "x2", "x3", "x4", "x5", "x10", "x20"};
      TransKaiNmsO = TransKaiNms;
      TransKaiDmg = new float[TransKaiNms.length];
      TransKaiDmgO = new float[TransKaiNms.length];
      TransKaiDrainRace = new float[Races.length];
      TransKaiDrainORace = new float[Races.length];
      TransKaiDrainLevel = new float[TransKaiNms.length];
      TransKaiDrainOLevel = new float[TransKaiNms.length];
      TransMngDmg = new float[1];
      TransMngDmgO = new float[1];
      AlgnmntNms = new String[]{"Good", "Neutral", "Evil"};
      techCol = new int[]{0, 16777215, 53999, 13801198, 14812441, 328965, 5695066, 16706880, 16625664, 15294875, 11482731, 16752576, 3135190, 1477514, 8974316, 5263440, 11184810, 20414, 7455999, 9385113, 14859007, 8389913, 16677498, 4230966, 9829013, 12233002, 16776101, 16368896, 16762000, 6565897, 13007647};
      techCol2 = new int[]{0, 16777215, 12575487, 16242687, 16736618, 328965, 10878885, 16775651, 16633177, 16350129, 13059966, 16757714, 3135190, 2928043, 11862015, 7105644, 12763842, 2063832, 9885951, 11094961, 15913983, 10032686, 16749714, 5940568, 11730862, 14009926, 16777156, 16766720, 16768171, 7750429, 13800511};
      techCol3 = new int[]{0, 8224125, 2499671, 2559542, 4786450, 197379, 2505498, 3477505, 6170377, 10820956, 7539241, 15633325, 38807, 21844, 6077370, 2500134, 8553090, 10890, 4822478, 6753140, 12750553, 5308930, 13980735, 1206284, 6736224, 9793536, 15390586, 13146368, 13797206, 3739392, 9718786};
      techCol4 = new int[]{0, 13619151, 38899, 9247404, 12851243, 328965, 2479675, 16437248, 15040768, 13128827, 10559571, 15633325, 1751735, 28782, 7394005, 4144959, 9868950, 15781, 6532069, 7806595, 14001385, 6816272, 15297119, 2848800, 8249721, 10915606, 15984268, 14725632, 15509107, 5315587, 11494929};
      techColName = new String[]{"AlignmentBased", "white", "blue", "purple", "red", "black", "green", "yellow", "orange", "pink", "magenta", "lightPink", "cyan", "darkCyan", "lightCyan", "darkGray", "gray", "darkBlue", "lightBlue", "darkPurple", "lightPurple", "darkRed", "lightRed", "darkGreen", "lime", "darkYellow", "lightYellow", "gold", "lightOrange", "darkBrown", "lightBrown"};
      techBase = new int[]{1, 0, 1, 1, 1, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
      techMin = new int[]{1, 0, 1, 0, 0, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
      techMax = new int[]{20, 1, 30, 8, 2, 100, 1, 0, 0, 0, 30, 3, 10, 10, 10, 100};
      techUpg = new int[]{0, 0, 0, 1, 1, 10, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1};
      techNCBase = new int[]{1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
      techNCMin = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
      techNCMax = new int[]{20, 1, 30, 2, 2, 1, 4, 24, 24, 10, 8, 10, 10, 10, 10, 100};
      techNCUpg = new int[]{0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1};
      techDBCstatmods = new String[]{"SpeedInc", "DamageInc", "CostRed", "CastRed", "CoolRed", "DensityInc", "SizeInc"};
      tech_stats = new byte[]{10, 18, 25, 31, 36, 40, 43, 45, 46, 47, 48};
      techDBCName = new String[]{"TName", "TAcquired", "TOwner", "TType", "TSpeed", "TDamage", "TEffect", "TEnergyCost", "TCasttime", "TCooldown", "TColor", "TDensity", "TIncantation", "TFire", "TMove", "", "TExp", "TLvl", "TUpg", "TStats"};
      techDBCTypes = new String[]{"Wave", "Blast", "Disk", "Laser", "Spiral", "BigBlast", "Barrage", "Shield", "Explosion"};
      techDBCaddTYCost = new float[]{1.2F, 1.0F, 1.5F, 1.3F, 1.7F, 1.8F, 0.3F, 1.2F, 1.7F};
      techDBCct = new float[]{3.0F, 2.0F, 4.0F, 1.0F, 3.0F, 8.0F, 0.2F, 2.0F, 5.0F};
      techDBCcd = new float[]{20.0F, 10.0F, 5.0F, 3.0F, 15.0F, 60.0F, 0.2F, 15.0F, 45.0F};
      techDBCEffects = new String[]{"No", "Yes"};
      techDBCAcquired = new String[]{"Learned", "Selfmade"};
      techDBCSpeed = new String[]{"Slow", "Average", "Fast", "VeryFast"};
      techDBCaddSPCost = new float[]{0.9F, 1.0F, 1.2F, 1.4F};
      techDBCstatsDefault = new byte[]{0, 0, 0, 0, 0, 0, 0};
      techName = new String[]{"Name", "Acquired", "Owner", "Type", "Speed", "Damage", "Effect", "Energy Cost", "Casttime", "Cooldown", "Color", "Density", "Incantation", "Fire", "Move"};
      techTypes = new String[]{"Wave", "Blast", "Disk", "Laser", "Large", "Barrage", "Spiral", "Defensive Kiai", "Offensive Kiai"};
      techEffects = new String[]{"Single", "Explosive", "AOE"};
      techAcquired = new String[]{"Learned", "Selfmade"};
      techSpeed = new String[]{"Very Slow", "Slow", "Average", "Fast", "Very Fast", "Extreme Fast"};
      techSndIncBeam = new String[]{"cbeam1s", "cbeam2s", "cbeam3s", "cbeam4s", "cbeam5s", "cbeam6s", "cbeam7s"};
      techSndFireBeam = new String[]{"fbeam1s", "fbeam2s", "fbeam3s", "fbeam4s", "fbeam5s", "fbeam6s", "fbeam7s", "fbeam8s", "fbeam9s", "fbeam10s", "fbeam11s", "fbeam12s", "fbeam13s"};
      techSndMoveBeam = new String[]{"mbeam1s", "mbeam2s"};
      techSndIncDisk = new String[]{"cdisk1s", "cdisk2s"};
      techSndFireDisk = new String[]{"fdisk1s"};
      techSndMoveDisk = new String[]{"mdisk1s"};
      techSndFireLeser = new String[]{"fleser1s", "fleser2s"};
      techSndPMInc = new String[]{"DBC.hame", "DBC3.cspiritbomb", "DBC3.ckidisc", "DBC3.cspecialbeamcannon", "DBC3.cmasenko", "DBC3.cbigbang", "DBC2.finalflash_charge", "DBC3.cgallitgun", "DBC3.cburning", "DBC2.deathball_charge", "1610.pwbl"};
      techSndPMIncFire = new String[]{"DBC.ha", "DBC3.fspiritbomb", "DBC2.disc_fire", "DBC3.fspecialbeamcannon", "DBC3.fmasenko", "DBC2.bigbang_fire", "DBC3.ffinalflash", "DBC3.fgallitgun", "DBC3.fburning", "DBC2.deathball_fire"};
      techSndPMFire = new String[]{"DBC.hamehafire", "DBC2.blast", "DBC2.kiball_release", "DBC2.basicbeam_fire"};
      techSndPMMove = new String[]{"DBC4.mbeam1s", "DBC4.mbeam2s"};
      Masters = new String[]{"None", "General", "Master Roshi", "Master Shen", "Korin", "Kami", "King Kai", "Krillin", "Piccolo", "Vegeta", "Trunks", "Freiza", "Master Cell", "Son Goku", "Son Gohan", "Babidi", "Jin", "Guru", "Whis"};
      pmdbc = new String[][]{{"KAHame", "0", "2", "0", "1", "55", "0", "0", "0", "0", "2", "1", "1", "1", "1", "10"}, {"KABlast", "0", "1", "1", "1", "15", "0", "0", "0", "0", "0", "1", "0", "2", "0", "2"}, {"KASpiritbomb", "0", "6", "5", "0", "95", "1", "0", "0", "0", "1", "1", "2", "0", "0", "15"}, {"KAEnergyDisk", "0", "7", "2", "2", "45", "0", "0", "0", "0", "7", "1", "3", "0", "0", "6"}, {"KAMakanko", "0", "8", "4", "1", "75", "0", "0", "0", "0", "7", "1", "4", "0", "1", "12"}, {"KAMasenko", "0", "8", "0", "1", "55", "0", "0", "0", "0", "8", "1", "5", "0", "1", "7"}, {"KABigBang", "0", "9", "1", "2", "65", "1", "0", "0", "0", "1", "1", "6", "0", "0", "1"}, {"KAFinalFlash", "0", "9", "0", "1", "85", "0", "0", "0", "0", "7", "1", "7", "0", "1", "13"}, {"KAGalicGun", "0", "9", "0", "1", "55", "0", "0", "0", "0", "3", "1", "8", "0", "1", "9"}, {"KABurningAtt", "0", "10", "1", "2", "65", "1", "0", "0", "0", "7", "1", "9", "0", "1", "3"}, {"KAPlanetDest", "0", "11", "5", "0", "95", "1", "0", "0", "0", "4", "1", "10", "0", "0", "14"}, {"KAFakeMoon", "0", "9", "1", "0", "30", "0", "300", "0", "0", "0", "0", "11", "0", "0", "18"}};
      techNCName = new String[]{"Name", "Acquired", "Owner", "Type", "Speed", "Damage", "Effect", "Chakra", "Handseals", "Cooldown", "Color", "Density", "Incantation", "Fire", "Move"};
      techNCTypes = new String[]{"Wave", "Ball", "Disk", "Support", "Offensive", "Taijutsu"};
      techNCEffects = new String[]{"Fire", "Wind", "Lightning", "Earth", "Water", "Raw", "Yang", "Yin", "YinYang", "Nature"};
      techNCAcquired = new String[]{"Learned", "Selfmade"};
      techNCDam = new String[]{"Single", "Explosive"};
      techNCClassn = new String[]{"Ninjutsu", "Genjutsu", "Taijutsu", "Bunshinjutsu", "IryoNinjutsu", "Kinjutsu", "Hiden", "Fuinjutsu ", "BloodlineLimit", "BloodlineSelection", "Kuchiyose"};
      techNCSpeed = new String[]{"Slow", "Average", "Fast", "Very Fast"};
      techNCBunshintyp = new String[]{"Fire", "Wind", "Lightning", "Earth", "Water", "Raw", "Yang", "Shadow", "Yin-Yang", "Nature"};
      techNCSndIncAff = new String[]{"ka", "fuu", "rai", "do", "sui"};
      techNCSndIncTyp = new String[]{"wave", "ball", "disk"};
      techNCSndIncCls = new String[]{"pty", "", "gen", "", "bunshin"};
      techNCSndIncSpec = new String[]{"kai", "", "", "", "", "", "", "kagebunshin"};
      techNCSndIncBeam = new String[0];
      techNCSndIncDisk = new String[0];
      techNCSndFireBeam = new String[0];
      techNCSndFireDisk = new String[0];
      techNCSndMoveBeam = new String[0];
      techNCSndMoveDisk = new String[0];
      techNCSndIncPM = new String[]{"", "bunshin_say", "Chidori", "Katon_Gouk", "Katon_Hous", "Rasengan_Ready", "Fire", "Fuuton", "Lightning", "Earth", "Water", "Raw", "Yang", "Yin", "Yin-Yang", "Nature", "Earth_Wall", "Mud_Wall", "Water_Pistol"};
      techNCSndHitPM = new String[]{"", "bunshin", "Chidori_Hit", "Explosion", "Rasengan_Hit"};
      techNCSndFirePM = new String[]{"", "bunshin", "Hous_Shoot"};
      techNCCol = new int[]{16132352, 14745595, 16382459, 11898202, 5029102, 12379372, 15855792, 2363398, 1908620, 7456823};
      techNCCostP = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85};
      techNCEffHS = new String[]{"323", "132", "213", "312", "121", "313", "231", "131", "212", "133", "232"};
      techNCCCHS = new String[]{"1", "2", "3", "12", "13", "21", "23", "31", "32", "121", "122", "123", "131", "132", "133", "211", "212", "213", "231", "232", "233", "311", "312", "313", "321", "322", "323", "1211", "1212", "1213", "1231", "1232", "1233", "1311", "1312", "1313", "1321", "1322", "1323", "2121", "2122", "2123", "2131", "2132", "2133", "2311", "2312", "2313", "2321", "2322", "2323", "3121", "3122", "3123", "3131", "3132", "3133", "3211", "3212", "3213", "3231", "3232", "3233"};
      techNCPreMadeSeals = new String[]{"", "", ""};
      NarutoNPCnames = new String[]{"", "Sarutobi", "Hiashi", "Fugaku"};
      NarutoNPCclans = new int[]{0, 0, 1, 2};
      MastersNC = new String[]{"None", "General", "Basic", "YondaimeHokage", "Sasuke", "Uchihaclan", "NidaimeHokage", "BasicMedical", "Hyuugaclan"};
      pmj = new String[][]{{"Rasengan", "0", "3", "1", "1", "10", "5", "10", "13231", "100", "0", "1", "5", "0", "4"}, {"Chidori", "0", "4", "1", "1", "10", "2", "10", "21232", "100", "0", "1", "2", "0", "2"}, {"Housenka", "0", "5", "1", "1", "10", "0", "10", "32213", "100", "0", "1", "4", "0", "3"}, {"Bunshin", "0", "2", "3", "0", "1", "5", "2", "11322", "100", "0", "4", "1", "0", "1"}, {"IwaBunshin", "0", "1", "3", "0", "10", "3", "3", "11313", "100", "0", "4", "1", "0", "1"}, {"MizuBunshin", "0", "1", "3", "0", "10", "4", "3", "11312", "100", "0", "4", "1", "0", "1"}, {"KageBunshin", "0", "6", "3", "0", "20", "5", "5", "11323", "100", "0", "4", "1", "7", "1"}, {"Genjutsu", "0", "1", "3", "2", "5", "7", "5", "23121", "100", "0", "2", "1", "0", "1"}, {"Shousen", "0", "7", "3", "0", "10", "6", "10", "23211", "100", "0", "5", "2", "0", "2"}, {"Susanoo", "0", "5", "3", "0", "10", "6", "10", "0", "100", "0", "6", "2", "0", "2"}, {"Kaiten", "0", "8", "5", "0", "10", "6", "10", "0", "100", "0", "7", "2", "0", "2"}, {"EarthWall", "0", "2", "1", "0", "30", "3", "10", "32211", "100", "0", "1", "16", "0", "1"}, {"MudWall", "0", "2", "1", "0", "50", "3", "15", "32212", "100", "0", "1", "17", "0", "1"}, {"WaterPistol", "0", "2", "1", "2", "8", "4", "8", "31312", "100", "0", "1", "18", "0", "3"}};
      dmgMlTyps = new String[]{"Crushing", "Piercing", "Slashing"};
      statNames = new String[][]{{"Melee", "Defense", "Body"}, {"Melee", "Defense", "Body", "Stamina", "EnergyPower", "EnergyPool", "MaxSkills", "Speed", "RegenRateBody", "RegenRateStamina", "RegenRateEnergy", "FlySpeed"}, {"Melee", "Defense", "Body", "Stamina", "EnergyPower", "EnergyPool", "MaxSkills", "Speed", "RegenRateBody", "RegenRateStamina", "RegenRateEnergy"}, {"Melee", "Defense", "Body", "Stamina", "Speed", "RegenRateBody", "RegenRateStamina"}};
      attrInit = new String[][]{{"STR ", "DEX ", "CONS"}, {"STR ", "DEX ", "CONS", "WILL", "MIND", "SPI"}, {"STR ", "DEX ", "CONS", "WILL", "MIND", "SPI"}, {"STR", "AGI", "VIT"}};
      attrNms = new String[][]{{"Strength", "Dexterity", "Constitution"}, {"Strength", "Dexterity", "Constitution", "WillPower", "Mind", "Spirit"}, {"Strength", "Dexterity", "Constitution", "WillPower", "Mind", "Spirit"}, {"Strength", "Agility", "Vitality"}};
      attrDsc = new String[][]{{"StrMC", "DexMC", "ConMC"}, {"StrDB", "DexDB", "ConDB", "WilDB", "MndDB", "SpiDB"}, {"StrNC", "DexNC", "ConNC", "WilNC", "MndNC", "SpiNC"}, {"StrSA", "AgiSA", "VitSA"}};
      attrStat = new String[][]{{"mleMC", "DefMC", "heltMC"}, {"mleDB", "DefDB", "BdDB", "StDB", "EnPwDB", "EnPlDB", "MxSkDB", "SpDB", "RBDB", "RSDB", "REDB", "FSDB"}, {"mleNC", "DefNC", "BdNC", "StNC", "EnPwNC", "EnPlNC", "MxSkNC", "SpNC", "RBNC", "RSNC", "RENC"}, {"mleSA", "DefSA", "BdSA", "StSA"}};
      statInc = new float[][]{{0.3F, 1.0F, 2.0F}, {2.5F, 4.0F, 20.0F, 3.5F, 5.2F, 40.0F, 0.15F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F}, {2.5F, 4.0F, 20.0F, 3.5F, 5.2F, 40.0F, 0.15F, 1.0F, 1.0F, 1.0F, 1.0F}, {1.0F, 1.0F, 250.0F}};
      attrStart = new int[][][]{{{10}, {10}, {10}}, {{10, 15, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 10, 5, 5, 15, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 10, 7, 15, 8, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 15, 15, 10, 10, 7, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 5, 10, 15, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 5, 5, 18, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10}}, {{10}, {10}, {10}, {10}, {10}, {10}}, {{1}, {1}, {1}}};
      splitter = Splitter.on(',').omitEmptyStrings().trimResults();
      joiner = Joiner.on(',').skipNulls();
      attrCstH = null;
      statIncBonusRaceDBC = new int[][]{{0, 30, 15, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {30, 0, 15, 0, 10, 30, 0, 0, 0, 0, 0, 0, 0, 0}, {10, 20, 15, 30, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0}, {10, 0, 5, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {10, 0, 5, 0, 30, 10, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
      statIncBonusClass = new int[][][]{{{0, 10, -10}, {0, -10, 10}, {0, 0, 0}}, {{0, -10, 10}, {0, 10, -10}, {0, -10, 10}, {0, -10, 10}, {0, 10, -10}, {0, 10, -10}, {0, 0, 0}, {0, 10, -10}, {0, -10, 10}, {0, -10, 10}, {0, 10, -10}, {0, 10, -10}}, {{0, 5, 10}, {0, 5, 0}, {0, 5, -10}, {0, 5, 10}, {0, -5, 5}, {0, -10, -10}, {0, 0, 0}, {0, 5, 5}, {0, -10, -10}, {0, -10, -10}, {0, -10, -10}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
      sao_skillSlot = null;
      sao_skills = null;
      sao_level = 1;
      sao_exp = 0;
      sao_ap = 0;
      sao_sp = 0;
      sao_col = 0;
      saoSkls = new HashMap();
      SAO_SkillMap_Cats = new String[]{"weapons", "armors"};
      SAO_SkillMap_Weapons = new String[]{"1sword", "1curved", "1dagger", "1rapier", "1axe", "1mace", "2sword", "2spear", "2axe", "2hammer", "2katana"};
      SAO_SkillMap_WeaponTypes = new String[]{"slash", "slash", "pierce", "pierce", "slash", "crash", "slash", "pierce", "slash", "crash", "slash"};
      SAO_Weapon_Cat_Sword = new String[]{"sword", "straight", "shortsword", "longsword"};
      SAO_Weapon_Cat_Curved = new String[]{"curved", "scimitar"};
      SAO_Weapon_Cat_Dagger = new String[]{"dagger", "knife"};
      SAO_Weapon_Cat_Rapier = new String[]{"rapier"};
      SAO_Weapon_Cat_Axe = new String[]{"axe"};
      SAO_Weapon_Cat_Spear = new String[]{"spear"};
      SAO_Weapon_Cat_BattleAxe = new String[]{"greataxe", "battleaxe"};
      SAO_Weapon_Cat_WarHammer = new String[]{"mace", "blunt", "club"};
      SAO_Weapon_Cat_Sword2 = new String[]{"sword", "greatsword", "twohandedsword", "zwei", "2sword", "twosword"};
      SAO_Weapon_Cat_Katana = new String[]{"katana"};
      SAO_SkillMap_Armors = new String[]{"leather", "lightmetal", "heavymetal", "lightshield", "heavyshield", "parry"};
      damInd = new HashMap();
      TrnngOptns = new String[]{"shadowdummy", "concentration", "BPswap", "airBoxing"};
      jfcData0 = null;
      jfcaa = null;
      jfcms = null;
      jfcmt = null;
      jfccp = null;
      jfccs = null;
      modsC = null;
      modsS = null;
      Perc10 = 0.9F;
      Perc15 = 0.85F;
      Perc20 = 0.8F;
      DBCresetted = true;
      NCresetted = true;
      difp = "";
      NAMES = new String[]{"Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillion", "Septillion", "Octillion", "Nonillion", "Decillion", "Undecillion", "Duodecillion", "Tredecillion", "Quattuordecillion", "Quindecillion", "Sexdecillion", "Septendecillion", "Octodecillion", "Novemdecillion", "Vigintillion"};
      THOUSAND = BigInteger.valueOf(1000L);
      MAP = new TreeMap();

      for(int i = 0; i < NAMES.length; ++i) {
         MAP.put(THOUSAND.pow(i + 1), NAMES[i]);
      }

      ltnb = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
      cldb = "§1";
      cldg = "§2";
      cla = "§3";
      cldr = "§4";
      cldp = "§5";
      clgd = "§6";
      clgy = "§7";
      cldgy = "§8";
      clbe = "§9";
      clb = "§0";
      cllg = "§a";
      cllb = "§b";
      cllr = "§c";
      clpr = "§d";
      cly = "§e";
      clw = "§f";
      CHAT_STYLE_YELLOW = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
      wi = "wi.jrmc";
      bs = "BuildingSpawns";
      wip = "wip.jrmc";
      modAssetIDs = new HashMap();
      paused = false;
      turih = new HashMap();
      mem = 1000L;
      familyCEmptyFamiliesCleared = false;
      previousServerFolder = "";
   }

   public static class Log {
      public static final boolean DEBUG = true;

      public static void log(String message) {
         String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
         String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
         String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
         int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
         System.out.println(className + "." + methodName + ":" + lineNumber + ": " + message);
      }
   }
}
