package JinRyuu.JRMCore.entity;

import net.minecraft.world.World;

public class EntityEnergyAttJ4 extends EntityEnAttacks {
   private float size;
   private byte type;
   public final int number_of_lightVerts = 10;
   public long[] lightVert = new long[10];
   private int lightLivingTime;

   public float getSize() {
      return this.size;
   }

   public byte getType() {
      return this.type;
   }

   public int getLightLivingTime() {
      return this.lightLivingTime;
   }

   public EntityEnergyAttJ4(World w, byte type, double x, double y, double z) {
      super(w);
      this.type = type;
      this.size = 1.0F;
      this.func_70105_a(this.size, this.size);
      this.posX = x;
      this.posY = y;
      this.posZ = z;
   }

   public void onUpdate() {
      if (this.world.field_72995_K) {
         if (this.ticksExisted == 1) {
            this.func_70105_a(this.size, this.size);
         }

         if (this.ticksExisted > 20) {
            this.setDead();
         }

         this.func_70107_b(this.posX, this.posY, this.posZ);
      }

   }
}
