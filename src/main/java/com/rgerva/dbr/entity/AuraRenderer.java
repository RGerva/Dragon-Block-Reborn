/**
 * Generic Class: AuraRenderer <T> A generic structure that works with type parameters.
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

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.datagen.model.custom.ModelAura;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class AuraRenderer extends EntityRenderer<EntityAura, AuraState> {

  private final String modid;
  private ModelAura model;

  public AuraRenderer(EntityRendererProvider.Context ctx) {
    this(ctx, DragonBlockReborn.MOD_ID);
  }

  @Override
  public AuraState createRenderState() {
    return new AuraState();
  }

  public AuraRenderer(EntityRendererProvider.Context ctx, String modid) {
    super(ctx);
    this.modid = modid;
    this.model = new ModelAura(ctx.bakeLayer(ModelAura.LAYER_LOCATION));
    this.shadowRadius = 0.0F;
  }

  @Override
  public void extractRenderState(EntityAura entity, AuraState state, float partialTick) {
    // Flags
    state.rot = entity.getRot();
    state.inner = entity.getInner();

    // Dinâmica
    float spd = (float) entity.getSpd();
    state.spd2 = 18.0F / (spd * 0.05F);
    state.age = (float) entity.getAge() + partialTick;

    float cr = entity.getCRel();
    float s1 = entity.getState();
    float s2 = entity.getState2() * 0.5F;
    state.s = s1 + cr * 0.03F + s2;

    state.yaw = entity.getYRot();
    state.pitch = entity.getXRot();

    // Texturas e cores
    String tex = entity.getTex();
    String texl2 = entity.getTexL2();
    state.hasL2 = texl2 != null && texl2.length() > 2;

    state.mainTex = ResourceLocation.fromNamespaceAndPath(modid, tex + ".png");
    state.layer2Tex = ResourceLocation.fromNamespaceAndPath(modid, texl2 + ".png");

    state.mainRGB = unpackRGB(entity.getCol());
    state.l2RGB = unpackRGB(entity.getColL2());

    // Alpha (respeita 1ª pessoa do player local)
    Minecraft mc = Minecraft.getInstance();
    Player local = mc.player;
    boolean isLocalFirstPerson =
        local != null
            && local.getGameProfile().getName().equals(entity.getMot())
            && mc.options.getCameraType().isFirstPerson();

    state.alpha = !isLocalFirstPerson ? entity.getAlp() : (state.inner ? 0.025F : 0.05F);

    // Lightning condição (mesma do antigo)
    state.renderLightning =
        state.age < entity.getLightLivingTime()
            && entity.getState() > 4.0F
            && entity.getState() < 7.0F
            && !state.rot;
  }

  @Override
  public void render(AuraState s, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
    poseStack.pushPose();

    // translate base (0, +3, 0)
    poseStack.translate(0.0, 3.0, 0.0);

    // bloco de rotação condicional
    if (s.rot) {
      poseStack.translate(0.0, -1.5, 0.0);
      poseStack.mulPose(Axis.YP.rotationDegrees(-s.yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(s.pitch - 90.0F));
      poseStack.translate(0.0, 1.5, 0.0);
    }

    poseStack.pushPose();

    // rotações/escala equivalentes ao GL antigo
    poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
    poseStack.scale(1.0F + 0.1F * s.s, 1.0F + 0.07F * s.s, 1.0F + 0.1F * s.s);
    poseStack.translate(0.0, -0.3 - 0.07 * s.s, 0.0);
    poseStack.mulPose(Axis.YP.rotationDegrees(s.age * s.spd2));

    VertexConsumer vcMain = buffer.getBuffer(RenderType.entityTranslucent(s.mainTex));
    VertexConsumer vcL2 =
        s.hasL2 ? buffer.getBuffer(RenderType.entityTranslucent(s.layer2Tex)) : null;
    int overlay = OverlayTexture.NO_OVERLAY;

    int innerPasses = s.inner ? 2 : 1;
    for (int i2 = 0; i2 < innerPasses && (i2 != 1 || !(s.age > 10.0F)); i2++) {
      if (s.age < 15.0F) {
        for (int i = 0; i < 4; i++) {
          poseStack.pushPose();
          poseStack.mulPose(Axis.YP.rotationDegrees(i * 90.0F));
          model.renderToBuffer(
              poseStack,
              vcMain,
              packedLight,
              overlay,
              s.mainRGB[0],
              s.mainRGB[1],
              s.mainRGB[2],
              s.alpha);
          if (s.hasL2 && vcL2 != null) {
            model.renderToBuffer(
                poseStack, vcL2, packedLight, overlay, s.l2RGB[0], s.l2RGB[1], s.l2RGB[2], s.alpha);
          }
          poseStack.popPose();
        }
      }
      for (int i = 0; i < 4; i++) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(i * 90.0F + 45.0F));
        model.renderToBuffer(
            poseStack,
            vcMain,
            packedLight,
            overlay,
            s.mainRGB[0],
            s.mainRGB[1],
            s.mainRGB[2],
            s.alpha);
        if (s.hasL2 && vcL2 != null) {
          model.renderToBuffer(
              poseStack, vcL2, packedLight, overlay, s.l2RGB[0], s.l2RGB[1], s.l2RGB[2], s.alpha);
        }
        poseStack.popPose();
      }
    }

    poseStack.popPose();

			if (s.renderLightning) {
					renderLightning(poseStack, buffer, s, packedLight);
			}


    poseStack.popPose();
  }

  private static float[] unpackRGB(int rgb) {
    return new float[] {
      ((rgb >> 16) & 0xFF) / 255.0F, ((rgb >> 8) & 0xFF) / 255.0F, (rgb & 0xFF) / 255.0F
    };
  }

  // Efeito “raios” em blend aditivo aproximando o visual antigo
  private void renderLightning(
      PoseStack poseStack, MultiBufferSource buffer, AuraState s, int packedLight) {
    // Blend aditivo padrão dos “raios”
    VertexConsumer vc = buffer.getBuffer(RenderType.lightning());
    PoseStack.Pose pose = poseStack.last();

    // Random estável por frame (pode trocar a seed se quiser ancorar no entity)
    java.util.Random rand = new java.util.Random((long) (s.age * 31));

    float f2 = 0.5F; // tonalidade azulada
    float alpha = 0.3F; // transparência do raio
    float r = 0.9F * f2, g = 0.9F * f2, b = 1.0F * f2;

    // Três “faixas” triangulares com jitter leve (equivalente aproximado ao Tessellator antigo)
    for (int seg = 0; seg < 3; seg++) {
      double x0 = 0.0, z0 = 0.0;
      double x1 = (rand.nextInt(31) - 15) * 0.07;
      double z1 = (rand.nextInt(31) - 15) * 0.07;

      // Triângulo 1
      vc.addVertex(pose, (float) x0, 0.0F, (float) z0)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);

      vc.addVertex(pose, (float) x1, 0.5F, (float) z1)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);

      vc.addVertex(pose, (float) -x1, 0.5F, (float) -z1)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);

      // Triângulo 2 (invertido) para formar uma “faixa”
      vc.addVertex(pose, (float) x0, 0.0F, (float) z0)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);

      vc.addVertex(pose, (float) -x1, 0.5F, (float) -z1)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);

      vc.addVertex(pose, (float) x1, 0.5F, (float) z1)
          .setColor(r, g, b, alpha)
          .setOverlay(OverlayTexture.NO_OVERLAY)
          .setLight(packedLight)
          .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
  }
}
