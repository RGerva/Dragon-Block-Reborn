/**
 * Generic Class: EntityAura <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.entity;

import com.rgerva.dbr.sound.ModSounds;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class EntityAura extends Entity {
		@Nullable
		private LivingEntity owner;

		public int randomSoundDelay;
		public long lightVert;
		private int lightLivingTime;
		private String mot;
		private boolean rot;
		private int Age;
		private int color;
		private int colorl2;
		private float state;
		private float state2;
		private int crel;
		private float yaw;
		private float pitch;
		private float alpha;
		private String tex;
		private String texl2;
		private int speed;
		private boolean inner;
		private int rendpass;

		public int getLightLivingTime() {
				return this.lightLivingTime;
		}

		public EntityAura(EntityType<?> entityType, Level level) {
				super(entityType, level);

				this.randomSoundDelay = 0;
				this.mot = "";
				this.rot = false;
				this.color = 16777215;
				this.colorl2 = 16777215;
				this.state = 0.0F;
				this.state2 = 0.0F;
				this.crel = 0;
				this.yaw = 0.0F;
				this.pitch = 0.0F;
				this.alpha = 0.1F;
				this.tex = "aura";
				this.texl2 = "";
				this.speed = 20;
				this.inner = true;
				this.rendpass = 1;
		}

//		public EntityAura(Level level, String dbcCharger, int c, float s, float s2, int cr) {
//				this(ModEntities.AURA.get(), level);
//				this.randomSoundDelay = 0;
//				this.mot = "";
//				this.rot = false;
//				this.color = 16777215;
//				this.colorl2 = 16777215;
//				this.state = 0.0F;
//				this.state2 = 0.0F;
//				this.crel = 0;
//				this.yaw = 0.0F;
//				this.pitch = 0.0F;
//				this.alpha = 0.1F;
//				this.tex = "aura";
//				this.texl2 = "";
//				this.speed = 20;
//				this.inner = true;
//				this.rendpass = 1;
//				this.mot = dbcCharger;
//				this.color = c;
//				this.state = s;
//				this.state2 = s2;
//				this.crel = cr;
//				this.lightVert = this.getRandom().nextLong();
//				this.lightLivingTime = this.getRandom().nextInt(4);
//		}

		public static void summonAura(ServerLevel serverLevel, double x, double y, double z) {
				EntityAura aura = new EntityAura(ModEntities.AURA.get(), serverLevel);
				aura.setPos(x, y, z);
				serverLevel.addFreshEntity(aura);
		}


		public boolean shouldRenderInPass(int pass) {
				return pass == this.rendpass;
		}

		public boolean getRot() {
				return this.rot;
		}

		public float getYaw() {
				return this.yaw;
		}

		public float getPitch() {
				return this.pitch;
		}

		public int getAge() {
				return this.Age;
		}

		public float getState() {
				return this.state;
		}

		public float getState2() {
				return this.state2;
		}

		public float getCRel() {
				return (float)this.crel;
		}

		public int getCol() {
				return this.color;
		}

		public void setCol(int c) {
				this.color = c;
		}

		public int getColL2() {
				return this.colorl2;
		}

		public void setColL2(int c) {
				this.colorl2 = c;
		}

		public float getAlp() {
				return this.alpha;
		}

		public void setAlp(float f) {
				this.alpha = f;
		}

		public String getTex() {
				return this.tex;
		}

		public void setTex(String s) {
				this.tex = s;
		}

		public String getTexL2() {
				return this.texl2;
		}

		public void setTexL2(String s) {
				this.texl2 = s;
		}

		public int getSpd() {
				return this.speed;
		}

		public void setSpd(int s) {
				this.speed = s;
		}

		public boolean getInner() {
				return this.inner;
		}

		public void setInner(boolean s) {
				this.inner = s;
		}

		public void setRendPass(int s) {
				this.rendpass = s;
		}

		public String getmot() {
				return this.mot;
		}

		public void setOwner(@Nullable LivingEntity owner) {
				this.owner = owner;
		}

		@Nullable
		public LivingEntity getOwner() {
				return owner;
		}

		@Override
		public void checkDespawn() {
				if (this.owner == null || !this.owner.isAlive()) {
						this.discard(); // remove do mundo
				}
		}

		@Override
		public void tick() {
				super.tick();

				// Garante que tem um alvo definido
				if (this.mot != null && !this.mot.isEmpty()) {
						Player alvo = level().players().stream()
										.filter(p -> p.getGameProfile().getName().equals(this.mot))
										.findFirst()
										.orElse(null);

						if (alvo != null) {
								// Define deslocamento vertical para alinhar com o centro do player ou onde a aura deve estar
								double yOffset = 0.0; // ajuste se quiser mais alto/baixo

								// Servidor: posição e rotação instantâneas
								if (!level().isClientSide) {
										this.setPos(alvo.getX(), alvo.getY() + yOffset, alvo.getZ());
										this.setYRot(alvo.getYRot());
										this.setXRot(alvo.getXRot());
										this.setDeltaMovement(Vec3.ZERO);
								}
								// Cliente: corrige posição visual
								else {
										Vec3 destino = new Vec3(alvo.getX(), alvo.getY() + yOffset, alvo.getZ());
										this.moveOrInterpolateTo(destino, alvo.getYRot(), alvo.getXRot());
								}

								// Tocar som conforme lógica original
								if (this.getAge() < this.getLightLivingTime()
												&& this.getState() > 4.0F && this.getState() < 7.0F
												&& this.getAge() == 2) {

//										level().playSound(null,
//														alvo.getX(), alvo.getY(), alvo.getZ(),
//														ModSounds.SPARK.get(), SoundSource.PLAYERS,
//														0.0375F, 0.85F + (float) this.lightLivingTime * 0.05F);
								}
						} else {
								this.discard();
						}
				}

				// Expira pelo tempo de vida
				if (this.Age++ >= this.speed) {
						this.discard();
				}
		}

		@Override
		protected void defineSynchedData(SynchedEntityData.Builder builder) {

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
}
