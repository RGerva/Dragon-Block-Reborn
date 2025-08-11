package JinRyuu.JRMCore;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.entity.EntityNPCshadow;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.JRMCorePData2;
import JinRyuu.JRMCore.p.JRMCorePExpl;
import JinRyuu.JRMCore.p.JRMCorePQuad;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.server.JGEntityHelper;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import com.google.gson.Gson;
import cpw.mods.fml.common.FMLCommonHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class JRMCorePacHanS {
   public static final int HALF_RELEASE = 50;
   public static final int MAX_RELEASE = 100;
   public static final int RELEASE_PER_POTENTIAL_UNLOCK = 5;
   public static final ChatStyle chatStyle;
   public static final int DATA_TYPE_SOUND = 1;
   public static final int MISSION_DATA = 2;
   public static final int GROUP_DATA = 3;
   public static final int TRAINING = 10;
   public static final int FAMILYC_FAMILY_DATA = 200;
   public static final int FORM_GROUP = 1;
   public static final int ACCEPT_GROUP = 2;
   public static final int DECLINE_GROUP = 3;
   public static final int DISBAND_GROUP = 4;
   public static final int LEAVE_GROUP = 5;
   public static final int INVITE_TO_GROUP = 6;
   public static final int SET_LEADER_GROUP = 7;
   public static final int KICK_FROM_GROUP = 8;
   public static final int SPAWN_DUMMY = 0;
   public static final int MINIGAME_CONCENTRATION = 1;
   public static final int MINIGAME_AIRBOXING = 2;
   public static final int TP_LIMIT_CHECK_REQUEST = -1;
   public static final int MINIGAME_TP_COST = 0;
   public static final int MINIGAME_COLLECT_TP_REWARD = 1;
   public static final int RAGE_GAIN = 1;
   public static final int BLOCKING = 2;
   public static final int KI_CHARGE_EFFECT = 3;
   public static final int TECHNIQUE = 4;
   public static final int HEAT_GAIN = 5;
   public static final int SKILL_ADD = 1;
   public static final int SKILL_DELETE = 2;
   public static final int SKILL_INCREASE = 3;
   public static final int SKILL_DECREASE = 4;
   public static final int STATUS_EFFECT = 5;
   public static final int PLAYER_SETTINGS_ONOFF = 6;
   public static final int PLAYER_SETTINGS_SET = 8;
   public static final int STATUS_EFFECT_ON = 0;
   public static final int STATUS_EFFECT_OFF = 1;
   public static int RAGE_GAIN_PLUS;
   public static int RAGE_GAIN_MINUS;
   public double explosionX;
   public double explosionY;
   public double explosionZ;
   public float explosionSize;
   public List chunkPositionRecords;
   public float playerVelocityX;
   public float playerVelocityY;
   public float playerVelocityZ;
   public boolean expGriOff;
   public double expDam;
   public Entity origin;
   public byte type;
   public static HashMap<String, Long> ckr;
   public static String R;
   public static String P;
   public static String Cl;
   public static String Acc;
   public static String St;
   public static String Diff;
   public static String Ptch;

   public void handleExpl(double explosionX, double explosionY, double explosionZ, float explosionSize, boolean expGriOff, double expDam, Entity origin, List chunkPositionRecords, float playerVelocityX, float playerVelocityY, float playerVelocityZ, EntityPlayer p, byte type) {
      this.explosionX = explosionX;
      this.explosionY = explosionY;
      this.explosionZ = explosionZ;
      this.explosionSize = explosionSize;
      this.expGriOff = expGriOff;
      this.expDam = expDam;
      this.chunkPositionRecords = chunkPositionRecords;
      int var3 = (int)this.explosionX;
      int var4 = (int)this.explosionY;
      int var5 = (int)this.explosionZ;
      this.playerVelocityX = playerVelocityX;
      this.playerVelocityY = playerVelocityY;
      this.playerVelocityZ = playerVelocityZ;
      this.type = type;
      PD.sendToDimension(new JRMCorePExpl(explosionX, explosionY, explosionZ, explosionSize, expGriOff, expDam, origin, chunkPositionRecords, playerVelocityX, playerVelocityY, playerVelocityZ, type), origin.field_71093_bK);
   }

   public void handleData(int c, String d, EntityPlayer p) {
      byte acc;
      byte rc;
      int r;
      String SenderName;
      String dnsau;
      if (c == 0) {
         acc = JRMCoreH.getByte(p, Acc);
         int bodyColor;
         if (acc == 0) {
            rc = JRMCoreH.getByte(p, R);
            if (JRMCoreH.isRaceMajin(rc)) {
               int hc = JRMCoreH.dnsHairC(d);
               bodyColor = JRMCoreH.dnsBodyCM(d);
               if (hc != bodyColor) {
                  d = JRMCoreH.dnsHairCSet(d, bodyColor);
               }
            }

            JRMCoreH.setString(d, p, "jrmcDNS");
         } else {
            SenderName = JRMCoreH.getString(p, "jrmcDNS");
            bodyColor = JRMCoreH.dnsHairB(SenderName);
            int hf = JRMCoreH.dnsHairF(SenderName);
            int hc = JRMCoreH.dnsHairC(SenderName);
            int race = JRMCoreH.getByte(p, R);
            if (JRMCoreH.isRaceMajin(race)) {
               r = JRMCoreH.dnsBodyCM(SenderName);
               if (hc != r) {
                  hc = r;
               }
            }

            dnsau = JRMCoreH.dnsHairBSet(d, bodyColor);
            dnsau = JRMCoreH.dnsHairFSet(dnsau, hf);
            dnsau = JRMCoreH.dnsHairCSet(dnsau, hc);
            if (SenderName.equals(dnsau)) {
               JRMCoreH.setString(d, p, "jrmcDNS");
            }
         }
      }

      if (c == 1) {
         acc = JRMCoreH.getByte(p, Acc);
         JRMCoreH.setString(d, p, "jrmcDNSH");
      }

      if (c == 2) {
         JRMCoreH.setInt(Integer.parseInt(d), p, "jrmcAuraColor");
      }

      if (c == 3) {
         acc = JRMCoreH.getByte(p, Acc);
         rc = JRMCoreH.getByte(p, R);
         dnsau = JRMCoreH.getString(p, "jrmcDNSAU");
         if (acc == 1 && JRMCoreH.rc_arc(rc) && JRMCoreHDBC.auc(JRMCoreH.SklLvlX(p)) && !dnsau.contains(";")) {
            JRMCoreH.setString(d, p, "jrmcDNSAU");
         }
      }

      if (c == 4) {
         acc = JRMCoreH.getByte(p, Acc);
         rc = JRMCoreH.getByte(p, R);
         dnsau = JRMCoreH.getString(p, "jrmcDNSAU");
         if (acc == 1 && JRMCoreH.rc_arc(rc) && JRMCoreHDBC.auc(JRMCoreH.SklLvlX(p)) && !dnsau.contains(";")) {
            JRMCoreH.setString(";" + d, p, "jrmcDNSAU");
         }
      }

      MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
      SenderName = server.func_71266_T() ? p.func_146103_bH().getId() + ";" + p.getName() : p.getName();
      NBTTagCompound nbt = this.nbt(p, "pres");
      if (c == 80 && JRMCoreConfig.ssurl.contains("http://")) {
         String[] ssurl = JRMCoreConfig.ssurl.split(",");
         String o = getUrlContents(ssurl[0] + ssurl[1] + SenderName);
         if (d.contains("q")) {
            JRMCoreH.jrmcDataToP(c, o, p);
         }

         if (d.contains("r") && !o.equalsIgnoreCase("error")) {
            String o1 = o.isEmpty() ? "0" : o;
            int q = Integer.parseInt(o1);
            r = Integer.parseInt(d.substring(1));
            String ssc = JRMCoreConfig.ssc;
            if (ssc.contains("http://")) {
               ssc = getUrlContents(ssc);
            }

            String[] s1 = ssc.split(";");
            String uid = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
            mod_JRMCore.logger.info("PWSPlog: Phase1! " + p.getName() + " issued purchase for localID " + (r + 1) + "! UniqueID=" + uid);
            SenderName = SenderName + ";" + uid;
            if (!ssc.contains("=")) {
               mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " something went wrong!");
               p.func_145747_a((new ChatComponentText("something went wrong, get in contact with an admin!")).func_150255_a(chatStyle));
            } else {
               String[] sn = new String[s1.length];
               String[] sc = new String[s1.length];

               int curcost;
               for(curcost = 0; curcost < s1.length; ++curcost) {
                  String[] s2 = s1[curcost].split("=");
                  sn[curcost] = s2[0];
                  sc[curcost] = s2[1];
               }

               curcost = Integer.parseInt(sc[r]);
               int a = q - curcost;
               mod_JRMCore.logger.info("PWSPlog: Phase2!");
               if (a >= 0) {
                  String cost = getUrlContents(ssurl[0] + ssurl[1] + SenderName + ssurl[2] + curcost + ssurl[3] + (r + 1) + ssurl[4]);
                  mod_JRMCore.logger.info("PWSPlog: Phase3!");
                  if (cost.contains("has used up")) {
                     mod_JRMCore.logger.info("PWSPlog: Begin!");
                     int n2;
                     int n3;
                     if (sn[r].substring(0, 2).contains("TP")) {
                        int curtp = nbt.func_74762_e("jrmcTpint");
                        int addtp = Integer.parseInt(sn[r].substring(2));
                        n2 = curtp + addtp;
                        n3 = 0;
                        if (n2 > JRMCoreH.getMaxTP()) {
                           n3 = n2 - JRMCoreH.getMaxTP();
                           n2 = JRMCoreH.getMaxTP();
                        }

                        nbt.func_74768_a("jrmcTpint", n2);
                        JRMCoreH.jrmcDataToP(c, a + "", p);
                        mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " successfully bought " + addtp + " TP and now has " + n2 + (n3 > 0 ? " and " + n3 + " has gone wasted!" : "."));
                        p.func_145747_a((new ChatComponentText("You have successfully bought " + addtp + " TP and now has " + n2 + (n3 > 0 ? " and " + n3 + " has gone wasted!" : "."))).func_150255_a(chatStyle));
                     } else {
                        String it;
                        String[] ssa;
                        String nam;
                        String n1;
                        String n1;
                        if (sn[r].substring(0, 2).contains("CM")) {
                           it = "";
                           if (!sn[r].contains("||")) {
                              n1 = sn[r].split("!")[0].substring(2);
                              String com = sn[r].split("!")[1];
                              nam = String.format(com.replace("@p", "%s"), p.getName());
                              p.func_145747_a((new ChatComponentText("You have successfully bought " + n1 + "!")).func_150255_a(chatStyle));
                              mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " successfully bought " + n1 + "!");
                              p.world.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
                              TileEntity tileentity = p.world.func_147438_o(0, 254, 0);
                              CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
                              commandblocklogic.func_145752_a(nam);
                              commandblocklogic.func_145755_a(p.world);
                              p.world.func_147468_f(0, 254, 0);
                           } else {
                              ssa = sn[r].split("\\|\\|");
                              it = ssa[0].substring(2);

                              for(n2 = 1; n2 < ssa.length; ++n2) {
                                 nam = ssa[n2];
                                 n1 = nam.split("!")[0].substring(2);
                                 String com = nam.split("!")[1];
                                 String s = String.format(com.replace("@p", "%s"), p.getName());
                                 p.world.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
                                 TileEntity tileentity = p.world.func_147438_o(0, 254, 0);
                                 CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
                                 commandblocklogic.func_145752_a(s);
                                 commandblocklogic.func_145755_a(p.world);
                                 p.world.func_147468_f(0, 254, 0);
                              }

                              p.func_145747_a((new ChatComponentText("You have successfully bought " + it + "!")).func_150255_a(chatStyle));
                              mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " successfully bought " + it + "!");
                           }
                        } else if (sn[r].substring(0, 2).contains("IT")) {
                           it = "";
                           if (sn[r].contains("||")) {
                              ssa = sn[r].split("\\|\\|");
                              it = ssa[0].substring(2);

                              for(n2 = 1; n2 < ssa.length; ++n2) {
                                 nam = ssa[n2];
                                 n1 = "";
                                 int n2 = 1;
                                 int n3 = 0;
                                 if (n2 > 0) {
                                    String[] s2 = nam.split(",");
                                    if (s2.length > 1) {
                                       n2 = Integer.parseInt(s2[1]);
                                    }

                                    if (s2[0].contains("::")) {
                                       String[] s3 = s2[0].split("::");
                                       n1 = s3[0];
                                       n3 = Integer.parseInt(s3[1]);
                                    } else {
                                       n1 = s2[0];
                                    }

                                    Item item = JRMCoreH.getItemByText(n1);
                                    if (item != null) {
                                       ItemStack itemstack = new ItemStack(item, n2, n3);
                                       EntityItem entityitem = p.func_71019_a(itemstack, false);
                                       entityitem.field_145804_b = 0;
                                    }
                                 } else {
                                    it = nam.substring(2);
                                 }
                              }
                           } else {
                              n1 = "";
                              n2 = 1;
                              n3 = 0;
                              String[] s2 = sn[r].split(",");
                              if (s2.length > 1) {
                                 n2 = Integer.parseInt(s2[1]);
                              }

                              if (s2[0].contains("::")) {
                                 String[] s3 = s2[0].split("::");
                                 n1 = s3[0].substring(2);
                                 n3 = Integer.parseInt(s3[1]);
                              } else {
                                 n1 = s2[0].substring(2);
                              }

                              Item item = JRMCoreH.getItemByText(n1);
                              if (item != null) {
                                 ItemStack itemstack = new ItemStack(item, n2, n3);
                                 EntityItem entityitem = p.func_71019_a(itemstack, false);
                                 entityitem.field_145804_b = 0;
                                 it = itemstack.func_82833_r();
                              }
                           }

                           mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " successfully bought " + it);
                           p.func_145747_a((new ChatComponentText("You have successfully bought " + it)).func_150255_a(chatStyle));
                        }
                     }
                  }
               }
            }

            mod_JRMCore.logger.info("PWSPlog: END");
         }
      } else if (c == 80) {
         mod_JRMCore.logger.info("PWSPlog: " + p.getName() + " something terribly went wrong!");
         p.func_145747_a((new ChatComponentText("something terribly went wrong, get in contact with an admin!")).func_150255_a(chatStyle));
      }

   }

   public void spawcha(EntityPlayer p, World w, String n, String h, String a, String m, String pr, double x, double y, double z, int g) {
      JGEntityHelper.spawcha(p, w, n, h, a, m, pr, x, y, z, g);
   }

   public void handleData2(String c, String d, EntityPlayer p) {
      NBTTagCompound nbt;
      String msd;
      String msdV;
      String msdO;
      int mid;
      byte al;
      boolean reset;
      String[] sydaV;
      boolean canRepeat;
      int size;
      int size;
      byte rc;
      byte cl;
      String rp;
      if (c.length() <= 1 && d.length() <= 1) {
         nbt = this.nbt(p, "pres");
         msd = nbt.func_74779_i("JRMCmissionSync");
         msdV = nbt.func_74779_i("JRMCmissionSyncVers");
         msdO = msd;
         String msdVO = msdV;
         HashMap<String, Integer> h = new HashMap();
         if (msd.length() > 3) {
            for(int i = 0; i < JRMCoreM.getSydaAmount(msd); ++i) {
               mid = JRMCoreM.getMda_Mission(msd, i);
               String sid = JRMCoreM.getMda_Series(msd, i);
               h.put(sid, mid);
            }
         }

         rc = nbt.func_74771_c(P);
         cl = nbt.func_74771_c(R);
         al = nbt.func_74771_c(Cl);
         Iterator iterator = JRMCoreM.missions.keySet().iterator();

         while(true) {
            while(true) {
               String seriesID;
               JRMCoreMsnBundle M;
               do {
                  if (!iterator.hasNext()) {
                     return;
                  }

                  seriesID = (String)iterator.next();
                  M = (JRMCoreMsnBundle)JRMCoreM.missions.get(seriesID);
               } while(M == null);

               List<JRMCoreMsn> msnl = M.getMissions();
               boolean unlocked = true;
               if (M.getSettings().getUnlock().length() > 0) {
                  String[] sidd = M.getSettings().getUnlock().split(",");

                  for(int i = 0; i < sidd.length; ++i) {
                     unlocked = JRMCoreM.isUnlocked(sidd[i], msd, msdV);
                     if (!unlocked) {
                        break;
                     }
                  }
               }

               reset = true;
               sydaV = JRMCoreM.getMda(msdV, seriesID);
               rp = JRMCoreM.getSydaV(sydaV, 2);
               canRepeat = rp.equals("0");
               if (sydaV.length > 1) {
                  reset = !M.getVersion().equalsIgnoreCase(sydaV[1]);
               }

               rp = reset ? "0" : rp;
               String cc = JRMCoreM.getSydaV(sydaV, 3);
               String ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
               msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
               int msnToSendID = 0;
               boolean hasSyda = false;
               if (h.containsKey(seriesID)) {
                  if (!reset) {
                     msnToSendID = (Integer)h.get(seriesID);
                  }

                  hasSyda = true;
               }

               for(size = 0; size < msnl.size(); ++size) {
                  JRMCoreMsn msn = (JRMCoreMsn)msnl.get(size);
                  if (hasSyda && reset) {
                     JRMCoreM.resetMsnBndl(hasSyda, reset, msn, msnToSendID, rc, cl, al, msd, msdV, msdO, msdVO, seriesID, nbt, M, p);
                  } else if (msn.getId() == msnToSendID) {
                     ArrayList<String> o = msn.getObjectives(rc, cl, al);
                     size = o.size();
                     String[] ar;
                     int i;
                     if (hasSyda) {
                        if (JRMCoreM.getMda_Con(JRMCoreM.getMda(msd, seriesID), size - 1).equals("") || reset) {
                           String[] var10000 = new String[]{"0"};
                           ar = new String[size];

                           for(i = 0; i < size; ++i) {
                              ar[i] = "0";
                           }

                           msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
                           rp = reset ? "0" : rp;
                           cc = JRMCoreM.getSydaV(sydaV, 3);
                           ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
                           msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
                           if (!msd.equalsIgnoreCase(msdO)) {
                              nbt.func_74778_a("JRMCmissionSync", msd);
                           }

                           if (!msdV.equalsIgnoreCase(msdVO)) {
                              nbt.func_74778_a("JRMCmissionSyncVers", msdV);
                           }
                        }
                     } else {
                        ar = new String[size];

                        for(i = 0; i < ar.length; ++i) {
                           ar[i] = "0";
                        }

                        msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
                        rp = reset ? "0" : rp;
                        cc = JRMCoreM.getSydaV(sydaV, 3);
                        ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
                        msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
                        if (!msd.equalsIgnoreCase(msdO)) {
                           nbt.func_74778_a("JRMCmissionSync", msd);
                        }

                        if (!msdV.equalsIgnoreCase(msdVO)) {
                           nbt.func_74778_a("JRMCmissionSyncVers", msdV);
                        }
                     }

                     PD.sendTo(new JRMCorePData2(seriesID + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JRMCoreM.JSN_TYPE_MSN)), (EntityPlayerMP)p);
                     break;
                  }
               }
            }
         }
      } else {
         nbt = this.nbt(p, "pres");
         if (c.length() > 0) {
            msd = nbt.func_74779_i("JRMCmissionSync");
            msdV = nbt.func_74779_i("JRMCmissionSyncVers");
            msdO = msdV;
            HashMap<String, Integer> h = new HashMap();
            if (msd.length() > 3) {
               for(int i = 0; i < JRMCoreM.getSydaAmount(msd); ++i) {
                  String sid = JRMCoreM.getMda_Series(msd, i);
                  mid = JRMCoreM.getMda_Mission(msd, i);
                  h.put(sid, mid);
               }
            }

            int pw = nbt.func_74771_c(P);
            rc = nbt.func_74771_c(R);
            cl = nbt.func_74771_c(Cl);
            al = nbt.func_74771_c("jrmcAlign");
            ArrayList<EntityPlayer> gp = JRMCoreM.prog(p, true);
            int g = gp.size();
            String seriesID = c;
            JRMCoreMsnBundle M = (JRMCoreMsnBundle)JRMCoreM.missions.get(c);
            List<JRMCoreMsn> msnl = M.getMissions();
            reset = true;
            if (M.getSettings().getUnlock().length() > 0) {
               sydaV = M.getSettings().getUnlock().split(",");

               for(int i = 0; i < sydaV.length; ++i) {
                  reset = JRMCoreM.isUnlocked(sydaV[i], msd, msdV);
                  if (!reset) {
                     break;
                  }
               }
            }

            sydaV = JRMCoreM.getMda(msdV, c);
            rp = JRMCoreM.getSydaV(sydaV, 2);
            canRepeat = rp.equals("0");
            int msnToSendID = 0;
            if (h.containsKey(c)) {
               msnToSendID = (Integer)h.get(c);
            }

            if (canRepeat && reset) {
               for(int j = 0; j < msnl.size(); ++j) {
                  JRMCoreMsn msn = (JRMCoreMsn)msnl.get(j);
                  if (msn.getId() == msnToSendID) {
                     gp = JRMCoreM.prog(p, true, c, msnToSendID);
                     ArrayList<String> o = msn.getObjectives(pw, rc, cl);
                     size = o.size();
                     boolean start = false;
                     String ps = (String)msn.getProps().get(0);

                     String os;
                     String t;
                     String os;
                     String cc;
                     int alamount;
                     int n3;
                     for(size = 0; size < o.size(); ++size) {
                        os = (String)o.get(size);
                        t = JRMCoreM.getMCo_type(os);
                        os = JRMCoreM.getMCo_data(os, "N");
                        if (t.equalsIgnoreCase("item")) {
                           String[] d2 = os.split("::");
                           Item im = JRMCoreH.getItemByText(d2.length > 1 ? d2[0] : os);
                           ItemStack is = im != null ? new ItemStack(im, 1, d2.length > 1 ? Integer.parseInt(d2[1]) : 0) : null;
                           cc = is != null ? is.func_77977_a() : "ERROR";
                           alamount = 0;
                           Iterator var38 = gp.iterator();

                           while(var38.hasNext()) {
                              EntityPlayer p1 = (EntityPlayer)var38.next();

                              for(n3 = 0; n3 < p1.field_71071_by.field_70462_a.length; ++n3) {
                                 if (p1.field_71071_by.field_70462_a[n3] != null && p1.field_71071_by.field_70462_a[n3].func_77977_a().equalsIgnoreCase(cc)) {
                                    alamount += p1.field_71071_by.field_70462_a[n3].field_77994_a;
                                 }
                              }
                           }

                           JRMCoreM.prog(p, seriesID, msnToSendID, size, size, "" + alamount);
                           msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, size, "" + alamount);
                        }
                     }

                     double tpres;
                     String tptype;
                     int b;
                     String n1;
                     double tpamount;
                     int at;
                     if (JRMCoreM.getMda_ObjComp_all(o, JRMCoreM.getMda(msd, seriesID), g)) {
                        size = 0;

                        while(true) {
                           int lvl;
                           if (size >= o.size()) {
                              ArrayList<String> r = msn.getRewards(pw, rc, cl);
                              int btnID = Integer.parseInt(d);
                              if (btnID < 0) {
                                 break;
                              }

                              if (ps.equalsIgnoreCase("randrew")) {
                                 btnID = (new Random()).nextInt(r.size());
                              }

                              String[] rw = ((String)r.get(btnID)).split(";");
                              String[] rws = rw[0].split("\\|\\|");
                              Iterator var83 = gp.iterator();

                              while(var83.hasNext()) {
                                 EntityPlayer p1 = (EntityPlayer)var83.next();

                                 for(int i = 0; i < rws.length; ++i) {
                                    String[] srw = rws[i].split("!");
                                    if (!srw[0].equalsIgnoreCase("tp")) {
                                       if (srw[0].equalsIgnoreCase("align")) {
                                          alamount = Integer.parseInt(srw[1]);
                                          b = al + alamount < 0 ? 0 : (al + alamount > 100 ? 100 : al + alamount);
                                          if (alamount == 0) {
                                             if (al >= 55) {
                                                b = al - 10 < 0 ? 0 : al - 10;
                                             } else if (al <= 45) {
                                                b = al + 10 > 100 ? 100 : al + 10;
                                             } else {
                                                b = 50;
                                             }
                                          }

                                          JRMCoreH.tpalgn(p1, 0, b);
                                       } else if (srw[0].equalsIgnoreCase("item")) {
                                          tptype = srw[1];
                                          n1 = "";
                                          int n2 = 1;
                                          n3 = 0;
                                          String[] s2 = tptype.split(",");
                                          if (s2.length > 1) {
                                             n2 = Integer.parseInt(s2[1]);
                                          }

                                          if (s2[0].contains("::")) {
                                             String[] s3 = s2[0].split("::");
                                             n1 = s3[0];
                                             n3 = Integer.parseInt(s3[1]);
                                          } else {
                                             n1 = s2[0];
                                          }

                                          Item item = JRMCoreH.getItemByText(n1);
                                          if (item != null) {
                                             ItemStack itemstack = new ItemStack(item, n2, n3);
                                             EntityItem entityitem = p1.func_71019_a(itemstack, false);
                                             entityitem.field_145804_b = 0;
                                          }
                                       } else if (srw[0].equalsIgnoreCase("com")) {
                                          tptype = srw[1];
                                          tptype = tptype.replace("@p", "%s");
                                          n1 = String.format(tptype, p1.getName());
                                          p1.world.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
                                          TileEntity tileentity = p1.world.func_147438_o(0, 254, 0);
                                          CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
                                          commandblocklogic.func_145752_a(n1);
                                          commandblocklogic.func_145755_a(p1.world);
                                          p1.world.func_147468_f(0, 254, 0);
                                          mod_JRMCore.logger.info("MSNlog: " + p1.getName() + " successfully earned reward for quest " + seriesID + "/" + msn.getId() + "!");
                                       }
                                    } else {
                                       tptype = srw[1];
                                       tpamount = Double.parseDouble(srw[2]);
                                       if (tptype.equals("fix")) {
                                          JRMCoreH.tpalgn(p1, (int)tpamount, al);
                                       } else {
                                          int[] PlyrAttrbts;
                                          if (tptype.equalsIgnoreCase("lvl")) {
                                             PlyrAttrbts = JRMCoreH.PlyrAttrbts(p1);
                                             JRMCoreH.tpalgn(p1, (int)(tpamount * (double)JRMCoreH.getPlayerLevel(PlyrAttrbts)), 0);
                                          } else if (tptype.equalsIgnoreCase("align")) {
                                             n3 = JRMCoreH.Algnmnt(al);
                                             lvl = JRMCoreM.getMAlgnmnt_Num(msn.getAlign(pw, rc, cl));
                                             tpres = lvl == n3 ? tpamount : (lvl != n3 + 1 && lvl != n3 - 1 ? 0.0D : tpamount / 2.0D);
                                             JRMCoreH.tpalgn(p1, (int)tpres, al);
                                          } else if (tptype.equalsIgnoreCase("lvlalign")) {
                                             PlyrAttrbts = JRMCoreH.PlyrAttrbts(p1);
                                             lvl = JRMCoreH.getPlayerLevel(PlyrAttrbts);
                                             at = JRMCoreH.Algnmnt(al);
                                             int ma = JRMCoreM.getMAlgnmnt_Num(msn.getAlign(pw, rc, cl));
                                             double tpres = ma == at ? tpamount : (ma != at + 1 && ma != at - 1 ? 0.0D : tpamount / 2.0D);
                                             JRMCoreH.tpalgn(p1, (int)(tpres * (double)lvl), al);
                                          }
                                       }
                                    }
                                 }
                              }

                              msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
                              JRMCoreM.prog((EntityPlayerMP)p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
                              break;
                           }

                           os = (String)o.get(size);
                           t = JRMCoreM.getMCo_type(os);
                           os = JRMCoreM.getMCo_data(os, "N");
                           if (t.equalsIgnoreCase("item")) {
                              int da = (int)((float)JRMCoreM.getMCo_dataI(os, "M") * JRMCoreM.gm(g));
                              String[] d2 = os.split("::");
                              Item im = JRMCoreH.getItemByText(d2.length > 1 ? d2[0] : os);
                              ItemStack is = im != null ? new ItemStack(im, 1, d2.length > 1 ? Integer.parseInt(d2[1]) : 0) : null;
                              tptype = is != null ? is.func_77977_a() : "ERROR";
                              b = da;
                              Iterator var106 = gp.iterator();

                              while(var106.hasNext()) {
                                 EntityPlayer p1 = (EntityPlayer)var106.next();

                                 for(lvl = 0; lvl < p1.field_71071_by.field_70462_a.length; ++lvl) {
                                    if (b > 0 && p1.field_71071_by.field_70462_a[lvl] != null && p1.field_71071_by.field_70462_a[lvl].func_77977_a().equalsIgnoreCase(tptype)) {
                                       at = p1.field_71071_by.field_70462_a[lvl].field_77994_a;
                                       if (b < at) {
                                          p1.field_71071_by.field_70462_a[lvl].field_77994_a = at - b;
                                          b -= at;
                                       } else if (b >= at) {
                                          p1.field_71071_by.field_70462_a[lvl] = null;
                                          b -= at;
                                       }
                                    }
                                 }
                              }
                           }

                           ++size;
                        }
                     } else {
                        String ft = JRMCoreM.getMCo_type((String)o.get(0));
                        os = JRMCoreM.getMCo_data((String)o.get(0), "N");
                        boolean db = d.equals("-3");
                        if (size == 1) {
                           msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, "1");
                        }

                        String os;
                        String t;
                        String ccv;
                        ArrayList r;
                        String[] rw;
                        if (!JRMCoreM.getMda(msd, seriesID)[2].equals("0")) {
                           if (JRMCoreM.getMda(msd, seriesID)[2].equals("1")) {
                              os = (String)o.get(0);
                              os = JRMCoreM.getMCo_type(os);
                              if (os.equalsIgnoreCase("skip")) {
                                 ArrayList<String> r = msn.getRewards(pw, rc, cl);
                                 String[] rw = ((String)r.get(0)).split(";");
                                 msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
                                 JRMCoreM.prog((EntityPlayerMP)p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
                              } else if (os.equalsIgnoreCase("restart")) {
                                 rp = M.getSettings().getRepeat().contains("-") ? "-1" : "" + Integer.parseInt(M.getSettings().getRepeat()) * 12;
                                 t = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 3)) + 1);
                                 ccv = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 4)) + 1);
                                 msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, t, ccv);
                                 JRMCoreM.prog(p, seriesID, M.getVersion(), rp, t, ccv);
                                 r = msn.getRewards(pw, rc, cl);
                                 rw = ((String)r.get(0)).split(";");
                                 msd = JRMCoreM.setToNextMsn(msd, "0", msnl, seriesID, pw, rc, cl);
                                 JRMCoreM.prog((EntityPlayerMP)p, M, msn, "0", msnl, seriesID, pw, rc, cl);
                              }
                           }
                        } else {
                           for(int i = 0; i < o.size(); ++i) {
                              os = (String)o.get(i);
                              t = JRMCoreM.getMCo_type(os);
                              ccv = JRMCoreM.getMCo_data(os, "N");
                              String dsnS;
                              boolean spwn;
                              double rtx;
                              if (t.equalsIgnoreCase("kill")) {
                                 spwn = JRMCoreM.getMCo_data(os, "P").equalsIgnoreCase("spwn");
                                 if (!spwn) {
                                    float angle = p.rotationYaw;
                                    tpamount = Math.sin((double)(angle / 57.295776F));
                                    rtx = Math.cos((double)(angle / 57.295776F));
                                    at = p.world.func_72976_f((int)(p.posX - 3.0D * tpamount), (int)(p.posZ + 3.0D * rtx));
                                    dsnS = JRMCoreM.getMCo_data(os, "T");
                                    this.spawcha(p, p.world, JRMCoreM.getMCo_data(os, "N"), JRMCoreM.getMCo_data(os, "H"), JRMCoreM.getMCo_data(os, "A"), dsnS, seriesID + ";" + msnToSendID + ";" + p.getName(), p.posX - 3.0D * tpamount, (double)at, p.posZ + 3.0D * rtx, g);
                                    JRMCoreM.prog(p, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
                                    msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
                                    String md = JRMCoreM.getMCo_data(os, "S");
                                    List pl = p.world.func_72872_a(EntityPlayer.class, p.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));
                                    if (pl.size() > 0 && md.length() > 1) {
                                       for(int v = 0; v < pl.size(); ++v) {
                                          EntityPlayer va = (EntityPlayer)pl.get(v);
                                          ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
                                          if (chat.func_150260_c().length() > 0) {
                                             va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
                                          }

                                          String dsnS = JRMCoreM.getMCo_data(os, "O");
                                          if (dsnS.length() > 1) {
                                             if (dsnS.contains(",")) {
                                                String[] dsnSa = dsnS.split(",");
                                                va.world.func_72956_a(va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
                                             } else {
                                                va.world.func_72956_a(va, dsnS, 1.0F, 1.0F);
                                             }
                                          }
                                       }
                                    }
                                 }
                              } else if (!t.equalsIgnoreCase("killsame")) {
                                 if (t.equalsIgnoreCase("talk") && db) {
                                    JRMCoreM.prog(p, seriesID, msnToSendID, size, i, "1");
                                    msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, i, "1");
                                 } else if (t.equalsIgnoreCase("skip")) {
                                    r = msn.getRewards(pw, rc, cl);
                                    rw = ((String)r.get(0)).split(";");
                                    msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
                                    JRMCoreM.prog((EntityPlayerMP)p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
                                 } else if (t.equalsIgnoreCase("restart")) {
                                    rp = M.getSettings().getRepeat().contains("-") ? "-1" : "" + Integer.parseInt(M.getSettings().getRepeat()) * 12;
                                    cc = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 3)) + 1);
                                    tptype = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 4)) + 1);
                                    msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, tptype);
                                    JRMCoreM.prog(p, seriesID, M.getVersion(), rp, cc, tptype);
                                    ArrayList<String> r = msn.getRewards(pw, rc, cl);
                                    String[] rw = ((String)r.get(0)).split(";");
                                    msd = JRMCoreM.setToNextMsn(msd, "0", msnl, seriesID, pw, rc, cl);
                                    JRMCoreM.prog((EntityPlayerMP)p, M, msn, "0", msnl, seriesID, pw, rc, cl);
                                 }
                              } else {
                                 spwn = JRMCoreM.getMCo_data(os, "P").equalsIgnoreCase("spwn");
                                 if (!spwn) {
                                    tptype = JRMCoreM.getMCo_data(os, "T");

                                    for(b = 0; b < (int)((float)JRMCoreM.getMCo_dataI(os, "M") * JRMCoreM.gm(g)); ++b) {
                                       float angle = p.rotationYaw;
                                       rtx = Math.sin((double)(angle / 57.295776F));
                                       tpres = Math.cos((double)(angle / 57.295776F));
                                       int Y = p.world.func_72976_f((int)(p.posX - 3.0D * rtx), (int)(p.posZ + 3.0D * tpres));
                                       this.spawcha(p, p.world, JRMCoreM.getMCo_data(os, "N"), JRMCoreM.getMCo_data(os, "H"), JRMCoreM.getMCo_data(os, "A"), tptype, seriesID + ";" + msnToSendID + ";" + p.getName(), p.posX - 3.0D * rtx, (double)Y, p.posZ + 3.0D * tpres, 1);
                                    }

                                    JRMCoreM.prog(p, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
                                    msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
                                    n1 = JRMCoreM.getMCo_data(os, "S");
                                    List pl = p.world.func_72872_a(EntityPlayer.class, p.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));
                                    if (pl.size() > 0 && n1.length() > 1) {
                                       for(n3 = 0; n3 < pl.size(); ++n3) {
                                          EntityPlayer va = (EntityPlayer)pl.get(n3);
                                          ChatComponentTranslation chat = new ChatComponentTranslation(n1, new Object[0]);
                                          if (chat.func_150254_d().length() > 0) {
                                             va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
                                          }

                                          dsnS = JRMCoreM.getMCo_data(os, "O");
                                          if (dsnS.length() > 1) {
                                             if (dsnS.contains(",")) {
                                                String[] dsnSa = dsnS.split(",");
                                                va.world.func_72956_a(va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
                                             } else {
                                                va.world.func_72956_a(va, dsnS, 1.0F, 1.0F);
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }

                     nbt.func_74778_a("JRMCmissionSync", msd);
                     if (!msdV.equalsIgnoreCase(msdO)) {
                        nbt.func_74778_a("JRMCmissionSyncVers", msdV);
                     }

                     PD.sendTo(new JRMCorePData2(seriesID + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JRMCoreM.JSN_TYPE_MSN)), (EntityPlayerMP)p);
                     break;
                  }
               }
            }
         }
      }

   }

   public static String getUrlContents(String theUrl) {
      StringBuilder content = new StringBuilder();

      try {
         URL url = new URL(theUrl);
         URLConnection urlConnection = url.openConnection();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

         String line;
         while((line = bufferedReader.readLine()) != null) {
            content.append(line);
         }

         bufferedReader.close();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return content.toString();
   }

   public static boolean respc(String theUrl) {
      long ct = System.currentTimeMillis() / 1000L;
      if (ckr.get("guc") == null || ct > (Long)ckr.get("guc")) {
         try {
            URL url = new URL(theUrl);
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();
            connect.setConnectTimeout(10000);
            connect.setReadTimeout(10000);
            connect.setDoOutput(true);
            connect.setInstanceFollowRedirects(false);
            connect.setRequestMethod("HEAD");
            connect.setUseCaches(false);

            try {
               int responseCode = connect.getResponseCode();
               if (responseCode == 200) {
                  ckr.remove("guc");
                  return true;
               }
            } catch (SocketTimeoutException var6) {
            }

            connect.disconnect();
         } catch (IOException var7) {
         }

         ckr.put("guc", ct + 10L);
      }

      return false;
   }

   public static String update() {
      String s = "nothing";

      try {
         String[] ssurl = JRMCoreConfig.ssurl.split(",");
         URL url = new URL(ssurl[0]);
         HttpURLConnection connect = (HttpURLConnection)url.openConnection();
         connect.setConnectTimeout(10000);
         connect.setReadTimeout(10000);
         connect.setDoOutput(true);
         connect.setInstanceFollowRedirects(false);
         connect.setRequestMethod("HEAD");
         connect.setUseCaches(false);

         try {
            int responseCode = connect.getResponseCode();
            if (responseCode == 200) {
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
               String var6 = bufferedReader.readLine();
            }
         } catch (SocketTimeoutException var7) {
         }
      } catch (IOException var8) {
      }

      return s;
   }

   public void handleQuadI(byte b1, int b2, int b3, int b4) {
   }

   public void handleQuad(int b1, int b2, int b3, int b4, EntityPlayer player) {
      MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
      if (b1 == 1) {
         player.world.func_72956_a(player, "jinryuudragonbc:" + JRMCoreH.techSnds(b2, b3, b4), 1.0F, 1.0F);
      }

      String l;
      if (b1 == 2 && JRMCoreConfig.DebugInfo) {
         l = "JRMC has found Potential hacking at ID:01 by player: %s";
         mod_JRMCore.logger.info(String.format(l, player.getName()));
         CommandBase.func_152373_a(player, (ICommand)null, l, new Object[]{player.getName()});
      }

      int i;
      int egid;
      int egid;
      int reward;
      int pl;
      if (b1 == 3) {
         if (b2 == 1) {
            Random ran = new Random();
            i = ran.nextInt(1000000);
            JRMCoreH.setInt(i, player, "JRMCGID");
            JRMCoreH.setString(player.getName(), player, "JRMCGLIDs");
         } else {
            int pl;
            if (b2 == 2) {
               l = JRMCoreH.getString(player, "JRMCGIDis");
               EntityPlayer le = JRMCoreH.getPlayerForUsername(server, l);
               if (le != null) {
                  pl = JRMCoreH.getInt(le, "JRMCGID");
                  String lsl = JRMCoreH.getString(le, "JRMCGLIDs");
                  egid = 0;
                  if (server.func_71213_z() != null && server.func_71213_z().length > 0) {
                     for(egid = 0; egid < server.func_71213_z().length; ++egid) {
                        EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[egid]);
                        reward = JRMCoreH.getInt(e, "JRMCGID");
                        if (reward == pl) {
                           ++egid;
                        }
                     }
                  }

                  if (lsl.equalsIgnoreCase(l) && egid < 10) {
                     JRMCoreH.setString(l, player, "JRMCGLIDs");
                     JRMCoreH.setInt(pl, player, "JRMCGID");
                     JRMCoreH.setString(" ", player, "JRMCGIDis");
                  } else {
                     JRMCoreH.setString(" ", player, "JRMCGLIDs");
                     JRMCoreH.setInt((int)0, player, "JRMCGID");
                     JRMCoreH.setString(" ", player, "JRMCGIDis");
                  }
               } else {
                  JRMCoreH.setString(" ", player, "JRMCGIDis");
               }
            } else if (b2 == 3) {
               JRMCoreH.setString(" ", player, "JRMCGIDis");
            } else {
               int gid;
               String lid;
               EntityPlayerMP e;
               if (b2 == 4) {
                  gid = JRMCoreH.getInt(player, "JRMCGID");
                  lid = JRMCoreH.getString(player, "JRMCGLIDs");
                  if (player.getName().equalsIgnoreCase(lid) && server.func_71213_z() != null && server.func_71213_z().length > 0) {
                     for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                        e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                        egid = JRMCoreH.getInt(e, "JRMCGID");
                        if (egid == gid) {
                           JRMCoreH.setString(" ", e, "JRMCGLIDs");
                           JRMCoreH.setInt((int)0, e, "JRMCGID");
                           JRMCoreH.setString(" ", e, "JRMCGIDis");
                        }
                     }
                  }
               } else {
                  EntityPlayerMP e;
                  if (b2 == 5) {
                     gid = JRMCoreH.getInt(player, "JRMCGID");
                     lid = JRMCoreH.getString(player, "JRMCGLIDs");
                     if (player.getName().equalsIgnoreCase(lid)) {
                        String i = " ";
                        if (server.func_71213_z() != null && server.func_71213_z().length > 0) {
                           for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                              e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                              egid = JRMCoreH.getInt(e, "JRMCGID");
                              if (gid == egid && player.func_145782_y() != e.func_145782_y()) {
                                 i = e.getName();
                                 break;
                              }
                           }

                           for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                              e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                              egid = JRMCoreH.getInt(e, "JRMCGID");
                              if (egid == gid && i.length() > 2) {
                                 JRMCoreH.setString(i, e, "JRMCGLIDs");
                              }
                           }
                        }
                     }

                     JRMCoreH.setString(" ", player, "JRMCGLIDs");
                     JRMCoreH.setInt((int)0, player, "JRMCGID");
                     JRMCoreH.setString(" ", player, "JRMCGIDis");
                  } else if (b2 == 6) {
                     EntityPlayerMP inv = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[b3 * 100 + b4]);
                     if (inv != null && JRMCoreH.getInt(inv, "JRMCGID") == 0) {
                        JRMCoreH.setString(player.getName(), inv, "JRMCGIDis");
                     }
                  } else if (b2 == 7) {
                     gid = JRMCoreH.getInt(player, "JRMCGID");
                     if (server.func_71213_z() != null && server.func_71213_z().length > 0) {
                        i = 0;
                        Entity nl = null;

                        for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                           e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                           egid = JRMCoreH.getInt(e, "JRMCGID");
                           if (egid == gid) {
                              if (i == b3) {
                                 nl = e;
                              }

                              ++i;
                           }
                        }

                        for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                           e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                           egid = JRMCoreH.getInt(e, "JRMCGID");
                           if (egid == gid) {
                              JRMCoreH.setString(nl.getName(), e, "JRMCGLIDs");
                           }
                        }
                     }
                  } else if (b2 == 8) {
                     gid = JRMCoreH.getInt(player, "JRMCGID");
                     i = 0;
                     if (server.func_71213_z() != null && server.func_71213_z().length > 0) {
                        for(pl = 0; pl < server.func_71213_z().length; ++pl) {
                           e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
                           egid = JRMCoreH.getInt(e, "JRMCGID");
                           if (egid == gid) {
                              if (i == b3 && !e.getName().equalsIgnoreCase(player.getName())) {
                                 JRMCoreH.setString(" ", e, "JRMCGLIDs");
                                 JRMCoreH.setInt((int)0, e, "JRMCGID");
                              }

                              ++i;
                           }
                        }
                     }
                  }
               }
            }
         }
      } else if (b1 == 10) {
         NBTTagCompound nbt = this.nbt(player, "pres");
         i = nbt.func_74762_e("jrmcTpint");
         int result;
         if (b2 == 0) {
            if (!JRMCoreH.isFusionSpectator(player)) {
               if (i > 0) {
                  nbt.func_74768_a("jrmcTpint", i - 1);
                  byte acc = nbt.func_74771_c(Acc);
                  byte pwrtyp = nbt.func_74771_c(P);
                  byte rce = nbt.func_74771_c(R);
                  byte cls = nbt.func_74771_c(Cl);
                  byte st = nbt.func_74771_c(St);
                  int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
                  result = JRMCoreH.stat(player, 0, pwrtyp, 0, PlyrAttrbts[0], rce, cls, 0.0F);
                  int maxBody = JRMCoreH.stat(player, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
                  EntityNPCshadow var8 = new EntityNPCshadow(player.world, player, maxBody, result, player);
                  var8.setLocationAndAngles(player.posX - 0.0D, player.posY + 1.5D, player.posZ - 0.0D, player.rotationYaw, player.rotationPitch);
                  player.world.func_72838_d(var8);
               } else {
                  player.func_145747_a(new ChatComponentText(JRMCoreH.cly + "You need more TP to Start training"));
               }
            }
         } else {
            int[] PlyrAttrbts;
            int actualReward;
            String info;
            if (b2 == 1) {
               if (JGConfigMiniGameConcentration.TPGainOn) {
                  if (b3 == -1) {
                     PD.sendTo(new JRMCorePQuad(b1, b2, 0, nbt.func_74762_e("jrmcTPlimit")), (EntityPlayerMP)player);
                  } else if (b3 == 0) {
                     nbt.func_74768_a("jrmcTpint", i - 1);
                  } else if (b3 == 1) {
                     PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
                     pl = (int)((float)b4 * JGConfigMiniGameConcentration.TPMultiplier);
                     egid = (int)((float)JGConfigMiniGameConcentration.TPDailyLimit * (JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel > 0.0F ? (float)JRMCoreH.getPlayerLevel(PlyrAttrbts) * JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel : 1.0F));
                     egid = nbt.func_74762_e("jrmcTPlimit");
                     actualReward = egid + pl;
                     reward = pl;
                     if (egid < actualReward) {
                        reward = pl - (actualReward - egid);
                        actualReward = egid;
                     }

                     if (reward > 0) {
                        result = i + reward;
                        if (result > JRMCoreH.getMaxTP()) {
                           result = JRMCoreH.getMaxTP();
                        }

                        nbt.func_74768_a("jrmcTpint", result);
                        nbt.func_74768_a("jrmcTPlimit", actualReward);
                        player.func_145747_a(new ChatComponentText(JRMCoreH.cly + "Reward from Minigame " + reward + " TP"));
                        info = "JRMC given reward of %sTP from minigame at ID:02 by player: %s";
                        if (JRMCoreConfig.DebugInfo) {
                           mod_JRMCore.logger.info(String.format(info, reward, player.getName()));
                        }
                     }

                     PD.sendTo(new JRMCorePQuad(b1, b2, b3, nbt.func_74762_e("jrmcTPlimit")), (EntityPlayerMP)player);
                  }
               }
            } else if (b2 == 2 && JGConfigMiniGameAirBoxing.TPGainOn) {
               if (b3 == -1) {
                  PD.sendTo(new JRMCorePQuad(b1, b2, 1, nbt.func_74762_e("jrmcTPlimit2")), (EntityPlayerMP)player);
               } else if (b3 == 0) {
                  nbt.func_74768_a("jrmcTpint", i - 1);
               } else if (b3 == 1) {
                  PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
                  pl = (int)((float)b4 * JGConfigMiniGameAirBoxing.TPMultiplier);
                  egid = (int)((float)JGConfigMiniGameAirBoxing.TPDailyLimit * (JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel > 0.0F ? (float)JRMCoreH.getPlayerLevel(PlyrAttrbts) * JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel : 1.0F));
                  egid = nbt.func_74762_e("jrmcTPlimit2");
                  actualReward = egid + pl;
                  reward = pl;
                  if (egid < actualReward) {
                     reward = pl - (actualReward - egid);
                     actualReward = egid;
                  }

                  if (reward > 0) {
                     result = i + reward;
                     if (result > JRMCoreH.getMaxTP()) {
                        result = JRMCoreH.getMaxTP();
                     }

                     nbt.func_74768_a("jrmcTpint", result);
                     nbt.func_74768_a("jrmcTPlimit2", actualReward);
                     player.func_145747_a(new ChatComponentText(JRMCoreH.cly + "Reward from Minigame " + reward + " TP"));
                     info = "JRMC given reward of %sTP from minigame at ID:02 by player: %s";
                     if (JRMCoreConfig.DebugInfo) {
                        mod_JRMCore.logger.info(String.format(info, reward, player.getName()));
                     }
                  }

                  PD.sendTo(new JRMCorePQuad(b1, b2, b3, nbt.func_74762_e("jrmcTPlimit2")), (EntityPlayerMP)player);
               }
            }
         }
      }

   }

   public void handleFall(byte b, EntityPlayer p) {
      if (b == 1 || b == 2) {
         JRMCoreH.setByte(b == 1 ? 1 : 0, p, "jrmcStnd");
      }

   }

   public void handleTech(byte b, String s, EntityPlayer p) {
      if (JRMCoreConfig.osbic > 0 && (Integer)JRMCoreH.osbic.get(p.getName()) < JRMCoreConfig.osbic * 20) {
         p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((float)(JRMCoreConfig.osbic * 20 - (Integer)JRMCoreH.osbic.get(p.getName())) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
      } else {
         int pwrtyp = JRMCoreH.getByte(p, P);
         String te = "te;;;";
         String ug = "ug;;;";
         String up = "up;;;";
         String dn = "dn;;;";
         int s2;
         String toteach;
         if (!s.contains(dn) && !s.contains(up)) {
            if (s.contains(ug)) {
               if (b >= 0 && b <= 3) {
                  s2 = Integer.parseInt(s.replaceAll(ug, ""));
                  toteach = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
                  JRMCoreH.setString(JRMCoreH.tech_upgrd(toteach, s2), p, JRMCoreH.techNbt[b]);
               }
            } else {
               int i;
               if (s.contains(te)) {
                  if (b >= 0 && b <= 3) {
                     EntityPlayer va = JRMCoreH.getClosestPlayerToEntity(p, 8.0D);
                     if (va != null) {
                        toteach = JRMCoreH.tech_teach(JRMCoreH.getString(p, JRMCoreH.techNbt[b]));
                        String[] tn = JRMCoreH.tech_conv(toteach.split(";"));
                        i = JRMCoreH.techDBCtpc(tn, true) * 2;
                        va.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOffer"), new Object[]{p.getName(), tn[0], i})).func_150255_a(JRMCoreH2.styl_ylw));
                        JRMCoreH.setString(toteach + ";:;" + p.getName(), va, "jrmcTechLearn");
                     } else {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noOneToTeach"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
                     }
                  }
               } else if (b >= 0 && b <= 7) {
                  int s2;
                  int costTp;
                  if (!s.contains(";") && s.length() > 0) {
                     int tp;
                     if (s.equals(" ")) {
                        String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
                        if (!s1.equals(" ") && !s1.equals("") && pwrtyp == 1) {
                           if (b >= 4) {
                              s2 = Integer.parseInt(s1);
                              String[][] PMA = JRMCoreH.pmdbc;
                              i = (int)((float)JRMCoreH.techDBCtpc(PMA[s2], false) * 0.9F) / 2;
                              tp = JRMCoreH.getInt(p, "jrmcTpint");
                              JRMCoreH.setInt(tp + i, p, "jrmcTpint");
                           } else if (s1.contains(";")) {
                              String[] s2 = s1.toString().split(";");
                              costTp = JRMCoreH.techDBCtpc(s2, false) / 2;
                              i = JRMCoreH.getInt(p, "jrmcTpint");
                              JRMCoreH.setInt(i + costTp, p, "jrmcTpint");
                           }
                        }

                        JRMCoreH.setString(" ", p, JRMCoreH.techNbt[b]);
                     } else {
                        s2 = Integer.parseInt(s);
                        String[][] PMA = (String[][])null;
                        int tp;
                        if (pwrtyp == 2) {
                           PMA = JRMCoreH.pmj;
                           costTp = JRMCoreH.techNCCostP[Integer.parseInt(PMA[s2][7])];
                           float cost1000 = (float)costTp * 0.01F * 1000.0F;
                           tp = Integer.parseInt(PMA[s2][4]);
                           tp = Integer.parseInt(PMA[s2][3]);
                           int dmg1000 = (int)(cost1000 - cost1000 * 0.25F * (float)tp + (tp == 0 ? cost1000 * 0.2F : 0.0F));
                           int costTp = (int)(20.0F + cost1000 / 2.0F);
                           int cost = (int)((float)costTp * 1.5F);
                           int tp = JRMCoreH.getInt(p, "jrmcTpint");
                           if (tp - cost >= 0) {
                              JRMCoreH.setInt(tp - cost, p, "jrmcTpint");
                              JRMCoreH.setString("" + s2, p, JRMCoreH.techNbt[b]);
                              p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("nc", "LearnedJutsu"), new Object[0])).func_150255_a(chatStyle));
                           }
                        } else {
                           boolean may = false;
                           if (b == 4) {
                              for(i = 0; i < 4; ++i) {
                                 String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[4 + i]);
                                 if (!NumberUtils.isNumber(s1) && !s1.contains(",")) {
                                    b = (byte)(4 + i);
                                    may = true;
                                    break;
                                 }

                                 may = false;
                              }
                           }

                           PMA = JRMCoreH.pmdbc;
                           i = (int)((float)JRMCoreH.techDBCtpc(PMA[s2], false) * 0.9F);
                           tp = JRMCoreH.getInt(p, "jrmcTpint");
                           if (tp - i >= 0 && may) {
                              JRMCoreH.setInt(tp - i, p, "jrmcTpint");
                              JRMCoreH.setString("" + s2, p, JRMCoreH.techNbt[b]);
                           } else {
                              p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noslotleft"), new Object[0])).func_150255_a(chatStyle));
                           }
                        }
                     }
                  } else {
                     String[] s2 = s.contains(";") ? s.toString().split(";") : null;
                     if (s2 == null) {
                        JRMCoreH.setString(" ", p, JRMCoreH.techNbt[b]);
                     } else {
                        s2 = JRMCoreH.techDBCtpc(s2, false);
                        costTp = JRMCoreH.getInt(p, "jrmcTpint");
                        if (costTp - s2 >= 0) {
                           JRMCoreH.setInt(costTp - s2, p, "jrmcTpint");
                           JRMCoreH.setString(s, p, JRMCoreH.techNbt[b]);
                           JRMCoreH.Tech(p, b, s);
                        }
                     }
                  }
               }
            }
         } else {
            s2 = s.contains(up) ? (b - 1 < (b > 3 ? 4 : 0) ? (b > 3 ? 7 : 3) : b - 1) : (b + 1 > (b > 3 ? 7 : 3) ? (b > 3 ? 4 : 0) : b + 1);
            toteach = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
            String s2 = JRMCoreH.getString(p, JRMCoreH.techNbt[s2]);
            JRMCoreH.setString(toteach, p, JRMCoreH.techNbt[s2]);
            JRMCoreH.setString(s2, p, JRMCoreH.techNbt[b]);
         }

      }
   }

   public void handleAttck(byte b, EntityPlayer p) {
   }

   public void handleCost(short s, EntityPlayer p) {
      NBTTagCompound nbt = this.nbt(p, "pres");
      int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
      byte pwr = nbt.func_74771_c(P);
      byte rce = nbt.func_74771_c(R);
      byte cls = nbt.func_74771_c(Cl);
      JRMCoreH.stat(p, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
      int curBody = JRMCoreH.getInt(p, "jrmcBdy");
      JRMCoreH.stat(p, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs((EntityPlayer)p, pwr));
      int curEnergy = JRMCoreH.getInt(p, "jrmcEnrgy");
      int fc = curEnergy - s;
      if (fc > 0 && !JRMCoreH.isInCreativeMode(p)) {
         JRMCoreH.setInt(fc, p, "jrmcEnrgy");
      }

      if (fc <= 0) {
         JRMCoreH.setInt((int)0, p, "jrmcEnrgy");
         JRMCoreH.setByte((int)0, p, "jrmcRelease");
         JRMCoreH.setInt(curBody + fc, p, "jrmcBdy");
      }

      curBody = JRMCoreH.getInt(p, "jrmcBdy");
      if (curBody < 0) {
         JRMCoreH.setInt((int)0, p, "jrmcBdy");
      }

      JRMCoreH.Stats(p, nbt.func_74762_e("jrmcBdy"), nbt.func_74762_e("jrmcEnrgy"), nbt.func_74762_e("jrmcStamina"), nbt.func_74771_c("jrmcRelease"), nbt.func_74771_c("jrmcSaiRg"));
   }

   public void handleRls(byte b, EntityPlayer p) {
      NBTTagCompound nbt = this.nbt(p, "pres");
      int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
      String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
      byte pwr = nbt.func_74771_c(P);
      byte rce = nbt.func_74771_c(R);
      byte cls = nbt.func_74771_c(Cl);
      byte rls = JRMCoreH.getByte(p, "jrmcRelease");
      byte st2 = nbt.func_74771_c("jrmcState2");
      if (!JRMCoreConfig.release) {
         JRMCoreH.setByte((int)50, p, "jrmcRelease");
      } else {
         int mr = JRMCoreH.SklLvl(pwr == 1 ? 5 : (pwr == 2 ? 10 : 0), pwr, PlyrSkills) * 5;
         if (b == 0 && st2 <= 0) {
            JRMCoreH.setByte((int)0, p, "jrmcRelease");
         }

         if (b == 1 && rls < 100) {
            int relmax = 50 + mr;
            rls = (byte)(rls + 5 > 100 ? 100 : rls + 5);
            rls = (byte)(rls > relmax ? relmax : rls);
            JRMCoreH.setByte(rls, p, "jrmcRelease");
         }

         if (b == 2 && rls > 0 && st2 <= 0) {
            JRMCoreH.setByte(rls - 5 < 0 ? 0 : rls - 5, p, "jrmcRelease");
         }
      }

   }

   public void handleTri(byte b, byte b2, byte b3, EntityPlayer p) {
      NBTTagCompound nbt = this.nbt(p, "pres");
      if (b == 1) {
         int rg;
         if (b2 == RAGE_GAIN_MINUS) {
            rg = nbt.func_74771_c("jrmcSaiRg") - b3;
            nbt.func_74774_a("jrmcSaiRg", rg < 0 ? 0 : (byte)rg);
         }

         if (b2 == RAGE_GAIN_PLUS) {
            rg = nbt.func_74771_c("jrmcSaiRg") + b3;
            nbt.func_74774_a("jrmcSaiRg", rg > 100 ? 100 : (byte)rg);
         }
      }

      ExtendedPlayer props;
      if (b == 2) {
         props = ExtendedPlayer.get(p);
         props.setBlocking(b2);
      }

      int heat;
      byte align;
      if (b == 3) {
         props = ExtendedPlayer.get(p);
         props.setAnimKiShoot(b2);
         props.setAnimKiShootOn(1);
         heat = 0;
         align = 0;
         String StE = nbt.func_74779_i("jrmcStatusEff");
         boolean setGoDOn = JRMCoreH.StusEfcts(20, StE);
         float density = 1.0F;
         float dam = 1.0F;
         int part = 0;
         String data = "";
         byte[] sts = new byte[0];
         byte perc = 100;
         int dam1 = 1;
         boolean isCustomAttack = false;

         try {
            String s1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[b3]));
            if (s1.split(";").length > 1) {
               isCustomAttack = true;
               heat = Integer.parseInt(s1.split(";")[10]);
               density = Float.parseFloat(s1.split(";")[11]);
               dam = Float.parseFloat(s1.split(";")[5]);
               data = s1.split(";")[0];
               sts = new byte[0];
               sts = JRMCoreH.tech_statmods(s1.split(";")[19]);
               perc = 100;
            } else if (!s1.equals(" ") && s1 != null) {
               heat = Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][10]);
               density = Float.parseFloat(JRMCoreH.pmdbc[Integer.parseInt(s1)][11]);
               dam = Float.parseFloat(JRMCoreH.pmdbc[Integer.parseInt(s1)][5]);
               data = JRMCoreH.pmdbc[Integer.parseInt(s1)][0];
            }

            dam1 = JRMCoreH.getEnegyDamage(p, s1.split(";"), sts);
            align = JRMCoreH.getByte(p, "jrmcAlign");
         } catch (Exception var22) {
         }

         if (heat == 0) {
            if (align > 66) {
               heat = 2;
            }

            if (align <= 66 && align >= 33) {
               heat = 3;
            }

            if (align < 33) {
               heat = 4;
            }
         }

         props.setGoDOn(setGoDOn && isCustomAttack && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENABLED ? 1 : 0);
         props.setKiShotCol(heat);
         float size = JRMCoreH.calculateEnergyScale((float)dam1, JRMCoreH.getMaxEnergyDamage(), (float)perc, sts, (byte)((int)density), 0.01F, 0.1F);
         props.setKiShotSiz(size);
         if (!data.toLowerCase().contains("spiritbomb") && !data.toLowerCase().contains("spirit bomb")) {
            if (!data.toLowerCase().contains("kahame") && !data.toLowerCase().contains("kamehame") && !data.toLowerCase().contains("kame hame")) {
               if (data.toLowerCase().contains("galic")) {
                  part = 4;
               } else {
                  try {
                     String s1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[b3]));
                     if (s1.split(";").length > 1) {
                        if (s1 != null && Integer.parseInt(s1.split(";")[3]) == 8 && Integer.parseInt(s1.split(";")[6]) == 1) {
                           part = 3;
                        }
                     } else if (!s1.equals(" ") && JRMCoreH.pmdbc[Integer.parseInt(s1)] != null && Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][3]) == 8 && Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][6]) == 1) {
                        part = 3;
                     }
                  } catch (Exception var21) {
                  }
               }
            } else {
               part = 2;
            }
         } else {
            part = 1;
         }

         props.setKiShotPart(part);
      }

      int heat_max;
      int formID;
      if (b == 4) {
         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
         byte pwr = JRMCoreH.getByte(p, "jrmcPwrtyp");
         align = JRMCoreH.getByte(p, "jrmcRace");
         byte cls = JRMCoreH.getByte(p, "jrmcClass");
         JRMCoreH.stat(p, 5, pwr, 5, PlyrAttrbts[5], align, cls, JRMCoreH.SklLvl_KiBs((EntityPlayer)p, pwr));
         heat_max = JRMCoreH.getInt(p, "jrmcEnrgy");
         int maxStam = JRMCoreH.stat(p, 2, pwr, 3, PlyrAttrbts[2], align, cls, 0.0F);
         formID = JRMCoreH.getInt(p, "jrmcStamina");
         int n = b3 >= 4 ? JRMCoreH.SklLvl(3, (EntityPlayer)p) : JRMCoreH.SklLvl(2, (EntityPlayer)p);
         int cst = (int)((double)((float)maxStam * (b3 == 5 ? 0.1F - 0.005F * (float)n : 0.2F - (b == 4 ? 0.005F : 0.01F) * (float)n)) * DBCConfig.cnfFlncst);
         if (formID > cst) {
            if (!JRMCoreH.isInCreativeMode(p)) {
               JRMCoreH.setInt(formID - cst, p, "jrmcStamina");
            }

            if (b3 != 4) {
               p.world.func_72956_a(p, b3 == 5 ? "jinryuudragonbc:DBC2.swoop" : "jinryuudragonbc:DBC2.tp", 0.25F, p.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }
         }

         if (b3 >= 4) {
            cst = (int)((double)(12 - n) * DBCConfig.cnfFlnck);
            if (heat_max > cst && !JRMCoreH.isInCreativeMode(p)) {
               JRMCoreH.setInt(heat_max - cst, p, "jrmcEnrgy");
            }
         }
      }

      if (b == 5 && b2 == 0 && JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
         byte st2 = nbt.func_74771_c("jrmcState2");
         if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[st2 > 0 ? st2 - 1 : 0] > 0) {
            heat = nbt.func_74762_e("jrmcEf8slc");
            double heatD = nbt.func_74769_h("jrmcEf8slcD");
            int heatGain = 1;
            if (JGConfigDBCFormMastery.FM_Enabled) {
               JGPlayerMP jgPlayer = new JGPlayerMP(p);
               jgPlayer.setNBT(nbt);
               int race = jgPlayer.getRace();
               formID = JRMCoreH.getFormID("UltraInstict", race);
               double masteryLevel = JRMCoreH.getFormMasteryValue(p, formID);
               float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_HEAT_MULTI);
               heatGain = (int)((float)heatGain * costMulti);
            }

            heatD += (double)heatGain;
            heat += (int)heatD;
            heatD -= (double)((int)heatD);
            nbt.func_74780_a("jrmcEf8slcD", heatD);
            heat_max = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[st2 > 0 ? st2 - 1 : 0];
            nbt.func_74768_a("jrmcEf8slc", heat > heat_max ? heat_max : heat);
         }
      }

   }

   public void handleStats3(byte b, byte b2, byte b3, EntityPlayer p) {
      if (JRMCoreConfig.osbic > 0 && (Integer)JRMCoreH.osbic.get(p.getName()) < JRMCoreConfig.osbic * 20) {
         p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((float)(JRMCoreConfig.osbic * 20 - (Integer)JRMCoreH.osbic.get(p.getName())) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
      } else {
         NBTTagCompound nbt = this.nbt(p, "pres");
         JGPlayerMP jgPlayer = new JGPlayerMP(p);
         jgPlayer.setNBT(nbt);
         byte powerType = jgPlayer.getPowerType();
         if (JRMCoreH.isPowerTypeKi(powerType) && (b == 1 || b == 2 || b == 3 || b == 4) && JRMCoreH.isFused(p)) {
            p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
         } else {
            int[] playerAttributes = jgPlayer.getAttributes();
            String[] playerSkills = jgPlayer.getSkills();
            byte race = jgPlayer.getRace();
            int playerSkillsCount = playerSkills.length;
            String PlyrSkillX = jgPlayer.getSkillsX();
            String PlyrSkillY = jgPlayer.getSkillsY();
            int[][] rSklsMR = (int[][])null;
            int[][] cSklsMR = (int[][])null;
            String[] rSkls;
            int[][] rSklsLvl;
            String[] rSklsNms;
            String[] cSkls;
            int[][] cSklsLvl;
            String[] cSklsNms;
            String[] skls;
            int[] sklsUps;
            int[][] sklsLvl;
            String[] sklsNms;
            int[][] sklsMR;
            String var27;
            if (JRMCoreH.isPowerTypeChakra(powerType)) {
               rSkls = JRMCoreH.ncRSkls;
               rSklsLvl = JRMCoreH.ncRSklsLvl;
               rSklsNms = JRMCoreH.ncRSklsNms;
               cSkls = JRMCoreH.ncCSkls;
               cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
               cSklsNms = JRMCoreH.NCRacialSkillAbilityNames;
               cSklsMR = JRMCoreH.NCRacialSkillMindCost;
               skls = JRMCoreH.NCSkillIDs;
               sklsUps = JRMCoreH.ncSklsUps;
               sklsLvl = JRMCoreH.NCSkillTPCost;
               sklsNms = JRMCoreH.NCSkillNames;
               sklsMR = JRMCoreH.NCSkillMindCost;
               var27 = "nc";
            } else {
               rSkls = JRMCoreH.vlblRSkls;
               rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
               rSklsNms = JRMCoreH.vlblRSklsNms;
               rSklsMR = JRMCoreH.DBCRacialSkillMindCost;
               cSkls = JRMCoreH.vlblCSkls;
               cSklsLvl = JRMCoreH.vlblCSklsLvl;
               cSklsNms = JRMCoreH.vlblCSklsNms;
               skls = JRMCoreH.DBCSkillsIDs;
               sklsUps = JRMCoreH.vlblSklsUps;
               sklsLvl = JRMCoreH.DBCSkillTPCost;
               sklsNms = JRMCoreH.DBCSkillNames;
               sklsMR = JRMCoreH.DBCSkillMindCost;
               var27 = "dbc";
            }

            int skillLevels = JRMCoreH.skillSlot_SpentMindRequirement(playerSkills, skls, sklsMR) + JRMCoreH.skillSlot_SpentMindRequirement_X(PlyrSkillX, race, rSklsMR) + JRMCoreH.skillSlot_SpentMindRequirement(PlyrSkillY, cSkls, cSklsMR);
            boolean SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], skillLevels);
            boolean doit;
            int tpCost;
            int tpCost;
            String sn2;
            int currentTP;
            if (b == 1) {
               doit = true;
               if (b2 == 16 && JGConfigUltraInstinct.CONFIG_UI_LEVELS == 0) {
                  doit = false;
               }

               if (doit) {
                  int currentTP = nbt.func_74762_e("jrmcTpint");
                  tpCost = JRMCoreH.getSkillTPCost(b2, 0, JRMCoreH.isPowerTypeKi(powerType));
                  boolean bln = true;
                  boolean tc = false;
                  if (JRMCoreH.isPowerTypeKi(powerType) && b2 == 10) {
                     bln = false;
                     tc = currentTP >= tpCost;
                  }

                  if (bln && tpCost != -1 && currentTP >= tpCost || !bln && tc) {
                     boolean saiNotMxdSkl = JRMCoreH.isPowerTypeKi(powerType) && b2 == 9 ? JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godKiAble(race, JRMCoreH.SklLvlX(p)) : true;
                     if (!saiNotMxdSkl) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", JRMCoreH.rc_sai(race) ? "needRacialSkillMax" : "cantLearnThis"), new Object[0])).func_150255_a(chatStyle));
                        return;
                     }

                     boolean stop = false;
                     tpCost = 0;

                     for(byte i = 0; i < playerSkillsCount; ++i) {
                        if (playerSkills[i].contains(skls[b2])) {
                           stop = true;
                        }

                        if (playerSkills[i].length() > 2) {
                           ++tpCost;
                        }
                     }

                     currentTP = JRMCoreH.skillMindRequirement(skls[b2], skls, sklsMR);
                     int mindRequirementResult = skillLevels + currentTP;
                     SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], mindRequirementResult);
                     sn2 = nbt.func_74779_i("jrmcStatusEff");
                     boolean isFused = JRMCoreH.isFused(p);
                     if (isFused) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
                     } else if (JRMCoreH.isPowerTypeKi(powerType) && b2 == 0 && !JRMCoreConfig.fuzn) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "skilldisabled"), new Object[0])).func_150255_a(chatStyle));
                     } else if (stop) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "alreadyhaveskill"), new Object[0])).func_150255_a(chatStyle));
                     } else if (!SklSlt) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nomindleft"), new Object[0])).func_150255_a(chatStyle));
                     } else {
                        nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[b2] + "0"));
                        int tpResult = currentTP - tpCost;
                        nbt.func_74768_a("jrmcTpint", tpResult);
                     }
                  }
               }
            } else {
               String StE;
               if (b == 2) {
                  if (playerSkills[b2].contains(skls[8])) {
                     JRMCoreH.PlyrSettingsRem((EntityPlayer)p, 0);
                  }

                  StE = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(playerSkills[b2], ""));
                  nbt.func_74778_a("jrmcSSlts", StE.length() < 3 ? "," : StE);
               } else {
                  String bns;
                  boolean hasGoD;
                  String skill;
                  String sklnm;
                  int skillLvl;
                  if (b == 3) {
                     doit = true;
                     bns = nbt.func_74779_i("jrmcStatusEff");
                     hasGoD = JRMCoreH.StusEfcts(10, bns) || JRMCoreH.StusEfcts(11, bns);
                     if (hasGoD) {
                        p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
                        return;
                     }

                     skill = b2 == 100 ? "jrmcSSltX" : (b2 == 101 ? "jrmcSSltY" : (b2 == 102 ? "jrmcSSltZ" : "jrmcSSlts"));
                     sklnm = nbt.func_74779_i(skill);
                     int d;
                     if (skill.equals("jrmcSSlts")) {
                        skillLvl = JRMCoreH.skillMindRequirement(playerSkills[b2], skls, sklsMR);
                        d = skillLevels + skillLvl;
                        SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], d);
                        sklnm = playerSkills[b2];
                        if (!SklSlt) {
                           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nomindleft"), new Object[0])).func_150255_a(chatStyle));
                        }
                     } else if (b2 == 100) {
                        skillLvl = JRMCoreH.skillMindRequirement_X(sklnm, race, rSklsMR);
                        d = skillLevels + skillLvl;
                        SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], d);
                        doit = JRMCoreConfig.dat5711;
                     } else if (b2 == 101) {
                        skillLvl = JRMCoreH.skillMindRequirement(sklnm, cSkls, cSklsMR);
                        d = skillLevels + skillLvl;
                        SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], d);
                        doit = JRMCoreConfig.dat5711;
                     }

                     if (!sklnm.equals("pty") && doit) {
                        skillLvl = Integer.parseInt(sklnm.substring(2)) + 1;
                        d = JRMCoreH.pwr_ki(powerType) && !JRMCoreH.rSai(race) && sklnm.contains(skls[9]) ? -1 : JRMCoreH.SklInit(sklnm, skls, sklsUps);
                        String info;
                        if (skillLvl - 1 <= d) {
                           if (b3 == 1) {
                              int tpCost = false;
                              if (b2 == 100) {
                                 tpCost = JRMCoreH.skillTPCost_X(PlyrSkillX, race, rSklsLvl);
                              } else if (b2 == 101) {
                                 tpCost = JRMCoreH.skillTPCost_X(PlyrSkillY, race, cSklsLvl);
                              } else {
                                 tpCost = JRMCoreH.skillTPCost(sklnm, skls, sklsLvl);
                              }

                              currentTP = nbt.func_74762_e("jrmcTpint");
                              if (JRMCoreH.rSai(race) && b2 == 100) {
                                 skillLvl = skillLvl > 7 ? 7 : skillLvl;
                              } else if (race == 4 && b2 == 100) {
                                 skillLvl = skillLvl > 6 ? 6 : skillLvl;
                              } else if (race != 4 && b2 == 100) {
                                 skillLvl = skillLvl > 5 ? 5 : skillLvl;
                              } else if (JRMCoreH.isPowerTypeKi(powerType) && b2 < 100 && sklnm.contains(skls[9]) && skillLvl > d + 1) {
                                 skillLvl = skillLvl > d + 1 ? d + 1 : skillLvl;
                              }

                              if (tpCost != -1 && currentTP >= tpCost && SklSlt) {
                                 String nskl = sklnm.substring(0, 2) + (skillLvl >= 10 ? 9 : skillLvl);
                                 if (skill.equals("jrmcSSlts")) {
                                    sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(sklnm, nskl));
                                    nbt.func_74778_a(skill, sn2);
                                 } else {
                                    nbt.func_74778_a(skill, nskl);
                                 }

                                 if (!sklnm.equalsIgnoreCase(nskl)) {
                                    nbt.func_74768_a("jrmcTpint", currentTP - tpCost);
                                 }
                              }
                           } else if (JRMCoreConfig.DebugInfo) {
                              info = "JRMC has found Potential hacking at ID:05 by player: %s";
                              mod_JRMCore.logger.info(String.format(info, p.getName()));
                              CommandBase.func_152373_a(p, (ICommand)null, info, new Object[]{p.getName()});
                           }
                        } else {
                           info = "JRMC has blocked an action at ID:10 by player: %s for: %s";
                           mod_JRMCore.logger.info(String.format(info, p.getName(), sklnm));
                        }
                     } else if (!sklnm.equals("pty") && !doit) {
                        String info = "JRMC has found Potential hacking at ID:15 by player: %s";
                        mod_JRMCore.logger.info(String.format(info, p.getName(), sklnm));
                     }
                  } else if (b == 4) {
                     StE = b2 == 100 ? "jrmcSSltX" : (b2 == 101 ? "jrmcSSltY" : "jrmcSSlts");
                     bns = nbt.func_74779_i(StE);
                     if (StE.equals("jrmcSSlts")) {
                        bns = playerSkills[b2];
                     }

                     tpCost = Integer.parseInt(bns.substring(2)) - 1;
                     skill = bns.substring(0, 2) + (tpCost <= -1 ? 0 : tpCost);
                     if (StE.equals("jrmcSSlts")) {
                        sklnm = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(bns, skill));
                        nbt.func_74778_a(StE, sklnm);
                     } else {
                        nbt.func_74778_a(StE, skill);
                     }
                  } else if (b == 5) {
                     StE = nbt.func_74779_i("jrmcStatusEff");
                     bns = JRMCoreH.StusEfcts[b3];
                     if (b2 == 0) {
                        nbt.func_74778_a("jrmcStatusEff", StE.contains(bns) ? StE : StE + bns);
                     }

                     if (b2 == 1) {
                        nbt.func_74778_a("jrmcStatusEff", StE.contains(bns) ? StE.replace(bns, "") : StE);
                     }

                     if (b3 == 3 && b2 == 0 && !JRMCoreH.isInCreativeMode(p)) {
                        hasGoD = jgPlayer.hasStatusEffect(20, StE);
                        if (hasGoD && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA && JGConfigDBCGoD.CONFIG_GOD_ENABLED) {
                           int curEnergy = jgPlayer.getEnergy();
                           byte classID = jgPlayer.getClassID();
                           skillLvl = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs((String[])playerSkills, powerType));
                           float cost = JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[1] * (float)skillLvl;
                           cost += JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[0];
                           if (curEnergy > (int)cost) {
                              curEnergy -= (int)cost;
                           } else {
                              JRMCoreH.StusEfcts(3, StE, (NBTTagCompound)nbt, false);
                           }

                           JRMCoreH.setInt(curEnergy, p, "jrmcEnrgy");
                        }
                     }
                  } else if (b == 6) {
                     if (b3 == 0) {
                        JRMCoreH.PlyrSettingsOn((EntityPlayer)p, b2);
                     }

                     if (b3 == 1) {
                        JRMCoreH.PlyrSettingsRem((EntityPlayer)p, b2);
                     }
                  } else if (b == 8) {
                     JRMCoreH.PlyrSettingsSet((NBTTagCompound)nbt, b2, b3);
                  }
               }
            }

         }
      }
   }

   public void handleStats2(int curTP, int curExp, byte align, int[] PlyrAttrbts) {
   }

   public void handleStats(int curBody, int curEnergy, byte curRelease, byte b) {
   }

   public void handleUpgrade(byte b, EntityPlayer p) {
      if (JRMCoreConfig.osbic > 0 && (Integer)JRMCoreH.osbic.get(p.getName()) < JRMCoreConfig.osbic * 20) {
         p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((float)(JRMCoreConfig.osbic * 20 - (Integer)JRMCoreH.osbic.get(p.getName())) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
      } else {
         NBTTagCompound nbt = this.nbt(p, "pres");
         JGPlayerMP jgPlayer = new JGPlayerMP(p);
         jgPlayer.setNBT(nbt);
         byte powerType = jgPlayer.getPowerType();
         if (JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isFused(p)) {
            p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
         } else {
            int[] playerAttributes = jgPlayer.getAttributes();
            String[] playerSkills = jgPlayer.getSkills();
            byte race = jgPlayer.getRace();
            byte classID = jgPlayer.getClassID();
            int curBody = jgPlayer.getHealth();
            int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
            int curEnergy = jgPlayer.getEnergy();
            int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs((String[])playerSkills, powerType));
            int curStam = jgPlayer.getStamina();
            int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
            int ap;
            if (!JRMCoreH.isPowerTypeKi(powerType) && !JRMCoreH.isPowerTypeChakra(powerType)) {
               if (JRMCoreH.isPowerTypeSAO(powerType)) {
                  ap = nbt.func_74762_e("saocAp");
                  if (ap > 0) {
                     nbt.func_74768_a(JRMCoreH.AttrbtNbtI[b], (short)(nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b]) + 1));
                     nbt.func_74768_a("saocAp", nbt.func_74762_e("saocAp") - 1);
                     if (b == 2) {
                        playerAttributes = JRMCoreH.PlyrAttrbts(p);
                        maxBody = JRMCoreH.stat(p, 2, powerType, 2, playerAttributes[2], race, classID, 0.0F);
                        double incBody = (double)JRMCoreH.statInc(powerType, 2, 1, race, classID, 0.0F);
                        JRMCoreH.setInt((int)((double)curBody + incBody > (double)maxBody ? (double)maxBody : (double)curBody + incBody), p, "jrmcBdy");
                     }
                  }
               }
            } else {
               ap = b / 6;
               int cost = JRMCoreH.attrCst(playerAttributes, ap);
               if (cost > 0 && nbt.func_74762_e("jrmcTpint") >= cost && nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b % 6]) < hdN7rK()) {
                  int pr = nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b % 6]);
                  pr = pr < 1 ? (pr + '耀') / 2 + '耀' : pr;
                  int to = pr + 1 * JRMCoreH.attributeMultiplier(ap);
                  if (to > JRMCoreConfig.tmx) {
                     return;
                  }

                  nbt.func_74768_a("jrmcTpint", nbt.func_74762_e("jrmcTpint") - cost);
                  nbt.func_74768_a(JRMCoreH.AttrbtNbtI[b % 6], v2tBFN(to));
                  double incBody = (double)JRMCoreH.statInc(powerType, 2, 1, race, classID, 0.0F);
                  JRMCoreH.setInt((int)((double)curBody + incBody > (double)maxBody ? (double)maxBody : (double)curBody + incBody), p, "jrmcBdy");
                  double incEnergy = (double)JRMCoreH.statInc(powerType, 5, 1, race, classID, JRMCoreH.SklLvl_KiBs((String[])playerSkills, powerType));
                  JRMCoreH.setInt((int)((double)curEnergy + incEnergy > (double)maxEnergy ? (double)maxEnergy : (double)curEnergy + incEnergy), p, "jrmcEnrgy");
                  double incStam = (double)JRMCoreH.statInc(powerType, 3, 1, race, classID, 0.0F);
                  JRMCoreH.setInt((int)((double)curStam + incStam > (double)maxStam ? (double)maxStam : (double)curStam + incStam), p, "jrmcStamina");
               }
            }

            JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), playerAttributes);
         }
      }
   }

   public void handleChar(byte b, int b2, EntityPlayer p) {
      NBTTagCompound nbt = this.nbt(p, "pres");
      int i = true;
      byte acc = nbt.func_74771_c(Acc);
      byte pwrtyp = nbt.func_74771_c(P);
      byte rce = nbt.func_74771_c(R);
      byte cls = nbt.func_74771_c(Cl);
      byte st = nbt.func_74771_c(St);
      if (acc == 0 && b == this.b(0)) {
         nbt.func_74774_a(R, (byte)b2);
         nbt.func_74774_a(St, (byte)(rce == 4 ? 4 : 0));
      }

      if (acc == 0 && b == 106) {
         nbt.func_74774_a(St, (byte)(rce == 4 ? b2 : 0));
      }

      if (acc == 0 && b == this.b(7)) {
         nbt.func_74776_a("JRYCAge", (float)JRMCoreH.YearsD[b2]);
      }

      if (acc == 0 && b == this.b(2)) {
         nbt.func_74774_a(P, (byte)b2);
      }

      if (acc == 0 && b == this.b(3)) {
         nbt.func_74774_a(Cl, (byte)b2);
      }

      int[] PlyrAttrbts;
      int maxBody;
      if (acc == 0 && b == this.b(4)) {
         boolean doit = true;
         if (JRMCoreH.DBC()) {
            doit = !JRMCoreH.isFused(p);
         }

         if (doit) {
            nbt.func_74774_a(Acc, (byte)b2);
            int j;
            if (pwrtyp != 1 && pwrtyp != 2) {
               for(j = 0; j < 3; ++j) {
                  nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], JRMCoreH.attributeStart(pwrtyp, j, rce, cls));
               }

               PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
               maxBody = JRMCoreH.stat(p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
               JRMCoreH.setInt(maxBody, p, "jrmcBdy");
            } else {
               nbt.func_74774_a(St, (byte)(rce == 4 ? 4 : 0));
               j = JRMCoreH.getInt(p, "jrmcRencrnt");
               int j;
               if (j == 1) {
                  JRMCoreH.setInt((int)0, p, "jrmcRencrnt");

                  for(j = 0; j < 6; ++j) {
                     int a = JRMCoreH.getInt(p, JRMCoreH.AttrbtNbtR[j]);
                     int s = JRMCoreH.attributeStart(pwrtyp, j, rce, cls);
                     nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], a > s ? a : s);
                     JRMCoreH.setInt((int)0, p, JRMCoreH.AttrbtNbtR[j]);
                  }
               } else {
                  for(j = 0; j < 6; ++j) {
                     nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], JRMCoreH.attributeStart(pwrtyp, j, rce, cls));
                  }
               }

               PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
               maxBody = JRMCoreH.stat(p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
               JRMCoreH.setInt(maxBody, p, "jrmcBdy");
               int maxEnergy = JRMCoreH.stat(p, 5, pwrtyp, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs((EntityPlayer)p, pwrtyp));
               JRMCoreH.setInt(maxEnergy, p, "jrmcEnrgy");
            }

            JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), PlyrAttrbts);
            nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(nbt.func_74771_c(R), nbt.func_74771_c(Cl), pwrtyp));
            nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(nbt.func_74771_c(R), nbt.func_74771_c(Cl), pwrtyp));
            nbt.func_74768_a("jrmcArcRsrv", 0);
            nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
         }
      }

      if (b == this.b(5) && nbt.func_74771_c(Diff) < b2) {
         nbt.func_74774_a(Diff, (byte)b2);
      }

      if (b == this.b(6)) {
         nbt.func_74774_a(Ptch, (byte)b2);
      }

      if (b == 100 && !JRMCoreH.isFused(p)) {
         JRMCoreH.resetDedSer();
         JRMCoreH.resetChar(p);
      }

      if (b == 101 && nbt.func_74771_c(Diff) >= 1 && nbt.func_74762_e("jrmcDiffRed") <= 1) {
         nbt.func_74768_a("jrmcDiffRed", 2400 * nbt.func_74771_c(Diff));
      }

      if (b == 102) {
         if (nbt.func_74771_c("jrmcTlmd") != 0 && nbt.func_74771_c("jrmcTlmd") != -1) {
            if (nbt.func_74771_c("jrmcTlmd") == 1) {
               nbt.func_74774_a("jrmcTlmd", (byte)0);
            }
         } else {
            nbt.func_74774_a("jrmcTlmd", (byte)1);
         }
      }

      if (acc == 0 && b == 103) {
         if (b2 == 0) {
            nbt.func_74774_a("jrmcTlmd", (byte)2);
         }

         if (b2 == 1) {
            nbt.func_74774_a("jrmcTlmd", (byte)0);
         }
      }

      if (b == 104) {
         if (nbt.func_74771_c("jrmcTlmd") == 0 || nbt.func_74771_c("jrmcTlmd") == -1 || nbt.func_74771_c("jrmcTlmd") == 1) {
            nbt.func_74774_a("jrmcTlmd", (byte)3);
         }

         int state = JRMCoreH.getByte(p, "jrmcState");
         if (state == 7 || state == 8 || state == 14) {
            JRMCoreH.setByte((int)0, p, "jrmcState");
         }
      }

      if (b == 105) {
         int tp = nbt.func_74762_e("jrmcTpint");
         PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
         maxBody = JRMCoreH.stat(p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
         if ((nbt.func_74771_c("jrmcTlmd") == 3 || nbt.func_74771_c("jrmcTlmd") == 4) && tp >= 20) {
            nbt.func_74768_a("jrmcTpint", tp - 20);
            JRMCoreH.jrmcDam(p, (int)((float)maxBody * 0.1F), (DamageSource)null);
            nbt.func_74774_a("jrmcTlmd", (byte)0);
         }
      }

   }

   public void handleCol(int i, byte b, EntityPlayer p) {
      this.nbt(p, "pres");
   }

   public void handleTick(int jrmcpg, String jrmcp, EntityPlayer p) {
      NBTTagCompound nbt = this.nbt(p, "pres");
      if (jrmcpg == 1) {
         if (nbt.func_74781_a("jrmcAlign") == null) {
            nbt.func_74774_a("jrmcAlign", (byte)67);
         }

         if (nbt.func_74771_c("jrmcAlign") > 100) {
            nbt.func_74774_a("jrmcAlign", (byte)100);
         }

         if (nbt.func_74771_c("jrmcAlign") < 0) {
            nbt.func_74774_a("jrmcAlign", (byte)0);
         }

         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
         String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");

         for(byte i = 0; i < JRMCoreH.AttrbtNbtI.length; ++i) {
            if (nbt.func_74781_a(JRMCoreH.AttrbtNbtI[i]) == null) {
               nbt.func_74768_a(JRMCoreH.AttrbtNbtI[i], 1);
            }

            PlyrAttrbts[i] = nbt.func_74762_e(JRMCoreH.AttrbtNbtI[i]);
         }

         JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), PlyrAttrbts);
      }

      if (jrmcpg == 3) {
         if (nbt.func_74781_a("jrmcSSltX") == null) {
            nbt.func_74778_a("jrmcSSltX", "pty");
         }

         if (nbt.func_74781_a("jrmcSSltY") == null) {
            nbt.func_74778_a("jrmcSSltY", "pty");
         }

         nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(nbt.func_74771_c(R), nbt.func_74771_c(Cl), nbt.func_74771_c(P)));
         nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(nbt.func_74771_c(R), nbt.func_74771_c(Cl), nbt.func_74771_c(P)));
         JRMCoreH.Stats3(p, nbt.func_74779_i("jrmcSSlts"), nbt.func_74779_i("jrmcSSltX"), nbt.func_74779_i("jrmcSSltY"), nbt.func_74779_i("jrmcSSltZ"));
      }

      if (jrmcpg == -1) {
         for(byte i = 0; i < 4; ++i) {
            String s = JRMCoreH.getString(p, JRMCoreH.techNbt[i]);
            JRMCoreH.Tech(p, i, s);
         }
      }

   }

   int calc1(int j, int l) {
      int i = 0;

      for(int k = 0; k < j; ++k) {
         i += i + l;
      }

      return i;
   }

   int calc2(int j, int l) {
      int i = 0;

      for(int k = 0; k < j / l; ++k) {
         int z = k * l / 50 <= 0 ? 1 : k * l / 50;
         i += z;
      }

      return i;
   }

   public static int dS9XgQ(String l) {
      String w = "0123456789ABCDEF";
      l = l.toUpperCase();
      int a = 0;

      for(int i = 0; i < l.length(); ++i) {
         char c = l.charAt(i);
         int d = w.indexOf(c);
         a = 16 * a + d;
      }

      return a;
   }

   public static int hdN7rK() {
      int b = JRMCoreConfig.tmx;
      String r = "64";
      String k = "3B9ACA00";
      return b > dS9XgQ(k) ? dS9XgQ(k) : (b < dS9XgQ(r) ? 0 : b);
   }

   public static int v2tBFN(int b) {
      String k = "3B9ACA00";
      return b > dS9XgQ(k) ? dS9XgQ(k) : b;
   }

   public byte b(int n) {
      return (byte)n;
   }

   public NBTTagCompound nbt(EntityPlayer p, String s) {
      return JRMCoreH.nbt(p, s);
   }

   public void jrmct(int tick, String s, EntityPlayer p) {
      JRMCoreH.jrmct(tick, s, p);
   }

   static {
      chatStyle = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
      RAGE_GAIN_PLUS = 0;
      RAGE_GAIN_MINUS = 1;
      ckr = new HashMap();
      R = "jrmcRace";
      P = "jrmcPwrtyp";
      Cl = "jrmcClass";
      Acc = "jrmcAccept";
      St = "jrmcState";
      Diff = "jrmcDiff";
      Ptch = "jrmcPtch";
   }
}
