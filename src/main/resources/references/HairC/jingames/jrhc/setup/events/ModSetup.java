package jingames.jrhc.setup.events;

import jingames.jrhc.hairmodel.HairModel;
import jingames.jrhc.setup.capabilities.IPlayerStats;
import jingames.jrhc.setup.network.Networking;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(
   modid = "jrhc",
   bus = Bus.MOD
)
public class ModSetup {
   @SubscribeEvent
   public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(HairModel.LAYER_LOCATION, HairModel::createBodyLayer);
   }

   @SubscribeEvent
   public static void registerCapabilities(RegisterCapabilitiesEvent event) {
      event.register(IPlayerStats.class);
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      Networking.registerMessages();
   }
}
