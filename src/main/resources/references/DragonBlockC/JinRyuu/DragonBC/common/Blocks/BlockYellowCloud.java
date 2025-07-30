package JinRyuu.DragonBC.common.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockYellowCloud extends Block {
   public BlockYellowCloud() {
      super(Material.field_151596_z);
      this.func_149711_c(0.1F);
      this.func_149752_b(10.0F);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public int func_149701_w() {
      return 0;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149678_a(int par1, boolean par2) {
      return false;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public boolean func_149747_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister par1IconRegister) {
      this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_149739_a());
   }

   public int idDropped(int par1, Random par2Random, int par3) {
      return 0;
   }
}
