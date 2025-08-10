/**
 * Generic Class: AuraModel <T>
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

package com.rgerva.dbr.datagen.model.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.entity.animations.AuraAnimations;
import com.rgerva.dbr.entity.renderer.AuraEntityRenderState;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;

import java.awt.*;


public class AuraModel extends EntityModel<AuraEntityRenderState> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "aura_template"),
            "main");

    private final ModelPart auraRoot;
    private final ModelPart auraBody;
    private final ModelPart auraOutline;
    private final ModelPart bone18;
    private final ModelPart bone19;
    private final ModelPart bone20;
    private final ModelPart bone21;
    private final ModelPart bone22;
    private final ModelPart bone23;
    private final ModelPart bone24;
    private final ModelPart bone25;
    private final ModelPart auraCore;
    private final ModelPart bone26;
    private final ModelPart bone27;
    private final ModelPart bone28;
    private final ModelPart bone29;
    private final ModelPart bone30;
    private final ModelPart bone31;
    private final ModelPart bone32;
    private final ModelPart bone33;

		private final KeyframeAnimation idlingAnimation;
		private final KeyframeAnimation activeAnimation;
		private final KeyframeAnimation deactivateAnimation;

		@Override
		public void setupAnim(AuraEntityRenderState state) {
				this.root().getAllParts().forEach(ModelPart::resetPose);

				this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
				this.activeAnimation.apply(state.activateAnimationState, state.ageInTicks, 1f);
				this.deactivateAnimation.apply(state.deactivateAnimationState, state.ageInTicks, 1f);
		}

		public AuraModel(ModelPart root){
				super(root);

				this.auraRoot = root.getChild("auraRoot");
        this.auraBody = this.auraRoot.getChild("auraBody");
        this.auraOutline = this.auraBody.getChild("auraOutline");
        this.bone18 = this.auraOutline.getChild("bone18");
        this.bone19 = this.auraOutline.getChild("bone19");
        this.bone20 = this.auraOutline.getChild("bone20");
        this.bone21 = this.auraOutline.getChild("bone21");
        this.bone22 = this.auraOutline.getChild("bone22");
        this.bone23 = this.auraOutline.getChild("bone23");
        this.bone24 = this.auraOutline.getChild("bone24");
        this.bone25 = this.auraOutline.getChild("bone25");
        this.auraCore = this.auraBody.getChild("auraCore");
        this.bone26 = this.auraCore.getChild("bone26");
        this.bone27 = this.auraCore.getChild("bone27");
        this.bone28 = this.auraCore.getChild("bone28");
        this.bone29 = this.auraCore.getChild("bone29");
        this.bone30 = this.auraCore.getChild("bone30");
        this.bone31 = this.auraCore.getChild("bone31");
        this.bone32 = this.auraCore.getChild("bone32");
        this.bone33 = this.auraCore.getChild("bone33");

				this.idlingAnimation = AuraAnimations.AURA_ON.bake(root);
				this.activeAnimation = AuraAnimations.AURA_MOVE.bake(root);
				this.deactivateAnimation = AuraAnimations.AURA_OFF.bake(root);
    }

    public static LayerDefinition createBodyLayer() {

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition auraRoot = partdefinition.addOrReplaceChild("auraRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition auraBody = auraRoot.addOrReplaceChild("auraBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition auraOutline = auraBody.addOrReplaceChild("auraOutline", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone18 = auraOutline.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone18_r1 = bone18.addOrReplaceChild("bone18_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 1.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone18_r2 = bone18.addOrReplaceChild("bone18_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone18_r3 = bone18.addOrReplaceChild("bone18_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone18_r4 = bone18.addOrReplaceChild("bone18_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, -2.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone18_r5 = bone18.addOrReplaceChild("bone18_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, -2.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone18_r6 = bone18.addOrReplaceChild("bone18_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, -2.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone19 = auraOutline.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone19_r1 = bone19.addOrReplaceChild("bone19_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, -0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone19_r2 = bone19.addOrReplaceChild("bone19_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone19_r3 = bone19.addOrReplaceChild("bone19_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone19_r4 = bone19.addOrReplaceChild("bone19_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone19_r5 = bone19.addOrReplaceChild("bone19_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone20 = auraOutline.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone20_r1 = bone20.addOrReplaceChild("bone20_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 1.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone20_r2 = bone20.addOrReplaceChild("bone20_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, -0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone20_r3 = bone20.addOrReplaceChild("bone20_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone20_r4 = bone20.addOrReplaceChild("bone20_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone20_r5 = bone20.addOrReplaceChild("bone20_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone20_r6 = bone20.addOrReplaceChild("bone20_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone21 = auraOutline.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition bone21_r1 = bone21.addOrReplaceChild("bone21_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, -0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone21_r2 = bone21.addOrReplaceChild("bone21_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone21_r3 = bone21.addOrReplaceChild("bone21_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone21_r4 = bone21.addOrReplaceChild("bone21_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone21_r5 = bone21.addOrReplaceChild("bone21_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone22 = auraOutline.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition bone22_r1 = bone22.addOrReplaceChild("bone22_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 1.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone22_r2 = bone22.addOrReplaceChild("bone22_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition bone22_r3 = bone22.addOrReplaceChild("bone22_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone22_r4 = bone22.addOrReplaceChild("bone22_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone22_r5 = bone22.addOrReplaceChild("bone22_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone22_r6 = bone22.addOrReplaceChild("bone22_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone23 = auraOutline.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

        PartDefinition bone23_r1 = bone23.addOrReplaceChild("bone23_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, -0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone23_r2 = bone23.addOrReplaceChild("bone23_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone23_r3 = bone23.addOrReplaceChild("bone23_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone23_r4 = bone23.addOrReplaceChild("bone23_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone23_r5 = bone23.addOrReplaceChild("bone23_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone24 = auraOutline.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bone24_r1 = bone24.addOrReplaceChild("bone24_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 1.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone24_r2 = bone24.addOrReplaceChild("bone24_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -23.0086F, -0.1305F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone24_r3 = bone24.addOrReplaceChild("bone24_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone24_r4 = bone24.addOrReplaceChild("bone24_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone24_r5 = bone24.addOrReplaceChild("bone24_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone24_r6 = bone24.addOrReplaceChild("bone24_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone25 = auraOutline.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone25_r1 = bone25.addOrReplaceChild("bone25_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, -0.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone25_r2 = bone25.addOrReplaceChild("bone25_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone25_r3 = bone25.addOrReplaceChild("bone25_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, -0.7322F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone25_r4 = bone25.addOrReplaceChild("bone25_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 1.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone25_r5 = bone25.addOrReplaceChild("bone25_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 4.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition auraCore = auraBody.addOrReplaceChild("auraCore", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone26 = auraCore.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition bone26_r1 = bone26.addOrReplaceChild("bone26_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 11.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone26_r2 = bone26.addOrReplaceChild("bone26_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone26_r3 = bone26.addOrReplaceChild("bone26_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone26_r4 = bone26.addOrReplaceChild("bone26_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 8.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone26_r5 = bone26.addOrReplaceChild("bone26_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, 8.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone26_r6 = bone26.addOrReplaceChild("bone26_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, 8.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone27 = auraCore.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone27_r1 = bone27.addOrReplaceChild("bone27_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 9.6084F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone27_r2 = bone27.addOrReplaceChild("bone27_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone27_r3 = bone27.addOrReplaceChild("bone27_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone27_r4 = bone27.addOrReplaceChild("bone27_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone27_r5 = bone27.addOrReplaceChild("bone27_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone28 = auraCore.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone28_r1 = bone28.addOrReplaceChild("bone28_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 11.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone28_r2 = bone28.addOrReplaceChild("bone28_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 9.6084F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone28_r3 = bone28.addOrReplaceChild("bone28_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone28_r4 = bone28.addOrReplaceChild("bone28_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone28_r5 = bone28.addOrReplaceChild("bone28_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone28_r6 = bone28.addOrReplaceChild("bone28_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone29 = auraCore.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition bone29_r1 = bone29.addOrReplaceChild("bone29_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 9.6084F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone29_r2 = bone29.addOrReplaceChild("bone29_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone29_r3 = bone29.addOrReplaceChild("bone29_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone29_r4 = bone29.addOrReplaceChild("bone29_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone29_r5 = bone29.addOrReplaceChild("bone29_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone30 = auraCore.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition bone30_r1 = bone30.addOrReplaceChild("bone30_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 11.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone30_r2 = bone30.addOrReplaceChild("bone30_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 10.3916F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition bone30_r3 = bone30.addOrReplaceChild("bone30_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone30_r4 = bone30.addOrReplaceChild("bone30_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone30_r5 = bone30.addOrReplaceChild("bone30_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone30_r6 = bone30.addOrReplaceChild("bone30_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone31 = auraCore.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

        PartDefinition bone31_r1 = bone31.addOrReplaceChild("bone31_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 9.6084F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone31_r2 = bone31.addOrReplaceChild("bone31_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone31_r3 = bone31.addOrReplaceChild("bone31_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone31_r4 = bone31.addOrReplaceChild("bone31_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone31_r5 = bone31.addOrReplaceChild("bone31_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone32 = auraCore.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bone32_r1 = bone32.addOrReplaceChild("bone32_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0042F, 11.0785F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -8.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition bone32_r2 = bone32.addOrReplaceChild("bone32_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -23.0086F, 9.8695F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone32_r3 = bone32.addOrReplaceChild("bone32_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone32_r4 = bone32.addOrReplaceChild("bone32_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone32_r5 = bone32.addOrReplaceChild("bone32_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone32_r6 = bone32.addOrReplaceChild("bone32_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        PartDefinition bone33 = auraCore.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone33_r1 = bone33.addOrReplaceChild("bone33_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -21.0257F, 9.6084F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.0F, -14.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone33_r2 = bone33.addOrReplaceChild("bone33_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -24.0F, 10.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -15.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone33_r3 = bone33.addOrReplaceChild("bone33_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -26.7189F, 9.2678F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -18.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bone33_r4 = bone33.addOrReplaceChild("bone33_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.9668F, 11.0438F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition bone33_r5 = bone33.addOrReplaceChild("bone33_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.5F, 14.0622F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.0F, 1.0472F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    public void renderToBuffer(
            PoseStack poseStack,
            VertexConsumer buffer,
            int packedLight,
            int packedOverlay,
            float red,
            float green,
            float blue,
            float alpha) {

				int a = (int)(alpha * 255) << 24;
				int r = (int)(red * 255) << 16;
				int g = (int)(green * 255) << 8;
				int b = (int)(blue * 255);

				int color = a | r | g | b;
				
        auraRoot.render(poseStack, buffer, packedLight, packedOverlay, color);
        auraBody.render(poseStack, buffer, packedLight, packedOverlay, color);
        auraOutline.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone18.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone19.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone20.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone21.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone22.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone23.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone24.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone25.render(poseStack, buffer, packedLight, packedOverlay, color);
        auraCore.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone26.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone27.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone28.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone29.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone30.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone31.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone32.render(poseStack, buffer, packedLight, packedOverlay, color);
        bone33.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}
