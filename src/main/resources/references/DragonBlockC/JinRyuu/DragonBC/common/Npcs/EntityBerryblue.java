package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBerryblue extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 10;
   public final int HePo = 100;
   private int target;

   public EntityBerryblue(World par1World) {
      super(par1World);
      this.field_70728_aV = 200;
      this.tex = "berryblue";
      this.func_70105_a(1.0F, 1.5F);
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int BP = 200000;
      int exp = this.field_70728_aV * 100;
      long BattlePower = (long)(BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, (double)((BP + "").length() - 2))));
      return BattlePower;
   }

   public void func_70636_d() {
      List var4 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
      if (!var4.isEmpty()) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            Entity var6 = (Entity)var4.get(var5);
            this.becomeAngryAt(var6);
         }
      }

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
      this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
      this.randomSoundDelay = this.field_70146_Z.nextInt(40);
   }
}
