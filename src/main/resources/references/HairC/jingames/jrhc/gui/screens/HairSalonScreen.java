package jingames.jrhc.gui.screens;

import com.mojang.blaze3d.platform.Window;
import com.mojang.math.Axis;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jingames.jrhc.gui.buttons.sliders.type_00.ButtonSlider00;
import jingames.jrhc.gui.buttons.sliders.type_02.ButtonSlider02;
import jingames.jrhc.gui.buttons.type_00.Button00;
import jingames.jrhc.gui.buttons.type_01.Button01;
import jingames.jrhc.gui.buttons.type_A1.ButtonA1;
import jingames.jrhc.gui.buttons.type_A2.ButtonA2;
import jingames.jrhc.gui.buttons.type_c.ButtonC;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import jingames.jrhc.setup.helper.ARGB;
import jingames.jrhc.setup.helper.GuiHelper;
import jingames.jrhc.setup.network.Networking;
import jingames.jrhc.setup.network.PacketColors;
import jingames.jrhc.setup.network.PacketData;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix3x2fStack;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class HairSalonScreen extends Screen {
   public static final ResourceLocation BUTTON_1 = ResourceLocation.tryBuild("jrhc", "textures/gui/button1.png");
   public static final ResourceLocation GUI = ResourceLocation.tryBuild("jrhc", "textures/gui/gui.png");
   public static final ResourceLocation ALLW = ResourceLocation.tryBuild("jrhc", "textures/gui/allw.png");
   public static final ResourceLocation COLORS = ResourceLocation.tryBuild("jrhc", "textures/gui/colors.png");
   public static final Logger LOGGER = LogManager.getLogger();
   public static int guiID = 0;
   public int guiIDprev = 0;
   public int guiIDprev2 = 0;
   public int guiLeft;
   public int guiTop;
   public int xSize = 256;
   public int ySize = 159;
   public int imageWidth = 256;
   public int imageHeight = 159;
   public float xSize_lo;
   public float ySize_lo;
   private URI clickedURI;
   private String url = "https://hairsalon.jingames.net";
   private String getClipboardContent;
   private Button01 customHairButton;
   private Button01 hairColorButton;
   private Button01 RemoveHairButton;
   private Button00 revertHairButton;
   private Button00 doneButton;
   private Button00 backButton;
   private ButtonC rgbColorButton;
   private ButtonSlider00 blackWhiteSliderButton;
   private Button00 hairSalonButton;
   private Button00 shareButton;
   private Button00 pasteButton;
   private Button00 resetButton;
   private Button00 nextButton;
   private ButtonA2 yawButtonPrevious;
   private ButtonA2 yawButtonNext;
   private ButtonA2 pitchButtonPrevious;
   private ButtonA2 pitchButtonNext;
   public static int HairSelected = 0;
   public static int Hair2Selected = 0;
   public static int ColorSelected = 0;
   public static float BrightSelected = 0.8F;
   public static int yaw = 0;
   public static int pitch = 0;
   public static int preset = 0;
   public static boolean freeView = true;
   private ButtonA1 freeViewTrueButton;
   private ButtonA1 freeViewResetButton;
   private ButtonA2 presetButtonPrevious;
   private ButtonA2 presetButtonNext;
   private int[] hairModelPartIDPerPage = new int[]{0, 4, 14, 24, 40, 56};
   public static String dnsH = "";
   public static String[] dnsHSplittedBy2;
   private String dnsHOld = "";
   private int[] dfa = new int[5];
   public static final int hairLengthG2 = 786;
   public static final int hairLengthG1 = 392;
   private ButtonSlider02[] hairSlider02 = new ButtonSlider02[952];
   private ButtonA2[] hairOButton02 = new ButtonA2[56];
   private ButtonA2[] hairXButton02 = new ButtonA2[56];
   private ButtonA2[] hairTierButton02 = new ButtonA2[56];
   private float ColorSelectedOldRed;
   private float ColorSelectedOldGreen;
   private float ColorSelectedOldBlue;
   public static String hoverText;
   public static String[] defHairPrsts;
   public static String[] defHairPrstsMadeBy;
   public static int MaxPresetNum;
   public static ArrayList<String> PresetList;

   public HairSalonScreen(int id) {
      super(Component.translatable("screen.jrhc.hairsalon"));
      guiID = id;
      this.guiIDprev = guiID;
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         int red = (int)(h.getRedColor() * 255.0F);
         int green = (int)(h.getGreenColor() * 255.0F);
         int blue = (int)(h.getBlueColor() * 255.0F);
         ColorSelected = red * 65536 + green * 256 + blue;
         this.ColorSelectedOldRed = (float)red / 255.0F;
         this.ColorSelectedOldGreen = (float)green / 255.0F;
         this.ColorSelectedOldBlue = (float)blue / 255.0F;
         if (h.getDNSH() == null) {
            h.setDNSH("00");
         }

         dnsH = h.getDNSH();
         this.dnsHOld = dnsH;
      });
   }

   protected void init() {
      ArrayList<String> defpres = new ArrayList();
      ArrayList<String> presets = new ArrayList();
      String[] var3 = defHairPrsts;
      int j = var3.length;

      int count;
      String s;
      for(count = 0; count < j; ++count) {
         s = var3[count];
         defpres.add(s);
      }

      presets.addAll(defpres);
      PresetList = presets;

      int i;
      for(i = 0; i < PresetList.size(); ++i) {
         if (((String)PresetList.get(i)).equals(dnsH)) {
            preset = i;
            break;
         }
      }

      i = (this.width - this.imageWidth) / 2;
      j = (this.height - this.imageHeight) / 2;
      int count = 0;
      s = "Custom Hair";
      int sw = this.font.width(s) / 2;
      this.customHairButton = (Button01)this.addRenderableWidget(new Button01(i + 190 - sw, j + 5 + count * 10, sw, 10, Component.literal(s), (p_86679_) -> {
         guiID = 2;
         if (dnsH == null) {
            this.changeDnsH("00");
         }

         this.setSliderValuesFromPresetOrCopy(dnsH, -1);
      }, 14482939, true));
      count = count + 1;
      s = "Color";
      sw = this.font.width(s) / 2;
      this.hairColorButton = (Button01)this.addRenderableWidget(new Button01(i + 190 - sw, j + 5 + count * 10, sw, 10, Component.literal(s), (p_86679_) -> {
         guiID = 1;
      }, 16777215, false));
      ++count;
      s = "Remove Custom Hair";
      sw = this.font.width(s) / 2;
      this.RemoveHairButton = (Button01)this.addRenderableWidget(new Button01(i + 190 - sw, j + 5 + count * 10, sw, 10, Component.literal(s), (p_86679_) -> {
         this.changeDnsH(defHairPrsts[0]);
      }, 14482939, true));
      String n = "Revert";
      int nw = this.font.width(n) + 8;
      this.revertHairButton = (Button00)this.addRenderableWidget(new Button00(i - 42, j + 143, nw, 20, Component.literal(n), (p_86679_) -> {
         this.changeDnsH(this.dnsHOld);
         this.changeColor(this.ColorSelectedOldRed, this.ColorSelectedOldGreen, this.ColorSelectedOldBlue);
      }, 0, 0));
      n = "Done";
      nw = this.font.width(n) + 8;
      this.doneButton = (Button00)this.addRenderableWidget(new Button00(i + 257, j + 143, nw, 20, Component.literal(n), (p_86679_) -> {
         if (guiID == 0) {
            this.onClose();
         } else {
            guiID = 0;
            this.hideModelPartButtonsOnAllPageExceptThis(-1);
         }

      }, 0, 0));
      n = "Back";
      nw = this.font.width(n) + 8;
      this.backButton = (Button00)this.addRenderableWidget(new Button00(i - 30, j + 143, nw, 20, Component.literal(n), (p_86679_) -> {
         if (guiID > 2 && guiID <= 6) {
            --guiID;
            this.hideModelPartButtonsOnAllPageExceptThis(guiID - 2);
         } else {
            guiID = 0;
         }

      }, 0, 0));
      this.rgbColorButton = (ButtonC)this.addRenderableWidget(new ButtonC(i + 5 + 0, j + 5 + 0, 128, 128, Component.literal(""), (p_86679_) -> {
         guiID = 0;
         Player player = Minecraft.getInstance().player;
      }, 0));
      this.blackWhiteSliderButton = (ButtonSlider00)this.addRenderableWidget(new ButtonSlider00(i + 135, j + 5, 20, 128, Component.literal(""), (p_86679_) -> {
      }, BrightSelected, 1.0F));
      n = "Next";
      nw = this.font.width(n) + 8;
      this.nextButton = (Button00)this.addRenderableWidget(new Button00(i + 258, j + 120, nw, 20, Component.literal(n), (p_86679_) -> {
         if (guiID >= 2 && guiID < 6) {
            ++guiID;
            this.hideModelPartButtonsOnAllPageExceptThis(guiID - 2);
         } else {
            guiID = 2;
            this.hideModelPartButtonsOnAllPageExceptThis(guiID - 2);
         }

      }, 0, 0));
      n = "Yaw";
      nw = this.font.width(n) + 8;
      count = 0;
      this.yawButtonPrevious = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 5, j + 15 + count * 11, 10, 10, Component.literal("<"), (p_86679_) -> {
         if (yaw < 7) {
            ++yaw;
         }

      }));
      this.yawButtonNext = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 47, j + 15 + count * 11, 10, 10, Component.literal(">"), (p_86679_) -> {
         if (yaw > -7) {
            --yaw;
         }

      }));
      count = count + 1;
      n = "Pitch";
      nw = this.font.width(n) + 8;
      this.pitchButtonPrevious = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 5, j + 15 + count * 11, 10, 10, Component.literal("<"), (p_86679_) -> {
         if (pitch < 15) {
            ++pitch;
         }

      }));
      this.pitchButtonNext = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 15 + nw, j + 15 + count * 11, 10, 10, Component.literal(">"), (p_86679_) -> {
         if (pitch > -15) {
            --pitch;
         }

      }));
      ++count;
      this.freeViewTrueButton = (ButtonA1)this.addRenderableWidget(new ButtonA1(i + 25, j + 15 + count * 11, 15, 15, Component.literal("x"), (p_86679_) -> {
         freeView = false;
         yaw = 0;
         pitch = 0;
      }));
      this.freeViewResetButton = (ButtonA1)this.addRenderableWidget(new ButtonA1(i + 5, j + 15 + count * 11, 15, 15, Component.literal("o"), (p_86679_) -> {
         if (freeView) {
            freeView = false;
         } else {
            freeView = true;
         }

      }));
      count = 0;
      s = "Preset " + preset;
      sw = this.font.width(s);
      this.presetButtonPrevious = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 5 + 70 - 7, j + 5 + 50 - 2 + count * 11, 10, 10, Component.literal("<"), (p_86679_) -> {
         --preset;
         if (preset < 0) {
            preset = MaxPresetNum;
         }

         this.hideModelPartButtonsOnAllPageExceptThis(guiID - 2);
         this.changeDnsH((String)PresetList.get(preset));
         this.setSliderValuesFromPresetOrCopy((String)PresetList.get(preset), -1);
      }));
      this.presetButtonNext = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 5 + 70 + 4 + sw, j + 5 + 50 - 2 + count * 11, 10, 10, Component.literal(">"), (p_86679_) -> {
         ++preset;
         if (preset > MaxPresetNum) {
            preset = 0;
         }

         this.hideModelPartButtonsOnAllPageExceptThis(guiID - 2);
         this.changeDnsH((String)PresetList.get(preset));
         this.setSliderValuesFromPresetOrCopy((String)PresetList.get(preset), -1);
      }));
      int chid = 0;

      for(int page = 1; page < 6; ++page) {
         int hid = this.hairModelPartIDPerPage[page - 1] * 10;

         for(int face = this.hairModelPartIDPerPage[page - 1]; face < this.hairModelPartIDPerPage[page]; ++face) {
            int l = dnsHair2(dnsH, face * 14);
            int X = dnsHair2(dnsH, face * 14 + 2);
            int Y = dnsHair2(dnsH, face * 14 + 4);
            int Z = dnsHair2(dnsH, face * 14 + 6);
            int B = dnsHair2(dnsH, face * 14 + 8);
            int P = dnsHair2(dnsH, face * 14 + 10);
            int T = dnsHair2(dnsH, face * 14 + 12);
            int nums = face * 7 + 1;
            X = X > 82 ? 82 : (X < 18 ? 18 : X);
            Y = Y > 82 ? 82 : (Y < 18 ? 18 : Y);
            Z = Z > 82 ? 82 : (Z < 18 ? 18 : Z);
            B = B > 82 ? 82 : (B < 18 ? 18 : B);
            P = P > 82 ? 82 : (P < 18 ? 18 : P);
            T = T > 82 ? 82 : (T < 18 ? 18 : T);
            X = (int)((float)(X - 18) * 1.56F);
            Y = (int)((float)(Y - 18) * 1.56F);
            Z = (int)((float)(Z - 18) * 1.56F);
            B = (int)((float)(B - 18) * 1.56F);
            P = (int)((float)(P - 18) * 1.56F);
            T = (int)((float)(T - 18) * 1.56F);
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 0 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)X * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums));
            ++hid;
            ++nums;
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 7 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)Y * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums));
            ++hid;
            ++nums;
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 14 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)Z * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums));
            ++hid;
            ++nums;
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 21 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)l * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums - 4));
            ++hid;
            int localHid = nums - 4;
            this.hairOButton02[face] = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 80 + 28 + 45, i + 5 + 38, 10, 10, Component.literal("o"), (p_86679_) -> {
               this.changeDnsHValue(localHid, "00");
            }, 1));
            ++hid;
            this.hairXButton02[face] = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 80 + 28 + 45, j + 31 + 38, 10, 10, Component.literal("x"), (p_86679_) -> {
               this.changeFaceOfDnsH(face);
               this.setSliderValuesFromPresetOrCopy((String)PresetList.get(preset), face);
            }));
            ++hid;
            this.hairTierButton02[face] = (ButtonA2)this.addRenderableWidget(new ButtonA2(i + 80 + 28 + 45, j + 18 + 38, 10, 10, Component.literal("(|)"), (p_86679_) -> {
            }, 2));
            ++hid;
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 0 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)B * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums));
            ++hid;
            ++nums;
            this.hairSlider02[hid] = (ButtonSlider02)this.addRenderableWidget(new ButtonSlider02(i + 80 + 7 + 45, i + 5 + 38, 5, 35, Component.literal(""), (p_86679_) -> {
            }, (float)P * 0.01F, 1.0F, this.dfa[page - 1] == 1 && chid == 0 ? 14737632 : 0, nums));
            ++hid;
            ++nums;
            ++hid;
            ++chid;
         }
      }

      count = 0;
      n = "HairSalon";
      nw = this.font.width(n) + 8;
      this.hairSalonButton = (Button00)this.addRenderableWidget(new Button00(i + 258, j + count * 25, nw, 20, Component.literal(n), (p_86679_) -> {
         this.urlOpenWithConfirm(this.url);
      }, 0, 1));
      count = count + 1;
      n = "Share";
      nw = this.font.width(n) + 8;
      this.shareButton = (Button00)this.addRenderableWidget(new Button00(i + 258, j + count * 25, nw, 20, Component.literal(n), (p_86679_) -> {
         this.setClipboardFromDnsH();
      }, 0, 2));
      ++count;
      n = "Paste";
      nw = this.font.width(n) + 8;
      this.pasteButton = (Button00)this.addRenderableWidget(new Button00(i + 258, j + count * 25, nw, 20, Component.literal(n), (p_86679_) -> {
         this.pasteFromClipboard();
      }, 0, 3));
      ++count;
      n = "Reset";
      nw = this.font.width(n) + 8;
      this.resetButton = (Button00)this.addRenderableWidget(new Button00(i + 258, j + count * 25, nw, 20, Component.literal(n), (p_86679_) -> {
         this.setSliderValuesFromPresetOrCopy(dnsH, -1);
         this.changeDnsH((String)PresetList.get(preset));
      }, 0, 4));
      this.hideModelPartButtonsOnAllPageExceptThis(-1);
      super.init();
   }

   private void setClipboardFromDnsH() {
      Minecraft.getInstance().keyboardHandler.setClipboard(dnsH);
   }

   public void pasteFromClipboard() {
      this.getClipboardContent = Minecraft.getInstance().keyboardHandler.getClipboard();
      if (this.getClipboardContent.length() != 786) {
         this.getClipboardContent = dnsHairG1toG2(this.getClipboardContent);
      }

      if (this.getClipboardContent.length() == 786) {
         this.setSliderValuesFromPresetOrCopy(this.getClipboardContent, -1);
         this.changeDnsH(this.getClipboardContent);
      }

   }

   private void changeColor(float oldred, float oldgreen, float oldblue) {
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         Networking.sendToServer(new PacketColors(oldred, oldgreen, oldblue));
         int red = (int)(oldred * 255.0F);
         int green = (int)(oldgreen * 255.0F);
         int blue = (int)(oldblue * 255.0F);
         ColorSelected = red * 65536 + green * 256 + blue;
      });
   }

   private void changeFaceOfDnsH(int fc) {
      String[] dnsHSFaceplittedBy14 = ((String)PresetList.get(preset)).split("(?<=\\G.{14})");
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         dnsH = h.getDNSH();
      });
      String[] dnsHSplittedBy14 = dnsH.split("(?<=\\G.{14})");
      String newDnsH = "";
      int number = 0;
      String[] var7 = dnsHSplittedBy14;
      int var8 = dnsHSplittedBy14.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         String element = var7[var9];
         if (number == fc) {
            newDnsH = newDnsH + dnsHSFaceplittedBy14[fc];
         } else {
            newDnsH = newDnsH + element;
         }

         ++number;
      }

      this.changeDnsH(newDnsH);
   }

   private void drawDetails(GuiGraphics gui, int mouseX, int mouseY, Font var8) {
      if (!hoverText.isEmpty()) {
         Matrix3x2fStack poseStack = gui.pose();
         poseStack.pushMatrix();
         String desc = hoverText;
         int ll = 200;
         int descw = var8.width(desc);
         int desch = 1 + var8.width(desc) / ll;
         int rowNum = desch;
         desch = this.txt(gui, var8, desc, "§8", 0, false, 0, 0, ll);
         Window var5 = Minecraft.getInstance().getWindow();
         int var6 = var5.getGuiScaledWidth();
         int var7 = var5.getGuiScaledHeight();
         int xp = 0;
         int yp = 0;
         if (var6 < mouseX + (descw < ll ? descw : ll) + 10) {
            xp += var6 - (mouseX + (descw < ll ? descw : ll)) - 10;
         }

         if (var7 < mouseY + desch * 10 + 10) {
            yp = -(desch * 10 + 20);
         }

         if (rowNum > desch) {
            desch = rowNum;
         }

         if (rowNum > 3) {
            desch = rowNum + 1;
         }

         gui.blit(RenderPipelines.GUI_TEXTURED, ALLW, mouseX + xp, mouseY + 10 + yp, 5.0F, 5.0F, (descw < ll ? descw : ll) + 10, desch * 10 + 10, 256, 256);
         gui.fill(0, 0, 0, 0, 0);
         this.txt(gui, var8, desc, "§8", 0, true, mouseX + 5 + xp, mouseY + 5 + 10 + yp, ll);
         hoverText = "";
         poseStack.popMatrix();
      }

   }

   public int txt(GuiGraphics gui2, Font var8, String s, String c, int i, boolean b, int l, int t, int c2) {
      if (c2 == 0) {
         boolean c21 = true;
      }

      String[] text = s.split("\n");
      s = s.replaceAll("/n", "\n");
      int i2 = 0;
      int i3 = 0;
      int j = 10;
      String[] var14 = text;
      int var15 = text.length;

      for(int var16 = 0; var16 < var15; ++var16) {
         String element = var14[var16];
         if (b) {
            if (i != 0 && i2 == 0) {
               i3 = i;
            }

            if (element.length() > 38) {
               String[] text2 = element.split("(?<=\\G.{38})");

               for(int z = 0; z < text2.length; ++z) {
                  GuiHelper.drawString(gui2, var8, c + text2[z], l, t + i2 * j + z * j + i3, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
               }
            } else {
               GuiHelper.drawString(gui2, var8, c + element, l, t + i2 * j + i3, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
            }
         }

         ++i2;
      }

      i2 = (int)((float)i2 + GuiHelper.round((float)i * 0.1F, 0));
      return i2;
   }

   public void setSliderValuesFromPresetOrCopy(String presetOrCopyValue, int resetonlyFaceX) {
      String newValue = presetOrCopyValue;
      if (presetOrCopyValue.length() != 786) {
         newValue = dnsHairG1toG2(presetOrCopyValue);
      }

      if (newValue.length() != 786) {
         System.out.println("The used value is not compatible with Hair C!");
      } else {
         for(int pageX = 1; pageX < 6; ++pageX) {
            int hid = this.hairModelPartIDPerPage[pageX - 1] * 10;

            for(int face = this.hairModelPartIDPerPage[pageX - 1]; face < this.hairModelPartIDPerPage[pageX]; ++face) {
               if (this.hairSlider02[hid] != null) {
                  if (resetonlyFaceX >= 0 && resetonlyFaceX != face) {
                     hid += 10;
                  } else {
                     int l = dnsHair2(newValue, face * 14);
                     int X = dnsHair2(newValue, face * 14 + 2);
                     int Y = dnsHair2(newValue, face * 14 + 4);
                     int Z = dnsHair2(newValue, face * 14 + 6);
                     int B = dnsHair2(newValue, face * 14 + 8);
                     int P = dnsHair2(newValue, face * 14 + 10);
                     int T = dnsHair2(newValue, face * 14 + 12);
                     X = X > 82 ? 82 : (X < 18 ? 18 : X);
                     Y = Y > 82 ? 82 : (Y < 18 ? 18 : Y);
                     Z = Z > 82 ? 82 : (Z < 18 ? 18 : Z);
                     B = B > 82 ? 82 : (B < 18 ? 18 : B);
                     P = P > 82 ? 82 : (P < 18 ? 18 : P);
                     T = T > 82 ? 82 : (T < 18 ? 18 : T);
                     X = (int)((float)(X - 18) * 1.56F);
                     Y = (int)((float)(Y - 18) * 1.56F);
                     Z = (int)((float)(Z - 18) * 1.56F);
                     B = (int)((float)(B - 18) * 1.56F);
                     P = (int)((float)(P - 18) * 1.56F);
                     T = (int)((float)(T - 18) * 1.56F);
                     this.hairSlider02[hid].sliderValue = (float)X * 0.01F;
                     ++hid;
                     if (this.hairSlider02[hid] != null) {
                        this.hairSlider02[hid].sliderValue = (float)Y * 0.01F;
                     }

                     ++hid;
                     if (this.hairSlider02[hid] != null) {
                        this.hairSlider02[hid].sliderValue = (float)Z * 0.01F;
                     }

                     ++hid;
                     if (this.hairSlider02[hid] != null) {
                        this.hairSlider02[hid].sliderValue = (float)l * 0.01F;
                     }

                     if (this.hairOButton02[face] != null) {
                        if (l != 0) {
                           this.hairOButton02[face].hideGroup = false;
                           this.hairOButton02[face].string = "o";
                        } else {
                           this.hairOButton02[face].hideGroup = true;
                           this.hairOButton02[face].string = "<";
                        }
                     }

                     if (this.hairTierButton02[face] != null) {
                        this.hairTierButton02[face].tierNum = 1;
                        this.hairTierButton02[face].string = "(|)";
                     }

                     hid += 4;
                     if (this.hairSlider02[hid] != null) {
                        this.hairSlider02[hid].sliderValue = (float)B * 0.01F;
                     }

                     ++hid;
                     if (this.hairSlider02[hid] != null) {
                        this.hairSlider02[hid].sliderValue = (float)P * 0.01F;
                     }

                     ++hid;
                     ++hid;
                  }
               } else {
                  hid += 10;
               }
            }
         }

      }
   }

   public static int dnsHair2(String s, int n) {
      try {
         int var10000;
         if (s != null && s.length() > n) {
            String var4 = sa(s, n);
            var10000 = Integer.parseInt(var4 + sa(s, n + 1));
         } else {
            var10000 = 0;
         }

         return var10000;
      } catch (Exception var3) {
         return 0;
      }
   }

   public static String sa(String s1, int s2) {
      char var10000 = s1.charAt(s2);
      return var10000.makeConcatWithConstants<invokedynamic>(var10000);
   }

   public void renderBackground(GuiGraphics p_283688_, int p_299421_, int p_298679_, float p_297268_) {
   }

   public void render(GuiGraphics gui, int x, int y, float p_96565_) {
      Matrix3x2fStack posestack = gui.pose();
      Minecraft minecraft = Minecraft.getInstance();
      Player player = minecraft.player;
      int screenHeight = this.height - 63;
      int screenWidth = this.width;
      Font fontrenderer = this.font;
      posestack.pushMatrix();
      int xSize = 256;
      int ySize = 159;
      int guiLeft = (this.width - xSize) / 2;
      int guiTop = (this.height - ySize) / 2;
      gui.blit(RenderPipelines.GUI_TEXTURED, GUI, guiLeft, guiTop, 0.0F, 0.0F, xSize, ySize, 256, 256);
      gui.fill(0, 0, 0, 0, 0);
      int i;
      if (guiID == 0) {
         GuiHelper.drawString(gui, fontrenderer, "Barber Menu", screenWidth / 2 - 110, screenHeight / 2 - 40, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
         int i = (this.width - this.imageWidth) / 2;
         i = (this.height - this.imageHeight) / 2;
         renderEntity(gui, i - 40, i + 15, 58, (float)(i + 51) - (float)x, (float)(i + 75 - 50) - (float)y, Minecraft.getInstance().player);
         float h2 = (float)(ColorSelected >> 16 & 255) / 255.0F;
         float h3 = (float)(ColorSelected >> 8 & 255) / 255.0F;
         float h4 = (float)(ColorSelected & 255) / 255.0F;
         float h1 = 1.0F;
         gui.fill(guiLeft + 190 - 25, guiTop + 4 + 10, guiLeft + 190 - 25 + 50, guiTop + 4 + 10 + 10, ARGB.colorFromFloat(1.0F, h1 * h2, h1 * h3, h1 * h4));
         this.customHairButton.visible = true;
         this.hairColorButton.visible = true;
         this.RemoveHairButton.visible = true;
         this.revertHairButton.visible = true;
         this.doneButton.visible = true;
         this.backButton.visible = false;
         this.rgbColorButton.visible = false;
         this.blackWhiteSliderButton.visible = false;
         this.hairSalonButton.visible = false;
         this.shareButton.visible = false;
         this.pasteButton.visible = false;
         this.resetButton.visible = false;
         this.nextButton.visible = false;
         this.yawButtonPrevious.visible = false;
         this.yawButtonNext.visible = false;
         this.pitchButtonPrevious.visible = false;
         this.pitchButtonNext.visible = false;
         this.freeViewTrueButton.visible = false;
         this.freeViewResetButton.visible = false;
         this.presetButtonPrevious.visible = false;
         this.presetButtonNext.visible = false;
      }

      if (guiID == 1) {
         this.customHairButton.visible = false;
         this.hairColorButton.visible = false;
         this.RemoveHairButton.visible = false;
         this.revertHairButton.visible = false;
         this.doneButton.visible = false;
         this.hairSalonButton.visible = false;
         this.shareButton.visible = false;
         this.pasteButton.visible = false;
         this.resetButton.visible = false;
         this.nextButton.visible = false;
         this.yawButtonPrevious.visible = false;
         this.yawButtonNext.visible = false;
         this.pitchButtonPrevious.visible = false;
         this.pitchButtonNext.visible = false;
         this.freeViewTrueButton.visible = false;
         this.freeViewResetButton.visible = false;
         this.presetButtonPrevious.visible = false;
         this.presetButtonNext.visible = false;
         this.backButton.visible = true;
         this.rgbColorButton.visible = true;
         this.blackWhiteSliderButton.visible = true;
      }

      super.render(gui, x, y, p_96565_);
      if (guiID >= 2 && guiID <= 6) {
         this.yawButtonPrevious.visible = !freeView;
         this.yawButtonNext.visible = !freeView;
         this.pitchButtonPrevious.visible = !freeView;
         this.pitchButtonNext.visible = !freeView;
         this.freeViewTrueButton.visible = !freeView;
         this.freeViewResetButton.visible = true;
         this.doneButton.visible = true;
         this.hairSalonButton.visible = true;
         this.shareButton.visible = true;
         this.pasteButton.visible = true;
         this.resetButton.visible = true;
         this.presetButtonPrevious.visible = false;
         this.presetButtonNext.visible = false;
         this.customHairButton.visible = false;
         this.hairColorButton.visible = false;
         this.RemoveHairButton.visible = false;
         this.revertHairButton.visible = false;
         this.nextButton.visible = true;
         this.backButton.visible = true;
         this.rgbColorButton.visible = false;
         this.blackWhiteSliderButton.visible = false;
         this.presetButtonNext.x = guiLeft + 5 + 70 + 4 + this.font.width("Preset " + preset);
         String text;
         switch(guiID) {
         case 3:
            text = "Right";
            break;
         case 4:
            text = "Left";
            break;
         case 5:
            text = "Back";
            break;
         case 6:
            text = "Top";
            break;
         default:
            this.backButton.visible = false;
            text = "Front";
            this.presetButtonPrevious.visible = true;
            this.presetButtonNext.visible = true;
            int count = 0;
            String s = "Preset " + preset;
            GuiHelper.drawString(gui, fontrenderer, s, guiLeft + 5 + 70 + 4, guiTop + 5 + 50 + count * 11, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
            if (preset > 8) {
               s = defHairPrstsMadeBy[preset];
               GuiHelper.drawString(gui, fontrenderer, "Made by", guiLeft + 5 + 70 + 4, guiTop + 5 + 60 + count * 11, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
               GuiHelper.drawString(gui, fontrenderer, s, guiLeft + 5 + 70 + 4, guiTop + 15 + 60 + count * 11, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
            }
         }

         GuiHelper.drawString(gui, fontrenderer, text, screenWidth / 2 - 121, screenHeight / 2 - 43, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
         int j;
         if (this.yawButtonPrevious.visible) {
            String n = "Yaw";
            int count = 0;
            GuiHelper.drawString(gui, fontrenderer, n, guiLeft + 15 + 6, guiTop + 15 + 2 + count * 10, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
            j = count + 1;
            n = "Pitch";
            GuiHelper.drawString(gui, fontrenderer, n, guiLeft + 15 + 4, guiTop + 15 + 2 + j * 10, ARGB.colorFromFloat(1.0F, 0.0F, 0.0F, 0.0F), false);
         }

         i = (this.width - this.imageWidth) / 2;
         j = (this.height - this.imageHeight) / 2;
         renderEntity(gui, i - 85, j + 55, 80, (float)(i + 51) - (float)x, (float)(j + 75 - 50) - (float)y, Minecraft.getInstance().player);
         int page = guiID - 2;
         int hid = this.hairModelPartIDPerPage[page] * 10;
         String rot = "hairrotations";
         String xax = "hairxaxis";
         String yax = "hairyaxis";
         String zax = "hairzaxis";
         String len = "hairlength";
         String ben = "hairbend";
         String bpo = "hairbendpoint";
         String trf = "hairtransf";
         String tir = "hairtier";
         String trd = "hairtierdesc";
         String hde = "hairhide";
         String shw = "hairshow";
         String res = "hairreset";
         String dal = "hairdoallon";
         String dad = "hairdoalldesc";
         String daf = "hairdoalloff";
         int[][] posH = new int[][]{{0, 1, 2, 3, 0, 1, 2, 0, 1, 0}, {0, 1, 2, 3, 1, 2, 3, 2, 3, 3}, {3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0}, {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3}};
         int[][] posV = new int[][]{{0, 0, 0, 0, 1, 1, 1, 2, 2, 3}, {0, 0, 0, 0, 1, 1, 1, 2, 2, 3}, {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, {3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0}};
         int pidh = 0;
         int pidv = 0;
         int chid = 0;

         for(int face = this.hairModelPartIDPerPage[page]; face < this.hairModelPartIDPerPage[page + 1]; ++face) {
            int l = dnsHair2(dnsH, face * 14);
            int X = dnsHair2(dnsH, face * 14 + 2);
            int Y = dnsHair2(dnsH, face * 14 + 4);
            int Z = dnsHair2(dnsH, face * 14 + 6);
            int B = dnsHair2(dnsH, face * 14 + 8);
            int P = dnsHair2(dnsH, face * 14 + 10);
            int T = dnsHair2(dnsH, face * 14 + 12);
            X = X > 82 ? 82 : (X < 18 ? 18 : X);
            Y = Y > 82 ? 82 : (Y < 18 ? 18 : Y);
            Z = Z > 82 ? 82 : (Z < 18 ? 18 : Z);
            B = B > 82 ? 82 : (B < 18 ? 18 : B);
            P = P > 82 ? 82 : (P < 18 ? 18 : P);
            T = T > 82 ? 82 : (T < 18 ? 18 : T);
            int x2 = X - 50;
            int y2 = Y - 50;
            int z2 = Z - 50;
            int b2 = B - 50;
            int p2 = P - 50;
            int t2 = T - 50;
            int L2 = (int)((float)l / 2.8F) + 1;
            X = (int)((float)(X - 18) * 1.56F);
            Y = (int)((float)(Y - 18) * 1.56F);
            Z = (int)((float)(Z - 18) * 1.56F);
            B = (int)((float)(B - 18) * 1.56F);
            P = (int)((float)(P - 18) * 1.56F);
            T = (int)((float)(T - 18) * 1.56F);
            int pH = page == 0 ? pidh : posH[page - 1][chid];
            int pV = page == 0 ? pidv : posV[page - 1][chid];
            String var10000;
            if (this.hairOButton02[face] != null) {
               this.hairOButton02[face].visible = true;
               this.hairOButton02[face].x = guiLeft + 80 + 28 + pH * 45;
               this.hairOButton02[face].y = guiTop + 5 + pV * 38;
               if (this.hairOButton02[face].isHoveredOrFocused()) {
                  var10000 = GuiHelper.cldgy;
                  hoverText = var10000 + (l != 0 ? cct(hde).getString() : cct(shw).getString()) + face;
                  this.drawDetails(gui, x, y, fontrenderer);
               }
            }

            if (this.hairXButton02[face] != null) {
               this.hairXButton02[face].visible = true;
               this.hairXButton02[face].x = guiLeft + 80 + 28 + pH * 45;
               this.hairXButton02[face].y = guiTop + 31 + pV * 38;
               if (this.hairXButton02[face].isHoveredOrFocused()) {
                  var10000 = GuiHelper.cldgy;
                  hoverText = var10000 + cct(res).getString();
                  this.drawDetails(gui, x, y, fontrenderer);
               }
            }

            boolean showGroup = true;
            boolean showTier1 = true;
            boolean showTier2 = true;
            if (this.hairTierButton02[face] != null) {
               this.hairTierButton02[face].visible = showGroup;
               this.hairTierButton02[face].x = guiLeft + 80 + 28 + pH * 45;
               this.hairTierButton02[face].y = guiTop + 18 + pV * 38;
               if (this.hairTierButton02[face].tierNum == 1) {
                  showTier1 = true;
                  showTier2 = false;
               } else if (this.hairTierButton02[face].tierNum == 2) {
                  showTier1 = false;
                  showTier2 = true;
               }

               if (this.hairTierButton02[face].isHoveredOrFocused()) {
                  var10000 = GuiHelper.cldgy;
                  hoverText = var10000 + cct(tir).getString() + (this.hairTierButton02[face].tierNum == 1 ? " 1\n" : " 2\n") + cct(trd).getString();
                  this.drawDetails(gui, x, y, fontrenderer);
               }
            }

            if (this.hairOButton02[face].hideGroup) {
               showTier1 = false;
               showTier2 = false;
               showGroup = false;
            }

            if (this.hairSlider02[hid] != null) {
               this.hairSlider02[hid].visible = showTier1;
               this.hairSlider02[hid].x = guiLeft + 80 + 0 + pH * 45;
               this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
               if (this.hairSlider02[hid].isHoveredOrFocused()) {
                  var10000 = GuiHelper.cldgy;
                  hoverText = var10000 + cct(tir).getString() + " 1\n " + cct(rot).getString() + "\n " + cct(xax).getString() + ": " + x2;
                  this.drawDetails(gui, x, y, fontrenderer);
               }

               ++hid;
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = showTier1;
                  this.hairSlider02[hid].x = guiLeft + 80 + 7 + pH * 45;
                  this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
                  if (this.hairSlider02[hid].isHoveredOrFocused()) {
                     var10000 = GuiHelper.cldgy;
                     hoverText = var10000 + cct(tir).getString() + " 1\n " + cct(rot).getString() + "\n " + cct(yax).getString() + ": " + y2;
                     this.drawDetails(gui, x, y, fontrenderer);
                  }
               }

               ++hid;
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = showTier1;
                  this.hairSlider02[hid].x = guiLeft + 80 + 14 + pH * 45;
                  this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
                  if (this.hairSlider02[hid].isHoveredOrFocused()) {
                     var10000 = GuiHelper.cldgy;
                     hoverText = var10000 + cct(tir).getString() + " 1\n " + cct(rot).getString() + "\n " + cct(zax).getString() + ": " + z2;
                     this.drawDetails(gui, x, y, fontrenderer);
                  }
               }

               ++hid;
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = showTier1;
                  this.hairSlider02[hid].x = guiLeft + 80 + 21 + pH * 45;
                  this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
                  if (this.hairSlider02[hid].isHoveredOrFocused()) {
                     var10000 = GuiHelper.cldgy;
                     hoverText = var10000 + cct(tir).getString() + " 1\n " + cct(len).getString() + ": " + L2;
                     this.drawDetails(gui, x, y, fontrenderer);
                  }
               }

               hid += 4;
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = showTier2;
                  this.hairSlider02[hid].x = guiLeft + 80 + 0 + pH * 45;
                  this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
                  if (this.hairSlider02[hid].isHoveredOrFocused()) {
                     var10000 = GuiHelper.cldgy;
                     hoverText = var10000 + cct(tir).getString() + " 2\n " + cct(ben).getString() + ": " + b2;
                     this.drawDetails(gui, x, y, fontrenderer);
                  }
               }

               ++hid;
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = showTier2;
                  this.hairSlider02[hid].x = guiLeft + 80 + 7 + pH * 45;
                  this.hairSlider02[hid].y = guiTop + 5 + pV * 38;
                  if (this.hairSlider02[hid].isHoveredOrFocused()) {
                     var10000 = GuiHelper.cldgy;
                     hoverText = var10000 + cct(tir).getString() + " 2\n " + cct(bpo).getString() + ": " + p2;
                     this.drawDetails(gui, x, y, fontrenderer);
                  }
               }

               ++hid;
               ++hid;
               ++chid;
               ++pidh;
               if (pidh > 3) {
                  ++pidv;
               }

               pidh = pidh > 3 ? 0 : pidh;
            } else {
               hid += 10;
            }
         }
      }

      posestack.popMatrix();
   }

   public void changeDnsH(String newDnsh) {
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         h.setDNSH(newDnsh);
         Networking.sendToServer(new PacketData(newDnsh));
      });
      dnsH = newDnsh;
      dnsHSplittedBy2 = dnsH.split("(?<=\\G.{2})");
   }

   public void changeDnsHValue(int dnsHElementId, String newValue) {
      String newDnsH = "";
      int number = 0;
      String[] var5 = dnsHSplittedBy2;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String element = var5[var7];
         if (number == dnsHElementId) {
            newDnsH = newDnsH + newValue;
         } else {
            newDnsH = newDnsH + element;
         }

         ++number;
      }

      this.changeDnsH(newDnsH);
   }

   public static Component cct(String s1) {
      return Component.translatable("jrhc." + s1, new Object[0]);
   }

   public void hideModelPartButtonsOnAllPageExceptThis(int exceptThisPage) {
      for(int pageX = 1; pageX < 6; ++pageX) {
         int hid = this.hairModelPartIDPerPage[pageX - 1] * 10;

         for(int face = this.hairModelPartIDPerPage[pageX - 1]; face < this.hairModelPartIDPerPage[pageX]; ++face) {
            if (exceptThisPage != pageX - 1) {
               if (this.hairSlider02[hid] != null) {
                  this.hairSlider02[hid].visible = false;
                  ++hid;
                  if (this.hairSlider02[hid] != null) {
                     this.hairSlider02[hid].visible = false;
                  }

                  ++hid;
                  if (this.hairSlider02[hid] != null) {
                     this.hairSlider02[hid].visible = false;
                  }

                  ++hid;
                  if (this.hairSlider02[hid] != null) {
                     this.hairSlider02[hid].visible = false;
                  }

                  ++hid;
                  if (this.hairOButton02[face] != null) {
                     this.hairOButton02[face].visible = false;
                  }

                  ++hid;
                  if (this.hairXButton02[face] != null) {
                     this.hairXButton02[face].visible = false;
                  }

                  ++hid;
                  if (this.hairTierButton02[face] != null) {
                     this.hairTierButton02[face].visible = false;
                  }

                  ++hid;
                  if (this.hairSlider02[hid] != null) {
                     this.hairSlider02[hid].visible = false;
                  }

                  ++hid;
                  if (this.hairSlider02[hid] != null) {
                     this.hairSlider02[hid].visible = false;
                  }

                  ++hid;
                  ++hid;
               } else {
                  hid += 10;
               }
            }
         }
      }

   }

   public static int dnsHair1(String s, int n) {
      try {
         return s != null && s.length() > n - 1 ? Integer.parseInt(sa(s, n)) : 0;
      } catch (Exception var3) {
         return 0;
      }
   }

   public static String dnsHairG1toG2(String s) {
      String g2 = "";
      if (s.length() == 392) {
         for(int face = 0; face < 56; ++face) {
            int l = dnsHair1(s, face * 7) * 11 - 10;
            l = l < 0 ? 0 : l;
            int X = dnsHair2(s, face * 7 + 1);
            int Y = dnsHair2(s, face * 7 + 3);
            int Z = dnsHair2(s, face * 7 + 5);
            Object var10000 = l < 10 ? "0" + l : l;
            String L = String.valueOf(var10000).makeConcatWithConstants<invokedynamic>(String.valueOf(var10000));
            g2 = g2 + L + X + Y + Z + "505000";
         }

         g2 = g2 + "20";
      } else if (s.length() == 784) {
         g2 = s + "20";
      } else {
         g2 = s;
      }

      return g2;
   }

   public static void renderEntity(GuiGraphics p_282665_, int p_98851_, int p_98852_, int p_98853_, float p_98854_, float p_98855_, LivingEntity p_275689_) {
      int p_275535_ = p_98851_ + p_98853_ * 3;
      int p_301381_ = p_98852_ + p_98853_ * 3;
      p_282665_.pose().pushMatrix();
      p_282665_.enableScissor(p_98851_, p_98852_, p_275535_, p_301381_);
      float f2 = (float)Math.atan((double)(p_98854_ / 40.0F));
      float f3 = (float)Math.atan((double)(p_98855_ / 40.0F));
      Quaternionf quaternionf = Axis.ZP.rotationDegrees(180.0F);
      Quaternionf quaternionf1 = Axis.XP.rotationDegrees(f3 * 20.0F);
      float f4 = p_275689_.yBodyRot;
      float f5 = p_275689_.getYRot();
      float f6 = p_275689_.getXRot();
      float f7 = p_275689_.yHeadRotO;
      float f8 = p_275689_.yHeadRot;
      if (guiID >= 2 && guiID <= 6 && guiID == 6) {
         quaternionf1 = Axis.XP.rotationDegrees(-45.0F);
      }

      quaternionf.mul(quaternionf1);
      if (guiID >= 2 && guiID <= 6) {
         if (freeView) {
            p_275689_.setXRot(-f3 * 20.0F);
         } else {
            p_275689_.setXRot((float)pitch * 1.75F);
            f2 = (float)yaw / 5.5F;
         }

         switch(guiID) {
         case 3:
            p_275689_.yBodyRot = 90.0F;
            p_275689_.setYRot(90.0F + f2 * 40.0F);
            break;
         case 4:
            p_275689_.yBodyRot = 270.0F;
            p_275689_.setYRot(270.0F + f2 * 40.0F);
            break;
         case 5:
            p_275689_.yBodyRot = 0.0F;
            p_275689_.setYRot(0.0F - f2 * 40.0F);
            break;
         case 6:
            p_275689_.yBodyRot = 180.0F;
            p_275689_.setYRot(180.0F + f2 * 40.0F);
            break;
         default:
            p_275689_.yBodyRot = 180.0F;
            p_275689_.setYRot(180.0F + f2 * 40.0F);
         }

         p_275689_.yHeadRot = p_275689_.getYRot();
         p_275689_.yHeadRotO = p_275689_.getYRot();
      } else {
         p_275689_.yBodyRot = 180.0F + f2 * 20.0F;
         p_275689_.setYRot(180.0F + f2 * 40.0F);
         p_275689_.setXRot(-f3 * 20.0F);
         p_275689_.yHeadRot = p_275689_.getYRot();
         p_275689_.yHeadRotO = p_275689_.getYRot();
      }

      float f9 = p_275689_.getScale();
      Vector3f vector3f = new Vector3f(0.0F, p_275689_.getBbHeight() / 2.0F + 0.0625F * f9, 0.0F);
      float f10 = (float)p_98853_ / f9;
      renderEntityInInventory(p_282665_, p_98851_, p_98852_, p_275535_, p_301381_, f10, vector3f, quaternionf, quaternionf1, p_275689_);
      p_275689_.yBodyRot = f4;
      p_275689_.setYRot(f5);
      p_275689_.setXRot(f6);
      p_275689_.yHeadRotO = f7;
      p_275689_.yHeadRot = f8;
      p_282665_.disableScissor();
      p_282665_.pose().popMatrix();
   }

   public static void renderEntityInInventory(GuiGraphics p_282665_, int p_407731_, int p_410143_, int p_407838_, int p_406338_, float p_300023_, Vector3f p_298037_, Quaternionf p_281880_, @Nullable Quaternionf p_282882_, LivingEntity p_282466_) {
      EntityRenderDispatcher entityrenderdispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
      EntityRenderer<? super LivingEntity, ?> entityrenderer = entityrenderdispatcher.getRenderer(p_282466_);
      EntityRenderState entityrenderstate = entityrenderer.createRenderState(p_282466_, 1.0F);
      entityrenderstate.hitboxesRenderState = null;
      p_282665_.submitEntityRenderState(entityrenderstate, p_300023_, p_298037_, p_281880_, p_282882_, p_407731_, p_410143_, p_407838_, p_406338_);
   }

   public static void drawSpecial(Consumer<MultiBufferSource> p_367429_) {
      p_367429_.accept(Minecraft.getInstance().renderBuffers().bufferSource());
      Minecraft.getInstance().renderBuffers().bufferSource().endBatch();
   }

   public static void flush() {
      Minecraft.getInstance().renderBuffers().bufferSource().endBatch();
   }

   public boolean isPauseScreen() {
      return false;
   }

   public void urlOpenWithConfirm(String url) {
      this.clickedURI = URI.create(url);
      this.guiIDprev2 = guiID;
      Minecraft.getInstance().setScreen(new ConfirmLinkScreen((p_169232_) -> {
         if (p_169232_) {
            Util.getPlatform().openUri(url);
         }

         Minecraft.getInstance().setScreen(this);
      }, url, false));
   }

   public void confirmClicked(boolean p_73878_1_, int p_73878_2_) {
      if (p_73878_2_ == 0) {
         if (p_73878_1_) {
            this.URLOpener(this.clickedURI);
         }

         this.clickedURI = null;
         Minecraft.getInstance().setScreen(this);
      }

   }

   private void URLOpener(URI p_146407_1_) {
      try {
         Desktop.getDesktop().browse(p_146407_1_);
      } catch (Throwable var3) {
         LOGGER.error("Couldn't open link", var3);
      }

   }

   static {
      dnsHSplittedBy2 = dnsH.split("(?<=\\G.{2})");
      hoverText = "";
      defHairPrsts = new String[]{"008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500020", "345050555050801250505550501901505055505080235050455050803450505550508001505055505080015050555050802350505550508034505055505080125050555050800150505550508023505055505080015050555050800150505550506712505045505080015050455050800150504550508023505045505080345050455050801250504550508001505045505080235050455050800150504550508001505045505061015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050630155505050506701555050505061015550505050671170505050503814705050505041147050505050411770505050503817705050505041207050505050412070505050504117705050505041227050505050412570505050504125705050505041207050505050412070505050503225705050505041257050505050412270505050503420", dnsHairG1toG2("18080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080804808080180808018080801808080180808018080804808080180808018080801808080180808018080801808080180808018080801808080180808028080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080"), dnsHairG1toG2("33843554384754461805224154501455050143505014550501435050143505014350501435050050505505050550505055145505014350501455050145505014550501455050145505005050450505045050504515050501505050150505015050501475049147504914750501475050152505015250501525050152505005550501475050147505005550503631847363184726318522631850267194727218502701850270185027019501701850270185027018501505050150505015050501505050"), dnsHairG1toG2("08080180181919019191901819190505055050505505050550505055050505505050550505055050505505050550505055050504505050450505045050504505050450505045050504505050450505045050504505550504785050478505005550500555050474505047450500555050055505047150504715050055505005550500555050055505005550500325050425505042550500345050030505042350504235050038505003450504215050421505003450500695050419505041950500285050"), "225067556150391150675561502311503245615023205032456150361750505450507117505054505071175050545050711750505450507101505054505071025050545050710150505450507100505054505071005050545050710050505450507122505045505071225050455050722250504550507222505045505072015050455050720150504550507201505045505072005050455050720050504550507200505045505072225445505050712254475050507122545250505071225454505050710154455050507101544950505071015450505050710154545050507100545050505071005450505050710054505050507100545050505071005450505050710054505050507100545050505071005450505050712850505650507465505074801930655050251819303750504550507437505056505074685050748018326850502519183234505045505074345050565050746850507480183868505025181838345050455050743450505650507480505074801843805050251819433450504550507420", "025050545050210250505450501801505045505021025050475050180147507467503248505072675043255250726750360150505667501922475071675038255050716750380152507167503202475071675032025250716750300050507167503000505047655036205250276550362250502765503620475027655036225250306550363150503065503622475030655034015250276550250147502765503000505027655036175050505050803150505050508028505050505080225050505050801750505050508022505050505080255050505050801750505050508000505050505080005050505050800050505050508000505050505080005050505050800050505050508000505050505080005050505050803154508067504931545080615028285450766150472854506561506551525080675038655250806150786052507861503451525069615050625050806950528250508061503485505078615030625050696150585149508069506157495080615080624950786150805149506961504920", "011918215050000018192550500000191974505000011919785050001263505550500001565255505000346550555050001250505050500023505050505000125650505050003467505050500000505055505000005050555050000050505550500001505047505000346549455050000158504550500012675045505000346550495050000158504950500001525049505000005050455050000050504550500000505045505000016749505050000167504550500001675052505000016752505050000167505050500001675047505000016550525050000165505250500001565050505000015850525050000160504950500001555050505000341950505050003419505050500034195050505000341850505050002367505050500034675050505000346750505050003467505050500001675050505000346750505050003467505050500034675050505000016750475050003467505250500034675047505000346750505050003463505050500001635052505000016554525050000165494950500020", "405050525050002350505250500001505047505000345050475050003450505250500034505054505000345050525050003450505050500034505050505000345050525050000050505550500034525050505000005050555050000050505550500034505050505000345050475050003450504550500034505047505000005050455050003450504750500034505047505000005050455050003452505050500000505045505000345050505050003450505050500034505050505000345050505050003450505050500034505050505000345050505050003450505050500034505050505000345050505050003450505050500034505050505000345250525050003452505250500034525049505000345250495050000032505050500000255050505000002550505050000034505050500023345050505000233450505050000023505050500000385050505000237247505050002328805450500034345050505000343450505050003450505050500034345050505000343450505050003434505050500020", "373852546750347428545480193462285654801934283647478050340147507467501848505072675018255250726750183760656580501822475071675018255050716750189730327158501802475071675018973225673850189765616160501820414547655019545654216550195754542165501920475027655019943669346576193161503065231900475030655019406534276538199465393460501997654138655019976345453950189760494941501897615252415018976354563850189763494736501897614949395018976152523950189763525234501897584749395018976150493850189760545234501897585250415018885445474550189754475041501897545250435018885454523950185143607861501897415874585018514369196150185147768078391865525680565018974356806150188843567861501868396374615018975056805650189750568056501885582374615018975823726150187149568054501877495680565018774950785650189163236961501820", "742165287250008067344723505680673447305058001819181819000050505550500000505055505000005050555050000050505550500000505055505000005050555050000050505550500000505055505000005050555050000050505550500000505045505000005050455050000050504550500000505045505000005050455050000050504550500000505045505000005050455050000050504550500000505045505000005550505050000078505050500000765049505000005550505050000055505050500000744749505000007450495050000055505050500000555050505000007150495050000071504950500000555050505000005550505050000055504750500000545049505000005550505050000018495828506354195047302827541850473028270034505050500000305050505000601850503227285419504730500000385050505000003450505050000021504728304737185052302827003450505050000069505050500000195050505000001950505050000028505050500020", "653938673450217445386339501825743219635021173436636771187750501947503257505080475043575250184750362250345847501954475078475038345050784750386252508047503222475074475032345250764750300050507167503028505080475036605250194750367450501847503648505021475036625050214750364850502347503660475023475034485250234750252547502347503000505018505036748050525050808280505050508080805050505080808050495050809778505250508097785050505080977850495050809778504950508097785052505080977850505050809778505050508097785049505080005050505050800050505050508000505050505080005050505050804552501949504951545080495028575250185250474552508050506565545019495038855450184950786854501852503488525080505050715450284950528854508049503497525080505030945254805050588052502549506180525018495080855050185250808052508049504920", "775069556150391150675561502311503245615023775030456150364250505250507148505052505071655050525050717750505250507101505052505071025050525050710150505250507100505052505071015050525050710050505450507177505047505071655050475050724850504750507242505047505072015050455050720150504550507201505045505072015050455050720050504550507200505045505072115045505050711150475050507111505250505071115054505050712052504550507125545050435071255450504350712252505650507100545050505071655047506550716550525065507100545050505071005450505050715750435067507151505650675071005450505050712850505650507465505074801930655050251819303750504550507437505056505074685050748018326850502519183234505045505074345050565050746850507480183868505025181838345050455050743450505650507480505074801843805050251819433450504550507420", "005058605850214850635656502345503843585023005050475050184858506358503254545076505043375450724550362554507241501948565071395038375450724750382254507256503228585067715032225450695450302056506067503034545028365036455450273250364854502758503645545027385036225450303050363754502843503645585032655034255450276950253158503465503025565039655036606550507150806065605071508051654750715080426556507150803161505458508042565047635080346050476150803458504163508037585058385080406350562850804061505432508037605045325080315650563650803754505238508034585050395080315450494150803450547439504934525078395028425450183950473754672539506551545076395038515256803950784845717839503448496518395050485456803950526049722139503457437280395030574172803950586056508043506174564380585080885652255850806056522561504920", "114761546550196543615465501951383950695019203839508050195150807661501948478076615019514750766950192263566080501922475063675019255050636750191754506367501902525050675019746571655850190050507167501922347438185018205250321850182250503219501820475032195018225250301950183150503019501822475030195018743860384350180154505065501800505027655018175050505050193150505050501928505050505019225050505050191750505050501922505050505019255050505050191750505050501951544750365019915652503650199156475036501951545450365019485239503650195156475036501951565250385019515260503650197150507467501997505076675019514980747450197149807661501971475074675019974950766750195152807474501971528076615018605250805050197152507850501997505023525019975078253950196049508050501971495078505019974950235250199749212539501920", "226969185850003469741967500034526980745000177430196550003447496761500054494969635000375249675850002056496960500025474971585000314950716050004552497165500017475069675000205050696750000050505550500022504538675000144750285850002250502863500017504930605000175450326950002050503274500020505034695000085050285050000847502850500000505045505000146743503450001767435034500014675650365000146960504350001769414725500017674750345000176752503250001467605030500008714550505000087150505050000871505050500008715450505000005550505050000055505050500000555050505000005550505050006076504732500045214547255000452150473650003119504728500074785047345000687850473850005178435047500062785050435000827850473650009180504739500082784752435000978050524150003718505023500085195050385000318050504150002819505036500020", "008080185050000018191950500020672180805000001819195050002056508043502134545080435021205250804350210854508043502308545076455000205450784550002554507847500014545076415000005050555050000050505550500014505019565028225450215450002556502152500020545021565000175450216150002554502154500022545021545000005050455050002254502354500000505045505000017850505050002278505050500020785050505000117850505050000876505050500025745050505000347650505050002076505050500008765050505000257450505050003174505050500020765050505000007850505050002874505050500025745050505000007850505050004076505258500034785050635000258050505650001480475063501857765050585000577850505650004880505054500040765050525000517450505450006076505056500054785050525000487450505250003476505054500037765050525000517850505250002876505052500020", dnsHairG1toG2("28080253181949319197641919761635055261505535647613565058260505536050553585055050505505050550505055256504326050452675045163504536150452635045265504505050450505045050504535538601785050178505032356713564350374504927650503585650355505027152452715450355505015450541554750154545015452453235050425345032527503253656423304542336474183656419395813450501215050121505013450504695050419504931950501285050"), "825067555849188550675861501848503665325018345639416150187752525254501977505052545019775050525450197750505254501901505052545019015050525450190050505254501901505052545019015050525450190150505254501977545047545018775050475450187750504754501877524747545018005050475480180150504754801801505047548018015050475450180150504754501801505047545018775245504750187752475047501877525250475018775254504750180150505047501801504750475018015050504750180150505047501801505050475018015050504750180150505047501801505450475018015047504750180150475047501801505450475018015054504750180850505650506720505074801967015050718019672850504550506711505056505067255050748018670150506780186720505045505067115050565850672050507480186701805039801867115050455050671150505658506708505074801867085050748019671150504550506720", "657676216550006580713058500065213067585000654545476550005458546134500057808027185000008080805050000080808050500060807636235000828080306950003121493274191831307143235019977223285850003178692571500000808080505000008080721850005780807218500054585439345000311949697418008280217169500060802563255000977278725850003145713278501831808080505000546950783250009749255039500097497650395000546950213250006261455076500060635054655000606350476550006561565076500051584952715000682327766150006821742163500051411945305000548023236549008578608056520085784119565200541976786550005180673425500062787836215000628021617850005180346176500034807441275000601974431856006080275880410034192758805000542118382750006228193830450062281963695000542123607150005134186172500060674936745000626752652750005134183928500020", "542161287167197167324723691960673647495219001819181819005450504949721951505049546319175250495478190245564378326300505055505000005050565050000050505550500000505055505000005050565050000050471950500091653860363680375250526178186252505063781857505050638019943456616758190050504550500000505045505000005050455050000050504550500000505045505000605250503458006054505034580054545050345800545250503458196518415052786134526047711980425241542571804027616160807401636050807658011950495050000119504950500005563950505045001950505050000034676750500000343434505000003050505050000018495828506357195047302878541850473028780034505050500037656043505080601850503227805419504730508017674547505080572371606767804058504728305437185052302876542565493880763478306338657205544749505074014523495050743119653963607120", "605250725050218850507450501897505269505021484565715050187747508067503251505069675043255250726750364250505267501908475072675038315050806750382252504967503202475076675032025250476750300050507167503000505047655036025261496550362250506065503620475078655036085247526550362050502365503605475058655034005250276550250547502765503000505027655036175050505050803150505050508028505050505080225050505050801750505050508022505050505080255050505050801750505050508000505050505080005050505050800050505050508000505050505080005050505050800050505050508000505050505080005050505050803154508067504931545080615028285450766150472854506561506551525080675038655250806150786052507861503451525069615050625050806950528250508061503485505078615030625050696150585149508069506157495080615080624950786150805149506961504920", "574734557169802550504750501911524954495080575234453638808550545243568085505050326580975050544365809754655458808097505052385080975049504136809752655260458097525250386319975050504350809750475245506797523447608080945049504360809750475039508097505049435080975232496050809750505245508097545050415080975050454350809750504543508097505045475061975543496050809750455660508094545865615080976161616150809756434958508097584145565080976061585850809752545058508097554345585080975245476050809752544958508097525650615080975443475650639750495060506797546052545080974758455850671171505050503814705050505041512334456928673163505050503834675050505041576750635049492067505050504117675050505041486350505050412565505050504125675050505041206350505050417463546056544797565660545041976160635050419758475045473420", "515252215050182254504350501822545058505019515247785050187750501947503257505080475043575250184750362254507847501954475078475038345050784750386252508047503222475076475032345250784750300050507167503028525080475036605250194750367450501847503648505021475036625050194750364850502147503660475021475034485250234350252547502543503000505018505036748050525050808280505050508080805050505080808050495050808280505250508091805050505080918050495050808880504950508082805052505080828050505050808280505050508080805049505080005050505050800050505050508000505050505080005050505050804552501949504951545080495028575250185250474552508050506565545019495038855450184950786854501852503488525080505050715450284950528854508049503497525080505030945254805050588052502549506180525018495080855050185250808052508049504920", "255067496150804250654750501954505052505080255038506967475452435232438062526752695680654736553650807119412134383854453655364727605050553974806850505050508057454754505080605250526345801150414750506760504147633880624939457667805452364567508034523847505080625443476150803150414950508048525449505080485050477134632850435050508001416936505061255641435050803155504750508028555052505080457138305050802055454750508034554145505080205638455050802555454550508028555250505080315550475050804055505050508022553945505080205045495050632055414550506722554749505061224969505050676069475858473637434956744141342154807225413770677669323865655428395041207050505050412070505050504125675050505041543819256156415467563634384148675245395041487250637432415452564367413231675665505041454949545050413747654967503420", "975067555847479749676063502797473241655023975032436150369747495867506597474958675065974749586750659747495867506597494958673056974949586730569749495867305697494958673052974949586730529749495867304797505045635080975050456350809750504563508097505045635080975050456350769750504563507697505045635076975050456350729750504563507297505045635069976349493850329763494938503297635050385032976350503850329760505041503097605050415030976050504150309760505041503097585050415028975850504150289758505041502897585050415028975650503950259756505039502597565050395025975650503950259765496539501897675634395019976358343450189767496741501997715236415023976549654150199736193438504197615436415018977050504150309770505045503097705050545030977050505850309765506360501997655067605018976550343950189765503639501820", "173838653061281439525261304114618047393041173861363061280841182134502114411818655000114119217250002549475276710057525454655000405030524527001439411874500042505078415000255050784550000050505550500025495452257100114180217250001441191965500008411821345021143941187450004050305256270057544545655000255050215450004250502147500000505045505000146150185050001761501850500022615080505000176149805050002261501950500014615018505000206150805050001761508050500014675018505000176750185050002267508050500014675080505000148050183236002280501841360017805080323600228050804136001454508050500022565080505000205650185050001454501850500022545080505000285450805050002870188050500020701880505000225450805050002854508050500028545080505000205449805050001454508050500022545080505000225450805050001454508050500020", "005050545050210043525667502100434947675027005050475050180143507245502301565078455023015650805050230050505667501902585078455023345849764550232858507850502302565076505023005650765050230050507165503000505030655036016550195050210161502145502101635021455021016050215050213463502345502101615021455021005450235050210149502350502100545027655036487150565050803171505850508028695050505080317152415050801772545050508022695050505080257150505050801769504750508005715254505080147650505050801769505050508005724749505080005050505050800050505050508000505050505080005050505050802058501936504942603672675028255836767150474265603638345062676141415038602571493850506058692530503451584519615050605850803950526874415658396085583476695030686050784350582061508050566577636132385656626050804750805163507847504920", "424949524772180149495447721801495245477218424952474772189750305260781848507852741818974965525880189750675056801897502552617118485078527423189749695256801897503052588018975023526072189750255256801897503250568018975234495880184850234974181897506949607818975230495680184850234974231897507449617118975076496072189750694958801897507449568018974945505241189749475052411897495450524118974956505241189750475056411897504750564118975054505641189750545056411897524750584118975249505841189752525058411801525450584118975249505641189752495056411897525250564118975252505641180150505650501801505074801918015050251819180150504550501801505056505018975052238038180150502519181801505045505018015050565050180150507480181801505025181818015050455050180150505650501801505074801818015050251819180150504550501820", "174960726750005465254939500025722519694100146732217250003178474358500040784741615000258043416150002080434363501831694341325000347849396050003771283680500034764327395000118043455450000050505550500051186156585000281858606350005418565871503231785260695018511869748050003780617163500031805861615000088058585650002578587260500000505045505000377645504350006063521941500060635018415000427654504350003174455043500054655218395000546349193950003174545043501814724750435000716754195850006867471958500014725250435000226143493850005163475028500045615450285019176056502850004818414761500025283641605000543036415650004230364358500042184147585000681838495850007727384360500060303641585000607838496050008078385258500091743956565000852136495850006071396052500085744152615000746041725450008830323860500020", "512756547818392541525474502128364547715018284145477150214847507867503454505078675032575250786750392843476367501851475272675045514950726750386252497267503965475269568045574952716772362549507167503417475438745018625654276958394554522765503648525227655043575654236550184854542365501934525223655019515454256958212856522565501820545228655025485450742850308060508030502868605021325021425450233850285452507236503968605076345034806054253950253754502532503457545072365036606150743450306863542836503028525021275047255650713050342861507636503437635023255023345250253850434249548067505862495280695018514952765834304054508061503074525078675041805250806750457152491861503660524980615028745050786750438250508067504194505018615041685050806150327149527869504965475080675080744952186150278049528061503420", "005050545050216239505467501800505245562576005050475050188256506067191868565060671918545650606719182556506067191882585060671918685850606719185458506067191882605060671918686050606719188263506067191854565039651819685650396518196856503965181982565039651819685850396518196858503965181982585039651819686050396518198260503965181982635039651819516147473950186261525239501857615454388018946354544580188061505039501877585450415018976552493450188063504738541894584549395018945645494350189760525241501897585452415018975450494150189754504943501897545052435018915450524350182552347472501845523874695018455436807450184065307478181842524380675018685245806150186852398061501840523080615018345039808019185150398078181848543280781918345634807119189734193258501894674967585018976356363418189463523943501820", "745067545450393450675654502334503243565023655032475250360250505450507101505054505071684750505050717750505047507101505054505071015050545050710163655049507100505054505071005050545050710050505450507177495049495071574750495050722236504550507205505045505072025050455050720150504550507202505045505072005050455050720050504550507200505045505072605445455050719454525050507197545252505071605454545050712254454550507194544949505071975450525050711154545650507100545050505071005450505050710054505050507100545050505071005450505050710054505050507100545050505071005450505050712850505650507465505074801930655050251819303750504550507437505056505074655050215018326850502519183240505045505074345050565050746850507480183868505025181838345050455050744050505650507480505074801843805050251819433450504550507420", "204561547247396239565267381925454543671880254543436950192049506932503931495069415047515250673250413152505560503234505069432880455050672750803752496738503637505271635038455047716050272247507271503245505030505018405250236550194054502560502137565023585023345450256350234856502756502540585025565018315250286050254252502560502125565027455025255450745050272555507850501940565080415019405549214150192556457150502520584574505019425850784350194858521943501925564971505028205650765050213460508041501937585023435021315450724950232856507250501831585076505018406150194750182880504358502148805045495019687650474550195180524938501848805038585028578050415650386080525256451871806056305019458050396750616080504354503657806347561845608050495450414080504361503251805043585041687865435418545180504560503420", "015658607676250254585671183001416747398052025050475050230147507467503248505072675043255250726750360150505667507822475071675038255050716750380152507167503202475071675032015250716750300050507167503000505047655036205250276550362250502765503620475027655036225250306550363150503065503622475030655034015250276550250147502765503000505027655036175050505050803150505050508028505050505080225050505050801750505050508022505050505080255050505050801750505050508000505050505080005050505050800050505050508000505050505080005050505050800050505050508000505050505080005050505050803154508067504931545080615028285450766150472854506561506551525080675038655250806150786052507861503451525069615050625050806950528250508061503485505078615030625050696150585149508069506157495080615080624950786150805149506961504920", "485067556149454250675861502320503054415080205032436150187150505460501868505054615019485050546050189750505050501851505050505019515050505050185150505050501902505050505019015050505050180050505450507197495050505018545050457150187150504761501865505047615018545050506080185150505061801851505050638018315050505050192550505050501900505045505072285250504750232852505047502128525050475021285250504950218552505049502197525050495021975250504950219752505047652185505050505021885050505050218850505050502188505050505021005450505050710054505050507100545050505071005450505050711750505650507420505074801943015050718019612850504550502122505056505067255050748018430150506780186320505045505021225050565050712050507480183802505069281871115050455050192250505650506520505074801843015050694119612550504550502120"};
      defHairPrstsMadeBy = new String[]{"", "", "", "", "", "", "", "", "", "Tobin", "FunkerFankar", "Otaku (2)", "andrew0030 (3)", "CloseCaller101", "narukebaransu", "Acerz", "Acerz", "SSJameus", "GamingChica", "LadyBubblez", "KinToro", "Andryit", "RakuSaku", "Ryuho", "RakuSaku", "Lloso", "ErikArujo", "LeKebabGeek", "Snow Soulrose", "CrustBucket", "RaZGriZ", "Egroeg/George/DarianN1", "DbzPro64", "RaZGriZx86", "KillYamcha", "SaltyDesu"};
      MaxPresetNum = defHairPrsts.length - 1;
      PresetList = new ArrayList();
   }
}
