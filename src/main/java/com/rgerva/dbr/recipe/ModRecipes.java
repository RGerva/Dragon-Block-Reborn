/**
 * Generic Class: ModRecipes <T>
 * A generic structure that works with type parameters.
 * <p>
 * Created by: rgerv
 * On: 2025/jul.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.recipe;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class ModRecipes {
    public interface ModBasicRecipe<T extends RecipeInput> extends Recipe<T> {
        List<Ingredient> getIngredients();

        boolean isIngredient(ItemStack itemStack);

        boolean isResult(ItemStack itemStack);
    }

    // ===== Registers =====
    public static final DeferredRegister<RecipeBookCategory> CATEGORIES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_BOOK_CATEGORY, DragonBlockReborn.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, DragonBlockReborn.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, DragonBlockReborn.MOD_ID);



    public static void register(IEventBus eventBus) {
        CATEGORIES.register(eventBus);
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
