package jingames.jrhc.setup.events;

import java.util.Random;
import jingames.jrhc.gui.screens.HairSalonScreen;
import jingames.jrhc.setup.registrations.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jrhc",
   value = {Dist.CLIENT},
   bus = Bus.FORGE
)
public class ClientOnlyForgeSetup {
   public static Random rand = new Random();

   @SubscribeEvent
   public static void onItemUse(RightClickItem event) {
      if (event.getEntity().level().isClientSide && event.getEntity().getMainHandItem().is((Item)ModItems.ITEMBARBERSNC.get())) {
         Minecraft.getInstance().setScreen(new HairSalonScreen(0));
      }

   }
}
