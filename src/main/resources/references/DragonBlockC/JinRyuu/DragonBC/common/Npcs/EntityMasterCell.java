package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMasterCell extends EntityDBCKami {
   public final int HePo = 22000;

   public EntityMasterCell(World par1World) {
      super(par1World);
      this.name = "Master Cell";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(22000.0D);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         par1EntityPlayer.openGui(mod_DragonBC.instance, 16, par1EntityPlayer.world, (int)this.posX, (int)this.posY, (int)this.posZ);
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/cell3.png";
   }

   public void onUpdate() {
      super.onUpdate();
   }
}
