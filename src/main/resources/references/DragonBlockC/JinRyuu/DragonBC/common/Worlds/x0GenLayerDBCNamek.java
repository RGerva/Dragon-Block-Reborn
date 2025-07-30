package JinRyuu.DragonBC.common.Worlds;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class x0GenLayerDBCNamek extends GenLayer {
   public x0GenLayerDBCNamek(long seed) {
      super(seed);
   }

   public static GenLayer[] makeTheWorld(long seed, WorldType type) {
      GenLayer biomes = new x0GenLayerDBCNamekBiomes(1L);
      GenLayer biomes = new GenLayerZoom(1000L, biomes);
      biomes = new GenLayerZoom(1001L, biomes);
      biomes = new GenLayerZoom(1002L, biomes);
      biomes = new GenLayerZoom(1003L, biomes);
      biomes = new GenLayerZoom(1004L, biomes);
      biomes = new GenLayerZoom(1005L, biomes);
      GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
      biomes.func_75905_a(seed);
      genlayervoronoizoom.func_75905_a(seed);
      return new GenLayer[]{biomes, genlayervoronoizoom};
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      return null;
   }
}
