package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.world.World;

public class EntityGodParticle extends EntityAuraFX {
   public EntityGodParticle(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
      super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
      this.func_70536_a(0);
      this.field_70544_f = (float)(Math.random() * 1.0D) + 0.4F;
      this.func_70538_b(255.0F, 255.0F, 255.0F);
      this.field_70547_e = (int)(10.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70159_w *= 1.0D;
      this.field_70181_x *= 8.0D;
      this.field_70179_y *= 1.0D;
   }
}
