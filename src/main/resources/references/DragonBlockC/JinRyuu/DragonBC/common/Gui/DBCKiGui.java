package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class DBCKiGui extends Gui {
   private Minecraft mc;
   private FontRenderer fontRenderer;
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public int itemKi;
   private float xSize_lo;
   private float ySize_lo;
   protected int guiLeft;
   protected int guiTop;
   protected int xSize;
   protected int ySize;
   public int width;
   public int height;
   private int kihelp1;
   private int kihelp2;
   private short kihelp3;
   private double kihelp4;
   public double ret;

   public DBCKiGui(int i) {
      this.mc = JRMCoreClient.mc;
      this.fontRenderer = this.mc.field_71466_p;
      this.itemKi = 0;
      this.xSize = 176;
      this.ySize = 166;
      this.ret = 0.0D;
      this.itemKi = i;
   }

   public void initGui() {
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.xSize_lo = (float)par1;
      this.ySize_lo = (float)par2;
   }

   public void setWorldAndResolution(Minecraft par1Minecraft, int par2, int par3) {
      this.width = par2;
      this.height = par3;
      this.initGui1();
   }

   public void initGui1() {
      this.guiLeft = (this.width - this.xSize) / 2;
      this.guiTop = (this.height - this.ySize) / 2;
   }

   public void renderTest() {
      ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int width = res.func_78326_a();
      int height = res.func_78328_b();
      FontRenderer fontRender = this.mc.field_71466_p;
      int x = true;
      int y = true;
      int color = 16777215;
   }

   public void renderKiBar(int ki) {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      int var18 = var6 / 2 - 91;
      int var23 = var7 - 52 + 3;
      ki = JRMCoreH.kiAmount;
      int maxki = JRMCoreH.kiMax;
      int maxkiplus = JRMCoreH.kiChargRa;
      double kimult = JRMCoreH.kiMultip;
      int var51 = mod_DragonBC.cwfb + 10;
      int var61 = mod_DragonBC.chfb + 10;
      short var21 = 182;
      double width = 182.0D;
      double max = kimult;
      if (kimult < 1.0D) {
         max = 1.0D;
      }

      double maxperc = width / max;
      double var22 = maxperc * (double)ki;
      if (var22 > width) {
         var22 = width;
      }

      this.kihelp1 = var51;
      this.kihelp2 = var61;
      this.kihelp3 = var21;
      this.kihelp4 = var22;
      boolean var11 = false;
      int var12 = var11 ? 16777215 : 8453920;
      String var34 = "" + ki;
      int var38 = mod_DragonBC.cwfn + ((int)width + var8.func_78256_a(var34)) / 2;
      int var37 = mod_DragonBC.chfn + 2;
      var8.func_78276_b(var34, var38 + 1, var37, 0);
      var8.func_78276_b(var34, var38 - 1, var37, 0);
      var8.func_78276_b(var34, var38, var37 + 1, 0);
      var8.func_78276_b(var34, var38, var37 - 1, 0);
      var8.func_78276_b(var34, var38, var37, 8388564);
      ki = JRMCoreH.dbcHealthCur;
      maxki = JRMCoreH.dbcHealth;
      var51 = var6 - 13;
      var61 = var7 / 2 + 33;
      short var21 = 41;
      int height = 41;
      max = (double)maxki;
      if (max < 1.0D) {
         max = 1.0D;
      }

      maxperc = (double)height / max;
      var22 = maxperc * (double)ki;
      if (var22 > (double)height) {
         var22 = (double)height;
      }

      ResourceLocation tx2 = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.field_71446_o.func_110577_a(tx2);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73729_b(var51, var61, 0, 80, 11, var21);
      if (var22 > 0.0D) {
         this.func_73729_b(var51, var61, 11, 80, 11, (int)var22);
      }

      var11 = false;
      var12 = var11 ? 16777215 : 8453920;
      var34 = "" + ki;
      var38 = var51 + 12 - var34.length() * 6;
      var37 = var61 + 45;
      var8.func_78276_b(var34, var38 + 1, var37, 0);
      var8.func_78276_b(var34, var38 - 1, var37, 0);
      var8.func_78276_b(var34, var38, var37 + 1, 0);
      var8.func_78276_b(var34, var38, var37 - 1, 0);
      var8.func_78276_b(var34, var38, var37, 8388564);
      this.kiBarHelper(this.kihelp1, this.kihelp2, this.kihelp3, this.kihelp4);
   }

   public void kiBarHelper(int var51, int var61, int var21, double var22) {
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.field_71446_o.func_110577_a(tx);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73729_b(var51, var61, 0, 64, var21, 5);
      if (var22 > 0.0D) {
         this.func_73729_b(var51, var61, 0, 69, (int)var22, 5);
      }

   }

   public void renderKiChrgBar() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.field_71446_o.func_110577_a(tx);
      int ki = JRMCoreH.KACharge;
      int maxki = JRMCoreH.kiMax;
      int maxkiplus = JRMCoreH.kiChargRa;
      int selc = JRMCoreH.KASelected;
      int chrg = 0;
      if (selc == 1) {
         chrg = 40;
      }

      if (selc == 2) {
         chrg = 2;
      }

      if (selc == 3) {
         chrg = 40;
      }

      if (selc == 4) {
         chrg = 40;
      }

      if (selc == 5) {
         chrg = 2;
      }

      if (selc == 6) {
         chrg = 40;
      }

      if (selc == 7) {
         chrg = 120;
      }

      if (selc == 8) {
         chrg = 2;
      }

      if (selc == 9) {
         chrg = 50;
      }

      if (selc == 10) {
         chrg = 40;
      }

      if (selc == 11) {
         chrg = 120;
      }

      if (selc == 12) {
         chrg = 70;
      }

      if (selc == 13) {
         chrg = 40;
      }

      if (selc == 14) {
         chrg = 200;
      }

      if (selc == 15) {
         chrg = 200;
      }

      int var51 = var6 / 2 - 30;
      int var61 = var7 / 2 + 60;
      short var21 = 60;
      double width = 60.0D;
      int maxchrg = chrg;
      if (chrg < 1) {
         maxchrg = 1;
      }

      double maxperc = width / (double)maxchrg;
      double var22 = maxperc * (double)ki;
      if (var22 > width) {
         var22 = width;
      }

      this.func_73729_b(var51, var61, 0, 0, var21, 10);
      if (var22 > 0.0D) {
         this.func_73729_b(var51, var61, 0, 10, (int)var22, 10);
      }

   }

   public void renderTP(int tp) {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      String ic = "jinryuudragonbc:icons.png";
      int xSize = 130;
      int ySize = 44;
      int guiLeft = var6 - xSize + 131;
      int guiTop = (var7 - ySize) / 2;
      float pitch = DBCClient.mc.field_71439_g.field_70125_A + 0.0F;
      if (pitch > 0.0F) {
         guiLeft -= (int)(pitch * 1.4F);
      } else {
         guiLeft -= 0;
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(ic);
      this.mc.field_71446_o.func_110577_a(tx);
      int d = JRMCoreH.KASelected;
      if (d != 0) {
         this.func_73729_b(guiLeft, guiTop, 0, 20, xSize, ySize);
         this.name(this.KAName(d), 3, 3, var8, guiLeft, guiTop);
         this.name(this.KAcost(d), 3, 13, var8, guiLeft, guiTop);
         if (d != 16) {
            this.name(this.KAdesc(d), 3, 23, var8, guiLeft, guiTop);
            this.name(this.KAdesc2(d), 3, 33, var8, guiLeft, guiTop);
         }

         int x = 16;
         int y = 16;
         int Left = var6 - x;
         int Top = (var7 - y) / 2;
         String i = "jinryuudragonbc:KA/KA" + d + ".png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation tx2 = new ResourceLocation(i);
         this.mc.field_71446_o.func_110577_a(tx2);
         this.func_73729_b(Left - 1, Top - 33, 0, 0, x, y);
      }

   }

   public void name(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
      int posX = var6 + posx;
      int posY = var7 + posy;
      var8.func_78276_b(var35, posX + 1, posY, 0);
      var8.func_78276_b(var35, posX - 1, posY, 0);
      var8.func_78276_b(var35, posX, posY + 1, 0);
      var8.func_78276_b(var35, posX, posY - 1, 0);
      var8.func_78276_b(var35, posX, posY, 8388564);
   }

   public String KAName(int par1) {
      String ret = "";
      if (par1 == 1) {
         ret = StatCollector.func_74838_a("dbc.KABigBang.name");
      }

      if (par1 == 2) {
         ret = StatCollector.func_74838_a("dbc.KABlast.name");
      }

      if (par1 == 3) {
         ret = StatCollector.func_74838_a("dbc.KABurningAtt.name");
      }

      if (par1 == 4) {
         ret = StatCollector.func_74838_a("dbc.KADeathBeam.name");
      }

      if (par1 == 5) {
         ret = StatCollector.func_74838_a("dbc.KADodon.name");
      }

      if (par1 == 6) {
         ret = StatCollector.func_74838_a("dbc.KAEnergyDisk.name");
      }

      if (par1 == 7) {
         ret = StatCollector.func_74838_a("dbc.KAFinalFlash.name");
      }

      if (par1 == 8) {
         ret = StatCollector.func_74838_a("dbc.KAFingerLeser.name");
      }

      if (par1 == 9) {
         ret = StatCollector.func_74838_a("dbc.KAGalicGun.name");
      }

      if (par1 == 10) {
         ret = StatCollector.func_74838_a("dbc.KAHame.name");
      }

      if (par1 == 11) {
         ret = StatCollector.func_74838_a("dbc.KAHame10x.name");
      }

      if (par1 == 12) {
         ret = StatCollector.func_74838_a("dbc.KAMakanko.name");
      }

      if (par1 == 13) {
         ret = StatCollector.func_74838_a("dbc.KAMasenko.name");
      }

      if (par1 == 14) {
         ret = StatCollector.func_74838_a("dbc.KAPlanetDest.name");
      }

      if (par1 == 15) {
         ret = StatCollector.func_74838_a("dbc.KASpiritbomb.name");
      }

      if (par1 == 16) {
         ret = StatCollector.func_74838_a("dbc.KTKaioken.name");
      }

      return ret;
   }

   public String KAcost(int par1) {
      int explevel = JRMCoreH.kiAscPow;
      if (JRMCoreH.armTypSS1On(DBCClient.mc.field_71439_g)) {
         explevel *= 2;
      }

      if (JRMCoreH.armTypSS2On(DBCClient.mc.field_71439_g)) {
         explevel *= 3;
      }

      if (JRMCoreH.armTypSS3On(DBCClient.mc.field_71439_g)) {
         explevel *= 4;
      }

      int evil = JRMCoreH.align;
      double evl2 = (double)(100 - evil) * 0.01D;
      double good2 = (double)evil * 0.01D;
      double evl = evl2 + 0.2D;
      double good = good2 + 0.2D;
      double neu = 1.0D - (good2 - evl2 < 0.0D ? (good2 - evl2) * -1.0D : good2 - evl2) + 0.2D;
      int maxki = JRMCoreH.kiMax;
      int cost = 0;
      if (par1 == 1) {
         this.ret = neu * 20.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 2) {
         this.ret = (double)(3 * explevel);
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 3) {
         this.ret = good * 15.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 4) {
         this.ret = evl * 8.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 5) {
         this.ret = neu * 5.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 6) {
         this.ret = (double)(10 * explevel);
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 7) {
         this.ret = neu * 16.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 8) {
         this.ret = evl * 6.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 9) {
         this.ret = neu * 9.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 10) {
         this.ret = good * 8.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 11) {
         this.ret = good * 19.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 12) {
         this.ret = neu * 11.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 13) {
         this.ret = good * 9.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 14) {
         this.ret = evl * 100.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 15) {
         this.ret = good * 80.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)((double)(maxki * explevel) * 0.9D) : (int)this.ret;
      }

      if (par1 == 16) {
         cost = JRMCoreH.kiKaioKen;
      }

      return StatCollector.func_74838_a("dbc.itemKiAtt.line1") + cost + " Ki";
   }

   public String KAdesc(int par1) {
      int explevel = JRMCoreH.kiAscPow;
      if (JRMCoreH.armTypSS1On(DBCClient.mc.field_71439_g)) {
         explevel *= 2;
      }

      if (JRMCoreH.armTypSS2On(DBCClient.mc.field_71439_g)) {
         explevel *= 3;
      }

      if (JRMCoreH.armTypSS3On(DBCClient.mc.field_71439_g)) {
         explevel *= 4;
      }

      int evil = JRMCoreH.align;
      double evl2 = (double)(100 - evil) * 0.01D;
      double good2 = (double)evil * 0.01D;
      double evl = evl2 + 0.2D;
      double good = good2 + 0.2D;
      double neu = 1.0D - (good2 - evl2 < 0.0D ? (good2 - evl2) * -1.0D : good2 - evl2) + 0.2D;
      double ret = 0.0D;
      int cost = 0;
      int maxki = JRMCoreH.kiMax;
      if (par1 == 1) {
         ret = neu * 15.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 2) {
         ret = 2.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 3) {
         ret = good * 13.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 4) {
         ret = evl * 5.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 5) {
         ret = neu * 4.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 6) {
         ret = 8.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 7) {
         ret = neu * 9.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 8) {
         ret = evl * 5.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 9) {
         ret = neu * 6.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 10) {
         ret = good * 5.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 11) {
         ret = good * 10.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 12) {
         ret = neu * 7.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 13) {
         ret = good * 5.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 14) {
         ret = evl * 50.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 15) {
         ret = good * 50.0D * (double)explevel;
         cost = (int)this.ret > maxki * explevel ? (int)(ret * (double)(maxki * explevel) / this.ret) : (int)ret;
      }

      if (par1 == 16) {
         ret = (double)JRMCoreH.kiKaioKen;
      }

      return StatCollector.func_74838_a("dbc.itemKiAtt.line2") + cost + StatCollector.func_74838_a("dbc.itemKiAtt.line2.2");
   }

   public String KAdesc2(int par1) {
      return par1 != 2 && par1 != 5 && par1 != 6 && par1 != 8 && par1 != 16 ? StatCollector.func_74838_a("dbc.itemKiAtt.line3") : StatCollector.func_74838_a("dbc.itemKiAtt.line4");
   }
}
