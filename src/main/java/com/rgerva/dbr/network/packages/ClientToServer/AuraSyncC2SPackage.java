/**
 * Record: AuraSyncC2SPackage
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

package com.rgerva.dbr.network.packages.ClientToServer;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.entity.EntityAura;
import com.rgerva.dbr.entity.entity.AuraEntity;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AuraSyncC2SPackage(boolean activate) implements CustomPacketPayload {

		public static final Type<AuraSyncC2SPackage> ID =
						new Type<>(
										ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "client_aura"));

		public static final StreamCodec<RegistryFriendlyByteBuf, AuraSyncC2SPackage> STREAM_CODEC =
						StreamCodec.ofMember(AuraSyncC2SPackage::write, AuraSyncC2SPackage::new);

		public AuraSyncC2SPackage(RegistryFriendlyByteBuf buf){
				this(buf.readBoolean());
		}

		public void write(RegistryFriendlyByteBuf buf) {
				buf.writeBoolean(activate);
		}

		@Override
		public Type<? extends CustomPacketPayload> type() {
				return ID;
		}

		public static void handle(AuraSyncC2SPackage data, IPayloadContext context){
				context.enqueueWork(
								() -> {
										if (!(context.player().level() instanceof ServerLevel level)
														|| !(context.player() instanceof ServerPlayer player)) return;


										if (data.activate) {
//												AuraEntity.spawnAura(level, player);
												EntityAura.summonAura(level, player);
										}else{
//												List<AuraEntity> nearbyAuras = level.getEntitiesOfClass(AuraEntity.class,
//																player.getBoundingBox().inflate(4.0),
//																aura -> aura.isOwnedBy(player));
//
//												for (AuraEntity aura : nearbyAuras) {
//														aura.setActive(false);
//												}

												List<EntityAura> nearbyAuras = level.getEntitiesOfClass(EntityAura.class,
																player.getBoundingBox().inflate(4.0),
																aura -> aura.isOwnedBy(player));

//												for (EntityAura aura : nearbyAuras) {
//														aura.setActive(false);
//												}
										}
								}
				);
		}
}
