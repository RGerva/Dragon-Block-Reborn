package JinRyuu.JRMCore.client.notification;

import JinRyuu.JRMCore.JRMCoreGuiButtonEmpty;
import JinRyuu.JRMCore.JRMCoreGuiButtons00;
import JinRyuu.JRMCore.JRMCoreGuiButtonsA1;
import JinRyuu.JRMCore.JRMCoreGuiScreen;
import JinRyuu.JRMCore.JRMCoreGuiSliderX00;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigsClient;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class JGNotificationGUI {
   public static final int NOTIFICATIONS_OPEN = 50011;
   public static final int NORMAL = 0;
   public static final int MUTED = 1;
   public static final int DISABLED = 2;
   public static final int TEXTURE_SIZE = 16;
   public static final int COLOR_WHITE = 16777215;
   public static final int COLOR_RED = 14828830;
   public static final int COLOR_GREEN = 2940958;
   public static final int COLOR_BLUE = 2898406;
   public static final int COLOR_BLACK = 0;
   private static final int MODE_LIST = 0;
   private static final int MODE_SELECTION = 1;
   private static final int BUTTON_ID_START_SELECT = 19000;
   private static final int LIST_COUNT = 5;
   private static int listCount = 0;
   private static int buttonIDStartDelete;
   private static int buttonIDEnd;
   private static int buttonIDClearAll;
   private static int buttonIDSort;
   private static int buttonIDMute;
   private static int buttonIDDisable;
   private static ArrayList<JGNotification> notificationList;
   private static ArrayList<String> notificationKeyList;
   private static int mode;
   public static byte currentCategory;
   public static int[] categoryState;
   private static Instant now;
   private static boolean sortNewestToOldest;
   private static int categoryScroll;

   public static JRMCoreGuiScreen getGUIInstance() {
      return JRMCoreGuiScreen.instance;
   }

   public static void checkButtons(int buttonID) {
      if (buttonID == 50011) {
         categoryScroll = 0;
         getGUIInstance().scroll = 0;
         mode = 0;
         currentCategory = 0;
      }

      int i;
      if (buttonID >= 19000 && buttonID < buttonIDEnd) {
         boolean remove = buttonID >= buttonIDStartDelete;
         i = buttonID - (remove ? buttonIDStartDelete : 19000) - getGUIInstance().scroll;
         int i;
         if (!remove) {
            int size = notificationList.size();

            for(i = size - 1; i >= 0; --i) {
               if (i != i) {
                  notificationList.remove(i);
                  notificationKeyList.remove(i);
               }
            }

            categoryScroll = getGUIInstance().scroll;
            getGUIInstance().scroll = 0;
            mode = 1;
         } else if (currentCategory == 0) {
            JGNotificationHandler.removeNotification((String)notificationKeyList.get(i));
         } else {
            int scrollStart = 0;
            i = scrollStart + i + 1;
            JGNotificationHandler.removeNotification((String)notificationKeyList.get(i));
         }
      } else if (buttonID == buttonIDEnd) {
         getGUIInstance().scroll = categoryScroll;
         mode = 0;
      } else {
         int all;
         if (buttonID > buttonIDEnd && buttonID <= buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length) {
            all = buttonID - buttonIDEnd - 1;
            currentCategory = (byte)all;
            mode = 0;
            categoryScroll = 0;
            getGUIInstance().scroll = 0;
         } else if (buttonID == buttonIDClearAll) {
            if (currentCategory == 0) {
               JGNotificationHandler.clearNotifications();
            } else if (JGNotificationHandler.notificationsCount.containsKey(currentCategory)) {
               all = (Integer)JGNotificationHandler.notificationsCount.get(currentCategory);

               for(i = all - 1; i >= 0; --i) {
                  JGNotificationHandler.removeNotification(JGNotificationHandler.createKey(currentCategory, i + 1));
               }

               JGNotificationHandler.notificationsCount.remove(currentCategory);
            }
         } else if (buttonID == buttonIDSort) {
            sortNewestToOldest = !sortNewestToOldest;
         } else if (buttonID == buttonIDMute) {
            all = 0;
            if (currentCategory == 0) {
               for(i = 0; i < categoryState.length; ++i) {
                  if (i == 0) {
                     all = categoryState[currentCategory] == 1 ? 0 : 1;
                  }

                  categoryState[i] = all;
               }
            } else {
               categoryState[currentCategory] = categoryState[currentCategory] == 1 ? 0 : 1;
            }

            JGConfigClientSettings.init_notifications(JGConfigsClient.clientNotifications, false, false);
         } else if (buttonID == buttonIDDisable) {
            all = 0;
            if (currentCategory == 0) {
               for(i = 0; i < categoryState.length; ++i) {
                  if (i == 0) {
                     all = categoryState[currentCategory] == 2 ? 0 : 2;
                  }

                  categoryState[i] = all;
               }
            } else {
               categoryState[currentCategory] = categoryState[currentCategory] == 2 ? 0 : 2;
            }

            JGConfigClientSettings.init_notifications(JGConfigsClient.clientNotifications, false, false);
         }
      }

   }

   public static void update(List buttonList, int width, int height, int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      if (JGNotificationHandler.hasNewContent) {
         JGNotificationHandler.hasNewContent = false;
      }

      draw(buttonList, width, height, posX, posY, var5, var6, var8);
   }

   public static void draw(List buttonList, int width, int height, int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      int xPos = false;
      int yPos = false;
      String text = "";
      int xSize = 256;
      int ySize = 159;
      int guiLeft = (width - xSize) / 2;
      int guiTop = (height - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      getGUIInstance();
      ResourceLocation guiLocation = new ResourceLocation(JRMCoreGuiScreen.guiBG2);
      getGUIInstance();
      JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(guiLocation);
      getGUIInstance().func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      String n = JRMCoreH.trl("jrmc", "Back");
      int nw = var8.func_78256_a(n) + 8;
      int yPos = guiTop + 160;
      buttonList.add(new JRMCoreGuiButtons00(mode == 0 ? 100 : buttonIDEnd, guiLeft, yPos, nw, 20, n, 15051074));
      int xPos = guiLeft + 10;
      yPos = guiTop + 4;
      text = JGNotificationHandler.getCategoryTextAll(currentCategory);
      getGUIInstance();
      JRMCoreGuiScreen.drawStringWithBorder(var8, "Category: " + text.substring(0, 1).toUpperCase() + text.substring(1), xPos, yPos, 16777215);
      now = Instant.now();

      int idY;
      for(int i = 0; i < JGNotificationHandler.CATEGORY_IDS_ALL.length; ++i) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         xPos = guiLeft - 20;
         yPos = guiTop + 20 + i * 20;
         buttonList.add(new JRMCoreGuiButtonEmpty(false, currentCategory == i ? 1 : 0, i + 1, categoryState != null ? categoryState[i] : 0, buttonIDEnd + 1 + i, xPos, yPos, 16, 16, "", categoryState[i] == 2 ? 12850949 : (categoryState[i] == 1 ? 12871948 : 0)));
         byte category = JGNotificationHandler.CATEGORY_IDS_ALL[i];
         idY = i == 0 ? JGNotificationHandler.notifications.size() : (JGNotificationHandler.notificationsCount.containsKey(category) ? (Integer)JGNotificationHandler.notificationsCount.get(category) : 0);
         text = JGNotificationHandler.CATEGORY_TEXTS_ALL[i] + ": " + idY;
         if (categoryState[i] != 0) {
            String state = "";
            if (categoryState[i] == 2) {
               state = JRMCoreH.trl("jrmc", "Disabled");
            } else {
               state = JRMCoreH.trl("jrmc", "Muted");
            }

            text = text + " (" + state + ")";
         }

         getGUIInstance();
         JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text), xPos, yPos, 16, 16, getGUIInstance().x, getGUIInstance().y, var8);
      }

      JRMCoreGuiScreen var10000;
      float var10001;
      int var10004;
      int var10005;
      boolean var10006;
      int j;
      if (mode == 0) {
         if (notificationList.size() != 0) {
            notificationList.clear();
            notificationKeyList.clear();
         }

         ArrayList<String> notifications = JGNotificationHandler.getNotificationsArray(currentCategory, sortNewestToOldest);
         int count = notifications.size();
         listCount = count;
         buttonIDStartDelete = 19000 + listCount;
         buttonIDEnd = buttonIDStartDelete + listCount;
         buttonIDClearAll = buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length + 1;
         buttonIDSort = buttonIDClearAll + 1;
         buttonIDMute = buttonIDSort + 1;
         buttonIDDisable = buttonIDMute + 1;
         float m2 = 5.0F;
         int sz = 5;
         getGUIInstance().scrollMouseJump = 1;
         if (count > sz) {
            if ((float)count - m2 < (float)getGUIInstance().scroll) {
               getGUIInstance().scroll = (int)((float)count - m2);
            } else if (getGUIInstance().scroll < 0) {
               getGUIInstance().scroll = 0;
            }

            if (getGUIInstance().mousePressed && !JRMCoreGuiButtonsA1.clicked) {
               var10000 = getGUIInstance();
               var10001 = (float)count - m2;
               getGUIInstance();
               var10000.scroll = (int)JRMCoreH.round(var10001 * JRMCoreGuiScreen.scrollSide, 0);
            } else {
               getGUIInstance();
               JRMCoreGuiScreen.scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)getGUIInstance().scroll / ((float)count - m2);
            }
         } else {
            getGUIInstance().scroll = 0;
         }

         if (count > sz) {
            getGUIInstance();
            if (JRMCoreGuiScreen.scrollSide > 0.0F) {
               buttonList.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 - 70, "i", false));
            }

            getGUIInstance();
            if (JRMCoreGuiScreen.scrollSide < 1.0F) {
               buttonList.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 + 60, "v", false));
            }

            var10004 = guiLeft + xSize / 2 + 110 - 1;
            var10005 = guiTop + 25;
            var10006 = getGUIInstance().mousePressed;
            getGUIInstance();
            buttonList.add(new JRMCoreGuiSliderX00(1000000, var10004, var10005, var10006, JRMCoreGuiScreen.scrollSide, 1.0F, false));
         }

         String[] buttons = new String[]{JRMCoreH.trl("jrmc", "Disable"), JRMCoreH.trl("jrmc", "Mute"), JRMCoreH.trl("jrmc", "Sort"), JRMCoreH.trl("jrmc", "RemoveAll")};
         int[] buttonIDs = new int[]{buttonIDDisable, buttonIDMute, buttonIDSort, buttonIDClearAll};
         int[] buttonIcons = new int[]{18, 17, sortNewestToOldest ? 19 : 20, 18};
         yPos = guiTop - 22;

         int scrollStart;
         for(scrollStart = 0; scrollStart < buttons.length; ++scrollStart) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            xPos = guiLeft + scrollStart * (scrollStart < buttons.length - 1 ? 20 : 30);
            buttonList.add(new JRMCoreGuiButtonEmpty(false, 0, buttonIcons[scrollStart], 0, buttonIDs[scrollStart], xPos, yPos, 16, 16, "", 0));
            text = buttons[scrollStart];
            getGUIInstance();
            JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text), xPos, yPos, 16, 16, getGUIInstance().x, getGUIInstance().y, var8);
         }

         scrollStart = getGUIInstance().scroll;
         int scrollMax = false;
         int scrollMax;
         if (scrollStart + 5 > count) {
            scrollMax = count;
         } else {
            scrollMax = scrollStart + 5;
         }

         j = scrollStart;
         int k = 0;

         for(int i = scrollStart; i < scrollMax; ++i) {
            String key = (String)notifications.get(i);
            if (JGNotificationHandler.notifications.containsKey(key)) {
               JGNotification note = (JGNotification)JGNotificationHandler.notifications.get(key);
               xPos = guiLeft + 10;
               yPos = guiTop + 20 + k * 26;
               int[] var51 = new int[]{0, 16763650, 16722690, 2993151, 3002773, 13815502};
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               if (note.iconColor != 0) {
                  color(note.iconColor);
               }

               ResourceLocation gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_background.png");
               getGUIInstance();
               JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
               getGUIInstance().func_73729_b(xPos, yPos, 0, 0, 230, 26);
               xPos = guiLeft + 12;
               yPos = guiTop + 10 + 13 + k * 26 + 2;
               gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
               getGUIInstance();
               JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
               int idY = note.icon * 16 / 256;
               int idX = note.icon * 16 - idY * 256;
               idY *= 16;
               getGUIInstance().func_73729_b(xPos, yPos, idX, idY, 16, 16);
               notificationList.add(note);
               notificationKeyList.add(key);
               xPos = guiLeft + 35;
               yPos = guiTop + 22 + k * 26;
               getGUIInstance();
               text = JRMCoreGuiScreen.getStringShortened(var8, 175, note.title + " (" + getTime(note.received, false, true) + ")");
               var8.func_78276_b(text, xPos, yPos, 16777215);
               xPos = guiLeft + 35;
               yPos = guiTop + 22 + k * 26;
               getGUIInstance();
               text = JRMCoreGuiScreen.getStringShortened(var8, 165, note.description);
               var8.func_78276_b(text.replace("/n", ""), xPos, yPos + 13, 16777215);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               xPos = guiLeft + 210;
               yPos = guiTop + 10 + 13 + k * 26 + 2;
               text = JRMCoreH.trl("jrmc", "Remove");
               buttonList.add(new JRMCoreGuiButtonEmpty(false, 0, 18, 0, buttonIDStartDelete + i, xPos, yPos, 16, 16, "", 0));
               getGUIInstance();
               JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text), xPos, yPos, 16, 16, getGUIInstance().x, getGUIInstance().y, var8);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               xPos = guiLeft + 10;
               yPos = guiTop + 20 + k * 26;
               buttonList.add(new JRMCoreGuiButtonEmpty(19000 + i, xPos, yPos, 195, 26, ""));
               ++j;
               ++k;
            }
         }
      } else if (mode == 1) {
         if (notificationList.size() != 1) {
            return;
         }

         JGNotification note = (JGNotification)notificationList.get(0);
         xPos = guiLeft + 12;
         yPos = guiTop + 20;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         if (note.iconColor != 0) {
            color(note.iconColor);
         }

         ResourceLocation gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
         getGUIInstance();
         JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
         idY = note.icon * 16 / 256;
         int idX = note.icon * 16 - idY * 256;
         idY *= 16;
         getGUIInstance().func_73729_b(xPos, yPos, idX, idY, 16, 16);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         xPos = guiLeft + 35;
         yPos = guiTop + 22 - 2 + 3;
         getGUIInstance();
         text = JRMCoreGuiScreen.getStringShortened(var8, 200, note.title);
         getGUIInstance();
         JRMCoreGuiScreen.drawStringWithBorder(var8, text, xPos, yPos, 16777215);
         xPos = guiLeft + 45 - 30;
         yPos = guiTop + 45;
         text = note.description;
         String translatedLine = JRMCoreH.trl(text);
         int count = JRMCoreH.txt(translatedLine, "", 0, false, xPos, yPos, 215, 0, 0);
         int textboxWidth = count > 11 ? 215 : 230;
         float m2 = 11.0F;
         int sz = 11;
         getGUIInstance().scrollMouseJump = 2;
         if (count > sz) {
            if ((float)count - m2 < (float)getGUIInstance().scroll) {
               getGUIInstance().scroll = (int)((float)count - m2);
            } else if (getGUIInstance().scroll < 0) {
               getGUIInstance().scroll = 0;
            }

            if (getGUIInstance().mousePressed && !JRMCoreGuiButtonsA1.clicked) {
               var10000 = getGUIInstance();
               var10001 = (float)count - m2;
               getGUIInstance();
               var10000.scroll = (int)JRMCoreH.round(var10001 * JRMCoreGuiScreen.scrollSide, 0);
            } else {
               getGUIInstance();
               JRMCoreGuiScreen.scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)getGUIInstance().scroll / ((float)count - m2);
            }
         } else {
            getGUIInstance().scroll = 0;
         }

         if (count > sz) {
            getGUIInstance();
            if (JRMCoreGuiScreen.scrollSide > 0.0F) {
               buttonList.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 - 70, "i", false));
            }

            getGUIInstance();
            if (JRMCoreGuiScreen.scrollSide < 1.0F) {
               buttonList.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 + 60, "v", false));
            }

            var10004 = guiLeft + xSize / 2 + 110 - 1;
            var10005 = guiTop + 25;
            var10006 = getGUIInstance().mousePressed;
            getGUIInstance();
            buttonList.add(new JRMCoreGuiSliderX00(1000000, var10004, var10005, var10006, JRMCoreGuiScreen.scrollSide, 1.0F, false));
         }

         j = count - 11 - getGUIInstance().scroll;
         if (j < 0) {
            j = 0;
         }

         JRMCoreH.txt(translatedLine, "", 0, true, xPos, yPos - 10 * getGUIInstance().scroll, textboxWidth, getGUIInstance().scroll, j);
      }

   }

   public static String getTime(Instant time, boolean longText, boolean showBiggest) {
      String text = "";
      Duration duration = Duration.between(time, now);
      if (duration.toDays() > 0L) {
         text = text + duration.toDays() + (longText ? " Day" + (duration.toDays() > 1L ? "s" : "") : "d");
         if (showBiggest) {
            return text;
         }
      }

      long timer;
      if (duration.toHours() > 0L) {
         if (showBiggest) {
            text = "";
         }

         timer = duration.toHours();
         text = text + (duration.toDays() > 0L ? " " : "") + (timer >= 24L ? timer - timer / 24L * 24L : timer) + (longText ? " Hour" + (timer > 1L ? "s" : "") : "h");
         if (showBiggest) {
            return text;
         }
      }

      if (duration.toMinutes() > 0L) {
         if (showBiggest) {
            text = "";
         }

         timer = duration.toMinutes();
         text = text + (duration.toHours() > 0L ? " " : "") + (timer >= 60L ? timer - timer / 60L * 60L : timer) + (longText ? " Minute" + (timer > 1L ? "s" : "") : "m");
         if (showBiggest) {
            return text;
         }
      }

      if (duration.toMillis() > 0L) {
         if (showBiggest) {
            text = "";
         }

         timer = duration.toMillis() / 1000L;
         text = text + (duration.toMinutes() > 0L ? " " : "") + (timer >= 60L ? timer - timer / 60L * 60L : timer) + (longText ? " Second" + (timer > 1L ? "s" : "") : "s");
         if (showBiggest) {
            return text;
         }
      }

      return text;
   }

   public static void color(int color, float alpha) {
      float h2 = (float)(color >> 16 & 255) / 255.0F;
      float h3 = (float)(color >> 8 & 255) / 255.0F;
      float h4 = (float)(color & 255) / 255.0F;
      float h1 = 1.0F;
      int r = (int)(h2 * 254.0F);
      int g = (int)(h3 * 254.0F);
      int b = (int)(h4 * 254.0F);
      GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, alpha);
   }

   public static void color(int color) {
      float h2 = (float)(color >> 16 & 255) / 255.0F;
      float h3 = (float)(color >> 8 & 255) / 255.0F;
      float h4 = (float)(color & 255) / 255.0F;
      float h1 = 1.0F;
      int r = (int)(h2 * 254.0F);
      int g = (int)(h3 * 254.0F);
      int b = (int)(h4 * 254.0F);
      GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
   }

   static {
      buttonIDStartDelete = 19000 + listCount;
      buttonIDEnd = buttonIDStartDelete + listCount;
      buttonIDClearAll = buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length + 1;
      buttonIDSort = buttonIDClearAll + 1;
      buttonIDMute = buttonIDSort + 1;
      buttonIDDisable = buttonIDMute + 1;
      notificationList = new ArrayList();
      notificationKeyList = new ArrayList();
      mode = 0;
      currentCategory = 0;
      categoryState = new int[]{0, 0, 0, 0, 0, 0};
      sortNewestToOldest = true;
      categoryScroll = 0;
   }
}
