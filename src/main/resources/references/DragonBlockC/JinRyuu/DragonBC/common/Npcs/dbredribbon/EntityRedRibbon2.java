package JinRyuu.DragonBC.common.Npcs.dbredribbon;

import JinRyuu.DragonBC.common.Npcs.EntityDBCWildlifeA;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityRedRibbon2 extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
   public final int AttPow = 5;
   public final int HePo = 20;
   public String texture;

   public EntityRedRibbon2(World world) {
      super(world);
      this.field_70728_aV = 10;
      this.func_70105_a(0.6F, 2.0F);
      this.texture = "";
      this.canFly = false;
      this.canFireKiAttacks = false;
   }

   public void setAttributes(int damage, int health) {
      if (damage != 5 || health != 20) {
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", (double)damage);
         this.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", (double)health);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.texture + ".png";
   }

   public boolean func_70601_bi() {
      return this.world.checkNoEntityCollision(this.boundingBox) && this.world.func_72945_a(this, this.boundingBox).isEmpty() && !this.world.func_72953_d(this.boundingBox);
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

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
   }
}
