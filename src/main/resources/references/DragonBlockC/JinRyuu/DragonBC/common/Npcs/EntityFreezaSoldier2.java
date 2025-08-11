package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFreezaSoldier2 extends EntityFreezaSoldiers {
   public final int AttPow = 20;
   public final int HePo = 200;

   public EntityFreezaSoldier2(World par1World) {
      super(par1World);
      this.field_70728_aV = 5;
      this.field_70715_bh.func_75776_a(0, new EntityAINearestAttackableTarget(this, EntityNamekian01.class, 200, false));
      this.field_70715_bh.func_75776_a(1, new EntityAINearestAttackableTarget(this, EntityNamekian03.class, 200, false));
      this.setMediumDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20.0D);
   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/soldier1.png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
      par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
      this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
   }

   protected Entity func_70782_k() {
      return this.target != null ? this.target : (this.angerLevel == 0 ? null : super.func_70782_k());
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
      int var3 = this.rand.nextInt(1);
      if (var3 != 0) {
         this.func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
      }

      var3 = this.rand.nextInt(2 + par2);

      for(int var4 = 0; var4 < var3; ++var4) {
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
