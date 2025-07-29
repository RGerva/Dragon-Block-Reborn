/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMasterGohan
/*    */   extends EntityDBCKami {
/* 13 */   public final int HePo = 100000;
/*    */ 
/*    */   
/*    */   public EntityMasterGohan(World par1World) {
/* 17 */     super(par1World);
/* 18 */     this.name = "Master Gohan";
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 22 */     super.func_110147_ax();
/* 23 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 28 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 29 */     boolean var3 = (var2 != null);
/*    */     
/* 31 */     if (func_70089_S()) {
/*    */       
/* 33 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 22, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 34 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 38 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 47 */     return "jinryuudragonbc:npcs/gohan1.png";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 58 */     super.func_70071_h_();
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterGohan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */