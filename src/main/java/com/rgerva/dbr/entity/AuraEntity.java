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

package com.rgerva.dbr.entity;

import com.rgerva.dbr.entity.renderer.AuraEntityRenderState;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class AuraEntity extends Entity {
		private final AuraEntityRenderState renderState = new AuraEntityRenderState();

		private int idleAnimationTimeout = 0;

		private static final EntityDataAccessor<Integer> VARIANT =
						SynchedEntityData.defineId(AuraEntity.class, EntityDataSerializers.INT);

		public AuraEntity(EntityType<?> entityType, Level level) {
				super(entityType, level);
		}

		private void setupAnimationStates() {
				this.renderState.activateAnimationState.start(this.tickCount);
//				if(this.idleAnimationTimeout <= 0) {
//						this.idleAnimationTimeout = 80;
//						this.renderState.idleAnimationState.start(this.tickCount);
//				} else {
//						--this.idleAnimationTimeout;
//				}
		}

		@Override
		public void tick() {
				super.tick();
				if(this.level().isClientSide()) {
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

		}

		@Override
		protected void addAdditionalSaveData(ValueOutput valueOutput) {

		}

		@Override
		protected void removePassenger(Entity passenger) {
				super.removePassenger(passenger);
				if(!level().isClientSide()){
						this.kill((ServerLevel) this.level());
				}
		}
}
