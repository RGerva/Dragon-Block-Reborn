package JinRyuu.DragonBC.common.Items;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class ItemDBCRender1 implements IItemRenderer {
   protected ItemDBCModel1 model = new ItemDBCModel1();

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
      switch(type) {
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
         h1 = 1.0F;
         scale = 0.3F;
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-2.5F, 0.2F, -0.2F);
         this.model.render();
         GL11.glDisable(3042);
         GL11.glPopMatrix();
         break;
      case INVENTORY:
         GL11.glPushMatrix();
         h1 = 1.0F;
         scale = 2.5F;
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(4.5F, 2.2F, 0.0F);
         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
         this.model.render();
         GL11.glDisable(3042);
         GL11.glPopMatrix();
         break;
      case ENTITY:
         GL11.glPushMatrix();
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         JRMCoreClient.mc.field_71446_o.bindTexture(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
         h1 = 1.0F;
         scale = 0.2F;
         GL11.glScalef(scale, scale, scale);
         GL11.glColor3f(h1, h1, h1);
         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-1.4F, 1.0F, -0.2F);
         this.model.render();
         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }

   }
}
