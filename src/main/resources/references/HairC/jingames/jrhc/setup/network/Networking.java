package jingames.jrhc.setup.network;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.SimpleChannel;

public class Networking {
   private static SimpleChannel INSTANCE;
   private static int ID = 0;

   private static int nextID() {
      return ID++;
   }

   public static void registerMessages() {
      INSTANCE = ChannelBuilder.named(ResourceLocation.tryBuild("jrhc", "jrhc")).serverAcceptedVersions((status, version) -> {
         return true;
      }).clientAcceptedVersions((status, version) -> {
         return true;
      }).optional().simpleChannel();
      INSTANCE.messageBuilder(PacketData.class, nextID()).encoder(PacketData::toBytes).decoder(PacketData::new).consumerMainThread(PacketData::handle).add();
      INSTANCE.messageBuilder(PacketDataForAll.class, nextID()).encoder(PacketDataForAll::toBytes).decoder(PacketDataForAll::new).consumerMainThread(PacketDataForAll::handle).add();
      INSTANCE.messageBuilder(PacketGetData.class, nextID()).encoder(PacketGetData::toBytes).decoder(PacketGetData::new).consumerMainThread(PacketGetData::handle).add();
      INSTANCE.messageBuilder(PacketColors.class, nextID()).encoder(PacketColors::toBytes).decoder(PacketColors::new).consumerMainThread(PacketColors::handle).add();
      INSTANCE.messageBuilder(PacketColorsForAll.class, nextID()).encoder(PacketColorsForAll::toBytes).decoder(PacketColorsForAll::new).consumerMainThread(PacketColorsForAll::handle).add();
   }

   public static void sendToClient(Object packet, ServerPlayer player) {
      INSTANCE.send(packet, player.connection.getConnection());
   }

   public static void sendToServer(Object packet) {
      INSTANCE.send(packet, Minecraft.getInstance().getConnection().getConnection());
   }
}
