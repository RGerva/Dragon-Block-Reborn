/**
 * Generic Class: ModRecipes <T>
 * A generic structure that works with type parameters.
 *
 * <p>Created by: bb785
 * <p>On: 2026/mar.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2026 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the GNU General Public License, Version 3.0.
 */

package com.rgerva.dbr.recipe;

import com.rgerva.dbr.Dragon_Block_Reborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModRecipes {
    public static final DeferredRegister<RecipeBookCategory> CATEGORIES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_BOOK_CATEGORY, Dragon_Block_Reborn.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Dragon_Block_Reborn.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Dragon_Block_Reborn.MOD_ID);

    public static void register(IEventBus eventBus) {
        CATEGORIES.register(eventBus);
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }

    public interface ModBasicRecipe<T extends RecipeInput> extends Recipe<T> {
        List<Ingredient> getIngredients();

        boolean isIngredient(ItemStack itemStack);

        boolean isResult(ItemStack itemStack);
    }
}
