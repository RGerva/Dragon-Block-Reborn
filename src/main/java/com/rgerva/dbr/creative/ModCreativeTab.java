/**
 * Generic Class: ModCreativeTab <T>
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

package com.rgerva.dbr.creative;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DragonBlockReborn.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATIVE_TAB =
            CREATIVE_MODE_TAB.register("tab_dragon_block_reborn",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(Items.ACACIA_PLANKS))
                            .title(Component.translatable("tab_dragon_block_reborn"))
                            .displayItems(((itemDisplayParameters, output) -> {

                            }))
                            .build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {}

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
