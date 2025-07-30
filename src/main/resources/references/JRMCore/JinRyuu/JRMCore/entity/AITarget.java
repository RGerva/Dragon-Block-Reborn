package JinRyuu.JRMCore.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.StringUtils;

public abstract class AITarget extends EntityAIBase {
   protected EntityCreature taskOwner;
   protected boolean shouldCheckSight;
   private boolean nearbyOnly;
   private int targetSearchStatus;
   private int targetSearchDelay;
   private int field_75298_g;

   public AITarget(EntityCreature par1EntityCreature, boolean par2) {
      this(par1EntityCreature, par2, false);
   }

   public AITarget(EntityCreature par1EntityCreature, boolean par2, boolean par3) {
      this.taskOwner = par1EntityCreature;
      this.shouldCheckSight = par2;
      this.nearbyOnly = par3;
   }

   public boolean func_75253_b() {
      EntityLivingBase entitylivingbase = this.taskOwner.func_70638_az();
      if (entitylivingbase == null) {
         return false;
      } else if (!entitylivingbase.func_70089_S()) {
         return false;
      } else {
         double d0 = this.getTargetDistance();
         if (this.taskOwner.func_70068_e(entitylivingbase) > d0 * d0) {
            return false;
         } else {
            if (this.shouldCheckSight) {
               if (this.taskOwner.func_70635_at().func_75522_a(entitylivingbase)) {
                  this.field_75298_g = 0;
               } else if (++this.field_75298_g > 60) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   protected double getTargetDistance() {
      IAttributeInstance attributeinstance = this.taskOwner.func_110148_a(SharedMonsterAttributes.field_111265_b);
      return attributeinstance == null ? 16.0D : attributeinstance.func_111126_e();
   }

   public void func_75249_e() {
      this.targetSearchStatus = 0;
      this.targetSearchDelay = 0;
      this.field_75298_g = 0;
   }

   public void func_75251_c() {
      this.taskOwner.func_70624_b((EntityLivingBase)null);
   }

   protected boolean isSuitableTarget(EntityLivingBase par1EntityLivingBase, boolean par2) {
      if (par1EntityLivingBase == null) {
         return false;
      } else if (par1EntityLivingBase == this.taskOwner) {
         return false;
      } else if (!par1EntityLivingBase.func_70089_S()) {
         return false;
      } else if (!this.taskOwner.func_70686_a(par1EntityLivingBase.getClass())) {
         return false;
      } else {
         if (this.taskOwner instanceof IEntityOwnable && StringUtils.isNotEmpty(((IEntityOwnable)this.taskOwner).func_152113_b())) {
            if (par1EntityLivingBase instanceof IEntityOwnable && ((IEntityOwnable)this.taskOwner).func_152113_b().equals(((IEntityOwnable)par1EntityLivingBase).func_152113_b())) {
               return false;
            }

            if (par1EntityLivingBase == ((IEntityOwnable)this.taskOwner).func_70902_q()) {
               return false;
            }
         } else if (par1EntityLivingBase instanceof EntityPlayer && !par2 && ((EntityPlayer)par1EntityLivingBase).field_71075_bZ.field_75102_a) {
            return false;
         }

         if (!this.taskOwner.func_110176_b(MathHelper.func_76128_c(par1EntityLivingBase.field_70165_t), MathHelper.func_76128_c(par1EntityLivingBase.field_70163_u), MathHelper.func_76128_c(par1EntityLivingBase.field_70161_v))) {
            return false;
         } else if (this.shouldCheckSight && !this.taskOwner.func_70635_at().func_75522_a(par1EntityLivingBase)) {
            return false;
         } else {
            if (this.nearbyOnly) {
               if (--this.targetSearchDelay <= 0) {
                  this.targetSearchStatus = 0;
               }

               if (this.targetSearchStatus == 0) {
                  this.targetSearchStatus = this.canEasilyReach(par1EntityLivingBase) ? 1 : 2;
               }

               if (this.targetSearchStatus == 2) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   private boolean canEasilyReach(EntityLivingBase par1EntityLivingBase) {
      this.targetSearchDelay = 10 + this.taskOwner.func_70681_au().nextInt(5);
      PathEntity pathentity = this.taskOwner.func_70661_as().func_75494_a(par1EntityLivingBase);
      if (pathentity == null) {
         return false;
      } else {
         PathPoint pathpoint = pathentity.func_75870_c();
         if (pathpoint == null) {
            return false;
         } else {
            int i = pathpoint.field_75839_a - MathHelper.func_76128_c(par1EntityLivingBase.field_70165_t);
            int j = pathpoint.field_75838_c - MathHelper.func_76128_c(par1EntityLivingBase.field_70161_v);
            return (double)(i * i + j * j) <= 2.25D;
         }
      }
   }
}
