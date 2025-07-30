package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class KintounBlackItem extends Item {
   public KintounBlackItem() {
      this.func_77637_a(mod_DragonBC.DragonBlockC);
      this.field_77777_bU = 1;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:dragonitems1.png";
   }

   public void func_94581_a(IIconRegister iconRegister) {
      this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }

   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
      if (par7 == 0) {
         --par5;
      }

      if (par7 == 1) {
         ++par5;
      }

      if (par7 == 2) {
         --par6;
      }

      if (par7 == 3) {
         ++par6;
      }

      if (par7 == 4) {
         --par4;
      }

      if (par7 == 5) {
         ++par4;
      }

      if (!player.func_82247_a(par4, par5, par6, par7, stack)) {
         return false;
      } else {
         if (!world.field_72995_K) {
            player.field_71071_by.func_146026_a(this);
            player.field_71071_by.field_70459_e = true;
            player.field_71071_by.field_70459_e = false;
            KintounBlackEntity KintounEntity = new KintounBlackEntity(world);
            KintounEntity.func_70012_b((double)par4, (double)(par5 + 1), (double)par6, player.field_70177_z, 0.0F);
            world.func_72838_d(KintounEntity);
         }

         return true;
      }
   }

   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
      if (!world.field_72995_K) {
         Vec3 vec = player.func_70040_Z();
         KintounBlackEntity KintounEntity = new KintounBlackEntity(world);
         KintounEntity.func_70012_b(player.field_70165_t + vec.field_72450_a * 1.5D, player.field_70163_u + 1.0D + vec.field_72448_b * 1.5D, player.field_70161_v + vec.field_72449_c * 1.5D, player.field_70177_z, 0.0F);
         world.func_72838_d(KintounEntity);
         ItemStack[] inv = player.field_71071_by.field_70462_a;
         int id = 0;
         ItemStack[] var8 = inv;
         int var9 = inv.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            ItemStack invStack = var8[var10];
            if (invStack != null && invStack.equals(stack)) {
               player.field_71071_by.field_70462_a[id] = null;
               break;
            }

            ++id;
         }
      }

      return stack;
   }
}
