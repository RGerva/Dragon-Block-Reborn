package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRedRibbonSoldierB3 extends EntityRedRibbon2 {
   public final int AttPow = 40;
   public final int HePo = 80;

   public EntityRedRibbonSoldierB3(World world) {
      super(world);
      this.func_70105_a(0.6F, 2.0F);
      this.texture = "redribbon_soldierb3";
      this.setAttributes(DBCConfig.RRSoldier3DAM, DBCConfig.RRSoldier3HP, 40, 80);
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
   }

   public void onUpdate() {
      super.onUpdate();
      if (!this.world.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < 25.0F && this.ticksExisted % 150 == 0) {
         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.world, this, this.field_70789_a, 1.8F, 1.0F, 5);
         this.world.func_72956_a(this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
         this.world.func_72838_d(var8);
      }

   }
}
