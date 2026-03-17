/**
 * Generic Class: ModItems <T>
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

package com.rgerva.dbr.item;

import com.rgerva.dbr.Dragon_Block_Reborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Dragon_Block_Reborn.MOD_ID);

    public static final DeferredItem<Item> GETE_SCRAP = ITEMS.registerItem("gete_scrap", Item::new);
    public static final DeferredItem<Item> GETE_INGOT = ITEMS.registerItem("gete_ingot", Item::new);
    public static final DeferredItem<Item> KIKONO_SHARD = ITEMS.registerItem("kikono_shard", Item::new);
    public static final DeferredItem<Item> KIKONO_STICK = ITEMS.registerItem("kikono_stick", Item::new);

    protected static ResourceKey<Item> id(@NotNull String path) {
        return ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(Dragon_Block_Reborn.MOD_ID, path));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
