package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Npcs.EntityAura2;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
import JinRyuu.JRMCore.JRMCoreCliTicH;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreKeyHandler;
import JinRyuu.JRMCore.p.JRMCorePTri;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
import JinRyuu.JRMCore.p.DBC.DBCPascend;
import JinRyuu.JRMCore.p.DBC.DBCPascendsound;
import JinRyuu.JRMCore.p.DBC.DBCPchargesound;
import JinRyuu.JRMCore.p.DBC.DBCPdescend;
import JinRyuu.JRMCore.p.DBC.DBCPdescendsound;
import JinRyuu.JRMCore.p.DBC.DBCPduo;
import JinRyuu.JRMCore.p.DBC.DBCPenergy;
import JinRyuu.JRMCore.server.JGMathHelper;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DBCKiTech {
   public static int ascend = 0;
   public static int pup = 0;
   public static int pup2 = 0;
   public static int ptime = 0;
   public static int inSuperTime = 0;
   private static int time = 0;
   private static int time2 = 0;
   private static int time3 = 0;
   private static int partnorm = 0;
   private static int power = 0;
   private static int jump;
   public static boolean jumping = false;
   public static boolean jumpRel = false;
   public static boolean floating = false;
   public static boolean releasing = false;
   public static boolean ascending = false;
   public static boolean ascendingK = false;
   private static float sec = 0.0F;
   private static boolean jumpToFly = false;
   private static Instant quickTransformTimer;
   private static int quickTransformCount = 0;
   private static boolean quickTransformAdded = false;
   private static Instant singleDescendTimer;
   private static int singleDescendCount = 0;
   private static boolean singleDescendAdded = false;
   private static Instant holdingTransformTimer;
   private static boolean holdingForTransform = false;
   private static boolean sentAbsorption = false;
   public static float flyY = 0.0F;
   public static int floatTime = 0;
   public static boolean floatMultAdded = false;
   private static boolean dodge_forwDash_STE;
   private static float sent;
   public static final int SWOOP_FORWARD = 0;
   public static final int SWOOP_LEFT = 1;
   public static final int SWOOP_BACK = 2;
   public static final int SWOOP_RIGHT = 3;
   public static int swoopDirection = -1;
   public static int tickTime = 0;
   public static int prevTickTime = 0;
   public static int dash = 0;
   public static int dodge_per;
   public static long dodge_recently;
   public static boolean dodge_forwHold;
   public static int dodge_forwSwTm;
   public static boolean turbo = false;
   public static int ton = 0;
   public static boolean wasTransformPressed = false;
   public static HashMap<String, EntityAura2> ra = new HashMap();

   public static void ChargeKi() {
      ++partnorm;
      if (partnorm >= 5) {
         partnorm = 0;
         chargePart(false);
      }

      ++power;
      if (power >= (int)(JRMCoreH.State == 10 && JRMCoreH.State2 > 0 ? JRMCoreCliTicH.counterValue * 3.0F : JRMCoreCliTicH.counterValue * 2.5F)) {
         power = 0;
         chargePart(true);
      }

      boolean b = isPressed(JRMCoreKeyHandler.KiCharge) && !isPressed(JRMCoreKeyHandler.KiAscend) && !JRMCoreH.StusEfctsMe(11);
      if (b) {
         if (!releasing) {
            releasing = true;
            JRMCoreH.Skll((byte)5, (byte)0, (byte)4);
         }
      } else if (releasing) {
         releasing = false;
         JRMCoreH.Skll((byte)5, (byte)1, (byte)4);
      }

      if (b) {
         ++time;
         ++time2;
         ++time3;
         if (isPressed(JRMCoreKeyHandler.Fn) && (JRMCoreH.Race != 0 && JRMCoreH.Race != 3 || JRMCoreH.State <= 0)) {
            if (time3 >= 10) {
               time3 = 0;
               JRMCoreH.Rls((byte)2);
            }
         } else if (JRMCoreH.curRelease < 50 + JRMCoreH.SklLvl(5, (byte)1) * 5 && time >= (JRMCoreH.curRelease >= 50 ? (turbo ? 15 : 30) : (turbo ? 5 : 10))) {
            time = 0;
            float en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
            float re = (float)JRMCoreH.curRelease;
            en = en > 75.0F ? 75.0F : en;
            if (re >= 50.0F) {
               if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                  return;
               }
            } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
               return;
            }

            JRMCoreH.Rls((byte)1);
         }
      }

   }

   public static void JumpKi(KeyBinding keyBindJump) {
      EntityPlayer var4 = DBCClient.mc.field_71439_g;
      float t = turbo ? 1.0F : 0.8F;
      float n = (float)JRMCoreH.SklLvl(1, (byte)1);
      float max = 0.22F;
      float prc = 0.3F + 0.05F * n + (float)(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[1] / gYZc2f()) * 0.2F;
      float rel = (float)JRMCoreH.curRelease * 0.01F;
      float add = max * prc * t * rel;
      int cost = 1 + (int)(add * 30.0F);
      boolean able = true;
      if (JRMCoreH.curEnergy < cost) {
         able = false;
      }

      boolean relStp = JRMCoreConfig.releaseStop ? !releasing : true;
      if (isPressed(keyBindJump) && !relStp) {
         KeyBinding.func_74510_a(keyBindJump.func_151463_i(), false);
         if (JRMCoreClient.mc.field_71439_g.field_70181_x > 0.0D) {
            JRMCoreClient.mc.field_71439_g.field_70181_x = 0.0D;
         }
      }

      if (isPressed(keyBindJump) && relStp && !jumpRel && able) {
         jumping = true;
         if (jump >= 10) {
            jumping = false;
         }

         if (jump >= 1 && jump < 10 && jump / 5 * 5 == jump) {
            JRMCoreH.Cost(cost);
         }

         if (jumping) {
            EntityClientPlayerMP var10000 = DBCClient.mc.field_71439_g;
            var10000.field_70181_x += 0.05D + (double)add;
         }
      } else {
         jumpRel = true;
      }

      if (!jumpRel && !floating) {
         ++jump;
         if (jump == 4) {
            JRMCoreH.KAsounds(var4, 0);
         }
      }

      if (var4.field_70122_E) {
         jump = 0;
         jumpRel = false;
      }

   }

   public static long dtap1() {
      return System.currentTimeMillis() + 50L;
   }

   public static long dtap4() {
      return System.currentTimeMillis() + 250L;
   }

   public static void FloatKi(KeyBinding kiFlight, KeyBinding keyBindJump, KeyBinding keyBindSneak) {
      EntityPlayer p = DBCClient.mc.field_71439_g;
      int n = JRMCoreH.SklLvl(3, (byte)1);
      int st = JRMCoreH.StusEfctsMe(13) ? (JRMCoreH.rc_sai(JRMCoreH.Race) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) - 1) : (JRMCoreH.rc_arc(JRMCoreH.Race) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_humNam(JRMCoreH.Race) ? JRMCoreH.mstc_humnam() : 1))) : JRMCoreH.State;
      float inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 11, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
      float add = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[4], n, (float)JRMCoreH.curRelease, turbo, true, st, JRMCoreH.State2, inc);
      boolean pressingRightClick = isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G);
      boolean pressingForward = isPressed(JRMCoreClient.mc.field_71474_y.field_74351_w);
      boolean pressingLeft = isPressed(JRMCoreClient.mc.field_71474_y.field_74370_x);
      boolean pressingBack = isPressed(JRMCoreClient.mc.field_71474_y.field_74368_y);
      boolean pressingRight = isPressed(JRMCoreClient.mc.field_71474_y.field_74366_z);
      boolean isAnyDirectionKeyPressing = !JRMCoreH.StusEfctsMe(4) && !pressingRightClick && (pressingForward || pressingLeft || pressingBack || pressingRight);
      boolean forw = isAnyDirectionKeyPressing && isPressed(JRMCoreKeyHandler.Fn);
      if (dodge_forwSwTm == 0 && isPressed(JRMCoreKeyHandler.Fn) && !isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G) && !isPressed(JRMCoreKeyHandler.KiCharge) && !isPressed(JRMCoreKeyHandler.KiAscend)) {
         dodge_forwSwTm = forw ? 1 : 0;
      }

      if (dodge_forwSwTm > 0 && isAnyDirectionKeyPressing && !JRMCoreClient.mc.field_71439_g.field_70122_E) {
         dodge_forwHold = true;
         ++dodge_forwSwTm;
      } else {
         dodge_forwHold = false;
         dodge_forwSwTm = 0;
      }

      int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts();
      byte pwr = JRMCoreH.Pwrtyp;
      byte rce = JRMCoreH.Race;
      byte cls = JRMCoreH.Class;
      int maxEnergy = JRMCoreH.stat(p, 5, pwr, 5, PlyrAttrbts[5], rce, cls, 0.0F);
      int ce2 = JRMCoreH.curEnergy;
      int cst2 = (int)((float)maxEnergy * 0.1F - (float)n * 0.005F);
      int maxStam = JRMCoreH.stat(p, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
      int ce = JRMCoreH.curStamina;
      int cst = (int)((float)maxStam * (0.2F - (float)n * 0.005F));
      boolean dodge = !JRMCoreH.PlyrSettingsB(2);
      if (ce > cst && n > 0 && dodge && ce2 > cst2 && !p.func_70115_ae()) {
         if (dodge_forwHold && !p.field_70122_E && dodge_forwHold) {
            if (!dodge_forwDash_STE) {
               dodge_forwDash_STE = true;
            }

            if (floating) {
               floating = false;
            }

            float s = add * 1.5F;
            float w = JRMCoreH.weightPerc(1);
            s *= w;
            double motionX = 0.0D;
            double motionY = 0.0D;
            double motionZ = 0.0D;
            float yaw = p.field_70177_z;
            float pitch = p.field_70125_A;
            if (pressingLeft) {
               yaw -= 90.0F / (!pressingForward && !pressingBack ? 1.0F : 2.0F) * (pressingBack ? -1.0F : 1.0F);
               pitch = 0.0F;
            } else if (pressingRight) {
               yaw += 90.0F / (!pressingForward && !pressingBack ? 1.0F : 2.0F) * (pressingBack ? -1.0F : 1.0F);
               pitch = 0.0F;
            }

            if (pressingForward) {
               pitch = p.field_70125_A;
            } else if (pressingBack) {
               yaw -= 180.0F;
               pitch = p.field_70125_A * -1.0F;
            }

            motionX = (double)(-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
            motionZ = (double)(MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
            motionY = (double)(-MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F));
            setThrowableHeading(p, motionX, motionY, motionZ, s * (float)JRMCoreConfig.Flngspd, 0.0F);
            if (sec <= 0.0F || dodge_forwSwTm == 2) {
               sec = 10.0F;
               triForce(4, 0, dodge_forwSwTm == 2 ? 5 : 4);
               chargePart(false);
            }

            if (dodge_forwSwTm == 2) {
               KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
            }
         }

         if (dodge_forwDash_STE && !dodge_forwHold) {
            dodge_forwDash_STE = false;
            floating = true;
            dodge_forwSwTm = 0;
            KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
         }
      } else if (dodge_forwHold && dodge_forwDash_STE) {
         dodge_forwDash_STE = false;
         floating = true;
         dodge_forwSwTm = 0;
         KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
      }

      if (sec > 0.0F) {
         --sec;
      }

      boolean isSwooping = JRMCoreH.StusEfctsMe(7);
      if (isSwooping && !dodge_forwDash_STE && sent <= 0.0F) {
         sent = JRMCoreCliTicH.counterValue * 0.5F;
         JRMCoreH.Skll((byte)5, (byte)1, (byte)7);
      } else if (!isSwooping && dodge_forwDash_STE && sent <= 0.0F) {
         sent = JRMCoreCliTicH.counterValue * 0.5F;
         JRMCoreH.Skll((byte)5, (byte)0, (byte)7);
      } else if (sent > 0.0F && sent <= 1.0F && !isSwooping && !dodge_forwDash_STE) {
         sent = 0.0F;
      } else if (sent > 0.0F && sent <= 1.0F && isSwooping && dodge_forwDash_STE) {
         sent = 0.0F;
      }

      if (sent > 0.0F) {
         --sent;
      }

      int cost = (int)(1.0F + add);
      boolean able = true;
      boolean b = n == 0;
      if (DBCConfig.flyAnyLvl) {
         b = false;
      }

      if (JRMCoreH.curEnergy < cost || b) {
         able = false;
      }

      EntityClientPlayerMP var10000;
      float par2;
      float par1;
      if (DBCConfig.oldFly) {
         if (isPressed(kiFlight) || isPressed(JRMCoreKeyHandler.Fn) && isPressed(kiFlight) && able) {
            ++floatTime;
            if (floatTime >= 20) {
               JRMCoreH.Cost(cost);
               floatTime = 0;
            }

            if (isPressed(JRMCoreKeyHandler.Fn)) {
               var10000 = DBCClient.mc.field_71439_g;
               var10000.field_70181_x /= 15.15D;
            } else {
               DBCClient.mc.field_71439_g.field_70181_x = (double)(0.6F * add * (float)JRMCoreConfig.Flngspd);
            }

            par1 = p.field_70702_br;
            par2 = p.field_70701_bs;
            if (!isPressed(DBCClient.mc.field_71474_y.field_74351_w) && !isPressed(DBCClient.mc.field_71474_y.field_74368_y) && !isPressed(DBCClient.mc.field_71474_y.field_74370_x) && !isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
               p.field_70159_w = 0.0D;
               p.field_70179_y = 0.0D;
               floatMultAdded = false;
            } else {
               mv(par1, par2, p, add);
               floatMultAdded = true;
            }
         }
      } else {
         if (isPressed(kiFlight)) {
            KeyBinding.func_74510_a(kiFlight.func_151463_i(), false);
            if (able) {
               if (!floating) {
                  if (p.field_70122_E) {
                     DBCClient.mc.field_71439_g.field_70181_x = 0.5D;
                     jumpToFly = true;
                  }
               } else {
                  floatMultAdded = false;
               }

               floating = !floating;
            }
         }

         if (floating && able && !p.field_70122_E) {
            ++floatTime;
            if (floatTime >= 20) {
               JRMCoreH.Cost(cost);
               floatTime = 0;
            }

            if (isPressed(keyBindJump)) {
               jumpRel = true;
               DBCClient.mc.field_71439_g.field_70181_x = (double)(0.25F * add * (float)JRMCoreConfig.Flngspd);
            } else if (isPressed(keyBindSneak)) {
               if (DBCClient.mc.field_71439_g.field_70181_x > (double)(-(0.25F * add))) {
                  DBCClient.mc.field_71439_g.field_70181_x = (double)(-(0.25F * add) * (float)JRMCoreConfig.Flngspd);
               }
            } else if (p.field_70181_x < 0.0D) {
               var10000 = DBCClient.mc.field_71439_g;
               var10000.field_70181_x /= !JRMCoreH.isShtng && JRMCoreConfig.PlayerFlyingDragDownOn ? 15.15D : 150.15D;
            }

            par1 = p.field_70702_br;
            par2 = p.field_70701_bs;
            if (!isPressed(DBCClient.mc.field_71474_y.field_74351_w) && !isPressed(DBCClient.mc.field_71474_y.field_74368_y) && !isPressed(DBCClient.mc.field_71474_y.field_74370_x) && !isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
               p.field_70159_w = 0.0D;
               p.field_70179_y = 0.0D;
               floatMultAdded = false;
            } else {
               if (JRMCoreH.StusEfctsMe(9) && !JRMCoreH.StusEfctsMe(4) && !isPressed(DBCClient.mc.field_71474_y.field_74368_y) && !isPressed(DBCClient.mc.field_71474_y.field_74370_x) && !isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
                  float wei = JRMCoreH.weightPerc(1);
                  float s = add * wei;
                  int back = 0;
                  int right = 0;
                  int left = 0;
                  double motionX = (double)(-MathHelper.func_76126_a((p.field_70177_z + (float)back + (float)left + (float)right) / 180.0F * 3.1415927F) * MathHelper.func_76134_b(p.field_70125_A / 180.0F * 3.1415927F));
                  double motionZ = (double)(MathHelper.func_76134_b((p.field_70177_z + (float)back + (float)left + (float)right) / 180.0F * 3.1415927F) * MathHelper.func_76134_b(p.field_70125_A / 180.0F * 3.1415927F));
                  double motionY = (double)(-MathHelper.func_76126_a((p.field_70125_A + (float)back) / 180.0F * 3.1415927F));
                  setThrowableHeading(p, motionX, motionY, motionZ, s * (float)JRMCoreConfig.Flngspd, 0.0F);
               } else {
                  mv(par1, par2, p, add * (float)JRMCoreConfig.Flngspd);
               }

               floatMultAdded = true;
            }
         }

         if (floating && p.field_70122_E) {
            if (jumpToFly) {
               jumpToFly = false;
            } else {
               floating = false;
               floatMultAdded = false;
            }
         }
      }

   }

   public static void mv(float strafe, float frward, EntityPlayer var4, float add) {
      float f3 = strafe * strafe + frward * frward;
      if (f3 >= 1.0E-4F) {
         f3 = MathHelper.func_76129_c(f3);
         if (f3 < 1.0F) {
            f3 = 1.0F;
         }

         f3 = add / f3;
         float f4 = MathHelper.func_76126_a(var4.field_70177_z * 3.1415927F / 180.0F);
         float f5 = MathHelper.func_76134_b(var4.field_70177_z * 3.1415927F / 180.0F);
         float pitch = MathHelper.func_76126_a(var4.field_70125_A * 3.1415927F / 180.0F);
         float speedY = 1.0F - (pitch < 0.0F ? -pitch : pitch);
         strafe *= f3;
         frward *= f3;
         float speed = var4.field_70122_E ? 0.25F : 0.25F;
         var4.field_70159_w = (double)((strafe * f5 - frward * f4) * speed);
         var4.field_70179_y = (double)((frward * f5 + strafe * f4) * speed);
      }

   }

   public static void DashKi(boolean sprint) {
      EntityPlayer var4 = DBCClient.mc.field_71439_g;
      World var3 = DBCClient.mc.field_71441_e;
      int n = JRMCoreH.SklLvl(2, (byte)1);
      int st = JRMCoreH.StusEfctsMe(13) ? (JRMCoreH.rc_sai(JRMCoreH.Race) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) - 1) : (JRMCoreH.rc_arc(JRMCoreH.Race) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_humNam(JRMCoreH.Race) ? JRMCoreH.mstc_humnam() : 1))) : JRMCoreH.State;
      float inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 7, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
      float add = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[1], n, (float)JRMCoreH.curRelease, turbo, false, st, JRMCoreH.State2, inc);
      int cost = (int)(1.0F + add);
      int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts();
      byte pwr = JRMCoreH.Pwrtyp;
      byte rce = JRMCoreH.Race;
      byte cls = JRMCoreH.Class;
      int maxStam = JRMCoreH.stat(var4, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
      int ce = JRMCoreH.curStamina;
      int cst = (int)((float)maxStam * 0.2F - (float)n * 0.01F);
      boolean left = JRMCoreClient.mc.field_71474_y.field_74370_x.func_151468_f();
      boolean right = JRMCoreClient.mc.field_71474_y.field_74366_z.func_151468_f();
      boolean back = JRMCoreClient.mc.field_71474_y.field_74368_y.func_151468_f();
      boolean dodge = !JRMCoreH.PlyrSettingsB(2);
      long ctm = System.currentTimeMillis() / 1000L;
      if (dodge_per == 0 && dodge_recently != ctm && isPressed(JRMCoreKeyHandler.Fn) && !isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G) && !isPressed(JRMCoreKeyHandler.KiCharge) && !isPressed(JRMCoreKeyHandler.KiAscend)) {
         dodge_per = !left && !right && !back ? 0 : 1;
      } else if (dodge_recently == ctm) {
         dodge_per = 0;
      }

      double par12;
      double par22;
      if (dodge_per > 0 && dodge_recently != ctm && ce > cst && n > 0 && dodge && JRMCoreH.curRelease > 0) {
         int y = JRMCoreClient.mc.field_71439_g.field_70122_E ? 2 : 1;
         if (left) {
            dodge_recently = ctm;
            par12 = Math.cos((double)(JRMCoreClient.mc.field_71439_g.field_70177_z - 90.0F) * 3.141592653589793D / 180.0D) * 1.5D * (double)y;
            par22 = Math.sin((double)(JRMCoreClient.mc.field_71439_g.field_70177_z - 90.0F) * 3.141592653589793D / 180.0D) * -1.5D * (double)y;
            JRMCoreClient.mc.field_71439_g.field_70179_y = par12;
            JRMCoreClient.mc.field_71439_g.field_70159_w = par22;
            triForce(4, 0, 0);
         }

         if (right) {
            dodge_recently = ctm;
            par12 = Math.cos((double)(JRMCoreClient.mc.field_71439_g.field_70177_z + 90.0F) * 3.141592653589793D / 180.0D) * 1.5D * (double)y;
            par22 = Math.sin((double)(JRMCoreClient.mc.field_71439_g.field_70177_z + 90.0F) * 3.141592653589793D / 180.0D) * -1.5D * (double)y;
            JRMCoreClient.mc.field_71439_g.field_70179_y = par12;
            JRMCoreClient.mc.field_71439_g.field_70159_w = par22;
            triForce(4, 0, 1);
         }

         if (back) {
            dodge_recently = ctm;
            par12 = Math.cos((double)JRMCoreClient.mc.field_71439_g.field_70177_z * 3.141592653589793D / 180.0D) * -1.0D * (double)y;
            par22 = Math.sin((double)JRMCoreClient.mc.field_71439_g.field_70177_z * 3.141592653589793D / 180.0D) * 1.0D * (double)y;
            JRMCoreClient.mc.field_71439_g.field_70179_y = par12;
            JRMCoreClient.mc.field_71439_g.field_70159_w = par22;
            triForce(4, 0, 3);
         }

         dodge_per = 0;
         KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
      }

      boolean able = true;
      if (JRMCoreH.curEnergy < cost || dodge_forwHold) {
         able = false;
      }

      if (able && sprint && !floating && JRMCoreH.curRelease > 0) {
         ++dash;
         if (dash >= 20) {
            JRMCoreH.Cost(cost);
            dash = 0;
         }

         par12 = var4.field_70165_t;
         par22 = var4.field_70163_u;
         double par32 = var4.field_70161_v;
         if (var3.func_147439_a((int)par12, (int)par22 - 2, (int)par32) != Blocks.field_150432_aD) {
            float par1 = var4.field_70702_br;
            float par2 = var4.field_70701_bs;
            if (!isPressed(DBCClient.mc.field_71474_y.field_74351_w) && !isPressed(DBCClient.mc.field_71474_y.field_74368_y) && !isPressed(DBCClient.mc.field_71474_y.field_74370_x) && !isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
               var4.field_70159_w = 0.0D;
               var4.field_70179_y = 0.0D;
               floatMultAdded = false;
            } else {
               mv(par1, par2, var4, add);
               floatMultAdded = true;
            }
         }
      }

   }

   public static void setThrowableHeading(Entity e, double par1, double par3, double par5, float par7, float par8) {
      Random rand = e.field_70170_p.field_73012_v;
      par1 *= (double)par7;
      par3 *= (double)par7;
      par5 *= (double)par7;
      float s = e.field_70122_E ? 0.25F : 0.25F;
      e.field_70159_w = par1 * (double)s;
      e.field_70181_x = par3 * (double)s;
      e.field_70179_y = par5 * (double)s;
   }

   public static void TurboMode(KeyBinding key) {
      EntityPlayer var4 = DBCClient.mc.field_71439_g;
      if (isPressed(key)) {
         KeyBinding.func_74510_a(key.func_151463_i(), false);
         if (!turbo) {
            turbo = true;
            JRMCoreH.Skll((byte)5, (byte)0, (byte)3);
            JRMCoreH.jrmct(3);
         } else if (turbo) {
            turbo = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)3);
            JRMCoreH.jrmct(3);
         }
      }

      if (JRMCoreH.curEnergy <= 0) {
         turbo = false;
         ++ton;
         if (ton > 10) {
            JRMCoreH.Skll((byte)5, (byte)1, (byte)3);
            JRMCoreH.jrmct(3);
            ton = 0;
         }
      }

   }

   public static void EnAt(byte selc) {
      PD.sendToServer(new DBCPenergy(selc, (byte)0));
   }

   public static void EnAt(byte selc, byte p) {
      PD.sendToServer(new DBCPenergy(selc, p));
   }

   public static void EnAtSlct(byte b) {
      byte selct = JRMCoreH.EnAtSlct;
      JRMCoreH.EnAtSlct = (byte)(selct + (b == 1 ? -1 : 1));
      if (JRMCoreH.EnAtSlct > (JRMCoreH.mrAtts ? 7 : 3)) {
         JRMCoreH.EnAtSlct = 0;
      } else if (JRMCoreH.EnAtSlct < 0) {
         JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts ? 7 : 3);
      }

   }

   public static boolean KAkiEn(byte s, byte r, byte p) {
      String[] tech = JRMCoreH.tech(s);
      short cost = (short)(JRMCoreH.maxEnergy + 1);
      if (tech != null) {
         if (s < 4) {
            cost = (short)((int)((float)(JRMCoreH.costEnAt(tech) * r) * 0.02F * (float)p * 0.02F));
         } else {
            cost = (short)((int)((float)(Short.parseShort(tech[7]) * r) * 0.02F * (float)p * 0.02F * (float)(JRMCoreH.State + 1)));
         }

         if (JRMCoreH.curEnergy >= cost) {
            return JRMCoreH.curEnergy >= cost;
         }

         DBCClientTickHandler.nuller();
         KeyBinding var10000 = DBCClient.mc.field_71474_y.field_74313_G;
         KeyBinding.func_74510_a(DBCClient.mc.field_71474_y.field_74313_G.func_151463_i(), false);
      }

      return false;
   }

   public static boolean isPressed(KeyBinding k) {
      return k.func_151470_d();
   }

   public static void Ascend(KeyBinding k) {
      boolean useOozaru = false;
      boolean rotPit = DBCClient.mc.field_71439_g.field_70125_A <= -90.0F;
      boolean canUseQuickTransform = false;
      if (!isPressed(k)) {
         wasTransformPressed = false;
      }

      boolean useGodOfDestruction;
      boolean playerSettingsBlueOn;
      boolean playerSettingsBlueOnInBlue;
      boolean playerSettingsGodOn;
      int godSkillLevel;
      if (rotPit) {
         int n = 200;
         EntityPlayer pl = DBCClient.mc.field_71439_g;
         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(pl.field_70165_t - (double)n, 200.0D, pl.field_70161_v - (double)n, pl.field_70165_t + (double)n, 255.0D, pl.field_70161_v + (double)n);
         List l = pl.field_70170_p.func_72872_a(EntityEnergyFM.class, aabb);
         useGodOfDestruction = !l.isEmpty();
         playerSettingsBlueOn = JRMCoreH.StusEfctsMe(8) || useGodOfDestruction;
         playerSettingsBlueOnInBlue = JRMCoreH.tailHas(JRMCoreH.TlMd);
         playerSettingsGodOn = false;

         for(godSkillLevel = (int)pl.field_70163_u; godSkillLevel < 256; ++godSkillLevel) {
            int x = (int)pl.field_70165_t;
            int z = (int)pl.field_70161_v;
            playerSettingsGodOn = DBCClient.mc.field_71441_e.func_147437_c(x < 0 ? x - 1 : x, godSkillLevel, z < 0 ? z - 1 : z);
            if (!playerSettingsGodOn) {
               break;
            }
         }

         useOozaru = playerSettingsGodOn && playerSettingsBlueOnInBlue && JRMCoreH.State == 0 && JRMCoreH.rSai() && playerSettingsBlueOn && rotPit;
      }

      boolean isTransformKeyPressed = useOozaru ? true : isPressed(k);
      boolean useKaioken = JRMCoreH.PlyrSettingsB(0) && JRMCoreH.SklLvl(8) > 0;
      boolean isInUltraInstinct = JRMCoreH.StusEfctsMe(19) && JRMCoreH.SklLvl(16) < JRMCoreH.State2 && JRMCoreH.State2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS;
      boolean useUltraInstinct2 = JRMCoreH.SklLvl(16) > JRMCoreH.State2 && JRMCoreH.State2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS;
      useGodOfDestruction = JRMCoreH.SklLvl(18) > 0;
      playerSettingsBlueOn = JRMCoreH.PlyrSettingsI(1, 2) && JRMCoreH.State == 0;
      playerSettingsBlueOnInBlue = JRMCoreH.PlyrSettingsI(1, 2) && (JRMCoreH.State == 10 || JRMCoreH.State == 9);
      playerSettingsGodOn = JRMCoreH.PlyrSettingsI(1, 1) && (JRMCoreH.State == 9 || JRMCoreH.State == 10);
      godSkillLevel = JRMCoreH.SklLvl(9);
      boolean isInKaioken = JRMCoreH.StusEfctsMe(5);
      boolean isInMystic = JRMCoreH.StusEfctsMe(13);
      boolean isInGoD = JRMCoreH.StusEfctsMe(20);
      boolean isInUI = JRMCoreH.StusEfctsMe(19);
      boolean isInBase = JRMCoreH.State == (JRMCoreH.isRaceArcosian() ? 4 : 0);
      boolean isMajinAbsorptionModeOn = JRMCoreH.StusEfctsMe(21);
      boolean ascended = false;
      boolean useMajinAbsorption = JGConfigRaces.CONFIG_MAJIN_ENABLED && JRMCoreH.isRaceMajin() && isMajinAbsorptionModeOn;
      if (isTransformKeyPressed) {
         if (!holdingForTransform) {
            if (holdingTransformTimer == null) {
               holdingTransformTimer = Instant.now();
            } else if (Duration.between(holdingTransformTimer, Instant.now()).toMillis() > 200L) {
               holdingForTransform = true;
            }
         }
      } else {
         holdingTransformTimer = null;
         holdingForTransform = false;
         sentAbsorption = false;
      }

      if (useMajinAbsorption || !isPressed(k) || (!isInMystic || DBCConfig.MysticKaiokenOn && useKaioken) && !isInGoD) {
         float en;
         byte p;
         float re;
         byte p;
         if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(6) && !JRMCoreH.StusEfctsMe(13)) {
            if (!DBCConfig.MysticKaiokenOn && (JRMCoreH.StusEfctsMe(5) || JRMCoreH.State2 != 0)) {
               return;
            }

            if (DBCConfig.IsInstantTransformEnabled[2]) {
               canUseQuickTransform = true;
            }

            if (holdingForTransform) {
               ++ptime;
               p = 12;
               if (ptime >= p) {
                  ptime = 0;
                  JRMCoreH.Cost(1);
                  p = 10;
                  p = p > 100 ? 100 : p;
                  triForce(1, 0, p);
               }

               ++time;
               if (JRMCoreH.curRelease < 50 && time >= 10) {
                  label1244: {
                     time = 0;
                     en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                     re = (float)JRMCoreH.curRelease;
                     en = en > 75.0F ? 75.0F : en;
                     if (re >= 50.0F) {
                        if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                           break label1244;
                        }
                     } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
                        break label1244;
                     }

                     JRMCoreH.Rls((byte)1);
                  }
               }

               ++pup;
               ++pup2;
               if (pup >= 33 || pup2 == 1) {
                  String ar = "jinryuudragonbc:DBC.aura";
                  soundAsc(ar);
                  pup = 0;
               }

               ++ascend;
               p = 10;
               if (ascend >= p && JRMCoreH.TransSaiCurRg >= 100) {
                  Ascndng();
                  JRMCoreH.Rls((byte)1);
                  soundAsc(4);
                  ascend = 0;
                  ptime = 0;
                  partnorm = 0;
                  pup = 0;
                  pup2 = 0;
               }

               ascended = true;
               if (ascended) {
                  if (!ascending) {
                     ascending = true;
                     JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
                  }
               } else if (ascending) {
                  ascending = false;
                  JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
               }
            }
         } else {
            boolean s;
            byte s;
            if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(16) && !JRMCoreH.StusEfctsMe(20)) {
               if (isClientMoving()) {
                  if (JRMCoreH.StusEfctsMe(1)) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  }

                  return;
               }

               s = isInBase && useGodOfDestruction && !isInMystic && !isInUI && !isInKaioken && JRMCoreH.SklLvl(9) > (JRMCoreH.rSai(JRMCoreH.Race) ? 1 : 0);
               if (s) {
                  if (DBCConfig.IsInstantTransformEnabled[3]) {
                     canUseQuickTransform = true;
                  }

                  if (holdingForTransform) {
                     ++ptime;
                     p = 10;
                     if (ptime >= p) {
                        ptime = 0;
                        JRMCoreH.Cost(1);
                        s = 10;
                        s = s > 100 ? 100 : s;
                        triForce(1, 0, s);
                     }

                     ++ascend;
                     s = 10;
                     if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                        Ascndng();
                        JRMCoreH.Rls((byte)1);
                        soundAsc(4);
                        ascend = 0;
                        ptime = 0;
                        partnorm = 0;
                        pup = 0;
                        pup2 = 0;
                     }
                  }
               }

               if (holdingForTransform) {
                  ascended = true;
                  if (ascended) {
                     if (!ascending) {
                        ascending = true;
                        JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
                     }
                  } else if (ascending) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  }
               }
            } else if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(11) && !isInUltraInstinct) {
               if (isClientMoving()) {
                  if (JRMCoreH.StusEfctsMe(1)) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  }

                  return;
               }

               s = isInBase && !isInMystic && !JRMCoreH.StusEfctsMe(12) && !JRMCoreH.StusEfctsMe(5) && !JRMCoreH.pnh && !JRMCoreH.StusEfctsMe(18) && JRMCoreH.SklLvl(9) > (JRMCoreH.rSai(JRMCoreH.Race) ? 1 : 0) && useUltraInstinct2;
               if (s) {
                  if (DBCConfig.IsInstantTransformEnabled[1]) {
                     canUseQuickTransform = true;
                  }

                  if (holdingForTransform) {
                     ++ptime;
                     p = 10;
                     if (ptime >= p) {
                        ptime = 0;
                        JRMCoreH.Cost(1);
                        s = 10;
                        s = s > 100 ? 100 : s;
                        triForce(1, 0, s);
                        triForce(5, 0, 0);
                     }

                     ++ascend;
                     s = 10;
                     if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                        Ascndng();
                        JRMCoreH.Rls((byte)1);
                        soundAsc(4);
                        ascend = 0;
                        ptime = 0;
                        partnorm = 0;
                        pup = 0;
                        pup2 = 0;
                     }
                  }
               }

               if (holdingForTransform) {
                  ascended = true;
                  if (ascended) {
                     if (!ascending) {
                        ascending = true;
                        JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
                     }
                  } else if (ascending) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  }
               }
            } else if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(4) && !JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11)) {
               if (!wasTransformPressed) {
                  if (JRMCoreH.PlyrSettingsB(4)) {
                     String ar = "jinryuudragonbc:DBC.fusestrt";
                     soundAsc(ar);
                  }

                  wasTransformPressed = true;
               }

               ++ptime;
               p = 12;
               if (ptime >= p) {
                  ptime = 0;
                  JRMCoreH.Cost(1);
                  p = 10;
                  p = p > 100 ? 100 : p;
                  triForce(1, 0, p);
               }

               ++ascend;
               p = 10;
               if (ascend >= p && JRMCoreH.TransSaiCurRg >= 100) {
                  Ascndng();
                  JRMCoreH.Rls((byte)1);
                  ascend = 0;
                  ptime = 0;
                  partnorm = 0;
                  pup = 0;
                  pup2 = 0;
               }
            } else {
               boolean isAbsorption;
               if (useKaioken && !useOozaru) {
                  ascended = isTransformKeyPressed && (float)JRMCoreH.curBody > (float)JRMCoreH.maxBody * 0.05F && JRMCoreH.SklLvl(8) > JRMCoreH.State2 && JRMCoreH.State2 < JRMCoreH.TransKaiDmg.length - 1;
                  if (ascended) {
                     if (!ascendingK) {
                        ascendingK = true;
                        JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
                     }
                  } else if (ascendingK) {
                     ascendingK = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
                  } else if (ascending) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  }

                  if (ascended) {
                     if (DBCConfig.IsInstantTransformEnabled[0]) {
                        canUseQuickTransform = true;
                     }

                     if (holdingForTransform) {
                        ++pup;
                        ++pup2;
                        if (pup >= 33 || pup2 == 1) {
                           soundAsc(2);
                           pup = 0;
                        }

                        ++ascend;
                        s = true;
                        if (ascend >= 20 + (10 - JRMCoreH.SklLvl(8)) * 10) {
                           Ascndng();
                           isAbsorption = JRMCoreH.State2 > 0 && JRMCoreH.StusEfctsMe(5);
                           String ar = "jinryuudragonbc:DBC3.force";
                           if (isAbsorption && JRMCoreH.rc_sai(JRMCoreH.Race) && JRMCoreH.State == 10) {
                              ar = "jinryuudragonbc:1610.aurabks";
                           }

                           soundAsc(ar);
                           ascend = 0;
                           ptime = 0;
                           partnorm = 0;
                           pup = 0;
                           pup2 = 0;
                        }
                     }
                  } else if (!isTransformKeyPressed) {
                     ascend = 0;
                  }
               } else {
                  int racialSkillLvl;
                  int p;
                  int ic;
                  if (isTransformKeyPressed && JRMCoreH.isRaceArcosian() && canAttemptTransformation() && !JRMCoreH.isInState(5) && !JRMCoreH.isInState(6)) {
                     if (hasRacialSkillLevel()) {
                        racialSkillLvl = getClientRacialSkillLevel();
                        if (JRMCoreH.State < 4 || racialSkillLvl >= 3 && JRMCoreH.State == 4) {
                           if (isClientMoving()) {
                              if (JRMCoreH.StusEfctsMe(1)) {
                                 ascending = false;
                                 JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                              }

                              return;
                           }

                           canUseQuickTransform = true;
                           if (holdingForTransform) {
                              ascended = true;
                              ++time;
                              if (JRMCoreH.curRelease < 50 && time >= 10) {
                                 label1214: {
                                    time = 0;
                                    en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                                    re = (float)JRMCoreH.curRelease;
                                    en = en > 75.0F ? 75.0F : en;
                                    if (re >= 50.0F) {
                                       if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                                          break label1214;
                                       }
                                    } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
                                       break label1214;
                                    }

                                    JRMCoreH.Rls((byte)1);
                                 }
                              }

                              ++pup;
                              ++pup2;
                              if (pup >= 33 || pup2 == 1) {
                                 soundAsc(2);
                                 pup = 0;
                              }

                              ++ptime;
                              p = racialSkillLvl >= 3 ? 10 : (racialSkillLvl >= 2 ? 13 : 15);
                              if (ptime >= p) {
                                 ptime = 0;
                                 JRMCoreH.Cost(1);
                                 ic = (racialSkillLvl >= 3 ? 15 : (racialSkillLvl >= 2 ? 10 : 5)) * (JRMCoreH.State > 3 ? 1 : 4);
                                 ic = ic > 100 ? 100 : ic;
                                 triForce(1, 0, ic);
                              }

                              ++ascend;
                              s = 10;
                              if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                                 Ascndng();
                                 soundAsc(4);
                                 ascended = true;
                                 ascend = 0;
                                 ptime = 0;
                                 partnorm = 0;
                                 pup = 0;
                                 pup2 = 0;
                                 JRMCoreH.kiInSuper = racialSkillLvl >= 2 ? 2 : 1;
                              }
                           }
                        }
                     }
                  } else {
                     label1429: {
                        boolean isSuperOozaru;
                        boolean isBlue;
                        float en;
                        float re;
                        int ic;
                        byte s;
                        int p;
                        if (isTransformKeyPressed && JRMCoreH.isRaceSaiyan() && canAttemptTransformation() && !JRMCoreH.isInState(3) && !JRMCoreH.isInState(6) && !JRMCoreH.isInState(13)) {
                           label1403: {
                              if (godSkillLevel > 2) {
                                 if (JRMCoreH.isInState(15)) {
                                    break label1403;
                                 }
                              } else if (godSkillLevel > 1) {
                                 if (JRMCoreH.isInState(10)) {
                                    break label1403;
                                 }
                              } else if (JRMCoreH.isInState(9)) {
                                 break label1403;
                              }

                              if (!hasRacialSkillLevel()) {
                                 break label1429;
                              }

                              racialSkillLvl = getClientRacialSkillLevel();
                              isAbsorption = racialSkillLvl >= 1 && JRMCoreH.isInState(7);
                              isSuperOozaru = racialSkillLvl >= 6 && JRMCoreH.isInState(8);
                              isBlue = JRMCoreH.isInState(10) && godSkillLevel > 2 && racialSkillLvl >= 6;
                              if (!useOozaru && !isAbsorption && !isSuperOozaru && !isBlue && (racialSkillLvl < 1 || JRMCoreH.State >= racialSkillLvl && (1 >= racialSkillLvl || !playerSettingsGodOn) && (1 >= racialSkillLvl || !playerSettingsBlueOnInBlue) && (!JRMCoreH.isInState(4) || 1 >= racialSkillLvl))) {
                                 break label1429;
                              }

                              if (isClientMoving()) {
                                 if (JRMCoreH.StusEfctsMe(1)) {
                                    ascending = false;
                                    JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                                 }

                                 return;
                              }

                              canUseQuickTransform = true;
                              if (!holdingForTransform) {
                                 break label1429;
                              }

                              ascended = true;
                              ++time;
                              if (JRMCoreH.curRelease < 50 && time >= 10) {
                                 label1218: {
                                    time = 0;
                                    en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                                    re = (float)JRMCoreH.curRelease;
                                    en = en > 75.0F ? 75.0F : en;
                                    if (re >= 50.0F) {
                                       if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                                          break label1218;
                                       }
                                    } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
                                       break label1218;
                                    }

                                    JRMCoreH.Rls((byte)1);
                                 }
                              }

                              ++pup;
                              ++pup2;
                              if (pup >= 33 || pup2 == 1) {
                                 String ar = "jinryuudragonbc:DBC.aura";
                                 if (!useOozaru && JRMCoreH.StusEfctsMe(14)) {
                                    ar = "jinryuudragonbc:DBC.aura";
                                 } else if (useOozaru || !playerSettingsGodOn && !playerSettingsBlueOn && !playerSettingsBlueOnInBlue) {
                                    if (useOozaru) {
                                       ar = "jinryuudragonbc:1610.oozt";
                                    }
                                 } else {
                                    ar = "jinryuudragonbc:1610.aurab";
                                 }

                                 soundAsc(ar);
                                 pup = 0;
                              }

                              ++ptime;
                              p = useOozaru ? 15 : (racialSkillLvl >= 3 ? 5 : (racialSkillLvl >= 2 ? 7 : 10));
                              if (ptime >= p) {
                                 ptime = 0;
                                 JRMCoreH.Cost(1);
                                 ic = useOozaru ? 15 : (isAbsorption ? 5 : (racialSkillLvl >= 4 ? 15 : (racialSkillLvl >= 2 ? 10 : 5)));
                                 ic = ic > 100 ? 100 : ic;
                                 triForce(1, 0, ic);
                              }

                              ++ascend;
                              s = 10;
                              if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                                 Ascndng();
                                 String ar = "jinryuudragonbc:DBC.ascend";
                                 if (useOozaru) {
                                    ar = "jinryuudragonbc:DBC3.force";
                                 } else {
                                    ar = "jinryuudragonbc:1610.sss";
                                 }

                                 soundAsc(ar);
                                 ascended = true;
                                 ascend = 0;
                                 ptime = 0;
                                 partnorm = 0;
                                 pup = 0;
                                 pup2 = 0;
                                 JRMCoreH.kiInSuper = racialSkillLvl >= 2 ? 2 : 1;
                              }
                              break label1429;
                           }
                        }

                        if (!isTransformKeyPressed || !JRMCoreH.isRaceMajin() || !canAttemptTransformation() || JRMCoreH.State >= (godSkillLevel > 0 ? 4 : 3) && !isMajinAbsorptionModeOn) {
                           if (isTransformKeyPressed && JRMCoreH.isRaceHumanOrNamekian() && canAttemptTransformation() && JRMCoreH.isInState(0)) {
                              if (hasRacialSkillLevel()) {
                                 racialSkillLvl = getClientRacialSkillLevel();
                                 if (racialSkillLvl != 0 && racialSkillLvl >= 1) {
                                    canUseQuickTransform = true;
                                    if (isClientMoving()) {
                                       if (JRMCoreH.StusEfctsMe(1)) {
                                          ascending = false;
                                          JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                                       }

                                       return;
                                    }

                                    if (holdingForTransform) {
                                       ascended = true;
                                       ++time;
                                       if (time >= 7) {
                                          label1227: {
                                             time = 0;
                                             en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                                             re = (float)JRMCoreH.curRelease;
                                             en = en > 75.0F ? 75.0F : en;
                                             if (re >= 50.0F) {
                                                if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                                                   break label1227;
                                                }
                                             } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
                                                break label1227;
                                             }

                                             JRMCoreH.Rls((byte)1);
                                          }
                                       }

                                       ++pup;
                                       ++pup2;
                                       if (pup >= 33 || pup2 == 1) {
                                          soundAsc(2);
                                          pup = 0;
                                       }

                                       ++ptime;
                                       p = racialSkillLvl >= 3 ? 5 : (racialSkillLvl >= 2 ? 7 : 10);
                                       if (ptime >= p) {
                                          ptime = 0;
                                          JRMCoreH.Cost(1);
                                          ic = (racialSkillLvl >= 3 ? 15 : (racialSkillLvl >= 2 ? 10 : 5)) * 2;
                                          ic = ic > 100 ? 100 : ic;
                                          triForce(1, 0, ic);
                                       }

                                       ++ascend;
                                       s = 10;
                                       if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                                          Ascndng();
                                          soundAsc(4);
                                          ascended = true;
                                          ascend = 0;
                                          ptime = 0;
                                          partnorm = 0;
                                          pup = 0;
                                          pup2 = 0;
                                       }
                                    }
                                 }
                              }
                           } else if (JRMCoreH.TransSaiCurRg > 0) {
                              ++ptime;
                              if (ptime >= 40) {
                                 triForce(1, 1, 100);
                                 ptime = 0;
                              }
                           }
                        } else if (JGConfigRaces.CONFIG_MAJIN_ENABLED && hasRacialSkillLevel()) {
                           racialSkillLvl = getClientRacialSkillLevel();
                           isAbsorption = JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED && racialSkillLvl >= 4 && isMajinAbsorptionModeOn;
                           isSuperOozaru = JRMCoreH.PlyrSettingsI(1, 0);
                           isBlue = isMajinAbsorptionModeOn ? isAbsorption && !sentAbsorption : (JRMCoreH.isInState(0) ? (playerSettingsGodOn ? godSkillLevel > 0 && JRMCoreHDBC.hasMajinGodRacialRequirement(racialSkillLvl) : racialSkillLvl >= (isSuperOozaru ? 5 : 2)) : (isSuperOozaru ? false : racialSkillLvl >= 3 && !JRMCoreH.isInState(2)));
                           if (isBlue) {
                              canUseQuickTransform = !isAbsorption;
                              if (isClientMoving()) {
                                 if (JRMCoreH.StusEfctsMe(1)) {
                                    ascending = false;
                                    JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                                 }

                                 return;
                              }

                              if (holdingForTransform) {
                                 if (!isAbsorption) {
                                    ascended = true;
                                 }

                                 ++time;
                                 if (time >= 7) {
                                    time = 0;
                                    en = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                                    re = (float)JRMCoreH.curRelease;
                                    en = en > 75.0F ? 75.0F : en;
                                    if (!isAbsorption) {
                                       label970: {
                                          if (re >= 50.0F) {
                                             if (!(re - 50.0F < (en - 50.0F) * 2.0F)) {
                                                break label970;
                                             }
                                          } else if (!(re < (en <= 10.0F ? en * 5.0F : 50.0F))) {
                                             break label970;
                                          }

                                          JRMCoreH.Rls((byte)1);
                                       }
                                    }
                                 }

                                 ++pup;
                                 ++pup2;
                                 if (pup >= 33 || pup2 == 1) {
                                    if (!isAbsorption) {
                                       soundAsc(2);
                                    }

                                    pup = 0;
                                 }

                                 ++ptime;
                                 p = (racialSkillLvl >= 3 ? 5 : (racialSkillLvl >= 2 ? 7 : 10)) * (isAbsorption ? 3 : 1);
                                 if (ptime >= p) {
                                    ptime = 0;
                                    if (!isAbsorption) {
                                       JRMCoreH.Cost(1);
                                    }

                                    ic = (racialSkillLvl >= 3 ? 15 : (racialSkillLvl >= 2 ? 10 : 5)) * 2;
                                    ic = ic > 100 ? 100 : ic;
                                    triForce(1, 0, ic);
                                 }

                                 ++ascend;
                                 s = 10;
                                 if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
                                    if (isAbsorption) {
                                       EnAt(DBCPacketHandlerServer.MAJIN_ABSORPTION, (byte)0);
                                       sentAbsorption = true;
                                    } else {
                                       Ascndng();
                                       soundAsc(4);
                                    }

                                    ascended = true;
                                    ascend = 0;
                                    ptime = 0;
                                    partnorm = 0;
                                    pup = 0;
                                    pup2 = 0;
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (ascended) {
                     if (!ascending) {
                        ascending = true;
                        JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
                     }
                  } else if (ascending) {
                     ascending = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
                  } else if (ascendingK) {
                     ascendingK = false;
                     JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
                  }
               }
            }
         }
      }

      if (JRMCoreH.State2 > 0 && !ascendingK) {
         ascendingK = true;
         if (!JRMCoreH.StusEfctsMe(19)) {
            JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
         }
      }

      if (DBCConfig.InstantTransformOn) {
         if (isTransformKeyPressed) {
            if (canUseQuickTransform && !quickTransformAdded) {
               quickTransformAdded = true;
               if (quickTransformTimer == null) {
                  quickTransformTimer = Instant.now();
               } else if (Duration.between(quickTransformTimer, Instant.now()).toMillis() < 700L) {
                  ++quickTransformCount;
                  quickTransformTimer = Instant.now();
                  if (quickTransformCount >= 1) {
                     quickTransformTimer = null;
                     quickTransformCount = 0;
                     quickTransform();
                  }
               }
            }
         } else {
            quickTransformAdded = false;
            if ((quickTransformTimer != null || quickTransformCount > 0) && Duration.between(quickTransformTimer, Instant.now()).toMillis() > 1000L) {
               quickTransformTimer = null;
               quickTransformCount = 0;
            }
         }
      }

   }

   private static void quickTransform() {
      if (DBCConfig.InstantTransformOn) {
         ascend = 0;
         ptime = 0;
         partnorm = 0;
         pup = 0;
         pup2 = 0;
         String ar = "jinryuudragonbc:DBC3.force";
         soundAsc(ar);
         int dbcascend = true;
         PD.sendToServer(new DBCPascend((byte)-1));
      }

   }

   public static void ssj2() {
      ++pup;
      JRMCoreH.kiInSuper = 2;
      if (pup == 50) {
         pup = 0;
      }

   }

   public static void Descend(KeyBinding key) {
      boolean isDescendingKeyPressed = isPressed(key);
      boolean fullDescending = false;
      boolean singleDescend = false;
      if (isDescendingKeyPressed && DBCConfig.SingleFormDescendOn) {
         if (!singleDescendAdded) {
            singleDescendAdded = true;
            if (singleDescendTimer == null) {
               singleDescendTimer = Instant.now();
            } else if (Duration.between(singleDescendTimer, Instant.now()).toMillis() < 700L) {
               ++singleDescendCount;
               singleDescendTimer = Instant.now();
               if (singleDescendCount >= 1) {
                  singleDescendTimer = null;
                  singleDescendCount = 0;
                  singleDescend = true;
               }
            }
         }

         if (singleDescendTimer != null && !singleDescend && Duration.between(singleDescendTimer, Instant.now()).toMillis() > 1000L) {
            fullDescending = true;
            singleDescendCount = 0;
            singleDescendAdded = true;
            singleDescendTimer = null;
         }
      } else {
         singleDescendAdded = false;
         if ((singleDescendTimer != null || singleDescendCount > 0) && Duration.between(singleDescendTimer, Instant.now()).toMillis() > 1000L) {
            singleDescendTimer = null;
            singleDescendCount = 0;
         }
      }

      if (isDescendingKeyPressed && (!DBCConfig.SingleFormDescendOn || (fullDescending || singleDescend) && singleDescendAdded)) {
         singleDescendTimer = null;
         singleDescendCount = 0;
         singleDescendAdded = false;
         if (!JRMCoreH.StusEfctsMe(13) && !JRMCoreH.StusEfctsMe(20) && !JRMCoreH.StusEfctsMe(19) && (JRMCoreH.State2 == 0 && JRMCoreH.State == 0 || JRMCoreH.State2 == 0 && JRMCoreH.Race == 4 && JRMCoreH.State <= 4)) {
            JRMCoreH.Rls((byte)0);
         }

         JRMCoreH.kiInSuper = 0;
         ascend = 0;
         ptime = 0;
         partnorm = 0;
         pup = 0;
         if (JRMCoreH.State2 <= 0 && JRMCoreH.State != 7) {
            if (!JRMCoreH.StusEfctsMe(13) && !JRMCoreH.StusEfctsMe(20) && !JRMCoreH.StusEfctsMe(19)) {
               if ((JRMCoreH.Race != 4 || JRMCoreH.Race == 4 && JRMCoreH.State > 4) && JRMCoreH.PlyrSkillX != null && hasRacialSkillLevel()) {
                  int racialSkillLevel = getClientRacialSkillLevel();
                  if (racialSkillLevel != 0) {
                     String ar = "jinryuudragonbc:DBC.descend";
                     if (JRMCoreH.rc_sai(JRMCoreH.Race)) {
                        ar = "jinryuudragonbc:1610.sse";
                     }

                     soundAsc(ar);
                     Dscndng(singleDescend ? -1 : 1);
                  }
               }
            } else {
               String ar = "jinryuudragonbc:DBC.descend";
               soundAsc(ar);
               Dscndng(3);
            }
         } else {
            soundAsc(3);
            Dscndng(singleDescend ? -1 : 1);
         }
      }

   }

   public static int Vqfj3D(String l) {
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

   public static int gYZc2f() {
      int b = JRMCoreConfig.tmx;
      String r = "64";
      String k = "3B9ACA00";
      return b > Vqfj3D(k) ? Vqfj3D(k) : (b < Vqfj3D(r) ? 0 : b);
   }

   public static void triForce(int i, int j, int k) {
      PD.sendToServer(new JRMCorePTri((byte)i, (byte)j, (byte)k));
   }

   private static void Ascndng() {
      int dbcascend = true;
      PD.sendToServer(new DBCPascend((byte)1));
   }

   public static void Dscndng(int i) {
      PD.sendToServer(new DBCPdescend((byte)i));
   }

   public static void Dscndng() {
      int dbcascend = true;
      Dscndng(1);
   }

   public static void soundAsc(String s) {
      int e = DBCClient.mc.field_71439_g.func_145782_y();
      PD.sendToServer(new DBCPchargesound(e, s));
   }

   public static void soundAsc(int i) {
      int dbcascendsound = DBCClient.mc.field_71439_g.func_145782_y();
      Object d;
      switch(i) {
      case 1:
         d = new DBCPascendsound(dbcascendsound);
         break;
      case 2:
         d = new DBCPchargesound(dbcascendsound, "jinryuudragonbc:DBC.aura");
         break;
      case 3:
         d = new DBCPdescendsound(dbcascendsound);
         break;
      case 4:
         d = new DBCPduo(300, dbcascendsound);
         break;
      default:
         d = new DBCPdescendsound(dbcascendsound);
      }

      PD.sendToServer((IMessage)d);
   }

   public static void chargePart(boolean b) {
      if (!JRMCoreClient.mc.func_147113_T()) {
         World w = DBCClient.mc.field_71439_g.field_70170_p;

         for(int pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
            if (JRMCoreH.dnn(19) && JRMCoreH.dnn(2) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
               String s = JRMCoreH.StusEfctsClient(pl);
               String[] st = JRMCoreH.data2[pl].split(";");
               int k = Integer.parseInt(st[1]);
               if (s.contains(JRMCoreH.StusEfcts[4]) || s.contains(JRMCoreH.StusEfcts[1]) || s.contains(JRMCoreH.StusEfcts[3]) || s.contains(JRMCoreH.StusEfcts[5]) || s.contains(JRMCoreH.StusEfcts[7])) {
                  Entity e = w.func_72924_a(JRMCoreH.plyrs[pl]);
                  if (e instanceof EntityPlayer) {
                     String[] a = JRMCoreH.data1[pl].split(";");
                     int r = Integer.parseInt(a[0]);
                     String[] dat5 = JRMCoreH.data5[pl].split(";");
                     int al = Integer.parseInt(dat5[0]);
                     int kc = Integer.parseInt(dat5[1]);
                     chargePart((EntityPlayer)e, r, al, kc, Integer.parseInt(st[0]), k, b, s);
                  }
               }
            }
         }

      }
   }

   public static void chargePart(EntityPlayer p, int r, int a, int c, int s, int k, boolean b, String se) {
      int dbcchargepart = 0;
      boolean kk = k > 0 || JRMCoreH.StusEfcts(5, se);
      boolean var10000;
      if (JRMCoreH.rc_sai(r) && JRMCoreH.StusEfcts(14, se)) {
         var10000 = true;
      } else {
         var10000 = false;
      }

      boolean ma = JRMCoreH.StusEfcts(12, se);
      boolean ui = JRMCoreH.StusEfcts(19, se);
      boolean gd = JRMCoreH.StusEfcts(20, se);
      boolean auraOn = JRMCoreH.StusEfcts(4, se);
      boolean auraTransformOn = JRMCoreH.StusEfcts(1, se);
      boolean turbo = JRMCoreH.StusEfcts(3, se);
      boolean swoop = JRMCoreH.StusEfcts(7, se);
      String dbcCharger;
      if (!b) {
         partnorm = 0;
         if (kk && JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) {
            dbcchargepart = 9;
         } else if (kk) {
            dbcchargepart = 4;
         } else if ((s <= 0 || !JRMCoreH.rc_sai(r) || s == 7) && !JRMCoreHDBC.godKiUser(r, s)) {
            dbcchargepart = 1;
         } else {
            dbcchargepart = 2;
         }
      } else {
         dbcCharger = "jinryuudragonbc:DBC.aura";
         if (JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) {
            dbcCharger = "jinryuudragonbc:1610.aurab";
         }

         if (JRMCoreH.rc_sai(r) && s != 10 && s != 15 && JRMCoreHDBC.godKiUser(r, s)) {
            dbcCharger = "jinryuudragonbc:1610.aurag";
         }

         if (kk && JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) {
            dbcCharger = "jinryuudragonbc:1610.aurabk";
         }

         if (gd) {
            dbcCharger = "jinryuudragonbc:DBC5.aura_destroyer";
         }

         if (ui) {
            dbcCharger = "jinryuudragonbc:DBC5.aura_ui";
         }

         if (JRMCoreH.isRaceMajin(r) && !swoop) {
            if (!turbo && (auraOn || auraTransformOn)) {
               dbcCharger = "jinryuudragonbc:DBC5.majin_cattle";
            } else if (turbo && auraOn && !auraTransformOn) {
               soundAsc("jinryuudragonbc:DBC5.majin_cattle");
            }
         }

         soundAsc(dbcCharger);
         if (!JRMCoreH.StusEfcts(3, se) && !JRMCoreH.StusEfcts(7, se)) {
            if (k > 0) {
               dbcchargepart = 8;
            } else if (s > 0 && JRMCoreH.rc_sai(r) && s == 7 && !JRMCoreHDBC.godKiUser(r, s)) {
               dbcchargepart = 5;
            } else {
               dbcchargepart = 6;
            }
         }

         power = 0;
      }

      if (dbcchargepart > 0) {
         dbcCharger = p.func_70005_c_();
         double dbcChargerY = p.field_70163_u;
         Entity other = p.field_70170_p.func_72924_a(dbcCharger);
         Random rand = new Random();
         Entity aura = null;
         Entity aura2 = null;
         float state = 0.0F;
         float state2 = 0.0F;
         int cr = 0;
         if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(2) && JRMCoreH.dnn(10)) {
            for(int pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
               if (JRMCoreH.plyrs[pl].equals(dbcCharger)) {
                  String[] states = JRMCoreH.data2[pl].split(";");
                  state = (float)Integer.parseInt(states[0]);
                  state2 = (float)Integer.parseInt(states[1]);
                  cr = Integer.parseInt(JRMCoreH.dat10[pl].split(";")[0]);
               }
            }
         }

         c = c > 0 ? c : JRMCoreH.Algnmnt_rc(a);
         boolean w = JRMCoreH.StusEfcts(7, se) || JRMCoreH.StusEfcts(9, se) && JRMCoreH.data(dbcCharger, 3, "0").contains("1") && !JRMCoreH.StusEfctsMe(4);
         boolean ssg = JRMCoreHDBC.godKiUserBase(r, s);
         boolean ssb = JRMCoreH.rc_sai(r) && s == 10;
         boolean ssbs = JRMCoreH.rc_sai(r) && s == 15;
         boolean auf = JRMCoreH.rc_arc(r) && s == 6;
         boolean v = JRMCoreH.StusEfcts(17, se);
         boolean lsa = JRMCoreH.lgndb(se, r, s);
         int sacol = JRMCoreHDBC.getPlayerColor2(2, c, 1, r, s, v, lsa, ui, gd);
         state = !ssg && !ssb ? state : 0.0F;
         state = ssbs ? 3.0F : state;
         boolean oozar = JRMCoreH.rc_sai(r) && (state == 7.0F || state == 8.0F);
         state = oozar ? state * 3.0F : state;
         state = JRMCoreH.rc_nam(r) && state == 2.0F ? 22.0F : state;
         boolean plyrSP = DBCClient.mc.field_71439_g.func_70005_c_().equals(dbcCharger) && DBCClient.mc.field_71474_y.field_74320_O == 0;
         if (dbcchargepart >= 1 && dbcchargepart <= 4) {
            aura = new EntityAura2(p.field_70170_p, dbcCharger, state2 > 0.0F ? 16646144 : sacol, state, state2, cr, w);
         }

         if (dbcchargepart >= 5 && dbcchargepart <= 8 && !ui && !gd) {
            aura = new EntityAuraRing(p.field_70170_p, dbcCharger, state2 > 0.0F ? 16646144 : sacol, state, state2, cr);
         }

         if (dbcchargepart == 9) {
            aura = new EntityAura2(p.field_70170_p, dbcCharger, sacol, 0.0F, 0.0F, cr, w);
            if (state2 > 0.0F) {
               aura2 = new EntityAura2(p.field_70170_p, dbcCharger, 16646144, 2.0F + state, state2 * 1.5F, cr, w);
            }
         }

         if (aura != null && other != null) {
            if (aura instanceof EntityAura2) {
               if (ssg) {
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.2F);
                  ((EntityAura2)aura).setTex("aurai");
                  ((EntityAura2)aura).setTexL2("aurai2");
                  ((EntityAura2)aura).setColL2(16747301);
               } else if (ssbs && v) {
                  ((EntityAura2)aura).setSpd(30);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.2F);
                  ((EntityAura2)aura).setTex("aurai");
                  ((EntityAura2)aura).setTexL2("aurai2");
                  ((EntityAura2)aura).setColL2(8592109);
               } else if (ssbs) {
                  ((EntityAura2)aura).setSpd(40);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.5F);
                  ((EntityAura2)aura).setTex("aurag");
                  ((EntityAura2)aura).setColL3(12310271);
                  ((EntityAura2)aura).setTexL3("auragb");
               } else if (ssb && v) {
                  ((EntityAura2)aura).setSpd(30);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.2F);
                  ((EntityAura2)aura).setTex("aurai");
                  ((EntityAura2)aura).setTexL2("aurai2");
                  ((EntityAura2)aura).setColL2(7872713);
               } else if (ssb) {
                  ((EntityAura2)aura).setSpd(40);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.5F);
                  ((EntityAura2)aura).setTex("aurag");
                  ((EntityAura2)aura).setColL3(15727354);
                  ((EntityAura2)aura).setTexL3("auragb");
               } else if (auf) {
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.5F);
                  ((EntityAura2)aura).setTex("aurau");
                  ((EntityAura2)aura).setTexL2("aurau2");
                  ((EntityAura2)aura).setColL2(16776724);
               } else if (ui) {
                  ((EntityAura2)aura).setSpd(100);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.005F : 0.15F);
                  ((EntityAura2)aura).setTex("auras");
                  ((EntityAura2)aura).setCol(15790320);
                  ((EntityAura2)aura).setColL3(4746495);
                  ((EntityAura2)aura).setTexL3("auragb");
               } else if (gd) {
                  ((EntityAura2)aura).setSpd(30);
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.2F);
                  ((EntityAura2)aura).setTex("aurag");
                  ((EntityAura2)aura).setTexL3("auragb");
                  ((EntityAura2)aura).setColL2(12464847);
               } else {
                  ((EntityAura2)aura).setAlp(plyrSP ? 0.05F : 0.2F);
               }
            }

            if (aura != null && aura instanceof EntityAura2) {
               ((EntityAura2)aura).setBol(JRMCoreH.StusEfcts(1, se));
               ((EntityAura2)aura).setBol2(JRMCoreH.StusEfcts(4, se));
               ((EntityAura2)aura).setBol3(JRMCoreH.StusEfcts(3, se));
               ((EntityAura2)aura).setBol4(ui && !gd);
               boolean Bol4a = JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0 ? JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[JRMCoreH.state2UltraInstinct(!ui, (byte)((int)state2))] : false;
               ((EntityAura2)aura).setBol4a(Bol4a);
               int bol6 = gd ? 6 : (ssg ? 0 : (v && ssb ? 3 : (v && ssbs ? 5 : (ssb ? 1 : (ssbs ? 2 : (auf ? 4 : -1))))));
               if (ui) {
                  bol6 = 0;
               }

               ((EntityAura2)aura).setBol6(bol6);
               ((EntityAura2)aura).setBol7(ma || kk);
               ((EntityAura2)aura).kettleMode = (byte)(JRMCoreH.isRaceMajin(r) && (auraOn || auraTransformOn) && !swoop ? (!turbo && !auraTransformOn && !kk ? 1 : 2) : 0);
            }

            p.field_70170_p.func_72838_d((Entity)aura);
         }

         if (aura2 != null && other != null) {
            if (aura2 instanceof EntityAura2) {
               ((EntityAura2)aura2).setSpd(40);
               ((EntityAura2)aura2).setAlp(plyrSP ? 0.025F : 0.3F);
               ((EntityAura2)aura2).setTex("aurak");
               ((EntityAura2)aura2).setInner(false);
               ((EntityAura2)aura2).setRendPass(0);
            }

            aura2.func_70012_b(other.field_70165_t - 0.0D, other.field_70163_u - 2.0D + (double)rand.nextInt(5) * 0.03D, other.field_70161_v - 0.0D, rand.nextFloat(), 0.0F);
            p.field_70170_p.func_72838_d(aura2);
         }
      }

   }

   private static int getClientRacialSkillLevel() {
      return Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
   }

   private static boolean canAttemptTransformation() {
      return JRMCoreH.PlyrSkillX != null && JRMCoreH.curEnergy > 1;
   }

   private static boolean hasRacialSkillLevel() {
      return JRMCoreH.PlyrSkillX.contains("TR");
   }

   private static boolean isClientMoving() {
      if (holdingForTransform) {
         return DBCConfig.MoveWhileTransforming ? false : !JGMathHelper.isMotionSmallerThanN(DBCClient.mc.field_71439_g, 0.05D, true, false, true, true);
      } else {
         return DBCConfig.MoveWhileInstantTransforming ? false : !JGMathHelper.isMotionSmallerThanN(DBCClient.mc.field_71439_g, 0.05D, true, false, true, true);
      }
   }
}
