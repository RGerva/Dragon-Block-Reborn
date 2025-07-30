package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComSkill extends CommandBase {
   public String func_71517_b() {
      return "dbcskill";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] stringArray) {
      if (stringArray.length < 2) {
         throw new WrongUsageException(this.func_71518_a(par1ICommandSender), new Object[0]);
      } else {
         String s = stringArray[0];
         boolean give = s.toLowerCase().contentEquals("give");
         boolean givelvl = s.toLowerCase().contentEquals("givelvl");
         boolean take = s.toLowerCase().contentEquals("take");
         boolean all = stringArray[1].toLowerCase().contentEquals("all");
         int id = -1;
         if (!all) {
            for(int i = 0; i < JRMCoreH.DBCSkillNames.length; ++i) {
               if (stringArray[1].toLowerCase().equals(JRMCoreH.DBCSkillNames[i].toLowerCase())) {
                  id = i;
                  break;
               }
            }
         }

         EntityPlayerMP entityplayermp;
         if (stringArray.length > (givelvl ? 3 : 2)) {
            entityplayermp = func_82359_c(par1ICommandSender, stringArray[givelvl ? 3 : 2]);
         } else {
            entityplayermp = func_71521_c(par1ICommandSender);
         }

         String entitycommansender = "Console";

         try {
            EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
            entitycommansender = commansender.func_70005_c_();
         } catch (Exception var32) {
         }

         boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComANAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComANAS : JRMCoreConfig.ComANAO);
         NBTTagCompound nbt = JRMCoreH.nbt(entityplayermp, "pres");
         int pwrtyp = JRMCoreH.getByte(entityplayermp, "jrmcPwrtyp");
         int rc = JRMCoreH.getByte(entityplayermp, "jrmcRace");
         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(entityplayermp);
         String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
         int PlyrSkills_Amount = PlyrSkills.length;
         String[] skls = JRMCoreH.DBCSkillsIDs;
         String[] sklsNms = JRMCoreH.DBCSkillNames;
         String t;
         ChatStyle color;
         if (id < 0 && !all) {
            t = JRMCoreH.trlai("jrmc", "skillnameinvalid");
            color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
            entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
         } else {
            String skl;
            String sn2;
            if (give || givelvl) {
               boolean stop = false;
               byte i;
               boolean have;
               boolean ne;
               int lv;
               int slv;
               int lv;
               String t;
               boolean po;
               if (all && givelvl) {
                  for(i = 0; i < JRMCoreH.DBCSkillNames.length; ++i) {
                     for(int j = 0; j < PlyrSkills_Amount; ++j) {
                        if (PlyrSkills[j].contains(skls[i])) {
                           ne = stringArray[2].contains("+");
                           po = stringArray[2].contains("-");
                           slv = Integer.parseInt(stringArray[2]);
                           lv = JRMCoreH.SklLvl(j, 1, PlyrSkills) - 1;
                           int re = !ne && !po ? slv - 1 : lv + slv;
                           re = re > 9 ? 9 : (re < 0 ? 0 : re);
                           t = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[j], skls[i] + re));
                           nbt.func_74778_a("jrmcSSlts", t);
                           String t = JRMCoreH.trlai("jrmc", "skillupped");
                           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[]{sklsNms[i], re + 1})).func_150255_a(color));
                           if (n) {
                              this.notifyAdmins(par1ICommandSender, "%s has upgraded skill %s to lvl %s", new Object[]{entityplayermp.func_70005_c_(), sklsNms[i], re + 1});
                           }
                        }
                     }
                  }
               } else if (id >= 0) {
                  for(i = 0; i < PlyrSkills_Amount; ++i) {
                     if (PlyrSkills[i].contains(skls[id])) {
                        stop = true;
                        if (stop && givelvl) {
                           have = stringArray[2].contains("+");
                           ne = stringArray[2].contains("-");
                           lv = Integer.parseInt(stringArray[2]);
                           slv = JRMCoreH.SklLvl(id, 1, PlyrSkills) - 1;
                           lv = !have && !ne ? lv - 1 : slv + lv;
                           lv = lv > 9 ? 9 : (lv < 0 ? 0 : lv);
                           String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[i], skls[id] + lv));
                           nbt.func_74778_a("jrmcSSlts", sn2);
                           t = JRMCoreH.trlai("jrmc", "skillupped");
                           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[]{sklsNms[id], lv + 1})).func_150255_a(color));
                           if (n) {
                              this.notifyAdmins(par1ICommandSender, "%s has upgraded skill %s to lvl %s", new Object[]{entityplayermp.func_70005_c_(), sklsNms[id], lv + 1});
                           }

                           return;
                        }
                     }
                  }
               }

               if (stop) {
                  sn2 = JRMCoreH.trlai("jrmc", "alreadyhaveskill");
                  ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                  entityplayermp.func_145747_a((new ChatComponentTranslation(sn2, new Object[0])).func_150255_a(color));
                  if (n) {
                     this.notifyAdmins(par1ICommandSender, "%s already has skill %s", new Object[]{entityplayermp.func_70005_c_(), sklsNms[id]});
                  }
               } else {
                  PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
                  PlyrSkills_Amount = PlyrSkills.length;
                  if (all) {
                     for(i = 0; i < JRMCoreH.DBCSkillNames.length; ++i) {
                        have = false;

                        int re;
                        for(re = 0; re < PlyrSkills_Amount; ++re) {
                           if (PlyrSkills[re].contains(skls[i])) {
                              have = true;
                           }
                        }

                        if (!have) {
                           re = 0;
                           if (givelvl) {
                              po = stringArray[2].contains("+");
                              boolean ne = stringArray[2].contains("-");
                              lv = Integer.parseInt(stringArray[2]);
                              int slv = 0;
                              re = !po && !ne ? lv - 1 : slv + lv;
                              re = re > 9 ? 9 : (re < 0 ? 0 : re);
                           }

                           nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[i] + re));
                           String t = JRMCoreH.trlai("jrmc", "skilladded");
                           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[]{sklsNms[i]})).func_150255_a(color));
                           if (n) {
                              this.notifyAdmins(par1ICommandSender, "%s has received skill %s to lvl %s", new Object[]{entityplayermp.func_70005_c_(), sklsNms[i], re + 1});
                           }
                        }
                     }
                  } else {
                     int re = 0;
                     if (givelvl) {
                        have = stringArray[2].contains("+");
                        ne = stringArray[2].contains("-");
                        lv = Integer.parseInt(stringArray[2]);
                        int slv = 0;
                        re = !have && !ne ? lv - 1 : slv + lv;
                        re = re > 9 ? 9 : (re < 0 ? 0 : re);
                     }

                     nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[id] + re));
                     skl = JRMCoreH.trlai("jrmc", "skilladded");
                     ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                     entityplayermp.func_145747_a((new ChatComponentTranslation(skl, new Object[]{sklsNms[id]})).func_150255_a(color));
                     if (n) {
                        this.notifyAdmins(par1ICommandSender, "%s has received skill %s to lvl %s", new Object[]{entityplayermp.func_70005_c_(), sklsNms[id], re + 1});
                     }
                  }
               }
            }

            if (take) {
               if (id >= 0) {
                  for(byte i = 0; i < PlyrSkills_Amount; ++i) {
                     if (PlyrSkills[i].contains(skls[id])) {
                        if (id == 8) {
                           JRMCoreH.PlyrSettingsRem(nbt, 0);
                        }

                        if (id == 16) {
                           JRMCoreH.PlyrSettingsRem(nbt, 11);
                        }

                        if (id == 18) {
                           JRMCoreH.PlyrSettingsRem(nbt, 16);
                        }

                        sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[i], ""));
                        nbt.func_74778_a("jrmcSSlts", sn2.length() < 3 ? "," : sn2);
                        skl = sklsNms[id];
                        String t = "Skill " + skl + " removed";
                        ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                        entityplayermp.func_145747_a((new ChatComponentText(t)).func_150255_a(color));
                        if (n) {
                           this.notifyAdmins(par1ICommandSender, "%s's skill %s has been removed!", new Object[]{entityplayermp.func_70005_c_(), skl});
                        }
                     }
                  }
               } else {
                  nbt.func_74778_a("jrmcSSlts", ",");
                  t = JRMCoreH.trlai("jrmc", "skillallremoved");
                  color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                  entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
                  if (n) {
                     this.notifyAdmins(par1ICommandSender, "%s's all skill has been removed!", new Object[]{entityplayermp.func_70005_c_()});
                  }
               }
            }
         }

      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }

   public String getSkillList() {
      String list = "";

      for(int i = 0; i < JRMCoreH.DBCSkillNames.length; ++i) {
         list = list + ", " + JRMCoreH.DBCSkillNames[i];
      }

      return list;
   }

   public String func_71518_a(ICommandSender icommandsender) {
      String list = this.getSkillList();
      return "/dbcskill (give or take) (skillName) [playerName] OR /dbcskill take all [playerName] OR /dbcskill givelvl (skillName) (lvl 1-10) [playerName] --> skillNames can be: " + list;
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] arrayString) {
      int length = arrayString.length;
      switch(length) {
      case 1:
         return func_71530_a(arrayString, new String[]{"give", "take", "givelvl"});
      case 2:
         return func_71530_a(arrayString, this.getSkillList().split(", "));
      case 3:
         return func_71530_a(arrayString, arrayString[0].equals("givelvl") ? new String[]{"1"} : this.getListOfPlayers());
      case 4:
         return arrayString[0].equals("givelvl") ? func_71530_a(arrayString, this.getListOfPlayers()) : null;
      default:
         return null;
      }
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean isUsernameIndex(int id) {
      return id == 0;
   }
}
