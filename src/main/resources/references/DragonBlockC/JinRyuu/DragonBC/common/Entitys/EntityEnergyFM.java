package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnergyFM extends Entity implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   public Entity shootingEntity;
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private int ticksInAir = 0;
   private float Expl = 4.0F;
   private String ExplSound = "jinryuudragonbc:DBC.expl";
   private String AirSound = "jinryuudragonbc:DBC.hafire";
   private float strtX;
   private float strtY;
   private float strtZ;
   private float trgtX = 0.0F;
   private float trgtY = 0.0F;
   private float trgtZ = 0.0F;
   private byte speed;
   private boolean shrink = false;
   private byte relFired = 100;
   private float size = 10.0F;
   private int cb = 50;
   private boolean kiClashed;
   private List kiClashedList = new ArrayList();

   public float strtX() {
      return this.strtX;
   }

   public float strtY() {
      return this.strtY;
   }

   public float strtZ() {
      return this.strtZ;
   }

   public float trgtX() {
      return this.trgtX;
   }

   public float trgtY() {
      return this.trgtY;
   }

   public float trgtZ() {
      return this.trgtZ;
   }

   public int getShrink() {
      return this.func_70096_w().func_75679_c(20);
   }

   public byte getSpe() {
      return this.speed;
   }

   public int getAirTicks() {
      return this.ticksInAir;
   }

   public void setAirTicks(int i) {
      this.ticksInAir = i;
   }

   public EntityEnergyFM(World par1World) {
      super(par1World);
      this.func_70105_a(this.size, this.size);
   }

   public EntityEnergyFM(EntityLivingBase par2EntityLivingBase) {
      super(par2EntityLivingBase.world);
      this.speed = 20;
      int sbh = (int)(this.posY > 65.0D ? this.posY - 65.0D : 1.0D) * 4;
      this.size = 0.5F + (float)(sbh / 5 * 100) * 0.02F / 8.0F;
      if (this.size > 10.0F) {
         this.size = 10.0F;
      }

      this.shootingEntity = par2EntityLivingBase;
      this.field_70155_l = 10.0D;
      this.func_70105_a(this.size, this.size);
      double d8 = (double)(par2EntityLivingBase.field_70130_N + 1.0F);
      double var10000 = (double)(par2EntityLivingBase.field_70131_O + 0.5F + this.size * 0.5F);
      Vec3 vec3 = par2EntityLivingBase.func_70676_i(1.0F);
      double x = par2EntityLivingBase.posX + vec3.field_72450_a * d8;
      double y = par2EntityLivingBase.posY + vec3.field_72448_b * d8 + (double)(par2EntityLivingBase.field_70131_O * 0.55F);
      double z = par2EntityLivingBase.posZ + vec3.field_72449_c * d8;
      this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
      this.field_70129_M = this.size * 0.5F;
      this.field_70159_w = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70181_x = 1.0D;
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, (float)this.speed * 0.05F, 1.0F);
      this.strtX = (float)x;
      this.strtY = (float)y;
      this.strtZ = (float)z;
   }

   protected void entityInit() {
      this.field_70180_af.func_75682_a(20, 0);
   }

   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= (double)var9;
      par3 /= (double)var9;
      par5 /= (double)var9;
      par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
      par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
      par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
      par1 *= (double)par7;
      par3 *= (double)par7;
      par5 *= (double)par7;
      this.field_70159_w = par1;
      this.field_70181_x = par3;
      this.field_70179_y = par5;
      float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
      this.field_70126_B = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
      this.field_70127_C = this.rotationPitch = (float)(Math.atan2(par3, (double)var10) * 180.0D / 3.141592653589793D);
      this.ticksInGround = 0;
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.func_70107_b(par1, par3, par5);
      this.func_70101_b(par7, par8);
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double par1, double par3, double par5) {
      this.field_70159_w = par1;
      this.field_70181_x = par3;
      this.field_70179_y = par5;
      if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
         this.field_70126_B = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
         this.field_70127_C = this.rotationPitch = (float)(Math.atan2(par3, (double)var7) * 180.0D / 3.141592653589793D);
         this.field_70127_C = this.rotationPitch;
         this.field_70126_B = this.rotationYaw;
         this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
         this.ticksInGround = 0;
      }

   }

   public void onUpdate() {
      if (!this.world.field_72995_K && this.shootingEntity == null) {
         this.setDead();
      }

      if (this.posY >= 250.0D) {
         this.field_70181_x = 0.0D;
      } else {
         int sbh = (int)(this.posY > 80.0D ? this.posY - 80.0D : 1.0D) * 4;
         this.size = 0.5F + (float)(sbh / 5 * 100) * 0.02F / 8.0F;
         this.func_70105_a(this.size, this.size);
      }

      this.field_70159_w = 0.0D;
      this.field_70179_y = 0.0D;
      if (this.ticksExisted == 1) {
         this.func_70105_a(this.size, this.size);
         this.field_70129_M = this.size * 0.5F;
      }

      super.onUpdate();
      if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70126_B = this.rotationYaw = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D);
         this.field_70127_C = this.rotationPitch = (float)(Math.atan2(this.field_70181_x, (double)var1) * 180.0D / 3.141592653589793D);
      }

      Block block = this.world.func_147439_a(this.xTile, this.yTile, this.zTile);
      if (block.func_149688_o() != Material.field_151579_a) {
         block.func_149719_a(this.world, this.xTile, this.yTile, this.zTile);
         AxisAlignedBB axisalignedbb = block.func_149668_a(this.world, this.xTile, this.yTile, this.zTile);
         if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.posX, this.posY, this.posZ))) {
            this.inGround = true;
         }
      }

      if (this.inGround) {
         int var19 = this.world.func_72805_g(this.xTile, this.yTile, this.zTile);
         if (block == this.inTile && var19 == this.inData) {
            ++this.ticksInGround;
            if (this.ticksInGround == 1) {
               this.setDead();
               if (!this.world.field_72995_K) {
                  this.world.func_72956_a(this, this.AirSound, 1.0F, 1.0F);
               }
            }
         } else {
            this.inGround = false;
            this.field_70159_w *= (double)(this.rand.nextFloat() * 0.2F);
            this.field_70181_x *= (double)(this.rand.nextFloat() * 0.2F);
            this.field_70179_y *= (double)(this.rand.nextFloat() * 0.2F);
            this.ticksInGround = 0;
            this.ticksInAir = 0;
         }
      } else {
         ++this.ticksInAir;
         Vec3 var17 = Vec3.func_72443_a(this.posX, this.posY, this.posZ);
         Vec3 var3 = Vec3.func_72443_a(this.posX + this.field_70159_w, this.posY + this.field_70181_x, this.posZ + this.field_70179_y);
         MovingObjectPosition var4 = this.world.func_147447_a(var17, var3, false, true, false);
         var17 = Vec3.func_72443_a(this.posX, this.posY, this.posZ);
         var3 = Vec3.func_72443_a(this.posX + this.field_70159_w, this.posY + this.field_70181_x, this.posZ + this.field_70179_y);
         if (!this.world.field_72995_K && this.ticksInAir >= 2000) {
            this.setDead();
         }

         int var9;
         for(var9 = 1; var9 < 3; ++var9) {
         }

         var9 = this.ticksInAir / 10 * 10;
         if (this.ticksInAir == (var9 == 0 ? 10 : var9)) {
            this.world.func_72956_a(this, "jinryuudragonbc:" + JRMCoreH.techSnds(0, 2, 0), 1.0F, 1.0F);
         }

         if (var4 != null) {
            var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
         }

         float var11;
         if (!this.world.field_72995_K) {
            Entity var5 = null;
            List var6 = this.world.func_72839_b(this, this.boundingBox.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
            double var7 = 0.0D;
            var9 = 0;

            while(true) {
               if (var9 >= var6.size()) {
                  if (var5 != null) {
                     var4 = new MovingObjectPosition(var5);
                  }
                  break;
               }

               Entity var10 = (Entity)var6.get(var9);
               if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
                  var11 = 0.0F;
                  AxisAlignedBB var12 = var10.boundingBox.func_72314_b((double)var11, (double)var11, (double)var11);
                  MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
                  if (var13 != null) {
                     double var14 = var17.func_72438_d(var13.field_72307_f);
                     if (var14 < var7 || var7 == 0.0D) {
                        var5 = var10;
                        var7 = var14;
                     }
                  }
               }

               ++var9;
            }
         }

         if (var4 != null) {
            if (!this.world.field_72995_K) {
               this.world.func_72956_a(this, this.ExplSound, 1.0F, 1.0F);
            }

            this.xTile = var4.field_72311_b;
            this.yTile = var4.field_72312_c;
            this.zTile = var4.field_72309_d;
            this.inTile = this.world.func_147439_a(this.xTile, this.yTile, this.zTile);
            this.inData = this.world.func_72805_g(this.xTile, this.yTile, this.zTile);
            this.inGround = true;
            if (this.inTile.func_149688_o() != Material.field_151579_a) {
               this.inTile.func_149670_a(this.world, this.xTile, this.yTile, this.zTile, this);
            }
         }

         this.posX += this.field_70159_w;
         this.posY += this.field_70181_x;

         for(this.posZ += this.field_70179_y; this.rotationPitch - this.field_70127_C >= 180.0F; this.field_70127_C += 360.0F) {
         }

         while(this.rotationYaw - this.field_70126_B < -180.0F) {
            this.field_70126_B -= 360.0F;
         }

         while(this.rotationYaw - this.field_70126_B >= 180.0F) {
            this.field_70126_B += 360.0F;
         }

         float var22 = 1.0F;
         var11 = 0.0F;
         if (this.func_70090_H()) {
            for(int var26 = 0; var26 < 4; ++var26) {
               float var27 = 0.25F;
               this.world.func_72869_a("bubble", this.posX - this.field_70159_w * (double)var27, this.posY - this.field_70181_x * (double)var27, this.posZ - this.field_70179_y * (double)var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }

            var22 = 1.0F;
         }

         this.field_70159_w *= (double)var22;
         this.field_70181_x *= (double)var22;
         this.field_70179_y *= (double)var22;
         this.field_70181_x -= (double)var11;
         this.func_70107_b(this.posX, this.posY, this.posZ);
      }

   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
      par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
      par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
      par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
      par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
      par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      this.xTile = par1NBTTagCompound.func_74765_d("xTile");
      this.yTile = par1NBTTagCompound.func_74765_d("yTile");
      this.zTile = par1NBTTagCompound.func_74765_d("zTile");
      this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 255);
      this.inData = par1NBTTagCompound.func_74771_c("inData") & 255;
      this.inGround = par1NBTTagCompound.func_74771_c("inGround") == 1;
   }

   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
      if (!this.world.field_72995_K && this.inGround) {
      }

   }

   protected boolean func_70041_e_() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return false;
   }

   public boolean func_82704_a(Entity var1) {
      return false;
   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.shootingEntity == null ? 0 : this.shootingEntity.func_145782_y());
      data.writeByte(this.speed);
      data.writeFloat(this.strtX);
      data.writeFloat(this.strtY);
      data.writeFloat(this.strtZ);
      data.writeFloat(this.size);
      data.writeFloat(this.trgtX);
      data.writeFloat(this.trgtY);
      data.writeFloat(this.trgtZ);
      data.writeByte(this.shrink ? 1 : 0);
   }

   public void readSpawnData(ByteBuf data) {
      int first = data.readInt();
      this.shootingEntity = first == 0 ? this.shootingEntity : this.world.func_73045_a(first);
      this.speed = data.readByte();
      this.strtX = data.readFloat();
      this.strtY = data.readFloat();
      this.strtZ = data.readFloat();
      this.size = data.readFloat();
      this.trgtX = data.readFloat();
      this.trgtY = data.readFloat();
      this.trgtZ = data.readFloat();
      this.shrink = data.readByte() == 1;
   }

   public Entity getThrower() {
      return null;
   }

   public void setThrower(Entity entity) {
   }

   @SideOnly(Side.CLIENT)
   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public double getMaxRenderDistanceSquared() {
      return 65536.0D;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }
}
