package JinRyuu.JRMCore;

import java.util.HashMap;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComJrmcCheck extends CommandBase {
   public static HashMap<String, Object[]> SList = new HashMap();

   public String func_71517_b() {
      return "jrmccheck";
   }

   public int func_82362_a() {
      return 1;
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "Usage: '/jrmccheck sheet [playerName]' to view players character sheet.";
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return true;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length <= 0) {
         throw new WrongUsageException(this.func_71518_a(par1ICommandSender), new Object[0]);
      } else {
         String entitycommansenderName = "Console";

         EntityPlayerMP entitycommansender;
         try {
            entitycommansender = func_71521_c(par1ICommandSender);
            entitycommansenderName = entitycommansender.getName();
         } catch (Exception var24) {
         }

         if (entitycommansenderName.equals("Console")) {
            mod_JRMCore.logger.info("This command can't be run from Console");
         } else {
            entitycommansender = func_71521_c(par1ICommandSender);
            EntityPlayerMP entityplayermp = entitycommansender;
            boolean sheet = false;
            if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("sheet")) {
               sheet = true;
            }

            if (par2ArrayOfStr.length > 1) {
               if (!JRMCoreConfig.JRMCCheckOnOthersWithoutOP && entitycommansender != null && !entitycommansenderName.equals("Console") && !par2ArrayOfStr[1].equals(entitycommansenderName)) {
                  sheet = false;
                  ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
                  entitycommansender.func_145747_a((new ChatComponentText("JRMCCheck - Non OP Players can check other Player's Sheet is DISABLED!")).func_150255_a(color));
               }

               entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
            }

            NBTTagCompound nbt = JRMCoreH.nbt(entityplayermp, "pres");
            ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
            ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
            if (sheet) {
               int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(entityplayermp);
               byte rc = nbt.func_74771_c("jrmcRace");
               byte pwr = nbt.func_74771_c("jrmcPwrtyp");
               byte Cls = nbt.func_74771_c("jrmcClass");
               byte rls = JRMCoreH.getByte(entityplayermp, "jrmcRelease");
               int ac = nbt.func_74762_e("jrmcAlCntr");
               byte alive = nbt.func_74771_c("jrmcAlv");
               int Diff = JRMCoreH.getByte(entityplayermp, "jrmcDiff");
               int Align = JRMCoreH.getByte(entityplayermp, "jrmcAlign");
               int TPint = JRMCoreH.getInt(entityplayermp, "jrmcTpint");
               String[] pw = new String[]{"NotSelected", "DBC", "NC", "SAO"};
               entitycommansender.func_145747_a((new ChatComponentText(entityplayermp.getDisplayName() + "'s Character Sheet")).func_150255_a(colorG));
               entitycommansender.func_145747_a((new ChatComponentText("Level: " + JRMCoreH.getPlayerLevel(PlyrAttrbts))).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Power User: " + pw[pwr])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Race: " + JRMCoreH.Races[rc])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Class: " + JRMCoreH.cl(pwr)[Cls])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Training Points: " + TPint)).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Power Release: " + rls + "%")).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("STR: " + PlyrAttrbts[0])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("DEX: " + PlyrAttrbts[1])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("CON: " + PlyrAttrbts[2])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("WIL: " + PlyrAttrbts[3])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("MND: " + PlyrAttrbts[4])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("SPI: " + PlyrAttrbts[5])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Status: " + (alive == 0 ? "Alive" : "Dead"))).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Difficulty: " + JRMCoreH.DifficultyNames[Diff])).func_150255_a(color));
               entitycommansender.func_145747_a((new ChatComponentText("Alignment: " + JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(Align)])).func_150255_a(color));
               String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");

               for(byte j = 0; j < PlyrSkills.length; ++j) {
                  String skl = PlyrSkills[j];
                  if (skl.length() > 2) {
                     entitycommansender.func_145747_a((new ChatComponentText("Skill: lvl " + (Integer.parseInt(skl.substring(2)) + 1) + " " + JRMCoreH.SklName(skl, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames))).func_150255_a(colorG));
                  }
               }

               this.notifyAdmins(par1ICommandSender, "%s checked char sheet of %s ", new Object[]{func_71521_c(par1ICommandSender).getDisplayName(), entityplayermp.getName()});
            }

         }
      }
   }

   private void setter(String s, int v, String n) {
      Object[] o = (Object[])SList.get(s);
      if (o != null) {
         int prevV = Integer.parseInt(o[0] + "");
         if (prevV > v) {
            Object[] sTemp = new Object[]{v, n};
            SList.put(s, sTemp);
         }
      } else {
         Object[] sTemp = new Object[]{v, n};
         SList.put(s, sTemp);
      }

   }

   private Object[] getter(String s) {
      Object[] o = (Object[])SList.get(s);
      return o.length == 2 ? o : null;
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length == 2 ? func_71530_a(par2ArrayOfStr, this.getListOfPlayers()) : null;
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean isUsernameIndex(int par1) {
      return par1 == 0;
   }
}
