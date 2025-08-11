package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.Ds;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ExplosionJRMC extends Explosion {
   public boolean field_77286_a = false;
   public boolean field_82755_b = true;
   private int field_77289_h;
   private Random explosionRNG;
   private World worldObj;
   public double field_77284_b;
   public double field_77285_c;
   public double field_77282_d;
   public Entity field_77283_e;
   public float field_77280_f;
   public boolean ego;
   public double damage;
   public List field_77281_g;
   private Map field_77288_k;
   public Entity palyer;
   public byte type;

   public ExplosionJRMC(World par1World, Entity par2Entity, double x, double y, double z, float size, boolean off, double dam, Entity origin, byte type) {
      super(par1World, par2Entity, x, y, z, size);
      this.field_77289_h = JRMCoreConfig.eaei;
      this.explosionRNG = new Random();
      this.field_77281_g = new ArrayList();
      this.field_77288_k = new HashMap();
      this.worldObj = par1World;
      this.field_77283_e = par2Entity;
      this.field_77280_f = size;
      this.field_77284_b = x;
      this.field_77285_c = y;
      this.field_77282_d = z;
      this.ego = off;
      this.damage = dam;
      this.palyer = origin;
      this.type = type;
   }

   public void func_77278_a() {
      this.field_77289_h = (int)((float)this.field_77289_h * this.field_77280_f);
      float f = this.field_77280_f;
      HashSet hashset = new HashSet();
      int i;
      int j;
      int k;
      double d0;
      double d1;
      double d2;
      if (!this.ego) {
         for(i = 0; i < this.field_77289_h; ++i) {
            for(j = 0; j < this.field_77289_h; ++j) {
               for(k = 0; k < this.field_77289_h; ++k) {
                  if (i == 0 || i == this.field_77289_h - 1 || j == 0 || j == this.field_77289_h - 1 || k == 0 || k == this.field_77289_h - 1) {
                     double d3 = (double)((float)i / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                     double d4 = (double)((float)j / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                     double d5 = (double)((float)k / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                     double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                     d3 /= d6;
                     d4 /= d6;
                     d5 /= d6;
                     float f1 = this.field_77280_f * (0.7F + this.worldObj.field_73012_v.nextFloat() * 0.6F);
                     d0 = this.field_77284_b;
                     d1 = this.field_77285_c;
                     d2 = this.field_77282_d;

                     for(float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) {
                        int l = MathHelper.func_76128_c(d0);
                        int i1 = MathHelper.func_76128_c(d1);
                        int j1 = MathHelper.func_76128_c(d2);
                        Block block = this.worldObj.func_147439_a(l, i1, j1);
                        if (!this.ego && block.func_149688_o() != Material.field_151579_a) {
                           float f3 = this.field_77283_e != null ? this.field_77283_e.func_145772_a(this, this.worldObj, l, i1, j1, block) * 0.2F : block.getExplosionResistance(this.field_77283_e, this.worldObj, l, i1, j1, this.field_77284_b, this.field_77285_c, this.field_77282_d) * 0.2F;
                           f1 -= (f3 + 0.3F) * f2;
                        }

                        if (!this.ego && f1 > 0.0F && (this.field_77283_e == null || this.field_77283_e.func_145774_a(this, this.worldObj, l, i1, j1, block, f1))) {
                           hashset.add(new ChunkPosition(l, i1, j1));
                        }

                        d0 += d3 * (double)f2;
                        d1 += d4 * (double)f2;
                        d2 += d5 * (double)f2;
                     }
                  }
               }
            }
         }
      }

      this.field_77281_g.addAll(hashset);
      this.field_77280_f *= 2.0F;
      i = MathHelper.func_76128_c(this.field_77284_b - (double)this.field_77280_f - 1.0D);
      j = MathHelper.func_76128_c(this.field_77284_b + (double)this.field_77280_f + 1.0D);
      k = MathHelper.func_76128_c(this.field_77285_c - (double)this.field_77280_f - 1.0D);
      int l1 = MathHelper.func_76128_c(this.field_77285_c + (double)this.field_77280_f + 1.0D);
      int i2 = MathHelper.func_76128_c(this.field_77282_d - (double)this.field_77280_f - 1.0D);
      int j2 = MathHelper.func_76128_c(this.field_77282_d + (double)this.field_77280_f + 1.0D);
      List list = this.worldObj.func_72839_b(this.field_77283_e, AxisAlignedBB.func_72330_a((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
      Vec3 vec3 = Vec3.func_72443_a(this.field_77284_b, this.field_77285_c, this.field_77282_d);

      for(int k2 = 0; k2 < list.size(); ++k2) {
         Entity entity = (Entity)list.get(k2);
         double d7 = entity.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / (double)this.field_77280_f;
         if (d7 <= 1.0D) {
            d0 = entity.posX - this.field_77284_b;
            d1 = entity.posY + (double)entity.func_70047_e() - this.field_77285_c;
            d2 = entity.posZ - this.field_77282_d;
            double d8 = (double)MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
            if (d8 != 0.0D) {
               d0 /= d8;
               d1 /= d8;
               d2 /= d8;
               double d9 = (double)this.worldObj.func_72842_a(vec3, entity.boundingBox);
               double d10 = (1.0D - d7) * d9;
               int sdmg = (int)((1.0D - d7) * (this.damage / 1.25D));
               if (this.palyer instanceof EntityPlayer || entity instanceof EntityPlayer) {
                  entity.func_70097_a(Ds.causeExplosion(this.palyer), (float)sdmg);
               }

               double d11 = EnchantmentProtection.func_92092_a(entity, d10);
               entity.field_70159_w += d0 * d11;
               entity.field_70181_x += d1 * d11;
               entity.field_70179_y += d2 * d11;
               if (entity instanceof EntityPlayer) {
                  this.field_77288_k.put((EntityPlayer)entity, Vec3.func_72443_a(d0 * d10, d1 * d10, d2 * d10));
               }
            }
         }
      }

      this.field_77280_f = f;
   }

   public void func_77279_a(boolean par1) {
      String snd = "";
      if (this.palyer instanceof EntityPlayer) {
         byte p = JRMCoreH.getByte((EntityPlayer)this.palyer, "PowerType");
         snd = p == 2 ? "jinryuunarutoc:NC1.Explosion" : "jinryuudragonbc:DBC.expl";
      }

      if (this.type != 5) {
         this.worldObj.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, snd, 4.0F, (1.0F + (this.worldObj.field_73012_v.nextFloat() - this.worldObj.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
      }

      if (this.field_77280_f >= 2.0F && this.field_82755_b) {
         this.worldObj.func_72869_a("hugeexplosion", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
      } else {
         this.worldObj.func_72869_a("largeexplode", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
      }

      ChunkPosition chunkposition;
      int i;
      int j;
      int k;
      Block block;
      Iterator iterator;
      if (this.field_82755_b) {
         iterator = this.field_77281_g.iterator();

         while(iterator.hasNext()) {
            chunkposition = (ChunkPosition)iterator.next();
            i = chunkposition.field_151329_a;
            j = chunkposition.field_151327_b;
            k = chunkposition.field_151328_c;
            block = this.worldObj.func_147439_a(i, j, k);
            if (par1) {
               double d0 = (double)((float)i);
               double d1 = (double)((float)j);
               double d2 = (double)((float)k);
               double d3 = d0 - this.field_77284_b;
               double d4 = d1 - this.field_77285_c;
               double d5 = d2 - this.field_77282_d;
               double d6 = (double)MathHelper.func_76133_a(d3 * d3 + d4 * d4 + d5 * d5);
               d3 /= d6;
               d4 /= d6;
               d5 /= d6;
               double d7 = 0.5D / (d6 / (double)this.field_77280_f + 0.1D);
               d7 *= (double)(this.worldObj.field_73012_v.nextFloat() * this.worldObj.field_73012_v.nextFloat() + 0.3F);
               double var10000 = d3 * d7;
               var10000 = d4 * d7;
               var10000 = d5 * d7;
            }

            if (block.func_149688_o() != Material.field_151579_a) {
               this.worldObj.func_147468_f(i, j, k);
               block.func_149723_a(this.worldObj, i, j, k, this);
            }
         }
      }

      if (this.field_77286_a) {
         iterator = this.field_77281_g.iterator();

         while(iterator.hasNext()) {
            chunkposition = (ChunkPosition)iterator.next();
            i = chunkposition.field_151329_a;
            j = chunkposition.field_151327_b;
            k = chunkposition.field_151328_c;
            block = this.worldObj.func_147439_a(i, j, k);
            Block block1 = this.worldObj.func_147439_a(i, j - 1, k);
            if (block.func_149688_o() == Material.field_151579_a && block1.func_149730_j() && this.explosionRNG.nextInt(3) == 0) {
            }
         }
      }

   }

   public Map func_77277_b() {
      return this.field_77288_k;
   }

   public EntityLivingBase func_94613_c() {
      return this.field_77283_e == null ? null : (this.field_77283_e instanceof EntityTNTPrimed ? ((EntityTNTPrimed)this.field_77283_e).func_94083_c() : (this.field_77283_e instanceof EntityLivingBase ? (EntityLivingBase)this.field_77283_e : null));
   }
}
