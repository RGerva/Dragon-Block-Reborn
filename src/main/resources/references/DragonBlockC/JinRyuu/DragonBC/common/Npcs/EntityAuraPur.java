package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityAuraPur extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 3;
   private Entity mot;
   int Age;
   int MaxAge = 20;

   public EntityAuraPur(World par1World) {
      super(par1World);
   }

   public EntityAuraPur(World par1World, Entity other) {
      super(par1World);
      this.mot = other;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public void func_70071_h_() {
      if (this.mot != null) {
         this.field_70159_w = this.mot.field_70159_w;
         this.field_70181_x = this.mot.field_70181_x;
         this.field_70179_y = this.mot.field_70179_y;
      }

      boolean doit = false;
      int x = false;
      int y = false;
      int z = false;
      if (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v - 1).func_149688_o() == Material.field_151579_a) {
         doit = true;
         int x = (int)this.field_70165_t;
         int y = (int)this.field_70163_u;
         int var7 = (int)this.field_70161_v;
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if (this.Age++ >= this.MaxAge) {
         if (doit) {
         }

         this.func_70106_y();
      }

      this.field_70181_x += 0.0D;
      if (this.field_70163_u == this.field_70167_r) {
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

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      String textura = "";
      if (this.tex == 1) {
         textura = "jinryuudragonbc:aurab.png";
      }

      if (this.tex == 2) {
         textura = "jinryuudragonbc:auras.png";
      }

      if (this.tex == 3) {
         textura = "jinryuudragonbc:aurap.png";
      }

      if (this.tex == 4) {
         textura = "jinryuudragonbc:aurar.png";
      }

      return textura;
   }

   public boolean getCanSpawnHere() {
      return !this.field_70170_p.func_72855_b(this.field_70121_D);
   }

   public void onLivingUpdate() {
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound var1) {
   }

   protected void func_70014_b(NBTTagCompound var1) {
   }
}
