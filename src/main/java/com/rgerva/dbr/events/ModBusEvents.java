/**
 * Generic Class: ModBusEvents <T>
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

package com.rgerva.dbr.events;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID, value = Dist.CLIENT)
public class ModBusEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        DragonBlockReborn.LOGGER.info("HELLO FROM CLIENT SETUP");
        DragonBlockReborn.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
