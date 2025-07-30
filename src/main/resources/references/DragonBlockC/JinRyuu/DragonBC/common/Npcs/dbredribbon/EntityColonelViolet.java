package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityColonelViolet extends EntityRedRibbon {
   public final int AttPow = 30;
   public final int HePo = 130;

   public EntityColonelViolet(World world) {
      super(world);
      this.texture = "colonel_violet";
      this.func_70105_a(0.6F, 2.0F);
      this.setEasyDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(130.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(30.0D);
   }

   public long BattlePowerOld() {
      int BP = 780000;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }
}
