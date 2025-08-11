package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPorunga2 extends EntityCreature {
   public int randomSoundDelay = 0;
   public int timeBack;
   protected Entity closestEntity;
   float var1 = 8.0F;
   private int age;
   private int jumpTicks = 0;

   public EntityPorunga2(World par1World) {
      super(par1World);
      this.field_70728_aV = 0;
      this.field_70130_N = 1.0F;
      this.field_70131_O = 32.0F;
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
      return this.func_70089_S() ? true : super.func_70085_c(par1EntityPlayer);
   }

   protected void func_70619_bc() {
   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      this.field_70159_w *= 0.0D;
      this.field_70179_y *= 0.0D;
      super.onUpdate();
      ++this.age;
      if (this.age == 200) {
         mod_DragonBC.logger.info("Porunga has fulfilled a wish!");
         this.setDead();
      }

      if (this.world.field_72995_K) {
         DBCH.dragonSum(this);
      }

   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Porunga.png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   public void func_70636_d() {
      if (this.jumpTicks > 0) {
         --this.jumpTicks;
      }

      if (this.field_70716_bi > 0) {
         double d0 = this.posX + (this.field_70709_bj - this.posX) / (double)this.field_70716_bi;
         double d1 = this.posY + (this.field_70710_bk - this.posY) / (double)this.field_70716_bi;
         double d2 = this.posZ + (this.field_110152_bk - this.posZ) / (double)this.field_70716_bi;
         double d3 = MathHelper.func_76138_g(this.field_70712_bm - (double)this.rotationYaw);
         this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.field_70716_bi);
         this.rotationPitch = (float)((double)this.rotationPitch + (this.field_70705_bn - (double)this.rotationPitch) / (double)this.field_70716_bi);
         --this.field_70716_bi;
         this.func_70107_b(d0, d1, d2);
         this.func_70101_b(this.rotationYaw, this.rotationPitch);
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

      this.world.field_72984_F.func_76320_a("ai");
      if (this.func_70610_aX()) {
         this.field_70703_bu = false;
         this.field_70702_br = 0.0F;
         this.field_70701_bs = 0.0F;
         this.field_70704_bt = 0.0F;
      } else if (this.func_70613_aW()) {
         if (this.func_70650_aV()) {
            this.world.field_72984_F.func_76320_a("newAi");
            this.func_70619_bc();
            this.world.field_72984_F.func_76319_b();
         } else {
            this.world.field_72984_F.func_76320_a("oldAi");
            this.world.field_72984_F.func_76319_b();
            this.field_70759_as = this.rotationYaw;
         }
      }

      this.world.field_72984_F.func_76319_b();
      this.world.field_72984_F.func_76320_a("jump");
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

      this.world.field_72984_F.func_76319_b();
      this.world.field_72984_F.func_76320_a("travel");
      this.field_70702_br *= 0.98F;
      this.field_70701_bs *= 0.98F;
      this.field_70704_bt *= 0.9F;
      this.world.field_72984_F.func_76319_b();
      this.world.field_72984_F.func_76320_a("push");
      if (!this.world.field_72995_K) {
         this.func_85033_bc();
      }

      this.world.field_72984_F.func_76319_b();
      this.world.field_72984_F.func_76320_a("looting");
      if (!this.world.field_72995_K && this.func_98052_bS() && !this.field_70729_aU && this.world.func_82736_K().func_82766_b("mobGriefing")) {
      }

      this.world.field_72984_F.func_76319_b();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0E-6D);
      this.field_70159_w *= 1.0E-4D;
      this.field_70179_y *= 1.0E-4D;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50000.0D);
   }
}
