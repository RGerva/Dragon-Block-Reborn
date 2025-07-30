package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAura extends Entity {
   public int randomSoundDelay;
   public long lightVert;
   private int lightLivingTime;
   private String mot;
   private boolean rot;
   private int Age;
   private int color;
   private int colorl2;
   private float state;
   private float state2;
   private int crel;
   private float yaw;
   private float pitch;
   private float alpha;
   private String tex;
   private String texl2;
   private int speed;
   private boolean inner;
   private int rendpass;

   public int getLightLivingTime() {
      return this.lightLivingTime;
   }

   public EntityAura(World par1World) {
      super(par1World);
      this.randomSoundDelay = 0;
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
   }

   public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b, float a) {
      this(par1World, dbcCharger, c, s, s2, cr, b);
      this.alpha = a;
   }

   public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b) {
      this(par1World, dbcCharger, c, s, s2, cr);
      this.rot = b;
   }

   public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr) {
      super(par1World);
      this.randomSoundDelay = 0;
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
      this.mot = dbcCharger;
      this.color = c;
      this.state = s;
      this.state2 = s2;
      this.crel = cr;
      this.lightVert = this.field_70146_Z.nextLong();
      this.lightLivingTime = this.field_70146_Z.nextInt(4) + 0;
   }

   public boolean shouldRenderInPass(int pass) {
      return pass == this.rendpass;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean getRot() {
      return this.rot;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public int getAge() {
      return this.Age;
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

   public int getCol() {
      return this.color;
   }

   public void setCol(int c) {
      this.color = c;
   }

   public int getColL2() {
      return this.colorl2;
   }

   public void setColL2(int c) {
      this.colorl2 = c;
   }

   public float getAlp() {
      return this.alpha;
   }

   public void setAlp(float f) {
      this.alpha = f;
   }

   public String getTex() {
      return this.tex;
   }

   public void setTex(String s) {
      this.tex = s;
   }

   public String getTexL2() {
      return this.texl2;
   }

   public void setTexL2(String s) {
      this.texl2 = s;
   }

   public int getSpd() {
      return this.speed;
   }

   public void setSpd(int s) {
      this.speed = s;
   }

   public boolean getInner() {
      return this.inner;
   }

   public void setInner(boolean s) {
      this.inner = s;
   }

   public void setRendPass(int s) {
      this.rendpass = s;
   }

   public String getmot() {
      return this.mot;
   }

   public void func_70071_h_() {
      if (this.mot.length() > 1) {
         Entity other = this.field_70170_p.func_72924_a(this.mot);
         if (other != null) {
            if (this.rot) {
               this.yaw = other.field_70177_z;
               this.pitch = other.field_70125_A;
            }

            this.func_70012_b(other.field_70165_t, other.field_70163_u + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F), other.field_70161_v, other.field_70177_z, other.field_70125_A);
            if (this.getAge() < this.getLightLivingTime() && this.getState() > 4.0F && this.getState() < 7.0F && this.getAge() == 2) {
               other.func_85030_a("jinryuudragonbc:1610.spark", 0.0375F, 0.85F + (float)this.lightLivingTime * 0.05F);
            }
         } else {
            this.func_70106_y();
         }
      }

      if (this.Age++ >= this.speed) {
         this.func_70106_y();
      }

   }

   public boolean getCanSpawnHere() {
      return !this.field_70170_p.func_72855_b(this.field_70121_D);
   }

   public void onLivingUpdate() {
   }

   protected void func_70037_a(NBTTagCompound var1) {
   }

   protected void func_70014_b(NBTTagCompound var1) {
   }

   protected void func_70088_a() {
   }
}
