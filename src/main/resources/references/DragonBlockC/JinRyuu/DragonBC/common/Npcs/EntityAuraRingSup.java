package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAuraRingSup extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 1;
   private Entity mot;
   int Age;
   int MaxAge = 7;

   public EntityAuraRingSup(World par1World) {
      super(par1World);
   }

   public EntityAuraRingSup(World par1World, Entity other) {
      super(par1World);
      this.mot = other;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public void onUpdate() {
      if (this.mot != null) {
         this.field_70159_w = this.mot.field_70159_w;
         this.field_70181_x = this.mot.field_70181_x;
         this.field_70179_y = this.mot.field_70179_y;
      }

      this.field_70169_q = this.posX;
      this.field_70167_r = this.posY;
      this.field_70166_s = this.posZ;
      if (this.Age++ >= this.MaxAge) {
         this.setDead();
      }

      this.field_70181_x += 0.0D;
      if (this.posY == this.field_70167_r) {
         this.field_70159_w *= 1.0D;
         this.field_70179_y *= 1.0D;
      }

      if (!this.field_70122_E) {
         this.field_70159_w *= DBCKiAttacks.motX;
         this.field_70179_y *= DBCKiAttacks.motZ;
         this.field_70181_x *= DBCKiAttacks.motY;
      }

      this.func_70091_d(this.field_70159_w * 2.0D, this.field_70181_x * 2.0D, this.field_70179_y * 2.0D);
   }

   public boolean getCanSpawnHere() {
      return !this.world.checkNoEntityCollision(this.boundingBox);
   }

   public void onLivingUpdate() {
   }

   protected void entityInit() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }
}
