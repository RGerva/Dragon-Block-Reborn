package jingames.jrhc;

import jingames.jrhc.setup.registrations.ModItems;
import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("jrhc")
public class HairCMod {
   public static final String MODID = "jrhc";

   public HairCMod(FMLJavaModLoadingContext c) {
      ModItems.ITEMS.register(c.getModBusGroup());
      ModItems.TABS.register(c.getModBusGroup());
      c.registerExtensionPoint(DisplayTest.class, () -> {
         return new DisplayTest(() -> {
            return "";
         }, (a, b) -> {
            return true;
         });
      });
   }
}
