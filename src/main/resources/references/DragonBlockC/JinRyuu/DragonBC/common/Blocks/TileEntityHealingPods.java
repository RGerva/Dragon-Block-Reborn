package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityHealingPods extends TileEntity {
   private int timer = 100;

   public void func_145845_h() {
      if (!this.field_145850_b.field_72995_K) {
         --this.timer;
         if (this.timer <= 0) {
            float n = 1.0F;
            AxisAlignedBB aabb = this.getRenderBoundingBox();
            List list = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb);

            for(int i = 0; i < list.size(); ++i) {
               EntityPlayer player = (EntityPlayer)list.get(i);
               int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
               byte pwr = JRMCoreH.getByte(player, "jrmcPwrtyp");
               byte rce = JRMCoreH.getByte(player, "jrmcRace");
               byte cls = JRMCoreH.getByte(player, "jrmcClass");
               int maxBody = JRMCoreH.stat(player, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
               int curBody = JRMCoreH.getInt(player, "jrmcBdy");
               int maxEnergy = JRMCoreH.stat(player, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(player, pwr));
               int curEnergy = JRMCoreH.getInt(player, "jrmcEnrgy");
               int maxStam = JRMCoreH.stat(player, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
               int curStam = JRMCoreH.getInt(player, "jrmcStamina");
               float damage = 20.0F - player.func_110143_aJ();
               if ((float)curBody - damage > 0.0F) {
                  player.func_70606_j(player.func_110143_aJ() + damage);
               }

               float stam;
               if (curBody < maxBody) {
                  stam = (float)(curBody + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(stam > (float)maxBody ? (float)maxBody : stam, player, "jrmcBdy");
               }

               if (curEnergy < maxEnergy) {
                  stam = (float)(curEnergy + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(stam > (float)maxEnergy ? (float)maxEnergy : stam, player, "jrmcEnrgy");
               }

               if (curStam < maxStam) {
                  stam = (float)(curStam + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(stam > (float)maxStam ? (float)maxStam : stam, player, "jrmcStamina");
               }

               if (player.func_71024_bL().func_75121_c()) {
                  player.func_71024_bL().func_75122_a(1, 0.5F);
               }
            }

            this.timer = 100;
         }
      }

      super.func_145845_h();
   }

   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
   }

   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
   }
}
