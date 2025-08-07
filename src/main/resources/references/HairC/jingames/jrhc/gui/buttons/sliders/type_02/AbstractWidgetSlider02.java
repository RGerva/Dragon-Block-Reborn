package jingames.jrhc.gui.buttons.sliders.type_02;

import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Color;
import jingames.jrhc.gui.screens.HairSalonScreen;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import jingames.jrhc.setup.helper.ARGB;
import jingames.jrhc.setup.network.Networking;
import jingames.jrhc.setup.network.PacketData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.narration.NarratableEntry.NarrationPriority;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix3x2fStack;

public abstract class AbstractWidgetSlider02 implements Renderable, GuiEventListener, LayoutElement, NarratableEntry {
   public static final ResourceLocation BUTTON_1 = ResourceLocation.tryBuild("jrhc", "textures/gui/button1.png");
   protected int width;
   protected int height;
   public int x;
   public int y;
   private Component message;
   protected boolean isHovered;
   public boolean active = true;
   public boolean visible = true;
   protected float alpha = 1.0F;
   private boolean focused;
   public float sliderValue = 1.0F;
   public float sliderMaxValue = 1.0F;
   public boolean dragging = false;
   public String label;
   private int col;
   public int id = -1;
   public static final int UNSET_FG_COLOR = -1;
   protected int packedFGColor = -1;

   public AbstractWidgetSlider02(int p_93629_, int p_93630_, int p_93631_, int p_93632_, Component label, float startingValue, float maxValue, int c) {
      this.x = p_93629_;
      this.y = p_93630_;
      this.width = p_93631_;
      this.height = p_93632_;
      this.message = label;
      this.col = c;
   }

   public AbstractWidgetSlider02(int p_93629_, int p_93630_, int p_93631_, int p_93632_, Component label, float startingValue, float maxValue) {
      this.x = p_93629_;
      this.y = p_93630_;
      this.width = p_93631_;
      this.height = p_93632_;
      this.message = label;
      this.label = label.getString();
      this.sliderValue = startingValue;
      this.sliderMaxValue = maxValue;
   }

   public AbstractWidgetSlider02(int p_93629_, int p_93630_, int p_93631_, int p_93632_, Component label, float startingValue, float maxValue, int c, int id) {
      this.x = p_93629_;
      this.y = p_93630_;
      this.width = p_93631_;
      this.height = p_93632_;
      this.message = label;
      this.label = label.getString();
      this.col = c;
      this.sliderValue = startingValue;
      this.sliderMaxValue = maxValue;
      this.id = id;
   }

   public int getHeight() {
      return this.height;
   }

   protected int getYImage(boolean p_93668_) {
      int i = 1;
      if (!this.active) {
         i = 0;
      } else if (p_93668_) {
         i = 2;
      }

      return i;
   }

   public void render(GuiGraphics p_93657_, int p_93658_, int p_93659_, float p_93660_) {
      if (this.visible) {
         this.isHovered = p_93658_ >= this.x && p_93659_ >= this.y && p_93658_ < this.x + this.width && p_93659_ < this.y + this.height;
         this.renderButton(p_93657_, p_93658_, p_93659_, p_93660_);
      }

   }

   protected MutableComponent createNarrationMessage() {
      return wrapDefaultNarrationMessage(this.getMessage());
   }

   public static MutableComponent wrapDefaultNarrationMessage(Component p_168800_) {
      return Component.translatable("gui.narrate.button", new Object[]{p_168800_});
   }

   public void renderButton(GuiGraphics gui, int p_93677_, int p_93678_, float p_93679_) {
      if (this.visible) {
         Matrix3x2fStack p_93676_ = gui.pose();
         p_93676_.pushMatrix();
         Minecraft minecraft = Minecraft.getInstance();
         Font fontrenderer = minecraft.font;
         int k = 0;
         int l;
         if (this.col != 0) {
            l = this.col;
            float h2 = (float)(l >> 16 & 255) / 255.0F;
            float h3 = (float)(l >> 8 & 255) / 255.0F;
            float h4 = (float)(l & 255) / 255.0F;
            float h1 = 1.0F;
            if (k == 2) {
               int r = (int)(h2 * 254.0F);
               int g = (int)(h3 * 254.0F);
               int b = (int)(h4 * 254.0F);
               float[] hsb = Color.RGBtoHSB(r, g, b, (float[])null);
               float hue = hsb[0];
               float saturation = 0.33F;
               float brightness = hsb[2];
               int rgb = Color.HSBtoRGB(hue, saturation, brightness);
               h2 = (float)(rgb >> 16 & 255) / 255.0F;
               h3 = (float)(rgb >> 8 & 255) / 255.0F;
               h4 = (float)(rgb & 255) / 255.0F;
            }

            System.out.println(123);
         }

         gui.blit(RenderPipelines.GUI_TEXTURED, BUTTON_1, this.x, this.y, 241.0F, 159.0F, this.width, this.height, 256, 256);
         gui.fill(0, 0, 0, 0, 0);
         l = ARGB.color(255, 224, 224, 224);
         if (!this.active) {
            l = ARGB.color(255, 95, 95, 96);
         } else if (this.isHoveredOrFocused()) {
            l = ARGB.color(255, 255, 255, 160);
         }

         gui.blit(RenderPipelines.GUI_TEXTURED, BUTTON_1, this.x, this.y + (int)(this.sliderValue * (float)this.height), 241.0F, 155.0F, this.width / 2, 2, 256, 256);
         gui.fill(0, 0, 0, 0, 0);
         gui.blit(RenderPipelines.GUI_TEXTURED, BUTTON_1, this.x + 2, this.y + (int)(this.sliderValue * (float)this.height), (float)(256 - (this.width - this.width / 2)), 155.0F, this.width - this.width / 2, 2, 256, 256);
         gui.fill(0, 0, 0, 0, 0);
         gui.drawCenteredString(fontrenderer, this.message, this.x + this.width / 2, this.y + (this.height - 8) / 2, l);
         p_93676_.popMatrix();
      }

   }

   protected void renderBg(PoseStack p_93661_, Minecraft p_93662_, int p_93663_, int p_93664_) {
   }

   public void onRelease(double p_93669_, double p_93670_) {
      this.dragging = false;
   }

   protected void onDrag(double p_93636_, double p_93637_, double xpos, double ypos) {
      if (this.visible) {
      }

   }

   public boolean mouseClicked(double p_93641_, double p_93642_, int p_93643_) {
      if (this.active && this.visible) {
         if (this.isValidClickButton(p_93643_)) {
            boolean flag = this.clicked(p_93641_, p_93642_);
            if (flag) {
               this.sliderValue = (float)(p_93642_ - (double)this.y) / (float)this.height;
               if (this.sliderValue < 0.0F) {
                  this.sliderValue = 0.0F;
               }

               if (this.sliderValue > 1.0F) {
                  this.sliderValue = 1.0F;
               }

               this.dragging = true;
               if (this.id != -1 && this.visible) {
                  float T = this.sliderValue / 0.01F;
                  int T2 = (int)(T / 1.56F) + 18;
                  String newpart = "";
                  if (this.id != 0 && this.id % 7 != 0) {
                     T2 = T2 > 82 ? 82 : (T2 < 18 ? 18 : T2);
                     newpart = String.valueOf(T2);
                  } else {
                     T2 = (int)T;
                     T2 = T2 > 97 ? 97 : (T2 < 1 ? 1 : T2);
                     newpart = T2 < 10 ? "0" + T2 : String.valueOf(T2);
                  }

                  this.changeDnsHValue(this.id, newpart);
               }

               this.playDownSound(Minecraft.getInstance().getSoundManager());
               this.onClick(p_93641_, p_93642_);
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void changeDnsHValue(int dnsHElementId, String newValue) {
      String newDnsH = "";
      int number = 0;
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         HairSalonScreen.dnsH = h.getDNSH();
      });
      HairSalonScreen.dnsHSplittedBy2 = HairSalonScreen.dnsH.split("(?<=\\G.{2})");
      String[] var6 = HairSalonScreen.dnsHSplittedBy2;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         String element = var6[var8];
         if (number == dnsHElementId) {
            newDnsH = newDnsH + newValue;
         } else {
            newDnsH = newDnsH + element;
         }

         ++number;
      }

      this.changeDnsH(newDnsH);
   }

   public void changeDnsH(String newDnsh) {
      Player player = Minecraft.getInstance().player;
      player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
         Networking.sendToServer(new PacketData(newDnsh));
         h.setDNSH(newDnsh);
      });
      HairSalonScreen.dnsH = newDnsh;
      HairSalonScreen.dnsHSplittedBy2 = HairSalonScreen.dnsH.split("(?<=\\G.{2})");
   }

   public boolean mouseReleased(double p_93684_, double p_93685_, int p_93686_) {
      if (this.isValidClickButton(p_93686_)) {
         this.onRelease(p_93684_, p_93685_);
         return true;
      } else {
         return false;
      }
   }

   protected boolean isValidClickButton(int p_93652_) {
      return p_93652_ == 0;
   }

   public boolean mouseDragged(double p_93645_, double p_93646_, int p_93647_, double p_93648_, double p_93649_) {
      if (this.isValidClickButton(p_93647_)) {
         this.onDrag(p_93645_, p_93646_, p_93648_, p_93649_);
         return true;
      } else {
         return false;
      }
   }

   protected boolean clicked(double p_93681_, double p_93682_) {
      return this.active && this.visible && p_93681_ >= (double)this.x && p_93682_ >= (double)this.y && p_93681_ < (double)(this.x + this.width) && p_93682_ < (double)(this.y + this.height);
   }

   public boolean isHoveredOrFocused() {
      return this.isHovered || this.focused;
   }

   public boolean changeFocus(boolean p_93691_) {
      if (this.active && this.visible) {
         this.focused = !this.focused;
         this.onFocusedChanged(this.focused);
         return this.focused;
      } else {
         return false;
      }
   }

   protected void onFocusedChanged(boolean p_93689_) {
   }

   public boolean isMouseOver(double p_93672_, double p_93673_) {
      return this.active && this.visible && p_93672_ >= (double)this.x && p_93673_ >= (double)this.y && p_93672_ < (double)(this.x + this.width) && p_93673_ < (double)(this.y + this.height);
   }

   public void renderToolTip(PoseStack p_93653_, int p_93654_, int p_93655_) {
   }

   public void playDownSound(SoundManager p_93665_) {
      p_93665_.play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int p_93675_) {
      this.width = p_93675_;
   }

   public void setHeight(int value) {
      this.height = value;
   }

   public void setAlpha(float p_93651_) {
      this.alpha = p_93651_;
   }

   public void setMessage(Component p_93667_) {
      this.message = p_93667_;
   }

   public Component getMessage() {
      return this.message;
   }

   public boolean isFocused() {
      return this.focused;
   }

   public boolean isActive() {
      return this.visible && this.active;
   }

   public void setFocused(boolean p_93693_) {
      this.focused = p_93693_;
   }

   public int getFGColor() {
      if (this.packedFGColor != -1) {
         return this.packedFGColor;
      } else {
         return this.active ? 16777215 : 10526880;
      }
   }

   public void setFGColor(int color) {
      this.packedFGColor = color;
   }

   public void clearFGColor() {
      this.packedFGColor = -1;
   }

   public NarrationPriority narrationPriority() {
      if (this.focused) {
         return NarrationPriority.FOCUSED;
      } else {
         return this.isHovered ? NarrationPriority.HOVERED : NarrationPriority.NONE;
      }
   }

   protected void defaultButtonNarrationText(NarrationElementOutput p_168803_) {
      p_168803_.add(NarratedElementType.TITLE, this.createNarrationMessage());
      if (this.active) {
         if (this.isFocused()) {
            p_168803_.add(NarratedElementType.USAGE, Component.translatable("narration.button.usage.focused"));
         } else {
            p_168803_.add(NarratedElementType.USAGE, Component.translatable("narration.button.usage.hovered"));
         }
      }

   }

   public boolean keyPressed(int p_93374_, int p_93375_, int p_93376_) {
      if (this.active && this.visible) {
         if (p_93374_ != 257 && p_93374_ != 32 && p_93374_ != 335) {
            return false;
         } else {
            this.playDownSound(Minecraft.getInstance().getSoundManager());
            this.onPress();
            return true;
         }
      } else {
         return false;
      }
   }

   public abstract void onPress();

   public void onClick(double p_93371_, double p_93372_) {
      this.onPress();
   }

   public ScreenRectangle getRectangle() {
      return super.getRectangle();
   }
}
