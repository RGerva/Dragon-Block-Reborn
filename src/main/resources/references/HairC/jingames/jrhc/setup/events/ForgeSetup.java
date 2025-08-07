package jingames.jrhc.setup.events;

import java.util.Iterator;
import jingames.jrhc.setup.capabilities.PlayerStatsProvider;
import jingames.jrhc.setup.network.Networking;
import jingames.jrhc.setup.network.PacketColorsForAll;
import jingames.jrhc.setup.network.PacketDataForAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.StartTracking;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jrhc",
   bus = Bus.FORGE
)
public class ForgeSetup {
   @SubscribeEvent
   public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
      if (event.getObject() instanceof Player) {
         PlayerStatsProvider provider = new PlayerStatsProvider();
         event.addCapability(ResourceLocation.tryBuild("jrhc", "stats"), provider);
      }

   }

   @SubscribeEvent
   public static void onPlayerDeath(Clone event) {
      event.getOriginal().reviveCaps();
      event.getOriginal().getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((og) -> {
         event.getEntity().getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
            h.setDNSH(og.getDNSH());
            h.setRedColor(og.getRedColor());
            h.setGreenColor(og.getGreenColor());
            h.setBlueColor(og.getBlueColor());
         });
      });
      event.getOriginal().invalidateCaps();
   }

   @SubscribeEvent
   public static void onServerJoin(PlayerLoggedInEvent event) {
      if (event.getEntity() != null) {
         Player player = event.getEntity();
         if (player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).isPresent()) {
            player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               Iterator var3 = event.getEntity().level().players().iterator();

               while(var3.hasNext()) {
                  Player sp = (Player)var3.next();
                  if (h.getDNSH() == null) {
                     Networking.sendToClient(new PacketDataForAll("00", player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  } else {
                     Networking.sendToClient(new PacketDataForAll(h.getDNSH(), player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  }
               }

            });
         }
      }

   }

   @SubscribeEvent
   public static void playerRespawn(PlayerRespawnEvent event) {
      if (event.getEntity() != null) {
         Player player = event.getEntity();
         if (player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).isPresent()) {
            player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               Iterator var3 = event.getEntity().level().players().iterator();

               while(var3.hasNext()) {
                  Player sp = (Player)var3.next();
                  if (h.getDNSH() == null) {
                     Networking.sendToClient(new PacketDataForAll("00", player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  } else {
                     Networking.sendToClient(new PacketDataForAll(h.getDNSH(), player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  }
               }

            });
         }
      }

   }

   @SubscribeEvent
   public static void playerRespawn(PlayerChangedDimensionEvent event) {
      if (event.getEntity() != null) {
         Player player = event.getEntity();
         if (player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).isPresent()) {
            player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               Iterator var3 = event.getEntity().level().players().iterator();

               while(var3.hasNext()) {
                  Player sp = (Player)var3.next();
                  if (h.getDNSH() == null) {
                     Networking.sendToClient(new PacketDataForAll("00", player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  } else {
                     Networking.sendToClient(new PacketDataForAll(h.getDNSH(), player.getUUID()), (ServerPlayer)sp);
                     Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), player.getUUID()), (ServerPlayer)sp);
                  }
               }

            });
         }
      }

   }

   @SubscribeEvent
   public static void locatePlayer(StartTracking event) {
      Entity var2 = event.getTarget();
      if (var2 instanceof Player) {
         Player target = (Player)var2;
         if (event.getEntity() != null && target.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).isPresent()) {
            target.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
               if (h.getDNSH() == null) {
                  Networking.sendToClient(new PacketDataForAll("00", target.getUUID()), (ServerPlayer)event.getEntity());
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), target.getUUID()), (ServerPlayer)event.getEntity());
               } else {
                  Networking.sendToClient(new PacketDataForAll(h.getDNSH(), target.getUUID()), (ServerPlayer)event.getEntity());
                  Networking.sendToClient(new PacketColorsForAll(h.getRedColor(), h.getGreenColor(), h.getBlueColor(), target.getUUID()), (ServerPlayer)event.getEntity());
               }

            });
         }
      }

   }
}
