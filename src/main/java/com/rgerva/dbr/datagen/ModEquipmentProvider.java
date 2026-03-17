/**
 * Generic Class: ModEquipmentProvider <T>
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
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentProvider extends EquipmentAssetProvider {
    protected final PackOutput.PathProvider pathProvider;

    public ModEquipmentProvider(PackOutput output) {
        super(output);
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    public static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {

    }

    public static EquipmentClientInfo humanoidAndHorse(String name) {
        return EquipmentClientInfo.builder()
                .addHumanoidLayers(Identifier.fromNamespaceAndPath(Dragon_Block_Reborn.MOD_ID, name))
                .addLayers(
                        EquipmentClientInfo.LayerType.HORSE_BODY,
                        new EquipmentClientInfo.Layer[]{
                                EquipmentClientInfo.Layer.leatherDyeable(
                                        Identifier.fromNamespaceAndPath(Dragon_Block_Reborn.MOD_ID, name), false)
                        })
                .build();
    }

    public static @NonNull EquipmentClientInfo onlyHumanoid(String name) {
        return EquipmentClientInfo.builder()
                .addHumanoidLayers(Identifier.fromNamespaceAndPath(Dragon_Block_Reborn.MOD_ID, name))
                .build();
    }

    @Override
    public @NonNull CompletableFuture<?> run(@NonNull CachedOutput output) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> map = new HashMap<>();
        bootstrap((key, model) -> {
            if (map.putIfAbsent(key, model) != null) {
                throw new IllegalStateException("Duplicate equipment asset for id: " + key.toString());
            }
        });

        return DataProvider.saveAll(output, EquipmentClientInfo.CODEC, this.pathProvider::json, map);
    }
}
