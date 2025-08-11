package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnergyAttJ3 extends EntityEnAttacks implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private double damage = 1.0D;
   private String DBCExplSound = "jinryuudragonbc:DBC.expl";
   private String NCExplSound = "jinryuunarutoc:NC1.Explosion";
   private byte type;
   private int dam;
   private byte perc;
   private byte pmjID;
   private int cost;
   private int costPerc;
   private int originDmg;
   private int pwrtyp = 0;
   private String nameJutsu;
   public float size = 1.7F;
   private boolean used = false;
   private int health;
   private byte jtsre;
   private float rota;

   public byte getType() {
      return this.type;
   }

   public int getDam() {
      return this.dam;
   }

   public byte getPerc() {
      return this.perc;
   }

   public float getSizePerc() {
      return this.size;
   }

   public byte getjtsre() {
      return this.jtsre;
   }

   public float getrota() {
      return this.rota;
   }

   public EntityEnergyAttJ3(World par1World) {
      super(par1World);
      this.func_70105_a(this.size, this.size);
   }

   public EntityEnergyAttJ3(byte jtsre, EntityLivingBase entity, byte type, int dam, byte perc, int dam1, int cost, int costPerc) {
      super(entity.world);
      this.jtsre = jtsre;
      this.type = type;
      this.dam = dam;
      this.perc = 50;
      this.cost = cost;
      this.costPerc = costPerc;
      this.originDmg = dam1;
      this.pmjID = perc;
      if (this.pmjID != -1) {
         this.nameJutsu = JRMCoreH.trl("nc", JRMCoreH.pmj[this.pmjID][0]);
      }

      this.damage = (double)this.dam * (double)this.perc * 0.019999999552965164D;
      this.shootingEntity = entity;
      this.pwrtyp = 0;
      if (this.shootingEntity instanceof EntityPlayer) {
         this.pwrtyp = JRMCoreH.PlyrPwr((EntityPlayer)this.shootingEntity);
      }

      this.field_70155_l = 10.0D;
      this.func_70105_a(this.size, this.size);
      double d8 = (double)(entity.field_70130_N + 1.0F);
      double d9 = (double)entity.field_70131_O;
      Vec3 vec3 = entity.func_70676_i(1.0F);
      double x = entity.posX + vec3.field_72450_a * d8;
      double y = entity.posY + vec3.field_72448_b * d8 + (double)(entity.field_70131_O * 0.55F);
      double z = entity.posZ + vec3.field_72449_c * d8;
      int spot = -1;
      int checked = 0;

      for(int i = (int)y; spot == -1 && checked < 3; --i) {
         if (!entity.world.func_147439_a((int)x, i, (int)z).func_149739_a().toLowerCase().contains("air")) {
            int spot = i + 1;
            y = (double)spot;
            break;
         }

         ++checked;
      }

      this.setLocationAndAngles(x, y, z, entity.rotationYaw, entity.rotationPitch);
      this.rota = entity.rotationYaw;
   }

   protected void entityInit() {
      this.field_70180_af.func_75682_a(16, (byte)0);
   }

   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.func_70107_b(par1, par3, par5);
      this.func_70101_b(par7, par8);
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double par1, double par3, double par5) {
   }

   public void onUpdate() {
      if (!this.world.field_72995_K && this.shootingEntity == null) {
         this.setDead();
      }

      if (this.ticksExisted == 1) {
         this.func_70105_a(this.size, this.size);
      }

      if (this.ticksExisted > 500) {
         this.setDead();
      }

      super.onUpdate();
      if (!this.world.field_72995_K && this.getDamage() <= 0.0D) {
         this.setDead();
      }

      Block block = this.world.func_147439_a((int)this.posX, (int)this.posY, (int)this.posZ);
      if (block.func_149688_o() != Material.field_151579_a) {
         block.func_149719_a(this.world, this.xTile, this.yTile, this.zTile);
         AxisAlignedBB axisalignedbb = block.func_149668_a(this.world, this.xTile, this.yTile, this.zTile);
         if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.posX, this.posY, this.posZ))) {
            this.inGround = true;
         }
      }

      if (this.inGround) {
         int var19 = this.world.func_72805_g((int)this.posX, (int)this.posY, (int)this.posZ);
         if (block.func_149688_o() != Material.field_151579_a && !block.func_149739_a().toLowerCase().contains("air")) {
            ++this.ticksInGround;
            this.posY += 0.10000000149011612D;
         } else {
            this.inGround = false;
            this.ticksInGround = 0;
         }

         this.func_chins();
      } else {
         this.func_chins();
         this.func_70107_b(this.posX, this.posY, this.posZ);
         this.doBlockCollisions();
      }

   }

   public long getPower(Entity entity) {
      return (long)(this.getDamage() / 2.0D);
   }

   private void doBlockCollisions() {
      this.func_145775_I();
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
      par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
      par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
      par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
      par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
      par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
      par1NBTTagCompound.func_74780_a("damage", this.damage);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      this.xTile = par1NBTTagCompound.func_74765_d("xTile");
      this.yTile = par1NBTTagCompound.func_74765_d("yTile");
      this.zTile = par1NBTTagCompound.func_74765_d("zTile");
      this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 255);
      this.inData = par1NBTTagCompound.func_74771_c("inData") & 255;
      this.inGround = par1NBTTagCompound.func_74771_c("inGround") == 1;
      if (par1NBTTagCompound.func_74764_b("damage")) {
         this.damage = par1NBTTagCompound.func_74769_h("damage");
      }

   }

   public void func_70100_b_(EntityPlayer e) {
   }

   protected boolean func_70041_e_() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public void setDamage(double par1) {
      this.damage = par1;
   }

   public double getDamage() {
      return this.damage;
   }

   public void setKnockbackStrength(int par1) {
   }

   public boolean func_82704_a(Entity var1) {
      return false;
   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.shootingEntity == null ? 0 : this.shootingEntity.func_145782_y());
      data.writeByte(this.perc);
      data.writeByte(this.type);
      data.writeByte(this.jtsre);
      data.writeInt(this.dam);
      data.writeFloat(this.size);
      data.writeFloat(this.rota);
   }

   public void readSpawnData(ByteBuf data) {
      int first = data.readInt();
      this.shootingEntity = first == 0 ? this.shootingEntity : this.world.func_73045_a(first);
      this.perc = data.readByte();
      this.type = data.readByte();
      this.jtsre = data.readByte();
      this.dam = data.readInt();
      this.size = data.readFloat();
      this.rota = data.readFloat();
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

   public void setJutsuName(String name) {
      this.nameJutsu = name;
   }

   public boolean func_70067_L() {
      return true;
   }

   public float func_70111_Y() {
      return 0.1F;
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return this.func_70046_E();
   }

   public AxisAlignedBB func_70046_E() {
      return this.boundingBox;
   }

   private void func_chins() {
      Vec3 var17 = Vec3.func_72443_a(this.posX, this.posY, this.posZ);
      Vec3 var3 = Vec3.func_72443_a(this.posX + this.field_70159_w, this.posY + this.field_70181_x, this.posZ + this.field_70179_y);
      MovingObjectPosition var4 = this.world.func_147447_a(var17, var3, false, true, false);
      var17 = Vec3.func_72443_a(this.posX, this.posY, this.posZ);
      var3 = Vec3.func_72443_a(this.posX + this.field_70159_w, this.posY + this.field_70181_x, this.posZ + this.field_70179_y);
      if (var4 != null) {
         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
      }

      List entityList;
      double targetDamage;
      if (!this.world.field_72995_K) {
         Entity var5 = null;
         entityList = this.world.func_72839_b(this, this.boundingBox.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
         double var7 = 0.0D;

         for(int n = 0; n < entityList.size(); ++n) {
            Entity entity = (Entity)entityList.get(n);
            if (entity.func_70067_L() && entity != this.shootingEntity) {
               float var11 = 0.0F;
               AxisAlignedBB var12 = entity.boundingBox.func_72314_b((double)var11, (double)var11, (double)var11);
               MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
               if (var13 != null) {
                  targetDamage = var17.func_72438_d(var13.field_72307_f);
                  if (targetDamage < var7 || var7 == 0.0D) {
                     var5 = entity;
                     var7 = targetDamage;
                  }
               }
            }
         }

         if (var5 != null) {
            new MovingObjectPosition(var5);
         }
      }

      if (!this.world.field_72995_K) {
         AxisAlignedBB aabb = this.boundingBox.func_72329_c();
         entityList = this.world.func_72839_b(this, aabb);

         for(int n = 0; n < entityList.size(); ++n) {
            Entity entity = (Entity)entityList.get(n);
            if (entity != this.shootingEntity && entity instanceof EntityEnAttacks) {
               long shieldPower = this.getPower(this);
               long targetPower = 0L;
               targetDamage = 0.0D;
               if (entity instanceof EntityEnergyAttJ) {
                  targetPower = ((EntityEnergyAttJ)entity).getPower(entity);
                  targetDamage = ((EntityEnergyAttJ)entity).getDamage();
               } else if (entity instanceof EntityEnergyAttJ2) {
                  targetPower = ((EntityEnergyAttJ2)entity).getPower(entity);
                  targetDamage = ((EntityEnergyAttJ2)entity).getDamage();
               }

               if (targetPower > shieldPower) {
                  if (entity instanceof EntityEnergyAttJ) {
                     ((EntityEnergyAttJ)entity).setDamage((double)((float)targetDamage - (float)this.getDamage()));
                  } else if (entity instanceof EntityEnergyAttJ2) {
                     ((EntityEnergyAttJ2)entity).setDamage((double)((float)targetDamage - (float)this.getDamage()));
                  }

                  this.setDead();
               } else if (targetPower < shieldPower) {
                  this.setDamage((double)((float)this.getDamage() - (float)targetDamage));
                  entity.setDead();
               } else {
                  entity.setDead();
                  this.setDead();
               }

               this.field_70159_w = 0.0D;
               this.field_70181_x = 0.0D;
               this.field_70179_y = 0.0D;
            }
         }
      }

   }

   public boolean func_70075_an() {
      return false;
   }
}
