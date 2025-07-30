package JinRyuu.DragonBC.common.Worlds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class x2WorldProviderTC extends WorldProvider {
   public int registerWorld() {
      return 23;
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
      return 0.0F;
   }

   public float setSunSize() {
      return 0.0F;
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
      return " Leaving Time Chamber";
   }

   public boolean hasMultipleBiomes() {
      return false;
   }

   public void func_76572_b() {
      this.field_76578_c = new WorldChunkManagerHell(BiomeGenBaseDBC.TC, 0.8F);
   }

   public IChunkProvider func_76555_c() {
      return new x2ChunkProviderTC(this.field_76579_a, this.field_76579_a.func_72905_C(), false);
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
      return "TimeChamber";
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
      return 98.0F;
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
      return true;
   }

   public boolean canDoRainSnowIce(Chunk chunk) {
      return true;
   }
}
