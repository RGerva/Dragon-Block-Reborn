/**
 * Generic Class: AuraEntity <T>
 * A generic structure that works with type parameters.
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

package com.rgerva.dbr.entity.entity;

import com.rgerva.dbr.entity.ModEntities;
import com.rgerva.dbr.entity.renderer.AuraEntityRenderState;
import com.rgerva.dbr.network.interfaces.IModAuraSync;
import java.util.UUID;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class AuraEntity extends Entity implements IModAuraSync {
		private final AuraEntityRenderState renderState = new AuraEntityRenderState();
		public final AnimationState idleAnimationState = new AnimationState();

		private boolean active = true;
		private UUID ownerUUID;

		private static final EntityDataAccessor<Integer> VARIANT =
						SynchedEntityData.defineId(AuraEntity.class, EntityDataSerializers.INT);

		public AuraEntity(EntityType<?> entityType, Level level) {
				super(entityType, level);
		}

		private void setupAnimationStates() {
				if (level().isClientSide) {
						// IDLE sempre roda se estiver ativa
						if (activateAura()) {
								if (!this.idleAnimationState.isStarted()) {
										this.idleAnimationState.start(this.tickCount);
								}
						} else {
								this.idleAnimationState.stop();
						}

						// ATIVAÇÃO só toca no 1º tick de ativação
						if (activateAura() && tickCount == 1) {
								this.renderState.activateAnimationState.start(this.tickCount);
						}

						// DESATIVAÇÃO quando flag vai pra falso
						if (!activateAura() && tickCount == 1) {
								this.renderState.deactivateAnimationState.start(this.tickCount);
						}
				}
		}

		@Override
		public void tick() {
				super.tick();

				if (!level().isClientSide) {
						if (!active) {
								this.discard();
								return;
						}

						if (ownerUUID != null) {
								Entity owner = ((ServerLevel) level()).getEntity(ownerUUID);
								if (owner instanceof LivingEntity livingOwner && livingOwner.isAlive()) {
										this.setPos(livingOwner.getX(), livingOwner.getY(), livingOwner.getZ());

								} else {
										this.discard();
								}
						} else {
								this.discard();
						}
				}else{
						this.setupAnimationStates();
				}
		}

		@Override
		protected void defineSynchedData(SynchedEntityData.Builder builder) {
				builder.define(VARIANT, 0);
		}

		private int getTypeVariant() {
				return this.entityData.get(VARIANT);
		}

		public AuraVariant getVariant() {
				return AuraVariant.byId(this.getTypeVariant() & 255);
		}

		private void setVariant(AuraVariant variant) {
				this.entityData.set(VARIANT, variant.getId() & 255);
		}

		@Override
		public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float v) {
				return false;
		}

		@Override
		protected void readAdditionalSaveData(ValueInput valueInput) {
				this.active = valueInput.getBooleanOr("Active", false);
		}

		@Override
		protected void addAdditionalSaveData(ValueOutput valueOutput) {
				valueOutput.putBoolean("Active", active);
		}


		@Override public boolean isPickable() { return false; }
		@Override public boolean isInvisible() { return false; }
		@Override public boolean isPushable() { return false; }
		@Override public boolean isAttackable() { return false; }
		@Override public boolean isAlwaysTicking() { return true; }

		@Override
		protected void removePassenger(Entity passenger) {
				super.removePassenger(passenger);
				if(!level().isClientSide()){
						this.kill((ServerLevel) this.level());
				}
		}

		public int getVariantId() {
			return 0;
		}

		public boolean isKaiokenEnabled() {
				return false;
		}

		public int getAuraColorR() {
				return 255;
		}

		public int getAuraColorG() {
				return 0;
		}

		public int getAuraColorB() {
				return 0;
		}

		@Override
		public boolean activateAura() {
				return active;
		}

		public void setActiveAndSync(boolean activate) {
				this.active = activate;
				syncAuraToServer();
		}

		public static void spawnAura(ServerLevel level, ServerPlayer player) {
				AuraEntity aura = new AuraEntity(ModEntities.AURA_ENTITY.get(), level);
				aura.initOwner(player);
				level.addFreshEntity(aura);
		}

		public boolean isOwnedBy(Player player) {
				return ownerUUID != null && ownerUUID.equals(player.getUUID());
		}

		public UUID getOwnerUUID() {
				return ownerUUID;
		}

		public void setActive(boolean active) {
				this.active = active;
		}

		public void initOwner(LivingEntity owner) {
				this.ownerUUID = owner.getUUID();
				this.setPos(owner.getX(), owner.getY(), owner.getZ());
		}
}
