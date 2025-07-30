package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.m.ModdedItems;
import JinRyuu.DragonBC.common.Render.DragonBlock01Item;
import JinRyuu.DragonBC.common.Render.DragonBlock01ItemR;
import JinRyuu.DragonBC.common.Render.KintounBlackItem;
import JinRyuu.DragonBC.common.Render.KintounItem;
import JinRyuu.DragonBC.common.Render.SpacePod01Item;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.EnumHelper;

public class ItemsDBC {
   public static ToolMaterial KATANA = EnumHelper.addToolMaterial("KATANA", 1, 500, 6.0F, 10.0F, 20);
   public static ToolMaterial ZSWORD = EnumHelper.addToolMaterial("ZSWORD", 3, 2000, 8.0F, 20.0F, 5);
   public static ToolMaterial BSWORD = EnumHelper.addToolMaterial("BSWORD", 2, 1000, 12.0F, 15.0F, 25);
   public static ToolMaterial HandleSWORD = EnumHelper.addToolMaterial("HandleSWORD", 1, 100, 1.0F, 1.0F, 1);
   public static ToolMaterial BladeSWORD = EnumHelper.addToolMaterial("BladeSWORD", 1, 100, 2.0F, 1.0F, 1);
   public static ToolMaterial STAFFPP = EnumHelper.addToolMaterial("STAFFPP", 1, 1000, 8.0F, 10.0F, 1);
   public static ToolMaterial EVILSPEAR = EnumHelper.addToolMaterial("EVILSPEAR", 1, 1000, 6.0F, 10.0F, 20);
   public static ToolMaterial DIMENSIONSWORD = EnumHelper.addToolMaterial("DIMENSIONSWORD", 1, 100, 12.0F, 20.0F, 20);
   public static ToolMaterial SMALLCLUB = EnumHelper.addToolMaterial("SMALLCLUB", 1, 70, 1.0F, 1.0F, 1);
   public static Item ItemEvilSpear;
   public static Item ItemDimensionSword;
   public static Item ItemJanembaEssence;
   public static Item ItemSmallClub;
   public static ArmorMaterial GI2 = EnumHelper.addArmorMaterial("GI", 250, new int[]{3, 5, 5, 5}, 20);
   public static ArmorMaterial GI = EnumHelper.addArmorMaterial("GI", 150, new int[]{3, 5, 5, 5}, 20);
   public static ArmorMaterial WARENAI = EnumHelper.addArmorMaterial("WARENAI", 300, new int[]{3, 8, 6, 3}, 10);
   public static ArmorMaterial tier0 = EnumHelper.addArmorMaterial("tier0", 300, new int[]{1, 10, 6, 3}, 10);
   public static ArmorMaterial tier1 = EnumHelper.addArmorMaterial("tier1", 300, new int[]{1, 10, 4, 3}, 10);
   public static ArmorMaterial tier2 = EnumHelper.addArmorMaterial("tier2", 300, new int[]{1, 10, 2, 3}, 10);
   public static ArmorMaterial tier3 = EnumHelper.addArmorMaterial("tier3", 300, new int[]{1, 8, 4, 3}, 10);
   public static ArmorMaterial scouter1 = EnumHelper.addArmorMaterial("scouter1", 300, new int[]{1, 10, 6, 3}, 10);
   public static ArmorMaterial scouter2 = EnumHelper.addArmorMaterial("scouter2", 300, new int[]{2, 10, 6, 3}, 10);
   public static ArmorMaterial scouter3 = EnumHelper.addArmorMaterial("scouter3", 300, new int[]{3, 10, 6, 3}, 10);
   public static Item SpacePod01Item;
   public static Item SpacePodVegetaChip;
   public static Item KintounItem;
   public static Item KintounBlackItem;
   public static Item ItemAlienTechChipTier1;
   public static Item ItemChipTier2;
   public static Item ItemChipTier3;
   public static Item ItemDragonRadar;
   public static Item ItemDragonBlock;
   public static Item ItemNamekDragonBlock;
   public static Item ItemSaibaiSeed;
   public static Item ItemSenzu;
   public static Item ItemWarenai;
   public static Item ItemWarenaiFabric;
   public static Item ItemStrongFabric;
   public static Item ItemKatana;
   public static Item ItemNamekIT;
   public static Item ItemKatchin;
   public static Item ItemZSword;
   public static Item ItemBraveSword;
   public static Item ItemKatanaHandle;
   public static Item ItemBraveSwordHandle;
   public static Item ItemZSwordHandle;
   public static Item ItemKatanaSwordBlade;
   public static Item ItemBraveSwordBlade;
   public static Item ItemZSwordBlade;
   public static Item ItemPP;
   public static Item ItemDinoMeat;
   public static Item ItemDinoMeatCooked;
   public static Item ItemDinoMeatBig;
   public static Item ItemDinoMeatCookedBig;
   public static Item ItemBucketMedLiq;
   public static Item ItemMedMoss;
   public static ItemPotion Bloods;
   public static ArrayList<Item> BattleArmors = new ArrayList();
   public static ArrayList<Item> OutfitGis = new ArrayList();
   public static Item BattleArmorHelmet00;
   public static Item BattleArmorChest00;
   public static Item BattleArmorLegs00;
   public static Item BattleArmorBoots00;
   public static Item BattleArmorHelmet01;
   public static Item BattleArmorChest01;
   public static Item BattleArmorLegs01;
   public static Item BattleArmorBoots01;
   public static Item BattleArmorHelmet02;
   public static Item BattleArmorChest02;
   public static Item BattleArmorLegs02;
   public static Item BattleArmorBoots02;
   public static Item BattleArmorHelmet03;
   public static Item BattleArmorChest03;
   public static Item BattleArmorLegs03;
   public static Item BattleArmorBoots03;
   public static Item BattleArmorHelmet04;
   public static Item BattleArmorChest04;
   public static Item BattleArmorLegs04;
   public static Item BattleArmorBoots04;
   public static Item BattleArmorHelmet05;
   public static Item BattleArmorChest05;
   public static Item BattleArmorLegs05;
   public static Item BattleArmorBoots05;
   public static Item BattleArmorHelmet00a;
   public static Item BattleArmorHelmet01a;
   public static Item BattleArmorHelmet02a;
   public static Item BattleArmorHelmet03a;
   public static Item BattleArmorHelmet04a;
   public static Item BattleArmorHelmet05a;
   public static Item BattleArmorHelmet00b;
   public static Item BattleArmorHelmet01b;
   public static Item BattleArmorHelmet02b;
   public static Item BattleArmorHelmet03b;
   public static Item BattleArmorHelmet04b;
   public static Item BattleArmorHelmet05b;
   public static Item BattleArmorHelmet06;
   public static Item BattleArmorChest06;
   public static Item BattleArmorLegs06;
   public static Item BattleArmorBoots06;
   public static Item BattleArmorHelmet07;
   public static Item BattleArmorChest07;
   public static Item BattleArmorBoots07;
   public static Item BattleArmorHelmet08;
   public static Item BattleArmorChest08;
   public static Item BattleArmorBoots08;
   public static Item BattleArmorHelmet09;
   public static Item BattleArmorChest09;
   public static Item BattleArmorLegs09;
   public static Item BattleArmorBoots09;
   public static Item Coat;
   public static Item Coat_2;
   public static Item GiFighter1Torso;
   public static Item GiFighter1Leg;
   public static Item GiFighter1Boots;
   public static Item GiNamekTorso;
   public static Item GiNamekLeg;
   public static Item GiNamekBoots;
   public static Item GiFutureTorso;
   public static Item GiFutureLeg;
   public static Item GiFutureBoots;
   public static Item GiFighter2Torso;
   public static Item GiFighter2Leg;
   public static Item GiFighter2Boots;
   public static Item JinTorso;
   public static Item JinLeg;
   public static Item JinBoots;
   public static Item KameTorso1;
   public static Item KameBoots1;
   public static Item GiFighter3Torso;
   public static Item ItemWeightShell;
   public static Item ItemWeightShirt;
   public static Item ItemWeightHandLeg;
   public static Item ItemWeightCape;
   public static Item ItemWeightHeavySuit;
   public static final String[] ItemsOutfitnams = new String[]{"c16", "c17", "c18", "c19", "c20", "darbura", "majinbuufat", "majinbuu", "tien", "chichi", "genblue", "highschool", "karinga", "pilaf", "saiyaman", "supkai", "black", "fusiond", "broly", "demonclan", "hercules", "kingkai", "lordslug", "mrpopo", "orintemp", "uub", "videl2", "videl3", "videl", "yamcha", "supkaiblack", "tracksuit", "cabba", "caulifla", "gokugtgi", "gokus", "hit", "kale", "pridetrooper", "vegetas", "whis", "c18s", "superc17", "c18-2", "tienb", "tiens", "pan", "c17s", "xenogoku01"};
   public static final String[] ItemsOutfitType = new String[]{"1,2,3", "1,2,3", "1,2,3", "0,1,2,3", "0,1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "0,1,2,3", "0,1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2", "1,3", "1", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3"};
   public static final String[] ItemsGiType = new String[]{"1,2,3", "2", "3", "1", "1", "1", "1", "1", "0", "0", "1", "1"};
   public static final String[] ItemsGiType2 = new String[]{"1", "1"};
   public static final int outfit_c16 = 0;
   public static final int outfit_c17 = 1;
   public static final int outfit_c18 = 2;
   public static final int outfit_c19 = 3;
   public static final int outfit_c20 = 4;
   public static final int outfit_darbura = 5;
   public static final int outfit_majinbuufat = 6;
   public static final int outfit_majinbuu = 7;
   public static final int outfit_tien = 8;
   public static final int outfit_chichi = 9;
   public static final int outfit_genblue = 10;
   public static final int outfit_highschool = 11;
   public static final int outfit_karinga = 12;
   public static final int outfit_pilaf = 13;
   public static final int outfit_saiyaman = 14;
   public static final int outfit_supkai = 15;
   public static final int outfit_black = 16;
   public static final int outfit_fusionDance = 17;
   public static final int outfit_broly = 18;
   public static final int outfit_demonclan = 19;
   public static final int outfit_hercules = 20;
   public static final int outfit_kingkai = 21;
   public static final int outfit_lordslug = 22;
   public static final int outfit_mrpopo = 23;
   public static final int outfit_orintemp = 24;
   public static final int outfit_uub = 25;
   public static final int outfit_videl2 = 26;
   public static final int outfit_videl3 = 27;
   public static final int outfit_videl = 28;
   public static final int outfit_yamcha = 29;
   public static final int outfit_superKaiBlack = 30;
   public static final int outfit_tracksuit = 31;
   public static Item[] ItemsOutfit0;
   public static Item[] ItemsOutfit1;
   public static Item[] ItemsOutfit2;
   public static Item[] ItemsOutfit3;
   public static final int ItemGis = 12;
   public static final int ItemGis2 = 2;
   public static Item[] ItemsGi0;
   public static Item[] ItemsGi1;
   public static Item[] ItemsGi2;
   public static Item[] ItemsGi3;
   public static Item[] ItemsGi1_2;
   public static final String[] ItemsBodynams;
   public static Item[] ItemsBody;
   public static final String[] ItemsHeadnams;
   public static Item[] ItemsHead;
   public static final int ItemBodysuitAmount = 8;
   public static ItemBodyDBC[] ItemBodysuits;
   public static final int ItemGiAmount = 3;
   public static final int[] ItemGiType;
   public static VanityColor[] ItemGiBody;
   public static ArrayList<Item> ItemGi;
   public static final String[] ItemsRecnams;
   public static Item[] ItemsRec;
   public static final int ItemLehnoriIngot = 0;
   public static final int ItemDlogIngot = 1;
   public static final int ItemDnomaidIngot = 2;
   public static final int Itemjjay = 3;
   public static final int ItemDlogSword = 4;
   public static final int ItemDnomaidSword = 5;
   public static final int ItemLehnoriSword = 6;
   public static final int ItemDlogPickaxe = 7;
   public static final int ItemDnomaidPickaxe = 8;
   public static final int ItemLehnoriPickaxe = 9;
   public static final int ItemDlogAxe = 10;
   public static final int ItemDnomaidAxe = 11;
   public static final int ItemLehnoriAxe = 12;
   public static final int ItemLehnoriHelm = 13;
   public static final int ItemLehnoriChest = 14;
   public static final int ItemLehnoriLeg = 15;
   public static final int ItemLehnoriBoot = 16;
   public static final int ItemDlogHelm = 17;
   public static final int ItemDlogChest = 18;
   public static final int ItemDlogLeg = 19;
   public static final int ItemDlogBoot = 20;
   public static final int ItemDnomaidHelm = 21;
   public static final int ItemDnomaidChest = 22;
   public static final int ItemDnomaidLeg = 23;
   public static final int ItemDnomaidBoot = 24;
   public static final String[] ItemOWnams;
   public static final Item[] ItemOWtypes;
   public static Item[] ItemsOW;
   public static final int[] ItemsVanityNum;
   public static final int[] ItemVanity3;
   public static Item[] ItemsVanity;

   public static void init() {
      SpacePod01Item = GameRegistry.registerItem((new SpacePod01Item(BlocksDBC.SpacePod01Block, GI, 0, 0)).func_77655_b("SpacePod01Item"), "SpacePod01Item", (String)null);
      KintounItem = GameRegistry.registerItem((new KintounItem()).func_77655_b("KintounItem"), "KintounItem", (String)null);
      KintounBlackItem = GameRegistry.registerItem((new KintounBlackItem()).func_77655_b("KintounBlackItem"), "KintounBlackItem", (String)null);
      ItemBucketMedLiq = GameRegistry.registerItem((new ItemDBCBucket(BlocksDBC.BlockHealingPods)).func_77655_b("ItemBucketMedLiq"), "ItemBucketMedLiq", (String)null);
      ItemMedMoss = GameRegistry.registerItem((new ItemMedMoss(1, 0.1F)).func_77655_b("ItemMedMoss"), "ItemMedMoss", (String)null);
      ItemSenzu = GameRegistry.registerItem((new ItemSenzu(20, 10.0F, true)).func_77655_b("ItemSenzu"), "ItemSenzu", (String)null);
      ItemSaibaiSeed = GameRegistry.registerItem((new ItemSaibaiSeed()).func_77655_b("ItemSaibaiSeed"), "ItemSaibaiSeed", (String)null);
      ItemWarenai = GameRegistry.registerItem((new ItemWarenai()).func_77655_b("ItemWarenai"), "ItemWarenai", (String)null);
      ItemKatana = GameRegistry.registerItem((new ItemKatana(KATANA)).func_77655_b("ItemKatana"), "ItemKatana", (String)null);
      ItemKatchin = GameRegistry.registerItem((new ItemKatchin()).func_77655_b("ItemKatchin"), "ItemKatchin", (String)null);
      ItemBraveSword = GameRegistry.registerItem((new ItemBraveSword(BSWORD)).func_77655_b("ItemBraveSword"), "ItemBraveSword", (String)null);
      ItemZSword = GameRegistry.registerItem((new ItemZSword(ZSWORD)).func_77655_b("ItemZSword"), "ItemZSword", (String)null);
      ItemKatanaHandle = GameRegistry.registerItem((new ItemKatanaHandle(HandleSWORD)).func_77655_b("ItemKatanaHandle"), "ItemKatanaHandle", (String)null);
      ItemBraveSwordHandle = GameRegistry.registerItem((new ItemBraveSwordHandle(HandleSWORD)).func_77655_b("ItemBraveSwordHandle"), "ItemBraveSwordHandle", (String)null);
      ItemZSwordHandle = GameRegistry.registerItem((new ItemZSwordHandle(HandleSWORD)).func_77655_b("ItemZSwordHandle"), "ItemZSwordHandle", (String)null);
      ItemKatanaSwordBlade = GameRegistry.registerItem((new ItemKatanaBlade(BladeSWORD)).func_77655_b("ItemKatanaSwordBlade"), "ItemKatanaSwordBlade", (String)null);
      ItemBraveSwordBlade = GameRegistry.registerItem((new ItemBraveSwordBlade(BladeSWORD)).func_77655_b("ItemBraveSwordBlade"), "ItemBraveSwordBlade", (String)null);
      ItemZSwordBlade = GameRegistry.registerItem((new ItemZSwordBlade(BladeSWORD)).func_77655_b("ItemZSwordBlade"), "ItemZSwordBlade", (String)null);
      ItemEvilSpear = GameRegistry.registerItem((new ItemSwordBase(EVILSPEAR)).func_77655_b("ItemEvilSpear"), "ItemEvilSpear", (String)null);
      ItemDimensionSword = GameRegistry.registerItem((new ItemSwordBase(DIMENSIONSWORD)).func_77655_b("ItemDimensionSword"), "ItemDimensionSword", (String)null);
      ItemJanembaEssence = GameRegistry.registerItem((new ItemAnyBase()).func_77655_b("ItemJanembaEssence"), "ItemJanembaEssence", (String)null);
      ItemSmallClub = GameRegistry.registerItem((new ItemAnyBase()).func_77625_d(1).func_77655_b("ItemSmallClub"), "ItemSmallClub", (String)null);
      ItemPP = GameRegistry.registerItem((new ItemWeapon(STAFFPP)).func_77655_b("ItemPP"), "ItemPP", (String)null);

      int i;
      for(i = 0; i < ItemOWnams.length; ++i) {
         ItemsOW[i] = GameRegistry.registerItem(ItemOWtypes[i].func_77655_b(ItemOWnams[i]), ItemOWnams[i], (String)null);
      }

      for(i = 0; i < ItemsRecnams.length; ++i) {
         ItemsRec[i] = GameRegistry.registerItem((new ItemRec(ItemsRecnams[i])).func_77655_b("record." + ItemsRecnams[i]), "record." + ItemsRecnams[i], (String)null);
      }

      String[] s;
      int j;
      int iddd;
      for(i = 0; i < ItemsOutfitnams.length; ++i) {
         s = ItemsOutfitType[i].split(",");

         for(j = 0; j < s.length; ++j) {
            iddd = Integer.parseInt(s[j]);
            switch(iddd) {
            case 0:
               OutfitGis.add(ItemsOutfit0[i] = GameRegistry.registerItem((new GiTurtle(GI2, 0, iddd, ItemsOutfitnams[i])).func_77655_b(ItemsOutfitnams[i] + "Head"), ItemsOutfitnams[i] + "Head", (String)null));
               break;
            case 1:
               OutfitGis.add(ItemsOutfit1[i] = GameRegistry.registerItem((new GiTurtle(GI2, 0, iddd, ItemsOutfitnams[i])).func_77655_b(ItemsOutfitnams[i] + "Chest"), ItemsOutfitnams[i] + "Chest", (String)null));
               break;
            case 2:
               OutfitGis.add(ItemsOutfit2[i] = GameRegistry.registerItem((new GiTurtle(GI2, 0, iddd, ItemsOutfitnams[i])).func_77655_b(ItemsOutfitnams[i] + "Leg"), ItemsOutfitnams[i] + "Leg", (String)null));
               break;
            case 3:
               OutfitGis.add(ItemsOutfit3[i] = GameRegistry.registerItem((new GiTurtle(GI2, 0, iddd, ItemsOutfitnams[i])).func_77655_b(ItemsOutfitnams[i] + "Boots"), ItemsOutfitnams[i] + "Boots", (String)null));
            }
         }
      }

      int id;
      for(i = 0; i < 12; ++i) {
         s = ItemsGiType[i].split(",");

         for(j = 0; j < s.length; ++j) {
            int iddd = false;
            id = Integer.parseInt(s[j]);
            switch(id) {
            case 0:
               ItemGi.add(ItemsGi0[i] = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, id, "gi_color_" + i)).func_77655_b("gi_color_" + i + "Head"), "gi_color_" + i + "Head", (String)null));
               break;
            case 1:
               ItemGi.add(ItemsGi1[i] = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, id, "gi_color_" + i)).func_77655_b("gi_color_" + i + "Chest"), "gi_color_" + i + "Chest", (String)null));
               break;
            case 2:
               ItemGi.add(ItemsGi2[i] = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, id, "gi_color_" + i)).func_77655_b("gi_color_" + i + "Leg"), "gi_color_" + i + "Leg", (String)null));
               break;
            case 3:
               ItemGi.add(ItemsGi3[i] = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, id, "gi_color_" + i)).func_77655_b("gi_color_" + i + "Boots"), "gi_color_" + i + "Boots", (String)null));
            }
         }
      }

      for(i = 0; i < 8; ++i) {
         ItemBodysuits[i] = (ItemBodyDBC)GameRegistry.registerItem((new ItemBodyDBC(JRMCoreH2.cols[15], "body" + i)).func_77655_b("bodysuit" + i), "bodysuit" + i, (String)null);
      }

      for(i = 0; i < 3; ++i) {
         ItemGiBody[i] = (VanityColor)GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, ItemGiType[i], "gi" + i)).func_77655_b("gi" + i), "gi" + i, (String)null);
      }

      ItemWarenaiFabric = GameRegistry.registerItem((new ItemAnyBase()).func_77655_b("ItemWarenaiFabric"), "ItemWarenaiFabric", (String)null);
      ItemStrongFabric = GameRegistry.registerItem((new ItemAnyBase()).func_77655_b("ItemStrongFabric"), "ItemStrongFabric", (String)null);
      ItemAlienTechChipTier1 = GameRegistry.registerItem((new ItemKatchin()).func_77655_b("ItemAlienTechChipTier1"), "ItemAlienTechChipTier1", (String)null);
      ItemChipTier2 = GameRegistry.registerItem((new ItemKatchin()).func_77655_b("ItemChipTier2"), "ItemChipTier2", (String)null);
      ItemChipTier3 = GameRegistry.registerItem((new ItemKatchin()).func_77655_b("ItemChipTier3"), "ItemChipTier3", (String)null);
      ItemDinoMeat = GameRegistry.registerItem((new ItemDinoMeat(2, 0.0F, 1.0F)).func_77655_b("ItemDinoMeat"), "ItemDinoMeat", (String)null);
      ItemDinoMeatCooked = GameRegistry.registerItem((new ItemDinoMeat(5, 0.0F, 1.6F)).func_77655_b("ItemDinoMeatCooked"), "ItemDinoMeatCooked", (String)null);
      ItemDinoMeatBig = GameRegistry.registerItem((new ItemDinoMeat(3, 0.0F, 1.5F)).func_77655_b("ItemDinoMeatBig"), "ItemDinoMeatBig", (String)null);
      ItemDinoMeatCookedBig = GameRegistry.registerItem((new ItemDinoMeat(8, 0.0F, 2.4F)).func_77655_b("ItemDinoMeatCookedBig"), "ItemDinoMeatCookedBig", (String)null);
      ItemWeightShell = GameRegistry.registerItem((new ItemWeight(5)).func_77655_b("ItemWeightShell"), "ItemWeightShell", (String)null);
      ItemWeightShirt = GameRegistry.registerItem((new ItemWeight(5)).func_77655_b("ItemWeightShirt"), "ItemWeightShirt", (String)null);
      ItemWeightHandLeg = GameRegistry.registerItem((new ItemWeight(5)).func_77655_b("ItemWeightHandLeg"), "ItemWeightHandLeg", (String)null);
      ItemWeightCape = GameRegistry.registerItem((new ItemWeight(5)).func_77655_b("ItemWeightCape"), "ItemWeightCape", (String)null);
      ItemWeightHeavySuit = GameRegistry.registerItem((new ItemWeight(5)).func_77655_b("ItemWeightHeavySuit"), "ItemWeightHeavySuit", (String)null);
      ItemDragonRadar = GameRegistry.registerItem((new ItemDragonRadar()).func_77655_b("ItemDragonRadar"), "ItemDragonRadar", (String)null);
      ItemDragonBlock = GameRegistry.registerItem((new DragonBlock01Item(BlocksDBC.BlockDragonBall)).func_77655_b("ItemDragonBlock"), "ItemDragonBlock", (String)null);
      ItemNamekDragonBlock = GameRegistry.registerItem((new DragonBlock01Item(BlocksDBC.BlockNamekDragonBall)).func_77655_b("ItemNamekDragonBlock"), "ItemNamekDragonBlock", (String)null);
      BattleArmors.add(BattleArmorHelmet00 = GameRegistry.registerItem((new ItemHeadDBC("tier0", "1")).func_77655_b("YellowScouter"), "YellowScouter", (String)null));
      BattleArmors.add(BattleArmorHelmet01 = GameRegistry.registerItem((new ItemHeadDBC("tier1", "1")).func_77655_b("RedScouter"), "RedScouter", (String)null));
      BattleArmors.add(BattleArmorHelmet02 = GameRegistry.registerItem((new ItemHeadDBC("tier2", "1")).func_77655_b("PurpleScouter"), "PurpleScouter", (String)null));
      BattleArmors.add(BattleArmorHelmet03 = GameRegistry.registerItem((new ItemHeadDBC("tier3", "1")).func_77655_b("BlueScouter"), "BlueScouter", (String)null));
      BattleArmors.add(BattleArmorHelmet04 = GameRegistry.registerItem((new ItemHeadDBC("tier4", "1")).func_77655_b("GreenScouter"), "GreenScouter", (String)null));
      BattleArmors.add(BattleArmorHelmet05 = GameRegistry.registerItem((new ItemHeadDBC("tier5", "1")).func_77655_b("PinkScouter"), "PinkScouter", (String)null));
      BattleArmors.add(BattleArmorChest00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier0")).func_77655_b("BattleArmorChest00"), "BattleArmorChest00", (String)null));
      BattleArmors.add(BattleArmorLegs00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier0")).func_77655_b("BattleArmorLegs00"), "BattleArmorLegs00", (String)null));
      BattleArmors.add(BattleArmorBoots00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier0")).func_77655_b("BattleArmorBoots00"), "BattleArmorBoots00", (String)null));
      BattleArmors.add(BattleArmorChest01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier1")).func_77655_b("BattleArmorChest01"), "BattleArmorChest01", (String)null));
      BattleArmors.add(BattleArmorLegs01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier1")).func_77655_b("BattleArmorLegs01"), "BattleArmorLegs01", (String)null));
      BattleArmors.add(BattleArmorBoots01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier1")).func_77655_b("BattleArmorBoots01"), "BattleArmorBoots01", (String)null));
      BattleArmors.add(BattleArmorChest02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier2")).func_77655_b("BattleArmorChest02"), "BattleArmorChest02", (String)null));
      BattleArmors.add(BattleArmorLegs02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier2")).func_77655_b("BattleArmorLegs02"), "BattleArmorLegs02", (String)null));
      BattleArmors.add(BattleArmorBoots02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier2")).func_77655_b("BattleArmorBoots02"), "BattleArmorBoots02", (String)null));
      BattleArmors.add(BattleArmorChest03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 1, "tier3")).func_77655_b("BattleArmorChest03"), "BattleArmorChest03", (String)null));
      BattleArmors.add(BattleArmorLegs03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 2, "tier3")).func_77655_b("BattleArmorLegs03"), "BattleArmorLegs03", (String)null));
      BattleArmors.add(BattleArmorBoots03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 3, "tier3")).func_77655_b("BattleArmorBoots03"), "BattleArmorBoots03", (String)null));
      BattleArmors.add(BattleArmorChest04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier4")).func_77655_b("BattleArmorChest04"), "BattleArmorChest04", (String)null));
      BattleArmors.add(BattleArmorLegs04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 2, "tier4")).func_77655_b("BattleArmorLegs04"), "BattleArmorLegs04", (String)null));
      BattleArmors.add(BattleArmorBoots04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier4")).func_77655_b("BattleArmorBoots04"), "BattleArmorBoots04", (String)null));
      BattleArmors.add(BattleArmorChest05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier5")).func_77655_b("BattleArmorChest05"), "BattleArmorChest05", (String)null));
      BattleArmors.add(BattleArmorLegs05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 2, "tier5")).func_77655_b("BattleArmorLegs05"), "BattleArmorLegs05", (String)null));
      BattleArmors.add(BattleArmorBoots05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier5")).func_77655_b("BattleArmorBoots05"), "BattleArmorBoots05", (String)null));
      BattleArmors.add(BattleArmorChest06 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 1, "tier6")).func_77655_b("BattleArmorChest06"), "BattleArmorChest06", (String)null));
      BattleArmors.add(BattleArmorLegs06 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 2, "tier6")).func_77655_b("BattleArmorLegs06"), "BattleArmorLegs06", (String)null));
      BattleArmors.add(BattleArmorBoots06 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier6")).func_77655_b("BattleArmorBoots06"), "BattleArmorBoots06", (String)null));
      BattleArmors.add(BattleArmorChest07 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier7")).func_77655_b("BattleArmorChest07"), "BattleArmorChest07", (String)null));
      BattleArmors.add(BattleArmorBoots07 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier7")).func_77655_b("BattleArmorBoots07"), "BattleArmorBoots07", (String)null));
      BattleArmors.add(BattleArmorChest08 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier8")).func_77655_b("BattleArmorChest08"), "BattleArmorChest08", (String)null));
      BattleArmors.add(BattleArmorBoots08 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier8")).func_77655_b("BattleArmorBoots08"), "BattleArmorBoots08", (String)null));
      BattleArmors.add(BattleArmorChest09 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 1, "tier9")).func_77655_b("BattleArmorChest09"), "BattleArmorChest09", (String)null));
      BattleArmors.add(BattleArmorLegs09 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 2, "tier9")).func_77655_b("BattleArmorLegs09"), "BattleArmorLegs09", (String)null));
      BattleArmors.add(BattleArmorBoots09 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier9")).func_77655_b("BattleArmorBoots09"), "BattleArmorBoots09", (String)null));
      ItemGi.add(Coat = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, 5, "gi_color_" + (ItemGi.size() - 1))).func_77655_b("gi_color_" + (ItemGi.size() - 1) + "Chest"), "gi_color_" + (ItemGi.size() - 1) + "Chest", (String)null));
      ItemGi.add(Coat_2 = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, 5, "gi_color_" + (ItemGi.size() - 1))).func_77655_b("gi_color_" + (ItemGi.size() - 1) + "Chest"), "gi_color_" + (ItemGi.size() - 1) + "Chest", (String)null));

      for(i = 0; i < 2; ++i) {
         s = ItemsGiType2[i].split(",");
         j = 0;

         while(j < s.length) {
            iddd = ItemsGiType.length + 3 + i;
            id = Integer.parseInt(s[j]);
            switch(id) {
            case 1:
               ItemGi.add(ItemsGi1_2[i] = GameRegistry.registerItem((new VanityColor(JRMCoreH2.cols[15], GI2, id, "gi_color_" + iddd)).func_77655_b("gi_color_" + iddd + "Chest"), "gi_color_" + iddd + "Chest", (String)null));
            default:
               ++j;
            }
         }
      }

      OutfitGis.add(GiFighter1Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter1")).func_77655_b("GiFighterTorso1"), "GiFighterTorso1", (String)null));
      OutfitGis.add(GiFighter1Leg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "zfighter1")).func_77655_b("GiFighterLeg1"), "GiFighterLeg1", (String)null));
      OutfitGis.add(GiFighter1Boots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "zfighter1")).func_77655_b("GiFighterBoots1"), "GiFighterBoots1", (String)null));
      OutfitGis.add(GiNamekTorso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "namek")).func_77655_b("GiNamekTorso0").func_77637_a(mod_DragonBC.DragonBlockC), "GiNamekTorso0", (String)null));
      OutfitGis.add(GiNamekLeg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "namek")).func_77655_b("GiNamekLeg0").func_77637_a(mod_DragonBC.DragonBlockC), "GiNamekLeg0", (String)null));
      OutfitGis.add(GiNamekBoots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "namek")).func_77655_b("GiNamekBoots0").func_77637_a(mod_DragonBC.DragonBlockC), "GiNamekBoots0", (String)null));
      OutfitGis.add(GiFutureTorso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "future")).func_77655_b("GiFutureTorso0"), "GiFutureTorso0", (String)null));
      OutfitGis.add(GiFutureLeg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "future")).func_77655_b("GiFutureLeg0"), "GiFutureLeg0", (String)null));
      OutfitGis.add(GiFutureBoots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "future")).func_77655_b("GiFutureBoots0"), "GiFutureBoots0", (String)null));
      OutfitGis.add(GiFighter2Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter2")).func_77655_b("GiFighterTorso2").func_77637_a(mod_DragonBC.DragonBlockC), "GiFighterTorso2", (String)null));
      OutfitGis.add(GiFighter2Leg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "zfighter2")).func_77655_b("GiFighterLeg2").func_77637_a(mod_DragonBC.DragonBlockC), "GiFighterLeg2", (String)null));
      OutfitGis.add(GiFighter2Boots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "zfighter2")).func_77655_b("GiFighterBoots2").func_77637_a(mod_DragonBC.DragonBlockC), "GiFighterBoots2", (String)null));
      OutfitGis.add(JinTorso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "jin")).func_77655_b("JinTorso").func_77637_a(mod_DragonBC.DragonBlockC), "JinTorso", (String)null));
      OutfitGis.add(JinLeg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "jin")).func_77655_b("JinLeg").func_77637_a(mod_DragonBC.DragonBlockC), "JinLeg", (String)null));
      OutfitGis.add(JinBoots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "jin")).func_77655_b("JinBoots").func_77637_a(mod_DragonBC.DragonBlockC), "JinBoots", (String)null));
      OutfitGis.add(KameTorso1 = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "kame")).func_77655_b("KameTorso1").func_77637_a(mod_DragonBC.DragonBlockC), "KameTorso1", (String)null));
      OutfitGis.add(KameBoots1 = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "kame")).func_77655_b("KameBoots1").func_77637_a(mod_DragonBC.DragonBlockC), "KameBoots1", (String)null));
      OutfitGis.add(GiFighter3Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter3")).func_77655_b("GiFighterTorso3").func_77637_a(mod_DragonBC.DragonBlockC), "GiFighterTorso3", (String)null));
      BattleArmors.add(BattleArmorHelmet00a = GameRegistry.registerItem((new ItemHeadDBC("tier0", "2")).func_77655_b("YellowScoutera"), "YellowScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet01a = GameRegistry.registerItem((new ItemHeadDBC("tier1", "2")).func_77655_b("RedScoutera"), "RedScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet02a = GameRegistry.registerItem((new ItemHeadDBC("tier2", "2")).func_77655_b("PurpleScoutera"), "PurpleScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet03a = GameRegistry.registerItem((new ItemHeadDBC("tier3", "2")).func_77655_b("BlueScoutera"), "BlueScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet04a = GameRegistry.registerItem((new ItemHeadDBC("tier4", "2")).func_77655_b("GreenScoutera"), "GreenScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet05a = GameRegistry.registerItem((new ItemHeadDBC("tier5", "2")).func_77655_b("PinkScoutera"), "PinkScoutera", (String)null));
      BattleArmors.add(BattleArmorHelmet00b = GameRegistry.registerItem((new ItemHeadDBC("tier0", "3")).func_77655_b("YellowScouterb"), "YellowScouterb", (String)null));
      BattleArmors.add(BattleArmorHelmet01b = GameRegistry.registerItem((new ItemHeadDBC("tier1", "3")).func_77655_b("RedScouterb"), "RedScouterb", (String)null));
      BattleArmors.add(BattleArmorHelmet02b = GameRegistry.registerItem((new ItemHeadDBC("tier2", "3")).func_77655_b("PurpleScouterb"), "PurpleScouterb", (String)null));
      BattleArmors.add(BattleArmorHelmet03b = GameRegistry.registerItem((new ItemHeadDBC("tier3", "3")).func_77655_b("BlueScouterb"), "BlueScouterb", (String)null));
      BattleArmors.add(BattleArmorHelmet04b = GameRegistry.registerItem((new ItemHeadDBC("tier4", "3")).func_77655_b("GreenScouterb"), "GreenScouterb", (String)null));
      BattleArmors.add(BattleArmorHelmet05b = GameRegistry.registerItem((new ItemHeadDBC("tier5", "3")).func_77655_b("PinkScouterb"), "PinkScouterb", (String)null));

      for(i = 0; i < ItemsVanityNum.length; ++i) {
         ItemsVanity[i] = GameRegistry.registerItem((new VanityColor(16777215, GI2, ItemsVanityNum[i], "vanity_d_" + i, ItemVanity3[i])).func_77655_b("vanity_d_" + i), "vanity_d_" + i, (String)null);
      }

      ModdedItems.init();
   }

   @SideOnly(Side.CLIENT)
   public static void client() {
      MinecraftForgeClient.registerItemRenderer(ItemKatana, new ItemDBCRender("K"));
      MinecraftForgeClient.registerItemRenderer(ItemBraveSword, new ItemDBCRender("S"));
      MinecraftForgeClient.registerItemRenderer(ItemZSword, new ItemDBCRender("Z"));
      MinecraftForgeClient.registerItemRenderer(ItemPP, new ItemWeaponRender2());
      MinecraftForgeClient.registerItemRenderer(ItemDragonRadar, new ItemDBCRenderRad());
      MinecraftForgeClient.registerItemRenderer(ItemDimensionSword, new ItemDBCRender1());
      MinecraftForgeClient.registerItemRenderer(ItemEvilSpear, new ItemDBCRender2());
      MinecraftForgeClient.registerItemRenderer(ItemDragonBlock, new DragonBlock01ItemR(1.0F));
      MinecraftForgeClient.registerItemRenderer(ItemNamekDragonBlock, new DragonBlock01ItemR(2.0F));
   }

   static {
      ItemsOutfit0 = new Item[ItemsOutfitnams.length];
      ItemsOutfit1 = new Item[ItemsOutfitnams.length];
      ItemsOutfit2 = new Item[ItemsOutfitnams.length];
      ItemsOutfit3 = new Item[ItemsOutfitnams.length];
      ItemsGi0 = new Item[12];
      ItemsGi1 = new Item[12];
      ItemsGi2 = new Item[12];
      ItemsGi3 = new Item[12];
      ItemsGi1_2 = new Item[2];
      ItemsBodynams = new String[]{""};
      ItemsBody = new Item[ItemsBodynams.length];
      ItemsHeadnams = new String[]{""};
      ItemsHead = new Item[ItemsHeadnams.length];
      ItemBodysuits = new ItemBodyDBC[8];
      ItemGiType = new int[]{1, 1, 1};
      ItemGiBody = new VanityColor[3];
      ItemGi = new ArrayList();
      ItemsRecnams = new String[]{"DBC1", "DBC2", "DBC3", "DBC4", "DBC5"};
      ItemsRec = new Item[ItemsRecnams.length];
      ItemOWnams = new String[]{"LehnoriIngot", "DlogIngot", "DnomaidIngot", "JJay", "DlogSword", "DnomaidSword", "LehnoriSword", "DlogPick", "DnomaidPick", "LehnoriPick", "DlogAxe", "DnomaidAxe", "LehnoriAxe", "LehnoriHelmet", "LehnoriChest", "LehnoriPants", "LehnoriBoots", "DlogHelmet", "DlogChest", "DlogPants", "DlogBoots", "DnomaidHelmet", "DnomaidChest", "DnomaidPants", "DnomaidBoots"};
      ItemOWtypes = new Item[]{new ItemAnyBase(), new ItemAnyBase(), new ItemAnyBase(), new ItemAnyBase(), new ItemSwordBase(ToolMaterial.WOOD), new ItemSwordBase(ToolMaterial.EMERALD), new ItemSwordBase(ToolMaterial.IRON), new ItemToolPickaxe(ToolMaterial.WOOD), new ItemToolPickaxe(ToolMaterial.EMERALD), new ItemToolPickaxe(ToolMaterial.IRON), new ItemToolAxe(ToolMaterial.WOOD), new ItemToolAxe(ToolMaterial.EMERALD), new ItemToolAxe(ToolMaterial.IRON), new ItemArmorNormal(ArmorMaterial.IRON, 0, 0, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 1, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 2, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 3, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 0, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 1, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 2, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 3, "dloglayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 0, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 1, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 2, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 3, "dnomaidlayer")};
      ItemsOW = new Item[ItemOWnams.length];
      ItemsVanityNum = new int[]{1, 1, 1, 2, 3, 0, 0, 0};
      ItemVanity3 = new int[]{0, -1, -1, -1, 1, 2, 3, 4};
      ItemsVanity = new Item[ItemsVanityNum.length];
   }
}
