package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
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

public class EntitySabertooth extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
   public final int AttPow = 15;
   public final int HePo = 150;

   public EntitySabertooth(World par1World) {
      super(par1World);
      float[] var10000 = new float[]{0.0F, 0.5F, 1.0F};
      this.field_70728_aV = 50;
      this.func_70105_a(2.5F, 2.4F);
      if (DBCConfig.NPC_SaberT_Dam != 15 || DBCConfig.NPC_SaberT_HP != 150) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)DBCConfig.NPC_SaberT_Dam);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)DBCConfig.NPC_SaberT_HP);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(150.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(15.0D);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/sabertooth.png";
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   protected Entity func_70782_k() {
      return super.func_70782_k();
   }

   public void func_70636_d() {
      super.func_70636_d();
   }

   protected void func_70628_a(boolean par1, int par2) {
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   public void writeSpawnData(ByteBuf additionalData) {
   }

   public void readSpawnData(ByteBuf additionalData) {
   }

   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }
}
