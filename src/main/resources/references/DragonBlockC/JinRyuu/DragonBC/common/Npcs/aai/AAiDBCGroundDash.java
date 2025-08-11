package JinRyuu.DragonBC.common.Npcs.aai;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.JRMCore.entity.aai.AAi;
import JinRyuu.JRMCore.server.JGMathHelper;

public class AAiDBCGroundDash extends AAi {
   private double multi;
   private double rate;
   private double multi2;
   private double limit;

   public AAiDBCGroundDash(double[] values) {
      this(values[0], values[1], values[2], values[3]);
   }

   public AAiDBCGroundDash(double multi, double rate, double multi2, double limit) {
      this.multi = multi;
      this.rate = rate;
      this.multi2 = multi2;
      this.limit = limit;
   }

   public void update() {
      EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
      if (entity.func_70089_S() && !entity.world.field_72995_K && !entity.isLocked() && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity.getTargetedEntity().func_70068_e(entity) < 4096.0D) {
         double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
         if (this.checkChanceToUse(this.rate) && !entity.chargingKiAttack && xzDist >= 6.0D && entity.field_70122_E && !entity.isJumping()) {
            entity.field_70159_w *= this.multi;
            entity.field_70179_y *= this.multi;
            double xDiff = (entity.getTargetedEntity().posX - entity.posX) / 50.0D * this.multi2;
            double zDiff = (entity.getTargetedEntity().posZ - entity.posZ) / 50.0D * this.multi2;
            entity.field_70159_w += xDiff;
            if (this.limit != -1.0D) {
               entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
            }

            entity.field_70179_y += zDiff;
            if (this.limit != -1.0D) {
               entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
            }
         }
      }

   }
}
