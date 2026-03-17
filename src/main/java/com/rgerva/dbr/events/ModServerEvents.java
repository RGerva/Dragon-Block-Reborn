/**
 * Generic Class: ModServerEvents <T>
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
import com.rgerva.dbr.command.ModCommands;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = Dragon_Block_Reborn.MOD_ID, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        ConfigCommand.register(event.getDispatcher());
        ModCommands.configCommand(event.getDispatcher());
    }
}
