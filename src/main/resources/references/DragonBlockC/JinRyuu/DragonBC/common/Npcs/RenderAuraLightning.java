/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderAuraLightning
/*    */   extends RenderDBC
/*    */ {
/*    */   private ModelLightning aModel;
/*    */   
/*    */   public RenderAuraLightning() {
/* 22 */     super((ModelBase)new ModelLightning(), 0.5F);
/* 23 */     this.aModel = new ModelLightning();
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAuraLightning(EntityAuraLightning par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 28 */     this.field_76989_e = 0.0F;
/* 29 */     GL11.glPushMatrix();
/* 30 */     GL11.glPushMatrix();
/*    */     
/* 32 */     float var13 = handleRotationFloat(par1Entity, par9);
/* 33 */     float size = handleSizeFloat(par1Entity, par9);
/*    */     
/* 35 */     Random rand = new Random();
/* 36 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/* 37 */     float var20 = 2.0F;
/*    */     
/* 39 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 1.6F, (float)par6 + 0.0F);
/* 40 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 42 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
/* 43 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:lightning.png");
/* 44 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 45 */     GL11.glDepthMask(false);
/* 46 */     GL11.glEnable(3042);
/* 47 */     GL11.glBlendFunc(770, 771);
/* 48 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 49 */     GL11.glScalef(var20, var20, var20);
/* 50 */     this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
/* 51 */     GL11.glDisable(3042);
/* 52 */     GL11.glAlphaFunc(516, 0.1F);
/* 53 */     GL11.glPopMatrix();
/* 54 */     GL11.glDepthMask(true);
/* 55 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 61 */     return par1Entity.field_70173_aa + par2;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float handleSizeFloat(Entity par1Entity, float par2) {
/* 66 */     float ticksExsisted = (par1Entity.field_70173_aa + par2) / 2.0F;
/* 67 */     return ticksExsisted;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 91 */     renderAuraLightning((EntityAuraLightning)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderAuraLightning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */