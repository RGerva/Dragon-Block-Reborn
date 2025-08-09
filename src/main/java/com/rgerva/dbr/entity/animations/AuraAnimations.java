/**
 * Generic Class: AuraAnimations <T>
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

package com.rgerva.dbr.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class AuraAnimations {

		public static final AnimationDefinition AURA_MOVE = AnimationDefinition.Builder.withLength(0.1667F).looping()
						.addAnimation("auraRoot", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
										new Keyframe(0.0823F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
										new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
										new Keyframe(0.1657F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
										new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.SCALE,
										new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.8F, 0.8F, 0.8F), AnimationChannel.Interpolations.LINEAR)
						))
						.build();

		public static final AnimationDefinition AURA_ON = AnimationDefinition.Builder.withLength(0.3333F)
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.SCALE,
										new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
						.build();

		public static final AnimationDefinition AURA_OFF = AnimationDefinition.Builder.withLength(0.3333F)
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
						.addAnimation("auraBody", new AnimationChannel(AnimationChannel.Targets.SCALE,
										new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
						.build();

		public static final AnimationDefinition HUMANOID_EYES = AnimationDefinition.Builder.withLength(0.0F).looping()
						.addAnimation("eyes", new AnimationChannel(AnimationChannel.Targets.SCALE,
										new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("leftPupil", new AnimationChannel(AnimationChannel.Targets.POSITION,
										new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("rightPupil", new AnimationChannel(AnimationChannel.Targets.POSITION,
										new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.build();

		public static final AnimationDefinition HUMANOID_KNOCKED_OUT = AnimationDefinition.Builder.withLength(0.0F).looping()
						.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
										new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0F, -16.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
										new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.addAnimation("eyes", new AnimationChannel(AnimationChannel.Targets.SCALE,
										new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
						))
						.build();

		public static final AnimationDefinition SFX_CHARGE_LOOP = AnimationDefinition.Builder.withLength(2.823F).looping()
						.build();

		public static final AnimationDefinition SFX_CHARGE_GOD_LOOP = AnimationDefinition.Builder.withLength(2.0F).looping()
						.build();
}
