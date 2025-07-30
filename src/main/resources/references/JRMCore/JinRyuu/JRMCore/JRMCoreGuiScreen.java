package JinRyuu.JRMCore;

import JinRyuu.JRMCore.client.JGRecipeHandler;
import JinRyuu.JRMCore.client.JGRenderHelper;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigsClient;
import JinRyuu.JRMCore.client.minigame.MiniGame;
import JinRyuu.JRMCore.client.minigame.MiniGameAirBoxing;
import JinRyuu.JRMCore.client.minigame.MiniGameConcentration;
import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
import JinRyuu.JRMCore.entity.EntityAuraFlat;
import JinRyuu.JRMCore.entity.EntityNull;
import JinRyuu.JRMCore.items.ItemBarberSnC;
import JinRyuu.JRMCore.p.JRMCorePData2;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerClient;
import JinRyuu.JRMCore.p.DBC.DBCPdri;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
import JinRyuu.NarutoC.common.NCKeyHandler;
import com.google.common.collect.Multimap;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class JRMCoreGuiScreen extends GuiScreen implements ClipboardOwner, GuiYesNoCallback {
   public static final int ID_APPERANCE = 0;
   public static final int ID_APPERANCE_ARCO = 19;
   public static final int ID_COLOR_PICKER = 1;
   public static final int ID_POWER_CLASS_SELECT = 2;
   public static final int ID_FINALIZING = 3;
   public static final int ID_BARBER = 8;
   public static final int ID_ATTRIBUTES = 10;
   public static final int ID_SKILLS = 11;
   public static final int ID_TECHNIQUES = 12;
   public static final int ID_ATTACK_CREATOR = 13;
   public static final int ID_DIFFICULTY = 14;
   public static final int ID_LEARN_ATTACKS_AND_JUTSUS = 15;
   public static final int ID_LEARN_SKILLS = 16;
   public static final int ID_TRAINING = 17;
   public static final int ID_MINIGAME_CONCENTRATION = 18;
   public static final int ID_NEWS = 30;
   public static final int ID_NO_CONNECTION = 31;
   public static final int ID_SERVER_INFO = 40;
   public static final int ID_UPDATE_INFO = 50;
   public static final int ID_MISSION_SYSTEM_MIN = 60;
   public static final int ID_MISSION_SYSTEM_MAX = 70;
   public static final int ID_MAIN_MISSION = 60;
   public static final int ID_SIDE_MISSION = 61;
   public static final int ID_GROUP_SYSTEM = 70;
   public static final int ID_SERVER_DONATION = 80;
   public static final int ID_CLIENT_SETTINGS = 10000;
   public static final int ID_HELP = 10001;
   public static final int ID_MINIGAME_AIRBOXING = 10002;
   public static final int ID_INSTANT_TRANSMISSION_GROUP_PICK = 10100;
   public static final int ID_NOTIFICATIONS = 10011;
   private static final int cs_mode_GRAPHIC_SETTINGS = 0;
   private static final int cs_mode_USER_INTERFACE = 1;
   private static final Logger logger = LogManager.getLogger();
   public static final String News = "News";
   public static Minecraft mc = Minecraft.func_71410_x();
   public static JRMCoreGuiScreen instance;
   public MiniGameConcentration miniGameConcentration = new MiniGameConcentration();
   public MiniGameAirBoxing miniGameAirBoxing = new MiniGameAirBoxing();
   private EntityNull entityTest;
   private ArrayList<EntityAuraFlat> entityTests2;
   private Instant timer;
   public boolean guiUp = false;
   public int guiID = 0;
   public int guiIDprev = 0;
   public int guiIDprev2 = 0;
   public int guiIDprev3 = 0;
   public int guiLeft;
   public int guiTop;
   public int xSize = 256;
   public int ySize = 159;
   public float xSize_lo;
   public float ySize_lo;
   public List Modsnews;
   public int site = 0;
   public int sip = 0;
   private int diff = 0;
   private int attCrtPg = 0;
   private int attViwPg = 0;
   private int pgSkls = 0;
   private int smd;
   private int ipg;
   private int inv;
   private int lp;
   private int sscl;
   private int[] hbt;
   private int[] dfa = new int[5];
   private URI clickedURI;
   private int mcu = 0;
   public static String urlToOpen = "";
   private static float ptch = 0.0F;
   public static float scrollSide = 0.0F;
   public static int hairPreview = 0;
   public static int[] hairPreviewStates = new int[]{0, 4, 5, 6};
   private static boolean headRoton = false;
   private static int headRotX = 0;
   private static int headRotY = 0;
   private static int headRotZ = 0;
   private static final int gui_help_descs = 13;
   private static final int help_guides = 13;
   private static int help_page_id = 0;
   private static int help_mode = 0;
   private static final int[] cs_pages = new int[]{9, 3};
   private static int cs_page = 0;
   private static int cs_mode = 0;
   public static boolean CanRace = true;
   public static boolean CanGender = true;
   public static boolean CanYears = true;
   public static boolean CanHair = true;
   public static boolean CanColor = true;
   public static boolean canCustom = true;
   public static boolean CanSpecial = true;
   public static boolean CanPwr = true;
   public static boolean CanClass = true;
   private static boolean[] CanUpgrade = new boolean[]{true, true, true, true, true, true};
   public static byte EnAttNum = 0;
   public static String name = "Attack";
   public static int acquired = 1;
   public static String owner;
   public static int type;
   public static int speed;
   public static int dam;
   public static int effect;
   public static int cost;
   public static int casttime;
   public static int cooldown;
   public static int color;
   public static int density;
   public static int sincantation;
   public static int sfire;
   public static int smove;
   public static int[] techCrt;
   public static String button1;
   public static String button2;
   public static String wish;
   public static String guiBG2;
   public static String pc;
   public static String gui_help_tabs;
   public static String wishsep;
   public static String icons;
   String SideMsn = "";
   int ss = -1;
   boolean ssb = false;
   public static int colorType;
   public static int StateSlcted;
   public static int RaceSlcted;
   public static int GenderSlcted;
   public static int YearsSlcted;
   public static int HairSlcted;
   public static int Hair2Slcted;
   public static int ColorSlcted;
   public static int BreastSizeSlcted;
   public static int SkinTypeSlcted;
   public static int BodyTypeSlcted;
   public static int BodyColPresetSlcted;
   public static int BodyColMainSlcted;
   public static int BodyColSub1Slcted;
   public static int BodyColSub2Slcted;
   public static int BodyColSub3Slcted;
   public static int FaceNoseSlcted;
   public static int FaceMouthSlcted;
   public static int EyesSlcted;
   public static int EyeColPresetSlcted;
   public static int EyeCol1Slcted;
   public static int EyeCol2Slcted;
   public static int BodyauColMainSlcted;
   public static int BodyauColSub1Slcted;
   public static int BodyauColSub2Slcted;
   public static int BodyauColSub3Slcted;
   public static int HairPrstsSlcted;
   public static boolean canSavePreset;
   public static float BrghtSlcted;
   public static int PwrtypSlcted;
   public static int ClassSlcted;
   public static boolean tail;
   public static int KiColorSlcted;
   public static ArrayList<String> PresetList;
   private static int tick;
   private static String dnsau;
   private static String dns;
   private static String dnsSent;
   private static String dnsOrig;
   private static String dnsH;
   private static String dnsHbu;
   private static String dnsHSent;
   private static String dnsHOrig;
   protected static List detailList;
   public int x = 0;
   public int y = 0;
   private byte pwr = 0;
   public int scroll;
   public int scrollMouseJump = 1;
   public boolean mousePressed;
   private int IDtoProcessConfirmFor = -1;
   private boolean confirmationWindow = false;
   private int kdf;
   private static String ssc;
   private static int sscr;
   public static boolean ufc;
   final byte HELP_MODE_SELECT = 0;
   final byte HELP_GUIDE_PICK = 1;
   final byte HELP_CRAFTING = 2;
   final byte HELP_GUIDE = 3;
   private int gui_recipe_mod = -1;
   private int gui_recipe_category = 0;
   private int text = 0;
   protected GuiTextField inputField;
   protected GuiTextField[] inputField2 = new GuiTextField[3];
   private String defaultInputFieldText = "Attack";
   private boolean inputField2Ch = false;
   private int inputField2Cl = 0;
   protected static final ResourceLocation field_110408_a;
   ModelRenderer[] hairall;
   public static int count;
   public static int warn;
   public static int startcount;
   private String Process = "Something is Wrong";
   private int wid = 0;
   private int hei = 0;
   private String textureFile = "jinryuudragonbc:sagas.png";
   private int curPage = 0;
   private int[] hcl = new int[]{0, 4, 14, 24, 40, 56};
   public static int scrlld;

   public boolean isGUIOpen(int id) {
      return id == this.guiID;
   }

   public JRMCoreGuiScreen(int w) {
      JRMCoreGuiSliderX00.sliderValue = 0.0F;
      this.scroll = 0;
      scrollSide = 0.0F;
      this.guiID = w;
      this.guiIDprev = this.guiID;
      ssc = "";
      this.confirmationWindow = false;
      this.guiUp = false;
      if (JRMCoreConfig.ssc.contains("http://")) {
         JRMCoreH.turih.remove(JRMCoreConfig.ssc);
         JRMCoreH.tur(JRMCoreConfig.ssc);
      }

      String bpmd = JRMCoreH.rld("BPMode", "jinryuujrmcore.dat");
      JRMCoreH.BPMode = bpmd.equalsIgnoreCase("Normal") ? 0 : (bpmd.equalsIgnoreCase("High") ? 1 : 0);
   }

   private static String ntl(int i) {
      return JRMCoreH.numToLet(i);
   }

   private static String ntl5(int i) {
      return JRMCoreH.numToLet5(i);
   }

   public void func_73866_w_() {
      this.guiUp = false;

      int posX;
      for(posX = 0; posX < this.inputField2.length; ++posX) {
         this.inputField2[posX] = new GuiTextField(mc.field_71466_p, 0, 0, 50, 12);
         this.inputField2[posX].func_146180_a("255");
      }

      wish = JRMCoreH.tjjrmc + ":gui.png";
      pc = JRMCoreH.tjjrmc + ":gui_pc.png";
      button1 = JRMCoreH.tjjrmc + ":button1.png";
      icons = JRMCoreH.tjjrmc + ":icons.png";
      instance = this;
      int posY;
      int dam;
      int effect;
      int cost;
      int casttime;
      int cooldown;
      int i;
      int density;
      int sincantation;
      int sfire;
      int smove;
      int[] techCrtN;
      if (JRMCoreH.Pwrtyp == 2) {
         posX = JRMCoreH.techNCBase[3];
         posY = JRMCoreH.techNCBase[4];
         dam = JRMCoreH.techNCBase[5];
         effect = JRMCoreH.techNCBase[6];
         cost = JRMCoreH.techNCBase[7];
         casttime = JRMCoreH.techNCBase[8];
         cooldown = JRMCoreH.techNCBase[9];
         i = JRMCoreH.techNCBase[10];
         density = JRMCoreH.techNCBase[11];
         sincantation = JRMCoreH.techNCBase[12];
         sfire = JRMCoreH.techNCBase[13];
         smove = JRMCoreH.techNCBase[14];
         techCrtN = new int[]{1, acquired, 1, posX, posY, dam, effect, cost, casttime, cooldown, i, density, sincantation, sfire, smove};
         techCrt = techCrtN;
      }

      if (JRMCoreH.Pwrtyp == 1) {
         posX = JRMCoreH.techBase[3];
         posY = JRMCoreH.techBase[4];
         dam = JRMCoreH.techBase[5];
         effect = JRMCoreH.techBase[6];
         cost = JRMCoreH.techBase[7];
         casttime = JRMCoreH.techBase[8];
         cooldown = JRMCoreH.techBase[9];
         i = JRMCoreH.techBase[10];
         density = JRMCoreH.techBase[11];
         sincantation = JRMCoreH.techBase[12];
         sfire = JRMCoreH.techBase[13];
         smove = JRMCoreH.techBase[14];
         techCrtN = new int[]{1, acquired, 1, posX, posY, dam, effect, cost, casttime, cooldown, i, density, sincantation, sfire, smove};
         techCrt = techCrtN;
      }

      this.field_146292_n.clear();
      this.guiLeft = (this.field_146294_l - this.xSize) / 2;
      this.guiTop = (this.field_146295_m - this.ySize) / 2;
      posX = this.field_146294_l / 2;
      posY = this.field_146295_m / 2;
      JRMCoreGuiSliderX00.sliderValue = 0.0F;
      this.scroll = 0;
      scrollSide = 0.0F;
      this.SideMsn = "";
      this.site = 0;
      JRMCoreH.jrmct(1);
      JRMCoreH.jrmct(3);
      this.smd = 0;
      this.ipg = 0;
      this.inv = 0;
      if (JRMCoreH.Accepted == 2) {
         this.guiID = 31;
      }

      if (JRMCoreH.Accepted == 1 && (this.guiID > 50 || this.guiID < 30) && this.guiID != 8 && this.guiID != 10001 && this.guiID != 10010 && (this.guiID < 60 || this.guiID > 70) && this.guiID != 10100) {
         this.guiID = 10;
      }

      if (JRMCoreH.Accepted == 0 && this.guiID == 8) {
         this.guiID = 0;
      }

      if (this.guiID == 8) {
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               dns = JRMCoreHJFC.childDNS(ItemBarberSnC.barberTarget);
               dnsH = JRMCoreHJFC.childDNSH(ItemBarberSnC.barberTarget);
               dnsOrig = JRMCoreHJFC.childDNS(ItemBarberSnC.barberTarget);
               dnsHOrig = JRMCoreHJFC.childDNSH(ItemBarberSnC.barberTarget);
               RaceSlcted = JRMCoreH.Race;
               HairSlcted = JRMCoreH.dnsHairB(dns);
               Hair2Slcted = JRMCoreH.dnsHairF(dns);
               ColorSlcted = JRMCoreH.dnsHairC(dns);
            }
         } else {
            dns = JRMCoreH.dns;
            dnsH = JRMCoreH.dnsH;
            dnsOrig = JRMCoreH.dns;
            dnsHOrig = JRMCoreH.dnsH;
            RaceSlcted = JRMCoreH.Race;
            HairSlcted = JRMCoreH.dnsHairB(dns);
            Hair2Slcted = JRMCoreH.dnsHairF(dns);
            ColorSlcted = JRMCoreH.dnsHairC(dns);
         }
      }

      if (this.guiID <= 50 && this.guiID >= 30) {
         JRMCoreClient.JFCGui.checkVersion();
         JRMCoreClient.JFCGui.checkText();
      }

      if (this.guiID == 0) {
         RaceSlcted = JRMCoreH.Race;
         if (JRMCoreH.dns.length() > 3) {
            dns = JRMCoreH.dns;
         } else {
            setchangerace();
         }

         if (JRMCoreH.dnsH.length() > 3) {
            dnsH = JRMCoreH.dnsH;
         }

         dnsOrig = JRMCoreH.dns;
         dnsHOrig = JRMCoreH.dnsH;
         GenderSlcted = JRMCoreH.dnsGender(dns);
         HairSlcted = JRMCoreH.dnsHairB(dns);
         Hair2Slcted = JRMCoreH.dnsHairF(dns);
         ColorSlcted = JRMCoreH.dnsHairC(dns);
         BreastSizeSlcted = JRMCoreH.dnsBreast(dns);
         SkinTypeSlcted = JRMCoreH.dnsSkinT(dns);
         BodyTypeSlcted = JRMCoreH.dnsBodyT(dns);
         BodyColMainSlcted = JRMCoreH.dnsBodyCM(dns);
         BodyColSub1Slcted = JRMCoreH.dnsBodyC1(dns);
         BodyColSub2Slcted = JRMCoreH.dnsBodyC2(dns);
         FaceNoseSlcted = JRMCoreH.dnsFaceN(dns);
         FaceMouthSlcted = JRMCoreH.dnsFaceM(dns);
         EyesSlcted = JRMCoreH.dnsEyes(dns);
         EyeCol1Slcted = JRMCoreH.dnsEyeC1(dns);
         EyeCol2Slcted = JRMCoreH.dnsEyeC2(dns);
      }

      csau_d();
      String s = JRMCoreH.rld("HairPresets", "jinryuujrmcore.dat");
      List<String> stooges = Arrays.asList();
      if (s.length() > 3) {
         stooges = Arrays.asList(s.split(","));
      }

      ArrayList<String> saves = new ArrayList(stooges);
      ArrayList<String> defpres = new ArrayList();
      ArrayList<String> presets = new ArrayList();
      String[] var19 = JRMCoreH.defHairPrsts;
      density = var19.length;

      for(sincantation = 0; sincantation < density; ++sincantation) {
         String def = var19[sincantation];
         defpres.add(def);
      }

      saves.removeAll(defpres);
      presets.addAll(defpres);
      presets.addAll(saves);
      PresetList = presets;

      for(i = 0; i < PresetList.size(); ++i) {
         if (((String)PresetList.get(i)).equals(dnsH)) {
            HairPrstsSlcted = i;
            break;
         }
      }

      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.initGui();
      }

   }

   public void urlOpenWithConfirm(String url) {
      this.clickedURI = URI.create(url);
      this.guiIDprev2 = this.guiID;
      mc.func_147108_a(new GuiConfirmOpenLink(this, url, 0, false));
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if (p_73878_2_ == 0) {
         if (p_73878_1_) {
            this.func_146407_a(this.clickedURI);
         }

         this.clickedURI = null;
         mc.func_147108_a(this);
      }

   }

   private void func_146407_a(URI p_146407_1_) {
      try {
         Desktop.getDesktop().browse(p_146407_1_);
      } catch (Throwable var3) {
         logger.error("Couldn't open link", var3);
      }

   }

   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
      int selct = par1 - 20;
      int KA = false;
      JRMCoreGuiButtons00 ret;
      if (KA) {
         ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
      } else {
         ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
      }

      return ret;
   }

   public void func_146284_a(GuiButton button) {
      int id = button.field_146127_k;
      if (this.confirmationWindow) {
         this.confirmationWindow = false;
      }

      if (button.field_146127_k == 10001) {
         this.guiID = 10001;
         help_mode = 0;
         help_page_id = 0;
      }

      if (button.field_146127_k == 10003 && help_page_id > 0) {
         --help_page_id;
      }

      if (button.field_146127_k == 10004) {
         if (help_mode == 2) {
            ++help_page_id;
         } else if (help_mode == 3 && help_page_id < 13) {
            ++help_page_id;
         }
      }

      if (button.field_146127_k == 10005) {
         help_mode = 1;
         help_page_id = 0;
      }

      if (button.field_146127_k == 10006) {
         help_mode = 2;
         help_page_id = 0;
      }

      if (button.field_146127_k == 10007) {
         help_mode = 0;
         help_page_id = 0;
      }

      if (button.field_146127_k == 10008) {
         this.guiID = 10;
         help_mode = 0;
         help_page_id = 0;
      }

      if (button.field_146127_k >= 10009 && button.field_146127_k < 10009 + JGRecipeHandler.recipelistmods.length) {
         this.gui_recipe_mod = button.field_146127_k - 10009;
         this.gui_recipe_category = JGRecipeHandler.getFirstRecipeCategory(this.gui_recipe_mod);
         help_page_id = 0;
      }

      if (button.field_146127_k >= 10013 && button.field_146127_k < 10013 + JGRecipeHandler.recipelistcategories.length) {
         this.gui_recipe_category = button.field_146127_k - 10013;
         help_page_id = 0;
      }

      if (button.field_146127_k == 10019) {
         this.gui_recipe_mod = -1;
      }

      if (button.field_146127_k == -10) {
         if (this.mcu >= 3) {
            this.mcu = 0;
         } else {
            ++this.mcu;
         }
      }

      if (button.field_146127_k == 4890) {
         this.inputField.func_146180_a(JRMCoreH2.kiAttNamGen() + " " + JRMCoreH.techDBCTypes[techCrt[3]]);
      }

      if (button.field_146127_k == 4900 && JRMCoreH.DBC()) {
         JRMCoreHDBC.openGui(0, JRMCoreClient.mc.field_71439_g);
      }

      if (button.field_146127_k == 4901 && JRMCoreH.NC()) {
         JRMCoreHNC.openGui(0, JRMCoreClient.mc.field_71439_g);
      }

      if (button.field_146127_k == 4902 && JRMCoreH.JYC()) {
         JRMCoreHJYC.openGui(1, JRMCoreClient.mc.field_71439_g);
      }

      if (button.field_146127_k == 4903 && JRMCoreH.JFC()) {
         JRMCoreHJFC.openGui(1, JRMCoreClient.mc.field_71439_g);
      }

      if (button.field_146127_k == 4904 && JRMCoreH.SAOC()) {
         JRMCoreHSAC.openGui(0, JRMCoreClient.mc.field_71439_g);
      }

      if (button.field_146127_k == 0) {
         this.guiID = this.guiIDprev == 8 ? this.guiIDprev : (this.guiIDprev == 19 ? this.guiIDprev : 0);
      }

      if (button.field_146127_k == 1) {
         RaceSlctF();
         JRMCoreH.Char((byte)0, (byte)RaceSlcted);
         setchangerace();
         setdns();
      }

      if (button.field_146127_k == -1) {
         RaceSlctB();
         JRMCoreH.Char((byte)0, (byte)RaceSlcted);
         setchangerace();
         setdns();
      }

      if (button.field_146127_k == 4999) {
         StateViewF();
         JRMCoreH.Char((byte)106, (byte)StateSlcted);
         setdns();
      }

      if (button.field_146127_k == -4999) {
         StateViewB();
         JRMCoreH.Char((byte)106, (byte)StateSlcted);
         setdns();
      }

      if (button.field_146127_k == 8) {
         YearsSlctF();
         setdns();
         JRMCoreH.Char((byte)7, (byte)YearsSlcted);
      }

      if (button.field_146127_k == -8) {
         YearsSlctB();
         setdns();
         JRMCoreH.Char((byte)7, (byte)YearsSlcted);
      }

      if (button.field_146127_k == 2) {
         GenderSlctF();
         setdns();
      }

      if (button.field_146127_k == -2) {
         GenderSlctF();
         setdns();
      }

      if (button.field_146127_k == 3) {
         HairSlctF();
         setdns();
      }

      if (button.field_146127_k == -3) {
         HairSlctB();
         setdns();
      }

      if (button.field_146127_k == 5000) {
         Hair2SlctF();
         setdns();
      }

      if (button.field_146127_k == -5000) {
         Hair2SlctB();
         setdns();
      }

      if (button.field_146127_k == 5011) {
         EyeCol2Slcted = EyeCol1Slcted;
         setdns();
      }

      if (id == 4 || id == 5003 || id == 5004 || id == 5005 || id == 5009 || id == 5010 || id == 5014 || id == 5015 || id == 5016 || id == 5017 || id == 5018 || id == 5019) {
         this.inputField2Cl = id;
         this.guiIDprev = this.guiID;
         this.guiID = 1;
         colorType = button.field_146127_k;
      }

      int i;
      if (button.field_146127_k == -4) {
         i = ((JRMCoreGuiButtonC)button).getBgCol();
         switch(colorType) {
         case 4:
            ColorSlcted = i;
            break;
         case 5003:
            BodyColMainSlcted = i;
            break;
         case 5004:
            BodyColSub1Slcted = i;
            break;
         case 5005:
            BodyColSub2Slcted = i;
            break;
         case 5009:
            EyeCol1Slcted = i;
            break;
         case 5010:
            EyeCol2Slcted = i;
            break;
         case 5014:
            BodyColSub3Slcted = i;
            break;
         case 5015:
            KiColorSlcted = i;
            break;
         case 5016:
            BodyauColMainSlcted = i;
            setdnsau();
            JRMCoreH.jrmcDataFC(3, dnsau);
            break;
         case 5017:
            BodyauColSub1Slcted = i;
            setdnsau();
            JRMCoreH.jrmcDataFC(3, dnsau);
            break;
         case 5018:
            BodyauColSub2Slcted = i;
            setdnsau();
            JRMCoreH.jrmcDataFC(3, dnsau);
            break;
         case 5019:
            BodyauColSub3Slcted = i;
            setdnsau();
            JRMCoreH.jrmcDataFC(3, dnsau);
         }

         if (this.guiIDprev == 8 || this.guiIDprev == 0 || this.guiIDprev == 2 || this.guiIDprev == 19) {
            this.guiID = this.guiIDprev;
         }

         colorType = 0;
         if (this.guiIDprev == 8) {
            setdnsForHair();
         } else {
            setdns();
         }

         this.updateMajinHairToBodyColor();
      }

      if (button.field_146127_k == -5016) {
         csau_df();
         setdnsau();
         JRMCoreH.jrmcDataFC(3, dnsau);
      }

      if (button.field_146127_k == 5001) {
         BreastSizeSlcted = (int)(((JRMCoreGuiSlider01)button).sliderValue * 10.0F);
         setdns();
      }

      if (button.field_146127_k == 5002) {
         SkinTypeSlcted = SlctF(SkinTypeSlcted, 2);
         setchangerace();
         setdns();
      }

      if (button.field_146127_k == -5002) {
         SkinTypeSlcted = SlctB(SkinTypeSlcted, 2);
         setchangerace();
         setdns();
      }

      if (button.field_146127_k == 5) {
         BodyTypeSlcted = SlctF(BodyTypeSlcted, JRMCoreH.customSknLimits[RaceSlcted][0]);
         setdns();
      }

      if (button.field_146127_k == -5) {
         BodyTypeSlcted = SlctB(BodyTypeSlcted, JRMCoreH.customSknLimits[RaceSlcted][0]);
         setdns();
      }

      if (button.field_146127_k == 5006) {
         FaceNoseSlcted = SlctF(FaceNoseSlcted, JRMCoreH.customSknLimits[RaceSlcted][2]);
         setdns();
      }

      if (button.field_146127_k == -5006) {
         FaceNoseSlcted = SlctB(FaceNoseSlcted, JRMCoreH.customSknLimits[RaceSlcted][2]);
         setdns();
      }

      if (button.field_146127_k == 5007) {
         FaceMouthSlcted = SlctF(FaceMouthSlcted, JRMCoreH.customSknLimits[RaceSlcted][3]);
         setdns();
      }

      if (button.field_146127_k == -5007) {
         FaceMouthSlcted = SlctB(FaceMouthSlcted, JRMCoreH.customSknLimits[RaceSlcted][3]);
         setdns();
      }

      if (button.field_146127_k == 5008) {
         EyesSlcted = SlctF(EyesSlcted, JRMCoreH.customSknLimits[RaceSlcted][4]);
         setdns();
      }

      if (button.field_146127_k == -5008) {
         EyesSlcted = SlctB(EyesSlcted, JRMCoreH.customSknLimits[RaceSlcted][4]);
         setdns();
      }

      if (button.field_146127_k == 5012) {
         BodyColPresetSlcted = SlctF(BodyColPresetSlcted, JRMCoreH.customSknLimitsBCP[RaceSlcted]);
         setchangebodycol();
         setdns();
         this.updateMajinHairToBodyColor();
      }

      if (button.field_146127_k == -5012) {
         BodyColPresetSlcted = SlctB(BodyColPresetSlcted, JRMCoreH.customSknLimitsBCP[RaceSlcted]);
         setchangebodycol();
         setdns();
         this.updateMajinHairToBodyColor();
      }

      if (button.field_146127_k == 5013) {
         EyeColPresetSlcted = SlctF(EyeColPresetSlcted, JRMCoreH.defeyecols.length);
         setchangeeyecol();
         setdns();
      }

      if (button.field_146127_k == -5013) {
         EyeColPresetSlcted = SlctB(EyeColPresetSlcted, JRMCoreH.defeyecols.length);
         setchangeeyecol();
         setdns();
      }

      if (button.field_146127_k >= 5100 && button.field_146127_k <= 5104) {
         this.guiIDprev = this.guiID;
         dnsH = JRMCoreH.dnsH;
         this.guiID = button.field_146127_k - 5080;
      }

      if (button.field_146127_k == 5199) {
         dnsH = (String)PresetList.get(HairPrstsSlcted);
      }

      if (button.field_146127_k == 5150) {
         ++this.guiID;
      }

      if (button.field_146127_k == 5151) {
         --this.guiID;
      }

      if (button.field_146127_k == 5152 && (this.guiIDprev == 0 || this.guiIDprev == 8)) {
         this.guiID = this.guiIDprev;
      }

      if (button.field_146127_k == 5153) {
         this.setClipboardContents(dnsH);
      }

      String cont;
      if (button.field_146127_k == 5154) {
         cont = this.getClipboardContents();
         dnsH = cont;
      }

      if (button.field_146127_k == 5155) {
         HairCstmNextPreset();
      }

      if (button.field_146127_k == -5155) {
         HairCstmPrevPreset();
      }

      if (button.field_146127_k == 5156) {
         HairCstmSaveAsPreset();
      }

      if (button.field_146127_k == 5157) {
         HairCstmDelPreset();
      }

      if (button.field_146127_k == 5158) {
         HairCstmResetPreset();
      }

      if (button.field_146127_k == 5159) {
         cont = "http://hairsalon.jingames.net";
         this.urlOpenWithConfirm(cont);
      }

      if (button.field_146127_k == 5160) {
         headRotX += 10;
      }

      if (button.field_146127_k == 5161) {
         headRotX -= 10;
      }

      if (button.field_146127_k == 5162) {
         headRotY += 10;
      }

      if (button.field_146127_k == 5163) {
         headRotY -= 10;
      }

      if (button.field_146127_k == 5164) {
         headRotZ += 10;
      }

      if (button.field_146127_k == 5165) {
         headRotZ -= 10;
      }

      if (button.field_146127_k == 5166) {
         headRotX = 0;
         headRotY = 0;
         headRotZ = 0;
      }

      if (button.field_146127_k == 5167) {
         headRoton = !headRoton;
      }

      if (button.field_146127_k == 5168) {
         ++hairPreview;
         hairPreview = hairPreview > 3 ? 3 : hairPreview;
      }

      if (button.field_146127_k == 5169) {
         hairPreview = 0;
      }

      int i;
      int i3;
      if (button.field_146127_k >= 5200 && button.field_146127_k <= 6000 && dnsH.length() > 3) {
         dnsHbu = dnsH;
         i = button.field_146127_k - 5200;
         i = 0;
         int pidh = false;
         int pidv = false;
         this.hbt = this.hbt == null ? new int[56] : this.hbt;

         for(i3 = 0; i3 < 56; ++i3) {
            int l = JRMCoreH.dnsHair2(dnsH, i3 * 14);
            if (i / 10 == i) {
               int tempID = i - i * 10;
               int temp;
               int i;
               int i;
               label2116:
               switch(tempID) {
               case 0:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 2, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 + 2 != i3 * 14 + 2) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 2, temp + "");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 1:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 4, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 + 4 != i3 * 14 + 4) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 4, temp + "");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 2:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 6, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 + 6 != i3 * 14 + 6) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 6, temp + "");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 3:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F);
                  temp = temp > 99 ? 99 : (temp < 1 ? 1 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14, temp < 10 ? "0" + temp : "" + temp);
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 != i3 * 14) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14, temp < 10 ? "0" + temp : "" + temp);
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 4:
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14, l != 0 ? "00" : "01");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 != i3 * 14) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14, l != 0 ? "00" : "01");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 5:
                  String dnsHdef = (String)PresetList.get(HairPrstsSlcted);
                  int L = JRMCoreH.dnsHair2(dnsHdef, i3 * 14);
                  int X = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 2);
                  int Y = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 4);
                  int Z = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 6);
                  int B = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 8);
                  int P = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 10);
                  int T = JRMCoreH.dnsHair2(dnsHdef, i3 * 14 + 12);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14, L + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 2, X + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 4, Y + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 6, Z + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 8, B + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 10, P + "");
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 12, T + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }
                  break;
               case 6:
                  int now = this.hbt[i3];
                  this.hbt[i3] = now < 1 ? now + 1 : 0;
                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] + 8 != i3 + 8) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     this.hbt[i] = now < 1 ? now + 1 : 0;
                     ++i;
                  }
               case 7:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 8, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 + 8 != i3 * 14 + 8) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 8, temp + "");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 8:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 10, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] != 1 || this.hcl[this.curPage] * 14 + 10 != i3 * 14 + 10) {
                     break;
                  }

                  i = this.hcl[this.curPage] + 1;

                  while(true) {
                     if (i >= this.hcl[this.curPage + 1]) {
                        break label2116;
                     }

                     dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 10, temp + "");
                     if (dnsH.length() != 786) {
                        dnsH = dnsHbu;
                     }

                     ++i;
                  }
               case 9:
                  temp = (int)(((JRMCoreGuiSlider02)button).sliderValue * 100.0F / 1.56F) + 18;
                  temp = temp > 82 ? 82 : (temp < 18 ? 18 : temp);
                  dnsH = JRMCoreH.dnsHair2set(dnsH, i3 * 14 + 12, temp + "");
                  if (dnsH.length() != 786) {
                     dnsH = dnsHbu;
                  }

                  if (this.dfa[this.curPage] == 1 && this.hcl[this.curPage] * 14 + 12 == i3 * 14 + 12) {
                     for(i = this.hcl[this.curPage] + 1; i < this.hcl[this.curPage + 1]; ++i) {
                        dnsH = JRMCoreH.dnsHair2set(dnsH, i * 14 + 12, temp + "");
                        if (dnsH.length() != 786) {
                           dnsH = dnsHbu;
                        }
                     }
                  }
               }
            }

            ++i;
         }

         if (button.field_146127_k == 5999) {
            i3 = this.dfa[this.curPage];
            this.dfa[this.curPage] = i3 == 0 ? 1 : 0;
         }
      }

      if (button.field_146127_k == 6) {
         PwrtypSlcted = Slct("F", PwrtypSlcted, JRMCoreH.PwrtypAllow);
      }

      if (button.field_146127_k == -6) {
         PwrtypSlcted = Slct("B", PwrtypSlcted, JRMCoreH.PwrtypAllow);
      }

      if (button.field_146127_k == 7) {
         ClassSlcted = Slct2("F", ClassSlcted, JRMCoreH.PwrtypAllow, PwrtypSlcted, cl());
      }

      if (button.field_146127_k == -7) {
         ClassSlcted = Slct2("B", ClassSlcted, JRMCoreH.PwrtypAllow, PwrtypSlcted, cl());
      }

      if (button.field_146127_k == 20) {
         BrghtSlcted = ((JRMCoreGuiSlider00)button).sliderValue;
      }

      if (button.field_146127_k == 10) {
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 11) {
         this.guiID = 2;
      }

      if (button.field_146127_k == 12) {
         this.guiID = 3;
      }

      if (button.field_146127_k == 13) {
         setdns();
         JRMCoreH.jrmcDataFC(0, dns);
         JRMCoreH.jrmcDataFC(1, dnsH);
         JRMCoreH.jrmcDataFC(2, KiColorSlcted + "");
         JRMCoreH.Char((byte)7, (byte)YearsSlcted);
         JRMCoreH.Char((byte)0, (byte)RaceSlcted);
         JRMCoreH.Char((byte)2, (byte)PwrtypSlcted);
         JRMCoreH.Char((byte)3, (byte)ClassSlcted);
         JRMCoreH.Char((byte)4, (byte)1);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 14) {
         setdnsForHair();
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               JRMCoreHJFC.childDNSset(ItemBarberSnC.barberTarget, dns);
               JRMCoreHJFC.childDNSHset(ItemBarberSnC.barberTarget, dnsH);
            }
         } else {
            JRMCoreH.jrmcDataFC(0, dns);
            JRMCoreH.jrmcDataFC(1, dnsH);
         }

         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == -14) {
         dns = dnsOrig;
         dnsH = dnsHOrig;
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               JRMCoreHJFC.childDNSset(ItemBarberSnC.barberTarget, dns);
               JRMCoreHJFC.childDNSHset(ItemBarberSnC.barberTarget, dnsH);
            }
         } else {
            JRMCoreH.jrmcDataFC(0, dns);
            JRMCoreH.jrmcDataFC(1, dnsH);
         }

         RaceSlcted = JRMCoreH.Race;
         HairSlcted = JRMCoreH.dnsHairB(dns);
         Hair2Slcted = JRMCoreH.dnsHairF(dns);
         ColorSlcted = JRMCoreH.dnsHairC(dns);
      }

      if (button.field_146127_k == 15) {
         HairSlctF();
         setdnsForHair();
      }

      if (button.field_146127_k == -15) {
         HairSlctB();
         setdnsForHair();
      }

      if (button.field_146127_k == 16) {
         setdnsau();
         JRMCoreH.jrmcDataFC(4, dnsau);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 31) {
         this.guiID = 30;
      }

      if (button.field_146127_k == 32) {
         this.guiID = 40;
      }

      if (button.field_146127_k == 33) {
         this.guiID = 50;
      }

      if (button.field_146127_k == 41) {
         --this.site;
      }

      if (button.field_146127_k == 42) {
         ++this.site;
      }

      if (button.field_146127_k == 43) {
         this.scroll -= 3;
      }

      if (button.field_146127_k == 44) {
         this.scroll += 3;
      }

      if (button.field_146127_k == 50) {
         this.sip = 0;
      }

      if (button.field_146127_k == 51) {
         this.sip = 1;
      }

      if (button.field_146127_k == 60) {
         this.guiID = 60;
      }

      if (button.field_146127_k == 61) {
         this.guiID = 61;
      }

      if (button.field_146127_k == 62) {
         this.guiID = 70;
      }

      if (button.field_146127_k == 63 || button.field_146127_k == 64 || button.field_146127_k == 65) {
         i = button.field_146127_k - 62;
         this.dri(JRMCoreH.SagaProg - i);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 66) {
         i = button.field_146127_k - 62;
         this.dri(JRMCoreH.SagaProg + 100 - i - 1);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 67) {
         i = button.field_146127_k - 62;
         this.dri(JRMCoreH.SagaProg + 100 - i - 1);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 68) {
         this.dri(3990);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 69) {
         this.dri(100);
      }

      int i2;
      int i3;
      if (button.field_146127_k == 73 || button.field_146127_k == 74 || button.field_146127_k == 75) {
         i = button.field_146127_k - 72;
         i = JRMCoreH.SagaSideProg - i;
         i2 = i / 10000;
         i3 = i / 100 - i2 * 100;
         i3 = i - i2 * 10000 - i3 * 100;
         JRMCoreH.quad(2, i2, i3, i3);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 80) {
         JRMCoreH.quad(3, 1, 0, 0);
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == 81) {
         JRMCoreH.quad(3, 2, 0, 0);
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == 82) {
         JRMCoreH.quad(3, 3, 0, 0);
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == 83) {
         this.inv = 1;
      }

      if (button.field_146127_k == 84) {
         this.inv = 3;
      }

      if (button.field_146127_k == 85) {
         this.inv = 2;
      }

      if (button.field_146127_k == 86) {
         JRMCoreH.quad(3, 4, 0, 0);
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == 87) {
         JRMCoreH.quad(3, 5, 0, 0);
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == 88) {
         ++this.ipg;
         ++this.lp;
      }

      if (button.field_146127_k == 89) {
         --this.ipg;
         --this.lp;
      }

      if (button.field_146127_k == 90) {
         this.ipg = 0;
         this.inv = 0;
      }

      if (button.field_146127_k == -30) {
         JRMCoreH.quad(10, 0, 0, 0);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == -31) {
         this.guiID = 18;
         JRMCoreH.quad(10, 1, 0, this.miniGameConcentration.score);
      }

      if (button.field_146127_k == -32 && this.guiID != 18) {
         cont = JRMCoreH.rld("BPMode", "jinryuujrmcore.dat").equalsIgnoreCase("Normal") ? "High" : "Normal";
         JRMCoreH.wld(cont, "BPMode", "jinryuujrmcore.dat", false);
         JRMCoreH.BPMode = cont.equalsIgnoreCase("Normal") ? 0 : (cont.equalsIgnoreCase("High") ? 1 : 0);
      }

      if (button.field_146127_k == -33) {
         JRMCoreH.quad(10, 1, 1, this.miniGameConcentration.score);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == -34) {
         this.guiID = 10002;
         JRMCoreH.quad(10, 2, 0, this.miniGameConcentration.score);
      }

      if (button.field_146127_k == -35 && this.miniGameAirBoxing != null) {
         this.miniGameAirBoxing.endAnimationStart = true;
      }

      if (button.field_146127_k == -36) {
         JRMCoreH.quad(10, 2, 1, this.miniGameAirBoxing.score);
         mc.field_71439_g.func_71053_j();
      }

      if (button.field_146127_k == 100) {
         this.guiID = 10;
      }

      if (button.field_146127_k == 101) {
         this.guiID = 11;
      }

      if (button.field_146127_k == 102) {
         this.guiID = 12;
      }

      if (button.field_146127_k == 104) {
         this.guiID = 14;
      }

      if (button.field_146127_k == 109) {
         this.guiID = 10000;
      }

      if (button.field_146127_k == 50011) {
         this.guiID = 10011;
      }

      if (button.field_146127_k == 10000) {
         JGConfigClientSettings.init_client(JGConfigsClient.clientSettings, false, false);
      }

      if (button.field_146127_k == 11000) {
         JGConfigClientSettings.CLIENT_hud0x -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.CLIENT_hud0x < -100) {
            JGConfigClientSettings.CLIENT_hud0x = -100;
         }
      }

      if (button.field_146127_k == 11001) {
         JGConfigClientSettings.CLIENT_hud0x += JGConfigClientSettings.addMore;
      }

      if (button.field_146127_k == 11002) {
         JGConfigClientSettings.CLIENT_hud0y -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.CLIENT_hud0y < -100) {
            JGConfigClientSettings.CLIENT_hud0y = -100;
         }
      }

      if (button.field_146127_k == 11003) {
         JGConfigClientSettings.CLIENT_hud0y += JGConfigClientSettings.addMore;
      }

      if (button.field_146127_k == 11004 && JGConfigClientSettings.CLIENT_hud0 > 0) {
         --JGConfigClientSettings.CLIENT_hud0;
      }

      if (button.field_146127_k == 11005 && JGConfigClientSettings.CLIENT_hud0 + 1 < JGConfigClientSettings.BENS_CONFIG_HUD_SIZES_POS.length) {
         ++JGConfigClientSettings.CLIENT_hud0;
      }

      if (button.field_146127_k == 11006) {
         JGConfigClientSettings.hud_lockon_take();
      }

      if (button.field_146127_k == 11007) {
         JGConfigClientSettings.hud_lockon_add();
      }

      if (button.field_146127_k == 11008) {
         JGConfigClientSettings.init_client(JGConfigsClient.clientSettings, false, true);
      }

      if (button.field_146127_k == 11009) {
         JGConfigClientSettings.settings_addmore();
      }

      if (button.field_146127_k == 11010) {
         JGConfigClientSettings.CLIENT_hud1x -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.CLIENT_hud1x < -10000) {
            JGConfigClientSettings.CLIENT_hud1x = 0;
         }
      }

      if (button.field_146127_k == 11011) {
         JGConfigClientSettings.CLIENT_hud1x += JGConfigClientSettings.addMore;
      }

      if (button.field_146127_k == 11012) {
         JGConfigClientSettings.CLIENT_hud1y -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.CLIENT_hud1y < -10000) {
            JGConfigClientSettings.CLIENT_hud1y = 0;
         }
      }

      if (button.field_146127_k == 11013) {
         JGConfigClientSettings.CLIENT_hud1y += JGConfigClientSettings.addMore;
      }

      if (button.field_146127_k == 11014 && JGConfigClientSettings.CLIENT_hud1 > 0) {
         --JGConfigClientSettings.CLIENT_hud1;
      }

      if (button.field_146127_k == 11015 && JGConfigClientSettings.CLIENT_hud1 + 1 < JGConfigClientSettings.BENS_CONFIG_HUD_1_SIZES_X.length) {
         ++JGConfigClientSettings.CLIENT_hud1;
      }

      if (button.field_146127_k == 11016 && cs_page > 0) {
         --cs_page;
         this.guiUp = false;
      }

      if (button.field_146127_k == 11017 && cs_page < cs_pages[cs_mode] - 1) {
         ++cs_page;
         this.guiUp = true;
      }

      if (button.field_146127_k == 11018) {
         JGConfigClientSettings.CLIENT_GR0 = !JGConfigClientSettings.CLIENT_GR0;
      }

      if (button.field_146127_k == 11019) {
         JGConfigClientSettings.CLIENT_GR1 = !JGConfigClientSettings.CLIENT_GR1;
      }

      if (button.field_146127_k == 11020) {
         JGConfigClientSettings.CLIENT_GR2 = !JGConfigClientSettings.CLIENT_GR2;
      }

      if (button.field_146127_k == 11021) {
         JGConfigClientSettings.CLIENT_GR3 = !JGConfigClientSettings.CLIENT_GR3;
      }

      if (button.field_146127_k == 11022) {
         JGConfigClientSettings.CLIENT_GR4 = !JGConfigClientSettings.CLIENT_GR4;
      }

      if (button.field_146127_k == 11023) {
         JGConfigClientSettings.CLIENT_GR5 = !JGConfigClientSettings.CLIENT_GR5;
      }

      if (button.field_146127_k == 11024) {
         JGConfigClientSettings.CLIENT_GR6 = !JGConfigClientSettings.CLIENT_GR6;
      }

      if (button.field_146127_k == 11025) {
         JGConfigClientSettings.CLIENT_GR7 = !JGConfigClientSettings.CLIENT_GR7;
      }

      if (button.field_146127_k == 11026) {
         JGConfigClientSettings.CLIENT_GR8 = !JGConfigClientSettings.CLIENT_GR8;
      }

      if (button.field_146127_k == 11027) {
         JGConfigClientSettings.CLIENT_GR9 = !JGConfigClientSettings.CLIENT_GR9;
      }

      if (button.field_146127_k == 11028) {
         JGConfigClientSettings.CLIENT_GR10 = !JGConfigClientSettings.CLIENT_GR10;
      }

      if (button.field_146127_k == 11029) {
         JGConfigClientSettings.CLIENT_GR11 = !JGConfigClientSettings.CLIENT_GR11;
      }

      if (button.field_146127_k == 11030) {
         --JGConfigClientSettings.CLIENT_DA1;
         if (JGConfigClientSettings.CLIENT_DA1 < -1) {
            JGConfigClientSettings.CLIENT_DA1 = -1;
         }
      }

      if (button.field_146127_k == 11031) {
         ++JGConfigClientSettings.CLIENT_DA1;
      }

      if (button.field_146127_k == 11032) {
         --JGConfigClientSettings.CLIENT_DA2;
         if (JGConfigClientSettings.CLIENT_DA2 < 0) {
            JGConfigClientSettings.CLIENT_DA2 = 0;
         }
      }

      if (button.field_146127_k == 11033) {
         ++JGConfigClientSettings.CLIENT_DA2;
      }

      if (button.field_146127_k == 11034 && JGConfigClientSettings.CLIENT_DA3 < 10) {
         ++JGConfigClientSettings.CLIENT_DA3;
      }

      if (button.field_146127_k == 11035 && JGConfigClientSettings.CLIENT_DA3 > 0) {
         --JGConfigClientSettings.CLIENT_DA3;
      }

      if (button.field_146127_k == 11036) {
         JGConfigClientSettings.CLIENT_DA4 = !JGConfigClientSettings.CLIENT_DA4;
      }

      if (button.field_146127_k == 11037) {
         JGConfigClientSettings.CLIENT_DA5 = !JGConfigClientSettings.CLIENT_DA5;
      }

      if (button.field_146127_k == 11038) {
         JGConfigClientSettings.CLIENT_DA6 = !JGConfigClientSettings.CLIENT_DA6;
      }

      if (button.field_146127_k == 11039) {
         JGConfigClientSettings.CLIENT_DA7 = !JGConfigClientSettings.CLIENT_DA7;
      }

      if (button.field_146127_k == 11040) {
         JGConfigClientSettings.CLIENT_DA8 = !JGConfigClientSettings.CLIENT_DA8;
      }

      if (button.field_146127_k == 11041) {
         JGConfigClientSettings.CLIENT_DA9 = !JGConfigClientSettings.CLIENT_DA9;
      }

      if (button.field_146127_k == 11042) {
         JGConfigClientSettings.CLIENT_DA10 = !JGConfigClientSettings.CLIENT_DA10;
      }

      if (button.field_146127_k == 11043) {
         JGConfigClientSettings.CLIENT_DA11 = !JGConfigClientSettings.CLIENT_DA11;
      }

      if (button.field_146127_k == 11044) {
         JGConfigClientSettings.CLIENT_DA12 = !JGConfigClientSettings.CLIENT_DA12;
      }

      if (button.field_146127_k == 11045) {
         JGConfigClientSettings.CLIENT_DA13 = !JGConfigClientSettings.CLIENT_DA13;
      }

      if (button.field_146127_k == 11046) {
         JGConfigClientSettings.CLIENT_DA14 = !JGConfigClientSettings.CLIENT_DA14;
      }

      if (button.field_146127_k == 11047) {
         JGConfigClientSettings.CLIENT_DA15 = !JGConfigClientSettings.CLIENT_DA15;
      }

      if (button.field_146127_k == 11048) {
         JGConfigClientSettings.CLIENT_DA16 = !JGConfigClientSettings.CLIENT_DA16;
      }

      if (button.field_146127_k == 11049) {
         JGConfigClientSettings.CLIENT_hud2 = !JGConfigClientSettings.CLIENT_hud2;
         cs_page = 0;
      }

      if (button.field_146127_k == 11050) {
         JGConfigClientSettings.CLIENT_DA17 = !JGConfigClientSettings.CLIENT_DA17;
      }

      if (button.field_146127_k == 11051) {
         JGConfigClientSettings.CLIENT_DA18 = !JGConfigClientSettings.CLIENT_DA18;
      }

      if (button.field_146127_k == 11052) {
         JGConfigClientSettings.CLIENT_DA20 = !JGConfigClientSettings.CLIENT_DA20;
      }

      if (button.field_146127_k == 11053) {
         JGConfigClientSettings.CLIENT_DA19 = !JGConfigClientSettings.CLIENT_DA19;
      }

      if (button.field_146127_k == 11054 && JGConfigClientSettings.CLIENT_DA21 < 10) {
         ++JGConfigClientSettings.CLIENT_DA21;
      }

      if (button.field_146127_k == 11055 && JGConfigClientSettings.CLIENT_DA21 > 0) {
         --JGConfigClientSettings.CLIENT_DA21;
      }

      if (button.field_146127_k == 11056) {
         JGConfigClientSettings.CLIENT_GR12 = !JGConfigClientSettings.CLIENT_GR12;
      }

      if (button.field_146127_k == 11057) {
         JGConfigClientSettings.CLIENT_GR13 = !JGConfigClientSettings.CLIENT_GR13;
      }

      if (button.field_146127_k == 11058) {
         cont = this.getClipboardContents();
         JGConfigClientSettings.CLIENT_hud2_2 = cont;
      }

      if (button.field_146127_k == 11059) {
         JGConfigClientSettings.CLIENT_DA22 = !JGConfigClientSettings.CLIENT_DA22;
      }

      int max_scale = true;
      if (button.field_146127_k == 11060 && JGConfigClientSettings.CLIENT_Ki_Visibility > 0) {
         --JGConfigClientSettings.CLIENT_Ki_Visibility;
      }

      if (button.field_146127_k == 11061 && JGConfigClientSettings.CLIENT_Ki_Visibility < 10) {
         ++JGConfigClientSettings.CLIENT_Ki_Visibility;
      }

      if (button.field_146127_k == 11062 && JGConfigClientSettings.CLIENT_Ki_Scale > 0) {
         --JGConfigClientSettings.CLIENT_Ki_Scale;
      }

      if (button.field_146127_k == 11063 && JGConfigClientSettings.CLIENT_Ki_Scale < 10000) {
         ++JGConfigClientSettings.CLIENT_Ki_Scale;
      }

      if (button.field_146127_k == 11067 && JGConfigClientSettings.CLIENT_Ki_Charge_Visibility > 0) {
         --JGConfigClientSettings.CLIENT_Ki_Charge_Visibility;
      }

      if (button.field_146127_k == 11068 && JGConfigClientSettings.CLIENT_Ki_Charge_Visibility < 10) {
         ++JGConfigClientSettings.CLIENT_Ki_Charge_Visibility;
      }

      if (button.field_146127_k == 11069 && JGConfigClientSettings.CLIENT_Ki_Charge_Scale > 0) {
         --JGConfigClientSettings.CLIENT_Ki_Charge_Scale;
      }

      if (button.field_146127_k == 11070 && JGConfigClientSettings.CLIENT_Ki_Charge_Scale < 10000) {
         ++JGConfigClientSettings.CLIENT_Ki_Charge_Scale;
      }

      if (button.field_146127_k == 11074 && JGConfigClientSettings.CLIENT_Jutsu_Visibility > 0) {
         --JGConfigClientSettings.CLIENT_Jutsu_Visibility;
      }

      if (button.field_146127_k == 11075 && JGConfigClientSettings.CLIENT_Jutsu_Visibility < 10) {
         ++JGConfigClientSettings.CLIENT_Jutsu_Visibility;
      }

      if (button.field_146127_k == 11076 && JGConfigClientSettings.CLIENT_Jutsu_Scale > 0) {
         --JGConfigClientSettings.CLIENT_Jutsu_Scale;
      }

      if (button.field_146127_k == 11077 && JGConfigClientSettings.CLIENT_Jutsu_Scale < 10000) {
         ++JGConfigClientSettings.CLIENT_Jutsu_Scale;
      }

      if (button.field_146127_k == 11300) {
         JGConfigClientSettings.tipNotificationsOn = !JGConfigClientSettings.tipNotificationsOn;
      }

      if (button.field_146127_k == 11301) {
         JGConfigClientSettings.errorNotificationsOn = !JGConfigClientSettings.errorNotificationsOn;
      }

      if (button.field_146127_k > 11079 && button.field_146127_k < 11089) {
         JGConfigClientSettings.CLIENT_Ki_3d[button.field_146127_k - 11080] = !JGConfigClientSettings.CLIENT_Ki_3d[button.field_146127_k - 11080];
      }

      if (button.field_146127_k > 11088 && button.field_146127_k < 11098) {
         JGConfigClientSettings.CLIENT_Ki_Charge_3d[button.field_146127_k - 11089] = !JGConfigClientSettings.CLIENT_Ki_Charge_3d[button.field_146127_k - 11089];
      }

      if (button.field_146127_k > 11097 && button.field_146127_k < 11101) {
         JGConfigClientSettings.CLIENT_Jutsu_3d[button.field_146127_k - 11098] = !JGConfigClientSettings.CLIENT_Jutsu_3d[button.field_146127_k - 11098];
      }

      if (button.field_146127_k == 11101) {
         JGConfigClientSettings.renderEnergyOutsideView = !JGConfigClientSettings.renderEnergyOutsideView;
      }

      if (button.field_146127_k == 11200) {
         JGConfigClientSettings.concentrationAnimatedTexturesOn = !JGConfigClientSettings.concentrationAnimatedTexturesOn;
      }

      if (button.field_146127_k == 11201) {
         JGConfigClientSettings.concentrationAnimatedColorOn = !JGConfigClientSettings.concentrationAnimatedColorOn;
      }

      if (button.field_146127_k == 11202) {
         JGConfigClientSettings.airboxing3DCharacterOn = !JGConfigClientSettings.airboxing3DCharacterOn;
      }

      if (button.field_146127_k == 11203) {
         JGConfigClientSettings.airboxing3DAuraOn = !JGConfigClientSettings.airboxing3DAuraOn;
      }

      if (button.field_146127_k == 11204) {
         JGConfigClientSettings.airboxingAnimatedColorOn = !JGConfigClientSettings.airboxingAnimatedColorOn;
      }

      if (button.field_146127_k == 11205) {
         JGConfigClientSettings.renderdistanceMultiplierBarrierBlock -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierBarrierBlock < 0) {
            JGConfigClientSettings.renderdistanceMultiplierBarrierBlock = 0;
         }
      }

      if (button.field_146127_k == 11206) {
         JGConfigClientSettings.renderdistanceMultiplierBarrierBlock = (int)((double)JGConfigClientSettings.renderdistanceMultiplierBarrierBlock + (double)JGConfigClientSettings.addMore);
         if (JGConfigClientSettings.renderdistanceMultiplierBarrierBlock > 100) {
            JGConfigClientSettings.renderdistanceMultiplierBarrierBlock = 100;
         }
      }

      if (button.field_146127_k == 11207) {
         JGConfigClientSettings.renderdistanceMultiplierParticles -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierParticles < 0) {
            JGConfigClientSettings.renderdistanceMultiplierParticles = 0;
         }
      }

      if (button.field_146127_k == 11208) {
         JGConfigClientSettings.renderdistanceMultiplierParticles += JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierParticles > 10000) {
            JGConfigClientSettings.renderdistanceMultiplierParticles = 10000;
         }
      }

      if (button.field_146127_k == 11209) {
         JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge < 0) {
            JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge = 0;
         }
      }

      if (button.field_146127_k == 11210) {
         JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge += JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge > 10000) {
            JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge = 10000;
         }
      }

      if (button.field_146127_k == 11211) {
         JGConfigClientSettings.renderdistanceMultiplierAuras -= JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierAuras < 0) {
            JGConfigClientSettings.renderdistanceMultiplierAuras = 0;
         }
      }

      if (button.field_146127_k == 11212) {
         JGConfigClientSettings.renderdistanceMultiplierAuras += JGConfigClientSettings.addMore;
         if (JGConfigClientSettings.renderdistanceMultiplierAuras > 10000) {
            JGConfigClientSettings.renderdistanceMultiplierAuras = 10000;
         }
      }

      if (button.field_146127_k == 11213) {
         JGConfigClientSettings.kiAttackChargePercentageOn = !JGConfigClientSettings.kiAttackChargePercentageOn;
      }

      if (button.field_146127_k == 11214) {
         JGConfigClientSettings.dbcFastFusionSpectatorCameraFollowOn = !JGConfigClientSettings.dbcFastFusionSpectatorCameraFollowOn;
      }

      if (button.field_146127_k == 11215) {
         JGConfigClientSettings.safeZoneUIModeOn = !JGConfigClientSettings.safeZoneUIModeOn;
      }

      if (button.field_146127_k == 11216) {
         JGConfigClientSettings.instantTransmissionFirstPerson = !JGConfigClientSettings.instantTransmissionFirstPerson;
      }

      if (button.field_146127_k == 11217) {
         JGConfigClientSettings.instantTransmissionParticles = !JGConfigClientSettings.instantTransmissionParticles;
      }

      JGNotificationGUI.checkButtons(button.field_146127_k);
      if (button.field_146127_k == 10101) {
         mc.field_71439_g.func_71053_j();
      }

      for(i = 0; i < 20; ++i) {
         if (button.field_146127_k == 10102 + i) {
            DBCPacketHandlerClient.selectGroupTeleport(i);
            mc.field_71439_g.func_71053_j();
            break;
         }
      }

      if (button.field_146127_k == 12000) {
         cs_mode = 0;
         cs_page = 0;
      }

      if (button.field_146127_k == 12001) {
         cs_mode = 1;
         cs_page = 0;
      }

      for(i = 0; i < 13; ++i) {
         if (button.field_146127_k == 12002 + i) {
            help_mode = 3;
            help_page_id = i;
         }
      }

      if (button.field_146127_k == 33000) {
         String[] s = new String[this.inputField2.length];

         for(i2 = 0; i2 < this.inputField2.length; ++i2) {
            s[i2] = this.inputField2[i2].func_146179_b();
         }

         int[] n = new int[this.inputField2.length];

         try {
            for(i3 = 0; i3 < this.inputField2.length; ++i3) {
               n[i3] = Integer.parseInt(s[i3]);
               if (n[i3] < 0) {
                  n[i3] = 0;
               }

               if (n[i3] > 255) {
                  n[i3] = 255;
               }
            }

            i3 = n[0];
            i3 = (i3 << 8) + n[1];
            i3 = (i3 << 8) + n[2];
            switch(colorType) {
            case 4:
               ColorSlcted = i3;
               break;
            case 5003:
               BodyColMainSlcted = i3;
               break;
            case 5004:
               BodyColSub1Slcted = i3;
               break;
            case 5005:
               BodyColSub2Slcted = i3;
               break;
            case 5009:
               EyeCol1Slcted = i3;
               break;
            case 5010:
               EyeCol2Slcted = i3;
               break;
            case 5014:
               BodyColSub3Slcted = i3;
               break;
            case 5015:
               KiColorSlcted = i3;
               break;
            case 5016:
               BodyauColMainSlcted = i3;
               setdnsau();
               JRMCoreH.jrmcDataFC(3, dnsau);
               break;
            case 5017:
               BodyauColSub1Slcted = i3;
               setdnsau();
               JRMCoreH.jrmcDataFC(3, dnsau);
               break;
            case 5018:
               BodyauColSub2Slcted = i3;
               setdnsau();
               JRMCoreH.jrmcDataFC(3, dnsau);
               break;
            case 5019:
               BodyauColSub3Slcted = i3;
               setdnsau();
               JRMCoreH.jrmcDataFC(3, dnsau);
            }

            if (this.guiIDprev == 8 || this.guiIDprev == 0 || this.guiIDprev == 2 || this.guiIDprev == 19) {
               this.guiID = this.guiIDprev;
            }

            colorType = 0;
            if (this.guiIDprev == 8) {
               setdnsForHair();
            } else {
               setdns();
            }
         } catch (Exception var23) {
         }

         this.inputField2Ch = false;
         this.updateMajinHairToBodyColor();
      }

      if (button.field_146127_k == 105) {
         JRMCoreH.Char((byte)102, (byte)0);
      }

      if (button.field_146127_k == 106) {
         if (tail) {
            tail = false;
         } else {
            tail = true;
         }

         JRMCoreH.Char((byte)103, (byte)(tail ? 1 : 0));
      }

      if (button.field_146127_k == 107) {
         JRMCoreH.Skll((byte)5, (byte)(JRMCoreH.StusEfctsMe(6) ? 1 : 0), (byte)6);
      }

      if (button.field_146127_k == 108) {
         this.guiID = 17;
      }

      if (button.field_146127_k == -101) {
         this.diff = 0;
      }

      if (button.field_146127_k == -102) {
         this.diff = 1;
      }

      if (button.field_146127_k == -103) {
         this.diff = 2;
      }

      if (button.field_146127_k == -104) {
         this.guiID = 10;
         JRMCoreH.Char((byte)5, (byte)this.diff);
      }

      if (!JRMCoreH.isFused()) {
         for(i = 0; i < JRMCoreH.PlyrAttrbts.length; ++i) {
            if (button.field_146127_k == 110 + i) {
               JRMCoreH.Upg((byte)(i + this.mcu * 6));
            }
         }
      }

      byte i;
      for(i = 0; i < 3; ++i) {
         if (button.field_146127_k == 120 + i) {
            this.attCrtPg = i;
            this.attViwPg = i;
            this.pgSkls = i;
         }
      }

      for(i = 0; i < JRMCoreH.techDBCstatmods.length; ++i) {
         if (button.field_146127_k == 130 + i) {
            JRMCoreH.Tech((byte)0, "ug;;;" + i);
         }

         if (button.field_146127_k == 140 + i) {
            JRMCoreH.Tech((byte)1, "ug;;;" + i);
         }

         if (button.field_146127_k == 150 + i) {
            JRMCoreH.Tech((byte)2, "ug;;;" + i);
         }

         if (button.field_146127_k == 160 + i) {
            JRMCoreH.Tech((byte)3, "ug;;;" + i);
         }
      }

      for(i = 0; i < 3; ++i) {
         if (button.field_146127_k == 190 + i) {
            sndPly(i, 0);
         }
      }

      if (button.field_146127_k == 195) {
         sndPly(5, 0);
      }

      if (button.field_146127_k == 196) {
         ptch = ((JRMCoreGuiSlider00)button).sliderValue;
         sndPly(0, 1);
      }

      if (button.field_146127_k == 197) {
         JRMCoreH.Char((byte)6, (byte)((int)(ptch * 100.0F)));
      }

      String url;
      if (button.field_146127_k == 198) {
         url = urlToOpen.substring(urlToOpen.indexOf("http"));
         this.urlOpenWithConfirm(url);
      }

      if (button.field_146127_k == 199) {
         try {
            url = "http://main.jingames.net";
            Desktop.getDesktop().browse(URI.create(url));
         } catch (IOException var22) {
            mod_JRMCore.logger.error(var22.getMessage());
         }
      }

      if (button.field_146127_k == -200) {
         this.guiID = 16;
      }

      for(i = 0; i < 4; ++i) {
         if (button.field_146127_k == 200 + i) {
            if (this.attViwPg == 0) {
               this.guiID = 13;
            } else {
               this.guiID = 15;
            }

            EnAttNum = i;
         }

         if (button.field_146127_k == 240 + i) {
            i2 = i + this.attViwPg * 4;
            i3 = i2 == this.attViwPg * 4 ? (this.attViwPg + 1) * 4 - 1 : i2 - 1;
            JRMCoreH.Tech((byte)(i + this.attViwPg * 4), "up;;;");
            JRMCoreH.jrmct(-1);
            JRMCoreH.swapCD((byte)i2, (byte)i3);
         }

         if (button.field_146127_k == 244 + i) {
            i2 = i + this.attViwPg * 4;
            JRMCoreH.resetCD((byte)i2);
            JRMCoreH.Tech((byte)i2, " ");
            JRMCoreH.jrmct(-1);
         }

         if (button.field_146127_k == 248 + i) {
            i2 = i + this.attViwPg * 4;
            i3 = i2 == (this.attViwPg + 1) * 4 - 1 ? this.attViwPg * 4 : i2 + 1;
            JRMCoreH.Tech((byte)(i + this.attViwPg * 4), "dn;;;");
            JRMCoreH.jrmct(-1);
            JRMCoreH.swapCD((byte)i2, (byte)i3);
         }

         if (button.field_146127_k == 252 + i) {
            JRMCoreH.Tech((byte)(i + this.attViwPg * 4), "te;;;");
            JRMCoreH.jrmct(-1);
         }
      }

      if (button.field_146127_k == 210) {
         JRMCoreH.Tech(EnAttNum, name + ";" + techCrt[1] + ";" + owner + ";" + techCrt[3] + ";" + techCrt[4] + ";" + techCrt[5] / (techCrt[3] == 6 ? 5 : 1) + ";" + techCrt[6] + ";" + techCrt[7] + ";" + techCrt[8] + ";" + techCrt[9] + ";" + techCrt[10] + ";" + techCrt[11] + ";" + techCrt[12] + ";" + techCrt[13] + ";" + techCrt[14]);
         JRMCoreH.jrmct(-1);
         this.guiID = 12;
      }

      for(i = 0; i < 15; ++i) {
         if (button.field_146127_k == -220 - i || button.field_146127_k == 220 + i) {
            EnAt(i, button.field_146127_k, 1);
            if (i == 3 && this.pwr == 1) {
               this.inputField.func_146180_a(JRMCoreH2.kiAttNamGen() + " " + JRMCoreH.trl("dbc", JRMCoreH.techDBCTypes[techCrt[3]]));
            }

            if (i == 3 && this.pwr == 2) {
               this.inputField.func_146180_a(JRMCoreH2.kiAttNamGen() + " " + JRMCoreH.trl("nc", JRMCoreH.techNCTypes[techCrt[3]]));
            }
         }

         if (button.field_146127_k == -260 - i || button.field_146127_k == 260 + i) {
            EnAt(i, button.field_146127_k, 5);
         }

         if (button.field_146127_k == -280 - i || button.field_146127_k == 280 + i) {
            EnAt(i, button.field_146127_k, 100);
         }
      }

      if (!JRMCoreH.isFused()) {
         for(i = 0; i < JRMCoreH.PlyrSkills.length; ++i) {
            if (button.field_146127_k == 300 + i) {
               JRMCoreH.Skll((byte)2, i);
               JRMCoreH.jrmct(3);
            }
         }

         for(i = 0; i < JRMCoreH.PlyrSkills.length; ++i) {
            if (button.field_146127_k == 330 + i) {
               JRMCoreH.Skll((byte)3, i);
               JRMCoreH.jrmct(3);
            }
         }

         for(i = 0; i < JRMCoreH.PlyrSkills.length; ++i) {
            if (button.field_146127_k == 360 + i) {
               this.confirmationWindow = true;
               this.IDtoProcessConfirmFor = i;
            }
         }

         if (button.field_146127_k == 399) {
            this.confirmationWindow = false;
         }

         if (button.field_146127_k == 390) {
            JRMCoreH.Skll((byte)3, (byte)100);
            JRMCoreH.jrmct(3);
         }

         if (button.field_146127_k == 391) {
            JRMCoreH.Skll((byte)3, (byte)101);
            JRMCoreH.jrmct(3);
         }
      }

      if (button.field_146127_k == 392) {
         this.guiID = 19;
      }

      for(i = 0; i < 10; ++i) {
         if (button.field_146127_k == 1000 + i) {
            this.smd = i;
         }

         if (button.field_146127_k == -1000 - i) {
            this.smd = i;
            JRMCoreH.quad(2, i, 0, 0);
         }
      }

      for(i = 0; i < 10; ++i) {
         if (button.field_146127_k == -2010 - i) {
            JRMCoreH.quad(3, 7, i, 0);
            this.inv = 0;
         }

         if (button.field_146127_k == -2000 - i) {
            JRMCoreH.quad(3, 8, i, 0);
            this.inv = 0;
         }
      }

      for(i = 0; i < (JRMCoreH.plyrs != null ? JRMCoreH.plyrs.length : 10); ++i) {
         if (button.field_146127_k == 2000 + i) {
            i2 = i / 100;
            i3 = i - i2 * 100;
            JRMCoreH.quad(3, 6, i2, i3);
            this.inv = 0;
         }
      }

      if (button.field_146127_k == 3199 && JRMCoreConfig.ssurl2.contains("ttp:/")) {
         try {
            url = JRMCoreConfig.ssurl2;
            Desktop.getDesktop().browse(URI.create(url));
         } catch (IOException var21) {
            mod_JRMCore.logger.error(var21.getMessage());
         }
      }

      for(i = 0; i < this.sscl; ++i) {
         if (button.field_146127_k == 3000 + i) {
            this.ss = i;
            this.ssb = true;
         }

         if (button.field_146127_k == 3200 + i) {
            this.ss = i;
            this.ssb = false;
         }
      }

      if (button.field_146127_k == 3099) {
         this.guiID = 80;
         JRMCoreH.jrmcDataFC(80, "q");
      }

      if (button.field_146127_k == 3098) {
         JRMCoreEH.aw = true;
         this.kdf = 0;
      }

      if (button.field_146127_k == 3097) {
         JRMCoreEH.gk = !JRMCoreEH.gk;
      }

      if (button.field_146127_k == 3096) {
         url = "http://dbcserver1710.jingames.net";
         this.urlOpenWithConfirm(url);
      }

      if (button.field_146127_k == 3100) {
         if (this.ssb) {
            JRMCoreH.jrmcDataFC(80, "r" + this.ss);
            this.sscl = 0;
         }

         mc.field_71439_g.func_71053_j();
      }

      for(i = 0; i < (JRMCoreH.Pwrtyp == 2 ? JRMCoreH.NCSkillNames : JRMCoreH.DBCSkillNames).length; ++i) {
         if (button.field_146127_k == 4000 + i) {
            JRMCoreH.Skll((byte)1, i);
            this.guiID = 11;
            this.ipg = 0;
         }
      }

      for(i = 0; i < (JRMCoreH.Pwrtyp == 2 ? JRMCoreH.pmj : JRMCoreH.pmdbc).length; ++i) {
         if (button.field_146127_k == 4200 + i) {
            JRMCoreH.Tech((byte)(EnAttNum + 4), "" + i);
            this.guiID = 12;
            this.attViwPg = 1;
            this.ipg = 0;
         }
      }

      if (button instanceof JRMCoreGuiButtons00MS && button.field_146127_k == 6000) {
         JRMCoreGuiButtons00MS btn = (JRMCoreGuiButtons00MS)button;
         if (btn.d2.equals("-1")) {
            mc.field_71439_g.func_71053_j();
         }

         dataSend(btn.d1, btn.d2);
      }

      if (button instanceof JRMCoreGuiButtons01MS && button.field_146127_k == 6001) {
         JRMCoreGuiButtons01MS btn = (JRMCoreGuiButtons01MS)button;
         this.SideMsn = btn.d1;
      }

      if (button.field_146127_k == 6002) {
         this.SideMsn = "";
      }

      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.actionPerformed(button);
      }

      this.nuller();
   }

   public static String[] cl() {
      return JRMCoreH.cl(PwrtypSlcted);
   }

   public static String[] clDesc(int pwr) {
      String[] cl = JRMCoreH.PwrtypAllow[pwr].contains("DBC") ? JRMCoreH.ClassesDBCDesc : (JRMCoreH.PwrtypAllow[pwr].contains("NC") ? JRMCoreH.ClansDesc : JRMCoreH.ClassesDesc);
      return cl;
   }

   public static String[] clDesc() {
      return clDesc(PwrtypSlcted);
   }

   public static void sndPly(int b, int t) {
      String snd = "";
      String snd2 = "";
      int i;
      if (t == 0) {
         b += 12;
         int[] crt = new int[techCrt.length];

         for(i = 0; i < techCrt.length; ++i) {
            crt[i] = techCrt[i];
         }

         if (JRMCoreH.Pwrtyp == 1) {
            if (crt[3] == 0 || crt[3] == 1 || crt[3] == 5 || crt[3] == 4 || crt[3] == 6 || crt[3] == 7 || crt[3] == 8) {
               if (b == 12) {
                  snd = JRMCoreH.techSndIncBeam[crt[12]];
               }

               if (b == 13) {
                  snd = JRMCoreH.techSndFireBeam[crt[13]];
               }

               if (b == 14) {
                  snd = JRMCoreH.techSndMoveBeam[crt[14]];
               }
            }

            if (crt[3] == 2) {
               if (b == 12) {
                  snd = JRMCoreH.techSndIncDisk[crt[12]];
               }

               if (b == 13) {
                  snd = JRMCoreH.techSndFireDisk[crt[13]];
               }

               if (b == 14) {
                  snd = JRMCoreH.techSndMoveDisk[crt[14]];
               }
            }

            if (crt[3] == 3 && b == 13) {
               snd = JRMCoreH.techSndFireLeser[crt[13]];
            }

            JRMCoreClient.mc.field_71439_g.func_85030_a("jinryuudragonbc:DBC4." + snd, 1.0F, 1.0F);
         } else if (JRMCoreH.Pwrtyp == 2) {
            if (crt[11] == 1) {
               if (JRMCoreH.techNCSndIncAff.length > crt[6]) {
                  snd = JRMCoreH.techNCSndIncAff[crt[6]];
               }

               if (JRMCoreH.techNCSndIncTyp.length > crt[3]) {
                  snd2 = JRMCoreH.techNCSndIncTyp[crt[3]];
               }
            }

            if (crt[11] == 2 && JRMCoreH.techNCSndIncCls.length > crt[11]) {
               snd2 = JRMCoreH.techNCSndIncCls[crt[11]];
            }

            if (crt[11] == 4) {
               if (JRMCoreH.techNCSndIncAff.length > crt[6]) {
                  snd = JRMCoreH.techNCSndIncAff[crt[6]];
               }

               if (JRMCoreH.techNCSndIncCls.length > crt[11]) {
                  snd2 = JRMCoreH.techNCSndIncCls[crt[11]];
               }
            }

            float p = JRMCoreH.PtchVc == 0 ? 1.0F : 0.8F + 0.006F * (float)JRMCoreH.PtchVc;
            JRMCoreClient.mc.field_71439_g.func_85030_a("jinryuunarutoc:NC2." + snd, 1.0F, p);
            JRMCoreClient.mc.field_71439_g.func_85030_a("jinryuunarutoc:NC2." + snd2, 1.0F, p);
         }
      } else if (t == 1 && JRMCoreH.Pwrtyp == 2) {
         Random r = new Random();
         i = r.nextInt(JRMCoreH.techNCSndIncAff.length);
         snd = JRMCoreH.techNCSndIncAff[i];
         float p = 0.8F + 0.6F * ptch;
         JRMCoreClient.mc.field_71439_g.func_85030_a("jinryuunarutoc:NC2." + snd, 1.0F, p);
      }

   }

   public void nuller() {
      JRMCoreH.ask = null;
      JRMCoreH.targ = null;
      if (this.guiID != this.guiIDprev3) {
         this.guiIDprev3 = this.guiID;
         JRMCoreGuiSliderX00.sliderValue = 0.0F;
         this.scroll = 0;
         scrollSide = 0.0F;
      }

   }

   public void player() {
   }

   public static void EnAt(byte b, int n, int t) {
      boolean chkr = JRMCoreH.Pwrtyp == 2;
      int[] techMin;
      int[] techMax;
      int[] techUpg;
      if (chkr) {
         techMin = JRMCoreH.techNCMin;
         techMax = JRMCoreH.techNCMax;
         techUpg = JRMCoreH.techNCUpg;
      } else {
         techMin = JRMCoreH.techMin;
         techMax = JRMCoreH.techMax;
         techUpg = JRMCoreH.techUpg;
      }

      if (b > 2 && (chkr || b != 7)) {
         int[] crt = new int[techCrt.length];

         for(int i = 0; i < techCrt.length; ++i) {
            crt[i] = techCrt[i];
         }

         crt[b] += n > 0 ? techUpg[b] * t : -techUpg[b] * t;
         if (b < 12) {
            if (crt[b] > techMax[b]) {
               crt[b] = techMax[b];
            } else if (crt[b] < techMin[b]) {
               crt[b] = techMin[b];
            }

            if (crt[3] != techCrt[3]) {
               crt[12] = 0;
               crt[13] = 0;
               crt[14] = 0;
            }

            if (b == 3 && (crt[b] == 7 || crt[b] == 8)) {
               crt[4] = 1;
            }
         } else {
            if (crt[3] == 0 || crt[3] == 1 || crt[3] == 5 || crt[3] == 4 || crt[3] == 6 || crt[3] == 7 || crt[3] == 8) {
               if (b == 12) {
                  if (crt[b] > JRMCoreH.techSndIncBeam.length - 1) {
                     crt[b] = JRMCoreH.techSndIncBeam.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 13) {
                  if (crt[b] > JRMCoreH.techSndFireBeam.length - 1) {
                     crt[b] = JRMCoreH.techSndFireBeam.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 14) {
                  if (crt[b] > JRMCoreH.techSndMoveBeam.length - 1) {
                     crt[b] = JRMCoreH.techSndMoveBeam.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }
            }

            if (crt[3] == 2) {
               if (b == 12) {
                  if (crt[b] > JRMCoreH.techSndIncDisk.length - 1) {
                     crt[b] = JRMCoreH.techSndIncDisk.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 13) {
                  if (crt[b] > JRMCoreH.techSndFireDisk.length - 1) {
                     crt[b] = JRMCoreH.techSndFireDisk.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 14) {
                  if (crt[b] > JRMCoreH.techSndMoveDisk.length - 1) {
                     crt[b] = JRMCoreH.techSndMoveDisk.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }
            }

            if (crt[3] == 3) {
               if (b == 12) {
                  if (crt[b] > 0) {
                     crt[b] = 0;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 13) {
                  if (crt[b] > JRMCoreH.techSndFireLeser.length - 1) {
                     crt[b] = JRMCoreH.techSndFireLeser.length - 1;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }

               if (b == 14) {
                  if (crt[b] > 0) {
                     crt[b] = 0;
                  } else if (crt[b] < techMin[b]) {
                     crt[b] = techMin[b];
                  }
               }
            }
         }

         techCrt = crt;
      }

   }

   public static void setchangebodycol() {
      int[][] pres = JRMCoreH.defbodycols[BodyColPresetSlcted];
      BodyColMainSlcted = pres[RaceSlcted].length > 0 ? pres[RaceSlcted][0] : 0;
      BodyColSub1Slcted = pres[RaceSlcted].length > 1 ? pres[RaceSlcted][1] : 0;
      BodyColSub2Slcted = pres[RaceSlcted].length > 2 ? pres[RaceSlcted][2] : 0;
      BodyColSub3Slcted = pres[RaceSlcted].length > 3 ? pres[RaceSlcted][3] : 0;
   }

   public static void setchangeeyecol() {
      int[] preseyes = JRMCoreH.defeyecols[EyeColPresetSlcted];
      EyeCol1Slcted = preseyes[RaceSlcted];
      EyeCol2Slcted = preseyes[RaceSlcted];
   }

   public static void setchangerace() {
      GenderSlcted = JRMCoreH.RaceGenders[RaceSlcted] == 1 ? 0 : GenderSlcted;
      if (RaceSlcted == 4) {
         StateSlcted = 4;
      } else {
         StateSlcted = 0;
      }

      int bt = JRMCoreH.customSknLimits[RaceSlcted][0];
      BodyTypeSlcted = BodyTypeSlcted > bt - 1 ? bt - 1 : BodyTypeSlcted;
      setchangebodycol();
      bt = JRMCoreH.customSknLimits[RaceSlcted][2];
      FaceNoseSlcted = FaceNoseSlcted > bt - 1 ? bt - 1 : FaceNoseSlcted;
      bt = JRMCoreH.customSknLimits[RaceSlcted][3];
      FaceMouthSlcted = FaceMouthSlcted > bt - 1 ? bt - 1 : FaceMouthSlcted;
      bt = JRMCoreH.customSknLimits[RaceSlcted][4];
      EyesSlcted = EyesSlcted > bt - 1 ? bt - 1 : EyesSlcted;
      setchangeeyecol();
      setdns();
   }

   public static void csau_d() {
      String dnsau = JRMCoreH.data(JRMCoreClient.mc.field_71439_g.func_70005_c_(), 16, "");
      dnsau = dnsau.contains(";") ? dnsau.substring(1) : dnsau;
      BodyauColMainSlcted = JRMCoreH.dnsauCM(dnsau);
      BodyauColSub1Slcted = JRMCoreH.dnsauC1(dnsau);
      BodyauColSub2Slcted = JRMCoreH.dnsauC2(dnsau);
      BodyauColSub3Slcted = JRMCoreH.dnsauC3(dnsau);
   }

   public static void csau_df() {
      BodyauColMainSlcted = 14208118;
      BodyauColSub1Slcted = 10317733;
      BodyauColSub2Slcted = 6966676;
      BodyauColSub3Slcted = 11045420;
   }

   public static void setdnsau() {
      String BCM = ntl5(BodyauColMainSlcted);
      String BC1 = ntl5(BodyauColSub1Slcted);
      String BC2 = ntl5(BodyauColSub2Slcted);
      String BC3 = ntl5(BodyauColSub3Slcted);
      dnsau = BCM + BC1 + BC2 + BC3;
   }

   public static void setdns() {
      GenderSlcted = GenderSlcted > 9 ? 9 : (GenderSlcted < 0 ? 0 : GenderSlcted);
      BreastSizeSlcted = BreastSizeSlcted > 9 ? 9 : (BreastSizeSlcted < 0 ? 0 : BreastSizeSlcted);
      SkinTypeSlcted = SkinTypeSlcted > 9 ? 9 : (SkinTypeSlcted < 0 ? 0 : SkinTypeSlcted);
      String R = ntl(RaceSlcted);
      String G = GenderSlcted + "";
      String H1 = ntl(HairSlcted);
      String H2 = ntl(Hair2Slcted);
      String HC = ntl5(ColorSlcted);
      String BS = BreastSizeSlcted + "";
      String ST = SkinTypeSlcted + "";
      String BT = ntl(BodyTypeSlcted);
      String BCM = ntl5(BodyColMainSlcted);
      String BC1 = ntl5(BodyColSub1Slcted);
      String BC2 = ntl5(BodyColSub2Slcted);
      String BC3 = ntl5(BodyColSub3Slcted);
      String FN = ntl(FaceNoseSlcted);
      String FM = ntl(FaceMouthSlcted);
      String ET = ntl(EyesSlcted);
      String EC1 = ntl5(EyeCol1Slcted);
      String EC2 = ntl5(EyeCol2Slcted);
      if (SkinTypeSlcted == 0) {
         dns = R + G + H1 + H2 + HC + BS + ST + BC1;
      } else {
         dns = R + G + H1 + H2 + HC + BS + ST + BT + BCM + BC1 + BC2 + BC3 + FN + FM + ET + EC1 + EC2;
      }

   }

   public static void setdnsForHair() {
      dns = JRMCoreH.dnsHairBSet(dns, HairSlcted);
      dns = JRMCoreH.dnsHairFSet(dns, Hair2Slcted);
      dns = JRMCoreH.dnsHairCSet(dns, ColorSlcted);
   }

   public static void HairCstmNextPreset() {
      int selct = HairPrstsSlcted + 1;
      if (selct < PresetList.size()) {
         HairPrstsSlcted = selct;
      } else {
         HairPrstsSlcted = 0;
      }

      dnsH = (String)PresetList.get(HairPrstsSlcted);
   }

   public static void HairCstmPrevPreset() {
      int selct = HairPrstsSlcted - 1;
      if (selct >= 0) {
         HairPrstsSlcted = selct;
      } else {
         HairPrstsSlcted = PresetList.size() - 1;
      }

      dnsH = (String)PresetList.get(HairPrstsSlcted);
   }

   public static void HairCstmSaveAsPreset() {
      String s = JRMCoreH.rld("HairPresets", "jinryuujrmcore.dat");
      List<String> stooges = Arrays.asList();
      if (s.length() > 3) {
         stooges = Arrays.asList(s.split(","));
      }

      ArrayList<String> saves = new ArrayList(stooges);
      ArrayList<String> defpres = new ArrayList();
      ArrayList<String> presets = new ArrayList();
      String[] var5 = JRMCoreH.defHairPrsts;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String def = var5[var7];
         defpres.add(def);
      }

      saves.add(dnsH);
      saves.removeAll(defpres);
      String listString = "";

      String strng;
      for(Iterator var10 = saves.iterator(); var10.hasNext(); listString = listString + "," + strng) {
         strng = (String)var10.next();
      }

      if (listString.length() > 2) {
         listString = listString.substring(1);
      }

      presets.addAll(defpres);
      presets.addAll(saves);
      PresetList = presets;
      dnsH = (String)PresetList.get(PresetList.size() - 1);
      JRMCoreH.wld(listString, "HairPresets", "jinryuujrmcore.dat", false);
      HairPrstsSlcted = PresetList.size() - 1;
      dnsH = (String)PresetList.get(HairPrstsSlcted);
   }

   public static void HairCstmDelPreset() {
      if (HairPrstsSlcted > JRMCoreH.defHairPrsts.length - 1) {
         String s = JRMCoreH.rld("HairPresets", "jinryuujrmcore.dat");
         List<String> stooges = Arrays.asList();
         if (s.length() > 3) {
            stooges = Arrays.asList(s.split(","));
         }

         ArrayList<String> saves = new ArrayList(stooges);
         ArrayList<String> defpres = new ArrayList();
         ArrayList<String> presets = new ArrayList();
         String[] var5 = JRMCoreH.defHairPrsts;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String def = var5[var7];
            defpres.add(def);
         }

         if (saves.size() > HairPrstsSlcted - JRMCoreH.defHairPrsts.length) {
            saves.remove(HairPrstsSlcted - JRMCoreH.defHairPrsts.length);
         }

         String listString = "";

         String strng;
         for(Iterator var10 = saves.iterator(); var10.hasNext(); listString = listString + "," + strng) {
            strng = (String)var10.next();
         }

         if (listString.length() > 2) {
            listString = listString.substring(1);
         }

         presets.addAll(defpres);
         presets.addAll(saves);
         PresetList = presets;
         JRMCoreH.wld(listString, "HairPresets", "jinryuujrmcore.dat", false);
         --HairPrstsSlcted;
         dnsH = (String)PresetList.get(HairPrstsSlcted);
      }

   }

   public static void HairCstmResetPreset() {
      dnsH = (String)PresetList.get(HairPrstsSlcted);
   }

   public static void StateViewF() {
      if (RaceSlcted == JRMCoreH.RACES) {
         ++StateSlcted;
         StateSlcted = StateSlcted > JRMCoreH.RACES + 1 ? 0 : StateSlcted;
      } else {
         StateSlcted = 0;
      }

   }

   public static void StateViewB() {
      if (RaceSlcted == JRMCoreH.RACES) {
         --StateSlcted;
         StateSlcted = StateSlcted < 0 ? JRMCoreH.RACES + 1 : StateSlcted;
      } else {
         StateSlcted = 0;
      }

   }

   public static void RaceSlctF() {
      if (JRMCoreH.isRaceArcosian(RaceSlcted) && !JGConfigRaces.CONFIG_MAJIN_ENABLED) {
         RaceSlcted = 5;
      }

      for(int selct = 1; selct < JRMCoreH.Races.length; ++selct) {
         if (RaceSlcted < selct && (JRMCoreH.RaceAllow[selct].contains("DBC") && JRMCoreH.DBC() || JRMCoreH.RaceAllow[selct].contains("HHC") && JRMCoreH.HHC())) {
            RaceSlcted = selct;
            return;
         }
      }

      int selct = 0;
      if (RaceSlcted > selct || JRMCoreH.isRaceMajin(RaceSlcted) && !JGConfigRaces.CONFIG_MAJIN_ENABLED) {
         RaceSlcted = selct;
      }
   }

   public static void RaceSlctB() {
      if (JRMCoreH.isRaceHuman(RaceSlcted) && !JGConfigRaces.CONFIG_MAJIN_ENABLED) {
         RaceSlcted = 5;
      }

      int selct;
      for(selct = JRMCoreH.Races.length - 1; selct >= 0; --selct) {
         if (RaceSlcted > selct && JRMCoreH.Allow(JRMCoreH.RaceAllow[selct])) {
            RaceSlcted = selct;
            return;
         }
      }

      for(selct = JRMCoreH.Races.length - 1; selct >= 0; --selct) {
         if (RaceSlcted < selct && JRMCoreH.Allow(JRMCoreH.RaceAllow[selct])) {
            RaceSlcted = selct;
            return;
         }
      }

   }

   public static void GenderSlctF() {
      int selct = GenderSlcted + 1;
      if (selct < JRMCoreH.Genders.length && JRMCoreH.Allow(JRMCoreH.GenderAllow[selct])) {
         GenderSlcted = selct;
      } else {
         GenderSlcted = 0;
      }

   }

   public static void YearsSlctF() {
      int selct = YearsSlcted + 1;
      if (selct < JRMCoreH.YearsD.length) {
         YearsSlcted = selct;
      } else {
         YearsSlcted = 0;
      }

   }

   public static void YearsSlctB() {
      int selct = YearsSlcted - 1;
      if (selct >= 0) {
         YearsSlcted = selct;
      } else {
         YearsSlcted = JRMCoreH.YearsD.length - 1;
      }

   }

   public static void HairSlctF() {
      int selct = HairSlcted + 1;
      if (selct < JRMCoreH.Hairs.length) {
         HairSlcted = selct;
      } else {
         HairSlcted = JRMCoreH.isRaceMajin(RaceSlcted) ? 10 : 0;
      }

   }

   public static void HairSlctB() {
      int selct = HairSlcted - 1;
      if (selct >= 0) {
         HairSlcted = selct;
      } else {
         HairSlcted = JRMCoreH.Hairs.length - 1;
      }

   }

   public static void Hair2SlctF() {
      int selct = Hair2Slcted + 1;
      if (selct < JRMCoreH.Hairs2.length) {
         Hair2Slcted = selct;
      } else {
         Hair2Slcted = 0;
      }

   }

   public static void Hair2SlctB() {
      int selct = Hair2Slcted - 1;
      if (selct >= 0) {
         Hair2Slcted = selct;
      } else {
         Hair2Slcted = JRMCoreH.Hairs2.length - 1;
      }

   }

   public static int SlctF(int s, int l) {
      int selct = s + 1;
      return selct < l ? selct : 0;
   }

   public static int SlctB(int s, int l) {
      int selct = s - 1;
      return selct >= 0 ? selct : l - 1;
   }

   public static int Slct(String dir, int Select, String[] allow) {
      int selct;
      boolean loop;
      if (dir.contains("B")) {
         selct = Select - 1;
         loop = true;

         while(loop) {
            if (JRMCoreH.RaceCanHavePwr[RaceSlcted].contains("" + selct) && selct < allow.length && JRMCoreH.Allow(allow[selct])) {
               Select = selct;
               loop = false;
               break;
            }

            --selct;
            if (selct <= 0) {
               selct = allow.length - 1;
            }
         }
      } else {
         selct = Select + 1;
         loop = true;

         while(loop) {
            if (JRMCoreH.RaceCanHavePwr[RaceSlcted].contains("" + selct) && selct < allow.length && JRMCoreH.Allow(allow[selct])) {
               Select = selct;
               loop = false;
               break;
            }

            ++selct;
            if (selct >= allow.length) {
               selct = 0;
            }
         }
      }

      return Select;
   }

   public static int Slct2(String dir, int Select, String[] allow, int allowsel, String[] cur) {
      int selct;
      if (dir.contains("B")) {
         selct = Select - 1;
         if (selct >= 0 && JRMCoreH.Allow(allow[allowsel])) {
            Select = selct;
         } else {
            Select = cur.length - 1;
         }
      } else {
         selct = Select + 1;
         if (selct < cur.length && JRMCoreH.Allow(allow[allowsel])) {
            Select = selct;
         } else {
            Select = 0;
         }
      }

      return Select;
   }

   public static int SlctCol(String dir, int Select, String[] allow) {
      int selct;
      if (dir.contains("B")) {
         selct = Select - 1;
         if (selct >= 0) {
            Select = selct;
         } else {
            Select = allow.length - 1;
         }
      } else {
         selct = Select + 1;
         if (selct < allow.length) {
            Select = selct;
         } else {
            Select = 0;
         }
      }

      return Select;
   }

   public static int SlctSpec(String dir, int Select, int[] allow) {
      int selct;
      int max;
      if (dir.contains("B")) {
         selct = Select - 1;
         max = allow[RaceSlcted];
         if (selct >= 0) {
            Select = selct;
         } else {
            Select = max - 1;
         }
      } else {
         selct = Select + 1;
         max = allow[RaceSlcted];
         if (selct < max) {
            Select = selct;
         } else {
            Select = 0;
         }
      }

      return Select;
   }

   public void func_73863_a(int x, int y, float f) {
      int ar = 2000;
      if (this.kdf < ar) {
         ++this.kdf;
      }

      if (Mouse.isButtonDown(0)) {
         this.mousePressed = true;
         scrollSide = JRMCoreGuiSliderX00.sliderValue;
      } else {
         this.mousePressed = false;

         while(Mouse.next()) {
            int mw = Mouse.getEventDWheel();
            if (mw != 0) {
               if (mw < 0) {
                  this.scroll += this.scrollMouseJump;
               } else if (mw > 0 && this.scroll > 0) {
                  this.scroll -= this.scrollMouseJump;
               }

               this.scrollMouseJump = 1;
            }
         }
      }

      if (JRMCoreH.Accepted == 0 && this.guiID == 10) {
         this.guiID = 0;
      }

      this.x = x;
      this.y = y;
      if (this.guiID == 31 && JRMCoreH.Accepted != 2) {
         this.guiID = 30;
      }

      if (this.guiIDprev2 != 0) {
         this.guiID = this.guiIDprev2;
         this.guiIDprev2 = 0;
      }

      if (dns.length() > 1 && !dns.equals(dnsSent)) {
         dnsSent = dns;
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               JRMCoreHJFC.childDNSset(ItemBarberSnC.barberTarget, dnsSent);
            }
         } else {
            JRMCoreH.jrmcDataFC(0, dnsSent);
         }
      }

      if (dnsH.length() != 786 && !dnsH.equals(dnsHSent)) {
         dnsH = JRMCoreH.dnsHairG1toG2(dnsH);
      }

      if (dnsH.length() == 786 && !dnsH.equals(dnsHSent)) {
         dnsHSent = dnsH;
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               JRMCoreHJFC.childDNSHset(ItemBarberSnC.barberTarget, dnsHSent);
            }
         } else {
            JRMCoreH.jrmcDataFC(1, dnsHSent);
         }
      }

      if (dnsH.length() < 3) {
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               dnsH = JRMCoreHJFC.childDNSH(ItemBarberSnC.barberTarget);
            }
         } else {
            dnsH = JRMCoreH.dnsH;
         }
      }

      if (dns.length() < 3) {
         if (JRMCoreH.JFC() && ItemBarberSnC.barberTarget != null) {
            if (JRMCoreHJFC.isChildNPC(ItemBarberSnC.barberTarget)) {
               dns = JRMCoreHJFC.childDNS(ItemBarberSnC.barberTarget);
            }
         } else {
            dns = JRMCoreH.dns;
         }
      }

      this.xSize_lo = (float)x;
      this.ySize_lo = (float)y;
      ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = mc.field_71466_p;
      this.field_146292_n.clear();
      ++tick;
      if (tick >= 20) {
         tick = 0;
         JRMCoreH.jrmct(1);
         JRMCoreH.jrmct(3);
      }

      this.guiLeft = (this.field_146294_l - this.xSize) / 2;
      this.guiTop = (this.field_146295_m - this.ySize) / 2;
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      this.pwr = JRMCoreH.Pwrtyp;
      short xSize;
      short xSize;
      int guiLeft;
      int guiLeft;
      ResourceLocation guiLocation;
      int i2;
      int i;
      byte nr;
      String mod;
      String[] techEffects;
      String[] techEffects;
      int possibleReward;
      String[] m;
      int reward;
      int owner;
      byte i;
      int costP;
      int cls;
      String TransNms;
      String s;
      String StatIncreaseDesc3;
      boolean canAffordTP;
      int skillID;
      int i;
      int i;
      String className;
      int type;
      int cost;
      String Attributes;
      String TP;
      int n2;
      if (this.isGUIOpen(80)) {
         xSize = 256;
         xSize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiLeft = (this.field_146295_m - xSize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiLeft, 0, 0, xSize, xSize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(100, guiLeft + xSize / 2 - 150, guiLeft + xSize / 2 + 65, 20, 20, "X", 0));
         i2 = JRMCoreH.curTP;
         i = JRMCoreH.ServerPoints;
         nr = 0;
         mod = JRMCoreConfig.ssc;
         if (mod.contains("http://")) {
            mod = JRMCoreGuiScreen.ssc.length() > 0 ? JRMCoreGuiScreen.ssc : (JRMCoreGuiScreen.ssc = JRMCoreH.turihr(JRMCoreConfig.ssc));
         }

         techEffects = mod.split(";");
         techEffects = new String[techEffects.length];
         int[] sc = new int[techEffects.length];

         for(possibleReward = 0; possibleReward < techEffects.length; ++possibleReward) {
            if (techEffects[possibleReward].contains("=")) {
               m = techEffects[possibleReward].split("=");
               techEffects[possibleReward] = m[0];
               sc[possibleReward] = Integer.parseInt(m[1]);
            }
         }

         this.sscl = techEffects.length;
         className = "Click here to donate for points";
         type = this.field_146289_q.func_78256_a(className);
         this.field_146292_n.add(new JRMCoreGuiButtons00(3199, guiLeft + 5 + 1, guiLeft + 162, type + 8, 20, className, JRMCoreH.techNCCol[0]));
         className = "Server Points";
         this.field_146289_q.func_78256_a(className);
         var8.func_78276_b(className + ": §8" + i + "P", guiLeft + 5, guiLeft + 5 + nr * 8, 0);
         i = nr + 1;
         className = "Point Cost";
         this.field_146289_q.func_78256_a(className);
         if (this.ss >= 0) {
            var8.func_78276_b(className + ": §8" + sc[this.ss] + "P", guiLeft + 5, guiLeft + 5 + i * 8, 0);
            ++i;
         }

         if (mod.equals("loading")) {
            className = "LOADING";
            type = this.field_146289_q.func_78256_a(className);
            var8.func_78276_b("LOADING", guiLeft + 250 - type, guiLeft + 5, 0);
         } else if (mod.equals("error")) {
            className = "CONNECTION ERROR";
            type = this.field_146289_q.func_78256_a(className);
            var8.func_78276_b("CONNECTION ERROR", guiLeft + 250 - type, guiLeft + 5, 0);
         } else if (mod.contains("=")) {
            if (this.ss >= 0 && techEffects[this.ss].startsWith("TP")) {
               reward = Integer.parseInt(techEffects[this.ss].substring(2)) + i2;
               owner = i - sc[this.ss];
               reward = reward > JRMCoreH.getMaxTP() ? JRMCoreH.getMaxTP() : reward;
               if (reward <= JRMCoreH.getMaxTP() && owner >= 0) {
                  className = "Point Result";
                  this.field_146289_q.func_78256_a(className);
                  var8.func_78276_b(className + ": §8" + JRMCoreH.numSep((long)owner) + "P", guiLeft + 5, guiLeft + 5 + i * 8, 0);
                  ++i;
                  className = "TP Current";
                  this.field_146289_q.func_78256_a(className);
                  var8.func_78276_b(className + ": §8" + JRMCoreH.numSep((long)i2) + "TP", guiLeft + 5, guiLeft + 5 + i * 8, 0);
                  ++i;
                  className = "TP Result";
                  this.field_146289_q.func_78256_a(className);
                  var8.func_78276_b(className + ": §8" + JRMCoreH.numSep((long)reward) + "TP", guiLeft + 5, guiLeft + 5 + i * 8, 0);
                  ++i;
               }
            } else if (this.ss >= 0 && techEffects[this.ss].startsWith("IT") || this.ss >= 0 && techEffects[this.ss].startsWith("CM")) {
               reward = i - sc[this.ss];
               if (reward >= 0) {
                  className = "Point Result";
                  this.field_146289_q.func_78256_a(className);
                  var8.func_78276_b(className + ": §8" + reward + "P", guiLeft + 5, guiLeft + 5 + i * 8, 0);
                  ++i;
               }
            }

            if (this.ss >= 0 && sc[this.ss] == 0) {
               className = JRMCoreH.cldg + "Its for FREE!";
               this.field_146289_q.func_78256_a(className);
               var8.func_78276_b(className, guiLeft + 5, guiLeft + 5 + i * 8, 0);
               ++i;
            }

            reward = techEffects.length;
            float m2 = 5.0F;
            i = 7;
            this.scrollMouseJump = 2;
            if (reward > i) {
               if ((float)reward - m2 < (float)this.scroll) {
                  this.scroll = (int)((float)reward - m2);
               } else if (this.scroll < 0) {
                  this.scroll = 0;
               }

               if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
                  this.scroll = (int)JRMCoreH.round(((float)reward - m2) * scrollSide, 0);
               } else {
                  scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)reward - m2);
               }
            } else {
               this.scroll = 0;
            }

            costP = -1;

            for(cls = this.scroll; cls < (reward > this.scroll + i ? this.scroll + i : reward); ++cls) {
               ++costP;
               TransNms = null;
               s = "";
               String[] ssa = null;
               if (techEffects[cls].startsWith("IT")) {
                  if (techEffects[cls].contains("||")) {
                     ssa = techEffects[cls].split("\\|\\|");
                     TransNms = ssa[0].substring(2);
                  } else {
                     StatIncreaseDesc3 = "";
                     canAffordTP = true;
                     skillID = 0;
                     String[] s2 = techEffects[cls].split(",");
                     if (s2.length > 1) {
                        cost = Integer.parseInt(s2[1]);
                        s = cost + " ";
                     }

                     if (s2[0].contains("::")) {
                        String[] s3 = s2[0].split("::");
                        StatIncreaseDesc3 = s3[0].substring(2);
                        skillID = Integer.parseInt(s3[1]);
                     } else {
                        StatIncreaseDesc3 = s2[0].substring(2);
                     }

                     Item item = JRMCoreH.getItemByText(StatIncreaseDesc3);
                     if (item != null) {
                        ItemStack is = new ItemStack(item, 1, skillID);
                        TransNms = item.func_77653_i(is);
                     }
                  }
               } else if (techEffects[cls].startsWith("TP")) {
                  TransNms = techEffects[cls].substring(2) + "TP";
               } else if (techEffects[cls].startsWith("CM")) {
                  if (techEffects[cls].contains("||")) {
                     ssa = techEffects[cls].split("\\|\\|");
                     TransNms = ssa[0].substring(2);
                  } else {
                     TransNms = techEffects[cls].split("!")[0].substring(2);
                  }
               }

               if (TransNms != null) {
                  className = s + TransNms;
                  type = this.field_146289_q.func_78256_a(className);
                  if (i - sc[cls] >= 0) {
                     this.field_146292_n.add(new JRMCoreGuiButtons00(3000 + cls, guiLeft + xSize / 2 + 110 - type, guiLeft + (xSize + 1) / 2 - 75 + costP * 21, type + 8, 20, className, this.ss == cls ? 160000 : 100000));
                  } else {
                     this.field_146292_n.add(new JRMCoreGuiButtons00(3200 + cls, guiLeft + xSize / 2 + 110 - type, guiLeft + (xSize + 1) / 2 - 75 + costP * 21, type + 8, 20, className, 3092271));
                  }

                  if (ssa != null && this.ss == cls) {
                     StatIncreaseDesc3 = "";
                     cost = 0;

                     for(skillID = 0; skillID < ssa.length; ++skillID) {
                        Attributes = ssa[skillID];
                        if (skillID > 0) {
                           if (techEffects[cls].startsWith("IT")) {
                              TP = "";
                              int n2 = true;
                              i = 0;
                              String[] s2 = Attributes.split(",");
                              if (s2.length > 1) {
                                 n2 = Integer.parseInt(s2[1]);
                                 s = n2 + " ";
                              }

                              if (s2[0].contains("::")) {
                                 String[] s3 = s2[0].split("::");
                                 TP = s3[0];
                                 i = Integer.parseInt(s3[1]);
                              } else {
                                 TP = s2[0];
                              }

                              Item item = JRMCoreH.getItemByText(TP);
                              if (item != null) {
                                 ItemStack is = new ItemStack(item, 1, i);
                                 TransNms = "§8" + s + item.func_77653_i(is);
                              }
                           }

                           if (techEffects[cls].startsWith("CM")) {
                              TransNms = "§8" + Attributes.split("!")[0];
                           }
                        } else {
                           TransNms = Attributes.substring(2);
                        }

                        if (!StatIncreaseDesc3.equals(TransNms)) {
                           type = this.field_146289_q.func_78256_a(TransNms);
                           var8.func_78276_b(TransNms, guiLeft + 5, guiLeft + 5 + 52 + cost * 10, 0);
                           StatIncreaseDesc3 = TransNms;
                           ++cost;
                        }
                     }
                  }
               }
            }

            if (reward > i) {
               if (scrollSide > 0.0F) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 + 18, guiLeft + (xSize + 1) / 2 - 70, "i"));
               }

               if (scrollSide < 1.0F) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 + 18, guiLeft + (xSize + 1) / 2 + 60, "v"));
               }

               this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiLeft + 25, this.mousePressed, scrollSide, 1.0F));
            }
         }

         className = "Checkout";
         type = this.field_146289_q.func_78256_a(className);
         this.field_146292_n.add(new JRMCoreGuiButtons00(3100, guiLeft + xSize / 2 + 100 - type / 2, guiLeft + (xSize + 1) / 2 - 50 + 131, type + 8, 20, className, 0));
      }

      String ln;
      String s;
      int gender;
      boolean ir;
      int xPos;
      String[] techTypes;
      boolean COLOR_ID;
      int limit;
      float h4;
      String ClassDesc;
      String buttonText;
      String Class;
      String Stats;
      boolean doit;
      String speed;
      int i;
      boolean fc;
      String TRState;
      boolean canAffordMind;
      int fcs;
      int var10000;
      if (this.guiID <= 50 && this.guiID >= 30) {
         xSize = 256;
         xSize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiLeft = (this.field_146295_m - xSize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiLeft, 0, 0, xSize, xSize);
         if (this.isGUIOpen(50)) {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(31, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "News"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(32, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Server"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(33, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Update"), 1));
            this.menuButtons("News");
            ln = "Read more at JinGames.net";
            i = var8.func_78256_a(ln);
            this.field_146292_n.add(new JRMCoreGuiButtons01(199, guiLeft + 128 - i / 2, guiLeft + 5, i, ln, 16777215));
            if (Version.ammv != null) {
               if (Version.ammv.length() > 0) {
                  techTypes = Version.ammv.split(";");
                  gender = 0;
                  techEffects = techTypes;
                  xPos = techTypes.length;

                  for(limit = 0; limit < xPos; ++limit) {
                     className = techEffects[limit];
                     ++gender;
                     m = className.split("::");
                     ClassDesc = "§2";
                     buttonText = "";
                     Stats = "";
                     speed = "";
                     boolean next = false;
                     if ("jinryuujrmcore".equals(m[0].toLowerCase().replace("_", ""))) {
                        TransNms = m[1];
                        s = m[2];
                        buttonText = "JinRyuu's JRMCore";
                        Stats = "1.3.51";
                        if (!Stats.equals(TransNms)) {
                           speed = speed + "Update to new version: " + TransNms;
                           ClassDesc = "§4";
                           next = true;
                        }
                     } else {
                        TransNms = m[1];
                        s = m[2];
                        buttonText = JRMCoreH.Nams(m[0].toLowerCase().replace("_", ""));
                        Stats = JRMCoreH.Vers(m[0].toLowerCase().replace("_", ""));
                        if (Stats == null) {
                           Stats = TransNms;
                           ClassDesc = "§8";
                        } else if (!Stats.equals(TransNms)) {
                           speed = "Update to new version: " + TransNms;
                           ClassDesc = "§4";
                           next = true;
                        }
                     }

                     var8.func_78276_b(ClassDesc + buttonText + " v" + Stats, guiLeft + 5, guiLeft + 8 + gender * 10, 0);
                     if (next) {
                        ++gender;
                        var8.func_78276_b("  " + ClassDesc + speed, guiLeft + 5, guiLeft + 8 + gender * 10, 0);
                     }
                  }
               }
            } else {
               var8.func_78276_b("Connection Problems", guiLeft + 5, guiLeft + 8, 0);
            }
         }

         if (this.isGUIOpen(40)) {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(31, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "News"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(33, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Update"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(32, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Server"), 1));
            this.menuButtons("Server");
            boolean regen = JRMCoreConfig.regen;
            s = JRMCoreConfig.regenRate;
            COLOR_ID = JRMCoreConfig.hregen;
            mod = JRMCoreConfig.hRegenRate;
            ir = JRMCoreConfig.release;
            xPos = JRMCoreConfig.SklMedCat;
            h4 = JRMCoreConfig.SklMedRate;
            possibleReward = (int)((float)JRMCoreConfig.tpgn * JRMCoreConfig.TPGainRace[JRMCoreH.Race]);
            boolean sizes = JRMCoreConfig.sizes;
            doit = JRMCoreConfig.expGriOff;
            this.field_146292_n.add(new JRMCoreGuiButtons00(50, guiLeft + xSize / 2 - 120, guiLeft + (xSize + 1) / 2 - 75, 40, 20, "Core", 8046079));
            int k = 25;
            if (this.sip == 0) {
               var8.func_78276_b("§9" + JRMCoreH.trl("jrmc", "CoreServerConfigurations") + "§0", guiLeft + 5, guiLeft + 5 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "EnergyRegeneration") + ": §8" + (regen ? JRMCoreH.trl("jrmc", "Enabled") + ", " + JRMCoreH.trl("jrmc", "Speed") + ": " + s : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 15 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "HealthRegeneration") + ": §8" + (COLOR_ID ? JRMCoreH.trl("jrmc", "Enabled") + ", " + JRMCoreH.trl("jrmc", "Speed") + ": " + mod : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 25 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "PowerRelease") + ": §8" + (ir ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Off")), guiLeft + 5, guiLeft + 35 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "MediSkillCategory") + ": §8" + (xPos == 0 ? JRMCoreH.trl("jrmc", "Active") : JRMCoreH.trl("jrmc", "Passive")) + ", " + JRMCoreH.trl("jrmc", "Rate") + ": " + (int)(h4 * 100.0F) + "%", guiLeft + 5, guiLeft + 45 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "TrainingPointGain") + ": §8" + possibleReward, guiLeft + 5, guiLeft + 55 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "AttributeBasedSizeChange") + ": §8" + (sizes ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 65 + k, 0);
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Explosions") + ": §8" + (!doit ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 75 + k, 0);
            }

            if (JRMCoreH.DBC()) {
               this.field_146292_n.add(new JRMCoreGuiButtons00(51, guiLeft + xSize / 2 - 75, guiLeft + (xSize + 1) / 2 - 75, 40, 20, "DBC", 8046079));
               if (this.sip == 1) {
                  boolean plntVegeta = JRMCoreHDBC.DBCgetConfigplntVegeta();
                  fc = JRMCoreHDBC.DBCgetConfigflyAnyLvl();
                  cls = JRMCoreHDBC.DBCgetConfigeDBrate();
                  fcs = JRMCoreHDBC.DBCgetConfignDBrate();
                  boolean DeathSystemOff = JRMCoreHDBC.DBCgetConfigDeathSystemOff();
                  canAffordMind = JRMCoreHDBC.DBCgetConfigDBSpawnEnabled();
                  StatIncreaseDesc3 = JRMCoreHDBC.DBCgetConfigDBSpawnTime();
                  canAffordTP = JRMCoreHDBC.DBCgetConfigSagaSystemOn();
                  var8.func_78276_b("§9" + JRMCoreH.trl("dbc", "DBCServerConfigurations") + "§0", guiLeft + 5, guiLeft + 5 + k, 0);
                  var8.func_78276_b(JRMCoreH.trl("dbc", "PlanetVegeta") + ": §8" + (plntVegeta ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 15 + k, 0);
                  var8.func_78276_b(JRMCoreH.trl("dbc", "flyneedsskilllevel") + ": §8" + (fc ? "0" : "1"), guiLeft + 5, guiLeft + 25 + k, 0);
                  var8.func_78276_b(JRMCoreH.trl("dbc", "DBSpawn") + ": §8" + (canAffordMind ? StatIncreaseDesc3 + ", §0" + JRMCoreH.trl("dbc", "Earthrate") + ": §81:" + cls + " §0" + JRMCoreH.trl("dbc", "Namekrate") + ": §81:" + fcs : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 35 + k, 0);
                  var8.func_78276_b(JRMCoreH.trl("dbc", "SagaSystem") + ": §8" + (canAffordTP ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 45 + k, 0);
                  var8.func_78276_b(JRMCoreH.trl("dbc", "DeathSystem") + ": §8" + (!DeathSystemOff ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled")), guiLeft + 5, guiLeft + 55 + k, 0);
               }
            }
         } else if (this.sip != 0) {
            this.sip = 0;
         }

         if (!this.isGUIOpen(30)) {
            if (this.site != 0) {
               this.site = 0;
            }
         } else {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(33, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Update"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(32, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Server"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(31, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "News"), 1));
            this.menuButtons("News");
            ln = "Read more at JinGames.net";
            i = var8.func_78256_a(ln);
            this.field_146292_n.add(new JRMCoreGuiButtons01(199, guiLeft + 128 - i / 2, guiLeft + 5, i, ln, 16777215));
            i = 0;
            if (Version.news != null && Version.news.length() > 0) {
               List lt = mc.field_71466_p.func_78271_c(Version.news.replaceAll("/n", "\n"), 230);
               Iterator iterator = lt.iterator();
               xPos = lt.size();
               h4 = 5.0F;
               int sz = 10;
               this.scrollMouseJump = 3;
               if (xPos > sz) {
                  if ((float)xPos - h4 < (float)this.scroll) {
                     this.scroll = (int)((float)xPos - h4);
                  } else if (this.scroll < 0) {
                     this.scroll = 0;
                  }

                  if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
                     this.scroll = (int)(((float)xPos - h4) * scrollSide);
                  } else {
                     scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)xPos - h4);
                  }
               } else {
                  this.scroll = 0;
               }

               label3695:
               while(true) {
                  do {
                     do {
                        if (!iterator.hasNext()) {
                           if (i <= 13 + this.scroll && i > this.scroll) {
                              ln = "Click here to Read More";
                              i = var8.func_78256_a(ln);
                              this.field_146292_n.add(new JRMCoreGuiButtons01(199, guiLeft + 5, guiLeft + 10 + 8 + i * 10 - this.scroll * 10, i, ln, 16777215));
                           }
                           break label3695;
                        }

                        ++i;
                        Class = (String)iterator.next();
                     } while(i > this.scroll + 14);
                  } while(i <= this.scroll);

                  EnumChatFormatting col = EnumChatFormatting.BLACK;
                  if (i == 1) {
                     col = EnumChatFormatting.UNDERLINE;
                  }

                  if (i == 2) {
                     if (!Class.contains("min") && !Class.contains("hour") && !Class.contains("day")) {
                        if (Class.contains("week")) {
                           col = EnumChatFormatting.DARK_RED;
                        } else if (Class.contains("month") || Class.contains("year")) {
                           col = EnumChatFormatting.GRAY;
                        }
                     } else {
                        col = EnumChatFormatting.DARK_GREEN;
                     }
                  }

                  Matcher matcher = JRMCoreHC.paturl.matcher(Class);
                  if (matcher.find()) {
                     i = matcher.start(1);
                     costP = matcher.end();
                     urlToOpen = matcher.group();
                     i = var8.func_78256_a(Class);
                     if (Class.contains("youtu")) {
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                        TRState = JRMCoreH.tjjrmc + ":yt.png";
                        ResourceLocation tx2 = new ResourceLocation(TRState);
                        mc.field_71446_o.func_110577_a(tx2);
                        JRMCoreHC.dtr((float)(guiLeft + 5), (float)(guiLeft + 8 - 3 + i * 10 - this.scroll * 10), 0, 0, 20.0F, 15.0F, this.field_73735_i);
                     }

                     this.field_146292_n.add(new JRMCoreGuiButtons01(198, guiLeft + 25, guiLeft + 8 + i * 10 - this.scroll * 10, i, Class, JRMCoreH.techCol[1]));
                  } else {
                     var8.func_78276_b(col + Class, guiLeft + 6, guiLeft + 8 + i * 10 - this.scroll * 10, 0);
                  }
               }
            }

            if (scrollSide > 0.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110, guiLeft + (xSize + 1) / 2 - 70, "i"));
            }

            if (scrollSide < 1.0F) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110, guiLeft + (xSize + 1) / 2 + 60, "v"));
            }

            this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110, guiLeft + 25, this.mousePressed, scrollSide, 1.0F));
         }

         if (this.isGUIOpen(31)) {
            ln = "Click here to open JinGames.net";
            i = var8.func_78256_a(ln);
            this.field_146292_n.add(new JRMCoreGuiButtons01(199, guiLeft + 65, guiLeft + 5, i, ln, 16777215));
            nr = 2;
            i = nr + JRMCoreH.txt("Waiting for Server Data!", "§8", 0, true, guiLeft + 6, guiLeft + 5 + nr * 10, 0);
            i += JRMCoreH.txt("Wait for the server to send the data (should be few seconds),", "§5", 5, true, guiLeft + 6, guiLeft + 5 + i * 10, 0);
            var10000 = i + JRMCoreH.txt("IF you see this for long time the server might not have the required installed!", "§4", 0, true, guiLeft + 6, guiLeft + 5 + i * 10, 0);
         }
      }

      int i;
      int STR;
      String powerType;
      String raceName;
      boolean gn;
      int xPos;
      String Race;
      String mod;
      String[] j;
      int dmg;
      String StatIncreaseDesc4;
      String TrainingPoints;
      String RequiredTP;
      String Alignment;
      boolean upg;
      String name;
      if (this.guiID >= 60 && this.guiID <= 70) {
         xSize = 256;
         xSize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiLeft = (this.field_146295_m - xSize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiLeft, 0, 0, xSize, xSize);
         if (this.isGUIOpen(60)) {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(62, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Group") + (JRMCoreH.GMN > 1 ? " " + JRMCoreH.GMN : ""), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(61, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Side"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(60, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Main"), 1));
            this.menuButtons("Journal");
            if (this.pwr == 1) {
               this.msys("mainDBC", guiLeft + 6, guiLeft + 5);
            } else if (this.pwr == 2) {
               this.msys("mainNC", guiLeft + 6, guiLeft + 5);
            } else if (JRMCoreH.Accepted == 0) {
               i2 = JRMCoreH.txt(JRMCoreH.trl("jrmc", "selectpwratcreator"), "§8", 0, true, guiLeft + 6, guiLeft + 5, 0);
            }
         }

         if (this.isGUIOpen(61)) {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(62, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Group") + (JRMCoreH.GMN > 1 ? " " + JRMCoreH.GMN : ""), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(60, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Main"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(61, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Side"), 1));
            this.menuButtons("Journal");
            if (this.pwr != 1 && this.pwr != 2 && this.pwr != 3) {
               if (JRMCoreH.Accepted == 0) {
                  i2 = JRMCoreH.txt(JRMCoreH.trl("jrmc", "selectpwratcreator"), "§8", 0, true, guiLeft + 6, guiLeft + 5, 0);
               }
            } else if (this.SideMsn.length() >= 1) {
               if (this.site != 0) {
                  this.site = 0;
               }

               this.msys(this.SideMsn, guiLeft + 6, guiLeft + 5);
               JRMCoreMsn m = (JRMCoreMsn)JRMCoreM.missionsC.get(this.SideMsn);
               s = JRMCoreH.trl("jrmc", "Back");
               this.field_146292_n.add(new JRMCoreGuiButtons00(6002, guiLeft + xSize + 2, guiLeft + xSize + 0, this.field_146289_q.func_78256_a(s) + 8, 20, s, 0));
            } else {
               i2 = 0;
               Iterator iterator = JRMCoreM.missionsC.keySet().iterator();

               label3654:
               while(true) {
                  ArrayList d;
                  JRMCoreMsn m;
                  while(true) {
                     if (!iterator.hasNext()) {
                        if (this.site != 0) {
                           s = JRMCoreH.trl("jrmc", "Prev");
                           i = this.field_146289_q.func_78256_a(s) + 8;
                           this.field_146292_n.add(new JRMCoreGuiButtons00(41, guiLeft + xSize / 2 - 130 - i, guiLeft + xSize - 40, i, 20, s, 0));
                        }

                        if (i2 > (this.site + 1) * 14) {
                           s = JRMCoreH.trl("jrmc", "Next");
                           this.field_146292_n.add(new JRMCoreGuiButtons00(42, guiLeft + xSize / 2 + 130, guiLeft + xSize - 40, this.field_146289_q.func_78256_a(s) + 8, 20, s, 0));
                        }
                        break label3654;
                     }

                     mod = (String)iterator.next();
                     m = (JRMCoreMsn)JRMCoreM.missionsC.get(mod);
                     d = (ArrayList)JRMCoreM.missionsCD.get(mod);
                     raceName = JRMCoreH.trl((String)d.get(1));
                     if (this.pwr == 1) {
                        if (!mod.equalsIgnoreCase("mainDBC")) {
                           break;
                        }
                     } else if (this.pwr != 2 || !mod.equalsIgnoreCase("mainNC")) {
                        break;
                     }
                  }

                  Race = JRMCoreH.trl((String)d.get(5));
                  j = Race.split(",");

                  for(type = 0; type < j.length; ++type) {
                     if (j.length == 1 && j[type].length() == 0 || j[type].equalsIgnoreCase(this.pwr == 1 ? "DBC" : (this.pwr == 2 ? "NC" : (this.pwr == 3 ? "SAOC" : "MC")))) {
                        ClassDesc = JRMCoreH.trl((String)d.get(2));
                        buttonText = JRMCoreH.trl((String)d.get(3));
                        Stats = JRMCoreH.trl((String)d.get(4));
                        speed = JRMCoreH.trl((String)d.get(6));
                        TRState = d.size() > 7 ? JRMCoreH.trl((String)d.get(7)) : "";
                        TransNms = "";
                        String[] syncMdaV = JRMCoreM.getMda(JRMCoreH.MSDV, mod);
                        canAffordMind = true;
                        String[] nmd;
                        if (TRState.length() > 0) {
                           String[] sidd = TRState.split(",");

                           for(cost = 0; cost < sidd.length; ++cost) {
                              canAffordMind = JRMCoreM.isUnlocked(sidd[cost], JRMCoreH.MSD, JRMCoreH.MSDV);
                              if (!canAffordMind) {
                                 break;
                              }
                           }

                           for(cost = 0; cost < sidd.length; ++cost) {
                              canAffordMind = JRMCoreM.isUnlocked(sidd[cost], JRMCoreH.MSD, JRMCoreH.MSDV);
                              if (sidd[cost].contains(":")) {
                                 nmd = sidd[cost].split(":");
                                 ArrayList<String> dd = (ArrayList)JRMCoreM.missionsCD.get(nmd[0]);
                                 if (dd != null) {
                                    TP = JRMCoreH.trl((String)dd.get(1));
                                    if (!canAffordMind) {
                                       TransNms = TransNms + "/n" + TP + " (ID: " + nmd[1] + ")";
                                    }
                                 }
                              } else {
                                 ArrayList<String> dd = (ArrayList)JRMCoreM.missionsCD.get(sidd[cost]);
                                 if (dd != null) {
                                    Attributes = JRMCoreH.trl((String)dd.get(1));
                                    if (!canAffordMind) {
                                       TransNms = TransNms + "/n" + Attributes;
                                    }
                                 }
                              }
                           }
                        }

                        if (i2 < 14 + this.site * 14 && i2 >= 0 + this.site * 14) {
                           dmg = Integer.parseInt(speed);
                           StatIncreaseDesc4 = dmg > 0 ? "Every " + speed + " min" + (dmg > 1 ? "s" : "") : (dmg == -1 ? "No" : "Yes");
                           nmd = JRMCoreM.getMda(JRMCoreH.MSDV, mod);
                           Attributes = JRMCoreM.getSydaV(nmd, 2);
                           dmg = Integer.parseInt(Attributes) * 5;
                           TP = dmg > 0 ? JRMCoreH.trl("jrmc", "missionRepeat.wait", JRMCoreH.format_lz2(dmg / 1 % 60), JRMCoreH.format_lz2(dmg / 60 % 60), JRMCoreH.format_lz2(dmg / 3600 % 24), JRMCoreH.format_lz2(dmg / 86400)) : "";
                           TrainingPoints = dmg > 0 ? TP + "/n" : (dmg < 0 ? JRMCoreH.trl("jrmc", "missionRepeat.not") + "/n" : "");
                           RequiredTP = canAffordMind ? "" : JRMCoreH.trl("jrmc", "missionUnlock") + TransNms;
                           Alignment = dmg <= 0 && dmg >= 0 ? "" : TrainingPoints;
                           upg = !canAffordMind || dmg > 0 || dmg < 0;
                           name = upg ? JRMCoreH.cldr + "Locked!/n" + RequiredTP + Alignment : "";
                           i = var8.func_78256_a(raceName);
                           drawDetails(ClassDesc + "\n\nAuthors: " + buttonText + "\nVersion: " + Stats + "\nRepeatable: " + StatIncreaseDesc4 + "\n" + name, guiLeft + 5 + 10, guiLeft + 5 + 2 + i2 * 10 - this.site * 14 * 10, i, 8, x, y, var8);
                           STR = upg ? JRMCoreH.techCol[8] : (m.getId() > 0 ? JRMCoreH.techCol[6] : 0);
                           this.field_146292_n.add(new JRMCoreGuiButtons01MS(6001, guiLeft + 5 + 10, guiLeft + 5 + i2 * 10 - this.site * 14 * 10, this.field_146289_q.func_78256_a(raceName), raceName, STR, mod, "0"));
                        }

                        ++i2;
                     }
                  }
               }
            }
         }

         if (this.isGUIOpen(70)) {
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(60, guiLeft + xSize / 2 - 110, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Main"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(61, guiLeft + xSize / 2 - 60, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Side"), 0));
            this.field_146292_n.add(new JRMCoreGuiButtonsTab(62, guiLeft + xSize / 2 - 10, guiLeft + (xSize + 1) / 2 - 99, 60, 20, JRMCoreH.trl("jrmc", "Group") + (JRMCoreH.GMN > 1 ? " " + JRMCoreH.GMN : ""), 1));
            this.menuButtons("Group");
            if (this.pwr == 1) {
               if (JRMCoreH.GID == 0) {
                  if (JRMCoreH.GIDi.length() <= 1) {
                     this.field_146292_n.add(new JRMCoreGuiButtons00(80, guiLeft + xSize / 2 - 85, guiLeft + (xSize + 1) / 2 + 35, 170, 20, JRMCoreH.trl("jrmc", "form"), 0));
                  } else {
                     for(i2 = 0; i2 < JRMCoreH.plyrs.length; ++i2) {
                        Entity e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[i2]);
                        if (e != null && e.func_70005_c_().equalsIgnoreCase(JRMCoreH.GIDi)) {
                           mod = e.func_70005_c_();
                           mod = JRMCoreH.trl("jrmc", "recivedinv") + " " + mod;
                           var8.func_78276_b(mod, guiLeft + 5, guiLeft + 5, 0);
                           powerType = JRMCoreH.trl("jrmc", "Accept");
                           this.field_146292_n.add(new JRMCoreGuiButtons00(81, guiLeft + xSize / 2 + 10, guiLeft + (xSize + 1) / 2 - 50, this.field_146289_q.func_78256_a(powerType) + 8, 20, powerType, 0));
                           break;
                        }
                     }

                     ln = JRMCoreH.trl("jrmc", "decline");
                     this.field_146292_n.add(new JRMCoreGuiButtons00(82, guiLeft + xSize / 2 + 10, guiLeft + (xSize + 1) / 2 - 30, this.field_146289_q.func_78256_a(ln) + 8, 20, ln, 0));
                  }
               }

               if (JRMCoreH.GID != 0) {
                  EntityPlayer e;
                  if (this.inv == 3) {
                     i2 = 0;
                     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.GIDs != null) {
                        for(i = 0; i < (JRMCoreH.plyrs.length < JRMCoreH.GIDs.length ? JRMCoreH.plyrs.length : JRMCoreH.GIDs.length); ++i) {
                           if (JRMCoreH.GIDs[i] == JRMCoreH.GID) {
                              e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[i]);
                              if (e != null) {
                                 mod = e.func_70005_c_();
                                 this.field_146292_n.add(new JRMCoreGuiButtons01(-2010 - i2, guiLeft + xSize / 2 - 122, guiLeft + (xSize + 1) / 2 - 74 + i2 * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(mod), mod, 0));
                                 ++i2;
                              }
                           }
                        }
                     }
                  }

                  if (this.inv == 2) {
                     i2 = 0;
                     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.GIDs != null) {
                        for(i = 0; i < (JRMCoreH.plyrs.length < JRMCoreH.GIDs.length ? JRMCoreH.plyrs.length : JRMCoreH.GIDs.length); ++i) {
                           if (JRMCoreH.GIDs[i] == JRMCoreH.GID) {
                              e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[i]);
                              mod = JRMCoreH.plyrs[i];
                              this.field_146292_n.add(new JRMCoreGuiButtons01(-2000 - i2, guiLeft + xSize / 2 - 122, guiLeft + (xSize + 1) / 2 - 74 + i2 * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(mod), mod, e != null ? 0 : JRMCoreH.techCol[4]));
                              ++i2;
                           }
                        }
                     }
                  }

                  if (this.inv == 1) {
                     i2 = 0;
                     gn = false;
                     COLOR_ID = false;
                     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.GIDs != null) {
                        for(gender = 0; gender < (JRMCoreH.plyrs.length < JRMCoreH.GIDs.length ? JRMCoreH.plyrs.length : JRMCoreH.GIDs.length); ++gender) {
                           if (i2 <= 14 + this.ipg * 14 && i2 >= 0 + this.ipg * 14 && JRMCoreH.GIDs[gender] == 0) {
                              Entity e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[gender]);
                              if (e != null) {
                                 raceName = e.func_70005_c_();
                                 this.field_146292_n.add(new JRMCoreGuiButtons01(2000 + gender, guiLeft + xSize / 2 - 122, guiLeft + (xSize + 1) / 2 - 74 + i2 * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(raceName), raceName, 0));
                                 ++i2;
                              }
                           }
                        }
                     }

                     if (JRMCoreH.plyrs.length > 14 + this.ipg * 14) {
                        mod = JRMCoreH.trl("jrmc", "Next");
                        this.field_146292_n.add(new JRMCoreGuiButtons00(88, guiLeft + xSize / 2 + 130, guiLeft + (xSize + 1) / 2 + 15, this.field_146289_q.func_78256_a(mod) + 8, 20, mod, 0));
                     }

                     if (this.ipg != 0) {
                        mod = JRMCoreH.trl("jrmc", "Prev");
                        xPos = this.field_146289_q.func_78256_a(mod) + 8;
                        this.field_146292_n.add(new JRMCoreGuiButtons00(89, guiLeft + xSize / 2 - 130 - xPos, guiLeft + (xSize + 1) / 2 + 15, xPos, 20, mod, 0));
                     }
                  }

                  ln = JRMCoreH.trl("jrmc", "leader");
                  if (this.inv == 0) {
                     i = 0;
                     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.GIDs != null) {
                        for(i = 0; i < (JRMCoreH.plyrs.length < JRMCoreH.GIDs.length ? JRMCoreH.plyrs.length : JRMCoreH.GIDs.length); ++i) {
                           if (JRMCoreH.GIDs[i] == JRMCoreH.GID) {
                              Entity e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[i]);
                              powerType = (e != null ? "" : JRMCoreH.cldr) + JRMCoreH.plyrs[i] + (JRMCoreH.plyrs[i].equalsIgnoreCase(JRMCoreH.GLID) ? " " + JRMCoreH.cly + ln : "");
                              var8.func_78276_b(powerType, guiLeft + 5, guiLeft + 6 + i * 10, 0);
                              ++i;
                           }
                        }
                     }

                     if (mc.field_71439_g.func_70005_c_().equalsIgnoreCase(JRMCoreH.GLID)) {
                        if (JRMCoreH.GMN < 10) {
                           mod = JRMCoreH.trl("jrmc", "invite");
                           gender = this.field_146289_q.func_78256_a(mod) + 8;
                           this.field_146292_n.add(new JRMCoreGuiButtons00(83, guiLeft + xSize / 2 + 10 + 60 - gender / 2, guiLeft + (xSize + 1) / 2 - 70, this.field_146289_q.func_78256_a(mod) + 8, 20, mod, 0));
                        }

                        mod = JRMCoreH.trl("jrmc", "setleader");
                        gender = this.field_146289_q.func_78256_a(mod) + 8;
                        this.field_146292_n.add(new JRMCoreGuiButtons00(84, guiLeft + xSize / 2 + 10 + 60 - gender / 2, guiLeft + (xSize + 1) / 2 - 50 + 1, this.field_146289_q.func_78256_a(mod) + 8, 20, mod, 0));
                        powerType = JRMCoreH.trl("jrmc", "kick");
                        xPos = this.field_146289_q.func_78256_a(powerType) + 8;
                        this.field_146292_n.add(new JRMCoreGuiButtons00(85, guiLeft + xSize / 2 + 10 + 60 - xPos / 2, guiLeft + (xSize + 1) / 2 - 30 + 2, this.field_146289_q.func_78256_a(powerType) + 8, 20, powerType, 0));
                        Race = JRMCoreH.trl("jrmc", "disband");
                        possibleReward = this.field_146289_q.func_78256_a(Race) + 8;
                        this.field_146292_n.add(new JRMCoreGuiButtons00(86, guiLeft + xSize / 2 + 10 + 60 - possibleReward / 2, guiLeft + (xSize + 1) / 2 - 10 + 3, this.field_146289_q.func_78256_a(Race) + 8, 20, Race, 0));
                     }

                     mod = JRMCoreH.trl("jrmc", "leave");
                     gender = this.field_146289_q.func_78256_a(mod) + 8;
                     this.field_146292_n.add(new JRMCoreGuiButtons00(87, guiLeft + xSize / 2 + 10 + 60 - gender / 2, guiLeft + (xSize + 1) / 2 + 10 + 4, this.field_146289_q.func_78256_a(mod) + 8, 20, mod, 0));
                  }

                  if (this.inv != 0) {
                     s = JRMCoreH.trl("jrmc", "Back");
                     i = this.field_146289_q.func_78256_a(s) + 8;
                     this.field_146292_n.add(new JRMCoreGuiButtons00(90, guiLeft + xSize / 2 - 130 - i, guiLeft + (xSize + 1) / 2 + 40, i, 20, s, 0));
                  }

                  s = JRMCoreH.cldg + JRMCoreH.trl("jrmc", "msnshare");
                  i = this.field_146289_q.func_78256_a(s);
                  var8.func_78276_b(s, guiLeft + 250 - i, guiLeft + 145, 0);
               }
            } else if (JRMCoreH.Accepted == 0) {
               i2 = JRMCoreH.txt(JRMCoreH.trl("jrmc", "selectpwratcreator"), "§8", 0, true, guiLeft + 6, guiLeft + 5, 0);
            }
         }
      }

      float h2;
      float h3;
      float posXm;
      int sw;
      float posYm;
      float h4;
      String StatIncreaseDesc5;
      int sw;
      if (this.isGUIOpen(0)) {
         xSize = 256;
         xSize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiLeft = (this.field_146295_m - xSize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiLeft, 0, 0, xSize, xSize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         ln = JRMCoreH.trl("jrmc", "Next");
         i = this.field_146289_q.func_78256_a(ln) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(11, posX + 130, posY + 65, i, 20, ln, 0));
         i = JRMCoreH.dnsRace("dns");
         if (JRMCoreH.Allow(JRMCoreH.RaceAllow[RaceSlcted])) {
            CanRace = true;
         } else {
            CanRace = false;
            if (RaceSlcted != 0) {
               RaceSlcted = 0;
               JRMCoreH.Char((byte)0, (byte)RaceSlcted);
            }
         }

         if (JRMCoreH.Allow(JRMCoreH.GenderAllow[GenderSlcted]) && JRMCoreH.RaceGenders[RaceSlcted] != 1) {
            CanGender = true;
         } else {
            CanGender = false;
            if (GenderSlcted != 0) {
               GenderSlcted = 0;
            }
         }

         if (JRMCoreH.Allow("JYC")) {
            CanYears = true;
         } else {
            CanYears = false;
            if (YearsSlcted != 0) {
               YearsSlcted = 0;
            }
         }

         if (JRMCoreH.RaceCanHaveHair[RaceSlcted].contains("H")) {
            CanHair = true;
         } else {
            CanHair = false;
            if (HairSlcted != 10) {
               HairSlcted = 10;
            }
         }

         if (JRMCoreH.isRaceMajin(RaceSlcted)) {
            this.updateMajinHairToBodyColor();
            CanColor = false;
            if (HairSlcted < 10) {
               HairSlcted = 12;
               setdnsForHair();
            }
         } else if (JRMCoreH.RaceCanHaveHair[RaceSlcted].contains("H") && JRMCoreH.RaceHairColor[RaceSlcted] == -1) {
            CanColor = true;
         } else {
            ColorSlcted = JRMCoreH.RaceHairColor[RaceSlcted] != -1 ? JRMCoreH.RaceHairColor[RaceSlcted] : 0;
            CanColor = false;
         }

         if (JRMCoreH.RaceCustomSkin[RaceSlcted] == 2) {
            canCustom = true;
         } else if (JRMCoreH.RaceCustomSkin[RaceSlcted] == 1) {
            canCustom = false;
            if (SkinTypeSlcted != 1) {
               SkinTypeSlcted = 1;
               setdns();
            }
         } else {
            canCustom = false;
            if (SkinTypeSlcted != 0) {
               SkinTypeSlcted = 0;
               setdns();
            }
         }

         mod = JRMCoreH.trl("jrmc", JRMCoreH.Races[RaceSlcted]);
         powerType = JRMCoreH.trl("jrmc", JRMCoreH.Genders[GenderSlcted]);
         raceName = JRMCoreH.trl("jrmc", JRMCoreH.Years[YearsSlcted]);
         Race = JRMCoreH.trl("jrmc", "TRState");
         className = JRMCoreH.trl("jrmc", "Hair") + " " + (HairSlcted + 1);
         Class = "" + ColorSlcted;
         ClassDesc = JRMCoreH.trl("jrmc", JRMCoreH.skinTyps[SkinTypeSlcted]);
         buttonText = JRMCoreH.trl("jrmc", "Tail");
         i = 0;
         if (CanRace) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-1, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(1, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
         }

         var8.func_78276_b(mod, guiLeft + 190 - var8.func_78256_a(mod) / 2, guiLeft + 5 + i * 10, 0);
         i = i + 1;
         if (CanGender) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-2, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(2, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
            var8.func_78276_b(powerType, guiLeft + 190 - var8.func_78256_a(powerType) / 2, guiLeft + 5 + i * 10, 0);
         }

         ++i;
         if (CanHair) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-3, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(3, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
            if (HairSlcted != 12) {
               var8.func_78276_b(className, guiLeft + 190 - var8.func_78256_a(className) / 2, guiLeft + 5 + i * 10, 0);
            }

            speed = JRMCoreH.trl("jrmc", "CustomHair");
            cls = this.field_146289_q.func_78256_a(speed) / 2;
            if (HairSlcted == 12) {
               this.field_146292_n.add((new JRMCoreGuiButtons01(5100, guiLeft + 190 - cls, guiLeft + 5 + i * 10, cls, speed, JRMCoreH.techNCCol[1])).setShadow(false));
            }
         }

         ++i;
         if (CanColor) {
            speed = JRMCoreH.trl("jrmc", "Color");
            cls = this.field_146289_q.func_78256_a(speed) / 2;
            this.field_146292_n.add((new JRMCoreGuiButtons01(4, guiLeft + 190 - cls, guiLeft + 5 + i * 10, cls, speed, JRMCoreH.techNCCol[1])).setShadow(false));
         }

         if (RaceSlcted != 4 && RaceSlcted != 3) {
            h2 = (float)(ColorSlcted >> 16 & 255) / 255.0F;
            h3 = (float)(ColorSlcted >> 8 & 255) / 255.0F;
            h4 = (float)(ColorSlcted & 255) / 255.0F;
            posXm = 1.0F;
            GL11.glColor4f(posXm * h2, posXm * h3, posXm * h4, 1.0F);
            mc.field_71446_o.func_110577_a(new ResourceLocation(button1));
            this.func_73729_b(guiLeft + 190 - 25, guiLeft + 4 + i * 10, 0, 0, 50, 10);
         } else if (RaceSlcted == 4) {
            speed = Race + ": " + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", JRMCoreH.TransNms[RaceSlcted][JRMCoreH.State]);
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-4999, guiLeft + 130, guiLeft + 5 + i * 10 - 1, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(4999, guiLeft + 240, guiLeft + 5 + i * 10 - 1, ">"));
            var8.func_78276_b(speed, guiLeft + 190 - var8.func_78256_a(speed) / 2, guiLeft + 5 + i * 10, 0);
         }

         ++i;
         if (GenderSlcted == 1) {
            this.field_146292_n.add(new JRMCoreGuiSlider01(5001, guiLeft + 190 - 25, guiLeft + 4 + i * 10, 50, 10, "", (float)BreastSizeSlcted * 0.1F, 1.0F));
         }

         ++i;
         if (CanYears) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-8, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(8, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
            var8.func_78276_b(raceName, guiLeft + 190 - var8.func_78256_a(raceName) / 2, guiLeft + 5 + i * 10, 0);
         }

         ++i;
         if (RaceSlcted == 2) {
            speed = buttonText + " " + (tail ? JRMCoreH.trl("jrmc", "Enabled") : JRMCoreH.trl("jrmc", "Disabled"));
            cls = this.field_146289_q.func_78256_a(speed) / 2;
            this.field_146292_n.add((new JRMCoreGuiButtons01(106, guiLeft + 190 - cls, guiLeft + 5 + i * 10, cls, speed, tail ? 3452672 : 4210752)).setShadow(false));
         }

         ++i;
         if (canCustom) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5002, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5002, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
         }

         var8.func_78276_b(ClassDesc, guiLeft + 190 - var8.func_78256_a(ClassDesc) / 2, guiLeft + 5 + i * 10, 0);
         ++i;
         fc = false;
         if (SkinTypeSlcted == 1) {
            if (SkinTypeSlcted == 1) {
               TRState = JRMCoreH.trl("jrmc", "BodyType") + " " + (BodyTypeSlcted + 1);
               var8.func_78276_b(TRState, guiLeft + 190 - var8.func_78256_a(TRState) / 2, guiLeft + 5 + i * 10, 0);
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               ++i;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5012, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5012, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               cls = JRMCoreH.customSknLimits[RaceSlcted][1];
               if (cls >= 1) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5003, guiLeft + 190 - 10 + ((cls - 1) * -10 - (cls > 1 ? cls - 2 : 0)), guiLeft + 5 - 1 + i * 10, 20, 10, "", BodyColMainSlcted));
               }

               if (cls >= 2) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5004, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 21, guiLeft + 5 - 1 + i * 10, 20, 10, "", BodyColSub1Slcted));
               }

               if (cls >= 3) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5005, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 42, guiLeft + 5 - 1 + i * 10, 20, 10, "", BodyColSub2Slcted));
               }

               if (cls >= 4) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5014, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 63, guiLeft + 5 - 1 + i * 10, 20, 10, "", BodyColSub3Slcted));
               }

               ++i;
               fcs = i;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5006, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5006, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               s = JRMCoreH.trl("jrmc", "Nose") + " " + (FaceNoseSlcted + 1);
               var8.func_78276_b(s, guiLeft + 190 - var8.func_78256_a(s) / 2, guiLeft + 5 + i * 10, 0);
               ++i;
               s = JRMCoreH.trl("jrmc", "Mouth") + " " + (FaceMouthSlcted + 1);
               var8.func_78276_b(s, guiLeft + 190 - var8.func_78256_a(s) / 2, guiLeft + 5 + i * 10, 0);
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5007, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5007, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               ++i;
               s = JRMCoreH.trl("jrmc", "Eyes") + " " + (EyesSlcted + 1);
               var8.func_78276_b(s, guiLeft + 190 - var8.func_78256_a(s) / 2, guiLeft + 5 + i * 10, 0);
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5008, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5008, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               ++i;
               cls = JRMCoreH.customSknLimits[RaceSlcted][5];
               if (cls != 0) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5013, guiLeft + 130, guiLeft + 5 + i * 10, "<"));
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(5013, guiLeft + 240, guiLeft + 5 + i * 10, ">"));
               }

               if (cls >= 1) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5009, guiLeft + 190 - 10 + ((cls - 1) * -10 - (cls > 1 ? cls - 2 : 0)), guiLeft + 5 - 1 + i * 10, 20, 10, "", EyeCol1Slcted));
               }

               if (cls >= 2) {
                  this.field_146292_n.add(new JRMCoreGuiButtonC1(5010, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 21, guiLeft + 5 - 1 + i * 10, 20, 10, "", EyeCol2Slcted));
                  ++i;
                  s = JRMCoreH.trl("jrmc", "Match");
                  sw = this.field_146289_q.func_78256_a(s) / 2;
                  this.field_146292_n.add((new JRMCoreGuiButtons01(5011, guiLeft + 190 - sw, guiLeft + 5 + i * 10, sw, s, JRMCoreH.techNCCol[1])).setShadow(false));
               }

               ++i;
               fc = hovered(x, y, guiLeft + 130, guiLeft + 5 + fcs * 10 + 2, 120, 7 + i * 3);
            }
         } else {
            cls = JRMCoreH.customSknLimits[RaceSlcted][1];
            if (cls >= 2) {
               this.field_146292_n.add(new JRMCoreGuiButtonC1(5004, guiLeft + 190 - 10 + (cls - 0) * -10 - (cls > 1 ? cls - 1 : 0) + 21, guiLeft + 5 - 1 + i * 10, 20, 10, "", BodyColSub1Slcted));
            }
         }

         if (RaceSlcted == 1 && !tail) {
            tail = true;
            JRMCoreH.Char((byte)103, (byte)(tail ? 1 : 0));
         }

         JRMCoreClient.mc.field_71417_B.func_74374_c();
         posXm = (float)Mouse.getX() * 1.0F / ((float)JRMCoreClient.mc.field_71443_c * 1.0F);
         posYm = (float)Mouse.getY() * 1.0F / ((float)JRMCoreClient.mc.field_71440_d * 1.0F);
         var10000 = (int)((float)var6 * posXm);
         var10000 = var7 - (int)((float)var7 * posYm);
         if (fc) {
            func_110423_a(guiLeft + 51, guiLeft + 155 + 190, 180, (float)(guiLeft + 51) - this.xSize_lo, (float)(guiLeft + 80) - this.ySize_lo, mc.field_71439_g, false, false, false);
         } else {
            func_110423_a_I(guiLeft + 51, guiLeft + 155, 60, (float)(guiLeft + 51) - this.xSize_lo, (float)(guiLeft + 80) - this.ySize_lo, mc.field_71439_g);
         }

         StatIncreaseDesc5 = JRMCoreH.trl("jrmc", "Appearance");
         sw = this.field_146289_q.func_78256_a(StatIncreaseDesc5) / 2;
         var8.func_78276_b(StatIncreaseDesc5, guiLeft + 7, guiLeft + 5, 0);
      }

      ufc = false;
      byte il;
      if (this.isGUIOpen(19)) {
         xSize = 256;
         xSize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiLeft = (this.field_146295_m - xSize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiLeft, 0, 0, xSize, xSize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         ln = JRMCoreH.trl("jrmc", "Accept");
         i = this.field_146289_q.func_78256_a(ln) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(16, posX + 130, posY + 65, i, 20, ln, 0));
         COLOR_ID = false;
         il = 0;
         gender = il + 1;
         xPos = gender;
         int cls = 4;
         this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5016, guiLeft + 130, guiLeft + 5 + gender * 10, "<"));
         this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5016, guiLeft + 240, guiLeft + 5 + gender * 10, ">"));
         this.field_146292_n.add(new JRMCoreGuiButtonC1(5016, guiLeft + 190 - 10 + ((cls - 1) * -10 - (cls > 1 ? cls - 2 : 0)), guiLeft + 5 - 1 + gender * 10, 20, 10, "", BodyauColMainSlcted));
         this.field_146292_n.add(new JRMCoreGuiButtonC1(5017, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 21, guiLeft + 5 - 1 + gender * 10, 20, 10, "", BodyauColSub1Slcted));
         this.field_146292_n.add(new JRMCoreGuiButtonC1(5018, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 42, guiLeft + 5 - 1 + gender * 10, 20, 10, "", BodyauColSub2Slcted));
         this.field_146292_n.add(new JRMCoreGuiButtonC1(5019, guiLeft + 190 - 10 + (cls - 1) * -10 - (cls > 1 ? cls - 2 : 0) + 63, guiLeft + 5 - 1 + gender * 10, 20, 10, "", BodyauColSub3Slcted));
         ++gender;
         COLOR_ID = hovered(x, y, guiLeft + 130, guiLeft + 5 + xPos * 10 + 2, 120, 7 + gender * 3);
         ufc = true;
         JRMCoreClient.mc.field_71417_B.func_74374_c();
         float posXm = (float)Mouse.getX() * 1.0F / ((float)JRMCoreClient.mc.field_71443_c * 1.0F);
         float posYm = (float)Mouse.getY() * 1.0F / ((float)JRMCoreClient.mc.field_71440_d * 1.0F);
         var10000 = (int)((float)var6 * posXm);
         var10000 = var7 - (int)((float)var7 * posYm);
         if (COLOR_ID) {
            func_110423_a(guiLeft + 51, guiLeft + 155 + 190, 180, (float)(guiLeft + 51) - this.xSize_lo, (float)(guiLeft + 80) - this.ySize_lo, mc.field_71439_g, false, false, false);
         } else {
            func_110423_a_I(guiLeft + 51, guiLeft + 155, 60, (float)(guiLeft + 51) - this.xSize_lo, (float)(guiLeft + 80) - this.ySize_lo, mc.field_71439_g);
         }

         speed = JRMCoreH.trl("jrmc", "ArcosianUltimateColor");
         cls = this.field_146289_q.func_78256_a(speed) / 2;
         var8.func_78276_b(speed, guiLeft + 7, guiLeft + 5, 0);
      }

      String[] hcp = new String[]{JRMCoreH.trl("jrmc", "FrontHead"), JRMCoreH.trl("jrmc", "RightHead"), JRMCoreH.trl("jrmc", "LeftHead"), JRMCoreH.trl("jrmc", "BackHead"), JRMCoreH.trl("jrmc", "TopHead")};
      int STRo;
      int DEX;
      int DEXo;
      int WIL;
      int WILo;
      int MND;
      int MNDo;
      int CON;
      int SPI;
      int aea;
      int awa;
      int ali;
      int aea;
      int awa;
      int af;
      boolean hasWeight;
      short ySize;
      int guiTop;
      ResourceLocation guiLocation;
      int[][] cSklsLvl;
      byte i;
      String StatIncreaseDesc2;
      int lvl;
      int i;
      int nw;
      String AlignmentDesc;
      String s;
      if (this.guiID >= 20 && this.guiID <= 24) {
         this.curPage = this.guiID - 20;
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         i = 0;
         hairCheck(guiLeft + 25 - 25, guiTop + 220 + 45, 80, (float)(guiLeft + 150) - this.xSize_lo, (float)(guiTop + 80) - this.ySize_lo, (EntityLivingBase)((EntityLivingBase)(ItemBarberSnC.barberTarget == null ? mc.field_71439_g : ItemBarberSnC.barberTarget)), this.curPage);
         var8.func_78276_b(hcp[this.curPage], guiLeft + 7, guiTop + 5, 0);
         if (!headRoton) {
            powerType = JRMCoreH.trl("jrmc", "Yaw");
            xPos = this.field_146289_q.func_78256_a(powerType) + 8;
            var8.func_78276_b(powerType, guiLeft + 15 + 4, guiTop + 15 + 2 + i * 10, 0);
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5160, guiLeft + 5, guiTop + 15 + i * 11, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5161, guiLeft + 15 + xPos, guiTop + 15 + i * 11, ">"));
            ++i;
            powerType = JRMCoreH.trl("jrmc", "Pitch");
            xPos = this.field_146289_q.func_78256_a(powerType) + 8;
            var8.func_78276_b(powerType, guiLeft + 15 + 4, guiTop + 15 + 2 + i * 10, 0);
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5164, guiLeft + 5, guiTop + 15 + i * 11, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5165, guiLeft + 15 + xPos, guiTop + 15 + i * 11, ">"));
            ++i;
         }

         if (JRMCoreH.DBC()) {
            powerType = JRMCoreH.trl("jrmc", "Preview");
            xPos = this.field_146289_q.func_78256_a(powerType) + 8;
            var8.func_78276_b(powerType, guiLeft + 15 + 4, guiTop + 15 + 2 + i * 10, 0);
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5169, guiLeft + 5, guiTop + 15 + i * 11, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5168, guiLeft + 15 + xPos, guiTop + 15 + i * 11, ">"));
         }

         ++i;
         if (!headRoton) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA1(5166, guiLeft + 25, guiTop + 15 + i * 11, "x"));
         }

         this.field_146292_n.add(new JRMCoreGuiButtonsA1(5167, guiLeft + 5, guiTop + 15 + i * 11, "o"));
         cSklsLvl = new int[][]{{0, 1, 2, 3, 0, 1, 2, 0, 1, 0}, {0, 1, 2, 3, 1, 2, 3, 2, 3, 3}, {3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0}, {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3}};
         int[][] posV = new int[][]{{0, 0, 0, 0, 1, 1, 1, 2, 2, 3}, {0, 0, 0, 0, 1, 1, 1, 2, 2, 3}, {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, {3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0}};
         Class = JRMCoreH.trl("jrmc", "hairRotations");
         ClassDesc = JRMCoreH.trl("jrmc", "hairXaxis");
         buttonText = JRMCoreH.trl("jrmc", "hairYaxis");
         Stats = JRMCoreH.trl("jrmc", "hairZaxis");
         speed = JRMCoreH.trl("jrmc", "hairLength");
         TRState = JRMCoreH.trl("jrmc", "hairBend");
         TransNms = JRMCoreH.trl("jrmc", "hairBendpoint");
         s = JRMCoreH.trl("jrmc", "hairTransf");
         StatIncreaseDesc2 = JRMCoreH.trl("jrmc", "hairTier");
         StatIncreaseDesc3 = JRMCoreH.trl("jrmc", "hairTierDesc");
         StatIncreaseDesc4 = JRMCoreH.trl("jrmc", "hairHide");
         StatIncreaseDesc5 = JRMCoreH.trl("jrmc", "hairShow");
         Attributes = JRMCoreH.trl("jrmc", "hairReset");
         TP = JRMCoreH.trl("jrmc", "hairDoAllOn");
         TrainingPoints = JRMCoreH.trl("jrmc", "hairDoAllDesc");
         RequiredTP = JRMCoreH.trl("jrmc", "hairDoAllOff");
         if (dnsH.length() != 786) {
            powerType = JRMCoreH.trl("jrmc", "BaseHair");
            xPos = this.field_146289_q.func_78256_a(powerType) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(5199, guiLeft - 2 - xPos, guiTop + 10, xPos, 20, powerType, 0));
         } else {
            lvl = this.hcl[this.curPage] * 10;
            i = 0;
            nw = 0;
            i = 0;

            for(STR = this.hcl[this.curPage]; STR < this.hcl[this.curPage + 1]; ++STR) {
               STRo = JRMCoreH.dnsHair2(dnsH, STR * 14);
               DEX = JRMCoreH.dnsHair2(dnsH, STR * 14 + 2);
               DEXo = JRMCoreH.dnsHair2(dnsH, STR * 14 + 4);
               WIL = JRMCoreH.dnsHair2(dnsH, STR * 14 + 6);
               WILo = JRMCoreH.dnsHair2(dnsH, STR * 14 + 8);
               MND = JRMCoreH.dnsHair2(dnsH, STR * 14 + 10);
               MNDo = JRMCoreH.dnsHair2(dnsH, STR * 14 + 12);
               DEX = DEX > 82 ? 82 : (DEX < 18 ? 18 : DEX);
               DEXo = DEXo > 82 ? 82 : (DEXo < 18 ? 18 : DEXo);
               WIL = WIL > 82 ? 82 : (WIL < 18 ? 18 : WIL);
               WILo = WILo > 82 ? 82 : (WILo < 18 ? 18 : WILo);
               MND = MND > 82 ? 82 : (MND < 18 ? 18 : MND);
               MNDo = MNDo > 82 ? 82 : (MNDo < 18 ? 18 : MNDo);
               CON = DEX - 50;
               SPI = DEXo - 50;
               aea = WIL - 50;
               awa = WILo - 50;
               ali = MND - 50;
               aea = MNDo - 50;
               awa = (int)((float)STRo / 2.8F) + 1;
               DEX = (int)((float)(DEX - 18) * 1.56F);
               DEXo = (int)((float)(DEXo - 18) * 1.56F);
               WIL = (int)((float)(WIL - 18) * 1.56F);
               WILo = (int)((float)(WILo - 18) * 1.56F);
               MND = (int)((float)(MND - 18) * 1.56F);
               MNDo = (int)((float)(MNDo - 18) * 1.56F);
               af = this.curPage == 0 ? i : cSklsLvl[this.curPage - 1][i];
               int pV = this.curPage == 0 ? nw : posV[this.curPage - 1][i];
               hasWeight = this.hbt == null || this.hbt[STR] == 0;
               if (hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 0 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)DEX * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 1\n " + Class + "\n " + ClassDesc + ": " + CON), guiLeft + 80 + 0 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               if (hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 7 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)DEXo * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 1\n " + Class + "\n " + buttonText + ": " + SPI), guiLeft + 80 + 7 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               if (hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 14 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)WIL * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 1\n " + Class + "\n " + Stats + ": " + aea), guiLeft + 80 + 14 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               if (hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 21 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)STRo * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 1\n " + speed + ": " + awa), guiLeft + 80 + 21 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5200 + lvl, guiLeft + 80 + 28 + af * 45, guiTop + 5 + pV * 38, STRo != 0 ? "o" : "<"));
               drawDetails(JRMCoreH.cldgy + JRMCoreH.cct((STRo != 0 ? StatIncreaseDesc4 : StatIncreaseDesc5) + "\n" + STR), guiLeft + 80 + 28 + af * 45, guiTop + 5 + pV * 38 + 2, 10, 9, x, y, this.field_146289_q);
               ++lvl;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(5200 + lvl, guiLeft + 80 + 28 + af * 45, guiTop + 31 + pV * 38, "x"));
               drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(Attributes), guiLeft + 80 + 28 + af * 45, guiTop + 31 + pV * 38 + 2, 10, 9, x, y, this.field_146289_q);
               ++lvl;
               if (STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(5200 + lvl, guiLeft + 80 + 28 + af * 45, guiTop + 18 + pV * 38, hasWeight ? "(|)" : "(||)"));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct((hasWeight ? StatIncreaseDesc2 + " 1" : StatIncreaseDesc2 + " 2") + "\n" + StatIncreaseDesc3), guiLeft + 80 + 28 + af * 45, guiTop + 18 + pV * 38 + 2, 10, 9, x, y, this.field_146289_q);
               }

               ++lvl;
               if (!hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 0 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)WILo * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 2\n " + TRState + ": " + awa), guiLeft + 80 + 0 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               if (!hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 7 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)MND * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 2\n " + TransNms + ": " + ali), guiLeft + 80 + 7 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               if (!hasWeight && STRo != 0) {
                  this.field_146292_n.add(new JRMCoreGuiSlider02(5200 + lvl, guiLeft + 80 + 14 + af * 45, guiTop + 5 + pV * 38, 5, 35, "", (float)MNDo * 0.01F, 1.0F, this.dfa[this.curPage] == 1 && i == 0 ? 14737632 : 0));
                  drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(StatIncreaseDesc2 + " 2\n " + s + ": " + aea), guiLeft + 80 + 14 + af * 45, guiTop + 5 + pV * 38 + 2, 5, 35, x, y, this.field_146289_q);
               }

               ++lvl;
               ++i;
               ++i;
               if (i > 3) {
                  ++nw;
               }

               i = i > 3 ? 0 : i;
            }

            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5999, guiLeft + 80 - 12, guiTop + 5, this.dfa[this.curPage] != 0 ? "o" : ">"));
            drawDetails(JRMCoreH.cldgy + JRMCoreH.cct((this.dfa[this.curPage] != 0 ? TP : RequiredTP) + "\n" + TrainingPoints), guiLeft + 80 - 12, guiTop + 5 + 1, 10, 9, x, y, this.field_146289_q);
            ++lvl;
         }

         if (this.curPage == 0) {
            if (!canSavePreset) {
               canSavePreset = true;
            }

            Iterator var232 = PresetList.iterator();

            while(var232.hasNext()) {
               AlignmentDesc = (String)var232.next();
               if (AlignmentDesc.equals(dnsH)) {
                  canSavePreset = false;
               }
            }

            i = 0;
            Alignment = JRMCoreH.trl("jrmc", "Preset") + " " + HairPrstsSlcted;
            i = this.field_146289_q.func_78256_a(Alignment);
            var8.func_78276_b(Alignment, guiLeft + 5 + 70 + 4, guiTop + 5 + 50 + i * 11, 0);
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-5155, guiLeft + 5 + 70 - 7, guiTop + 5 + 50 - 2 + i * 11, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(5155, guiLeft + 5 + 70 + 4 + i, guiTop + 5 + 50 - 2 + i * 11, ">"));
            var8.func_78276_b("G" + JRMCoreH.dnsHairG((String)PresetList.get(HairPrstsSlcted)), guiLeft + 5 + 70 + 4 + i + 12, guiTop + 5 + 50 + i * 11, 0);
            i = i + 1;
            Alignment = JRMCoreH.trl("jrmc", "SavePreset");
            i = this.field_146289_q.func_78256_a(Alignment) / 2;
            if (canSavePreset) {
               this.field_146292_n.add((new JRMCoreGuiButtons01(5156, guiLeft + 5 + 70, guiTop + 5 + 50 + i * 11, i, Alignment, JRMCoreH.techNCCol[1])).setShadow(false));
               ++i;
            }

            Alignment = JRMCoreH.trl("jrmc", "DelPreset");
            i = this.field_146289_q.func_78256_a(Alignment) / 2;
            if (HairPrstsSlcted > JRMCoreH.defHairPrsts.length - 1) {
               this.field_146292_n.add((new JRMCoreGuiButtons01(5157, guiLeft + 5 + 70, guiTop + 5 + 60 + i * 11, i, Alignment, JRMCoreH.techNCCol[1])).setShadow(false));
               ++i;
            }
         }

         powerType = JRMCoreH.trl("jrmc", "Back");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         if (this.curPage != 0) {
            this.field_146292_n.add(new JRMCoreGuiButtons00(5151, guiLeft - 2 - xPos, guiTop + 120, xPos, 20, powerType, 0));
         }

         powerType = JRMCoreH.trl("jrmc", "Next");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         if (this.curPage < hcp.length - 1) {
            this.field_146292_n.add(new JRMCoreGuiButtons00(5150, guiLeft + 258, guiTop + 120, xPos, 20, powerType, 0));
         }

         powerType = JRMCoreH.trl("jrmc", "Done");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(5152, guiLeft + 258, guiTop + 145, xPos, 20, powerType, 0));
         Alignment = JRMCoreH.trl("jrmc", "HairSalonDesc");
         AlignmentDesc = JRMCoreH.trl("jrmc", "HairShareDesc");
         name = JRMCoreH.trl("jrmc", "HairPasteDesc");
         s = JRMCoreH.trl("jrmc", "HairResetDesc");
         i = 0;
         powerType = JRMCoreH.trl("jrmc", "HairSalon");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(5159, guiLeft + 258, guiTop + i * 25, xPos, 20, powerType, 0));
         drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(Alignment), guiLeft + 258, guiTop + i * 25 + 2, xPos, 20, x, y, this.field_146289_q);
         i = i + 1;
         powerType = JRMCoreH.trl("jrmc", "Share");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(5153, guiLeft + 258, guiTop + i * 25, xPos, 20, powerType, 0));
         drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(AlignmentDesc), guiLeft + 258, guiTop + i * 25 + 2, xPos, 20, x, y, this.field_146289_q);
         ++i;
         powerType = JRMCoreH.trl("jrmc", "Paste");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(5154, guiLeft + 258, guiTop + i * 25, xPos, 20, powerType, 0));
         drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(name), guiLeft + 258, guiTop + i * 25 + 2, xPos, 20, x, y, this.field_146289_q);
         ++i;
         powerType = JRMCoreH.trl("jrmc", "Reset");
         xPos = this.field_146289_q.func_78256_a(powerType) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(5158, guiLeft + 258, guiTop + i * 25, xPos, 20, powerType, 0));
         drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(s), guiLeft + 258, guiTop + i * 25 + 2, xPos, 20, x, y, this.field_146289_q);
         ++i;
      }

      String StatIncreaseDescVit;
      float h2;
      float h3;
      byte i;
      String[] techAcquired;
      int[][] SklsMR;
      int ni;
      String[] techName;
      int[][] rSklsLvl;
      float cool;
      String StatIncreaseDescStr;
      int stat;
      int costTp;
      String statNam;
      String nameEffect;
      String tt;
      if (this.isGUIOpen(1)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         gn = false;

         for(i = 0; i < 128; ++i) {
            for(gender = 0; gender < 128; ++gender) {
               Color i = Color.getHSBColor((float)i * 2.0F / 255.0F, (float)gender * 2.0F / 255.0F, BrghtSlcted);
               xPos = i.getRed() * 65536 + i.getGreen() * 256 + i.getBlue();
               if (colorType == 5015 && xPos == 0) {
                  i = 11075583;
                  if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
                     i = 14526719;
                  }

                  if (JRMCoreH.align < 33) {
                     i = 16646144;
                  }

                  this.field_146292_n.add(new JRMCoreGuiButtonC(-4, guiLeft + 5 + i, guiTop + 5 + gender, 1, 1, "", xPos, i));
               } else {
                  this.field_146292_n.add(new JRMCoreGuiButtonC(-4, guiLeft + 5 + i, guiTop + 5 + gender, 1, 1, "", xPos));
               }
            }
         }

         if (colorType == 5015 && BrghtSlcted == 0.0F) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "AlignmentBased"), guiLeft + 5, guiTop + 140, 0);
         }

         this.field_146292_n.add(new JRMCoreGuiSlider00(20, guiLeft + 135, guiTop + 5, "", BrghtSlcted, 1.0F));
         i = 0;
         if (this.inputField2Cl == 4) {
            i = ColorSlcted;
         } else if (this.inputField2Cl == 5015) {
            i = KiColorSlcted;
         } else if (this.inputField2Cl == 5003) {
            i = BodyColMainSlcted;
         } else if (this.inputField2Cl == 5004) {
            i = BodyColSub1Slcted;
         } else if (this.inputField2Cl == 5005) {
            i = BodyColSub2Slcted;
         } else if (this.inputField2Cl == 5014) {
            i = BodyColSub3Slcted;
         } else if (this.inputField2Cl == 5009) {
            i = EyeCol1Slcted;
         } else if (this.inputField2Cl == 5010) {
            i = EyeCol2Slcted;
         } else if (this.inputField2Cl == 5016) {
            i = BodyauColMainSlcted;
         } else if (this.inputField2Cl == 5017) {
            i = BodyauColSub1Slcted;
         } else if (this.inputField2Cl == 5018) {
            i = BodyauColSub2Slcted;
         } else if (this.inputField2Cl == 5019) {
            i = BodyauColSub3Slcted;
         }

         float h2 = (float)(i >> 16 & 255) / 255.0F;
         h2 = (float)(i >> 8 & 255) / 255.0F;
         h3 = (float)(i & 255) / 255.0F;
         h4 = 1.0F;
         GL11.glColor4f(h4 * h2, h4 * h2, h4 * h3, 1.0F);
         mc.field_71446_o.func_110577_a(new ResourceLocation(button1));
         this.func_73729_b(guiLeft + 180, guiTop + 65, 0, 0, 50, 10);
         techTypes = new String[]{"Red", "Green", "Blue"};

         for(gender = 0; gender < this.inputField2.length; ++gender) {
            powerType = techTypes[gender] + ":";
            xPos = this.field_146289_q.func_78256_a(powerType) / 2;
            var8.func_78276_b(powerType, guiLeft + 158, guiTop + 15 + gender * 15, 0);
            this.nametf(var8, gender, 0, 0);
            if (this.inputField2[gender] != null) {
               this.inputField2[gender].field_146209_f = guiLeft + 195;
               this.inputField2[gender].field_146210_g = guiTop + 15 + gender * 15;
               this.inputField2[gender].func_146194_f();
            }
         }

         mod = "Get RGB Color";
         xPos = this.field_146289_q.func_78256_a(mod) / 2;
         this.field_146292_n.add((new JRMCoreGuiButtons01(33000, guiLeft + 205 - xPos, guiTop + 80, xPos, mod, JRMCoreH.techNCCol[1])).setShadow(false));
         mod = JRMCoreH.trl("jrmc", "Back");
         xPos = this.field_146289_q.func_78256_a(mod) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(0, posX - 130 - xPos, posY + 65, xPos, 20, mod, 0));
      } else if (this.isGUIOpen(2)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         s = JRMCoreH.trl("jrmc", "Back");
         i = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(0, posX - 130 - i, posY + 65, i, 20, s, 0));
         s = JRMCoreH.trl("jrmc", "Next");
         i = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(12, posX + 130, posY + 65, i, 20, s, 0));
         if (JRMCoreH.Allow(JRMCoreH.PwrtypAllow[PwrtypSlcted])) {
            CanPwr = true;
         } else {
            PwrtypSlcted = 0;
            CanPwr = false;
         }

         if (JRMCoreH.Allow(JRMCoreH.PwrtypAllow[PwrtypSlcted]) && PwrtypSlcted != 3) {
            CanClass = true;
         } else {
            ClassSlcted = 0;
            CanClass = false;
         }

         if (cl().length - 1 < ClassSlcted) {
            ClassSlcted = 0;
         }

         if (!JRMCoreH.RaceCanHavePwr[RaceSlcted].contains("" + PwrtypSlcted)) {
            PwrtypSlcted = Slct("B", PwrtypSlcted, JRMCoreH.PwrtypAllow);
         }

         mod = JRMCoreH.trl("jrmc", JRMCoreH.Pwrtyps[PwrtypSlcted]);
         powerType = JRMCoreH.trl("jrmc", cl()[ClassSlcted]);
         raceName = JRMCoreH.trl("jrmc", clDesc()[ClassSlcted]);
         Race = JRMCoreH.trl("jrmc", "Stats");
         className = JRMCoreH.trl("jrmc", "StatIncreaseDesc");
         Class = JRMCoreH.trl("jrmc", "StartAttr");
         var8.func_78276_b(JRMCoreH.trl("jrmc", "PowerType"), guiLeft + 5, guiTop + 5, 0);
         int i = 1;
         if (CanPwr) {
            boolean yes = false;
            if (!JRMCoreH.DBC() && !JRMCoreH.NC()) {
               if (JRMCoreH.SAOC()) {
                  yes = true;
               }
            } else {
               yes = true;
            }

            if (yes) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(-6, guiLeft + 130 - 125, guiTop + 4 + i * 10, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(6, guiLeft + 240 - 125, guiTop + 4 + i * 10, ">"));
            }

            Stats = JRMCoreH.trl(PwrtypSlcted == 3 ? "saoc" : "jrmc", JRMCoreH.PwrtypDesc[PwrtypSlcted]);
            costP = var8.func_78256_a(mod);
            cls = guiLeft + 64 - costP / 2;
            fcs = guiTop + 5 + i * 10;
            drawDetails(mod, Stats, cls, fcs, x, y, var8);
         }

         reward = i + 1;
         if (CanClass) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-7, guiLeft + 130 - 125, guiTop + 4 + reward * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(7, guiLeft + 240 - 125, guiTop + 4 + reward * 10, ">"));
            owner = var8.func_78256_a(powerType);
            i = guiLeft + 64 - owner / 2;
            costP = guiTop + 5 + reward * 10;
            drawDetails(powerType, raceName, i, costP, x, y, var8);
         }

         ++reward;
         if (PwrtypSlcted == 1) {
            owner = KiColorSlcted > 0 ? KiColorSlcted : 11075583;
            float h2 = (float)(owner >> 16 & 255) / 255.0F;
            h2 = (float)(owner >> 8 & 255) / 255.0F;
            h3 = (float)(owner & 255) / 255.0F;
            h4 = 1.0F;
            GL11.glColor4f(h4 * h2, h4 * h2, h4 * h3, 1.0F);
            mc.field_71446_o.func_110577_a(new ResourceLocation(button1));
            this.func_73729_b(guiLeft + 64 - 50 + 1, guiTop + 4 + reward * 10, 0, 0, 100, 10);
            s = JRMCoreH.trl("jrmc", "AuraColor");
            sw = this.field_146289_q.func_78256_a(s) / 2;
            this.field_146292_n.add((new JRMCoreGuiButtons01(5015, guiLeft + 64 - sw, guiTop + 5 + reward * 10, sw, s, JRMCoreH.techNCCol[1])).setShadow(false));
         }

         ++reward;
         var8.func_78276_b(Race, guiLeft + 5, guiTop + 5 + reward * 10, 0);
         var8.func_78276_b(Class, guiLeft + 5 + 128, guiTop + 5 + reward * 10, 0);
         ++reward;
         owner = JRMCoreH.attributeStart(PwrtypSlcted, 0, RaceSlcted, ClassSlcted);
         i = JRMCoreH.attributeStart(PwrtypSlcted, 1, RaceSlcted, ClassSlcted);
         costP = JRMCoreH.attributeStart(PwrtypSlcted, 2, RaceSlcted, ClassSlcted);
         cls = JRMCoreH.attributeStart(PwrtypSlcted, 3, RaceSlcted, ClassSlcted);
         fcs = JRMCoreH.attributeStart(PwrtypSlcted, 4, RaceSlcted, ClassSlcted);
         ni = JRMCoreH.attributeStart(PwrtypSlcted, 5, RaceSlcted, ClassSlcted);
         float inc;
         if (PwrtypSlcted != 1 && PwrtypSlcted != 2) {
            if (PwrtypSlcted == 3) {
               sw = JRMCoreH.stat(mc.field_71439_g, 0, PwrtypSlcted, 0, owner, RaceSlcted, ClassSlcted, 0.0F);
               dmg = (int)JRMCoreH.statInc[PwrtypSlcted][0];
               StatIncreaseDesc4 = JRMCoreH.trl("saoc", JRMCoreH.attrStat[PwrtypSlcted][0]);
               StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
               Attributes = "STR";
               drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, dmg), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
               TP = JRMCoreH.cldgy + "STR: " + JRMCoreH.cldr + owner;
               TrainingPoints = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[PwrtypSlcted][0]);
               drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
               ++reward;
               sw = JRMCoreH.stat(mc.field_71439_g, 2, PwrtypSlcted, 2, costP, RaceSlcted, ClassSlcted, 0.0F);
               dmg = (int)JRMCoreH.statInc[PwrtypSlcted][2];
               StatIncreaseDesc4 = JRMCoreH.trl("saoc", JRMCoreH.attrStat[PwrtypSlcted][2]);
               StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
               Attributes = "VIT";
               drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, dmg), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
               TP = JRMCoreH.cldgy + "AGI: " + JRMCoreH.cldr + i;
               TrainingPoints = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[PwrtypSlcted][1]);
               drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
               ++reward;
               TP = JRMCoreH.cldgy + "VIT: " + JRMCoreH.cldr + costP;
               TrainingPoints = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[PwrtypSlcted][2]);
               drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
               ++reward;
            } else {
               sw = JRMCoreH.stat(mc.field_71439_g, 0, PwrtypSlcted, 0, owner, RaceSlcted, ClassSlcted, 0.0F);
               inc = JRMCoreH.statInc[PwrtypSlcted][0];
               StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][0]);
               StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
               Attributes = "STR";
               drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
               TP = JRMCoreH.cldgy + "STR: " + JRMCoreH.cldr + owner;
               TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][0]);
               drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
               ++reward;
               sw = JRMCoreH.stat(mc.field_71439_g, 2, PwrtypSlcted, 2, costP, RaceSlcted, ClassSlcted, 0.0F);
               inc = JRMCoreH.statInc[PwrtypSlcted][2];
               StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][2]);
               StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
               Attributes = "CON";
               drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
               TP = JRMCoreH.cldgy + "CON: " + JRMCoreH.cldr + costP;
               TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][2]);
               drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
               ++reward;
            }
         } else {
            sw = JRMCoreH.stat(mc.field_71439_g, 0, PwrtypSlcted, 0, owner, RaceSlcted, ClassSlcted, 0.0F);
            inc = JRMCoreH.statInc(PwrtypSlcted, 0, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][0]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "STR";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "STR: " + JRMCoreH.cldr + owner;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][0]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
            sw = JRMCoreH.stat(mc.field_71439_g, 1, PwrtypSlcted, 1, i, RaceSlcted, ClassSlcted, 0.0F);
            inc = JRMCoreH.statInc(PwrtypSlcted, 1, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][1]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "DEX";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "DEX: " + JRMCoreH.cldr + i;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][1]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
            sw = JRMCoreH.stat(mc.field_71439_g, 2, PwrtypSlcted, 2, costP, RaceSlcted, ClassSlcted, 0.0F);
            inc = JRMCoreH.statInc(PwrtypSlcted, 2, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][2]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "CON";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "CON: " + JRMCoreH.cldr + costP;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][2]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
            sw = JRMCoreH.stat(mc.field_71439_g, 2, PwrtypSlcted, 3, costP, RaceSlcted, ClassSlcted, 0.0F);
            inc = JRMCoreH.statInc(PwrtypSlcted, 3, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][3]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "CON";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "WIL: " + JRMCoreH.cldr + cls;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][3]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
            sw = JRMCoreH.stat(mc.field_71439_g, 3, PwrtypSlcted, 4, cls, RaceSlcted, ClassSlcted, 0.0F);
            inc = JRMCoreH.statInc(PwrtypSlcted, 4, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][4]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "WIL";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "MND: " + JRMCoreH.cldr + fcs;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][4]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
            sw = JRMCoreH.stat(mc.field_71439_g, 5, PwrtypSlcted, 5, ni, RaceSlcted, ClassSlcted, JRMCoreH.SklLvl_KiBs(this.pwr));
            inc = JRMCoreH.statInc(PwrtypSlcted, 5, 1, RaceSlcted, ClassSlcted, 0.0F);
            StatIncreaseDesc4 = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[PwrtypSlcted][5]);
            StatIncreaseDesc5 = JRMCoreH.cldgy + StatIncreaseDesc4 + ": " + JRMCoreH.cldr + sw;
            Attributes = "SPI";
            drawDetails(StatIncreaseDesc5, JRMCoreH.cct(className, Attributes, inc), guiLeft + 5, guiTop + 5 + reward * 10, x, y, var8);
            TP = JRMCoreH.cldgy + "SPI: " + JRMCoreH.cldr + ni;
            TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[PwrtypSlcted][5]);
            drawDetails(TP, TrainingPoints, guiLeft + 5 + 128, guiTop + 5 + reward * 10, x, y, var8);
            ++reward;
         }
      } else if (this.isGUIOpen(3)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         s = JRMCoreH.trl("jrmc", "Back");
         i = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(11, posX - 130 - i, posY + 65, i, 20, s, 0));
         s = JRMCoreH.trl("jrmc", "Accept");
         i = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(13, posX + 130, posY + 65, i, 20, s, 0));
         mod = JRMCoreH.trl("jrmc", JRMCoreH.Races[RaceSlcted]);
         powerType = JRMCoreH.trl("jrmc", JRMCoreH.Genders[GenderSlcted]);
         raceName = JRMCoreH.trl("jrmc", "Hair") + " " + (HairSlcted + 1);
         Race = "" + ColorSlcted;
         className = JRMCoreH.trl("jrmc", "BodyType") + " " + (BodyTypeSlcted + 1);
         Class = JRMCoreH.trl("jrmc", JRMCoreH.Pwrtyps[PwrtypSlcted]);
         ClassDesc = JRMCoreH.trl("jrmc", cl()[ClassSlcted]);
         buttonText = JRMCoreH.trl("jrmc", JRMCoreH.ClassNames[PwrtypSlcted]);
         Stats = JRMCoreH.trl("jrmc", JRMCoreH.skinTyps[SkinTypeSlcted]);
         int i = 0;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "Race") + ": " + mod, guiLeft + 5, guiTop + 5 + i * 10, 0);
         costP = i + 1;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "Gender") + ": " + powerType, guiLeft + 5, guiTop + 5 + costP * 10, 0);
         ++costP;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "Hair") + ": " + raceName, guiLeft + 5, guiTop + 5 + costP * 10, 0);
         ++costP;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "Color") + ": ", guiLeft + 5, guiTop + 5 + costP * 10, 0);
         ++costP;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "BodyType") + ": " + Stats, guiLeft + 5, guiTop + 5 + costP * 10, 0);
         ++costP;
         var8.func_78276_b(JRMCoreH.trl("jrmc", "PowerType") + ": " + Class, guiLeft + 5, guiTop + 5 + costP * 10, 0);
         ++costP;
         if (PwrtypSlcted != 3) {
            var8.func_78276_b(buttonText + ": " + ClassDesc, guiLeft + 5, guiTop + 5 + costP * 10, 0);
         }

         ++costP;
         h3 = (float)(ColorSlcted >> 16 & 255) / 255.0F;
         h4 = (float)(ColorSlcted >> 8 & 255) / 255.0F;
         posXm = (float)(ColorSlcted & 255) / 255.0F;
         posYm = 1.0F;
         GL11.glColor4f(posYm * h3, posYm * h4, posYm * posXm, 1.0F);
         mc.field_71446_o.func_110577_a(new ResourceLocation(button1));
         this.func_73729_b(guiLeft + 5 + var8.func_78256_a("Color: "), guiTop + 3 + 30, 0, 0, 50, 10);
         dmg = guiLeft + xSize / 2;
         func_110423_a_I(dmg + 51, guiTop + 155, 60, (float)(dmg + 51) - this.xSize_lo, (float)(guiTop + 120 - 40) - this.ySize_lo, mc.field_71439_g);
      } else if (this.isGUIOpen(8)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         i = 0;
         if (CanHair) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(-15, guiLeft + 130, guiTop + 5 + i * 10, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(15, guiLeft + 240, guiTop + 5 + i * 10, ">"));
            i = i + 1;
         } else {
            i = i + 1;
         }

         if (CanColor) {
            mod = JRMCoreH.trl("jrmc", "Color");
            gender = this.field_146289_q.func_78256_a(mod) / 2;
            this.field_146292_n.add((new JRMCoreGuiButtons01(4, guiLeft + 190 - gender, guiTop + 5 + i * 10, gender, mod, JRMCoreH.techNCCol[1])).setShadow(false));
         }

         ++i;
         if (JRMCoreH.isRaceMajin(RaceSlcted)) {
            BodyColMainSlcted = JRMCoreH.dnsBodyCM(dns);
            this.updateMajinHairToBodyColor();
            CanColor = false;
            if (HairSlcted < 10) {
               HairSlcted = 12;
               setdnsForHair();
            }
         } else if (JRMCoreH.RaceCanHaveHair[RaceSlcted].contains("H") && JRMCoreH.RaceHairColor[RaceSlcted] == -1) {
            CanColor = true;
         } else {
            ColorSlcted = JRMCoreH.RaceHairColor[RaceSlcted] != -1 ? JRMCoreH.RaceHairColor[RaceSlcted] : 0;
            CanColor = false;
         }

         mod = JRMCoreH.trl("jrmc", "Hair") + " " + (HairSlcted + 1);
         mod = "" + ColorSlcted;
         i = 0;
         if (CanHair) {
            if (HairSlcted != 12) {
               var8.func_78276_b(mod, guiLeft + 190 - var8.func_78256_a(mod) / 2, guiTop + 5 + i * 10, 0);
            }

            powerType = JRMCoreH.trl("jrmc", "CustomHair");
            xPos = this.field_146289_q.func_78256_a(powerType) / 2;
            if (HairSlcted == 12) {
               this.field_146292_n.add((new JRMCoreGuiButtons01(5100, guiLeft + 190 - xPos, guiTop + 5 + i * 10, xPos, powerType, JRMCoreH.techNCCol[1])).setShadow(false));
            }
         }

         i = i + 1;
         if (CanColor) {
            h2 = (float)(ColorSlcted >> 16 & 255) / 255.0F;
            h3 = (float)(ColorSlcted >> 8 & 255) / 255.0F;
            h4 = (float)(ColorSlcted & 255) / 255.0F;
            float h1 = 1.0F;
            GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, 1.0F);
            mc.field_71446_o.func_110577_a(new ResourceLocation(button1));
            this.func_73729_b(guiLeft + 190 - 25, guiTop + 4 + i * 10, 0, 0, 50, 10);
         }

         ++i;
         func_110423_a(guiLeft + 51, guiTop + 155, 60, (float)(guiLeft + 51) - this.xSize_lo, (float)(guiTop + 80) - this.ySize_lo, (EntityLivingBase)((EntityLivingBase)(ItemBarberSnC.barberTarget == null ? mc.field_71439_g : ItemBarberSnC.barberTarget)));
         if (!CanHair) {
            Race = JRMCoreH.trl("jrmc", "NoHairToEdit");
            possibleReward = this.field_146289_q.func_78256_a(Race) / 2;
            var8.func_78276_b(Race, guiLeft + 10, guiTop + 15, 0);
         }

         Race = JRMCoreH.trl("jrmc", "BarberMenu");
         possibleReward = this.field_146289_q.func_78256_a(Race) / 2;
         var8.func_78276_b(Race, guiLeft + 7, guiTop + 5, 0);
         Class = JRMCoreH.trl("jrmc", "Revert");
         reward = this.field_146289_q.func_78256_a(Class) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(-14, posX - 130 - reward, posY + 65, reward, 20, Class, 0));
         Class = JRMCoreH.trl("jrmc", "Done");
         reward = this.field_146289_q.func_78256_a(Class) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(14, posX + 130, posY + 65, reward, 20, Class, 0));
      } else if (this.isGUIOpen(10000)) {
         this.drawHUD_clntsett(posX, posY, var5, var6, var8);
      } else if (this.isGUIOpen(10001)) {
         this.drawHUD_help(posX, posY, var5, var6, var8);
      } else if (this.isGUIOpen(10011)) {
         JGNotificationGUI.update(this.field_146292_n, this.field_146294_l, this.field_146295_m, posX, posY, var5, var6, var8);
      } else if (this.isGUIOpen(14)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         s = JRMCoreH.trl("jrmc", "Back");
         i = this.field_146289_q.func_78256_a(s) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(100, posX - 130 - i, posY + 65, i, 20, s, 0));
         var8.func_78276_b(JRMCoreH.trl("jrmc", "SelectedDifficulty") + ": " + JRMCoreH.DifficultyNames[this.diff], guiLeft + 5, guiTop + 5, 0);
         gender = 0;
         xPos = 8046079;
         i = JRMCoreH.Dffclty;

         for(limit = 0; limit < JRMCoreH.DifficultyNames.length; ++limit) {
            gender += 2;
            if (i == limit) {
               xPos = 3452672;
            } else {
               xPos = 8046079;
            }

            if (i > limit) {
               xPos = 4210752;
            }

            this.field_146292_n.add(new JRMCoreGuiButtons00(-101 - limit, posX - 120, posY - 86 + gender * 10, 60, 20, JRMCoreH.trl("jrmc", JRMCoreH.DifficultyNames[limit]), xPos));
            possibleReward = JRMCoreH.expgnrt(JRMCoreH.Race, JRMCoreH.State, limit, mc.field_71439_g);
            Iterator iterator = mc.field_71466_p.func_78271_c(JRMCoreH.cct(JRMCoreH.trl("jrmc", JRMCoreH.DifficultyDesc[limit]), possibleReward + "%"), 245).iterator();

            while(iterator.hasNext()) {
               ++gender;
               ClassDesc = (String)iterator.next();
               var8.func_78276_b("§0" + ClassDesc, guiLeft + 6, guiTop + 5 + gender * 10, 0);
            }
         }

         if (i < this.diff) {
            this.field_146292_n.add(new JRMCoreGuiButtons00(-104, posX + 130, posY + 65, 40, 20, JRMCoreH.trl("jrmc", "Accept"), 0));
         } else if (i != this.diff) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "KaioDiffRedLine"), guiLeft + 5, guiTop + 5 + 140, 0);
         }
      } else if (this.isGUIOpen(10)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(JRMCoreH.isPowerTypeSAO() ? JRMCoreH.tjsaoc + ":gui.png" : wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         if (this.pwr != 3) {
            this.align(icons);
         }

         if (JRMCoreH.isPowerTypeKi()) {
            s = JRMCoreH.trl("jrmc", "Difficulty");
            i = this.field_146289_q.func_78256_a(s) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(104, posX + 90 - i / 2, posY + 55, i, 20, s, 8046079));
         }

         if (JRMCoreH.isPowerTypeKi()) {
            JRMCoreClient.bars.showSE(posX / 2, guiTop - 34 - 1, 0, 0);
         }

         this.menuButtons("CH");
         if (!JRMCoreConfig.ssurl.contains("empty") && JRMCoreConfig.ssurl.contains("ttp")) {
            s = "Server Shop";
            i = this.field_146289_q.func_78256_a(s);
            this.field_146292_n.add(new JRMCoreGuiButtons00(3099, guiLeft + 260, guiTop + 85, i + 8, 20, s, 0));
         }

         if (!JRMCoreEH.aw && JRMCoreEH.dt && this.kdf >= ar) {
            s = "Update vanity";
            i = this.field_146289_q.func_78256_a(s);
            this.field_146292_n.add(new JRMCoreGuiButtons00(3098, guiLeft + 260, guiTop + 85 - 40 - 42, i + 8, 20, s, 0));
         }

         if (JRMCoreEH.dt) {
            s = (JRMCoreEH.gk ? "Hide" : "Show") + " own vanity";
            i = this.field_146289_q.func_78256_a(s);
            this.field_146292_n.add(new JRMCoreGuiButtons00(3097, guiLeft + 260, guiTop + 85 - 40 - 21, i + 8, 20, s, 0));
         }

         s = "Official DBC Server's site";
         i = this.field_146289_q.func_78256_a(s);
         this.field_146292_n.add(new JRMCoreGuiButtons00(3096, guiLeft + 260, guiTop + 85 - 40, i + 8, 20, s, 0));
         gender = JRMCoreH.dnsGender(JRMCoreH.dns);
         powerType = JRMCoreH.trl("jrmc", JRMCoreH.Pwrtyps[JRMCoreH.Pwrtyp]);
         raceName = JRMCoreH.trl("jrmc", "Race");
         Race = JRMCoreH.trl("jrmc", JRMCoreH.Races[JRMCoreH.Race]);
         className = JRMCoreH.trl("jrmc", JRMCoreH.ClassNames[JRMCoreH.Pwrtyp]);
         Class = JRMCoreH.trl("jrmc", JRMCoreH.cl(JRMCoreH.Pwrtyp)[JRMCoreH.Class]);
         ClassDesc = JRMCoreH.trl("jrmc", clDesc(JRMCoreH.Pwrtyp)[JRMCoreH.Class]);
         buttonText = JRMCoreH.trl("jrmc", "Level");
         Stats = JRMCoreH.trl("jrmc", "Stats");
         speed = JRMCoreH.trl("jrmc", "PowerRelease");
         TRState = JRMCoreH.trl("jrmc", "TRState");
         TransNms = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(JRMCoreH.Race, JRMCoreH.isPowerTypeChakra() ? 0 : JRMCoreH.State, JRMCoreH.StusEfctsMe(17), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20)));
         s = JRMCoreH.trl("jrmc", "StatIncreaseDesc");
         StatIncreaseDesc2 = JRMCoreH.trl("jrmc", "StatIncreaseDesc2");
         StatIncreaseDesc3 = JRMCoreH.trl("jrmc", "StatIncreaseDesc3");
         StatIncreaseDesc4 = JRMCoreH.trl("jrmc", "StatIncreaseDesc4");
         StatIncreaseDesc5 = JRMCoreH.trl("jrmc", "StatIncreaseDesc5");
         Attributes = JRMCoreH.trl("jrmc", "Attributes");
         TP = JRMCoreH.trl("jrmc", "TP");
         TrainingPoints = JRMCoreH.trl("jrmc", "TrainingPoints");
         RequiredTP = JRMCoreH.trl("jrmc", "RequiredTP");
         Alignment = JRMCoreH.trl("jrmc", "Alignment");
         AlignmentDesc = JRMCoreH.trl("jrmc", "AlignmentDesc");
         boolean max = JRMCoreH.getPlayerLevel(JRMCoreH.PlyrAttrbts) >= JRMCoreH.getPlayerLevel(kqGW3Z(false) * 6);
         i = 0;
         if (this.pwr != 3) {
            drawDetails(buttonText + ": " + JRMCoreH.cldgy + JRMCoreH.numSep((long)JRMCoreH.getPlayerLevel(JRMCoreH.PlyrAttrbts)), JRMCoreH.cldgy + (max ? JRMCoreH.trl("jrmc", "LevelMax") : JRMCoreH.trl("jrmc", "LevelNext", JRMCoreH.cllr + JRMCoreH.attrLvlNext(JRMCoreH.PlyrAttrbts) + JRMCoreH.cldgy)), guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
            var8.func_78276_b(speed + ": " + JRMCoreH.cldgy + JRMCoreH.curRelease + "%", guiLeft + 5 + 128, guiTop + 5 + i * 10, 0);
            ++i;
            ++i;
            var8.func_78276_b(Stats, guiLeft + 5 + 128, guiTop + 5 + i * 10, 0);
            ++i;
         }

         STR = STRo = JRMCoreH.PlyrAttrbts[0];
         DEX = DEXo = JRMCoreH.PlyrAttrbts[1];
         CON = JRMCoreH.PlyrAttrbts[2];
         WIL = WILo = JRMCoreH.PlyrAttrbts[3];
         MND = MNDo = JRMCoreH.statMindC();
         SPI = JRMCoreH.PlyrAttrbts[5];
         double per = 1.0D;
         boolean st = JRMCoreH.Pwrtyp == 1 && ((JRMCoreH.State != 0 || JRMCoreH.State2 != 0) && JRMCoreH.Race != 4 || (JRMCoreH.State != 4 || JRMCoreH.State2 != 0) && JRMCoreH.Race == 4 || JRMCoreH.Race == 4 && JRMCoreH.State >= 4 && JRMCoreH.curRelease == 100 && JRMCoreH.getArcRsrv() > 0 || JRMCoreH.StusEfctsMe(12) || JRMCoreH.StusEfctsMe(13) || JRMCoreH.StusEfctsMe(20) || JRMCoreH.StusEfctsMe(19));
         String stc = JRMCoreH.StusEfctsMe(19) ? JRMCoreH.cllb : JRMCoreH.clgd;
         boolean c = JRMCoreH.StusEfctsMe(10) || JRMCoreH.StusEfctsMe(11);
         if (JRMCoreH.Pwrtyp != 3 && JRMCoreH.Pwrtyp > 0) {
            STR = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 0, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
            DEX = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 1, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
            WIL = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
            af = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 2, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
            per = (double)(af > CON ? af : CON) / ((double)CON * 1.0D);
         }

         float wDex = 1.0F;
         float wStr = 1.0F;
         hasWeight = false;
         if ((int)JRMCoreH.WeightOn > 0) {
            hasWeight = true;
            wDex = JRMCoreH.weightPerc(1);
            wStr = JRMCoreH.weightPerc(0);
         }

         boolean isPowerTypeChakra = JRMCoreH.isPowerTypeChakra();
         int statSPI;
         int sklks;
         int stat;
         int curAtr;
         String statAttrW;
         int statO;
         String mod;
         int st1;
         if (!JRMCoreH.isPowerTypeKi() && !isPowerTypeChakra) {
            if (this.pwr == 3) {
               StatIncreaseDescStr = JRMCoreH.trl("saoc", "StatIncreaseDescStr");
               StatIncreaseDescVit = JRMCoreH.trl("saoc", "StatIncreaseDescVit");
               costTp = JRMCoreHSAC.getWeaponDamage(mc.field_71439_g.func_71045_bC(), STR);
               statSPI = JRMCoreHSAC.getWeaponBonus(mc.field_71439_g.func_71045_bC(), 0);
               sklks = JRMCoreHSAC.getWeaponBonus(mc.field_71439_g.func_71045_bC(), 1);
               stat = (int)JRMCoreHSAC.getDamage(costTp, STR, DEX);
               int requires = JRMCoreHSAC.getWeaponStatName(mc.field_71439_g.func_71045_bC(), "requires");
               int attackMin = JRMCoreHSAC.getWeaponStatName(mc.field_71439_g.func_71045_bC(), "attackMin");
               curAtr = JRMCoreHSAC.getWeaponStatName(mc.field_71439_g.func_71045_bC(), "attackMax");
               int attackMinOrg = attackMin;
               int attackMaxOrg = curAtr;
               if (requires > 0 && requires <= STR && mc.field_71439_g.func_71045_bC() != null) {
                  attackMin = (int)JRMCoreHSAC.getDamage(attackMin, STR + statSPI, DEX);
                  curAtr = (int)JRMCoreHSAC.getDamage(curAtr, STR + sklks, DEX);
               } else if (mc.field_71439_g.func_71045_bC() != null) {
                  int d1 = mc.field_71439_g.func_71045_bC().func_77973_b() instanceof ItemSword ? 4 : 0;
                  Multimap multimap = mc.field_71439_g.func_71045_bC().func_111283_C();
                  if (!multimap.isEmpty()) {
                     Iterator iterator = multimap.entries().iterator();

                     while(iterator.hasNext()) {
                        Entry entry = (Entry)iterator.next();
                        AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
                        double d0 = attributemodifier.func_111164_d();
                        if (attributemodifier.func_111167_a() == UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF")) {
                           d0 += (double)EnchantmentHelper.func_152377_a(mc.field_71439_g.func_71045_bC(), EnumCreatureAttribute.UNDEFINED);
                        }

                        if (attributemodifier.func_111169_c() != 1 && attributemodifier.func_111169_c() != 2) {
                           d1 += (int)d0;
                        } else {
                           d1 += (int)(d0 * 100.0D);
                        }

                        if (!(d0 > 0.0D) && d0 < 0.0D) {
                           d1 = (int)((double)d1 * -1.0D);
                        }
                     }
                  }

                  attackMin = 1 + d1;
                  curAtr = 2 + d1;
               } else {
                  attackMin = 1;
                  curAtr = 2;
               }

               max = JRMCoreH.sao_level >= 255;
               drawDetails(buttonText + ": " + JRMCoreH.cldgy + JRMCoreH.sao_level, JRMCoreH.cldgy + (max ? JRMCoreH.trl("jrmc", "LevelMax") : "You need " + JRMCoreH.SAOexpNeeded(JRMCoreH.sao_level, JRMCoreH.sao_exp) + " to Level up"), guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               drawDetails("AreaLevel: " + JRMCoreHSAC.SAO_getLvlBasedOnDrop(JRMCoreClient.mc.field_71439_g), "Current Level of an Area and mobs are probably around this level.", guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               statAttrW = "EXP: " + JRMCoreH.cldgy + JRMCoreH.sao_exp + "/" + JRMCoreH.SAOexpNeeded(JRMCoreH.sao_level, JRMCoreH.sao_exp);
               String desc = JRMCoreH.trl("saoc", "expDesc");
               drawDetails(statAttrW, desc, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               statAttrW = "COL: " + JRMCoreH.cldgy + JRMCoreH.sao_col;
               desc = JRMCoreH.trl("saoc", "colDesc");
               drawDetails(statAttrW, desc, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               ++i;
               var8.func_78276_b(Attributes, guiLeft + 5, guiTop + 5 + i * 10, 0);
               var8.func_78276_b(Stats, guiLeft + 5 + 128, guiTop + 5 + i * 10, 0);
               ++i;
               statO = (int)JRMCoreH.statInc[JRMCoreH.Pwrtyp][0];
               String statNam = JRMCoreH.trl("saoc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][0]);
               String Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + attackMin + "-" + curAtr;
               mod = "STR";
               drawDetails(Stat, JRMCoreH.cct(StatIncreaseDescStr + JRMCoreH.cldgy + "/nSAOC weapon damage " + JRMCoreH.cldr + attackMinOrg + "-" + attackMaxOrg, mod, statO), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);

               for(int i1 = 0; i1 < 3; ++i1) {
                  st1 = JRMCoreH.attrCst(JRMCoreH.PlyrAttrbts, 0);
                  boolean b = CanUpgrade[i1] && JRMCoreH.sao_ap > 0 && kqGW3Z(c) > JRMCoreH.PlyrAttrbts[i1];
                  int ypos = guiTop + i * 10 + 3 + i1 * 10;
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(110 + i1, guiLeft + 3, ypos, 10, 2, b));
                  drawDetails(JRMCoreH.cct(RequiredTP, JRMCoreH.cllr + JRMCoreH.attrCst(JRMCoreH.PlyrAttrbts, 0) + JRMCoreH.cldgy, ""), guiLeft + 3, ypos + 1, 10, 10, x, y, var8);
               }

               String startAttr = JRMCoreH.cldgy + "STR: " + JRMCoreH.cldr + STR + (statSPI > 0 ? JRMCoreH.clgd + " +" + statSPI : "");
               String AttrDesc = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][0]);
               drawDetails(startAttr, AttrDesc, guiLeft + 5 + 10, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               int stat = JRMCoreH.stat(mc.field_71439_g, 2, JRMCoreH.Pwrtyp, 2, CON, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
               statO = (int)JRMCoreH.statInc[JRMCoreH.Pwrtyp][2];
               statNam = JRMCoreH.trl("saoc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][2]);
               Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + stat;
               mod = "VIT";
               drawDetails(Stat, JRMCoreH.cct(StatIncreaseDescVit, mod, statO), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
               startAttr = JRMCoreH.cldgy + "AGI: " + JRMCoreH.cldr + DEX + (sklks > 0 ? JRMCoreH.clgd + " +" + sklks : "");
               AttrDesc = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][1]);
               drawDetails(startAttr, AttrDesc, guiLeft + 5 + 10, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               startAttr = JRMCoreH.cldgy + "VIT: " + JRMCoreH.cldr + CON;
               AttrDesc = JRMCoreH.trl("saoc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][2]);
               drawDetails(startAttr, AttrDesc, guiLeft + 5 + 10, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               startAttr = JRMCoreH.sao_ap + JRMCoreH.cldgy + " AP";
               AttrDesc = JRMCoreH.trl("saoc", "AtrPoints");
               if (JRMCoreH.sao_ap > 0) {
                  drawDetails(startAttr, AttrDesc, guiLeft + 5 + 10, guiTop + 5 + i * 10, x, y, var8);
               }

               ++i;
            } else {
               stat = JRMCoreH.stat(mc.field_71439_g, 0, JRMCoreH.Pwrtyp, 0, STR, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
               float inc = JRMCoreH.statInc[JRMCoreH.Pwrtyp][0];
               statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][0]);
               nameEffect = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + stat;
               tt = "STR";
               drawDetails(nameEffect, JRMCoreH.cct(s, tt, inc), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
               String startAttr = JRMCoreH.cldgy + "STR: " + JRMCoreH.cldr + STR;
               String AttrDesc = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][0]);
               drawDetails(startAttr, AttrDesc, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               ++i;
               stat = JRMCoreH.stat(mc.field_71439_g, 2, JRMCoreH.Pwrtyp, 2, CON, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
               inc = JRMCoreH.statInc[JRMCoreH.Pwrtyp][2];
               statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][2]);
               nameEffect = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + stat;
               tt = "CON";
               drawDetails(nameEffect, JRMCoreH.cct(s, tt, inc), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
               startAttr = JRMCoreH.cldgy + "CON: " + JRMCoreH.cldr + CON;
               AttrDesc = JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][2]);
               drawDetails(startAttr, AttrDesc, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               ++i;
            }
         } else {
            float ncbonus = 0.0F;
            if (isPowerTypeChakra) {
               statSPI = JRMCoreH.SklLvl(0, 2, JRMCoreH.PlyrSkills);
               ncbonus = (float)statSPI * 0.04F + (float)JRMCoreH.State * 0.25F;
            }

            statSPI = JRMCoreH.stat(mc.field_71439_g, 5, JRMCoreH.Pwrtyp, 5, SPI, JRMCoreH.Race, JRMCoreH.Class, JRMCoreH.SklLvl_KiBs(this.pwr));
            sklks = 0;
            if (JRMCoreH.Pwrtyp == 1) {
               sklks = (int)((double)JRMCoreH.SklLvl(12) * 0.0025D * (double)statSPI * (double)JRMCoreH.curRelease * 0.01D);
            }

            stat = JRMCoreH.stat(mc.field_71439_g, 0, JRMCoreH.Pwrtyp, 0, STR, JRMCoreH.Race, JRMCoreH.Class, ncbonus);
            float inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 0, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            String statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][0]);
            curAtr = (int)((double)stat * 0.01D * (double)JRMCoreH.curRelease * (double)JRMCoreH.weightPerc(0));
            long longValue = (long)curAtr + (long)sklks;
            if (longValue > 2147483647L) {
               longValue = 2147483647L;
            }

            String Stat = JRMCoreH.cldgy + statNam + ": " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep(longValue);
            String statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 0);
            statAttrW = hasWeight ? "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "weightreduction") + ": " + JRMCoreH.cllr + (int)(100.0F - wStr * 100.0F) + "%" : "";
            drawDetails(Stat, JRMCoreH.cct(s + StatIncreaseDesc2 + (sklks > 0 ? StatIncreaseDesc4 : ""), statAttr, inc, JRMCoreH.numSep((long)stat), 0, JRMCoreH.numSep((long)sklks)) + statAttrW, guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            if (JRMCoreH.Pwrtyp == 1) {
               sklks = (int)((double)JRMCoreH.SklLvl(11) * 0.005D * (double)statSPI * (double)JRMCoreH.curRelease * 0.01D);
            }

            stat = JRMCoreH.stat(mc.field_71439_g, 1, JRMCoreH.Pwrtyp, 1, DEX, JRMCoreH.Race, JRMCoreH.Class, ncbonus);
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 1, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][1]);
            curAtr = (int)((double)stat * 0.01D * (double)JRMCoreH.curRelease * (double)JRMCoreH.weightPerc(1));
            longValue = (long)curAtr + (long)sklks;
            if (longValue > 2147483647L) {
               longValue = 2147483647L;
            }

            Stat = JRMCoreH.cldgy + statNam + ": " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep(longValue);
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 1);
            statAttrW = hasWeight ? "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "weightreduction") + ": " + JRMCoreH.cllr + (int)(100.0F - wDex * 100.0F) + "%" : "";
            drawDetails(Stat, JRMCoreH.cct(s + StatIncreaseDesc2 + StatIncreaseDesc3 + (sklks > 0 ? StatIncreaseDesc4 : ""), statAttr, inc, JRMCoreH.numSep((long)stat), JRMCoreH.numSep((long)((int)((float)curAtr * (float)JRMCoreConfig.StatPasDef * 0.01F))), JRMCoreH.numSep((long)sklks)) + statAttrW, guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            statNam = JRMCoreH.trl("jrmc", "Passive");
            Stat = JRMCoreH.cldgy + statNam + ": " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep((long)((int)((float)curAtr * (float)JRMCoreConfig.StatPasDef * 0.01F + (float)sklks)));
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 1);
            statAttrW = hasWeight ? "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "weightreduction") + ": " + JRMCoreH.cllr + (int)(100.0F - wDex * 100.0F) + "%" : "";
            drawDetails(Stat, JRMCoreH.cct(s + StatIncreaseDesc2 + StatIncreaseDesc3 + (sklks > 0 ? StatIncreaseDesc4 : ""), statAttr, inc, JRMCoreH.numSep((long)stat), JRMCoreH.numSep((long)((int)((float)curAtr * (float)JRMCoreConfig.StatPasDef * 0.01F))), JRMCoreH.numSep((long)sklks)) + statAttrW, guiLeft + 5 + 128 + 5, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            stat = JRMCoreH.stat(mc.field_71439_g, 2, JRMCoreH.Pwrtyp, 2, CON, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 2, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][2]);
            int dr = (int)((1.0D - 1.0D / per) * 100.0D);
            Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + JRMCoreH.numSep((long)stat) + (JRMCoreH.round(per, 1) != 1.0D ? " R" + dr + "%" : "");
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 2);
            drawDetails(Stat, JRMCoreH.cct(s + (JRMCoreH.round(per, 1) != 1.0D ? StatIncreaseDesc5 : ""), statAttr, inc, dr), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            stat = JRMCoreH.stat(mc.field_71439_g, 2, JRMCoreH.Pwrtyp, 3, CON, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 3, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][3]);
            Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + JRMCoreH.numSep((long)stat);
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 2);
            drawDetails(Stat, JRMCoreH.cct(s, statAttr, inc), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            stat = JRMCoreH.stat(mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 4, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][4]);
            Stat = JRMCoreH.cldgy + statNam + ": " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep((long)((int)((double)stat * 0.01D * (double)JRMCoreH.curRelease)));
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 3);
            drawDetails(Stat, JRMCoreH.cct(s + StatIncreaseDesc2, statAttr, inc, JRMCoreH.numSep((long)stat)), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            stat = JRMCoreH.stat(mc.field_71439_g, 5, JRMCoreH.Pwrtyp, 5, SPI, JRMCoreH.Race, JRMCoreH.Class, JRMCoreH.SklLvl_KiBs(this.pwr));
            statO = JRMCoreH.stat(mc.field_71439_g, 5, JRMCoreH.Pwrtyp, 5, SPI, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statO = stat - statO;
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 5, 1, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][5]);
            Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + JRMCoreH.numSep((long)stat);
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 5);
            drawDetails(Stat, JRMCoreH.cct(s + (statO > 0 ? StatIncreaseDesc4 : ""), statAttr, inc, 0, 0, statO), guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            boolean isPowerTypeKi = JRMCoreH.isPowerTypeKi();
            String[] skls;
            String[] sklsNms;
            if (JRMCoreH.isPowerTypeChakra()) {
               skls = JRMCoreH.NCSkillIDs;
               sklsNms = JRMCoreH.NCSkillNames;
               mod = "nc";
            } else {
               skls = JRMCoreH.DBCSkillsIDs;
               sklsNms = JRMCoreH.DBCSkillNames;
               mod = "dbc";
            }

            st1 = JRMCoreH.Pwrtyp == 1 && JRMCoreH.StusEfctsMe(13) ? (JRMCoreH.rc_sai(JRMCoreH.Race) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) - 1) : (JRMCoreH.rc_arc(JRMCoreH.Race) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_humNam(JRMCoreH.Race) ? JRMCoreH.mstc_humnam() : 1))) : JRMCoreH.State;
            inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 7, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
            stat = (int)(JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[1], JRMCoreH.SklLvl(isPowerTypeKi ? 2 : 0, JRMCoreH.Pwrtyp), 100.0F, true, false, st1, JRMCoreH.State2, inc) * 100.0F);
            statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][7]);
            Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + stat + "%";
            statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 1);
            String skll = JRMCoreH.trl(mod, JRMCoreH.SklName(skls[isPowerTypeKi ? 2 : 0], skls, sklsNms));
            statAttrW = hasWeight ? "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "weightreduction") + ": " + JRMCoreH.cllr + (int)(100.0F - wDex * 100.0F) + "%" : "";
            drawDetails(Stat, JRMCoreH.cct(JRMCoreH.trl("jrmc", "SpDBDesc"), JRMCoreH.cldg + stat + JRMCoreH.cldgy, JRMCoreH.cllr + statAttr + JRMCoreH.cldgy, JRMCoreH.clbe + skll + JRMCoreH.cldgy) + statAttrW, guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            if (JRMCoreH.isPowerTypeKi()) {
               inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 11, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
               stat = (int)(JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[4], JRMCoreH.SklLvl(3, (byte)1), 100.0F, true, true, st1, JRMCoreH.State2, inc) * 100.0F);
               statNam = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][11]);
               Stat = JRMCoreH.cldgy + statNam + ": " + JRMCoreH.cldr + stat + "%";
               statAttr = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 4);
               skll = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[3], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
               statAttrW = hasWeight ? "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "weightreduction") + ": " + JRMCoreH.cllr + (int)(100.0F - wDex * 100.0F) + "%" : "";
               drawDetails(Stat, JRMCoreH.cct(JRMCoreH.trl("jrmc", "FSDBDesc"), JRMCoreH.cldg + stat + JRMCoreH.cldgy, JRMCoreH.cllr + statAttr + JRMCoreH.cldgy, JRMCoreH.clbe + skll + JRMCoreH.cldgy) + statAttrW, guiLeft + 5 + 128, guiTop + 5 + i * 10, x, y, var8);
               ++i;
            }

            int i = 1;
            String requiredTP = JRMCoreH.cct(RequiredTP, JRMCoreH.cllr + JRMCoreH.numSep((long)JRMCoreH.attrCst(JRMCoreH.PlyrAttrbts, this.mcu)) + JRMCoreH.cldgy, "");
            drawDetails(TP + ": " + JRMCoreH.cldgy + JRMCoreH.numSep((long)JRMCoreH.curTP), TrainingPoints + ",\n" + requiredTP, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
            i = i + 1;
            (new StringBuilder()).append(!JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11) ? (JRMCoreH.StusEfctsMe(14) && JRMCoreH.lgndb() ? JRMCoreH.cldg : JRMCoreH.cldgy) : JRMCoreH.clpr).append(TransNms).toString();
            String textRace = raceName + ": " + JRMCoreH.cldgy + Race;
            var8.func_78276_b(textRace, guiLeft + 5, guiTop + 5 + i * 10, 0);
            ++i;
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation textureIcons = new ResourceLocation(JRMCoreH.tjjrmc + ":icons3.png");
            mc.field_71446_o.func_110577_a(textureIcons);
            this.func_73729_b(guiLeft + 5 + this.field_146289_q.func_78256_a(textRace), guiTop + 5 + (i - 1) * 10 - 3, 0, (8 - (gender >= 1 ? 1 : 0)) * 16, 16, 16);
            GL11.glPopMatrix();
            mc.field_71446_o.func_110577_a(guiLocation);
            String fullFormText = TRState + ": " + (!JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11) ? (JRMCoreH.StusEfctsMe(14) && JRMCoreH.lgndb() ? JRMCoreH.cldg : JRMCoreH.cldgy) : JRMCoreH.clpr) + TransNms;
            boolean fz;
            String AttrDesc;
            String say;
            if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi()) {
               fz = JRMCoreH.StusEfctsMe(5);
               int kaiokenID = JRMCoreH.getFormID("Kaioken", JRMCoreH.Race);
               double formLevel2 = JRMCoreH.getFormMasteryValue(JRMCoreClient.mc.field_71439_g, kaiokenID);
               String[] formData = JRMCoreH.getFormMasteryData().split(",");
               AttrDesc = formData[0];
               say = formData[1];
               DecimalFormat format = new DecimalFormat("#.##");
               drawDetails(fullFormText, TransNms + " Mastery Lvl: " + JRMCoreH.cldr + format.format(Double.parseDouble(say)) + (fz ? "\n" + JRMCoreH.cldgy + "Kaioken Mastery Lvl: " + JRMCoreH.cldr + format.format(formLevel2) : ""), guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
               ++i;
            } else {
               var8.func_78276_b(fullFormText, guiLeft + 5, guiTop + 5 + i * 10, 0);
               ++i;
            }

            drawDetails(className + ": " + JRMCoreH.cldgy + Class, ClassDesc, guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            drawDetails(Alignment + ": " + JRMCoreH.algnCur(JRMCoreH.align), JRMCoreH.cct(AlignmentDesc, JRMCoreH.align + "%", ""), guiLeft + 5, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            ++i;
            var8.func_78276_b(Attributes, guiLeft + 5, guiTop + 5 + i * 10, 0);
            ++i;
            fz = !JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11);
            boolean en = JRMCoreH.curTP >= JRMCoreGuiScreen.cost;

            for(int i1 = 0; i1 < JRMCoreH.PlyrAttrbts.length; ++i1) {
               boolean mxd = kqGW3Z(c) > JRMCoreH.PlyrAttrbts[i1];
               boolean b = CanUpgrade[i1] && en && mxd && fz;
               int ypos = guiTop + i * 10 + 3 + i1 * 10;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(110 + i1, guiLeft + 3, ypos, 10, 2, b));
               say = null;
               if (!mxd) {
                  say = JRMCoreH.cct(JRMCoreH.trl("jrmc", "AttributeMaxed"));
               } else if (!fz) {
                  say = JRMCoreH.cct(JRMCoreH.trl("dbc", "cantupgradef"));
               }

               if (say != null) {
                  drawDetails(say, guiLeft + 3, ypos + 1, 10, 10, x, y, var8);
               }
            }

            String attributeMulti = "  Race-Class Multiplier:";
            String startAttr = JRMCoreH.cldgy + "STR: " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep((long)STR) + (hasWeight ? JRMCoreH.cllr + " -" + (int)JRMCoreH.WeightOn : "");
            String AttrOrig = st ? JRMCoreH.trl("jrmc", "Modified") + ": " + JRMCoreH.clgd + STR + "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "Original") + ": " + JRMCoreH.cldr + STRo + "\n" : "";
            AttrDesc = AttrOrig + JRMCoreH.cldgy + JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 0) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][0]) + (hasWeight ? "\n" + JRMCoreH.trl("jrmc", "trainingweightworn") + ": " + JRMCoreH.cllr + (int)JRMCoreH.WeightOn : "") + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][0] + this.getAttributeBonusDescription(0);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            startAttr = JRMCoreH.cldgy + "DEX: " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep((long)DEX) + (hasWeight ? JRMCoreH.cllr + " -" + (int)JRMCoreH.WeightOn : "");
            AttrOrig = st ? JRMCoreH.trl("jrmc", "Modified") + ": " + JRMCoreH.clgd + DEX + "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "Original") + ": " + JRMCoreH.cldr + DEXo + "\n" : "";
            AttrDesc = AttrOrig + JRMCoreH.cldgy + JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 1) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][1]) + (hasWeight ? "\n" + JRMCoreH.trl("jrmc", "trainingweightworn") + ": " + JRMCoreH.cllr + (int)JRMCoreH.WeightOn : "") + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][1] + this.getAttributeBonusDescription(1);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            startAttr = JRMCoreH.cldgy + "CON: " + JRMCoreH.cldr + JRMCoreH.numSep((long)CON) + (JRMCoreH.round(per, 1) != 1.0D ? " x" + JRMCoreH.round(per, 1) : "");
            AttrDesc = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 2) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][2]) + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][2] + this.getAttributeBonusDescription(2);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            startAttr = JRMCoreH.cldgy + "WIL: " + (st ? stc : JRMCoreH.cldr) + JRMCoreH.numSep((long)WIL);
            AttrOrig = st ? JRMCoreH.trl("jrmc", "Modified") + ": " + JRMCoreH.clgd + WIL + "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "Original") + ": " + JRMCoreH.cldr + WILo + "\n" : "";
            AttrDesc = AttrOrig + JRMCoreH.cldgy + JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 3) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][3]) + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][3] + this.getAttributeBonusDescription(3);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            startAttr = JRMCoreH.cldgy + "MND: " + (MND != MNDo ? JRMCoreH.clgd : JRMCoreH.cldr) + JRMCoreH.numSep((long)MND);
            AttrOrig = MND != MNDo ? JRMCoreH.trl("jrmc", "Modified") + ": " + JRMCoreH.clgd + MND + "\n" + JRMCoreH.cldgy + JRMCoreH.trl("jrmc", "Original") + ": " + JRMCoreH.cldr + MNDo + "\n" : "";
            AttrDesc = AttrOrig + JRMCoreH.cldgy + JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 4) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][4]) + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][4] + this.getAttributeBonusDescription(4);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            startAttr = JRMCoreH.cldgy + "SPI: " + JRMCoreH.cldr + JRMCoreH.numSep((long)SPI);
            AttrDesc = JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 5) + ", " + JRMCoreH.trl("jrmc", JRMCoreH.attrDsc[JRMCoreH.Pwrtyp][5]) + "\n  Race-Class Multiplier: " + JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[JRMCoreH.Race][JRMCoreH.Class][5] + this.getAttributeBonusDescription(5);
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(-10, guiLeft + 7, guiTop + 0 + i * 10 + 3, 10, 2, true));
            int cost = JRMCoreH.attrCst(JRMCoreH.PlyrAttrbts, this.mcu);
            boolean xm = JRMCoreH.acm(JRMCoreH.PlyrAttrbts);
            String say = JRMCoreH.cct(RequiredTP, JRMCoreH.cldr + JRMCoreH.numSep((long)cost) + JRMCoreH.cldgy, "") + (!en ? "/n(" + JRMCoreH.trl("jrmc", "notenoughtp") + ")" : "");
            if (xm) {
               say = JRMCoreH.cct(JRMCoreH.trl("jrmc", "AttributeAllMaxed"));
            } else if (cost == 0) {
               say = JRMCoreH.cct(JRMCoreH.trl("jrmc", "cantupgrade"));
            } else if (!fz) {
               say = JRMCoreH.cct(JRMCoreH.trl("dbc", "cantupgradef"));
            }

            startAttr = JRMCoreH.cldgy + " UC: " + JRMCoreH.cldb + (cost <= 0 ? JRMCoreH.trl("jrmc", "LimitReached") : JRMCoreH.numSep((long)cost) + " TP" + (this.mcu > 0 ? " x" + JRMCoreH.attributeMultiplier(this.mcu) : ""));
            AttrDesc = JRMCoreH.trl("jrmc", "UCnam") + ", " + say + (x > 0 ? " x" + JRMCoreH.attributeMultiplier(this.mcu) : "");
            drawDetails(startAttr, AttrDesc, guiLeft + 15, guiTop + 5 + i * 10, x, y, var8);
            ++i;
            if (JRMCoreH.Pwrtyp == 2 && JRMCoreH.PtchVc == 0) {
               this.field_146292_n.add(new JRMCoreGuiSlider00(196, guiLeft - 30, guiTop + 5 - 20, "", ptch, 1.0F));
               this.field_146292_n.add(new JRMCoreGuiButtons00(197, guiLeft - 30, guiTop + 5 + 130 - 20, 20, 20, "Ok", 0));
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Voice"), guiLeft - 30, guiTop + 5 - 30, JRMCoreH.techNCCol[1]);
            }
         }
      } else if (this.isGUIOpen(11)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.menuButtons("SK");
         if (JRMCoreH.isPowerTypeChakra()) {
            s = JRMCoreH.trl("jrmc", "Learn");
            i = this.field_146289_q.func_78256_a(s);
            this.field_146292_n.add(new JRMCoreGuiButtons01(-200, guiLeft + 250 + 10, guiTop + 5, i, s, JRMCoreH.techNCCol[1]));
         }

         SklsMR = (int[][])null;
         int[][] cSklsMR = (int[][])null;
         int[] sklsUps;
         int[][] sklsMR;
         int[][] sklsLvl;
         String[] skls;
         String[] sklsNms;
         if (JRMCoreH.isPowerTypeChakra()) {
            techName = JRMCoreH.ncRSkls;
            rSklsLvl = JRMCoreH.ncRSklsLvl;
            techAcquired = JRMCoreH.ncRSklsNms;
            techEffects = JRMCoreH.ncCSkls;
            cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
            j = JRMCoreH.NCRacialSkillAbilityNames;
            cSklsMR = JRMCoreH.NCRacialSkillMindCost;
            skls = JRMCoreH.NCSkillIDs;
            sklsUps = JRMCoreH.ncSklsUps;
            sklsLvl = JRMCoreH.NCSkillTPCost;
            sklsNms = JRMCoreH.NCSkillNames;
            sklsMR = JRMCoreH.NCSkillMindCost;
            TransNms = "nc";
         } else {
            techName = JRMCoreH.vlblRSkls;
            rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
            techAcquired = JRMCoreH.vlblRSklsNms;
            SklsMR = JRMCoreH.DBCRacialSkillMindCost;
            techEffects = JRMCoreH.vlblCSkls;
            cSklsLvl = JRMCoreH.vlblCSklsLvl;
            j = JRMCoreH.vlblCSklsNms;
            skls = JRMCoreH.DBCSkillsIDs;
            sklsUps = JRMCoreH.vlblSklsUps;
            sklsLvl = JRMCoreH.DBCSkillTPCost;
            sklsNms = JRMCoreH.DBCSkillNames;
            sklsMR = JRMCoreH.DBCSkillMindCost;
            TransNms = "dbc";
         }

         ni = JRMCoreH.skillSlot_MindUsed();
         canAffordMind = JRMCoreH.skillSlot_EnoughMindLeft();
         dmg = JRMCoreH.skillSlot_AvailableMindLeft();
         canAffordTP = true;
         skillID = 0;
         if (JRMCoreH.PlyrSkillX != null && !JRMCoreH.PlyrSkillX.contains("pty") && JRMCoreH.PlyrSkillX.length() > 1) {
            ++skillID;
            Attributes = JRMCoreH.SklName(JRMCoreH.PlyrSkillX, techName, techAcquired, JRMCoreH.Race);
            TP = JRMCoreH.trl(TransNms, Attributes);
            n2 = Integer.parseInt(JRMCoreH.PlyrSkillX.substring(2));
            var8.func_78276_b("§0" + TP + (n2 <= 9 ? " " + this.textLevel(n2) : ""), guiLeft + 5, guiTop + 15 + skillID * 10, 0);
            i = this.field_146289_q.func_78256_a(TP);
            drawDetails(JRMCoreH.trl(TransNms, Attributes + "Desc"), guiLeft + 5, guiTop + 15 + skillID * 10 + 2, i, 6, x, y, var8);
            lvl = JRMCoreH.skillMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, SklsMR);
            i = ni + lvl;
            canAffordMind = JRMCoreH.canAffordSkill(JRMCoreH.statMindC(), i);
            nw = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, rSklsLvl);
            if (JRMCoreConfig.dat5711 && nw != -1) {
               if (JRMCoreH.rSai(JRMCoreH.Race) && n2 < 7) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(390, guiLeft - 10, guiTop + 13 + skillID * 10, 10, 2, canAffordMind));
               } else if (JRMCoreH.Race == 4 && n2 < 6) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(390, guiLeft - 10, guiTop + 13 + skillID * 10, 10, 2, canAffordMind));
               } else if (JRMCoreH.Race != 4 && n2 < 5) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(390, guiLeft - 10, guiTop + 13 + skillID * 10, 10, 2, canAffordMind));
               }
            }

            if (JRMCoreH.Race == 4 && JRMCoreHDBC.auc(n2) && !JRMCoreH.data(mc.field_71439_g.func_70005_c_(), 16, "").contains(";")) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(392, guiLeft + 10 + var8.func_78256_a(TP + (n2 < 7 ? this.textLevel(n2) : "")), guiTop + 13 + skillID * 10, 20, 1));
            }

            s = n2 < (JRMCoreH.Race != 1 && JRMCoreH.Race != 2 ? (JRMCoreH.Race == 4 ? 6 : 5) : 7) ? (nw == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + JRMCoreH.numSep((long)nw) + " M: " + JRMCoreH.numSep((long)lvl)) : JRMCoreH.trl("jrmc", "Maxed");
            var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + skillID * 10, 0);
         }

         if (JRMCoreH.PlyrSkillY != null && !JRMCoreH.PlyrSkillY.contains("pty") && !JRMCoreH.PlyrSkillY.contains("Sai") && JRMCoreH.Race != 1 && JRMCoreH.Race != 2 && JRMCoreH.PlyrSkillY.length() > 1) {
            ++skillID;
            Attributes = JRMCoreH.SklName(JRMCoreH.PlyrSkillY, techEffects, j);
            n2 = Integer.parseInt(JRMCoreH.PlyrSkillY.substring(2));
            var8.func_78276_b("§0" + (JRMCoreH.Race != 1 && JRMCoreH.Race != 2 ? Attributes + this.textLevel(n2 + 1) : JRMCoreH.TransSaiUpNam[n2]), guiLeft + 5, guiTop + 15 + skillID * 10, 0);
            i = this.field_146289_q.func_78256_a(Attributes);
            drawDetails(JRMCoreH.trl(TransNms, Attributes + "Desc"), guiLeft + 5, guiTop + 15 + skillID * 10 + 2, i, 6, x, y, var8);
            lvl = JRMCoreH.skillMindRequirement(JRMCoreH.PlyrSkillY, techEffects, cSklsMR);
            i = ni + lvl;
            canAffordMind = JRMCoreH.canAffordSkill(JRMCoreH.statMindC(), i);
            nw = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillY, JRMCoreH.Race, cSklsLvl);
            if (JRMCoreConfig.dat5711 && n2 <= 8 && nw != -1) {
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(391, guiLeft - 10, guiTop + 13 + skillID * 10, 10, 2, canAffordMind));
            }

            s = n2 <= 8 ? (nw == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + JRMCoreH.numSep((long)nw) + " M: " + JRMCoreH.numSep((long)lvl)) : JRMCoreH.trl("jrmc", "Maxed");
            var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + skillID * 10, 0);
         }

         byte wpy;
         if (JRMCoreH.PlyrSkills != null) {
            sw = JRMCoreH.PlyrSkills.length;
            cool = 5.0F;
            wpy = 10;
            this.scrollMouseJump = 1;
            if (sw > wpy) {
               if ((float)sw - cool < (float)this.scroll) {
                  this.scroll = (int)((float)sw - cool);
               } else if (this.scroll < 0) {
                  this.scroll = 0;
               }

               if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
                  this.scroll = (int)(((float)sw - cool) * scrollSide);
               } else {
                  scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)sw - cool);
               }
            } else {
               this.scroll = 0;
            }

            if (sw > wpy) {
               if (scrollSide > 0.0F) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 - 70, "i"));
               }

               if (scrollSide < 1.0F) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 + 60, "v"));
               }

               this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiTop + 25, this.mousePressed, scrollSide, 1.0F));
            }

            for(i = this.scroll; i < (JRMCoreH.PlyrSkills.length > this.scroll + 10 ? this.scroll + 10 : JRMCoreH.PlyrSkills.length); ++i) {
               Alignment = JRMCoreH.PlyrSkills[i];
               if (!Alignment.contains("pty") && Alignment.length() > 2) {
                  ++skillID;
                  AlignmentDesc = JRMCoreH.SklName(Alignment, skls, sklsNms);
                  name = JRMCoreH.trl(TransNms, AlignmentDesc);
                  i = Integer.parseInt(Alignment.substring(2));
                  STR = JRMCoreH.isPowerTypeKi() && !JRMCoreH.rSai(JRMCoreH.Race) && Alignment.contains(JRMCoreH.DBCSkillsIDs[9]) ? (i > 0 ? 0 : i) : JRMCoreH.SklLvl_m(Alignment, skls, i);
                  i = STR;
                  String nm = "§0" + name + " " + this.textLevel(STR + 1);
                  var8.func_78276_b(nm, guiLeft + 5, guiTop + 20 + skillID * 10, 0);
                  String a = "";
                  if (JRMCoreH.isPowerTypeKi()) {
                     switch(JRMCoreH.SklID(Alignment, skls)) {
                     case 7:
                        a = "" + JRMCoreConfig.SklMedCat;
                     }
                  } else if (JRMCoreH.isPowerTypeChakra()) {
                     switch(JRMCoreH.SklID(Alignment, skls)) {
                     case 11:
                        a = "" + JRMCoreConfig.SklMedCat;
                     }
                  }

                  DEXo = this.field_146289_q.func_78256_a(name);
                  drawDetails(JRMCoreH.trl(TransNms, AlignmentDesc + "Desc" + a), guiLeft + 5, guiTop + 20 + skillID * 10 + 2, DEXo, 6, x, y, var8);
                  this.field_146292_n.add(new JRMCoreGuiButtonsA3(360 + i, guiLeft + 243, guiTop + 20 + skillID * 10 - 2, 10, 3));
                  WIL = JRMCoreH.skillMindRequirement(Alignment, skls, sklsMR);
                  WILo = ni + WIL;
                  canAffordMind = JRMCoreH.canAffordSkill(JRMCoreH.statMindC(), WILo);
                  STR = JRMCoreH.isPowerTypeKi() && !JRMCoreH.rSai(JRMCoreH.Race) && Alignment.contains(JRMCoreH.DBCSkillsIDs[9]) ? -1 : JRMCoreH.SklInit(Alignment, skls, sklsUps);
                  MND = JRMCoreH.skillTPCost(Alignment, skls, sklsLvl);
                  if (i <= STR && MND != -1) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA3(330 + i, guiLeft - 10, guiTop + 18 + skillID * 10, 10, 2, canAffordMind));
                  }

                  String st = i <= JRMCoreH.SklInit(Alignment, skls, sklsUps) ? (MND == -1 ? JRMCoreH.trl("jrmc", "UpgradeLocked") : "TP: " + JRMCoreH.numSep((long)MND) + " M: " + JRMCoreH.numSep((long)WIL)) : JRMCoreH.trl("jrmc", "Maxed");
                  var8.func_78276_b(st, guiLeft + 240 - var8.func_78256_a(st), guiTop + 20 + skillID * 10, 0);
               }
            }
         }

         var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points" + " (TP)", guiLeft + 10, guiTop + 150, 0);
         Attributes = "TP and Mind Cost:";
         drawStringWithBorder(var8, "TP and Mind Cost:", guiLeft + 250 - var8.func_78256_a("TP and Mind Cost:"), guiTop + 5 - 2, 16765738);
         drawDetails("§0" + JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep((long)dmg), JRMCoreH.statMindC() >= kqGW3Z(false) ? JRMCoreH.trl("jrmc", "SkillSysMax", JRMCoreH.clpr + JRMCoreH.PlyrSkills.length + JRMCoreH.cldgy) : JRMCoreH.trl("jrmc", "SkillSysNext", JRMCoreH.cllr + JRMCoreH.attrNms(JRMCoreH.Pwrtyp, 4) + JRMCoreH.cldgy, JRMCoreH.clpr + JRMCoreH.PlyrSkills.length + JRMCoreH.cldgy), guiLeft + 5, guiTop + 5, x, y, var8);
         if (this.confirmationWindow && this.IDtoProcessConfirmFor >= 0) {
            xSize = 140;
            int ySize = 71;
            int wpx = 60;
            wpy = 50;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            guiLocation = new ResourceLocation(wish);
            mc.field_71446_o.func_110577_a(guiLocation);
            this.func_73729_b(guiLeft + wpx, guiTop + wpy, 0, 159, xSize, ySize);
            RequiredTP = JRMCoreH.PlyrSkills[this.IDtoProcessConfirmFor];
            if (!RequiredTP.contains("pty") && RequiredTP.length() > 2) {
               ++skillID;
               Alignment = JRMCoreH.Pwrtyp == 1 ? JRMCoreH.trl("dbc", JRMCoreH.SklName(RequiredTP, skls, sklsNms)) : JRMCoreH.trl("nc", JRMCoreH.SklName(RequiredTP, skls, sklsNms));
               JRMCoreH.txt(JRMCoreH.trl("jrmc", "delskillconfirm", Alignment), JRMCoreH.cldr, 0, true, guiLeft + wpx + 5, guiTop + wpy + 5, xSize - 10);
               this.field_146292_n.add(new JRMCoreGuiButtons00(300 + this.IDtoProcessConfirmFor, guiLeft + 5 + wpx, guiTop + 45 + wpy, 40, 20, JRMCoreH.trl("jrmc", "Yes"), 0));
            }

            this.field_146292_n.add(new JRMCoreGuiButtons00(399, guiLeft + 95 + wpx, guiTop + 45 + wpy, 40, 20, JRMCoreH.trl("jrmc", "No"), 0));
         }
      }

      boolean may;
      float h3;
      float h4;
      if (this.isGUIOpen(12)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.menuButtons("TE");
         if (JRMCoreH.Pwrtyp == 2) {
            techName = JRMCoreH.techNCName;
            techTypes = JRMCoreH.techNCTypes;
            techAcquired = JRMCoreH.techNCAcquired;
            techEffects = JRMCoreH.techNCSpeed;
            techEffects = JRMCoreH.techNCEffects;
         } else {
            techName = JRMCoreH.techDBCName;
            techTypes = JRMCoreH.techDBCTypes;
            techAcquired = JRMCoreH.techDBCAcquired;
            techEffects = JRMCoreH.techDBCSpeed;
            techEffects = JRMCoreH.techDBCEffects;
         }

         byte i;
         byte[] sts;
         String kipow;
         String c;
         String exps;
         boolean may;
         int t;
         if (this.attViwPg == 0) {
            for(i = 0; i < 4; ++i) {
               if (JRMCoreH.tech(i) == null) {
                  this.field_146292_n.add(new JRMCoreGuiButtons00(200 + i, guiLeft + 85, guiTop + 25 + i * 35, 60, 20, JRMCoreH.trl("jrmc", "Create"), 0));
               } else {
                  j = JRMCoreH.tech(i);
                  Class = j[0];
                  ClassDesc = j[1];
                  buttonText = j[2];
                  Stats = j[3];
                  speed = j[4];
                  TRState = j[5];
                  TransNms = j[6];
                  s = j[7];
                  StatIncreaseDesc2 = j[8];
                  StatIncreaseDesc3 = j[9];
                  StatIncreaseDesc4 = j[10];
                  StatIncreaseDesc5 = j[11];
                  Attributes = "";
                  TP = "";
                  TrainingPoints = "";
                  i = 0;
                  lvl = 0;
                  i = 0;
                  sts = JRMCoreH.techDBCstatsDefault;
                  if (j.length > 12) {
                     Attributes = j[12];
                     TP = j[13];
                     TrainingPoints = j[14];
                  }

                  if (j.length > 16) {
                     i = Integer.parseInt(j[16]);
                     lvl = Integer.parseInt(j[17]);
                     i = Integer.parseInt(j[18]);
                     sts = JRMCoreH.tech_statmods(j[19]);
                  }

                  if (this.pwr == 1) {
                     JRMCoreClient.bars.renderEnSideBar();
                     boolean v = JRMCoreH.StusEfctsMe(10) || JRMCoreH.StusEfctsMe(11);
                     var10000 = JRMCoreH.PlyrAttrbts[3];
                     STRo = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, v, JRMCoreH.getMajinAbsorption());
                     DEX = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, 0, 0, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, v, JRMCoreH.getMajinAbsorption());
                     DEXo = JRMCoreH.stat(mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, STRo, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     WIL = JRMCoreH.stat(mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, DEX, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     WILo = JRMCoreH.techDBCdmg(j, DEXo, sts);
                     String dam2 = "";
                     if (Integer.parseInt(Stats) == 6) {
                        WILo = (int)((float)WILo / 2.0F);
                     } else if (Integer.parseInt(Stats) == 7 || Integer.parseInt(Stats) == 8) {
                        WILo = (int)((float)WILo * 2.0F);
                        if (Integer.parseInt(Stats) == 8 && Integer.parseInt(TransNms) == 1) {
                           WILo = (int)((float)WILo * 3.0F);
                        }
                     }

                     MNDo = JRMCoreH.techDBCkic(j, WIL, sts);
                     CON = JRMCoreH.techDBCtpc(j, false);
                     h3 = JRMCoreH.techDBCct(j, sts);
                     h4 = JRMCoreH.techDBCcd(j, sts);
                     kipow = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][4]);
                     WILo = (int)((double)WILo * JRMCoreConfig.dat5696[Integer.parseInt(Stats)][1]);
                     MNDo = (int)((double)MNDo * JRMCoreConfig.dat5696[Integer.parseInt(Stats)][2]);
                     c = JRMCoreH.clb;
                     aea = (int)((double)WILo * 0.01D * (double)JRMCoreH.curRelease);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[0]) + ": " + (JRMCoreConfig.dat5695[Integer.parseInt(Stats)] ? JRMCoreH.cldgy : JRMCoreH.cllr + "§m") + Class, guiLeft + 5, guiTop + 15 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[3]) + ": " + (JRMCoreConfig.dat5695[Integer.parseInt(Stats)] ? JRMCoreH.cldgy : JRMCoreH.cllr) + JRMCoreH.trl("dbc", techTypes[Integer.parseInt(Stats)]), guiLeft + 5, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", Integer.parseInt(Stats) != 7 ? techName[5] : "Shield") + ": §8" + aea + " (" + JRMCoreH.curRelease + "%)", guiLeft + 120, guiTop + 15 + 0 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[7]) + ": §8" + MNDo, guiLeft + 120, guiTop + 15 + 8 + i * 35, 0);
                     if (i > 0) {
                        var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[18]) + ": §8" + i, guiLeft + 120, guiTop + 15 + 16 + i * 35, 0);
                     }

                     for(awa = 0; awa < JRMCoreH.techDBCstatmods.length; ++awa) {
                        boolean doit = true;
                        if (awa == 0 && (Integer.parseInt(Stats) == 8 || Integer.parseInt(Stats) == 7)) {
                           doit = false;
                        }

                        if (doit) {
                           may = i > 0;
                           int ypos = guiTop + 32 + i * 35 + 0;
                           this.field_146292_n.add(new JRMCoreGuiButtonsA3(130 + i * 10 + awa, guiLeft + 5 + awa * 15, ypos, 10, 2, may));
                           String dat = JRMCoreH.techDBCstatmods[awa];
                           if (awa == 1 && Integer.parseInt(Stats) == 7) {
                              dat = "ShieldInc";
                           }

                           StatIncreaseDescStr = JRMCoreH.trl("dbc", dat) + (sts[awa] > 0 ? "\n " + (int)(JRMCoreH.tech_statmod(sts, awa) * 100.0F) + "%%" : "");
                           drawDetails(JRMCoreH.cct(StatIncreaseDescStr, JRMCoreH.cllr + JRMCoreH.attrCst(JRMCoreH.PlyrAttrbts, 0) + JRMCoreH.cldgy, ""), guiLeft + 5 + awa * 15, ypos + 1, 10, 10, x, y, var8);
                        }
                     }

                     exps = "EXP: " + JRMCoreH.cldgy + i + "/" + JRMCoreH.tech_getexpFor(lvl);
                     String tt = (JRMCoreConfig.dat5695[Integer.parseInt(Stats)] ? "" : JRMCoreH.cllr + "§n§l" + JRMCoreH.trl("jrmc", "DisabledType") + "\n") + c + JRMCoreH.trl("dbc", techName[0]) + ": §8" + Class + "\n" + c + JRMCoreH.trl("dbc", techName[17]) + ": §8" + lvl + " (" + (lvl < 10 ? exps : JRMCoreH.trl("jrmc", "Maxed")) + ")\n" + c + JRMCoreH.trl("dbc", techName[ClassDesc.contains("1") ? 1 : 2]) + ": §8" + (ClassDesc.contains("1") ? JRMCoreH.trl("jrmc", techAcquired[Integer.parseInt(ClassDesc)]) : buttonText) + "\n" + c + JRMCoreH.trl("dbc", techName[3]) + ": §8" + JRMCoreH.trl("dbc", techTypes[Integer.parseInt(Stats)]) + " " + (sts[6] > 0 ? "(" + JRMCoreH.trl("dbc", JRMCoreH.techDBCstatmods[6]) + " +" + (int)(JRMCoreH.tech_statmod(sts, 6) * 100.0F) + "%%)" : "") + "\n" + c + JRMCoreH.trl("dbc", Integer.parseInt(Stats) != 7 ? techName[5] : "Shield") + ": §8" + aea + " (" + JRMCoreH.trl("dbc", "maxDmgDesc") + ")\n" + c + JRMCoreH.trl("dbc", Integer.parseInt(Stats) != 7 ? "potDmg" : "potShld") + ": §8" + WILo + (sts[1] > 0 ? " (+" + (int)(JRMCoreH.tech_statmod(sts, 1) * 100.0F) + "%%)" : "") + "\n" + c + JRMCoreH.trl("dbc", techName[4]) + ": §8" + JRMCoreH.trl("jrmc", techEffects[Integer.parseInt(speed)]) + (sts[0] > 0 ? " (+" + (int)(JRMCoreH.tech_statmod(sts, 0) * 100.0F) + "%%)" : "") + "\n" + c + JRMCoreH.trl("dbc", techName[8]) + ": §8" + JRMCoreH.round(h3, 1) + " sec" + (sts[3] > 0 ? " (" + (int)(JRMCoreH.tech_statmod(sts, 3) * 100.0F) + "%%)" : "") + "\n" + c + JRMCoreH.trl("dbc", techName[9]) + ": §8" + JRMCoreH.round(h4, 1) + " sec" + (sts[4] > 0 ? " (" + (int)(JRMCoreH.tech_statmod(sts, 4) * 100.0F) + "%%)" : "") + "\n" + c + JRMCoreH.trl("dbc", techName[7]) + ": §8" + JRMCoreH.techDBCkic(j, DEXo, sts) * (int)JRMCoreConfig.dat5696[Integer.parseInt(Stats)][2] + (sts[2] > 0 ? " (" + (int)(JRMCoreH.tech_statmod(sts, 2) * 100.0F) + "%%)" : "") + (sts[5] > 0 ? "\n" + c + JRMCoreH.trl("dbc", techName[11]) + ": §8" + (int)JRMCoreH.tech_statmod(sts, 5) : "");
                     drawDetails(tt, guiLeft + 5, guiTop + 15 + i * 35 + 1, 240, 20, x, y, this.field_146289_q);
                  }

                  if (this.pwr == 2) {
                     i = Integer.parseInt(Stats);
                     STR = Integer.parseInt(speed);
                     STRo = Integer.parseInt(TransNms);
                     DEX = JRMCoreH.techNCCostP[Integer.parseInt(s)];
                     DEXo = (int)((double)DEX * 0.01D * (double)JRMCoreH.maxEnergy);
                     DEXo = DEXo < 1 ? 1 : DEXo;
                     WIL = (int)((float)DEXo - (float)DEXo * 0.25F * (float)STR + (i == 0 ? (float)DEXo * 0.2F : 0.0F));
                     WILo = JRMCoreH.SklLvl(1, (byte)2);
                     MND = JRMCoreH.SklLvl(2, (byte)2);
                     MNDo = JRMCoreH.SklLvl(4, (byte)2);
                     CON = JRMCoreH.SklLvl(5, (byte)2);
                     SPI = JRMCoreH.SklLvl(6, (byte)2);
                     aea = JRMCoreH.SklLvl(7, (byte)2);
                     awa = JRMCoreH.SklLvl(8, (byte)2);
                     ali = 0;
                     boolean may = false;
                     if (STRo == 0 && MNDo > 0) {
                        may = true;
                        ali = MNDo;
                     } else if (STRo == 1 && CON > 0) {
                        may = true;
                        ali = CON;
                     } else if (STRo == 2 && SPI > 0) {
                        may = true;
                        ali = SPI;
                     } else if (STRo == 3 && aea > 0) {
                        may = true;
                        ali = aea;
                     } else if (STRo == 4 && awa > 0) {
                        may = true;
                        ali = awa;
                     } else if (STRo > 4) {
                        may = true;
                        ali = WILo;
                     }

                     double d = (double)((float)WIL / 50.0F);
                     WIL = (int)(d * 20.0D + d * (double)((float)WILo * 2.0F + (float)ali));
                     WIL = WIL < 1 ? 1 : WIL;
                     double cost1000 = (double)DEX * 0.01D * 1000.0D;
                     t = (int)(cost1000 - cost1000 * 0.25D * (double)STR + (i == 0 ? cost1000 * 0.20000000298023224D : 0.0D));
                     stat = (int)(20.0D + cost1000 / 2.0D);
                     StatIncreaseDescVit = may ? "§8" : "§4";
                     statNam = JRMCoreH.trl("nc", techEffects[STRo]);
                     var8.func_78276_b("§0" + techName[0] + ": " + StatIncreaseDescVit + Class, guiLeft + 5, guiTop + 15 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[ClassDesc.contains("1") ? 1 : 2] + ": " + StatIncreaseDescVit + (ClassDesc.contains("1") ? techAcquired[Integer.parseInt(ClassDesc)] : buttonText), guiLeft + 5, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[3] + ": " + StatIncreaseDescVit + techTypes[i], guiLeft + 5, guiTop + 15 + 16 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[5] + ": " + StatIncreaseDescVit + (may ? WIL + " " + statNam + " " + JRMCoreH.techNCSpeed[STR + (i == 2 ? 1 : 0)] : "No " + statNam + " Affinity!"), guiLeft + 120, guiTop + 15 + 0 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[8] + ": " + StatIncreaseDescVit + JRMCoreH.techNCHS(j), guiLeft + 120, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[7] + ": " + StatIncreaseDescVit + DEXo + " (" + DEX + "%)", guiLeft + 120, guiTop + 15 + 16 + i * 35, 0);
                  }

                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(240 + i, guiLeft - 10, guiTop + 10 + i * 35, "^"));
                  this.field_146292_n.add(new JRMCoreGuiButtons00(252 + i, guiLeft + 260, guiTop + 11 + i * 35, 60, 12, JRMCoreH.trl("jrmc", "Teach"), 0));
                  this.field_146292_n.add(new JRMCoreGuiButtons00(244 + i, guiLeft + 260, guiTop + 25 + i * 35, 60, 12, JRMCoreH.trl("jrmc", "Unlearn"), 0));
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(248 + i, guiLeft - 10, guiTop + 30 + i * 35, "v"));
               }
            }

            if (this.pwr != 2 && this.pwr != 1) {
               this.attViwPg = 0;
            } else {
               Race = JRMCoreH.trl("jrmc", "Next");
               possibleReward = this.field_146289_q.func_78256_a(Race) + 8;
               this.field_146292_n.add(new JRMCoreGuiButtons00(120 + this.attViwPg + 1, posX + 122 - possibleReward, posY - 100, possibleReward, 20, Race, 0));
            }
         } else if (this.attViwPg == 1) {
            for(i = 0; i < 4; ++i) {
               if (JRMCoreH.techsPM(i) >= 0) {
                  if (this.pwr == 2) {
                     j = JRMCoreH.pmj[JRMCoreH.techsPM(i)];
                  } else {
                     j = JRMCoreH.pmdbc[JRMCoreH.techsPM(i)];
                  }

                  Class = j[0];
                  ClassDesc = j[1];
                  owner = Integer.parseInt(j[2]);
                  Stats = j[3];
                  speed = j[4];
                  TRState = j[5];
                  TransNms = j[6];
                  s = j[7];
                  StatIncreaseDesc2 = j[8];
                  StatIncreaseDesc3 = j[9];
                  StatIncreaseDesc4 = j[10];
                  StatIncreaseDesc5 = j[11];
                  Attributes = "";
                  TP = "";
                  TrainingPoints = "";
                  if (j.length > 12) {
                     Attributes = j[12];
                     TP = j[13];
                     TrainingPoints = j[14];
                  }

                  may = false;
                  int lvl = false;
                  upg = false;
                  sts = JRMCoreH.techDBCstatsDefault;
                  if (j.length > 16) {
                     i = Integer.parseInt(j[16]);
                     lvl = Integer.parseInt(j[17]);
                     i = Integer.parseInt(j[18]);
                     sts = JRMCoreH.tech_statmods(j[19]);
                  }

                  if (this.pwr == 1) {
                     JRMCoreClient.bars.renderEnSideBar();
                     i = Integer.parseInt(TRState);
                     STR = 0;
                     STRo = (int)((float)(Integer.parseInt(s) * JRMCoreH.curRelease) * 0.02F * (float)(JRMCoreH.State / 2 + 1));
                     if (Integer.parseInt(Stats) == 0) {
                        i = (int)((float)i * 0.5F);
                        STR = (int)((float)STR * 0.5F);
                     }

                     i = i < 1 ? 1 : i;
                     STR = STR < 1 ? 1 : STR;
                     boolean v = JRMCoreH.StusEfctsMe(10) || JRMCoreH.StusEfctsMe(11);
                     var10000 = JRMCoreH.PlyrAttrbts[3];
                     WIL = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, v, JRMCoreH.getMajinAbsorption());
                     WILo = JRMCoreH.stat(mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     MND = JRMCoreH.techDBCdmg(j, WILo, sts);
                     JRMCoreH.techDBCkic(j, WILo, sts);
                     CON = JRMCoreH.techDBCtpc(j, false);
                     h3 = JRMCoreH.techDBCct(j, sts);
                     h4 = JRMCoreH.techDBCcd(j, sts);
                     kipow = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][4]);
                     c = "§0";
                     Class = JRMCoreH.trl("dbc", Class);
                     aea = (int)((double)MND * 0.01D * (double)JRMCoreH.curRelease);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[0]) + ": §8" + Class, guiLeft + 5, guiTop + 15 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[3]) + ": §8" + techTypes[Integer.parseInt(Stats)], guiLeft + 5, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[5]) + ": §8" + aea + " (" + JRMCoreH.curRelease + "%)", guiLeft + 120, guiTop + 15 + 0 + i * 35, 0);
                     var8.func_78276_b(c + JRMCoreH.trl("dbc", techName[7]) + ": §8" + JRMCoreH.techDBCkic(j, WILo, sts), guiLeft + 120, guiTop + 15 + 8 + i * 35, 0);
                     exps = c + JRMCoreH.trl("dbc", techName[0]) + ": §8" + Class + "\n" + c + JRMCoreH.trl("dbc", techName[ClassDesc.contains("1") ? 1 : 2]) + ": §8" + (ClassDesc.contains("1") ? JRMCoreH.trl("jrmc", techAcquired[Integer.parseInt(ClassDesc)]) : JRMCoreH.Masters[owner]) + "\n" + c + JRMCoreH.trl("dbc", techName[3]) + ": §8" + JRMCoreH.trl("dbc", techTypes[Integer.parseInt(Stats)]) + "\n" + c + JRMCoreH.trl("dbc", techName[5]) + ": §8" + aea + " (" + JRMCoreH.trl("dbc", "maxDmgDesc") + ")\n" + c + JRMCoreH.trl("dbc", "potDmg") + ": §8" + MND + "\n" + c + JRMCoreH.trl("dbc", techName[4]) + ": §8" + JRMCoreH.trl("jrmc", techEffects[Integer.parseInt(speed)]) + "\n" + c + JRMCoreH.trl("dbc", techName[8]) + ": §8" + JRMCoreH.round(h3, 1) + " sec\n" + c + JRMCoreH.trl("dbc", techName[9]) + ": §8" + JRMCoreH.round(h4, 1) + " sec\n" + c + JRMCoreH.trl("dbc", techName[7]) + ": §8" + JRMCoreH.techDBCkic(j, WILo, sts);
                     drawDetails(JRMCoreH.cct(exps), guiLeft + 5, guiTop + 15 + i * 35 + 1, 240, 20, x, y, this.field_146289_q);
                  }

                  if (this.pwr == 2) {
                     i = Integer.parseInt(Stats);
                     STR = Integer.parseInt(speed);
                     STRo = Integer.parseInt(TransNms);
                     DEX = Integer.parseInt(StatIncreaseDesc5);
                     DEXo = JRMCoreH.techNCCostP[Integer.parseInt(s)];
                     WIL = (int)((double)DEXo * 0.01D * (double)JRMCoreH.maxEnergy);
                     WIL = WIL < 1 ? 1 : WIL;
                     WILo = (int)((float)WIL - (float)WIL * 0.25F * (float)STR + (i == 0 ? (float)WIL * 0.2F : 0.0F));
                     MND = JRMCoreH.SklLvl(1, (byte)2);
                     MNDo = JRMCoreH.SklLvl(2, (byte)2);
                     CON = JRMCoreH.SklLvl(9, (byte)2);
                     SPI = JRMCoreH.SklLvl(3, (byte)2);
                     aea = JRMCoreH.SklLvl(4, (byte)2);
                     awa = JRMCoreH.SklLvl(5, (byte)2);
                     ali = JRMCoreH.SklLvl(6, (byte)2);
                     aea = JRMCoreH.SklLvl(7, (byte)2);
                     awa = JRMCoreH.SklLvl(8, (byte)2);
                     af = 0;
                     may = false;
                     if (STRo == 0 && aea > 0) {
                        may = true;
                        af = aea;
                     } else if (STRo == 1 && awa > 0) {
                        may = true;
                        af = awa;
                     } else if (STRo == 2 && ali > 0) {
                        may = true;
                        af = ali;
                     } else if (STRo == 3 && aea > 0) {
                        may = true;
                        af = aea;
                     } else if (STRo == 4 && awa > 0) {
                        may = true;
                        af = awa;
                     } else if (STRo > 4) {
                        may = true;
                        af = MND;
                     }

                     double d1;
                     if (DEX == 1) {
                        d1 = (double)((float)WILo / 50.0F);
                        WILo = (int)(d1 * 20.0D + d1 * (double)((float)MND * 2.0F + (float)af));
                        WILo = WILo < 1 ? 1 : WILo;
                     }

                     String c;
                     if (DEX == 2) {
                        c = JRMCoreH.ncCSkls[JRMCoreH.Class];
                        t = 0;
                        if (JRMCoreH.PlyrSkillY.contains(c) && c.equals("SG")) {
                           t = Integer.parseInt(JRMCoreH.PlyrSkillY.replaceAll(c, ""));
                        }

                        double d1 = (double)((float)WILo / 15.0F);
                        WILo = (int)(d1 * 5.0D + d1 * (double)MNDo);
                        WILo = WILo < 1 ? 1 : WILo;
                        WILo = (int)((double)WILo * (1.0D + (double)t * 0.1D));
                     }

                     if (DEX == 4) {
                        d1 = (double)((float)WILo / 50.0F);
                        WILo = (int)(d1 * 20.0D + d1 * (double)((float)MND * 2.0F + (float)af));
                        WILo = (int)((double)WILo * (STRo == 7 ? 1.0D : 0.5D));
                        WILo = WILo < 1 ? 1 : WILo;
                     }

                     if (DEX == 5) {
                        d1 = (double)((float)WILo / 50.0F);
                        WILo = (int)(d1 * 20.0D + d1 * (double)((float)CON * 2.0F + (float)SPI));
                        WILo = WILo < 1 ? 1 : WILo;
                     }

                     c = may ? "§8" : "§4";
                     double cost1000 = (double)DEXo * 0.01D * 1000.0D;
                     int dmg1000 = (int)(cost1000 - cost1000 * 0.25D * (double)STR + (i == 0 ? cost1000 * 0.20000000298023224D : 0.0D));
                     costTp = (int)(20.0D + cost1000 / 2.0D);
                     Class = JRMCoreH.trl("nc", Class);
                     nameEffect = JRMCoreH.trl("nc", techEffects[STRo]);
                     var8.func_78276_b("§0" + techName[0] + ": " + c + Class, guiLeft + 5, guiTop + 15 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[ClassDesc.contains("1") ? 1 : 2] + ": " + c + (ClassDesc.contains("1") ? techAcquired[Integer.parseInt(ClassDesc)] : JRMCoreH.trl("nc", JRMCoreH.MastersNC[owner])), guiLeft + 5, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[3] + ": " + c + techTypes[i], guiLeft + 5, guiTop + 15 + 16 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[5] + ": " + c + (may ? WILo + " " + nameEffect + " " + JRMCoreH.techNCSpeed[STR + (i == 2 ? 1 : 0)] : "No " + nameEffect + " Affinity!"), guiLeft + 120, guiTop + 15 + 0 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[8] + ": " + c + (StatIncreaseDesc2.equals("0") ? "Jutsu selector" : StatIncreaseDesc2), guiLeft + 120, guiTop + 15 + 8 + i * 35, 0);
                     var8.func_78276_b("§0" + techName[7] + ": " + c + WIL + " (" + DEXo + "%)", guiLeft + 120, guiTop + 15 + 16 + i * 35, 0);
                     JRMCoreH.txt("Hover over and release " + Keyboard.getKeyName(NCKeyHandler.HandSeal1.func_151463_i()), JRMCoreH.cldgy, 0, true, 0, 0, 180);
                     tt = JRMCoreH.cldr + techName[0] + ": " + c + Class + "\n" + (StatIncreaseDesc2.equals("0") ? JRMCoreH.cldr + techName[8] + ": " + c + "None\n" + JRMCoreH.cldr + "Usage: " + JRMCoreH.cldg + "You must use the special jutsu selector on the right side.\n" + JRMCoreH.cldgy + JRMCoreH.cldr + "Keys: " + JRMCoreH.cldgy + "Press and Hold " + JRMCoreH.cllr + JRMCoreHC.getKey(JRMCoreKeyHandler.Fn.func_151463_i()) + ", " + JRMCoreH.cldgy + "then either press " + JRMCoreH.clpr + JRMCoreHC.getKey(mc.field_71474_y.field_74322_I.func_151463_i()) + JRMCoreH.cldgy + " or use the Mouse Wheel to choose a special jutsu.\nTo Activate the selected jutsu Press " + JRMCoreH.clbe + JRMCoreHC.getKey(JRMCoreKeyHandler.KiAscend.func_151463_i()) + JRMCoreH.cldgy : JRMCoreH.cldr + techName[8] + ": " + c + StatIncreaseDesc2 + "\n" + JRMCoreH.cldr + "Usage: " + JRMCoreH.cldg + "Combination of the \"Hand Seal\" keys\n" + JRMCoreH.cldr + "Keys: " + JRMCoreH.cldgy + JRMCoreH.cllr + JRMCoreHC.getKey(NCKeyHandler.HandSeal1.func_151463_i()) + JRMCoreH.cldgy + ", " + JRMCoreH.clpr + JRMCoreHC.getKey(NCKeyHandler.HandSeal2.func_151463_i()) + JRMCoreH.cldgy + ", " + JRMCoreH.clbe + JRMCoreHC.getKey(NCKeyHandler.HandSeal2.func_151463_i()));
                     drawDetails(JRMCoreH.cct(tt), guiLeft + 5, guiTop + 15 + i * 35 + 1, 240, 20, x, y, this.field_146289_q);
                  }

                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(240 + i, guiLeft - 10, guiTop + 10 + i * 35, "^"));
                  this.field_146292_n.add(new JRMCoreGuiButtons00(244 + i, guiLeft + 260, guiTop + 25 + i * 35, 60, 20, JRMCoreH.trl("jrmc", "Unlearn"), 0));
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(248 + i, guiLeft - 10, guiTop + 30 + i * 35, "v"));
               } else if (this.pwr == 2) {
                  this.field_146292_n.add(new JRMCoreGuiButtons00(200 + i, guiLeft + 85, guiTop + 25 + i * 35, 60, 20, JRMCoreH.trl("jrmc", "Learn"), 0));
               }
            }

            if (this.pwr != 2 && this.pwr != 1) {
               this.attViwPg = 0;
            } else {
               this.field_146292_n.add(new JRMCoreGuiButtons00(120 + this.attViwPg - 1, posX - 120, posY - 100, 40, 20, JRMCoreH.trl("jrmc", "Prev"), 0));
            }
         }
      } else {
         this.attViwPg = 0;
      }

      if (this.isGUIOpen(13)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         String[] techName;
         if (JRMCoreH.Pwrtyp == 2) {
            techName = JRMCoreH.techNCName;
            techName = JRMCoreH.techNCTypes;
            techTypes = JRMCoreH.techNCAcquired;
            techAcquired = JRMCoreH.techNCSpeed;
            techEffects = JRMCoreH.techNCEffects;
            raceName = "nc";
         } else {
            techName = JRMCoreH.techDBCName;
            techName = JRMCoreH.techDBCTypes;
            techTypes = JRMCoreH.techDBCAcquired;
            techAcquired = JRMCoreH.techDBCSpeed;
            techEffects = JRMCoreH.techDBCEffects;
            raceName = "dbc";
         }

         limit = 0;
         if (this.pwr == 1) {
            limit = this.field_146289_q.func_78256_a(JRMCoreH.trl("dbc", techName[0]));
         }

         ++this.text;
         if (this.text == 1 && this.attCrtPg == 0) {
            this.name(var8, guiLeft - (this.pwr == 1 ? 65 : 0) + limit, guiTop - (this.pwr == 1 ? 2 : 0));
            if (this.pwr == 1) {
               this.inputField.func_146180_a(JRMCoreH2.kiAttNamGen() + " " + JRMCoreH.trl("dbc", JRMCoreH.techDBCTypes[techCrt[3]]));
            }

            if (this.pwr == 2) {
               this.inputField.func_146180_a(JRMCoreH2.kiAttNamGen() + " " + JRMCoreH.trl("nc", JRMCoreH.techNCTypes[techCrt[3]]));
            }
         } else {
            this.text = 2;
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         if (this.inputField != null && this.attCrtPg == 0) {
            this.inputField.func_146194_f();
            JRMCoreGuiScreen.name = this.inputField.func_146179_b();
         }

         String[] tech;
         if (this.pwr == 1) {
            type = this.attCrtPg == 0 ? 0 : (this.attCrtPg == 1 ? 12 : 13);

            while(true) {
               if (type >= (this.attCrtPg == 0 ? 12 : (this.attCrtPg == 1 ? 15 : 20))) {
                  if (this.attCrtPg == 0) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(4890, guiLeft + 140 + limit, guiTop + 15 + 0, "<"));
                  }

                  if (this.attCrtPg == 1) {
                     for(type = 0; type < 3; ++type) {
                        if (techCrt[3] == 3) {
                           if (type == 1) {
                              this.field_146292_n.add(new JRMCoreGuiButtonsA2(190 + type, guiLeft + 215, guiTop + 15 + type * 11, ">"));
                           }
                        } else {
                           this.field_146292_n.add(new JRMCoreGuiButtonsA2(190 + type, guiLeft + 215, guiTop + 15 + type * 11, ">"));
                        }
                     }
                  }

                  type = techCrt[3];
                  reward = techCrt[4];
                  owner = techCrt[6];
                  tech = new String[]{JRMCoreGuiScreen.name, "" + techCrt[1], JRMCoreGuiScreen.owner, "" + techCrt[3], "" + techCrt[4], "" + techCrt[5], "" + techCrt[6], "" + techCrt[7], "" + techCrt[8], "" + techCrt[9], "" + techCrt[10], "" + techCrt[11], "" + techCrt[12], "" + techCrt[13], "" + techCrt[14]};
                  fc = JRMCoreH.StusEfctsMe(10) || JRMCoreH.StusEfctsMe(11);
                  var10000 = JRMCoreH.PlyrAttrbts[3];
                  fcs = JRMCoreH.getPlayerAttribute(JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), JRMCoreH.Pwrtyp, JRMCoreH.PlyrSkills, fc, JRMCoreH.getMajinAbsorption());
                  ni = JRMCoreH.stat(mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, fcs, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                  byte[] sts = JRMCoreH.techDBCstatsDefault;
                  dmg = JRMCoreH.techDBCdmg(tech, ni, sts);
                  cost = JRMCoreH.techDBCkic(tech, ni, sts);
                  skillID = JRMCoreH.techDBCtpc(tech, false);
                  float cast = JRMCoreH.techDBCct(tech, sts);
                  cool = JRMCoreH.techDBCcd(tech, sts);
                  if (type == 6) {
                     dmg = (int)((float)dmg / 5.0F);
                     dmg = (int)((float)dmg / 2.0F);
                     dmg = (int)((float)dmg / 2.0F);
                     cost = (int)((float)cost / 5.0F);
                  } else if (type == 7 || type == 8) {
                     dmg = (int)((float)dmg * 2.0F);
                     if (type == 8 && owner == 1) {
                        dmg = (int)((float)dmg * 3.0F);
                     }
                  }

                  dmg = (int)((double)dmg * JRMCoreConfig.dat5696[type][1]);
                  cost = (int)((double)cost * JRMCoreConfig.dat5696[type][2]);
                  TrainingPoints = JRMCoreH.trl("jrmc", JRMCoreH.attrStat[JRMCoreH.Pwrtyp][4]);
                  RequiredTP = "§8";
                  int px = 20;
                  if (this.attCrtPg == 0) {
                     int i = 0;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[0]) + ": ", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     i = i + 1;
                     var8.func_78276_b((JRMCoreConfig.dat5695[type] ? "" : JRMCoreH.cllr) + JRMCoreH.trl("dbc", techName[3]) + ": " + (JRMCoreConfig.dat5695[type] ? RequiredTP : JRMCoreH.cllr) + JRMCoreH.trl("dbc", techName[techCrt[3]]), guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[4]) + ": " + RequiredTP + JRMCoreH.trl("jrmc", JRMCoreH.techDBCSpeed[techCrt[4] + (type == 2 ? 1 : 0)]) + "", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", type != 7 ? techName[5] : "Shield") + ": " + RequiredTP + dmg + " (" + TrainingPoints + " " + tech[5] + "%)", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b((JRMCoreConfig.dat5709[type] ? "" : JRMCoreH.cllr) + JRMCoreH.trl("dbc", techName[6]) + ": " + (JRMCoreConfig.dat5709[type] ? RequiredTP : JRMCoreH.cllr) + JRMCoreH.trl("jrmc", techEffects[techCrt[6]]) + RequiredTP, guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[7]) + ": " + RequiredTP + cost + " ", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[8]) + ": " + RequiredTP + JRMCoreH.round(cast, 1) + " sec", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[9]) + ": " + RequiredTP + JRMCoreH.round(cool, 1) + " sec", guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[10]) + ": " + RequiredTP + JRMCoreH.trl("jrmc", JRMCoreH.techColName[techCrt[10]]), guiLeft + 10 + px, guiTop + 17 + i * 11, 0);
                     ++i;
                     name = JRMCoreH.trl("jrmc", "Next");
                     i = this.field_146289_q.func_78256_a(name) + 8;
                     this.field_146292_n.add(new JRMCoreGuiButtons00(120 + this.attCrtPg + 1, posX + 130, posY + 40, i, 20, name, 0));
                  } else if (this.attCrtPg == 1) {
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[12]) + ": §8" + (Integer.parseInt(tech[12]) + 1), guiLeft + 10 + px, guiTop + 15 + 0, 0);
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[13]) + ": §8" + (Integer.parseInt(tech[13]) + 1), guiLeft + 10 + px, guiTop + 15 + 11, 0);
                     var8.func_78276_b(JRMCoreH.trl("dbc", techName[14]) + ": §8" + (Integer.parseInt(tech[14]) + 1), guiLeft + 10 + px, guiTop + 15 + 22, 0);
                     AlignmentDesc = JRMCoreH.trl("jrmc", "Prev");
                     nw = this.field_146289_q.func_78256_a(AlignmentDesc) + 8;
                     this.field_146292_n.add(new JRMCoreGuiButtons00(120 + this.attCrtPg - 1, posX - 130 - nw, posY + 40, nw, 20, AlignmentDesc, 0));
                  }

                  var8.func_78276_b("TP Current/Cost: §8" + JRMCoreH.numSep((long)JRMCoreH.curTP) + "/" + JRMCoreH.numSep((long)skillID), guiLeft + 10, guiTop + 15 + 121, 0);
                  this.field_146292_n.add(new JRMCoreGuiButtons00(102, posX - 170, posY + 65, 40, 20, JRMCoreH.trl("jrmc", "Back"), 0));
                  if (skillID <= JRMCoreH.curTP) {
                     this.field_146292_n.add(new JRMCoreGuiButtons00(210, posX + 130, posY + 65, 40, 20, JRMCoreH.trl("jrmc", "Accept"), 0));
                  }

                  if (this.attCrtPg == 0) {
                     AlignmentDesc = "jinryuumodscore:icons5.png";
                     ResourceLocation tx = new ResourceLocation(AlignmentDesc);
                     mc.field_71446_o.func_110577_a(tx);
                     type = techCrt[3];
                     i = techCrt[5];
                     STR = techCrt[6];
                     STRo = techCrt[9];
                     DEX = techCrt[10];
                     DEXo = techCrt[11];
                     WIL = i / 5;
                     int xSize2 = 9;
                     int ySize2 = 9;
                     guiLeft = guiLeft + xSize - xSize2 * 5;
                     guiTop = guiTop + ySize2 + 7;
                     if (STR == 1) {
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                        this.func_73729_b(guiLeft, guiTop, 178, 0, xSize2, ySize2);
                     }

                     MNDo = DEX;
                     if (DEX == 0 && JRMCoreH.align > 66) {
                        MNDo = 2;
                     }

                     if (MNDo == 0 && JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
                        MNDo = 3;
                     }

                     if (MNDo == 0 && JRMCoreH.align < 33) {
                        MNDo = 4;
                     }

                     MNDo = JRMCoreH.techCol[MNDo];
                     float h2 = (float)(MNDo >> 16 & 255) / 255.0F;
                     h3 = (float)(MNDo >> 8 & 255) / 255.0F;
                     h4 = (float)(MNDo & 255) / 255.0F;
                     GL11.glColor4f(h2, h3, h4, 1.0F);
                     this.func_73729_b(guiLeft, guiTop, 187 + WIL / 5 * xSize2, type * ySize2, xSize2, ySize2);
                  }
                  break;
               }

               doit = true;
               if (type == 4 && (techName[techCrt[3]].equals("Shield") || techName[techCrt[3]].equals("Explosion"))) {
                  doit = false;
               }

               if (doit) {
                  if (type > 2 && type != 7 && type != 8 && type != 9 && type != 11) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(-220 - type, guiLeft + 190 - 185, guiTop + 15 + (this.attCrtPg == 0 ? (type - 2) * 11 : (this.attCrtPg == 1 ? (type - 12) * 11 : 0)), "<"));
                  }

                  if (type > 2 && type != 7 && type != 8 && type != 9 && type != 11) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(220 + type, guiLeft + 200 - 185, guiTop + 15 + (this.attCrtPg == 0 ? (type - 2) * 11 : (this.attCrtPg == 1 ? (type - 12) * 11 : 0)), ">"));
                  }
               }

               ++type;
            }
         }

         if (this.pwr == 2) {
            for(type = this.attCrtPg == 0 ? 0 : (this.attCrtPg == 1 ? 12 : 13); type < (this.attCrtPg == 0 ? 12 : (this.attCrtPg == 1 ? 15 : 20)); ++type) {
               if (type > 2 && type != 5 && type != 8 && type != 9 && type != 10 && type != 11) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(-220 - type, guiLeft + 190 - 185, guiTop + 15 + (this.attCrtPg == 0 ? (type - 1) * 11 : (this.attCrtPg == 1 ? (type - 12) * 11 : 0)), "<"));
               }

               if (type > 2 && type != 5 && type != 8 && type != 9 && type != 10 && type != 11) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(220 + type, guiLeft + 200 - 185, guiTop + 15 + (this.attCrtPg == 0 ? (type - 1) * 11 : (this.attCrtPg == 1 ? (type - 12) * 11 : 0)), ">"));
               }
            }

            this.field_146292_n.add(new JRMCoreGuiButtonsA2(195, guiLeft + 215, guiTop + 15 + 0, ">"));
            if (this.attCrtPg == 1) {
               for(type = 0; type < 3; ++type) {
                  this.field_146292_n.add(new JRMCoreGuiButtonsA2(190 + type, guiLeft + 215, guiTop + 15 + type * 11, ">"));
               }
            }

            type = techCrt[3];
            reward = techCrt[4];
            owner = techCrt[6];
            tech = new String[]{JRMCoreGuiScreen.name, "" + techCrt[1], JRMCoreGuiScreen.owner, "" + techCrt[3], "" + techCrt[4], "" + techCrt[5], "" + techCrt[6], "" + techCrt[7], "" + techCrt[8], "" + techCrt[9], "" + techCrt[10], "" + techCrt[11], "" + techCrt[12], "" + techCrt[13], "" + techCrt[14]};
            costP = JRMCoreH.techNCCostP[techCrt[7]];
            cls = (int)((double)costP * 0.01D * (double)JRMCoreH.maxEnergy);
            cls = cls < 1 ? 1 : cls;
            fcs = (int)((float)cls - (float)cls * 0.25F * (float)reward + (type == 0 ? (float)cls * 0.2F : 0.0F));
            ni = JRMCoreH.SklLvl(1, (byte)2);
            sw = JRMCoreH.SklLvl(2, (byte)2);
            dmg = JRMCoreH.SklLvl(4, (byte)2);
            cost = JRMCoreH.SklLvl(5, (byte)2);
            skillID = JRMCoreH.SklLvl(6, (byte)2);
            sw = JRMCoreH.SklLvl(7, (byte)2);
            int awa = JRMCoreH.SklLvl(8, (byte)2);
            n2 = 0;
            may = false;
            if (owner == 0 && dmg > 0) {
               may = true;
               n2 = dmg;
            } else if (owner == 1 && cost > 0) {
               may = true;
               n2 = cost;
            } else if (owner == 2 && skillID > 0) {
               may = true;
               n2 = skillID;
            } else if (owner == 3 && sw > 0) {
               may = true;
               n2 = sw;
            } else if (owner == 4 && awa > 0) {
               may = true;
               n2 = awa;
            } else if (owner > 4) {
               may = true;
               n2 = ni;
            }

            float d = (float)fcs / 50.0F;
            fcs = (int)(d * 20.0F + d * ((float)ni * 2.0F + (float)n2));
            fcs = fcs < 1 ? 1 : fcs;
            AlignmentDesc = may ? "§8" : "§4";
            double cost1000 = (double)costP * 0.01D * 1000.0D;
            STR = (int)(cost1000 - cost1000 * 0.25D * (double)reward + (type == 0 ? cost1000 * 0.20000000298023224D : 0.0D));
            STRo = (int)(20.0D + cost1000 / 2.0D);
            int px = 20;
            if (this.attCrtPg == 0) {
               var8.func_78276_b(techName[0] + ": ", guiLeft + 10 + px, guiTop + 17 + 0, 0);
               var8.func_78276_b(techName[2] + ": " + AlignmentDesc + JRMCoreGuiScreen.owner, guiLeft + 10 + px, guiTop + 17 + 11, 0);
               var8.func_78276_b(techName[3] + ": " + AlignmentDesc + techName[techCrt[3]], guiLeft + 10 + px, guiTop + 17 + 22, 0);
               var8.func_78276_b(techName[4] + ": " + AlignmentDesc + JRMCoreH.techNCSpeed[techCrt[4] + (type == 2 ? 1 : 0)] + "", guiLeft + 10 + px, guiTop + 17 + 33, 0);
               var8.func_78276_b(techName[5] + ": " + AlignmentDesc + (may ? fcs + " §0->with 1000 Chakra: " + AlignmentDesc + STR : "No Affinity!"), guiLeft + 10 + px, guiTop + 17 + 44, 0);
               var8.func_78276_b(techName[6] + ": " + AlignmentDesc + JRMCoreH.trl(raceName, techEffects[techCrt[6]]), guiLeft + 10 + px, guiTop + 17 + 55, 0);
               var8.func_78276_b(techName[7] + ": " + AlignmentDesc + cls + " (" + costP + "%)", guiLeft + 10 + px, guiTop + 17 + 66, 0);
               var8.func_78276_b(techName[8] + ": " + AlignmentDesc + JRMCoreH.techNCHS(tech) + "", guiLeft + 10 + px, guiTop + 17 + 77, 0);
            } else if (this.attCrtPg == 1) {
            }

            var8.func_78276_b("TP Current/Cost: §8" + JRMCoreH.numSep((long)JRMCoreH.curTP) + "/" + JRMCoreH.numSep((long)STRo), guiLeft + 10, guiTop + 15 + 121, 0);
            this.field_146292_n.add(new JRMCoreGuiButtons00(102, posX - 170, posY + 65, 40, 20, JRMCoreH.trl("jrmc", "Back"), 0));
            if (STRo <= JRMCoreH.curTP) {
               this.field_146292_n.add(new JRMCoreGuiButtons00(210, posX + 130, posY + 65, 40, 20, JRMCoreH.trl("jrmc", "Accept"), 0));
            }
         }
      } else {
         this.text = 0;
         this.attCrtPg = 0;
      }

      if (this.isGUIOpen(15)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         String[][] PMA;
         if (this.pwr == 2) {
            PMA = JRMCoreH.pmj;
            mod = "nc";
         } else {
            PMA = JRMCoreH.pmdbc;
            mod = "dbc";
         }

         var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
         gender = 0;
         xPos = PMA.length;

         for(i = 0; i < xPos; ++i) {
            if (gender <= 13 + this.ipg * 13 && gender >= 0 + this.ipg * 13) {
               Race = JRMCoreH.trl(mod, PMA[i][0]);
               possibleReward = this.field_146289_q.func_78256_a(Race);
               var8.func_78276_b(Race, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, 0);
               Class = JRMCoreH.techOwnd(i, this.pwr) ? " " + JRMCoreH.trl("jrmc", "Owned") : "";
               reward = this.field_146289_q.func_78256_a(Class);
               var8.func_78276_b(Class, guiLeft + xSize / 2 - 122 + possibleReward, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
               if (!JRMCoreH.techOwnd(i, this.pwr)) {
                  owner = JRMCoreH.techNCCostP[Integer.parseInt(PMA[i][7])];
                  double cost1000 = (double)owner * 0.01D * 1000.0D;
                  cls = Integer.parseInt(PMA[i][4]);
                  fcs = Integer.parseInt(PMA[i][3]);
                  ni = (int)(cost1000 - cost1000 * 0.25D * (double)cls + (fcs == 0 ? cost1000 * 0.20000000298023224D : 0.0D));
                  sw = (int)(20.0D + cost1000 / 2.0D);
                  dmg = (int)((float)sw * 1.5F);
                  StatIncreaseDesc4 = " " + dmg + " tp";
                  skillID = this.field_146289_q.func_78256_a(Race);
                  if (JRMCoreH.curTP >= dmg) {
                     this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, this.pwr) ? 4200 + i : -1, guiLeft + xSize / 2 - 122 + possibleReward + reward, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, skillID, StatIncreaseDesc4, JRMCoreH.techNCCol[1]));
                  } else {
                     var8.func_78276_b(StatIncreaseDesc4, guiLeft + xSize / 2 - 122 + possibleReward + reward, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                  }
               }
            }

            ++gender;
         }

         int NC_Page_Limit = true;
         if (gender > 14 + this.lp * 14) {
            Race = JRMCoreH.trl("jrmc", "Next");
            this.field_146292_n.add(new JRMCoreGuiButtons00(88, guiLeft + xSize / 2 + 130, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(Race) + 8, 20, Race, 0));
         }

         if (this.lp != 0) {
            Race = JRMCoreH.trl("jrmc", "Prev");
            possibleReward = this.field_146289_q.func_78256_a(Race) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(89, guiLeft + xSize / 2 - 130 - possibleReward, guiTop + (ySize + 1) / 2 + 15, possibleReward, 20, Race, 0));
         }
      } else {
         this.lp = 0;
      }

      if (this.isGUIOpen(16)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
         if (this.pwr == 2) {
            techName = JRMCoreH.NCSkillNames;
            rSklsLvl = JRMCoreH.NCSkillTPCost;
            SklsMR = JRMCoreH.NCSkillMindCost;
            techEffects = JRMCoreH.NCSkillIDs;
            mod = "nc";
         } else {
            techName = JRMCoreH.DBCSkillNames;
            rSklsLvl = JRMCoreH.DBCSkillTPCost;
            SklsMR = JRMCoreH.DBCSkillMindCost;
            techEffects = JRMCoreH.DBCSkillsIDs;
            mod = "dbc";
         }

         var8.func_78276_b(JRMCoreH.numSep((long)JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
         limit = 0;
         possibleReward = techName.length;

         for(byte i = 0; i < possibleReward; ++i) {
            if (limit <= 13 + this.ipg * 13 && limit >= 0 + this.ipg * 13) {
               ClassDesc = JRMCoreH.trl(mod, techName[i]);
               owner = this.field_146289_q.func_78256_a(ClassDesc);
               var8.func_78276_b(ClassDesc, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, 0);
               Stats = JRMCoreH.SklLvl(i, this.pwr) < 1 ? "" : " " + JRMCoreH.trl("jrmc", "Owned");
               costP = this.field_146289_q.func_78256_a(Stats);
               var8.func_78276_b(Stats, guiLeft + xSize / 2 - 122 + owner, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
               if (JRMCoreH.SklLvl(i, this.pwr) < 1) {
                  cls = JRMCoreH.getSkillTPCost(i, 0, JRMCoreH.isPowerTypeKi());
                  TransNms = " " + cls + " tp";
                  ni = JRMCoreH.skillMindRequirement(techEffects[i], techEffects, SklsMR);
                  StatIncreaseDesc2 = " " + JRMCoreH.trl("jrmc", "Mind") + ": " + ni;
                  dmg = this.field_146289_q.func_78256_a(ClassDesc);
                  cost = JRMCoreH.skillSlot_MindUsed() + ni;
                  boolean ssm = JRMCoreH.canAffordSkill(JRMCoreH.statMindC(), cost);
                  if (cls != -1 && JRMCoreH.curTP >= cls && ssm) {
                     this.field_146292_n.add(new JRMCoreGuiButtons01(JRMCoreH.SklLvl(i, this.pwr) < 1 ? 4000 + i : -1, guiLeft + xSize / 2 - 122 + owner + costP, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, dmg, TransNms, JRMCoreH.techNCCol[1]));
                  } else {
                     var8.func_78276_b(TransNms, guiLeft + xSize / 2 - 122 + owner + costP, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                  }

                  var8.func_78276_b(StatIncreaseDesc2, guiLeft + xSize / 2 - 122 + owner + costP + this.field_146289_q.func_78256_a(TransNms), guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, ssm ? '耀' : JRMCoreH.techNCCol[0]);
               }
            }

            ++limit;
         }

         if (limit > 13 + this.lp * 13) {
            Class = JRMCoreH.trl("jrmc", "Next");
            this.field_146292_n.add(new JRMCoreGuiButtons00(88, guiLeft + xSize / 2 + 130, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(Class) + 8, 20, Class, 0));
         }

         if (this.lp != 0) {
            Class = JRMCoreH.trl("jrmc", "Prev");
            reward = this.field_146289_q.func_78256_a(Class) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(89, guiLeft + xSize / 2 - 130 - reward, guiTop + (ySize + 1) / 2 + 15, reward, 20, Class, 0));
         }
      } else {
         this.lp = 0;
      }

      if (this.isGUIOpen(17)) {
         xSize = 256;
         ySize = 159;
         guiLeft = (this.field_146294_l - xSize) / 2;
         guiTop = (this.field_146295_m - ySize) / 2;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         guiLocation = new ResourceLocation(wish);
         mc.field_71446_o.func_110577_a(guiLocation);
         this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
         this.menuButtons("TR");
         s = " " + JRMCoreH.trl("jrmc", "Start");
         i = this.field_146289_q.func_78256_a(s);
         il = 0;
         ir = false;
         raceName = JRMCoreH.trl("jrmc", "Training");
         Race = JRMCoreH.trl("jrmc", "TrainingDesc");
         drawDetails(raceName, JRMCoreH.cct(Race, JRMCoreHC.BPC_ME2), guiLeft + 5, guiTop + 5 + il * 15, x, y, var8);
         gender = il + 1;
         raceName = JRMCoreH.TrnngOptnsNam(0);
         Race = JRMCoreH.TrnngOptnsDesc(0);
         possibleReward = this.field_146289_q.func_78256_a(raceName);
         this.field_146292_n.add(new JRMCoreGuiButtons01(-30, guiLeft + 5 + possibleReward, guiTop + 5 + gender * 15, i, s, JRMCoreH.techNCCol[1]));
         drawDetails(raceName, JRMCoreH.cct(Race), guiLeft + 5, guiTop + 5 + gender * 15, x, y, var8);
         ++gender;
         raceName = JRMCoreH.TrnngOptnsNam(1);
         Race = JRMCoreH.TrnngOptnsDesc(1);
         possibleReward = this.field_146289_q.func_78256_a(raceName);
         this.field_146292_n.add(new JRMCoreGuiButtons01(-31, guiLeft + 5 + possibleReward, guiTop + 5 + gender * 15, i, s, JRMCoreH.techNCCol[1]));
         drawDetails(raceName, JRMCoreH.cct(Race), guiLeft + 5, guiTop + 5 + gender * 15, x, y, var8);
         ++gender;
         raceName = JRMCoreH.TrnngOptnsNam(3);
         Race = JRMCoreH.TrnngOptnsDesc(3);
         possibleReward = this.field_146289_q.func_78256_a(raceName);
         this.field_146292_n.add(new JRMCoreGuiButtons01(-34, guiLeft + 5 + possibleReward, guiTop + 5 + gender * 15, i, s, JRMCoreH.techNCCol[1]));
         drawDetails(raceName, JRMCoreH.cct(Race), guiLeft + 5, guiTop + 5 + gender * 15, x, y, var8);
         ++gender;
      } else {
         String[] var319;
         if (this.isGUIOpen(18)) {
            xSize = 256;
            ySize = 159;
            guiLeft = (this.field_146294_l - xSize) / 2;
            guiTop = (this.field_146295_m - ySize) / 2;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            guiLocation = new ResourceLocation(MiniGame.training1gui);
            mc.field_71446_o.func_110577_a(guiLocation);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
            guiLeft += 5;
            guiTop += 5;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            guiLocation = new ResourceLocation(MiniGame.training1);
            mc.field_71446_o.func_110577_a(guiLocation);
            this.miniGameConcentration.stateManager(guiLeft, guiTop);
            this.field_146292_n.add(new JRMCoreGuiButtonsMG0(-32, guiLeft, guiTop, 150, 150, "", 0));
            i = 0;
            COLOR_ID = true;
            var319 = new String[5];
            MiniGameConcentration var10003 = this.miniGameConcentration;
            var319[0] = MiniGameConcentration.States[this.miniGameConcentration.state];
            var319[1] = "Lives: " + this.miniGameConcentration.lives;
            var319[2] = "Level: " + this.miniGameConcentration.lvl;
            var319[3] = "Score: " + this.miniGameConcentration.score;
            var319[4] = this.miniGameConcentration.temporaryMessage;
            techAcquired = var319;
            xPos = guiLeft + 155;
            techEffects = techAcquired;
            limit = techAcquired.length;

            for(possibleReward = 0; possibleReward < limit; ++possibleReward) {
               Class = techEffects[possibleReward];
               drawStringWithBorder(var8, Class, xPos, guiTop + 10 + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
            }

            ++i;
            xPos = (int)((float)JGConfigMiniGameConcentration.TPDailyLimit * (JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel > 0.0F ? (float)JRMCoreH.getPlayerLevel(JRMCoreH.PlyrAttrbts) * JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel : 1.0F));
            if (JGConfigMiniGameConcentration.TPGainOn) {
               drawStringWithBorder(var8, "Used limit: " + JRMCoreH.trngTPlmt + "/" + xPos, xPos, guiTop + 10 + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
            }

            if (this.miniGameConcentration.state == 3) {
               limit = (int)((float)this.miniGameConcentration.score * JGConfigMiniGameConcentration.TPMultiplier);
               if (JGConfigMiniGameConcentration.TPGainOn && limit > 0) {
                  possibleReward = JRMCoreH.trngTPlmt + limit;
                  type = limit;
                  if (xPos < possibleReward) {
                     type = limit - (possibleReward - xPos);
                  }

                  drawStringWithBorder(var8, "Reward: " + type + " TP", xPos, guiTop + 10 + i * 10, JRMCoreH.techNCCol[6]);
                  ++i;
                  ClassDesc = "Claim TP";
                  owner = this.field_146289_q.func_78256_a(ClassDesc);
                  this.field_146292_n.add(new JRMCoreGuiButtons00(-33, xPos + 10, guiTop + 10 + i * 10 + 10, owner + 10, 20, ClassDesc, 0));
                  ++i;
               }
            }

            if (this.miniGameConcentration.state == 2) {
               drawStringWithBorder(var8, "TP gain: " + (JGConfigMiniGameConcentration.TPGainOn ? "Enabled" : "Disabled"), xPos, guiTop + 10 + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
               limit = (int)((float)this.miniGameConcentration.score * JGConfigMiniGameConcentration.TPMultiplier);
               if (JGConfigMiniGameConcentration.TPGainOn && limit > 0) {
                  possibleReward = JRMCoreH.trngTPlmt + limit;
                  type = limit;
                  if (xPos < possibleReward) {
                     type = limit - (possibleReward - xPos);
                  }

                  drawStringWithBorder(var8, "Reward: " + type + " TP", xPos, guiTop + 10 + i * 10, JRMCoreH.techNCCol[6]);
                  ++i;
                  ClassDesc = "Claim TP";
                  owner = this.field_146289_q.func_78256_a(ClassDesc);
                  this.field_146292_n.add(new JRMCoreGuiButtons00(-33, xPos + 10, guiTop + 10 + i * 10 + 10, owner + 10, 20, ClassDesc, 0));
                  ++i;
               }
            }
         } else if (this.isGUIOpen(10002)) {
            xSize = 256;
            ySize = 159;
            guiLeft = (this.field_146294_l - xSize) / 2;
            guiTop = (this.field_146295_m - ySize) / 2;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            guiLocation = new ResourceLocation(MiniGame.training1gui);
            mc.field_71446_o.func_110577_a(guiLocation);
            this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
            if (JGConfigClientSettings.airboxing3DCharacterOn) {
               if (this.entityTest == null) {
                  this.entityTest = new EntityNull((World)null);
               }

               func_110423_a(guiLeft + 35, guiTop + 23, 45, 0.0F, 0.0F, this.entityTest, false, false, false);
            } else if (this.entityTest != null) {
               this.entityTest = null;
            }

            i = this.miniGameAirBoxing.comboCounter;
            if (JGConfigClientSettings.airboxing3DAuraOn) {
               if (this.entityTests2 == null) {
                  this.entityTests2 = new ArrayList();
                  this.timer = Instant.now();
               }

               if (i > 0 && (float)Duration.between(this.timer, Instant.now()).toMillis() >= (float)(200 / (i / 2 > 20 ? 20 : i / 2 + 1)) && (!JRMCoreClient.mc.field_71439_g.field_70170_p.field_72995_K || !JRMCoreClient.mc.func_147113_T())) {
                  this.timer = Instant.now();
                  i = i / 2 >= 20 ? i / 50 + 1 : 1;
                  if (i > 5) {
                     i = 5;
                  }

                  for(gender = 0; gender < i; ++gender) {
                     this.entityTests2.add(new EntityAuraFlat((World)null));
                  }
               }

               for(i = this.entityTests2.size() - 1; i >= 0; --i) {
                  func_110423_a(guiLeft + 35, guiTop + 23, 45, 0.0F, 0.0F, (EntityLivingBase)this.entityTests2.get(i), false, false, false);
                  if (((EntityAuraFlat)this.entityTests2.get(i)).field_70128_L) {
                     this.entityTests2.remove(i);
                  }
               }
            } else if (this.entityTests2 != null) {
               this.entityTests2 = null;
               this.timer = null;
            }

            this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
            guiLeft += 5;
            guiTop += 5;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            guiLocation = new ResourceLocation(MiniGame.training1);
            mc.field_71446_o.func_110577_a(guiLocation);
            this.miniGameAirBoxing.stateManager(guiLeft, guiTop);
            i = 0;
            int COLOR_ID = true;
            guiTop = guiTop + 5 + 20;
            var319 = new String[5];
            MiniGameAirBoxing var318 = this.miniGameAirBoxing;
            var319[0] = MiniGameAirBoxing.States[this.miniGameAirBoxing.state];
            var319[1] = "Lives: " + this.miniGameAirBoxing.lives;
            var319[2] = "Level: " + this.miniGameAirBoxing.lvl;
            var319[3] = "Score: " + this.miniGameAirBoxing.score;
            var319[4] = i > 0 ? i + "x combo" : "";
            techEffects = var319;
            xPos = guiLeft + 145;
            String[] var189 = techEffects;
            possibleReward = techEffects.length;

            for(type = 0; type < possibleReward; ++type) {
               ClassDesc = var189[type];
               drawStringWithBorder(var8, ClassDesc, xPos, guiTop + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
            }

            ++i;
            limit = (int)((float)JGConfigMiniGameAirBoxing.TPDailyLimit * (JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel > 0.0F ? (float)JRMCoreH.getPlayerLevel(JRMCoreH.PlyrAttrbts) * JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel : 1.0F));
            if (JGConfigMiniGameAirBoxing.TPGainOn) {
               drawStringWithBorder(var8, "Used limit: " + JRMCoreH.trngTPlmt2 + "/" + limit, xPos, guiTop + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
            }

            if (this.miniGameAirBoxing.state == 2) {
               drawStringWithBorder(var8, "TP gain: " + (JGConfigMiniGameAirBoxing.TPGainOn ? "Enabled" : "Disabled"), xPos, guiTop + i * 10, JRMCoreH.techNCCol[6]);
               ++i;
            }

            if (this.miniGameAirBoxing.state == 2 || this.miniGameAirBoxing.state == 3) {
               possibleReward = (int)((float)this.miniGameAirBoxing.score * JGConfigMiniGameAirBoxing.TPMultiplier);
               if (JGConfigMiniGameAirBoxing.TPGainOn && possibleReward > 0) {
                  type = JRMCoreH.trngTPlmt2 + possibleReward;
                  reward = possibleReward;
                  if (limit < type) {
                     reward = possibleReward - (type - limit);
                  }

                  drawStringWithBorder(var8, "Reward: " + reward + " TP", xPos, guiTop + i * 10, JRMCoreH.techNCCol[6]);
                  ++i;
                  buttonText = this.miniGameAirBoxing.state == 2 ? "End Game" : "Claim TP";
                  i = this.field_146289_q.func_78256_a(buttonText);
                  this.field_146292_n.add(new JRMCoreGuiButtons00(this.miniGameAirBoxing.state == 2 ? -35 : -36, xPos + 10, guiTop + i * 10 + 5, i + 10, 20, buttonText, 0));
                  ++i;
               }
            }
         } else if (this.isGUIOpen(10100)) {
            this.drawHUD_instantTransmissionPicker(posX, posY, var5, var6, var8);
         }
      }

      if (JRMCoreH.SAOC()) {
         JRMCoreHSAC.drawScreen(x, y, f);
      }

      super.func_73863_a(x, y, f);
      this.drawDetails(x, y, var8);
   }

   private void drawHUD_instantTransmissionPicker(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      int xSize = 256;
      int ySize = 159;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation guiLocation = new ResourceLocation(pc);
      mc.field_71446_o.func_110577_a(guiLocation);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      String title = "Select a Group Member";
      var8.func_78276_b(title, guiLeft + 5, guiTop + 5, 0);
      int i = 0;
      if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.GIDs != null) {
         for(int pl = 0; pl < (JRMCoreH.plyrs.length < JRMCoreH.GIDs.length ? JRMCoreH.plyrs.length : JRMCoreH.GIDs.length); ++pl) {
            if (JRMCoreH.GIDs[pl] == JRMCoreH.GID) {
               Entity e = mc.field_71441_e.func_72924_a(JRMCoreH.plyrs[pl]);
               String n;
               if (JRMCoreH.plyrs[pl].equalsIgnoreCase(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
                  n = JRMCoreH.plyrs[pl];
                  var8.func_78276_b(n, guiLeft + xSize / 2 - 120, guiTop + (ySize + 1) / 2 - 62 + i * 10 - this.ipg * 14 * 10, 0);
               } else {
                  n = JRMCoreH.plyrs[pl];
                  this.field_146292_n.add(new JRMCoreGuiButtons01(10102 + i, guiLeft + xSize / 2 - 120, guiTop + (ySize + 1) / 2 - 62 + i * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(n), n, 0));
               }

               ++i;
            }
         }
      }

      String back = JRMCoreH.trl("jrmc", "Back");
      int sw = this.field_146289_q.func_78256_a(back) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10101, guiLeft + xSize / 2 - 130 - sw, guiTop + (ySize + 1) / 2 + 40, sw, 20, back, 0));
   }

   private void drawHUD_help(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      int xSize = 256;
      int ySize = 159;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation guiLocation = new ResourceLocation(pc);
      mc.field_71446_o.func_110577_a(guiLocation);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      if (help_mode == 0) {
         this.drawHUD_helpgmodeselect(posX, posY, var5, var6, var8);
      } else if (help_mode == 1) {
         this.drawHUD_helpguidepick(posX, posY, var5, var6, var8);
      } else if (help_mode == 3) {
         this.drawHUD_helpguide(posX, posY, var5, var6, var8);
      } else if (help_mode == 2) {
         this.drawHUD_helpcraft(posX, posY, var5, var6, var8);
      }

   }

   private void drawHUD_helpgmodeselect(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      ResourceLocation gui_help_tab = new ResourceLocation(gui_help_tabs);
      mc.field_71446_o.func_110577_a(gui_help_tab);
      this.func_73729_b(this.guiLeft, this.guiTop + 18, 0, 0, this.xSize, this.ySize);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main") + ": ", this.guiLeft + 10, this.guiTop + 5, 0);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main1_1"), this.guiLeft + 80, this.guiTop + 25, 0);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main1_2"), this.guiLeft + 75, this.guiTop + 35, 0);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main2_1"), this.guiLeft + 80, this.guiTop + 93, 0);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main2_2"), this.guiLeft + 75, this.guiTop + 103, 0);
      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_main2_3"), this.guiLeft + 75, this.guiTop + 113, 0);
      String n = JRMCoreH.trl("jrmc", "Exit");
      int nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10008, posX - 95 - nw, posY + 85, nw, 20, n, 4877291));
      n = JRMCoreH.trl("jrmc", "Guides");
      nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10005, posX + 50 - nw, posY - 20, nw, 20, n, 4877291));
      n = JRMCoreH.trl("jrmc", "Receipts");
      nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10006, posX + 50 - nw, posY + 48, nw, 20, n, 4877291));
   }

   private void drawHUD_helpguidepick(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      var8.func_78276_b(JRMCoreH.trl("jrmc", "Guides") + ": ", this.guiLeft + 10, this.guiTop + 5, 0);
      String n = JRMCoreH.trl("jrmc", "Back2");
      int nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10007, posX - 95 - nw, posY + 85, nw, 20, n, 4877291));

      for(int xx = 0; xx < 13; ++xx) {
         var8.func_78276_b(JRMCoreH.trl("jrmc", "help_guide_" + (xx + 1) + "_title"), this.guiLeft + 5, this.guiTop + 18 + xx * 10, 0);
      }

      this.guiTop += 16;
      int xpos = -10;
      int ypos = this.guiTop;

      for(int xx = 0; xx < 13; ++xx) {
         ypos = this.guiTop + xx * 10;
         this.field_146292_n.add(new JRMCoreGuiButtonsA3(12002 + xx, this.guiLeft + xpos, ypos, 10, 2, true));
      }

      this.guiTop -= 16;
   }

   private void drawHUD_helpguide(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      var8.func_78276_b(JRMCoreH.trl("jrmc", "Guides") + ": ", this.guiLeft + 10, this.guiTop + 5, 0);
      String n = JRMCoreH.trl("jrmc", "Back2");
      int nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(10005, posX - 95 - nw, posY + 85, nw, 20, n, 4877291));
      if (help_page_id - 1 >= 0) {
         n = JRMCoreH.trl("jrmc", "Back");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(10003, posX + 70 - nw, posY + 85, nw, 20, n, 4877291));
      }

      if (help_page_id + 1 < 13) {
         n = JRMCoreH.trl("jrmc", "Next");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(10004, posX + 120 - nw, posY + 85, nw, 20, n, 4877291));
      }

      if (help_page_id == 1) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int kep_x = false;
         int kep_y = false;
         ResourceLocation kep = new ResourceLocation(JRMCoreH.tjjrmc + ":help/inv.png");
         mc.field_71446_o.func_110577_a(kep);
         int kep_x = 168;
         int kep_y = 78;
         this.func_73729_b(this.guiLeft + 40, this.guiTop + 75, 0, 0, kep_x, kep_y);
      }

      var8.func_78276_b(JRMCoreH.trl("jrmc", "help_guide_" + (help_page_id + 1) + "_title") + ": ", this.guiLeft + 70, this.guiTop + 5, 0);
      String sdata1 = StatCollector.func_74838_a("jinryuujrmcore.help_guide_" + (help_page_id + 1) + "_desc");
      int nr = JRMCoreH.txt(JRMCoreH.trl(sdata1), "§1", 0, true, this.guiLeft + 5, this.guiTop + 18, 0, 0, 0);
   }

   private void drawHUD_helpcraft(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      var8.func_78276_b(JRMCoreH.trl("jrmc", "Receipts") + ": ", this.guiLeft + 10, this.guiTop + 5, 0);
      String n;
      int nw;
      int AllRecipes;
      int Recipes;
      if (this.gui_recipe_mod == -1) {
         var8.func_78276_b("Select mod: ", this.guiLeft + 10, this.guiTop + 25, 0);
         n = JRMCoreH.trl("jrmc", "Back");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(10007, posX - 95 - nw, posY + 85, nw, 20, n, 4877291));
         AllRecipes = 0;

         for(Recipes = 0; Recipes < JGRecipeHandler.recipelistmods.length; ++Recipes) {
            boolean render = Recipes == 0 ? true : (Recipes == 1 ? JRMCoreH.DBC() : (Recipes == 2 ? JRMCoreH.NC() : (Recipes == 3 ? JRMCoreH.JYC() : false)));
            if (render) {
               n = JGRecipeHandler.recipelistmods[Recipes];
               nw = this.field_146289_q.func_78256_a(n) + 8;
               this.field_146292_n.add(new JRMCoreGuiButtons00(10009 + Recipes, posX - nw / 2, posY - 40 + AllRecipes * 22, nw, 20, n, 4877291));
               ++AllRecipes;
            }
         }
      } else if (this.gui_recipe_category > -1) {
         AllRecipes = JGRecipeHandler.getRecipeCount(this.gui_recipe_mod, this.gui_recipe_category);
         Recipes = JGRecipeHandler.getRecipeCount(this.gui_recipe_mod, this.gui_recipe_category) - help_page_id * 4;
         if (Recipes > 4) {
            Recipes = 4;
         }

         int placement = 0;

         for(int i = 0; i < JGRecipeHandler.recipelistcategories.length; ++i) {
            if (JGRecipeHandler.getRecipeCount(this.gui_recipe_mod, i) > 0) {
               n = JRMCoreH.trl("jrmc", "guidehelp_" + JGRecipeHandler.recipelistcategories[i]);
               nw = this.field_146289_q.func_78256_a(n) + 8;
               this.field_146292_n.add(new JRMCoreGuiButtons00(10013 + i, posX - 130 - nw, posY - 60 + placement * 22, nw, 20, n, i == this.gui_recipe_category ? 9819364 : 4877291));
               ++placement;
            }
         }

         n = JRMCoreH.trl("jrmc", "Back");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(10019, posX - 95 - nw, posY + 85, nw, 20, n, 4877291));
         if (help_page_id - 1 >= 0) {
            n = JRMCoreH.trl("jrmc", "Back");
            nw = this.field_146289_q.func_78256_a(n) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(10003, posX + 70 - nw, posY + 85, nw, 20, n, 5478826));
         }

         if (AllRecipes - (help_page_id + 1) * 4 > 0) {
            n = JRMCoreH.trl("jrmc", "Next");
            nw = this.field_146289_q.func_78256_a(n) + 8;
            this.field_146292_n.add(new JRMCoreGuiButtons00(10004, posX + 120 - nw, posY + 85, nw, 20, n, 5478826));
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int kep_x = false;
         int kep_y = false;

         int k;
         for(k = 0; k < 4; ++k) {
            ResourceLocation kep = new ResourceLocation(JRMCoreH.tjjrmc + ":help/craft" + (k < Recipes ? "" : "empty") + ".png");
            mc.field_71446_o.func_110577_a(kep);
            int i = k % 2;
            int j = k > 1 ? 1 : 0;
            int kep_x = 241;
            int kep_y = 136;
            this.func_73729_b(this.guiLeft + 6 + 122 * i, this.guiTop + 18 + 69 * j, 0, 0, kep_x, kep_y);
         }

         for(k = 0; k < Recipes; ++k) {
            ItemStack stack = (ItemStack)JGRecipeHandler.recipelist.get(JGRecipeHandler.recipelistmods[this.gui_recipe_mod] + "." + JGRecipeHandler.recipelistcategories[this.gui_recipe_category] + (k + help_page_id * 4));
            if (stack != null) {
               IRecipe shape = JGRecipeHandler.getRecipe(stack.func_77973_b());
               int stackSize = 0;
               if (shape != null) {
                  if (shape instanceof ShapedRecipes) {
                     stackSize = ((ShapedRecipes)shape).func_77571_b().field_77994_a;
                  } else {
                     stackSize = ((ShapelessRecipes)shape).func_77571_b().field_77994_a;
                  }
               }

               int GUI_X = this.guiLeft + 5 + k % 2 * 122;
               int GUI_Y = this.guiTop + 15 + k / 2 * 69;
               int itemX = GUI_X + 99;
               int itemY = GUI_Y + 34;
               int description1 = true;
               int description2 = true;
               int description3 = true;
               float scaleItem = 1.0F;
               float scaleRecipe = 1.0F;
               JGRenderHelper.drawItem(mc, this.field_73735_i, this.field_146289_q, stack, itemX, itemY, 1.0F, stackSize);
               int itemWidth = 16;
               int itemHeight = 16;
               String name = stack.func_82833_r();
               drawDetails(name, itemX, itemY, itemWidth, itemHeight, this.x, this.y, var8);
               String recipe = "";
               if (shape != null) {
                  int recipeWidth = 3;
                  ItemStack[] recipeItems;
                  if (shape instanceof ShapedRecipes) {
                     recipeItems = ((ShapedRecipes)shape).field_77574_d;
                     recipeWidth = ((ShapedRecipes)shape).field_77576_b;
                  } else {
                     recipeItems = new ItemStack[((ShapelessRecipes)shape).field_77579_b.size()];

                     for(int i = 0; i < ((ShapelessRecipes)shape).field_77579_b.size(); ++i) {
                        recipeItems[i] = (ItemStack)((ShapelessRecipes)shape).field_77579_b.get(i);
                     }
                  }

                  ItemStack[] recept2 = new ItemStack[recipeItems.length];
                  ItemStack[] recept = recipeItems;

                  int i;
                  for(i = 0; i < recipeItems.length; ++i) {
                     if (recipeItems[i] != null) {
                        recept2[i] = new ItemStack(Item.func_150899_d(Item.func_150891_b(recipeItems[i].func_77973_b())));
                     }
                  }

                  for(i = 0; i < recept.length; ++i) {
                     if (recept[i] != null && recept2[i] != null) {
                        recept2[i] = JGRecipeHandler.colorFix(recept2[i], recept[i]);
                     }
                  }

                  for(i = 0; i < recept.length; ++i) {
                     if (recept[i] != null && recept2[i] != null) {
                        int recPosX = GUI_X + 4 + 1 + i % recipeWidth * 18;
                        int recPosY = GUI_Y + 14 + 3 + i / recipeWidth * 18;
                        recipe = recipe + recept[i].func_82833_r();
                        JGRenderHelper.drawItem(mc, this.field_73735_i, this.field_146289_q, recept2[i], recPosX, recPosY, 1.0F, 0);
                        String recipeName = recept[i].func_82833_r();
                        itemWidth = 16;
                        itemHeight = 16;
                        drawDetails(recipeName, recPosX, recPosY, itemWidth, itemHeight, this.x, this.y, var8);
                     }
                  }
               }
            }
         }
      } else {
         this.gui_recipe_mod = -1;
         this.gui_recipe_category = 0;
      }

   }

   private void drawHUD_clntsett(int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
      int xSize = 256;
      int ySize = 159;
      int guiLeft = (this.field_146294_l - xSize) / 2;
      int guiTop = (this.field_146295_m - ySize) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation guiLocation = new ResourceLocation(wish);
      mc.field_71446_o.func_110577_a(guiLocation);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
      String n = JRMCoreH.trl("jrmc", "Back");
      int nw = this.field_146289_q.func_78256_a(n) + 8;
      this.field_146292_n.add(new JRMCoreGuiButtons00(100, posX - 155 - nw, posY + 65, nw, 20, n, 0));
      int num = 0;
      int cs_x = posX - 135;
      int cs_y = posY - 100 + num * 20;
      n = JRMCoreH.trl("jrmc", "Graphic Settings");
      this.field_146292_n.add(new JRMCoreGuiButtons00(12000, cs_x, cs_y, 135, 20, n, cs_mode == 0 ? 541552 : 4877291));
      int num = num + 1;
      cs_x += num * 135;
      cs_y = posY - 100;
      n = JRMCoreH.trl("jrmc", "User Interface");
      this.field_146292_n.add(new JRMCoreGuiButtons00(12001, cs_x, cs_y, 135, 20, n, cs_mode == 1 ? 541552 : 4877291));
      ++num;
      num = 0;
      cs_x = posX + 145 - nw / 2;
      cs_y = posY - 20 - num * 25;
      n = JRMCoreH.trl("jrmc", "Reset");
      this.field_146292_n.add(new JRMCoreGuiButtons00(11008, cs_x, cs_y, 100, 20, n, 11022891));
      num = num + 1;
      if (cs_mode == 1 || cs_mode == 0 && cs_page == 8) {
         cs_y = posY - 20 - num * 25;
         n = JRMCoreH.trl("jrmc", "Add more") + "(" + JGConfigClientSettings.addMore + ")";
         this.field_146292_n.add(new JRMCoreGuiButtons00(11009, cs_x, cs_y, 100, 20, n, 4877291));
         ++num;
      }

      cs_y = posY - 20 - num * 25;
      n = JRMCoreH.trl("jrmc", "Save");
      this.field_146292_n.add(new JRMCoreGuiButtons00(10000, cs_x, cs_y, 100, 20, n, 4437547));
      ++num;
      String na;
      if (JGConfigClientSettings.CLIENT_hud2 && cs_mode == 1) {
         cs_y = posY + 80 - num * 25;
         n = JRMCoreH.trl("jrmc", "Paste");
         this.field_146292_n.add(new JRMCoreGuiButtons00(11058, cs_x, cs_y, 100, 20, n, 4437547));
         ++num;
         na = JRMCoreH.trl("jrmc", "ClientPasteDesc");
         drawDetails(JRMCoreH.cldgy + JRMCoreH.cct(na), cs_x, cs_y, 100, 20, this.x, this.y, this.field_146289_q);
      }

      if (cs_page - 1 >= 0) {
         n = JRMCoreH.trl("jrmc", "Back");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(11016, posX + 70 - nw, posY + 85, nw, 20, n, 4877291));
      }

      if (cs_page + 1 < cs_pages[cs_mode]) {
         n = JRMCoreH.trl("jrmc", "Next");
         nw = this.field_146289_q.func_78256_a(n) + 8;
         this.field_146292_n.add(new JRMCoreGuiButtons00(11017, posX + 120 - nw, posY + 85, nw, 20, n, 4877291));
      }

      String name;
      String text;
      int ypos;
      byte xpos;
      int ypos;
      if (cs_mode == 0) {
         num = 0;
         guiTop += 7;
         int x;
         byte xpos;
         if (cs_page == 0) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client ParAmo") + ": " + JGConfigClientSettings.get_da1() + "x", guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client ParSpe") + ": " + JGConfigClientSettings.get_da2() + "x", guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Image0", JGConfigClientSettings.CLIENT_GR2), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles0", JGConfigClientSettings.CLIENT_GR0), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles1", JGConfigClientSettings.CLIENT_GR7), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles2", JGConfigClientSettings.CLIENT_GR1), guiLeft + 5, guiTop + num * 15, 0);
            var8.func_78276_b(this.getClientConfigText("SETT3D", JGConfigClientSettings.CLIENT_GR10), guiLeft + 205, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles3", JGConfigClientSettings.CLIENT_GR8), guiLeft + 5, guiTop + num * 15, 0);
            var8.func_78276_b(this.getClientConfigText("SETT3D", JGConfigClientSettings.CLIENT_GR11), guiLeft + 205, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles4", JGConfigClientSettings.CLIENT_GR9), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles5", JGConfigClientSettings.CLIENT_GR3), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Particles6", JGConfigClientSettings.CLIENT_GR4), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            num = 0;
            x = guiTop - 2;
            xpos = -10;
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11030, guiLeft + xpos - 13, x + 15 * num, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11031, guiLeft + xpos, x + 15 * num, ">"));
            num = num + 1;
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11032, guiLeft + xpos - 13, x + 15 * num, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11033, guiLeft + xpos, x + 15 * num, ">"));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11020, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11018, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11025, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11019, guiLeft + xpos, x + 15 * num, 10, 2, true));
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11028, guiLeft + xpos - 13, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11026, guiLeft + xpos, x + 15 * num, 10, 2, true));
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11029, guiLeft + xpos - 13, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11027, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11021, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11022, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
         } else if (cs_page == 1) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt21") + ": " + JGConfigClientSettings.CLIENT_DA21 * 10 + "%", guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt3") + ": " + JGConfigClientSettings.CLIENT_DA3 * 10 + "%", guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt19", JGConfigClientSettings.CLIENT_DA19), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt4", JGConfigClientSettings.CLIENT_DA4), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt5", JGConfigClientSettings.CLIENT_DA5), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt6", JGConfigClientSettings.CLIENT_DA6), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt7", JGConfigClientSettings.CLIENT_DA7), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt8", JGConfigClientSettings.CLIENT_DA8), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt9", JGConfigClientSettings.CLIENT_DA9), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt10", JGConfigClientSettings.CLIENT_DA10), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            num = 0;
            x = guiTop - 2;
            xpos = -10;
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11055, guiLeft + xpos - 13, x + 15 * num, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11054, guiLeft + xpos, x + 15 * num, ">"));
            num = num + 1;
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11035, guiLeft + xpos - 13, x + 15 * num, "<"));
            this.field_146292_n.add(new JRMCoreGuiButtonsA2(11034, guiLeft + xpos, x + 15 * num, ">"));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11053, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11036, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11037, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11038, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11039, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11040, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11041, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11042, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
         } else if (cs_page == 2) {
            var8.func_78276_b(this.getClientConfigText("Client Opt11", JGConfigClientSettings.CLIENT_DA11), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt20", JGConfigClientSettings.CLIENT_DA20), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt12", JGConfigClientSettings.CLIENT_DA12), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt13", JGConfigClientSettings.CLIENT_DA13), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt14", JGConfigClientSettings.CLIENT_DA14), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt15", JGConfigClientSettings.CLIENT_DA15), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt16", JGConfigClientSettings.CLIENT_DA16), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt17", JGConfigClientSettings.CLIENT_DA17), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt18", JGConfigClientSettings.CLIENT_DA18), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt22", JGConfigClientSettings.CLIENT_DA22), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            num = 0;
            x = guiTop - 2;
            xpos = -10;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11043, guiLeft + xpos, x + 15 * num, 10, 2, true));
            num = num + 1;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11052, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11044, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11045, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11046, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11047, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11048, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11050, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11051, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11059, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
         } else if (cs_page == 3) {
            var8.func_78276_b(this.getClientConfigText("Client Opt25", JGConfigClientSettings.renderEnergyOutsideView), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt40", JGConfigClientSettings.instantTransmissionFirstPerson), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(this.getClientConfigText("Client Opt41", JGConfigClientSettings.instantTransmissionParticles), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            num = 0;
            x = guiTop - 2;
            xpos = -10;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11101, guiLeft + xpos, x + 15 * num, 10, 2, true));
            num = num + 1;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11216, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11217, guiLeft + xpos, x + 15 * num, 10, 2, true));
            ++num;
         } else {
            byte xpos;
            if (cs_page == 4) {
               na = JRMCoreH.trl("jrmc", "Ki Attack") + " ";
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt23") + ": " + JGConfigClientSettings.CLIENT_Ki_Visibility * 10 + "% (" + JRMCoreH.trl("jrmc", "SETT2D") + ")", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt24") + ": " + JGConfigClientSettings.CLIENT_Ki_Scale * 10 + "%", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               na = JRMCoreH.trl("jrmc", "Ki Attack Charge") + " ";
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt23") + ": " + JGConfigClientSettings.CLIENT_Ki_Charge_Visibility * 10 + "% (" + JRMCoreH.trl("jrmc", "SETT2D") + ")", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt24") + ": " + JGConfigClientSettings.CLIENT_Ki_Charge_Scale * 10 + "%", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               na = JRMCoreH.trl("jrmc", "Jutsu") + " ";
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt23") + ": " + JGConfigClientSettings.CLIENT_Jutsu_Visibility * 10 + "% (" + JRMCoreH.trl("jrmc", "SETT2D") + ")", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(na + JRMCoreH.trl("jrmc", "Client Opt24") + ": " + JGConfigClientSettings.CLIENT_Jutsu_Scale * 10 + "%", guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               num = 0;
               ypos = guiTop - 2;
               xpos = -10;
               int xpos2 = true;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11060, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11061, guiLeft + xpos, ypos + 15 * num, ">"));
               num = num + 1;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11062, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11063, guiLeft + xpos, ypos + 15 * num, ">"));
               ++num;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11067, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11068, guiLeft + xpos, ypos + 15 * num, ">"));
               ++num;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11069, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11070, guiLeft + xpos, ypos + 15 * num, ">"));
               ++num;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11074, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11075, guiLeft + xpos, ypos + 15 * num, ">"));
               ++num;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11076, guiLeft + xpos - 13, ypos + 15 * num, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11077, guiLeft + xpos, ypos + 15 * num, ">"));
               ++num;
            } else {
               int j;
               String[] names2;
               if (cs_page == 5) {
                  if (!JRMCoreH.DBC()) {
                     cs_page = this.guiUp ? cs_page + 1 : cs_page - 1;
                  } else {
                     names2 = new String[]{"Wave", "Blast", "Disk", "Laser", "Spiral", "BigBlast", "Barrage", "Shield", "Explosion"};
                     name = JRMCoreH.trl("jrmc", "Ki Attack") + " ";

                     for(ypos = 0; ypos < names2.length; ++ypos) {
                        text = JRMCoreH.trl("jrmc", "SETT3D") + " " + name + JRMCoreH.trl("dbc", names2[ypos]) + ": " + (JGConfigClientSettings.CLIENT_Ki_3d[ypos] ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF"));
                        var8.func_78276_b(text, guiLeft + 5, guiTop + num * 15, 0);
                        ++num;
                     }

                     num = 0;
                     ypos = guiTop - 2;
                     xpos = -10;

                     for(j = 0; j < names2.length; ++j) {
                        this.field_146292_n.add(new JRMCoreGuiButtonsA3(11080 + j, guiLeft + xpos, ypos + 15 * num, 10, 2, true));
                        ++num;
                     }
                  }
               } else if (cs_page == 6) {
                  if (!JRMCoreH.DBC()) {
                     cs_page = this.guiUp ? cs_page + 1 : cs_page - 1;
                  } else {
                     names2 = new String[]{"Wave", "Blast", "Disk", "Laser", "Spiral", "BigBlast", "Barrage", "Shield", "Explosion"};
                     name = JRMCoreH.trl("jrmc", "Ki Attack Charge") + " ";

                     for(ypos = 0; ypos < names2.length; ++ypos) {
                        text = JRMCoreH.trl("jrmc", "SETT3D") + " " + name + JRMCoreH.trl("dbc", names2[ypos]) + ": " + (JGConfigClientSettings.CLIENT_Ki_Charge_3d[ypos] ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF"));
                        var8.func_78276_b(text, guiLeft + 5, guiTop + num * 15, 0);
                        ++num;
                     }

                     num = 0;
                     ypos = guiTop - 2;
                     xpos = -10;

                     for(j = 0; j < names2.length; ++j) {
                        this.field_146292_n.add(new JRMCoreGuiButtonsA3(11089 + j, guiLeft + xpos, ypos + 15 * num, 10, 2, true));
                        ++num;
                     }
                  }
               } else if (cs_page != 7) {
                  if (cs_page == 8) {
                     x = guiLeft + 5;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt31") + ": " + JGConfigClientSettings.renderdistanceMultiplierBarrierBlock + "%", x, guiTop + num * 15, 0);
                     ++num;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt32") + ": " + JGConfigClientSettings.renderdistanceMultiplierParticles + "%", x, guiTop + num * 15, 0);
                     ++num;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt33") + ": " + JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge + "%", x, guiTop + num * 15, 0);
                     ++num;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt34") + ": " + JGConfigClientSettings.renderdistanceMultiplierAuras + "%", x, guiTop + num * 15, 0);
                     ++num;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt38") + ": " + (JGConfigClientSettings.dbcFastFusionSpectatorCameraFollowOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
                     ++num;
                     var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt39") + ": " + (JGConfigClientSettings.safeZoneUIModeOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
                     ++num;
                     num = 0;
                     ypos = guiTop - 2;
                     xpos = -10;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11205, guiLeft + xpos - 13, ypos + 15 * num, "<"));
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11206, guiLeft + xpos, ypos + 15 * num, ">"));
                     num = num + 1;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11207, guiLeft + xpos - 13, ypos + 15 * num, "<"));
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11208, guiLeft + xpos, ypos + 15 * num, ">"));
                     ++num;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11209, guiLeft + xpos - 13, ypos + 15 * num, "<"));
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11210, guiLeft + xpos, ypos + 15 * num, ">"));
                     ++num;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11211, guiLeft + xpos - 13, ypos + 15 * num, "<"));
                     this.field_146292_n.add(new JRMCoreGuiButtonsA2(11212, guiLeft + xpos, ypos + 15 * num, ">"));
                     ++num;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA3(11214, guiLeft + xpos, ypos + 15 * num, 10, 2, true));
                     ++num;
                     this.field_146292_n.add(new JRMCoreGuiButtonsA3(11215, guiLeft + xpos, ypos + 15 * num, 10, 2, true));
                     ++num;
                  }
               } else if (!JRMCoreH.NC()) {
                  cs_page = this.guiUp ? cs_page + 1 : cs_page - 1;
               } else {
                  names2 = new String[]{"Wave", "Ball", "Disk"};
                  name = JRMCoreH.trl("jrmc", "Jutsu") + " ";

                  for(ypos = 0; ypos < names2.length; ++ypos) {
                     text = JRMCoreH.trl("jrmc", "SETT3D") + " " + name + JRMCoreH.trl("nc", names2[ypos]) + ": " + (JGConfigClientSettings.CLIENT_Jutsu_3d[ypos] ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF"));
                     var8.func_78276_b(text, guiLeft + 5, guiTop + num * 15, 0);
                     ++num;
                  }

                  num = 0;
                  ypos = guiTop - 2;
                  xpos = -10;

                  for(j = 0; j < names2.length; ++j) {
                     this.field_146292_n.add(new JRMCoreGuiButtonsA3(11098 + j, guiLeft + xpos, ypos + 15 * num, 10, 2, true));
                     ++num;
                  }
               }
            }
         }

         guiTop -= 7;
      } else if (cs_mode == 1) {
         num = 0;
         guiTop += 7;
         if (cs_page == 0) {
            if (JRMCoreH.pwr_ki(this.pwr)) {
               na = " " + JRMCoreH.trl("jrmc", JRMCoreH.BPMode == 0 ? "BPNormal" : "BPHigh");
               name = JRMCoreH.TrnngOptnsNam(2);
               text = JRMCoreH.TrnngOptnsDesc(2);
               ypos = this.field_146289_q.func_78256_a(na);
               int fnw = this.field_146289_q.func_78256_a(name);
               this.field_146292_n.add(new JRMCoreGuiButtons01(-32, guiLeft + 5 + fnw, guiTop, ypos, na, JRMCoreH.techNCCol[1]));
               drawDetails(name, JRMCoreH.cct(text, JRMCoreH.numSepShort(JRMCoreHC.BPC_ME2)), guiLeft + 5, guiTop, this.x, this.y, var8);
               ++num;
            }

            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt36") + ": " + (JGConfigClientSettings.tipNotificationsOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt37") + ": " + (JGConfigClientSettings.errorNotificationsOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Custom Hud") + ": " + (JGConfigClientSettings.CLIENT_hud2 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            if (JGConfigClientSettings.CLIENT_hud2) {
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud 2 X") + ": " + JGConfigClientSettings.CLIENT_hud0x, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud 2 Y") + ": " + JGConfigClientSettings.CLIENT_hud0y, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Health bar text style") + ": " + (JGConfigClientSettings.CLIENT_GR5 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               if (!JGConfigClientSettings.CLIENT_GR12) {
                  na = JRMCoreH.trl("jrmc", "On") + "/" + JRMCoreH.trl("jrmc", "Off");
               } else {
                  na = JRMCoreH.trl("jrmc", "Enable") + "/" + JRMCoreH.trl("jrmc", "Disable");
               }

               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Action Menu Text Type") + ": " + na, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Action Menu White") + ": " + (JGConfigClientSettings.CLIENT_GR13 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
               ++num;
            } else {
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud X") + ": " + JGConfigClientSettings.CLIENT_hud0x, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud Y") + ": " + JGConfigClientSettings.CLIENT_hud0y, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud Style") + ": " + JGConfigClientSettings.CLIENT_hud0, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Lockon Style") + ": " + JGConfigClientSettings.CLIENT_lockon, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud 1 X") + ": " + JGConfigClientSettings.CLIENT_hud1x, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud 1 Y") + ": " + JGConfigClientSettings.CLIENT_hud1y, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
            }
         } else if (cs_page == 1) {
            if (!JGConfigClientSettings.CLIENT_hud2) {
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Hud 1 Style") + ": " + JGConfigClientSettings.CLIENT_hud1, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Health bar rotated") + ": " + (JGConfigClientSettings.CLIENT_GR6 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               if (!JGConfigClientSettings.CLIENT_GR12) {
                  na = JRMCoreH.trl("jrmc", "On") + "/" + JRMCoreH.trl("jrmc", "Off");
               } else {
                  na = JRMCoreH.trl("jrmc", "Enable") + "/" + JRMCoreH.trl("jrmc", "Disable");
               }

               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Health bar text style") + ": " + (JGConfigClientSettings.CLIENT_GR5 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Action Menu Text Type") + ": " + na, guiLeft + 5, guiTop + num * 15, 0);
               ++num;
               var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Action Menu White") + ": " + (JGConfigClientSettings.CLIENT_GR13 ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
               ++num;
            }

            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt26") + ": " + (JGConfigClientSettings.concentrationAnimatedTexturesOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt27") + ": " + (JGConfigClientSettings.concentrationAnimatedColorOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt28") + ": " + (JGConfigClientSettings.airboxing3DCharacterOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt29") + ": " + (JGConfigClientSettings.airboxing3DAuraOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt30") + ": " + (JGConfigClientSettings.airboxingAnimatedColorOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
         } else if (cs_page == 2) {
            var8.func_78276_b(JRMCoreH.trl("jrmc", "Client Opt35") + ": " + (JGConfigClientSettings.kiAttackChargePercentageOn ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF")), guiLeft + 5, guiTop + num * 15, 0);
            ++num;
         }

         guiTop -= 7;
         GL11.glPushMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         float size = 0.3F + (0.0F - (float)var6 / 240.0F / 25.0F);
         if (size < 0.0F) {
            size = 0.3F;
         }

         ypos = (int)(256.0F * size);
         int guiHeight = (int)(256.0F * size);
         GL11.glTranslatef((float)(var6 / 2 - ypos / 2), 5.0F, 0.0F);
         GL11.glScalef(size, size, size);
         mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjjrmc, "gui/lo/" + JGConfigClientSettings.get_hud_lockon() + ".png"));
         this.func_73729_b(0, 0, 0, 0, 256, 256);
         GL11.glPopMatrix();
         if (JGConfigClientSettings.CLIENT_hud2) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            JRMCoreClient.bars.renderCG(0);
            GL11.glPopMatrix();
         } else {
            byte pwr = JRMCoreH.Pwrtyp;
            ResourceLocation tx = new ResourceLocation((pwr == 1 ? "jinryuumodscore:" : (pwr == 2 ? "jinryuunarutoc:" : "jinryuumodscore:")) + "energy.png");
            mc.field_71446_o.func_110577_a(tx);
            this.func_73729_b(JGConfigClientSettings.CLIENT_hud0x + (pwr == 1 ? 10 : 0), JGConfigClientSettings.CLIENT_hud0y + (pwr == 1 ? 10 : 25), 0, 0 + (pwr == 1 ? JGConfigClientSettings.get_hud_pos(0) : 86), pwr == 1 ? JGConfigClientSettings.get_hud_x() + this.getx1() : 50, pwr == 1 ? JGConfigClientSettings.get_hud_y() + this.gety1() : 86);
            tx = new ResourceLocation("jinryuumodscore:health.png");
            mc.field_71446_o.func_110577_a(tx);
            int img_height = JGConfigClientSettings.get_hud_1_height();
            int var_x = var5.func_78326_a() + JGConfigClientSettings.CLIENT_hud1x;
            int var = (var5.func_78328_b() - JGConfigClientSettings.CLIENT_hud1y) / 2 + 25;
            int g = var_x - (JGConfigClientSettings.get_hud_1_height() + 2);
            this.func_73729_b(g, var, JGConfigClientSettings.get_hud_1_pos(0), 0, JGConfigClientSettings.get_hud_1_height(), JGConfigClientSettings.get_hud_1_width());
         }

         num = 0;
         guiTop += 5;
         xpos = -10;
         ypos = guiTop + num * 15;
         if (cs_page == 0) {
            if (JRMCoreH.pwr_ki(this.pwr)) {
               ++num;
               ypos = guiTop + num * 15;
            }

            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11300, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11301, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11049, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            if (JGConfigClientSettings.CLIENT_hud2) {
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11000, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11001, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11002, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11003, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11023, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11056, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11057, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
            } else {
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11000, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11001, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11002, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11003, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11004, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11005, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11006, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11007, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11010, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11011, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11012, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11013, guiLeft + xpos, ypos, ">"));
               ++num;
            }
         } else if (cs_page == 1) {
            if (!JGConfigClientSettings.CLIENT_hud2) {
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11014, guiLeft + xpos - 13, ypos, "<"));
               this.field_146292_n.add(new JRMCoreGuiButtonsA2(11015, guiLeft + xpos, ypos, ">"));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11024, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11023, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11056, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
               ypos = guiTop + num * 15;
               this.field_146292_n.add(new JRMCoreGuiButtonsA3(11057, guiLeft + xpos, ypos, 10, 2, true));
               ++num;
            }

            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11200, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11201, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11202, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11203, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11204, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
         } else if (cs_page == 2) {
            ypos = guiTop + num * 15;
            this.field_146292_n.add(new JRMCoreGuiButtonsA3(11213, guiLeft + xpos, ypos, 10, 2, true));
            ++num;
         }

         guiTop -= 7;
      }

   }

   public static String getStringShortened(FontRenderer var8, int widthLimit, String text) {
      int width = var8.func_78256_a(text);
      if (width > widthLimit) {
         String newText = "";
         int length = text.length();

         for(int i = length - 1; i >= 0; --i) {
            newText = text.substring(0, i) + "...";
            if (var8.func_78256_a(newText) <= widthLimit) {
               text = newText;
               break;
            }
         }
      }

      return text.substring(0, 1).toUpperCase() + text.substring(1);
   }

   public void menuButtons(String st) {
      menuButtons(st, this.field_146292_n, this.guiLeft, this.guiTop, this.ySize, this.x, this.y, this.field_146289_q);
   }

   public static void menuButtons(String st, List buttonList, int guiLeft, int guiTop, int ySize, int x, int y, FontRenderer fontRendererObj) {
      int i = 0;
      int rid = false;
      buttonList.add(new JRMCoreGuiButtons00(10, guiLeft - 22, guiTop + 145, 20, 20, "X", 0));
      String name = "";
      if (!JRMCoreConfig.ssurl.contains("empty") && JRMCoreConfig.ssurl.contains("ttp")) {
         name = "Server Shop";
         buttonList.add(new JRMCoreGuiButtons02(3099, guiLeft + i * 21, guiTop + ySize + 2, "$", st.equals("ST") ? 1 : 0, Color.GREEN.darker().darker().getRGB()));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

      name = JRMCoreH.trl("jrmc", "News");
      int var10004 = guiLeft + i * 21;
      int var10005 = guiTop + ySize + 2;
      String var10006 = name.substring(0, 2).toUpperCase();
      int var10007 = st.equals("News") ? 1 : 0;
      rid = false;
      buttonList.add(new JRMCoreGuiButtons03(31, var10004, var10005, var10006, var10007, 8046079, 0));
      drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
      ++i;
      int BONUS_X = true;
      int tabX = -60 + (JRMCoreH.Pwrtyp == 2 && JRMCoreH.PtchVc == 0 ? 0 : 25);
      int tabY = -80;
      name = JRMCoreH.trl("jrmc", "Help");
      var10004 = guiLeft + tabX;
      var10005 = guiTop + ySize + 2 + tabY;
      var10006 = name.substring(0, 2).toUpperCase();
      rid = true;
      buttonList.add(new JRMCoreGuiButtons03(10001, var10004, var10005, var10006, 0, 8046079, 8));
      drawDetails(JRMCoreH.cct(name), guiLeft + tabX, guiTop + ySize + 2 + 1 + tabY, 20, 20, x, y, fontRendererObj);
      tabY = -60;
      name = JRMCoreH.trl("jrmc", "CltSettings");
      var10004 = guiLeft + tabX;
      var10005 = guiTop + ySize + 2 + tabY;
      var10006 = name.substring(0, 2).toUpperCase();
      rid = true;
      buttonList.add(new JRMCoreGuiButtons03(109, var10004, var10005, var10006, 0, 8046079, 9));
      drawDetails(JRMCoreH.cct(name), guiLeft + tabX, guiTop + ySize + 2 + 1 + tabY, 20, 20, x, y, fontRendererObj);
      tabY = -100;
      name = JRMCoreH.trl("jrmc", "Notifications");
      var10004 = guiLeft + tabX;
      var10005 = guiTop + ySize + 2 + tabY;
      var10006 = name.substring(0, 2).toUpperCase();
      rid = true;
      buttonList.add(new JRMCoreGuiButtons03(50011, var10004, var10005, var10006, 0, 8046079, 10));
      drawDetails(JRMCoreH.cct(name), guiLeft + tabX, guiTop + ySize + 2 + 1 + tabY, 20, 20, x, y, fontRendererObj);
      if (JRMCoreH.Accepted != 0 && JRMCoreH.Accepted != 2) {
         name = JRMCoreH.trl("jrmc", "CharSheet");
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("CH") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(100, var10004, var10005, var10006, var10007, 8046079, 1));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

      if (JRMCoreH.Pwrtyp != 0 && (JRMCoreH.isPowerTypeKi() || JRMCoreH.isPowerTypeChakra())) {
         name = JRMCoreH.trl("jrmc", "Skills");
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("SK") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(101, var10004, var10005, var10006, var10007, 8046079, 2));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
         name = JRMCoreH.Pwrtyp == 1 ? JRMCoreH.trl("jrmc", "KiTechniques") : JRMCoreH.trl("jrmc", "Jutsu");
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("TE") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(102, var10004, var10005, var10006, var10007, 8046079, 3));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
         name = JRMCoreH.trl("jrmc", "Training");
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("TR") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(108, var10004, var10005, var10006, var10007, 8046079, 6));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
         name = JRMCoreH.Pwrtyp == 1 ? JRMCoreH.trl("dbc", "SagaSystem") : (JRMCoreH.Pwrtyp == 2 ? JRMCoreH.trl("nc", "StorySystem") : JRMCoreH.trl("jrmc", "Story"));
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("Journal") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(60, var10004, var10005, var10006, var10007, 8046079, 7));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

      if (JRMCoreH.isPowerTypeKi()) {
         name = JRMCoreH.trl("jrmc", "GroupManager");
         var10004 = guiLeft + i * 21;
         var10005 = guiTop + ySize + 2;
         var10006 = name.substring(0, 2).toUpperCase();
         var10007 = st.equals("Group") ? 1 : 0;
         rid = true;
         buttonList.add(new JRMCoreGuiButtons03(62, var10004, var10005, var10006, var10007, 8046079, 4));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

      name = JRMCoreH.trl("jrmc", "ServerConfig");
      var10004 = guiLeft + i * 21;
      var10005 = guiTop + ySize + 2;
      var10006 = name.substring(0, 2).toUpperCase();
      var10007 = st.equals("Server") ? 1 : 0;
      rid = true;
      buttonList.add(new JRMCoreGuiButtons03(32, var10004, var10005, var10006, var10007, 8046079, 5));
      drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
      ++i;
      if (JRMCoreH.JYC()) {
         name = JRMCoreH.trl("jrmc", "Calendar");
         buttonList.add(new JRMCoreGuiButtons02(4902, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Calendar") ? 1 : 0, 8046079));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

      if (JRMCoreH.JFC()) {
         name = JRMCoreH.trl("jrmc", "Family");
         buttonList.add(new JRMCoreGuiButtons02(4903, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Family") ? 1 : 0, 8046079));
         drawDetails(JRMCoreH.cct(name), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj);
         ++i;
      }

   }

   private static void drawDetails(String s1, String s2, int xpos, int ypos, int x, int y, FontRenderer var8) {
      int wpos = var8.func_78256_a(s1);
      var8.func_78276_b(s1, xpos, ypos, 0);
      if (xpos < x && xpos + wpos > x && ypos - 3 < y && ypos + 10 > y) {
         int ll = 200;
         Object[] txt = new Object[]{s2, "§8", 0, true, x + 5, y + 5, Integer.valueOf(ll)};
         detailList.add(txt);
      }

   }

   public static boolean hovered(int mX, int mY, int xpos, int ypos, int w, int h) {
      return xpos < mX && xpos + w > mX && ypos - 3 < mY && ypos + h > mY;
   }

   public static void drawDetails(String s1, int xpos, int ypos, int w, int h, int x, int y, FontRenderer var8) {
      if (hovered(x, y, xpos, ypos, w, h)) {
         int ll = 200;
         Object[] txt = new Object[]{s1, "§8", 0, true, x + 5, y + 5, Integer.valueOf(ll)};
         detailList.add(txt);
      }

   }

   private int getx1() {
      return JGConfigClientSettings.get_hud_start_x();
   }

   private int gety1() {
      return JGConfigClientSettings.get_hud_start_y();
   }

   private void drawDetails(int x, int y, FontRenderer var8) {
      if (!detailList.isEmpty()) {
         Object[] o = (Object[])((Object[])detailList.get(0));
         String desc = (String)o[0];
         int ll = Integer.parseInt("" + o[6]);
         int descw = var8.func_78256_a(desc);
         int var10000 = 1 + var8.func_78256_a(desc) / ll;
         mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuumodscore:allw.png"));
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
         int desch = JRMCoreH.txt(desc, (String)o[1], Integer.parseInt("" + o[2]), false, 0, 0, ll);
         ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
         int var6 = var5.func_78326_a();
         int var7 = var5.func_78328_b();
         int xp = 0;
         int yp = 0;
         if (var6 < x + (descw < ll ? descw : ll) + 10) {
            xp += var6 - (x + (descw < ll ? descw : ll)) - 10;
         }

         if (var7 < y + desch * 10 + 10) {
            yp = -(desch * 10 + 20);
         }

         this.func_73729_b(x + xp, y + 10 + yp, 5, 5, (descw < ll ? descw : ll) + 10, desch * 10 + 10);
         JRMCoreH.txt(desc, (String)o[1], Integer.parseInt("" + o[2]), Boolean.parseBoolean("" + o[3]), Integer.parseInt("" + o[4]) + xp, Integer.parseInt("" + o[5]) + 10 + yp, ll);
         detailList.clear();
      }

   }

   public static int y4NUu(String l) {
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

   public static int kqGW3Z(boolean n) {
      int b = JRMCoreConfig.tmx;
      String r = "64";
      String k = "3B9ACA00";
      return b > y4NUu(k) ? y4NUu(k) : (b < y4NUu(r) ? 0 : b);
   }

   public static int r3W3mY(int b) {
      String k = "3B9ACA00";
      return b > y4NUu(k) ? y4NUu(k) : b;
   }

   private void align(String icons) {
      int ySize2 = this.ySize - 10;
      int guiLeft2 = (this.field_146294_l - this.xSize) / 2;
      int guiTop2 = (this.field_146295_m - ySize2) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation tx = new ResourceLocation(icons);
      mc.field_71446_o.func_110577_a(tx);
      GL11.glPushMatrix();
      int alignment1 = 654591;
      int alignment2 = 6028287;
      boolean evl = JRMCoreH.Algnmnt_Evil(JRMCoreH.align);
      if (JRMCoreH.Algnmnt_Good(JRMCoreH.align)) {
         alignment1 = 654591;
         alignment2 = 6028287;
      } else if (JRMCoreH.Algnmnt_Neut(JRMCoreH.align)) {
         alignment1 = 9127101;
         alignment2 = 11042302;
      } else if (evl) {
         alignment1 = 16726090;
         alignment2 = 16544131;
      }

      float h2 = (float)(alignment1 >> 16 & 255) / 255.0F;
      float h3 = (float)(alignment1 >> 8 & 255) / 255.0F;
      float h4 = (float)(alignment1 & 255) / 255.0F;
      float h1 = 1.0F;
      GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, 0.5F);
      this.func_73729_b(guiLeft2 + 8, guiTop2 - 11, 8, 174, 241, 7);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
      this.func_73729_b(guiLeft2, guiTop2 - 10, 0, 169, this.xSize, 5);
      int max = this.xSize - 20;
      if (max < 1) {
         max = 1;
      }

      double maxperc = (double)max * 0.01D;
      int var22 = (int)(maxperc * (double)JRMCoreH.align);
      if (var22 > this.xSize) {
         var22 = this.xSize;
      }

      int xSize2 = 5;
      int ySize3 = this.ySize - 10;
      int guiLeft3 = (this.field_146294_l - xSize2) / 2 - max / 2 + var22;
      int guiTop3 = guiTop2 - 1;
      h2 = (float)(alignment2 >> 16 & 255) / 255.0F;
      h3 = (float)(alignment2 >> 8 & 255) / 255.0F;
      h4 = (float)(alignment2 & 255) / 255.0F;
      GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, 1.0F);
      this.func_73729_b(guiLeft3 - 4, guiTop3 - 10 - 3, 0, 182, 11, 13);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void name(FontRenderer var8, int i, int j) {
      this.inputField = new GuiTextField(var8, i + 100, j + 15 + 0, 100, 12);
      this.inputField.func_146203_f(20);
      this.inputField.func_146185_a(true);
      this.inputField.func_146195_b(true);
      this.inputField.func_146180_a(this.defaultInputFieldText);
      this.inputField.func_146205_d(true);
   }

   public void func_73876_c() {
      if (this.inputField != null) {
         this.inputField.func_146178_a();
      }

      for(int id = 0; id < this.inputField2.length; ++id) {
         if (this.inputField2 != null && this.inputField2[id] != null) {
            this.inputField2[id].func_146178_a();
         }
      }

   }

   protected void func_73869_a(char c, int i) {
      super.func_73869_a(c, i);
      if (this.inputField != null) {
         this.inputField.func_146201_a(c, i);
      }

      for(int id = 0; id < this.inputField2.length; ++id) {
         if (this.inputField2 != null && this.inputField2[id] != null) {
            this.inputField2Ch = true;
            this.inputField2[id].func_146201_a(c, i);
         }
      }

   }

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      if (this.inputField != null) {
         this.inputField.func_146192_a(i, j, k);
      }

      for(int id = 0; id < this.inputField2.length; ++id) {
         if (this.inputField2 != null && this.inputField2[id] != null) {
            this.inputField2[id].func_146192_a(i, j, k);
         }
      }

   }

   private void nametf(FontRenderer var8, int id, int i, int j) {
      this.inputField2[id].func_146203_f(3);
      this.inputField2[id].func_146185_a(true);
      this.inputField2[id].func_146205_d(true);
   }

   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      mc.func_110434_K().func_110577_a(field_110408_a);
      int k = this.guiLeft;
      int l = this.guiTop;
      this.func_73729_b(k, l, 0, 0, this.xSize, this.ySize);
      func_110423_a(k + 51, l + 75, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo, mc.field_71439_g);
   }

   public static void head(int par0, int par1, int par2, float par3, float par4, EntityLivingBase par5EntityLivingBase) {
      GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par0, (float)par1, 50.0F);
      GL11.glScalef((float)(-par2), (float)par2, (float)par2);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      float f2 = par5EntityLivingBase.field_70761_aq;
      float f3 = par5EntityLivingBase.field_70177_z;
      float f4 = par5EntityLivingBase.field_70125_A;
      float f5 = par5EntityLivingBase.field_70758_at;
      float f6 = par5EntityLivingBase.field_70759_as;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_74519_b();
      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      par5EntityLivingBase.field_70761_aq = (float)Math.atan((double)(par3 / 40.0F)) * 20.0F;
      par5EntityLivingBase.field_70177_z = (float)Math.atan((double)(par3 / 40.0F)) * 40.0F;
      par5EntityLivingBase.field_70125_A = -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F;
      par5EntityLivingBase.field_70759_as = par5EntityLivingBase.field_70177_z;
      par5EntityLivingBase.field_70758_at = par5EntityLivingBase.field_70177_z;
      GL11.glTranslatef(0.0F, par5EntityLivingBase.field_70129_M, 0.0F);
      RenderManager.field_78727_a.field_78735_i = 180.0F;
      renderEntityWithPosYaw(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      par5EntityLivingBase.field_70761_aq = f2;
      par5EntityLivingBase.field_70177_z = f3;
      par5EntityLivingBase.field_70125_A = f4;
      par5EntityLivingBase.field_70758_at = f5;
      par5EntityLivingBase.field_70759_as = f6;
      GL11.glPopMatrix();
      RenderHelper.func_74518_a();
      GL11.glDisable(32826);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   public static void renderEntityWithPosYaw(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      Render render = null;

      try {
         render = RenderManager.field_78727_a.func_78713_a(par1Entity);
         if (render != null && RenderManager.field_78727_a.field_78724_e != null) {
            try {
               render.func_76986_a(par1Entity, par2, par4, par6, par8, par9);
            } catch (Throwable var12) {
               throw new ReportedException(CrashReport.func_85055_a(var12, "Rendering entity in world"));
            }
         }

      } catch (Throwable var13) {
         CrashReport crashreport = CrashReport.func_85055_a(var13, "Rendering entity in world");
         throw new ReportedException(crashreport);
      }
   }

   public static void func_110423_a_I(int par0, int par1, int scale, float par3, float par4, EntityLivingBase entity) {
      func_110423_a(par0, par1, scale, par3, par4, entity, true, true, false);
   }

   public static void func_110423_a(int par0, int par1, int scale, float par3, float par4, EntityLivingBase entity) {
      func_110423_a(par0, par1, scale, par3, par4, entity, true, true, true);
   }

   public static void func_110423_a(int par0, int par1, int scale, float par3, float par4, EntityLivingBase entity, boolean hr, boolean l, boolean i) {
      GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par0, (float)par1, 50.0F);
      GL11.glScalef((float)(-scale), (float)scale, (float)scale);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      float f2 = entity.field_70761_aq;
      float f3 = entity.field_70177_z;
      float f4 = entity.field_70125_A;
      float f5 = entity.field_70758_at;
      float f6 = entity.field_70759_as;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      if (l) {
         RenderHelper.func_74519_b();
      }

      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      if (hr) {
         GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      }

      entity.field_70761_aq = hr ? (float)(i ? -1 : 1) * (float)Math.atan((double)(par3 / 40.0F)) * 20.0F : 0.0F;
      entity.field_70177_z = hr ? (float)(i ? -1 : 1) * (float)Math.atan((double)(par3 / 40.0F)) * 40.0F : 0.0F;
      entity.field_70125_A = hr ? -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F : 0.0F;
      entity.field_70759_as = hr ? entity.field_70177_z : 0.0F;
      entity.field_70758_at = hr ? entity.field_70177_z : 0.0F;
      GL11.glTranslatef(0.0F, entity.field_70129_M, 0.0F);
      RenderManager.field_78727_a.field_78735_i = 180.0F;
      RenderManager.field_78727_a.func_147940_a(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      entity.field_70761_aq = f2;
      entity.field_70177_z = f3;
      entity.field_70125_A = f4;
      entity.field_70758_at = f5;
      entity.field_70759_as = f6;
      GL11.glPopMatrix();
      RenderHelper.func_74518_a();
      GL11.glDisable(32826);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   public static void hairCheck(int par0, int par1, int scale, float par3, float par4, EntityLivingBase par5EntityLivingBase, int side) {
      GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par0, (float)par1 - (side == 4 ? 20.0F : 0.0F), 50.0F);
      GL11.glScalef((float)(-scale), (float)scale, (float)scale);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      switch(side) {
      case 0:
      default:
         break;
      case 1:
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         break;
      case 2:
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         break;
      case 3:
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         break;
      case 4:
         GL11.glRotatef(40.0F, 1.0F, 0.0F, 0.0F);
      }

      float f2 = par5EntityLivingBase.field_70761_aq;
      float f3 = par5EntityLivingBase.field_70177_z;
      float f4 = par5EntityLivingBase.field_70125_A;
      float f5 = par5EntityLivingBase.field_70758_at;
      float f6 = par5EntityLivingBase.field_70759_as;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_74519_b();
      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      par5EntityLivingBase.field_70761_aq = headRoton ? -((float)Math.atan((double)(par3 / 40.0F))) * 20.0F : 0.0F;
      par5EntityLivingBase.field_70177_z = headRoton ? -((float)Math.atan((double)(par3 / 40.0F))) * 40.0F : (float)headRotX;
      par5EntityLivingBase.field_70125_A = headRoton ? -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F : (float)headRotZ;
      par5EntityLivingBase.field_70759_as = par5EntityLivingBase.field_70177_z;
      par5EntityLivingBase.field_70758_at = par5EntityLivingBase.field_70177_z;
      GL11.glTranslatef(0.0F, par5EntityLivingBase.field_70129_M, 0.0F);
      RenderManager.field_78727_a.field_78735_i = 180.0F;
      RenderManager.field_78727_a.func_147940_a(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      par5EntityLivingBase.field_70761_aq = f2;
      par5EntityLivingBase.field_70177_z = f3;
      par5EntityLivingBase.field_70125_A = f4;
      par5EntityLivingBase.field_70758_at = f5;
      par5EntityLivingBase.field_70759_as = f6;
      GL11.glPopMatrix();
      RenderHelper.func_74518_a();
      GL11.glDisable(32826);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   public void lostOwnership(Clipboard aClipboard, Transferable aContents) {
   }

   public void setClipboardContents(String aString) {
      StringSelection stringSelection = new StringSelection(aString);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, this);
   }

   public String getClipboardContents() {
      String result = "";
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable contents = clipboard.getContents((Object)null);
      boolean hasTransferableText = contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
      if (hasTransferableText) {
         try {
            result = (String)contents.getTransferData(DataFlavor.stringFlavor);
         } catch (UnsupportedFlavorException var6) {
            mod_JRMCore.logger.error(var6);
            var6.printStackTrace();
         } catch (IOException var7) {
            mod_JRMCore.logger.error(var7);
            var7.printStackTrace();
         }
      }

      return result;
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public boolean func_73868_f() {
      return false;
   }

   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
      int wid = var8.func_78256_a(var35) / 2;
      int posX = var6 / 2 + posx - wid;
      int posY = var7 / 2 + posy;
      var8.func_78276_b(var35, posX + 1, posY, 0);
      var8.func_78276_b(var35, posX - 1, posY, 0);
      var8.func_78276_b(var35, posX, posY + 1, 0);
      var8.func_78276_b(var35, posX, posY - 1, 0);
      var8.func_78276_b(var35, posX, posY, 8388564);
   }

   public void SagasPage(int var6, int var7) {
      this.textureFile = "jinryuudragonbc:sagas.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void SagasPrint() {
      this.func_73866_w_();
      Minecraft minecraft = JRMCoreClient.mc;
      World world = minecraft.field_71441_e;
      EntityPlayerSP entityplayersp = minecraft.field_71439_g;
      ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
      int width = scaledresolution.func_78326_a() / 2;
      int height = scaledresolution.func_78328_b() / 2;
      int widthplus = true;
      GL11.glEnable(3042);
      GL11.glEnable(32826);
      RenderHelper.func_74519_b();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73732_a(this.field_146289_q, this.Process, width + this.wid, height + this.hei, 16768306);
      GL11.glDisable(32826);
      GL11.glDisable(3042);
   }

   public void SagasBack(int var6, int var7) {
      int xSize = 182;
      int ySize = 191;
      int guiLeft = (var6 - xSize) / 2;
      int guiTop = (var7 - ySize) / 2;
      String var4 = "jinryuudragonbc:sagas.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation guiLocation = new ResourceLocation(var4);
      mc.field_71446_o.func_110577_a(guiLocation);
      this.func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
   }

   public void ScouterRenderBlur(int par1, int par2) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      ResourceLocation guiLocation = new ResourceLocation(this.textureFile);
      mc.field_71446_o.func_110577_a(guiLocation);
      Tessellator var3 = Tessellator.field_78398_a;
      var3.func_78382_b();
      var3.func_78374_a(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
      var3.func_78374_a((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
      var3.func_78374_a((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
      var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var3.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void sideSagas() {
      if ((int)((double)JRMCoreH.SagaSideProg * 0.01D) == 101) {
         this.sideSaga(101, 1, this.guiLeft + 6, this.guiTop + 5, 1);
      } else {
         this.sideSaga(100, 4, this.guiLeft + 6, this.guiTop + 5, 1);
      }

   }

   public void sideSaga(int s, int type, int x, int y, int n) {
      int posX = this.field_146294_l / 2;
      int posY = this.field_146295_m / 2;
      int nr = 0;
      if (JRMCoreH.SagaSideProg >= s * 100 && JRMCoreH.SagaSideProg <= s * 100 + 99 || this.smd != 0 && this.smd == s / 100) {
         int nr;
         if (JRMCoreH.SagaSideProg == s * 100 + 99) {
            this.Process = JRMCoreH.trl("jrmc", "reward");
            nr = nr + JRMCoreH.txt(this.Process, "§0", 0, true, x, y + nr * 10, 0);
         } else {
            this.Process = StatCollector.func_74838_a("dbc.sidesagas." + s / 100 * 100 + ".story");
            nr = nr + JRMCoreH.txt(this.Process, "§1", 0, true, x, y + nr * 10, 0);
            this.Process = StatCollector.func_74838_a("dbc.sidesagas." + s + ".title");
            nr += JRMCoreH.txt(this.Process, "§8", 5, true, x, y + nr * 10, 0);
            this.Process = StatCollector.func_74838_a("dbc.sidesagas." + s + ".desc");
            nr += JRMCoreH.txt(this.Process, "§0", 10, true, x, y + nr * 10, 0);
            this.Process = StatCollector.func_74838_a("dbc.sidesagas." + s + ".obj");
            nr += JRMCoreH.txt(this.Process, "§9", 5, true, x, y + nr * 10, 0);
            if (type != 1 && JRMCoreH.SagaSideProg != 0) {
               boolean b = false;
               if (type == 2) {
                  b = true;
                  if (JRMCoreH.SagaSideProg >= s * 100 + 10) {
                     this.Process = "" + (JRMCoreH.SagaSideProg - (s * 100 + 10) == 0 ? StatCollector.func_74838_a("dbc.sagasystem.all.none") : StatCollector.func_74838_a("dbc.sagasystem.all.one")) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.tk");
                  }
               }

               if (type == 3) {
                  b = true;
                  if (JRMCoreH.SagaSideProg >= s * 100 + 10) {
                     this.Process = "" + (JRMCoreH.SagaSideProg - (s * 100 + 10)) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.ak");
                  }
               }

               if (type == 4) {
                  b = true;
                  this.Process = "" + (JRMCoreH.SagaSideProg - s * 100) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.ak");
               }

               if (b) {
                  nr += JRMCoreH.txt(this.Process, "§2", 5, true, x, y + nr * 10, 0);
               }
            }

            if (JRMCoreH.SagaSideProg == 0) {
               this.Process = JRMCoreH.trl("jrmc", "accept");
               this.field_146292_n.add(new JRMCoreGuiButtons00(-1 * (1000 + s / 100), posX + 60, posY + 50, this.field_146289_q.func_78256_a(this.Process) + 8, 20, this.Process, 0));
               this.Process = JRMCoreH.trl("jrmc", "decline");
               this.field_146292_n.add(new JRMCoreGuiButtons00(1000, posX - 60, posY + 50, this.field_146289_q.func_78256_a(this.Process) + 8, 20, this.Process, 0));
            } else {
               this.Process = JRMCoreH.trl("jrmc", "abandon");
               this.field_146292_n.add(new JRMCoreGuiButtons00(-1000, posX - 60, posY + 50, this.field_146289_q.func_78256_a(this.Process) + 8, 20, this.Process, 0));
            }
         }
      } else {
         this.Process = StatCollector.func_74838_a("dbc.sidesagas." + s / 100 * 100 + ".story");
         this.field_146292_n.add(new JRMCoreGuiButtons01(1000 + s / 100, posX - 122, posY - 74 + n * 10, this.field_146289_q.func_78256_a(this.Process), this.Process, 0));
      }

   }

   public void mainSaga(int title, int saganum, int type, int x, int y) {
      int nr = 0;
      int nr;
      if (JRMCoreH.SagaProg >= saganum * 100 && JRMCoreH.SagaProg <= saganum * 100 + 99) {
         if (title == 1) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.saiyan");
         }

         if (title == 2) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.freeza");
         }

         if (title == 3) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.android");
         }

         if (title == 4) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.buu");
         }

         if (title == 5) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.beerus");
         }

         if (title == 6) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.gfreeza");
         }

         if (title == 7) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.universe6");
         }

         if (title == 8) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.cvegeta");
         }

         if (title == 9) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.dbsftrunks");
         }

         if (title == 99) {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem.credits");
         }

         nr = nr + JRMCoreH.txt(this.Process, "§1", 0, true, x, y + nr * 10, 0);
         if (JRMCoreH.SagaProg == saganum * 100 + 99) {
            this.Process = JRMCoreH.trl("jrmc", "reward");
            nr += JRMCoreH.txt(this.Process, "§0", 0, true, x, y + nr * 10, 0);
         } else {
            this.Process = StatCollector.func_74838_a("dbc.sagasystem." + saganum + ".title");
            nr += JRMCoreH.txt(this.Process, "§8", 5, true, x, y + nr * 10, 0);
            this.Process = StatCollector.func_74838_a("dbc.sagasystem." + saganum + ".desc");
            nr += JRMCoreH.txt(this.Process, "§0", 10, true, x, y + nr * 10, 0);
            this.Process = StatCollector.func_74838_a("dbc.sagasystem." + saganum + ".obj");
            nr += JRMCoreH.txt(this.Process, "§9", 5, true, x, y + nr * 10, 0);
            if (type != 1) {
               boolean b = false;
               if (type == 2 && JRMCoreH.SagaProg >= saganum * 100 + 10) {
                  b = true;
                  this.Process = "" + (JRMCoreH.SagaProg - (saganum * 100 + 10) == 0 ? StatCollector.func_74838_a("dbc.sagasystem.all.none") : StatCollector.func_74838_a("dbc.sagasystem.all.one")) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.tk");
               }

               if (type == 3 && JRMCoreH.SagaProg >= saganum * 100 + 10) {
                  b = true;
                  this.Process = "" + (JRMCoreH.SagaProg - (saganum * 100 + 10)) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.ak");
               }

               if (type == 4) {
                  b = true;
                  this.Process = "" + (JRMCoreH.SagaProg - saganum * 100) + " " + StatCollector.func_74838_a("dbc.sagasystem.all.ak");
               }

               if (b) {
                  nr += JRMCoreH.txt(this.Process, "§2", 5, true, x, y + nr * 10, 0);
               }
            }
         }
      } else if (JRMCoreH.SagaProg < 100) {
         this.Process = StatCollector.func_74838_a("dbc.sagasystem.0.title");
         nr = nr + JRMCoreH.txt(this.Process, "§8", 0, true, x, y + nr * 10, 0);
         this.Process = StatCollector.func_74838_a("dbc.sagasystem.0.desc");
         nr += JRMCoreH.txt(this.Process, "§0", 5, true, x, y + nr * 10, 0);
         this.Process = StatCollector.func_74838_a("dbc.sagasystem.0.obj");
         nr += JRMCoreH.txt(this.Process, "§9", 10, true, x, y + nr * 10, 0);
      }

   }

   public static void dataSend(String c, String d) {
      PD.sendToServer(new JRMCorePData2(c, d));
   }

   public void msys(String sid, int x, int y) {
      int szx = 14;
      int curm = JRMCoreM.getSydaAmount(JRMCoreH.MSD);
      int mainMsnID = JRMCoreM.getMda_SeriesByID(JRMCoreH.MSD, sid);
      int MsnID = 0;
      if (mainMsnID >= 0) {
         MsnID = JRMCoreM.getMda_Mission(JRMCoreH.MSD, mainMsnID);
      }

      JRMCoreMsn msn = (JRMCoreMsn)JRMCoreM.missionsC.get(sid);
      int m1 = scrlld;
      float m2 = 5.0F;
      int sz = 10;
      this.scrollMouseJump = 1;
      if (m1 > sz) {
         if ((float)m1 - m2 < (float)this.scroll) {
            this.scroll = (int)((float)m1 - m2);
         } else if (this.scroll < 0) {
            this.scroll = 0;
         }

         if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
            this.scroll = (int)(((float)m1 - m2) * scrollSide);
         } else {
            scrollSide = JRMCoreGuiSliderX00.sliderValue = (float)this.scroll / ((float)m1 - m2);
         }
      } else {
         this.scroll = 0;
      }

      if (m1 > sz) {
         if (scrollSide > 0.0F) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA1(43, this.guiLeft + this.xSize / 2 + 110 + 18, this.guiTop + 80 - 70, "i"));
         }

         if (scrollSide < 1.0F) {
            this.field_146292_n.add(new JRMCoreGuiButtonsA1(44, this.guiLeft + this.xSize / 2 + 110 + 18, this.guiTop + 80 + 60, "v"));
         }

         this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, this.guiLeft + this.xSize / 2 + 110 + 18, this.guiTop + 25, this.mousePressed, scrollSide, 1.0F));
      }

      int nr = 0;
      int nr;
      if (!JRMCoreH.MSD.equals(" ") && msn != null && msn.getId() == MsnID) {
         boolean t = msn.isTranslated();
         String s = msn.getTitle(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
         nr = nr + JRMCoreH.txt(t ? JRMCoreH.trl(s) : s, "§1", 0, true, x, y + (nr - this.scroll) * 10, 0, this.scroll - nr, 0);
         s = msn.getSubtitle(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
         nr += JRMCoreH.txt(t ? JRMCoreH.trl(s) : s, "§8", 5, true, x + 5, y + (nr - this.scroll) * 10, 0, this.scroll - nr, 0);
         ArrayList<String> a = msn.getObjectives(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
         String btnN = (String)a.get(0);
         String[] syncMda = JRMCoreM.getMda(JRMCoreH.MSD, sid);
         if (syncMda.length > 1) {
            s = msn.getDescription(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
            int snr = this.scroll - nr;
            snr += snr > 0 ? 1 : 0;
            int test = szx + snr;
            nr += JRMCoreH.txtH(t ? JRMCoreH.trl(s) : s, "§0", 10, true, x, y + (nr - this.scroll) * 10, 0, snr, test, this.field_146292_n);
            ArrayList r;
            String ul;
            int k;
            if (JRMCoreM.getMda_ObjComp_all(a, syncMda, JRMCoreH.GMN)) {
               r = msn.getRewards(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
               ul = (String)msn.getProps().get(0);
               boolean rr = ul.equalsIgnoreCase("randrew");

               for(int i = 0; i < (rr ? 1 : r.size()); ++i) {
                  String[] rw = ((String)r.get(i)).split(";");
                  String bs = JRMCoreH.trl(rw[1]);
                  k = this.field_146289_q.func_78256_a(bs) + 8;
                  if (nr - this.scroll < szx - 1 && this.scroll - nr < 0) {
                     this.field_146292_n.add(new JRMCoreGuiButtons00MS(6000, this.guiLeft + this.xSize / 2 - k / 2, y + (nr - this.scroll) * 11, k, 20, bs, 0, sid, "" + i));
                  }

                  ++nr;
                  ++nr;
               }
            } else {
               r = (ArrayList)JRMCoreM.missionsCD.get(sid);
               ul = r.size() > 7 ? JRMCoreH.trl((String)r.get(7)) : "";
               String nsds = "";
               String[] syncMdaV = JRMCoreM.getMda(JRMCoreH.MSDV, sid);
               boolean unlocked = true;
               String nsd;
               String[] sidd;
               String nsd;
               if (ul.length() > 0) {
                  sidd = ul.split(",");

                  for(k = 0; k < sidd.length; ++k) {
                     unlocked = JRMCoreM.isUnlocked(sidd[k], JRMCoreH.MSD, JRMCoreH.MSDV);
                     if (!unlocked) {
                        break;
                     }
                  }

                  for(k = 0; k < sidd.length; ++k) {
                     unlocked = JRMCoreM.isUnlocked(sidd[k], JRMCoreH.MSD, JRMCoreH.MSDV);
                     if (sidd[k].contains(":")) {
                        String[] nmd = sidd[k].split(":");
                        ArrayList<String> dd = (ArrayList)JRMCoreM.missionsCD.get(nmd[0]);
                        if (dd != null) {
                           nsd = JRMCoreH.trl((String)dd.get(1));
                           if (!unlocked) {
                              nsds = nsds + "/n" + nsd + " (ID: " + nmd[1] + ")";
                           }
                        }
                     } else {
                        ArrayList<String> dd = (ArrayList)JRMCoreM.missionsCD.get(sidd[k]);
                        if (dd != null) {
                           nsd = JRMCoreH.trl((String)dd.get(1));
                           if (!unlocked) {
                              nsds = nsds + "/n" + nsd;
                           }
                        }
                     }
                  }
               }

               sidd = JRMCoreM.getMda(JRMCoreH.MSDV, sid);
               String rpv = JRMCoreM.getSydaV(sidd, 2);
               int rpi = Integer.parseInt(rpv) * 5;
               nsd = rpi > 0 ? JRMCoreH.trl("jrmc", "missionRepeat.wait", JRMCoreH.format_lz2(rpi / 1 % 60), JRMCoreH.format_lz2(rpi / 60 % 60), JRMCoreH.format_lz2(rpi / 3600 % 24), JRMCoreH.format_lz2(rpi / 86400)) : "";
               nsd = rpi > 0 ? nsd + "/n" : (rpi < 0 ? JRMCoreH.trl("jrmc", "missionRepeat.not") + "/n" : "");
               String lkd = unlocked ? "" : JRMCoreH.trl("jrmc", "missionUnlock") + nsds;
               String lkd1 = rpi <= 0 && rpi >= 0 ? "" : nsd;
               boolean lck = !unlocked || rpi > 0 || rpi < 0;
               String lkd2 = lck ? JRMCoreH.cldr + "Locked!/n" + lkd + lkd1 : "";
               if (!lck) {
                  for(int i = 1; i < a.size(); ++i) {
                     String nss = JRMCoreM.getMda_Con(syncMda, JRMCoreM.SYNC_COND_data(i));
                     nr += JRMCoreH.txt(JRMCoreM.getMCo_readable((String)a.get(i), nss, JRMCoreH.GMN), "§9", 5, true, x, y + (nr - this.scroll) * 10, 0, this.scroll - nr, nr - this.scroll > szx ? nr - this.scroll - szx : 0);
                     --nr;
                  }

                  if (JRMCoreM.getMda_btn_Start(a, syncMda, JRMCoreH.GMN)) {
                     String bs = JRMCoreM.getBtn(btnN);
                     int bsw = this.field_146289_q.func_78256_a(bs) + 8;
                     this.field_146292_n.add(new JRMCoreGuiButtons00MS(6000, this.guiLeft + this.xSize / 2 + 60, this.guiTop + (this.ySize + 1) / 2 + 50, bsw, 20, bs, 0, sid, a.size() == 1 ? "-2" : "-1"));
                  }
               } else {
                  nr += JRMCoreH.txt(lkd2, "§9", 5, true, x, y + (nr - this.scroll) * 10, 0, this.scroll - nr, nr - this.scroll + 3 > szx ? nr - this.scroll - szx + 3 : 0);
                  --nr;
               }
            }
         }
      } else {
         nr = nr + JRMCoreH.txt("DOWNLOADING MISSION...", "§1", 0, true, x, y + nr * 10, 0);
         if (tick == 0) {
            PD.sendToServer(new JRMCorePData2("", ""));
         }
      }

      scrlld = nr;
   }

   public void dri(int id) {
      PD.sendToServer(new DBCPdri(id));
   }

   public String getAttributeBonusDescription(int attributeID) {
      if (JRMCoreConfig.JRMCABonusOn) {
         String attributeMulti2 = "\n  Bonus Attributes:";
         String description = "\n  Bonus Attributes:";
         String[] bonuses = JRMCoreH.getBonusAttributes(attributeID).split("\\|");
         String[] var5 = bonuses;
         int var6 = bonuses.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String bonus = var5[var7];
            if (bonus.equals("n")) {
               description = description + "\n    NA";
            } else {
               description = description + "\n    " + bonus.replace(";", ": ");
            }
         }

         return description;
      } else {
         return "";
      }
   }

   public String getClientConfigText(String configName, boolean configValue) {
      return JRMCoreH.trl("jrmc", configName) + ": " + (configValue ? JRMCoreH.trl("jrmc", "SETTON") : JRMCoreH.trl("jrmc", "SETTOFF"));
   }

   public static void drawStringWithBorder(FontRenderer fontRendererObj, String text, int x, int y, int color, int borderColor) {
      fontRendererObj.func_78276_b(text, x + 1, y + 2, borderColor);
      fontRendererObj.func_78276_b(text, x - 1, y + 2, borderColor);
      fontRendererObj.func_78276_b(text, x, y + 1 + 2, borderColor);
      fontRendererObj.func_78276_b(text, x, y - 1 + 2, borderColor);
      fontRendererObj.func_78276_b(text, x, y + 2, color);
   }

   public static void drawStringWithBorder(FontRenderer fontRendererObj, String text, int x, int y, int color) {
      drawStringWithBorder(fontRendererObj, text, x, y, color, 0);
   }

   private String textLevel(int lvl) {
      return "§8(lvl: " + lvl + ")";
   }

   private void updateMajinHairToBodyColor() {
      if (JRMCoreH.isRaceMajin(RaceSlcted) && ColorSlcted != BodyColMainSlcted) {
         ColorSlcted = BodyColMainSlcted;
         setdnsForHair();
      }

   }

   static {
      owner = JRMCoreClient.mc.field_71439_g.func_70005_c_();
      type = JRMCoreH.techBase[3];
      speed = JRMCoreH.techBase[4];
      dam = JRMCoreH.techBase[5];
      effect = JRMCoreH.techBase[6];
      cost = JRMCoreH.techBase[7];
      casttime = JRMCoreH.techBase[8];
      cooldown = JRMCoreH.techBase[9];
      color = JRMCoreH.techBase[10];
      density = JRMCoreH.techBase[11];
      sincantation = JRMCoreH.techBase[12];
      sfire = JRMCoreH.techBase[13];
      smove = JRMCoreH.techBase[14];
      techCrt = new int[]{1, acquired, 1, type, speed, dam, effect, cost, casttime, cooldown, color, density, sincantation, sfire, smove};
      button1 = JRMCoreH.tjjrmc + ":button1.png";
      button2 = JRMCoreH.tjjrmc + ":button2.png";
      wish = JRMCoreH.tjjrmc + ":gui.png";
      guiBG2 = JRMCoreH.tjjrmc + ":gui2.png";
      pc = JRMCoreH.tjjrmc + ":gui_pc.png";
      gui_help_tabs = JRMCoreH.tjjrmc + ":help/tab0.png";
      wishsep = JRMCoreH.tjjrmc + ":guidev.png";
      icons = JRMCoreH.tjjrmc + ":icons.png";
      colorType = 0;
      StateSlcted = 0;
      RaceSlcted = 0;
      GenderSlcted = 0;
      YearsSlcted = 3;
      HairSlcted = 10;
      Hair2Slcted = 0;
      ColorSlcted = 0;
      BreastSizeSlcted = 4;
      SkinTypeSlcted = 0;
      BodyTypeSlcted = 0;
      BodyColPresetSlcted = 0;
      BodyColMainSlcted = 0;
      BodyColSub1Slcted = 0;
      BodyColSub2Slcted = 0;
      BodyColSub3Slcted = 0;
      FaceNoseSlcted = 0;
      FaceMouthSlcted = 0;
      EyesSlcted = 0;
      EyeColPresetSlcted = 0;
      EyeCol1Slcted = 0;
      EyeCol2Slcted = 0;
      BodyauColMainSlcted = 0;
      BodyauColSub1Slcted = 0;
      BodyauColSub2Slcted = 0;
      BodyauColSub3Slcted = 0;
      HairPrstsSlcted = 0;
      canSavePreset = true;
      BrghtSlcted = 0.8F;
      PwrtypSlcted = 0;
      ClassSlcted = 0;
      tail = true;
      KiColorSlcted = 0;
      PresetList = new ArrayList();
      tick = 0;
      dnsau = JRMCoreH.dnsau;
      dns = JRMCoreH.dns;
      dnsSent = "";
      dnsOrig = "";
      dnsH = JRMCoreH.dnsH;
      dnsHSent = "";
      dnsHOrig = "";
      detailList = new ArrayList();
      ssc = "";
      sscr = 0;
      field_110408_a = new ResourceLocation("textures/gui/container/inventory.png");
      count = 0;
      warn = 0;
      startcount = 0;
      scrlld = 0;
   }
}
