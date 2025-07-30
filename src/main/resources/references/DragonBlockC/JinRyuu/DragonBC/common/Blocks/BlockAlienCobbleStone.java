package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAlienCobbleStone extends Block {
   public BlockAlienCobbleStone() {
      super(Material.field_151576_e);
      this.func_149647_a(mod_DragonBC.DragonBlockC);
      this.func_149711_c(2.0F);
      this.func_149752_b(10.0F);
      this.func_149672_a(field_149769_e);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }
}
