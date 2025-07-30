package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityInstantTransmission extends Entity implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   public static final float SOUND = 0.25F;
   public Entity shootingEntity;
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private int ticksInAir = 0;
   private byte speed;
   private float size = 10.0F;
   private boolean teleported = false;
   private byte mode = 0;
   private byte skillLevel = 1;
   private byte shortTPMode = 0;
   private byte surroundMode = 0;

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

   public EntityInstantTransmission(World world) {
      super(world);
      this.func_70105_a(this.size, this.size);
   }

   public EntityInstantTransmission(EntityLivingBase userEntity) {
      super(userEntity.field_70170_p);
      this.speed = 20;
      this.size = 0.5F;
      this.shootingEntity = userEntity;
      this.field_70155_l = 10.0D;
      this.func_70105_a(this.size, this.size);
      double d10 = 2.0D;
      double d8 = (double)(userEntity.field_70130_N + 1.0F);
      double var10000 = (double)(userEntity.field_70131_O + 0.5F + this.size * 0.5F);
      Vec3 vec3 = userEntity.func_70040_Z();
      double x = userEntity.field_70165_t + vec3.field_72450_a * d8 - vec3.field_72450_a * 2.0D;
      double y = userEntity.field_70163_u + vec3.field_72448_b * d8 + (double)(userEntity.field_70131_O * 0.55F) - vec3.field_72448_b * 2.0D;
      double z = userEntity.field_70161_v + vec3.field_72449_c * d8 - vec3.field_72449_c * 2.0D;
      this.field_70129_M = this.size * 0.5F;
      this.func_70012_b(x, y, z, userEntity.func_70079_am(), userEntity.field_70125_A);
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
      this.field_70181_x = (double)(-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, (float)this.speed * 0.05F, 1.0F);
   }

   public void setData(int mode, int skillLevel, int shortTPMode, int surroundMode) {
      this.mode = (byte)mode;
      this.skillLevel = (byte)skillLevel;
      this.shortTPMode = (byte)shortTPMode;
      this.surroundMode = (byte)surroundMode;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(20, 0);
   }

   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= (double)var9;
      par3 /= (double)var9;
      par5 /= (double)var9;
      par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)par8;
      par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)par8;
      par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)par8;
      par1 *= (double)par7;
      par3 *= (double)par7;
      par5 *= (double)par7;
      this.field_70159_w = par1;
      this.field_70181_x = par3;
      this.field_70179_y = par5;
      float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, (double)var10) * 180.0D / 3.141592653589793D);
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
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, (double)var7) * 180.0D / 3.141592653589793D);
         this.field_70127_C = this.field_70125_A;
         this.field_70126_B = this.field_70177_z;
         this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
         this.ticksInGround = 0;
      }

   }

   public void func_70071_h_() {
      if (!this.field_70170_p.field_72995_K && !JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[0]) {
         this.func_70106_y();
      } else {
         this.onLand();
         if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) {
            this.func_70106_y();
         }

         if (this.field_70163_u >= 250.0D) {
            this.field_70181_x = 0.0D;
         } else {
            this.size = 0.5F;
            this.func_70105_a(this.size, this.size);
         }

         if (this.field_70173_aa == 1) {
            this.func_70105_a(this.size, this.size);
            this.field_70129_M = this.size * 0.5F;
         }

         super.func_70071_h_();
         if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
            float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var1) * 180.0D / 3.141592653589793D);
         }

         Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
         if (block.func_149688_o() != Material.field_151579_a) {
            block.func_149719_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
               this.inGround = true;
            }
         }

         if (this.inGround) {
            int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
            if (block == this.inTile && var19 == this.inData) {
               ++this.ticksInGround;
               if (this.ticksInGround == 1) {
               }
            } else {
               this.inGround = false;
               this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
               this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
               this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
               this.ticksInGround = 0;
               this.ticksInAir = 0;
            }
         } else {
            ++this.ticksInAir;
            Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
            var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (!this.field_70170_p.field_72995_K && this.ticksInAir >= 2000) {
               this.func_70106_y();
            }

            int t = this.ticksInAir / 10 * 10;
            if (this.ticksInAir == (t == 0 ? 10 : t)) {
               this.field_70170_p.func_72956_a(this, "jinryuudragonbc:" + JRMCoreH.techSnds(0, 2, 0), 1.0F, 1.0F);
            }

            if (var4 != null) {
               var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
            }

            if (!this.field_70170_p.field_72995_K) {
               Entity var5 = null;
               List var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
               double var7 = 0.0D;
               int var9 = 0;

               while(true) {
                  if (var9 >= var6.size()) {
                     if (var5 != null) {
                        var4 = new MovingObjectPosition(var5);
                     }
                     break;
                  }

                  Entity var10 = (Entity)var6.get(var9);
                  if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
                     float var11 = 0.0F;
                     AxisAlignedBB var12 = var10.field_70121_D.func_72314_b((double)var11, (double)var11, (double)var11);
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
               if (!this.field_70170_p.field_72995_K) {
               }

               this.xTile = var4.field_72311_b;
               this.yTile = var4.field_72312_c;
               this.zTile = var4.field_72309_d;
               this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
               this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
               this.inGround = true;
               if (this.inTile.func_149688_o() != Material.field_151579_a) {
                  this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
               }
            }

            while(this.field_70125_A - this.field_70127_C >= 180.0F) {
               this.field_70127_C += 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B < -180.0F) {
               this.field_70126_B -= 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B >= 180.0F) {
               this.field_70126_B += 360.0F;
            }

            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }

      }
   }

   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
      par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
      par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
      par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
      par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
      par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
   }

   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
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
      data.writeByte(this.speed);
      data.writeFloat(this.size);
   }

   public void readSpawnData(ByteBuf data) {
      int first = data.readInt();
      this.shootingEntity = first == 0 ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
      this.speed = data.readByte();
      this.size = data.readFloat();
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

   public void onLand() {
      if (this.shootingEntity != null && !this.teleported && !this.field_70170_p.field_72995_K) {
         for(int j = 0; j < JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[this.skillLevel - 1]; ++j) {
            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if (!JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_GO_THROUGH_BLOCKS_ENABLED) {
               Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
               if (block.func_149688_o() != Material.field_151579_a) {
                  block.func_149719_a(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
                  AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
                  if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
                     String message = "Instant Transmission Failed! A block was in the way";
                     ((EntityPlayer)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                     this.func_70106_y();
                     return;
                  }
               }
            }

            double r = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE;
            AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
            List entityList = this.field_70170_p.func_72839_b(this, aabb);

            for(int i = 0; i < entityList.size(); ++i) {
               Entity targetEntity = (Entity)entityList.get(i);
               if (targetEntity != null && targetEntity instanceof EntityLivingBase && targetEntity.func_70089_S() && !targetEntity.equals(this.shootingEntity) && !JRMCoreH.isFusionSpectator(targetEntity)) {
                  if (targetEntity instanceof EntityPlayer && JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_RELEASE_SENSE_REQUIRED_ENABLED[0]) {
                     JGPlayerMP targetMP = new JGPlayerMP((EntityPlayer)targetEntity);
                     NBTTagCompound nbt2 = this.nbt((EntityPlayer)targetEntity, "pres");
                     targetMP.setNBT(nbt2);
                     byte targetRelease = targetMP.getRelease();
                     boolean targetCanBeSensed = targetRelease > 0;
                     if (!targetCanBeSensed) {
                        String message = "Instant Transmission Failed! Target can not be sensed at 0% Release Level.";
                        ((EntityPlayer)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                        this.func_70106_y();
                        return;
                     }
                  }

                  EntityPlayer pl = (EntityPlayer)this.shootingEntity;
                  int groupID = JRMCoreH.getInt(pl, "JRMCGID");
                  ArrayList<EntityPlayer> teleportedEntities = new ArrayList();
                  teleportedEntities.add(pl);
                  int k;
                  if (this.surroundMode != -1) {
                     int surroundPlayerLimit = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[0][this.skillLevel - 1];
                     double r2 = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE;
                     double r2Y = 1.0D;
                     AxisAlignedBB aabb2 = AxisAlignedBB.func_72330_a(pl.field_70165_t - r2, pl.field_70163_u - 1.0D, pl.field_70161_v - r2, pl.field_70165_t + r2, pl.field_70163_u + 1.0D, pl.field_70161_v + r2);
                     List entityList2 = this.field_70170_p.func_72839_b(this, aabb2);

                     for(int k = 0; k < entityList2.size(); ++k) {
                        Entity nearbyEntity = (Entity)entityList2.get(k);
                        if (nearbyEntity != null && nearbyEntity instanceof EntityPlayer && !((EntityPlayer)nearbyEntity).equals(targetEntity) && !((EntityPlayer)nearbyEntity).equals(pl) && nearbyEntity.func_70089_S()) {
                           if (surroundPlayerLimit != -1 && teleportedEntities.size() - 1 > surroundPlayerLimit) {
                              break;
                           }

                           boolean groupOnly = this.surroundMode == 0;
                           if (groupOnly) {
                              k = JRMCoreH.getInt((EntityPlayer)nearbyEntity, "JRMCGID");
                              if (k == groupID && groupID != 0) {
                                 teleportedEntities.add((EntityPlayer)nearbyEntity);
                              }
                           } else {
                              teleportedEntities.add((EntityPlayer)nearbyEntity);
                           }
                        }
                     }
                  }

                  JGPlayerMP jgPlayer = new JGPlayerMP(pl);
                  NBTTagCompound nbt = this.nbt(pl, "pres");
                  jgPlayer.setNBT(nbt);
                  String ste = jgPlayer.getStatusEffects();
                  boolean divine = JRMCoreH.StusEfcts(17, ste);
                  boolean creativeMode = JRMCoreH.isInCreativeMode(pl);
                  if (!creativeMode) {
                     int[] playerAttributes = jgPlayer.getAttributes();
                     byte race = jgPlayer.getRace();
                     byte classID = jgPlayer.getClassID();
                     byte powerType = jgPlayer.getPowerType();
                     int curEnergy = jgPlayer.getEnergy();
                     k = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(pl, powerType));
                     double FLAT_COST = (double)JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[0][0][this.skillLevel - 1];
                     double PERCENTAGE_COST = (double)JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[0][1][this.skillLevel - 1];
                     double costMulti = PERCENTAGE_COST / 100.0D;
                     double energyCost = (double)k * costMulti + FLAT_COST;
                     if (teleportedEntities.size() > 1) {
                        double costPerPlayerFlat = (double)JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][this.skillLevel - 1];
                        double costPerPlayerPerc = (double)JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][this.skillLevel - 1];
                        double costMultiPerPlayer = costPerPlayerPerc / 100.0D;
                        double energyCostDim = (double)k * costMultiPerPlayer + costPerPlayerFlat;
                        energyCost += energyCostDim * (double)(teleportedEntities.size() - 1);
                     }

                     if ((double)curEnergy < energyCost) {
                        String message = "Instant Transmission Failed! Not Enough Ki: " + (int)energyCost;
                        pl.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
                        this.func_70106_y();
                        return;
                     }

                     int remainingEnergy = curEnergy - (int)energyCost;
                     JRMCoreH.setInt(remainingEnergy, pl, "jrmcEnrgy");
                  }

                  pl.field_70170_p.func_72956_a(pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
                  double x;
                  double y;
                  double z;
                  int tpLong;
                  if (this.shortTPMode == -1) {
                     x = targetEntity.field_70165_t;
                     y = targetEntity.field_70163_u;
                     z = targetEntity.field_70161_v;
                     Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
                     if (block.func_149688_o() != Material.field_151579_a) {
                        ++y;
                     }
                  } else {
                     Block block;
                     float value;
                     boolean found;
                     if (this.shortTPMode == 0) {
                        x = targetEntity.field_70165_t - this.field_70159_w * 2.0D;
                        y = targetEntity.field_70163_u - this.field_70181_x * 2.0D;
                        z = targetEntity.field_70161_v - this.field_70179_y * 2.0D;

                        for(k = 0; k < 3; ++k) {
                           found = false;
                           block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);

                           for(tpLong = 0; tpLong < 3; ++tpLong) {
                              block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u + tpLong, (int)this.field_70161_v);
                              if (block.func_149688_o() != Material.field_151579_a) {
                                 if (k == 2) {
                                    ++y;
                                 } else {
                                    value = k == 0 ? 1.0F : 0.0F;
                                    x = targetEntity.field_70165_t - this.field_70159_w * (double)value;
                                    y = targetEntity.field_70163_u - this.field_70181_x * (double)value;
                                    z = targetEntity.field_70161_v - this.field_70179_y * (double)value;
                                 }
                                 break;
                              }
                           }
                        }
                     } else {
                        x = targetEntity.field_70165_t + this.field_70159_w * 2.0D;
                        y = targetEntity.field_70163_u + this.field_70181_x * 2.0D;
                        z = targetEntity.field_70161_v + this.field_70179_y * 2.0D;

                        for(k = 0; k < 3; ++k) {
                           found = false;
                           block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);

                           for(tpLong = 0; tpLong < 3; ++tpLong) {
                              block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u + tpLong, (int)this.field_70161_v);
                              if (block.func_149688_o() != Material.field_151579_a) {
                                 if (k == 2) {
                                    ++y;
                                 } else {
                                    value = k == 0 ? 1.0F : 0.0F;
                                    x = targetEntity.field_70165_t + this.field_70159_w * (double)value;
                                    y = targetEntity.field_70163_u + this.field_70181_x * (double)value;
                                    z = targetEntity.field_70161_v + this.field_70179_y * (double)value;
                                 }
                                 break;
                              }
                           }
                        }
                     }
                  }

                  JRMCoreH.playerUsedInstantTransmission(pl);

                  for(k = teleportedEntities.size() - 1; k >= 0; --k) {
                     EntityPlayer entity = (EntityPlayer)teleportedEntities.get(k);
                     double x2 = entity.field_70165_t - pl.field_70165_t;
                     double y2 = 0.0D;
                     double z2 = entity.field_70161_v - pl.field_70161_v;
                     ((EntityPlayerMP)entity).func_70080_a(x + x2, y + y2 + 1.0D, z + z2, entity.field_70177_z - (float)(this.shortTPMode == 1 ? 180 : 0), entity.field_70125_A * (float)(this.shortTPMode == 1 ? -1 : 1));
                     ((EntityPlayerMP)entity).field_71135_a.func_147364_a(x + x2, y + y2 + 1.0D, z + z2, entity.field_70177_z, entity.field_70125_A);
                     entity.func_71023_q(1);
                  }

                  String[] fusionParticipants;
                  String instantTransmissionTimers;
                  if (JRMCoreH.isFused(pl)) {
                     instantTransmissionTimers = nbt.func_74779_i("jrmcFuzion");
                     if (instantTransmissionTimers.length() > 0 && !instantTransmissionTimers.equals(" ")) {
                        fusionParticipants = instantTransmissionTimers.split(",");
                        if (fusionParticipants.length == 3) {
                           boolean isController = fusionParticipants[0].equalsIgnoreCase(pl.func_70005_c_());
                           if (isController) {
                              EntityPlayer fusedPlayerPartner = pl.field_70170_p.func_72924_a(fusionParticipants[1]);
                              if (fusedPlayerPartner != null) {
                                 NBTTagCompound nbt2 = this.nbt(fusedPlayerPartner, "pres");
                                 String fusionMembers2 = nbt2.func_74779_i("jrmcFuzion");
                                 String[] fusionParticipants2 = fusionMembers2.split(",");
                                 if (fusionParticipants2.length == 3) {
                                    ((EntityPlayerMP)fusedPlayerPartner).field_71135_a.func_147364_a(x, y + 1.5D, z, fusedPlayerPartner.field_70177_z, fusedPlayerPartner.field_70125_A);
                                    fusedPlayerPartner.func_71023_q(1);
                                 }
                              }
                           }
                        }
                     }
                  }

                  JRMCoreH.playerUsedInstantTransmission(pl);
                  this.teleported = true;
                  this.field_70159_w = 0.0D;
                  this.field_70181_x = 0.0D;
                  this.field_70179_y = 0.0D;
                  pl.field_70170_p.func_72956_a(pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
                  if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
                     instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
                     fusionParticipants = instantTransmissionTimers.split(";");
                     int tpShort = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[0][this.skillLevel - 1];
                     tpLong = Integer.parseInt(fusionParticipants[1]);
                     JRMCoreH.setString(tpShort + ";" + tpLong, pl, "jrmcInstantTransmissionTimers");
                  } else {
                     instantTransmissionTimers = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[0][this.skillLevel - 1] + ";0";
                     JRMCoreH.setString(instantTransmissionTimers, pl, "jrmcInstantTransmissionTimers");
                  }

                  this.func_70106_y();
                  return;
               }
            }
         }

         if (!this.field_70128_L) {
            String message = "Instant Transmission didn't find any targets!";
            ((EntityPlayerMP)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
            this.func_70106_y();
            return;
         }
      }

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
}
