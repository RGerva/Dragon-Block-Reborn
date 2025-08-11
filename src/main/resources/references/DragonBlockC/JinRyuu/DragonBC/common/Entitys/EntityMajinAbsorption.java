package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.JRMCore.Ds;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.items.ItemVanity;
import JinRyuu.JRMCore.server.JGMathHelper;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityMajinAbsorption extends Entity implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   public static final float SOUND = 0.25F;
   public static final HashMap<Class, Boolean> absorptionListResults = new HashMap();
   public Entity shootingEntity;
   public Entity target;
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private int ticksInAir = 0;
   private float speed;
   private float size = 2.0F;
   private boolean teleported = false;
   private byte mode = 0;
   private byte skillLevel = 1;
   private int bodyColor = 0;
   private float userAttack = 1.0F;
   private float userPower = 1.0F;
   private int stateID = 0;
   public float targetW = 0.0F;
   public float targetH = 0.0F;
   public double visualH = 0.0D;
   public double visualW = 0.0D;
   public double prevX = 0.0D;
   public double prevY = 0.0D;
   public double prevZ = 0.0D;
   public int prevCount = 0;
   public String absorptionData = "0,0,0+0";

   public int getShrink() {
      return this.func_70096_w().func_75679_c(20);
   }

   public float getSpe() {
      return this.speed;
   }

   public int getAirTicks() {
      return this.ticksInAir;
   }

   public void setAirTicks(int i) {
      this.ticksInAir = i;
   }

   public byte getSkillLevel() {
      return this.skillLevel;
   }

   public int getBodyColor() {
      return this.bodyColor;
   }

   public byte getMode() {
      return this.mode;
   }

   public EntityMajinAbsorption(World world) {
      super(world);
      this.func_70105_a(this.size, this.size);
   }

   public EntityMajinAbsorption(EntityLivingBase userEntity, int skillLevel, int bodyColor, float userPower, float userAttack, int stateID) {
      super(userEntity.world);
      this.setData(skillLevel, bodyColor, userPower, userAttack, stateID);
      this.speed = 1.0F * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[stateID];
      this.size = 2.0F;
      this.shootingEntity = userEntity;
      this.field_70155_l = 10.0D;
      this.func_70105_a(this.size, this.size);
      double d8 = (double)(userEntity.field_70130_N + 1.0F);
      double var10000 = (double)(userEntity.field_70131_O + 0.5F + this.size * 0.5F);
      Vec3 vec3 = userEntity.func_70040_Z();
      double x = userEntity.posX + vec3.field_72450_a * d8;
      double y = userEntity.posY + vec3.field_72448_b * d8 + (double)(userEntity.field_70131_O * 0.55F);
      double z = userEntity.posZ + vec3.field_72449_c * d8;
      this.field_70129_M = this.size * 0.5F;
      this.setLocationAndAngles(x, y, z, userEntity.func_70079_am(), userEntity.rotationPitch);
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.rotationPitch / 180.0F * 3.1415927F));
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.rotationPitch / 180.0F * 3.1415927F));
      this.field_70181_x = (double)(-MathHelper.func_76126_a(this.rotationPitch / 180.0F * 3.1415927F));
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed, 1.0F);
      this.prevX = this.posX;
      this.prevY = this.posY;
      this.prevZ = this.posZ;
   }

   public void setData(int skillLevel, int bodyColor, float userPower, float userAttack, int stateID) {
      this.skillLevel = (byte)skillLevel;
      this.bodyColor = bodyColor;
      this.userPower = userPower;
      if (userPower < 1.0F) {
         userPower = 1.0F;
      }

      this.userAttack = userAttack;
      if (userAttack < 1.0F) {
         userAttack = 1.0F;
      }

      this.stateID = stateID;
   }

   protected void entityInit() {
      this.field_70180_af.func_75682_a(20, 0);
      this.field_70180_af.func_75682_a(21, 0.0F);
      this.field_70180_af.func_75682_a(22, 0.0F);
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
      }

      if (this.ticksExisted == 1) {
         this.func_70105_a(this.size, this.size);
         this.field_70129_M = this.size * 0.5F;
      }

      super.onUpdate();
      if (this.world.field_72995_K || this.ticksExisted < JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[this.stateID][0] && (this.prevX != this.posX || this.prevY != this.posY || this.prevZ != this.posZ)) {
         this.prevCount = 0;
      } else {
         ++this.prevCount;
         if (this.prevCount >= JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[this.stateID][1]) {
            this.setDead();
         }
      }

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
            int t = this.ticksInGround / 10 * 10;
            if (this.ticksInGround == (t == 0 ? 10 : t)) {
               this.world.func_72956_a(this, "jinryuudragonbc:DBC5.majin_bodypart", 0.4F, 1.0F);
            }

            if (this.ticksInGround >= 1) {
               this.posX -= this.field_70159_w;
               this.posY -= this.field_70181_x;
               this.posZ -= this.field_70179_y;
               this.field_70159_w = 0.0D;
               this.field_70181_x = 0.0D;
               this.field_70179_y = 0.0D;
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
         if (!this.world.field_72995_K && this.ticksInAir >= 2000 && this.target == null && this.getMode() != 2) {
            this.setDead();
         }

         int t = this.ticksInAir / 10 * 10;
         if (this.ticksInAir == (t == 0 ? 10 : t)) {
            this.world.func_72956_a(this, "jinryuudragonbc:DBC5.majin_bodypart", 0.4F, 1.0F);
         }

         if (var4 != null) {
            var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
         }

         int var9;
         Entity var5;
         double HITBOX;
         List var6;
         double distY;
         Entity var10;
         double distY;
         if (!this.world.field_72995_K) {
            var5 = null;
            HITBOX = 2.0D;
            var6 = this.world.func_72839_b(this, this.boundingBox.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(2.0D, 2.0D, 2.0D));
            distY = 0.0D;
            var9 = 0;

            while(true) {
               if (var9 >= var6.size()) {
                  if (var5 != null) {
                     var4 = new MovingObjectPosition(var5);
                  }
                  break;
               }

               var10 = (Entity)var6.get(var9);
               if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
                  float var11 = 0.0F;
                  AxisAlignedBB var12 = var10.boundingBox.func_72314_b((double)var11, (double)var11, (double)var11);
                  MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
                  if (var13 != null) {
                     distY = var17.func_72438_d(var13.field_72307_f);
                     if (distY < distY || distY == 0.0D) {
                        var5 = var10;
                        distY = distY;
                     }
                  }
               }

               ++var9;
            }
         }

         if (!this.world.field_72995_K && this.target == null) {
            var5 = null;
            HITBOX = 4.0D;
            var6 = this.world.func_72839_b(this, this.boundingBox.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(4.0D, 4.0D, 4.0D));
            distY = 0.0D;

            for(var9 = 0; var9 < var6.size(); ++var9) {
               var10 = (Entity)var6.get(var9);
               if (var10 instanceof EntityLivingBase && var10 != null && ((EntityLivingBase)var10).func_70089_S() && var10 != this.shootingEntity && var10.func_70067_L() && !this.isEntityOnTheBlacklist(var10) && !JRMCoreH.isFusionSpectator(var10) && !JRMCoreH.isInCreativeMode(var10)) {
                  if (this.target == null) {
                     this.target = var10;
                     this.mode = 1;
                     this.func_70096_w().func_75692_b(20, 1);
                     this.func_70096_w().func_75692_b(21, this.target.field_70130_N);
                     this.func_70096_w().func_75692_b(22, this.target.field_70131_O);
                  } else {
                     double distX = this.target.posX - this.posX;
                     if (distX < 0.0D) {
                        distX *= -1.0D;
                     }

                     distY = this.target.posY + (double)(this.target.field_70131_O / 2.0F) - this.posY;
                     if (distY < 0.0D) {
                        distY *= -1.0D;
                     }

                     double distZ = this.target.posZ - this.posZ;
                     if (distZ < 0.0D) {
                        distZ *= -1.0D;
                     }

                     double dist = distX + distY + distZ;
                     double distX2 = var10.posX - this.posX;
                     if (distX2 < 0.0D) {
                        distX2 *= -1.0D;
                     }

                     double distY2 = var10.posY - this.posY;
                     if (distY2 < 0.0D) {
                        distY2 *= -1.0D;
                     }

                     double distZ2 = var10.posZ - this.posZ;
                     if (distZ2 < 0.0D) {
                        distZ2 *= -1.0D;
                     }

                     double dist2 = distX2 + distY2 + distZ2;
                     if (dist < dist2) {
                        this.target = var10;
                        this.mode = 1;
                        this.func_70096_w().func_75692_b(20, 1);
                        this.func_70096_w().func_75692_b(21, this.target.field_70130_N);
                        this.func_70096_w().func_75692_b(22, this.target.field_70131_O);
                     }
                  }
                  break;
               }
            }
         }

         if (var4 != null && this.target == null && this.mode <= 0 && !this.world.func_147439_a(var4.field_72311_b, var4.field_72312_c, var4.field_72309_d).func_149739_a().equals("tile.bedrock")) {
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

         Entity target = this.getMode() == 1 ? this.target : (this.getMode() == 2 ? this.shootingEntity : null);
         if (target != null) {
            double distX = target.posX - this.posX;
            distY = target.posY + (double)(target.field_70131_O / 2.0F) - this.posY;
            double distZ = target.posZ - this.posZ;
            double div = 20.0D;
            double MIN_SPEED = 0.1D;
            double HIT_DISTANCE = 0.3D;
            this.field_70159_w = distX / 20.0D;
            if (JGMathHelper.doubleSmallerThan(this.field_70159_w, MIN_SPEED)) {
               this.field_70159_w = this.field_70159_w < 0.0D ? -MIN_SPEED : MIN_SPEED;
            }

            this.field_70181_x = distY / 20.0D;
            if (JGMathHelper.doubleSmallerThan(this.field_70181_x, MIN_SPEED)) {
               this.field_70181_x = this.field_70181_x < 0.0D ? -MIN_SPEED : MIN_SPEED;
            }

            this.field_70179_y = distZ / 20.0D;
            if (JGMathHelper.doubleSmallerThan(this.field_70179_y, MIN_SPEED)) {
               this.field_70179_y = this.field_70179_y < 0.0D ? -MIN_SPEED : MIN_SPEED;
            }

            this.posX += this.field_70159_w;
            this.posY += this.field_70181_x;
            this.posZ += this.field_70179_y;
            if (!this.world.field_72995_K) {
               if (this.shootingEntity != null && this.shootingEntity.func_70089_S()) {
                  if (JGMathHelper.doubleSmallerThan(distX, HIT_DISTANCE) && JGMathHelper.doubleSmallerThan(distY, HIT_DISTANCE) && JGMathHelper.doubleSmallerThan(distZ, HIT_DISTANCE)) {
                     JGPlayerMP jgPlayer;
                     if (this.getMode() == 2) {
                        jgPlayer = new JGPlayerMP((EntityPlayer)this.shootingEntity);
                        jgPlayer.connectBaseNBT();
                        jgPlayer.setAbsorption(this.absorptionData);
                        this.world.func_72956_a(this, "jinryuudragonbc:DBC5.majin_absorption2", 0.4F, 1.0F);
                        this.setDead();
                     } else if (this.target != null && ((EntityLivingBase)this.target).func_70089_S()) {
                        jgPlayer = new JGPlayerMP((EntityPlayer)this.shootingEntity);
                        jgPlayer.connectBaseNBT();
                        if (JRMCoreH.isPowerTypeKi(jgPlayer.getPowerType()) && JRMCoreH.isRaceMajin(jgPlayer.getRace())) {
                           float attackTarget = 1.0F;
                           float healthTarget = 1.0F;
                           float kiPowerTarget = 1.0F;
                           float powerTarget;
                           if (this.target instanceof EntityPlayer) {
                              JGPlayerMP jgPlayerTarget = new JGPlayerMP((EntityPlayer)this.target);
                              jgPlayerTarget.connectBaseNBT();
                              powerTarget = (float)jgPlayerTarget.getRelease() / 100.0F;
                              int strength = jgPlayerTarget.getAttribute(0);
                              attackTarget = (float)JRMCoreH.stat(0, (EntityPlayer)this.target, 0, strength, 0.0F);
                              attackTarget = (float)((int)(attackTarget * powerTarget));
                              healthTarget = (float)jgPlayerTarget.getHealth();
                              kiPowerTarget = (float)jgPlayerTarget.getEnergyPower();
                              kiPowerTarget = (float)((int)(kiPowerTarget * powerTarget));
                           } else {
                              if (((EntityLivingBase)this.target).func_110148_a(SharedMonsterAttributes.field_111264_e) != null) {
                                 attackTarget = (float)((EntityLivingBase)this.target).func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                                 kiPowerTarget = attackTarget / 2.0F;
                              }

                              healthTarget = ((EntityLivingBase)this.target).func_110143_aJ();
                           }

                           float targetHealthOG = healthTarget;
                           attackTarget = (float)((int)(attackTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][0]));
                           healthTarget = (float)((int)(healthTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][1]));
                           kiPowerTarget = (float)((int)(kiPowerTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][2]));
                           if (attackTarget < 1.0F) {
                              attackTarget = 1.0F;
                           }

                           if (healthTarget < 1.0F) {
                              healthTarget = 1.0F;
                           }

                           if (kiPowerTarget < 1.0F) {
                              kiPowerTarget = 1.0F;
                           }

                           powerTarget = attackTarget + kiPowerTarget + healthTarget;
                           if (!(powerTarget <= this.userPower)) {
                              this.setDead();
                           } else {
                              String[] prevAbs = jgPlayer.getAbsorption().split(",");
                              this.absorptionData = "";
                              boolean isTargetPlayer = this.target instanceof EntityPlayer;
                              int i = 0;

                              while(true) {
                                 if (i >= 3) {
                                    this.mode = 2;
                                    this.func_70096_w().func_75692_b(20, 2);
                                    ((EntityLivingBase)this.target).func_70606_j(1.0F);
                                    DamageSource damagesource = Ds.causeEntityMajinAbsorptionDamage(this, this.shootingEntity);
                                    if (this.target.func_70097_a(damagesource, targetHealthOG)) {
                                       this.world.func_72956_a(this, "jinryuudragonbc:DBC5.majin_absorption", 0.3F, 1.0F);
                                    } else {
                                       this.setDead();
                                    }
                                    break;
                                 }

                                 String data;
                                 if (prevAbs.length <= i) {
                                    data = i == 2 ? "0+0" : "0";
                                 } else {
                                    data = prevAbs[i];
                                    int j;
                                    if (i == 0) {
                                       int prevValue = 0;
                                       if (prevAbs[i].length() > 0) {
                                          prevValue = Integer.parseInt(prevAbs[i]);
                                       }

                                       j = (int)(powerTarget / this.userPower * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_GAIN_MULTI);
                                       if (j < JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MIN_GAIN) {
                                          j = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MIN_GAIN;
                                       }

                                       if (JGConfigRaces.CONFIG_MAJIN_ADD_GAIN_ENABLED) {
                                          prevValue += j;
                                       } else {
                                          prevValue = j;
                                       }

                                       if (prevValue > JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL) {
                                          prevValue = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL;
                                       }

                                       data = "" + prevValue;
                                    } else if (!isTargetPlayer) {
                                       data = i == 2 ? "0+0" : "0";
                                    } else if (i == 1) {
                                       JGPlayerMP jgPlayerTarget = new JGPlayerMP((EntityPlayer)this.target);
                                       jgPlayerTarget.connectBaseNBT();
                                       data = "" + jgPlayerTarget.getRace();
                                    } else if (i == 2) {
                                       data = "";
                                       ItemStack[] stack_vanities = new ItemStack[8];

                                       for(j = 0; j < 8; ++j) {
                                          stack_vanities[j] = ExtendedPlayer.get((EntityPlayer)this.target).inventory.func_70301_a(3 + j);
                                          if (stack_vanities[j] != null && stack_vanities[j].func_77973_b() instanceof ItemVanity) {
                                             data = data + (data.length() > 0 ? "-" : "") + Item.func_150891_b(stack_vanities[j].func_77973_b()) + "+" + ((ItemVanity)stack_vanities[j].func_77973_b()).getColor(stack_vanities[j]);
                                          }
                                       }

                                       if (data.length() == 0) {
                                          data = "0+0";
                                       }
                                    }
                                 }

                                 this.absorptionData = this.absorptionData + data + (i + 1 < 3 ? "," : "");
                                 ++i;
                              }
                           }
                        } else {
                           this.setDead();
                        }
                     } else {
                        this.setDead();
                     }
                  }
               } else {
                  this.setDead();
               }
            }
         } else {
            this.posX += this.field_70159_w;
            this.posY += this.field_70181_x;
            this.posZ += this.field_70179_y;
         }

         this.mode = (byte)this.func_70096_w().func_75679_c(20);
         this.targetW = this.func_70096_w().func_111145_d(21);

         for(this.targetH = this.func_70096_w().func_111145_d(22); this.rotationPitch - this.field_70127_C >= 180.0F; this.field_70127_C += 360.0F) {
         }

         while(this.rotationYaw - this.field_70126_B < -180.0F) {
            this.field_70126_B -= 360.0F;
         }

         while(this.rotationYaw - this.field_70126_B >= 180.0F) {
            this.field_70126_B += 360.0F;
         }

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
      data.writeInt(this.target == null ? 0 : this.target.func_145782_y());
      data.writeFloat(this.speed);
      data.writeFloat(this.size);
      data.writeInt(this.bodyColor);
      data.writeByte(this.skillLevel);
      data.writeFloat(this.userPower);
      data.writeByte(this.mode);
      data.writeFloat(this.targetW);
      data.writeFloat(this.targetH);
   }

   public void readSpawnData(ByteBuf data) {
      int first = data.readInt();
      this.shootingEntity = first == 0 ? this.shootingEntity : this.world.func_73045_a(first);
      int second = data.readInt();
      this.target = second == 0 ? this.target : this.world.func_73045_a(second);
      this.speed = data.readFloat();
      this.size = data.readFloat();
      this.bodyColor = data.readInt();
      this.skillLevel = data.readByte();
      this.userPower = data.readFloat();
      this.mode = data.readByte();
      this.targetW = data.readFloat();
      this.targetH = data.readFloat();
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

   public float rad(float angle) {
      return angle * 3.1415927F / 180.0F;
   }

   public NBTTagCompound nbt(EntityPlayer p, String s) {
      NBTTagCompound nbt;
      if (s.contains("pres")) {
         if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
            nbt = new NBTTagCompound();
            p.getEntityData().func_74782_a("PlayerPersisted", nbt);
         } else {
            nbt = p.getEntityData().func_74775_l("PlayerPersisted");
         }
      } else {
         nbt = p.getEntityData();
      }

      return nbt;
   }

   public boolean addInstance(Class cl, boolean b) {
      absorptionListResults.put(cl, b);
      return b;
   }

   public boolean instanceOf(Entity entity) {
      if (JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.size() == 0) {
         return false;
      } else {
         Class entityClass = entity.getClass();
         if (absorptionListResults != null && absorptionListResults.size() > 0 && absorptionListResults.containsKey(entityClass)) {
            return (Boolean)absorptionListResults.get(entityClass);
         } else {
            String name = entityClass.toString();

            try {
               if (JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.containsKey(name)) {
                  return this.addInstance(entityClass, true);
               } else {
                  Iterator var4 = JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.keySet().iterator();

                  Class cl;
                  do {
                     String key;
                     do {
                        do {
                           if (!var4.hasNext()) {
                              return this.addInstance(entityClass, false);
                           }

                           key = (String)var4.next();
                        } while(!JRMCoreH.DBC() && key.startsWith("JinRyuu.DragonBC"));
                     } while(!JRMCoreH.NC() && key.startsWith("JinRyuu.NarutoC"));

                     cl = Class.forName(key);
                  } while(!cl.isAssignableFrom(entityClass));

                  return this.addInstance(entityClass, true);
               }
            } catch (Exception var7) {
               return this.addInstance(entityClass, false);
            }
         }
      }
   }

   public boolean isEntityOnTheBlacklist(Entity entity) {
      return this.instanceOf(entity);
   }
}
