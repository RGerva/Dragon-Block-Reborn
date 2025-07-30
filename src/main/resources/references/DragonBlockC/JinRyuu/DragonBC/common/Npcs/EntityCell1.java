package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.World;

public class EntityCell1 extends EntityCyborgsInf {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 1500;
   public final int HePo = 15000;

   public EntityCell1(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "cell1";
      this.setData1(1);
      this.setData2(0);
      this.setMediumDifficulty();
      this.addAAiTeleport();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1500.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         int r = (int)(Math.random() * 4.0D);
         if (r == 0) {
            this.setData1(1);
            this.setData2(0);
         } else if (r == 1) {
            this.setData1(3);
            this.setData2(0);
         } else if (r == 2) {
            this.setData1(4);
            this.setData2(7);
         } else {
            this.setData1(2);
            this.setData2(7);
         }
      }

      super.func_70636_d();
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      if (par1DamageSource instanceof EntityDamageSourceIndirect || par1DamageSource instanceof EntityDamageSource) {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            this.becomeAngryAt(var3);
         }
      }

      super.func_70645_a(par1DamageSource);
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }
}
