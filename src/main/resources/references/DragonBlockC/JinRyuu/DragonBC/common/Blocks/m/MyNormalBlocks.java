package JinRyuu.DragonBC.common.Blocks.m;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MyNormalBlocks extends Block {
   protected MyNormalBlocks(String unlocalizedName, Material material) {
      super(material);
      this.func_149663_c(unlocalizedName);
      this.func_149658_d(JRMCoreH.tjdbcAssts + ":" + unlocalizedName);
      this.func_149647_a(mod_DragonBC.DragonBlockC);
      this.func_149711_c(2.0F);
      this.func_149752_b(10.0F);
      this.setHarvestLevel("pickaxe", 1);
      this.func_149672_a(field_149769_e);
   }
}
