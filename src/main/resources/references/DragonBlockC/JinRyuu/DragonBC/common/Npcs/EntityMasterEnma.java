package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMasterEnma extends EntityDBCKami {
   public int randomSoundDelay = 0;

   public EntityMasterEnma(World par1World) {
      super(par1World);
      this.field_70728_aV = 0;
      this.field_70130_N = 2.0F * DBCConfig.EnmaScale;
      this.field_70131_O = 4.0F * DBCConfig.EnmaScale;
      this.name = "Master Enma";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         par1EntityPlayer.openGui(mod_DragonBC.instance, 10, par1EntityPlayer.world, (int)this.posX, (int)this.posY, (int)this.posZ);
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/enma.png";
   }
}
