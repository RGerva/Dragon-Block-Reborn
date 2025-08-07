package jingames.jrhc.setup.network;

import java.util.Iterator;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.network.CustomPayloadEvent.Context;

public class PacketGetData {
   private String StatName = "00";

   public PacketGetData(FriendlyByteBuf buf) {
      this.StatName = buf.readUtf();
   }

   public PacketGetData() {
   }

   public void toBytes(FriendlyByteBuf buf) {
      buf.writeUtf(this.StatName);
   }

   public void handle(Context ctx) {
      ctx.enqueueWork(() -> {
         ServerPlayer sender = ctx.getSender();
         sender.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
            Iterator var3 = ctx.getSender().level().players().iterator();

            while(var3.hasNext()) {
               Player sp = (Player)var3.next();
               if (h.getDNSH() == null) {
                  Networking.sendToClient(new PacketDataForAll("00", sender.getUUID()), (ServerPlayer)sp);
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), sender.getUUID()), (ServerPlayer)sp);
               } else {
                  Networking.sendToClient(new PacketDataForAll(h.getDNSH(), sender.getUUID()), (ServerPlayer)sp);
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), sender.getUUID()), (ServerPlayer)sp);
               }
            }

         });
         Iterator var2 = ctx.getSender().level().players().iterator();

         while(var2.hasNext()) {
            Player sp = (Player)var2.next();
            sp.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               if (h.getDNSH() == null) {
                  Networking.sendToClient(new PacketDataForAll("00", sp.getUUID()), sender);
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), sp.getUUID()), sender);
               } else {
                  Networking.sendToClient(new PacketDataForAll(h.getDNSH(), sp.getUUID()), sender);
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), sp.getUUID()), sender);
               }

            });
         }

      });
      ctx.setPacketHandled(true);
   }
}
