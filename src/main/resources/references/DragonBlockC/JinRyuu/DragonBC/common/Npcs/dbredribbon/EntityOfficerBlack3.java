package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import java.util.Random;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityOfficerBlack3 extends EntityRedRibbon {
   public final int AttPow = 170;
   public final int HePo = 480;
   private int lastShot;
   private boolean shot;

   public EntityOfficerBlack3(World world) {
      super(world);
      this.texture = "officer_black_mecha";
      this.func_70105_a(1.5F, 2.8F);
      this.lastShot = -1;
      this.shot = false;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(480.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(170.0D);
   }

   public long BattlePowerOld() {
      int BP = 16320000;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < 25.0F) {
         if (this.lastShot == -1) {
            this.lastShot = (new Random()).nextInt(2);
         }

         EntityPrjtls_1 var8;
         if (this.lastShot == 0) {
            if ((this.field_70173_aa + 200) % 400 < 15) {
               var8 = new EntityPrjtls_1(this.field_70170_p, this, this.field_70789_a, 1.8F, 1.0F, 6);
               this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.gun_shot_single", 0.2F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
               this.field_70170_p.func_72838_d(var8);
               this.shot = true;
            } else if (this.shot) {
               this.lastShot = -1;
               this.shot = false;
            }
         } else if (this.field_70173_aa % 100 == 0) {
            var8 = new EntityPrjtls_1(this.field_70170_p, this, this.field_70789_a, 1.8F, 1.0F, 2);
            this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
            this.field_70170_p.func_72838_d(var8);
            this.shot = true;
         } else if (this.shot) {
            this.lastShot = -1;
            this.shot = false;
         }
      }

   }
}
