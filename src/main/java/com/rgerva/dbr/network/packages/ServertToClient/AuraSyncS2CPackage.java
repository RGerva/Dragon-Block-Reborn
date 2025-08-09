/**
 * Record: AuraSyncS2CPackage
 * Immutable data structure for simplified object representation.
 * <p>
 * Created by: rgerv
 * On: 2025/ago.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.network.packages.ServertToClient;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.entity.AuraEntity;
import com.rgerva.dbr.entity.ModEntities;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AuraSyncS2CPackage() implements CustomPacketPayload {

		public static final Type<AuraSyncS2CPackage> ID =
						new Type<>(
										ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "sync_aura"));

		public static final StreamCodec<RegistryFriendlyByteBuf, AuraSyncS2CPackage> STREAM_CODEC =
						StreamCodec.ofMember(AuraSyncS2CPackage::write, AuraSyncS2CPackage::read);

		public static AuraSyncS2CPackage read(RegistryFriendlyByteBuf buf){
				return new AuraSyncS2CPackage();
		}

		public void write(RegistryFriendlyByteBuf buf) {}

		@Override
		public Type<? extends CustomPacketPayload> type() {
				return null;
		}

		public static void handle(AuraSyncS2CPackage data, IPayloadContext context){
				context.enqueueWork(
								() -> {
										if (!(context.player().level() instanceof ServerLevel level)
														|| !(context.player() instanceof ServerPlayer player)) return;

										AuraEntity aura = ModEntities.AURA_ENTITY.get().create(level, EntitySpawnReason.EVENT);
										if(aura != null){
												Vec3 pos = player.position();
												aura.setPos(pos.x, pos.y, pos.z);
												player.level().getLevel().addFreshEntity(aura);
										}
								}
				);
		}
}
