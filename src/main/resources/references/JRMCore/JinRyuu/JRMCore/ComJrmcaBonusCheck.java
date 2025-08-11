package JinRyuu.JRMCore;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComJrmcaBonusCheck extends CommandBase {
   private final String name = "jrmcabonuscheck";
   private final byte MODE_GET = 0;
   private final byte MODE_BAD_MODE = -1;
   private final byte MODE_STR = 0;
   private final byte MODE_DEX = 1;
   private final byte MODE_CON = 2;
   private final byte MODE_WILL = 3;
   private final byte MODE_MIND = 4;
   private final byte MODE_SPI = 5;
   private final String[] ATTRIBUTES_LONG = new String[]{"strength", "dexterity", "constitution", "willpower", "mind", "spirit"};
   public static final String[] ATTRIBUTES_SHORT = new String[]{"str", "dex", "con", "wil", "mnd", "spi"};
   private final String[] MODES = new String[]{"sheet"};

   public String func_71517_b() {
      return "jrmcabonuscheck";
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "/jrmcabonuscheck (sheet) (Attribute) (BonusName or ID) [playerName]. Attribute can be Strength, Dexterity, Constitution, Willpower, Mind, Spirit.";
   }

   public int func_82362_a() {
      return 0;
   }

   public boolean func_71519_b(ICommandSender par1ICommandSender) {
      return true;
   }

   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
      int length = stringArray.length;
      switch(length) {
      case 1:
         return func_71530_a(stringArray, this.MODES);
      case 2:
         return func_71530_a(stringArray, this.ATTRIBUTES_LONG);
      case 3:
         return func_71530_a(stringArray, this.getListOfPlayers());
      default:
         return null;
      }
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
      func_152373_a(commandSender, this, string, objects);
   }

   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
      if (stringArray.length <= 0) {
         throw new WrongUsageException(this.func_71518_a(commandSender), new Object[0]);
      } else {
         String modeSting = stringArray[0].toLowerCase();
         String attributeString = stringArray[1].toLowerCase();
         byte mode = modeSting.equals("sheet") ? 0 : -1;
         byte attribute = 0;

         for(byte i = 0; i < this.ATTRIBUTES_LONG.length; ++i) {
            if (attributeString.equals(this.ATTRIBUTES_LONG[i]) || attributeString.equals(ATTRIBUTES_SHORT[i])) {
               attribute = i;
            }
         }

         int playerNameID = true;
         EntityPlayerMP entityplayermp;
         if (stringArray.length > 2) {
            entityplayermp = func_82359_c(commandSender, stringArray[2]);
         } else {
            entityplayermp = func_71521_c(commandSender);
         }

         String entitycommansender = "Console";
         EntityPlayerMP commansender = null;

         try {
            commansender = func_71521_c(commandSender);
            entitycommansender = commansender.getName();
         } catch (Exception var24) {
         }

         boolean canRun = true;
         if (!JRMCoreConfig.JRMCABonusCheckOnOthersWithoutOP && commansender != null && !entitycommansender.equals("Console") && !entityplayermp.getName().equals(entitycommansender)) {
            canRun = false;
            ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
            commansender.func_145747_a((new ChatComponentText("JRMCABonusCheck - Non OP Players can check other Player's Sheet is DISABLED!")).func_150255_a(color));
         }

         if (canRun) {
            boolean run = false;
            NBTTagCompound nbt = this.nbt(entityplayermp, "pres");
            String startString = nbt.func_74779_i("jrmcAttrBonus" + ATTRIBUTES_SHORT[attribute]);
            String[] bonus = startString.split("\\|");
            String[][] bonusValues = new String[bonus.length][2];
            if (bonus.length > 0 && bonus[0].length() > 0) {
               for(int i = 0; i < bonus.length; ++i) {
                  String[] bonusValue = bonus[i].split("\\;");
                  bonusValues[i][0] = bonusValue[0];
                  bonusValues[i][1] = bonusValue[1];
               }
            }

            ChatStyle color;
            if (mode == 0) {
               color = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
               ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
               if (commansender != null) {
                  commansender.func_145747_a((new ChatComponentText(entityplayermp.getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:")).func_150255_a(color));
               } else if (entitycommansender.equals("Console")) {
                  JRMCoreH.log(entityplayermp.getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:");
               }

               if (bonus.length > 0 && bonus[0].length() > 0) {
                  for(int i = 0; i < bonus.length; ++i) {
                     String[] bonusValue = bonus[i].split("\\;");
                     bonusValues[i][0] = bonusValue[0];
                     bonusValues[i][1] = bonusValue[1];
                     if (bonusValues[i][1].contains("nbt_") || bonusValues[i][1].contains("NBT_")) {
                        String noNBTText = bonusValues[i][1].replace("nbt_", "").replace("NBT_", "");
                        double value = nbt.func_74769_h(noNBTText.substring(1));
                        bonusValues[i][1] = noNBTText.substring(0, 1) + "(" + value + ")";
                     }

                     if (commansender != null) {
                        commansender.func_145747_a((new ChatComponentText("ID " + bonusValues[i][0] + " | VALUE: " + bonusValues[i][1])).func_150255_a(color));
                     } else if (entitycommansender.equals("Console")) {
                        JRMCoreH.log("ID " + bonusValues[i][0] + " | VALUE: " + bonusValues[i][1]);
                     }
                  }
               } else if (commansender != null) {
                  commansender.func_145747_a((new ChatComponentText("EMPTY")).func_150255_a(color));
               } else if (entitycommansender.equals("Console")) {
                  JRMCoreH.log("EMPTY");
               }
            }

            if (!JRMCoreConfig.JRMCABonusOn) {
               if (commansender != null) {
                  color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
                  commansender.func_145747_a((new ChatComponentText("JRMCABonus Attributes are DISABLED in the configs!")).func_150255_a(color));
               } else if (entitycommansender.equals("Console")) {
                  JRMCoreH.log("JRMCABonus Attributes are DISABLED in the configs!");
               }
            }
         }

      }
   }
}
