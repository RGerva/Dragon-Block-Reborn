package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.DBCKiAttacks;
import JinRyuu.DragonBC.common.DBCKiTech;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreGuiButtons00MS;
import JinRyuu.JRMCore.JRMCoreGuiButtons01;
import JinRyuu.JRMCore.JRMCoreGuiScreen;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreM;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPdri;
import JinRyuu.JRMCore.p.DBC.DBCPwish;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class DBCTalkGui extends GuiScreen {
   public static final int ENMA = 10;
   public static final int ENMA_REINCARNATE = 1001;
   public static final int KAMI = 11;
   public static final int KAMI_STARTANEW = 1101;
   public static final int KAMI_CUTTAIL = 1102;
   public static final int KAMI_REGROWTAIL = 1104;
   public static final int KAMI_WEIGHT = 1105;
   public static final int KAMI_SKILLS = 111;
   public static final int JIN = 9000;
   public static final int JIN_SKILLS = 9100;
   public static final int GURU = 9001;
   public static final int GURU_SKILLS = 9101;
   public static final int WHIS = 9002;
   public static final int WHIS_SKILLS = 9102;
   public static final int KAIO = 12;
   public static final int KAIO_SKILLS = 112;
   public static final int KAIO_ATTACKS = 1121;
   public static final int KAIO_DIFFICULTY = 221;
   public static final int KARIN = 13;
   public static final int KARIN_SKILLS = 113;
   public static final int ROSHI = 15;
   public static final int ROSHI_SKILLS = 115;
   public static final int ROSHI_ATTACKS = 1151;
   public static final int CELL = 16;
   public static final int CELL_SKILLS = 116;
   public static final int CELL_ATTACKS = 1161;
   public static final int GOKU = 17;
   public static final int GOKU_SKILLS = 117;
   public static final int GOKU_ATTACKS = 1171;
   public static final int FRIEZA = 18;
   public static final int FRIEZA_SKILLS = 118;
   public static final int FRIEZA_ATTACKS = 1181;
   public static final int BABIDI = 19;
   public static final int BABIDI_SKILLS = 119;
   public static final int BABIDI_ATTACKS = 1191;
   public static final int PICCOLO = 20;
   public static final int PICCOLO_SKILLS = 120;
   public static final int PICCOLO_ATTACKS = 1201;
   public static final int VEGETA = 21;
   public static final int VEGETA_SKILLS = 121;
   public static final int VEGETA_ATTACKS = 1211;
   public static final int GOHAN = 22;
   public static final int GOHAN_SKILLS = 122;
   public static final int GOHAN_ATTACKS = 1221;
   public static final int TRUNKS = 23;
   public static final int TRUNKS_SKILLS = 123;
   public static final int TRUNKS_ATTACKS = 1231;
   private Minecraft mc;
   private FontRenderer fontRenderer;
   private int tick;
   private GuiIngame Guiingame;
   private int wish;
   private int ipg;
   private int lp;
   private int master;
   private HashMap<String, String> MsnSysTalkTo;
   private String CurMaster;
   private String name;
   private int text;
   protected GuiTextField inputField;
   private String defaultInputFieldText;
   private int updateTimer;
   private int updateTime;
   private boolean updateTimerStopper;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   private String Process;
   private int wid;
   private int hei;
   private String textureFile;

   public void renderSuperProtect(int ki) {
      this.field_146292_n.clear();
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      this.field_146292_n.add(new DBCGuiButtons01(100, posX - 0, posY - 0, 20, 20, "TEST"));
   }

   public DBCTalkGui(int w, World wld, int x, int y, int z) {
      this.mc = JRMCoreClient.mc;
      this.fontRenderer = this.mc.field_71466_p;
      this.wish = 0;
      this.ipg = 0;
      this.lp = 0;
      this.master = 0;
      this.CurMaster = "";
      this.name = "";
      this.text = 0;
      this.defaultInputFieldText = "";
      this.updateTimer = 0;
      this.updateTime = 0;
      this.updateTimerStopper = false;
      this.Process = "Something is Wrong";
      this.wid = 0;
      this.hei = 0;
      this.textureFile = "jinryuudragonbc:sagas.png";
      double n = 0.1D;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a((double)x - n, (double)y + n, (double)z - n, (double)x + n, (double)y + n, (double)z + n);
      List l = wld.func_72872_a(EntityDBCKami.class, aabb);
      Iterator it = l.iterator();
      if (it.hasNext()) {
         EntityDBCKami k = (EntityDBCKami)it.next();
         this.CurMaster = k.func_70005_c_();
      }

      this.wish = w;
      this.updateTime = 0;
      JRMCoreH.revTmr = -1;
      JRMCoreH.Master = 1;
      this.MsnSysTalkTo = JRMCoreM.getMda_Obj_TalkTo();
      if (this.wish == 13) {
         DBCKiAttacks.dbctick(-100);
      } else if (this.wish == 12) {
         DBCKiAttacks.dbctick(-101);
      } else if (this.wish == 15) {
         DBCKiAttacks.dbctick(-101);
      } else if (this.wish == 16) {
         DBCKiAttacks.dbctick(-101);
      } else if (this.wish == 17) {
         DBCKiAttacks.dbctick(-101);
      } else if (this.wish == 18) {
         DBCKiAttacks.dbctick(-101);
      } else if (this.wish == 19) {
         DBCKiAttacks.dbctick(-101);
      }

   }

   public void func_73866_w_() {
   }

   public void func_146284_a(GuiButton button) {
      if (button.field_146127_k == -1) {
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 0) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 1) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 2) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 3) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 4) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 10) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 11) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 12) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 13) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 14) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 99) {
         this.updateTime = 0;
         if (this.wish == 10) {
            this.wish = 1001;
         } else if (this.wish == 1001) {
            this.wish = 10;
         }
      }

      if (button.field_146127_k == 100) {
         this.dbcTelep(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 101) {
         this.dbcTelep(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 103) {
         this.wish = 221;
      }

      if (button.field_146127_k == 104) {
         this.wish = 12;
      }

      if (button.field_146127_k == 105) {
         this.mc.field_71439_g.func_71053_j();
         JRMCoreH.Char((byte)101, (byte)0);
      }

      if (button.field_146127_k == 106) {
         JRMCoreH.Char((byte)104, (byte)0);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 107) {
         this.wish = 1102;
      }

      if (button.field_146127_k == 108) {
         this.wish = 1104;
      }

      if (button.field_146127_k == 109) {
         JRMCoreH.Char((byte)105, (byte)0);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 198) {
         this.wish = 113;
      }

      if (button.field_146127_k == 110) {
         this.wish = 1105;
      }

      if (button.field_146127_k == 111) {
         this.wish = 2005;
      }

      int i;
      for(i = 0; i < 15; ++i) {
         if (button.field_146127_k == 10111 + i) {
            this.wish = 111 + i;
         }

         if (button.field_146127_k == 101111 + i * 10) {
            this.wish = 1111 + i * 10;
         }
      }

      if (button.field_146127_k == 9100) {
         this.wish = 9100;
      }

      if (button.field_146127_k == 9101) {
         this.wish = 9101;
      }

      if (button.field_146127_k == 9102) {
         this.wish = 9102;
      }

      if (button.field_146127_k == 199) {
         this.dbcWish(button.field_146127_k);
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 201) {
         this.mc.field_71439_g.func_71053_j();
         JRMCoreH.Char((byte)4, (byte)0);
         JRMCoreH.Char((byte)100, (byte)0);
         boolean doit = true;
         if (JRMCoreH.DBC() && this.mc.field_71439_g != null) {
            doit = !JRMCoreH.isFused();
         }

         if (doit) {
            JRMCoreH.resetChar();
            DBCKiTech.turbo = false;
         }
      }

      if (button.field_146127_k == 2011) {
         this.wish = 1101;
      }

      if (button.field_146127_k == 2012) {
         this.wish = 11;
      }

      if (button.field_146127_k == 202) {
         if (JRMCoreH.align > 65) {
            this.dbcWish(button.field_146127_k);
         } else {
            this.dbcWish(button.field_146127_k + 1);
         }

         this.mc.field_71439_g.func_71053_j();
      }

      if (button instanceof JRMCoreGuiButtons00MS && button.field_146127_k == 6000) {
         JRMCoreGuiButtons00MS btn = (JRMCoreGuiButtons00MS)button;
         if (btn.d2.equals("-3")) {
            this.mc.field_71439_g.func_71053_j();
         }

         JRMCoreGuiScreen.dataSend(btn.d1, btn.d2);
      }

      for(i = 0; i < JRMCoreH.DBCSkillsIDs.length; ++i) {
         if (button.field_146127_k == 1000 + i) {
            JRMCoreH.Skll((byte)1, (byte)i);
         }
      }

      for(byte i = 0; i < (JRMCoreH.Pwrtyp == 2 ? JRMCoreH.pmj : JRMCoreH.pmdbc).length; ++i) {
         if (button.field_146127_k == 4200 + i) {
            JRMCoreH.Tech((byte)4, "" + i);
            this.wish = (this.wish - 1000) / 10;
            this.ipg = 0;
         }
      }

      if ((this.name.matches("[0-9].+") || this.name.matches("[0-9]+")) && this.name.length() > 0) {
         try {
            this.name = (Float.parseFloat(this.name) > 5000.0F ? 5000.0F : (Float.parseFloat(this.name) < 0.1F ? 0.1F : Float.parseFloat(this.name))) + "";
         } catch (Exception var3) {
            this.name = "5";
         }

         if (button.field_146127_k == 210) {
            PD.sendToServer(new DBCPwish(2, "0;" + this.name));
            this.mc.field_71439_g.func_71053_j();
         }

         if (button.field_146127_k == 211) {
            PD.sendToServer(new DBCPwish(2, "1;" + this.name));
            this.mc.field_71439_g.func_71053_j();
         }

         if (button.field_146127_k == 212) {
            PD.sendToServer(new DBCPwish(2, "2;" + this.name));
            this.mc.field_71439_g.func_71053_j();
         }

         if (button.field_146127_k == 213) {
            PD.sendToServer(new DBCPwish(2, "3;" + this.name));
            this.mc.field_71439_g.func_71053_j();
         }

         if (button.field_146127_k == 214) {
            PD.sendToServer(new DBCPwish(2, "4;" + this.name));
            this.mc.field_71439_g.func_71053_j();
         }
      }

      if (button.field_146127_k == 50) {
         PD.sendToServer(new DBCPwish(5, "0"));
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 51) {
         PD.sendToServer(new DBCPwish(5, "1"));
         this.mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 52) {
         PD.sendToServer(new DBCPwish(6, ""));
         this.mc.field_71439_g.func_71053_j();
      }

   }

   public void dri(int id) {
      PD.sendToServer(new DBCPdri(id));
   }

   public void dbcWish(int id) {
      PD.sendToServer(new DBCPwish(1, id + ""));
   }

   public void dbcTelep(int id) {
      PD.sendToServer(new DBCPwish(1, id + ""));
   }

   private void name(FontRenderer var8, int i, int j) {
      this.inputField = new GuiTextField(var8, i + 100, j + 15 + 0, 100, 12);
      this.inputField.func_146203_f(20);
      this.inputField.func_146185_a(true);
      this.inputField.func_146195_b(true);
      this.inputField.func_146180_a(this.defaultInputFieldText);
      this.inputField.func_146205_d(true);
   }

   public void func_73876_c() {
      if (this.inputField != null) {
         this.inputField.func_146178_a();
      }

   }

   protected void func_73869_a(char c, int i) {
      super.func_73869_a(c, i);
      if (this.inputField != null) {
         this.inputField.func_146201_a(c, i);
      }

   }

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      if (this.inputField != null) {
         this.inputField.func_146192_a(i, j, k);
      }

   }

   public void sklLrn(int i, int x, int y) {
      DBCGuiButtons01 btn = new DBCGuiButtons01(JRMCoreH.SklLvl(i, (byte)1) < 1 ? 1000 + i : -1, x, y, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.DBCSkillNames[i]));
      btn.field_146124_l = JRMCoreH.getDBCSkillTPCost(i, 0) == -1 ? false : (JRMCoreH.getDBCSkillTPCost(i, 0) <= JRMCoreH.curTP ? JRMCoreH.SklLvl(i) < 1 : false);
      this.field_146292_n.add(btn);
      this.mc.field_71466_p.func_78276_b(JRMCoreH.SklLvl(i, (byte)1) < 1 ? (JRMCoreH.getDBCSkillTPCost(i, 0) == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(i, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost)) : JRMCoreH.trl("dbc.talkgui.owned"), x + 120, y + 7, 0);
   }

   public void sklLrn(int i, int x, int y, boolean b) {
      DBCGuiButtons01 btn = new DBCGuiButtons01(JRMCoreH.SklLvl(i, (byte)1) < 1 ? 1000 + i : -1, x, y, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.DBCSkillNames[i]));
      btn.field_146124_l = JRMCoreH.getDBCSkillTPCost(i, 0) == -1 ? false : (JRMCoreH.getDBCSkillTPCost(i, 0) <= JRMCoreH.curTP && JRMCoreH.SklLvl(i) < 1 ? b : false);
      this.field_146292_n.add(btn);
      this.mc.field_71466_p.func_78276_b(JRMCoreH.SklLvl(i) < 1 ? (JRMCoreH.getDBCSkillTPCost(i, 0) == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(i, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost)) : JRMCoreH.trl("dbc.talkgui.owned"), x + 120, y + 7, 0);
   }

   public void func_73863_a(int x, int y, float f) {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.field_146292_n.clear();
      ++this.tick;
      if (this.tick >= 20) {
         this.tick = 0;
         JRMCoreH.jrmct(1);
         JRMCoreH.jrmct(3);
      }

      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      int xSize = 256;
      int ySize = 160;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      boolean cont = true;
      String wish;
      String s2;
      byte i;
      boolean i2;
      int nw;
      int i2;
      if (this.MsnSysTalkTo != null) {
         wish = EntityList.func_75620_a((String)this.MsnSysTalkTo.get("N"), (World)null).func_70005_c_();
         if (wish.equalsIgnoreCase(this.CurMaster)) {
            cont = false;
            s2 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation tx = new ResourceLocation(s2);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            i = 0;
            this.Process = wish;
            i2 = i + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + i * 10, 0);
            i2 = Boolean.parseBoolean((String)this.MsnSysTalkTo.get("translated"));
            this.Process = JRMCoreH.trl((String)this.MsnSysTalkTo.get("G"));
            i2 += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + i2 * 10, 0);
            this.Process = JRMCoreH.trl((String)this.MsnSysTalkTo.get("B"));
            nw = var8.func_78256_a(this.Process) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00MS(6000, guiLeft + xSize - 6 - nw, guiTop + ySize - 5 - 20, nw, 20, this.Process, 0, (String)this.MsnSysTalkTo.get("series"), "-3"));
            this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
         }
      }

      if (cont) {
         int owner;
         int fnw;
         int fnw;
         int onw;
         int onw;
         int line;
         int ml;
         int nms;
         if (this.wish != 10) {
            if (this.wish == 1001) {
               xSize = 182;
               ySize = 191;
               guiLeft = (this.field_146294_l - xSize) / 2;
               guiTop = (this.field_146295_m - ySize) / 2;
               this.drawBg("enma", xSize, ySize);
               line = (int)(System.currentTimeMillis() / 1000L);
               if (this.updateTime < line && !this.updateTimerStopper) {
                  this.updateTime = line + 10;
               }

               this.updateTimer = this.updateTime - line;
               if (this.updateTimer <= 0 && !this.updateTimerStopper) {
                  this.updateTimerStopper = true;
               }

               i = 0;
               i2 = false;
               nms = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmareincarnate", new Object[]{(int)(DBCConfig.Reinc * 100.0F) + "%"}), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + i * 10, 175);
               i2 = i + nms;
               this.field_146292_n.add(new DBCGuiButtons01(99, guiLeft + xSize / 2 - 40 - 5, guiTop + 10 + i2 * 21 - nms * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
               ++i2;
               if (this.updateTimer <= 0) {
                  this.field_146292_n.add(new DBCGuiButtons01(101, guiLeft + xSize / 2 - 40 - 5, guiTop + 10 + i2 * 21 - nms * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
                  ++i2;
               } else {
                  s2 = JRMCoreH.trl("dbc.talkgui.enmareincavilabl", new Object[]{JRMCoreH.format_lz2(new Object[]{this.updateTimer % 60})});
                  ml = var8.func_78256_a(s2);
                  var8.func_78276_b(s2, guiLeft + xSize / 2 - ml / 2, guiTop + 10 + i2 * 21 - nms * 10 + 5, 0);
                  ++i2;
               }
            } else if (this.wish == 9000) {
               this.master = 16;
               this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
            }
         } else {
            xSize = 182;
            ySize = 191;
            guiLeft = (this.field_146294_l - xSize) / 2;
            guiTop = (this.field_146295_m - ySize) / 2;
            this.drawBg("enma", xSize, ySize);
            line = (int)(System.currentTimeMillis() / 1000L);
            if (this.updateTime < line) {
               this.updateTime = line + 5;
               DBCH.packDuo(-1, 0);
            }

            i = 0;
            i2 = false;
            nw = JRMCoreH.Algnmnt(JRMCoreH.align);
            nms = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmawelcome" + (nw == 0 ? "G" : (nw == 1 ? "N" : "E"))), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + i * 10, 175);
            i2 = i + nms;
            if (DBCConfig.Reinc > 0.0F) {
               s2 = JRMCoreH.trl("dbc.talkgui.reincarnate");
               ml = var8.func_78256_a(s2);
               this.field_146292_n.add(new DBCGuiButtons01(99, guiLeft + xSize / 2 - ml / 2 - 5, guiTop + 5 + i2 * 21 - nms * 10, ml + 10, 20, s2));
               ++i2;
            }

            if (JRMCoreH.revTmr > 0 && DBCConfig.FreeRev) {
               owner = (int)JRMCoreH.gkap((long)(JRMCoreH.revTmr - 5), "rt", 5, 0.025D);
               fnw = owner / 1 % 60;
               fnw = owner / 60 % 60;
               onw = owner / 3600 % 24;
               onw = owner / 86400;
               s2 = JRMCoreH.trl("dbc.talkgui.revivetime", new Object[]{JRMCoreH.format_lz2(new Object[]{fnw}), JRMCoreH.format_lz2(new Object[]{fnw}), JRMCoreH.format_lz2(new Object[]{onw}), JRMCoreH.format_lz2(new Object[]{onw})});
               ml = var8.func_78256_a(s2);
               var8.func_78276_b(s2, guiLeft + xSize / 2 - ml / 2, guiTop + 12 + i2 * 21 - nms * 10, 0);
               ++i2;
               s2 = JRMCoreH.trl("dbc.talkgui.revfree");
               ml = var8.func_78256_a(s2);
               DBCGuiButtons01 b = new DBCGuiButtons01(-1, posX - ml / 2 - 5, guiTop + 5 + i2 * 21 - nms * 10, ml + 10, 20, s2);
               b.field_146124_l = false;
               this.field_146292_n.add(b);
               ++i2;
            } else if (JRMCoreH.revTmr == 0) {
               s2 = JRMCoreH.trl("dbc.talkgui.revfree");
               ml = var8.func_78256_a(s2);
               this.field_146292_n.add(new DBCGuiButtons01(100, posX - ml / 2 - 5, guiTop + 5 + i2 * 21 - nms * 10, ml + 10, 20, s2));
               ++i2;
            }

            s2 = JRMCoreH.trl("dbc.talkgui.stay");
            ml = var8.func_78256_a(s2);
            this.field_146292_n.add(new DBCGuiButtons01(-1, posX - ml / 2 - 5, guiTop + 5 + i2 * 21 - nms * 10, ml + 10, 20, s2));
            ++i2;
         }

         if (this.wish == 9001) {
            this.master = 17;
            this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
         }

         if (this.wish == 9002) {
            this.master = 18;
            this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
         }

         ResourceLocation tx;
         byte nr;
         byte line;
         String n;
         String n;
         String n;
         if (this.wish == 11) {
            this.master = 5;
            line = 0;
            if (JRMCoreH.SagaProg == 1700) {
               this.field_146292_n.add(new DBCGuiButtons01(203, posX - 35, posY - 5, 100, 20, StatCollector.func_74838_a("dbc.MainSaga.17.1")));
            } else if (JRMCoreH.SagaSideProg == 10100) {
               this.field_146292_n.add(new DBCGuiButtons01(204, posX - 35, posY - 5, 100, 20, StatCollector.func_74838_a("dbc.sidesagas.101.talkok")));
            } else {
               if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == 3 || JRMCoreH.TlMd == 4)) {
                  s2 = JRMCoreH.trl("dbc.talkgui.kami.forcetailregrow");
                  ml = this.field_146289_q.func_78256_a(s2) + 8;
                  this.field_146292_n.add(new DBCGuiButtons01(108, posX + 115 - ml, posY + 15 + line * 21, ml, 20, s2));
                  ++line;
               }

               if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == -1 || JRMCoreH.TlMd == 0 || JRMCoreH.TlMd == 1)) {
                  s2 = JRMCoreH.trl("dbc.talkgui.kami.cutdowntail");
                  ml = this.field_146289_q.func_78256_a(s2) + 8;
                  this.field_146292_n.add(new DBCGuiButtons01(107, posX + 115 - ml, posY + 15 + line * 21, ml, 20, s2));
                  ++line;
               }

               s2 = JRMCoreH.trl("dbc.talkgui.anew");
               ml = this.field_146289_q.func_78256_a(s2) + 8;
               this.field_146292_n.add(new DBCGuiButtons01(2011, posX + 115 - ml, posY + 15 + line * 21, ml, 20, s2));
               ++line;
               s2 = JRMCoreH.trl("dbc.talkgui.skills");
               ml = this.field_146289_q.func_78256_a(s2) + 8;
               this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - ml, posY + 15 + line * 21, ml, 20, s2));
               ++line;
               line = 0;
               s2 = JRMCoreH.trl("dbc.talkgui.giveweights");
               ml = this.field_146289_q.func_78256_a(s2) + 8;
               this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, ml, 20, s2));
               line = line + 1;
            }

            this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
         } else if (this.wish == 1101) {
            this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.field_146292_n.add(new DBCGuiButtons01(201, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         } else if (this.wish == 1102) {
            this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.field_146292_n.add(new DBCGuiButtons01(106, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         } else if (this.wish == 1104) {
            this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.field_146292_n.add(new DBCGuiButtons01(109, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         } else if (this.wish == 1105) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            nr = 0;
            this.Process = StatCollector.func_74838_a("dbc.talkgui.giveweightsdesc");
            ml = nr + JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
            i = 0;
            n = JRMCoreH.trl("dbc.talkgui.weightamount");
            nw = this.field_146289_q.func_78256_a(n) + 8;
            ++this.text;
            if (this.text == 1) {
               this.name(var8, posX - 220 + nw, posY - 25 + i * 21);
               this.inputField.func_146180_a("5");
            } else {
               this.text = 2;
            }

            if (this.inputField != null) {
               this.inputField.func_146194_f();
               this.name = this.inputField.func_146179_b();
               var8.func_78276_b(n, posX - 120, posY - 7 + i * 21, 0);
            }

            i2 = i + 1;
            n = ItemsDBC.ItemWeightHandLeg.func_77653_i(new ItemStack(ItemsDBC.ItemWeightHandLeg));
            nw = this.field_146289_q.func_78256_a(n) + 8;
            if (this.master == 6) {
               this.field_146292_n.add(new DBCGuiButtons01(210, posX - 120, posY - 15 + i2 * 21, nw, 20, n));
               ++i2;
            }

            n = ItemsDBC.ItemWeightShell.func_77653_i(new ItemStack(ItemsDBC.ItemWeightShell));
            nw = this.field_146289_q.func_78256_a(n) + 8;
            if (this.master == 2) {
               this.field_146292_n.add(new DBCGuiButtons01(211, posX - 120, posY - 15 + i2 * 21, nw, 20, n));
               ++i2;
            }

            n = ItemsDBC.ItemWeightShirt.func_77653_i(new ItemStack(ItemsDBC.ItemWeightShirt));
            nw = this.field_146289_q.func_78256_a(n) + 8;
            if (this.master == 6 || this.master == 5) {
               this.field_146292_n.add(new DBCGuiButtons01(212, posX - 120, posY - 15 + i2 * 21, nw, 20, n));
               ++i2;
            }

            n = ItemsDBC.ItemWeightCape.func_77653_i(new ItemStack(ItemsDBC.ItemWeightCape));
            nw = this.field_146289_q.func_78256_a(n) + 8;
            if (this.master == 8) {
               this.field_146292_n.add(new DBCGuiButtons01(213, posX - 120, posY - 15 + i2 * 21, nw, 20, n));
               ++i2;
            }

            n = ItemsDBC.ItemWeightHeavySuit.func_77653_i(new ItemStack(ItemsDBC.ItemWeightHeavySuit));
            nw = this.field_146289_q.func_78256_a(n) + 8;
            if (this.master == 18) {
               this.field_146292_n.add(new DBCGuiButtons01(214, posX - 120, posY - 15 + i2 * 21, nw, 20, n));
               ++i2;
            }
         } else {
            byte i;
            if (this.wish == 111) {
               this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
               wish = "jinryuudragonbc:saa.png";
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               tx = new ResourceLocation(wish);
               this.mc.field_71446_o.func_110577_a(tx);
               this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
               posX = this.field_146294_l / 2;
               posY = this.field_146295_m / 2;
               ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
               i2 = JRMCoreH.statMindC() - ml;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
               var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
               i = 0;
               this.sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
               nms = i + 1;
               this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
               ++nms;
               this.sklLrn(5, guiLeft + 5, guiTop + 25 + nms * 21);
               ++nms;
               this.sklLrn(4, guiLeft + 5, guiTop + 25 + nms * 21);
               ++nms;
               this.sklLrn(7, guiLeft + 5, guiTop + 25 + nms * 21);
               ++nms;
               this.sklLrn(6, guiLeft + 5, guiTop + 25 + nms * 21);
               ++nms;
            } else {
               boolean line;
               int line2;
               byte line2;
               if (this.wish == 9000) {
                  this.drawBg("saa", xSize, ySize);
                  this.master = 17;
                  line = false;
                  line2 = 0;
                  if (JRMCoreH.align > 33) {
                     n = JRMCoreH.trl("dbc.talkgui.skills");
                     i2 = this.field_146289_q.func_78256_a(n) + 8;
                     this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                     line2 = line2 + 1;
                  }

                  this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
               } else {
                  boolean gf;
                  if (this.wish == 9100) {
                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                     wish = "jinryuudragonbc:saa.png";
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     tx = new ResourceLocation(wish);
                     this.mc.field_71446_o.func_110577_a(tx);
                     this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                     posX = this.field_146294_l / 2;
                     posY = this.field_146295_m / 2;
                     ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                     i2 = JRMCoreH.statMindC() - ml;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                     var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                     i = 0;
                     gf = DBCConfig.Godform && JRMCoreHDBC.godKiAble();
                     this.sklLrn(9, guiLeft + 5, guiTop + 25 + i * 21, gf);
                     nms = i + 1;
                     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
                        this.sklLrn(16, guiLeft + 5, guiTop + 25 + nms * 21);
                        ++nms;
                     }
                  } else if (this.wish == 9001) {
                     this.drawBg("saa", xSize, ySize);
                     this.master = 17;
                     line = false;
                     line2 = 0;
                     if (JRMCoreH.align > 33) {
                        n = JRMCoreH.trl("dbc.talkgui.skills");
                        i2 = this.field_146289_q.func_78256_a(n) + 8;
                        this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                        line2 = line2 + 1;
                     }

                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                  } else if (this.wish == 9101) {
                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                     wish = "jinryuudragonbc:saa.png";
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     tx = new ResourceLocation(wish);
                     this.mc.field_71446_o.func_110577_a(tx);
                     this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                     posX = this.field_146294_l / 2;
                     posY = this.field_146295_m / 2;
                     ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                     i2 = JRMCoreH.statMindC() - ml;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                     var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                     i = 0;
                     this.sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
                     nms = i + 1;
                  } else if (this.wish == 9002) {
                     this.drawBg("saa", xSize, ySize);
                     this.master = 18;
                     line = 0;
                     line2 = 0;
                     if (JRMCoreH.align > 33) {
                        n = JRMCoreH.trl("dbc.talkgui.skills");
                        i2 = this.field_146289_q.func_78256_a(n) + 8;
                        this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                        line2 = line2 + 1;
                        if (JRMCoreH.align > 33) {
                           n = JRMCoreH.trl("dbc.talkgui.giveweights");
                           i2 = this.field_146289_q.func_78256_a(n) + 8;
                           this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115, posY + 15 + line * 21, i2, 20, n));
                           line = line + 1;
                        }
                     }

                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                     i = 0;
                     n = JRMCoreH.trl("dbc", "whisteleport");
                     i2 = this.field_146289_q.func_78256_a(n) + 8;
                     nms = i + 1;
                     this.field_146292_n.add(new DBCGuiButtons01(52, posX - i2 / 2, posY + 20 + nms * 20, i2, 20, n));
                     ++nms;
                  } else if (this.wish == 9102) {
                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                     wish = "jinryuudragonbc:saa.png";
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     tx = new ResourceLocation(wish);
                     this.mc.field_71446_o.func_110577_a(tx);
                     this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                     posX = this.field_146294_l / 2;
                     posY = this.field_146295_m / 2;
                     ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                     i2 = JRMCoreH.statMindC() - ml;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                     var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                     i = 0;
                     gf = DBCConfig.Godform && JRMCoreHDBC.godKiAble();
                     this.sklLrn(9, guiLeft + 5, guiTop + 25 + i * 21, gf);
                     nms = i + 1;
                     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
                        this.sklLrn(16, guiLeft + 5, guiTop + 25 + nms * 21);
                        ++nms;
                     }

                     this.sklLrn(18, guiLeft + 5, guiTop + 25 + nms * 21);
                     ++nms;
                  } else if (this.wish == 12) {
                     this.drawBg("saa", xSize, ySize);
                     this.master = 6;
                     line = 0;
                     line2 = 0;
                     if (JRMCoreH.align > 33) {
                        if (JRMCoreH.Master == 1) {
                           n = JRMCoreH.trl("dbc.talkgui.learntechs");
                           i2 = this.field_146289_q.func_78256_a(n) + 8;
                           this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                           ++line2;
                        }

                        n = JRMCoreH.trl("dbc.talkgui.skills");
                        i2 = this.field_146289_q.func_78256_a(n) + 8;
                        this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                        ++line2;
                     }

                     n = JRMCoreH.trl("dbc.talkgui.difftonormal");
                     i2 = this.field_146289_q.func_78256_a(n) + 8;
                     this.field_146292_n.add(new DBCGuiButtons01(103, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                     ++line2;
                     if (JRMCoreH.align > 33) {
                        n = JRMCoreH.trl("dbc.talkgui.giveweights");
                        i2 = this.field_146289_q.func_78256_a(n) + 8;
                        this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, i2, 20, n));
                        line = line + 1;
                     }

                     if (JRMCoreH.StusEfctsMe(12)) {
                        n = JRMCoreH.trl("dbc", "majinLoose");
                        i2 = this.field_146289_q.func_78256_a(n) + 8;
                        this.field_146292_n.add(new DBCGuiButtons01(50, posX + 115 - i2, posY + 15 + line2 * 21, i2, 20, n));
                        ++line2;
                     }

                     this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                  } else {
                     String fn;
                     if (this.wish == 112) {
                        this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        wish = "jinryuudragonbc:saa.png";
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                        tx = new ResourceLocation(wish);
                        this.mc.field_71446_o.func_110577_a(tx);
                        this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                        posX = this.field_146294_l / 2;
                        posY = this.field_146295_m / 2;
                        ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                        i2 = JRMCoreH.statMindC() - ml;
                        var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                        var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                        i = 0;
                        boolean var10000;
                        if (DBCConfig.Godform && JRMCoreHDBC.godKiAble()) {
                           var10000 = true;
                        } else {
                           var10000 = false;
                        }

                        fn = JRMCoreH.trl("dbc", "PURitual");
                        fnw = this.field_146289_q.func_78256_a(fn) + 8;
                        DBCGuiButtons01 btn = new DBCGuiButtons01(JRMCoreH.SklLvl(10, (byte)1) < 1 ? 1010 : -1, guiLeft + 5, guiTop + 25 + i * 21, 83, 20, fn);
                        btn.field_146124_l = JRMCoreH.align == 100 && JRMCoreH.SklLvl(10) == 0 && JRMCoreH.getDBCSkillTPCost(10, 0) != -1 && JRMCoreH.getDBCSkillTPCost(10, 0) <= JRMCoreH.curTP;
                        this.field_146292_n.add(btn);
                        this.mc.field_71466_p.func_78276_b(JRMCoreH.align < 100 ? JRMCoreH.trl("jrmc", "NeedToBeGood", new Object[]{100}) : (JRMCoreH.SklLvl(10) < 1 ? (JRMCoreH.getDBCSkillTPCost(10, 0) == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(10, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost)) : JRMCoreH.trl("dbc.talkgui.owned")), guiLeft + 5 + 120, guiTop + 25 + 7 + i * 21, 0);
                        nms = i + 1;
                        this.sklLrn(8, guiLeft + 5, guiTop + 25 + nms * 21);
                        ++nms;
                        this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
                        ++nms;
                        this.sklLrn(13, guiLeft + 5, guiTop + 25 + nms * 21);
                        ++nms;
                     } else {
                        String n;
                        int nw;
                        String[][] PMA;
                        byte i;
                        String fn;
                        String on;
                        int costTp;
                        if (this.wish == 1121) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 1 || owner == 6) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 221) {
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           Iterator iterator = this.mc.field_71466_p.func_78271_c(JRMCoreH.trl("dbc", "KaioDiffRed"), 245).iterator();
                           i2 = 0;

                           while(iterator.hasNext()) {
                              ++i2;
                              n = (String)iterator.next();
                              var8.func_78276_b("§0" + n, guiLeft + 5, guiTop + 5 + i2 * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(104, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
                           this.field_146292_n.add(new DBCGuiButtons01(105, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
                        } else if (this.wish == 13) {
                           this.master = 4;
                           if (JRMCoreH.align > 65) {
                              if (JRMCoreH.Senzu == 0) {
                                 this.field_146292_n.add(new DBCGuiButtons01(199, posX - 35, posY + 35, 100, 20, StatCollector.func_74838_a("dbc.talkgui.karin.senzu")));
                              }

                              this.field_146292_n.add(new DBCGuiButtons01(198, posX - 35, posY + 55, 100, 20, StatCollector.func_74838_a("dbc.talkgui.skills")));
                              if (!this.mc.field_71439_g.field_71071_by.func_146028_b(ItemsDBC.KintounItem)) {
                                 this.field_146292_n.add(new DBCGuiButtons01(202, posX - 35, posY + 15, 100, 20, StatCollector.func_74838_a("dbc.talkgui.kintoun")));
                              }
                           } else if (!this.mc.field_71439_g.field_71071_by.func_146028_b(ItemsDBC.KintounBlackItem)) {
                              this.field_146292_n.add(new DBCGuiButtons01(202, posX - 35, posY + 15, 140, 20, StatCollector.func_74838_a("dbc.talkgui.kintounblack")));
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 113) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 15) {
                           this.master = 2;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[2]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           this.Process = StatCollector.func_74838_a("dbc.talkgui.roshi.goodneut");
                           ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           i2 = 0;
                           if (JRMCoreH.align > 32) {
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nw = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - nw, posY + 15 + i2 * 21, nw, 20, n));
                                 ++i2;
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nw = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - nw, posY + 15 + i2 * 21, nw, 20, n));
                              ++i2;
                           }

                           i = 0;
                           n = JRMCoreH.trl("dbc.talkgui.giveweights");
                           nw = this.field_146289_q.func_78256_a(n) + 8;
                           this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + i * 21, nw, 20, n));
                           i2 = i + 1;
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 115) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(2, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1151) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              if (Integer.parseInt(PMA[i][2]) == 2 || Integer.parseInt(PMA[i][2]) == 1) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       onw = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       String n = " " + onw + " tp";
                                       int nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= onw) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 16) {
                           this.master = 12;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[12]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align <= 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.cell.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.cell.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 116) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(4, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(6, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(11, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(12, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(17, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1161) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 2 || owner == 1 || owner == 7 || owner == 8 || owner == 9 || owner == 11) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 17) {
                           this.master = 13;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[13]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align > 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songoku.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songoku.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 117) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_AvailableMindLeft();
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)ml), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
                           i2 = i + 1;
                           this.sklLrn(6, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(0, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(14, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(12, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(17, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                        } else if (this.wish == 1171) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 2 || owner == 1 || owner == 6 || owner == 7) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 18) {
                           this.master = 11;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[11]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align <= 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.freeza.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.freeza.else");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 118) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(2, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(4, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1181) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 1 || owner == 11) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 19) {
                           this.master = 15;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[15]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           i2 = 0;
                           if (JRMCoreH.align <= 65) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.evilneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nw = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nw / 2, posY + 15 + i2 * 20, nw, 20, n));
                                 ++i2;
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nw = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 15 + i2 * 20, nw, 20, n));
                              ++i2;
                              if (!JRMCoreH.StusEfctsMe(12)) {
                                 n = JRMCoreH.trl("dbc", "majinGet");
                                 nw = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01(51, posX + 15 - nw / 2, posY + 15 + i2 * 20, nw, 20, n));
                                 ++i2;
                              }
                           } else if (JRMCoreH.align == 100) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.fullgood");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.good");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (!JRMCoreH.StusEfctsMe(12)) {
                                 n = JRMCoreH.trl("dbc", "majinGet");
                                 nw = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01(51, posX + 15 - nw / 2, posY + 15 + i2 * 20, nw, 20, n));
                                 ++i2;
                              }
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 119) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(2, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(4, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1191) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 1) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 20) {
                           this.master = 8;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[this.master]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           i2 = 0;
                           if (JRMCoreH.align > 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.piccolo.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nw = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - nw, posY + 15 + i2 * 21, nw, 20, n));
                                 ++i2;
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nw = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - nw, posY + 15 + i2 * 21, nw, 20, n));
                              ++i2;
                              i = 0;
                              n = JRMCoreH.trl("dbc.talkgui.giveweights");
                              nw = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + i * 21, nw, 20, n));
                              i2 = i + 1;
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.piccolo.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 120) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(7, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(6, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(11, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(12, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1201) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 1 || owner == 7 || owner == 8) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 21) {
                           this.master = 9;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[this.master]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align > 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.vegeta.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.vegeta.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 121) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
                           i2 = JRMCoreH.statMindC() - ml;
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)i2), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(2, guiLeft + 5, guiTop + 25 + i * 21);
                           nms = i + 1;
                           this.sklLrn(5, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                           this.sklLrn(4, guiLeft + 5, guiTop + 25 + nms * 21);
                           ++nms;
                        } else if (this.wish == 1211) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 1 || owner == 9) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 22) {
                           this.master = 14;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[14]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align > 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 122) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_AvailableMindLeft();
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)ml), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
                           i2 = i + 1;
                           this.sklLrn(6, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(11, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(15, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                        } else if (this.wish == 1221) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 2 || owner == 1 || owner == 8 || owner == 14) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        } else if (this.wish == 23) {
                           this.master = 10;
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           nr = 0;
                           this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[10]);
                           ml = nr + JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
                           if (JRMCoreH.align > 32) {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.goodneut");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                              if (JRMCoreH.Master == 1) {
                                 n = JRMCoreH.trl("dbc.talkgui.learntechs");
                                 nms = this.field_146289_q.func_78256_a(n) + 8;
                                 this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - nms / 2, posY + 35, nms, 20, n));
                              }

                              n = JRMCoreH.trl("dbc.talkgui.skills");
                              nms = this.field_146289_q.func_78256_a(n) + 8;
                              this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nms / 2, posY + 55, nms, 20, n));
                           } else {
                              this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.evil");
                              ml += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + ml * 10, 0);
                           }

                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                        } else if (this.wish == 123) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           ml = JRMCoreH.skillSlot_AvailableMindLeft();
                           var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)ml), guiLeft + 5, guiTop + 15, 0);
                           var8.func_78276_b("TP: " + JRMCoreH.numSep((long)JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
                           i = 0;
                           this.sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
                           i2 = i + 1;
                           this.sklLrn(14, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(12, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                           this.sklLrn(15, guiLeft + 5, guiTop + 25 + i2 * 21);
                           ++i2;
                        } else if (this.wish == 1231) {
                           this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
                           wish = "jinryuudragonbc:saa.png";
                           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                           tx = new ResourceLocation(wish);
                           this.mc.field_71446_o.func_110577_a(tx);
                           this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
                           posX = this.field_146294_l / 2;
                           posY = this.field_146295_m / 2;
                           PMA = JRMCoreH.pmdbc;
                           var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
                           i2 = 0;
                           nms = PMA.length;

                           for(i = 0; i < nms; ++i) {
                              owner = Integer.parseInt(PMA[i][2]);
                              if (owner == 2 || owner == 1 || owner == 14 || owner == 10) {
                                 if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
                                    fn = JRMCoreH.trl("dbc", PMA[i][0]);
                                    fnw = this.fontRenderer.func_78256_a(fn);
                                    var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
                                    on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
                                    onw = this.fontRenderer.func_78256_a(on);
                                    var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                                    if (!JRMCoreH.techOwnd(i, (byte)1)) {
                                       costTp = (int)((float)JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
                                       n = " " + costTp + " tp";
                                       nw = this.fontRenderer.func_78256_a(fn);
                                       if (JRMCoreH.curTP >= costTp) {
                                          this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
                                       } else {
                                          var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                                       }
                                    }
                                 }

                                 ++i2;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (this.wish == 9000) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.current(StatCollector.func_74838_a("dbc.talkgui.line1000"), 10, 10, var8, guiLeft, guiTop);
            n = StatCollector.func_74838_a("dbc.talkgui.line1001");
            n = StatCollector.func_74838_a("dbc.talkgui.line1002");
            n = StatCollector.func_74838_a("dbc.talkgui.line1003");
            if (JRMCoreH.align > 66) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1004");
               n = StatCollector.func_74838_a("dbc.talkgui.line1005");
               n = StatCollector.func_74838_a("dbc.talkgui.line1006");
            }

            if (JRMCoreH.align < 33) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1007");
               n = StatCollector.func_74838_a("dbc.talkgui.line1008");
               n = StatCollector.func_74838_a("dbc.talkgui.line1009");
            }

            this.current(n, 15, 20, var8, guiLeft, guiTop);
            this.current(n, 15, 30, var8, guiLeft, guiTop);
            this.current(n, 15, 40, var8, guiLeft, guiTop);
         } else if (this.wish == 9001) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.current(StatCollector.func_74838_a("dbc.talkgui.line1010"), 10, 10, var8, guiLeft, guiTop);
            n = StatCollector.func_74838_a("dbc.talkgui.line1011");
            n = StatCollector.func_74838_a("dbc.talkgui.line1012");
            if (JRMCoreH.align > 66) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1013");
               n = StatCollector.func_74838_a("dbc.talkgui.line1014");
            }

            if (JRMCoreH.align < 33) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1015");
               n = StatCollector.func_74838_a("dbc.talkgui.line1016");
            }

            this.current(n, 15, 20, var8, guiLeft, guiTop);
            this.current(n, 15, 30, var8, guiLeft, guiTop);
         } else if (this.wish == 9002) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.current(StatCollector.func_74838_a("dbc.talkgui.line1017"), 10, 10, var8, guiLeft, guiTop);
            n = StatCollector.func_74838_a("dbc.talkgui.line1018");
            n = StatCollector.func_74838_a("dbc.talkgui.line1019");
            if (JRMCoreH.align > 66) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1020");
               n = StatCollector.func_74838_a("dbc.talkgui.line1021");
            }

            if (JRMCoreH.align < 33) {
               n = StatCollector.func_74838_a("dbc.talkgui.line1022");
               n = StatCollector.func_74838_a("dbc.talkgui.line1023");
            }

            this.current(n, 15, 20, var8, guiLeft, guiTop);
            this.current(n, 15, 30, var8, guiLeft, guiTop);
         } else if (this.wish == 11) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.current(StatCollector.func_74838_a("dbc.talkgui.line0000"), 10, 10, var8, guiLeft, guiTop);
            n = StatCollector.func_74838_a("dbc.talkgui.line0001");
            n = StatCollector.func_74838_a("dbc.talkgui.line0002");
            n = StatCollector.func_74838_a("dbc.talkgui.line0003");
            if (JRMCoreH.align > 66) {
               n = StatCollector.func_74838_a("dbc.talkgui.line0004");
               n = StatCollector.func_74838_a("dbc.talkgui.line0005");
               n = StatCollector.func_74838_a("dbc.talkgui.line0006");
            }

            if (JRMCoreH.align < 33) {
               n = StatCollector.func_74838_a("dbc.talkgui.line0007");
               n = StatCollector.func_74838_a("dbc.talkgui.line0008");
               n = StatCollector.func_74838_a("dbc.talkgui.line0009");
            }

            if (JRMCoreH.SagaProg == 1700) {
               n = StatCollector.func_74838_a("dbc.MainSaga.17.2");
               n = StatCollector.func_74838_a("dbc.MainSaga.17.3");
               n = StatCollector.func_74838_a("dbc.MainSaga.17.4");
            }

            if (JRMCoreH.SagaSideProg == 10100) {
               n = StatCollector.func_74838_a("dbc.sidesagas.101.talk");
               JRMCoreH.txt(n, "§0", 5, true, guiLeft + 15, guiTop + 20, 0);
            } else {
               this.current(n, 15, 20, var8, guiLeft, guiTop);
               this.current(n, 15, 30, var8, guiLeft, guiTop);
               this.current(n, 15, 40, var8, guiLeft, guiTop);
            }
         } else if (this.wish == 1101) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            nr = 0;
            this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.startanew");
            ml = nr + JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
         } else if (this.wish == 1102) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            nr = 0;
            this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.confirmtailcut");
            ml = nr + JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
         } else if (this.wish == 1104) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            nr = 0;
            this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.tailregrow");
            ml = nr + JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
         } else if (this.wish == 12) {
            this.current(StatCollector.func_74838_a("dbc.talkgui.line0010"), 10, 10, var8, guiLeft, guiTop);
            wish = StatCollector.func_74838_a("dbc.talkgui.line0011");
            s2 = StatCollector.func_74838_a("dbc.talkgui.line0012");
            n = StatCollector.func_74838_a("dbc.talkgui.line0013");
            if (JRMCoreH.align > 66) {
               wish = StatCollector.func_74838_a("dbc.talkgui.line0014");
               s2 = StatCollector.func_74838_a("dbc.talkgui.line0015");
               n = StatCollector.func_74838_a("dbc.talkgui.line0016");
            }

            if (JRMCoreH.align < 33) {
               wish = StatCollector.func_74838_a("dbc.talkgui.line0017");
               s2 = StatCollector.func_74838_a("dbc.talkgui.line0018");
               n = StatCollector.func_74838_a("dbc.talkgui.line0019");
            }

            this.current(wish, 15, 20, var8, guiLeft, guiTop);
            this.current(s2, 15, 30, var8, guiLeft, guiTop);
            this.current(n, 15, 40, var8, guiLeft, guiTop);
         } else if (this.wish == 13) {
            wish = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tx = new ResourceLocation(wish);
            this.mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.current(StatCollector.func_74838_a("dbc.talkgui.karin.00"), 10, 10, var8, guiLeft, guiTop);
            n = StatCollector.func_74838_a("dbc.talkgui.karin.01");
            n = StatCollector.func_74838_a("dbc.talkgui.karin.02");
            n = StatCollector.func_74838_a("dbc.talkgui.karin.03");
            if (JRMCoreH.align < 66) {
               n = StatCollector.func_74838_a("dbc.talkgui.karin.04");
               n = StatCollector.func_74838_a("dbc.talkgui.karin.05");
               n = StatCollector.func_74838_a("dbc.talkgui.karin.06");
            }

            if (JRMCoreH.align < 33) {
               n = StatCollector.func_74838_a("dbc.talkgui.karin.07");
               n = StatCollector.func_74838_a("dbc.talkgui.karin.08");
               n = StatCollector.func_74838_a("dbc.talkgui.karin.09");
            }

            if (JRMCoreH.Senzu == 1) {
               this.current(StatCollector.func_74838_a("dbc.talkgui.karin.nosenzu"), 25, 80, var8, guiLeft, guiTop);
            }

            this.current(n, 15, 20, var8, guiLeft, guiTop);
            this.current(n, 15, 30, var8, guiLeft, guiTop);
            this.current(n, 15, 40, var8, guiLeft, guiTop);
         }
      }

      super.func_73863_a(x, y, f);
   }

   private void drawBg(String name) {
      this.drawBg(name, 256, 160);
   }

   private void drawBg(String name, int xSize, int ySize) {
      String wish = "jinryuudragonbc:" + name + ".png";
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(wish);
      this.mc.field_71446_o.func_110577_a(tx);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
   }

   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
      int wid = var8.func_78256_a(var35) / 2;
      int posX = var6 + posx;
      int posY = var7 + posy;
      var8.func_78276_b(var35, posX, posY, 0);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void SagasPrint() {
      this.func_73866_w_();
      Minecraft minecraft = this.mc;
      World world = minecraft.field_71441_e;
      EntityPlayerSP entityplayersp = minecraft.field_71439_g;
      ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
      int width = scaledresolution.func_78326_a() / 2;
      int height = scaledresolution.func_78328_b() / 2;
      int widthplus = true;
      minecraft.field_71460_t.func_78478_c();
      GL11.glEnable(3042);
      GL11.glEnable(32826);
      RenderHelper.func_74519_b();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73732_a(this.fontRenderer, this.Process, width + this.wid, height + this.hei, 16768306);
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
      this.mc.field_71446_o.func_110577_a(tx);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
   }
}
