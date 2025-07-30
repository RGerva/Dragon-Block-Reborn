package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDBCWildlife extends EntityDBC {
   public EntityDBCWildlife(World par1World) {
      super(par1World);
   }

   protected NBTTagCompound nbt(EntityPlayer p, String s) {
      NBTTagCompound nbt;
      if (s.contains("pres")) {
         if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
            nbt = new NBTTagCompound();
            p.getEntityData().func_74782_a("PlayerPersisted", nbt);
         } else {
            nbt = p.getEntityData().func_74775_l("PlayerPersisted");
         }
      } else {
         nbt = p.getEntityData();
      }

      return nbt;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0D);
   }

   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      super.func_70014_b(par1NBTTagCompound);
      par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
   }

   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
      super.func_70037_a(par1NBTTagCompound);
      this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
   }

   protected void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
   }
}
