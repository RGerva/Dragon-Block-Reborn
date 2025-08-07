package jingames.jrhc.setup.network;

import java.util.Iterator;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.network.CustomPayloadEvent.Context;

public class PacketColors {
   public float red;
   public float green;
   public float blue;

   public PacketColors(FriendlyByteBuf buf) {
      this.red = buf.readFloat();
      this.green = buf.readFloat();
      this.blue = buf.readFloat();
   }

   public PacketColors(float red, float green, float blue) {
      this.red = red;
      this.green = green;
      this.blue = blue;
   }

   public void toBytes(FriendlyByteBuf buf) {
      buf.writeFloat(this.red);
      buf.writeFloat(this.green);
      buf.writeFloat(this.blue);
   }

   public void handle(Context ctx) {
      ctx.enqueueWork(() -> {
         ServerPlayer sender = ctx.getSender();
         sender.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
            h.setRedColor(this.red);
            h.setGreenColor(this.green);
            h.setBlueColor(this.blue);
            Iterator var4 = ctx.getSender().level().players().iterator();

            while(var4.hasNext()) {
               Player sp = (Player)var4.next();
               Networking.sendToClient(new PacketColorsForAll(this.red, this.green, this.blue, sender.getUUID()), (ServerPlayer)sp);
            }

         });
      });
      ctx.setPacketHandled(true);
   }
}
