/**
 * Generic Class: ModConfig <T>
 * A generic structure that works with type parameters.
 *
 * <p>Created by: RGerva
 * <p>On: 2026/mar
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2026 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the GNU General Public License, Version 3.0.
 */

package com.rgerva.dbr.config;

import com.rgerva.dbr.Dragon_Block_Reborn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = Dragon_Block_Reborn.MOD_ID)
public class ModConfig {

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
