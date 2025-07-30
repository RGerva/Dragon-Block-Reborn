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

public class EntityJiren2 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 40000;
   public final int HePo = 180000;
   private int target;

   public EntityJiren2(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "jiren_full_power";
      this.func_70105_a(0.7F, 2.8F);
      this.setData1(1);
      this.setData2(8);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(180000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = 1185955840;
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
            this.setData2(8);
         } else if (k == 1) {
            this.setData1(1);
            this.setData2(4);
         } else {
            this.setData1(5);
            this.setData2(4);
         }
      }

      if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            boolean bol4a = true;
            boolean bol4 = true;
            Entity other = this;
            double posXOth = super.field_70165_t;
            double posYOth = super.field_70163_u + (double)(this instanceof EntityPlayerSP ? -1.6F : 0.0F);
            double posZOth = super.field_70161_v;
            float red;
            float green;
            float blue;
            float red2;
            float green2;
            float blue2;
            float red3;
            float green3;
            float blue3;
            if (bol4a) {
               red = 189.0F;
               green = 26.0F;
               blue = 47.0F;
               red2 = 189.0F;
               green2 = 26.0F;
               blue2 = 47.0F;
               red3 = 248.0F;
               green3 = 231.0F;
               blue3 = 236.0F;
            } else {
               red = 141.0F;
               green = 158.0F;
               blue = 210.0F;
               red2 = 215.0F;
               green2 = 152.0F;
               blue2 = 219.0F;
               red3 = 243.0F;
               green3 = 247.0F;
               blue3 = 250.0F;
            }

            float out = 1.6F;
            float in = 1.5F;
            float life = 0.8F * super.field_70131_O;
            float extra_scale = 0.5F;
            int dea = true;
            float outNew = 1.6F;
            float target_fullsize_one1 = 0.32F;
            float targetsizeMin = super.field_70131_O * (8.0F / target_fullsize_one1) * 0.01F;
            float target_fullsize_one2 = 0.32F;
            float targetsizeMax = super.field_70131_O * (26.0F / target_fullsize_one2) * 0.01F;
            float alpha = 0.6F;

            double x;
            double y;
            double z;
            int repeat2;
            EntityCusPar entity2;
            for(repeat2 = 0; repeat2 < 4; ++repeat2) {
               outNew = 1.7600001F;
               y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
               x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.006F, false, -1, true, other);
               entity2.field_70170_p.func_72838_d(entity2);
            }

            for(repeat2 = 0; repeat2 < 4; ++repeat2) {
               outNew = 1.7600001F;
               y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
               x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.006F, false, -1, true, other);
               entity2.field_70170_p.func_72838_d(entity2);
            }

            EntityCusPar entity2;
            if (this.field_70173_aa % 4 == 0) {
               x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               y = Math.random() * (double)other.field_70131_O - 0.5D;
               z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, other);
               entity2.field_70170_p.func_72838_d(entity2);
            }

            EntityCusPar entity3;
            int repeat2;
            if (bol4) {
               if (bol4a) {
                  outNew = 1.8000001F;
                  y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                  x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                  z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                  entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, other);
                  entity2.field_70170_p.func_72838_d(entity2);

                  for(repeat2 = 0; repeat2 < 1 + (bol4a ? 1 : 0); ++repeat2) {
                     y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
                     y -= 0.30000001192092896D;
                     outNew = 1.9499999F;
                     x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                     z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                     entity3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, other);
                     entity3.field_70170_p.func_72838_d(entity3);
                  }
               }

               if (this.field_70173_aa % (bol4a ? 1 : 4) == 0) {
                  x = Math.random() * 1.5D - 0.75D;
                  y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                  z = Math.random() * 1.5D - 0.75D;
                  entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * (bol4a ? 1.2F : 1.0F) * 0.6F, 0.45F * (bol4a ? 1.2F : 1.0F) * 0.6F, 0.015F * (bol4a ? 1.2F : 1.0F) * 0.6F, false, -1, true, other);
                  entity2.field_70170_p.func_72838_d(entity2);
               }
            }

            float in2 = 0.6F;

            for(repeat2 = 0; repeat2 < 3; ++repeat2) {
               outNew = 0.6F;
               x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D - 0.30000001192092896D;
               z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               entity3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.120000005F, 0.15F, 0.003F, false, -1, true, other);
               entity3.field_70170_p.func_72838_d(entity3);

               for(int repeat2 = 0; repeat2 < 2; ++repeat2) {
                  y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
                  y -= 0.30000001192092896D;
                  outNew = 1.26F;
                  x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                  z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                  Entity entity1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 32, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.012F, false, -1, true, other);
                  entity1.field_70170_p.func_72838_d(entity1);
               }
            }

            if (this.field_70173_aa % 4 == 0) {
               x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
               z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, other);
               entity2.field_70170_p.func_72838_d(entity2);
               y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
               y -= 0.30000001192092896D;
               outNew = 1.26F;
               x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
               entity3 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, other);
               entity3.field_70170_p.func_72838_d(entity3);
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
