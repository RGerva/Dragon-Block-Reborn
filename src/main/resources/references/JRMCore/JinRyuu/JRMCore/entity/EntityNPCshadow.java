package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityNPCshadow extends EntityNPC implements IEntityAdditionalSpawnData {
   public int randomSoundDelay = 0;
   public int angerLevel = 0;
   private EntityPlayer summoner = null;
   private EntityLivingBase target = null;
   private int maxHealth = 1;
   private int pmje = 0;
   private int wait = 0;
   private int m = 1;
   private int age = 0;
   private String dnsSum;
   public String expValue;
   private int gen;
   private int breast;
   private float f;

   public EntityPlayer getsummoner() {
      return this.summoner;
   }

   public int getSFire() {
      return this.pmje;
   }

   public int getDam() {
      return this.dam;
   }

   public String getdnsSum() {
      return this.dnsSum;
   }

   public int getGen() {
      return this.gen;
   }

   public float getF() {
      return this.f;
   }

   public EntityNPCshadow(World world) {
      super(world);
      this.toString();
      this.expValue = String.valueOf(this.BattlePower());
      this.gen = 1;
      this.breast = 0;
      this.f = 1.0F;
      this.field_70728_aV = 30;
   }

   public EntityNPCshadow(World world, EntityPlayer summoner, int body, int dam, EntityLivingBase target) {
      super(world);
      this.toString();
      this.expValue = String.valueOf(this.BattlePower());
      this.gen = 1;
      this.breast = 0;
      this.f = 1.0F;
      this.field_70728_aV = 1;
      this.summoner = summoner;
      this.dam = dam;
      this.target = target;
      this.maxHealth = body * 2;
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.maxHealth);
   }

   public int BattlePower() {
      int exp = this.field_70728_aV * 100;
      int BattlePower = 1200 + this.rand.nextInt(100);
      return BattlePower;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuunarutoc:npcs/ninja01.png";
   }

   public ResourceLocation getResource() {
      return this.summoner != null && this.summoner instanceof AbstractClientPlayer ? ((AbstractClientPlayer)this.summoner).func_110306_p() : new ResourceLocation("jinryuunarutoc:npcs/ninja01.png");
   }

   public EntityPlayer getSummoner() {
      return this.summoner;
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   protected Entity func_70782_k() {
      int n = 8;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.posX - (double)n, this.posY - (double)n, this.posZ - (double)n, this.posX + (double)n, this.posY + (double)n, this.posZ + (double)n);
      Entity entity = this.world.func_72857_a(EntityCreature.class, aabb, this);
      EntityPlayer entityplayer = this.world.func_72856_b(this, 16.0D);
      Entity target = this.target;
      return (Entity)(target != null ? target : (entityplayer != null && entityplayer != this.summoner ? entityplayer : (entity != null && entity != this.summoner && entity != this ? entity : null)));
   }

   public void func_70636_d() {
      String[] pmj = JRMCoreH.pmj[Integer.parseInt(this.type)];
      this.pmje = Integer.parseInt(pmj[13]);
      if (!this.world.field_72995_K && (this.summoner == null || !(this.summoner instanceof EntityPlayer) || this.age > 6000)) {
         this.setDead();
      } else {
         double r = 10.0D;
         AxisAlignedBB ab = AxisAlignedBB.func_72330_a(this.posX - r, this.posY - r, this.posZ - r, this.posX + r, this.posY + r, this.posZ + r);
         List entityList = this.world.func_72872_a(this.getClass(), ab);
         if (entityList.size() > 5) {
            this.setDead();
         } else {
            ++this.age;
            if (this.age == 1) {
               this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.maxHealth);
               this.func_70691_i((float)this.maxHealth);
            }

            this.teleportAndUpdate();
            super.func_70636_d();
         }
      }
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityNPCshadow) {
                  EntityNPCshadow var7 = (EntityNPCshadow)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void func_70628_a(boolean par1, int par2) {
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   public int getAttackStrength(Entity par1Entity) {
      int dbcA = this.dam;
      return dbcA;
   }

   public boolean func_70652_k(Entity par1Entity) {
      int var2 = this.getAttackStrength(par1Entity);
      if (this.func_70644_a(Potion.field_76420_g)) {
         var2 += 3 << this.func_70660_b(Potion.field_76420_g).func_76458_c();
      }

      if (this.func_70644_a(Potion.field_76437_t)) {
         var2 -= 2 << this.func_70660_b(Potion.field_76437_t).func_76458_c();
      }

      int var3 = 0;
      if (par1Entity instanceof EntityLiving) {
         var2 = (int)((float)var2 + EnchantmentHelper.func_77512_a(this, (EntityLiving)par1Entity));
         var3 += EnchantmentHelper.func_77507_b(this, (EntityLiving)par1Entity);
      }

      boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a(this), (float)var2);
      if (var4) {
         if (var3 > 0) {
            par1Entity.func_70024_g((double)(-MathHelper.func_76126_a(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
            this.field_70159_w *= 0.6D;
            this.field_70179_y *= 0.6D;
         }

         int var5 = EnchantmentHelper.func_90036_a(this);
         if (var5 > 0) {
            par1Entity.func_70015_d(var5 * 4);
         }
      }

      return var4;
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      this.world.func_72956_a(this, "jinryuunarutoc:NC1." + JRMCoreH.techNCSndHitPM[0], 1.0F, 1.0F);
      super.func_70645_a(par1DamageSource);
   }

   protected void func_70785_a(Entity par1Entity, float par2) {
      if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.boundingBox.field_72337_e > this.boundingBox.field_72338_b && par1Entity.boundingBox.field_72338_b < this.boundingBox.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(par1Entity);
      }

   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.dam);
      data.writeInt(this.maxHealth);
      ByteBufUtils.writeUTF8String(data, this.summoner != null ? this.summoner.getName() : "");
   }

   public void readSpawnData(ByteBuf data) {
      this.dam = data.readInt();
      this.maxHealth = data.readInt();
      this.summoner = this.world.getPlayerEntityByName(ByteBufUtils.readUTF8String(data));
   }

   public void writeEntityToNBT(NBTTagCompound nbtCompound) {
      super.writeEntityToNBT(nbtCompound);
      nbtCompound.func_74768_a("NPCdam", this.dam);
      nbtCompound.func_74768_a("maxHealth", this.maxHealth);
      nbtCompound.func_74778_a("NPCsummoner", this.summoner != null ? this.summoner.getName() : "");
   }

   public void readEntityFromNBT(NBTTagCompound nbtCompound) {
      super.readEntityFromNBT(nbtCompound);
      this.dam = nbtCompound.func_74762_e("NPCdam");
      this.maxHealth = nbtCompound.func_74762_e("maxHealth");
      this.summoner = this.world.getPlayerEntityByName(nbtCompound.func_74779_i("NPCsummoner"));
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
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

   private void teleportAndUpdate() {
      if (this.summoner != null) {
         int R = 32;
         ++this.wait;
         List entityList2 = this.world.func_72872_a(EntityPlayer.class, this.boundingBox.func_72314_b((double)R, (double)R, (double)R));
         if (!entityList2.isEmpty()) {
            for(int var5 = 0; var5 < entityList2.size(); ++var5) {
               EntityPlayer var6 = (EntityPlayer)entityList2.get(var5);
               if (var6.getName().equals(this.summoner.getName())) {
                  this.becomeAngryAt(var6);
                  if (this.wait == 150 * this.m) {
                     boolean calculateSize = JRMCoreConfig.ShadowDummyScaleToTarget;
                     if (calculateSize) {
                        float height = this.field_70131_O;
                        float width = this.field_70130_N;
                        float heightTarget = this.summoner.field_70131_O;
                        float widthTarget = this.summoner.field_70130_N;
                        if (height != heightTarget || width != widthTarget) {
                           this.func_70105_a(widthTarget, heightTarget);
                        }
                     }

                     ++this.m;
                     if (!this.world.field_72995_K) {
                        this.func_70634_a(var6.posX, var6.posY + 1.5D, var6.posZ);
                        this.world.func_72956_a(this, JRMCoreH.TeleportSound(JRMCoreH.getByte(var6, "jrmcPwrtyp")), 0.5F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
                     }
                  }
               }
            }
         }
      }

   }
}
