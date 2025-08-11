package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class SaibaiHatchedTileEntity extends TileEntity {
   private int spawnDelay = 100;
   private String mobID = "Saibaman";
   public double field_98287_c;
   public double field_98284_d = 0.0D;
   private int minSpawnDelay = 150;
   private int maxSpawnDelay = 600;
   private int spawnCount = 1;
   private Entity field_98291_j;
   private int maxNearbyEntities = 1;
   private int activatingRangeFromPlayer = 4;
   private int spawnRange = 8;

   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
   }

   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
   }

   public void func_145845_h() {
      super.func_145845_h();
   }

   private boolean canRun() {
      return this.field_145850_b.func_72977_a((double)this.field_145851_c + 0.5D, (double)this.field_145848_d + 0.5D, (double)this.field_145849_e + 0.5D, (double)this.activatingRangeFromPlayer) != null;
   }

   private void updateSpawner() {
      int n = 4;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a((double)this.field_145851_c - (double)n, (double)this.field_145848_d - (double)n, (double)this.field_145849_e - (double)n, (double)this.field_145851_c + (double)n, (double)this.field_145848_d + (double)n, (double)this.field_145849_e + (double)n);
      int p = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb).size();
      if (this.canRun() && this.field_145850_b.func_72872_a(EntityPlayer.class, aabb).size() > 0) {
         if (this.field_145850_b.field_72995_K) {
            double var10000 = (double)((float)this.field_145851_c + this.field_145850_b.field_73012_v.nextFloat());
            var10000 = (double)((float)this.field_145848_d + this.field_145850_b.field_73012_v.nextFloat());
            var10000 = (double)((float)this.field_145849_e + this.field_145850_b.field_73012_v.nextFloat());
            if (this.spawnDelay > 0) {
               --this.spawnDelay;
            }

            this.field_98284_d = this.field_98287_c;
            this.field_98287_c = (this.field_98287_c + (double)(1000.0F / ((float)this.spawnDelay + 200.0F))) % 360.0D;
         } else {
            if (this.spawnDelay == -1) {
               this.func_98273_j();
            }

            if (this.spawnDelay > 0) {
               --this.spawnDelay;
               return;
            }

            boolean flag = false;
            int i = 0;

            while(true) {
               if (i >= 1) {
                  if (flag) {
                     this.func_98273_j();
                  }
                  break;
               }

               Entity entity = new EntitySaibaiman(this.field_145850_b);
               n = 16;
               aabb = AxisAlignedBB.func_72330_a((double)this.field_145851_c - (double)n, (double)this.field_145848_d - (double)n, (double)this.field_145849_e - (double)n, (double)this.field_145851_c + (double)n, (double)this.field_145848_d + (double)n, (double)this.field_145849_e + (double)n);
               int j = this.field_145850_b.func_72872_a(EntityDBC.class, aabb).size();
               if (this.field_145850_b.func_72872_a(EntityDBC.class, aabb).size() == 0) {
                  this.func_98273_j();
                  return;
               }

               double d0 = (double)this.field_145851_c + (this.field_145850_b.field_73012_v.nextDouble() - this.field_145850_b.field_73012_v.nextDouble()) * (double)this.spawnRange;
               double d3 = (double)(this.field_145848_d + this.field_145850_b.field_73012_v.nextInt(3) - 1);
               double d4 = (double)this.field_145849_e + (this.field_145850_b.field_73012_v.nextDouble() - this.field_145850_b.field_73012_v.nextDouble()) * (double)this.spawnRange;
               EntityLiving entityliving = entity instanceof EntityLiving ? (EntityLiving)entity : null;
               entity.setLocationAndAngles(d0, d3, d4, this.field_145850_b.field_73012_v.nextFloat() * 360.0F, 0.0F);
               if (entityliving == null || entityliving.func_70601_bi()) {
                  this.func_98265_a(entity);
                  this.field_145850_b.func_72926_e(2004, this.field_145851_c, this.field_145848_d, this.field_145849_e, 0);
                  if (entityliving != null) {
                     entityliving.func_70656_aK();
                  }

                  flag = true;
               }

               ++i;
            }
         }
      }

   }

   private Entity func_98265_a(Entity par1Entity) {
      if (par1Entity instanceof EntityLiving && par1Entity.world != null) {
         this.field_145850_b.func_72838_d(par1Entity);
      }

      return par1Entity;
   }

   private void func_98273_j() {
      if (this.maxSpawnDelay <= this.minSpawnDelay) {
         this.spawnDelay = this.minSpawnDelay;
      } else {
         int i = this.maxSpawnDelay - this.minSpawnDelay;
         this.spawnDelay = this.minSpawnDelay + this.field_145850_b.field_73012_v.nextInt(i);
      }

      this.func_98267_a(1);
   }

   private void func_98267_a(int par1) {
      this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, BlocksDBC.SaibaiHatched, par1, 0);
   }

   private boolean setDelayToMin(int par1) {
      if (par1 == 1 && this.field_145850_b.field_72995_K) {
         this.spawnDelay = this.minSpawnDelay;
         return true;
      } else {
         return false;
      }
   }

   public boolean func_145842_c(int par1, int par2) {
      return this.setDelayToMin(par1) ? true : super.func_145842_c(par1, par2);
   }
}
