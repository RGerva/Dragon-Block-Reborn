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

public class PacketColorsForAll {
   private float red;
   private float green;
   private float blue;
   private UUID hairChanger;

   public PacketColorsForAll(FriendlyByteBuf buf) {
      this.red = buf.readFloat();
      this.green = buf.readFloat();
      this.blue = buf.readFloat();
      this.hairChanger = buf.readUUID();
   }

   public PacketColorsForAll(float red, float green, float blue, UUID hairchanger) {
      this.red = red;
      this.green = green;
      this.blue = blue;
      this.hairChanger = hairchanger;
   }

   public void toBytes(FriendlyByteBuf buf) {
      buf.writeFloat(this.red);
      buf.writeFloat(this.green);
      buf.writeFloat(this.blue);
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
               h.setRedColor(this.red);
               h.setGreenColor(this.green);
               h.setBlueColor(this.blue);
            });
         }
      }

   }
}
