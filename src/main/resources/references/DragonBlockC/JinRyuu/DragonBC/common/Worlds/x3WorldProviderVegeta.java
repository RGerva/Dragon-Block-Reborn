package JinRyuu.DragonBC.common.Worlds;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class x3WorldProviderVegeta extends WorldProvider {
   public int registerWorld() {
      return 21;
   }

   public boolean renderClouds() {
      return true;
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
      return true;
   }

   public String getRespawnMessage() {
      return " Leaving Planet Vegeta ";
   }

   public boolean hasMultipleBiomes() {
      return true;
   }

   public void func_76572_b() {
      this.field_76578_c = new WorldChunkManagerHell(BiomeGenBaseDBC.Vegeta, 0.8F);
   }

   public IChunkProvider func_76555_c() {
      return new x0ChunkProviderNamek(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
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
      return "Vegeta";
   }
}
