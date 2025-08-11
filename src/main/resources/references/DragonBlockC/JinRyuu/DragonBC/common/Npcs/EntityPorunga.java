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
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPorunga extends EntityCreature {
   public int randomSoundDelay = 0;
   private int time = 0;
   public int timeBack = 0;
   private boolean granted = false;
   protected Entity closestEntity;
   private float maxDistanceForPlayer = 4.0F;
   private int lookTime;
   private Class watchedClass;
   float var1 = 8.0F;
   private int jumpTicks = 0;

   public EntityPorunga(World par1World) {
      super(par1World);
      this.field_70728_aV = 0;
      this.field_70130_N = 1.0F;
      this.field_70131_O = 32.0F;
      this.field_70714_bg.func_75776_a(0, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(0, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
   }

   protected void func_70619_bc() {
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         if (!this.world.field_72995_K) {
            if (!this.granted) {
               this.granted = true;
               JRMCoreH.setInt(3, par1EntityPlayer, "jrmcWishes");
               JRMCoreH.setInt(1, par1EntityPlayer, "jrmcDrgn");
            }
         } else if (!this.granted) {
            this.granted = true;
            par1EntityPlayer.openGui(mod_DragonBC.instance, 3, par1EntityPlayer.world, (int)this.posX, (int)this.posY, (int)this.posZ);
         }

         if (!this.world.field_72995_K) {
            EntityPorunga2 Dragon2 = new EntityPorunga2(par1EntityPlayer.world);
            Dragon2.setLocationAndAngles((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ), this.rotationYaw, 0.0F);
            Dragon2.timeBack = this.timeBack;
            this.world.func_72838_d(Dragon2);
         }

         this.setDead();
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   public void shouldExecute() {
      this.closestEntity = this.world.func_72890_a(this, (double)this.maxDistanceForPlayer);
      if (this.closestEntity != null) {
         this.watchedClass = EntityPlayer.class;
         this.func_70671_ap().func_75650_a(this.closestEntity.posX, this.closestEntity.posY + 2.0D, this.closestEntity.posZ, 10.0F, (float)this.func_70646_bf());
      }

   }

   public void onUpdate() {
      if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
      }

      ++this.time;
      if (this.time == 1) {
         mod_DragonBC.logger.info("Porunga is Summoned!");
      }

      if (this.world.field_72995_K) {
         DBCH.dragonSum(this);
      }

      float r = 30.0F;
      AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.posX - (double)r, this.posY - (double)r, this.posZ - (double)r, this.posX + (double)r, this.posY + (double)r, this.posZ + (double)r);
      List list = this.world.func_72872_a(EntityPlayer.class, aabb);
      if (list.size() == 0) {
         this.setDead();
      }

      super.onUpdate();
      this.shouldExecute();
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
      EntityPlayer var2 = this.world.func_72890_a(this, (double)this.var1);
      if (var2 != null) {
         this.closestEntity = var2;
         this.field_70700_bx = 10 + this.rand.nextInt(20);
      } else {
         this.field_70704_bt = (this.rand.nextFloat() - 0.5F) * 20.0F;
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
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50000.0D);
   }
}
