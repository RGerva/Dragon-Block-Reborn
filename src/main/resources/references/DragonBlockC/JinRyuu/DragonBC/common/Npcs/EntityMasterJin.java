package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMasterJin extends EntityDBCKami {
   public final int HePo = 80000;

   public EntityMasterJin(World par1World) {
      super(par1World);
      this.name = "Master Jin";
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80000.0D);
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
      boolean var3 = var2 != null;
      if (this.func_70089_S()) {
         par1EntityPlayer.openGui(mod_DragonBC.instance, 9000, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
         return true;
      } else {
         return super.func_70085_c(par1EntityPlayer);
      }
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/jin.png";
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70170_p.field_72995_K) {
         for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            if (JGConfigClientSettings.CLIENT_DA8) {
               double posXOth = super.field_70165_t;
               double posYOth = super.field_70163_u;
               double posZOth = super.field_70161_v;
               float red = 141.0F;
               float green = 158.0F;
               float blue = 210.0F;
               float red2 = 215.0F;
               float green2 = 152.0F;
               float blue2 = 219.0F;
               float out = 1.6F;
               float in = 1.5F;
               float life = 0.8F * super.field_70131_O;
               float extra_scale = 0.5F;
               int dea = true;
               double x = Math.random() * 1.600000023841858D - 0.800000011920929D;
               double y = Math.random() * (double)super.field_70131_O - 0.5D;
               double z = Math.random() * 1.600000023841858D - 0.800000011920929D;
               Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 141.0F, 158.0F, 210.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               x = Math.random() * 1.600000023841858D - 0.800000011920929D;
               y = Math.random() * (double)super.field_70131_O - 0.5D;
               z = Math.random() * 1.600000023841858D - 0.800000011920929D;
               entity.field_70170_p.func_72838_d(entity);
               Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 141.0F, 158.0F, 210.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               entity.field_70170_p.func_72838_d(entity);
               x = Math.random() * 1.5D - 0.75D;
               y = (Math.random() * (double)super.field_70131_O - 0.5D) * 0.800000011920929D;
               z = Math.random() * 1.5D - 0.75D;
               entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 152.0F, 219.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               x = Math.random() * 1.5D - 0.75D;
               y = (Math.random() * (double)super.field_70131_O - 0.5D) * 0.800000011920929D;
               z = Math.random() * 1.5D - 0.75D;
               entity.field_70170_p.func_72838_d(entity);
               entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 152.0F, 219.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               entity.field_70170_p.func_72838_d(entity);
               float in2 = 0.6F;
               x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               y = (Math.random() * (double)super.field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D;
               z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               y = (Math.random() * (double)super.field_70131_O - 0.5D) * 0.800000011920929D;
               z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
               entity.field_70170_p.func_72838_d(entity);
               Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, this);
               entity.field_70170_p.func_72838_d(entity2);
            }
         }
      }

   }
}
