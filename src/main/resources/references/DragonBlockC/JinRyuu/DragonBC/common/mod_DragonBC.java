package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Gui.ComDbc;
import JinRyuu.DragonBC.common.Gui.ComDbcSpawn;
import JinRyuu.DragonBC.common.Gui.ComDbcSpawnKi;
import JinRyuu.DragonBC.common.Gui.ComReincarnate;
import JinRyuu.DragonBC.common.Gui.ComRespCon;
import JinRyuu.DragonBC.common.Gui.ComRevive;
import JinRyuu.DragonBC.common.Gui.ComSkill;
import JinRyuu.DragonBC.common.Gui.ComStrain;
import JinRyuu.DragonBC.common.Gui.DBCGuiHandler;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntitiesDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
import JinRyuu.DragonBC.common.Worlds.x0WorldProviderNamek;
import JinRyuu.DragonBC.common.Worlds.x1WorldProviderOW;
import JinRyuu.DragonBC.common.Worlds.x2WorldProviderTC;
import JinRyuu.DragonBC.common.Worlds.x3WorldProviderVegeta;
import JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm.x2WorldProviderNullRealm;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
   modid = "jinryuudragonblockc",
   name = "Dragon Block C",
   version = "1.4.85",
   dependencies = "required-after:jinryuujrmcore"
)
public class mod_DragonBC {
   public static final String MOD = "Dragon Block C";
   public static CreativeTabs DragonBlockC = new DBCTab("DragonBlockC");
   @SidedProxy(
      clientSide = "JinRyuu.DragonBC.common.DBCClient",
      serverSide = "JinRyuu.DragonBC.common.DBC"
   )
   public static DBC proxy;
   @Instance("mod_DragonBC")
   public static mod_DragonBC instance = new mod_DragonBC();
   private DBCGuiHandler guiHandler = new DBCGuiHandler();
   public static boolean DeathSystemOff = false;
   public static int DBSpawnChance = 4;
   public static boolean DBSpawnEnabled = true;
   public static String DBSpawnTime = "daytime";
   public static boolean SagaSystemOn = true;
   public static boolean SagaSysSpawnPods = true;
   public static boolean cDeathSystemOff = false;
   public static int cDBSpawnChance = 4;
   public static boolean cDBSpawnEnabled = true;
   public static String cDBSpawnTime = "daytime";
   public static boolean cSagaSystemOn = true;
   public static boolean cSagaSysSpawnPods = true;
   public static int cwfb = 0;
   public static int chfb = 0;
   public static int cwfn = 0;
   public static int chfn = 0;
   public static boolean ConsSizeChangeOn = true;
   public static boolean TransSizeChangeOn = true;
   public static Properties runtimeIdProperties = new Properties();
   public static Logger logger;

   private String getVersion() {
      return "1.4.85";
   }

   public static DamageSource causePrjctlsDamage(EntityPrjtls_1 entityEnergyAtt, Entity par1Entity) {
      return (new EntityDamageSourceIndirect("dbcprojectile_1", entityEnergyAtt, par1Entity)).func_76349_b();
   }

   public static DamageSource causeEntityEnergyAttDamage(EntityEnergyAtt entityEnergyAtt, Entity par1Entity) {
      return (new EntityDamageSourceIndirect("Energy Attack", entityEnergyAtt, par1Entity)).func_76349_b();
   }

   @EventHandler
   public void ServerStarting(FMLServerStartingEvent event) {
      ServerCommandManager manager = (ServerCommandManager)event.getServer().func_71187_D();
      manager.func_71560_a(new ComRespCon());
      manager.func_71560_a(new ComDbc());
      manager.func_71560_a(new ComDbcSpawn());
      manager.func_71560_a(new ComRevive());
      manager.func_71560_a(new ComSkill());
      manager.func_71560_a(new ComStrain());
      manager.func_71560_a(new ComReincarnate());
      manager.func_71560_a(new ComDbcSpawnKi());
   }

   private void modMeta(FMLPreInitializationEvent event) {
      ModMetadata meta = event.getModMetadata();
      meta.name = "Dragon Block C";
      meta.description = "A Dragon Ball mod for Minecraft.";
      meta.authorList.clear();
      meta.authorList.add("JinRyuu Nagy");
      meta.modId = "jinryuudragonblockc";
      meta.version = "1.4.85";
      meta.autogenerated = false;
   }

   @EventHandler
   public void PreLoad(FMLPreInitializationEvent event) {
      this.modMeta(event);
      logger = event.getModLog();
      logger.info("Current Version " + this.getVersion());
      logger.info("Copyright (c) Tamas 'JinRyuu' Nagy,  2012-2018");
      logger.info("Copyright (c) Benjamin 'JinGames_Ben' Nagy,  2018-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
      logger.info("https://jingames.net");
      Configuration config = new Configuration(event.getSuggestedConfigurationFile());
      DBCConfig.init(config);
      proxy.registerKeys();
      proxy.registerTicks();
      proxy.registerDBCRender();
      proxy.initialize();
      logger.info("Pre Initialization Complated");
      instance = this;
   }

   @EventHandler
   public void load(FMLInitializationEvent event) {
      BlocksDBC.init();
      BlocksDBC.register();
      ItemsDBC.init();
      RecipesDBC.init();
      DBCEH events = new DBCEH();
      MinecraftForge.EVENT_BUS.register(events);
      FMLCommonHandler.instance().bus().register(events);
      GameRegistry.registerFuelHandler(new DBCHandlerFuel());
      FluidContainerRegistry.registerFluidContainer(BlocksDBC.medicalLiquid, new ItemStack(ItemsDBC.ItemBucketMedLiq), new ItemStack(Items.field_151133_ar));
      DBCHandlerBucket.INSTANCE.buckets.put(BlocksDBC.BlockHealingPods, ItemsDBC.ItemBucketMedLiq);
      MinecraftForge.EVENT_BUS.register(DBCHandlerBucket.INSTANCE);
      BiomeGenBaseDBC.init();
      GameRegistry.registerWorldGenerator(new WorldGeneratorDB(), 0);
      DimensionManager.registerProviderType(DBCConfig.planetNamek, x0WorldProviderNamek.class, true);
      DimensionManager.registerDimension(DBCConfig.planetNamek, DBCConfig.planetNamek);
      Side side = event.getSide();
      if (side == Side.CLIENT || DBCConfig.plntVegeta) {
         DimensionManager.registerProviderType(DBCConfig.planetVegeta, x3WorldProviderVegeta.class, true);
         DimensionManager.registerDimension(DBCConfig.planetVegeta, DBCConfig.planetVegeta);
      }

      int dimID = DBCConfig.otherWorld;
      DimensionManager.registerProviderType(dimID, x1WorldProviderOW.class, true);
      DimensionManager.registerDimension(dimID, dimID);
      dimID = DBCConfig.dimTimeChamber;
      DimensionManager.registerProviderType(dimID, x2WorldProviderTC.class, true);
      DimensionManager.registerDimension(dimID, dimID);
      dimID = DBCConfig.dimNullRealm;
      DimensionManager.registerProviderType(dimID, x2WorldProviderNullRealm.class, true);
      DimensionManager.registerDimension(dimID, dimID);
      Lang.init();
      logger.info("Initialization Completed");
      EntitiesDBC.common();
      logger.info(" Entities Loaded!");
      NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
      proxy.registerRenderThings();
   }

   @EventHandler
   public void PostLoad(FMLPostInitializationEvent event) {
      proxy.postInit();
      logger.info("Fully Loaded!");
      logger.info("Have a good game!");
      logger.info("Fight For Your Life ^^");
   }
}
