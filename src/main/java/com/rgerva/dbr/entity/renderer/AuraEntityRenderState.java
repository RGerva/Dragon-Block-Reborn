/**
 * Generic Class: AuraEntityRenderState <T>
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

package com.rgerva.dbr.entity.renderer;

import com.rgerva.dbr.entity.entity.AuraVariant;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class AuraEntityRenderState extends EntityRenderState {

		/**
		 * Animação de idle/loop da aura
		 */
		public final AnimationState idleAnimationState = new AnimationState();

		/**
		 * Animação quando a aura é ativada
		 */
		public final AnimationState activateAnimationState = new AnimationState();

		/**
		 * Animação quando a aura é desativada
		 */
		public final AnimationState deactivateAnimationState = new AnimationState();

		public AuraVariant variant;
}
