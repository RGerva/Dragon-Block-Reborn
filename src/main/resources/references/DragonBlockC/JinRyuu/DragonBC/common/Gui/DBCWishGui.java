package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.JRMCore.JRMCoreGuiButtonC;
import JinRyuu.JRMCore.JRMCoreGuiButtons00;
import JinRyuu.JRMCore.JRMCoreGuiButtons01;
import JinRyuu.JRMCore.JRMCoreGuiButtonsA1;
import JinRyuu.JRMCore.JRMCoreGuiSlider00;
import JinRyuu.JRMCore.JRMCoreGuiSliderX00;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPwish;
import java.awt.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class DBCWishGui extends GuiScreen {
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   private int wishID = 0;
   private int prevwish = 0;
   private int wish = 0;
   private int KiColorSlcted = -1;
   boolean clicked = false;
   int wpp = 6;
   String target = "";
   private int ipg;
   private float BrghtSlcted = 0.8F;
   private int scrollMouseJump;
   private int scroll;
   private float scrollSide;
   private boolean mousePressed;
   private int tickI;
   public static String[] playerlist = null;

   public void renderSuperProtect(int ki) {
      this.field_146292_n.clear();
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      this.field_146292_n.add(new DBCGuiButtons01(100, posX - 0, posY - 0, 20, 20, "TEST"));
   }

   public DBCWishGui(int w) {
      this.wish = w;
      this.scroll = 0;
      if (this.wish == 1 || this.wish == 2) {
         DBCH.packDuo(-2, 0);
      }

      playerlist = null;
      this.target = "";
   }

   public void func_73866_w_() {
      this.field_146292_n.clear();
   }

   public void func_146284_a(GuiButton button) {
      if (button.field_146127_k == -21) {
         int col = ((JRMCoreGuiButtonC)button).getBgCol();
         this.KiColorSlcted = col;
         this.wish = this.prevwish;
      }

      if (button.field_146127_k == -20) {
         this.BrghtSlcted = ((JRMCoreGuiSlider00)button).sliderValue;
      }

      if (button.field_146127_k == -3) {
         ++this.ipg;
      }

      if (button.field_146127_k == -4) {
         --this.ipg;
      }

      if (button.field_146127_k == -5) {
         this.wish = this.prevwish;
      }

      if (button.field_146127_k == -2) {
         this.scroll -= 3;
      }

      if (button.field_146127_k == -1) {
         this.scroll += 3;
      }

      if (button.field_146127_k >= 0) {
         boolean send = true;
         this.clicked = true;
         this.wishID = button.field_146127_k;
         if (this.wish == 1) {
            if (this.target.length() < 2 && (((String)DBCH.wishS.get(button.field_146127_k)).equals("revive") || ((String)DBCH.wishS.get(button.field_146127_k)).equals("reviventp"))) {
               send = false;
               this.dbcWish(3, "");
               this.prevwish = this.wish;
               this.wishID = button.field_146127_k;
               this.wish = 10;
            }

            if (this.KiColorSlcted == -1 && ((String)DBCH.wishS.get(button.field_146127_k)).equals("kicolor")) {
               send = false;
               this.prevwish = this.wish;
               this.wishID = button.field_146127_k;
               this.wish = 11;
            }
         }

         if (this.wish == 2) {
            if (this.target.length() < 2 && (((String)DBCH.wishP.get(button.field_146127_k)).equals("revive") || ((String)DBCH.wishP.get(button.field_146127_k)).equals("reviventp"))) {
               send = false;
               this.dbcWish(3, "");
               this.prevwish = this.wish;
               this.wishID = button.field_146127_k;
               this.wish = 10;
            }

            if (this.KiColorSlcted == -1 && ((String)DBCH.wishP.get(button.field_146127_k)).equals("kicolor")) {
               send = false;
               this.prevwish = this.wish;
               this.wishID = button.field_146127_k;
               this.wish = 11;
            }
         }

         if (send) {
            if (this.wish == 10) {
               int i = button.field_146127_k - 1000;
               this.target = playerlist[i];
               this.wish = this.prevwish;
            } else {
               this.dbcWish(0, this.wishID + ";" + (this.KiColorSlcted >= 0 ? this.KiColorSlcted : this.target));
               this.target = "";
               this.KiColorSlcted = -1;
            }
         }

         DBCH.packDuo(-2, 0);
      }

   }

   public void dbcWish(int id, String wish) {
      PD.sendToServer(new DBCPwish(id, wish));
   }

   public void func_73863_a(int x, int y, float f) {
      if (Mouse.isButtonDown(0)) {
         this.mousePressed = true;
         this.scrollSide = JRMCoreGuiSliderX00.sliderValue;
      } else {
         this.mousePressed = false;

         while(Mouse.next()) {
            int mw = Mouse.getEventDWheel();
            if (mw != 0) {
               if (mw < 0) {
                  this.scroll += this.scrollMouseJump;
               } else if (mw > 0 && this.scroll > 0) {
                  this.scroll -= this.scrollMouseJump;
               }

               this.scrollMouseJump = 1;
            }
         }
      }

      ++this.tickI;
      if (this.tickI > 20) {
         this.tickI = 0;
      }

      if (this.clicked && JRMCoreH.wishes <= 0) {
         this.field_146297_k.field_71439_g.func_71053_j();
      }

      this.field_146292_n.clear();
      FontRenderer var8 = this.field_146297_k.field_71466_p;
      ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      int xSize = 182;
      int ySize = 191;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      String tex = "jinryuudragonbc:wish.png";
      this.wpp = 6;
      ResourceLocation tx;
      byte j;
      boolean i2;
      int Y;
      int i21;
      float m2;
      byte sz;
      int i;
      String o;
      int pos;
      String n;
      int fn;
      String op;
      String arg1;
      int iz;
      int im;
      Item item;
      ItemStack is;
      int a;
      int X;
      int col;
      String[] sa;
      if (this.wish == 1) {
         tex = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         tx = new ResourceLocation(tex);
         this.field_146297_k.field_71446_o.func_110577_a(tx);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         j = 0;
         i2 = false;
         Y = JRMCoreH.Algnmnt(JRMCoreH.align);
         X = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragon.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
         a = j + X;
         i21 = DBCH.wishS.size();
         m2 = 5.0F;
         sz = 6;
         this.scrollMouseJump = 1;
         if (i21 > sz) {
            if ((float)i21 - m2 < (float)this.scroll) {
               this.scroll = (int)((float)i21 - m2);
            } else if (this.scroll < 0) {
               this.scroll = 0;
            }

            if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
               this.scroll = (int)(((float)i21 - m2) * this.scrollSide);
            } else {
               this.scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)i21 - m2);
            }
         } else {
            this.scroll = 0;
         }

         if (i21 > sz) {
            if (this.scrollSide > 0.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(-2, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 - 70, "i"));
            }

            if (this.scrollSide < 1.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(-1, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 + 60, "v"));
            }

            this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiTop + 25, this.mousePressed, this.scrollSide, 1.0F));
         }

         for(i = this.scroll; i < (i21 > this.scroll + sz ? this.scroll + sz : i21); ++i) {
            o = ((String)DBCH.wishS.get(i)).replace(";+;", ";+");
            pos = i - this.scroll;
            if (o.contains(";+")) {
               sa = o.split(";+");
               arg1 = sa[0];
               iz = Integer.parseInt(sa[1]);
               im = Integer.parseInt(sa[2]);
               item = JRMCoreH.getItemByText(arg1);
               if (item != null) {
                  is = new ItemStack(item, iz, im);
                  n = is.field_77994_a + " " + item.func_77653_i(is);
                  fn = var8.func_78256_a(n);
                  this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n));
               }
            } else if (this.KiColorSlcted >= 0 && o.equals("kicolor")) {
               col = this.KiColorSlcted > 0 ? this.KiColorSlcted : 11075583;
               n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o), new Object[0]);
               fn = var8.func_78256_a(n);
               this.field_146292_n.add(new JRMCoreGuiButtons00(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n, col));
            } else {
               op = (o.equals("revive") || o.equals("reviventp")) && this.target.length() > 2 ? "S" : "";
               arg1 = op.equals("S") ? this.target : JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
               n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o + op), new Object[]{arg1});
               fn = var8.func_78256_a(n);
               this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n));
            }
         }
      }

      if (this.wish == 2) {
         tex = "jinryuudragonbc:wish2.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         tx = new ResourceLocation(tex);
         this.field_146297_k.field_71446_o.func_110577_a(tx);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         j = 0;
         i2 = false;
         Y = JRMCoreH.Algnmnt(JRMCoreH.align);
         X = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragonp.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
         a = j + X;
         i21 = DBCH.wishP.size();
         m2 = 5.0F;
         sz = 6;
         this.scrollMouseJump = 1;
         if (i21 > sz) {
            if ((float)i21 - m2 < (float)this.scroll) {
               this.scroll = (int)((float)i21 - m2);
            } else if (this.scroll < 0) {
               this.scroll = 0;
            }

            if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
               this.scroll = (int)(((float)i21 - m2) * this.scrollSide);
            } else {
               this.scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)i21 - m2);
            }
         } else {
            this.scroll = 0;
         }

         if (i21 > sz) {
            if (this.scrollSide > 0.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(-2, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 - 70, "i"));
            }

            if (this.scrollSide < 1.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(-1, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 + 60, "v"));
            }

            this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiTop + 25, this.mousePressed, this.scrollSide, 1.0F));
         }

         for(i = this.scroll; i < (i21 > this.scroll + sz ? this.scroll + sz : i21); ++i) {
            o = ((String)DBCH.wishP.get(i)).replace(";+;", ";+");
            pos = i - this.scroll;
            if (o.contains(";+")) {
               sa = o.split(";+");
               arg1 = sa[0];
               iz = Integer.parseInt(sa[1]);
               im = Integer.parseInt(sa[2]);
               item = JRMCoreH.getItemByText(arg1);
               if (item != null) {
                  is = new ItemStack(item, iz, im);
                  n = is.field_77994_a + " " + item.func_77653_i(is);
                  fn = var8.func_78256_a(n);
                  this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n));
               }
            } else if (this.KiColorSlcted >= 0 && o.equals("kicolor")) {
               col = this.KiColorSlcted > 0 ? this.KiColorSlcted : 11075583;
               n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o), new Object[0]);
               fn = var8.func_78256_a(n);
               this.field_146292_n.add(new JRMCoreGuiButtons00(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n, col));
            } else {
               op = (o.equals("revive") || o.equals("reviventp")) && this.target.length() > 2 ? "S" : "";
               arg1 = op.equals("S") ? this.target : JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
               n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o + op), new Object[]{arg1});
               fn = var8.func_78256_a(n);
               this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + a * 10, fn + 10, 20, n));
            }
         }
      }

      int cc;
      if (this.wish == 10) {
         tex = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         tx = new ResourceLocation(tex);
         this.field_146297_k.field_71446_o.func_110577_a(tx);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         j = 0;
         i2 = false;
         Y = JRMCoreH.Algnmnt(JRMCoreH.align);
         X = JRMCoreH.txt(JRMCoreH.trl("dbc", "selectplayer"), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
         int var10000 = j + X;
         i21 = 0;
         if (playerlist != null && playerlist.length > 0) {
            for(cc = 0; cc < playerlist.length; ++cc) {
               if (i21 <= 14 + this.ipg * 14 && i21 >= 0 + this.ipg * 14) {
                  String n = playerlist[cc];
                  this.field_146292_n.add(new JRMCoreGuiButtons01(1000 + cc, guiLeft + xSize / 2 - 80, guiTop + (ySize + 1) / 2 - 84 + i21 * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(n), n, 0));
                  ++i21;
               }
            }
         }

         String s;
         if (JRMCoreH.plyrs.length > 14 + this.ipg * 14) {
            s = JRMCoreH.trl("jrmc", "Next");
            this.field_146292_n.add(new JRMCoreGuiButtons00(-3, guiLeft + xSize / 2 + 100, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(s) + 8, 20, s, 0));
         }

         int sw;
         if (this.ipg != 0) {
            s = JRMCoreH.trl("jrmc", "Prev");
            sw = this.field_146289_q.func_78256_a(s) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(-4, guiLeft + xSize / 2 - 100 - sw, guiTop + (ySize + 1) / 2 + 15, sw, 20, s, 0));
         }

         s = JRMCoreH.trl("jrmc", "Back");
         sw = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(-5, guiLeft + xSize / 2 - 100 - sw, guiTop + (ySize + 1) / 2 + 40, sw, 20, s, 0));
      }

      if (this.wish == 11) {
         tex = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         tx = new ResourceLocation(tex);
         this.field_146297_k.field_71446_o.func_110577_a(tx);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         int a = false;

         for(X = 0; X < 128; ++X) {
            for(Y = 0; Y < 128; ++Y) {
               Color i = Color.getHSBColor((float)X * 2.0F / 255.0F, (float)Y * 2.0F / 255.0F, this.BrghtSlcted);
               cc = i.getRed() * 65536 + i.getGreen() * 256 + i.getBlue();
               if (cc == 0) {
                  a = 11075583;
                  if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
                     a = 14526719;
                  }

                  if (JRMCoreH.align < 33) {
                     a = 16646144;
                  }

                  this.field_146292_n.add(new JRMCoreGuiButtonC(-21, guiLeft + 5 + X, guiTop + 5 + Y, 1, 1, "", cc, a));
               } else {
                  this.field_146292_n.add(new JRMCoreGuiButtonC(-21, guiLeft + 5 + X, guiTop + 5 + Y, 1, 1, "", cc));
               }
            }
         }

         if (this.BrghtSlcted == 0.0F) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "AlignmentBased"), guiLeft + 5, guiTop + 140, 0);
         }

         this.field_146292_n.add(new JRMCoreGuiSlider00(-20, guiLeft + 135, guiTop + 5, "", this.BrghtSlcted, 1.0F));
         String n = JRMCoreH.trl("jrmc", "Back");
         Y = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(-5, posX - 130 - Y, posY + 65, Y, 20, n, 0));
      }

      super.func_73863_a(x, y, f);
   }

   public boolean func_73868_f() {
      return false;
   }
}
