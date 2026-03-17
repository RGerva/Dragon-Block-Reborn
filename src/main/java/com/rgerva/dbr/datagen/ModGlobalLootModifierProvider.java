/**
 * Generic Class: ModGlobalLootModifierProvider <T>
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

package com.rgerva.dbr.datagen;

import com.rgerva.dbr.Dragon_Block_Reborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Dragon_Block_Reborn.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
