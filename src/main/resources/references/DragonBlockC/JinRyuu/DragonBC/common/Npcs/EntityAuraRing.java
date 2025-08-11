package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAuraRing extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 1;
   private String mot = "";
   int Age;
   int MaxAge = 20;
   int color = 16777215;
   private float state = 0.0F;
   private float state2 = 0.0F;
   int crel = 0;
   float alpha = 0.1F;

   public EntityAuraRing(World par1World) {
      super(par1World);
   }

   public boolean shouldRenderInPass(int pass) {
      return pass == 1;
   }

   public EntityAuraRing(World par1World, String dbcCharger, int c, float s, float s2, int cr) {
      super(par1World);
      this.mot = dbcCharger;
      this.color = c;
      this.state = s;
      this.state2 = s2;
      this.crel = cr;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public int getAge() {
      return this.Age;
   }

   public int getCol() {
      return this.color;
   }

   public float getState() {
      return this.state;
   }

   public float getState2() {
      return this.state2;
   }

   public float getCRel() {
      return (float)this.crel;
   }

   public void setCol(int c) {
      this.color = c;
   }

   public float getAlp() {
      return this.alpha;
   }

   public void setAlp(float a) {
      this.alpha = a;
   }

   public float update_alpha() {
      float one_age = (float)this.MaxAge / 100.0F;
      float one_alpha = this.getAlp() / 100.0F;
      float alpha_curr = (100.0F - (float)this.Age / one_age) / 100.0F * this.getAlp() * 3.0F;
      return alpha_curr;
   }

   public void onUpdate() {
      if (this.mot.length() > 1) {
         Entity other = this.world.getPlayerEntityByName(this.mot);
         if (other != null) {
            this.setLocationAndAngles(other.posX, other.posY + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F), other.posZ, 0.0F, 0.0F);
         } else {
            this.setDead();
         }
      }

      if (this.Age++ >= this.MaxAge) {
         this.setDead();
      }

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
