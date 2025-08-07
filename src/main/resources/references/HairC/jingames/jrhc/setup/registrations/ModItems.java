package jingames.jrhc.setup.registrations;

import jingames.jrhc.items.ItemBarberSnC;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
   public static final DeferredRegister<CreativeModeTab> TABS;
   public static final DeferredRegister<Item> ITEMS;
   public static final RegistryObject<Item> ITEMBARBERSNC;
   public static final RegistryObject<CreativeModeTab> TAB;

   public static ResourceKey<Item> createKey(String p_311525_) {
      return ResourceKey.create(Registries.ITEM, ResourceLocation.tryBuild("jrhc", p_311525_));
   }

   static {
      TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "jrhc");
      ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jrhc");
      ITEMBARBERSNC = ITEMS.register("itembarbersnc", () -> {
         return new ItemBarberSnC(20, 10.0F, true, (new Properties()).stacksTo(1).setId(createKey("itembarbersnc")));
      });
      TAB = TABS.register("jrhc", () -> {
         return CreativeModeTab.builder().title(Component.translatable("itemGroup.jrhc")).withTabsBefore(new ResourceKey[]{CreativeModeTabs.SPAWN_EGGS}).icon(() -> {
            return ((Item)ITEMBARBERSNC.get()).getDefaultInstance();
         }).displayItems((parameters, output) -> {
            output.accept((ItemLike)ITEMBARBERSNC.get());
         }).build();
      });
   }
}
