package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.entity.EntityKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCyborg20 extends EntityCyborgsAbs {
   public int randomSoundDelay = 0;
   public String tex;
   private boolean abs;
   public final int AttPow = 800;
   public final int HePo = 8000;

   public EntityCyborg20(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "c20";
      this.abs = false;
      this.setMediumDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(800.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      long BP = 270000000L;
      int exp = this.field_70728_aV * 100;
      if (this.abs) {
         BP = 320000000L;
      }

      long BattlePower = BP + (long)this.rand.nextInt(100);
      return BattlePower;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (!this.func_85032_ar() && par1DamageSource != null) {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityKiAttacks) {
            this.func_70606_j(this.func_110143_aJ() + 300.0F);
         }

         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityCyborg19) {
                  EntityCyborg19 var7 = (EntityCyborg19)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      } else {
         return false;
      }
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityKiAttacks) {
         this.func_70606_j(this.func_110143_aJ() + 300.0F);
      }

      if (var3 instanceof EntityPlayer) {
         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   public void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
