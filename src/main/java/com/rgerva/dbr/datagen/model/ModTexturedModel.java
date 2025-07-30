package com.rgerva.dbr.datagen.model;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;

public class ModTexturedModel {

    public static final TexturedModel.Provider DRAGON_BALL_MODEL = TexturedModel
            .createDefault(ModTexturedModel::getDragonBallMapping,
                    ModModelTemplates.DRAGON_BALL_TEMPLATE);

    public static TextureMapping getDragonBallMapping(Block block) {
        return new TextureMapping().
                put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block)).
                put(ModTextureSlot.DRAGON_BALL_SLOT, TextureMapping.getBlockTexture(block));
    }
}
