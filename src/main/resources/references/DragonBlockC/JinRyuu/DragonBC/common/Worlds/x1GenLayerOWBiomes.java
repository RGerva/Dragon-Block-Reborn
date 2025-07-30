package JinRyuu.DragonBC.common.Worlds;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class x1GenLayerOWBiomes extends GenLayer {
   protected BiomeGenBase[] allowedBiomes;

   public x1GenLayerOWBiomes(long seed) {
      super(seed);
      this.allowedBiomes = new BiomeGenBase[]{BiomeGenBaseDBC.OtherW, BiomeGenBaseDBC.OtherW2, BiomeGenBaseDBC.OtherW3, BiomeGenBaseDBC.OtherW4};
   }

   public x1GenLayerOWBiomes(long seed, GenLayer genlayer) {
      super(seed);
      this.allowedBiomes = new BiomeGenBase[]{BiomeGenBaseDBC.OtherW, BiomeGenBaseDBC.OtherW2, BiomeGenBaseDBC.OtherW3, BiomeGenBaseDBC.OtherW4};
      this.field_75909_a = genlayer;
   }

   public int[] func_75904_a(int x, int z, int width, int depth) {
      int[] dest = IntCache.func_76445_a(width * depth);

      for(int dz = 0; dz < depth; ++dz) {
         for(int dx = 0; dx < width; ++dx) {
            this.func_75903_a((long)(dx + x), (long)(dz + z));
            dest[dx + dz * width] = this.allowedBiomes[this.func_75902_a(this.allowedBiomes.length)].field_76756_M;
         }
      }

      return dest;
   }
}
