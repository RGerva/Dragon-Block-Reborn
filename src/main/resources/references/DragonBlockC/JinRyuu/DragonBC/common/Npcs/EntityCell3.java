package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCell3 extends EntityCyborgsInf {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 2000;
   public final int HePo = 20000;
   private int target;

   public EntityCell3(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "cell3";
      this.setMediumDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2000.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      long BP = 1000000000000L;
      int exp = this.field_70728_aV * 100;
      long BattlePower = BP + (long)this.rand.nextInt(100);
      return BattlePower;
   }

   public void target(int i) {
      this.target = i;
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         int r = (int)(Math.random() * 5.0D);
         if (r == 0) {
            this.setData1(1);
            this.setData2(0);
         } else if (r == 1) {
            this.setData1(3);
            this.setData2(0);
         } else if (r == 2) {
            this.setData1(4);
            this.setData2(7);
         } else if (r == 3) {
            this.setData1(6);
            this.setData2(2);
         } else {
            this.setData1(2);
            this.setData2(7);
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
