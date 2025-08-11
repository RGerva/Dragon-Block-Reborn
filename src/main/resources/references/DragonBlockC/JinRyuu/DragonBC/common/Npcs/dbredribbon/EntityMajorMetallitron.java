package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.entity.EntityPrjtls_1;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMajorMetallitron extends EntityRedRibbon2 {
   public final int AttPow = 50;
   public final int HePo = 200;
   private byte damageCategory;

   public EntityMajorMetallitron(World world) {
      super(world);
      this.func_70105_a(1.2F, 5.0F);
      this.texture = "major_metallitron";
      this.setAttributes(DBCConfig.RRMajorDAM, DBCConfig.RRMajorHP, 50, 200);
      this.damageCategory = 0;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/major_metallitron" + (this.damageCategory > 0 ? this.damageCategory + 1 : "") + ".png";
   }

   public void writeSpawnData(ByteBuf additionalData) {
      additionalData.writeByte(this.damageCategory);
   }

   public void readSpawnData(ByteBuf additionalData) {
      this.damageCategory = additionalData.readByte();
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74774_a("damageCategory", this.damageCategory);
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      this.damageCategory = (byte)(par1NBTTagCompound.func_74771_c("damageCategory") & 255);
   }

   public void onUpdate() {
      super.onUpdate();
      int currentHealth = (int)this.func_110143_aJ();
      int maxHealth = (int)this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
      this.damageCategory = (byte)((maxHealth - currentHealth) / (maxHealth / 3));
      if (this.damageCategory < 0) {
         this.damageCategory = 0;
      } else if (this.damageCategory > 2) {
         this.damageCategory = 2;
      }

      if (!this.world.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d(this) < 25.0F && (this.ticksExisted + 200) % 400 < 30) {
         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.world, this, this.field_70789_a, 1.8F, 1.0F, 6);
         this.world.func_72956_a(this, "jinryuudragonbc:DBC5.gun_shot_single", 0.2F, this.world.field_73012_v.nextFloat() * 0.1F + 0.9F);
         this.world.func_72838_d(var8);
      }

   }
}
