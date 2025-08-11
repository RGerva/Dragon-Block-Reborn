package JinRyuu.JRMCore;

import cpw.mods.fml.common.FMLCommonHandler;
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

public class ComJrmcKills extends CommandBase {
   public static HashMap<String, Object[]> SList = new HashMap();

   public String func_71517_b() {
      return "jrmckills";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "Usage: '/jrmckills top' to view top kills OR '/jrmckills [playerName]' to view players kill statistics.";
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return true;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length <= 0) {
         throw new WrongUsageException(this.func_71518_a(par1ICommandSender), new Object[0]);
      } else {
         EntityPlayerMP entitycommansender = func_71521_c(par1ICommandSender);
         EntityPlayerMP entityplayermp = entitycommansender;
         boolean flagTop = false;
         boolean flagPlayer = false;
         if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("top")) {
            entityplayermp = func_71521_c(par1ICommandSender);
            flagTop = true;
         } else if (par2ArrayOfStr.length > 0) {
            entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);
            flagPlayer = true;
         }

         NBTTagCompound nbt = JRMCoreH.nbt(entityplayermp, "pres");
         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
         ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
         MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
         int cur = server.func_71233_x();
         boolean alone = cur <= 1 && flagTop;
         int Karma;
         int KllCG;
         int Karma;
         if (cur > 1 && !flagPlayer) {
            if (flagTop) {
               int Total;
               int Good;
               for(int pl = 0; pl < cur; ++pl) {
                  EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                  int Align = JRMCoreH.getByte(entityplayermp, "jrmcAlign");
                  Karma = JRMCoreH.getInt(entityplayermp, "jrmcKarma");
                  KllCG = JRMCoreH.getInt(entityplayermp, "jrmcKillCountGood");
                  Karma = JRMCoreH.getInt(entityplayermp, "jrmcKillCountNeut");
                  Total = JRMCoreH.getInt(entityplayermp, "jrmcKillCountEvil");
                  Good = KllCG + Karma + Total;
                  this.setter("topBadKarma", Karma, player.getName());
                  this.setter("topTotalKills", Good, player.getName());
                  this.setter("topGoodKills", KllCG, player.getName());
                  this.setter("topNeutralKills", Karma, player.getName());
                  this.setter("topEvilKills", Total, player.getName());
               }

               Object[] topBadKarma = this.getter("topBadKarma");
               Object[] topTotalKills = this.getter("topTotalKills");
               Object[] topGoodKills = this.getter("topGoodKills");
               Object[] topNeutralKills = this.getter("topNeutralKills");
               Object[] topEvilKills = this.getter("topEvilKills");
               Karma = Integer.parseInt(topBadKarma[0] + "");
               Total = Integer.parseInt(topTotalKills[0] + "");
               Good = Integer.parseInt(topGoodKills[0] + "");
               int Neutral = Integer.parseInt(topNeutralKills[0] + "");
               int Evil = Integer.parseInt(topEvilKills[0] + "");
               boolean b = Karma == 0 && Total == 0 && Good == 0 && Neutral == 0 && Evil == 0;
               entitycommansender.func_145747_a((new ChatComponentText("Current Top Players")).func_150255_a(colorG));
               if (Karma > 0) {
                  entitycommansender.func_145747_a((new ChatComponentText("Most Wanted: " + topBadKarma[1] + " with " + topBadKarma[0] + " bad karma")).func_150255_a(color));
               }

               if (Total > 0) {
                  entitycommansender.func_145747_a((new ChatComponentText("Top Total Kills: " + topTotalKills[1] + " with " + topTotalKills[0] + " kill count")).func_150255_a(color));
               }

               if (Good > 0) {
                  entitycommansender.func_145747_a((new ChatComponentText("Top Good Kills: " + topGoodKills[1] + " with " + topGoodKills[0] + " kill count")).func_150255_a(color));
               }

               if (Neutral > 0) {
                  entitycommansender.func_145747_a((new ChatComponentText("Top Neutral Kills: " + topNeutralKills[1] + " with " + topNeutralKills[0] + " kill count")).func_150255_a(color));
               }

               if (Evil > 0) {
                  entitycommansender.func_145747_a((new ChatComponentText("Top Evil Kills: " + topEvilKills[1] + " with " + topEvilKills[0] + " kill count")).func_150255_a(color));
               }

               if (b) {
                  entitycommansender.func_145747_a((new ChatComponentText("There are no Top Players!")).func_150255_a(color));
               }

               SList.clear();
            }
         } else {
            int Align = JRMCoreH.getByte(entityplayermp, "jrmcAlign");
            int Karma = JRMCoreH.getInt(entityplayermp, "jrmcKarma");
            int KllCG = JRMCoreH.getInt(entityplayermp, "jrmcKillCountGood");
            Karma = JRMCoreH.getInt(entityplayermp, "jrmcKillCountNeut");
            KllCG = JRMCoreH.getInt(entityplayermp, "jrmcKillCountEvil");
            Karma = KllCG + Karma + KllCG;
            if (alone) {
               entitycommansender.func_145747_a((new ChatComponentText("You are alone on the server!")).func_150255_a(color));
            }

            entitycommansender.func_145747_a((new ChatComponentText(entityplayermp.getDisplayName() + "'s Player Kill counts")).func_150255_a(colorG));
            entitycommansender.func_145747_a((new ChatComponentText("Total Kills: " + Karma)).func_150255_a(color));
            entitycommansender.func_145747_a((new ChatComponentText("Good Kills: " + KllCG)).func_150255_a(color));
            entitycommansender.func_145747_a((new ChatComponentText("Neutral Kills: " + Karma)).func_150255_a(color));
            entitycommansender.func_145747_a((new ChatComponentText("Evil Kills: " + KllCG)).func_150255_a(color));
            entitycommansender.func_145747_a((new ChatComponentText("Bad Karma: " + Karma)).func_150255_a(color));
            entitycommansender.func_145747_a((new ChatComponentText("Alignment: " + JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(Align)])).func_150255_a(color));
            this.notifyAdmins(par1ICommandSender, "%s checked kill counts of %s  ", new Object[]{func_71521_c(par1ICommandSender).getDisplayName(), entityplayermp.getName()});
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
      return par2ArrayOfStr.length == 1 ? func_71530_a(par2ArrayOfStr, this.getListOfPlayers()) : null;
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean isUsernameIndex(int par1) {
      return par1 == 0;
   }
}
