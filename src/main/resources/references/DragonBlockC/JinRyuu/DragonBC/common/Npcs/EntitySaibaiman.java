package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntitySaibaiman extends EntityDBCEvil implements IMob {
   public int randomSoundDelay = 0;
   public final int AttPow = 20;
   public final int HePo = 200;

   public EntitySaibaiman(World par1World) {
      super(par1World);
      this.field_70728_aV = 10;
      this.setKiUsage(false, false);
      this.setEasyDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Saibaiman.png";
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   public void func_70636_d() {
      this.becomeAngryAtAllPlayer();
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
      int ran = this.field_70146_Z.nextInt(5);
      if (ran == 0) {
         this.func_145779_a(ItemsDBC.ItemSaibaiSeed, 1);
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
