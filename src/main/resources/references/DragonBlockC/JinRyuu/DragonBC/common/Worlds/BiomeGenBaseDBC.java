package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm.BiomeNullRealm;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public abstract class BiomeGenBaseDBC extends BiomeGenBase {
   public static BiomeGenBase Namek;
   public static BiomeGenBase Vegeta;
   public static BiomeGenBase Stony;
   public static BiomeGenBase OtherW;
   public static BiomeGenBase OtherW2;
   public static BiomeGenBase OtherW3;
   public static BiomeGenBase OtherW4;
   public static BiomeGenBase TC;
   public static BiomeGenBase NR;

   public BiomeGenBaseDBC(int biomeId) {
      super(biomeId);
   }

   public WorldGenerator func_76730_b(Random random) {
      return random.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.field_150329_H, 2) : new WorldGenTallGrass(Blocks.field_150329_H, 1);
   }

   public static void init() {
      BiomeDictionary.registerBiomeType(Namek, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(Vegeta, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(Stony, new Type[]{Type.HOT, Type.DRY});
      BiomeDictionary.registerBiomeType(OtherW, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(OtherW2, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(OtherW4, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(TC, new Type[]{Type.HOT, Type.DRY});
      BiomeDictionary.registerBiomeType(NR, new Type[]{Type.HOT, Type.DRY});
      BiomeDictionary.registerAllBiomes();
      BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Stony, DBCConfig.cnfDrt));
   }

   static {
      int i = 100;
      int var1 = i + 1;
      Namek = new x0BiomeGenNamek(i);
      ++var1;
      ++var1;
      Vegeta = new x3BiomeGenVegata(var1++);
      Stony = new BiomeGenStony(var1++);
      OtherW = new x1BiomeGenOW(var1++);
      TC = new x2BiomeGenTC(var1++);
      OtherW2 = new x1BiomeGenOW2(var1++);
      OtherW3 = new x1BiomeGenOW3(var1++);
      OtherW4 = new x1BiomeGenOW4(var1++);
      NR = new BiomeNullRealm(var1++);
   }
}
