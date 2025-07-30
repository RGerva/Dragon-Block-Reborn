package JinRyuu.DragonBC.common.Blocks.m;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Items.m.MapleLeafItem;
import JinRyuu.DragonBC.common.Items.m.WoodLeafItem;
import JinRyuu.DragonBC.common.Items.m.WoodLogItem;
import JinRyuu.DragonBC.common.Items.m.WoodPaperItem;
import JinRyuu.DragonBC.common.Items.m.WoodPlanksItem;
import JinRyuu.DragonBC.common.Items.m.WoodSaplingItem;
import JinRyuu.DragonBC.common.Items.m.WoodSlabItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public final class ModdedBlocks {
   public static Block SakuraStone;
   public static Block SakuraPlank;
   public static Block SakuraLogs;
   public static Block SakuraLeaves;
   public static Block SakuraSaplings;
   public static Block SakuraFence;
   public static Block MahagonyFence;
   public static Block MapleFence;
   public static Block SakuraStairs;
   public static Block MahagonyStairs;
   public static Block MapleStairs;
   public static Block MapleLeafs;
   public static BlockSlab SakuraSlabsSingle;
   public static BlockSlab SakuraSlabsDouble;
   public static Block PaperWallMahagony;
   public static Block PaperWallSakura;
   public static Block SakFenc;
   public static Block MahFenc;
   public static Block MapFenc;

   public static final void init() {
      GameRegistry.registerBlock(SakuraStone = new MyNormalBlocks("Sakura_Block", Material.field_151576_e), "Sakura_Block");
      PaperWallMahagony = (new MyPaperWallMahagony("Mahagony", Material.field_151575_d)).func_149663_c("MahagonyPaperWall");
      PaperWallSakura = (new MyPaperWallSakura("Sakura", Material.field_151575_d)).func_149663_c("SakuraPaperWall");
      GameRegistry.registerBlock(PaperWallSakura, WoodPaperItem.class, PaperWallSakura.func_149739_a().substring(5));
      GameRegistry.registerBlock(PaperWallMahagony, WoodPaperItem.class, PaperWallMahagony.func_149739_a().substring(5));
      SakuraPlank = (new MyWoodPlanks()).func_149663_c("Planks");
      SakFenc = (new MyFenceGates(0)).func_149663_c("SakFencGate");
      MahFenc = (new MyFenceGates(1)).func_149663_c("MahFencGate");
      MapFenc = (new MyFenceGates(2)).func_149663_c("MapFencGate");
      SakuraSlabsSingle = new MySlabs(false);
      SakuraSlabsDouble = new MySlabs(true);
      SakuraStairs = (new MyWoodStairs(SakuraStairs, 0)).func_149663_c("SakuraStairs").func_149647_a(mod_DragonBC.DragonBlockC);
      MahagonyStairs = (new MyWoodStairs(MahagonyStairs, 1)).func_149663_c("MahagonyStairs").func_149647_a(mod_DragonBC.DragonBlockC);
      MapleStairs = (new MyWoodStairs(MapleStairs, 2)).func_149663_c("MapleStairs").func_149647_a(mod_DragonBC.DragonBlockC);
      SakuraFence = (new MySakuraFence("SakuraFence", Material.field_151575_d)).func_149752_b(4.0F).func_149711_c(3.0F).func_149647_a(mod_DragonBC.DragonBlockC);
      MahagonyFence = (new MyMahagonyFence("MahagonyFence", Material.field_151575_d)).func_149752_b(5.0F).func_149711_c(4.0F).func_149647_a(mod_DragonBC.DragonBlockC);
      MapleFence = (new MyMapleFence("MapleFence", Material.field_151575_d)).func_149752_b(5.0F).func_149711_c(4.0F).func_149647_a(mod_DragonBC.DragonBlockC);
      SakuraLogs = (new LogBlock()).func_149663_c("Log").func_149647_a(mod_DragonBC.DragonBlockC);
      SakuraLeaves = (new LeafyBlock()).func_149663_c("Leaf").func_149713_g(1).func_149647_a(mod_DragonBC.DragonBlockC);
      SakuraSaplings = (new MySapling()).func_149663_c("Sapling").func_149647_a(mod_DragonBC.DragonBlockC);
      MapleLeafs = (new MapleLeaf()).func_149663_c("Maples").func_149713_g(1).func_149647_a(mod_DragonBC.DragonBlockC);
      GameRegistry.registerBlock(MapleLeafs, MapleLeafItem.class, MapleLeafs.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakuraPlank, WoodPlanksItem.class, SakuraPlank.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakuraStairs, "SakuraStairs");
      GameRegistry.registerBlock(MahagonyStairs, "MahagonyStairs");
      GameRegistry.registerBlock(MapleStairs, "MapleStairs");
      GameRegistry.registerBlock(SakuraSlabsSingle, WoodSlabItem.class, SakuraSlabsSingle.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakuraSlabsDouble, WoodSlabItem.class, "DoubleSlab");
      GameRegistry.registerBlock(SakuraFence, "SakuraFence");
      GameRegistry.registerBlock(MahagonyFence, "MahagonyFence");
      GameRegistry.registerBlock(MapleFence, "MapleFence");
      GameRegistry.registerBlock(SakuraLogs, WoodLogItem.class, SakuraLogs.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakuraLeaves, WoodLeafItem.class, SakuraLeaves.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakuraSaplings, WoodSaplingItem.class, SakuraSaplings.func_149739_a().substring(5));
      GameRegistry.registerBlock(SakFenc, "SakuraFenceGate");
      GameRegistry.registerBlock(MahFenc, "MahagonyFenceGate");
      GameRegistry.registerBlock(MapFenc, "MapleFenceGate");
   }
}
