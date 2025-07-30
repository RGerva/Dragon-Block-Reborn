package JinRyuu.JRMCore;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class ComJrmc extends CommandBase {
   public String func_71517_b() {
      return "jrmc";
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "Use '/jrmc startnew' to Start from the begining, resetting attributes and character look.and Use '/dbc accept' to accept offers like revive with teleport.";
   }

   public int func_82362_a() {
      return 0;
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return true;
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
      if (stringArray.length <= 0) {
         throw new WrongUsageException(this.func_71518_a(commandSender), new Object[0]);
      } else {
         EntityPlayerMP entityplayermp;
         if (stringArray.length > 1) {
            entityplayermp = func_82359_c(commandSender, stringArray[1]);
         } else {
            entityplayermp = func_71521_c(commandSender);
         }

         int pwrtyp = JRMCoreH.getByte(entityplayermp, "jrmcPwrtyp");
         String s = stringArray[0];
         boolean startnew = s.toLowerCase().contains("startnew");
         boolean heal = false;
         boolean accept = s.toLowerCase().contains("accept");
         boolean decline = s.toLowerCase().contains("decline");
         if (entityplayermp != null && JRMCoreConfig.osbic > 0 && (Integer)JRMCoreH.osbic.get(entityplayermp.func_70005_c_()) < JRMCoreConfig.osbic * 20) {
            entityplayermp.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((float)(JRMCoreConfig.osbic * 20 - (Integer)JRMCoreH.osbic.get(entityplayermp.func_70005_c_())) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
         } else {
            if (startnew) {
               if (JRMCoreH.DBC()) {
                  if (!JRMCoreH.isFused(entityplayermp)) {
                     JRMCoreH.resetChar(entityplayermp);
                     this.notifyAdmins(commandSender, "Resetting attributes and character look has been processed.", new Object[]{entityplayermp.func_70005_c_()});
                  } else {
                     this.notifyAdmins(commandSender, "Unable to reset attributes and character look while fused.", new Object[]{entityplayermp.func_70005_c_()});
                  }
               }
            } else if (!accept && !decline) {
               entityplayermp.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "typedWrong"), new Object[0])).func_150255_a(JRMCoreH2.styl_red));
            } else {
               MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
               EntityPlayerMP p = entityplayermp;
               String toteach1 = JRMCoreH.getString(entityplayermp, "jrmcTechLearn");
               if (toteach1.contains(";:;")) {
                  String[] toteach = toteach1.split(";:;");
                  String[] tn = toteach[0].split(";");
                  EntityPlayer teacher = JRMCoreH.getPlayerForUsername(server, toteach[1]);
                  if (teacher != null && entityplayermp.func_70032_d(teacher) < 8.0F && accept) {
                     if (pwrtyp == 1) {
                        int b = 0;
                        boolean may = false;

                        int costTp;
                        for(costTp = 0; costTp < 4; ++costTp) {
                           String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[costTp]);
                           if (!s1.contains(";")) {
                              b = costTp;
                              may = true;
                              break;
                           }

                           may = false;
                        }

                        if (may) {
                           costTp = JRMCoreH.techDBCtpc(tn, true) * 2;
                           int tp = JRMCoreH.getInt(p, "jrmcTpint");
                           if (tp - costTp >= 0) {
                              JRMCoreH.setInt((int)(tp - costTp), p, "jrmcTpint");
                              JRMCoreH.setString(toteach[0], p, JRMCoreH.techNbt[b]);
                              teacher.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfferAccepted"), new Object[]{p.func_70005_c_(), tn[0]})).func_150255_a(JRMCoreH2.styl_ylw));
                              p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "techadded"), new Object[]{tn[0]})).func_150255_a(JRMCoreH2.styl_ylw));
                           } else {
                              p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "notenoughtp"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
                           }
                        } else {
                           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noslotleft"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
                        }
                     }
                  } else if (toteach1.contains(";:;") && decline) {
                     JRMCoreH.setString(" ", entityplayermp, "jrmcTechLearn");
                     entityplayermp.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfDeclByYou"), new Object[]{toteach[1], tn[0]})).func_150255_a(JRMCoreH2.styl_ylw));
                     if (teacher != null) {
                        teacher.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfDeclByPlayr"), new Object[]{entityplayermp.func_70005_c_()})).func_150255_a(JRMCoreH2.styl_ylw));
                     }
                  } else {
                     JRMCoreH.setString(" ", entityplayermp, "jrmcTechLearn");
                     entityplayermp.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfferDeclined"), new Object[]{toteach[1], tn[0]})).func_150255_a(JRMCoreH2.styl_ylw));
                  }
               } else {
                  entityplayermp.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nothingtoaccept"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
               }
            }

         }
      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }
}
