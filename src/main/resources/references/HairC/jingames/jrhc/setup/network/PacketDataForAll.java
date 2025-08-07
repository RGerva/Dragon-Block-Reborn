package jingames.jrhc.setup.network;

import java.util.Iterator;
import java.util.UUID;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.CustomPayloadEvent.Context;
import net.minecraftforge.fml.DistExecutor;

public class PacketDataForAll {
   private String StatName;
   private UUID hairChanger;

   public PacketDataForAll(FriendlyByteBuf buf) {
      this.StatName = buf.readUtf();
      this.hairChanger = buf.readUUID();
   }

   public PacketDataForAll(String StatName, UUID hairchanger) {
      this.StatName = StatName;
      this.hairChanger = hairchanger;
   }

   public void toBytes(FriendlyByteBuf buf) {
      buf.writeUtf(this.StatName);
      buf.writeUUID(this.hairChanger);
   }

   public void handle(Context ctx) {
      ctx.enqueueWork(() -> {
         DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> {
            return () -> {
               this.playerChanged();
            };
         });
      });
      ctx.setPacketHandled(true);
   }

   public void playerChanged() {
      Iterator var1 = Minecraft.getInstance().level.players().iterator();

      while(var1.hasNext()) {
         Player sp = (Player)var1.next();
         if (sp.getUUID().equals(this.hairChanger)) {
            sp.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               h.setDNSH(this.StatName);
            });
         }
      }

   }
}
