package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityZarbon extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 100;
   public final int HePo = 1000;

   public EntityZarbon(World par1World) {
      super(par1World);
      this.field_70728_aV = 46;
      this.angerLevel = 400;
      this.setMediumDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(100.0D);
   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/zarbon.png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
   }

   protected Entity func_70782_k() {
      return this.target != null ? this.target : (this.angerLevel == 0 ? null : super.func_70782_k());
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityZarbon) {
                  EntityZarbon var7 = (EntityZarbon)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void func_70628_a(boolean par1, int par2) {
      int var3 = this.rand.nextInt(1 + par2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
      }

      var3 = this.rand.nextInt(2 + par2);

      for(var4 = 0; var4 < var3; ++var4) {
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
