package JinRyuu.DragonBC.common.Blocks.m;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MySlabs extends BlockSlab {
   public static final String[] woodType = new String[]{"Sakura", "Mahagony", "Maple"};
   private IIcon[] icon;

   public MySlabs(boolean isDouble) {
      super(isDouble, Material.field_151575_d);
      this.func_149711_c(2.0F);
      this.func_149752_b(2.0F);
      this.func_149672_a(field_149766_f);
      this.setHarvestLevel("axe", 0);
      this.field_149783_u = true;
      this.func_149647_a(mod_DragonBC.DragonBlockC);
      this.func_149663_c("Slab");
      if (isDouble) {
         this.func_149647_a((CreativeTabs)null);
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_149666_a(Item item, CreativeTabs tabs, List list) {
      for(int i = 0; i < woodType.length; ++i) {
         list.add(new ItemStack(item, 1, i));
      }

   }

   public String func_150002_b(int p_150002_1_) {
      return super.func_149739_a();
   }

   @SideOnly(Side.CLIENT)
   private static boolean isBlockSingleSlab(Block block) {
      return block == ModdedBlocks.SakuraSlabsSingle;
   }

   @SideOnly(Side.CLIENT)
   public Item func_149694_d(World world, int idk1, int idk2, int idk3) {
      return isBlockSingleSlab(this) ? Item.func_150898_a(this) : (this == ModdedBlocks.SakuraSlabsDouble ? Item.func_150898_a(ModdedBlocks.SakuraSlabsSingle) : Item.func_150898_a(ModdedBlocks.SakuraSlabsSingle));
   }

   public Item func_149650_a(int par22, Random random, int par33) {
      return Item.func_150898_a(ModdedBlocks.SakuraSlabsSingle);
   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      return new ItemStack(Item.func_150898_a(ModdedBlocks.SakuraSlabsSingle), 2, p_149644_1_ & 7);
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister iconRegister) {
      this.icon = new IIcon[woodType.length];

      for(int i = 0; i < this.icon.length; ++i) {
         this.icon[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":Planks" + woodType[i]);
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon func_149691_a(int side, int meta) {
      meta &= 7;
      if (meta > MathHelper.func_76125_a(meta, 0, 5)) {
         meta = MathHelper.func_76125_a(meta, 0, 5);
      }

      return this.icon[MathHelper.func_76125_a(meta, 0, 5)];
   }

   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
      return 40;
   }

   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
      return 5;
   }
}
