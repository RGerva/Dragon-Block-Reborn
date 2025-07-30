package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class ItemToolPickaxe extends ItemPickaxe {
   public ItemToolPickaxe(ToolMaterial tm) {
      super(tm);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister par1IconRegister) {
      this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a().replaceAll("item.", ""));
   }
}
