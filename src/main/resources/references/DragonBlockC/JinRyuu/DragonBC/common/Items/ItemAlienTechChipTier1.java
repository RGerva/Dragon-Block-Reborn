package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemAlienTechChipTier1 extends Item {
   public ItemAlienTechChipTier1() {
      this.func_77637_a(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void func_94581_a(IIconRegister iconRegister) {
      this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }
}
