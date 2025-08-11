package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCFlyingCharge;
import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCGroundDash;
import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCGroundJump;
import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCKiAttackCharge;
import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCTeleport;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.JGRenderHelper;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import JinRyuu.JRMCore.entity.aai.AAi;
import JinRyuu.JRMCore.entity.aai.AAiSystem;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityDBC extends EntityCreature implements IMob {
   public static final double DISTANCE_LENGTH_MAX = 64.0D;
   public static final double DISTANCE_LENGTH_MIN = 4.0D;
   protected String texture;
   private double moveSpeed;
   private int rang;
   private boolean updtd;
   public int angerLevel;
   private int aggroCooldown;
   public int prevAttackCounter;
   public int attackCounter;
   private Entity targetedEntity;
   private byte data1;
   private byte data2;
   private byte data3;
   private byte data4;
   private boolean blst;
   public boolean canFly;
   public boolean canFireKiAttacks;
   public boolean kiBarrageType0;
   public int kiAttackTimer;
   public int kiAttackTimerMin;
   public boolean chargingKiAttack;
   public int chargingKiAttackTimer;
   public int chargingKiAttackTimerMax;
   public AAiSystem aaiSystem;
   public boolean hasAAiKiChargeSystem;
   public Entity lockedBy;
   public int difficultyID;
   public boolean aggressive;
   public static final int STYLE_EASY = 0;
   public static final int STYLE_MEDIUM = 1;
   public static final int STYLE_HARD = 2;
   public static final int STYLE_INSANE = 3;

   public void setData1(int data) {
      this.data1 = (byte)data;
   }

   public void setData2(int data) {
      this.data2 = (byte)data;
   }

   public void setData3(int data) {
      this.data3 = (byte)data;
   }

   public void setData4(int data) {
      this.data4 = (byte)data;
   }

   public boolean doBlst() {
      if (this.blst) {
         this.blst = false;
         return true;
      } else {
         return false;
      }
   }

   public EntityDBC(World par1World) {
      super(par1World);
      this.moveSpeed = DBCConfig.EnemyDefaultMoveSpeed;
      this.rang = 0;
      this.updtd = false;
      this.angerLevel = 0;
      this.aggroCooldown = 0;
      this.prevAttackCounter = 0;
      this.attackCounter = 0;
      this.targetedEntity = null;
      this.data1 = 1;
      this.data2 = 0;
      this.data3 = 0;
      this.data4 = 0;
      this.blst = false;
      this.canFly = true;
      this.canFireKiAttacks = true;
      this.kiBarrageType0 = true;
      this.kiAttackTimer = 80;
      this.kiAttackTimerMin = 5;
      this.chargingKiAttack = false;
      this.chargingKiAttackTimer = 0;
      this.chargingKiAttackTimerMax = 0;
      this.hasAAiKiChargeSystem = false;
      this.lockedBy = null;
      this.difficultyID = 0;
      this.aggressive = true;
      this.field_70728_aV = 5;
      this.func_94058_c("");
      this.func_94061_f(false);
      this.moveSpeed = DBCConfig.EnemyDefaultMoveSpeed;
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return this.texture;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
   }

   protected void entityInit() {
      super.entityInit();
      this.field_70180_af.func_75682_a(23, new Integer(0));
   }

   protected boolean func_70650_aV() {
      return false;
   }

   protected boolean func_70692_ba() {
      return false;
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         int e = 1;
         if (var3 instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)var3;
            JRMCoreH.expPls(player, e);
         }
      }

      super.func_70645_a(par1DamageSource);
   }

   public int getAttackStrength(Entity par1Entity, int AttPow) {
      ItemStack var2 = this.func_70694_bm();
      int var3 = false;
      int value = (int)((float)(AttPow + 1) * 0.5F);
      int dbcA = AttPow - this.rand.nextInt(value);
      if (dbcA < 0) {
         dbcA = 0;
      }

      return dbcA;
   }

   protected void func_70626_be() {
      boolean doSuperActionUpdate = true;
      if (!(this instanceof EntityDBCWildlife) && this.angerLevel > 0) {
         doSuperActionUpdate = false;
         this.field_70143_R = 0.0F;
         this.prevAttackCounter = this.attackCounter;
         if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
            this.targetedEntity = null;
            this.field_70180_af.func_75692_b(23, 0);
            super.func_70626_be();
         }

         if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.world.func_72856_b(this, 100.0D);
            super.func_70626_be();
            if (this.targetedEntity != null) {
               this.field_70180_af.func_75692_b(23, this.targetedEntity.func_145782_y());
               this.aggroCooldown = 20;
            }
         }

         float r = this.field_70130_N / 2.0F + 3.5F;
         double ogTimer;
         int fireAttackRate;
         if (this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < r) {
            AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.posX - (double)r, this.posY - (double)r, this.posZ - (double)r, this.posX + (double)r, this.posY + (double)r, this.posZ + (double)r);
            List list = this.world.func_72872_a(EntityPlayer.class, aabb);
            ogTimer = this.getXZDistanceToEntity(this.targetedEntity);
            if (this.field_70724_aR - (!DBCConfig.AaiDisabled && ogTimer < 0.5D ? DBCConfig.EnemyDefaultAttackTimer - DBCConfig.EnemyDefaultShortRangeAttackTimer : 0) <= 0) {
               for(fireAttackRate = 0; fireAttackRate < list.size(); ++fireAttackRate) {
                  EntityPlayer player = (EntityPlayer)list.get(fireAttackRate);
                  this.func_70652_k(player);
               }

               this.field_70724_aR = DBCConfig.EnemyDefaultAttackTimer;
               this.world.func_72956_a(this, "jinryuudragonbc:DBC3.force", 0.5F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }
         }

         if (this.targetedEntity != null && this.targetedEntity.func_70089_S() && this.targetedEntity.func_70068_e(this) < 4096.0D) {
            double distanceMulti = this.targetedEntity.func_70068_e(this) / 50.0D * 0.1D + 1.0D;
            ogTimer = (double)(this.kiAttackTimer >= 10 ? this.kiAttackTimer : 80);
            fireAttackRate = (int)(ogTimer / distanceMulti);
            if (fireAttackRate < this.kiAttackTimerMin) {
               fireAttackRate = this.kiAttackTimerMin;
            }

            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.boundingBox.field_72338_b + (double)(this.targetedEntity.field_70131_O / 2.0F) - (this.posY + (double)(this.field_70131_O / 2.0F));
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.field_70761_aq = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / 3.1415927F;
            if (this.canFireKiAttacks && this.func_70685_l(this.targetedEntity)) {
               if (!this.hasAAiKiChargeSystem || this.chargingKiAttack) {
                  ++this.attackCounter;
                  if (this.attackCounter >= fireAttackRate) {
                     this.world.func_72956_a(this, "jinryuudragonbc:DBC2.basicbeam_fire", 0.5F, 1.0F);
                     byte type = this.data1;
                     byte speed = 1;
                     byte effect = 1;
                     byte color = this.data2;
                     byte density = 1;
                     byte sincantation = 0;
                     byte sfire = 0;
                     byte smove = 0;
                     byte[] sts = JRMCoreH.techDBCstatsDefault;
                     int dmg = (int)(50.0F / (this.data1 == 6 ? 5.0F : 1.0F));
                     int f = (int)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                     int dmg1 = (int)((float)f * 1.2F / (this.data1 == 6 ? 5.0F : 1.0F));
                     int cst = dmg1 / 2;
                     EntityEnergyAtt kiAttack;
                     if (this.data3 == 0) {
                        kiAttack = new EntityEnergyAtt(this, type, speed, dmg, effect, color, density, sincantation, sfire, smove, (byte)50, dmg1, cst, sts, (byte)0);
                     } else {
                        kiAttack = new EntityEnergyAtt(this, type, speed, dmg, effect, color, this.data4, density, sincantation, sfire, smove, (byte)50, dmg1, cst, sts, (byte)0);
                     }

                     double d8 = (double)this.field_70130_N + 0.5D;
                     Vec3 vec3 = this.func_70676_i(1.0F);
                     kiAttack.posX = this.posX + vec3.field_72450_a * d8;
                     kiAttack.posY = this.posY + (double)(this.field_70131_O / 2.0F) + 0.5D;
                     kiAttack.posZ = this.posZ + vec3.field_72449_c * d8;
                     this.world.func_72838_d(kiAttack);
                     if (this.data1 == 6 && (int)(Math.random() * 8.0D) != 0) {
                        this.attackCounter = this.kiBarrageType0 ? fireAttackRate - 10 : fireAttackRate;
                        this.blst = false;
                     } else {
                        this.attackCounter = -40;
                        this.blst = true;
                     }
                  }
               }
            } else if (this.attackCounter > 0) {
               --this.attackCounter;
            }
         } else if (this.attackCounter > 0) {
            --this.attackCounter;
         }
      }

      if (doSuperActionUpdate) {
         super.func_70626_be();
      }

   }

   public void lookForTarget() {
      if (this.angerLevel <= 0 && (this.targetedEntity == null || this.aggroCooldown-- <= 0)) {
         this.targetedEntity = this.world.func_72856_b(this, 100.0D);
         super.func_70626_be();
         if (this.targetedEntity != null) {
            this.field_70180_af.func_75692_b(23, this.targetedEntity.func_145782_y());
            this.aggroCooldown = 20;
            this.becomeAngryAt(this.targetedEntity);
         }
      }

   }

   public int updateDataInt(int i) {
      return this.field_70180_af.func_75679_c(i);
   }

   public void func_70636_d() {
      this.func_82168_bl();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
      super.func_70636_d();
   }

   public void onUpdate() {
      if (this.world.field_72995_K) {
         ++this.rang;
      }

      if (this.world.field_72995_K && this.rang > 100) {
         this.rang = 0;
         int i = this.updateDataInt(23);
         this.targetedEntity = i > 0 ? this.world.func_73045_a(i) : null;
      }

      if (!this.world.field_72995_K && !this.updtd) {
         this.updtd = true;
      }

      if (!(this instanceof EntityDBCWildlife) && this.targetedEntity != null && this.func_70685_l(this.targetedEntity) && this.canFly) {
         boolean client = this.targetedEntity.world.field_72995_K;
         double posYTarget = this.targetedEntity.posY - (client ? (JGRenderHelper.isClientPlayer(this.targetedEntity) ? 1.6D : 0.0D) : 0.0D);
         if ((posYTarget - this.posY > 5.0D || !this.targetedEntity.field_70122_E) && !this.field_70703_bu) {
            double yDistance = 0.0D;
            double posY = this.posY - (client ? (JGRenderHelper.isClientPlayer(this) ? 1.6D : 0.0D) : 0.0D);
            double d1 = posYTarget - posY;
            if (d1 < 0.0D) {
               d1 *= -1.0D;
            }

            double clientPlayerPosDiff = (double)(this.world.field_72995_K ? (JGRenderHelper.isClientPlayer(this.targetedEntity) ? 1.6F : 0.0F) : 0.0F);
            double targetPos = this.targetedEntity.posY - clientPlayerPosDiff;
            this.field_70143_R = 0.0F;
            if (d1 > 0.5D) {
               if (targetPos > this.posY - 0.5D) {
                  this.field_70181_x += d1 > 0.1D ? 0.1D : (d1 < -0.01D ? -0.01D : d1);
               }
            } else {
               this.field_70181_x = 0.01D;
            }
         }
      }

      if (this.aaiSystem != null) {
         this.aaiSystem.update();
      }

      if (this.lockedBy != null && !this.lockedBy.func_70089_S()) {
         this.lockedBy = null;
      }

      super.onUpdate();
   }

   protected Entity func_70782_k() {
      EntityPlayer entityplayer = this.world.func_72856_b(this, 16.0D);
      return entityplayer != null && this.func_70685_l(entityplayer) ? entityplayer : null;
   }

   public boolean func_70652_k(Entity entity) {
      if (!(entity instanceof EntityDBC)) {
         int f = (int)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
         f = this.getAttackStrength(entity, f);
         int i = 0;
         if (entity instanceof EntityLivingBase) {
            f = (int)((float)f + EnchantmentHelper.func_77512_a(this, (EntityLivingBase)entity));
            i += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)entity);
         }

         boolean flag = entity.func_70097_a(DamageSource.func_76358_a(this), (float)f);
         if (flag) {
            if (i > 0) {
               entity.func_70024_g((double)(-MathHelper.func_76126_a(this.rotationYaw * 3.1415927F / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.rotationYaw * 3.1415927F / 180.0F) * (float)i * 0.5F));
               this.field_70159_w *= 0.6D;
               this.field_70179_y *= 0.6D;
            }

            int j = EnchantmentHelper.func_90036_a(this);
            if (j > 0) {
               entity.func_70015_d(j * 4);
            }

            if (entity instanceof EntityLivingBase) {
               EnchantmentHelper.func_151384_a((EntityLivingBase)entity, this);
            }

            EnchantmentHelper.func_151385_b(this, entity);
         }

         return flag;
      } else {
         return false;
      }
   }

   protected void func_70785_a(Entity par1Entity, float par2) {
      if (this.field_70724_aR <= 0 && par2 < this.field_70130_N / 2.0F + 2.5F && par1Entity.boundingBox.field_72337_e > this.boundingBox.field_72338_b && par1Entity.boundingBox.field_72338_b < this.boundingBox.field_72337_e) {
         this.field_70724_aR = DBCConfig.EnemyDefaultAttackTimer;
         this.func_70652_k(par1Entity);
      }

   }

   public float func_70783_a(int par1, int par2, int par3) {
      return 0.5F - this.world.func_72801_o(par1, par2, par3);
   }

   protected boolean isValidLightLevel() {
      int i = MathHelper.func_76128_c(this.posX);
      int j = MathHelper.func_76128_c(this.boundingBox.field_72338_b);
      int k = MathHelper.func_76128_c(this.posZ);
      if (this.world.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32)) {
         return false;
      } else {
         int l = this.world.func_72957_l(i, j, k);
         if (this.world.func_72911_I()) {
            int i1 = this.world.field_73008_k;
            this.world.field_73008_k = 10;
            l = this.world.func_72957_l(i, j, k);
            this.world.field_73008_k = i1;
         }

         return l <= this.rand.nextInt(8);
      }
   }

   public boolean func_70601_bi() {
      return true;
   }

   public Entity getTargetedEntity() {
      return this.targetedEntity;
   }

   public boolean getupdtd() {
      return this.updtd;
   }

   public void becomeAngryAtAPlayer() {
      List list = this.world.func_72872_a(EntityPlayer.class, this.boundingBox.func_72314_b(16.0D, 16.0D, 16.0D));
      if (!list.isEmpty()) {
         Entity entity = (Entity)list.get(0);
         this.becomeAngryAt(entity);
      }

   }

   public void becomeAngryAtAllPlayer() {
      List list = this.world.func_72872_a(EntityPlayer.class, this.boundingBox.func_72314_b(16.0D, 16.0D, 16.0D));
      if (!list.isEmpty()) {
         for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            this.becomeAngryAt(entity);
         }
      }

   }

   public void becomeAngryAtClosestPlayer() {
      List list = this.world.func_72872_a(EntityPlayer.class, this.boundingBox.func_72314_b(16.0D, 16.0D, 16.0D));
      if (!list.isEmpty()) {
         Entity entityClosest = null;
         int rangeClosest = -1;

         for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            int range = (int)(entity != null && entity.func_70089_S() ? entity.func_70032_d(this) : 0.0F);
            if (range > rangeClosest) {
               entityClosest = entity;
               rangeClosest = range;
            }
         }

         if (entityClosest != null) {
            this.becomeAngryAt(entityClosest);
         }
      }

   }

   private void becomeAngryAt(Entity entity) {
      this.field_70789_a = entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
   }

   public void becomeAngryAt2(Entity entity) {
      this.becomeAngryAt(entity);
   }

   public void setAttributes(int damage, int health, int AttPow, int HePo) {
      if (damage != AttPow || health != HePo) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)damage);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)health);
      }

   }

   public double getXZDistanceToEntity(Entity targetEntity) {
      double d0 = targetEntity.posX - this.posX;
      if (d0 < 0.0D) {
         d0 *= -1.0D;
      }

      double d2 = targetEntity.posZ - this.posZ;
      if (d2 < 0.0D) {
         d2 *= -1.0D;
      }

      return d0 + d2;
   }

   public double getYDistanceToEntity(Entity targetEntity) {
      double d1 = targetEntity.posY - this.posY;
      if (d1 < 0.0D) {
         d1 *= -1.0D;
      }

      return d1;
   }

   public double getYDistanceToEntityWithClientDiff(Entity targetEntity) {
      boolean client = targetEntity.world.field_72995_K;
      double posYTarget = targetEntity.posY - (client ? (JGRenderHelper.isClientPlayer(targetEntity) ? 1.6D : 0.0D) : 0.0D);
      double posY = this.posY - (client ? (JGRenderHelper.isClientPlayer(this) ? 1.6D : 0.0D) : 0.0D);
      double d1 = posYTarget - posY;
      if (d1 < 0.0D) {
         d1 *= -1.0D;
      }

      return d1;
   }

   public boolean isJumping() {
      return this.field_70703_bu;
   }

   public void useJump() {
      this.func_70664_aZ();
   }

   public static double[] values(double... values) {
      return values;
   }

   public void setBattleStyle(double movementSpeed, double[] highJump, double[] dash, double[] flyingDash, double[] backawayKiCharge) {
      if (!DBCConfig.AaiDisabled) {
         if (movementSpeed != -1.0D) {
            this.moveSpeed *= movementSpeed;
         }

         this.aaiSystem = new AAiSystem(this, new AAi[0]);
         if (highJump != null) {
            this.aaiSystem.addAAi(new AAiDBCGroundJump(highJump));
         }

         if (dash != null) {
            this.aaiSystem.addAAi(new AAiDBCGroundDash(dash));
         }

         if (flyingDash != null && this.canFly) {
            this.aaiSystem.addAAi(new AAiDBCFlyingCharge(flyingDash));
         }

         if (backawayKiCharge != null && this.canFireKiAttacks) {
            this.aaiSystem.addAAi(new AAiDBCKiAttackCharge(backawayKiCharge));
            this.hasAAiKiChargeSystem = true;
         }
      }

   }

   public void setEasyDifficulty() {
      this.setDifficulty(0);
   }

   public void setMediumDifficulty() {
      this.setDifficulty(1);
   }

   public void setHardDifficulty() {
      this.setDifficulty(2);
   }

   public void setInsaneDifficulty() {
      this.setDifficulty(3);
   }

   public void setDifficulty(int difficulty) {
      if (this.aaiSystem != null) {
         this.aaiSystem.aais.clear();
      } else {
         this.aaiSystem = new AAiSystem(this, new AAi[0]);
      }

      if (DBCConfig.AaiForceDifficulty != -1) {
         difficulty = DBCConfig.AaiForceDifficulty;
      }

      this.difficultyID = difficulty;
      this.setBattleStyle(JGConfigDBCAAiDifficulty.SpeedMulti[this.difficultyID], values(JGConfigDBCAAiDifficulty.JumpMulti[this.difficultyID], JGConfigDBCAAiDifficulty.JumpRate[this.difficultyID], JGConfigDBCAAiDifficulty.JumpMulti2[this.difficultyID], JGConfigDBCAAiDifficulty.JumpLimit[this.difficultyID], JGConfigDBCAAiDifficulty.JumpLimit2[this.difficultyID]), values(JGConfigDBCAAiDifficulty.GroundDashSpeedMulti[this.difficultyID], 1.0D, JGConfigDBCAAiDifficulty.GroundDashSpeedMulti2[this.difficultyID], JGConfigDBCAAiDifficulty.GroundDashLimit[this.difficultyID]), values(JGConfigDBCAAiDifficulty.FlyingDashMulti[this.difficultyID], 1.0D, JGConfigDBCAAiDifficulty.FlyingDashLimit[this.difficultyID]), values(JGConfigDBCAAiDifficulty.KiAttackChargeMulti[this.difficultyID], 0.1D, JGConfigDBCAAiDifficulty.KiAttackChargeLimit[this.difficultyID]));
   }

   public void setKiUsage(boolean canFly, boolean canFireKiAttacks) {
      this.canFly = canFly;
      this.canFireKiAttacks = canFireKiAttacks;
   }

   public void setKiUsageAndDifficulty(boolean canFly, boolean canFireKiAttacks) {
      this.setKiUsageAndDifficulty(canFly, canFireKiAttacks, -1);
   }

   public void setKiUsageAndDifficulty(boolean canFly, boolean canFireKiAttacks, int difficulty) {
      this.setKiUsage(canFly, canFireKiAttacks);
      if (difficulty != -1) {
         this.setDifficulty(difficulty);
      }

   }

   public boolean isLocked() {
      return this.lockedBy != null;
   }

   public void addAAiTeleport(int rateMin, int rateMax, String sound) {
      if (this.aaiSystem == null) {
         this.aaiSystem = new AAiSystem(this, new AAi[0]);
      }

      this.aaiSystem.addAAi(new AAiDBCTeleport(rateMin, rateMax, sound));
   }

   public void addAAiTeleport(int rateMin, int rateMax) {
      if (this.aaiSystem == null) {
         this.aaiSystem = new AAiSystem(this, new AAi[0]);
      }

      this.aaiSystem.addAAi(new AAiDBCTeleport(new int[]{rateMin, rateMax}));
   }

   public void addAAiTeleport() {
      if (this.aaiSystem == null) {
         this.aaiSystem = new AAiSystem(this, new AAi[0]);
      }

      this.aaiSystem.addAAi(new AAiDBCTeleport(new int[]{JGConfigDBCAAiDifficulty.TeleportRateMin[this.difficultyID], JGConfigDBCAAiDifficulty.TeleportRateMax[this.difficultyID]}));
   }

   public void addAAiTeleport(String sound) {
      if (this.aaiSystem == null) {
         this.aaiSystem = new AAiSystem(this, new AAi[0]);
      }

      this.aaiSystem.addAAi(new AAiDBCTeleport(JGConfigDBCAAiDifficulty.TeleportRateMin[this.difficultyID], JGConfigDBCAAiDifficulty.TeleportRateMax[this.difficultyID], sound));
   }

   public boolean func_70097_a(DamageSource ds, float f) {
      boolean ret = super.func_70097_a(ds, f);
      Entity target = ds.func_76346_g();
      if (target != null && target.func_70089_S() && this.targetedEntity == null) {
         this.lookForTarget();
      }

      return ret;
   }
}
