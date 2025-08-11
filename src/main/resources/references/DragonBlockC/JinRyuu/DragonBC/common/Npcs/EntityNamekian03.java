package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityNamekian03 extends EntityVillager implements INpc, IMerchant {
   public final int AttPow;
   public final int HePo;
   private int randomTickDivider;
   private boolean isMating;
   private boolean isPlaying;
   Village field_70954_d;
   private EntityPlayer buyingPlayer;
   private MerchantRecipeList buyingList;
   private int timeUntilReset;
   private boolean needsInitilization;
   private int wealth;
   private String lastBuyingPlayer;
   private boolean field_82190_bM;
   private float field_82191_bN;
   public static final Map villagerStockList = new HashMap();
   public static final Map blacksmithSellingList = new HashMap();

   public EntityNamekian03(World par1World) {
      this(par1World, 0);
   }

   public EntityNamekian03(World par1World, int par2) {
      super(par1World);
      this.AttPow = 30;
      this.HePo = 300;
      this.randomTickDivider = 0;
      this.isMating = false;
      this.isPlaying = false;
      this.field_70954_d = null;
      this.func_70938_b(par2);
      this.func_70661_as().func_75498_b(true);
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.30000001192092896D, 0.3499999940395355D));
      this.field_70714_bg.func_75776_a(1, new EntityAITradePlayer(this));
      this.field_70714_bg.func_75776_a(1, new EntityAILookAtTradePlayer(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIMoveIndoors(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIRestrictOpenDoor(this));
      this.field_70714_bg.func_75776_a(4, new EntityAIOpenDoor(this, true));
      this.field_70714_bg.func_75776_a(6, new EntityAIVillagerMate(this));
      this.field_70714_bg.func_75776_a(7, new EntityAIFollowGolem(this));
      this.field_70714_bg.func_75776_a(8, new EntityAIPlay(this, 0.3199999928474426D));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWander(this, 0.30000001192092896D));
      this.field_70714_bg.func_75776_a(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityNamekian01) {
                  EntityNamekian01 var7 = (EntityNamekian01)var6;
                  var7.becomeAngryAt(var3);
               }
            }
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }

   public boolean func_70650_aV() {
      return true;
   }

   protected void func_70629_bd() {
      if (--this.randomTickDivider <= 0) {
         this.world.field_72982_D.func_75551_a(MathHelper.func_76128_c(this.posX), MathHelper.func_76128_c(this.posY), MathHelper.func_76128_c(this.posZ));
         this.randomTickDivider = 70 + this.rand.nextInt(50);
         this.field_70954_d = this.world.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.posX), MathHelper.func_76128_c(this.posY), MathHelper.func_76128_c(this.posZ), 32);
         if (this.field_70954_d != null) {
            ChunkCoordinates var1 = this.field_70954_d.func_75577_a();
            if (this.field_82190_bM) {
               this.field_82190_bM = false;
            }
         }
      }

      if (!this.func_70940_q() && this.timeUntilReset > 0) {
         --this.timeUntilReset;
         if (this.timeUntilReset <= 0) {
            if (this.needsInitilization) {
               MerchantRecipe var2;
               if (this.buyingList.size() > 1) {
                  for(Iterator var3 = this.buyingList.iterator(); var3.hasNext(); var2 = (MerchantRecipe)var3.next()) {
                  }
               }

               this.addDefaultEquipmentAndRecipies(1);
               this.needsInitilization = false;
               if (this.field_70954_d != null && this.lastBuyingPlayer != null) {
                  this.world.func_72960_a(this, (byte)14);
                  this.field_70954_d.func_82688_a(this.lastBuyingPlayer, 1);
               }
            }

            this.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
         }
      }

      super.func_70629_bd();
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return true;
   }

   protected void entityInit() {
      super.entityInit();
      this.field_70180_af.func_75682_a(20, 0);
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
      par1NBTTagCompound.func_74768_a("Profession", this.func_70946_n());
      par1NBTTagCompound.func_74768_a("Riches", this.wealth);
      if (this.buyingList != null) {
         par1NBTTagCompound.func_74782_a("Offers", this.buyingList.func_77202_a());
      }

   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
      this.func_70938_b(par1NBTTagCompound.func_74762_e("Profession"));
      this.wealth = par1NBTTagCompound.func_74762_e("Riches");
      if (par1NBTTagCompound.func_74764_b("Offers")) {
         NBTTagCompound var2 = par1NBTTagCompound.func_74775_l("Offers");
         this.buyingList = new MerchantRecipeList(var2);
      }

   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/namek02.png";
   }

   protected boolean func_70692_ba() {
      return false;
   }

   public void func_70938_b(int par1) {
      this.field_70180_af.func_75692_b(16, par1);
   }

   public int func_70946_n() {
      return this.field_70180_af.func_75679_c(16);
   }

   public boolean func_70941_o() {
      return this.isMating;
   }

   public void func_70947_e(boolean par1) {
      this.isMating = par1;
   }

   public void func_70939_f(boolean par1) {
      this.isPlaying = par1;
   }

   public boolean func_70945_p() {
      return this.isPlaying;
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      if (this.field_70954_d != null) {
         Entity var2 = par1DamageSource.func_76346_g();
         if (var2 != null) {
            if (var2 instanceof EntityPlayer) {
               int al = JRMCoreH.getByte((EntityPlayer)var2, "jrmcAlign");
               int al = al - 20;
               al = al < 0 ? 0 : al;
               JRMCoreH.setByte(al, (EntityPlayer)var2, "jrmcAlign");
               int kr = JRMCoreH.getInt((EntityPlayer)var2, "jrmcKarma");
               JRMCoreH.setInt(kr + 1, (EntityPlayer)var2, "jrmcKarma");
               ((EntityPlayer)var2).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
               this.field_70954_d.func_82688_a(((EntityPlayer)var2).getName(), -2);
            } else if (var2 instanceof IMob) {
               this.field_70954_d.func_82692_h();
            }
         } else if (var2 == null) {
            EntityPlayer var3 = this.world.func_72890_a(this, 16.0D);
            if (var3 != null) {
               this.field_70954_d.func_82692_h();
            }
         }
      }

      super.func_70645_a(par1DamageSource);
   }

   public void func_70932_a_(EntityPlayer par1EntityPlayer) {
      this.buyingPlayer = par1EntityPlayer;
   }

   public EntityPlayer func_70931_l_() {
      return this.buyingPlayer;
   }

   public boolean func_70940_q() {
      return this.buyingPlayer != null;
   }

   public void func_70933_a(MerchantRecipe par1MerchantRecipe) {
      par1MerchantRecipe.func_77399_f();
      if (par1MerchantRecipe.func_77393_a((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
         this.timeUntilReset = 40;
         this.needsInitilization = true;
         if (this.buyingPlayer != null) {
            this.lastBuyingPlayer = this.buyingPlayer.getName();
         } else {
            this.lastBuyingPlayer = null;
         }
      }

   }

   public MerchantRecipeList func_70934_b(EntityPlayer par1EntityPlayer) {
      if (this.buyingList == null) {
         this.addDefaultEquipmentAndRecipies(1);
      }

      return this.buyingList;
   }

   private float adjustProbability(float par1) {
      float var2 = par1 + this.field_82191_bN;
      return var2 > 0.9F ? 0.9F - (var2 - 0.9F) : var2;
   }

   private void addDefaultEquipmentAndRecipies(int par1) {
      if (this.buyingList != null) {
         this.field_82191_bN = MathHelper.func_76129_c((float)this.buyingList.size()) * 0.2F;
      } else {
         this.field_82191_bN = 0.0F;
      }

      MerchantRecipeList var2 = new MerchantRecipeList();
      VillagerRegistry.manageVillagerTrades(var2, this, this.func_70946_n(), this.rand);
      if (var2.isEmpty()) {
      }

      Collections.shuffle(var2);
      if (this.buyingList == null) {
         this.buyingList = new MerchantRecipeList();
      }

      for(int var9 = 0; var9 < par1 && var9 < var2.size(); ++var9) {
         this.buyingList.func_77205_a((MerchantRecipe)var2.get(var9));
      }

   }

   private static int getRandomCountForItem(int par0, Random par1Random) {
      Tuple var2 = (Tuple)villagerStockList.get(par0);
      return var2 == null ? 1 : ((Integer)var2.func_76341_a() >= (Integer)var2.func_76340_b() ? (Integer)var2.func_76341_a() : (Integer)var2.func_76341_a() + par1Random.nextInt((Integer)var2.func_76340_b() - (Integer)var2.func_76341_a()));
   }

   private static int getRandomCountForBlacksmithItem(int par0, Random par1Random) {
      Tuple var2 = (Tuple)blacksmithSellingList.get(par0);
      return var2 == null ? 1 : ((Integer)var2.func_76341_a() >= (Integer)var2.func_76340_b() ? (Integer)var2.func_76341_a() : (Integer)var2.func_76341_a() + par1Random.nextInt((Integer)var2.func_76340_b() - (Integer)var2.func_76341_a()));
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte par1) {
      if (par1 == 12) {
         this.generateRandomParticles("heart");
      } else if (par1 == 13) {
         this.generateRandomParticles("angryVillager");
      } else if (par1 == 14) {
         this.generateRandomParticles("happyVillager");
      } else {
         super.func_70103_a(par1);
      }

   }

   @SideOnly(Side.CLIENT)
   private void generateRandomParticles(String par1Str) {
      for(int var2 = 0; var2 < 5; ++var2) {
         double var3 = this.rand.nextGaussian() * 0.02D;
         double var5 = this.rand.nextGaussian() * 0.02D;
         double var7 = this.rand.nextGaussian() * 0.02D;
         this.world.func_72869_a(par1Str, this.posX + (double)(this.rand.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.field_70131_O), this.posZ + (double)(this.rand.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var3, var5, var7);
      }

   }

   public void initCreature() {
      VillagerRegistry.applyRandomTrade(this, this.world.field_73012_v);
   }

   public void func_82187_q() {
      this.field_82190_bM = true;
   }

   public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable) {
      EntityVillager var2 = new EntityVillager(this.world);
      return var2;
   }
}
