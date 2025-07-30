package JinRyuu.DragonBC.common.Render;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class block01dbcEntity extends Entity {
   public double bx;
   public double by;
   public double bz;

   public block01dbcEntity(World p_i1582_1_) {
      super(p_i1582_1_);
      this.func_70105_a(0.01F, 0.01F);
   }

   public block01dbcEntity(World p_i1582_1_, double bx, double by, double bz) {
      super(p_i1582_1_);
      this.bx = bx;
      this.by = by;
      this.bz = bz;
      this.func_70107_b(bx + 0.5D, by, bz + 0.5D);
      this.field_70130_N = this.field_70131_O = 0.01F;
      this.func_70105_a(this.field_70130_N, this.field_70131_O);
   }

   public int getX() {
      return (int)this.bx;
   }

   public int getY() {
      return (int)this.by;
   }

   public int getZ() {
      return (int)this.bz;
   }

   public void func_70030_z() {
      if (this.field_70153_n == null || this.field_70170_p.func_147437_c((int)this.bx, (int)this.by, (int)this.bz)) {
         this.func_70106_y();
      }

   }

   protected boolean func_142008_O() {
      return false;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O - 0.2D;
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
   }
}
