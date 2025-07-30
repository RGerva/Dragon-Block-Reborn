package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemWeight extends JinRyuu.JRMCore.items.ItemWeight {
   public ItemWeight(int weight) {
      super(weight);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister par1IconRegister) {
      this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }
}
