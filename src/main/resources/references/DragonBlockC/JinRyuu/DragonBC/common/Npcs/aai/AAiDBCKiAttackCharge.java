package JinRyuu.DragonBC.common.Npcs.aai;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.JRMCore.entity.aai.AAi;
import JinRyuu.JRMCore.server.JGMathHelper;
import java.util.Random;

public class AAiDBCKiAttackCharge extends AAi {
   private double multi;
   private double rate;
   private double limit;

   public AAiDBCKiAttackCharge(double[] values) {
      this(values[0], values[1], values[2]);
   }

   public AAiDBCKiAttackCharge(double multi, double rate, double limit) {
      this.multi = multi;
      this.rate = rate;
      this.limit = limit;
   }

   public void update() {
      EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
      if (entity.func_70089_S() && entity.canFireKiAttacks && !entity.isLocked() && !entity.world.field_72995_K && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity.getTargetedEntity().func_70068_e(entity) < 4096.0D) {
         int chargeTimerMax = true;
         int KI_ATTACK_DISTANCE = true;
         double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
         double yDist = entity.getYDistanceToEntity(entity.getTargetedEntity());
         if (!entity.chargingKiAttack && entity.ticksExisted % 25 == 0 && this.checkChanceToUse(this.rate)) {
            entity.chargingKiAttack = true;
            entity.chargingKiAttackTimer = 0;
            entity.chargingKiAttackTimerMax = (byte)(35 + (new Random()).nextInt(25));
         }

         if (entity.chargingKiAttack) {
            ++entity.chargingKiAttackTimer;
            if (entity.chargingKiAttackTimer >= entity.chargingKiAttackTimerMax) {
               entity.chargingKiAttack = false;
               entity.chargingKiAttackTimer = 0;
            }

            if (xzDist < 10.0D) {
               double xDiff = (entity.getTargetedEntity().posX - entity.posX) / 10.0D * this.multi;
               double zDiff = (entity.getTargetedEntity().posZ - entity.posZ) / 10.0D * this.multi;
               entity.field_70159_w = -xDiff;
               entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
               entity.field_70179_y = -zDiff;
               entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
            }
         }
      }

   }
}
