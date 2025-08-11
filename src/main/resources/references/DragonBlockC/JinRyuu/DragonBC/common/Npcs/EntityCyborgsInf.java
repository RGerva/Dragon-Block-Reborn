package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityCyborgsInf extends EntityCyborgs {
   public int randomSoundDelay = 0;

   public EntityCyborgsInf(World par1World) {
      super(par1World);
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
