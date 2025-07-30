package JinRyuu.JRMCore.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

class AINearestAttackableTargetSelector implements IEntitySelector {
   final IEntitySelector field_111103_c;
   final AINearestAttackableTarget field_111102_d;

   AINearestAttackableTargetSelector(AINearestAttackableTarget par1EntityAINearestAttackableTarget, IEntitySelector par2IEntitySelector) {
      this.field_111102_d = par1EntityAINearestAttackableTarget;
      this.field_111103_c = par2IEntitySelector;
   }

   public boolean func_82704_a(Entity par1Entity) {
      return !(par1Entity instanceof EntityLivingBase) ? false : (this.field_111103_c != null && !this.field_111103_c.func_82704_a(par1Entity) ? false : this.field_111102_d.isSuitableTarget((EntityLivingBase)par1Entity, false));
   }
}
