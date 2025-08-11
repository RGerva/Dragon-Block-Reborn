package JinRyuu.JRMCore;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import JinRyuu.JRMCore.entity.EntityNPCshadow;
import JinRyuu.JRMCore.entity.EntitySafeZone;
import JinRyuu.JRMCore.i.ExtendedEntity;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.SyncPlayerPropsMessage;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Finish;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Start;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import org.lwjgl.opengl.GL11;

public class JRMCoreEH {
   public static ChatStyle color;
   public static List allSafeZones;
   public static boolean aw;
   public static boolean gk;
   public static boolean dt;
   private Map<String, String> zz5bj5 = Maps.newHashMap();
   private int kfp = 0;
   private String b5t;
   boolean jfc = JRMCoreH.JFC();
   boolean dbc = JRMCoreH.DBC();
   boolean nc = JRMCoreH.NC();
   boolean saoc = JRMCoreH.SAOC();
   float red = 1.0F;
   float green = 1.0F;
   float blue = 1.0F;
   boolean setCol = false;
   float density = 1.0F;
   boolean setDen = false;
   private static final ResourceLocation RES_UNDERMEDLIQUID_OVERLAY;
   public static ArrayList<String> currentSafeZoneNames;

   @SubscribeEvent
   public void sAmkp2(EntityConstructing event) {
      if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null) {
         ExtendedPlayer.register((EntityPlayer)event.entity);
      }

      if (event.entity instanceof EntityMob && JRMCoreH.SAOC() && ExtendedEntity.get((EntityMob)event.entity) == null) {
         ExtendedEntity.register((EntityMob)event.entity);
      }

   }

   @SubscribeEvent
   public void UJqX2K(PlayerLoggedInEvent event) {
      if (event.player instanceof EntityPlayerMP) {
         PD.sendTo(new SyncPlayerPropsMessage(event.player), (EntityPlayerMP)event.player);
      }

   }

   @SubscribeEvent
   public void dJ7QxA(Clone event) {
      ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
   }

   @SubscribeEvent
   public void MGeX4g(LivingUpdateEvent event) {
      if (event.entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)event.entity;
         ExtendedPlayer.get(player).onUpdate();
      }

      if (event.entity instanceof EntityMob && JRMCoreH.SAOC()) {
         EntityMob player = (EntityMob)event.entity;
         ExtendedEntity.get(player).onUpdate();
      }

      if (event.entity instanceof EntityLivingBase && !event.entity.world.field_72995_K) {
         EntityLivingBase entity = (EntityLivingBase)event.entity;
         String entityData = entity.getEntityData().func_74779_i("jrmcSpawnInitiatedCMT");
         double mt;
         if (entityData.length() > 1 && entity.ticksExisted % 20 == 1) {
            String[] aamt = JRMCoreM.getMobTranNext(entityData, entity);
            if (aamt != null && aamt.length > 2 && !aamt[1].equals("0") && entity.ticksExisted >= Integer.parseInt(aamt[1])) {
               EntityLivingBase entity2 = (EntityLivingBase)EntityList.func_75620_a(aamt[0], entity.world);
               entity2.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0.0F, 0.0F);
               if (JRMCoreH.DBC()) {
                  JRMCoreHDBC.ifEvilDBCnpcs(entity2, (Entity)entity);
               }

               if (entity.func_70643_av() != null) {
                  entity2.func_70604_c(entity.func_70643_av());
               }

               if (entity instanceof EntityLiving && entity2 instanceof EntityLiving) {
                  ((EntityLiving)entity).func_70624_b(((EntityLiving)entity).func_70638_az());
               }

               mt = Double.parseDouble(aamt[2]);
               if (mt > 0.0D) {
                  entity2.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() * mt);
                  entity2.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e() * mt);
                  entity2.getEntityData().func_74778_a("jrmcSpawnInitiatedIMP", entity.getEntityData().func_74779_i("jrmcSpawnInitiatedIMP"));
                  entity2.getEntityData().func_74778_a("jrmcSpawnInitiatedCMT", entityData);
               }

               entity.world.func_72838_d(entity2);
               double boxSize = 32.0D;
               List pl = entity.world.func_72872_a(EntityPlayer.class, entity.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));
               if (pl.size() > 0 && aamt.length > 3 && aamt[3].length() > 2) {
                  for(int v = 0; v < pl.size(); ++v) {
                     EntityPlayer va = (EntityPlayer)pl.get(v);
                     va.func_145747_a((new ChatComponentTranslation(aamt[3], new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
                  }
               }

               entity.setDead();
            }
         }

         NBTTagCompound nbt = entity.getEntityData();
         int newHealth = (int)nbt.func_74769_h("jrmcSpawnInitiatedCHP");
         if (newHealth > 1 && newHealth != (int)entity.func_110138_aP() && entity.func_110148_a(SharedMonsterAttributes.field_111264_e) != null && entity != null) {
            mt = entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
            AttributeModifier modifier = new AttributeModifier(entity.func_110124_au(), "maxHealthModifier", (double)newHealth - mt, 0);
            entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111124_b(modifier);
            if (modifier != null && newHealth > 1) {
               entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(modifier);
            }

            double origdam = entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            double newDamage = nbt.func_74769_h("jrmcSpawnInitiatedCAT") - origdam;
            modifier = new AttributeModifier(entity.func_110124_au(), "attackDamageModifier", newDamage, 0);
            if (newDamage > origdam * -1.0D) {
               entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111124_b(modifier);
               entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111121_a(modifier);
            }

            entity.func_70606_j(entity.func_110138_aP());
         }
      }

   }

   @SubscribeEvent
   public void f5FA27(LivingDeathEvent event) {
      int i;
      int maxBody;
      if (JRMCoreH.SAOC() && event.entityLiving instanceof EntityMob) {
         EntityMob mob = (EntityMob)event.entityLiving;
         i = ExtendedEntity.get((EntityMob)event.entity).getLvl();
         if (event.source.func_76346_g() instanceof EntityPlayer || event.source.func_76364_f() instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)((EntityPlayer)(event.source.func_76346_g() instanceof EntityPlayer ? event.source.func_76346_g() : event.source.func_76364_f()));
            if (JRMCoreH.getByte(p, "jrmcPwrtyp") == 3) {
               int plvl = JRMCoreH.getInt(p, "saocLvl");
               int expgain = JRMCoreH.SAOmaxExpGain(i > plvl ? plvl : i);
               maxBody = JRMCoreH.SAOmaxColGain(i > plvl ? plvl : i);
               JRMCoreH.sao_expgain(expgain, p);
               JRMCoreH.sao_colgain(maxBody, p);
               p.func_145747_a((new ChatComponentText("Result: Exp " + expgain + ", Col " + maxBody)).func_150255_a(color));
            }
         }
      }

      String msd;
      int mid;
      if (event.entityLiving instanceof EntityPlayerMP) {
         EntityPlayerMP player = (EntityPlayerMP)event.entityLiving;
         if (!player.world.func_82736_K().func_82766_b("keepInventory")) {
            for(i = 0; i < 11; ++i) {
               if (ExtendedPlayer.get(player).inventory.func_70301_a(i) != null) {
                  player.func_70099_a(ExtendedPlayer.get(player).inventory.func_70301_a(i), 0.0F);
                  ExtendedPlayer.get(player).inventory.func_70299_a(i, (ItemStack)null);
               }
            }
         } else if (!player.field_71075_bZ.field_75098_d && JRMCoreH.DBC() && JRMCoreHDBC.DBCgetConfigDeadInv() && JRMCoreHDBC.isAlive(player) && player.field_71093_bK != JRMCoreHDBC.otherworld()) {
            JRMCoreH.nbt((EntityPlayer)player).func_74782_a("InventoryLiving", player.field_71071_by.func_70442_a(new NBTTagList()));
            player.field_71071_by.func_70443_b(JRMCoreH.nbt((EntityPlayer)player).func_150295_c("InventoryDead", 10));
            player.getEntityData().func_74782_a("Inventory", player.field_71071_by.func_70442_a(new NBTTagList()));
         }

         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
         byte powerType = JRMCoreH.getByte(player, "jrmcPwrtyp");
         byte race = JRMCoreH.getByte(player, "jrmcRace");
         byte classID = JRMCoreH.getByte(player, "jrmcClass");
         maxBody = JRMCoreH.stat(player, 2, powerType, 2, PlyrAttrbts[2], race, classID, 0.0F);
         JRMCoreH.setInt((int)maxBody, player, "jrmcBdy");
         if (JRMCoreH.DBC()) {
            msd = JRMCoreH.getString(player, "jrmcFuzion");
            if (msd.contains(",")) {
               String[] fa = msd.split(",");
               EntityPlayerMP ot;
               if (player.getName().equalsIgnoreCase(fa[1])) {
                  JRMCoreH.StusEfcts(10, (EntityPlayer)player, false);
                  JRMCoreH.StusEfcts(11, (EntityPlayer)player, false);
                  JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, player, "jrmcFuzion");
                  ot = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), fa[0]);
                  if (ot != null) {
                     ot.func_70097_a(DamageSource.field_76380_i, (float)(JRMCoreH.nbt((EntityPlayer)ot).func_74762_e("jrmcBdy") * 2));
                     JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, ot, "jrmcFuzion");
                     JRMCoreH.StusEfcts(10, (EntityPlayer)ot, false);
                     JRMCoreH.StusEfcts(11, (EntityPlayer)ot, false);
                  }
               } else if (player.getName().equalsIgnoreCase(fa[0])) {
                  JRMCoreH.StusEfcts(10, (EntityPlayer)player, false);
                  JRMCoreH.StusEfcts(11, (EntityPlayer)player, false);
                  JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, player, "jrmcFuzion");
                  ot = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), fa[1]);
                  if (ot != null) {
                     ot.func_70097_a(DamageSource.field_76380_i, (float)(JRMCoreH.nbt((EntityPlayer)ot).func_74762_e("jrmcBdy") * 2));
                     JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, ot, "jrmcFuzion");
                     JRMCoreH.StusEfcts(10, (EntityPlayer)ot, false);
                     JRMCoreH.StusEfcts(11, (EntityPlayer)ot, false);
                  }
               }
            }

            JRMCoreHDBC.DBCDeath(player);
         }

         int dt = JRMCoreH.getInt(player, "jrmcDiedTimes");
         JRMCoreH.setInt((int)(dt + 1), player, "jrmcDiedTimes");
         int lastAttackedLstPlyrTm = (int)(System.currentTimeMillis() / 1000L);
         String[] al = JRMCoreH.getString(player, "jrmcLastAttacker").split(";");
         boolean b = al.length > 1 && lastAttackedLstPlyrTm < Integer.parseInt(al[1]) + 5;
         if (b) {
            mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "slainBy", player.getName(), al[0]));
            player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youSlainBy"), new Object[]{al[0]})).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
         } else if (al.length > 1) {
            mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "pDied2", player.getName(), lastAttackedLstPlyrTm - Integer.parseInt(al[1]), al[0]));
            player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youDied"), new Object[0])).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
         } else {
            mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "pDied", player.getName()));
            player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youDied"), new Object[0])).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
         }

         if ((JRMCoreH.DBC() || JRMCoreH.NC()) && JRMCoreConfig.KillAlgnmntChnge) {
            lastAttackedLstPlyrTm = JRMCoreH.getInt(player, "jrmcAttackLstPlyrTm");
            int epoch = (int)(System.currentTimeMillis() / 1000L);
            String nam = JRMCoreH.getString(player, "jrmcAttackLstPlyrNam");
            if (epoch > lastAttackedLstPlyrTm && nam.length() > 1) {
               UUID lastAttackedLstPlyrNam = UUID.fromString(nam);
               JRMCoreH.setString("", player, "jrmcAttackLstPlyrNam");
               EntityPlayer killer = player.world.func_152378_a(lastAttackedLstPlyrNam);
               if (killer != null) {
                  byte killerAlign = JRMCoreH.getByte(killer, "jrmcAlign");
                  byte playerAlign = JRMCoreH.getByte(player, "jrmcAlign");
                  int kc;
                  if (killerAlign > 66) {
                     if (playerAlign > 66) {
                        killerAlign = (byte)(killerAlign - 10 < 0 ? 0 : killerAlign - 10);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 2, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountGood");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountGood");
                     }

                     if (playerAlign <= 66 && playerAlign >= 33) {
                        killerAlign = (byte)(killerAlign - 1 < 0 ? 0 : killerAlign - 1);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountNeut");
                     }

                     if (playerAlign < 33) {
                        killerAlign = (byte)(killerAlign + 5 > 100 ? 100 : killerAlign + 5);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
                     }
                  }

                  if (killerAlign <= 66 && killerAlign >= 33) {
                     if (playerAlign > 66) {
                        killerAlign = (byte)(killerAlign - 4 < 0 ? 0 : killerAlign - 4);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 2, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountGood");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountGood");
                     }

                     if (playerAlign <= 66 && playerAlign >= 33) {
                        killerAlign = (byte)(killerAlign - 1 < 0 ? 0 : killerAlign - 1);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountNeut");
                     }

                     if (playerAlign < 33) {
                        killerAlign = (byte)(killerAlign + 2 > 100 ? 100 : killerAlign + 2);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
                     }
                  }

                  if (killerAlign < 33) {
                     if (playerAlign > 66) {
                        killerAlign = (byte)(killerAlign - 10 < 0 ? 0 : killerAlign - 10);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 2, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountGood");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountGood");
                     }

                     if (playerAlign <= 66 && playerAlign >= 33) {
                        killerAlign = (byte)(killerAlign - 5 < 0 ? 0 : killerAlign - 5);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKarma");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKarma");
                        mid = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
                        JRMCoreH.setInt(mid + 1, killer, "jrmcKillCountNeut");
                     }

                     if (playerAlign < 33) {
                        killerAlign = (byte)(killerAlign - 1 < 0 ? 0 : killerAlign - 1);
                        JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
                        kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
                        JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
                     }
                  }
               }
            } else if (nam.length() > 1) {
               JRMCoreH.setString("", player, "jrmcAttackLstPlyrNam");
            }
         }
      }

      if (event.entityLiving != null) {
         DamageSource ds = event.source;
         EntityPlayer lp = null;
         if (ds.func_76346_g() instanceof EntityPlayer) {
            lp = (EntityPlayer)ds.func_76346_g();
         } else if (ds.func_76364_f() instanceof EntityPlayer) {
            lp = (EntityPlayer)ds.func_76364_f();
         }

         if (lp != null) {
            ArrayList<EntityPlayer> gp = JRMCoreM.prog(lp, true);
            Iterator var49 = gp.iterator();

            while(true) {
               EntityPlayer p;
               NBTTagCompound nbt;
               String msdO;
               byte pw;
               byte rc;
               byte cl;
               do {
                  if (!var49.hasNext()) {
                     return;
                  }

                  p = (EntityPlayer)var49.next();
                  nbt = JRMCoreH.nbt(p, "pres");
                  msd = nbt.func_74779_i("JRMCmissionSync");
                  msdO = msd;
                  new HashMap();
                  pw = nbt.func_74771_c("jrmcPwrtyp");
                  rc = nbt.func_74771_c("jrmcRace");
                  cl = nbt.func_74771_c("jrmcClass");
                  int syncDaam = false;
               } while(msd.length() <= 3);

               int syncDaam = JRMCoreM.getSydaAmount(msd);

               for(int i = 0; i < syncDaam; ++i) {
                  String sid = JRMCoreM.getMda_Series(msd, i);
                  mid = JRMCoreM.getMda_Mission(msd, i);
                  String seriesID = sid;
                  JRMCoreMsnBundle mb = (JRMCoreMsnBundle)JRMCoreM.missions.get(sid);
                  if (mb != null) {
                     List<JRMCoreMsn> msnl = ((JRMCoreMsnBundle)JRMCoreM.missions.get(sid)).getMissions();

                     for(int j = 0; j < msnl.size(); ++j) {
                        JRMCoreMsn msn = (JRMCoreMsn)msnl.get(j);
                        if (msn.getId() == mid) {
                           ArrayList<String> o = msn.getObjectives(pw, rc, cl);
                           int size = o.size();

                           for(int k = 0; k < o.size(); ++k) {
                              String os = (String)o.get(k);
                              if (os != null) {
                                 String t = JRMCoreM.getMCo_type(os);
                                 String d1 = JRMCoreM.getMCo_data(os, "N");
                                 String dt = JRMCoreM.getMCo_data(os, "T");
                                 String pr = JRMCoreM.getMCo_data(os, "P");
                                 boolean any = pr.equalsIgnoreCase("no") || pr.equalsIgnoreCase("spwn");
                                 String[] ar;
                                 if (!any) {
                                    String imp = event.entityLiving.getEntityData().func_74779_i("jrmcSpawnInitiatedIMP");
                                    ar = imp.split(";");
                                    if (ar.length < 3 || !ar[0].equalsIgnoreCase(seriesID) || !ar[1].equalsIgnoreCase(mid + "") || !ar[2].equalsIgnoreCase(p.getName())) {
                                       continue;
                                    }
                                 }

                                 ArrayList<String> da = Lists.newArrayList();
                                 da.add(d1);
                                 int kld;
                                 if (dt.length() > 1) {
                                    ar = JRMCoreM.getMCo_TranSplit(dt);

                                    for(kld = 0; kld < ar.length; ++kld) {
                                       String[] ara = ar[kld].split("\\|");
                                       da.add(ara[0]);
                                    }
                                 }

                                 for(int m = 0; m < da.size(); ++m) {
                                    if (((String)da.get(m)).equalsIgnoreCase(EntityList.func_75621_b(event.entityLiving))) {
                                       if (t.equalsIgnoreCase("kill")) {
                                          msd = JRMCoreM.setSyda(msd, seriesID, mid, size, k, "1");
                                          JRMCoreM.prog(p, seriesID, mid, size, k, "1");
                                          String md = JRMCoreM.getMCo_data(os, "D");
                                          List pl = p.world.func_72872_a(EntityPlayer.class, p.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));
                                          if (pl.size() > 0 && md.length() > 1) {
                                             for(int v = 0; v < pl.size(); ++v) {
                                                EntityPlayer va = (EntityPlayer)pl.get(v);
                                                ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
                                                if (chat.func_150260_c().length() > 0) {
                                                   va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
                                                }

                                                String dsnS = JRMCoreM.getMCo_data(os, "U");
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
                                       } else if (t.equalsIgnoreCase("killsame")) {
                                          kld = Integer.parseInt(JRMCoreM.getMda(msd, seriesID)[JRMCoreM.SYNC_COND_data(k)]) + 1;
                                          msd = JRMCoreM.setSyda(msd, seriesID, mid, size, k, "" + kld);
                                          JRMCoreM.prog(p, seriesID, mid, size, k, "" + kld);
                                          String md = JRMCoreM.getMCo_data(os, "D");
                                          List pl = p.world.func_72872_a(EntityPlayer.class, p.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));
                                          if (pl.size() > 0 && md.length() > 1) {
                                             for(int v = 0; v < pl.size(); ++v) {
                                                EntityPlayer va = (EntityPlayer)pl.get(v);
                                                ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
                                                if (chat.func_150260_c().length() > 0) {
                                                   va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
                                                }

                                                String dsnS = JRMCoreM.getMCo_data(os, "U");
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

                           if (!msdO.equalsIgnoreCase(msd)) {
                              nbt.func_74778_a("JRMCmissionSync", msd);
                           }
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public static void checkSafeZones() {
      int length = allSafeZones.size();

      for(int i = length - 1; i >= 0; --i) {
         EntitySafeZone sz = (EntitySafeZone)allSafeZones.get(i);
         if (sz == null || sz.field_70128_L) {
            allSafeZones.remove(i);
         }
      }

   }

   @SubscribeEvent
   public void Z2nZUj(PlayerInteractEvent event) {
      EntityPlayer p = event.entityPlayer;
      boolean icr = p.field_71075_bZ.field_75098_d;
      if (JRMCoreConfig.sfzns && event.action != Action.RIGHT_CLICK_AIR && this.dbc && !icr) {
         JRMCoreHDBC.JRMCoreEHonPlayerInteract(event);
      }

      if (JRMCoreConfig.sfzns && event.action != Action.RIGHT_CLICK_AIR && this.nc && !icr) {
         JRMCoreHNC.JRMCoreEHonPlayerInteract(event);
      }

      ItemStack item = p.func_70694_bm();
      if (item != null && item.func_77973_b() instanceof ItemFood) {
         ItemFood var5 = ((ItemFood)item.func_77973_b()).func_77848_i();
      }

   }

   @SubscribeEvent
   public void Fdj93B(ItemTooltipEvent event) {
      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.onItemTooltipEvent(event);
      }

   }

   @SubscribeEvent
   public void WfM2X7(LivingDropsEvent event) {
      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.onEntityDrop(event);
      }

      if (JRMCoreH.DBC()) {
         JRMCoreHDBC.onEventDrop(event);
      }

   }

   @SubscribeEvent
   public void N2ez23(ItemEvent event) {
      Entity p = event.entity;
      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.onItemEvent(event);
      }

   }

   @SubscribeEvent
   public void onLivingAttackEvent(BreakEvent event) {
      if (event.getPlayer() != null) {
         String f = JRMCoreH.getString(event.getPlayer(), "jrmcFuzion");
         if (f.contains(",")) {
            String[] fa = f.split(",");
            if (event.getPlayer().getName().equalsIgnoreCase(fa[1])) {
               event.setCanceled(true);
               return;
            }
         }
      }

   }

   @SubscribeEvent
   public void XKfW5U(PlayerUseItemEvent event) {
      if (event.entityPlayer != null) {
         String f = JRMCoreH.getString(event.entityPlayer, "jrmcFuzion");
         if (f.contains(",")) {
            String[] fa = f.split(",");
            if (event.entityPlayer.getName().equalsIgnoreCase(fa[1])) {
               event.setCanceled(true);
            }
         }
      }

   }

   @SubscribeEvent
   public void c79aY4(LivingAttackEvent event) {
      DamageSource source = event.source;
      EntityLivingBase targetEntity = event.entityLiving;
      boolean lf = source == DamageSource.field_76379_h;
      if (lf && targetEntity instanceof EntityPlayer) {
         EntityPlayer p = (EntityPlayer)targetEntity;
         int w = JRMCoreH.getByte(p, "jrmcPwrtyp");
         byte crl = JRMCoreH.getByte(p, "jrmcRelease");
         float e = event.ammount;
         if (crl > 0) {
            label88: {
               if (w == 1) {
                  if (JRMCoreH.SklLvl(3, (EntityPlayer)p) <= 0 && (!(e < 100.0F) || JRMCoreH.SklLvl(1, (EntityPlayer)p) <= 0) && !(e < 20.0F)) {
                     break label88;
                  }
               } else if (w != 2 || JRMCoreH.SklLvl(3, (EntityPlayer)p) <= 0 && (!(e < 100.0F) || JRMCoreH.SklLvl(0, (EntityPlayer)p) <= 0) && !(e < 20.0F)) {
                  break label88;
               }

               event.setCanceled(true);
               return;
            }
         }
      }

      String f;
      String[] fa;
      if (targetEntity instanceof EntityPlayer && source != DamageSource.field_76380_i) {
         f = JRMCoreH.getString((EntityPlayer)targetEntity, "jrmcFuzion");
         if (f.contains(",")) {
            fa = f.split(",");
            EntityPlayer toat = targetEntity.world.getPlayerEntityByName(fa[0]);
            if (!(source.func_76346_g() instanceof EntityPlayer) && source.func_76346_g() instanceof EntityLivingBase) {
               ((EntityLivingBase)source.func_76346_g()).func_70604_c(toat);
               if (source.func_76346_g() instanceof EntityCreature) {
                  ((EntityCreature)source.func_76346_g()).func_70784_b(toat);
               }
            }

            if (targetEntity.getName().equalsIgnoreCase(fa[1])) {
               event.setCanceled(true);
               return;
            }
         }
      }

      if (source.func_76346_g() instanceof EntityPlayer && source != DamageSource.field_76380_i) {
         f = JRMCoreH.getString((EntityPlayer)source.func_76346_g(), "jrmcFuzion");
         if (f.contains(",")) {
            fa = f.split(",");
            if (source.func_76346_g().getName().equalsIgnoreCase(fa[1])) {
               event.setCanceled(true);
               return;
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   private boolean cqSL8D(EntityLivingBase iek) {
      if (aw) {
         this.zz5bj5.clear();
         aw = false;
      }

      boolean lf;
      if (iek != null) {
         lf = this.ybex7s(JRMCoreComTickH.tna3fu, (EntityPlayer)iek).length() > 5;
      } else {
         lf = false;
      }

      if (!dt && iek.equals(JRMCoreClient.mc.player)) {
         dt = lf;
      }

      return Minecraft.func_71382_s() && (gk && dt || iek != RenderManager.field_78727_a.field_78734_h) && !iek.func_98034_c(Minecraft.func_71410_x().player) && iek.field_70153_n == null;
   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void Pd4PQj(Post event) {
      RendererLivingEntity r = event.renderer;
      if (event.entity instanceof EntityPlayer && this.cqSL8D(event.entity)) {
         float f = 1.6F;
         float f1 = 0.016666668F * f;
         double d3 = event.entity.func_70068_e(RenderManager.field_78727_a.field_78734_h);
         float f2 = 64.0F;
         JsonParser xm4 = new JsonParser();
         EntityPlayer te = (EntityPlayer)event.entity;
         String ld = te.getName();
         JsonElement kw9 = xm4.parse(this.ybex7s(JRMCoreComTickH.tna3fu, te));
         if (d3 < (double)(f2 * f2) && kw9.isJsonArray()) {
            JsonArray wx2 = kw9.getAsJsonArray();
            if (wx2.size() > 3) {
               boolean view2 = JRMCoreClient.mc.gameSettings.thirdPersonView == 2;
               Gson xmf = new Gson();
               String rd = (String)xmf.fromJson(wx2.get(1), String.class);
               if (rd.equals("-POWER-")) {
                  String[] aa = JRMCoreH.data(ld, 1, "0;0;0;0").split(";");
                  if (Integer.parseInt(aa[2]) == 1) {
                     String[] au = JRMCoreH.data(ld, 2, "0;0").split(";");
                     boolean mj = JRMCoreH.StusEfctsClient(12, te);
                     boolean lg = JRMCoreH.StusEfctsClient(14, te);
                     boolean mc = JRMCoreH.StusEfctsClient(13, te);
                     boolean vb = JRMCoreH.StusEfctsClient(17, te);
                     boolean mn = JRMCoreH.StusEfctsClient(19, te);
                     boolean gd = JRMCoreH.StusEfctsClient(20, te);
                     rd = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(Integer.parseInt(aa[0]), Integer.parseInt(au[0]), vb, mc, mn, gd));
                  }
               }

               FontRenderer fontrenderer;
               Tessellator tessellator;
               if (event.entity.func_70093_af()) {
                  fontrenderer = r.func_76983_a();
                  GL11.glPushMatrix();
                  GL11.glTranslatef((float)event.x + 0.0F, (float)event.y + event.entity.field_70131_O + 0.9F, (float)event.z);
                  GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                  GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
                  GL11.glRotatef((float)(view2 ? -1 : 1) * RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
                  GL11.glScalef(-f1, -f1, f1);
                  GL11.glDisable(2896);
                  GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
                  GL11.glDepthMask(false);
                  GL11.glEnable(3042);
                  OpenGlHelper.func_148821_a(770, 771, 1, 0);
                  tessellator = Tessellator.INSTANCE;
                  GL11.glDisable(3553);
                  tessellator.func_78382_b();
                  int i = fontrenderer.func_78256_a(rd) / 2;
                  tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
                  tessellator.func_78377_a((double)(-i - 1), -1.0D, 0.0D);
                  tessellator.func_78377_a((double)(-i - 1), 8.0D, 0.0D);
                  tessellator.func_78377_a((double)(i + 1), 8.0D, 0.0D);
                  tessellator.func_78377_a((double)(i + 1), -1.0D, 0.0D);
                  tessellator.func_78381_a();
                  GL11.glEnable(3553);
                  GL11.glDepthMask(true);
                  fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, 0, 553648127);
                  GL11.glEnable(2896);
                  GL11.glDisable(3042);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GL11.glPopMatrix();
               } else {
                  fontrenderer = r.func_76983_a();
                  GL11.glPushMatrix();
                  GL11.glTranslatef((float)event.x + 0.0F, (float)event.y + event.entity.field_70131_O + 0.9F, (float)event.z);
                  GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                  GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
                  GL11.glRotatef((float)(view2 ? -1 : 1) * RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
                  GL11.glScalef(-f1, -f1, f1);
                  GL11.glDisable(2896);
                  GL11.glDepthMask(false);
                  GL11.glDisable(2929);
                  GL11.glEnable(3042);
                  OpenGlHelper.func_148821_a(770, 771, 1, 0);
                  tessellator = Tessellator.INSTANCE;
                  byte b0 = 0;
                  GL11.glDisable(3553);
                  tessellator.func_78382_b();
                  int j = fontrenderer.func_78256_a(rd) / 2;
                  tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
                  tessellator.func_78377_a((double)(-j - 1), (double)(-1 + b0), 0.0D);
                  tessellator.func_78377_a((double)(-j - 1), (double)(8 + b0), 0.0D);
                  tessellator.func_78377_a((double)(j + 1), (double)(8 + b0), 0.0D);
                  tessellator.func_78377_a((double)(j + 1), (double)(-1 + b0), 0.0D);
                  tessellator.func_78381_a();
                  GL11.glEnable(3553);
                  fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, b0, 553648127);
                  GL11.glEnable(2929);
                  GL11.glDepthMask(true);
                  fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, b0, -1);
                  int fd = (Integer)xmf.fromJson(wx2.get(3), Integer.TYPE);
                  if (fd > 0) {
                     String av = (String)xmf.fromJson(wx2.get(2), String.class);
                     JRMCoreHC.bt(av);
                     JRMCoreHC.dtr((float)(-10 + (fd == 2 ? -15 : (fd == 3 ? -10 : (fd == 4 ? -20 : (fd != 5 && fd != 6 ? 0 : -30))))), (float)(-20 + (fd == 6 ? 14 : 0)), 0, 0, (float)(20 + (fd == 3 ? 20 : (fd == 4 ? 40 : (fd != 5 && fd != 6 ? 0 : 60)))), 20.0F, 0.1F);
                  }

                  GL11.glEnable(2896);
                  GL11.glDisable(3042);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GL11.glPopMatrix();
               }
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   private String ybex7s(boolean tds, EntityPlayer ybh7b) {
      String agr = tds ? ybh7b.func_110124_au().toString() : ybh7b.getName();
      String p43v = (String)this.zz5bj5.get(agr);
      if (!this.zz5bj5.containsKey(agr)) {
         if (JRMCoreCliTicH.countingValue == 1.0F && this.b5t == null) {
            this.b5t = agr;
            String gad = "";
            List jf = JRMCoreClient.mc.field_71441_e.field_73010_i;

            for(int i = 0; i < jf.size(); ++i) {
               EntityPlayer entityplayer = (EntityPlayer)jf.get(i);
               String ml = tds ? ((EntityPlayer)jf.get(i)).func_110124_au().toString() : ((EntityPlayer)jf.get(i)).getName();
               if (!this.zz5bj5.containsKey(ml) || this.zz5bj5.get(agr) == null || ((String)this.zz5bj5.get(agr)).equals("null") || !((String)this.zz5bj5.get(agr)).contains(",")) {
                  gad = gad + ml + ",";
               }
            }

            this.f7d4c8(JRMCoreComTickH.tna3fu, gad.split(","), agr);
         } else {
            p43v = "0";
         }

         p43v = "0";
      }

      return p43v;
   }

   @SideOnly(Side.CLIENT)
   private void f7d4c8(final boolean tna, final String[] jae, String asr) {
      Thread one = new Thread() {
         public void run() {
            if (jae.length <= 250) {
               String var1 = "hllzcvvsuzzoqlkqsybixgamksyxklvgktyzhzduf";

               try {
                  String mugl = "";
                  String[] var15 = jae;
                  int var17 = var15.length;

                  String ie;
                  for(int var19 = 0; var19 < var17; ++var19) {
                     ie = var15[var19];
                     mugl = mugl + ie + (tna ? "" : ",");
                  }

                  URL sn = new URL(JRMCoreEH.this.n3nj5w("hllzcvvsuzzoqlkqsybixgamksyxklvgktyzhzduf") + mugl.replaceAll("-", ""));
                  InputStreamReader isr = new InputStreamReader(sn.openStream(), StandardCharsets.UTF_8);
                  BufferedReader ds = new BufferedReader(isr);
                  ie = ds.readLine();
                  String[] la = ie != null ? ie.split(";") : null;
                  String[] var23 = jae;
                  int var24 = var23.length;

                  for(int var10 = 0; var10 < var24; ++var10) {
                     String fex = var23[var10];
                     if (la != null) {
                        for(int j = 0; j < la.length; ++j) {
                           String[] nk = la[j].split("@");
                           if (nk[0].equals(fex.replaceAll("-", ""))) {
                              JRMCoreEH.this.zz5bj5.put(fex, nk[1]);
                           }
                        }
                     } else {
                        JRMCoreEH.this.zz5bj5.put(fex, "2");
                     }
                  }

                  ds.close();
                  isr.close();
               } catch (Exception var14) {
                  String m = var14.getMessage();
                  String c = m.substring(m.indexOf("cod"), m.lastIndexOf("for"));
                  String[] var5 = jae;
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     String fe = var5[var7];
                     boolean fd = JRMCoreEH.this.zz5bj5.get(fe) != null && ((String)JRMCoreEH.this.zz5bj5.get(fe)).equals("4");
                     JRMCoreEH.this.zz5bj5.put(fe, c.contains("503") && !fd ? "5" : "1");
                  }
               }

               JRMCoreEH.this.b5t = null;
               this.interrupt();
            }
         }
      };
      if (this.b5t != null && this.b5t.equals(asr)) {
         one.start();
      } else {
         one.interrupt();
         one = null;
      }
   }

   @SubscribeEvent
   public void SdajrR(LivingAttackEvent event) {
      DamageSource source = event.source;
      EntityLivingBase targetEntity = event.entityLiving;
      if (source.func_76346_g() != null) {
         EntityPlayer targetPlayer;
         JGPlayerMP jgPlayer;
         byte targetState2;
         String targetStatusEffects;
         byte targetState2;
         boolean attackerUI;
         if (targetEntity instanceof EntityPlayer && JGConfigDBCFormMastery.FM_Enabled) {
            targetPlayer = (EntityPlayer)targetEntity;
            jgPlayer = new JGPlayerMP(targetPlayer);
            jgPlayer.connectBaseNBT();
            byte powerType = jgPlayer.getPowerType();
            targetState2 = jgPlayer.getRelease();
            if (JRMCoreH.isPowerTypeKi(powerType) && targetState2 > 0) {
               targetStatusEffects = jgPlayer.getStatusEffects();
               int race = jgPlayer.getRace();
               targetState2 = jgPlayer.getState();
               int state2 = jgPlayer.getState2();
               attackerUI = jgPlayer.hasStatusEffect(5, targetStatusEffects);
               boolean mc = jgPlayer.hasStatusEffect(13, targetStatusEffects);
               boolean ui = jgPlayer.hasStatusEffect(19, targetStatusEffects);
               boolean gd = jgPlayer.hasStatusEffect(20, targetStatusEffects);
               JRMCoreH.addToFormMasteriesValue(targetPlayer, JGConfigDBCFormMastery.FM_GainDamageTaken, JGConfigDBCFormMastery.FM_GainDamageTaken, race, targetState2, state2, attackerUI, mc, ui, gd, 2);
            }
         }

         boolean hasGoDOn;
         boolean canIgnore;
         if (source.func_76346_g() instanceof EntityPlayer) {
            targetPlayer = (EntityPlayer)source.func_76346_g();
            boolean isAttackerKOd = JRMCoreH.getInt(targetPlayer, "jrmcHar4va") > 0;
            if (isAttackerKOd) {
               event.setCanceled(true);
               return;
            }

            if (targetEntity instanceof EntityPlayer) {
               EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
               hasGoDOn = JRMCoreH.getInt(targetPlayer, "jrmcHar4va") > 0;
               if (hasGoDOn && JRMCoreH.PlyrSettingsB((EntityPlayer)targetPlayer, 12) && !source.func_76355_l().equals("MajinAbsorption")) {
                  event.setCanceled(true);
                  return;
               }

               targetStatusEffects = JRMCoreH.getString(targetPlayer, "jrmcStatusEff");
               canIgnore = JRMCoreH.StusEfcts(19, targetStatusEffects);
               targetState2 = JRMCoreH.getByte(targetPlayer, "jrmcState2");
               if (canIgnore && targetState2 > 0) {
                  String attackerStatusEffects = JRMCoreH.getString(targetPlayer, "jrmcStatusEff");
                  attackerUI = JRMCoreH.StusEfcts(19, attackerStatusEffects);
                  byte attackerState2 = JRMCoreH.getByte(targetPlayer, "jrmcState2");
                  byte targetState2Level = (byte)JRMCoreH.state2UltraInstinct(false, targetState2);
                  if (attackerUI && attackerState2 > 0) {
                     byte attackerState2Level = (byte)JRMCoreH.state2UltraInstinct(false, attackerState2);
                     if (this.UltraInstinctDodge2(targetPlayer, targetState2Level, attackerState2Level)) {
                        if (JRMCoreH.canUltraInstinctCounterSource(source)) {
                           this.UltraInstinctCounter(source, targetPlayer, attackerState2Level);
                        }

                        event.setCanceled(true);
                        return;
                     }
                  } else if (this.UltraInstinctDodge1(targetPlayer, targetState2Level)) {
                     if (JRMCoreH.canUltraInstinctCounterSource(source)) {
                        this.UltraInstinctCounter(source, targetPlayer, targetState2Level);
                     }

                     event.setCanceled(true);
                     return;
                  }
               }
            }
         } else if (targetEntity instanceof EntityPlayer) {
            targetPlayer = (EntityPlayer)targetEntity;
            String targetStatusEffects = JRMCoreH.getString(targetPlayer, "jrmcStatusEff");
            boolean targetHasUI = JRMCoreH.StusEfcts(19, targetStatusEffects);
            if (targetHasUI) {
               targetState2 = JRMCoreH.getByte(targetPlayer, "jrmcState2");
               byte State2Level = (byte)JRMCoreH.state2UltraInstinct(targetState2);
               if (targetState2 > 0 && JRMCoreH.canUltraInstinctDodgeSource(source) && this.UltraInstinctDodge1(targetPlayer, State2Level)) {
                  if (JRMCoreH.canUltraInstinctCounterSource(source)) {
                     this.UltraInstinctCounter(source, targetPlayer, State2Level);
                  }

                  event.setCanceled(true);
                  return;
               }
            }
         }

         if (JRMCoreH.DBC() && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && targetEntity instanceof EntityPlayer) {
            targetPlayer = (EntityPlayer)targetEntity;
            jgPlayer = new JGPlayerMP(targetPlayer);
            jgPlayer.connectBaseNBT();
            String StE = jgPlayer.getStatusEffects();
            hasGoDOn = jgPlayer.hasStatusEffect(20, StE);
            boolean hasTurbo = JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA ? jgPlayer.hasStatusEffect(3, StE) : true;
            if (hasGoDOn && hasTurbo) {
               canIgnore = false;
               if (JGConfigDBCGoD.CONFIG_GOD_IGNORE_PROJECTILES_ENABLED && source.func_76364_f() instanceof IProjectile) {
                  canIgnore = true;
               }

               if (!canIgnore) {
                  for(int i = 0; i < JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES.length; ++i) {
                     if (source.func_76355_l().equals(JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES[i])) {
                        canIgnore = true;
                        break;
                     }
                  }
               }

               int i;
               if (!canIgnore) {
                  String name = source.func_76346_g().getClass().toString();

                  try {
                     for(i = 0; i < JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES.length; ++i) {
                        String key = JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES[i];
                        if ((JRMCoreH.DBC() || !key.startsWith("JinRyuu.DragonBC")) && (JRMCoreH.NC() || !key.startsWith("JinRyuu.NarutoC"))) {
                           if (name.equals(key)) {
                              canIgnore = true;
                              break;
                           }

                           Class cl = Class.forName(key);
                           if (cl.isAssignableFrom(source.func_76346_g().getClass())) {
                              canIgnore = true;
                              break;
                           }
                        }
                     }
                  } catch (Exception var16) {
                  }
               }

               if (canIgnore) {
                  float release = (float)jgPlayer.getRelease() / 100.0F;
                  i = jgPlayer.getAttribute(0);
                  int melee = JRMCoreH.stat(0, targetPlayer, 0, i, 0.0F);
                  int var10000 = (int)((float)melee * release);
                  int damagevalue = (int)event.ammount;
                  float MULTI = JGConfigDBCGoD.CONFIG_GOD_IGNORE_DAMAGE_MULTI;
                  if ((float)i * MULTI > (float)damagevalue) {
                     event.setCanceled(true);
                     return;
                  }
               }
            }
         }
      }

   }

   private float getUltraInstinctStaminaCost(EntityPlayer targetPlayer, byte targetState2, float staminaCost) {
      if (JGConfigUltraInstinct.CONFIG_UI_PERCENTAGE_STAMINA_COST) {
         byte pwr = JRMCoreH.getByte(targetPlayer, "jrmcPwrtyp");
         byte rce = JRMCoreH.getByte(targetPlayer, "jrmcRace");
         byte cls = JRMCoreH.getByte(targetPlayer, "jrmcClass");
         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(targetPlayer);
         int maxStamina = JRMCoreH.stat(targetPlayer, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
         if (staminaCost > 100.0F) {
            staminaCost = (float)maxStamina;
         } else if (staminaCost == 0.0F) {
            staminaCost = 0.0F;
         } else {
            staminaCost *= (float)maxStamina / 100.0F;
         }
      }

      return staminaCost;
   }

   private float getUltraInstinctCounterStaminaCost(EntityPlayer targetPlayer, byte targetState2) {
      return this.getUltraInstinctStaminaCost(targetPlayer, targetState2, (float)JGConfigUltraInstinct.CONFIG_UI_DODGE_STAMINA_COST[targetState2]);
   }

   private float getUltraInstinctDodgeStaminaCost(EntityPlayer targetPlayer, byte targetState2) {
      return this.getUltraInstinctStaminaCost(targetPlayer, targetState2, (float)JGConfigUltraInstinct.CONFIG_UI_COUNTER_STAMINA_COST[targetState2]);
   }

   private boolean hasUltraInstinctEnoughStaminaToDodge(EntityPlayer targetPlayer, byte targetState2) {
      float currentStamina = (float)JRMCoreH.getInt(targetPlayer, "jrmcStamina");
      float staminaCost = this.getUltraInstinctDodgeStaminaCost(targetPlayer, targetState2);
      return staminaCost <= currentStamina;
   }

   private boolean UltraInstinctCounter(DamageSource source, EntityPlayer targetPlayer, byte targetState2) {
      if (!source.func_76355_l().equals("UICounter")) {
         byte attackCurrent = JRMCoreH.getUltraInstinctCounterRate(targetPlayer, targetState2);
         if (source.func_76346_g() != null && (new Random()).nextInt(100) < attackCurrent) {
            DamageSource autoCounterAttack = Ds.causeUICounterDamage(targetPlayer);
            source.func_76346_g().func_70097_a(autoCounterAttack, 1.0F);
            ExtendedPlayer.get(targetPlayer).setUIAnimID((int)(Math.random() * 2.0D) + 2);
            ExtendedPlayer.get(targetPlayer).setUIAnim(15);
            return true;
         }
      }

      return false;
   }

   private boolean UltraInstinctDodge1(EntityPlayer targetPlayer, byte targetState2) {
      byte dodgeCurrent = JRMCoreH.getUltraInstinctDodgeRate(targetPlayer, targetState2);
      boolean dodge = this.UltraInstinctDodge(targetPlayer, targetState2, dodgeCurrent);
      return dodge;
   }

   private boolean UltraInstinctDodge2(EntityPlayer targetPlayer, byte targetState2, byte attacker) {
      byte dodgeRate = JRMCoreH.getUltraInstinctDodgeRate(targetPlayer, targetState2);
      byte dodgeCurrent = (byte)getUILevelDodgeDivision(JGConfigUltraInstinct.CONFIG_UI_LEVELS, targetState2, attacker, dodgeRate);
      return this.UltraInstinctDodge(targetPlayer, targetState2, dodgeCurrent);
   }

   private boolean UltraInstinctDodge(EntityPlayer targetPlayer, byte targetState2, byte dodgeCurrent) {
      int currentStamina = JRMCoreH.getInt(targetPlayer, "jrmcStamina");
      int staminaCost = (int)this.getUltraInstinctDodgeStaminaCost(targetPlayer, targetState2);
      if ((staminaCost <= 0 || staminaCost <= currentStamina) && (new Random()).nextInt(100) < dodgeCurrent) {
         int newStamina;
         if (staminaCost > 0) {
            newStamina = currentStamina - staminaCost;
            if (newStamina < 0) {
               newStamina = 0;
            }

            if (!JRMCoreH.isInCreativeMode(targetPlayer)) {
               JRMCoreH.setInt(newStamina, targetPlayer, "jrmcStamina");
            }
         }

         newStamina = (int)(Math.random() * 3.0D) + 1;
         targetPlayer.world.func_72956_a(targetPlayer, "jinryuudragonbc:DBC4.dodge" + newStamina, 0.5F, 0.9F / (targetPlayer.world.field_73012_v.nextFloat() * 0.6F + 0.9F));
         ExtendedPlayer.get(targetPlayer).setUIAnimID((int)(Math.random() * 2.0D));
         ExtendedPlayer.get(targetPlayer).setUIAnim(15);
         return true;
      } else {
         return false;
      }
   }

   public static int getUILevelDodgeDivision(int maxDivision, int target, int attacker, int dodgeRate) {
      float division = (float)getUILevelDivision(maxDivision, target, attacker);
      int result = division == 0.0F ? 0 : (int)((float)dodgeRate / division);
      return result;
   }

   public static int getUILevelDivision(int maxDivision, int targetUILevel, int attackerUILevel) {
      if (targetUILevel > attackerUILevel) {
         return maxDivision - (targetUILevel - attackerUILevel);
      } else {
         return targetUILevel < attackerUILevel ? maxDivision - (targetUILevel - attackerUILevel) : 0;
      }
   }

   @SubscribeEvent
   public void Sd35MR(LivingHurtEvent event) {
      float amount = event.ammount;
      DamageSource source = event.source;
      EntityLivingBase targetEntity = event.entityLiving;
      String s;
      if (targetEntity instanceof EntityPlayer && source != DamageSource.field_76380_i) {
         s = JRMCoreH.getString((EntityPlayer)targetEntity, "jrmcFuzion");
         if (s.contains(",")) {
            String[] fusionArray = s.split(",");
            if (targetEntity.getName().equalsIgnoreCase(fusionArray[1])) {
               event.ammount = 0.0F;
               event.setCanceled(true);
               return;
            }
         }
      }

      if (targetEntity instanceof EntityNPCshadow) {
         EntityNPCshadow e = (EntityNPCshadow)targetEntity;
         if (source.func_76346_g() instanceof EntityLivingBase && e.getSummoner() != source.func_76346_g()) {
            e.setDead();
         }
      }

      if (source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt) {
         event.ammount = 0.0F;
      }

      if (targetEntity instanceof EntityPlayer && source.func_76346_g() instanceof EntityPlayer) {
         s = JRMCoreH.rwip(FMLCommonHandler.instance().getMinecraftServerInstance(), targetEntity.field_71093_bK + "");
         if (s.equalsIgnoreCase("false")) {
            event.ammount = 0.0F;
            return;
         }
      }

      if (!event.isCanceled() && (this.dbc || this.nc || this.saoc) && amount != 0.0F && source != Ds.OutOfBodyHealth && source != Ds.NotAlive && source != DamageSource.field_76380_i) {
         boolean playerAttacked = false;
         EntityPlayer attacker;
         if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer) {
            attacker = (EntityPlayer)source.func_76346_g();
            String fusion = JRMCoreH.getString(attacker, "jrmcFuzion");
            if (fusion.contains(",")) {
               String[] fusionArray = fusion.split(",");
               if (attacker.getName().equalsIgnoreCase(fusionArray[0]) && targetEntity.getName().equalsIgnoreCase(fusionArray[1])) {
                  event.setCanceled(true);
                  return;
               }

               if (attacker.getName().equalsIgnoreCase(fusionArray[1]) && targetEntity.getName().equalsIgnoreCase(fusionArray[0])) {
                  event.setCanceled(true);
                  return;
               }

               if (targetEntity.getName().equalsIgnoreCase(fusionArray[1])) {
                  event.setCanceled(true);
                  return;
               }
            }

            boolean ultraInstinctCounter = source.func_76355_l().equals("UICounter");
            boolean Melee = ultraInstinctCounter || source.func_76364_f() == source.func_76346_g() && source.func_76355_l().equals("player");
            boolean energyAtt = source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt;
            boolean Projectile = source.func_76364_f() instanceof IProjectile && !energyAtt;
            int powerType = JRMCoreH.getByte(attacker, "jrmcPwrtyp");
            int race = JRMCoreH.getByte(attacker, "jrmcRace");
            int state = JRMCoreH.getByte(attacker, "jrmcState");
            int state2 = JRMCoreH.getByte(attacker, "jrmcState2");
            int classID = JRMCoreH.getByte(attacker, "jrmcClass");
            double release = (double)JRMCoreH.getByte(attacker, "jrmcRelease");
            String sklx = JRMCoreH.getString(attacker, "jrmcSSltX");
            int resrv = JRMCoreH.getInt(attacker, "jrmcArcRsrv");
            String absorption = JRMCoreH.getString(attacker, "jrmcMajinAbsorptionData");
            int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(attacker);
            String[] PlyrSkills = JRMCoreH.getString(attacker, "jrmcSSlts").split(",");
            String statusEffects = JRMCoreH.getString(attacker, "jrmcStatusEff");
            boolean mj = JRMCoreH.StusEfcts(12, statusEffects);
            boolean lg = JRMCoreH.StusEfcts(14, statusEffects);
            boolean kk = JRMCoreH.StusEfcts(5, statusEffects);
            boolean mc = JRMCoreH.StusEfcts(13, statusEffects);
            boolean mn = JRMCoreH.StusEfcts(19, statusEffects);
            boolean gd = JRMCoreH.StusEfcts(20, statusEffects);
            int currentStamina = JRMCoreH.getInt(attacker, "jrmcStamina");
            int currentEnergy = JRMCoreH.getInt(attacker, "jrmcEnrgy");
            int STR = PlyrAttrbts[0];
            int DEX = PlyrAttrbts[1];
            float dam = amount;
            float den = 0.0F;
            int ml = JRMCoreH.stat(0, attacker, 0, STR, 0.0F);
            int cst = (int)((float)ml * 0.1F);
            int cstF = 0;
            int cstF2 = false;
            int handEffectID = 0;
            int UI_cost;
            int sklkf;
            int dealt;
            int epoch;
            int tp;
            int epoch;
            int skf;
            boolean c;
            boolean take_stamina;
            byte tp;
            if (JRMCoreH.isPowerTypeKi(powerType)) {
               if (JGConfigDBCFormMastery.FM_Enabled && release > 0.0D) {
                  JRMCoreH.addToFormMasteriesValue(attacker, JGConfigDBCFormMastery.FM_GainDamageDealt, JGConfigDBCFormMastery.FM_GainDamageDealt, race, state, state2, kk, mc, mn, gd, 1);
               }

               c = JRMCoreH.StusEfcts(10, statusEffects) || JRMCoreH.StusEfcts(11, statusEffects);
               if (Melee) {
                  sklkf = JRMCoreH.SklLvl(12, (String[])PlyrSkills);
                  take_stamina = !JRMCoreH.PlyrSettingsB((EntityPlayer)attacker, 9);
                  epoch = 0;
                  tp = 0;
                  if (sklkf > 0 && take_stamina) {
                     epoch = PlyrAttrbts[5];
                     skf = JRMCoreH.stat(attacker, 5, powerType, 5, epoch, race, classID, JRMCoreH.SklLvl_KiBs((String[])PlyrSkills, powerType));
                     epoch = (int)((double)sklkf * 0.0025D * (double)skf * release * 0.01D);
                     if (epoch > 0) {
                        cstF = (int)((double)epoch * DBCConfig.cnfKFc);
                        if (currentEnergy <= cstF) {
                           epoch = 0;
                           cstF = 0;
                        }

                        epoch = (int)((double)epoch * DBCConfig.cnfKFd);
                     }
                  }

                  STR = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 0, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
                  epoch = JRMCoreH.stat(attacker, 0, powerType, 0, STR, race, classID, 0.0F);
                  double curAtr = (double)epoch * release * 0.01D * (double)JRMCoreH.weightPerc(0, attacker);
                  boolean sklkfe2 = JRMCoreH.PlyrSettingsB((EntityPlayer)attacker, 13);
                  boolean sklkfe3 = JRMCoreH.PlyrSettingsI((EntityPlayer)attacker, 13, 1);
                  int skf = JRMCoreH.SklLvl(15, (String[])PlyrSkills);
                  boolean hasKiWeaponEnabled = sklkf > 0 && skf > 0 && sklkfe2;
                  if (hasKiWeaponEnabled) {
                     int WIL = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 3, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
                     attacker.world.func_72956_a(attacker, "jinryuudragonbc:DBC4.kiblade2", 1.0F, 1.0F);
                     int kiWeaponCost = 0;
                     int kiWeaponDamage = 0;
                     int dmg1 = (int)((float)JRMCoreH.stat(attacker, 3, powerType, 4, WIL, race, classID, 0.0F) * 0.01F);
                     float data1 = (float)((int)(0.005D * (double)dmg1 * release * 0.01D * (sklkfe3 ? DBCConfig.cnfKCsd : DBCConfig.cnfKBld) * JRMCoreConfig.dat5699));
                     float data2 = (float)((int)(0.005D * (double)dmg1 * release * 0.01D * (sklkfe3 ? DBCConfig.cnfKCsc : DBCConfig.cnfKBlc)));
                     int kiWeaponCost = (int)((float)kiWeaponCost + data2 / (sklkf > 1 ? (float)sklkf * 0.3F + 1.0F : 1.0F));
                     int kiWeaponDamage = (int)((float)kiWeaponDamage + (float)sklkf * data1);
                     boolean sklks2;
                     if (tp > 0) {
                        if (currentEnergy <= tp) {
                           sklks2 = false;
                           cstF2 = false;
                        }

                        tp = 0;
                     }

                     dmg1 = (int)((float)JRMCoreH.stat(attacker, 3, powerType, 4, WIL, race, classID, 0.0F) * 0.01F);
                     data1 = (float)((double)dmg1 * release * 0.009999999776482582D * (double)JRMCoreH.weightPerc(1, attacker) * (sklkfe3 ? DBCConfig.cnfKCsd : DBCConfig.cnfKBld) * JRMCoreConfig.dat5700);
                     data2 = (float)((double)dmg1 * release * 0.009999999776482582D * (double)JRMCoreH.weightPerc(1, attacker) * (sklkfe3 ? DBCConfig.cnfKCsc : DBCConfig.cnfKBlc));
                     kiWeaponCost = (int)((float)kiWeaponCost + data2 / (skf > 1 ? (float)skf * 0.3F + 1.0F : 1.0F));
                     kiWeaponDamage = (int)((float)kiWeaponDamage + (float)skf * data1);
                     if (tp > 0) {
                        if (currentEnergy <= tp) {
                           sklks2 = false;
                           cstF2 = false;
                        }

                        sklks2 = false;
                     }

                     if (kiWeaponCost > 0 && currentEnergy >= kiWeaponCost) {
                        dam = amount + (float)kiWeaponDamage;
                        currentEnergy -= kiWeaponCost;
                        if (!JRMCoreH.isInCreativeMode(attacker)) {
                           JRMCoreH.setInt(currentEnergy - kiWeaponCost, attacker, "jrmcEnrgy");
                        }
                     }
                  }

                  if (JRMCoreConfig.DebugInfo) {
                     mod_JRMCore.logger.info(attacker.getName() + " attacks " + targetEntity.getName() + " with melee " + curAtr + "+" + epoch + "=" + (curAtr + (double)epoch));
                  }

                  dam = (float)((double)dam + curAtr + (double)epoch);
               } else if (Projectile) {
                  cst = 1;
                  sklkf = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 3, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
                  dealt = (int)((float)JRMCoreH.stat(attacker, 3, powerType, 4, sklkf, race, classID, 0.0F) * 0.01F);
                  epoch = JRMCoreH.SklLvl(15, (String[])PlyrSkills);
                  dam = (float)((double)amount + (double)dealt * release * 0.004999999888241291D * (double)epoch * (double)JRMCoreH.weightPerc(1, attacker));
               }
            } else if (powerType == 2 && Melee) {
               c = false;
               sklkf = 0;
               if (JRMCoreH.NC() && attacker != null) {
                  handEffectID = ExtendedPlayer.get(attacker).getHandEffect();
                  sklkf = ExtendedPlayer.get(attacker).getEffect_used2();
                  if (handEffectID < 3 && handEffectID > 0 && attacker != null && attacker instanceof EntityPlayer && (handEffectID == 1 || handEffectID == 2)) {
                     JRMCoreH.newExpl(targetEntity.world, attacker, targetEntity.posX, targetEntity.posY, targetEntity.posZ, 0.0F, false, 0.0D, attacker, (byte)(2 + handEffectID));
                     c = true;
                     ExtendedPlayer.get(attacker).setHandEffect(0);
                     ExtendedPlayer.get(attacker).setEffect_used(0);
                     ExtendedPlayer.get(attacker).setEffect_used2(0);
                  }
               }

               STR = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 0, state, state2, race, sklx, (int)release, resrv, lg, mj, false, false, false, false, powerType, PlyrSkills, false, "0");
               dealt = JRMCoreH.SklLvl(0, 2, PlyrSkills);
               epoch = JRMCoreH.SklLvlY(2, JRMCoreH.getString(attacker, "jrmcSSltY"));
               den = classID == 1 ? (float)(epoch * JRMCoreConfig.hedp) * 0.01F : 0.0F;
               tp = JRMCoreH.stat(attacker, 0, powerType, 0, STR, race, classID, (float)dealt * 0.04F + (float)state * 0.25F);
               dam = (float)((double)amount + (double)tp * release * 0.009999999776482582D + (double)sklkf);
            } else if (powerType == 3 && Melee) {
               UI_cost = JRMCoreHSAC.getWeaponDamage(attacker.func_71045_bC(), STR);
               STR += JRMCoreHSAC.getWeaponBonus(attacker.func_71045_bC(), 0);
               DEX += JRMCoreHSAC.getWeaponBonus(attacker.func_71045_bC(), 1);
               sklkf = (int)JRMCoreHSAC.getDamage(UI_cost, STR, DEX);
               dam = amount + (float)sklkf;
               cst = 0;
            }

            if (ultraInstinctCounter) {
               dam *= (float)JGConfigUltraInstinct.CONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[JRMCoreH.state2UltraInstinct(!mn, (byte)state2)] * 0.01F;
            }

            dam = dam <= 0.0F ? 1.0F : dam;
            UI_cost = 0;
            if (Melee && ultraInstinctCounter) {
               UI_cost = (int)this.getUltraInstinctCounterStaminaCost(attacker, (byte)JRMCoreH.state2UltraInstinct(!mn, (byte)state2));
            }

            cst = (int)((double)cst * JRMCoreConfig.cnfPnchc + (double)UI_cost);
            if (currentStamina > cst && dam > 0.0F) {
               event.ammount = 0.0F;
               boolean doAttack = true;
               if (this.dbc && JRMCoreConfig.sfzns) {
                  doAttack = !JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone(targetEntity);
               }

               if (doAttack) {
                  playerAttacked = true;
                  if (Melee) {
                     take_stamina = ultraInstinctCounter ? UI_cost > 0 : true;
                     if (take_stamina) {
                        epoch = currentStamina - cst;
                        if (!JRMCoreH.isInCreativeMode(attacker)) {
                           JRMCoreH.setInt(epoch, attacker, "jrmcStamina");
                        }
                     }

                     if (cstF > 0 && currentEnergy >= cstF && !JRMCoreH.isInCreativeMode(attacker)) {
                        JRMCoreH.setInt(currentEnergy - cstF, attacker, "jrmcEnrgy");
                     }
                  }

                  dealt = (int)dam;
                  if (targetEntity instanceof EntityPlayer) {
                     EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
                     int acc = JRMCoreH.getByte(targetPlayer, "jrmcAccept");
                     if (acc == 0 || JRMCoreH.getByte(targetPlayer, "jrmcPwrtyp") == 0) {
                        event.setCanceled(false);
                        return;
                     }

                     dam = this.damageEntity(targetPlayer, source, dam);
                     JRMCoreH.a1t3(targetPlayer);
                     epoch = (int)(System.currentTimeMillis() / 1000L);
                     JRMCoreH.setInt(epoch + 5, targetPlayer, "jrmcAttackLstPlyrTm");
                     JRMCoreH.setString(attacker.func_110124_au().toString(), targetPlayer, "jrmcAttackLstPlyrNam");
                     if (energyAtt) {
                        dealt = JRMCoreH.jrmcDam(targetPlayer, (int)dam, source, ((EntityEnergyAtt)source.func_76364_f()).getType());
                     } else if (powerType == 1 && Projectile) {
                        skf = JRMCoreH.SklLvl(15, (String[])PlyrSkills);
                        int cost = (int)((double)dam * 0.005D * (double)skf * DBCConfig.cnfKIc);
                        if (currentEnergy < cost) {
                           event.setCanceled(false);
                           return;
                        }

                        if (!JRMCoreH.isInCreativeMode(attacker)) {
                           JRMCoreH.setInt(currentEnergy - cost, attacker, "jrmcEnrgy");
                        }

                        dealt = JRMCoreH.jrmcDam(targetPlayer, (int)((double)dam * DBCConfig.cnfKId), source);
                        this.knockback(targetPlayer, attacker, 1);
                     } else {
                        dealt = JRMCoreH.jrmcDam(targetPlayer, (int)dam, source);
                        this.knockback(targetPlayer, attacker, 1);
                     }

                     if (this.nc && JRMCoreH.clsTypOn(attacker) == 1 && JRMCoreH.getByte(attacker, "jrmcPwrtyp") == 2) {
                        JRMCoreH.jrmcEnergyDam(targetPlayer, (int)(dam * den), source);
                     }
                  } else if (!this.dbc || JRMCoreH.DGE(targetEntity)) {
                     if (powerType == 1 && Projectile) {
                        epoch = JRMCoreH.SklLvl(15, (String[])PlyrSkills);
                        tp = (int)((double)dam * 0.005D * (double)epoch * DBCConfig.cnfKIc);
                        if (currentEnergy < tp) {
                           event.setCanceled(false);
                           return;
                        }

                        if (!JRMCoreH.isInCreativeMode(attacker)) {
                           JRMCoreH.setInt(currentEnergy - tp, attacker, "jrmcEnrgy");
                        }

                        dealt = (int)dam;
                        this.damageEntity(targetEntity, source, (float)((int)((double)dam * DBCConfig.cnfKId)));
                        this.knockback(targetEntity, attacker, 1);
                        this.knockback(targetEntity, attacker, 1);
                     } else {
                        dealt = (int)dam;
                        this.damageEntity(targetEntity, source, dam);
                        if (handEffectID == 1) {
                           this.damageEntity(targetEntity, source, dam);
                           float push = 1.0F;
                           targetEntity.field_70159_w += (double)(attacker.posX > targetEntity.posX ? -push : push);
                           targetEntity.field_70181_x += (double)(attacker.posY > targetEntity.posY ? -push : push);
                           targetEntity.field_70179_y += (double)(attacker.posZ > targetEntity.posZ ? -push : push);
                           targetEntity.field_70133_I = true;
                        } else if (handEffectID == 0) {
                           this.knockback(targetEntity, attacker, 1);
                        }
                     }
                  }

                  if (!attacker.world.field_72995_K && (!this.dbc || JRMCoreH.DGE(targetEntity)) && attacker != null) {
                     boolean giveTP = true;
                     if (source.func_76364_f() != null && energyAtt) {
                        EntityEnergyAtt kiAttack = (EntityEnergyAtt)source.func_76364_f();
                        if (kiAttack.givenTP) {
                           giveTP = false;
                        } else {
                           kiAttack.givenTP = true;
                        }
                     }

                     if (giveTP) {
                        tp = 1;
                        if (targetEntity instanceof EntityPlayer) {
                           int[] PlyrAttrbtsTar = JRMCoreH.PlyrAttrbts((EntityPlayer)targetEntity);
                           int rltar = JRMCoreH.getByte(attacker, "jrmcRelease");
                           float tartp = (float)PlyrAttrbtsTar[4] / (JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race]) * (float)rltar * 0.01F;
                           float atttp = (float)((double)((float)PlyrAttrbts[4] / (JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race])) * release);
                           float mult = tartp / atttp;
                           mult = mult > 2.0F ? 2.0F : mult;
                           tp = (int)((float)tp + atttp * mult);
                        } else {
                           float atttp;
                           if (targetEntity instanceof EntityNPCshadow) {
                              atttp = (float)PlyrAttrbts[4] / (JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race]);
                              float mult = (float)((double)atttp / ((double)atttp * release * 0.009999999776482582D));
                              mult = mult > 2.0F ? 2.0F : mult;
                              tp = (int)((float)tp + atttp * mult);
                           } else {
                              atttp = (float)((double)((float)PlyrAttrbts[4] / (JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race])) * release * 0.009999999776482582D);
                              tp = (int)((float)tp + atttp);
                           }
                        }

                        JRMCoreH.jrmcExp(attacker, tp);
                     }
                  }

                  if (source.field_76373_n.equalsIgnoreCase("player")) {
                     epoch = (int)(Math.random() * 3.0D) + 1;
                     attacker.world.func_72956_a(attacker, "jinryuudragonbc:DBC4.punch" + epoch, 0.5F, 0.9F / (attacker.world.field_73012_v.nextFloat() * 0.4F + 0.8F));
                  }

                  if (attacker != null) {
                     JRMCoreH.setInt(dealt, attacker, "jrmcLastDamageDealt");
                  }

                  if (targetEntity != null && targetEntity instanceof EntityPlayer) {
                     JRMCoreH.setInt(dealt, (EntityPlayer)targetEntity, "jrmcLastDamageReceived");
                     if (attacker != null) {
                        epoch = (int)(System.currentTimeMillis() / 1000L);
                        JRMCoreH.setString(attacker.getName() + ";" + epoch, (EntityPlayer)targetEntity, "jrmcLastAttacker");
                     }
                  } else if (targetEntity != null) {
                     JRMCoreH.nbt((Entity)targetEntity).func_74768_a("jrmcLastDamageReceived", dealt);
                     if (attacker != null) {
                        epoch = (int)(System.currentTimeMillis() / 1000L);
                        JRMCoreH.nbt((Entity)targetEntity).func_74778_a("jrmcLastAttacker", attacker.getName() + ";" + epoch);
                     }
                  }

                  return;
               }

               if (attacker instanceof EntityPlayer) {
                  String t = JRMCoreH.cly + StatCollector.func_74838_a("dbc.entitymasters.nofightinsafe");
                  attacker.func_145747_a(new ChatComponentText(JRMCoreH.cly + t));
                  event.ammount = 0.0F;
                  return;
               }
            }
         }

         if (!playerAttacked && source != DamageSource.field_76380_i && targetEntity instanceof EntityPlayer) {
            attacker = (EntityPlayer)targetEntity;
            int acc = JRMCoreH.getByte(attacker, "jrmcAccept");
            if (acc == 0 || JRMCoreH.getByte(attacker, "jrmcPwrtyp") == 0) {
               event.setCanceled(false);
               return;
            }

            Entity attacker = source.func_76346_g();
            int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(attacker);
            byte race = JRMCoreH.getByte(attacker, "jrmcRace");
            byte release = JRMCoreH.getByte(attacker, "jrmcRelease");
            int currentBody = JRMCoreH.getInt(attacker, "jrmcBdy");
            if (!attacker.field_71075_bZ.field_75098_d && (this.dbc || this.nc || this.saoc)) {
               event.ammount = 0.0F;
               boolean doAttack = true;
               if (this.dbc && JRMCoreConfig.sfzns) {
                  doAttack = !JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone(targetEntity);
               }

               if (doAttack) {
                  amount = this.damageEntity(attacker, source, amount);
                  int dealt = 0;
                  JRMCoreH.a1t3(attacker);
                  if (attacker instanceof EntityNPCshadow) {
                     if ((float)currentBody > amount) {
                        dealt = JRMCoreH.jrmcDam(attacker, (int)amount, source);
                     } else {
                        attacker.setDead();
                     }
                  } else if (source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt) {
                     dealt = JRMCoreH.jrmcDam(attacker, (int)amount, source, ((EntityEnergyAtt)source.func_76364_f()).getType());
                  } else {
                     dealt = JRMCoreH.jrmcDam(attacker, (int)amount, source);
                  }

                  if (attacker != null) {
                     this.knockback(targetEntity, attacker, 1);
                  }

                  if (attacker != null) {
                     if (attacker instanceof EntityPlayer) {
                        JRMCoreH.setInt(dealt, (EntityPlayer)attacker, "jrmcLastDamageDealt");
                     } else {
                        JRMCoreH.nbt(attacker).func_74768_a("jrmcLastDamageDealt", dealt);
                     }
                  }

                  int epoch;
                  if (targetEntity != null && targetEntity instanceof EntityPlayer) {
                     JRMCoreH.setInt(dealt, (EntityPlayer)targetEntity, "jrmcLastDamageReceived");
                     if (attacker != null) {
                        epoch = (int)(System.currentTimeMillis() / 1000L);
                        JRMCoreH.setString(attacker.getName() + ";" + epoch, (EntityPlayer)targetEntity, "jrmcLastAttacker");
                     }
                  } else if (targetEntity != null) {
                     JRMCoreH.nbt((Entity)targetEntity).func_74768_a("jrmcLastDamageReceived", dealt);
                     if (attacker != null) {
                        epoch = (int)(System.currentTimeMillis() / 1000L);
                        JRMCoreH.nbt((Entity)targetEntity).func_74778_a("jrmcLastAttacker", attacker.getName() + ";" + epoch);
                     }
                  }

                  return;
               }

               if (attacker instanceof EntityPlayer) {
                  String t = JRMCoreH.cly + StatCollector.func_74838_a("dbc.entitymasters.nofightinsafe");
                  ((EntityPlayer)attacker).func_145747_a(new ChatComponentText(JRMCoreH.cly + t));
                  event.ammount = 0.0F;
                  return;
               }
            }
         }
      }

   }

   protected void knockback(EntityLivingBase targetEntity, Entity attacker, int knockbackStrength) {
      if (knockbackStrength > 0) {
         float var25 = MathHelper.func_76133_a(attacker.field_70159_w * attacker.field_70159_w + attacker.field_70179_y * attacker.field_70179_y);
         if (var25 > 0.0F) {
            targetEntity.func_70024_g(attacker.field_70159_w * (double)knockbackStrength * 0.6000000238418579D / (double)var25, 0.1D, attacker.field_70179_y * (double)knockbackStrength * 0.6000000238418579D / (double)var25);
         }
      }

   }

   protected float damageEntity(EntityPlayer targetPlayer, DamageSource source, float amount) {
      if (!targetPlayer.func_85032_ar()) {
         if (amount <= 0.0F) {
            return 0.0F;
         }

         if (!source.func_76363_c() && targetPlayer.func_70632_aY() && amount > 0.0F) {
            amount = (1.0F + amount) * 0.5F;
         }

         amount = this.ApplyArmor(targetPlayer, targetPlayer.field_71071_by.field_70460_b, source, (double)amount);
         if (amount <= 0.0F) {
            return 0.0F;
         }

         if (amount != 0.0F) {
            targetPlayer.func_71020_j(source.func_76345_d());
         }
      }

      return amount;
   }

   private float ApplyArmor(EntityLivingBase entity, ItemStack[] inventory, DamageSource source, double damage) {
      int armorNum = 0;
      int armorVal = 0;
      ItemStack[] var8 = inventory;
      int var9 = inventory.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ItemStack stack = var8[var10];
         if (stack != null) {
            ++armorNum;
         }
      }

      int itemProtect;
      int i;
      ItemStack stack;
      if (entity instanceof EntityPlayer) {
         for(i = 0; i < 1; ++i) {
            stack = ExtendedPlayer.get((EntityPlayer)entity).inventory.func_70301_a(0);
            if (stack != null) {
               if (stack != null) {
                  ++armorNum;
                  float armorMax = 5.0F;
                  int itemProtect = (int)(damage * (double)(armorMax / (armorMax + 25.0F)));
                  itemProtect = (int)(damage < 30.0D ? (float)itemProtect : armorMax);
                  itemProtect = damage > 10000.0D ? 3 : (damage > 5000.0D ? 2 : 1);
                  itemProtect = itemProtect < 1 ? 1 : itemProtect;
                  armorVal += itemProtect;
                  stack.func_77972_a(itemProtect, entity);
               }

               if (stack.field_77994_a <= 0) {
                  ExtendedPlayer.get((EntityPlayer)entity).inventory.func_70299_a(0, (ItemStack)null);
               }
            }
         }
      }

      if (armorNum == 0) {
         return (float)damage;
      } else {
         for(i = 0; i < 4; ++i) {
            stack = inventory[i];
            if (stack != null) {
               if (stack != null && stack.func_77973_b() instanceof ItemArmor && !source.func_76363_c()) {
                  ItemArmor armor = (ItemArmor)stack.func_77973_b();
                  float armorMax = (float)armor.field_77879_b;
                  itemProtect = (int)(damage * (double)(armorMax / (armorMax + 25.0F)));
                  itemProtect = (int)(damage < 30.0D ? (float)itemProtect : armorMax);
                  int itemDamage = damage > 10000.0D ? 3 : (damage > 5000.0D ? 2 : 1);
                  itemDamage = itemDamage < 1 ? 1 : itemDamage;
                  armorVal += itemProtect;
                  stack.func_77972_a(itemDamage, entity);
               }

               if (stack.field_77994_a <= 0) {
                  inventory[i] = null;
               }
            }
         }

         return (float)(damage - (double)armorVal);
      }
   }

   protected void damageEntity(EntityLivingBase targetEntity, DamageSource source, float amount) {
      if (!targetEntity.func_85032_ar()) {
         if (amount <= 0.0F) {
            return;
         }

         if (amount != 0.0F) {
            JRMCoreH.jrmctAll(4, targetEntity.func_145782_y() + ";take;" + amount);
            float f2 = targetEntity.func_110143_aJ();
            targetEntity.func_70606_j(f2 - amount);
            targetEntity.func_110142_aN().func_94547_a(source, f2, amount);
            targetEntity.func_110149_m(targetEntity.func_110139_bj() - amount);
         }
      }

   }

   @SubscribeEvent
   public void P5vE4Y(FillBucketEvent e) {
      Item item = e.current.func_77973_b();
      if (item instanceof ItemBucket) {
         EntityPlayer p = e.entityPlayer;
         boolean icr = p.field_71075_bZ.field_75098_d;
         if (JRMCoreConfig.sfzns && this.dbc && !icr && JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone(p)) {
            e.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   public void P5vE4Y(Start e) {
      Item item = e.item.func_77973_b();
      if (item instanceof ItemFood) {
         EntityPlayer player = e.entityPlayer;
         if (!player.world.field_72995_K) {
            JGPlayerMP jgPlayer = new JGPlayerMP(player);
            jgPlayer.connectBaseNBT();
            if (!JRMCoreConfig.CanEatWhileKOd && jgPlayer.getNBT().func_74762_e("jrmcHar4va") > 0) {
               e.setCanceled(true);
               return;
            }
         }
      }

   }

   @SubscribeEvent
   public void P5vE4Y(Finish e) {
      Item item = e.item.func_77973_b();
      if (item instanceof ItemFood) {
         EntityPlayer player = e.entityPlayer;
         if (!player.world.field_72995_K) {
            JGPlayerMP jgPlayer = new JGPlayerMP(player);
            jgPlayer.connectBaseNBT();
            if (!JRMCoreConfig.CanEatWhileKOd && jgPlayer.getNBT().func_74762_e("jrmcHar4va") > 0) {
               if (e.isCancelable()) {
                  e.setCanceled(true);
               }

               return;
            }

            int[] playerAttributes = jgPlayer.getAttributes();
            byte powerType = jgPlayer.getPowerType();
            byte race = jgPlayer.getRace();
            byte classID = jgPlayer.getClassID();
            int curBody = jgPlayer.getHealth();
            int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
            int curEnergy = jgPlayer.getEnergy();
            int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs((EntityPlayer)player, powerType));
            ItemFood itemFood = ((ItemFood)item).func_77848_i();
            if (curBody != maxBody || curEnergy != maxEnergy) {
               int healAmount = itemFood.func_150905_g(e.item);
               float healHealth = JRMCoreConfig.GlobalFoodHealMultiHealth;
               float healEnergy = JRMCoreConfig.GlobalFoodHealMultiEnergy;
               String itemName = item.func_77658_a();
               if (JRMCoreConfig.FoodHealMulti.size() > 0 && JRMCoreConfig.FoodHealMulti.containsKey(itemName)) {
                  float[] values = (float[])JRMCoreConfig.FoodHealMulti.get(itemName);
                  healHealth *= values[0];
                  healEnergy *= values[1];
               }

               int maxB = (int)((float)maxBody * healHealth * (float)healAmount);
               int maxE = (int)((float)maxEnergy * healEnergy * (float)healAmount);
               int body = curBody + maxB;
               JRMCoreH.setInt(body > maxBody ? maxBody : body, player, "jrmcBdy");
               int en = curEnergy + maxE;
               JRMCoreH.setInt(en > maxEnergy ? maxEnergy : en, player, "jrmcEnrgy");
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   private String n3nj5w(String r8w) {
      return r8w.replaceAll("l", "t").replaceAll("q", "r").replaceAll("c", ":").replaceAll("x", "n").replaceAll("z", "p").replaceAll("b", "j").replaceAll("y", ".").replaceAll("v", "/").replaceAll("d", "?").replaceAll("f", "=").replaceAll("k", "e");
   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void MPbr5K(ClientChatReceivedEvent event) {
      IChatComponent msg = event.message;
   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public void BLKn6D(FogColors event) {
      if (this.dbc) {
         float r = event.red;
         float g = event.green;
         float b = event.blue;
         if (JRMCoreHDBC.dragonSum > 0) {
            --JRMCoreHDBC.dragonSum;
            if (!this.setCol) {
               this.red = event.red;
               this.green = event.green;
               this.blue = event.blue;
            }

            if (this.red > 0.0F) {
               this.red -= event.red * 0.01F;
            }

            event.red = this.red;
            if (this.green > 0.0F) {
               this.green -= event.green * 0.01F;
            }

            event.green = this.green;
            if (this.blue > 0.0F) {
               this.blue -= event.blue * 0.01F;
            }

            event.blue = this.blue;
            this.setCol = true;
         } else if (this.setCol) {
            if (event.red > this.red && r >= this.red) {
               this.red += r * 0.01F;
            }

            event.red = this.red;
            if (event.green > this.green && g >= this.green) {
               this.green += g * 0.01F;
            }

            event.green = this.green;
            if (event.blue > this.blue && b >= this.blue) {
               this.blue += b * 0.01F;
            }

            event.blue = this.blue;
            if (r <= this.red && g <= this.green && b <= this.blue) {
               this.setCol = false;
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent(
      priority = EventPriority.NORMAL,
      receiveCanceled = true
   )
   public void Ju7scP(FogDensity event) {
      if (this.dbc) {
         float d = 0.005F;
         if (JRMCoreHDBC.dragonSum > 0) {
            --JRMCoreHDBC.dragonSum;
            if (!this.setDen) {
               this.density = 0.005F;
            }

            if (this.density < 0.03F) {
               this.density += event.density * 1.0E-4F;
            }

            event.density = this.density;
            GL11.glFogi(2917, 2048);
            event.setCanceled(true);
            this.setDen = true;
         } else if (this.setDen) {
            if (event.density > this.density && d <= this.density) {
               this.density -= 1.0E-4F;
            }

            event.density = this.density;
            GL11.glFogi(2917, 2048);
            event.setCanceled(true);
            if (d >= this.density) {
               this.setDen = false;
            }
         }
      }

      if (this.nc) {
         String m;
         if (JRMCoreClient.mc.field_71415_G && JRMCoreH.State == 1 && JRMCoreH.Pwrtyp == 2 && JRMCoreH.Class == 1 && JRMCoreH.PlyrSkillY != null && JRMCoreH.curEnergy > 0) {
            m = JRMCoreH.ncCSkls[JRMCoreH.Class];
            if (JRMCoreH.PlyrSkillY.contains(m)) {
               int t = Integer.parseInt(JRMCoreH.PlyrSkillY.replaceAll(m, ""));
               event.density = 0.09F - (float)t * 0.01F;
               GL11.glFogi(2917, 2048);
               event.setCanceled(true);
            }
         }

         if (JRMCoreH.Pwrtyp == 2 && JRMCoreH.inIll != null && JRMCoreH.inIll.length > 1) {
            m = JRMCoreH.inIll[0];
            String[] j = JRMCoreH.pmj[Integer.parseInt(JRMCoreH.inIll[1])];
            int dmg = Integer.parseInt(JRMCoreH.inIll[2]);
            int t = Integer.parseInt(JRMCoreH.inIll[3]);
            int l = 0;
            String doujutsu = JRMCoreH.ncCSkls[JRMCoreH.Class];
            if (JRMCoreH.PlyrSkillY.contains(doujutsu) && doujutsu.contains("SG") && JRMCoreH.State == 1) {
               l = Integer.parseInt(JRMCoreH.PlyrSkillY.replaceAll(doujutsu, "")) + 1;
            }

            event.density = 1.5F - (float)l * 0.14F;
            GL11.glFogi(2917, 2048);
            event.setCanceled(true);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void ZcJt9r(RenderBlockOverlayEvent e) {
      if (this.dbc && e.player.world.func_147439_a(e.blockX, e.blockY, e.blockZ) == JRMCoreHDBC.getMedBlock()) {
         e.setCanceled(true);
         this.renderWarpedTextureOverlay(e.renderPartialTicks);
      }

   }

   private void renderWarpedTextureOverlay(float p_78448_1_) {
      JRMCoreClient.mc.func_110434_K().bindTexture(RES_UNDERMEDLIQUID_OVERLAY);
      Tessellator tessellator = Tessellator.INSTANCE;
      float f1 = JRMCoreClient.mc.player.func_70013_c(p_78448_1_);
      GL11.glColor4f(f1, f1, f1, 0.5F);
      GL11.glEnable(3042);
      OpenGlHelper.func_148821_a(770, 771, 1, 0);
      GL11.glPushMatrix();
      float f2 = 4.0F;
      float f3 = -1.0F;
      float f4 = 1.0F;
      float f5 = -1.0F;
      float f6 = 1.0F;
      float f7 = -0.5F;
      float f8 = -JRMCoreClient.mc.player.rotationYaw / 64.0F;
      float f9 = JRMCoreClient.mc.player.rotationPitch / 64.0F;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)f3, (double)f5, (double)f7, (double)(f2 + f8), (double)(f2 + f9));
      tessellator.func_78374_a((double)f4, (double)f5, (double)f7, (double)(0.0F + f8), (double)(f2 + f9));
      tessellator.func_78374_a((double)f4, (double)f6, (double)f7, (double)(0.0F + f8), (double)(0.0F + f9));
      tessellator.func_78374_a((double)f3, (double)f6, (double)f7, (double)(f2 + f8), (double)(0.0F + f9));
      tessellator.func_78381_a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   @SubscribeEvent
   public void joinWorld(EntityJoinWorldEvent event) {
      Entity entity = event.entity;
      if (event.world != null && !event.world.field_72995_K && entity != null && entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         player.func_145747_a(new ChatComponentText("jinryuujrmcore.entitymasters.clear"));
      }

   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void serverChatEvent(ClientChatReceivedEvent event) {
      if (event != null && event.message != null && event.message.func_150260_c() != null) {
         boolean safeZoneUIMode = JGConfigClientSettings.safeZoneUIModeOn;
         String[] data = event.message.func_150260_c().split("\\:");
         String main = data[0];
         if (main.equals("jinryuujrmcore.entitymasters.clear")) {
            currentSafeZoneNames.clear();
            event.setCanceled(true);
            return;
         }

         String t;
         if (main.equals("jinryuujrmcore.entitymasters.insafezone")) {
            if (!safeZoneUIMode) {
               t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.insafezone");
               event.message = (new ChatComponentTranslation(t, new Object[]{data[1]})).func_150255_a(JRMCoreH2.styl_ylw);
            }

            currentSafeZoneNames.add("(" + data[1] + ")");
            if (safeZoneUIMode) {
               event.setCanceled(true);
            }

            return;
         }

         if (main.equals("jinryuujrmcore.entitymasters.insaafezone")) {
            if (!safeZoneUIMode) {
               t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.insaafezone");
               event.message = (new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw);
            }

            currentSafeZoneNames.add("(Safe Zone)");
            if (safeZoneUIMode) {
               event.setCanceled(true);
            }

            return;
         }

         Iterator var6;
         String sf;
         int i;
         if (main.equals("jinryuujrmcore.entitymasters.leftsafe")) {
            if (!safeZoneUIMode) {
               t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.leftsafe");
               event.message = (new ChatComponentTranslation(t, new Object[]{data[1]})).func_150255_a(JRMCoreH2.styl_ylw);
            }

            i = 0;

            for(var6 = currentSafeZoneNames.iterator(); var6.hasNext(); ++i) {
               sf = (String)var6.next();
               if (sf.equals("(" + data[1] + ")")) {
                  currentSafeZoneNames.remove(i);
                  break;
               }
            }

            if (safeZoneUIMode) {
               event.setCanceled(true);
            }

            return;
         }

         if (main.equals("jinryuujrmcore.entitymasters.leftasafe")) {
            if (!safeZoneUIMode) {
               t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.leftasafe");
               event.message = (new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw);
            }

            i = 0;

            for(var6 = currentSafeZoneNames.iterator(); var6.hasNext(); ++i) {
               sf = (String)var6.next();
               if (sf.equals("(Safe Zone)")) {
                  currentSafeZoneNames.remove(i);
                  break;
               }
            }

            if (safeZoneUIMode) {
               event.setCanceled(true);
            }

            return;
         }
      }

   }

   static {
      color = (new ChatStyle()).func_150238_a(EnumChatFormatting.DARK_GREEN);
      allSafeZones = new ArrayList();
      aw = false;
      gk = false;
      dt = false;
      RES_UNDERMEDLIQUID_OVERLAY = new ResourceLocation("jinryuudragonbc:textures/misc/undermedicalliquid.png");
      currentSafeZoneNames = new ArrayList();
   }
}
