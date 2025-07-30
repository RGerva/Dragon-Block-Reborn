package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Gui.DBCKiGui;
import JinRyuu.DragonBC.common.Gui.DBCSAAGui;
import JinRyuu.DragonBC.common.Gui.DBCSagaGui;
import JinRyuu.DragonBC.common.Gui.DBCWishGui;
import JinRyuu.DragonBC.common.Gui.ScouterGui;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntitiesDBC;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class DBCClient extends DBC {
   public static ScouterGui scouterGui;
   public static DBCSagaGui SagaSys;
   public static DBCKiGui KiGui;
   public static DBCWishGui WishGui;
   public static DBCSAAGui SAAGui;
   public static Minecraft mc = Minecraft.func_71410_x();
   public static DBCPacketHandlerClient phc = new DBCPacketHandlerClient();

   public void initialize() {
      super.initialize();
      FMLCommonHandler.instance().bus().register(new DBCClientTickHandler());
   }

   public void postInit() {
      super.postInit();
   }

   public void registerRenderThings() {
      scouterGui = new ScouterGui();
      SagaSys = new DBCSagaGui();
      KiGui = new DBCKiGui(0);
      WishGui = new DBCWishGui(0);
      SAAGui = new DBCSAAGui(2);
      ItemsDBC.client();
      EntitiesDBC.client();
   }

   public void registerKeys() {
      ClientRegistry.registerKeyBinding(DBCKeyHandler.ScFunc);
      ClientRegistry.registerKeyBinding(DBCKeyHandler.thirdFn);
   }

   public void registerTicks() {
   }

   public File getMinecraftDir() {
      return Minecraft.func_71410_x().field_71412_D;
   }
}
