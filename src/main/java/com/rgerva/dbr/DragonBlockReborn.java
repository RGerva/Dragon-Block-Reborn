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
import com.rgerva.dbr.network.ModMessages;
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
        modEventBus.addListener(ModMessages::register);

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
