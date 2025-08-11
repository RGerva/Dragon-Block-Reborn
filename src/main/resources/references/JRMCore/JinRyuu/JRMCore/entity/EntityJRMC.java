package JinRyuu.JRMCore.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityJRMC extends EntityCreature implements IMob {
   protected String texture;
   private double moveSpeed = 0.699D;
   public int rang = 0;
   public int angerLevel = 0;
   private int aggroCooldown = 0;
   public int prevAttackCounter = 0;
   public int attackCounter = 0;
   private Entity targetedEntity = null;
   public String expValue;

   public EntityJRMC(World par1World) {
      super(par1World);
      this.toString();
      this.expValue = String.valueOf(this.BattlePower());
      this.field_70728_aV = 5;
      this.func_94058_c("");
      this.func_94061_f(false);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return this.texture;
   }

   public long BattlePower() {
      long BattlePower = (long)this.field_70728_aV;
      return BattlePower;
   }

   public int func_70693_a(EntityPlayer Player) {
      return this.field_70728_aV;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.MaxHealth());
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
   }

   protected void entityInit() {
      super.entityInit();
   }

   protected boolean func_70650_aV() {
      return false;
   }

   protected boolean func_70692_ba() {
      return false;
   }

   public void func_70645_a(DamageSource par1DamageSource) {
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
      super.func_70626_be();
   }

   public void func_70636_d() {
      this.func_82168_bl();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
      super.func_70636_d();
   }

   public void onUpdate() {
      super.onUpdate();
   }

   protected Entity func_70782_k() {
      EntityPlayer entityplayer = this.world.func_72856_b(this, 16.0D);
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
      float i = (float)this.getAttackStrength(par1Entity);
      int j = 0;
      if (par1Entity instanceof EntityLiving) {
         i += EnchantmentHelper.func_77512_a(this, (EntityLiving)par1Entity);
         j += EnchantmentHelper.func_77507_b(this, (EntityLiving)par1Entity);
      }

      boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a(this), i);
      if (flag) {
         if (j > 0) {
            par1Entity.func_70024_g((double)(-MathHelper.func_76126_a(this.rotationYaw * 3.1415927F / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.rotationYaw * 3.1415927F / 180.0F) * (float)j * 0.5F));
            this.field_70159_w *= 0.6D;
            this.field_70179_y *= 0.6D;
         }

         int k = EnchantmentHelper.func_90036_a(this);
         if (k > 0) {
            par1Entity.func_70015_d(k * 4);
         }

         if (par1Entity instanceof EntityLiving) {
         }
      }

      return flag;
   }

   protected void func_70785_a(Entity par1Entity, float par2) {
      if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.boundingBox.field_72337_e > this.boundingBox.field_72338_b && par1Entity.boundingBox.field_72338_b < this.boundingBox.field_72337_e) {
         this.field_70724_aR = 20;
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
}
