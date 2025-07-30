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

public class EntityGodBelmod extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 9200;
   public final int HePo = 92000;
   private int target;

   public EntityGodBelmod(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "god_belmod";
      this.func_70105_a(0.6F, 2.0F);
      this.setData1(5);
      this.setData2(8);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(92000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(9200.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = 1776275456;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         if ((int)(Math.random() * 2.0D) == 0) {
            this.setData1(5);
            this.setData2(8);
         } else {
            this.setData1(1);
            this.setData2(0);
         }
      }

      if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            for(int i = 0; i < 5; ++i) {
               double x = Math.random() * 1.0D - 0.5D;
               double y = Math.random() * (double)this.field_70131_O - 0.5D;
               double z = Math.random() * 1.0D - 0.5D;
               Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, super.field_70165_t, super.field_70163_u, super.field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, this);
               entity.field_70170_p.func_72838_d(entity);
               x = Math.random() * 1.0D - 0.5D;
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * 1.0D - 0.5D;
               entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, super.field_70165_t, super.field_70163_u, super.field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, this);
               entity.field_70170_p.func_72838_d(entity);
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
