package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComReincarnate extends CommandBase {
   public String func_71517_b() {
      return "dbcreincarnate";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length < 0) {
         throw new WrongUsageException("/dbcreincarnate [playerName]", new Object[0]);
      } else {
         EntityPlayerMP p;
         if (par2ArrayOfStr.length > 0) {
            p = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);
         } else {
            p = func_71521_c(par1ICommandSender);
         }

         if (!JRMCoreH.isFused(p)) {
            JRMCoreHDBC.reincarnate(p);
            String t = JRMCoreH.trlai("dbc", "reincarnated");
            ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
            p.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
            this.notifyAdmins(par1ICommandSender, "%s reincarnated!", new Object[]{p.func_70005_c_()});
         } else {
            this.notifyAdmins(par1ICommandSender, "Unable to reincarnate while fused.", new Object[]{p.func_70005_c_()});
         }

      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "/dbcreincarnate (playerName)";
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
