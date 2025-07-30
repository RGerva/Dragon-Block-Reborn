package JinRyuu.JRMCore.p;

import JinRyuu.FamilyC.EntityNPC;
import JinRyuu.FamilyC.FamilyCCharGui;
import JinRyuu.FamilyC.FamilyCConfig;
import JinRyuu.JRMCore.FamilyCH;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class FamilyCP implements IMessage {
   public static final int FORM_FAMILY = 0;
   public static final int PROPOSE_INVITE = 1;
   public static final int ADOPT_INVITE = 2;
   public static final int ACCEPT_PROPOSE = 3;
   public static final int ACCEPT_ADOPT = 4;
   public static final int DECLINE_BOTH_ADOPT_AND_PROPOSE = 5;
   public static final int LEAVE_DIVORCE = 6;
   public static final int DISINHERIT_FORCE_DIVORCE_UNADOPT_CHILD = 7;
   public static final int ACCEPT_PROCREATION = 8;
   public static final int DECLINE_PROCREATION = 9;
   public static final int OFFER_PROCREATION = 10;
   public static final int NPC_CHANGE_DATA = 20;
   public static final int PLAYER_PARENT_AND_CHILD_DATA_WHEN_GUI_OPENED = 21;
   public static final int NPC_CHANGE_NAME = 22;
   public static final int NPC_CHANGE_DNS = 23;
   int id;
   String txt;

   public FamilyCP() {
   }

   public FamilyCP(int id, String txt) {
      this.id = id;
      this.txt = txt;
   }

   public void toBytes(ByteBuf buffer) {
      buffer.writeInt(this.id);
      ByteBufUtils.writeUTF8String(buffer, this.txt);
   }

   public void fromBytes(ByteBuf buffer) {
      this.id = buffer.readInt();
      this.txt = ByteBufUtils.readUTF8String(buffer);
   }

   public static class Handler extends BAmh<FamilyCP> {
      private static int dnsRaceSlcted;
      private static int dnsGenderSlcted;
      private static int dnsHairSlcted;
      private static int dnsHair2Slcted;
      private static int dnsColorSlcted;
      private static int dnsBreastSizeSlcted;
      private static int dnsBodyTypeSlcted;
      private static int dnsBodyColMainSlcted;
      private static int dnsBodyColSub1Slcted;
      private static int dnsBodyColSub2Slcted;
      private static int dnsBodyColSub3Slcted;
      private static int dnsFaceNoseSlcted;
      private static int dnsFaceMouthSlcted;
      private static int dnsEyesSlcted;
      private static int dnsEyeCol1Slcted;
      private static int dnsEyeCol2Slcted;
      private static String dns;

      public IMessage handleClientMessage(EntityPlayer p, FamilyCP msg, MessageContext ctx) {
         int id = msg.id;
         String txt = msg.txt;
         if (id == 20) {
            String[] dat = txt.split(":");
            int eid = Integer.parseInt(dat[0]);
            String follow = dat[1];
            String aggro = dat[2];
            String fid = dat[3];
            String d = dat[4];
            String m = dat[5];
            int cn = Integer.parseInt(dat[6]);
            Entity pl = p.field_70170_p.func_73045_a(eid);
            if (pl instanceof EntityNPC && pl != null) {
               FamilyCCharGui.dtcf = follow;
               FamilyCCharGui.dtca = aggro;
               FamilyCCharGui.dtcft = fid;
               FamilyCCharGui.dtcdad = d;
               FamilyCCharGui.dtcmom = m;
               FamilyCCharGui.inv = cn == 1 ? -1 : 0;
            }
         }

         if (id == 21) {
            FamilyCCharGui.children = txt;
         }

         if (id == 23) {
            int n = Integer.parseInt(txt);
            Entity pl = p.field_70170_p.func_73045_a(n);
            if (pl != null && pl instanceof EntityNPC) {
               EntityNPC npl = (EntityNPC)pl;
               npl.setNamUpdt(true);
            }
         }

         return null;
      }

      public IMessage handleServerMessage(EntityPlayer p, FamilyCP m, MessageContext ctx) {
         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
         int id = m.id;
         String txt = m.txt;
         MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
         String y = JRMCoreH.cly;
         String g = JRMCoreH.clgd;
         String dns = JRMCoreH.getString(p, "jrmcDNS");
         String[] dat;
         String n;
         String type;
         String dnsNPC;
         if (id == 0) {
            dat = txt.split(",");
            n = dat[0] + ",0";
            type = txt + "!" + p.func_70005_c_() + ",e!0";
            dnsNPC = JRMCoreH.getString(p, FamilyCH.FID);
            if (FamilyCH.rfi(server, dat[0] + ",0").equals("0") && dnsNPC.length() < 2) {
               FamilyCH.wfi(server, type, n, false);
               JRMCoreH.setString(n, p, FamilyCH.FID);
               p.func_145747_a((new ChatComponentText(y + g + dat[0] + y + " Family has been created!")).func_150255_a(color));
            } else {
               p.func_145747_a((new ChatComponentText(y + "Family already exists, can't create another family!")).func_150255_a(color));
            }
         }

         EntityPlayerMP pi;
         String d;
         String prid;
         String[] p1d;
         if (id == 1) {
            prid = JRMCoreH.getString(p, FamilyCH.FID);
            n = p.func_70005_c_();
            p1d = prid.split(",");
            dnsNPC = p1d[0];
            pi = JRMCoreH.getPlayerForUsername(server, txt);
            if (pi != null) {
               d = JRMCoreH.getString(pi, FamilyCH.FID);
               if (d.length() < 2) {
                  JRMCoreH.setString("", pi, FamilyCH.FIDa);
                  JRMCoreH.setString(p.func_70005_c_(), pi, FamilyCH.FIDi);
                  pi.func_145747_a((new ChatComponentText(y + "" + g + n + y + " sent you a proposal" + (dnsNPC.length() > 1 ? " from the " + g + dnsNPC + y + " family" : "") + "!")).func_150255_a(color));
               }
            }
         }

         String[] prt;
         if (id == 2) {
            prid = JRMCoreH.getString(p, FamilyCH.FID);
            n = p.func_70005_c_();
            p1d = prid.split(",");
            dnsNPC = p1d[0];
            pi = JRMCoreH.getPlayerForUsername(server, txt);
            if (pi != null) {
               d = JRMCoreH.getString(pi, FamilyCH.FID);
               if (d.length() < 2) {
                  JRMCoreH.setString("", pi, FamilyCH.FIDi);
                  JRMCoreH.setString(p.func_70005_c_(), pi, FamilyCH.FIDa);
                  prt = dnsNPC.split(",");
                  pi.func_145747_a((new ChatComponentText(y + "" + g + p.func_70005_c_() + y + " wants to adopt you" + (dnsNPC.length() > 1 ? ". So you'd be apart of the " + g + prt[0] + y + " family" : "") + "!")).func_150255_a(color));
               }
            }
         }

         String[] fm;
         String prid;
         String[] fm;
         int H1F;
         String afm;
         boolean nnf;
         String fn;
         int B1T;
         String fD;
         String[] fh2;
         EntityPlayerMP pt;
         String[] fida;
         int drp;
         String fn;
         String fh;
         String[] fma;
         if (id == 3) {
            prid = JRMCoreH.getString(p, FamilyCH.FIDi);
            pt = JRMCoreH.getPlayerForUsername(server, prid);
            type = JRMCoreH.getString(p, FamilyCH.FID);
            if (pt != null && type.length() < 2) {
               dnsNPC = JRMCoreH.getString(pt, FamilyCH.FID);
               fida = dnsNPC.split(",");
               drp = Integer.parseInt(fida[1]);
               fn = FamilyCH.rfi(server, dnsNPC);
               fm = fn.split("!");
               prid = drp == 0 ? fm[0] : "";
               fm = drp == 0 ? fm[1].split(",") : fm[0].split(",");
               H1F = drp == 0 ? Integer.parseInt(fm[2]) : 0;
               afm = "";
               nnf = false;
               fn = "";

               for(B1T = 0; B1T < fm.length; ++B1T) {
                  fD = fm[B1T];
                  fh2 = fD.split(":");
                  if (B1T > 1 && fh2[0].equalsIgnoreCase(prid)) {
                     nnf = true;
                     fn = fh2[1];
                  }
               }

               if (nnf) {
                  fh = prid + "," + p.func_70005_c_();
                  fD = fida[0] + "," + fn;
                  JRMCoreH.setString(dnsNPC, pt, FamilyCH.FIDo);
                  JRMCoreH.setString(fD, pt, FamilyCH.FID);
                  JRMCoreH.setString(fD, p, FamilyCH.FID);
                  FamilyCH.wfi(server, fh, fD, false);
               } else {
                  for(B1T = 0; B1T < fm.length; ++B1T) {
                     fD = fm[B1T];
                     if (fD.length() < 2 && !fD.equalsIgnoreCase(prid) && B1T < 2) {
                        afm = afm + "," + p.func_70005_c_();
                        JRMCoreH.setString(dnsNPC, p, FamilyCH.FID);
                        JRMCoreH.setString("", p, FamilyCH.FIDi);
                        JRMCoreH.setString("", p, FamilyCH.FIDa);
                     } else {
                        afm = afm + "," + fD;
                     }
                  }

                  afm = afm.substring(1);
                  fh = drp == 0 ? prid + "!" + afm + "!" + H1F : afm;
                  FamilyCH.wfi(server, fh, dnsNPC, false);
               }

               fma = prid.split(",");
               pt.func_145747_a((new ChatComponentText(y + "Proposal was accepted! You were married to " + g + p.func_70005_c_() + y + " and " + y + "joined the " + g + fma[0] + y + " family!")).func_150255_a(color));
               p.func_145747_a((new ChatComponentText(y + "You have married " + g + pt.func_70005_c_() + y + " and so you joined the " + g + fma[0] + y + " family!")).func_150255_a(color));
            } else {
               p.func_145747_a((new ChatComponentText(y + "Marriage failed because " + g + prid + y + " was not found!")).func_150255_a(color));
            }

            JRMCoreH.setString("", p, FamilyCH.FIDi);
            JRMCoreH.setString("", p, FamilyCH.FIDa);
         }

         if (id == 4) {
            prid = JRMCoreH.getString(p, FamilyCH.FIDa);
            pt = JRMCoreH.getPlayerForUsername(server, prid);
            type = JRMCoreH.getString(p, FamilyCH.FID);
            if (pt != null && type.length() < 2) {
               dnsNPC = JRMCoreH.getString(pt, FamilyCH.FID);
               fida = dnsNPC.split(",");
               drp = Integer.parseInt(fida[1]);
               fn = FamilyCH.rfi(server, dnsNPC);
               fm = fn.split("!");
               prid = drp == 0 ? fm[0] : "";
               fm = drp == 0 ? fm[1].split(",") : fm[0].split(",");
               if (drp == 0) {
                  Integer.parseInt(fm[2]);
               } else {
                  boolean var10000 = false;
               }

               afm = "";
               nnf = false;
               fn = "";

               for(B1T = 0; B1T < fm.length; ++B1T) {
                  fD = fm[B1T];
                  fh2 = fD.split(":");
                  if (B1T > 1 && fh2[0].equalsIgnoreCase(prid)) {
                     nnf = true;
                     fn = fh2[1];
                  }
               }

               fh = fida[0] + ",0";
               fD = FamilyCH.rfi(server, fh);
               fh2 = fD.split("!");
               H1F = Integer.parseInt(fh2[2]);
               ++H1F;
               if (nnf) {
                  afm = prid + ",e," + p.func_70005_c_() + ":" + H1F;
                  fh = fida[0] + "," + fn;
                  JRMCoreH.setString(dnsNPC, pt, FamilyCH.FIDo);
                  JRMCoreH.setString(fh, pt, FamilyCH.FID);
                  JRMCoreH.setString(fh, p, FamilyCH.FID);
                  FamilyCH.wfi(server, afm, fh, false);
               } else {
                  fh = drp == 0 ? fm[1] : fm[0];
                  afm = fh + "," + p.func_70005_c_() + ":" + H1F;
                  fD = drp == 0 ? prid + "!" + afm + "!" + H1F : afm;
                  JRMCoreH.setString(dnsNPC, p, FamilyCH.FID);
                  FamilyCH.wfi(server, fD, dnsNPC, false);
               }

               if (drp != 0) {
                  dnsNPC = fida[0] + ",0";
                  fn = FamilyCH.rfi(server, dnsNPC);
                  fm = fn.split("!");
                  prid = fm[0];
                  fh = fm[1];
                  fD = prid + "!" + fh + "!" + H1F;
                  FamilyCH.wfi(server, fD, dnsNPC, false);
               }

               pt.func_145747_a((new ChatComponentText(y + "Adoption offer was accepted! " + g + p.func_70005_c_() + y + " is now part of the " + g + fida[0] + y + " family!")).func_150255_a(color));
               p.func_145747_a((new ChatComponentText(y + "You have been adopted by " + g + pt.func_70005_c_() + y + " and you are now part of the " + g + fida[0] + y + " family!")).func_150255_a(color));
            } else {
               p.func_145747_a((new ChatComponentText(y + "Adoption failed because " + g + prid + y + " was not found!")).func_150255_a(color));
            }

            JRMCoreH.setString("", p, FamilyCH.FIDa);
            JRMCoreH.setString("", p, FamilyCH.FIDi);
         }

         if (id == 5) {
            JRMCoreH.setString("", p, FamilyCH.FIDi);
            JRMCoreH.setString("", p, FamilyCH.FIDa);
         }

         int pog;
         String fnam;
         String[] d;
         int fc;
         String p2;
         String fid2;
         String[] famDa;
         int S1T;
         if (id == 6) {
            prid = JRMCoreH.getString(p, FamilyCH.FID);
            n = p.func_70005_c_();
            if (prid.length() > 2) {
               p1d = prid.split(",");
               pog = Integer.parseInt(p1d[1]);
               fnam = FamilyCH.rfi(server, prid);
               d = fnam.split("!");
               fn = pog == 0 ? d[0] : "";
               fm = pog == 0 ? d[1].split(",") : d[0].split(",");
               fc = pog == 0 ? Integer.parseInt(d[2]) : 0;
               p2 = "";

               for(H1F = 0; H1F < fm.length; ++H1F) {
                  afm = fm[H1F];
                  famDa = afm.split(":");
                  if (famDa[0].equalsIgnoreCase(p.func_70005_c_())) {
                     p2 = p2 + (H1F < 2 ? ",l" : "");
                  } else {
                     p2 = p2 + "," + afm;
                  }
               }

               p2 = p2.substring(1);
               fid2 = pog == 0 ? fn + "!" + p2 + "!" + fc : p2;
               FamilyCH.wfi(server, fid2, prid, false);
               afm = JRMCoreH.getString(p, FamilyCH.FIDo);
               if (afm.length() > 2) {
                  p1d = afm.split(",");
                  pog = Integer.parseInt(p1d[1]);
                  String fdo = FamilyCH.rfi(server, afm);
                  d = fdo.split("!");
                  fn = pog == 0 ? d[0] : "";
                  fm = pog == 0 ? d[1].split(",") : d[0].split(",");
                  fc = pog == 0 ? Integer.parseInt(d[2]) : 0;
                  p2 = "";

                  for(S1T = 0; S1T < fm.length; ++S1T) {
                     fh = fm[S1T];
                     String[] fh2 = fh.split(":");
                     if (fh2[0].equalsIgnoreCase(p.func_70005_c_())) {
                        p2 = p2 + (S1T < 2 ? ",l" : "");
                        JRMCoreH.setString("0", p, FamilyCH.FIDo);
                     } else {
                        p2 = p2 + "," + fh;
                     }
                  }

                  p2 = p2.substring(1);
                  fid2 = pog == 0 ? fn + "!" + p2 + "!" + fc : p2;
                  FamilyCH.wfi(server, fid2, afm, false);
               }

               famDa = fn.split(",");
               p.func_145747_a((new ChatComponentText(y + "You have left the " + g + famDa[0] + y + " family!")).func_150255_a(color));
            }
         }

         int i2;
         int i;
         int fc;
         if (id == 7) {
            prid = JRMCoreH.getString(p, FamilyCH.FID);
            n = txt;
            EntityPlayerMP pud = JRMCoreH.getPlayerForUsername(server, txt);
            if (prid.length() > 2 && txt.length() > 1) {
               String[] fida = prid.split(",");
               fnam = fida[0];
               drp = Integer.parseInt(fida[1]);
               fn = FamilyCH.rfi(server, fnam + ",0");
               if (fn.contains("!")) {
                  fm = fn.split("!");
                  fc = Integer.parseInt(fm[2]);

                  for(i = 0; i <= drp; ++i) {
                     fid2 = fnam + "," + i;
                     afm = FamilyCH.rfi(server, fid2);
                     if (afm.length() > 3) {
                        famDa = afm.split("!");
                        fn = i == 0 ? famDa[0] : "";
                        fma = i == 0 ? famDa[1].split(",") : famDa[0].split(",");
                        fc = i == 0 ? Integer.parseInt(famDa[2]) : 0;
                        String nf = "";

                        for(i2 = 0; i2 < fma.length; ++i2) {
                           String fh = fma[i2];
                           String[] fh2 = fh.split(":");
                           if (fh2[0].equalsIgnoreCase(n)) {
                              nf = nf + (i2 < 2 ? ",k" : "");
                              FamilyCH.wfmd(server, "1", n, false);
                           } else {
                              nf = nf + "," + fh;
                           }
                        }

                        nf = nf.substring(1);
                        String fD = i == 0 ? fn + "!" + nf + "!" + fc : nf;
                        FamilyCH.wfi(server, fD, fid2, false);
                     }
                  }
               }

               if (pud != null) {
                  pud.func_145747_a((new ChatComponentText(y + "You have been removed from the " + g + fnam + y + " family by " + g + p.func_70005_c_() + y + "!")).func_150255_a(color));
               }

               p.func_145747_a((new ChatComponentText(y + "You have removed " + g + n + y + " from the " + g + fnam + y + " family!")).func_150255_a(color));
            } else {
               p.func_145747_a((new ChatComponentText(y + "Removing " + g + txt + y + " failed!")).func_150255_a(color));
            }
         }

         byte R1;
         if (id == 8) {
            prid = JRMCoreH.getString(p, FamilyCH.prID);
            pt = JRMCoreH.getPlayerForUsername(server, prid.length() > 2 && !prid.contains(";") ? prid : "");
            if (pt != null && p != null) {
               type = JRMCoreH.getString(pt, "jrmcDNS");
               int pa = gb(p, "jrmcAccept");
               R1 = gb(pt, "jrmcAccept");
               drp = JRMCoreH.dnsGender(dns);
               int ptg = JRMCoreH.dnsGender(type);
               if ((drp == 0 && ptg == 1 || drp == 1 && ptg == 0) && pa == 1 && R1 == 1) {
                  byte R1 = gb(p, "jrmcRace");
                  i = JRMCoreH.dnsHairB(dns);
                  H1F = JRMCoreH.dnsHairF(dns);
                  int H1C = JRMCoreH.dnsHairC(dns);
                  int B1 = JRMCoreH.dnsBreast(dns);
                  S1T = JRMCoreH.dnsSkinT(dns);
                  B1T = JRMCoreH.dnsBodyT(dns);
                  fc = JRMCoreH.dnsBodyCM(dns);
                  int B1C1 = JRMCoreH.dnsBodyC1(dns);
                  i2 = JRMCoreH.dnsBodyC2(dns);
                  int B1C3 = JRMCoreH.dnsBodyC3(dns);
                  int F1N = JRMCoreH.dnsFaceN(dns);
                  int F1M = JRMCoreH.dnsFaceM(dns);
                  int E1 = JRMCoreH.dnsEyes(dns);
                  int E1C1 = JRMCoreH.dnsEyeC1(dns);
                  int E1C2 = JRMCoreH.dnsEyeC2(dns);
                  String dnsH = JRMCoreH.getString(p, "jrmcDNSH");
                  byte R2 = gb(pt, "jrmcRace");
                  int H2B = JRMCoreH.dnsHairB(type);
                  int H2F = JRMCoreH.dnsHairF(type);
                  int H2C = JRMCoreH.dnsHairC(type);
                  int B2 = JRMCoreH.dnsBreast(type);
                  int S2T = JRMCoreH.dnsSkinT(type);
                  int B2T = JRMCoreH.dnsBodyT(type);
                  int B2CM = JRMCoreH.dnsBodyCM(type);
                  int B2C1 = JRMCoreH.dnsBodyC1(type);
                  int B2C2 = JRMCoreH.dnsBodyC2(type);
                  int B2C3 = JRMCoreH.dnsBodyC3(type);
                  int F2N = JRMCoreH.dnsFaceN(type);
                  int F2M = JRMCoreH.dnsFaceM(type);
                  int E2 = JRMCoreH.dnsEyes(type);
                  int E2C1 = JRMCoreH.dnsEyeC1(type);
                  int E2C2 = JRMCoreH.dnsEyeC2(type);
                  String dnsH2 = JRMCoreH.getString(pt, "jrmcDNSH");
                  if (FamilyCH.procWith(R1, R2)) {
                     byte r = (byte)FamilyCH.procTR(R1, R2);
                     Random ran = new Random();
                     dnsRaceSlcted = r;
                     dnsGenderSlcted = ran.nextInt(2);
                     int rid = ran.nextInt(3);
                     dnsHairSlcted = rid == 0 ? i : (rid == 1 ? H2B : ran.nextInt(JRMCoreH.Hairs.length));
                     dnsHair2Slcted = H1F;
                     rid = ran.nextInt(3);
                     dnsColorSlcted = rid == 0 ? H1C : (rid == 1 ? H2C : ran.nextInt(16777000));
                     dnsBreastSizeSlcted = ran.nextInt(9);
                     boolean p1p2 = false;
                     boolean p1 = false;
                     boolean p2 = false;
                     rid = ran.nextInt(3);
                     if (S1T == 1 && S2T == 1) {
                        p1p2 = true;
                        rid = rid == 0 ? B1T : (rid == 1 ? B2T : ran.nextInt(JRMCoreH.customSknLimits[r][0]));
                     } else if (S1T == 1) {
                        p1 = true;
                        rid = rid != 0 && rid != 1 ? ran.nextInt(JRMCoreH.customSknLimits[r][0]) : B1T;
                     } else if (S2T != 1) {
                        rid = ran.nextInt(JRMCoreH.customSknLimits[r][0]);
                     } else {
                        p2 = true;
                        rid = rid != 0 && rid != 1 ? ran.nextInt(JRMCoreH.customSknLimits[r][0]) : B2T;
                     }

                     dnsBodyTypeSlcted = rid;
                     rid = ran.nextInt(JRMCoreH.customSknLimitsBCP[r]);
                     int cls = JRMCoreH.defbodycols[rid][r].length;
                     rid = ran.nextInt(4);
                     dnsBodyColMainSlcted = cls < 1 ? 0 : (rid == 0 && (p1p2 || p1) ? fc : (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][0]) : B2CM));
                     rid = ran.nextInt(4);
                     dnsBodyColSub1Slcted = cls < 2 ? 0 : (rid != 0 || !p1p2 && !p1 ? ((rid == 1 || rid == 0 && !p1) && (p1p2 || p2) ? B2C1 : (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][1])) : B1C1);
                     rid = ran.nextInt(4);
                     dnsBodyColSub2Slcted = cls < 3 ? 0 : (rid != 0 || !p1p2 && !p1 ? ((rid == 1 || rid == 0 && !p1) && (p1p2 || p2) ? B2C2 : (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][2])) : i2);
                     rid = ran.nextInt(4);
                     dnsBodyColSub3Slcted = cls < 4 ? 0 : (rid != 0 || !p1p2 && !p1 ? ((rid == 1 || rid == 0 && !p1) && (p1p2 || p2) ? B2C3 : (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][3])) : B1C3);
                     rid = ran.nextInt(3);
                     dnsFaceNoseSlcted = rid != 0 || !p1p2 && !p1 ? (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? ran.nextInt(JRMCoreH.customSknLimits[r][2]) : F2N) : F1N;
                     rid = ran.nextInt(3);
                     dnsFaceMouthSlcted = rid != 0 || !p1p2 && !p1 ? (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? ran.nextInt(JRMCoreH.customSknLimits[r][3]) : F2M) : F1M;
                     rid = ran.nextInt(3);
                     dnsEyesSlcted = rid == 0 && (p1p2 || p1) ? E1 : (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? ran.nextInt(JRMCoreH.customSknLimits[r][4]) : E2);
                     rid = ran.nextInt(4);
                     int rid2 = ran.nextInt(5);
                     dnsEyeCol1Slcted = rid != 0 || !p1p2 && !p1 ? (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r]) : E2C1) : E1C1;
                     rid = ran.nextInt(4);
                     dnsEyeCol2Slcted = rid2 != 0 ? dnsEyeCol1Slcted : (rid != 0 || !p1p2 && !p1 ? (rid != 1 && (rid != 0 || p1) || !p1p2 && !p2 ? (rid != 2 && (rid >= 2 || p1p2 || p1 || p2) ? ran.nextInt(16777000) : JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r]) : E2C1) : E1C1);
                     setdns();
                     String dnsHdef = JRMCoreH.defHairPrsts[ran.nextInt(JRMCoreH.defHairPrsts.length)];
                     rid = ran.nextInt(2);
                     String dnsHc = dnsHairSlcted != 12 ? "0" : (i == 12 && H2B == 12 ? (rid == 0 ? dnsH : dnsH2) : (i == 12 ? dnsH : (H2B == 12 ? dnsH2 : dnsHdef)));
                     EntityPlayer e = ptg == 1 ? pt : (drp == 1 ? p : p);
                     EntityPlayer e2 = ptg == 0 ? pt : (drp == 0 ? p : pt);
                     JRMCoreH.setString(FamilyCP.Handler.dns + ";" + ((EntityPlayer)e).func_70005_c_() + ";" + ((EntityPlayer)e2).func_70005_c_() + ";" + txt + ";" + FamilyCConfig.pt * 120 + ";" + dnsHc, (EntityPlayer)e, FamilyCH.prID);
                     JRMCoreH.setString("f", (EntityPlayer)e2, FamilyCH.prID);
                     ((EntityPlayer)e2).func_145747_a((new ChatComponentText(y + "" + g + ((EntityPlayer)e).func_70005_c_() + y + " is now pregnant, thanks to you!")).func_150255_a(color));
                     ((EntityPlayer)e).func_145747_a((new ChatComponentText(y + "You've become pregnant! The father is " + g + ((EntityPlayer)e2).func_70005_c_() + y + ".")).func_150255_a(color));
                  }
               }
            } else {
               JRMCoreH.setString("n", p, FamilyCH.prID);
            }
         }

         if (id == 9) {
            prid = JRMCoreH.getString(p, FamilyCH.prID);
            pt = JRMCoreH.getPlayerForUsername(server, prid);
            if (pt != null) {
               pt.func_145747_a((new ChatComponentText(y + "" + p.func_70005_c_() + " has declined your procreation offer!")).func_150255_a(color));
            }

            JRMCoreH.setString("d", p, FamilyCH.prID);
         }

         int pg;
         if (id == 10) {
            EntityPlayerMP po = JRMCoreH.getPlayerForUsername(server, txt);
            n = JRMCoreH.getString(po, "jrmcDNS");
            pg = JRMCoreH.dnsGender(dns);
            pog = JRMCoreH.dnsGender(n);
            R1 = gb(p, "jrmcRace");
            byte R2 = gb(po, "jrmcRace");
            if (FamilyCConfig.mc != 0 && !FamilyCConfig.dcr) {
               if (FamilyCH.procWith(R1, R2) && po != null && (pg == 0 && pog == 1 || pg == 1 && pog == 0)) {
                  boolean allow = true;
                  String p1 = FamilyCH.rpfd(server, txt);
                  if (p1.contains(";")) {
                     String[] p1d = p1.split(";");
                     if (p1d.length >= FamilyCConfig.mc) {
                        p.func_145747_a((new ChatComponentText(y + "" + g + txt + y + " has already " + FamilyCConfig.mc + " children!")).func_150255_a(color));
                        allow = false;
                     } else {
                        p2 = FamilyCH.rpfd(server, p.func_70005_c_());
                        if (p2.contains(";")) {
                           String[] p2d = p2.split(";");
                           if (p2d.length >= FamilyCConfig.mc) {
                              p.func_145747_a((new ChatComponentText(y + "" + g + p.func_70005_c_() + y + " has already " + FamilyCConfig.mc + " children!")).func_150255_a(color));
                              allow = false;
                           }
                        }
                     }
                  }

                  if (allow) {
                     prid = JRMCoreH.getString((EntityPlayer)(pg == 1 ? p : po), FamilyCH.prID);
                     if (prid.contains(";") && !prid.equals("") && prid != "") {
                        p.func_145747_a((new ChatComponentText(y + (pg == 1 ? "You are" : g + txt + y + " is") + " already pregnant!")).func_150255_a(color));
                     } else {
                        JRMCoreH.setString(p.func_70005_c_(), po, FamilyCH.prID);
                        p.func_145747_a((new ChatComponentText(y + "A procreation offer has been sent!")).func_150255_a(color));
                        po.func_145747_a((new ChatComponentText(y + "You've recived a procreation offer from " + g + p.func_70005_c_() + y + "!")).func_150255_a(color));
                     }
                  }
               }
            } else {
               p.func_145747_a((new ChatComponentText(y + "Procreation is disabled by the server!")).func_150255_a(color));
            }
         }

         int eid;
         int i;
         if (id == 20) {
            dat = txt.split(":");
            eid = Integer.parseInt(dat[0]);
            pg = Integer.parseInt(dat[1]);
            boolean aggro = Integer.parseInt(dat[2]) == 1;
            i = Integer.parseInt(dat[3]);
            drp = Integer.parseInt(dat[4]);
            Entity pl = p.field_70170_p.func_73045_a(eid);
            if (pl != null && pl instanceof EntityNPC) {
               EntityNPC npl = (EntityNPC)pl;
               if (p.func_70005_c_().equalsIgnoreCase(npl.getDad()) || p.func_70005_c_().equalsIgnoreCase(npl.getMom())) {
                  npl.setFollow(pg);
                  npl.setAggr(aggro);
                  npl.setFollowTarget(i);
                  if (drp == 1) {
                     ((EntityNPC)pl).func_82160_b(true, 0);
                  }
               }
            }
         }

         if (id == 21) {
            boolean allow = true;
            n = FamilyCH.rpfd(server, p.func_70005_c_());
            p1d = n.split(";");
            dnsNPC = "";

            for(i = 0; i < p1d.length; ++i) {
               d = p1d[i].split(":");
               dnsNPC = dnsNPC + ";" + FamilyCH.rcfd(server, d[0]) + ":" + FamilyCH.rcpd(server, d[0]);
            }

            dnsNPC = dnsNPC.substring(1);
            if (dnsNPC.length() > 2) {
               FamilyCH.jfcd(21, dnsNPC, p);
            }
         }

         if (id == 22) {
            dat = txt.split(":");
            eid = Integer.parseInt(dat[0]);
            type = dat[1];
            Entity pl = p.field_70170_p.func_73045_a(eid);
            if (pl != null && pl instanceof EntityNPC) {
               EntityNPC entityNPC = (EntityNPC)pl;
               if (p.func_70005_c_().equalsIgnoreCase(entityNPC.getDad()) || p.func_70005_c_().equalsIgnoreCase(entityNPC.getMom())) {
                  entityNPC.setCnam((byte)0);
                  entityNPC.setNam(type);
                  entityNPC.setNamUpdt(true);
                  d = FamilyCH.rcfd(server, entityNPC.getCid() + "");
                  prt = d.split(":");
                  FamilyCH.wcfd(server, prt[1] + ":" + prt[2] + ":" + type, entityNPC.getCid(), false);
                  FamilyCH.jfcd(23, entityNPC.func_145782_y() + "", p);
               }
            }
         }

         if (id == 23) {
            dat = txt.split(":");
            eid = Integer.parseInt(dat[0]);
            type = dat[1];
            dnsNPC = dat[2];
            Entity entity = p.field_70170_p.func_73045_a(eid);
            if (entity != null && entity instanceof EntityNPC) {
               EntityNPC entityNPC = (EntityNPC)entity;
               if (p.func_70005_c_().equalsIgnoreCase(entityNPC.getDad()) || p.func_70005_c_().equalsIgnoreCase(entityNPC.getMom())) {
                  if (type.equals("dns")) {
                     entityNPC.setDNS(dnsNPC);
                  }

                  if (type.equals("dnsH")) {
                     entityNPC.setDNSH(dnsNPC);
                  }
               }
            }
         }

         return null;
      }

      private static String ntl(int i) {
         return JRMCoreH.numToLet(i);
      }

      private static String ntl5(int i) {
         return JRMCoreH.numToLet5(i);
      }

      private static byte gb(EntityPlayer p, String s) {
         return JRMCoreH.getByte(p, s);
      }

      private static int gi(EntityPlayer p, String s) {
         return JRMCoreH.getInt(p, s);
      }

      public static void setdns() {
         String R = ntl(dnsRaceSlcted);
         String G = dnsGenderSlcted + "";
         String H1 = ntl(dnsHairSlcted);
         String H2 = ntl(dnsHair2Slcted);
         String HC = ntl5(dnsColorSlcted);
         String BS = dnsBreastSizeSlcted + "";
         String ST = "1";
         String BT = ntl(dnsBodyTypeSlcted);
         String BCM = ntl5(dnsBodyColMainSlcted);
         String BC1 = ntl5(dnsBodyColSub1Slcted);
         String BC2 = ntl5(dnsBodyColSub2Slcted);
         String BC3 = ntl5(dnsBodyColSub3Slcted);
         String FN = ntl(dnsFaceNoseSlcted);
         String FM = ntl(dnsFaceMouthSlcted);
         String ET = ntl(dnsEyesSlcted);
         String EC1 = ntl5(dnsEyeCol1Slcted);
         String EC2 = ntl5(dnsEyeCol2Slcted);
         dns = R + G + H1 + H2 + HC + BS + ST + BT + BCM + BC1 + BC2 + BC3 + FN + FM + ET + EC1 + EC2;
      }
   }
}
