package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTrunks_dbs2 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 16000;
   public final int HePo = 100000;
   private int target;

   public EntityTrunks_dbs2(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "trunks2_ssj";
      this.func_70105_a(0.6F, 2.0F);
      this.setData2(2);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(16000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = -2122547200;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      int k;
      if (this.doBlst()) {
         k = (int)(Math.random() * 3.0D);
         if (k == 0) {
            this.setData1(1);
            this.setData2(2);
         } else if (k == 1) {
            this.setData1(1);
            this.setData2(2);
         } else {
            this.setData1(6);
            this.setData2(7);
         }
      }

      if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            for(int i = 0; i < 5; ++i) {
               float a = 0.5F;
               float h1 = 1.0F;
               float red = 255.0F;
               float green = 217.0F;
               float blue = 25.0F;
               float life = 0.8F * super.field_70131_O;
               float extra_scale = 1.0F + (super.field_70131_O > 2.1F ? super.field_70131_O / 2.0F : 0.0F) / 5.0F;
               float width = super.field_70130_N * 3.0F;
               double x = (Math.random() * 1.0D - 0.5D) * (double)(width * 1.2F);
               double y = Math.random() * (double)(this.field_70131_O * 1.4F) - (double)(this.field_70131_O / 2.0F) - 0.30000001192092896D;
               double z = (Math.random() * 1.0D - 0.5D) * (double)(width * 1.2F);
               double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
               double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (double)(life * extra_scale) * 0.07D;
               double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
               Entity entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", super.field_70170_p, 0.2F, 0.2F, super.field_70165_t, super.field_70163_u + (double)(this instanceof EntityPlayerSP ? -1.6F : 0.0F), super.field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, this);
               super.field_70170_p.func_72838_d(entity2);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", super.field_70170_p, 0.2F, 0.2F, super.field_70165_t, super.field_70163_u + (double)(this instanceof EntityPlayerSP ? -1.6F : 0.0F), super.field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, this);
               super.field_70170_p.func_72838_d(entity2);
            }
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
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }
}
