/**
 * Generic Class: AuraState <T> A generic structure that works with type parameters.
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

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class AuraState extends EntityRenderState {
		// transform flags
		public boolean rot;
		public boolean inner;
		public boolean hasL2;

		// dynamics
		public float age;
		public float maxAge;
		public float s;       // escala derivada (state + cr + state2)
		public float spd2;    // 18 / (spd * 0.05f)
		public float yaw;     // entity YRot (para uso no bloco 'rot')
		public float pitch;   // entity XRot
		public float alpha;

		// cores e texturas
		public float[] mainRGB;
		public float[] l2RGB;
		public ResourceLocation mainTex;
		public ResourceLocation layer2Tex;

		// lightning condition
		public boolean renderLightning;
}
