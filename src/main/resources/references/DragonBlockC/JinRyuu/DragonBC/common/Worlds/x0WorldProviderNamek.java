package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class x0WorldProviderNamek extends WorldProvider {
   public IChunkProvider func_76555_c() {
      return new x0ChunkProviderNamek(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
   }

   public void func_76572_b() {
      this.field_76578_c = new x0WorldChunkManagerNamek(this.field_76579_a.func_72905_C(), this.field_76577_b);
      this.field_76574_g = DBCConfig.planetNamek;
   }

   public static WorldProvider getProviderForDimension(int id) {
      return DimensionManager.createProviderFor(DBCConfig.planetNamek);
   }

   public String func_80007_l() {
      return "Namek";
   }

   public String getSaveFolder() {
      return this.func_80007_l();
   }

   public float func_76563_a(long par1, float par3) {
      return 1.0F;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderStars() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public double getMovementFactor() {
      return 0.1D;
   }

   @SideOnly(Side.CLIENT)
   public float getStarBrightness(World world, float f) {
      return 1.0F;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderClouds() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderVoidFog() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderEndSky() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float setSunSize() {
      return 0.25F;
   }

   @SideOnly(Side.CLIENT)
   public float setMoonSize() {
      return 4.0F;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
      return this.field_76579_a.getSkyColorBody(cameraEntity, partialTicks);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76561_g() {
      return true;
   }

   public boolean func_76567_e() {
      return true;
   }

   public boolean func_76569_d() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public float func_76571_f() {
      return this.field_76577_b.getCloudHeight();
   }

   public ChunkCoordinates func_76554_h() {
      return new ChunkCoordinates(50, 5, 0);
   }

   protected void func_76556_a() {
      float f = 0.0F;

      for(int i = 0; i <= 15; ++i) {
         float f1 = 1.0F - (float)i / 15.0F;
         this.field_76573_f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
      }

   }

   @SideOnly(Side.CLIENT)
   public String getWelcomeMessage() {
      return "Entering Planet Namek";
   }

   @SideOnly(Side.CLIENT)
   public String getDepartMessage() {
      return "Leaving Planet Namek";
   }

   public Vec3 drawClouds(float partialTicks) {
      return super.drawClouds(partialTicks);
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_76562_b(float par1, float par2) {
      float f2 = MathHelper.func_76134_b(par1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if (f2 < 0.0F) {
         f2 = 0.0F;
      }

      if (f2 > 1.0F) {
         f2 = 1.0F;
      }

      float f3 = 0.7529412F;
      float f4 = 0.84705883F;
      float f5 = 1.0F;
      f3 *= f2 * 0.94F + 0.06F;
      f4 *= f2 * 0.94F + 0.06F;
      f5 *= f2 * 0.91F + 0.09F;
      return Vec3.func_72443_a((double)f3, (double)f4, (double)f5);
   }
}
