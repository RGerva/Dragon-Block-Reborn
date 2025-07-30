package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class DBCSAAGui extends GuiScreen {
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public int saa = 0;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   private String Process = "Something is Wrong";
   private int wid = 0;
   private int hei = 0;
   private String textureFile = "jinryuudragonbc:sagas.png";

   public void renderSuperProtect(int ki) {
      this.field_146292_n.clear();
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      this.field_146292_n.add(new DBCGuiButtons02(100, posX - 0, posY - 0, 20, 20, "TEST"));
   }

   public DBCSAAGui(int w) {
      this.saa = w;
   }

   public void func_73866_w_() {
      this.field_146292_n.clear();
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      this.field_146292_n.add(new DBCGuiButtons02(-1, posX + 130, posY - 70, 70, 20, StatCollector.func_74838_a("dbc.saagui.abilities")));
      this.field_146292_n.add(new DBCGuiButtons02(-2, posX + 130, posY - 45, 70, 20, StatCollector.func_74838_a("dbc.saagui.sagasystem")));
      if (JRMCoreH.NC()) {
         this.field_146292_n.add(new DBCGuiButtons02(-1, posX - 200, posY - 70, 70, 20, "Dragon Block C"));
         this.field_146292_n.add(new DBCGuiButtons02(-3, posX - 200, posY - 45, 70, 20, "Naruto C"));
      }

      if (this.saa == 1) {
         this.field_146292_n.add(new DBCGuiButtons02(0, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.saagui.body")));
         this.field_146292_n.add(new DBCGuiButtons02(1, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.saagui.trainingpoints")));
         this.field_146292_n.add(new DBCGuiButtons02(2, posX - 82, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.saagui.maxki")));
         this.field_146292_n.add(new DBCGuiButtons02(3, posX + 2, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.saagui.chargeki")));
         this.field_146292_n.add(new DBCGuiButtons02(4, posX - 82, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.saagui.dash")));
         this.field_146292_n.add(new DBCGuiButtons02(5, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.saagui.punch")));
         this.field_146292_n.add(new DBCGuiButtons02(6, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.saagui.jump")));
         this.field_146292_n.add(new DBCGuiButtons02(7, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.saagui.fly")));
         this.field_146292_n.add(new DBCGuiButtons02(8, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.saagui.ascending")));
         this.field_146292_n.add(new DBCGuiButtons02(9, posX + 2, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.saagui.attackpower")));
         this.field_146292_n.add(new DBCGuiButtons01(10, posX - 10, posY + 65, 20, 20, "X"));
         if (!JRMCoreH.HairExists(DBCClient.mc.field_71439_g)) {
            this.field_146292_n.add(new DBCGuiButtons01(200, posX + 55, posY + 65, 70, 20, StatCollector.func_74838_a("dbc.saagui.selecthair")));
         }
      }

      if (this.saa == 2) {
         posY -= 10;
         this.field_146292_n.add(this.actionPerformed(21, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KABigBang.name")));
         this.field_146292_n.add(this.actionPerformed(22, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KABlast.name")));
         this.field_146292_n.add(this.actionPerformed(23, posX - 82, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.KABurningAtt.name")));
         this.field_146292_n.add(this.actionPerformed(24, posX + 2, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.KADeathBeam.name")));
         this.field_146292_n.add(this.actionPerformed(25, posX - 82, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KADodon.name")));
         this.field_146292_n.add(this.actionPerformed(26, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KAEnergyDisk.name")));
         this.field_146292_n.add(this.actionPerformed(27, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAFinalFlash.name")));
         this.field_146292_n.add(this.actionPerformed(28, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAFingerLeser.name")));
         this.field_146292_n.add(this.actionPerformed(29, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAGalicGun.name")));
         this.field_146292_n.add(this.actionPerformed(30, posX + 2, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAHame.name")));
         this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
         this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
         this.field_146292_n.add(new DBCGuiButtons01(101, posX + 85, posY + 65, 40, 20, StatCollector.func_74838_a("dbc.saagui.next")));
      }

      if (this.saa == 3) {
         posY -= 10;
         this.field_146292_n.add(this.actionPerformed(31, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KAHame10x.name")));
         this.field_146292_n.add(this.actionPerformed(32, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAMakanko.name")));
         this.field_146292_n.add(this.actionPerformed(33, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAMasenko.name")));
         this.field_146292_n.add(this.actionPerformed(34, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAPlanetDest.name")));
         this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
         this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
         this.field_146292_n.add(new DBCGuiButtons01(102, posX - 125, posY + 65, 40, 20, StatCollector.func_74838_a("dbc.saagui.back")));
      }

      if (this.saa == 4) {
         posY -= 10;
         this.field_146292_n.add(this.actionPerformed(36, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KTKaioken.name")));
         this.field_146292_n.add(this.actionPerformed(35, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KASpiritbomb.name")));
         this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
         this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
      }

      if (this.saa == 5) {
         this.field_146292_n.add(new DBCGuiButtons00(200, posX - 83, posY - 83, 83, 83, ""));
         this.field_146292_n.add(new DBCGuiButtons00(201, posX + 0, posY - 83, 83, 83, ""));
         this.field_146292_n.add(new DBCGuiButtons00(202, posX - 83, posY + 0, 83, 83, ""));
         this.field_146292_n.add(new DBCGuiButtons00(203, posX + 0, posY + 0, 83, 83, ""));
         this.field_146292_n.add(new DBCGuiButtons06(210, posX + 85, posY - 75, 40, 15, StatCollector.func_74838_a("dbc.saagui.Black")));
         this.field_146292_n.add(new DBCGuiButtons06(211, posX + 85, posY - 60, 40, 15, StatCollector.func_74838_a("dbc.saagui.White")));
         this.field_146292_n.add(new DBCGuiButtons06(212, posX + 85, posY - 45, 40, 15, StatCollector.func_74838_a("dbc.saagui.Purple")));
         this.field_146292_n.add(new DBCGuiButtons06(213, posX + 85, posY - 30, 40, 15, StatCollector.func_74838_a("dbc.saagui.Red")));
         this.field_146292_n.add(new DBCGuiButtons06(214, posX + 85, posY - 15, 40, 15, StatCollector.func_74838_a("dbc.saagui.Brown")));
         this.field_146292_n.add(new DBCGuiButtons06(215, posX + 85, posY + 0, 40, 15, StatCollector.func_74838_a("dbc.saagui.Orange")));
         this.field_146292_n.add(new DBCGuiButtons06(216, posX + 85, posY + 15, 40, 15, StatCollector.func_74838_a("dbc.saagui.Green")));
         this.field_146292_n.add(new DBCGuiButtons06(217, posX + 85, posY + 30, 40, 15, StatCollector.func_74838_a("dbc.saagui.Cyan")));
         this.field_146292_n.add(new DBCGuiButtons06(218, posX + 85, posY + 45, 40, 15, StatCollector.func_74838_a("dbc.saagui.Blue")));
         this.field_146292_n.add(new DBCGuiButtons01(10, posX - 10, posY + 65, 20, 20, "X"));
         this.field_146292_n.add(new DBCGuiButtons01(220, posX + 83, posY + 65, 43, 20, StatCollector.func_74838_a("dbc.saagui.accept")));
      }

   }

   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
      int selct = par1 - 20;
      int KA = 0;
      if (selct == 1) {
         KA = JRMCoreH.KABigBang;
      }

      if (selct == 2) {
         KA = JRMCoreH.KABlast;
      }

      if (selct == 3) {
         KA = JRMCoreH.KABurningAtt;
      }

      if (selct == 4) {
         KA = JRMCoreH.KADeathBeam;
      }

      if (selct == 5) {
         KA = JRMCoreH.KADodon;
      }

      if (selct == 6) {
         KA = JRMCoreH.KAEnergyDisk;
      }

      if (selct == 7) {
         KA = JRMCoreH.KAFinalFlash;
      }

      if (selct == 8) {
         KA = JRMCoreH.KAFingerLaser;
      }

      if (selct == 9) {
         KA = JRMCoreH.KAGalicGun;
      }

      if (selct == 10) {
         KA = JRMCoreH.KAKameHame;
      }

      if (selct == 11) {
         KA = JRMCoreH.KAKameHame10x;
      }

      if (selct == 12) {
         KA = JRMCoreH.KAMakanko;
      }

      if (selct == 13) {
         KA = JRMCoreH.KAMasenko;
      }

      if (selct == 14) {
         KA = JRMCoreH.KAPlanetDest;
      }

      if (selct == 15) {
         KA = JRMCoreH.KASpiritBomb;
      }

      if (selct == 16) {
         KA = JRMCoreH.KTKaioken;
      }

      Object ret;
      if (KA == 1) {
         ret = new DBCGuiButtons02(par1, par2, par3, par4, par5, par6Str);
      } else {
         ret = new DBCGuiButtons01(par1, par2, par3, par4, par5, par6Str);
      }

      return ret;
   }

   public void func_146284_a(GuiButton button) {
      if (button.field_146127_k == -1) {
         this.field_146297_k.field_71439_g.openGui(mod_DragonBC.instance, 6, this.field_146297_k.field_71439_g.field_70170_p, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
      }

      if (button.field_146127_k == -2) {
         this.field_146297_k.field_71439_g.openGui(mod_DragonBC.instance, 5, this.field_146297_k.field_71439_g.field_70170_p, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
      }

      if (button.field_146127_k == -3) {
      }

      if (button.field_146127_k == 0) {
         dbcSAA(20, button.field_146127_k);
         this.player();
      }

      if (button.field_146127_k == 10) {
         this.field_146297_k.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 21 || button.field_146127_k == 22 || button.field_146127_k == 23 || button.field_146127_k == 24 || button.field_146127_k == 25 || button.field_146127_k == 26 || button.field_146127_k == 27 || button.field_146127_k == 28 || button.field_146127_k == 29 || button.field_146127_k == 30 || button.field_146127_k == 31 || button.field_146127_k == 32 || button.field_146127_k == 33 || button.field_146127_k == 34 || button.field_146127_k == 35 || button.field_146127_k == 36 || button.field_146127_k == 100) {
         dbcSAA(button.field_146127_k);
         this.field_146297_k.field_71439_g.func_71053_j();
         if (button.field_146127_k != 100) {
            this.field_146297_k.field_71439_g.func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dbc.saagui.newskill")));
         }
      }

      if (button.field_146127_k == 220) {
         this.field_146297_k.field_71439_g.func_71053_j();
         dbcHair(JRMCoreH.Har + JRMCoreH.Col);
      }

   }

   public void player() {
   }

   public static void dbcSAA(int num, int saa) {
      mod_DragonBC.logger.info("dbcsaa channel is has not been set in DBCSAAGui " + num + " " + saa);
   }

   public static void dbcSAA(int num) {
      int dbctick = num + 100;
   }

   public static void dbcHair(String hair) {
      mod_DragonBC.logger.info("dbchalo channel is has not been set in DBCSAAGui " + hair);
   }

   public void func_73863_a(int x, int y, float f) {
      ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.field_146297_k.field_71466_p;
      String wish = "jinryuudragonbc:saa.png";
      String ww = "jinryuudragonbc:saa2.png";
      int xSize = 256;
      int ySize = 160;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(wish);
      this.field_146297_k.field_71446_o.func_110577_a(tx);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      int j;
      if (this.saa == 5) {
         wish = "jinryuudragonbc:gui/hairs.png";
         j = 0;
         if (JRMCoreH.Col == "_C0") {
            j = 0;
         }

         if (JRMCoreH.Col == "_C1") {
            j = 16777200;
         }

         if (JRMCoreH.Col == "_C2") {
            j = 9265576;
         }

         if (JRMCoreH.Col == "_C3") {
            j = 16766976;
         }

         if (JRMCoreH.Col == "_C4") {
            j = 16724787;
         }

         if (JRMCoreH.Col == "_C5") {
            j = 6045747;
         }

         if (JRMCoreH.Col == "_C6") {
            j = 16744192;
         }

         if (JRMCoreH.Col == "_C7") {
            j = 25600;
         }

         if (JRMCoreH.Col == "_C8") {
            j = 5956839;
         }

         if (JRMCoreH.Col == "_C9") {
            j = 5683455;
         }

         float h2 = (float)(j >> 16 & 255) / 255.0F;
         float h3 = (float)(j >> 8 & 255) / 255.0F;
         float h4 = (float)(j & 255) / 255.0F;
         float h1 = 1.0F;
         GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
         ResourceLocation tx2 = new ResourceLocation(wish);
         this.field_146297_k.field_71446_o.func_110577_a(tx2);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      }

      if (this.saa == 1) {
         j = ySize - 10;
         int guiLeft2 = (this.field_146294_l - xSize) / 2;
         int guiTop2 = (this.field_146295_m - j) / 2;
         this.func_73729_b(guiLeft2, guiTop2, 0, 169, xSize, 5);
         int max = xSize - 20;
         if (max < 1) {
            max = 1;
         }

         double maxperc = (double)max * 0.01D;
         int var22 = (int)(maxperc * (double)JRMCoreH.dbcEvilness);
         if (var22 > xSize) {
            var22 = xSize;
         }

         int xSize2 = 5;
         int ySize3 = ySize - 10;
         int guiLeft3 = (this.field_146294_l - xSize2) / 2 - max / 2 + var22;
         int guiTop3 = guiTop2 - 1;
         this.func_73729_b(guiLeft3, guiTop3, 0, 175, xSize2, 7);
         String s = "";
         int tp;
         int ex;
         if (JRMCoreH.dbcBP != null && JRMCoreH.dbcBP.length > 0) {
            String[] var27 = JRMCoreH.dbcBP;
            tp = var27.length;

            for(ex = 0; ex < tp; ++ex) {
               String n = var27[ex];
               String[] m = n.split(";");
               if (this.field_146297_k.field_71439_g.func_70005_c_().equals(m[0])) {
                  s = m[1];
               }
            }
         }

         this.current("BP: " + s, 0, -71, var8, var6, var7);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation tx3 = new ResourceLocation(ww);
         this.field_146297_k.field_71446_o.func_110577_a(tx3);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         tp = JRMCoreH.dbcTrainPoint;
         ex = JRMCoreH.jrmcExp;
         boolean var11 = false;
         int var12 = var11 ? 16777215 : 8453920;
         String var34 = StatCollector.func_74838_a("dbc.saagui.curexp") + " " + ex;
         int var38 = 5;
         int var37 = 5;
         var8.func_78276_b(var34, var38 + 1, var37, 0);
         var8.func_78276_b(var34, var38 - 1, var37, 0);
         var8.func_78276_b(var34, var38, var37 + 1, 0);
         var8.func_78276_b(var34, var38, var37 - 1, 0);
         var8.func_78276_b(var34, var38, var37, 8388564);
         this.current("" + JRMCoreH.kiPunch, 105, -10, var8, var6, var7);
         this.current("" + JRMCoreH.kiDash, -105, -10, var8, var6, var7);
         this.current("" + JRMCoreH.kiMax, -105, -35, var8, var6, var7);
         this.current("" + JRMCoreH.kiChargRa, 105, -35, var8, var6, var7);
         this.current("" + JRMCoreH.kiJump, -105, 15, var8, var6, var7);
         this.current("" + JRMCoreH.kiFly, 105, 15, var8, var6, var7);
         this.current("" + JRMCoreH.kiAsclvl, -105, 40, var8, var6, var7);
         this.current("" + JRMCoreH.kiAscPow, 105, 40, var8, var6, var7);
         this.current("" + JRMCoreH.dbcTrainPoint, 105, -60, var8, var6, var7);
         this.current("" + JRMCoreH.dbcHealth, -105, -60, var8, var6, var7);
         this.current2("" + JRMCoreH.kiPunch + "TP", 105, -10, var8, var6, var7);
         this.current2("" + JRMCoreH.kiDash + "TP", -105, -10, var8, var6, var7);
         this.current2("" + (JRMCoreH.kiMax / 50 <= 0 ? 1 : JRMCoreH.kiMax / 50) + "TP", -105, -35, var8, var6, var7);
         this.current2("" + JRMCoreH.kiChargRa + "TP", 105, -35, var8, var6, var7);
         this.current2("" + JRMCoreH.kiJump + "TP", -105, 15, var8, var6, var7);
         this.current2("" + JRMCoreH.kiFly + "TP", 105, 15, var8, var6, var7);
         this.current2("" + JRMCoreH.kiAsclvl * 20 + "TP", -105, 40, var8, var6, var7);
         this.current2("" + JRMCoreH.kiAscPow + "TP", 105, 40, var8, var6, var7);
         this.current2("5DBCxp", 106, -60, var8, var6, var7);
         this.current2("" + (JRMCoreH.dbcHealth / 50 <= 0 ? 1 : JRMCoreH.dbcHealth / 50) + "TP", -105, -60, var8, var6, var7);
      }

      super.func_73863_a(x, y, f);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
      int wid = var8.func_78256_a(var35) / 2;
      int posX = var6 / 2 + posx - wid;
      int posY = var7 / 2 + posy + 8 - 6;
      var8.func_78276_b(var35, posX + 1, posY, 0);
      var8.func_78276_b(var35, posX - 1, posY, 0);
      var8.func_78276_b(var35, posX, posY + 1, 0);
      var8.func_78276_b(var35, posX, posY - 1, 0);
      var8.func_78276_b(var35, posX, posY, 8388564);
   }

   public void current2(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
      int wid = var8.func_78256_a(var35) / 2;
      int posX = var6 / 2 + posx - wid;
      int posY = var7 / 2 + posy + 8 + 10 - 6;
      var8.func_78276_b(var35, posX + 1, posY, 0);
      var8.func_78276_b(var35, posX - 1, posY, 0);
      var8.func_78276_b(var35, posX, posY + 1, 0);
      var8.func_78276_b(var35, posX, posY - 1, 0);
      var8.func_78276_b(var35, posX, posY, 8388564);
   }

   public void SagasPage(int var6, int var7) {
      this.textureFile = "jinryuudragonbc:sagas.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void SagasPrint() {
      this.func_73866_w_();
      Minecraft minecraft = this.field_146297_k;
      World world = minecraft.field_71441_e;
      EntityPlayerSP entityplayersp = minecraft.field_71439_g;
      ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
      int width = scaledresolution.func_78326_a() / 2;
      int height = scaledresolution.func_78328_b() / 2;
      int widthplus = true;
      GL11.glEnable(3042);
      GL11.glEnable(32826);
      RenderHelper.func_74519_b();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73732_a(this.field_146289_q, this.Process, width + this.wid, height + this.hei, 16768306);
      GL11.glDisable(32826);
      GL11.glDisable(3042);
   }

   public void SagasBack(int var6, int var7) {
      int xSize = 182;
      int ySize = 191;
      int guiLeft = (var6 - xSize) / 2;
      int guiTop = (var7 - ySize) / 2;
      String var4 = "jinryuudragonbc:sagas.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(var4);
      this.field_146297_k.field_71446_o.func_110577_a(tx);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
   }

   public void ScouterRenderBlur(int par1, int par2) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      ResourceLocation tx = new ResourceLocation(this.textureFile);
      this.field_146297_k.field_71446_o.func_110577_a(tx);
      Tessellator var3 = Tessellator.field_78398_a;
      var3.func_78382_b();
      var3.func_78374_a(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
      var3.func_78374_a((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
      var3.func_78374_a((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
      var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var3.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
