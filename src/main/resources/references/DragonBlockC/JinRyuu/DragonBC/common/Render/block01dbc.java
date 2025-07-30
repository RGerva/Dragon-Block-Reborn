package JinRyuu.DragonBC.common.Render;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class block01dbc extends BlockContainer {
   public block01dbc(Material par2Material) {
      super(par2Material);
   }

   public boolean sitOnBlock(World par1World, double par2, double par3, double par4, EntityPlayer par5EntityPlayer) {
      this.checkForExistingEntity(par1World, par2, par3, par4, par5EntityPlayer);
      block01dbcEntity nemb = new block01dbcEntity(par1World, par2, par3, par4);
      par1World.func_72838_d(nemb);
      par5EntityPlayer.func_70078_a(nemb);
      return true;
   }

   public boolean checkForExistingEntity(World par1World, double par2, double par3, double par4, EntityPlayer par5EntityPlayer) {
      List<block01dbcEntity> listEMB = par1World.func_72872_a(block01dbcEntity.class, AxisAlignedBB.func_72330_a(par2, par3, par4, par2 + 1.0D, par3 + 1.0D, par4 + 1.0D).func_72314_b(1.0D, 1.0D, 1.0D));
      Iterator var10 = listEMB.iterator();

      block01dbcEntity mount;
      do {
         if (!var10.hasNext()) {
            return false;
         }

         mount = (block01dbcEntity)var10.next();
      } while((double)mount.getX() != par2 || (double)mount.getY() != par3 || (double)mount.getZ() != par4);

      if (mount.field_70153_n == null) {
         par5EntityPlayer.func_70078_a(mount);
      }

      return true;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return null;
   }
}
