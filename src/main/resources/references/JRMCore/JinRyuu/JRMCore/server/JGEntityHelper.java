package JinRyuu.JRMCore.server;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreM;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class JGEntityHelper {
   public static void spawcha(EntityPlayer p, World w, String n, String h, String a, String m, String pr, double x, double y, double z, int g) {
      EntityLivingBase e = (EntityLivingBase)EntityList.func_75620_a(n, w);
      if (e != null) {
         e.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
         setAttributes(e, h, a, m, pr, g);
         if (JRMCoreH.DBC()) {
            JRMCoreHDBC.ifEvilDBCnpcs(e, (EntityPlayer)p);
         }

         w.func_72838_d(e);
      }

   }

   public static void setAttributes(EntityLivingBase e, String health, String damage, String multi, String pr, int groupMulti) {
      if (e != null) {
         NBTTagCompound nbt = JRMCoreH.nbt((Entity)e);
         if (!pr.equals("") && pr.length() > 0) {
            nbt.func_74778_a("jrmcSpawnInitiatedIMP", pr);
         }

         double newHealth;
         if (!damage.equals("") && damage.length() > 0) {
            newHealth = Double.parseDouble(damage) * (double)JRMCoreM.gm(groupMulti);
            nbt.func_74780_a("jrmcSpawnInitiatedCAT", newHealth);
         }

         if (!health.equals("") && health.length() > 0) {
            newHealth = Double.parseDouble(health) * (double)JRMCoreM.gm(groupMulti);
            nbt.func_74780_a("jrmcSpawnInitiatedCHP", newHealth);
         }

         if (!multi.equals("") && multi.length() > 0) {
            nbt.func_74778_a("jrmcSpawnInitiatedCMT", multi);
         }
      }

   }
}
