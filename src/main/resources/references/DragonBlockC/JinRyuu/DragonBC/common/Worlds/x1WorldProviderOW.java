package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class x1WorldProviderOW extends WorldProvider {
   public int registerWorld() {
      return 22;
   }

   public boolean renderClouds() {
      return false;
   }

   public boolean renderEndSky() {
      return false;
   }

   public boolean renderVoidFog() {
      return true;
   }

   public float setMoonSize() {
      return 5.0F;
   }

   public float setSunSize() {
      return 4.0F;
   }

   public String getSunTexture() {
      return "jinryuudragonbc:sun.png";
   }

   public String getMoonTexture() {
      return "jinryuudragonbc:moon_phases.png";
   }

   public boolean renderStars() {
      return true;
   }

   public boolean darkenSkyDuringRain() {
      return false;
   }

   public String getRespawnMessage() {
      return " Leaving Other World ";
   }

   public boolean hasMultipleBiomes() {
      return true;
   }

   public void func_76572_b() {
      this.field_76578_c = new x1WorldChunkManagerOW(this.field_76579_a.func_72905_C(), this.field_76577_b);
      this.field_76574_g = DBCConfig.otherWorld;
   }

   public IChunkProvider func_76555_c() {
      return new x1ChunkProviderOW(this.field_76579_a, this.field_76579_a.func_72905_C(), false);
   }

   public boolean func_76567_e() {
      return true;
   }

   public float func_76563_a(long par1, float par3) {
      return 1.0F;
   }

   public String getSaveFolder() {
      return this.func_80007_l();
   }

   public String func_80007_l() {
      return "OtherWorld";
   }

   public static WorldProvider getProviderForDimension(int id) {
      return DimensionManager.createProviderFor(DBCConfig.otherWorld);
   }

   @SideOnly(Side.CLIENT)
   public float func_76571_f() {
      return this.getCloudHeight_();
   }

   public int func_76557_i() {
      return this.getMinimumSpawnHeight(this.field_76579_a);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76564_j() {
      return this.hasVoidParticles(this.field_76576_e);
   }

   @SideOnly(Side.CLIENT)
   public double func_76565_k() {
      return this.voidFadeMagnitude();
   }

   public double getHorizon() {
      return this.getHorizon(this.field_76579_a);
   }

   public int getMinimumSpawnHeight(World world) {
      return 4;
   }

   public float getCloudHeight_() {
      return 128.0F;
   }

   public double getHorizon(World world) {
      return 0.0D;
   }

   public boolean hasVoidParticles(boolean flag) {
      return false;
   }

   public double voidFadeMagnitude() {
      return 1.0D;
   }

   public boolean canDoLightning(Chunk chunk) {
      return false;
   }

   public boolean canDoRainSnowIce(Chunk chunk) {
      return false;
   }
}
