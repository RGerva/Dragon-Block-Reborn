package jingames.jrhc.setup.events;

import jingames.jrhc.setup.helper.ClientHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.AddLayers;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jrhc",
   value = {Dist.CLIENT},
   bus = Bus.MOD
)
public class ClientOnlyModSetup {
   @SubscribeEvent
   public static void addLayers(AddLayers evt) {
      ClientHelper.addPlayerLayer(evt, "default");
      ClientHelper.addPlayerLayer(evt, "slim");
   }
}
