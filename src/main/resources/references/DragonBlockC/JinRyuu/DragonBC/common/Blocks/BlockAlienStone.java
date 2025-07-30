package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockAlienStone extends Block {
   public BlockAlienStone() {
      super(Material.field_151576_e);
      this.func_149647_a(mod_DragonBC.DragonBlockC);
      this.func_149711_c(1.5F);
      this.func_149752_b(10.0F);
      this.func_149672_a(field_149769_e);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(BlocksDBC.BlockAlienCobbleStone);
   }
}
