package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemKatana extends ItemSword {
   public ItemKatana(ToolMaterial tm) {
      super(tm);
      this.func_77656_e(300);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister par1IconRegister) {
      this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
      if (par1ItemStack.func_77960_j() == 15) {
         Block var11 = par3World.func_147439_a(par4, par5, par6);
         if (var11 == BlocksDBC.BlockNamekSapling && !par3World.field_72995_K) {
            --par1ItemStack.field_77994_a;
         }
      }

      return par1ItemStack;
   }
}
