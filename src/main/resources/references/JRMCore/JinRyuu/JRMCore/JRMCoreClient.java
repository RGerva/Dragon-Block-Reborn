package JinRyuu.JRMCore;

import JinRyuu.JRMCore.client.JGRecipeHandler;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntitiesJRMC;
import JinRyuu.JRMCore.entity.EntityCusPar;
import JinRyuu.JRMCore.items.GiTurtleMdl;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class JRMCoreClient extends JRMCore {
   public static Minecraft mc = Minecraft.func_71410_x();
   static JRMCoreGui JFCGui;
   public static JRMCoreGuiBars bars;
   public static JRMCorePacHanC phc = new JRMCorePacHanC();
   @SideOnly(Side.CLIENT)
   public static final ModelBiped armor1 = new GiTurtleMdl(0.205F);
   @SideOnly(Side.CLIENT)
   public static final ModelBiped armor2 = new GiTurtleMdl(0.11F);

   public void initialize() {
      super.initialize();
      FMLCommonHandler.instance().bus().register(new JRMCoreCliTicH(mc));
   }

   public void postInit() {
      super.postInit();
      JRMCoreA.actionInit();
      JGRecipeHandler.registerRecipes();
   }

   public void registerRenderThings() {
      JFCGui = new JRMCoreGui();
      bars = new JRMCoreGuiBars();
      EntitiesJRMC.client();
   }

   public void registerKeys() {
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.DS);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.Fn);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.actionMenu);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiCharge);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiAscend);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiDescend);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiDash);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.lockOn);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiFlight);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.Sagasys);
      ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.infopanel);
   }

   public void registerTicks() {
   }

   public EntityPlayer getPlayerEntity(MessageContext ctx) {
      return (EntityPlayer)(ctx.side.isClient() ? mc.player : super.getPlayerEntity(ctx));
   }

   public EntityPlayer getPlayerEntity() {
      return mc.player;
   }

   public EntityPlayer getPlayerClient() {
      return mc.player;
   }

   public void generateDamIndParticles(double x, double y, double z, double amount, float timeleft) {
      double motionX = this.getPlayerClient().world.field_73012_v.nextGaussian() * 0.02D;
      double motionY = this.getPlayerClient().world.field_73012_v.nextGaussian() * 0.02D;
      double motionZ = this.getPlayerClient().world.field_73012_v.nextGaussian() * 0.02D;
      EntityFX particleMysterious = new JRMCoreDamInd(amount, timeleft, this.getPlayerClient().world, x, y, z, 0.0D, 0.0D, 0.0D);
      mc.field_71452_i.func_78873_a(particleMysterious);
   }

   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(e.getdata3(), entity.world, e.field_70131_O, e.field_70130_N, entity.posX + poX, entity.posY + poY, entity.posZ + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * (double)e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5(), e.getdata6(), e.getdata7(), e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, (Entity)null);
         entity.world.func_72838_d(p);
      }

   }

   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(e.getdata3(), entity.world, e.field_70131_O, e.field_70130_N, entity.posX + poX, entity.posY + poY, entity.posZ + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * (double)e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, (Entity)null);
         entity.world.func_72838_d(p);
      }

   }

   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed, float motion) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(e.getdata3(), entity.world, e.field_70131_O, e.field_70130_N, entity.posX + poX, entity.posY + poY, entity.posZ + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, motion, (int)(Math.random() * (double)e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, (Entity)null);
         entity.world.func_72838_d(p);
      }

   }

   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed, float motion, int death) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(e.getdata3(), entity.world, e.field_70131_O, e.field_70130_N, entity.posX + poX, entity.posY + poY, entity.posZ + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, motion, (int)(Math.random() * (double)e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), death, e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, (Entity)null);
         entity.world.func_72838_d(p);
      }

   }

   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, int img_s) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(e.getdata3(), entity.world, e.field_70131_O, e.field_70130_N, entity.posX + poX, entity.posY + poY, entity.posZ + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * (double)e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), img_s, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5(), e.getdata6(), e.getdata7(), e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, (Entity)null);
         entity.world.func_72838_d(p);
      }

   }

   public void func_gcp(String data3, World w, float box1, float box2, double poX, double poY, double poZ, double start_poX, double start_poY, double start_poZ, double moX, double moY, double moZ, float data29, int id, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, boolean rotate2, float max_rotation_sp2, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25, boolean data33, int data34, boolean data35, Entity ent) {
      for(int i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(data3, w, box1, box2, poX, poY, poZ, start_poX, start_poY, start_poZ, moX, moY, moZ, data29, id, id_min, id_max, data32, rotate, max_rotation_sp, rotate2, max_rotation_sp2, data1, rr, data2, data4, data5, data6, data7, data31, data8, data9, data10, data11, data12, data13, data14, data15, data16, data20, data21, data22, data23, data24, data25, data33, data34, data35, ent);
         w.func_72838_d(p);
      }

   }

   public void func_gcp(String data3, World w, float box1, float box2, double poX, double poY, double poZ, double start_poX, double start_poY, double start_poZ, double moX, double moY, double moZ, float data29, int id, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, boolean rotate2, float max_rotation_sp2, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25, boolean data33, int data34, boolean data35) {
      boolean found = false;
      Entity base = null;
      double minx = poX - 1.0D;
      double miny = poY - 1.0D;
      double minz = poZ - 1.0D;
      double maxx = minx + 2.0D;
      double maxy = miny + 2.0D;
      double maxz = minz + 2.0D;
      List var6 = w.func_72839_b((Entity)null, AxisAlignedBB.func_72330_a(minx, miny, minz, maxx, maxy, maxz));
      Entity var10 = null;

      int i;
      for(i = 0; i < var6.size(); ++i) {
         var10 = (Entity)var6.get(i);
         if (var10 instanceof EntityLivingBase && var10.func_70067_L()) {
            found = true;
            break;
         }
      }

      if (found) {
         base = (EntityLivingBase)var10;
      }

      for(i = 0; i < JGConfigClientSettings.get_da1(); ++i) {
         Entity p = new EntityCusPar(data3, w, box1, box2, found ? base.posX : poX, found ? base.posY + (double)(base instanceof EntityPlayerSP ? -1.6F : 0.0F) : poY, found ? base.posZ : poZ, start_poX, start_poY, start_poZ, moX, moY, moZ, data29, id, id_min, id_max, data32, rotate, max_rotation_sp, rotate2, max_rotation_sp2, data1, rr, data2, data4, data5, data6, data7, data31, data8, data9, data10, data11, data12, data13, data14, data15, data16, data20, data21, data22, data23, data24, data25, data33, data34, data35, base);
         w.func_72838_d(p);
      }

   }
}
