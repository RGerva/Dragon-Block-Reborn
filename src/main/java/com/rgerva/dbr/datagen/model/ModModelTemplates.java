package com.rgerva.dbr.datagen.model;

import com.rgerva.dbr.DragonBlockReborn;
import java.util.Optional;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

public class ModModelTemplates {

  public static final ModelTemplate DRAGON_BALL_TEMPLATE =
      block("dragon_ball_template", TextureSlot.PARTICLE, TextureSlot.create("dragon_ball"));

  private static ModelTemplate block(String parent, TextureSlot... requiredTextureSlots) {
    return new ModelTemplate(
        Optional.of(
            ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID,
                    "block/" + parent)),
        Optional.empty(),
        requiredTextureSlots);
  }

  private static ModelTemplate block(
      String parent, String variant, TextureSlot... requiredTextureSlots) {
    return new ModelTemplate(
        Optional.of(
            ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "block/" + parent)),
        Optional.of(variant),
        requiredTextureSlots);
  }
}
