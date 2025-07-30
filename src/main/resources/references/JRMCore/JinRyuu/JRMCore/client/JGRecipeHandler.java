package JinRyuu.JRMCore.client;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.items.ItemsJRMC;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class JGRecipeHandler {
   public static final String[] recipelistmods = new String[]{"JRMCore", "Dragon Block C", "Naruto C", "Years C"};
   public static HashMap<String, ItemStack> recipelist = new HashMap();
   public static final String[] recipelistcategories = new String[]{"Blocks", "Items", "Armors", "Weapons", "Tools", "Vanities"};
   public static int[][] recipelistitems;

   public static void registerRecipes() {
      for(int i = 0; i < recipelistmods.length; ++i) {
         for(int j = 0; j < recipelistcategories.length; ++j) {
            recipelistitems[i][j] = 0;
         }
      }

      String mod = "JRMCore";
      String category = "Tools";
      addRecipe(mod, category, ItemsJRMC.ItemBarberSnC);
      category = "Items";
      addRecipe(mod, category, ItemsJRMC.Custom_fabric);
      category = "Vanities";
      addRecipe(mod, category, ItemsJRMC.Costume_creeper);
      addRecipe(mod, category, ItemsJRMC.Costume_ender);

      for(int i = 0; i < ItemsJRMC.ItemVanity3.length; ++i) {
         addRecipe(mod, category, ItemsJRMC.ItemsVanity[i]);
      }

      if (JRMCoreH.DBC()) {
         JGRecipesDBC.registerRecipes(mod, category);
      }

      if (JRMCoreH.NC()) {
         JGRecipesNC.registerRecipes(mod, category);
      }

      if (JRMCoreH.JYC()) {
         JGRecipesYC.registerRecipes(mod, category);
      }

   }

   public static void addRecipe(String mod, String category, ItemStack stack) {
      int id = 0;

      for(int i = 0; i < recipelistmods.length; ++i) {
         for(int j = 0; j < recipelistcategories.length; ++j) {
            if (recipelistmods[i].equals(mod) && recipelistcategories[j].equals(category)) {
               id = recipelistitems[i][j];
               int var10002 = recipelistitems[i][j]++;
               break;
            }
         }
      }

      recipelist.put(mod + "." + category + id, stack);
   }

   public static void addRecipe(String mod, String category, Item stack) {
      addRecipe(mod, category, new ItemStack(stack));
   }

   public static void addRecipe(String mod, String category, Block stack) {
      addRecipe(mod, category, new ItemStack(stack));
   }

   public static int getRecipeCount(int mod, int category) {
      return recipelistitems[mod][category];
   }

   public static boolean hasRecipes(int mod, int category) {
      return recipelistitems[mod][category] > 0;
   }

   public static int getFirstRecipeCategory(int mod) {
      for(int i = 0; i < recipelistcategories.length; ++i) {
         if (hasRecipes(mod, i)) {
            return i;
         }
      }

      return -1;
   }

   public static IRecipe getRecipe(Item item) {
      List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
      Iterator var2 = recipes.iterator();

      while(var2.hasNext()) {
         Object obj = var2.next();
         ItemStack output;
         if (obj instanceof ShapedRecipes) {
            ShapedRecipes recipe = (ShapedRecipes)obj;
            output = recipe.func_77571_b();
            if (output.func_77973_b().equals(item)) {
               return recipe;
            }
         } else if (obj instanceof ShapelessRecipes) {
            ShapelessRecipes recipe = (ShapelessRecipes)obj;
            output = recipe.func_77571_b();
            if (output.func_77973_b().equals(item)) {
               return recipe;
            }
         }
      }

      return null;
   }

   public static ItemStack colorFix(ItemStack recept, ItemStack receptName) {
      ItemStack item = recept;
      if (recept != null && (recept.func_77973_b().func_77658_a().equals("tile.cloth") || recept.func_77973_b().func_77658_a().equals("item.dyePowder"))) {
         if (receptName.func_77973_b().getDamage(receptName) == 32767) {
            if (recept.func_77973_b().func_77658_a().equals("tile.cloth")) {
               item = new ItemStack(Blocks.field_150325_L);
            } else {
               item = new ItemStack(Items.field_151100_aR);
            }

            item.func_77973_b().setDamage(item, 15);
         } else if (recept.func_77973_b().func_77658_a().equals("tile.cloth")) {
            item = new ItemStack(Blocks.field_150325_L, 1, receptName.func_77973_b().getDamage(receptName));
         } else {
            item = new ItemStack(Items.field_151100_aR, 1, receptName.func_77973_b().getDamage(receptName));
         }
      }

      return item;
   }

   public static ShapedRecipes getShapedRecipe(Object obj, Item item) {
      ShapedRecipes recipe = (ShapedRecipes)obj;
      ItemStack output = recipe.func_77571_b();
      return output.func_77973_b().equals(item) ? recipe : null;
   }

   public static ShapelessRecipes getShapelessRecipe(Object obj, Item item) {
      ShapelessRecipes recipe = (ShapelessRecipes)obj;
      ItemStack output = recipe.func_77571_b();
      return output.func_77973_b().equals(item) ? recipe : null;
   }

   static {
      recipelistitems = new int[recipelistmods.length][recipelistcategories.length];
   }
}
