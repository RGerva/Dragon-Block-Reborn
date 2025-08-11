package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHC;
import java.util.ArrayList;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

public class ItemDBCRenderRad implements IItemRenderer {
   protected String t;
   private int tick;
   private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
   private static final ResourceLocation RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
   private static final ResourceLocation RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
   ArrayList<double[]> dbs = new ArrayList();
   ArrayList<double[]> dbs2 = new ArrayList();
   private int db = 0;
   private static int gdb = 0;
   private int dbw = 0;
   public static int tc = 0;

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      switch(type) {
      case EQUIPPED:
         return false;
      case INVENTORY:
         return false;
      case ENTITY:
         return false;
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
      switch(type) {
      case EQUIPPED:
      case INVENTORY:
      case ENTITY:
      case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();
         float p_78440_1_ = 0.0625F;
         EntityClientPlayerMP entityclientplayermp = JRMCoreClient.mc.player;
         float f2 = entityclientplayermp.field_70127_C + (entityclientplayermp.rotationPitch - entityclientplayermp.field_70127_C) * p_78440_1_;
         float f13 = 0.8F;
         float f1 = 0.0F;
         GL11.glTranslatef(0.35F, -0.0F, -0.3F);
         float f5 = 1.0F - f2 / 45.0F + 0.1F;
         if (f5 < 0.0F) {
            f5 = 0.0F;
         }

         if (f5 > 1.0F) {
            f5 = 1.0F;
         }

         f5 = -MathHelper.func_76134_b(f5 * 3.1415927F) * 0.5F + 0.5F;
         GL11.glRotatef(f5 * -85.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.5F, 0.0F, -0.0F);
         this.renderItem();
         GL11.glPopMatrix();
      default:
      }
   }

   public void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.INSTANCE;
      tessellator.func_78382_b();
      double zLevel = 0.0D;
      tessellator.func_78374_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + p_73729_6_), zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
      tessellator.func_78374_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + p_73729_6_), zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
      tessellator.func_78374_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + 0), zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + 0) * f1));
      tessellator.func_78374_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + 0), zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + 0) * f1));
      tessellator.func_78381_a();
   }

   public void renderItem() {
      GL11.glPushMatrix();
      TextureManager texturemanager = JRMCoreClient.mc.func_110434_K();
      String wish = JRMCoreH.tjdbcAssts + ":radar.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(wish);
      int xSize = 166;
      int ySize = 166;
      int xMin = false;
      int yMin = false;
      texturemanager.bindTexture(tx);
      TextureUtil.func_152777_a(false, false, 1.0F);
      Tessellator tessellator = Tessellator.INSTANCE;
      float f = 0.0F;
      float f = (float)xSize / 256.0F;
      float f1 = 0.0F;
      float f2 = (float)ySize / 256.0F;
      float f3 = -0.9F;
      float f4 = -0.5F;
      GL11.glEnable(32826);
      GL11.glTranslatef(-f3 - 0.2F, -f4, 0.13F);
      float f5 = 0.75F;
      GL11.glScalef(f5, f5, f5);
      GL11.glRotatef(10.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.375F, 0.1625F, 0.0F);
      GL11.glPushMatrix();
      JRMCoreHC.ri(tessellator, f, f1, f, f2, xSize, ySize, 0.0625F);
      GL11.glPopMatrix();
      ++this.tick;
      if (this.tick > 80) {
         if (this.tick > 90) {
            this.tick = 0;
         }
      } else {
         this.DragonRadar(JRMCoreClient.mc.player);
      }

      GL11.glDisable(32826);
      texturemanager.bindTexture(tx);
      TextureUtil.func_147945_b();
      GL11.glPopMatrix();
      if (ItemDragonRadar.cld) {
         ItemDragonRadar.cld = false;
         tc = 50;
      }

      if (tc > 0) {
         --tc;
      }

      GL11.glPushMatrix();
      texturemanager = JRMCoreClient.mc.func_110434_K();
      wish = JRMCoreH.tjdbcAssts + ":radar.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      tx = new ResourceLocation(wish);
      xSize = 166;
      int ySize = 17;
      xMin = false;
      int yMin = 166;
      int yMax = 166 + ySize;
      texturemanager.bindTexture(tx);
      TextureUtil.func_152777_a(false, false, 1.0F);
      Tessellator tessellator = Tessellator.INSTANCE;
      f = 0.0F;
      f1 = (float)xSize / 256.0F;
      f2 = (float)yMin / 256.0F;
      f3 = (float)yMax / 256.0F;
      f4 = -0.9F;
      f5 = -1.16F + (float)tc * 5.0E-4F;
      GL11.glEnable(32826);
      GL11.glTranslatef(-f4 - 0.2F, -f5, 0.13F);
      float f6 = 0.75F;
      GL11.glScalef(f6, f6, f6);
      GL11.glRotatef(10.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.635F, 0.2F, 0.097F);
      GL11.glPushMatrix();
      f = (float)ySize / 128.0F;
      GL11.glScalef(1.0F, f, 1.0F);
      JRMCoreHC.ri(tessellator, f1, f2, f, f3, xSize, ySize, 0.06F);
      GL11.glPopMatrix();
      GL11.glDisable(32826);
      texturemanager.bindTexture(tx);
      TextureUtil.func_147945_b();
      GL11.glPopMatrix();
      EntityClientPlayerMP entityclientplayermp = JRMCoreClient.mc.player;
      JRMCoreClient.mc.func_110434_K().bindTexture(entityclientplayermp.func_110306_p());
      int j1 = false;
      GL11.glPushMatrix();
      GL11.glTranslatef(0.6F, 0.0F, 0.0F);
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-0.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.3F, -0.1F, -0.1F);
      j1 = true;
      j1 = true;
      Render render = RenderManager.field_78727_a.func_78713_a(entityclientplayermp);
      RenderPlayer renderplayer = (RenderPlayer)render;
      float f10 = 1.0F;
      GL11.glScalef(f10, f10, f10);
      renderplayer.func_82441_a(entityclientplayermp);
      GL11.glPopMatrix();
   }

   public void upd(EntityPlayer p) {
      if (p.field_71093_bK != this.dbw) {
         this.dbw = p.field_71093_bK;
         this.dbs.clear();
         this.dbs2.clear();
      }

      if (gdb >= 800) {
         gdb = 0;
         if (this.db == 0) {
            this.db = 1;
            this.dbs.clear();
         } else {
            this.db = 0;
            this.dbs2.clear();
         }
      }

      for(int j = 0; j < 16; ++j) {
         if (gdb % 50 == 0 && j == gdb / 50) {
            this.chk(p, j * 16 + 15, j * 16);
         }
      }

      ++gdb;
   }

   public void chk(EntityPlayer p, int x, int n) {
      int l1 = MathHelper.func_76128_c(p.posX);
      int i11 = MathHelper.func_76128_c(p.posZ);
      int m = 80;

      for(int j11 = l1 - m; j11 <= l1 + m; ++j11) {
         for(int j2 = i11 - m; j2 <= i11 + m; ++j2) {
            for(int k2 = x; k2 >= n; --k2) {
               if (p.world.func_147439_a(j11, k2, j2) == BlocksDBC.BlockDragonBall || p.world.func_147439_a(j11, k2, j2) == BlocksDBC.BlockNamekDragonBall) {
                  double[] d = new double[]{(double)j11, (double)j2};
                  this.dbs.add(d);
                  this.dbs2.add(d);
               }
            }
         }
      }

   }

   public void DragonRadar(EntityPlayer p) {
      this.upd(p);
      int pitch = 0;

      int i;
      for(i = 0; i < this.dbs.size(); ++i) {
         this.DragonDetect(((double[])this.dbs.get(i))[0] - p.posX, ((double[])this.dbs.get(i))[1] - p.posZ, (float)(pitch > 0 ? pitch : 0));
      }

      for(i = 0; i < this.dbs2.size(); ++i) {
         this.DragonDetect(((double[])this.dbs2.get(i))[0] - p.posX, ((double[])this.dbs2.get(i))[1] - p.posZ, (float)(pitch > 0 ? pitch : 0));
      }

   }

   public void DragonDetect(double x, double y, float f) {
      int guiLeft = 69;
      int guiTop = 92;
      String ic = "jinryuumodscore:icons.png";
      String ic2 = "jinryuudragonbc:icons3.png";
      if (x > -70.0D && x < 70.0D && y > -70.0D && y < 70.0D) {
         GL11.glPushMatrix();
         GL11.glEnable(3042);
         GL11.glDisable(2896);
         GL11.glTranslatef(-0.005F, -0.0025F, 0.0F);
         GL11.glTranslatef(0.567F, 0.44F, 0.0F);
         GL11.glRotatef(-JRMCoreClient.mc.player.field_70759_as - 180.0F, 0.0F, 0.0F, 1.0F);
         GL14.glBlendFuncSeparate(0, 1, 771, 0);
         GL11.glTranslatef(-0.567F, -0.44F, 0.0F);
         GL11.glTranslatef(0.0F, 0.0F, -0.065F);
         float f10 = 0.00609375F;
         GL11.glScalef(f10, f10, f10);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
         int xSize = 166;
         int ySize = 166;
         String var4 = "jinryuudragonbc:radarm.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation tx = new ResourceLocation(var4);
         JRMCoreClient.mc.field_71446_o.bindTexture(tx);
         this.drawTexturedModalRect(-166, -166, 0, 0, xSize, ySize);
         GL11.glBlendFunc(773, 772);
         JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
         GL11.glTranslatef(1.0F, -0.5F, -0.01F);
         int xSize = 8;
         int ySize = 8;
         var4 = "jinryuudragonbc:detect.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         tx = new ResourceLocation(var4);
         JRMCoreClient.mc.field_71446_o.bindTexture(tx);
         this.drawTexturedModalRect((int)((double)guiLeft + x) - 166, (int)((double)guiTop + y) - 166, 0, 0, xSize, ySize);
         JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }

   }
}
