package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class WorldTeleporterDBCSpacePod01 extends Teleporter {
   private Random random;
   private WorldServer worldServerInstance;
   private Entity mo;

   public WorldTeleporterDBCSpacePod01(WorldServer par1WorldServer, Entity e) {
      super(par1WorldServer);
      this.worldServerInstance = par1WorldServer;
      this.random = new Random();
      this.mo = e;
   }

   public void func_77185_a(Entity entity, double par2, double par4, double par6, float par8) {
      int i = MathHelper.func_76128_c(entity.field_70165_t + 1.0D);
      int j = MathHelper.func_76128_c(entity.field_70163_u);
      int k = MathHelper.func_76128_c(entity.field_70161_v);
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
      double d4 = (double)j;
      double d6 = (double)k + 0.5D;
      entity.func_70012_b(d2 + 0.0D, d4 + 20.0D, d6 + 0.0D, entity.field_70177_z, 0.0F);
      entity.field_70159_w = entity.field_70181_x = entity.field_70179_y = 0.0D;
      if (this.mo != null && this.mo.getClass() == SpacePod01Entity.class) {
         SpacePod01Entity e = new SpacePod01Entity(world);
         e.func_70012_b(d2 + 0.0D, d4 + 20.0D, d6 + 0.0D, entity.field_70177_z, 0.0F);
         world.func_72838_d(e);
         entity.func_70078_a(e);
         PD.sendTo(new DBCPspacepod1(e.func_145782_y()), (EntityPlayerMP)entity);
      }

      return true;
   }
}
