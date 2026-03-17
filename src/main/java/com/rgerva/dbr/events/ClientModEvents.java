/**
 * Generic Class: ClientModEvents <T>
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

package com.rgerva.dbr.events;

import com.rgerva.dbr.Dragon_Block_Reborn;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Dragon_Block_Reborn.MOD_ID, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Dragon_Block_Reborn.LOGGER.info("HELLO FROM CLIENT SETUP");
        Dragon_Block_Reborn.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
