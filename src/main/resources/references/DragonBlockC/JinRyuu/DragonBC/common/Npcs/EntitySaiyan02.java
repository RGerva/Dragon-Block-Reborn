package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySaiyan02 extends EntityDBCEvil {
   private int randomSoundDelay;
   private Entity field_110191_bu;
   public final int AttPow = 60;
   public final int HePo = 600;

   public EntitySaiyan02(World par1World) {
      super(par1World);
      this.setEasyDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(600.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(60.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/saiyan02.png";
   }

   protected boolean func_70650_aV() {
      return false;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   public void func_70071_h_() {
      this.field_110191_bu = this.field_70789_a;
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

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity entity = par1DamageSource.func_76346_g();
         if (entity instanceof EntityPlayer) {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int i = 0; i < list.size(); ++i) {
               Entity entity1 = (Entity)list.get(i);
               if (entity1 instanceof EntitySaiyan02) {
                  EntitySaiyan02 entitypigzombie = (EntitySaiyan02)entity1;
                  entitypigzombie.becomeAngryAt(entity);
               }
            }

            this.becomeAngryAt(entity);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
