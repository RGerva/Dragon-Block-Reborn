/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ 
/*    */ public class ItemToolPickaxe
/*    */   extends ItemPickaxe {
/*    */   public ItemToolPickaxe(Item.ToolMaterial tm) {
/* 13 */     super(tm);
/* 14 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 19 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemToolPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */