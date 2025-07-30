package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.items.GiTurtleBase;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class GiTurtle extends GiTurtleBase {
   public GiTurtle(ArmorMaterial par2ArmorMaterial, int par3, int par4, String armornamePrefix) {
      super(par2ArmorMaterial, par3, par4, armornamePrefix);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
      this.modid = "jinryuudragonbc";
   }
}
