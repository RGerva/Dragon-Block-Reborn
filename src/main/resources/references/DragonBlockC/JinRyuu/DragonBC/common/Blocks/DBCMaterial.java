package JinRyuu.DragonBC.common.Blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class DBCMaterial extends Material {
   public static final Material dragonblock;

   public DBCMaterial(MapColor par1MapColor) {
      super(par1MapColor);
   }

   static {
      dragonblock = new Material(MapColor.field_151667_k);
   }
}
