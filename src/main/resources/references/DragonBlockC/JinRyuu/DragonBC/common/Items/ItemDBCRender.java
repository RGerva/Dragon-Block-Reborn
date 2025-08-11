package JinRyuu.DragonBC.common.Items;

import JinRyuu.JRMCore.JRMCoreClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class ItemDBCRender implements IItemRenderer {
   protected ItemKatanaModel model = new ItemKatanaModel();
   protected ItemKatanaModel2 model2 = new ItemKatanaModel2();
   protected String t;

   public ItemDBCRender(String type) {
      this.t = type;
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      switch(type) {
      case EQUIPPED:
         return true;
      case INVENTORY:
         return true;
      case ENTITY:
         return true;
      case EQUIPPED_FIRST_PERSON:
         return true;
      default:
         return false;
      }
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      float h1;
      float scale;
      float scl;
      switch(type) {
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();
         GL11.glDisable(2884);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
         h1 = 1.0F;
         scale = 1.0F;
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.8F, -0.75F, -0.0F);
         if (this.t.equals("Z")) {
            scl = 0.8F;
            GL11.glTranslatef(0.0F, 0.42999998F, -0.0F);
            GL11.glScalef(scl, scl, scl);
         }

         if (this.t.equals("Z")) {
            this.model2.render();
         } else {
            this.model.render(this.t);
         }

         GL11.glDisable(3042);
         GL11.glPopMatrix();
         break;
      case INVENTORY:
         GL11.glPushMatrix();
         h1 = 1.0F;
         scale = 10.0F;
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(1.1F, -0.4F, -0.0F);
         if (this.t.equals("Z")) {
            scl = 0.7F;
            GL11.glTranslatef(0.0F, 0.53F, -0.0F);
            GL11.glScalef(scl, scl, scl);
         }

         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
         if (this.t.equals("Z")) {
            this.model2.render();
         } else {
            this.model.render(this.t);
         }

         GL11.glDisable(3042);
         GL11.glPopMatrix();
         break;
      case ENTITY:
         GL11.glPushMatrix();
         GL11.glDisable(2884);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
         h1 = 1.0F;
         scale = 0.65F;
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.4F, -0.7F, -0.0F);
         if (this.t.equals("Z")) {
            scl = 0.8F;
            GL11.glTranslatef(0.0F, 0.42999998F, -0.0F);
            GL11.glScalef(scl, scl, scl);
         }

         if (this.t.equals("Z")) {
            this.model2.render();
         } else {
            this.model.render(this.t);
         }

         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }

   }
}
