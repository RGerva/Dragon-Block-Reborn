package jingames.jrhc.gui.buttons.type_A1;

import java.util.function.Consumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import org.joml.Matrix3x2fStack;

public class ButtonA1 extends AbstractWidgetA1 {
   public static final ButtonA1.OnTooltip NO_TOOLTIP = (p_93740_, p_93741_, p_93742_, p_93743_) -> {
   };
   protected final ButtonA1.OnPress onPress;
   protected final ButtonA1.OnTooltip onTooltip;

   public ButtonA1(int p_93721_, int p_93722_, int p_93723_, int p_93724_, Component p_93725_, ButtonA1.OnPress p_93726_) {
      this(p_93721_, p_93722_, p_93723_, p_93724_, p_93725_, p_93726_, NO_TOOLTIP);
   }

   public ButtonA1(int p_93728_, int p_93729_, int p_93730_, int p_93731_, Component p_93732_, ButtonA1.OnPress p_93733_, ButtonA1.OnTooltip p_93734_) {
      super(p_93728_, p_93729_, p_93730_, p_93731_, p_93732_);
      this.onPress = p_93733_;
      this.onTooltip = p_93734_;
   }

   public void onPress() {
      this.onPress.onPress(this);
   }

   public void renderButton(GuiGraphics p_93746_, int p_93747_, int p_93748_, float p_93749_) {
      super.renderButton(p_93746_, p_93747_, p_93748_, p_93749_);
      if (this.isHoveredOrFocused()) {
         this.renderToolTip(p_93746_.pose(), p_93747_, p_93748_);
      }

   }

   public void renderToolTip(Matrix3x2fStack p_93736_, int p_93737_, int p_93738_) {
      this.onTooltip.onTooltip(this, p_93736_, p_93737_, p_93738_);
   }

   public void updateNarration(NarrationElementOutput p_168838_) {
      this.defaultButtonNarrationText(p_168838_);
      this.onTooltip.narrateTooltip((p_168841_) -> {
         p_168838_.add(NarratedElementType.HINT, p_168841_);
      });
   }

   public void setX(int p_265236_) {
      this.x = p_265236_;
   }

   public void setY(int p_265404_) {
      this.y = p_265404_;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public void visitWidgets(Consumer<AbstractWidget> p_265082_) {
   }

   public interface OnTooltip {
      void onTooltip(ButtonA1 var1, Matrix3x2fStack var2, int var3, int var4);

      default void narrateTooltip(Consumer<Component> p_168842_) {
      }
   }

   public interface OnPress {
      void onPress(ButtonA1 var1);
   }
}
