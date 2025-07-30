package JinRyuu.DragonBC.common;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPtick;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class DBCKiAttacks {
   public static final int maxChrgLmt = 200;
   public static final int maxChrgcnt = 20;
   public static double motX = 0.5D;
   public static double motY = 0.01D;
   public static double motZ = 0.5D;
   public static final int time2 = 2;
   public static final int time40 = 40;
   public static final int time50 = 50;
   public static final int time70 = 70;
   public static final int time100 = 120;
   public static final int time120 = 200;
   public static final int BigBangCosts = 20;
   public static final String BigBangHeart = "7,5";
   public static final double BigBangDam = 15.0D;
   public static final float BigBangExpl = 5.0F;
   public static final String BigBangExplSound = "jinryuudragonbc:DBC.expl";
   public static final String BigBangAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String BigBangFired = "jinryuudragonbc:DBC2.bigbang_fire";
   public static final String BigBangCharg = "jinryuudragonbc:DBC3.cbigbang";
   public static final int BurningAttCosts = 15;
   public static final String BurningAttHeart = "7,5";
   public static final double BurningAttDam = 13.0D;
   public static final float BurningAttExpl = 3.0F;
   public static final String BurningAttExplSound = "jinryuudragonbc:DBC.expl";
   public static final String BurningAttAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String BurningAttFired = "jinryuudragonbc:DBC3.fburning";
   public static final String BurningAttFired2 = "jinryuudragonbc:DBC3.ffburning";
   public static final String BurningAttCharg = "jinryuudragonbc:DBC3.cburning";
   public static final int BlastCosts = 3;
   public static final String BlastHeart = "1";
   public static final double BlastDam = 2.0D;
   public static final float BlastExpl = 0.0F;
   public static final String BlastExplSound = "";
   public static final String BlastAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String BlastFired = "jinryuudragonbc:DBC2.blast";
   public static final String BlastCharg = "";
   public static final int DeathBeamCosts = 8;
   public static final String DeathBeamHeart = "5,5";
   public static final double DeathBeamDam = 5.0D;
   public static final float DeathBeamExpl = 2.0F;
   public static final String DeathBeamExplSound = "jinryuudragonbc:DBC.expl";
   public static final String DeathBeamAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String DeathBeamFired = "jinryuudragonbc:DBC2.basicbeam_fire";
   public static final String DeathBeamCharg = "";
   public static final int DodonCosts = 5;
   public static final String DodonHeart = "2";
   public static final double DodonDam = 4.0D;
   public static final float DodonExpl = 0.0F;
   public static final String DodonExplSound = "";
   public static final String DodonAirSound = "";
   public static final String DodonFired = "jinryuudragonbc:DBC2.kiball_release";
   public static final String DodonCharg = "";
   public static final int EnergyDiskCosts = 10;
   public static final String EnergyDiskHeart = "4";
   public static final double EnergyDiskDam = 8.0D;
   public static final float EnergyDiskExpl = 0.0F;
   public static final String EnergyDiskExplSound = "";
   public static final String EnergyDiskAirSound = "";
   public static final String EnergyDiskFired = "jinryuudragonbc:DBC2.disc_fire";
   public static final String EnergyDiskCharg = "jinryuudragonbc:DBC3.ckidisc";
   public static final int FinalFlashCosts = 16;
   public static final String FinalFlashHeart = "9";
   public static final double FinalFlashDam = 9.0D;
   public static final float FinalFlashExpl = 7.0F;
   public static final String FinalFlashExplSound = "jinryuudragonbc:DBC.expl";
   public static final String FinalFlashAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String FinalFlashFired = "jinryuudragonbc:DBC3.ffinalflash";
   public static final String FinalFlashCharg = "jinryuudragonbc:DBC2.finalflash_charge";
   public static final int FingerLeserCosts = 6;
   public static final String FingerLeserHeart = "2,5";
   public static final double FingerLeserDam = 5.0D;
   public static final float FingerLeserExpl = 0.0F;
   public static final String FingerLeserExplSound = "";
   public static final String FingerLeserAirSound = "";
   public static final String FingerLeserFired = "jinryuudragonbc:DBC3.fingerleser";
   public static final String FingerLeserCharg = "";
   public static final int GalicGunCosts = 9;
   public static final String GalicGunHeart = "6";
   public static final double GalicGunDam = 6.0D;
   public static final float GalicGunExpl = 5.0F;
   public static final String GalicGunExplSound = "jinryuudragonbc:DBC.expl";
   public static final String GalicGunAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String GalicGunFired = "jinryuudragonbc:DBC3.fgallitgun";
   public static final String GalicGunCharg = "jinryuudragonbc:DBC3.cgallitgun";
   public static final int KameHameCosts = 8;
   public static final String KameHameHeart = "5";
   public static final double KameHameDam = 5.0D;
   public static final float KameHameExpl = 4.0F;
   public static final String KameHameExplSound = "jinryuudragonbc:DBC.expl";
   public static final String KameHameAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String KameHameFired = "jinryuudragonbc:DBC.ha";
   public static final String KameHameCharg = "jinryuudragonbc:DBC.hame";
   public static final int KameHame10xCosts = 19;
   public static final String KameHame10xHeart = "12,5";
   public static final double KameHame10xDam = 10.0D;
   public static final float KameHame10xExpl = 10.0F;
   public static final String KameHame10xExplSound = "jinryuudragonbc:DBC.expl";
   public static final String KameHame10xAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String KameHame10xFired = "jinryuudragonbc:DBC.ha10x";
   public static final String KameHame10xCharg = "jinryuudragonbc:DBC.hame";
   public static final int MakankoCosts = 11;
   public static final String MakankoHeart = "7,5";
   public static final double MakankoDam = 7.0D;
   public static final float MakankoExpl = 4.0F;
   public static final String MakankoExplSound = "jinryuudragonbc:DBC.expl";
   public static final String MakankoAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String MakankoFired = "jinryuudragonbc:DBC3.fspecialbeamcannon";
   public static final String MakankoCharg = "jinryuudragonbc:DBC3.cspecialbeamcannon";
   public static final int MasenkoCosts = 9;
   public static final String MasenkoHeart = "5";
   public static final double MasenkoDam = 5.0D;
   public static final float MasenkoExpl = 2.0F;
   public static final String MasenkoExplSound = "jinryuudragonbc:DBC.expl";
   public static final String MasenkoAirSound = "jinryuudragonbc:DBC.hafire";
   public static final String MasenkoFired = "jinryuudragonbc:DBC3.fmasenko";
   public static final String MasenkoCharg = "jinryuudragonbc:DBC3.cmasenko";
   public static final int PlanetDestCosts = 100;
   public static final String PlanetDestHeart = "25";
   public static final double PlanetDestDam = 50.0D;
   public static final float PlanetDestExpl = 17.0F;
   public static final String PlanetDestExplSound = "jinryuudragonbc:DBC.expl";
   public static final String PlanetDestAirSound = "";
   public static final String PlanetDestFired = "jinryuudragonbc:DBC2.deathball_fire";
   public static final String PlanetDestCharg = "jinryuudragonbc:DBC2.deathball_charge";
   public static final int SpiritBombCosts = 80;
   public static final String SpiritBombHeart = "25";
   public static final double SpiritBombDam = 50.0D;
   public static final float SpiritBombExpl = 15.0F;
   public static final String SpiritBombExplSound = "jinryuudragonbc:DBC.expl";
   public static final String SpiritBombAirSound = "";
   public static final String SpiritBombFired = "jinryuudragonbc:DBC3.fspiritbomb";
   public static final String SpiritBombCharg = "jinryuudragonbc:DBC3.cspiritbomb";
   public static final int PunchCosts = 10;
   public static final double PunchDam = 15.0D;
   public static final float PunchExpl = 5.0F;
   public static final String PunchExplSound = "jinryuudragonbc:DBC2.strongpunch";
   public static final String PunchAirSound = "jinryuudragonbc:DBC2.hafire";
   public static final String PunchFired = "jinryuudragonbc:DBC2.strongpunch";
   public static final String PunchCharg = "";
   public double explosionX;
   public double explosionY;
   public double explosionZ;
   public float explosionSize;
   public List chunkPositionRecords;
   private float playerVelocityX;
   private float playerVelocityY;
   private float playerVelocityZ;

   public static void scouterRem(EntityPlayer p) {
      if (ExtendedPlayer.get(p).inventory.func_70301_a(2) != null) {
         ExtendedPlayer.get(p).inventory.func_70299_a(2, (ItemStack)null);
      }

   }

   public static void dbctick(int t) {
      PD.sendToServer(new DBCPtick(t));
   }

   public static void KASlct() {
      int selct = 1;
      if (JRMCoreH.KABigBang == 1 && JRMCoreH.KASelected < selct) {
         JRMCoreH.KASelected = selct;
      } else {
         selct = 2;
         if (JRMCoreH.KABlast == 1 && JRMCoreH.KASelected < selct) {
            JRMCoreH.KASelected = selct;
         } else {
            selct = 3;
            if (JRMCoreH.KABurningAtt == 1 && JRMCoreH.KASelected < selct) {
               JRMCoreH.KASelected = selct;
            } else {
               selct = 4;
               if (JRMCoreH.KADeathBeam == 1 && JRMCoreH.KASelected < selct) {
                  JRMCoreH.KASelected = selct;
               } else {
                  selct = 5;
                  if (JRMCoreH.KADodon == 1 && JRMCoreH.KASelected < selct) {
                     JRMCoreH.KASelected = selct;
                  } else {
                     selct = 6;
                     if (JRMCoreH.KAEnergyDisk == 1 && JRMCoreH.KASelected < selct) {
                        JRMCoreH.KASelected = selct;
                     } else {
                        selct = 7;
                        if (JRMCoreH.KAFinalFlash == 1 && JRMCoreH.KASelected < selct) {
                           JRMCoreH.KASelected = selct;
                        } else {
                           selct = 8;
                           if (JRMCoreH.KAFingerLaser == 1 && JRMCoreH.KASelected < selct) {
                              JRMCoreH.KASelected = selct;
                           } else {
                              selct = 9;
                              if (JRMCoreH.KAGalicGun == 1 && JRMCoreH.KASelected < selct) {
                                 JRMCoreH.KASelected = selct;
                              } else {
                                 selct = 10;
                                 if (JRMCoreH.KAKameHame == 1 && JRMCoreH.KASelected < selct) {
                                    JRMCoreH.KASelected = selct;
                                 } else {
                                    selct = 11;
                                    if (JRMCoreH.KAKameHame10x == 1 && JRMCoreH.KASelected < selct) {
                                       JRMCoreH.KASelected = selct;
                                    } else {
                                       selct = 12;
                                       if (JRMCoreH.KAMakanko == 1 && JRMCoreH.KASelected < selct) {
                                          JRMCoreH.KASelected = selct;
                                       } else {
                                          selct = 13;
                                          if (JRMCoreH.KAMasenko == 1 && JRMCoreH.KASelected < selct) {
                                             JRMCoreH.KASelected = selct;
                                          } else {
                                             selct = 14;
                                             if (JRMCoreH.KAPlanetDest == 1 && JRMCoreH.KASelected < selct) {
                                                JRMCoreH.KASelected = selct;
                                             } else {
                                                selct = 15;
                                                if (JRMCoreH.KASpiritBomb == 1 && JRMCoreH.KASelected < selct) {
                                                   JRMCoreH.KASelected = selct;
                                                } else {
                                                   selct = 16;
                                                   if (JRMCoreH.KTKaioken == 1 && JRMCoreH.KASelected < selct) {
                                                      JRMCoreH.KASelected = selct;
                                                   } else {
                                                      selct = 0;
                                                      if (JRMCoreH.KASelected > selct) {
                                                         JRMCoreH.KASelected = selct;
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static boolean KAkiEn(EntityPlayer thePlayer) {
      int explevel = JRMCoreH.kiAscPow;
      if (JRMCoreH.armTypSS1On(thePlayer)) {
         explevel *= 2;
      }

      if (JRMCoreH.armTypSS2On(thePlayer)) {
         explevel *= 3;
      }

      if (JRMCoreH.armTypSS3On(thePlayer)) {
         explevel *= 4;
      }

      int evil = JRMCoreH.dbcEvilness;
      double evl2 = (double)(100 - evil) * 0.01D;
      double good2 = (double)evil * 0.01D;
      double evl = evl2 + 0.2D;
      double good = good2 + 0.2D;
      double neu = 1.0D - (good2 - evl2 < 0.0D ? (good2 - evl2) * -1.0D : good2 - evl2) + 0.2D;
      double ret = 0.0D;
      int selct = JRMCoreH.KASelected;
      double cost = 0.0D;
      int maxki = JRMCoreH.kiMax;
      if (selct == 1) {
         cost = (double)((int)((double)explevel * neu * 20.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 2) {
         cost = (double)(explevel * 3);
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 3) {
         cost = (double)((int)((double)explevel * good * 15.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 4) {
         cost = (double)((int)((double)explevel * evl * 8.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 5) {
         cost = (double)((int)((double)explevel * neu * 5.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 6) {
         cost = (double)(explevel * 10);
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 7) {
         cost = (double)((int)((double)explevel * neu * 16.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 8) {
         cost = (double)((int)((double)explevel * evl * 6.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 9) {
         cost = (double)((int)((double)explevel * neu * 9.0D));
         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         }
      }

      if (selct == 10) {
         cost = (double)((int)((double)explevel * good * 8.0D));
      }

      if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
         return false;
      } else {
         if (selct == 11) {
            cost = (double)((int)((double)explevel * good * 19.0D));
         }

         if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
            return false;
         } else {
            if (selct == 12) {
               cost = (double)((int)((double)explevel * neu * 11.0D));
            }

            if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
               return false;
            } else {
               if (selct == 13) {
                  cost = (double)((int)((double)explevel * good * 9.0D));
               }

               if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
                  return false;
               } else {
                  if (selct == 14) {
                     cost = (double)((int)((double)explevel * evl * 100.0D));
                  }

                  if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
                     return false;
                  } else {
                     if (selct == 15) {
                        cost = (double)((int)((double)explevel * good * 80.0D));
                     }

                     if (JRMCoreH.kiAmount < ((int)cost > maxki ? (int)((double)maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) {
                        return false;
                     } else if (selct == 16 && JRMCoreH.kiAmount < 1) {
                        return false;
                     } else {
                        return selct != 0;
                     }
                  }
               }
            }
         }
      }
   }
}
