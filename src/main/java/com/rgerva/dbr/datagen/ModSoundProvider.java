package com.rgerva.dbr.datagen;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundProvider extends SoundDefinitionsProvider {
  protected ModSoundProvider(PackOutput output) {
    super(output, DragonBlockReborn.MOD_ID);
  }

  @Override
  public void registerSounds() {
    add(ModSounds.DRAGON_FLY, createSoundDefinition("dragon_fly"));
    add(ModSounds.DRAGON_GLOW, createSoundDefinition("dragon_glow"));
    add(ModSounds.DRAGON_GRANT, createSoundDefinition("dragon_grant"));
    add(ModSounds.DRAGON_MAKEONE, createSoundDefinition("dragon_makeone"));
    add(ModSounds.SPARK, createSoundDefinition("spark"));
  }

  protected SoundDefinition createSoundDefinition(String name) {
    return SoundDefinition.definition()
        .with(
            sound(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name))
                .attenuationDistance(8)
                .stream(true)
                .preload(true))
        .subtitle("sound." + DragonBlockReborn.MOD_ID + "." + name)
        .replace(true);
  }
}
