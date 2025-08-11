package JinRyuu.DragonBC.common.Npcs.dbtournament;

import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTien extends EntityDBCEvil {
   public String tex;
   public final int AttPow = 250;
   public final int HePo = 700;

   public EntityTien(World par1World) {
      super(par1World);
      this.field_70728_aV = 10;
      this.tex = "tien_shinhan";
      this.func_70105_a(0.6F, 2.0F);
      this.setData1(3);
      this.setData2(7);
      this.kiAttackTimer = 240;
      this.setEasyDifficulty();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(700.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(250.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = 35000000;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.rand.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      if (this.doBlst()) {
         int r = (int)(Math.random() * 2.0D);
         if (r == 0) {
            this.setData1(5);
            this.setData2(7);
         } else {
            this.setData1(3);
            this.setData2(7);
         }
      }

      this.becomeAngryAtAllPlayer();
      super.func_70636_d();
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   private void becomeAngryAt(Entity par1Entity) {
      this.field_70789_a = par1Entity;
      this.angerLevel = 400 + this.rand.nextInt(400);
   }
}
