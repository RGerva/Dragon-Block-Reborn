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

public class EntityFreezaFather extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 440;
   public final int HePo = 4400;
   int trans;

   public EntityFreezaFather(World par1World) {
      super(par1World);
      this.field_70728_aV = 120;
      this.field_70130_N = 2.0F;
      this.field_70131_O = 4.0F;
      this.setMediumDifficulty();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/kcold.png";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4400.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(440.0D);
   }

   public void func_70071_h_() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.func_70071_h_();
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      super.func_70014_b(par1NBTTagCompound);
      par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
   }

   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
      super.func_70037_a(par1NBTTagCompound);
      this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
   }

   protected Entity func_70782_k() {
      return this.target != null ? this.target : (this.angerLevel == 0 ? null : super.func_70782_k());
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         List var4 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            Entity var6 = (Entity)var4.get(var5);
            if (var6 instanceof EntityFreezaFather) {
               EntityFreezaFather var7 = (EntityFreezaFather)var6;
               var7.becomeAngryAt(var3);
            }

            if (var6 instanceof EntityFreezaSoldier1) {
               ((EntityFreezaSoldier1)var6).becomeAngryAt(var3);
            }

            if (var6 instanceof EntityFreezaSoldier2) {
               ((EntityFreezaSoldier2)var6).becomeAngryAt(var3);
            }

            if (var6 instanceof EntityFreezaSoldier3) {
               ((EntityFreezaSoldier3)var6).becomeAngryAt(var3);
            }
         }

         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityFreezaFather) {
                  EntityFreezaFather var7 = (EntityFreezaFather)var6;
                  var7.becomeAngryAt(var3);
               }

               if (var6 instanceof EntityFreezaSoldiers) {
                  EntityFreezaSoldiers var7 = (EntityFreezaSoldiers)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   public void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }

   protected void func_70628_a(boolean par1, int par2) {
      int var3 = this.field_70146_Z.nextInt(1 + par2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
      }

      var3 = this.field_70146_Z.nextInt(2 + par2);

      for(var4 = 0; var4 < var3; ++var4) {
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
