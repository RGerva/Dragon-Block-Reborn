package JinRyuu.JRMCore.blocks;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BlockBarrierRender extends TileEntitySpecialRenderer {
   float visibility = 0.0F;
   int startedTick1 = 0;
   int startedTick2 = 0;

   public void renderAModelAt(BlockBarrierTileEntity tileentity, double d, double d1, double d2, float f) {
      if (this.inInRenderDistance(this.distanceFromBlock(d, d1, d2))) {
         if (this.visibility > 0.0F) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glPushMatrix();
            boolean view2 = JRMCoreClient.mc.field_71474_y.field_74320_O == 2;
            GL11.glRotatef(RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(RenderManager.field_78727_a.field_78732_j * (float)(view2 ? 1 : -1), 1.0F, 0.0F, 0.0F);
            ResourceLocation tx = new ResourceLocation(JRMCoreH.tjjrmc + ":textures/blocks/tile.BlockBarrier.png");
            this.func_147499_a(tx);
            float scale = 0.0038F;
            GL11.glScalef(scale, scale, scale);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, this.visibility);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glDisable(2896);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569F);
            int size = 256;
            this.drawTexturedModalRect((float)(-size) / 2.0F, (float)(-size) / 2.0F, 0, 0, (float)size, (float)size, 0.0F);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
         }

         if (JRMCoreClient.mc.field_71439_g.func_71045_bC() != null && JRMCoreClient.mc.field_71439_g.func_71045_bC().func_77977_a().equals("tile.BlockBarrier")) {
            this.startedTick1 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
            if (this.visibility < 1.0F) {
               this.visibility += (float)(JRMCoreClient.mc.field_71439_g.field_70173_aa - this.startedTick2) / 15.0F;
               this.startedTick2 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
            }

            if (this.visibility > 1.0F) {
               this.visibility = 1.0F;
            }
         } else {
            this.startedTick2 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
            if (this.visibility > 0.0F) {
               this.visibility -= (float)(JRMCoreClient.mc.field_71439_g.field_70173_aa - this.startedTick1) / 15.0F;
               this.startedTick1 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
            }

            if (this.visibility < 0.0F) {
               this.visibility = 0.0F;
            }
         }

      }
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((BlockBarrierTileEntity)tileentity, d, d1, d2, f);
   }

   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)x, (double)(y + 0.0F), (double)z, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78374_a((double)x, (double)(y + height), (double)z, (double)((float)(u + 0) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + height), (double)z, (double)(((float)u + width) * f), (double)(((float)v + height) * f1));
      tessellator.func_78374_a((double)(x + width), (double)(y + 0.0F), (double)z, (double)(((float)u + width) * f), (double)((float)(v + 0) * f1));
      tessellator.func_78381_a();
   }

   private double distanceFromBlock(double x, double y, double z) {
      double longest = 0.0D;
      if (x < 0.0D) {
         x *= -1.0D;
      }

      if (x > longest) {
         longest = x;
      }

      if (y < 0.0D) {
         y *= -1.0D;
      }

      if (y > longest) {
         longest = y;
      }

      if (z < 0.0D) {
         z *= -1.0D;
      }

      if (z > longest) {
         longest = z;
      }

      return longest;
   }

   private boolean inInRenderDistance(double distance) {
      if (JGConfigClientSettings.renderdistanceMultiplierBarrierBlock == 100) {
         return true;
      } else {
         double d1 = 64.0D;
         return distance < d1 * ((double)JGConfigClientSettings.renderdistanceMultiplierBarrierBlock / 100.0D);
      }
   }
}
