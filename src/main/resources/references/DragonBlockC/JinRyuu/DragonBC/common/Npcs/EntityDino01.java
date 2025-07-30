package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDino01 extends EntityDBCWildlifeA implements IMob {
   public int randomSoundDelay = 0;
   public final int AttPow = 120;
   public final int HePo = 1000;

   public EntityDino01(World par1World) {
      super(par1World);
      this.field_70728_aV = 50;
      this.field_70129_M *= 4.0F;
      this.func_70105_a(8.0F, 12.0F);
      if (DBCConfig.NPC_Dino1_Dam != 120 || DBCConfig.NPC_Dino1_HP != 1000) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)DBCConfig.NPC_Dino1_Dam);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)DBCConfig.NPC_Dino1_HP);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(120.0D);
   }

   public void func_70071_h_() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.func_70071_h_();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Paozusaurus.png";
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   protected Entity func_70782_k() {
      return super.func_70782_k();
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
      this.func_145779_a(ItemsDBC.ItemDinoMeatBig, 1);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   protected boolean func_70692_ba() {
      return true;
   }
}
