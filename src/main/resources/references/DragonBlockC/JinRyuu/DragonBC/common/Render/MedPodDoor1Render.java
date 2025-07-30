package JinRyuu.DragonBC.common.Render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class MedPodDoor1Render extends TileEntitySpecialRenderer {
   private int moving = 0;
   private MedPodDoor1Model aModel = new MedPodDoor1Model();

   public void renderAModelAt(MedPodDoor1TileEntity tileentity, double d, double d1, double d2, float f) {
      String renderMode = "";
      boolean hasAbove = tileentity.func_145831_w().func_147439_a(tileentity.field_145851_c, tileentity.field_145848_d + 1, tileentity.field_145849_e) instanceof MedPodDoor1Block;
      boolean hasBelow = tileentity.func_145831_w().func_147439_a(tileentity.field_145851_c, tileentity.field_145848_d - 1, tileentity.field_145849_e) instanceof MedPodDoor1Block;
      if (hasAbove && hasBelow) {
         renderMode = "d";
      } else if (hasAbove) {
         renderMode = "c";
      } else if (hasBelow) {
         renderMode = "b";
      }

      GL11.glPushMatrix();
      Block b = tileentity.func_145838_q();
      int meta = tileentity.func_145832_p();
      if (meta != 3 && meta != 7) {
         if (meta != 1 && meta != 5) {
            if (meta != 0 && meta != 4) {
               if (meta == 2 || meta == 6) {
                  GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.625F);
                  GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
               }
            } else {
               GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.375F);
               GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
            }
         } else {
            GL11.glTranslatef((float)d + 0.625F, (float)d1 + 1.0F, (float)d2 + 0.5F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
         }
      } else {
         GL11.glTranslatef((float)d + 0.375F, (float)d1 + 1.0F, (float)d2 + 0.5F);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation("jinryuudragonbc:textures/blockmodels/MedPodDoor1" + renderMode + ".png");
      this.func_147499_a(tx);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      this.aModel.renderModel(tileentity.getCb(), meta, 0.0625F);
      GL11.glPopMatrix();
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((MedPodDoor1TileEntity)tileentity, d, d1, d2, f);
   }
}
