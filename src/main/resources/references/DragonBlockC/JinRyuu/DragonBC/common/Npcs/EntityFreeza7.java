package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFreeza7 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 12000;
   public final int HePo = 90000;
   int trans;

   public EntityFreeza7(World par1World) {
      super(par1World);
      this.field_70728_aV = 300;
      this.setData1(3);
      this.setData2(3);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/freeza7.png";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(90000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(12000.0D);
   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      super.onUpdate();
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
      par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
      this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
   }

   protected Entity func_70782_k() {
      return this.target != null ? this.target : (this.angerLevel == 0 ? null : super.func_70782_k());
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         int r = (int)(Math.random() * 4.0D);
         if (r == 0) {
            this.setData1(3);
            this.setData2(3);
         } else if (r == 1) {
            this.setData1(1);
            this.setData2(3);
         } else if (r == 2) {
            this.setData1(5);
            this.setData2(3);
         } else if (r == 3) {
            this.setData1(6);
            this.setData2(0);
         }
      }

      if (this.world.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
         float red = 249.0F;
         float green = 212.0F;
         float blue = 33.0F;
         float red2 = 234.0F;
         float green2 = 134.0F;
         float blue2 = 34.0F;
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
            EntityCusPar entity2;
            for(i = 0; i < 2; ++i) {
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2.world.func_72838_d(entity2);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               entity2.world.func_72838_d(entity2);
            }

            for(i = 0; i < 2; ++i) {
               out *= 1.3F;
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               x = Math.random() * (double)out - (double)(out / 2.0F);
               y = Math.random() * (double)this.field_70131_O - 0.5D;
               z = Math.random() * (double)out - (double)(out / 2.0F);
               entity2.world.func_72838_d(entity2);
               entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
               entity2.world.func_72838_d(entity2);
            }

            double x = Math.random() * 1.0D - 0.5D;
            double y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            double z = Math.random() * 1.0D - 0.5D;
            Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
            x = Math.random() * 1.0D - 0.5D;
            y = (Math.random() * (double)this.field_70131_O - 0.5D) * 0.800000011920929D;
            z = Math.random() * 1.0D - 0.5D;
            entity.world.func_72838_d(entity);
            entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, this);
            entity.world.func_72838_d(entity2);
         }
      }

      ++this.trans;
      super.func_70636_d();
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityFreeza7) {
                  EntityFreeza7 var7 = (EntityFreeza7)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void func_70628_a(boolean par1, int par2) {
      int var3 = this.rand.nextInt(1 + par2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
      }

      var3 = this.rand.nextInt(2 + par2);

      for(var4 = 0; var4 < var3; ++var4) {
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }
}
