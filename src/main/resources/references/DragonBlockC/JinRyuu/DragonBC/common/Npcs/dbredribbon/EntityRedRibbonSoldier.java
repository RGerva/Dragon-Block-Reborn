package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRedRibbonSoldier extends EntityRedRibbon2 {
   public final int AttPow = 15;
   public final int HePo = 80;

   public EntityRedRibbonSoldier(World world) {
      super(world);
      this.func_70105_a(0.6F, 2.0F);
      this.texture = "redribbon_soldier";
      this.setAttributes(DBCConfig.RRSoldierDAM, DBCConfig.RRSoldierHP, 15, 80);
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(15.0D);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < 25.0F && this.field_70173_aa % 50 < 3) {
         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, this, this.field_70789_a, 1.8F, 1.0F, 3);
         this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.gun_shot_single", 0.2F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
         this.field_70170_p.func_72838_d(var8);
      }

   }
}
