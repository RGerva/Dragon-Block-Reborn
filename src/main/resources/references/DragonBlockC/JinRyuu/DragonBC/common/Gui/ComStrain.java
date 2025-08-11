package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComStrain extends CommandBase {
   public String func_71517_b() {
      return "dbcstrain";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length < 1) {
         throw new WrongUsageException("/dbcstrain remove (playerName)", new Object[0]);
      } else {
         EntityPlayerMP entityplayermp;
         if (par2ArrayOfStr.length > 1) {
            entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
         } else {
            entityplayermp = func_71521_c(par1ICommandSender);
         }

         JRMCoreH.setInt(0, entityplayermp, "jrmcStrain");
         String t = JRMCoreH.trlai("dbc", "StrainRemoved");
         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
         this.notifyAdmins(par1ICommandSender, "%s's strain has been removed.", new Object[]{entityplayermp.getName()});
      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "/dbcstrain remove (playerName)";
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
