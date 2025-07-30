package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ComDbc extends CommandBase {
   public String func_71517_b() {
      return "dbc";
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "Use '/dbc locations' or '/dbc loc' to receive the locations in DBC and Use '/dbc accept' to accept offers like revive with teleport.";
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

   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      if (par2ArrayOfStr.length <= 0) {
         throw new WrongUsageException("Use '/dbc locations' or '/dbc loc' to receive the locations in DBC and Use '/dbc accept' to accept offers like revive with teleport.", new Object[0]);
      } else {
         EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
         String s = par2ArrayOfStr[0];
         boolean loc = s.toLowerCase().contains("locations") || s.toLowerCase().contains("loc");
         boolean accept = s.toLowerCase().contains("accept");
         boolean heal = false;
         String[] clar;
         if (loc) {
            ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
            if (entityplayermp.field_71093_bK == 0) {
               String[] kamh = DBCH.genKH.split(";");
               clar = DBCH.genCA.split(";");
               String[] gkhs = DBCH.genGH.split(";");
               String[] bs = DBCH.genBS.split(";");
               entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
               entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kami"))).func_150255_a(color));
               if (kamh.length > 2) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kame") + ": " + (JRMCoreH.parseInt(kamh[0]) + DBCH.genKHnpc1[0]) + " " + (JRMCoreH.parseInt(kamh[1]) + DBCH.genKHnpc1[1]) + " " + (JRMCoreH.parseInt(kamh[2]) + DBCH.genKHnpc1[2]))).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kamenotexp"))).func_150255_a(color));
               }

               if (clar.length > 2) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.cell") + ": " + (JRMCoreH.parseInt(clar[0]) + DBCH.genCAnpc1[0]) + " " + (JRMCoreH.parseInt(clar[1]) + DBCH.genCAnpc1[1]) + " " + (JRMCoreH.parseInt(clar[2]) + DBCH.genCAnpc1[2]))).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.cellnotexp"))).func_150255_a(color));
               }

               if (gkhs.length > 2) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.goku") + ": " + (JRMCoreH.parseInt(gkhs[0]) + DBCH.genGHnpc1[0]) + " " + (JRMCoreH.parseInt(gkhs[1]) + DBCH.genGHnpc1[1]) + " " + (JRMCoreH.parseInt(gkhs[2]) + DBCH.genGHnpc1[2]))).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.gokunotexp"))).func_150255_a(color));
               }

               if (bs.length > 2) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.babidi") + ": " + (JRMCoreH.parseInt(bs[0]) + DBCH.genBSnpc1[0]) + " " + (JRMCoreH.parseInt(bs[1]) + DBCH.genBSnpc1[1]) + " " + (JRMCoreH.parseInt(bs[2]) + DBCH.genBSnpc1[2]))).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.babidinotexp"))).func_150255_a(color));
               }
            }

            if (entityplayermp.field_71093_bK == DBCConfig.planetNamek) {
               String fzsp = DBCH.genFS.replace(";", " ");
               String guru = DBCH.genGuru.replace(";", " ");
               entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
               if (fzsp.length() > 3) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.freeza") + ": " + fzsp)).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.freezanotexp"))).func_150255_a(color));
               }

               entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
               if (guru.length() > 3) {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.guruhouse") + ": " + guru)).func_150255_a(color));
               } else {
                  entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.guruhousenotexp"))).func_150255_a(color));
               }
            }
         }

         if (accept) {
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            if (entityplayermp.field_71093_bK == DBCConfig.otherWorld && entityplayermp != null && entityplayermp.field_70154_o == null && entityplayermp.field_70153_n == null) {
               clar = JRMCoreH.getString(entityplayermp, "jrmcRevtpInit").split(";");
               if (clar.length > 3) {
                  String wisherNam = clar[0];
                  int reviveDim = Integer.parseInt(clar[1]);
                  int x = Integer.parseInt(clar[2]);
                  int y = Integer.parseInt(clar[3]);
                  int z = Integer.parseInt(clar[4]);
                  JRMCoreH.setByte(0, entityplayermp, "jrmcAlv");
                  server.func_71203_ab().transferPlayerToDimension(entityplayermp, reviveDim, new WorldTeleporterDBCTelep(server.func_71218_a(reviveDim)));
                  entityplayermp.func_71023_q(1);
                  double[] d = new double[]{(double)x, (double)y, (double)z};
                  entityplayermp.field_71135_a.func_147364_a(d[0], d[1], d[2], 0.0F, 0.0F);
                  mod_DragonBC.logger.info(entityplayermp.func_70005_c_() + " revived by " + wisherNam + "!");
                  if (JRMCoreHDBC.DBCgetConfigDeadInv() && entityplayermp.field_70170_p.func_82736_K().func_82766_b("keepInventory") && !entityplayermp.field_71075_bZ.field_75098_d && JRMCoreH.getByte(entityplayermp, "jrmcAlv") == 1) {
                     JRMCoreH.nbt(entityplayermp).func_74782_a("InventoryDead", entityplayermp.field_71071_by.func_70442_a(new NBTTagList()));
                     entityplayermp.field_71071_by.func_70443_b(JRMCoreH.nbt(entityplayermp).func_150295_c("InventoryLiving", 10));
                     entityplayermp.getEntityData().func_74782_a("Inventory", entityplayermp.field_71071_by.func_70442_a(new NBTTagList()));
                  }

                  EntityPlayer target = JRMCoreH.getPlayerForUsername(server, wisherNam);
                  if (target != null) {
                     String t = JRMCoreH.trlai("dbc", "reviveaccepted");
                     ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
                     target.func_145747_a((new ChatComponentTranslation(t, new Object[]{entityplayermp.func_70005_c_(), JRMCoreH.trl("dbc", (String)DBCH.plntNms.get(reviveDim)), x + ", " + y + ", " + z})).func_150255_a(styl));
                  }
               }
            }

            JRMCoreH.setString("e", entityplayermp, "jrmcRevtpInit");
         }

      }
   }

   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
      func_152373_a(par1iCommandSender, this, string, objects);
   }
}
