package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityKatopesla extends EntityDBCBasicEvil {
   public final int AttPow = 7000;
   public final int HePo = 40000;

   public EntityKatopesla(World world) {
      super(world);
      this.tex = "katopesla";
      this.func_70105_a(0.6F, 2.4F);
      this.setHardDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7000.0D);
   }

   public long BattlePowerOld() {
      int BP = 165425152;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.rand.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }
}
