/**
 * Generic class {@code DragonBlockReborn<T>} – A generic structure that works with type parameters.
 *
 * <p>Created by: RGerva, July 2025.<br>
 * GitHub: <a href="https://github.com/RGerva">https://github.com/RGerva</a>
 *
 * <p>Copyright © 2025 RGerva. All rights reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");<br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at:
 *
 * <p><a href="http://www.apache.org/licenses/LICENSE-2.0">
 * http://www.apache.org/licenses/LICENSE-2.0 </a>
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS,<br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>
 * See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.rgerva.dbr;

import com.mojang.logging.LogUtils;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.capabilities.ModCapabilities;
import com.rgerva.dbr.component.ModDataComponents;
import com.rgerva.dbr.config.ModConfig;
import com.rgerva.dbr.creative.ModCreativeTab;
import com.rgerva.dbr.effect.ModEffects;
import com.rgerva.dbr.enchantment.ModEnchantmentEffects;
import com.rgerva.dbr.entity.ModEntities;
import com.rgerva.dbr.fluid.ModFluids;
import com.rgerva.dbr.gui.ModGUI;
import com.rgerva.dbr.item.ModItems;
import com.rgerva.dbr.loot.ModLootModifiers;
import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.particles.ModParticles;
import com.rgerva.dbr.potion.ModPotions;
import com.rgerva.dbr.recipe.ModRecipes;
import com.rgerva.dbr.sound.ModSounds;
import com.rgerva.dbr.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DragonBlockReborn.MOD_ID)
public class DragonBlockReborn {
  public static final String MOD_ID = "dragon_block_reborn";
  public static final Logger LOGGER = LogUtils.getLogger();

  public DragonBlockReborn(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);
    NeoForge.EVENT_BUS.register(this);

    ModCreativeTab.register(modEventBus);

    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);

    ModDataComponents.register(modEventBus);
    ModSounds.register(modEventBus);

    ModEffects.register(modEventBus);
    ModPotions.register(modEventBus);

    ModEnchantmentEffects.register(modEventBus);
    ModEntities.register(modEventBus);

    ModVillagers.register(modEventBus);
    ModParticles.register(modEventBus);

    ModLootModifiers.register(modEventBus);
    ModBlockEntities.register(modEventBus);

    ModGUI.register(modEventBus);
    ModRecipes.register(modEventBus);

    ModFluids.register(modEventBus);

    modEventBus.addListener(ModCreativeTab::addCreative);
    modEventBus.addListener(ModCapabilities::registerCapabilities);
    modEventBus.addListener(ModNetwork::register);

    modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.COMMON, ModConfig.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    LOGGER.info("HELLO FROM COMMON SETUP");
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("HELLO from server starting");
  }
}
