package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Npcs.EntityAngelAwamo;
import JinRyuu.DragonBC.common.Npcs.EntityAngelCamparri;
import JinRyuu.DragonBC.common.Npcs.EntityAngelCognac;
import JinRyuu.DragonBC.common.Npcs.EntityAngelCukatail;
import JinRyuu.DragonBC.common.Npcs.EntityAngelKorn;
import JinRyuu.DragonBC.common.Npcs.EntityAngelKusu;
import JinRyuu.DragonBC.common.Npcs.EntityAngelMarcarita;
import JinRyuu.DragonBC.common.Npcs.EntityAngelMartinu;
import JinRyuu.DragonBC.common.Npcs.EntityAngelMohito;
import JinRyuu.DragonBC.common.Npcs.EntityAngelSour;
import JinRyuu.DragonBC.common.Npcs.EntityAniraza;
import JinRyuu.DragonBC.common.Npcs.EntityBarta;
import JinRyuu.DragonBC.common.Npcs.EntityBasil;
import JinRyuu.DragonBC.common.Npcs.EntityBeerus;
import JinRyuu.DragonBC.common.Npcs.EntityBeerusMonaka;
import JinRyuu.DragonBC.common.Npcs.EntityBeerusMonaka2;
import JinRyuu.DragonBC.common.Npcs.EntityBeerusMonaka3;
import JinRyuu.DragonBC.common.Npcs.EntityBergamo;
import JinRyuu.DragonBC.common.Npcs.EntityBerryblue;
import JinRyuu.DragonBC.common.Npcs.EntityBiarra;
import JinRyuu.DragonBC.common.Npcs.EntityBorareta;
import JinRyuu.DragonBC.common.Npcs.EntityBotamo;
import JinRyuu.DragonBC.common.Npcs.EntityBrianne;
import JinRyuu.DragonBC.common.Npcs.EntityBuuBuffed;
import JinRyuu.DragonBC.common.Npcs.EntityBuuEvil;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFusion;
import JinRyuu.DragonBC.common.Npcs.EntityBuuKid;
import JinRyuu.DragonBC.common.Npcs.EntityBuuPiccolo;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityBuuUltimate;
import JinRyuu.DragonBC.common.Npcs.EntityCabba;
import JinRyuu.DragonBC.common.Npcs.EntityCabbaSSJ;
import JinRyuu.DragonBC.common.Npcs.EntityCaulifla;
import JinRyuu.DragonBC.common.Npcs.EntityCaulifla2;
import JinRyuu.DragonBC.common.Npcs.EntityCell1;
import JinRyuu.DragonBC.common.Npcs.EntityCell2;
import JinRyuu.DragonBC.common.Npcs.EntityCell3;
import JinRyuu.DragonBC.common.Npcs.EntityCell4;
import JinRyuu.DragonBC.common.Npcs.EntityCellJr;
import JinRyuu.DragonBC.common.Npcs.EntityChampa;
import JinRyuu.DragonBC.common.Npcs.EntityCocotte;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.DragonBC.common.Npcs.EntityDercori;
import JinRyuu.DragonBC.common.Npcs.EntityDino01;
import JinRyuu.DragonBC.common.Npcs.EntityDino02;
import JinRyuu.DragonBC.common.Npcs.EntityDino03;
import JinRyuu.DragonBC.common.Npcs.EntityDodoria;
import JinRyuu.DragonBC.common.Npcs.EntityDyspo;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza1;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza2;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza3;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza4;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza5;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza6;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza7;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaMecha;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
import JinRyuu.DragonBC.common.Npcs.EntityFrost1;
import JinRyuu.DragonBC.common.Npcs.EntityFrost2;
import JinRyuu.DragonBC.common.Npcs.EntityFrost3;
import JinRyuu.DragonBC.common.Npcs.EntityFrost4;
import JinRyuu.DragonBC.common.Npcs.EntityFrost5;
import JinRyuu.DragonBC.common.Npcs.EntityFrost6;
import JinRyuu.DragonBC.common.Npcs.EntityGanos;
import JinRyuu.DragonBC.common.Npcs.EntityGanos2;
import JinRyuu.DragonBC.common.Npcs.EntityGinyu;
import JinRyuu.DragonBC.common.Npcs.EntityGodArak;
import JinRyuu.DragonBC.common.Npcs.EntityGodBelmod;
import JinRyuu.DragonBC.common.Npcs.EntityGodGiin;
import JinRyuu.DragonBC.common.Npcs.EntityGodHeles;
import JinRyuu.DragonBC.common.Npcs.EntityGodIwan;
import JinRyuu.DragonBC.common.Npcs.EntityGodLiquiir;
import JinRyuu.DragonBC.common.Npcs.EntityGodMosco;
import JinRyuu.DragonBC.common.Npcs.EntityGodQuitela;
import JinRyuu.DragonBC.common.Npcs.EntityGodRumsshi;
import JinRyuu.DragonBC.common.Npcs.EntityGodSidra;
import JinRyuu.DragonBC.common.Npcs.EntityGohan;
import JinRyuu.DragonBC.common.Npcs.EntityGohan2;
import JinRyuu.DragonBC.common.Npcs.EntityGohan_orange;
import JinRyuu.DragonBC.common.Npcs.EntityGohan_orange2;
import JinRyuu.DragonBC.common.Npcs.EntityGoku;
import JinRyuu.DragonBC.common.Npcs.EntityGoku2;
import JinRyuu.DragonBC.common.Npcs.EntityGoku3;
import JinRyuu.DragonBC.common.Npcs.EntityGoku4;
import JinRyuu.DragonBC.common.Npcs.EntityGokuBlack;
import JinRyuu.DragonBC.common.Npcs.EntityGokuBlackRose;
import JinRyuu.DragonBC.common.Npcs.EntityGuldo;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Npcs.EntityHit;
import JinRyuu.DragonBC.common.Npcs.EntityHop;
import JinRyuu.DragonBC.common.Npcs.EntityJeice;
import JinRyuu.DragonBC.common.Npcs.EntityJiren;
import JinRyuu.DragonBC.common.Npcs.EntityJiren2;
import JinRyuu.DragonBC.common.Npcs.EntityKahseral;
import JinRyuu.DragonBC.common.Npcs.EntityKakunsa;
import JinRyuu.DragonBC.common.Npcs.EntityKale;
import JinRyuu.DragonBC.common.Npcs.EntityKale2;
import JinRyuu.DragonBC.common.Npcs.EntityKatopesla;
import JinRyuu.DragonBC.common.Npcs.EntityKatopesla2;
import JinRyuu.DragonBC.common.Npcs.EntityKatopesla3;
import JinRyuu.DragonBC.common.Npcs.EntityKatopesla4;
import JinRyuu.DragonBC.common.Npcs.EntityKefla;
import JinRyuu.DragonBC.common.Npcs.EntityKefla2;
import JinRyuu.DragonBC.common.Npcs.EntityKiwi;
import JinRyuu.DragonBC.common.Npcs.EntityKoichiarator;
import JinRyuu.DragonBC.common.Npcs.EntityKoitsukai;
import JinRyuu.DragonBC.common.Npcs.EntityKrillin;
import JinRyuu.DragonBC.common.Npcs.EntityKunshi;
import JinRyuu.DragonBC.common.Npcs.EntityLavender;
import JinRyuu.DragonBC.common.Npcs.EntityMagetta;
import JinRyuu.DragonBC.common.Npcs.EntityMajora;
import JinRyuu.DragonBC.common.Npcs.EntityMonaka;
import JinRyuu.DragonBC.common.Npcs.EntityMurichim;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntityNapapa;
import JinRyuu.DragonBC.common.Npcs.EntityNarirama;
import JinRyuu.DragonBC.common.Npcs.EntityObni;
import JinRyuu.DragonBC.common.Npcs.EntityPanchia;
import JinRyuu.DragonBC.common.Npcs.EntityPaparoni;
import JinRyuu.DragonBC.common.Npcs.EntityPiccolo;
import JinRyuu.DragonBC.common.Npcs.EntityPiccolo2;
import JinRyuu.DragonBC.common.Npcs.EntityPuipui;
import JinRyuu.DragonBC.common.Npcs.EntityRRMecha;
import JinRyuu.DragonBC.common.Npcs.EntityRecoome;
import JinRyuu.DragonBC.common.Npcs.EntityRoasie;
import JinRyuu.DragonBC.common.Npcs.EntityRoshi_super;
import JinRyuu.DragonBC.common.Npcs.EntityRylibeu;
import JinRyuu.DragonBC.common.Npcs.EntitySabertooth;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanNappa;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanRaditz;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityShisami;
import JinRyuu.DragonBC.common.Npcs.EntityShosa;
import JinRyuu.DragonBC.common.Npcs.EntitySorbet;
import JinRyuu.DragonBC.common.Npcs.EntitySorrel;
import JinRyuu.DragonBC.common.Npcs.EntityTagoma;
import JinRyuu.DragonBC.common.Npcs.EntityToppo;
import JinRyuu.DragonBC.common.Npcs.EntityToppo2;
import JinRyuu.DragonBC.common.Npcs.EntityTrunks;
import JinRyuu.DragonBC.common.Npcs.EntityTrunks2;
import JinRyuu.DragonBC.common.Npcs.EntityTrunks_dbs;
import JinRyuu.DragonBC.common.Npcs.EntityTrunks_dbs2;
import JinRyuu.DragonBC.common.Npcs.EntityVados;
import JinRyuu.DragonBC.common.Npcs.EntityVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityVegeta2;
import JinRyuu.DragonBC.common.Npcs.EntityVegeta3;
import JinRyuu.DragonBC.common.Npcs.EntityVegeta4;
import JinRyuu.DragonBC.common.Npcs.EntityVegetaCopy;
import JinRyuu.DragonBC.common.Npcs.EntityVegetaCopyBlue;
import JinRyuu.DragonBC.common.Npcs.EntityWhis;
import JinRyuu.DragonBC.common.Npcs.EntityYakon;
import JinRyuu.DragonBC.common.Npcs.EntityZamasu;
import JinRyuu.DragonBC.common.Npcs.EntityZamasu_Fused;
import JinRyuu.DragonBC.common.Npcs.EntityZamasu_Fused2;
import JinRyuu.DragonBC.common.Npcs.EntityZamasu_Fused3;
import JinRyuu.DragonBC.common.Npcs.EntityZarbon;
import JinRyuu.DragonBC.common.Npcs.EntityZarbon2;
import JinRyuu.DragonBC.common.Npcs.EntityZeno;
import JinRyuu.DragonBC.common.Npcs.db.EntityBearThief;
import JinRyuu.DragonBC.common.Npcs.db.EntityBora;
import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi;
import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi2;
import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi3;
import JinRyuu.DragonBC.common.Npcs.db.EntityOolong;
import JinRyuu.DragonBC.common.Npcs.db.EntityPuar;
import JinRyuu.DragonBC.common.Npcs.db.EntityTigerBandit;
import JinRyuu.DragonBC.common.Npcs.db.EntityUpa;
import JinRyuu.DragonBC.common.Npcs.db.EntityYajirobe;
import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha;
import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha2;
import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha3;
import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha4;
import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha5;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityDevil;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityFortunetellerBaba;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityGrandpaGohan;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityGrandpaGohan2;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityInvisibleMan;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityMummy;
import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityVampire;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityCymbal;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityDrum;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityKingPiccolo;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityKingPiccolo2;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityPiano;
import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityTambourine;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityMai;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityMaiMecha;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilaf;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilafMecha;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilafMechaCombined;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityShu;
import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityShuMecha;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityAndroid8;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityBuyon;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityColonelSilver;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityColonelViolet;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityCommanderRed;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralBlue;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralBlue2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralWhite;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralWhite2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityLaunch;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityLaunch2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron1;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron3;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao3;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityNinjaMurasaki;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack3;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier3;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB2;
import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB3;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityCheelai;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityCheelai2;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly1;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly2;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly3;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly4;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyBuff;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyBuffSSJ;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyLegendary;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSParagus;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSParagus2;
import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityLemo;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityBacterian;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu2;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu3;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu4;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityGiran;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun2;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun3;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityKingChappa;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityManWolf;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityMasterShen;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityNam;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityPamput;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien2;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien3;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien4;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien5;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien6;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien7;
import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTournamentAnnouncer;
import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre;
import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre2;
import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre3;
import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre4;
import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre5;
import JinRyuu.DragonBC.common.Npcs.dbz.EntitySpirit;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.JGEntityHelper;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class ComDbcSpawn extends CommandBase {
   public String func_71517_b() {
      return "dbcspawn";
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "Use '/dbcspawn (DBCmobName) or /dbcspawn (DBCmobName) (Health)' to spawn the DBC mobs or /dbcspawn (DBCmobName) (Health) (Damage)' to spawn the DBC mobs.";
   }

   public int func_82362_a() {
      return 2;
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return MinecraftServer.func_71276_C().func_71264_H() || super.func_71519_b(par1ICommandSender);
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
      if (stringArray.length <= 0) {
         throw new WrongUsageException("Use '/dbcspawn (DBCmobName) or /dbcspawn (DBCmobName) (Health)' to spawn the DBC mobs or /dbcspawn (DBCmobName) (Health) (Damage)' to spawn the DBC mobs.", new Object[0]);
      } else {
         EntityPlayerMP entityplayermp;
         String stringDamage;
         String[] entity;
         if (stringArray.length <= 1) {
            entityplayermp = func_71521_c(commandSender);
            EntityDBC[] ent = this.getEntityList(entityplayermp);
            String[] entnams = this.getEntityNameList();
            stringDamage = stringArray[0].toLowerCase();
            EntityDBC entity = null;
            boolean spawned = false;

            for(int i1 = 0; i1 < entnams.length; ++i1) {
               if (entnams[i1].toLowerCase().contains(stringDamage)) {
                  entity = ent[i1];
                  entity.func_70029_a(entityplayermp.world);
                  entity = DBCH.NpcSpawnLoc((int)entityplayermp.posX, (int)entityplayermp.posY, (int)entityplayermp.posZ, entityplayermp.world).split(";");
                  entity.setLocationAndAngles(Double.parseDouble(entity[0]), Double.parseDouble(entity[1]), Double.parseDouble(entity[2]), 0.0F, 0.0F);
                  if (entity instanceof EntityDBCEvil) {
                     ((EntityDBCEvil)entity).setSpwner(entityplayermp);
                  }

                  entityplayermp.world.func_72838_d(entity);
                  this.notifyAdmins(commandSender, "%s spawned %s!", new Object[]{entityplayermp.getName(), entnams[i1]});
                  spawned = true;
                  break;
               }
            }

            if (!spawned) {
               this.notifyAdmins(commandSender, "%s couldn't spawn %s!", new Object[]{entityplayermp.getName(), stringDamage});
            }
         } else if (stringArray.length <= 4) {
            if (stringArray.length > 3) {
               entityplayermp = func_82359_c(commandSender, stringArray[3]);
            } else {
               entityplayermp = func_71521_c(commandSender);
            }

            String s = stringArray[0];
            String stringHealth = "";
            stringDamage = "";
            if (stringArray.length >= 2) {
               stringHealth = stringArray[1];
               if (stringArray.length == 3) {
                  stringDamage = stringArray[2];
               }
            }

            EntityDBC[] ent = this.getEntityList(entityplayermp);
            String[] entnams = this.getEntityNameList();
            String s2 = s.toLowerCase();
            entity = null;
            boolean spawned = false;

            for(int i1 = 0; i1 < entnams.length; ++i1) {
               if (entnams[i1].toLowerCase().contains(s2)) {
                  EntityDBC entity = ent[i1];
                  entity.func_70029_a(entityplayermp.world);
                  String[] v = DBCH.NpcSpawnLoc((int)entityplayermp.posX, (int)entityplayermp.posY, (int)entityplayermp.posZ, entityplayermp.world).split(";");
                  entity.setLocationAndAngles(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), 0.0F, 0.0F);
                  if (entity instanceof EntityDBCEvil) {
                     ((EntityDBCEvil)entity).setSpwner(entityplayermp);
                  }

                  NBTTagCompound nbt = JRMCoreH.nbt(entity);
                  JGEntityHelper.setAttributes(entity, stringHealth, stringDamage, "", "", 1);
                  entityplayermp.world.func_72838_d(entity);
                  this.notifyAdmins(commandSender, "%s spawned %s!", new Object[]{entityplayermp.getName(), entnams[i1]});
                  spawned = true;
                  break;
               }
            }

            if (!spawned) {
               this.notifyAdmins(commandSender, "%s couldn't spawn %s!", new Object[]{entityplayermp.getName(), s2});
            }
         }

      }
   }

   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
      func_152373_a(commandSender, this, string, objects);
   }

   private String[] getEntityNameList() {
      String[] entityNames = new String[]{"Nam", "Piccolo", "Piccolo2", "Raditz", "Nappa", "Vegeta", "Saibaiman", "Saiyan01", "Saiyan02", "Ogre1", "Ogre2", "Kiwi", "Dodoria", "Zarbon", "Zarbon2", "Guldo", "Recoome", "Barta", "Jeice", "Ginyu", "FreezaSoldier1", "FreezaSoldier2", "FreezaSoldier3", "Freeza1", "Freeza2", "Freeza3", "Freeza4", "Freeza5", "Freeza6", "FreezaGolden", "KingCold", "MechaFreeza", "Cyborg16", "Cyborg17", "Cyborg18", "Cyborg19", "Cyborg20", "Cell1", "Cell2", "Cell3", "Cell4", "Namekian01", "PuiPui", "Yakon", "Dabura", "BuuFat", "BuuSuper", "Dino01", "Beerus", "Dino02", "Dino03", "RRMecha1", "Sabertooth", "CellJr", "BuuEvil", "BuuFusion", "BuuPiccolo", "BuuUltimate", "BuuBuffed", "BuuKid", "Monaka", "BeerusMonaka", "BeerusMonaka2", "BeerusMonaka3", "Berryblue", "Botamo", "Champa", "Frost1", "Frost2", "Frost3", "Frost4", "Frost5", "Frost6", "Hit", "Krillin", "Magetta", "Roshi_super", "Shisami", "Sorbet", "Tagoma", "Vados", "Whis", "GokuBlack", "GokuBlackRose", "VegetaCopy", "VegetaCopyBlue", "Cabba", "CabbaSSJ", "Zamasu", "Zamasu_fused", "Zamasu_fused2", "Zamasu_fused3", "Zeno", "Goku_enemy", "Goku_enemy2", "Goku_enemy3", "Goku_enemy4", "Vegeta_enemy", "Vegeta_enemy2", "Vegeta_enemy3", "Vegeta_enemy4", "Gohan_enemy", "Gohan_enemy2", "Gohan_enemy2_1", "Gohan_enemy2_2", "Trunks_enemy", "Trunks_enemy2", "Trunks_enemy2_1", "Trunks_enemy2_2", "Awamo", "Camparri", "Cognac", "Cuktail", "Korn", "Kusu", "Marcarita", "Martinu", "Mohito", "Sour", "Arak", "Belmod", "Giin", "Heles", "Iwan", "Liquiir", "Mosco", "Quitela", "Rumsshi", "Sidra", "Basil", "Bergamo", "Lavender", "Brianne", "Caulifla", "Caulifla2", "Dyspo", "Jiren", "Jiren2", "Kale", "Kale2", "Kefla", "Kefla2", "Toppo", "Toppo2", "Aniraza", "Biarra", "Cocotte", "Dercori", "Ganos", "Ganos2", "Hop", "Kahseral", "Kakunsa", "Kunshi", "Majora", "Murichim", "Napapa", "Narirama", "Obni", "Paparoni", "Roasie", "Rylibeu", "Shosa", "Sorrel", "Borareta", "Koichiarator", "Koitsukai", "Panchia", "Katopesla", "Katopesla2", "Katopesla3", "Katopesla4", "DBSBroly", "DBSBroly2", "DBSBroly3", "DBSBroly4", "DBSBrolyBuff", "DBSBrolyBuffSSJ", "DBSBrolyLegendary", "DBSParagus", "DBSParagusOld", "Cheelai", "Cheelai2", "Lemo", "FortunetellerBaba", "BandagesTheMummy", "SeeThroughTheInvisibleMan", "FangsTheVampire", "SpikeTheDevil", "GrandpaGohan", "GrandpaGohan2", "Cymbal", "Drum", "KingPiccolo", "KingPiccolo2", "Piano", "Tambourine", "DBMasterRoshi", "DBMasterRoshi2", "DBMasterRoshi3", "BearThief", "TigerBandit", "Puar", "Yamcha", "Yamcha2", "Yamcha3", "Yamcha4", "Yamcha5", "DBMai", "DBPilaf", "DBShu", "DBMaiMecha", "DBPilafMecha", "DBShuMecha", "DBPilafMechaCombined", "Bacterian", "Giran", "JackieChun", "JackieChun2", "JackieChun3", "TournamentAnnouncer", "KingChappa", "ManWolf", "MasterShen", "Pamput", "TienShinhan", "TienShinhan2", "TienShinhan3", "Android8", "Buyon", "ColonelSilver", "ColonelViolet", "CommanderRed", "GeneralBlue", "GeneralBlue2", "GeneralWhite", "GeneralWhite2", "LaunchGood", "LaunchBad", "MajorMetallitron", "MajorMetallitron1", "MajorMetallitron2", "MajorMetallitron3", "MercenaryTao", "NinjaMurasaki", "RedRibbonSoldier", "RedRibbonSoldier2", "RedRibbonSoldier3", "RedRibbonSoldierB", "RedRibbonSoldierB2", "RedRibbonSoldierB3", "DBBora", "DBUpa", "Oolong", "Yajirobe", "MercenaryTao2", "MercenaryTao3", "OfficerBlack", "OfficerBlack2", "OfficerBlack3", "OfficeOgre", "OfficeOgre2", "OfficeOgre3", "OfficeOgre4", "OfficeOgre5", "DBZSpirit", "Chiaotzu", "Chiaotzu2", "Chiaotzu3", "Chiaotzu4", "TienShinhan4", "TienShinhan5", "TienShinhan6", "TienShinhan7"};
      return entityNames;
   }

   private EntityDBC[] getEntityList(EntityPlayerMP entityplayermp) {
      EntityDBC[] entities = new EntityDBC[]{new EntityNam(entityplayermp.world), new EntityPiccolo(entityplayermp.world), new EntityPiccolo2(entityplayermp.world), new EntitySaiyanRaditz(entityplayermp.world), new EntitySaiyanNappa(entityplayermp.world), new EntitySaiyanVegeta(entityplayermp.world), new EntitySaibaiman(entityplayermp.world), new EntitySaiyan01(entityplayermp.world), new EntitySaiyan02(entityplayermp.world), new EntityHell01(entityplayermp.world), new EntityHell02(entityplayermp.world), new EntityKiwi(entityplayermp.world), new EntityDodoria(entityplayermp.world), new EntityZarbon(entityplayermp.world), new EntityZarbon2(entityplayermp.world), new EntityGuldo(entityplayermp.world), new EntityRecoome(entityplayermp.world), new EntityBarta(entityplayermp.world), new EntityJeice(entityplayermp.world), new EntityGinyu(entityplayermp.world), new EntityFreezaSoldier1(entityplayermp.world), new EntityFreezaSoldier2(entityplayermp.world), new EntityFreezaSoldier3(entityplayermp.world), new EntityFreeza1(entityplayermp.world), new EntityFreeza2(entityplayermp.world), new EntityFreeza3(entityplayermp.world), new EntityFreeza4(entityplayermp.world), new EntityFreeza5(entityplayermp.world), new EntityFreeza6(entityplayermp.world), new EntityFreeza7(entityplayermp.world), new EntityFreezaFather(entityplayermp.world), new EntityFreezaMecha(entityplayermp.world), new EntityCyborg16(entityplayermp.world), new EntityCyborg17(entityplayermp.world), new EntityCyborg18(entityplayermp.world), new EntityCyborg19(entityplayermp.world), new EntityCyborg20(entityplayermp.world), new EntityCell1(entityplayermp.world), new EntityCell2(entityplayermp.world), new EntityCell3(entityplayermp.world), new EntityCell4(entityplayermp.world), new EntityNamekian01(entityplayermp.world), new EntityPuipui(entityplayermp.world), new EntityYakon(entityplayermp.world), new EntityDarbura(entityplayermp.world), new EntityBuuFat(entityplayermp.world), new EntityBuuSuper(entityplayermp.world), new EntityDino01(entityplayermp.world), new EntityBeerus(entityplayermp.world), new EntityDino02(entityplayermp.world), new EntityDino03(entityplayermp.world), new EntityRRMecha(entityplayermp.world), new EntitySabertooth(entityplayermp.world), new EntityCellJr(entityplayermp.world), new EntityBuuEvil(entityplayermp.world), new EntityBuuFusion(entityplayermp.world), new EntityBuuPiccolo(entityplayermp.world), new EntityBuuUltimate(entityplayermp.world), new EntityBuuBuffed(entityplayermp.world), new EntityBuuKid(entityplayermp.world), new EntityMonaka(entityplayermp.world), new EntityBeerusMonaka(entityplayermp.world), new EntityBeerusMonaka2(entityplayermp.world), new EntityBeerusMonaka3(entityplayermp.world), new EntityBerryblue(entityplayermp.world), new EntityBotamo(entityplayermp.world), new EntityChampa(entityplayermp.world), new EntityFrost1(entityplayermp.world), new EntityFrost2(entityplayermp.world), new EntityFrost3(entityplayermp.world), new EntityFrost4(entityplayermp.world), new EntityFrost5(entityplayermp.world), new EntityFrost6(entityplayermp.world), new EntityHit(entityplayermp.world), new EntityKrillin(entityplayermp.world), new EntityMagetta(entityplayermp.world), new EntityRoshi_super(entityplayermp.world), new EntityShisami(entityplayermp.world), new EntitySorbet(entityplayermp.world), new EntityTagoma(entityplayermp.world), new EntityVados(entityplayermp.world), new EntityWhis(entityplayermp.world), new EntityGokuBlack(entityplayermp.world), new EntityGokuBlackRose(entityplayermp.world), new EntityVegetaCopy(entityplayermp.world), new EntityVegetaCopyBlue(entityplayermp.world), new EntityCabba(entityplayermp.world), new EntityCabbaSSJ(entityplayermp.world), new EntityZamasu(entityplayermp.world), new EntityZamasu_Fused(entityplayermp.world), new EntityZamasu_Fused2(entityplayermp.world), new EntityZamasu_Fused3(entityplayermp.world), new EntityZeno(entityplayermp.world), new EntityGoku(entityplayermp.world), new EntityGoku2(entityplayermp.world), new EntityGoku3(entityplayermp.world), new EntityGoku4(entityplayermp.world), new EntityVegeta(entityplayermp.world), new EntityVegeta2(entityplayermp.world), new EntityVegeta3(entityplayermp.world), new EntityVegeta4(entityplayermp.world), new EntityGohan(entityplayermp.world), new EntityGohan2(entityplayermp.world), new EntityGohan_orange(entityplayermp.world), new EntityGohan_orange2(entityplayermp.world), new EntityTrunks(entityplayermp.world), new EntityTrunks2(entityplayermp.world), new EntityTrunks_dbs(entityplayermp.world), new EntityTrunks_dbs2(entityplayermp.world), new EntityAngelAwamo(entityplayermp.world), new EntityAngelCamparri(entityplayermp.world), new EntityAngelCognac(entityplayermp.world), new EntityAngelCukatail(entityplayermp.world), new EntityAngelKorn(entityplayermp.world), new EntityAngelKusu(entityplayermp.world), new EntityAngelMarcarita(entityplayermp.world), new EntityAngelMartinu(entityplayermp.world), new EntityAngelMohito(entityplayermp.world), new EntityAngelSour(entityplayermp.world), new EntityGodArak(entityplayermp.world), new EntityGodBelmod(entityplayermp.world), new EntityGodGiin(entityplayermp.world), new EntityGodHeles(entityplayermp.world), new EntityGodIwan(entityplayermp.world), new EntityGodLiquiir(entityplayermp.world), new EntityGodMosco(entityplayermp.world), new EntityGodQuitela(entityplayermp.world), new EntityGodRumsshi(entityplayermp.world), new EntityGodSidra(entityplayermp.world), new EntityBasil(entityplayermp.world), new EntityBergamo(entityplayermp.world), new EntityLavender(entityplayermp.world), new EntityBrianne(entityplayermp.world), new EntityCaulifla(entityplayermp.world), new EntityCaulifla2(entityplayermp.world), new EntityDyspo(entityplayermp.world), new EntityJiren(entityplayermp.world), new EntityJiren2(entityplayermp.world), new EntityKale(entityplayermp.world), new EntityKale2(entityplayermp.world), new EntityKefla(entityplayermp.world), new EntityKefla2(entityplayermp.world), new EntityToppo(entityplayermp.world), new EntityToppo2(entityplayermp.world), new EntityAniraza(entityplayermp.world), new EntityBiarra(entityplayermp.world), new EntityCocotte(entityplayermp.world), new EntityDercori(entityplayermp.world), new EntityGanos(entityplayermp.world), new EntityGanos2(entityplayermp.world), new EntityHop(entityplayermp.world), new EntityKahseral(entityplayermp.world), new EntityKakunsa(entityplayermp.world), new EntityKunshi(entityplayermp.world), new EntityMajora(entityplayermp.world), new EntityMurichim(entityplayermp.world), new EntityNapapa(entityplayermp.world), new EntityNarirama(entityplayermp.world), new EntityObni(entityplayermp.world), new EntityPaparoni(entityplayermp.world), new EntityRoasie(entityplayermp.world), new EntityRylibeu(entityplayermp.world), new EntityShosa(entityplayermp.world), new EntitySorrel(entityplayermp.world), new EntityBorareta(entityplayermp.world), new EntityKoichiarator(entityplayermp.world), new EntityKoitsukai(entityplayermp.world), new EntityPanchia(entityplayermp.world), new EntityKatopesla(entityplayermp.world), new EntityKatopesla2(entityplayermp.world), new EntityKatopesla3(entityplayermp.world), new EntityKatopesla4(entityplayermp.world), new EntityDBSBroly1(entityplayermp.world), new EntityDBSBroly2(entityplayermp.world), new EntityDBSBroly3(entityplayermp.world), new EntityDBSBroly4(entityplayermp.world), new EntityDBSBrolyBuff(entityplayermp.world), new EntityDBSBrolyBuffSSJ(entityplayermp.world), new EntityDBSBrolyLegendary(entityplayermp.world), new EntityDBSParagus(entityplayermp.world), new EntityDBSParagus2(entityplayermp.world), new EntityCheelai(entityplayermp.world), new EntityCheelai2(entityplayermp.world), new EntityLemo(entityplayermp.world), new EntityFortunetellerBaba(entityplayermp.world), new EntityMummy(entityplayermp.world), new EntityInvisibleMan(entityplayermp.world), new EntityVampire(entityplayermp.world), new EntityDevil(entityplayermp.world), new EntityGrandpaGohan(entityplayermp.world), new EntityGrandpaGohan2(entityplayermp.world), new EntityCymbal(entityplayermp.world), new EntityDrum(entityplayermp.world), new EntityKingPiccolo(entityplayermp.world), new EntityKingPiccolo2(entityplayermp.world), new EntityPiano(entityplayermp.world), new EntityTambourine(entityplayermp.world), new EntityDBMasterRoshi(entityplayermp.world), new EntityDBMasterRoshi2(entityplayermp.world), new EntityDBMasterRoshi3(entityplayermp.world), new EntityBearThief(entityplayermp.world), new EntityTigerBandit(entityplayermp.world), new EntityPuar(entityplayermp.world), new EntityYamcha(entityplayermp.world), new EntityYamcha2(entityplayermp.world), new EntityYamcha3(entityplayermp.world), new EntityYamcha4(entityplayermp.world), new EntityYamcha5(entityplayermp.world), new EntityMai(entityplayermp.world), new EntityPilaf(entityplayermp.world), new EntityShu(entityplayermp.world), new EntityMaiMecha(entityplayermp.world), new EntityPilafMecha(entityplayermp.world), new EntityShuMecha(entityplayermp.world), new EntityPilafMechaCombined(entityplayermp.world), new EntityBacterian(entityplayermp.world), new EntityGiran(entityplayermp.world), new EntityJackieChun(entityplayermp.world), new EntityJackieChun2(entityplayermp.world), new EntityJackieChun3(entityplayermp.world), new EntityTournamentAnnouncer(entityplayermp.world), new EntityKingChappa(entityplayermp.world), new EntityManWolf(entityplayermp.world), new EntityMasterShen(entityplayermp.world), new EntityPamput(entityplayermp.world), new EntityTien(entityplayermp.world), new EntityTien2(entityplayermp.world), new EntityTien3(entityplayermp.world), new EntityAndroid8(entityplayermp.world), new EntityBuyon(entityplayermp.world), new EntityColonelSilver(entityplayermp.world), new EntityColonelViolet(entityplayermp.world), new EntityCommanderRed(entityplayermp.world), new EntityGeneralBlue(entityplayermp.world), new EntityGeneralBlue2(entityplayermp.world), new EntityGeneralWhite(entityplayermp.world), new EntityGeneralWhite2(entityplayermp.world), new EntityLaunch(entityplayermp.world), new EntityLaunch2(entityplayermp.world), new EntityMajorMetallitron(entityplayermp.world), new EntityMajorMetallitron1(entityplayermp.world), new EntityMajorMetallitron2(entityplayermp.world), new EntityMajorMetallitron3(entityplayermp.world), new EntityMercenaryTao(entityplayermp.world), new EntityNinjaMurasaki(entityplayermp.world), new EntityRedRibbonSoldier(entityplayermp.world), new EntityRedRibbonSoldier2(entityplayermp.world), new EntityRedRibbonSoldier3(entityplayermp.world), new EntityRedRibbonSoldierB(entityplayermp.world), new EntityRedRibbonSoldierB2(entityplayermp.world), new EntityRedRibbonSoldierB3(entityplayermp.world), new EntityBora(entityplayermp.world), new EntityUpa(entityplayermp.world), new EntityOolong(entityplayermp.world), new EntityYajirobe(entityplayermp.world), new EntityMercenaryTao2(entityplayermp.world), new EntityMercenaryTao3(entityplayermp.world), new EntityOfficerBlack(entityplayermp.world), new EntityOfficerBlack2(entityplayermp.world), new EntityOfficerBlack3(entityplayermp.world), new EntityOfficeOgre(entityplayermp.world), new EntityOfficeOgre2(entityplayermp.world), new EntityOfficeOgre3(entityplayermp.world), new EntityOfficeOgre4(entityplayermp.world), new EntityOfficeOgre5(entityplayermp.world), new EntitySpirit(entityplayermp.world), new EntityChiaotzu(entityplayermp.world), new EntityChiaotzu2(entityplayermp.world), new EntityChiaotzu3(entityplayermp.world), new EntityChiaotzu4(entityplayermp.world), new EntityTien4(entityplayermp.world), new EntityTien5(entityplayermp.world), new EntityTien6(entityplayermp.world), new EntityTien7(entityplayermp.world)};
      return entities;
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] arrayString) {
      int length = arrayString.length;
      switch(length) {
      case 1:
         return func_71530_a(arrayString, this.getEntityNameList());
      case 2:
         return func_71530_a(arrayString, new String[]{"1000"});
      case 3:
         return func_71530_a(arrayString, new String[]{"1000"});
      case 4:
         return func_71530_a(arrayString, this.getListOfPlayers());
      default:
         return null;
      }
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean isUsernameIndex(int id) {
      return id == 3;
   }
}
