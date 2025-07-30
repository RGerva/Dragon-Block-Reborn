package JinRyuu.DragonBC.common.Npcs.aai;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.JRMCore.entity.aai.AAi;
import JinRyuu.JRMCore.server.JGMathHelper;

public class AAiDBCGroundJump extends AAi {
   private static final int STILL_JUMP_TIMER = 10;
   private double multi;
   private double rate;
   private double multi2;
   private double limit;
   private double limit2;
   private int stillStandingCountdown;
   private double xzDistLast;
   private double posXLast;
   private double posZLast;

   public AAiDBCGroundJump(double[] values) {
      this(values[0], values[1], values[2], values[3], values[4]);
   }

   public AAiDBCGroundJump(double multi, double rate, double multi2, double limit, double limit2) {
      this.multi = multi;
      this.rate = rate;
      this.multi2 = multi2;
      this.limit = limit;
      this.limit2 = limit2;
      this.stillStandingCountdown = 10;
      this.xzDistLast = 0.0D;
      this.posXLast = 0.0D;
      this.posZLast = 0.0D;
   }

   public void update() {
      EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
      if (entity.func_70089_S() && !entity.field_70170_p.field_72995_K && !entity.isLocked() && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity.getTargetedEntity().func_70068_e(entity) < 4096.0D) {
         double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
         double yDist = entity.getYDistanceToEntity(entity.getTargetedEntity());
         if (!JGMathHelper.doubleSmallerThan(xzDist - this.xzDistLast, 0.01D) && (!JGMathHelper.doubleSmallerThan(entity.field_70165_t - this.posXLast, 0.01D) || !JGMathHelper.doubleSmallerThan(entity.field_70161_v - this.posZLast, 0.01D))) {
            this.stillStandingCountdown = 10;
         } else {
            --this.stillStandingCountdown;
         }

         this.xzDistLast = xzDist;
         this.posXLast = entity.field_70165_t;
         this.posZLast = entity.field_70161_v;
         boolean attemptRandomJump = entity.field_70173_aa % 25 == 0 && xzDist > (double)entity.field_70130_N + 2.5D ? this.checkChanceToUse(0.25D) : false;
         if ((!entity.canFly || entity.getTargetedEntity().field_70122_E || attemptRandomJump || this.isStandingStill()) && (attemptRandomJump || this.isStandingStill() || yDist > (double)(entity.field_70131_O * 1.5F)) && (attemptRandomJump || this.isStandingStill() || entity.getTargetedEntity().field_70163_u - entity.field_70163_u > 0.0D) && entity.field_70122_E && !entity.isJumping() && this.checkChanceToUse(this.rate)) {
            entity.useJump();
            double jumpMulti = 1.0D + (!this.isStandingStill() && !attemptRandomJump ? yDist : 3.0D + yDist) / 5.0D;
            entity.field_70181_x *= jumpMulti * this.multi;
            if (this.limit2 != -1.0D) {
               entity.field_70181_x = JGMathHelper.doubleLimit(entity.field_70181_x, this.limit2);
            }

            double xDiff = (entity.getTargetedEntity().field_70165_t - entity.field_70165_t) / 10.0D * this.multi2;
            double zDiff = (entity.getTargetedEntity().field_70161_v - entity.field_70161_v) / 10.0D * this.multi2;
            entity.field_70159_w += xDiff;
            if (this.limit != -1.0D) {
               entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
            }

            entity.field_70179_y += zDiff;
            if (this.limit != -1.0D) {
               entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
            }

            this.stillStandingCountdown = 10;
         } else {
            entity.func_70637_d(false);
         }
      }

   }

   private boolean isStandingStill() {
      return this.stillStandingCountdown <= 0;
   }
}
