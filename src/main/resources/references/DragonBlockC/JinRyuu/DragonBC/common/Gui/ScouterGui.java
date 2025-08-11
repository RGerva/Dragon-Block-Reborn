package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCKiAttacks;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ScouterGui extends Gui {
   protected FontRenderer fontRenderer;
   private Minecraft mc;
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   public static int soundFunc2 = 0;
   int otherPlayerValue;
   public static int soundFunc3 = 0;
   protected String entiBP;
   protected String entiLoc;
   private String textureFile;

   public ScouterGui() {
      this.fontRenderer = DBCClient.mc.field_71466_p;
      this.mc = DBCClient.mc;
      this.otherPlayerValue = 0;
      this.entiBP = "§e";
      this.entiLoc = "§e";
      this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png";
   }

   public void initGui() {
   }

   public void ScFunctionsInit(int var6, int var7, int Tier) {
      this.ScouterRenderBlur(var6, var7);
      if (DBCClientTickHandler.ScFunc00 == 1) {
         this.ScouterIntro(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/intro.png";
         this.ScouterRenderBlur(var6, var7);
      }

      if (DBCClientTickHandler.ScFunc01 == 1) {
         this.ScouterFunction1(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/func1.png";
         this.ScouterRenderBlur(var6, var7);
      }

      if (DBCClientTickHandler.ScFunc02 == 1) {
         this.ScouterFunc2(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/func2.png";
         this.ScouterRenderBlur(var6, var7);
      }

      if (DBCClientTickHandler.ScFunc03 == 1) {
         this.ScouterFunc3(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/func3.png";
         this.ScouterRenderBlur(var6, var7);
      }

      if (DBCClientTickHandler.ScFunc04 == 1) {
         this.ScouterFunc2MP(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/func2mp.png";
         this.ScouterRenderBlur(var6, var7);
      }

      if (DBCClientTickHandler.ScFunc05 == 1) {
         this.ScouterFunc3MP(var6, var7, Tier);
         this.textureFile = "jinryuudragonbc:misc/func3mp.png";
         this.ScouterRenderBlur(var6, var7);
      }

   }

   public void renderKAC1() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      this.textureFile = "jinryuudragonbc:misc/KAC1.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void renderKAC2() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      this.textureFile = "jinryuudragonbc:misc/KAC2.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void renderKAC3() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      this.textureFile = "jinryuudragonbc:misc/KAC3.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void renderKAC4() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      this.textureFile = "jinryuudragonbc:misc/KAC4.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void renderKAC5() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      this.textureFile = "jinryuudragonbc:misc/KAC5.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void renderScouter() {
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      ItemStack stackhead = ExtendedPlayer.get(this.mc.player).inventory.func_70301_a(2);
      if (stackhead != null) {
         Item var9 = stackhead.func_77973_b();
         int Tier = 0;
         if (JRMCoreH.armTypScoutOn(stackhead)) {
            Tier = 1;
         }

         if (JRMCoreH.armTypScoutAOn(stackhead)) {
            Tier = 2;
         }

         if (JRMCoreH.armTypScoutBOn(stackhead)) {
            Tier = 3;
         }

         if (var9 == ItemsDBC.BattleArmorHelmet00 || var9 == ItemsDBC.BattleArmorHelmet00a || var9 == ItemsDBC.BattleArmorHelmet00b) {
            this.textureFile = "jinryuudragonbc:misc/scoutery0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (var9 == ItemsDBC.BattleArmorHelmet01 || var9 == ItemsDBC.BattleArmorHelmet01a || var9 == ItemsDBC.BattleArmorHelmet01b) {
            this.textureFile = "jinryuudragonbc:misc/scouterr0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (var9 == ItemsDBC.BattleArmorHelmet02 || var9 == ItemsDBC.BattleArmorHelmet02a || var9 == ItemsDBC.BattleArmorHelmet02b) {
            this.textureFile = "jinryuudragonbc:misc/scouterp0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (var9 == ItemsDBC.BattleArmorHelmet03 || var9 == ItemsDBC.BattleArmorHelmet03a || var9 == ItemsDBC.BattleArmorHelmet03b) {
            this.textureFile = "jinryuudragonbc:misc/scouterb0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (var9 == ItemsDBC.BattleArmorHelmet04 || var9 == ItemsDBC.BattleArmorHelmet04a || var9 == ItemsDBC.BattleArmorHelmet04b) {
            this.textureFile = "jinryuudragonbc:misc/scouterg0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (var9 == ItemsDBC.BattleArmorHelmet05 || var9 == ItemsDBC.BattleArmorHelmet05a || var9 == ItemsDBC.BattleArmorHelmet05b) {
            this.textureFile = "jinryuudragonbc:misc/scouterpi0.png";
            this.ScFunctionsInit(var6, var7, Tier);
         }

         if (JRMCoreH.armTypScoutAllOn(stackhead)) {
            if (var9.getDamage(stackhead) > 100) {
               this.textureFile = "jinryuudragonbc:misc/crack1.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var9.getDamage(stackhead) > 160) {
               this.textureFile = "jinryuudragonbc:misc/crack2.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var9.getDamage(stackhead) > 210) {
               this.textureFile = "jinryuudragonbc:misc/crack3.png";
               this.ScouterRenderBlur(var6, var7);
            }
         }
      }

      double MXZ = 8.0D;
      double MY = 8.0D;
      double XZ = 32.0D;
      double Y = 32.0D;
      double XZ1 = 16.0D;
      double Y1 = 16.0D;
      double XZ2 = 12.0D;
      double Y2 = 12.0D;
      double XZ3 = 4.0D;
      double Y3 = 4.0D;
      double XZ4 = 2.0D;
      double Y4 = 2.0D;
   }

   public void ScouterFunction1(int var6, int var7, int Tier) {
      double MXZ = 8.0D * (double)Tier;
      double MY = 8.0D * (double)Tier;
      double M2XZ = 8.0D * (double)Tier;
      double M2Y = 8.0D * (double)Tier;
      double XZ = 32.0D * (double)Tier;
      double Y = 32.0D * (double)Tier;
      double XZ1 = 16.0D * (double)Tier;
      double Y1 = 16.0D * (double)Tier;
      double XZ2 = 12.0D * (double)Tier;
      double Y2 = 12.0D * (double)Tier;
      double XZ3 = 4.0D * (double)Tier;
      double Y3 = 4.0D * (double)Tier;
      double XZ4 = 2.0D * (double)Tier;
      double Y4 = 2.0D * (double)Tier;
      double AXZ = 32.0D * (double)Tier;
      double AY = 16.0D * (double)Tier;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      double par42 = (double)this.mc.player.rotationYaw;
      float par52 = this.mc.player.rotationPitch;
      AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
      AxisAlignedBB AABBfent = AxisAlignedBB.func_72330_a(par12 - XZ4, par22 - Y4, par32 - XZ4, par12 + XZ4, par22 + Y1, par32 + XZ4);
      AxisAlignedBB AABBlent = AxisAlignedBB.func_72330_a(par12 - XZ4, par22 - Y1, par32 - XZ4, par12 + XZ4, par22 + Y4, par32 + XZ4);
      Class<EntityCreature> mobok = EntityCreature.class;
      Class<EntityBlaze> b = EntityBlaze.class;
      Class<EntityCaveSpider> c = EntityCaveSpider.class;
      Class<EntityCreeper> a = EntityCreeper.class;
      Class<EntityZombie> z = EntityZombie.class;
      Class<EntityGiantZombie> z2 = EntityGiantZombie.class;
      Class<EntityPigZombie> z3 = EntityPigZombie.class;
      Class<EntityGhast> g = EntityGhast.class;
      Class<EntityMagmaCube> m = EntityMagmaCube.class;
      Class<EntitySilverfish> i = EntitySilverfish.class;
      Class<EntitySkeleton> k = EntitySkeleton.class;
      Class<EntitySlime> l = EntitySlime.class;
      Class<EntitySpider> p = EntitySpider.class;
      Class<EntityPlayerMP> j = EntityPlayerMP.class;
      Class<EntityWitch> w = EntityWitch.class;
      Class<EntityEnderman> h = EntityEnderman.class;
      this.mc.player.world.func_72872_a(mobok, AxisAlignedBB.func_72330_a(par12 - XZ1, par22 - Y4, par32 - XZ1, par12 + XZ1, par22 + Y4, par32 + XZ1));
      this.mc.player.world.func_72872_a(mobok, AABBfent);
      this.mc.player.world.func_72872_a(mobok, AABBlent);
      List sarok = this.mc.player.world.func_72872_a(mobok, AxisAlignedBB.func_72330_a(par12 - XZ2, par22 - Y2, par32 - XZ2, par12 + XZ2, par22 + Y2, par32 + XZ2));
      List blaz = this.mc.player.world.func_72872_a(b, AABB);
      List cavs = this.mc.player.world.func_72872_a(c, AABB);
      List cree = this.mc.player.world.func_72872_a(a, AABB);
      List zomb = this.mc.player.world.func_72872_a(z, AABB);
      List zomv = this.mc.player.world.func_72872_a(z2, AABB);
      List zomp = this.mc.player.world.func_72872_a(z3, AABB);
      List ghas = this.mc.player.world.func_72872_a(g, AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - M2Y, par32 - M2XZ, par12 + M2XZ, par22 + M2Y, par32 + M2XZ));
      List magm = this.mc.player.world.func_72872_a(m, AABB);
      List silv = this.mc.player.world.func_72872_a(i, AABB);
      List skel = this.mc.player.world.func_72872_a(k, AABB);
      List slim = this.mc.player.world.func_72872_a(l, AABB);
      List spid = this.mc.player.world.func_72872_a(p, AABB);
      List play = this.mc.player.world.func_72872_a(j, AABB);
      List witc = this.mc.player.world.func_72872_a(w, AABB);
      List ende = this.mc.player.world.func_72872_a(h, AABB);
      if (!sarok.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png";
         this.ScouterRenderBlur(var6, var7);
         warn = 1;
         Class<? extends Entity> mobok1 = EntityCreature.class;
         List mobListAll = this.mc.player.world.func_72872_a(mobok1, AABBAll);
         this.mc.player.world.func_72872_a(mobok1, AABBfent);
         this.mc.player.world.func_72872_a(mobok1, AABBlent);
         Entity mobAll = this.mc.player.world.func_72857_a(mobok1, AABBAll, this.mc.player);
         this.mc.player.world.func_72857_a(mobok1, AABBfent, this.mc.player);
         this.mc.player.world.func_72857_a(mobok1, AABBlent, this.mc.player);
         if (!mobListAll.isEmpty()) {
            double var28 = mobAll.posX - par12;
            double var32 = mobAll.posZ - par32;
            double var27 = 0.0D;
            var27 = (par42 - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var32, var28);
            double field_76866_j = 0.0D;

            double var30;
            for(var30 = var27 - var27; var30 < -3.141592653589793D; var30 += 6.283185307179586D) {
            }

            while(var30 >= 3.141592653589793D) {
               var30 -= 6.283185307179586D;
            }

            if (var30 < -1.0D) {
               var30 = -1.0D;
            }

            if (var30 > 1.0D) {
               var30 = 1.0D;
            }

            field_76866_j += var30 * 0.1D;
            field_76866_j *= 0.8D;
            double field_76868_i = var27 + field_76866_j;
            var30 = Math.sin(field_76868_i);
            double var31 = Math.cos(field_76868_i);
            double var421 = mobAll.posY - par22 + 1.0D;
            double dist = (double)this.mc.player.func_70032_d(mobAll);
            double var271 = 0.0D;
            var271 = (double)par52 * 3.141592653589793D / 180.0D - Math.atan2(dist, var421);
            double field_76866_j1 = 0.0D;

            double var301;
            for(var301 = var271 - var271; var301 < -3.141592653589793D; var301 += 6.283185307179586D) {
            }

            while(var301 >= 3.141592653589793D) {
               var301 -= 6.283185307179586D;
            }

            if (var301 < -1.0D) {
               var301 = -1.0D;
            }

            if (var301 > 1.0D) {
               var301 = 1.0D;
            }

            field_76866_j1 += var301 * 0.1D;
            field_76866_j1 *= 0.8D;
            double field_76868_i1 = var271 + field_76866_j1;
            var301 = Math.sin(field_76868_i1);
            double var311 = Math.cos(field_76868_i1);
            if (var31 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/eszak.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var31 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/del.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var30 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/bal.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var30 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/jobb.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var311 > 0.1D) {
               this.textureFile = "jinryuudragonbc:misc/scouterfent.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var311 < -0.1D) {
               this.textureFile = "jinryuudragonbc:misc/scouterlent.png";
               this.ScouterRenderBlur(var6, var7);
            }
         }

         if (!blaz.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterB.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!cavs.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterC.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!cree.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterA.png";
            this.ScouterRenderBlur(var6, var7);
            this.textureFile = "jinryuudragonbc:misc/scouteregyeb.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!zomb.isEmpty() || !zomv.isEmpty() || !zomp.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterZ.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!magm.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterM.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!silv.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterI.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!skel.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterK.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!spid.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterP.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!play.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterJ.png";
            this.ScouterRenderBlur(var6, var7);
            count = 1;
         }

         if (!witc.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterW.png";
            this.ScouterRenderBlur(var6, var7);
         }

         if (!ende.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterH.png";
            this.ScouterRenderBlur(var6, var7);
         }
      }

      if (!slim.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterL.png";
         this.ScouterRenderBlur(var6, var7);
         startcount = 1;
      }

      if (!ghas.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterG.png";
         this.ScouterRenderBlur(var6, var7);
         startcount = 1;
      }

      if (sarok.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void ScouterSearch(int var6, int var7) {
   }

   public void ScouterFunc2(int var6, int var7, int Tier) {
      double MXZ = 16.0D * (double)Tier;
      double MY = 2.0D * (double)Tier;
      double M2XZ = 2.0D * (double)Tier;
      double M2Y = 16.0D * (double)Tier;
      double AXZ = 32.0D * (double)Tier;
      double AY = 16.0D * (double)Tier;
      double GXZ = 32.0D * (double)Tier;
      double GY = 32.0D * (double)Tier;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      double par42 = (double)this.mc.player.rotationYaw;
      AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
      AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      Class<? extends Entity> n = EntityMob.class;
      Class<? extends Entity> nam = EntityNamekian01.class;
      Class<? extends Entity> sa01 = EntitySaiyan01.class;
      Class<? extends Entity> sa02 = EntitySaiyan02.class;
      Class<? extends Entity> he01 = EntityHell01.class;
      Class<? extends Entity> he02 = EntityHell02.class;
      Class<? extends Entity> enm = EntityMasterEnma.class;
      Class<? extends Entity> mobok = EntityCreature.class;
      List mobListAll = this.mc.player.world.func_72872_a(mobok, AABBAll);
      Entity mobAll = this.mc.player.world.func_72857_a(mobok, AABBAll, this.mc.player);
      Class EntityClass;
      if (!mobListAll.isEmpty()) {
         EntityClass = mobAll.getClass();
         if (EntityClass == nam) {
            ;
         }

         if (EntityClass == sa01) {
            ;
         }

         if (EntityClass == sa02) {
            ;
         }

         if (EntityClass == he01) {
            ;
         }

         if (EntityClass == he02) {
            ;
         }

         if (EntityClass == enm) {
            ;
         }
      }

      if (!mobListAll.isEmpty()) {
         EntityClass = mobAll.getClass();
         soundFunc2 = 1;
         double entiNam = this.mc.player.func_70068_e(mobAll);
         int entiNamInt = (int)entiNam;
         this.toString();
         String entiNamStr = String.valueOf(entiNamInt);
         this.entiLoc = entiNamStr;
         this.textureFile = "jinryuudragonbc:misc/tavolsag.png";
         this.ScouterRenderBlur(var6, var7);
         this.Func2TAV();
      }

   }

   public void ScouterFunc3(int var6, int var7, int Tier) {
      Vec3 look = this.mc.player.func_70040_Z();
      double MXZ = 16.0D * (double)Tier;
      double MY = 2.0D * (double)Tier;
      double M2XZ = 2.0D * (double)Tier;
      double M2Y = 16.0D * (double)Tier;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      double par42 = (double)this.mc.player.rotationYaw;
      AxisAlignedBB AABBX0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBX1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + M2XZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBZ0 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - M2XZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBZ1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + M2XZ);
      AxisAlignedBB AABBY0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - M2Y, par32 - M2XZ, par12 + M2XZ, par22 + MY, par32 + M2XZ);
      AxisAlignedBB AABBY1 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - M2XZ, par12 + M2XZ, par22 + M2Y, par32 + M2XZ);
      AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      Class<? extends Entity> b = EntityBlaze.class;
      Class<? extends Entity> c = EntityCaveSpider.class;
      Class<? extends Entity> a = EntityCreeper.class;
      Class<? extends Entity> z = EntityZombie.class;
      Class<? extends Entity> z2 = EntityGiantZombie.class;
      Class<? extends Entity> z3 = EntityPigZombie.class;
      Class<? extends Entity> g = EntityGhast.class;
      Class<? extends Entity> m = EntityMagmaCube.class;
      Class<? extends Entity> i = EntitySilverfish.class;
      Class<? extends Entity> k = EntitySkeleton.class;
      Class<? extends Entity> l = EntitySlime.class;
      Class<? extends Entity> p = EntitySpider.class;
      Class<? extends Entity> j = EntityPlayerMP.class;
      Class<? extends Entity> w = EntityWitch.class;
      Class<? extends Entity> h = EntityEnderman.class;
      Class<? extends Entity> n = EntityMob.class;
      Class<? extends Entity> n2 = EntityMob.class;
      Class<EntityCreature> mobok = EntityCreature.class;
      List mobNear = this.mc.player.world.func_72872_a(mobok, AABBNear);
      Entity entMobok = this.mc.player.world.func_72857_a(mobok, AABBNear, this.mc.player);
      if (!mobNear.isEmpty()) {
         Class<? extends Entity> EntityClass = entMobok.getClass();
         if (EntityClass == b) {
            n2 = b;
         }

         if (EntityClass == c) {
            n2 = c;
         }

         if (EntityClass == a) {
            n2 = a;
         }

         if (EntityClass == z) {
            n2 = z;
         }

         if (EntityClass == z2) {
            n2 = z2;
         }

         if (EntityClass == z3) {
            n2 = z3;
         }

         if (EntityClass == g) {
            n2 = g;
         }

         if (EntityClass == m) {
            n2 = m;
         }

         if (EntityClass == i) {
            n2 = i;
         }

         if (EntityClass == k) {
            n2 = k;
         }

         if (EntityClass == l) {
            n2 = l;
         }

         if (EntityClass == p) {
            n2 = p;
         }

         if (EntityClass == j) {
            n2 = j;
         }

         if (EntityClass == w) {
            n2 = w;
         }

         if (EntityClass == h) {
            n2 = h;
         }
      }

      this.mc.player.world.func_72872_a(n, AABBX0);
      this.mc.player.world.func_72872_a(n, AABBX1);
      this.mc.player.world.func_72872_a(n, AABBZ0);
      this.mc.player.world.func_72872_a(n, AABBZ1);
      this.mc.player.world.func_72872_a(n, AABBY0);
      this.mc.player.world.func_72872_a(n, AABBY1);
      this.mc.player.world.func_72857_a(n, AABBNear, this.mc.player);
      if (!mobNear.isEmpty()) {
         List mobListAll = this.mc.player.world.func_72872_a(mobok, AABBNear);
         List mobListfent = this.mc.player.world.func_72872_a(mobok, AABBY1);
         List mobListlent = this.mc.player.world.func_72872_a(mobok, AABBY0);
         Entity mobAll = this.mc.player.world.func_72857_a(mobok, AABBNear, this.mc.player);
         this.mc.player.world.func_72857_a(mobok, AABBY1, this.mc.player);
         this.mc.player.world.func_72857_a(mobok, AABBY0, this.mc.player);
         if (!mobListAll.isEmpty()) {
            double var28 = mobAll.posX - par12;
            double var32 = mobAll.posZ - par32;
            double var27 = 0.0D;
            var27 = (par42 - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var32, var28);
            double field_76866_j = 0.0D;

            double var30;
            for(var30 = var27 - var27; var30 < -3.141592653589793D; var30 += 6.283185307179586D) {
            }

            while(var30 >= 3.141592653589793D) {
               var30 -= 6.283185307179586D;
            }

            if (var30 < -1.0D) {
               var30 = -1.0D;
            }

            if (var30 > 1.0D) {
               var30 = 1.0D;
            }

            field_76866_j += var30 * 0.1D;
            field_76866_j *= 0.8D;
            double field_76868_i = var27 + field_76866_j;
            var30 = Math.sin(field_76868_i);
            double var31 = Math.cos(field_76868_i);
            if (var31 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPeszak.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var31 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPdel.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var30 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPbal.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (var30 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPjobb.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (!mobListfent.isEmpty()) {
               this.textureFile = "jinryuudragonbc:misc/BPfent.png";
               this.ScouterRenderBlur(var6, var7);
            }

            if (!mobListlent.isEmpty()) {
               this.textureFile = "jinryuudragonbc:misc/BPlent.png";
               this.ScouterRenderBlur(var6, var7);
            }
         }
      }

      String entiNam = "0";
      int exp = false;
      new Random();
      if (!mobNear.isEmpty()) {
         Class<? extends Entity> EntityClass = entMobok.getClass();
         if (EntityClass == null) {
            entiNam = "Error";
         }

         if (EntityClass == n2) {
            entiNam = "" + JRMCoreH.bpc(entMobok);
            warn = 1;
         }

         if (EntityClass != n2 && EntityClass != null) {
            int exp = (int)(((EntityCreature)entMobok).func_110143_aJ() * 50.0F);
            warn = 1;
            if (exp <= 500 && EntityClass != EntityWolf.class) {
               exp = (int)(((EntityCreature)entMobok).func_110143_aJ() / 2.0F);
               warn = 0;
            }

            entiNam = "" + JRMCoreH.bpc(entMobok);
         }

         Entity dbc = this.mc.player.world.func_72857_a(EntityDBC.class, AABBNear, this.mc.player);
         if (dbc instanceof EntityDBC) {
            entiNam = "" + JRMCoreH.bpc(dbc);
            warn = 1;
         }
      }

      if (!mobNear.isEmpty()) {
         soundFunc3 = 1;
         long s = Long.parseLong(entiNam);
         String bc = "" + JRMCoreH.numSepShort(s);
         (new StringBuilder()).append("").append(bc).toString();
         if (Tier == 1 && s > 10000L || Tier == 2 && s > 1000000L) {
            DBCKiAttacks.dbctick(-2);
            DBCKiAttacks.scouterRem(this.mc.player);
         }

         this.entiBP = bc;
         this.textureFile = "jinryuudragonbc:misc/battlepower.png";
         this.ScouterRenderBlur(var6, var7);
         this.Func3BP();
      }

      if (mobNear.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void ScouterFunc2MP(int var6, int var7, int Tier) {
      double MXZ = 16.0D * (double)Tier;
      double MY = 2.0D * (double)Tier;
      double M2XZ = 2.0D * (double)Tier;
      double M2Y = 16.0D * (double)Tier;
      double AXZ = 32.0D * (double)Tier;
      double AY = 16.0D * (double)Tier;
      double GXZ = 32.0D * (double)Tier;
      double GY = 32.0D * (double)Tier;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
      AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      Class<? extends Entity> mobok = EntityPlayer.class;
      List mobListAll = this.mc.player.world.func_72872_a(mobok, AABBAll);
      Entity mobAll = this.mc.player.world.func_72857_a(mobok, AABBAll, this.mc.player);
      if (!mobListAll.isEmpty() && mobAll != null) {
         Class<? extends Entity> EntityClass = mobAll.getClass();
         if (mobAll == this.mc.player) {
            return;
         }

         soundFunc2 = 1;
         double entiNam = this.mc.player.func_70068_e(mobAll);
         int entiNamInt = (int)entiNam;
         this.toString();
         String entiNamStr = String.valueOf(entiNamInt);
         this.entiLoc = entiNamStr;
         this.Func2TAV();
         this.textureFile = "jinryuudragonbc:misc/tavolsag.png";
         this.ScouterRenderBlur(var6, var7);
      }

   }

   public void ScouterFunc3MP(int var6, int var7, int Tier) {
      double MXZ = 16.0D * (double)Tier;
      double M2Y = 16.0D * (double)Tier;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + M2Y, par32 + MXZ);
      Class<EntityPlayer> mobok = EntityPlayer.class;
      List mobNear = this.mc.player.world.func_72872_a(mobok, AABBNear);
      Entity entMobok = this.mc.player.world.func_72857_a(mobok, AABBNear, this.mc.player);
      if (!mobNear.isEmpty() && entMobok != null && entMobok != this.mc.player) {
         soundFunc3 = 1;
         String m = ((EntityPlayer)entMobok).getName();
         long s = JRMCoreH.bpc((EntityPlayer)entMobok, m, JRMCoreH.Pwrtyp);
         s = JRMCoreH.gkap(s, m);
         String bc = "" + JRMCoreH.numSepShort(s);
         if (Tier == 1 && s > 100000L || Tier == 2 && s > 1000000L) {
            DBCKiAttacks.dbctick(-2);
            DBCKiAttacks.scouterRem(this.mc.player);
         }

         this.entiBP = bc;
         this.textureFile = "jinryuudragonbc:misc/battlepower.png";
         this.ScouterRenderBlur(var6, var7);
         this.Func3BP();
      }

      if (mobNear.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void Func3BP() {
      this.initGui();
      Minecraft minecraft = this.mc;
      World world = minecraft.field_71441_e;
      EntityPlayerSP entityplayersp = minecraft.player;
      ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
      int width = scaledresolution.func_78326_a();
      int height = scaledresolution.func_78328_b();
      int widthplus = true;
      minecraft.field_71460_t.func_78478_c();
      RenderHelper.func_74519_b();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73732_a(this.fontRenderer, this.entiBP, width / 8, height / 40 * 16, 16768306);
   }

   public void Func2TAV() {
      this.initGui();
      EntityPlayerSP entityplayersp = this.mc.player;
      ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int width = scaledresolution.func_78326_a();
      int height = scaledresolution.func_78328_b();
      int widthplus = true;
      FontRenderer fontRender = this.mc.field_71466_p;
      this.mc.field_71460_t.func_78478_c();
      RenderHelper.func_74519_b();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73732_a(fontRender, this.entiLoc, width / 400 * 120, height / 40 * 15, 16768306);
   }

   public void ScouterDBRadar(int var6, int var7) {
      double MXZ = 32.0D;
      double MY = 8.0D;
      double M2XZ = 8.0D;
      double par12 = this.mc.player.posX;
      double par22 = this.mc.player.posY;
      double par32 = this.mc.player.posZ;
      AxisAlignedBB AABBX0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBX1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + M2XZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBZ0 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - M2XZ, par12 + MXZ, par22 + MY, par32 + MXZ);
      AxisAlignedBB AABBZ1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + M2XZ);
      this.mc.player.world.func_72830_b(AABBX0, DBCMaterial.dragonblock);
      this.mc.player.world.func_72830_b(AABBX1, DBCMaterial.dragonblock);
      this.mc.player.world.func_72830_b(AABBZ0, DBCMaterial.dragonblock);
      this.mc.player.world.func_72830_b(AABBZ1, DBCMaterial.dragonblock);
      boolean DBX0 = true;
      if (true) {
         this.textureFile = "jinryuudragonbc:misc/TAVjobb.png";
         this.ScouterRenderBlur(var6, var7);
      }

      boolean DBX1 = true;
      if (true) {
         this.textureFile = "jinryuudragonbc:misc/TAVbal.png";
         this.ScouterRenderBlur(var6, var7);
      }

      boolean DBZ0 = true;
      if (true) {
         this.textureFile = "jinryuudragonbc:misc/TAVeszak.png";
         this.ScouterRenderBlur(var6, var7);
      }

      boolean DBZ1 = true;
      if (true) {
         this.textureFile = "jinryuudragonbc:misc/TAVdel.png";
         this.ScouterRenderBlur(var6, var7);
      }

   }

   public void ScouterIntro(int var6, int var7, int tier2) {
      this.textureFile = "jinryuudragonbc:misc/intro.png";
      this.ScouterRenderBlur(var6, var7);
   }

   public void ScouterRenderBlur(int par1, int par2) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73735_i = -600.0F;
      ResourceLocation tx = new ResourceLocation(this.textureFile);
      this.mc.field_71446_o.bindTexture(tx);
      Tessellator var3 = Tessellator.INSTANCE;
      var3.func_78382_b();
      var3.func_78374_a(0.0D, (double)par2, (double)this.field_73735_i, 0.0D, 1.0D);
      var3.func_78374_a((double)par1, (double)par2, (double)this.field_73735_i, 1.0D, 1.0D);
      var3.func_78374_a((double)par1, 0.0D, (double)this.field_73735_i, 1.0D, 0.0D);
      var3.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, 0.0D);
      var3.func_78381_a();
      GL11.glDisable(3042);
   }
}
