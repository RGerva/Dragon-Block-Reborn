package jingames.jrhc.gui.buttons.type_c;

import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Color;
import jingames.jrhc.gui.screens.HairSalonScreen;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import jingames.jrhc.setup.helper.ARGB;
import jingames.jrhc.setup.network.Networking;
import jingames.jrhc.setup.network.PacketColors;
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

public abstract class AbstractWidgetC implements Renderable, GuiEventListener, LayoutElement, NarratableEntry {
   public static final ResourceLocation BUTTON_1 = ResourceLocation.tryBuild("jrhc", "textures/gui/button1.png");
   public static final ResourceLocation COLORS = ResourceLocation.tryBuild("jrhc", "textures/gui/colors.png");
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
   private int bgCol;
   public static final int UNSET_FG_COLOR = -1;
   protected int packedFGColor = -1;

   public int getBgCol() {
      return this.bgCol;
   }

   public AbstractWidgetC(int p_93629_, int p_93630_, int p_93631_, int p_93632_, Component p_93633_) {
      this.x = p_93629_;
      this.y = p_93630_;
      this.width = p_93631_;
      this.height = p_93632_;
      this.message = p_93633_;
   }

   public AbstractWidgetC(int p_93629_, int p_93630_, int p_93631_, int p_93632_, Component p_93633_, int bgColor) {
      this.x = p_93629_;
      this.y = p_93630_;
      this.width = p_93631_;
      this.height = p_93632_;
      this.message = p_93633_;
      this.bgCol = bgColor;
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
         Font var4 = minecraft.font;
         gui.blit(RenderPipelines.GUI_TEXTURED, COLORS, this.x, this.y, 0.0F, 0.0F, 128, 128, 256, 256);
         gui.fill(0, 0, 0, 0, 0);
         this.mouseMoved((double)p_93677_, (double)p_93678_);
         int var6 = ARGB.color(255, 224, 224, 224);
         if (!this.active) {
            var6 = ARGB.color(255, 95, 95, 96);
         } else if (this.isHoveredOrFocused()) {
            var6 = ARGB.color(255, 255, 255, 160);
         }

         gui.drawCenteredString(var4, this.message, this.x + this.width / 2, this.y + (this.height - 8) / 2, var6);
         p_93676_.popMatrix();
      }

   }

   protected void renderBg(PoseStack p_93661_, Minecraft p_93662_, int p_93663_, int p_93664_) {
   }

   public void onRelease(double p_93669_, double p_93670_) {
   }

   protected void onDrag(double p_93636_, double p_93637_, double p_93638_, double p_93639_) {
   }

   public boolean mouseClicked(double p_93641_, double p_93642_, int p_93643_) {
      if (this.active && this.visible) {
         if (this.isValidClickButton(p_93643_)) {
            boolean flag = this.clicked(p_93641_, p_93642_);
            if (flag) {
               int a = false;
               int i = this.x;
               int j = this.y;
               int mouseX = (int)p_93641_;
               int mouseY = (int)p_93642_;

               label30:
               for(int X = 0; X < 128; ++X) {
                  for(int Y = 0; Y < 128; ++Y) {
                     Color rgb = Color.getHSBColor((float)X * 2.0F / 255.0F, (float)Y * 2.0F / 255.0F, HairSalonScreen.BrightSelected);
                     int a = rgb.getRed() * 65536 + rgb.getGreen() * 256 + rgb.getBlue();
                     if (i + X == mouseX && j + Y == mouseY) {
                        Player player = Minecraft.getInstance().player;
                        player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
                           Networking.sendToServer(new PacketColors((float)rgb.getRed() / 255.0F, (float)rgb.getGreen() / 255.0F, (float)rgb.getBlue() / 255.0F));
                           int red = rgb.getRed();
                           int green = rgb.getGreen();
                           int blue = rgb.getBlue();
                           HairSalonScreen.ColorSelected = red * 65536 + green * 256 + blue;
                        });
                        break label30;
                     }
                  }
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
