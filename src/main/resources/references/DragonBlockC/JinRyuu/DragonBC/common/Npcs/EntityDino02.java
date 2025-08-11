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

public class EntityDino02 extends EntityDBCWildlifeA implements IMob {
   public int randomSoundDelay = 0;
   public final int AttPow = 40;
   public final int HePo = 300;

   public EntityDino02(World par1World) {
      super(par1World);
      this.field_70728_aV = 50;
      this.field_70129_M *= 4.0F;
      this.func_70105_a(2.0F, 2.0F);
      if (DBCConfig.NPC_Dino2_Dam != 40 || DBCConfig.NPC_Dino2_HP != 300) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)DBCConfig.NPC_Dino2_Dam);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)DBCConfig.NPC_Dino2_HP);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/dino02-1.png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   protected Entity func_70782_k() {
      return super.func_70782_k();
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
      this.func_145779_a(ItemsDBC.ItemDinoMeat, 1);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   protected boolean func_70692_ba() {
      return true;
   }
}
