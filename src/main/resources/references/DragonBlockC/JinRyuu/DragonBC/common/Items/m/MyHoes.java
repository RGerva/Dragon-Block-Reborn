/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemHoe;
/*    */ 
/*    */ public class MyHoes extends ItemHoe {
/*    */   public MyHoes(String unlocalizedName, Item.ToolMaterial material) {
/* 10 */     super(material);
/* 11 */     func_77655_b(unlocalizedName);
/* 12 */     func_111206_d(JRMCoreH.tjdbcAssts + ":" + unlocalizedName);
/* 13 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\MyHoes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */