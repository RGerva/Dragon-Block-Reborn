package JinRyuu.DragonBC.common.Render;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class KintounBaseEntity extends Entity {
   private int cloudColor = 16777216;

   public int getCloudColor() {
      return this.cloudColor;
   }

   public void setCloudColor(int col) {
      this.cloudColor = col;
   }

   public KintounBaseEntity(World par1World) {
      super(par1World);
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
   }
}
