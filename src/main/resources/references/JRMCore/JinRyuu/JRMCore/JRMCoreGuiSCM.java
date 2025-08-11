package JinRyuu.JRMCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiSCM extends GuiScreen {
   public static Minecraft mc = Minecraft.func_71410_x();
   protected int guiLeft;
   protected int guiTop;
   protected int xSize = 256;
   protected int ySize = 159;
   private float xSize_lo;
   private float ySize_lo;
   int id = 0;
   private int tick = 0;
   private int guiID = 0;
   private int ipg = 0;
   private int lp = 0;

   public void func_73866_w_() {
      this.field_146292_n.clear();
      this.guiLeft = (this.field_146294_l - this.xSize) / 2;
      this.guiTop = (this.field_146295_m - this.ySize) / 2;
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      JRMCoreH.jrmct(1);
      JRMCoreH.jrmct(3);
   }

   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
      int selct = par1 - 20;
      int KA = false;
      JRMCoreGuiButtons00 ret;
      if (KA) {
         ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
      } else {
         ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
      }

      return ret;
   }

   public void func_146284_a(GuiButton button) {
      if (button.field_146127_k == 0) {
         this.id = 0;
      }

   }

   public void func_73863_a(int x, int y, float f) {
      this.xSize_lo = (float)x;
      this.ySize_lo = (float)y;
      ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = mc.field_71466_p;
      String wish = "jinryuumodscore:gui.png";
      String icons = "jinryuumodscore:icons.png";
      this.field_146292_n.clear();
      ++this.tick;
      if (this.tick >= 20) {
         this.tick = 0;
         JRMCoreH.jrmct(1);
         JRMCoreH.jrmct(3);
      }

      this.guiLeft = (this.field_146294_l - this.xSize) / 2;
      this.guiTop = (this.field_146295_m - this.ySize) / 2;
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      byte pwr = JRMCoreH.Pwrtyp;
      short xSize;
      short ySize;
      int guiLeft;
      int guiTop;
      ResourceLocation guiLocation;
      String n;
      int n;
      String[] SklsNms;
      int[][] rSklsLvl;
      if (this.guiID == 11) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.bindTexture(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         this.field_146292_n.add(new JRMCoreGuiButtons00(100, posX - 120, posY + 85, 80, 20, JRMCoreH.trl("jrmc", "MainAttributes"), 0));
         this.field_146292_n.add(new JRMCoreGuiButtons00(101, posX - 35, posY + 85, 80, 20, JRMCoreH.trl("jrmc", "Skills"), 0));
         this.field_146292_n.add(new JRMCoreGuiButtons00(102, posX + 50, posY + 85, 80, 20, JRMCoreH.Pwrtyp == 1 ? JRMCoreH.trl("jrmc", "KiTechniques") : JRMCoreH.trl("jrmc", "Jutsu"), 0));
         if (JRMCoreH.Pwrtyp == 2) {
            String l = JRMCoreH.trl("jrmc", "Learn");
            int lw = this.field_146289_q.func_78256_a(l);
            this.field_146292_n.add(new JRMCoreGuiButtons01(-200, guiLeft + 250 - lw, guiTop + 5, lw, l, JRMCoreH.techNCCol[1]));
         }

         String[] rSklsNms;
         String[] cSkls;
         int[][] cSklsLvl;
         String[] cSklsNms;
         String[] skls;
         int[][] sklsLvl;
         String[] sklsNms;
         String mod;
         if (JRMCoreH.Pwrtyp == 2) {
            SklsNms = JRMCoreH.ncRSkls;
            rSklsLvl = JRMCoreH.ncRSklsLvl;
            rSklsNms = JRMCoreH.ncRSklsNms;
            cSkls = JRMCoreH.ncCSkls;
            cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
            cSklsNms = JRMCoreH.NCRacialSkillAbilityNames;
            skls = JRMCoreH.NCSkillIDs;
            sklsLvl = JRMCoreH.NCSkillTPCost;
            sklsNms = JRMCoreH.NCSkillNames;
            mod = "nc";
         } else {
            SklsNms = JRMCoreH.vlblRSkls;
            rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
            rSklsNms = JRMCoreH.vlblRSklsNms;
            cSkls = JRMCoreH.vlblCSkls;
            cSklsLvl = JRMCoreH.vlblCSklsLvl;
            cSklsNms = JRMCoreH.vlblCSklsNms;
            skls = JRMCoreH.DBCSkillsIDs;
            sklsLvl = JRMCoreH.DBCSkillTPCost;
            sklsNms = JRMCoreH.DBCSkillNames;
            mod = "dbc";
         }

         byte b = 0;
         boolean tpLevelCost;
         String s;
         int tpLevelCost;
         if (JRMCoreH.PlyrSkillX != null && !JRMCoreH.PlyrSkillX.contains("pty") && JRMCoreH.PlyrSkillX.length() > 1) {
            ++b;
            n = JRMCoreH.trl(mod, JRMCoreH.SklName(JRMCoreH.PlyrSkillX, SklsNms, rSklsNms, JRMCoreH.Race));
            n = Integer.parseInt(JRMCoreH.PlyrSkillX.substring(2));
            var8.func_78276_b("§0" + n + (n < 6 ? " §8lvl: " + n : ""), guiLeft + 5, guiTop + 15 + b * 10, 0);
            if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && n < 6) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(340, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
            }

            if (JRMCoreH.Race == 4 && n < 4) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(340, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
            }

            if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.PlyrSkillY != null && JRMCoreH.PlyrSkillY.contains("Sai") && n >= 5) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(JRMCoreH.PlyrSkillY.contains("R") ? 343 : 342, guiLeft + 10 + var8.func_78256_a(n + (n < 6 ? " §8lvl: " + n : "")), guiTop + 15 + b * 10, 20, JRMCoreH.PlyrSkillY.contains("R") ? 0 : 1));
            }

            tpLevelCost = false;
            if (mod.equals("dbc")) {
               tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, rSklsLvl);
            } else {
               tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillY, JRMCoreH.Race, cSklsLvl);
            }

            if (JRMCoreH.Race != 1 && JRMCoreH.Race != 2 && JRMCoreH.Race != 4) {
               s = JRMCoreH.trl("jrmc", "NoUpgrade");
               var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
            } else {
               s = n < (JRMCoreH.Race != 1 && JRMCoreH.Race != 2 ? (JRMCoreH.Race == 4 ? 4 : 0) : 6) ? (tpLevelCost == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + tpLevelCost) : JRMCoreH.trl("jrmc", "Maxed");
               var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
            }
         }

         if (JRMCoreH.PlyrSkillY != null && !JRMCoreH.PlyrSkillY.contains("pty") && !JRMCoreH.PlyrSkillY.contains("Sai") && JRMCoreH.Race != 1 && JRMCoreH.Race != 2 && JRMCoreH.PlyrSkillY.length() > 1) {
            ++b;
            n = JRMCoreH.SklName(JRMCoreH.PlyrSkillY, cSkls, cSklsNms);
            n = Integer.parseInt(JRMCoreH.PlyrSkillY.substring(2));
            var8.func_78276_b("§0" + (JRMCoreH.Race != 1 && JRMCoreH.Race != 2 ? n + " §8lvl: " + (n + 1) : JRMCoreH.TransSaiUpNam[n]), guiLeft + 5, guiTop + 15 + b * 10, 0);
            if (n <= 8) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(341, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
            }

            tpLevelCost = false;
            if (mod.equals("dbc")) {
               tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, rSklsLvl);
            } else {
               tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillY, JRMCoreH.Race, cSklsLvl);
            }

            s = n <= 8 ? (tpLevelCost == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + tpLevelCost) : JRMCoreH.trl("jrmc", "Maxed");
            var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
         }

         if (JRMCoreH.PlyrSkills != null) {
            int s = 0;

            for(byte i = 0; i < JRMCoreH.PlyrSkills.length; ++i) {
               String currentSkill = JRMCoreH.PlyrSkills[i];
               if (!currentSkill.contains("pty") && currentSkill.length() > 2) {
                  ++b;
                  s = JRMCoreH.Pwrtyp == 1 ? JRMCoreH.trl("dbc", JRMCoreH.SklName(currentSkill, skls, sklsNms)) : JRMCoreH.trl("nc", JRMCoreH.SklName(currentSkill, skls, sklsNms));
                  int n = Integer.parseInt(currentSkill.substring(2));
                  var8.func_78276_b("§0" + s + " §8lvl: " + (n + 1), guiLeft + 5, guiTop + 15 + b * 10, 0);
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(300 + i, guiLeft + 255, guiTop + 15 + b * 10, 10, 3));
                  if (n <= 8) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA3(320 + i, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
                  }

                  int tpLevelCost = JRMCoreH.skillTPCost(currentSkill, skls, sklsLvl);
                  String st = n <= 8 ? (tpLevelCost == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + tpLevelCost) : JRMCoreH.trl("jrmc", "Maxed");
                  var8.func_78276_b(st, guiLeft + 250 - var8.func_78256_a(st), guiTop + 15 + b * 10, 0);
               } else {
                  ++s;
               }
            }
         }
      }

      if (this.guiID == 16) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.bindTexture(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         String mod;
         if (pwr == 2) {
            SklsNms = JRMCoreH.NCSkillNames;
            rSklsLvl = JRMCoreH.NCSkillTPCost;
            mod = "nc";
         } else {
            SklsNms = JRMCoreH.DBCSkillNames;
            rSklsLvl = JRMCoreH.DBCSkillTPCost;
            mod = "dbc";
         }

         var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
         int i2 = 0;
         int nms = SklsNms.length;

         for(byte i = 0; i < nms; ++i) {
            if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
               String fn = JRMCoreH.trl(mod, SklsNms[i]);
               int fnw = this.field_146289_q.func_78256_a(fn);
               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, 0);
               String on = JRMCoreH.SklLvl(i, pwr) < 1 ? "" : " " + JRMCoreH.trl("jrmc", "Owned");
               int onw = this.field_146289_q.func_78256_a(on);
               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
               if (JRMCoreH.SklLvl(i, pwr) < 1) {
                  int tpCost = JRMCoreH.getSkillTPCost(i, 0, JRMCoreH.isPowerTypeKi());
                  n = " " + tpCost + " tp";
                  n = this.field_146289_q.func_78256_a(fn);
                  if (tpCost != -1 && JRMCoreH.curTP >= tpCost) {
                     this.field_146292_n.add(new JRMCoreGuiButtons01(JRMCoreH.SklLvl(i, pwr) < 1 ? 4000 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, n, n, JRMCoreH.techNCCol[1]));
                  } else {
                     var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                  }
               }
            }

            ++i2;
         }

         String p;
         if (i2 > 13 + this.lp * 13) {
            p = JRMCoreH.trl("jrmc", "Next");
            this.field_146292_n.add(new JRMCoreGuiButtons00(88, guiLeft + xSize / 2 + 130, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(p) + 8, 20, p, 0));
         }

         if (this.lp != 0) {
            p = JRMCoreH.trl("jrmc", "Prev");
            int pw = this.field_146289_q.func_78256_a(p) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(89, guiLeft + xSize / 2 - 130 - pw, guiTop + (ySize + 1) / 2 + 15, pw, 20, p, 0));
         }
      } else {
         this.lp = 0;
      }

      super.func_73863_a(x, y, f);
   }

   public boolean func_73868_f() {
      return false;
   }
}
