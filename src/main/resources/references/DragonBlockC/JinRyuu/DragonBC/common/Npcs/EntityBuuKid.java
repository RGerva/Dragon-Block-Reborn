package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBuuKid extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 12000;
   public final int HePo = 30000;
   private int target;

   public EntityBuuKid(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "kidMajinBuu";
      this.setData1(5);
      this.setData2(3);
      this.setHardDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(12000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = -1014444032;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         if ((int)(Math.random() * 2.0D) == 0) {
            this.setData1(5);
            this.setData2(3);
         } else {
            this.setData1(1);
            this.setData2(3);
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
