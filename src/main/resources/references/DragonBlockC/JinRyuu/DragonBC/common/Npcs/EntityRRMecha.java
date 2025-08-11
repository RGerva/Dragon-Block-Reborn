package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityRRMecha extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
   public final int AttPow = 20;
   public final int HePo = 200;
   private byte type;

   public int getType() {
      return this.type;
   }

   protected void func_70069_a(float f) {
   }

   public EntityRRMecha(World par1World) {
      super(par1World);
      float[] sizes = new float[]{0.0F, 0.5F, 1.0F};
      this.field_70728_aV = 50;
      this.type = (byte)((int)(Math.random() * 3.0D));
      this.func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
      int dam = this.type == 0 ? DBCConfig.NPC_RRMech1_Dam : (this.type == 1 ? DBCConfig.NPC_RRMech2_Dam : DBCConfig.NPC_RRMech3_Dam);
      int hp = this.type == 0 ? DBCConfig.NPC_RRMech1_HP : (this.type == 1 ? DBCConfig.NPC_RRMech2_HP : DBCConfig.NPC_RRMech3_HP);
      if (dam != 20 || hp != 200) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)dam);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)hp);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20.0D);
   }

   public void onUpdate() {
      super.onUpdate();
      float range = (float)(25 * (this.type + 1));
      if (!this.world.field_72995_K && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < range) {
         EntityPrjtls_1 var8;
         if (this.type == 0) {
            if (this.ticksExisted % 100 < 31 && this.ticksExisted % 15 == 0) {
               var8 = new EntityPrjtls_1(this.world, this, this.field_70789_a, 1.8F, 1.0F, 0);
               this.world.func_72956_a(this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
               this.world.func_72838_d(var8);
            }
         } else if (this.type == 1) {
            if (this.ticksExisted % 100 == 0 && (int)(Math.random() * (double)(6 / (this.type + 1))) == 0) {
               var8 = new EntityPrjtls_1(this.world, this, this.field_70789_a, 1.5F, 1.0F, 1);
               this.world.func_72956_a(this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
               this.world.func_72838_d(var8);
            }
         } else if (this.type == 2 && this.ticksExisted % 100 == 0 && (int)(Math.random() * 2.0D) == 0) {
            var8 = new EntityPrjtls_1(this.world, this, this.field_70789_a, 1.8F, 1.0F, 2);
            this.world.func_72956_a(this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
            this.world.func_72838_d(var8);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/rrmecha" + this.type + ".png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
   }

   protected Entity func_70782_k() {
      return super.func_70782_k();
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
      float[] chance;
      int drop_chance;
      if (this.type == 2) {
         chance = new float[]{12.0F, 5.0F, 3.0F};
         drop_chance = (int)(Math.random() * 101.0D);
         if ((float)drop_chance <= chance[2]) {
            this.func_145779_a(ItemsDBC.ItemChipTier3, 1);
         } else if ((float)drop_chance <= chance[1]) {
            this.func_145779_a(ItemsDBC.ItemChipTier2, 1);
         } else if ((float)drop_chance <= chance[0]) {
            this.func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1);
         }
      } else if (this.type == 1) {
         chance = new float[]{8.0F, 4.0F};
         drop_chance = (int)(Math.random() * 101.0D);
         if ((float)drop_chance <= chance[1]) {
            this.func_145779_a(ItemsDBC.ItemChipTier2, 1);
         } else if ((float)drop_chance <= chance[0]) {
            this.func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1);
         }
      } else if (this.type == 0) {
         chance = new float[]{7.0F};
         drop_chance = (int)(Math.random() * 101.0D);
         if ((float)drop_chance <= chance[0]) {
            this.func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1);
         }
      }

   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   public void writeSpawnData(ByteBuf additionalData) {
      additionalData.writeByte(this.type);
   }

   public void readSpawnData(ByteBuf additionalData) {
      this.type = additionalData.readByte();
      float[] sizes = new float[]{0.0F, 0.5F, 1.0F};
      this.func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74774_a("type", this.type);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      this.type = (byte)(par1NBTTagCompound.func_74771_c("type") & 255);
      float[] sizes = new float[]{0.0F, 0.5F, 1.0F};
      this.func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
   }
}
