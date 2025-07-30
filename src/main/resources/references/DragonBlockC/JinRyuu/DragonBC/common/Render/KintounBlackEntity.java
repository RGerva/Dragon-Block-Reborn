package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class KintounBlackEntity extends KintounBaseEntity {
   private boolean field_70279_a;
   private double speedMultiplier;
   private int boatPosRotationIncrements;
   private double boatX;
   private double boatY;
   private double boatZ;
   private double boatYaw;
   private double boatPitch;
   @SideOnly(Side.CLIENT)
   private double velocityX;
   @SideOnly(Side.CLIENT)
   private double velocityY;
   @SideOnly(Side.CLIENT)
   private double velocityZ;
   public String texture;
   private int dropcounter;
   private float dS;
   private float T;

   public KintounBlackEntity(World par1World) {
      super(par1World);
      this.T = 0.05F;
      this.field_70279_a = true;
      this.speedMultiplier = 0.08D;
      this.field_70156_m = true;
      this.func_70105_a(1.5F, 1.5F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.setCloudColor(3355443);
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(1));
      this.field_70180_af.func_75682_a(19, new Float(0.0F));
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return par1Entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70104_M() {
      return true;
   }

   public KintounBlackEntity(World par1World, double par2, double par4, double par6) {
      this(par1World);
      this.func_70107_b(par2, par4 + (double)this.field_70129_M, par6);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = par2;
      this.field_70167_r = par4;
      this.field_70166_s = par6;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.0D - 0.30000001192092896D;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.setTimeSinceHit(10);
         this.setDamageTaken(this.getDamageTaken() + par2 * 10.0F);
         this.func_70018_K();
         boolean flag = par1DamageSource.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.func_76346_g()).field_71075_bZ.field_75098_d;
         if (flag || this.getDamageTaken() > 1.0F) {
            if (this.field_70153_n != null) {
               this.field_70153_n.func_70078_a(this);
            }

            this.func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
            if (!flag) {
            }

            this.func_70106_y();
         }

         return true;
      } else {
         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_70057_ab() {
      this.setTimeSinceHit(10);
      this.setDamageTaken(this.getDamageTaken() * 11.0F);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
      if (this.field_70279_a) {
         this.boatPosRotationIncrements = par9 + 5;
      } else {
         double d3 = par1 - this.field_70165_t;
         double d4 = par3 - this.field_70163_u;
         double d5 = par5 - this.field_70161_v;
         double d6 = d3 * d3 + d4 * d4 + d5 * d5;
         if (d6 <= 1.0D) {
            return;
         }

         this.boatPosRotationIncrements = 3;
      }

      this.boatX = par1;
      this.boatY = par3;
      this.boatZ = par5;
      this.boatYaw = (double)par7;
      this.boatPitch = (double)par8;
      this.field_70159_w = this.velocityX;
      this.field_70181_x = this.velocityY;
      this.field_70179_y = this.velocityZ;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double par1, double par3, double par5) {
      this.velocityX = this.field_70159_w = par1;
      this.velocityY = this.field_70181_x = par3;
      this.velocityZ = this.field_70179_y = par5;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      double d1;
      double d2;
      if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA11) {
         for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            if (this.field_70159_w != 0.0D || this.field_70179_y != 0.0D) {
               double x = 0.0D;
               d1 = -1.2000000476837158D;
               d2 = 0.0D;
               Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, super.field_70165_t, super.field_70163_u, super.field_70161_v, x, d1, d2, 0.0D, 0.0D, 0.0D, 0.0F, 10, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 2, 0.05F, 0.001F, -0.0045F, 0, 27.0F, 66.0F, 142.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, false, (Entity)null);
               entity.field_70170_p.func_72838_d(entity);
            }
         }
      }

      if (this.getTimeSinceHit() > 0) {
         this.setTimeSinceHit(this.getTimeSinceHit() - 1);
      }

      if (this.getDamageTaken() > 0.0F) {
         this.setDamageTaken(this.getDamageTaken() - 1.0F);
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      byte b0 = 5;
      double d0 = 0.0D;

      for(int i = 0; i < b0; ++i) {
         d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(i + 0) / (double)b0 - 0.125D;
         d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(i + 1) / (double)b0 - 0.125D;
         AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
      }

      double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      double d4;
      double d5;
      if (d3 > 0.26249999999999996D) {
         d4 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D);
         d5 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D);

         for(int j = 0; (double)j < 1.0D + d3 * 60.0D; ++j) {
            double d6 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
            double var13 = (double)(this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
         }
      }

      double d11;
      double d10;
      if (this.field_70170_p.field_72995_K && this.field_70279_a) {
         if (this.boatPosRotationIncrements > 0) {
            d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / (double)this.boatPosRotationIncrements;
            d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / (double)this.boatPosRotationIncrements;
            d11 = this.field_70161_v + (this.boatZ - this.field_70161_v) / (double)this.boatPosRotationIncrements;
            d10 = MathHelper.func_76138_g(this.boatYaw - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + d10 / (double)this.boatPosRotationIncrements);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.boatPitch - (double)this.field_70125_A) / (double)this.boatPosRotationIncrements);
            --this.boatPosRotationIncrements;
            this.func_70107_b(d4, d5, d11);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         } else {
            d4 = this.field_70165_t + this.field_70159_w;
            d5 = this.field_70163_u + this.field_70181_x;
            d11 = this.field_70161_v + this.field_70179_y;
            this.func_70107_b(d4, d5, d11);
            this.field_70159_w *= 0.9900000095367432D;
            this.field_70181_x *= 0.949999988079071D;
            this.field_70179_y *= 0.9900000095367432D;
         }
      } else {
         double S = 0.0D;
         double d12;
         if (this.field_70153_n != null) {
            if (this.field_70153_n instanceof EntityPlayer) {
               NBTTagCompound tag = JRMCoreH.nbt((EntityPlayer)this.field_70153_n, "");
               if (tag.func_74762_e("DBCdriF") == 1) {
                  S = 0.55D;
                  this.dS += this.T;
                  tag.func_74768_a("DBCdriF", 0);
               } else if (tag.func_74762_e("DBCdriF") == 2) {
                  S = -0.55D;
                  this.dS -= this.T;
                  tag.func_74768_a("DBCdriF", 0);
               } else {
                  S = 0.0D;
                  tag.func_74768_a("DBCdriF", 0);
               }

               if (tag.func_74762_e("DBCdriY") == 3) {
                  this.field_70181_x += 0.5D;
                  if (this.field_70181_x > 0.5D) {
                     this.field_70181_x = 0.5D;
                  }

                  tag.func_74768_a("DBCdriY", 0);
               } else if (tag.func_74762_e("DBCdriY") == 4) {
                  if (this.field_70170_p.func_147439_a((int)this.field_70165_t + 0, (int)this.field_70163_u - 2, (int)this.field_70161_v + 0).func_149688_o() == Material.field_151579_a) {
                     this.field_70181_x -= 0.5D;
                     if (this.field_70181_x < -0.5D) {
                        this.field_70181_x = -0.5D;
                     }

                     tag.func_74768_a("DBCdriY", 0);
                  }
               } else {
                  this.field_70181_x = 0.0D;
                  tag.func_74768_a("DBCdriY", 0);
               }

               if (tag.func_74762_e("DBCdriS") == 5) {
                  this.field_70177_z -= 4.0F;
                  tag.func_74768_a("DBCdriS", 0);
               } else if (tag.func_74762_e("DBCdriS") == 6) {
                  this.field_70177_z += 4.0F;
                  tag.func_74768_a("DBCdriS", 0);
               } else {
                  tag.func_74768_a("DBCdriS", 0);
               }
            }

            if (this.dS > 0.5F) {
               this.dS = 0.5F;
            }

            if (this.dS < -0.5F) {
               this.dS = -0.5F;
            }

            d12 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D) * S;
            double r = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D) * -S;
            this.field_70179_y = d12;
            this.field_70159_w = r;
            this.dropcounter = 0;
            this.field_70153_n.field_70143_R = 0.0F;
            this.field_70143_R = 0.0F;
            if (this.field_70154_o != null) {
               this.field_70154_o.field_70143_R = 0.0F;
            }

            this.field_70153_n.field_70122_E = false;
            int al = JRMCoreH.getByte((EntityPlayer)this.field_70153_n, "jrmcAlign");
            if (al > 66) {
               this.field_70153_n.func_70078_a((Entity)null);
               this.func_70078_a((Entity)null);
               this.field_70153_n = null;
            }
         } else {
            ++this.dropcounter;
            if (this.dropcounter == 100) {
               this.dropcounter = 0;
               this.func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
               this.func_70106_y();
            }

            S = 0.0D;
            this.dS = 0.0F;
         }

         this.field_70143_R = 0.0F;
         if (this.field_70153_n == null) {
            this.field_70159_w *= 0.3900000095367432D;
            this.field_70179_y *= 0.3900000095367432D;
         }

         this.func_70091_d(this.field_70159_w * DBCConfig.cnfFlnmb, this.field_70181_x * DBCConfig.cnfFlnmb, this.field_70179_y * DBCConfig.cnfFlnmb);
         if (this.field_70123_F && d3 > 0.2D) {
            if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
               this.func_70106_y();
               this.func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
            }
         } else if (this.field_70153_n != null) {
            this.field_70159_w *= 0.3900000095367432D;
            this.field_70181_x *= 0.349999988079071D;
            this.field_70179_y *= 0.3900000095367432D;
         }

         this.field_70125_A = 0.0F;
         d5 = (double)this.field_70177_z;
         d11 = this.field_70169_q - this.field_70165_t;
         d10 = this.field_70166_s - this.field_70161_v;
         if (d11 * d11 + d10 * d10 > 0.001D) {
            d5 = (double)((float)(Math.atan2(d10, d11) * 180.0D / 3.141592653589793D));
         }

         d12 = MathHelper.func_76138_g(d5 - (double)this.field_70177_z);
         if (d12 > 20.0D) {
            d12 = 20.0D;
         }

         if (d12 < -20.0D) {
            d12 = -20.0D;
         }

         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         if (!this.field_70170_p.field_72995_K) {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            int l;
            if (list != null && !list.isEmpty()) {
               for(l = 0; l < list.size(); ++l) {
                  Entity entity = (Entity)list.get(l);
                  if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof KintounBlackEntity) {
                     this.field_70159_w = 0.0D;
                     this.field_70181_x = 0.0D;
                     this.field_70179_y = 0.0D;
                  }
               }
            }

            for(l = 0; l < 4; ++l) {
               int i1 = MathHelper.func_76128_c(this.field_70165_t + ((double)(l % 2) - 0.5D) * 0.8D);
               int j1 = MathHelper.func_76128_c(this.field_70161_v + ((double)(l / 2) - 0.5D) * 0.8D);

               for(int k1 = 0; k1 < 2; ++k1) {
                  int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
                  Block i2 = this.field_70170_p.func_147439_a(i1, l1, j1);
                  if (i2 == Blocks.field_150433_aE) {
                     this.field_70170_p.func_147468_f(i1, l1, j1);
                  } else if (i2 == Blocks.field_150392_bi) {
                     this.field_70170_p.func_147443_d(i1, l1, j1, 0, 0);
                  }
               }
            }

            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
               this.field_70153_n = null;
            }
         }
      }

   }

   public void func_70043_V() {
      if (this.field_70153_n != null) {
         double d0 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         double d1 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         this.field_70153_n.func_70107_b(this.field_70165_t + d0, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d1);
      }

   }

   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
      return this.interact(par1EntityPlayer);
   }

   public boolean interact(EntityPlayer par1EntityPlayer) {
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer) {
         return true;
      } else {
         if (!this.field_70170_p.field_72995_K) {
            par1EntityPlayer.func_70078_a(this);
         }

         return true;
      }
   }

   public void setDamageTaken(float par1) {
      this.field_70180_af.func_75692_b(19, par1);
   }

   public float getDamageTaken() {
      return this.field_70180_af.func_111145_d(19);
   }

   public void setTimeSinceHit(int par1) {
      this.field_70180_af.func_75692_b(17, par1);
   }

   public int getTimeSinceHit() {
      return this.field_70180_af.func_75679_c(17);
   }

   public void setForwardDirection(int par1) {
      this.field_70180_af.func_75692_b(18, par1);
   }

   public int getForwardDirection() {
      return this.field_70180_af.func_75679_c(18);
   }

   @SideOnly(Side.CLIENT)
   public void func_70270_d(boolean par1) {
      this.field_70279_a = par1;
   }
}
