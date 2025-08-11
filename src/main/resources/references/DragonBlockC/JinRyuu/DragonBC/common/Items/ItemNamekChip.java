package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemNamekChip extends Item {
   private Minecraft var2;
   int slot;

   public ItemNamekChip() {
      this.field_77777_bU = 2;
      this.func_77656_e(1);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister par1IconRegister) {
      this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }

   public void func_77615_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
      int var6 = this.func_77626_a(par1ItemStack) - par4;
      ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
      MinecraftForge.EVENT_BUS.post(event);
      if (!event.isCanceled()) {
         var6 = event.charge;
         if (par3EntityPlayer.func_70055_a(Material.field_151567_E)) {
            par2World.func_147443_d((int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ, 1, 1);
            if (par3EntityPlayer instanceof EntityPlayerMP) {
               EntityPlayerMP playerMP = (EntityPlayerMP)par3EntityPlayer;
               if (playerMP.field_71093_bK == 0) {
               }
            }
         }

      }
   }

   public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      return par1ItemStack;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 72000;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.isCanceled()) {
         return event.result;
      } else {
         if (par3EntityPlayer.field_71075_bZ.field_75098_d) {
            par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
         }

         return par1ItemStack;
      }
   }

   public int func_77619_b() {
      return 1;
   }
}
