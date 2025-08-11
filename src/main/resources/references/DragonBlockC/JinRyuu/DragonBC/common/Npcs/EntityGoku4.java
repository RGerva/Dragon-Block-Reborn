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

public class EntityGoku4 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 18000;
   public final int HePo = 108000;
   private int target;

   public EntityGoku4(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "goku_blue";
      this.func_70105_a(0.6F, 2.0F);
      this.setData2(2);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(108000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(18000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = -2042023936;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.rand.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         int r = (int)(Math.random() * 3.0D);
         if (r == 0) {
            this.setData1(1);
            this.setData2(2);
         } else if (r == 1) {
            this.setData1(1);
            this.setData2(2);
         } else {
            this.setData1(6);
            this.setData2(7);
         }
      }

      if (this.world.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         float red = 48.0F;
         float green = 208.0F;
         float blue = 232.0F;
         float out = 1.6F;
         float in = 1.0F;
         float life = 0.8F * this.field_70131_O;
         float extra_scale = 0.5F;
         int dea = true;

         for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            int i;
            double x;
            double y;
            double z;
            EntityCusPar entity2;
            for(i = 0; i < 2; ++i) {
               float spe2 = 1.3F;
               x = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
               y = -0.30000001192092896D;
               z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, 0.05D + Math.random() * 0.10000000149011612D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 25, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.02F, false, -1, false, this);
               entity2.world.func_72838_d(entity2);
            }

            EntityCusPar entity2;
            for(i = 0; i < 2; ++i) {
               x = Math.random() * 1.600000023841858D - 0.800000011920929D;
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * 1.600000023841858D - 0.800000011920929D;
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               x = Math.random() * 1.600000023841858D - 0.800000011920929D;
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * 1.600000023841858D - 0.800000011920929D;
               entity2.world.func_72838_d(entity2);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               entity2.world.func_72838_d(entity2);
            }

            double x = Math.random() * 1.0D - 0.5D;
            double y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            double z = Math.random() * 1.0D - 0.5D;
            Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
            x = Math.random() * 1.0D - 0.5D;
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * 1.0D - 0.5D;
            entity.world.func_72838_d(entity);
            entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
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
