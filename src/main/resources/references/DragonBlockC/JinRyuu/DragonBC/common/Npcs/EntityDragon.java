package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDragon extends EntityCreature {
   public int randomSoundDelay = 0;
   private int time = 0;
   public int timeBack = 0;
   private boolean granted = false;
   protected Entity closestEntity;
   float var1 = 8.0F;
   private float maxDistanceForPlayer = 4.0F;
   private int lookTime;
   private Class watchedClass;
   private int jumpTicks = 0;

   public EntityDragon(World par1World) {
      super(par1World);
      this.field_70728_aV = 0;
      this.func_94061_f(false);
      this.func_70105_a(2.0F, 25.0F);
      this.field_70130_N = 2.0F;
      this.field_70131_O = 25.0F;
      this.field_70121_D.field_72336_d = this.field_70121_D.field_72340_a + (double)this.field_70130_N;
      this.field_70121_D.field_72334_f = this.field_70121_D.field_72339_c + (double)this.field_70130_N;
      this.field_70121_D.field_72337_e = this.field_70121_D.field_72338_b + (double)this.field_70131_O;
      this.field_70714_bg.func_75776_a(0, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(1, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(2, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(3, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(4, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(0, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         if (!this.field_70170_p.field_72995_K) {
            if (!this.granted) {
               this.granted = true;
               JRMCoreH.setInt(1, par1EntityPlayer, "jrmcWishes");
               JRMCoreH.setInt(0, par1EntityPlayer, "jrmcDrgn");
            }
         } else if (!this.granted) {
            this.granted = true;
            par1EntityPlayer.openGui(mod_DragonBC.instance, 2, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
         }

         if (!par1EntityPlayer.field_70170_p.field_72995_K) {
            EntityDragon2 Dragon2 = new EntityDragon2(par1EntityPlayer.field_70170_p);
            Dragon2.func_70012_b((double)((int)this.field_70165_t), (double)((int)this.field_70163_u), (double)((int)this.field_70161_v), this.field_70177_z, 0.0F);
            Dragon2.timeBack = this.timeBack;
            par1EntityPlayer.field_70170_p.func_72838_d(Dragon2);
         }

         this.func_70106_y();
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   protected void func_70619_bc() {
   }

   public void shouldExecute() {
      this.closestEntity = this.field_70170_p.func_72890_a(this, (double)this.maxDistanceForPlayer);
      if (this.closestEntity != null) {
         this.watchedClass = EntityPlayer.class;
         this.func_70671_ap().func_75650_a(this.closestEntity.field_70165_t, this.closestEntity.field_70163_u + 2.0D, this.closestEntity.field_70161_v, 10.0F, (float)this.func_70646_bf());
      }

   }

   public void func_70071_h_() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      ++this.time;
      if (this.time == 1) {
         mod_DragonBC.logger.info("Shenron is Summoned!");
      }

      if (this.field_70170_p.field_72995_K) {
         DBCH.dragonSum(this);
      }

      float r = 30.0F;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - (double)r, this.field_70163_u - (double)r, this.field_70161_v - (double)r, this.field_70165_t + (double)r, this.field_70163_u + (double)r, this.field_70161_v + (double)r);
      List list = this.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
      if (list.size() == 0) {
         this.func_70106_y();
      }

      super.func_70071_h_();
      this.shouldExecute();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Dragon.png";
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   public void func_70636_d() {
      if (this.jumpTicks > 0) {
         --this.jumpTicks;
      }

      if (this.field_70716_bi > 0) {
         double d0 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
         double d1 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
         double d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / (double)this.field_70716_bi;
         double d3 = MathHelper.func_76138_g(this.field_70712_bm - (double)this.field_70177_z);
         this.field_70177_z = (float)((double)this.field_70177_z + d3 / (double)this.field_70716_bi);
         this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
         --this.field_70716_bi;
         this.func_70107_b(d0, d1, d2);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
      } else if (!this.func_70613_aW()) {
         this.field_70159_w *= 0.98D;
         this.field_70181_x *= 0.98D;
         this.field_70179_y *= 0.98D;
      }

      if (Math.abs(this.field_70159_w) < 0.005D) {
         this.field_70159_w = 0.0D;
      }

      if (Math.abs(this.field_70181_x) < 0.005D) {
         this.field_70181_x = 0.0D;
      }

      if (Math.abs(this.field_70179_y) < 0.005D) {
         this.field_70179_y = 0.0D;
      }

      this.field_70170_p.field_72984_F.func_76320_a("ai");
      if (this.func_70610_aX()) {
         this.field_70703_bu = false;
         this.field_70702_br = 0.0F;
         this.field_70701_bs = 0.0F;
         this.field_70704_bt = 0.0F;
      } else if (this.func_70613_aW()) {
         if (this.func_70650_aV()) {
            this.field_70170_p.field_72984_F.func_76320_a("newAi");
            this.func_70619_bc();
            this.field_70170_p.field_72984_F.func_76319_b();
         } else {
            this.field_70170_p.field_72984_F.func_76320_a("oldAi");
            this.field_70170_p.field_72984_F.func_76319_b();
            this.field_70759_as = this.field_70177_z;
         }
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("jump");
      if (this.field_70703_bu) {
         if (!this.func_70090_H() && !this.func_70058_J()) {
            if (this.field_70122_E && this.jumpTicks == 0) {
               this.func_70664_aZ();
               this.jumpTicks = 10;
            }
         } else {
            this.field_70181_x += 0.03999999910593033D;
         }
      } else {
         this.jumpTicks = 0;
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("travel");
      this.field_70702_br *= 0.98F;
      this.field_70701_bs *= 0.98F;
      this.field_70704_bt *= 0.9F;
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("push");
      if (!this.field_70170_p.field_72995_K) {
         this.func_85033_bc();
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("looting");
      if (!this.field_70170_p.field_72995_K && this.func_98052_bS() && !this.field_70729_aU && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      EntityPlayer var2 = this.field_70170_p.func_72890_a(this, (double)this.var1);
      if (var2 != null) {
         this.closestEntity = var2;
         this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
      } else {
         this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
      }

      if (this.closestEntity != null) {
         this.func_70625_a(this.closestEntity, 10.0F, (float)this.func_70646_bf());
         if (this.field_70700_bx-- <= 0 || this.closestEntity.field_70128_L || this.closestEntity.func_70068_e(this) > (double)(this.var1 * this.var1)) {
            this.closestEntity = null;
         }
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
   }
}
