package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGokuBlackRose extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 20000;
   public final int HePo = 120000;
   private int target;

   public EntityGokuBlackRose(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "gokublackrose";
      this.func_70105_a(0.6F, 2.0F);
      this.setHardDifficulty();
      this.addAAiTeleport("jinryuudragonbc:DBC4.blacktp");
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = -1036337152;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.rand.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      int k;
      if (this.doBlst()) {
         k = (int)(Math.random() * 3.0D);
         if (k == 0) {
            this.setData1(1);
            this.setData2(7);
         } else if (k == 1) {
            this.setData1(1);
            this.setData2(0);
         } else {
            this.setData1(5);
            this.setData2(1);
         }
      }

      if (this.world.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            float red = 186.0F;
            float green = 37.0F;
            float blue = 197.0F;
            float red2 = 140.0F;
            float green2 = 8.0F;
            float blue2 = 62.0F;
            float out = 1.6F;
            float in = 1.0F;
            float life = 0.8F * this.field_70131_O;
            float extra_scale = 0.5F;
            int dea = true;
            Entity pl = this;

            double x;
            double y;
            double z;
            EntityCusPar entity2;
            for(int gh = 0; gh < 2; ++gh) {
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2.world.func_72838_d(entity2);
               Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
               entity2.world.func_72838_d(entity2);
            }

            out *= 1.4F;
            x = Math.random() * (double)out - (double)(out / 2.0F);
            y = Math.random() * (double)this.field_70131_O - 0.5D;
            z = Math.random() * (double)out - (double)(out / 2.0F);
            Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            x = Math.random() * (double)out - (double)(out / 2.0F);
            y = Math.random() * (double)this.field_70131_O - 0.5D;
            z = Math.random() * (double)out - (double)(out / 2.0F);
            entity.world.func_72838_d(entity);
            entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            entity.world.func_72838_d(entity2);
            x = Math.random() * (double)in - (double)(in / 2.0F);
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * (double)in - (double)(in / 2.0F);
            entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            x = Math.random() * (double)in - (double)(in / 2.0F);
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * (double)in - (double)(in / 2.0F);
            entity.world.func_72838_d(entity);
            entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            entity.world.func_72838_d(entity2);
            in *= 1.2F;
            x = Math.random() * (double)in - (double)(in / 2.0F);
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * (double)in - (double)(in / 2.0F);
            entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            x = Math.random() * (double)in - (double)(in / 2.0F);
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * (double)in - (double)(in / 2.0F);
            entity.world.func_72838_d(entity);
            entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, pl);
            entity.world.func_72838_d(entity2);
         }
      }

      super.func_70636_d();
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
