package JinRyuu.DragonBC.common.Worlds;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class WorldTeleporterDBCTelep extends Teleporter {
   private Random random;
   private WorldServer worldServerInstance;

   public WorldTeleporterDBCTelep(WorldServer par1WorldServer) {
      super(par1WorldServer);
      this.worldServerInstance = par1WorldServer;
      this.random = new Random();
   }

   public void func_77185_a(Entity entity, double par2, double par4, double par6, float par8) {
      int i = MathHelper.func_76128_c(entity.posX + 1.0D);
      int j = MathHelper.func_76128_c(entity.posY);
      int k = MathHelper.func_76128_c(entity.posZ);
      int k1 = i;
      int i2 = k;

      for(int l1 = 250; l1 > 5; --l1) {
         if (this.worldServerInstance.func_147439_a(k1, l1, i2) != Blocks.field_150350_a) {
            this.placeInExistingPortal(this.worldServerInstance, entity, k1, l1, i2);
            return;
         }
      }

   }

   public boolean placeInExistingPortal(World world, Entity entity, int i, int j, int k) {
      double d2 = (double)i + 0.5D;
      double d4 = (double)j + 0.5D + 4.0D;
      double d6 = (double)k + 0.5D;
      entity.setLocationAndAngles(d2 + 0.0D, d4 + 2.0D, d6 + 0.0D, entity.rotationYaw, 0.0F);
      entity.field_70159_w = entity.field_70181_x = entity.field_70179_y = 0.0D;
      d2 -= 3.0D;
      d6 -= 3.0D;
      return true;
   }
}
