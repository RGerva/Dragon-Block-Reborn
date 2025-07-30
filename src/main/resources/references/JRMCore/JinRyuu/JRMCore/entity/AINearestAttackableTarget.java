package JinRyuu.JRMCore.entity;

import java.util.Collections;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget.Sorter;

public class AINearestAttackableTarget extends AITarget {
   private final Class targetClass;
   private final int targetChance;
   private final Sorter theNearestAttackableTargetSorter;
   private final IEntitySelector targetEntitySelector;
   private EntityLivingBase targetEntity;

   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4) {
      this(par1EntityCreature, par2Class, par3, par4, false);
   }

   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4, boolean par5) {
      this(par1EntityCreature, par2Class, par3, par4, par5, (IEntitySelector)null);
   }

   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4, boolean par5, IEntitySelector par6IEntitySelector) {
      super(par1EntityCreature, par4, par5);
      this.targetClass = par2Class;
      this.targetChance = par3;
      this.theNearestAttackableTargetSorter = new Sorter(par1EntityCreature);
      this.func_75248_a(1);
      this.targetEntitySelector = new AINearestAttackableTargetSelector(this, par6IEntitySelector);
   }

   public boolean func_75250_a() {
      if (this.taskOwner instanceof JinRyuu.FamilyC.EntityNPC && !((JinRyuu.FamilyC.EntityNPC)this.taskOwner).getAggr()) {
         return false;
      } else if (this.targetChance > 0 && this.taskOwner.func_70681_au().nextInt(this.targetChance) != 0) {
         return false;
      } else {
         double d0 = this.getTargetDistance();
         List list = this.taskOwner.field_70170_p.func_82733_a(this.targetClass, this.taskOwner.field_70121_D.func_72314_b(d0, 4.0D, d0), this.targetEntitySelector);
         Collections.sort(list, this.theNearestAttackableTargetSorter);
         if (list.isEmpty()) {
            return false;
         } else {
            this.targetEntity = (EntityLivingBase)list.get(0);
            return true;
         }
      }
   }

   public void func_75249_e() {
      this.taskOwner.func_70624_b(this.targetEntity);
      super.func_75249_e();
   }
}
