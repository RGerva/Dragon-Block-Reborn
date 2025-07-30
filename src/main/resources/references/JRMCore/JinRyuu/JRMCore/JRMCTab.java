package JinRyuu.JRMCore;

import JinRyuu.JRMCore.blocks.BlocksJRMC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JRMCTab extends CreativeTabs {
   public JRMCTab(String label) {
      super(label);
   }

   public ItemStack func_151244_d() {
      return new ItemStack(BlocksJRMC.BlockColoredStone);
   }

   @SideOnly(Side.CLIENT)
   public Item func_78016_d() {
      return Item.func_150898_a(BlocksJRMC.BlockColoredStone);
   }
}
