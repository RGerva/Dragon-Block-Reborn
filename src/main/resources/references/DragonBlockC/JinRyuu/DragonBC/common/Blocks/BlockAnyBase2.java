package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAnyBase2 extends Block {
   public BlockAnyBase2() {
      this(0);
   }

   public BlockAnyBase2(int harvestlevel) {
      super(Material.field_151576_e);
      this.func_149672_a(field_149780_i);
      this.func_149647_a(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister par1IconRegister) {
      this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_149739_a().replaceAll("tile.", ""));
   }
}
