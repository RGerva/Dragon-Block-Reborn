package jingames.jrhc.setup.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerStatsProvider implements ICapabilitySerializable<CompoundTag> {
   public final DefaultPlayerStats stats = new DefaultPlayerStats();
   private final LazyOptional<IPlayerStats> statsOptional = LazyOptional.of(() -> {
      return this.stats;
   });
   public static Capability<IPlayerStats> PLAYER_STATS_CAPABILITY = CapabilityManager.get(new CapabilityToken<IPlayerStats>() {
   });

   @Nonnull
   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
      return PLAYER_STATS_CAPABILITY.orEmpty(cap, this.statsOptional);
   }

   public CompoundTag serializeNBT(Provider registryAccess) {
      if (PLAYER_STATS_CAPABILITY == null) {
         return new CompoundTag();
      } else {
         CompoundTag tag = new CompoundTag();
         tag.putFloat("redcolor", this.stats.getRedColor());
         tag.putFloat("greencolor", this.stats.getGreenColor());
         tag.putFloat("bluecolor", this.stats.getBlueColor());
         if (this.stats.getDNSH() == null) {
            tag.putString("dnsh", "008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500020");
         } else {
            tag.putString("dnsh", this.stats.getDNSH());
         }

         return tag;
      }
   }

   public void deserializeNBT(Provider registryAccess, CompoundTag nbt) {
      if (PLAYER_STATS_CAPABILITY != null) {
         this.stats.setRedColor((Float)nbt.getFloat("redcolor").get());
         this.stats.setGreenColor((Float)nbt.getFloat("greencolor").get());
         this.stats.setBlueColor((Float)nbt.getFloat("bluecolor").get());
         if (nbt.getString("dnsh") == null) {
            this.stats.setDNSH("008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500000808080505000008080805050000080808050500020");
         } else {
            this.stats.setDNSH((String)nbt.getString("dnsh").get());
         }
      }

   }
}
