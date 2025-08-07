package jingames.jrhc.setup.network;

import java.util.Iterator;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.network.CustomPayloadEvent.Context;

public class PacketData {
   private String StatName;

   public PacketData(FriendlyByteBuf buf) {
      this.StatName = buf.readUtf();
   }

   public PacketData(String StatName) {
      this.StatName = StatName;
   }

   public void toBytes(FriendlyByteBuf buf) {
      buf.writeUtf(this.StatName);
   }

   public void handle(Context ctx) {
      ctx.enqueueWork(() -> {
         ServerPlayer sender = ctx.getSender();
         if (this.StatName.length() == 786 && !sender.level().isClientSide) {
            sender.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               h.setDNSH(this.StatName);
               Iterator var4 = ctx.getSender().level().players().iterator();

               while(var4.hasNext()) {
                  Player sp = (Player)var4.next();
                  Networking.sendToClient(new PacketDataForAll(this.StatName, sender.getUUID()), (ServerPlayer)sp);
               }

            });
         }

      });
      ctx.setPacketHandled(true);
   }
}
