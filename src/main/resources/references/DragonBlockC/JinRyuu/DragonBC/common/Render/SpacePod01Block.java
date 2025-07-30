package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SpacePod01Block extends BlockContainer {
   private Class SpacePod01TileEntity;
   int port1 = 0;

   public SpacePod01Block() {
      super(Material.field_151590_u);
      float var4 = 0.4F;
      this.func_149676_a(-0.5F, 0.0F, -0.5F, 1.5F, 2.0F, 1.5F);
      this.SpacePod01TileEntity = SpacePod01TileEntity.class;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister par1IconRegister) {
      this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_149739_a());
   }

   public int quanityDropped(Random random) {
      return 1;
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
      return null;
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) {
      if (entity.field_70154_o == null && entity.field_70153_n == null && entity instanceof EntityPlayerMP) {
         EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
         ++this.port1;
      }

   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
      TileEntity tile_entity = world.func_147438_o(x, y, z);
      if (tile_entity != null && !player.func_70093_af()) {
         player.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.SpacePod01Item, 1));
         player.openGui(mod_DragonBC.instance, 0, world, x, y, z);
         return true;
      } else {
         return false;
      }
   }

   private void dropItems(World world, int x, int y, int z) {
      Random rand = new Random();
      TileEntity tile_entity = world.func_147438_o(x, y, z);
      if (tile_entity instanceof IInventory) {
         IInventory inventory = (IInventory)tile_entity;

         for(int i = 0; i < inventory.func_70302_i_(); ++i) {
            ItemStack item = inventory.func_70301_a(i);
            if (item != null && item.field_77994_a > 0) {
               float rx = rand.nextFloat() * 0.6F + 0.1F;
               float ry = rand.nextFloat() * 0.6F + 0.1F;
               float rz = rand.nextFloat() * 0.6F + 0.1F;
               EntityItem entity_item = new EntityItem(world, (double)((float)x + rx), (double)((float)y + ry), (double)((float)z + rz), item);
               if (item.func_77942_o()) {
                  item.func_77982_d((NBTTagCompound)item.func_77978_p().func_74737_b());
               }

               float factor = 0.5F;
               entity_item.field_70159_w = rand.nextGaussian() * (double)factor;
               entity_item.field_70181_x = rand.nextGaussian() * (double)factor + 0.20000000298023224D;
               entity_item.field_70179_y = rand.nextGaussian() * (double)factor;
               world.func_72838_d(entity_item);
               item.field_77994_a = 0;
            }
         }

      }
   }

   public TileEntity func_149915_a(World world, int i) {
      return new SpacePod01TileEntity();
   }
}
