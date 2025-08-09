/**
 * Generic Class: AuraEntityRenderer <T>
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

import com.google.common.collect.Maps;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.datagen.model.custom.AuraModel;
import com.rgerva.dbr.entity.AuraEntity;
import com.rgerva.dbr.entity.AuraVariant;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import org.joml.Vector3f;

import java.util.Map;

public class AuraEntityRenderer extends EntityRenderer<AuraEntity, AuraEntityRenderState> {

		private AuraModel model;

		private static final Map<AuraVariant, ResourceLocation> LOCATION_BY_VARIANT =
						Util.make(Maps.newEnumMap(AuraVariant.class), map -> {
								map.put(AuraVariant.AURA,
												ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "textures/entity/aura/aura.png"));
								map.put(AuraVariant.AURA_MER,
												ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "textures/entity/aura/aura_mer.png"));
								map.put(AuraVariant.AURA_LOW,
												ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "textures/entity/aura/aura_low.png"));
						});

		public AuraEntityRenderer(EntityRendererProvider.Context context) {
				super(context);
				this.model = new AuraModel(context.bakeLayer(AuraModel.LAYER_LOCATION));
		}

		@Override
		public boolean shouldRender(AuraEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
				return true;
		}

		@Override
		public void render(AuraEntityRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
				poseStack.scale(1f, 1f, 1f);

				super.render(renderState, poseStack, bufferSource, packedLight);
		}

		@Override
		public AuraEntityRenderState createRenderState() {
				return new AuraEntityRenderState();
		}
}
