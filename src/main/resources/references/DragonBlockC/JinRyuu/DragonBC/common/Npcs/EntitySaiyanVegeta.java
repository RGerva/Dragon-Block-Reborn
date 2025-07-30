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

public class EntitySaiyanVegeta extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 40;
   public final int HePo = 400;

   public EntitySaiyanVegeta(World par1World) {
      super(par1World);
      this.field_70728_aV = 80;
      this.setMediumDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
   }

   public void func_70071_h_() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.func_70071_h_();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/vegeta.png";
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
      if (this.doBlst()) {
         int r = (int)(Math.random() * 3.0D);
         if (r == 0) {
            this.setData1(1);
            this.setData2(0);
         } else if (r == 1) {
            this.setData1(6);
            this.setData2(2);
         } else {
            this.setData1(5);
            this.setData2(0);
         }
      }

      if (this.field_70170_p.func_72826_c(1200.0F) == 1200.0F) {
         EntityNamekian01 c = new EntityNamekian01(this.field_70170_p);
         c.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
         this.field_70170_p.func_72838_d(c);
         this.func_70106_y();
      }

      super.func_70636_d();
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
               if (var6 instanceof EntitySaiyanVegeta) {
                  EntitySaiyanVegeta var7 = (EntitySaiyanVegeta)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }

   protected void func_70628_a(boolean par1, int par2) {
      int var3 = this.field_70146_Z.nextInt(1 + par2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(ItemsDBC.BattleArmorHelmet01, 1);
      }

      var3 = this.field_70146_Z.nextInt(2 + par2);

      for(var4 = 0; var4 < var3; ++var4) {
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
