package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Items.m.ModdedItems;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DBCHandlerFuel implements IFuelHandler {
   public int getBurnTime(ItemStack fuel) {
      if (fuel.func_77973_b() == ModdedItems.SakuraStick) {
         return 150;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyStick) {
         return 150;
      } else if (fuel.func_77973_b() == ModdedItems.MapleStick) {
         return 150;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraBranch) {
         return 200;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyBranch) {
         return 200;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraHammer) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraSword) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraAxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraPickaxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraHoe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.SakuraShovel) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonySword) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyAxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyPickaxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyHoe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MahagonyShovel) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MapleSword) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MapleAxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MaplePickaxe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MapleHoe) {
         return 250;
      } else if (fuel.func_77973_b() == ModdedItems.MapleShovel) {
         return 250;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.PaperWallSakura)) {
         return 150;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.PaperWallMahagony)) {
         return 150;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraLogs)) {
         return 400;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraPlank)) {
         return 400;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraSaplings)) {
         return 150;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraStairs)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MahagonyStairs)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MapleStairs)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraFence)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MahagonyFence)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MapleFence)) {
         return 200;
      } else if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraSlabsSingle)) {
         return 200;
      } else {
         Item item = fuel.func_77973_b();
         if (item == ItemsDBC.ItemsOW[3]) {
            return 1500;
         } else {
            return item == Item.func_150898_a(BlocksDBC.BlockOW[0]) ? 15000 : 0;
         }
      }
   }
}
