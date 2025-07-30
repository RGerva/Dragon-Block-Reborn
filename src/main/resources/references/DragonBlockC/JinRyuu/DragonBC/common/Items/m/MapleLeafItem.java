package JinRyuu.DragonBC.common.Items.m;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MapleLeafItem extends ItemBlock {
   public static final String[] leaves = new String[]{"Maple"};

   public MapleLeafItem(Block block) {
      super(block);
      this.func_77627_a(true);
   }

   public String func_77667_c(ItemStack itemstack) {
      int i = itemstack.func_77960_j();
      if (i < 0 || i >= leaves.length) {
         i = 0;
      }

      return super.func_77658_a() + "." + leaves[i];
   }

   public int func_77647_b(int meta) {
      return meta;
   }
}
