package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class ComDbcSpawnKi extends CommandBase {
   final String line = "Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.";

   public String func_71517_b() {
      return "dbcspawnki";
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.";
   }

   public int func_82362_a() {
      return 2;
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return true;
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length < 10) {
         throw new WrongUsageException("Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.", new Object[0]);
      } else {
         boolean spawn = true;
         boolean found = false;
         Object entityplayermp;
         if (par2ArrayOfStr.length == 11) {
            double minx = Double.parseDouble(par2ArrayOfStr[8]) - 1.0D;
            double miny = Double.parseDouble(par2ArrayOfStr[9]) - 1.0D;
            double minz = Double.parseDouble(par2ArrayOfStr[10]) - 1.0D;
            double maxx = minx + 2.0D;
            double maxy = miny + 2.0D;
            double maxz = minz + 2.0D;
            List var6 = par1ICommandSender.func_130014_f_().func_72839_b((Entity)null, AxisAlignedBB.func_72330_a(minx, miny, minz, maxx, maxy, maxz));
            Entity var10 = null;

            for(int var9 = 0; var9 < var6.size(); ++var9) {
               var10 = (Entity)var6.get(var9);
               if (var10 instanceof EntityLivingBase && var10.func_70067_L()) {
                  found = true;
                  break;
               }
            }

            if (found) {
               entityplayermp = (EntityLivingBase)var10;
            } else {
               entityplayermp = null;
            }
         } else {
            if (par2ArrayOfStr.length != 12) {
               return;
            }

            entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[11]);
            spawn = true;
            found = true;
         }

         EntityEnergyAtt mr = null;
         boolean spawned = false;
         if (spawn && found && entityplayermp != null) {
            byte type = Byte.parseByte(par2ArrayOfStr[0]);
            if (JRMCoreConfig.dat5695[type]) {
               if (type < 0) {
                  type = 0;
               }

               if (type > 8) {
                  type = 8;
               }

               byte speed = Byte.parseByte(par2ArrayOfStr[1]);
               if (speed < 0) {
                  speed = 0;
               }

               int dam1 = Integer.parseInt(par2ArrayOfStr[2]);
               if (dam1 < 0) {
                  dam1 = 0;
               }

               byte effect = Byte.parseByte(par2ArrayOfStr[3]);
               if (effect < 0) {
                  effect = 0;
               }

               if (effect > 1) {
                  effect = 1;
               }

               byte color = Byte.parseByte(par2ArrayOfStr[4]);
               if (color < 0) {
                  color = 0;
               }

               if (color > JRMCoreH.techCol.length - 1) {
                  color = (byte)(JRMCoreH.techCol.length - 1);
               }

               byte density = Byte.parseByte(par2ArrayOfStr[5]);
               if (density < 0) {
                  density = 0;
               }

               byte sndMv = Byte.parseByte(par2ArrayOfStr[6]);
               if (sndMv < 0) {
                  sndMv = 0;
               }

               if (sndMv > 1) {
                  sndMv = 1;
               }

               byte chrg = Byte.parseByte(par2ArrayOfStr[7]);
               if (chrg < 0) {
                  chrg = 0;
               }

               if (chrg > 100) {
                  chrg = 100;
               }

               byte[] sts = JRMCoreH.techDBCstatsDefault;
               ((EntityLivingBase)entityplayermp).field_70170_p.func_72956_a((Entity)entityplayermp, "jinryuudragonbc:DBC2.basicbeam_fire", 0.5F, 1.0F);
               mr = new EntityEnergyAtt((EntityLivingBase)entityplayermp, type, speed, 50, effect, color, density, (byte)0, (byte)0, sndMv, chrg, dam1, 0, sts, (byte)0);
               ((EntityLivingBase)entityplayermp).field_70170_p.func_72838_d(mr);
               spawned = true;
            }
         }

      }
   }
}
