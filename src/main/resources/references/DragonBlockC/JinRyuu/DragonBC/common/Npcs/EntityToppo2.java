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

public class EntityToppo2 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 20000;
   public final int HePo = 170000;
   private int target;

   public EntityToppo2(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "toppo_god";
      this.func_70105_a(1.2F, 3.6F);
      this.setData1(1);
      this.setData2(0);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(170000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = 1395167232;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.rand.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      int r;
      if (this.doBlst()) {
         r = (int)(Math.random() * 4.0D);
         if (r == 0) {
            this.setData1(1);
            this.setData2(0);
         } else if (r == 1) {
            this.setData1(6);
            this.setData2(0);
         } else if (r == 2) {
            this.setData1(5);
            this.setData2(8);
         } else {
            this.setData1(5);
            this.setData2(0);
         }
      }

      if (this.world.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         for(r = 0; r < JGConfigClientSettings.get_da1(); ++r) {
            for(int i = 0; i < 3; ++i) {
               float scale = 3.0F;
               float alpha = 0.5F;
               double x = Math.random() * 2.5D - 1.25D;
               double y = Math.random() * (double)this.field_70131_O - 0.20000000298023224D;
               double z = Math.random() * 2.5D - 1.25D;
               Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D) * 3.0F, ((float)(Math.random() * 0.029999999329447746D) + 0.05F) * 3.0F, 0.3F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.25F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, this);
               entity.world.func_72838_d(entity);
               x = Math.random() * 2.5D - 1.25D;
               y = Math.random() * (double)this.field_70131_O - 0.20000000298023224D;
               z = Math.random() * 2.5D - 1.25D;
               entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D) * 3.0F, ((float)(Math.random() * 0.029999999329447746D) + 0.05F) * 3.0F, 0.3F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.25F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, this);
               entity.world.func_72838_d(entity);
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
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
