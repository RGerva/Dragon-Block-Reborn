package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.Ds;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.server.JGMathHelper;
import JinRyuu.JRMCore.server.JGPlayerClientServerHelper;
import JinRyuu.NarutoC.common.NCJutsus;
import cpw.mods.fml.common.FMLCommonHandler;
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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnergyAttJ extends EntityEnAttacks implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private int ticksInAir = 0;
   private double damage = 1.0D;
   private int knockbackStrength;
   private float explevel;
   private String DBCExplSound = "jinryuudragonbc:DBC.expl";
   private String NCExplSound = "jinryuunarutoc:NC1.Explosion";
   private float strtX;
   private float strtY;
   private float strtZ;
   private float trgtX = 0.0F;
   private float trgtY = 0.0F;
   private float trgtZ = 0.0F;
   private byte type;
   private byte speed;
   private int dam;
   private byte perc;
   private byte pmjID;
   private short effect;
   private int color;
   private byte density;
   private short sincantation;
   private short sfire;
   private short smove;
   private byte align;
   private float size;
   private int conn;
   private int waveCount = 20;
   private byte wave = 0;
   private Entity target;
   private int cost;
   private int costPerc;
   private int originDmg;
   public boolean shrink = false;
   private int pwrtyp = 0;
   private String nameJutsu;
   private boolean givenExp = false;
   public double motionXStart;
   public double motionYStart;
   public double motionZStart;
   public float minScale;
   public float maxScale;
   public float maxDamage;
   public boolean added = false;
   public int animation_speed = 0;
   public long animation_start = 0L;
   public int animation_id = 0;
   public int animation_id_Max = 0;
   public int animation_random_Max = 0;
   public ArrayList<Integer> animation_random = new ArrayList();
   public float render_scale = 0.0F;
   public float render_scale_max = 2.0F;
   public double dist = 0.0D;
   public boolean shooterHolds;
   public boolean hadTarget = false;
   public boolean added2 = false;
   public long animation_start2 = 0L;
   public float waveScale = 1.0F;
   public double finalDist = 0.0D;
   public int lastSegments = 0;
   private boolean run = true;
   public float startRotationPitch = 0.0F;
   public float startRotationYaw = 0.0F;

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

   public float getScale() {
      float damage = (float)this.originDmg;
      byte perc = this.getPerc();
      byte den = this.getDen();
      float scale = JRMCoreH.calculateEnergyScale(damage, this.maxDamage, (float)perc, (byte[])null, den, this.minScale, this.maxScale);
      return scale;
   }

   public void setScales() {
      this.minScale = (float)JRMCoreConfig.JutsuSizeMin[this.getType()];
      this.maxScale = (float)JRMCoreConfig.JutsuSizeMax[this.getType()];
      this.maxDamage = JRMCoreH.getMaxEnergyDamage();
   }

   public float setScalesPost() {
      if (this.isWave()) {
         return 100.0F;
      } else if (this.isBlast()) {
         return 5.0F;
      } else {
         return this.isDisk() ? 5.0F : 1.0F;
      }
   }

   public float getSize() {
      return this.size;
   }

   private void shrinkWave() {
      JRMCoreH.setByte((int)0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
      if (!this.shrink) {
         this.shrink();
      }

   }

   private void shrink() {
      this.shrink = true;
      this.func_70096_w().func_75692_b(20, 1);
   }

   public boolean isContinuesWave() {
      return this.getType() >= JRMCoreConfig.ContinuesJutsuAttacks.length ? false : JRMCoreConfig.ContinuesJutsuAttacks[this.getType()];
   }

   public int getShrink() {
      return this.func_70096_w().func_75679_c(20);
   }

   public byte getType() {
      return this.type;
   }

   public int getCol() {
      return this.color;
   }

   public byte getSpe() {
      return this.speed;
   }

   public int getDam() {
      return this.dam;
   }

   public byte getDen() {
      return this.density;
   }

   public byte getPerc() {
      return this.perc;
   }

   public float getSizePerc() {
      return this.size;
   }

   public int getAirTicks() {
      return this.ticksInAir;
   }

   public short getEff() {
      return this.effect;
   }

   public void setAirTicks(int i) {
      this.ticksInAir = i;
   }

   public EntityEnergyAttJ(World par1World) {
      super(par1World);
      this.func_70105_a(this.size, this.size);
   }

   public EntityEnergyAttJ(EntityLivingBase par2EntityLivingBase, byte type, float speed, int dam, byte effect, byte color, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, int costPerc) {
      super(par2EntityLivingBase.world);
      this.type = type;
      this.shooterHolds = this.isContinuesWave();
      this.speed = (byte)((int)((speed + 1.0F) * 10.0F + (float)(type == 2 ? 10 : 0) + (float)(density == 2 ? 40 : 0)));
      this.dam = dam;
      this.perc = 50;
      this.effect = (short)effect;
      this.color = JRMCoreH.techNCCol[effect];
      this.density = density;
      this.sincantation = (short)sincantation;
      this.sfire = (short)sfire;
      this.smove = (short)smove;
      this.cost = cost;
      this.costPerc = costPerc;
      this.originDmg = dam1;
      this.pmjID = perc;
      if (this.pmjID != -1) {
         this.nameJutsu = JRMCoreH.trl("nc", JRMCoreH.pmj[this.pmjID][0]);
      }

      this.damage = (double)this.dam * (double)this.perc * 0.019999999552965164D;
      float size1;
      if (this.getType() < 3) {
         this.setScales();
         size1 = this.getScale();
      } else {
         size1 = 1.0F;
      }

      this.size = 0.5F + size1;
      if (JRMCoreConfig.JutsuScalesWithUser) {
         this.size *= this.shootingEntity == null ? 1.0F : this.shootingEntity.field_70131_O / 1.8F;
      }

      this.shootingEntity = par2EntityLivingBase;
      this.pwrtyp = 0;
      if (this.shootingEntity instanceof EntityPlayer) {
         this.pwrtyp = JRMCoreH.PlyrPwr((EntityPlayer)this.shootingEntity);
      }

      this.explevel = (float)effect;
      this.field_70155_l = 10.0D;
      this.func_70105_a(this.size, this.size);
      double d8 = (double)(par2EntityLivingBase.field_70130_N + 1.0F + 0.3F);
      double d9 = (double)(((EntityLivingBase)this.shootingEntity).field_70131_O + ((EntityLivingBase)this.shootingEntity).field_70131_O * 0.2F);
      Vec3 vec3;
      if (this.shootingEntity instanceof EntityPlayer) {
         vec3 = this.shootingEntity.func_70040_Z();
      } else {
         float rotationYaw = this.shootingEntity.func_70079_am();
         float rotationPitch = this.shootingEntity.rotationPitch;
         float vx = -MathHelper.func_76126_a(this.rad(rotationYaw)) * MathHelper.func_76134_b(this.rad(rotationPitch));
         float vz = MathHelper.func_76134_b(this.rad(rotationYaw)) * MathHelper.func_76134_b(this.rad(rotationPitch));
         float vy = -MathHelper.func_76126_a(this.rad(rotationPitch));
         vec3 = Vec3.func_72443_a((double)vx, (double)vy, (double)vz);
      }

      double x = par2EntityLivingBase.posX + vec3.field_72450_a * d8;
      double y = par2EntityLivingBase.posY + vec3.field_72448_b * d8 + (double)(par2EntityLivingBase.field_70131_O * 0.7F);
      double z = par2EntityLivingBase.posZ + vec3.field_72449_c * d8;
      this.setLocationAndAngles(x, y, z, par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
      this.field_70129_M = this.size * 0.5F;
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.rotationPitch / 180.0F * 3.1415927F));
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.rotationPitch / 180.0F * 3.1415927F));
      this.field_70181_x = (double)(-MathHelper.func_76126_a(this.rotationPitch / 180.0F * 3.1415927F));
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, (float)this.speed * 0.05F, 1.0F);
      this.strtX = (float)x;
      this.strtY = (float)y;
      this.strtZ = (float)z;
      this.motionXStart = this.field_70159_w;
      this.motionYStart = this.field_70181_x;
      this.motionZStart = this.field_70179_y;
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
      if ((JGConfigClientSettings.configsChanged || this.run) && this.world.field_72995_K && !this.field_70128_L) {
         this.field_70158_ak = JGConfigClientSettings.renderEnergyOutsideView;
      }

      if (this.isContinuesWave() && this.shooterHolds) {
         this.generateParticles(this, this.shootingEntity, this.color, true);
      }

      this.generateParticles(this, this, this.color, false);
      if (!this.run) {
         if (this.rotationPitch != this.startRotationPitch) {
            this.rotationPitch = this.startRotationPitch;
         }

         if (this.rotationYaw != this.startRotationYaw) {
            this.rotationYaw = this.startRotationYaw;
         }
      }

      boolean ROTATION_RELATED = true;
      if (this.run) {
         this.startRotationPitch = this.rotationPitch;
         this.startRotationYaw = this.rotationYaw;
         this.shooterHolds = this.isContinuesWave();
         if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)this.shootingEntity;
            ExtendedPlayer.get(player).setAnimKiShootOn(0);
         }

         this.run = false;
      }

      if (!this.world.field_72995_K && this.isContinuesWave() && this.target != null && !this.target.field_70128_L && !this.shooterHolds && JGMathHelper.isMotionSmallerThanN(this, 0.001D)) {
         this.setDead();
      }

      double y;
      double kiX;
      double var7;
      double kiZ;
      double kulx;
      double var14;
      double kuly;
      double kulz;
      float den;
      float calc;
      float res;
      double x;
      double z;
      if (JRMCoreConfig.WavesShrinkOnceLetGo) {
         if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.isContinuesWave() && this.shooterHolds) {
            x = (double)(((EntityLivingBase)this.shootingEntity).field_70130_N + 1.0F + 0.3F);
            y = (double)(((EntityLivingBase)this.shootingEntity).field_70131_O + ((EntityLivingBase)this.shootingEntity).field_70131_O * 0.2F);
            Vec3 vec3 = this.shootingEntity.func_70040_Z();
            double x = this.shootingEntity.posX + vec3.field_72450_a * x;
            double y = this.shootingEntity.posY + vec3.field_72448_b * x + (double)(this.shootingEntity.field_70131_O * 0.7F) + (double)(this.world.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F);
            double z = this.shootingEntity.posZ + vec3.field_72449_c * x;
            if (x < 0.0D) {
               x *= -1.0D;
            }

            if (y < 0.0D) {
               y *= -1.0D;
            }

            if (z < 0.0D) {
               z *= -1.0D;
            }

            double kiX = (double)this.strtX;
            if (kiX < 0.0D) {
               kiX *= -1.0D;
            }

            var14 = (double)this.strtY;
            if (var14 < 0.0D) {
               var14 *= -1.0D;
            }

            double kiZ = (double)this.strtZ;
            if (kiZ < 0.0D) {
               kiZ *= -1.0D;
            }

            double kulx = x - kiX;
            if (kulx < 0.0D) {
               kulx *= -1.0D;
            }

            double kuly = y - var14;
            if (kuly < 0.0D) {
               kuly *= -1.0D;
            }

            double kulz = z - kiZ;
            if (kulz < 0.0D) {
               kulz *= -1.0D;
            }

            calc = 0.2F;
            res = 1.0F;
            if (kulx > 0.20000000298023224D || kuly > 1.0D || kulz > 0.20000000298023224D) {
               this.shooterHolds = false;
               EntityPlayer player = (EntityPlayer)this.shootingEntity;
               ExtendedPlayer.get(player).setAnimKiShoot(0);
               if (!this.world.field_72995_K) {
                  JRMCoreH.setByte((int)0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
                  this.shrinkWave();
               } else {
                  JRMCoreH.isShtng = false;
               }
            }
         }
      } else if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.isContinuesWave() && this.shooterHolds) {
         x = (double)this.strtX;
         y = (double)this.strtY;
         z = (double)this.strtZ;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         if (y < 0.0D) {
            y *= -1.0D;
         }

         if (z < 0.0D) {
            z *= -1.0D;
         }

         kiX = this.shootingEntity.posX;
         if (kiX < 0.0D) {
            kiX *= -1.0D;
         }

         var7 = this.shootingEntity.posY + (double)(this.world.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F);
         if (var7 < 0.0D) {
            var7 *= -1.0D;
         }

         kiZ = this.shootingEntity.posZ;
         if (kiZ < 0.0D) {
            kiZ *= -1.0D;
         }

         kulx = x - kiX;
         if (kulx < 0.0D) {
            kulx *= -1.0D;
         }

         kuly = y - var7;
         if (kuly < 0.0D) {
            kuly *= -1.0D;
         }

         kulz = z - kiZ;
         if (kulz < 0.0D) {
            kulz *= -1.0D;
         }

         den = 3.0F;
         if (kulx > 3.0D || kuly > 3.0D || kulz > 3.0D) {
            this.shooterHolds = false;
            EntityPlayer player = (EntityPlayer)this.shootingEntity;
            ExtendedPlayer.get(player).setAnimKiShoot(0);
            if (!this.world.field_72995_K) {
               JRMCoreH.setByte((int)0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
            } else {
               JRMCoreH.isShtng = false;
            }
         }
      }

      if (!this.world.field_72995_K && this.isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackEnemyLock && this.target != null && !this.target.field_70128_L && this.shooterHolds) {
         x = this.posX;
         y = this.posY;
         z = this.posZ;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         if (y < 0.0D) {
            y *= -1.0D;
         }

         if (z < 0.0D) {
            z *= -1.0D;
         }

         kiX = this.target.posX;
         if (kiX < 0.0D) {
            kiX *= -1.0D;
         }

         var7 = this.target.posY;
         if (var7 < 0.0D) {
            var7 *= -1.0D;
         }

         kiZ = this.target.posZ;
         if (kiZ < 0.0D) {
            kiZ *= -1.0D;
         }

         kulx = x - kiX;
         if (kulx < 0.0D) {
            kulx *= -1.0D;
         }

         kuly = y - var7;
         if (kuly < 0.0D) {
            kuly *= -1.0D;
         }

         kulz = z - kiZ;
         if (kulz < 0.0D) {
            kulz *= -1.0D;
         }

         den = 0.5F;
         if (kulx > 0.5D || kuly > 0.5D || kulz > 0.5D) {
            this.target.posX = x;
            this.target.posY = y;
            this.target.posZ = z;
            this.target.posX = this.posX;
            this.target.posY = this.posY;
            this.target.posZ = this.posZ;
            this.target.field_70159_w = this.field_70159_w;
            this.target.field_70181_x = this.field_70181_x;
            this.target.field_70179_y = this.field_70179_y;
         }
      }

      if (!this.world.field_72995_K && this.isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown && JRMCoreConfig.ContinuesEnergyAttackMoveOnLostTarget && this.target != null && !this.target.field_70128_L && this.shooterHolds && JGMathHelper.isMotionSmallerThanN(this, 0.001D)) {
         x = this.posX;
         y = this.posY;
         z = this.posZ;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         if (y < 0.0D) {
            y *= -1.0D;
         }

         if (z < 0.0D) {
            z *= -1.0D;
         }

         kiX = this.target.posX;
         if (kiX < 0.0D) {
            kiX *= -1.0D;
         }

         var7 = this.target.posY;
         if (var7 < 0.0D) {
            var7 *= -1.0D;
         }

         kiZ = this.target.posZ;
         if (kiZ < 0.0D) {
            kiZ *= -1.0D;
         }

         kulx = x - kiX;
         if (kulx < 0.0D) {
            kulx *= -1.0D;
         }

         kuly = y - var7;
         if (kuly < 0.0D) {
            kuly *= -1.0D;
         }

         kulz = z - kiZ;
         if (kulz < 0.0D) {
            kulz *= -1.0D;
         }

         den = this.size + 1.0F;
         if (kulx > (double)den || kuly > (double)den || kulz > (double)den) {
            this.target = null;
            this.hadTarget = false;
            this.field_70159_w = this.motionXStart;
            this.field_70181_x = this.motionYStart;
            this.field_70179_y = this.motionZStart;
         }
      }

      if (!this.world.field_72995_K && JRMCoreConfig.WavesDieWhenTargetAway && this.shootingEntity != null && this.target != null && this.shootingEntity instanceof EntityPlayer && this.isContinuesWave()) {
         x = this.posX;
         y = this.posY;
         z = this.posZ;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         if (y < 0.0D) {
            y *= -1.0D;
         }

         if (z < 0.0D) {
            z *= -1.0D;
         }

         kiX = this.target.posX;
         if (kiX < 0.0D) {
            kiX *= -1.0D;
         }

         var7 = this.target.posY;
         if (var7 < 0.0D) {
            var7 *= -1.0D;
         }

         kiZ = this.target.posZ;
         if (kiZ < 0.0D) {
            kiZ *= -1.0D;
         }

         kulx = x - kiX;
         if (kulx < 0.0D) {
            kulx *= -1.0D;
         }

         kuly = y - var7;
         if (kuly < 0.0D) {
            kuly *= -1.0D;
         }

         kulz = z - kiZ;
         if (kulz < 0.0D) {
            kulz *= -1.0D;
         }

         den = this.size + 1.0F;
         if (kulx > (double)den || kuly > (double)den || kulz > (double)den) {
            if (this.type >= 0 && this.type < 2) {
               if (this.field_70131_O > 1.5F) {
                  this.createExplosion(0);
               }

               this.world.func_72956_a(this, this.pwrtyp == 1 ? this.DBCExplSound : (this.pwrtyp == 2 ? this.NCExplSound : ""), 1.0F, 1.0F);
            }

            this.setDead();
         }
      }

      if (!this.world.field_72995_K && this.shootingEntity == null) {
         this.setDead();
      }

      if (!this.world.field_72995_K && this.shootingEntity == null) {
         this.setDead();
      }

      if (!this.world.field_72995_K && this.isContinuesWave() && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
         byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
         if (b == 0 && !this.shrink && JRMCoreConfig.WavesShrinkOnceLetGo) {
            this.shrink();
         }
      }

      if (!this.world.field_72995_K && this.isContinuesWave() && this.hadTarget && (this.target == null || this.target.field_70128_L)) {
         this.setDead();
      }

      Entity var10000;
      if (this.isContinuesWave() && this.target != null) {
         if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) {
            this.field_70159_w *= 0.05000000074505806D;
            this.field_70181_x *= 0.05000000074505806D;
            this.field_70179_y *= 0.05000000074505806D;
            var10000 = this.target;
            var10000.field_70159_w *= 0.05000000074505806D;
            var10000 = this.target;
            var10000.field_70181_x *= 0.05000000074505806D;
            var10000 = this.target;
            var10000.field_70179_y *= 0.05000000074505806D;
         } else {
            this.target.field_70159_w = this.field_70159_w;
            this.target.field_70181_x = this.field_70181_x;
            this.target.field_70179_y = this.field_70179_y;
            this.target.posX = this.posX;
            this.target.posY = this.posY;
            this.target.posZ = this.posZ;
         }
      }

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
                  if (this.type >= 0 && this.type < 2) {
                     if (this.field_70131_O > 1.5F) {
                        this.createExplosion(0);
                     }

                     this.world.func_72956_a(this, this.pwrtyp == 1 ? this.DBCExplSound : (this.pwrtyp == 2 ? this.NCExplSound : ""), 1.0F, 1.0F);
                  }

                  if (this.density == 2) {
                     EntityPlayer shtr = (EntityPlayer)this.shootingEntity;
                     shtr.func_145747_a(new ChatComponentText(JRMCoreH.cly + this.nameJutsu + " failed!"));
                  }
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
         if (!this.world.field_72995_K && ((float)this.ticksInAir >= (float)JRMCoreConfig.EnergyAttackMaxLifeTickPercMulti * (float)this.perc * 0.02F || this.ticksInAir >= JRMCoreConfig.EnergyAttackMaxLifeTick)) {
            this.setDead();
         }

         if (var4 != null) {
            var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
         }

         float var11;
         List var5;
         int var9;
         Entity var10;
         if (!this.world.field_72995_K) {
            Entity var5 = null;
            var5 = this.world.func_72839_b(this, this.boundingBox.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
            var7 = 0.0D;
            var9 = 0;

            while(true) {
               if (var9 >= var5.size()) {
                  if (var5 != null) {
                     var4 = new MovingObjectPosition(var5);
                  }
                  break;
               }

               var10 = (Entity)var5.get(var9);
               if (var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
                  var11 = 0.0F;
                  AxisAlignedBB var12 = var10.boundingBox.func_72314_b((double)var11, (double)var11, (double)var11);
                  MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
                  if (var13 != null) {
                     var14 = var17.func_72438_d(var13.field_72307_f);
                     if (var14 < var7 || var7 == 0.0D) {
                        var5 = var10;
                        var7 = var14;
                     }
                  }
               }

               ++var9;
            }
         }

         if (this.field_70159_w <= 0.01D && this.field_70181_x <= 0.01D && this.field_70179_y <= 0.01D && this.field_70159_w >= -0.01D && this.field_70181_x >= -0.01D && this.field_70179_y >= -0.01D && !this.shrink && !this.isContinuesWave()) {
            this.shrink();
         }

         int d;
         if (!this.world.field_72995_K) {
            var5 = null;
            AxisAlignedBB aabb = this.boundingBox.func_72329_c();
            List var6 = this.world.func_72839_b(this, aabb);

            for(var9 = 0; var9 < var6.size(); ++var9) {
               var10 = (Entity)var6.get(var9);
               if (var10 != this.shootingEntity) {
                  if (this.isContinuesWave() && var10 instanceof EntityLivingBase) {
                     if (var4 == null) {
                        var4 = new MovingObjectPosition(var10);
                     }

                     if (this.target == null) {
                        this.target = var10;
                     }
                  } else if (this.isContinuesWave() && this.wave > 0 && this.shootingEntity instanceof EntityPlayer) {
                     this.shrinkWave();
                  } else if (!(var10 instanceof EntityEnAttacks) && var10 != this.shootingEntity) {
                     if (this.type >= 0 && this.type < 2 && this.field_70131_O > 1.5F) {
                        this.createExplosion(0);
                        this.setDead();
                     }
                  } else {
                     float spet;
                     float power;
                     short eff;
                     int td;
                     int ad;
                     float spe;
                     float dam;
                     float damt;
                     float dent;
                     int var77;
                     if (var10 instanceof EntityEnergyAttJ) {
                        EntityEnergyAttJ t = (EntityEnergyAttJ)var10;
                        d = (int)t.getDamage();
                        eff = t.getEff();
                        ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
                        td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
                        if (ad == td) {
                           this.setDead();
                        }

                        if (td == 0) {
                           t.setDead();
                        } else {
                           t.setDamage((double)td);
                        }

                        dam = (float)(t.getDamage() / 2.0D);
                        spe = (float)t.getSpe() * 2.0F;
                        den = (float)t.getDen() * 10.0F;
                        damt = (float)(this.damage / 2.0D);
                        spet = (float)this.speed * 2.0F;
                        dent = (float)this.density * 10.0F;
                        power = damt - dam + (spe - spet) + (dent - den);
                        calc = 1.0F - power * 0.01F;
                        if (this.conn == 0) {
                           ++this.conn;
                        }

                        if (this.conn == 1) {
                           if (power > 0.0F) {
                              res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
                              this.field_70159_w *= (double)res;
                              this.field_70181_x *= (double)res;
                              this.field_70179_y *= (double)res;
                              t.field_70159_w = this.field_70159_w;
                              t.field_70181_x = this.field_70181_x;
                              t.field_70179_y = this.field_70179_y;
                              if (t.getAirTicks() < this.ticksInAir) {
                                 t.getAirTicks();
                              } else {
                                 var77 = this.ticksInAir;
                              }

                              if (t.getAirTicks() < this.ticksInAir) {
                                 this.ticksInAir = t.getAirTicks();
                              }
                           }

                           this.conn = 2;
                        }
                     } else if (var10 instanceof EntityEnergyAttJ2) {
                        EntityEnergyAttJ2 t = (EntityEnergyAttJ2)var10;
                        d = (int)t.getDamage();
                        eff = t.getEff();
                        ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
                        td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
                        if (ad == td) {
                           this.setDead();
                        }

                        if (td == 0) {
                           t.setDead();
                        } else {
                           t.setDamage((double)td);
                        }

                        dam = (float)(t.getDamage() / 2.0D);
                        spe = t.getSpe() * 2.0F;
                        den = (float)t.getDen() * 10.0F;
                        damt = (float)(this.damage / 2.0D);
                        spet = (float)this.speed * 2.0F;
                        dent = (float)this.density * 10.0F;
                        power = damt - dam + (spe - spet) + (dent - den);
                        calc = 1.0F - power * 0.01F;
                        if (this.conn == 0) {
                           ++this.conn;
                        }

                        if (this.conn == 1) {
                           if (power > 0.0F) {
                              res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
                              this.field_70159_w *= (double)res;
                              this.field_70181_x *= (double)res;
                              this.field_70179_y *= (double)res;
                              t.field_70159_w = this.field_70159_w;
                              t.field_70181_x = this.field_70181_x;
                              t.field_70179_y = this.field_70179_y;
                              if (t.getAirTicks() < this.ticksInAir) {
                                 t.getAirTicks();
                              } else {
                                 var77 = this.ticksInAir;
                              }

                              if (t.getAirTicks() < this.ticksInAir) {
                                 this.ticksInAir = t.getAirTicks();
                              }
                           }

                           this.conn = 2;
                        }
                     }
                  }
               }
            }
         }

         int var23;
         float var25;
         int var23;
         if (var4 != null && var4.field_72308_g != this.shootingEntity) {
            if (var4.field_72308_g != null && (this.shootingEntity instanceof EntityPlayer || var4.field_72308_g instanceof EntityPlayer) && this.isContinuesWave() && this.shooterHolds) {
               if (this.shootingEntity instanceof EntityPlayer) {
                  this.trgtX = (float)this.posX;
                  this.trgtY = (float)this.posY;
                  this.trgtZ = (float)this.posZ;
                  byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
                  if (b == 1) {
                     if (this.target != null) {
                        if (this.waveCount == 20) {
                           ++this.wave;
                           if (JRMCoreConfig.ContinuesEnergyAttackTimer == 0 && this.wave > 2) {
                              this.wave = 2;
                           }

                           if (!this.world.field_72995_K) {
                              EntityPlayer Player = (EntityPlayer)this.shootingEntity;
                              byte curRel = JRMCoreH.getByte(Player, "jrmcRelease");
                              int curEn = JRMCoreH.getInt(Player, "jrmcEnrgy");
                              float cost2 = (float)((double)this.cost * (double)curRel * 0.009999999776482582D * (double)((float)this.perc * 0.02F));
                              if (!((float)curEn - cost2 > 0.0F)) {
                                 this.setDead();
                              }

                              if (cost2 < (float)curEn) {
                                 if (!JRMCoreH.isInCreativeMode(this.shootingEntity)) {
                                    JRMCoreH.setInt((float)curEn - cost2, Player, "jrmcEnrgy");
                                 }

                                 this.damage = (double)this.originDmg * (double)curRel * 0.009999999776482582D * (double)this.perc * 0.019999999552965164D * JRMCoreConfig.dat5696[this.type][1];
                              } else {
                                 this.setDead();
                              }
                           }

                           var23 = (int)this.damage;
                           DamageSource damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
                           if (this.target.func_70097_a(damagesource, (float)var23)) {
                           }

                           if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) {
                              this.field_70159_w *= 0.05000000074505806D;
                              this.field_70181_x *= 0.05000000074505806D;
                              this.field_70179_y *= 0.05000000074505806D;
                              var10000 = this.target;
                              var10000.field_70159_w *= 0.05000000074505806D;
                              var10000 = this.target;
                              var10000.field_70181_x *= 0.05000000074505806D;
                              var10000 = this.target;
                              var10000.field_70179_y *= 0.05000000074505806D;
                           } else {
                              this.target.field_70159_w = this.field_70159_w;
                              this.target.field_70181_x = this.field_70181_x;
                              this.target.field_70179_y = this.field_70179_y;
                              this.target.posX = this.posX;
                              this.target.posY = this.posY;
                              this.target.posZ = this.posZ;
                           }
                        }

                        this.target.field_70159_w = this.field_70159_w;
                        this.target.field_70181_x = this.field_70181_x;
                        this.target.field_70179_y = this.field_70179_y;
                     }

                     --this.waveCount;
                     if (this.waveCount <= 0) {
                        this.waveCount = 20;
                     }

                     if (JRMCoreConfig.ContinuesEnergyAttackTimer > 0 && this.wave >= JRMCoreConfig.ContinuesEnergyAttackTimer) {
                        this.setDead();
                     }
                  } else {
                     this.shrinkWave();
                  }
               }

               if (var4.field_72308_g instanceof EntityLivingBase) {
                  this.setTarget(var4.field_72308_g);
               } else {
                  this.shrinkWave();
               }
            } else if (var4.field_72308_g != null && this.isContinuesWave()) {
               if (var4.field_72308_g instanceof EntityLivingBase) {
                  this.target = var4.field_72308_g;
               } else {
                  this.shrinkWave();
               }
            } else {
               float var20;
               if (var4.field_72308_g == null) {
                  this.xTile = var4.field_72311_b;
                  this.yTile = var4.field_72312_c;
                  this.zTile = var4.field_72309_d;
                  this.inTile = this.world.func_147439_a(this.xTile, this.yTile, this.zTile);
                  this.inData = this.world.func_72805_g(this.xTile, this.yTile, this.zTile);
                  var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                  this.posX -= this.field_70159_w / (double)var20 * 0.05000000074505806D;
                  this.posY -= this.field_70181_x / (double)var20 * 0.05000000074505806D;
                  this.posZ -= this.field_70179_y / (double)var20 * 0.05000000074505806D;
                  this.inGround = true;
                  if (this.inTile.func_149688_o() != Material.field_151579_a) {
                     this.inTile.func_149670_a(this.world, this.xTile, this.yTile, this.zTile, this);
                  }
               } else {
                  var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                  var23 = (int)this.damage;
                  if (this.density == 2 && this.shootingEntity != null) {
                     var23 = 0;
                     if (!this.world.field_72995_K && var4.field_72308_g instanceof EntityPlayer) {
                        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                        EntityPlayer Player = (EntityPlayer)var4.field_72308_g;
                        int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(Player);
                        String[] PlyrSkills = JRMCoreH.getString(Player, "jrmcSSlts").split(",");
                        d = this.dam;
                        int t2 = d > 30 ? 30 : (d < 1 ? 1 : d);
                        NCJutsus.wgi(server, "1;" + this.pmjID + ";" + this.dam + ";" + t2 + ";" + t2, Player.getName(), false);
                        EntityPlayer shtr = (EntityPlayer)this.shootingEntity;
                        shtr.func_145747_a(new ChatComponentText(JRMCoreH.cly + "Target " + Player.getName() + " under the effect of " + this.nameJutsu));
                     }
                  } else if (this.density == 2) {
                     this.setDead();
                  }

                  if (JRMCoreH.DGE(var4.field_72308_g) && !this.givenExp) {
                     JRMCoreH.jrmcExp(this.shootingEntity, 1, this.getType());
                     this.givenExp = true;
                  }

                  DamageSource damagesource = null;
                  if (this.shootingEntity == null) {
                     this.setDead();
                  } else {
                     damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
                  }

                  if (this.func_70027_ad()) {
                     var4.field_72308_g.func_70015_d(5);
                  }

                  if (this.density != 2 && var4.field_72308_g.func_70097_a(damagesource, (float)var23)) {
                     if (var4.field_72308_g instanceof EntityLivingBase) {
                        if (!this.world.field_72995_K) {
                           EntityLivingBase var24 = (EntityLivingBase)var4.field_72308_g;
                           if (!this.world.field_72995_K) {
                           }
                        }

                        if (this.knockbackStrength > 0) {
                           var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                           if (var25 > 0.0F) {
                              var4.field_72308_g.func_70024_g(this.field_70159_w * (double)this.knockbackStrength * 0.6000000238418579D / (double)var25, 0.1D, this.field_70179_y * (double)this.knockbackStrength * 0.6000000238418579D / (double)var25);
                           }
                        }
                     }

                     if (this.type >= 0 && this.type <= 2 && this.field_70131_O > 1.5F) {
                        this.createExplosion(0);
                     }

                     this.setDead();
                  } else {
                     this.field_70159_w *= -0.10000000149011612D;
                     this.field_70181_x *= -0.10000000149011612D;
                     this.field_70179_y *= -0.10000000149011612D;
                     this.rotationYaw += 180.0F;
                     this.field_70126_B += 180.0F;
                     this.setDead();
                     this.ticksInAir = 0;
                  }
               }
            }
         }

         this.posX += this.field_70159_w;
         this.posY += this.field_70181_x;
         this.posZ += this.field_70179_y;

         for(var23 = 0; this.rotationPitch - this.field_70127_C >= 180.0F && var23 < 20; ++var23) {
            this.field_70127_C += 360.0F;
         }

         for(var23 = 0; this.rotationYaw - this.field_70126_B < -180.0F && var23 < 20; ++var23) {
            this.field_70126_B -= 360.0F;
         }

         for(var23 = 0; this.rotationYaw - this.field_70126_B >= 180.0F && var23 < 20; ++var23) {
            this.field_70126_B += 360.0F;
         }

         float var22 = 1.0F;
         var11 = 0.0F;
         if (this.func_70090_H()) {
            for(var23 = 0; var23 < 4; ++var23) {
               var25 = 0.25F;
               this.world.func_72869_a("bubble", this.posX - this.field_70159_w * (double)var25, this.posY - this.field_70181_x * (double)var25, this.posZ - this.field_70179_y * (double)var25, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }

            var22 = 1.0F;
         }

         this.field_70159_w *= (double)var22;
         this.field_70181_x *= (double)var22;
         this.field_70179_y *= (double)var22;
         this.field_70181_x -= (double)var11;
         this.func_70107_b(this.posX, this.posY, this.posZ);
         this.doBlockCollisions();
      }

      if (this.world.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) {
         EntityPlayer player = (EntityPlayer)this.shootingEntity;
         ExtendedPlayer.get(player).setAnimKiShoot(0);
         this.shrinkWave();
      }

   }

   public void setDead() {
      super.setDead();
      if (this.world.field_72995_K && this.world.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) {
         EntityPlayer player = (EntityPlayer)this.shootingEntity;
         ExtendedPlayer.get(player).setAnimKiShoot(0);
         this.shrinkWave();
         JRMCoreH.isShtng = false;
      }

   }

   public long getPower(Entity entity) {
      return (long)(this.getDamage() / 2.0D);
   }

   private void doBlockCollisions() {
      this.func_145775_I();
   }

   public void writeEntityToNBT(NBTTagCompound nbt) {
      nbt.func_74777_a("xTile", (short)this.xTile);
      nbt.func_74777_a("yTile", (short)this.yTile);
      nbt.func_74777_a("zTile", (short)this.zTile);
      nbt.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
      nbt.func_74774_a("inData", (byte)this.inData);
      nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
      nbt.func_74780_a("damage", this.damage);
   }

   public void readEntityFromNBT(NBTTagCompound nbt) {
      this.xTile = nbt.func_74765_d("xTile");
      this.yTile = nbt.func_74765_d("yTile");
      this.zTile = nbt.func_74765_d("zTile");
      this.inTile = Block.func_149729_e(nbt.func_74771_c("inTile") & 255);
      this.inData = nbt.func_74771_c("inData") & 255;
      this.inGround = nbt.func_74771_c("inGround") == 1;
      if (nbt.func_74764_b("damage")) {
         this.damage = nbt.func_74769_h("damage");
      }

   }

   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
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
      this.knockbackStrength = par1;
   }

   public boolean func_70075_an() {
      return false;
   }

   public boolean func_82704_a(Entity var1) {
      return false;
   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.shootingEntity == null ? 0 : this.shootingEntity.func_145782_y());
      data.writeInt(this.target == null ? 0 : this.target.func_145782_y());
      data.writeByte(this.perc);
      data.writeByte(this.type);
      data.writeInt(this.color);
      data.writeInt(this.dam);
      data.writeByte(this.density);
      data.writeShort(this.sincantation);
      data.writeShort(this.sfire);
      data.writeShort(this.smove);
      data.writeFloat(this.strtX);
      data.writeFloat(this.strtY);
      data.writeFloat(this.strtZ);
      data.writeFloat(this.size);
      data.writeFloat(this.trgtX);
      data.writeFloat(this.trgtY);
      data.writeFloat(this.trgtZ);
      data.writeByte(this.shrink ? 1 : 0);
      data.writeShort(this.effect);
      data.writeDouble(this.damage);
   }

   public void readSpawnData(ByteBuf data) {
      int first = data.readInt();
      this.shootingEntity = first == 0 ? this.shootingEntity : this.world.func_73045_a(first);
      int second = data.readInt();
      this.target = first == 0 ? this.target : this.world.func_73045_a(second);
      this.perc = data.readByte();
      this.type = data.readByte();
      this.color = data.readInt();
      this.dam = data.readInt();
      this.density = data.readByte();
      this.sincantation = data.readShort();
      this.sfire = data.readShort();
      this.smove = data.readShort();
      this.strtX = data.readFloat();
      this.strtY = data.readFloat();
      this.strtZ = data.readFloat();
      this.size = data.readFloat();
      this.trgtX = data.readFloat();
      this.trgtY = data.readFloat();
      this.trgtZ = data.readFloat();
      this.shrink = data.readByte() == 1;
      this.effect = data.readShort();
      this.damage = data.readDouble();
   }

   public boolean isWave() {
      return this.getType() == 0;
   }

   public boolean isBlast() {
      return this.getType() == 1;
   }

   public boolean isDisk() {
      return this.getType() == 2;
   }

   public boolean isFireElement() {
      return this.getEff() == 0;
   }

   public boolean isWindElement() {
      return this.getEff() == 1;
   }

   public boolean isLightningElement() {
      return this.getEff() == 2;
   }

   public boolean isEarthElement() {
      return this.getEff() == 3;
   }

   public boolean isWaterElement() {
      return this.getEff() == 4;
   }

   private void createExplosion(int type) {
      JRMCoreH.newExpl(this.world, this, this.posX, this.posY, this.posZ, this.size, false, this.damage, this.shootingEntity, (byte)type);
   }

   private void setTarget(Entity entity) {
      this.target = entity;
      this.hadTarget = true;
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

   public void generateParticles(EntityEnergyAttJ entityBlast, Entity entity, int color, boolean startSpawn) {
      if (entityBlast != null && entity != null && entityBlast.world.field_72995_K) {
         for(int i = 0; i < 3; ++i) {
            for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
               float colorFixer = 0.7F;
               float red = (float)(color >> 16 & 255) / 255.0F;
               float green = (float)(color >> 8 & 255) / 255.0F;
               float blue = (float)(color & 255) / 255.0F;
               red *= 0.7F;
               green *= 0.7F;
               blue *= 0.7F;
               float red2 = red * 2.0F;
               if (red2 > 1.0F) {
                  red2 = 1.0F;
               }

               float blue2 = blue * 2.0F;
               if (blue2 > 1.0F) {
                  blue2 = 1.0F;
               }

               float green2 = green * 2.0F;
               if (green2 > 1.0F) {
                  green2 = 1.0F;
               }

               float alpha = 1.0F;
               float out = 1.0F;
               float in = 1.5F;
               float life = 0.4F * entity.field_70131_O;
               float extra_scale = 0.3F;
               int dea = true;
               float target_fullsize_one1 = 0.32F;
               float targetsizeMin = entity.field_70131_O * (8.0F / target_fullsize_one1) * 0.01F;
               float target_fullsize_one2 = 0.32F;
               float targetsizeMax = entity.field_70131_O * (26.0F / target_fullsize_one2) * 0.01F;
               double x = (Math.random() * (double)(entity.field_70131_O * 2.0F) - (double)entity.field_70131_O) * 0.800000011920929D;
               double y = (Math.random() * (double)(entity.field_70131_O * 2.0F) - (double)entity.field_70131_O) * 0.800000011920929D;
               double z = (Math.random() * (double)(entity.field_70131_O * 2.0F) - (double)entity.field_70131_O) * 0.800000011920929D;
               Vec3 vec3 = entity.func_70040_Z();
               double d8 = (double)(entity.field_70130_N + (startSpawn ? 0.0F : 1.5F));
               double d9 = (double)entity.field_70131_O;
               double x2;
               double y2;
               double z2;
               if (startSpawn) {
                  x2 = (double)entityBlast.strtX();
                  y2 = (double)entityBlast.strtY();
                  z2 = (double)entityBlast.strtZ();
                  x2 += vec3.field_72450_a * d8;
                  y2 += vec3.field_72448_b * d9 + (double)(entity.field_70131_O * 0.4F);
                  z2 += vec3.field_72449_c * d8;
               } else {
                  x2 = entityBlast.posX;
                  y2 = entityBlast.posY;
                  z2 = entityBlast.posZ;
               }

               x2 += x;
               y2 += y;
               z2 += z;
               float rotationYaw = -entityBlast.rotationYaw;
               float rotationPitch = -entityBlast.rotationPitch;
               double motionX = (double)(-MathHelper.func_76126_a(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
               double motionZ = (double)(MathHelper.func_76134_b(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
               double motionY = (double)(-MathHelper.func_76126_a(rotationPitch / 180.0F * 3.1415927F));
               if (startSpawn) {
                  x2 += -motionX * 3.0D;
                  y2 += -motionY * 3.0D;
                  y2 -= (double)entityBlast.field_70131_O * 0.25D;
                  z2 += -motionZ * 3.0D;
               }

               motionX *= 0.5D;
               motionY *= 0.5D;
               motionY += (double)((float)(Math.random() * 0.10000000149011612D) - 0.05F);
               motionZ *= 0.5D;
               if (startSpawn) {
                  motionX *= -1.0D;
                  motionY *= -1.0D;
                  motionZ *= -1.0D;
               }

               float scaleStart = ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.3F;
               float scaleEnd = ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.3F;
               float scaleSpeed = 0.2F * life * 0.3F;
               int textureID = (int)(Math.random() * 3.0D) + 8;
               Entity particle = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.world, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart, scaleEnd, scaleStart, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, (Entity)null);
               entity.world.func_72838_d(particle);
               Entity particle2 = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.world, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart * 0.8F, scaleEnd * 0.8F, scaleStart * 0.8F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, (Entity)null);
               entity.world.func_72838_d(particle2);
            }
         }
      }

   }

   public float rad(float angle) {
      return angle * 3.1415927F / 180.0F;
   }
}
