package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Gui.DBCGuiSpacePod01;
import JinRyuu.DragonBC.common.Gui.ScouterGui;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.JRMCore.JRMCoreCliTicH;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHC;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreKeyHandler;
import JinRyuu.JRMCore.mod_JRMCore;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
import JinRyuu.JRMCore.p.DBC.DBCPdri;
import JinRyuu.JRMCore.p.DBC.DBCPscouter1;
import JinRyuu.JRMCore.p.DBC.DBCPscouter2;
import JinRyuu.JRMCore.p.DBC.DBCPscouter3;
import JinRyuu.JRMCore.p.DBC.DBCPscouter4;
import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class DBCClientTickHandler {
   private int kibar;
   public static int countT = 0;
   public static int warnT = 0;
   public static int startcountT = 0;
   public static int ScFunc0 = 0;
   public static int ScFunc00 = 0;
   public static int ScFunc01 = 0;
   public static int ScFunc02 = 0;
   public static int ScFunc03 = 0;
   public static int ScFunc04 = 0;
   public static int ScFunc05 = 0;
   public static int ScFuncSB = 0;
   public static int heightplus = 0;
   public static int tick = 0;
   public static int runOutOfKi = 0;
   public static int c = 0;
   public static boolean selected = false;
   public static short csicsu = 0;
   public static boolean KAchrgOn = false;
   private int previousTime = 0;
   private int currentTime = 0;
   private int countingValue = 0;
   public static int counterValue = 0;
   ArrayList<double[]> dbs = new ArrayList();
   private static int gdb = 0;
   private static int ticking;
   private static int TiLess;
   private static int TiSen;
   private Minecraft mc;
   public static int time = 0;
   public static int power = 0;
   public static int jump = 0;
   public static int ascend = 0;
   public static int pup = 0;
   public static int ptime = 0;
   public static int partnorm = 0;
   public static int inSuperTime = 0;
   public static int inSuperTime2 = 0;
   public static int inSuperTime3 = 0;
   public static float explevel;
   public static String textura;
   public static Item SuperHair;
   public static Item NormalHair;
   public static Block BlockHair01;
   private int check;
   public int test;
   private int timeincham;
   private boolean liedown;
   private int curHand;
   private static boolean inc;
   public static boolean charge = false;
   public static int charg = 0;
   public static int mountHelper = 0;
   public static boolean instantTransmissionOn = false;
   public static boolean instantTransmissionRequestSent = false;
   public static Instant instantTransmissionPress = null;
   public static boolean instantTransmissionWarning = false;

   public DBCClientTickHandler() {
      this.mc = DBCClient.mc;
      this.check = 0;
      this.test = 0;
   }

   public static boolean isPlayerInCreativeMode() {
      return JRMCoreH.isInCreativeMode(DBCClient.mc.player);
   }

   public void onRenderTickInGUI(GuiScreen guiscreen) {
      if (this.mc.player != null) {
         EntityPlayer player = Minecraft.func_71410_x().player;
         ItemStack hand = player.field_71071_by.func_70448_g();
         ItemStack stackhead = ExtendedPlayer.get(this.mc.player).inventory.func_70301_a(2);
         if (JRMCoreH.armTypScoutAllOn(stackhead) && DBCKeyHandler.ScFunc.func_151470_d()) {
            ++ScFuncSB;
            KeyBinding var10000;
            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc00 = 1;
               ScFuncSB = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74506_a();
            }

            if (ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFuncSB = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74506_a();
            }

            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc01 = 0;
               ScFunc02 = 1;
               ScFuncSB = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
            }

            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc02 = 0;
               ScFunc03 = 1;
               ScFuncSB = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
            }

            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0) {
               ScFunc03 = 0;
               ScFunc04 = 1;
               ScFuncSB = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
            }

            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1) {
               ScFunc04 = 0;
               ScFuncSB = 0;
               ScFunc00 = 0;
               var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
            }
         }

         DBCClient.scouterGui.renderScouter();
      }

   }

   public static boolean onHotbar(Item item, EntityPlayer player) {
      for(int i = 0; i < 9; ++i) {
         if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() == item) {
            return true;
         }
      }

      return false;
   }

   public void onRenderTick() {
      this.currentTime = (int)(System.currentTimeMillis() / 1000L);
      if (this.currentTime != this.previousTime) {
         this.previousTime = this.currentTime;
         counterValue = this.countingValue;
         this.countingValue = 0;
      }

      if (this.currentTime == this.previousTime) {
         ++this.countingValue;
      }

      if (!this.mc.func_147113_T()) {
         for(int i = 0; i < JRMCoreH.techniqueCooldowns.length; ++i) {
            if (JRMCoreH.techniqueCooldowns[i] >= 0.0F) {
               float[] var10000 = JRMCoreH.techniqueCooldowns;
               var10000[i] -= 10.0F / (float)counterValue;
            }

            if (JRMCoreH.techniqueCooldowns[i] <= 0.0F) {
               JRMCoreH.techniqueCooldowns[i] = 0.0F;
            }
         }

         JRMCoreH.updateAllOldCooldownValues();
      }

      if (this.mc.field_71415_G) {
         Minecraft var7 = this.mc;
         if (Minecraft.func_71382_s()) {
            EntityPlayer var4 = Minecraft.func_71410_x().player;
            ItemStack hand = this.mc.player.field_71071_by.func_70448_g();
            ItemStack stackhead = ExtendedPlayer.get(this.mc.player).inventory.func_70301_a(2);
            if (stackhead != null && JRMCoreH.armTypScoutAllOn(stackhead)) {
               if (DBCKeyHandler.ScFunc.func_151470_d()) {
                  ++ScFuncSB;
                  KeyBinding var8;
                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc00 = 1;
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74506_a();
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74506_a();
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc01 = 0;
                     ScFunc02 = 1;
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc02 = 0;
                     ScFunc03 = 1;
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc03 = 0;
                     ScFunc04 = 1;
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1 && ScFunc05 == 0) {
                     ScFunc04 = 0;
                     ScFunc05 = 1;
                     ScFuncSB = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
                  }

                  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 1) {
                     ScFunc05 = 0;
                     ScFuncSB = 0;
                     ScFunc00 = 0;
                     var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
                  }
               }
            } else if (DBCKeyHandler.ScFunc.func_151468_f() && JRMCoreH.SklLvl(6) > 0) {
               ++DBCEH.kisnsMd;
               if (DBCEH.kisnsMd > 4) {
                  DBCEH.kisnsMd = 0;
               }

               String t = JRMCoreH.trlai("dbc", "kisensemode" + DBCEH.kisnsMd);
               ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
               JRMCoreClient.mc.player.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
            }

            if (this.mc.gameSettings.thirdPersonView == 0) {
               DBCClient.scouterGui.renderScouter();
            }
         }
      }

   }

   public void upd(EntityPlayer p) {
      ++gdb;
      if (gdb > 40) {
         gdb = 0;
         this.dbs.clear();
         Block blockID = null;
         if (p.world.field_73011_w.field_76574_g == 20) {
            blockID = BlocksDBC.BlockNamekDragonBall;
         }

         if (p.world.field_73011_w.field_76574_g == 0) {
            blockID = BlocksDBC.BlockDragonBall;
         }

         int m = 80;
         int l1 = MathHelper.func_76128_c(p.posX);
         int i11 = MathHelper.func_76128_c(p.posZ);

         for(int j11 = l1 - m; j11 <= l1 + m; ++j11) {
            for(int j2 = i11 - m; j2 <= i11 + m; ++j2) {
               for(int k2 = 109; k2 >= 64; --k2) {
                  if (p.world.func_147439_a(j11, k2, j2) == blockID) {
                     double[] d = new double[]{(double)j11, (double)j2};
                     this.dbs.add(d);
                  }
               }
            }
         }
      }

   }

   public void DragonRadar(EntityPlayer p) {
      this.upd(p);
      int pitch = (int)p.rotationPitch + 60;

      for(int i = 0; i < this.dbs.size(); ++i) {
         DBCClient.SagaSys.DragonDetect(((double[])this.dbs.get(i))[0] - p.posX, ((double[])this.dbs.get(i))[1] - p.posZ, (float)(pitch > 0 ? pitch : 0));
      }

   }

   public void onTickInGUI() {
      GuiScreen guiscreen = this.mc.field_71462_r;
      if (DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
         int dbcspacepod1 = DBCGuiSpacePod01.ToEarth == 1 ? 3 : (DBCGuiSpacePod01.ToVegeta == 1 ? 2 : (DBCGuiSpacePod01.ToNamek == 1 ? 1 : 0));
         PD.sendToServer(new DBCPspacepod1(dbcspacepod1));
      }

   }

   public static void dri(int a) {
      PD.sendToServer(new DBCPdri(a));
   }

   public void changeCurEnAtSlct(int par1) {
      int lmt = JRMCoreH.mrAtts ? 8 : 4;
      if (par1 > 0) {
         par1 = 1;
      }

      if (par1 < 0) {
         par1 = -1;
      }

      for(JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - par1); JRMCoreH.EnAtSlct < 0; JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct + lmt)) {
      }

      while(JRMCoreH.EnAtSlct >= lmt) {
         JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - lmt);
      }

   }

   public void onTickInGameEnd() {
   }

   public void onTickInGame() {
      EntityPlayer var4 = Minecraft.func_71410_x().player;
      World var3 = FMLClientHandler.instance().getClient().field_71441_e;
      if (this.mc.field_71441_e != null && this.mc.player != null && !this.mc.player.field_70128_L) {
         if (this.mc.func_71387_A()) {
         }

         if (mountHelper != 0) {
            var4.func_70078_a(var4.world.func_73045_a(mountHelper));
            if (var4.func_70115_ae()) {
               mountHelper = 0;
            }
         }

         boolean inAabb = false;
         if (var4.field_71093_bK == DBCConfig.dimTimeChamber) {
            ++this.timeincham;
            if (this.timeincham >= 24000) {
               DBCKiAttacks.dbctick(-6);
               this.timeincham = 0;
               var4.func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dbc.HTC.toolong")));
            }

            inAabb = true;
         }

         if (var4.field_71093_bK == DBCConfig.dimNullRealm && this.mc.player.posY <= (double)DBCConfig.NullRealmMinimumHeight) {
            JRMCoreHDBC.requestNullRealmKnockout();
         }

         if (!inAabb) {
            this.timeincham = 0;
         }

         AxisAlignedBB kn;
         List l3;
         int i;
         int itLevel;
         if (var4.field_71093_bK == DBCConfig.otherWorld) {
            kn = AxisAlignedBB.func_72330_a(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
            l3 = var3.func_72872_a(EntityMasterEnma.class, kn);
            if (l3.size() > 1) {
               for(i = 1; l3.size() > i; ++i) {
                  Entity m = (Entity)l3.get(i);
                  JRMCoreH.KAsounds(m, 999);
               }
            }

            AxisAlignedBB aabbkaio = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
            List kaio = var3.func_72872_a(EntityMasterKaio.class, aabbkaio);
            if (kaio.size() > 1) {
               for(itLevel = 1; kaio.size() > itLevel; ++itLevel) {
                  Entity m = (Entity)kaio.get(itLevel);
                  JRMCoreH.KAsounds(m, 999);
               }
            }
         }

         if (var4.field_71093_bK == 0) {
            kn = AxisAlignedBB.func_72330_a(76.0D, 64.0D, 41.0D, 79.0D, 129.0D, 44.0D);
            l3 = var4.world.func_72872_a(EntityPlayer.class, kn);

            for(i = 0; i < l3.size(); ++i) {
               EntityPlayer e2 = (EntityPlayer)l3.get(i);
               if (e2.getName() == var4.getName()) {
                  float f5 = 0.15F;
                  if (var4.field_70159_w < (double)(-f5)) {
                     var4.field_70159_w = (double)(-f5);
                  }

                  if (var4.field_70159_w > (double)f5) {
                     var4.field_70159_w = (double)f5;
                  }

                  if (var4.field_70179_y < (double)(-f5)) {
                     var4.field_70179_y = (double)(-f5);
                  }

                  if (var4.field_70179_y > (double)f5) {
                     var4.field_70179_y = (double)f5;
                  }

                  var4.field_70143_R = 0.0F;
                  if (var4.field_70181_x < -0.15D) {
                     var4.field_70181_x = -0.15D;
                  }

                  boolean flag = var4.func_70093_af() && var4 instanceof EntityPlayer;
                  if (flag && var4.field_70181_x < 0.0D) {
                     var4.field_70181_x = 0.0D;
                  }

                  if (var4.field_70123_F) {
                     var4.field_70181_x = 0.2D;
                  }
               }
            }
         }

         ItemStack hand = this.mc.player.field_71071_by.func_70448_g();
         if (hand == null && DBCClient.mc.gameSettings.field_74313_G.func_151470_d() && JRMCoreH.KASelected == 16 && !JRMCoreKeyHandler.KiCharge.func_151470_d() && JRMCoreH.kiAmount > 0) {
         }

         int pl;
         if (DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
            pl = DBCGuiSpacePod01.ToEarth == 1 ? 3 : (DBCGuiSpacePod01.ToVegeta == 1 ? 2 : (DBCGuiSpacePod01.ToNamek == 1 ? 1 : 0));
            PD.sendToServer(new DBCPspacepod1(pl));
         }

         if (ScFunc00 == 1) {
            ++ScFunc0;
            if (ScFunc0 == 2) {
               ScFunc01 = 0;
               ScFunc00 = 1;
               ScFunc02 = 0;
               ScFunc03 = 0;
               ScFunc04 = 0;
               ScFunc05 = 0;
               pl = var4.func_145782_y();
               PD.sendToServer(new DBCPscouter1(pl));
            }

            if (ScFunc0 == 30) {
               ScFunc01 = 1;
               ScFunc00 = 0;
               ScFunc0 = 0;
            }
         }

         ScouterGui var10000 = DBCClient.scouterGui;
         if (ScouterGui.count == 1) {
            ++countT;
            if (countT == 5) {
               pl = var4.func_145782_y();
               PD.sendToServer(new DBCPscouter2(pl));
               countT = 0;
            }
         }

         var10000 = DBCClient.scouterGui;
         if (ScouterGui.warn == 1) {
            ++warnT;
            if (warnT == 10) {
               pl = var4.func_145782_y();
               PD.sendToServer(new DBCPscouter3(pl));
               warnT = 10;
            }
         }

         var10000 = DBCClient.scouterGui;
         if (ScouterGui.warn != 1) {
            warnT = 0;
         }

         var10000 = DBCClient.scouterGui;
         if (ScouterGui.startcount == 1) {
            ++startcountT;
            if (warnT == 10) {
               pl = var4.func_145782_y();
               PD.sendToServer(new DBCPscouter4(pl));
               startcountT = 10;
            }
         }

         var10000 = DBCClient.scouterGui;
         if (ScouterGui.startcount != 1) {
            startcountT = 0;
         }

         if (DBCClient.mc.player.field_70154_o != null && DBCClient.mc.player.field_70154_o.getClass() == SpacePod01Entity.class && DBCClient.mc.gameSettings.field_74322_I.func_151470_d()) {
            DBCClient.mc.player.openGui(mod_DragonBC.instance, 0, DBCClient.mc.field_71441_e, (int)DBCClient.mc.player.posX, (int)DBCClient.mc.player.posY, (int)DBCClient.mc.player.posZ);
         }

         if (DBCClient.mc.player.field_70154_o != null) {
            if (DBCClient.mc.gameSettings.field_74351_w.func_151470_d()) {
               JRMCoreH.forw = 1.0D;
               dri(1);
            } else if (DBCClient.mc.gameSettings.field_74368_y.func_151470_d()) {
               JRMCoreH.forw = 2.0D;
               dri(2);
            }

            if (DBCClient.mc.gameSettings.field_74370_x.func_151470_d()) {
               JRMCoreH.forw = 1.0D;
               dri(5);
            } else if (DBCClient.mc.gameSettings.field_74366_z.func_151470_d()) {
               JRMCoreH.forw = 2.0D;
               dri(6);
            }

            if (DBCClient.mc.gameSettings.field_74314_A.func_151470_d() && DBCClient.mc.player.field_70154_o != null) {
               JRMCoreH.forw = 3.0D;
               dri(3);
            } else if (JRMCoreKeyHandler.Fn.func_151470_d() && DBCClient.mc.player.field_70154_o != null) {
               JRMCoreH.forw = 4.0D;
               dri(4);
            } else {
               JRMCoreH.forw = 0.0D;
            }
         }

         if (JRMCoreH.PlyrPwr(var4) == 1) {
            boolean itEnabledShort;
            KeyBinding var79;
            if (JRMCoreH.curRelease != 0 && !JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob) {
               itEnabledShort = DBCClient.mc.gameSettings.field_74322_I.func_151470_d();
               if (hand == null && itEnabledShort && !DBCClient.mc.gameSettings.field_74313_G.func_151470_d() && !JRMCoreH.isChrgng) {
                  byte b = 0;
                  if (JRMCoreKeyHandler.Fn.func_151470_d()) {
                     b = 1;
                  }

                  DBCKiTech.EnAtSlct(b);
                  var79 = DBCClient.mc.gameSettings.field_74322_I;
                  KeyBinding.func_74510_a(DBCClient.mc.gameSettings.field_74322_I.func_151463_i(), false);
                  nuller();
               } else if (JRMCoreKeyHandler.Fn.func_151470_d() && !DBCClient.mc.gameSettings.field_74313_G.func_151470_d() && !JRMCoreH.isChrgng) {
                  i = JRMCoreCliTicH.mw;
                  if (i != 0) {
                     this.changeCurEnAtSlct(i);
                     var4.field_71071_by.field_70461_c = this.curHand;
                     if (DBCClient.mc.gameSettings.field_74331_S) {
                        if (i > 0) {
                           i = 1;
                        }

                        if (i < 0) {
                           i = -1;
                        }

                        GameSettings var80 = DBCClient.mc.gameSettings;
                        var80.field_74328_V += (float)i * 0.25F;
                     }
                  }

                  for(int i = 0; i < 8; ++i) {
                     if (Keyboard.getEventKey() == 2 + i) {
                        JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts ? i : (i < 4 ? i : i - 4));
                        var4.field_71071_by.field_70461_c = this.curHand;
                     }
                  }

                  var4.field_71071_by.field_70461_c = this.curHand;
                  nuller();
               }

               this.curHand = var4.field_71071_by.field_70461_c;
               float p = DBCClient.mc.player.rotationPitch < 0.0F ? (float)((int)DBCClient.mc.player.rotationPitch * -1) : (float)((int)DBCClient.mc.player.rotationPitch);
               float y = DBCClient.mc.player.rotationYaw < 0.0F ? (float)((int)DBCClient.mc.player.rotationYaw * -1) : (float)((int)DBCClient.mc.player.rotationYaw);
               boolean var81;
               if ((!(p > DBCH.RotPic) || !(p > DBCH.RotPic + 0.1F)) && (!(p < DBCH.RotPic) || !(p < DBCH.RotPic - 0.1F)) && (!(y > DBCH.RotYaw) || !(y > DBCH.RotYaw + 0.1F)) && (!(y < DBCH.RotYaw) || !(y < DBCH.RotYaw - 0.1F))) {
                  var81 = false;
               } else {
                  var81 = true;
               }

               byte selectionID = JRMCoreH.EnAtSlct;
               float currentCooldown = JRMCoreH.techCD(selectionID);
               String[] tech = JRMCoreH.tech(selectionID);
               byte[] sts;
               int type;
               if (hand == null && DBCClient.mc.gameSettings.field_74313_G.func_151470_d() && JRMCoreKeyHandler.Fn.func_151470_d() && JRMCoreH.curEnergy > 0 && !JRMCoreKeyHandler.KiCharge.func_151470_d() && tech != null && DBCKiTech.KAkiEn(selectionID, JRMCoreH.curRelease, JRMCoreH.chrgPrc) && JRMCoreConfig.dat5695[JRMCoreH.techDBCty(tech)]) {
                  sts = JRMCoreH.tech_statmods(tech[19]);
                  type = JRMCoreH.techDBCty(tech);
                  int color;
                  int pl;
                  if (!JRMCoreH.isShtng && currentCooldown == 0.0F) {
                     JRMCoreH.isChrgng = JRMCoreH.techDBCctWc(tech, sts) > 10.0F;
                     int f = (int)(50.0F / JRMCoreH.techDBCctWc(tech, sts) * (float)JRMCoreH.charged);
                     int var83 = JRMCoreH.PlyrAttrbts[3];
                     boolean c = JRMCoreH.isFused();
                     color = JRMCoreH.getPlayerAttribute(DBCClient.mc.player, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), 1, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
                     int WIL2 = JRMCoreH.getPlayerAttribute(DBCClient.mc.player, JRMCoreH.PlyrAttrbts, 3, 0, 0, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), false, false, false, false, 1, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
                     int stat = JRMCoreH.stat(DBCClient.mc.player, 3, JRMCoreH.Pwrtyp, 4, color, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     pl = JRMCoreH.stat(DBCClient.mc.player, 3, JRMCoreH.Pwrtyp, 4, WIL2, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     float costKi = (float)(JRMCoreH.techDBCkic(tech, pl, sts) * JRMCoreH.chrgPrc) * 0.02F * (float)JRMCoreH.curRelease * 0.01F;
                     costKi = (float)((double)costKi * JRMCoreConfig.dat5696[type][2]);
                     if (tech[0].equals("KAFakeMoon")) {
                        costKi = (float)Integer.parseInt(tech[7]);
                     }

                     if ((float)JRMCoreH.curEnergy > costKi) {
                        if (f > 50 && csicsu == csicsu / 5 * 5) {
                           ++csicsu;
                           ++JRMCoreH.charged;
                        } else if (f > 50) {
                           ++csicsu;
                        } else if (f <= 50) {
                           ++JRMCoreH.charged;
                        }
                     }

                     if (JRMCoreH.charged > 0 && JRMCoreH.curRelease > 0) {
                        JRMCoreH.cast = 50.0F / JRMCoreH.techDBCctWc(tech, sts) * (float)JRMCoreH.charged;
                        JRMCoreH.chrgPrc = (byte)((int)(JRMCoreH.cast > 100.0F ? 100.0F : JRMCoreH.cast));
                     }
                  }

                  ExtendedPlayer props = ExtendedPlayer.get(var4);
                  if (props.getAnimKiShoot() != type + 1) {
                     byte perc = 100;
                     DBCKiTech.triForce(3, type + 1, selectionID);
                     props.setAnimKiShoot(type + 1);
                     props.setAnimKiShootOn(1);
                     color = Integer.parseInt(JRMCoreH.tech(selectionID)[10]);
                     int align = JRMCoreH.getByte(var4, "jrmcAlign");
                     boolean setGoDOn = false;

                     for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
                        if (JRMCoreH.plyrs[pl] != null && JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.player.getName())) {
                           String s = JRMCoreH.data5[pl].split(";")[0];
                           align = Byte.parseByte(s);
                           setGoDOn = JRMCoreH.StusEfctsClient(20, pl);
                           break;
                        }
                     }

                     if (color == 0) {
                        if (align > 66) {
                           color = 2;
                        }

                        if (align <= 66 && align >= 33) {
                           color = 3;
                        }

                        if (align < 33) {
                           color = 4;
                        }
                     }

                     boolean isCustomAttack = selectionID < 4;
                     props.setGoDOn(setGoDOn && isCustomAttack && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENABLED ? 1 : 0);
                     props.setKiShotCol(color);
                     float density = Float.parseFloat(JRMCoreH.tech(selectionID)[11]);
                     int dam1 = JRMCoreH.getEnegyDamageC(JRMCoreH.tech(selectionID), sts);
                     float size = JRMCoreH.calculateEnergyScale((float)dam1, JRMCoreH.getMaxEnergyDamage(), (float)perc, sts, (byte)((int)density), 0.01F, 0.1F);
                     props.setKiShotSiz(size);
                     int part = 0;
                     String data = JRMCoreH.tech(selectionID)[0];
                     if (!data.toLowerCase().contains("spiritbomb") && !data.toLowerCase().contains("spirit bomb")) {
                        if (!data.toLowerCase().contains("kahame") && !data.toLowerCase().contains("kamehame") && !data.toLowerCase().contains("kame hame")) {
                           if (data.toLowerCase().contains("galic")) {
                              part = 4;
                           } else if (Integer.parseInt(JRMCoreH.tech(selectionID)[3]) == 8 && Integer.parseInt(JRMCoreH.tech(selectionID)[6]) == 1) {
                              part = 3;
                           }
                        } else {
                           part = 2;
                        }
                     } else {
                        part = 1;
                     }

                     props.setKiShotPart(part);
                  }

                  if ((float)JRMCoreH.charged >= JRMCoreH.techDBCctWc(tech, sts) / 2.0F && type == 6 && JRMCoreH.chrgPrc != 0) {
                     if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) {
                        JRMCoreH.isShtng = true;
                        DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc);
                        nuller();
                     }

                     JRMCoreH.isShtng = false;
                     if (tech.length > 12 && JRMCoreH.charged == 1 && !inc) {
                        inc = true;
                        JRMCoreH.quad(1, selectionID > 3 ? 10 : Integer.parseInt(tech[3]), 0, Integer.parseInt(tech[12]) - (selectionID > 3 ? 1 : 0));
                     }
                  }

                  if (tech.length > 12 && JRMCoreH.charged == 3 && !inc) {
                     inc = true;
                     JRMCoreH.quad(1, selectionID > 3 ? 10 : Integer.parseInt(tech[3]), 0, Integer.parseInt(tech[12]) - (selectionID > 3 ? 1 : 0));
                  }
               } else if (tech != null) {
                  sts = JRMCoreH.tech_statmods(tech[19]);
                  if (DBCKiTech.KAkiEn(selectionID, JRMCoreH.curRelease, JRMCoreH.chrgPrc)) {
                     type = JRMCoreH.techDBCty(tech);
                     boolean isMoving = DBCClient.mc.player.field_70159_w < 0.05D && DBCClient.mc.player.field_70179_y < 0.05D && DBCClient.mc.player.field_70159_w > -0.05D && DBCClient.mc.player.field_70179_y > -0.05D && DBCClient.mc.player.field_70181_x < 0.05D;
                     boolean doContinues = type >= JRMCoreConfig.ContinuesKiAttacks.length ? false : JRMCoreConfig.ContinuesKiAttacks[type];
                     if (doContinues && (float)JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F) {
                        if (isMoving) {
                           if ((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F && JRMCoreH.chrgPrc != 0 && !JRMCoreH.isShtng) {
                              EntityClientPlayerMP var82 = DBCClient.mc.player;
                              var82.field_70181_x *= 0.0D;
                              if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) {
                                 DBCKiTech.EnAt(DBCPacketHandlerServer.WAVE_FIRING);
                                 JRMCoreH.isShtng = true;
                                 DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc);
                                 nuller();
                              }
                           }
                        } else {
                           nuller();
                           DBCKiTech.EnAt(DBCPacketHandlerServer.WAVE_STOP);
                        }
                     } else if ((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F && type != 6 && JRMCoreH.chrgPrc != 0) {
                        if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if (JRMCoreH.curRelease != 0) {
                        nuller();
                     }

                     if (!isMoving) {
                        JRMCoreH.isShtng = false;
                     }
                  }
               } else {
                  nuller();
                  JRMCoreH.isShtng = false;
               }

               if (!JRMCoreH.isShtng && !JRMCoreH.isChrgng) {
                  ExtendedPlayer props = ExtendedPlayer.get(var4);
                  if (props.getAnimKiShoot() != 0) {
                     DBCKiTech.triForce(3, 0, 0);
                     props.setAnimKiShoot(0);
                     props.setAnimKiShootOn(0);
                  }
               }

               DBCH.RotPic = p;
               DBCH.RotYaw = y;
               JRMCoreHC.Blocking();
               DBCKiTech.ChargeKi();
               DBCKiTech.JumpKi(DBCClient.mc.gameSettings.field_74314_A);
               DBCKiTech.FloatKi(JRMCoreKeyHandler.KiFlight, DBCClient.mc.gameSettings.field_74314_A, DBCClient.mc.gameSettings.field_74311_E);
               DBCKiTech.TurboMode(JRMCoreKeyHandler.KiDash);
               DBCKiTech.DashKi(var4.func_70051_ag() || DBCKiTech.turbo);
               DBCKiTech.Ascend(JRMCoreKeyHandler.KiAscend);
               DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
            } else {
               if (JGConfigClientSettings.dbcFastFusionSpectatorCameraFollowOn && JRMCoreH.curRelease != 0 && JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob && JRMCoreH.isFused() && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(18)) {
                  for(pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
                     if (JRMCoreH.plyrs[pl].equals(var4.getName())) {
                        String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
                        if (fullFusionData.length >= 3) {
                           String[] fusionData = fullFusionData[2].split(",");
                           if (fusionData.length == 3) {
                              EntityPlayer player = var4.world.getPlayerEntityByName(fusionData[0]);
                              if (player != null) {
                                 var4.field_70159_w -= (var4.posX - player.posX) / 3.0D;
                                 var4.field_70181_x -= (var4.posY - player.posY) / 3.0D;
                                 var4.field_70179_y -= (var4.posZ - player.posZ) / 3.0D;
                              }
                           }
                        }
                        break;
                     }
                  }
               }

               if (JRMCoreH.isPowerTypeKi() && DBCKiTech.floating && JRMCoreH.curRelease == 0) {
                  DBCKiTech.floating = false;
               }

               if (!JRMCoreH.kob) {
                  if (!JRMCoreH.StusEfctsMe(11)) {
                     DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
                     DBCKiTech.DashKi(false);
                  }

                  DBCKiTech.ChargeKi();
               }

               if (JRMCoreKeyHandler.KiFlight.func_151470_d() || JRMCoreKeyHandler.KiDash.func_151470_d() || JRMCoreKeyHandler.KiAscend.func_151470_d()) {
                  String t1 = JRMCoreH.StusEfctsMe(11) ? JRMCoreH.trl("dbc", "fusedspectator") : JRMCoreH.trl("dbc.clienttick.increltouseki");
                  String t2 = JRMCoreKeyHandler.KiCharge.func_151464_g();
                  String tf = String.format(t1, t2);
                  this.mc.player.func_145747_a(new ChatComponentText(tf));
                  var79 = JRMCoreKeyHandler.KiFlight;
                  KeyBinding.func_74510_a(JRMCoreKeyHandler.KiFlight.func_151463_i(), false);
                  var79 = JRMCoreKeyHandler.KiDash;
                  KeyBinding.func_74510_a(JRMCoreKeyHandler.KiDash.func_151463_i(), false);
                  var79 = JRMCoreKeyHandler.KiAscend;
                  KeyBinding.func_74510_a(JRMCoreKeyHandler.KiAscend.func_151463_i(), false);
               }
            }

            if (JRMCoreH.isPowerTypeKi()) {
               JRMCoreHC.BPC_ME = JRMCoreH.gkap(JRMCoreH.bpc(JRMCoreClient.mc.player, JRMCoreClient.mc.player.getName(), JRMCoreH.Pwrtyp), "BPC_ME");
               if (JRMCoreHC.t1s) {
                  JRMCoreHC.BPC_ME2 = JRMCoreH.bpc(JRMCoreClient.mc.player, JRMCoreClient.mc.player.getName(), JRMCoreH.Pwrtyp, 100);
               }

               if (!JRMCoreH.damInd.isEmpty() && JRMCoreH.SklLvl(6) > 0) {
                  ArrayList<String> remove = new ArrayList();
                  if (!JRMCoreH.damInd.isEmpty()) {
                     Iterator var54 = JRMCoreH.damInd.entrySet().iterator();

                     while(var54.hasNext()) {
                        Entry<String, String> mapEntry = (Entry)var54.next();
                        String[] k = ((String)mapEntry.getKey()).split(":");
                        String[] v = ((String)mapEntry.getValue()).split(":");
                        double x = Double.parseDouble(k[0]);
                        double y = Double.parseDouble(k[1]);
                        double z = Double.parseDouble(k[2]);
                        double amount = Double.parseDouble(v[0]);
                        float timeleft = Float.parseFloat(v[1]) - 1.0F;
                        remove.add(mapEntry.getKey());
                        mod_JRMCore.proxy.generateDamIndParticles(x, y, z, amount, timeleft);
                     }
                  }

                  for(i = 0; i < remove.size(); ++i) {
                     JRMCoreH.damInd.remove(remove.get(i));
                  }

                  remove.clear();
               }
            }

            itEnabledShort = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[0];
            boolean itEnabledLong = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[1];
            boolean itEnabled = itEnabledShort || itEnabledLong;
            if (itEnabled) {
               boolean isUsed = this.mc.gameSettings.field_74313_G.func_151470_d();
               if (JRMCoreH.isPowerTypeKi() && JRMCoreH.curRelease != 0) {
                  int itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
                  if (itLevel > 0 && DBCKeyHandler.thirdFn.func_151470_d()) {
                     boolean disabled = false;
                     if (JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob && JRMCoreH.isFused() && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(18)) {
                        for(int pl = 0; pl < JRMCoreH.plyrs.length; ++pl) {
                           if (JRMCoreH.plyrs[pl].equals(var4.getName())) {
                              String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
                              if (fullFusionData.length >= 3) {
                                 String[] fusionData = fullFusionData[2].split(",");
                                 if (fusionData.length == 3) {
                                    EntityPlayer player = var4.world.getPlayerEntityByName(fusionData[0]);
                                    if (player != null) {
                                       disabled = true;
                                    }
                                 }
                              }
                              break;
                           }
                        }
                     }

                     boolean cancelUse = this.mc.gameSettings.field_74312_F.func_151470_d() || this.mc.player.field_71071_by.func_70448_g() != null || disabled;
                     if (cancelUse) {
                        resetIT(isUsed);
                        var79 = DBCKeyHandler.thirdFn;
                        KeyBinding.func_74510_a(DBCKeyHandler.thirdFn.func_151463_i(), false);
                     } else {
                        instantTransmissionOn = true;
                        if (isUsed) {
                           if (itEnabledShort) {
                              if (!instantTransmissionRequestSent) {
                                 DBCKiTech.EnAt(DBCPacketHandlerServer.INSTANT_TRANSMISSION, (byte)0);
                                 instantTransmissionRequestSent = true;
                                 instantTransmissionPress = null;
                                 instantTransmissionPress = Instant.now();
                              } else {
                                 instantTransmissionPress = null;
                                 instantTransmissionOn = false;
                              }
                           } else {
                              String message = "Instant Transmission Failed! Short teleportation is Disabled! ";
                              DBCClient.mc.player.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                           }
                        } else if (instantTransmissionPress == null && !instantTransmissionRequestSent) {
                           instantTransmissionPress = Instant.now();
                        } else if (!instantTransmissionRequestSent) {
                           long timer = Duration.between(instantTransmissionPress, Instant.now()).getSeconds();
                           if (timer >= 4L) {
                              if (itEnabledLong) {
                                 EntityPlayer plyr = DBCClient.mc.player;
                                 plyr.openGui(mod_JRMCore.instance, 10100, plyr.world, (int)plyr.posX, (int)plyr.posY, (int)plyr.posZ);
                                 instantTransmissionRequestSent = true;
                                 instantTransmissionPress = null;
                              } else {
                                 String message = "Instant Transmission Failed! Long teleportation is Disabled! ";
                                 DBCClient.mc.player.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                              }
                           }
                        } else {
                           instantTransmissionPress = null;
                           instantTransmissionOn = false;
                        }
                     }
                  } else {
                     resetIT(isUsed);
                  }
               } else {
                  resetIT(isUsed);
               }
            } else if (JRMCoreH.isPowerTypeKi() && JRMCoreH.curRelease != 0) {
               itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
               if (itLevel > 0) {
                  if (DBCKeyHandler.thirdFn.func_151470_d()) {
                     if (!instantTransmissionWarning) {
                        String message = "Instant Transmission Failed! Teleportation is Disabled! ";
                        DBCClient.mc.player.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                        instantTransmissionWarning = true;
                     }
                  } else {
                     instantTransmissionWarning = false;
                  }
               }
            }
         }
      }

   }

   public static void resetIT(boolean isUsed) {
      instantTransmissionOn = false;
      if (!isUsed) {
         instantTransmissionRequestSent = false;
      }

      instantTransmissionPress = null;
   }

   public static void nuller() {
      JRMCoreH.chrgPrc = 0;
      JRMCoreH.charged = 0;
      JRMCoreH.channel = 0;
      JRMCoreH.wave = 0;
      JRMCoreH.isChrgng = false;
      JRMCoreH.cast = 0.0F;
      csicsu = 0;
      inc = false;
   }

   @SubscribeEvent
   public void onTick(ClientTickEvent event) {
      if (!JRMCoreH.paused) {
         if (event.phase.equals(Phase.START)) {
            this.onTickInGame();
         } else if (event.phase.equals(Phase.END)) {
            this.onTickInGameEnd();
         }
      }

   }

   @SubscribeEvent
   public void onRenderTick(RenderTickEvent event) {
      if (event.phase == Phase.END && !JRMCoreH.paused) {
         this.onRenderTick();
      }

   }
}
