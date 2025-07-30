package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityNPC extends EntityCreature {
   protected String texture;
   protected String type = "6";
   protected int dam = 0;
   public String expValue;
   public int angerLevel;
   private int aggroCooldown;
   public int prevAttackCounter;
   public int attackCounter;
   private Entity targetedEntity;

   public EntityNPC(World par1World) {
      super(par1World);
      this.toString();
      this.expValue = String.valueOf(this.BattlePower());
      this.angerLevel = 0;
      this.aggroCooldown = 0;
      this.prevAttackCounter = 0;
      this.attackCounter = 0;
      this.targetedEntity = null;
      this.field_70728_aV = 5;
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return this.texture;
   }

   public ResourceLocation getResource() {
      return null;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.MaxHealth());
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
   }

   public int BattlePower() {
      int BattlePower = this.field_70728_aV;
      return BattlePower;
   }

   public int func_70693_a(EntityPlayer par1EntityPlayer) {
      return this.field_70728_aV;
   }

   protected boolean func_70692_ba() {
      return true;
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

   public int getAttackStrength(Entity par1Entity) {
      ItemStack var2 = this.func_70694_bm();
      int var3 = 5;
      return var3;
   }

   public int MaxHealth() {
      return 20;
   }

   protected void func_70626_be() {
      if (this.angerLevel > 0) {
         this.field_70143_R = 0.0F;
         this.prevAttackCounter = this.attackCounter;
         if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
            this.targetedEntity = null;
            super.func_70626_be();
         }

         if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.field_70170_p.func_72856_b(this, 100.0D);
            super.func_70626_be();
            if (this.targetedEntity != null) {
               this.aggroCooldown = 20;
            }
         }

         double d4 = 64.0D;
         if (this.targetedEntity != null && this.targetedEntity.func_70068_e(this) < d4 * d4) {
            double d5 = this.targetedEntity.field_70165_t - this.field_70165_t;
            double d6 = this.targetedEntity.field_70121_D.field_72338_b + (double)(this.targetedEntity.field_70131_O / 2.0F) - (this.field_70163_u + (double)(this.field_70131_O / 2.0F));
            double d7 = this.targetedEntity.field_70161_v - this.field_70161_v;
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d5, d7)) * 180.0F / 3.1415927F;
            if (this.func_70685_l(this.targetedEntity)) {
               ++this.attackCounter;
               if (this.attackCounter == 80) {
                  int t = Integer.parseInt(this.type);
                  if (t == 6) {
                     byte type = 1;
                     byte speed = 1;
                     byte effect = 0;
                     byte color = 0;
                     byte density = 1;
                     byte sincantation = 4;
                     byte sfire = 0;
                     byte smove = 3;
                     int dmg1 = this.dam;
                     int cst = this.dam / 2;
                     Entity entityball = new EntityEnergyAttJ(this, type, (float)speed, this.dam, effect, color, density, sincantation, sfire, smove, (byte)-1, dmg1, cst, 5);
                     double d8 = 0.5D;
                     Vec3 vec3 = this.func_70676_i(1.0F);
                     entityball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                     entityball.field_70163_u = this.field_70163_u + (double)(this.field_70131_O / 2.0F) + 0.5D;
                     entityball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                     this.field_70170_p.func_72838_d(entityball);
                     this.attackCounter = -40;
                  }
               }
            } else if (this.attackCounter > 0) {
               --this.attackCounter;
            }
         } else if (this.attackCounter > 0) {
            --this.attackCounter;
         }
      } else {
         super.func_70626_be();
      }

   }

   public void func_70636_d() {
      this.func_82168_bl();
      super.func_70636_d();
   }

   public void func_70071_h_() {
      if (this.targetedEntity != null && this.func_70685_l(this.targetedEntity)) {
      }

      super.func_70071_h_();
   }

   protected Entity func_70782_k() {
      EntityPlayer entityplayer = this.field_70170_p.func_72856_b(this, 16.0D);
      return entityplayer != null && this.func_70685_l(entityplayer) ? entityplayer : null;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else if (super.func_70097_a(par1DamageSource, par2)) {
         Entity entity = par1DamageSource.func_76346_g();
         if (this.field_70153_n != entity && this.field_70154_o != entity) {
            if (entity != this) {
               this.field_70789_a = entity;
            }

            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public int getDBCAttack(Entity par1Entity) {
      ItemStack var2 = this.func_70694_bm();
      int var3 = 10;
      return var3;
   }

   public boolean func_70652_k(Entity par1Entity) {
      int i = this.getAttackStrength(par1Entity);
      if (this.func_70644_a(Potion.field_76420_g)) {
         i += 3 << this.func_70660_b(Potion.field_76420_g).func_76458_c();
      }

      if (this.func_70644_a(Potion.field_76437_t)) {
         i -= 2 << this.func_70660_b(Potion.field_76437_t).func_76458_c();
      }

      int j = 0;
      if (par1Entity instanceof EntityLiving) {
         i = (int)((float)i + EnchantmentHelper.func_77512_a(this, (EntityLiving)par1Entity));
         j += EnchantmentHelper.func_77507_b(this, (EntityLiving)par1Entity);
      }

      boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a(this), (float)i);
      if (flag) {
         if (j > 0) {
            par1Entity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * (float)j * 0.5F));
            this.field_70159_w *= 0.6D;
            this.field_70179_y *= 0.6D;
         }

         int k = EnchantmentHelper.func_90036_a(this);
         if (k > 0) {
            par1Entity.func_70015_d(k * 4);
         }
      }

      return flag;
   }

   protected void func_70785_a(Entity par1Entity, float par2) {
      if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(par1Entity);
      }

   }

   public float func_70783_a(int par1, int par2, int par3) {
      return 0.5F - this.field_70170_p.func_72801_o(par1, par2, par3);
   }

   protected boolean isValidLightLevel() {
      int i = MathHelper.func_76128_c(this.field_70165_t);
      int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int k = MathHelper.func_76128_c(this.field_70161_v);
      if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32)) {
         return false;
      } else {
         int l = this.field_70170_p.func_72957_l(i, j, k);
         if (this.field_70170_p.func_72911_I()) {
            int i1 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            l = this.field_70170_p.func_72957_l(i, j, k);
            this.field_70170_p.field_73008_k = i1;
         }

         return l <= this.field_70146_Z.nextInt(8);
      }
   }

   public boolean func_70601_bi() {
      return true;
   }
}
