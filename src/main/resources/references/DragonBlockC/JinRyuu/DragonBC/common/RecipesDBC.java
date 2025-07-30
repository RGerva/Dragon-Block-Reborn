package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemBodyDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Items.VanityColor;
import JinRyuu.DragonBC.common.m.MyRecipes;
import JinRyuu.JRMCore.JRMCoreH2;
import JinRyuu.JRMCore.items.ItemsJRMC;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesDBC {
   public static final Item[] lesz;
   public static final Item[] comp;
   public static final Item[] tier;

   public static void init() {
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[]{"L", "X", 'X', ItemsDBC.ItemKatanaHandle, 'L', ItemsDBC.ItemKatanaSwordBlade});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[]{"L", "X", 'X', ItemsDBC.ItemBraveSwordHandle, 'L', ItemsDBC.ItemBraveSwordBlade});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[]{"L", "X", 'X', ItemsDBC.ItemZSwordHandle, 'L', ItemsDBC.ItemZSwordBlade});
      int WILDCARD = 32767;
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[]{new ItemStack(ItemsDBC.ItemKatana, 1, WILDCARD), new ItemStack(Items.field_151042_j, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[]{new ItemStack(ItemsDBC.ItemBraveSword, 1, WILDCARD), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(Items.field_151042_j, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[]{new ItemStack(ItemsDBC.ItemZSword, 1, WILDCARD), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(ItemsDBC.ItemKatchin, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaHandle, 1), new Object[]{"LXL", 'X', Items.field_151042_j, 'L', Items.field_151116_aA});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordHandle, 1), new Object[]{"X X", "LKL", 'X', Items.field_151042_j, 'L', Items.field_151116_aA, 'K', ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordHandle, 1), new Object[]{"G G", "LKL", 'K', ItemsDBC.ItemKatchin, 'L', Items.field_151116_aA, 'G', Items.field_151043_k});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaSwordBlade, 1), new Object[]{"XXX", "XXX", " X ", 'X', Items.field_151042_j});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordBlade, 1), new Object[]{"XKX", 'X', ItemsDBC.ItemKatanaSwordBlade, 'K', ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordBlade, 1), new Object[]{" K ", "XKX", " K ", 'X', ItemsDBC.ItemBraveSwordBlade, 'K', ItemsDBC.ItemKatchin});
      Item[] scouters = new Item[]{ItemsDBC.BattleArmorHelmet00, ItemsDBC.BattleArmorHelmet01, ItemsDBC.BattleArmorHelmet02, ItemsDBC.BattleArmorHelmet03, ItemsDBC.BattleArmorHelmet04, ItemsDBC.BattleArmorHelmet05, ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a, ItemsDBC.BattleArmorHelmet00b, ItemsDBC.BattleArmorHelmet01b, ItemsDBC.BattleArmorHelmet02b, ItemsDBC.BattleArmorHelmet03b, ItemsDBC.BattleArmorHelmet04b, ItemsDBC.BattleArmorHelmet05b};
      Item[] armor = new Item[]{ItemsDBC.BattleArmorChest00, ItemsDBC.BattleArmorChest01, ItemsDBC.BattleArmorChest02, ItemsDBC.BattleArmorChest03, ItemsDBC.BattleArmorChest04, ItemsDBC.BattleArmorChest05, ItemsDBC.BattleArmorLegs00, ItemsDBC.BattleArmorLegs01, ItemsDBC.BattleArmorLegs02, ItemsDBC.BattleArmorLegs03, ItemsDBC.BattleArmorLegs04, ItemsDBC.BattleArmorLegs05, ItemsDBC.BattleArmorBoots00, ItemsDBC.BattleArmorBoots01, ItemsDBC.BattleArmorBoots02, ItemsDBC.BattleArmorBoots03, ItemsDBC.BattleArmorBoots04, ItemsDBC.BattleArmorBoots05};
      Item[] var3 = scouters;
      int var4 = scouters.length;

      int var5;
      Item n;
      for(var5 = 0; var5 < var4; ++var5) {
         n = var3[var5];
         GameRegistry.addShapelessRecipe(new ItemStack(n, 1), new Object[]{new ItemStack(n, 1, WILDCARD), new ItemStack(ItemsDBC.ItemWarenai, 1, 0)});
      }

      var3 = armor;
      var4 = armor.length;

      for(var5 = 0; var5 < var4; ++var5) {
         n = var3[var5];
         GameRegistry.addShapelessRecipe(new ItemStack(n, 1), new Object[]{new ItemStack(n, 1, WILDCARD), new ItemStack(ItemsDBC.ItemWarenai, 1, 0), new ItemStack(ItemsDBC.ItemWarenai, 1, 0)});
      }

      int i;
      for(i = 0; i < ItemsDBC.OutfitGis.size(); ++i) {
         GameRegistry.addShapelessRecipe(new ItemStack((Item)ItemsDBC.OutfitGis.get(i), 1), new Object[]{new ItemStack((Item)ItemsDBC.OutfitGis.get(i), 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 13), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11)});
         GameRegistry.addShapelessRecipe(new ItemStack((Item)ItemsDBC.OutfitGis.get(i), 1), new Object[]{new ItemStack((Item)ItemsDBC.OutfitGis.get(i), 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 2), new ItemStack(Blocks.field_150325_L, 1, 9), new ItemStack(Blocks.field_150325_L, 1, 4)});
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest00, 1), new Object[]{"X X", "XXX", "XXX", 'X', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet00, 1), new Object[]{"YC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'Y', new ItemStack(Items.field_151100_aR, 1, 11), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet01, 1), new Object[]{"RC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'R', new ItemStack(Items.field_151100_aR, 1, 1), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet02, 1), new Object[]{"PC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'P', new ItemStack(Items.field_151100_aR, 1, 5), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet03, 1), new Object[]{"BC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'B', new ItemStack(Items.field_151100_aR, 1, 4), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet04, 1), new Object[]{"gC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'g', new ItemStack(Items.field_151100_aR, 1, 2), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet05, 1), new Object[]{"PC", "GX", 'X', ItemsDBC.ItemWarenai, 'G', Blocks.field_150359_w, 'P', new ItemStack(Items.field_151100_aR, 1, 9), 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest00, 1), new Object[]{"X X", "XXX", "XXX", 'X', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest01, 1), new Object[]{"D D", "BXB", "BDB", 'X', ItemsDBC.BattleArmorChest00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest02, 1), new Object[]{"D D", "BXB", "BDB", 'X', ItemsDBC.BattleArmorChest00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest03, 1), new Object[]{"D D", " X ", " D ", 'X', ItemsDBC.BattleArmorChest00, 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest04, 1), new Object[]{" D ", "BXB", "BDB", 'X', ItemsDBC.BattleArmorChest00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 2)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest05, 1), new Object[]{" D ", " X ", " D ", 'X', ItemsDBC.BattleArmorChest00, 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs00, 1), new Object[]{"XXX", "X X", "X X", 'X', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs01, 1), new Object[]{"D D", "BXB", "B B", 'X', ItemsDBC.BattleArmorLegs00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs02, 1), new Object[]{"D D", "BXB", "   ", 'X', ItemsDBC.BattleArmorLegs00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs03, 1), new Object[]{" D ", "BXB", "   ", 'X', ItemsDBC.BattleArmorLegs00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs04, 1), new Object[]{"D D", "BXB", "B B", 'X', ItemsDBC.BattleArmorLegs00, 'B', new ItemStack(Items.field_151100_aR, 1, 0), 'D', new ItemStack(Items.field_151100_aR, 1, 2)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs05, 1), new Object[]{"D D", "BXB", "B B", 'X', ItemsDBC.BattleArmorLegs00, 'B', new ItemStack(Items.field_151100_aR, 1, 4), 'D', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots00, 1), new Object[]{"X X", "X X", 'X', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots01, 1), new Object[]{"DXD", "B B", "   ", 'X', ItemsDBC.BattleArmorBoots00, 'B', new ItemStack(Items.field_151100_aR, 1, 12), 'D', new ItemStack(Items.field_151100_aR, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots02, 1), new Object[]{"DXD", "B B", "   ", 'X', ItemsDBC.BattleArmorBoots00, 'B', new ItemStack(Items.field_151100_aR, 1, 3), 'D', new ItemStack(Items.field_151100_aR, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots03, 1), new Object[]{" X ", "B B", "   ", 'X', ItemsDBC.BattleArmorBoots00, 'B', new ItemStack(Items.field_151100_aR, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots04, 1), new Object[]{"DXD", "B B", "   ", 'X', ItemsDBC.BattleArmorBoots00, 'B', new ItemStack(Items.field_151100_aR, 1, 2), 'D', new ItemStack(Items.field_151100_aR, 1, 1)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots05, 1), new Object[]{"DXD", "D D", "   ", 'X', ItemsDBC.BattleArmorBoots00, 'D', new ItemStack(Items.field_151100_aR, 1, 15)});

      for(i = 0; i < lesz.length; ++i) {
         GameRegistry.addRecipe(new ItemStack(lesz[i], 1), new Object[]{" C ", "CXC", " C ", 'X', comp[i], 'C', tier[i / 6]});
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[]{"R R", "RBR", "BRB", 'R', new ItemStack(Blocks.field_150325_L, 1, 14), 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[]{"R R", "R R", "RRR", 'R', new ItemStack(Blocks.field_150325_L, 1, 14)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[]{"B B", "Y Y", 'Y', new ItemStack(Blocks.field_150325_L, 1, 15), 'B', new ItemStack(Blocks.field_150325_L, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter3Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[]{new ItemStack(ItemsDBC.KameTorso1, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 14)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[]{new ItemStack(ItemsDBC.KameBoots1, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[]{"R R", "RBR", "RRR", 'R', new ItemStack(Blocks.field_150325_L, 1, 14), 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[]{"XXX", "X X", "X X", 'X', new ItemStack(Blocks.field_150325_L, 1, 14)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[]{"B B", "Y Y", 'Y', new ItemStack(Blocks.field_150325_L, 1, 4), 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Leg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 14)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Boots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 4)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[]{"B B", "BBB", "BBB", 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[]{"XXX", "X X", "X X", 'X', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[]{"B B", "B B", 'B', new ItemStack(Blocks.field_150325_L, 1, 12)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekTorso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekLeg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekBoots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[]{"B B", "BBB", 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[]{"XXX", "X X", "X X", 'X', new ItemStack(Blocks.field_150325_L, 1, 7)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[]{"B B", "B B", 'B', new ItemStack(Blocks.field_150325_L, 1, 4)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureTorso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureLeg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 7), new ItemStack(Blocks.field_150325_L, 1, 7)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureBoots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 4)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[]{"B B", "BRB", "BBB", 'R', new ItemStack(Blocks.field_150325_L, 1, 14), 'B', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[]{"BBB", "X X", "X X", 'X', new ItemStack(Blocks.field_150325_L, 1, 11), 'B', new ItemStack(Blocks.field_150325_L, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[]{"Y Y", "Y Y", 'Y', new ItemStack(Blocks.field_150325_L, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Leg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 3)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Boots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.SpacePod01Item, 1), new Object[]{"WWW", "WCW", "WWW", 'C', ItemsDBC.ItemChipTier2, 'W', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemAlienTechChipTier1, 3), new Object[]{"GIR", "CCC", "WWW", 'C', new ItemStack(Items.field_151100_aR, 1, 2), 'G', Items.field_151043_k, 'I', Items.field_151042_j, 'R', Items.field_151137_ax, 'W', ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier2, 1), new Object[]{"BGB", "CCC", "GBG", 'C', ItemsDBC.ItemAlienTechChipTier1, 'B', new ItemStack(Items.field_151100_aR, 1, 4), 'G', Items.field_151114_aO});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier3, 1), new Object[]{"BDB", "CcC", "DBD", 'C', ItemsDBC.ItemChipTier2, 'c', ItemsDBC.ItemAlienTechChipTier1, 'B', new ItemStack(Items.field_151100_aR, 1, 4), 'D', Items.field_151045_i});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.ArtGravDevBlock, 1), new Object[]{"IKI", "CCC", "KIK", 'C', ItemsDBC.ItemChipTier3, 'I', Items.field_151042_j, 'K', ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBucketMedLiq, 1), new Object[]{"CCC", "CBC", "CCC", 'C', ItemsDBC.ItemMedMoss, 'B', Items.field_151133_ar});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemDragonRadar, 1), new Object[]{"ICI", "CWC", "ICI", 'I', Items.field_151042_j, 'W', ItemsDBC.ItemWarenai, 'C', ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[]{"X", 'X', BlocksDBC.BlockNamekLog});
      GameRegistry.addRecipe(new ItemStack(Blocks.field_150347_e, 1), new Object[]{"X", 'X', BlocksDBC.BlockAlienCobbleStone});
      GameRegistry.addRecipe(new ItemStack(Blocks.field_150348_b, 1), new Object[]{"X", 'X', BlocksDBC.BlockAlienStone});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockNamekStone, 4), new Object[]{"XX", "XX", 'X', BlocksDBC.BlockAlienStone});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[11], 1), new Object[]{"II ", "IS ", " S ", 'I', ItemsDBC.ItemsOW[2], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[8], 1), new Object[]{"III", " S ", " S ", 'I', ItemsDBC.ItemsOW[2], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[5], 1), new Object[]{" I ", " I ", " S ", 'I', ItemsDBC.ItemsOW[2], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[10], 1), new Object[]{"II ", "IS ", " S ", 'I', ItemsDBC.ItemsOW[1], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[7], 1), new Object[]{"III", " S ", " S ", 'I', ItemsDBC.ItemsOW[1], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[4], 1), new Object[]{" I ", " I ", " S ", 'I', ItemsDBC.ItemsOW[1], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[12], 1), new Object[]{"II ", "IS ", " S ", 'I', ItemsDBC.ItemsOW[0], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[9], 1), new Object[]{"III", " S ", " S ", 'I', ItemsDBC.ItemsOW[0], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[6], 1), new Object[]{" I ", " I ", " S ", 'I', ItemsDBC.ItemsOW[0], 'S', Items.field_151055_y});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[0], 1), new Object[]{"III", "III", "III", 'I', ItemsDBC.ItemsOW[3]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[1], 1), new Object[]{"III", "III", "III", 'I', ItemsDBC.ItemsOW[1]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[2], 1), new Object[]{"III", "III", "III", 'I', ItemsDBC.ItemsOW[0]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[3], 1), new Object[]{"III", "III", "III", 'I', ItemsDBC.ItemsOW[2]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[3], 9), new Object[]{BlocksDBC.BlockOW[0]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[1], 9), new Object[]{BlocksDBC.BlockOW[1]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[0], 9), new Object[]{BlocksDBC.BlockOW[2]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[2], 9), new Object[]{BlocksDBC.BlockOW[3]});

      for(i = 0; i < 3; ++i) {
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 13], 1), new Object[]{"XXX", "X X", 'X', ItemsDBC.ItemsOW[i]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 14], 1), new Object[]{"X X", "XXX", "XXX", 'X', ItemsDBC.ItemsOW[i]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 15], 1), new Object[]{"XXX", "X X", "X X", 'X', ItemsDBC.ItemsOW[i]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 16], 1), new Object[]{"X X", "X X", 'X', ItemsDBC.ItemsOW[i]});
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemWarenaiFabric, 4), new Object[]{"WOW", "OWO", "WOW", 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'O', ItemsDBC.ItemWarenai});
      String[] row1 = new String[]{"FFF", "WWW", "FFF", "FWF", "FWF", "   ", "   ", "   "};
      String[] row2 = new String[]{"FFF", "FFF", "WFW", "FFF", "WFW", "FFF", "WFW", "WFW"};
      String[] row3 = new String[]{"W W", "W W", "W W", "W W", "W W", "W W", "W W", "   "};

      for(int i = 0; i < ItemsDBC.ItemBodysuits.length; ++i) {
         ItemStack body = new ItemStack(ItemsDBC.ItemBodysuits[i]);
         GameRegistry.addRecipe(body, new Object[]{row1[i], row2[i], row3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemWarenaiFabric});

         for(int j = 0; j < JRMCoreH2.colNams.length; ++j) {
            body = new ItemStack(ItemsDBC.ItemBodysuits[i]);
            ((ItemBodyDBC)body.func_77973_b()).setColor(body, JRMCoreH2.cols[j]);
            ItemStack dye = new ItemStack(Items.field_151100_aR, 1, j);
            GameRegistry.addRecipe(((ItemBodyDBC)body.func_77973_b()).setColor(body, JRMCoreH2.cols[j]), new Object[]{"DDD", "DXD", "DDD", 'X', ItemsDBC.ItemBodysuits[i], 'D', dye});
         }
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemStrongFabric, 4), new Object[]{"WOW", "WOW", "WOW", 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'O', ItemsDBC.ItemWarenai});
      String[] gi_row1 = new String[]{"F F", "F F", "F F"};
      String[] gi_row2 = new String[]{"FWF", "FWF", " W "};
      String[] gi_row3 = new String[]{" F ", "FFF", " F "};

      for(int i = 0; i < ItemsDBC.ItemGiBody.length; ++i) {
         ItemStack body = new ItemStack(ItemsDBC.ItemGiBody[i]);
         GameRegistry.addRecipe(body, new Object[]{gi_row1[i], gi_row2[i], gi_row3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});

         for(int j = 0; j < JRMCoreH2.colNams.length; ++j) {
            body = new ItemStack(ItemsDBC.ItemGiBody[i]);
            ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[j]);
            ItemStack dye = new ItemStack(Items.field_151100_aR, 1, j);
            GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[j]), new Object[]{"DDD", "DXD", "DDD", 'X', ItemsDBC.ItemGiBody[i], 'D', dye});
         }
      }

      String[] gi_color_Head1 = new String[]{"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Head2 = new String[]{"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "WFF", "FWF"};
      String[] gi_color_Head3 = new String[]{"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Chest1 = new String[]{"W F", "   ", "   ", "   ", "   ", "F F", "FFF", "  F", "   ", "   ", "   ", "  F"};
      String[] gi_color_Chest2 = new String[]{"FFF", "   ", "   ", "FFF", " F ", " W ", "FWF", "FWF", "   ", "   ", "F W", "W F"};
      String[] gi_color_Chest3 = new String[]{"FFF", "   ", "   ", " F ", " F ", "   ", "FFF", "FFF", "   ", "   ", "F  ", "   "};
      String[] gi_color_Legs1 = new String[]{"WFF", "FWF", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Legs2 = new String[]{"F F", "F F", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Legs3 = new String[]{"F F", "F F", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Boots1 = new String[]{"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Boots2 = new String[]{"W F", "   ", "F F", "   ", "   ", "   ", "   ", "   "};
      String[] gi_color_Boots3 = new String[]{"F F", "   ", "F F", "   ", "   ", "   ", "   ", "   "};
      int added = 0;

      int k;
      for(int i = 0; i < 12; ++i) {
         for(int j = 0; j < 4; ++j) {
            if (ItemsDBC.ItemsGiType[i].contains("" + j)) {
               ItemStack body;
               if (j == 0) {
                  body = new ItemStack(ItemsDBC.ItemsGi0[i]);
               } else if (j == 1) {
                  body = new ItemStack(ItemsDBC.ItemsGi1[i]);
               } else if (j == 2) {
                  body = new ItemStack(ItemsDBC.ItemsGi2[i]);
               } else {
                  body = new ItemStack(ItemsDBC.ItemsGi3[i]);
               }

               if (j == 0) {
                  GameRegistry.addRecipe(body, new Object[]{gi_color_Head1[i], gi_color_Head2[i], gi_color_Head3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});
               } else if (j == 1) {
                  GameRegistry.addRecipe(body, new Object[]{gi_color_Chest1[i], gi_color_Chest2[i], gi_color_Chest3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});
               } else if (j == 2) {
                  GameRegistry.addRecipe(body, new Object[]{gi_color_Legs1[i], gi_color_Legs2[i], gi_color_Legs3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});
               } else {
                  GameRegistry.addRecipe(body, new Object[]{gi_color_Boots1[i], gi_color_Boots2[i], gi_color_Boots3[i], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});
               }

               for(k = 0; k < JRMCoreH2.colNams.length; ++k) {
                  body = new ItemStack((Item)ItemsDBC.ItemGi.get(added));
                  ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[k]);
                  ItemStack dye = new ItemStack(Items.field_151100_aR, 1, k);
                  GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[k]), new Object[]{"DDD", "DXD", "DDD", 'X', ItemsDBC.ItemGi.get(added), 'D', dye});
               }

               ++added;
            }
         }
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.Coat, 1), new Object[]{"F W", "WWW", "WWW", 'F', ItemsJRMC.Custom_fabric, 'W', new ItemStack(Blocks.field_150325_L, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.Coat_2, 1), new Object[]{"F W", "WWW", "WWW", 'F', ItemsJRMC.Custom_fabric, 'W', new ItemStack(Blocks.field_150325_L, 1, 13)});
      added += 2;
      String[] gi_color_Chest1_1 = new String[]{"   ", "   "};
      String[] gi_color_Chest2_1 = new String[]{"FFF", "FFF"};
      String[] gi_color_Chest3_1 = new String[]{"   ", "FFF"};

      for(k = 0; k < 2; ++k) {
         int j = 1;
         if (ItemsDBC.ItemsGiType2[k].contains("" + j)) {
            ItemStack body = new ItemStack(ItemsDBC.ItemsGi1_2[k]);
            GameRegistry.addRecipe(body, new Object[]{gi_color_Chest1_1[k], gi_color_Chest2_1[k], gi_color_Chest3_1[k], 'W', new ItemStack(Blocks.field_150325_L, 1, 0), 'F', ItemsDBC.ItemStrongFabric});

            for(int k = 0; k < JRMCoreH2.colNams.length; ++k) {
               body = new ItemStack((Item)ItemsDBC.ItemGi.get(added));
               ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[k]);
               ItemStack dye = new ItemStack(Items.field_151100_aR, 1, k);
               GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[k]), new Object[]{"DDD", "DXD", "DDD", 'X', ItemsDBC.ItemGi.get(added), 'D', dye});
            }

            ++added;
         }
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemDimensionSword, 1), new Object[]{"AAA", "ABA", "AAA", 'A', ItemsDBC.ItemJanembaEssence, 'B', ItemsDBC.ItemSmallClub});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[0], 1), new Object[]{"AAA", "AAA", "AAA", 'A', ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatchin, 9), new Object[]{"AAA", "AAA", "AAA", 'A', BlocksDBC.BlockKachin[0]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemKatchin, 9), new Object[]{new ItemStack(BlocksDBC.BlockKachin[0], 1, WILDCARD)});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[1], 4), new Object[]{"AA", "AA", 'A', BlocksDBC.BlockKachin[0]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[2], 4), new Object[]{"AA", "AA", 'A', BlocksDBC.BlockKachin[1]});
      GameRegistry.addSmelting(BlocksDBC.BlockDragonBallStone, new ItemStack(BlocksDBC.BlockDragonBall, 1), 0.1F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreWrenai, new ItemStack(ItemsDBC.ItemWarenai, 1), 0.7F);
      GameRegistry.addSmelting(BlocksDBC.BlockAlienCobbleStone, new ItemStack(BlocksDBC.BlockAlienStone, 1), 0.1F);
      GameRegistry.addSmelting(Items.field_151102_aT, new ItemStack(Items.field_151100_aR, 1, 3), 0.2F);
      GameRegistry.addSmelting(ItemsDBC.ItemDinoMeat, new ItemStack(ItemsDBC.ItemDinoMeatCooked), 0.5F);
      GameRegistry.addSmelting(ItemsDBC.ItemDinoMeatBig, new ItemStack(ItemsDBC.ItemDinoMeatCookedBig), 0.5F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreLehnori, new ItemStack(ItemsDBC.ItemsOW[0]), 0.7F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreDlog, new ItemStack(ItemsDBC.ItemsOW[1]), 1.0F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreDnomaid, new ItemStack(ItemsDBC.ItemsOW[2]), 1.0F);
      MyRecipes.init();
   }

   static {
      lesz = new Item[]{ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a, ItemsDBC.BattleArmorHelmet00b, ItemsDBC.BattleArmorHelmet01b, ItemsDBC.BattleArmorHelmet02b, ItemsDBC.BattleArmorHelmet03b, ItemsDBC.BattleArmorHelmet04b, ItemsDBC.BattleArmorHelmet05b};
      comp = new Item[]{ItemsDBC.BattleArmorHelmet00, ItemsDBC.BattleArmorHelmet01, ItemsDBC.BattleArmorHelmet02, ItemsDBC.BattleArmorHelmet03, ItemsDBC.BattleArmorHelmet04, ItemsDBC.BattleArmorHelmet05, ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a};
      tier = new Item[]{ItemsDBC.ItemChipTier2, ItemsDBC.ItemChipTier3};
   }
}
