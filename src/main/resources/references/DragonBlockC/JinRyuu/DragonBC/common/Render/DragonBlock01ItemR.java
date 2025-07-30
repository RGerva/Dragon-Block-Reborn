package JinRyuu.DragonBC.common.Render;

import JinRyuu.JRMCore.JRMCoreClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class DragonBlock01ItemR implements IItemRenderer {
   private DragonBlock01Model aModel = new DragonBlock01Model();
   private float t;

   public DragonBlock01ItemR(float t) {
      this.t = t;
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return type != ItemRenderType.INVENTORY;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      GL11.glPushMatrix();
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:dragon_ball.png");
      JRMCoreClient.mc.func_110434_K().func_110577_a(tx);
      GL11.glScalef(this.t, this.t, this.t);
      GL11.glTranslatef((type == ItemRenderType.ENTITY ? 0.1F : 0.5F) + -0.08F * this.t, -0.9F - 0.1F * this.t, 0.0F);
      if (type == ItemRenderType.INVENTORY) {
         GL11.glTranslatef(7.0F - (this.t - 1.0F) * 3.0F, -15.5F - (this.t - 1.0F) * 2.0F, 0.0F);
         GL11.glScalef(17.0F, 17.0F, 17.0F);
      }

      float h1 = 1.0F;
      GL11.glColor3f(h1, h1, h1);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2884);
      this.aModel.render();
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }
}
