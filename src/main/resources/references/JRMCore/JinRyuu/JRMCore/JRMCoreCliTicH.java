package JinRyuu.JRMCore;

import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.client.helpmanager.HelpSystem;
import JinRyuu.JRMCore.client.notification.JGNotification;
import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
import JinRyuu.JRMCore.p.OpenGuiMessage;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.server.JGMathHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class JRMCoreCliTicH {
   public static final int ANIM_FLY = 1;
   public static final int ANIM_STAND = 2;
   public Minecraft mc;
   private int check;
   private boolean stand;
   static int actionSelectID = 0;
   static int actionNPA = 0;
   static boolean actionNBO = false;
   boolean jfc;
   boolean dbc;
   boolean nc;
   private boolean actionMenuOpen;
   public static EntityLivingBase lockOn;
   private static int dst = 50;
   private HashMap<Integer, KeyBinding> keys;
   public static HashMap<Integer, Integer> DoubleTapPressCounter = new HashMap();
   public static HashMap<Integer, Long> Tapped = new HashMap();
   public boolean wig;
   private boolean viewChange;
   private int viewPrevious;
   public static int currentTime;
   public static int previousTime;
   public static float countingValue;
   public static float counterValue;
   public static float smod = 1.0F;
   public static int smodr = 0;
   private static int gen;
   public static String[] mp;
   public static int ts;
   public static int ts2;
   public static int ts5;
   static int fnPressed;
   public static float offsetY;
   public static float clientHght;
   public static float yc;
   public static float clientHeight;
   public static float clientEyHeigClc;
   public static float clientDefEyHeig;
   public static float clientyOffset;
   public static int mw;
   private EntityRenderer renderer;
   private EntityRenderer prevRenderer;
   public static ArrayList<JGNotification> notificationPings;
   public Instant updateClient;
   public Instant updateTimer;

   public JRMCoreCliTicH(Minecraft mc) {
      this.mc = JRMCoreClient.mc;
      this.check = 0;
      this.stand = true;
      this.jfc = JRMCoreH.JFC();
      this.dbc = JRMCoreH.DBC();
      this.nc = JRMCoreH.NC();
      this.actionMenuOpen = false;
      this.keys = new HashMap();
      this.wig = true;
      this.viewChange = false;
      this.viewPrevious = 0;
      this.mc = mc;
   }

   public static boolean onHotbar(Item item, EntityPlayer player) {
      for(int i = 0; i < 9; ++i) {
         if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() == item) {
            return true;
         }
      }

      return false;
   }

   private void onRenderTick() {
      if (this.mc.field_71441_e != null && !this.mc.func_147113_T()) {
         HelpSystem.update();
         this.updateReleaseLevel();
      }

      boolean ation = this.actionMenuOpen;
      if (JRMCoreA.pwr_usrs(JRMCoreH.Pwrtyp) && this.mc.player != null && this.mc.field_71441_e != null && this.mc.field_71462_r == null && JRMCoreKeyHandler.actionMenu.func_151470_d()) {
         JRMCoreClient.JFCGui.renderActionMenu();
         this.actionMenuOpen = true;
         if (this.mc.field_71415_G) {
            this.mc.field_71415_G = false;
            this.mc.field_71417_B.func_74373_b();
         }
      } else if (this.actionMenuOpen && this.mc.field_71462_r != null) {
         KeyBinding.func_74506_a();
         this.actionMenuOpen = false;
      } else if (this.actionMenuOpen) {
         this.mc.field_71415_G = true;
         this.actionMenuOpen = false;
         this.mc.field_71417_B.func_74372_a();
      }

      if (JRMCoreH.Pwrtyp == 1) {
         JRMCoreA.actions = JRMCoreA.actionsDBC;
         if (ation && !this.actionMenuOpen && JRMCoreA.actions.get(actionSelectID) != null) {
            JRMCoreHDBC.action((Integer)JRMCoreA.actions.get(actionSelectID), true, false);
         }
      }

      if (JRMCoreH.Pwrtyp == 2) {
         JRMCoreA.actions = JRMCoreA.actionsNC;
         if (ation && !this.actionMenuOpen && JRMCoreA.actions.get(actionSelectID) != null) {
            JRMCoreHNC.action((Integer)JRMCoreA.actions.get(actionSelectID), true, false);
         }
      }

      if (!actionNBO && ation && JRMCoreClient.mc.gameSettings.field_74312_F.func_151470_d() && actionSelectID % 9 == 4) {
         actionSelectID = -1;
         actionNBO = true;
         actionNPA = actionNPA == 0 ? 1 : 0;
      }

      EntityPlayer player = Minecraft.func_71410_x().player;
      dst = 35;
      if (lockOn != null && player != null && JRMCoreConfig.lockon) {
         if (lockOn.field_70128_L || player.func_70032_d(lockOn) > (float)dst) {
            lockOn = null;
            return;
         }

         EntityLivingBase target = lockOn;
         double dx = player.posX - target.posX;
         double dz = player.posZ - target.posZ;
         double dy = player.posY - (target.posY + (double)(target.field_70131_O / 2.0F) - (double)this.mc.player.field_70131_O + 1.600000023841858D);
         double angle = Math.atan2(dz, dx) * 180.0D / 3.141592653589793D;
         double pitch = Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * 180.0D / 3.141592653589793D;
         double distance = (double)player.func_70032_d(target);

         float rYaw;
         for(rYaw = (float)(angle - (double)player.rotationYaw); rYaw > 180.0F; rYaw -= 360.0F) {
         }

         while(rYaw < -180.0F) {
            rYaw += 360.0F;
         }

         rYaw += 90.0F;
         float rPitch = (float)pitch - (float)(10.0D / Math.sqrt(distance)) + (float)(distance * 3.141592653589793D / 90.0D);
         player.func_70082_c(rYaw, -(rPitch - player.rotationPitch));
      }

      if (this.mc.player != null && this.mc.field_71415_G) {
         Minecraft var10000 = this.mc;
         if (Minecraft.func_71382_s()) {
            GL11.glPushMatrix();
            if (this.dbc && JGConfigClientSettings.CLIENT_GR2 && JRMCoreH.StusEfctsMe(7)) {
               JRMCoreClient.bars.swoop();
            }

            if ((this.dbc || this.nc) && JRMCoreH.Accepted == 1 && !this.mc.gameSettings.field_74321_H.func_151470_d() && (JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2 && JRMCoreH.inIll == null)) {
               if (JGConfigClientSettings.CLIENT_hud2) {
                  JRMCoreClient.bars.renderCG(0);
               } else {
                  JRMCoreClient.bars.renderBodyBar();
               }

               if ((JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2 && JRMCoreH.inIll == null) && !JGConfigClientSettings.CLIENT_hud2) {
                  JRMCoreClient.bars.renderKiBar();
               }

               if (JRMCoreH.Pwrtyp == 1) {
                  if (!JGConfigClientSettings.CLIENT_hud2) {
                     JRMCoreClient.bars.renderRageBar();
                  }

                  if (JRMCoreH.curRelease > 0) {
                     JRMCoreClient.bars.renderEnSideBar();
                  }

                  if (JRMCoreH.isChrgng) {
                     JRMCoreClient.bars.renderEnChrgBar();
                  }

                  if (JRMCoreH.curn > 0) {
                     JRMCoreClient.bars.rendern();
                  }

                  if (JRMCoreH.cura > 0) {
                     JRMCoreClient.bars.rendera();
                  }
               }

               if (JRMCoreH.Pwrtyp == 2 && JRMCoreH.curRelease > 0) {
                  JRMCoreClient.bars.renderEnSideBarNC();
               }
            }

            if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.SAOC() && JRMCoreH.Accepted == 1 && !this.mc.gameSettings.field_74321_H.func_151470_d()) {
               JRMCoreClient.bars.renderSAOHealthBar();
            }

            JRMCoreClient.bars.renderSafeZoneIndicator();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
         }
      }

      this.NotificationHandler();
   }

   private void onInputEvent(KeyInputEvent event) {
      EntityPlayer player = this.mc.player;
      if (JRMCoreKeyHandler.lockOn.func_151470_d() && JRMCoreH.SklLvl(6) > 0 && JRMCoreConfig.lockon) {
         Entity rtr = JRMCoreH2.getTarget(1.0F, (double)dst);
         if (lockOn == null && rtr != null) {
            double distanceSq = player.func_70068_e(rtr);
            double reachSq = (double)(dst * dst);
            if (reachSq >= distanceSq && rtr instanceof EntityLivingBase) {
               lockOn = (EntityLivingBase)rtr;
               player.world.func_72980_b(player.posX, player.posY, player.posZ, "jinryuudragonbc:DBC4.lockon", 1.0F, 1.0F, true);
            }
         } else {
            lockOn = null;
         }
      }

      this.keys.put(this.mc.gameSettings.field_74351_w.func_151463_i(), this.mc.gameSettings.field_74351_w);
      this.keys.put(this.mc.gameSettings.field_74368_y.func_151463_i(), this.mc.gameSettings.field_74368_y);
      this.keys.put(this.mc.gameSettings.field_74370_x.func_151463_i(), this.mc.gameSettings.field_74370_x);
      this.keys.put(this.mc.gameSettings.field_74366_z.func_151463_i(), this.mc.gameSettings.field_74366_z);
      Iterator var8 = this.keys.entrySet().iterator();

      while(var8.hasNext()) {
         Entry<Integer, KeyBinding> mapEntry = (Entry)var8.next();
         int k = (Integer)mapEntry.getKey();
         KeyBinding v = (KeyBinding)mapEntry.getValue();
         if (v.func_151470_d()) {
            Tapped.put(k, dtap2());
            if ((Long)Tapped.get(k) >= time()) {
               Integer c = (Integer)DoubleTapPressCounter.get(k);
               DoubleTapPressCounter.put(k, c == null ? 1 : Integer.valueOf(c + 1));
            }
         }
      }

   }

   public static long time() {
      return System.currentTimeMillis();
   }

   public static long dtap2() {
      return System.currentTimeMillis() + 250L;
   }

   public static boolean getDT(KeyBinding k) {
      Integer c = (Integer)DoubleTapPressCounter.get(k.func_151463_i());
      return c != null && c >= 2;
   }

   public void onTickInGUI() {
      GuiScreen guiscreen = this.mc.field_71462_r;
      EntityPlayer plyr = this.mc.player;
      if (guiscreen instanceof GuiMainMenu && !this.wig) {
         JRMCoreH.resetChar();
         JRMCoreH.resetDedSer();
         this.wig = true;
      }

      if (plyr != null && this.mc.field_71441_e != null && !(guiscreen instanceof JRMCoreGuiScreen)) {
         if (JRMCoreGuiScreen.hairPreview != 0) {
            JRMCoreGuiScreen.hairPreview = 0;
         }

         if (JRMCoreGuiScreen.ufc) {
            JRMCoreGuiScreen.ufc = false;
         }
      }

      if (plyr != null && !plyr.field_70128_L && this.mc.field_71441_e != null && (JRMCoreH.PlyrAttrbts[0] == 0 || this.wig)) {
         this.wig = false;
         JRMCoreH.jrmct(1);
         JRMCoreH.jrmct(-1);
         JRMCoreH.jrmct(3);
      }

   }

   public void onTickInGame() {
      mw = Mouse.getDWheel();
      EntityPlayer plyr = this.mc.player;
      if (JRMCoreH.data1 == null) {
         JRMCoreH.Race = this.b(0);
         JRMCoreH.dns = "0";
         JRMCoreH.Pwrtyp = this.b(0);
         JRMCoreH.Class = this.b(0);
         JRMCoreH.Accepted = this.b(2);
      }

      JRMCoreHC.t1s = ts <= 0;
      if (ts > 0) {
         --ts;
      } else {
         ts = 20;
      }

      JRMCoreHC.t2s = ts2 <= 0;
      if (ts2 > 0) {
         --ts2;
      } else {
         ts2 = 40;
      }

      JRMCoreHC.t5s = ts5 <= 0;
      if (ts5 > 0) {
         --ts5;
      } else {
         ts5 = 100;
      }

      currentTime = (int)(System.currentTimeMillis() / 1000L);
      if (currentTime != previousTime) {
         previousTime = currentTime;
         counterValue = countingValue;
         countingValue = 0.0F;
      }

      if (currentTime == previousTime) {
         ++countingValue;
      }

      HashMap<Integer, Long> tapped = (HashMap)Tapped.clone();
      Iterator var3 = tapped.entrySet().iterator();

      while(var3.hasNext()) {
         Entry<Integer, Long> mapEntry = (Entry)var3.next();
         int k = (Integer)mapEntry.getKey();
         long v = (Long)mapEntry.getValue();
         if (v < time()) {
            Tapped.remove(k);
            DoubleTapPressCounter.remove(k);
         }
      }

      if (plyr != null && !plyr.field_70128_L && this.mc.field_71441_e != null) {
         if (this.wig) {
            this.wig = false;
         }

         if (smodr > 0) {
            --smodr;
         }

         if (smodr == 0 && smod != 1.0F) {
            smod = 1.0F;
         }

         float w = JRMCoreH.weightPerc(1) * smod;
         boolean b = JRMCoreConfig.releaseStop && JRMCoreKeyHandler.KiCharge.func_151470_d() || JRMCoreH.kob;
         String[] d18 = JRMCoreH.data(18, "0;0;0;0;0;0;0;0;0").split(";");
         String[] fuse = d18[2].split(",");
         if (fuse.length == 3 && fuse[1].equalsIgnoreCase(this.mc.player.getName()) || JRMCoreH.kob) {
            b = true;
            EntityPlayer pl = this.mc.field_71441_e.getPlayerEntityByName(fuse[0]);
            if (pl != null) {
               if (this.mc.player.func_70032_d(pl) > 5.0F) {
                  this.mc.player.setLocationAndAngles(pl.posX, pl.posY, pl.posZ, this.mc.player.rotationYaw, this.mc.player.rotationPitch);
               }

               this.mc.gameSettings.thirdPersonView = 1;
               this.mc.player.field_70159_w = 0.0D;
               this.mc.player.field_70181_x = 0.0D;
               this.mc.player.field_70179_y = 0.0D;
            }
         }

         if (JRMCoreH.kob) {
            if (!this.viewChange) {
               this.viewChange = true;
               this.viewPrevious = this.mc.gameSettings.thirdPersonView;
            }

            this.mc.gameSettings.thirdPersonView = 1;
         } else if (this.viewChange) {
            this.viewChange = false;
            this.mc.gameSettings.thirdPersonView = this.viewPrevious;
         }

         EntityClientPlayerMP var10000;
         if (!(JRMCoreH.WeightOn > 0.0F) && !b && smod == 1.0F && !JRMCoreH.pnh) {
            if (!(this.mc.player.field_71158_b instanceof MovementInputFromOptions)) {
               this.mc.player.field_71158_b = new MovementInputFromOptions(this.mc.gameSettings);
            }
         } else {
            if (b) {
               w = 0.0F;
            }

            if (JRMCoreH.pnh && plyr.field_71093_bK != 22) {
               w *= 0.5F;
            }

            if (this.mc.player.field_71158_b instanceof MoveInputJRMC && this.mc.player.world.func_72976_f((int)this.mc.player.posX, (int)this.mc.player.posZ) > 0 && this.mc.player.field_70181_x > 0.0D) {
               var10000 = this.mc.player;
               var10000.field_70181_x *= (double)w;
            }

            if (!(this.mc.player.field_71158_b instanceof MoveInputJRMC) && (this.mc.player.field_71158_b.field_78900_b != 0.0F || this.mc.player.field_71158_b.field_78902_a != 0.0F)) {
               this.mc.player.field_71158_b = new MoveInputJRMC(this.mc.gameSettings, w);
            }

            if (this.mc.player.field_71158_b instanceof MoveInputJRMC && ((MoveInputJRMC)this.mc.player.field_71158_b).moveModifier != w) {
               ((MoveInputJRMC)this.mc.player.field_71158_b).moveModifier = w;
            }
         }

         ++this.check;
         if (this.check == 1) {
            plyr.openGui(mod_JRMCore.instance, 30, plyr.world, (int)plyr.posX, (int)plyr.posY, (int)plyr.posZ);
            this.check = 2;
         }

         if ((JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2) && JRMCoreKeyHandler.Sagasys.func_151470_d()) {
            plyr.openGui(mod_JRMCore.instance, 60, plyr.world, (int)plyr.posX, (int)plyr.posY, (int)plyr.posZ);
         }

         if (JRMCoreKeyHandler.infopanel.func_151470_d()) {
            plyr.openGui(mod_JRMCore.instance, 30, plyr.world, (int)plyr.posX, (int)plyr.posY, (int)plyr.posZ);
         }

         if (JRMCoreKeyHandler.DS.func_151470_d()) {
            plyr.openGui(mod_JRMCore.instance, 0, plyr.world, (int)plyr.posX, (int)plyr.posY, (int)plyr.posZ);
         }

         if (JRMCoreH.PlyrAttrbts[0] == 0 || this.wig) {
            this.wig = false;
            JRMCoreH.jrmct(1);
            JRMCoreH.jrmct(-1);
            JRMCoreH.jrmct(3);
         }

         if (!this.mc.func_147113_T()) {
            for(int i = 0; i < JRMCoreH.techniqueCooldowns.length; ++i) {
               JRMCoreH.techniqueCooldowns[i] = JRMCoreH.techniqueCooldowns[i] > 0.0F ? JRMCoreH.techniqueCooldowns[i] - 0.05F : 0.0F;
            }

            JRMCoreH.updateAllOldCooldownValues();
         }

         if (JRMCoreH.Accepted == 2) {
            JRMCoreH.Race = 0;
            JRMCoreH.dns = "0";
            JRMCoreH.Pwrtyp = 0;
            JRMCoreH.Class = 0;
            JRMCoreH.State = 0;
         }

         float f1 = 1.0F;
         float f2 = 1.0F;
         float f3 = 1.0F;
         boolean fly = !JRMCoreH.DBC();
         if (JRMCoreH.dnsGender(JRMCoreH.dns) <= 1) {
            f1 = 0.73F + (fly ? 0.27F : 0.0F);
         }

         if (JRMCoreH.dnsGender(JRMCoreH.dns) >= 2) {
            f1 = 0.7F + (fly ? 0.27F : 0.0F);
         }

         if (JRMCoreH.JYC()) {
            JRMCoreCliTicH.yc = JRMCoreHJYC.JYCsizeBasedOnAge(plyr);
         }

         float clientHght2;
         float transBody;
         float f6;
         if (JRMCoreH.DBC() && JRMCoreH.PlyrAttrbts[0] != 0 && JRMCoreConfig.sizes) {
            clientHght2 = f1;
            JRMCoreHDBC.DBCreleaseZeroTurnOffTurbo();
            f1 += JRMCoreHDBC.DBCsizeBasedOnCns(JRMCoreH.PlyrAttrbts);
            if (!JRMCoreH.isPowerTypeChakra()) {
               boolean divine = JRMCoreH.Race == 3 ? JRMCoreH.StusEfctsMe(17) : false;
               f2 = JRMCoreHDBC.DBCsizeBasedOnRace(JRMCoreH.Race, JRMCoreH.State, divine);
               f3 = JRMCoreHDBC.DBCsizeBasedOnRace2(JRMCoreH.Race, JRMCoreH.State, divine);
            }

            byte rls = JRMCoreH.curRelease;
            if (JRMCoreH.rSai(JRMCoreH.Race) && (JRMCoreH.State == 7 || JRMCoreH.State == 8)) {
               rls = 50;
               f1 = clientHght2;
            }

            transBody = (f3 - 1.0F) * (float)rls * 0.02F + 1.0F;
            f3 = transBody > f3 ? f3 : (f3 > 1.0F ? transBody : f3);
            f6 = (f2 - 1.0F) * (float)rls * 0.02F + 1.0F;
            f2 = f2 > 1.0F ? f6 : f2;
            float f1a1 = (f1 - clientHght2) * (rls <= 50 ? 0.25F : 0.5F);
            float f1ac = f1a1 * (float)rls * 0.02F;
            float f1ao = f1 - clientHght2 - f1a1 + f1ac + clientHght2;
            f1 = f1ao;
         }

         if (JRMCoreH.dns.length() < 3) {
            f1 = 0.9375F;
            f2 = 1.0F;
            f3 = 1.0F;
            JRMCoreCliTicH.yc = 1.0F;
         }

         if (!plyr.func_70608_bn() && JRMCoreH.JBRA()) {
            if (this.mc.gameSettings.field_74314_A.func_151468_f() && (this.mc.field_71441_e.func_147439_a((int)this.mc.player.posX, (int)this.mc.player.posY - 1, (int)this.mc.player.posZ - 1).func_149688_o() == Material.field_151586_h || this.mc.field_71441_e.func_147439_a((int)this.mc.player.posX, (int)this.mc.player.posY - 1, (int)this.mc.player.posZ - 1).func_149688_o() == Material.field_151587_i)) {
               double d1 = 0.02D;
               var10000 = this.mc.player;
               var10000.field_70181_x += d1;
            }

            JRMCoreCliTicH.clientHght = JRMCoreComTickH.height * f1 * f3 * JRMCoreCliTicH.yc;
            clientHght2 = JRMCoreCliTicH.clientHght;
            float clientWdth2 = JRMCoreComTickH.width * f1 * f2 * f3 * JRMCoreCliTicH.yc;
            JRMCoreComTickH.sS(plyr, clientWdth2, clientHght2);
            transBody = (0.5F - (JRMCoreCliTicH.yc - 0.5F)) * 2.0F;
            f6 = JRMCoreCliTicH.yc;
            f6 = 3.0F - f6 * 2.0F;
            offsetY = JRMCoreCliTicH.clientHght * 0.9F - 1.54F;
         }

         int r = 10;
         AxisAlignedBB ab = AxisAlignedBB.func_72330_a(plyr.posX - (double)r, plyr.posY - (double)r, plyr.posZ - (double)r, plyr.posX + (double)r, plyr.posY + (double)r, plyr.posZ + (double)r);
         List list = this.mc.player.world.func_72872_a(EntityPlayer.class, ab);

         for(int i = 0; i < list.size(); ++i) {
            EntityPlayer plyr1 = (EntityPlayer)list.get(i);
            if (!plyr.getName().equals(plyr1.getName())) {
               String[] s = JRMCoreH.data(plyr1.getName(), 1, "0;0;0;0;0;0").split(";");
               String[] s2 = JRMCoreH.data(plyr1.getName(), 2, "0;0").split(";");
               int state = Integer.parseInt(s2[0]);
               String[] s14 = JRMCoreH.data(plyr1.getName(), 14, "0,0,0,0,0,0").split(",");
               int rls = Integer.parseInt(JRMCoreH.data(plyr1.getName(), 10, "0;0").split(";")[0]);
               int race = Integer.parseInt(s[0]);
               int[] PlyrAttrbts = new int[s14.length];

               for(int i1 = 0; i1 < PlyrAttrbts.length; ++i1) {
                  PlyrAttrbts[i1] = Integer.parseInt(s14[i1]);
               }

               float f1 = 1.0F;
               float f2 = 1.0F;
               float f3 = 1.0F;
               boolean noC = !JRMCoreH.DBC();
               if (JRMCoreH.dnsGender(s[1]) <= 1) {
                  f1 = 0.73F + (noC ? 0.27F : 0.0F);
               }

               if (JRMCoreH.dnsGender(s[1]) >= 2) {
                  f1 = 0.7F + (noC ? 0.27F : 0.0F);
               }

               float yc = 1.0F;
               if (JRMCoreH.JYC()) {
                  yc = JRMCoreHJYC.JYCsizeBasedOnAge(plyr1);
               }

               float clientWdth2;
               if (JRMCoreH.DBC() && PlyrAttrbts[0] != 0 && JRMCoreConfig.sizes) {
                  float f1r = f1;
                  f1 += JRMCoreHDBC.DBCsizeBasedOnCns(PlyrAttrbts);
                  boolean divine = race == 3 ? JRMCoreH.StusEfctsClient(17, plyr1) : false;
                  f2 = JRMCoreHDBC.DBCsizeBasedOnRace(race, state, divine);
                  f3 = JRMCoreHDBC.DBCsizeBasedOnRace2(race, state, divine);
                  if (JRMCoreH.rSai(race) && (state == 7 || state == 8)) {
                     rls = 50;
                     f1 = f1r;
                  }

                  float f3a = (f3 - 1.0F) * (float)rls * 0.02F + 1.0F;
                  f3 = f3a > f3 ? f3 : (f3 > 1.0F ? f3a : f3);
                  clientWdth2 = (f2 - 1.0F) * (float)rls * 0.02F + 1.0F;
                  f2 = f2 > 1.0F ? clientWdth2 : f2;
                  float f1a1 = (f1 - f1r) * (rls <= 50 ? 0.25F : 0.5F);
                  float f1ac = f1a1 * (float)rls * 0.02F;
                  float f1ao = f1 - f1r - f1a1 + f1ac + f1r;
                  f1 = f1ao;
               }

               if (s[1].length() < 3) {
                  f1 = 0.9375F;
                  f2 = 1.0F;
                  f3 = 1.0F;
                  yc = 1.0F;
               }

               if (!plyr1.func_70608_bn()) {
                  boolean DO = true;
                  if (JRMCoreH.JBRA()) {
                     float clientHght = JRMCoreComTickH.height * f1 * f3 * yc;
                     clientWdth2 = JRMCoreComTickH.width * f1 * f2 * f3 * yc;
                     if (fuse.length == 3 && fuse[1].equalsIgnoreCase(plyr1.getName())) {
                        JRMCoreComTickH.sS(plyr1, 0.0F, 0.0F);
                        DO = false;
                     } else {
                        JRMCoreComTickH.sS(plyr1, clientWdth2, clientHght);
                     }
                  }

                  if (DO && fuse.length == 3 && fuse[1].equalsIgnoreCase(plyr1.getName())) {
                     JRMCoreComTickH.sS(plyr1, 0.0F, 0.0F);
                  }
               }
            }
         }

         fly = JRMCoreH.StusEfctsMe(9) && !JRMCoreH.StusEfctsMe(4) || JRMCoreH.DBC() && JRMCoreHDBC.DBCKiTechFly();
         if (((plyr.field_70159_w < 0.0D ? plyr.field_70159_w * -1.0D : plyr.field_70159_w) > 0.2D || (plyr.field_70179_y < 0.0D ? plyr.field_70179_y * -1.0D : plyr.field_70179_y) > 0.2D && JRMCoreH.inAir(plyr)) && fly) {
            if (this.stand) {
               this.stand = false;
               JRMCoreH.Anim(1);
            }
         } else if (!this.stand) {
            this.stand = true;
            JRMCoreH.Anim(2);
         }

         if (this.mc.player != null && this.mc.field_71441_e != null) {
            if (fnPressed > 0 && (this.mc.field_71462_r instanceof GuiInventory || this.mc.field_71462_r instanceof GuiContainerCreative)) {
               PD.sendToServer(new OpenGuiMessage(mod_JRMCore.GUI_CUSTOM_INV));
            }

            if (JRMCoreKeyHandler.Fn.func_151470_d()) {
               fnPressed = 10;
            } else {
               --fnPressed;
            }

            this.updateMaxStats();
         }
      }

   }

   public void onPreRenderTick() {
   }

   @SubscribeEvent
   public void onTick(ClientTickEvent event) {
      JRMCoreH.mld();
      if (event.phase.equals(Phase.START)) {
         JRMCoreH.paused = this.mc.func_147113_T();
         if (!JRMCoreH.paused) {
            this.onTickInGUI();
            this.onTickInGame();
         }
      }

      if (event.phase.equals(Phase.END)) {
      }

   }

   @SubscribeEvent
   public void onRenderTick(RenderTickEvent event) {
      if (event.phase == Phase.END) {
         this.onRenderTick();
      }

   }

   @SubscribeEvent
   public void onKeyInputEvent(KeyInputEvent event) {
      this.onInputEvent(event);
   }

   private byte b(int n) {
      return (byte)n;
   }

   private byte b(String n) {
      return Byte.parseByte(n);
   }

   private int i(String n) {
      return Integer.parseInt(n);
   }

   private void NotificationHandler() {
      int size = notificationPings.size();
      if (this.mc.player != null && size > 0) {
         ResourceLocation txx = new ResourceLocation(JRMCoreH.tjjrmc + ":notification.png");
         ResourceLocation txx2 = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
         FontRenderer fontRenderer = this.mc.field_71466_p;
         int[] xx = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
         int[] yy = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
         Instant now = Instant.now();

         for(int i = size - 1; i >= 0; --i) {
            JGNotification note = (JGNotification)notificationPings.get(i);
            if (note == null) {
               notificationPings.remove(i);
            } else {
               Duration dur = Duration.between(note.received, now);
               int value = (int)((float)dur.toMillis() / 10.0F);
               float alpha = 1.0F;
               if (value >= 500) {
                  notificationPings.remove(i);
               } else {
                  if (value >= 490) {
                     alpha = 1.0F - ((float)value - 490.0F) / 10.0F;
                  }

                  int renderLocation = note.renderLocation > xx.length - 1 ? xx.length - 1 : note.renderLocation;
                  yy[renderLocation] += value > 21 ? 21 : value;
                  ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                  int sw = scaledresolution.func_78326_a();
                  int sh = scaledresolution.func_78328_b();
                  int x = 0;
                  int y = 0;
                  if (renderLocation == 0) {
                     x = sw - 116 + xx[renderLocation];
                     y = yy[renderLocation] - 21;
                  } else if (renderLocation == 1) {
                     x = sw / 2 - 58 + xx[renderLocation];
                     y = yy[renderLocation] - 21;
                  } else if (renderLocation == 2) {
                     x = xx[renderLocation];
                     y = yy[renderLocation] - 21;
                  } else if (renderLocation == 3) {
                     x = sw - 116 + xx[renderLocation];
                     y = sh / 2 + 21 + yy[renderLocation] - 21;
                  } else if (renderLocation == 4) {
                     x = sw / 2 - 58 + xx[renderLocation];
                     y = sh / 2 + 21 + yy[renderLocation] - 21;
                  } else if (renderLocation == 5) {
                     x = xx[renderLocation];
                     y = sh / 2 + 21 + yy[renderLocation] - 21;
                  } else if (renderLocation == 6) {
                     x = sw - 116 + xx[renderLocation];
                     y = sh - yy[renderLocation];
                  } else if (renderLocation == 7) {
                     x = sw / 2 - 58 + xx[renderLocation];
                     y = sh - yy[renderLocation];
                  } else if (renderLocation == 8) {
                     x = xx[renderLocation];
                     y = sh - yy[renderLocation];
                  }

                  this.mc.func_110434_K().bindTexture(txx);
                  int icon = note.icon;
                  int idY = note.icon * 16 / 256;
                  int idX = note.icon * 16 - idY * 256;
                  idY *= 16;
                  GL11.glPushMatrix();
                  GL11.glEnable(3042);
                  GL11.glBlendFunc(770, 771);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
                  this.drawTexturedModalRect(x, y, 0, 0, 116, 21);
                  this.mc.func_110434_K().bindTexture(txx2);
                  JGNotificationGUI.color(note.iconColor, alpha);
                  this.drawTexturedModalRect(x + 3, y + 2, idX, idY, 16, 16);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
                  String text = JRMCoreGuiScreen.getStringShortened(fontRenderer, 94, note.title);
                  JRMCoreGuiScreen.drawStringWithBorder(fontRenderer, text, x + 20, y + 5, 16777215);
                  GL11.glDisable(3042);
                  GL11.glPopMatrix();
               }
            }
         }
      }

   }

   public void drawTexturedModalRect(int x, int y, int u, int v, int w, int h) {
      float zLevel = 0.0F;
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.INSTANCE;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)(x + 0), (double)(y + h), (double)zLevel, (double)((float)(u + 0) * f), (double)((float)(v + h) * f1));
      tessellator.func_78374_a((double)(x + w), (double)(y + h), (double)zLevel, (double)((float)(u + w) * f), (double)((float)(v + h) * f1));
      tessellator.func_78374_a((double)(x + w), (double)(y + 0), (double)zLevel, (double)((float)(u + w) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78374_a((double)(x + 0), (double)(y + 0), (double)zLevel, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78381_a();
   }

   public void updateMaxStats() {
      if (this.updateClient == null || Duration.between(this.updateClient, Instant.now()).toMillis() >= 1000L) {
         this.updateClient = Instant.now();
         EntityPlayer p = JRMCoreClient.mc.player;
         byte pwr = JRMCoreH.Pwrtyp;
         byte rce = JRMCoreH.Race;
         byte cls = JRMCoreH.Class;
         JRMCoreH.maxBody = JRMCoreH.stat(p, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
         JRMCoreH.maxEnergy = JRMCoreH.stat(p, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
         JRMCoreH.maxStamina = JRMCoreH.stat(p, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
      }

   }

   public void updateReleaseLevel() {
      if (JRMCoreH.Pwrtyp != 1 && JRMCoreH.Pwrtyp != 2) {
         if (JRMCoreHC.smoothReleaseLevel != (float)JRMCoreH.curRelease) {
            JRMCoreHC.smoothReleaseLevel = (float)JRMCoreH.curRelease;
         }
      } else if (JRMCoreHC.smoothReleaseLevel != (float)JRMCoreH.curRelease) {
         float diff = 1.0F;
         if (this.updateTimer == null) {
            this.updateTimer = Instant.now();
         } else {
            diff = (float)Duration.between(this.updateTimer, Instant.now()).toMillis() / 1000.0F;
            if (JGMathHelper.doubleSmallerThan((double)(JRMCoreHC.smoothReleaseLevel - (float)JRMCoreH.curRelease), 2.0D)) {
               JRMCoreHC.smoothReleaseLevel = (float)JRMCoreH.curRelease;
            } else {
               boolean smaller = JRMCoreHC.smoothReleaseLevel < (float)JRMCoreH.curRelease;
               float add = ((float)JRMCoreH.curRelease - JRMCoreHC.smoothReleaseLevel) / 20.0F * (diff + 1.0F);
               JRMCoreHC.smoothReleaseLevel += add;
               if (smaller) {
                  if (JRMCoreHC.smoothReleaseLevel > (float)JRMCoreH.curRelease) {
                     JRMCoreHC.smoothReleaseLevel = (float)JRMCoreH.curRelease;
                  }
               } else if (JRMCoreHC.smoothReleaseLevel < (float)JRMCoreH.curRelease) {
                  JRMCoreHC.smoothReleaseLevel = (float)JRMCoreH.curRelease;
               }
            }

            this.updateTimer = Instant.now();
         }
      } else if (this.updateTimer != null) {
         this.updateTimer = null;
      }

   }

   static {
      gen = JRMCoreH.pg;
      mp = JRMCoreH.p;
      ts = 0;
      ts2 = 0;
      ts5 = 0;
      fnPressed = 10;
      offsetY = 0.0F;
      clientHght = 1.8F;
      yc = 1.0F;
      clientHeight = JRMCoreComTickH.height - 1.5F;
      clientEyHeigClc = 0.18F;
      clientDefEyHeig = 0.12F;
      clientyOffset = 1.62F;
      notificationPings = new ArrayList();
   }
}
