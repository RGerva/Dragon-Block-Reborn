/**
 * Generic Class: ModContainerRecipeInputWrapper <T>
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

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class ModContainerRecipeInputWrapper implements RecipeInput {
    private final Container inventory;

    public ModContainerRecipeInputWrapper(Container inventory) {
        this.inventory = inventory;
    }

    @Override
    public ItemStack getItem(int slot) {
        return inventory.getItem(slot);
    }

    @Override
    public int size() {
        return inventory.getContainerSize();
    }
}
