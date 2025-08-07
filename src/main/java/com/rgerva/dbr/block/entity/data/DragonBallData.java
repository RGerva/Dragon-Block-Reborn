package com.rgerva.dbr.block.entity.data;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;

public class DragonBallData extends SavedData {
  public static final SavedDataType<DragonBallData> ID =
      new SavedDataType<>(
          "dragon_ball_data",
          DragonBallData::new,
          // Codec com Context
          ctx ->
              RecordCodecBuilder.create(
                  instance ->
                      instance
                          .group(
                              RecordCodecBuilder.point(ctx),
                              BlockPos.CODEC
                                  .listOf()
                                  .fieldOf("positions")
                                  .forGetter(data -> new ArrayList<>(data.dragonBallPositions)))
                          .apply(instance, DragonBallData::new)));

  private final Set<BlockPos> dragonBallPositions = new HashSet<>();

  // Construtor com contexto vazio (novo mundo)
  public DragonBallData(SavedData.Context ctx) {}

  // Construtor para carregar dados do disco
  public DragonBallData(SavedData.Context ctx, List<BlockPos> positions) {
    this.dragonBallPositions.addAll(positions);
  }

  public void addDragonBall(BlockPos pos) {
    if (dragonBallPositions.add(pos.immutable())) {
      this.setDirty();
    }
  }

  public void removeDragonBall(BlockPos pos) {
    if (dragonBallPositions.remove(pos.immutable())) {
      this.setDirty();
    }
  }

  public boolean canAddMore() {
    return dragonBallPositions.size() < 7;
  }

  public int count() {
    return dragonBallPositions.size();
  }

  public boolean contains(BlockPos pos) {
    return dragonBallPositions.contains(pos.immutable());
  }

  public static DragonBallData get(ServerLevel level) {
    return level.getDataStorage().computeIfAbsent(ID);
  }
}
