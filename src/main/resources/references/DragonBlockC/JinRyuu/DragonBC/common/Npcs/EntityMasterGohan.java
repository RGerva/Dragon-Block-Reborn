package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMasterGohan extends EntityDBCKami {
   public final int HePo = 100000;

   public EntityMasterGohan(World par1World) {
      super(par1World);
      this.name = "Master Gohan";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         par1EntityPlayer.openGui(mod_DragonBC.instance, 22, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/gohan1.png";
   }

   public void func_70071_h_() {
      super.func_70071_h_();
   }
}
