package com.rgerva.dbr.datagen.model;

import net.minecraft.client.data.models.model.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModTexturedModel {

  public static final TexturedModel.Provider DRAGON_BALL =
          TexturedModel.createDefault(ModTexturedModel::getParticleOnly,
                  ModelTemplates.PARTICLE_ONLY);

  public static TextureMapping getParticleOnly(Block block){
    return new TextureMapping()
            .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block));
  }
}
