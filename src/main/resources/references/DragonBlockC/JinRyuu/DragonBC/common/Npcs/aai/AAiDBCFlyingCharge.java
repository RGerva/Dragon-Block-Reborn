package JinRyuu.DragonBC.common.Npcs.aai;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.JRMCore.entity.aai.AAi;
import JinRyuu.JRMCore.server.JGMathHelper;

public class AAiDBCFlyingCharge extends AAi {
   private double multi;
   private double rate;
   private double limit;

   public AAiDBCFlyingCharge(double[] values) {
      this(values[0], values[1], values[2]);
   }

   public AAiDBCFlyingCharge(double multi, double rate, double limit) {
      this.multi = multi;
      this.rate = rate;
      this.limit = limit;
   }

   public void update() {
      EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
      if (entity.func_70089_S() && !entity.world.field_72995_K && !entity.isLocked() && !entity.chargingKiAttack && entity.getTargetedEntity() != null && entity.func_70685_l(entity.getTargetedEntity()) && this.checkChanceToUse(this.rate) && entity.canFly && !entity.field_70122_E) {
         double zDiff;
         if (JGMathHelper.doubleSmallerThan(entity.field_70159_w, 0.5D)) {
            zDiff = (entity.getTargetedEntity().posX - entity.posX) / 50.0D * this.multi;
            entity.field_70159_w = zDiff;
            if (this.limit != -1.0D) {
               entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
            }
         }

         if (JGMathHelper.doubleSmallerThan(entity.field_70179_y, 0.5D)) {
            zDiff = (entity.getTargetedEntity().posZ - entity.posZ) / 50.0D * this.multi;
            entity.field_70179_y = zDiff;
            if (this.limit != -1.0D) {
               entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
            }
         }
      }

   }
}
