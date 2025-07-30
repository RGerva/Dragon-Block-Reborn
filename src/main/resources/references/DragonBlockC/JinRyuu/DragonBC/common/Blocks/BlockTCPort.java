package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTCPort extends Block {
   public BlockTCPort() {
      super(Material.field_151573_f);
      this.func_149722_s();
      this.func_149752_b(6000000.0F);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public int func_149701_w() {
      return 0;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149678_a(int par1, boolean par2) {
      return false;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public boolean func_149747_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister par1IconRegister) {
      this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_149739_a());
   }

   public int idDropped(int par1, Random par2Random, int par3) {
      return 0;
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      if (par5Entity != null && par5Entity instanceof EntityPlayerMP && par5Entity.field_70154_o == null && par5Entity.field_70153_n == null) {
         EntityPlayerMP playerMP = (EntityPlayerMP)par5Entity;
         if (playerMP.field_71093_bK == 0 && par2 == 77 && par3 == 217 && par4 == 8) {
            short s = JRMCoreH.getShort(playerMP, "jrmcHTCTmO");
            short s1 = (short)JRMCoreH.getByte(playerMP, "jrmcMsg");
            if (s == 0) {
               playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, 23, new WorldTeleporterDBCTelep(playerMP.field_71133_b.func_71218_a(23)));
               playerMP.field_71135_a.func_147364_a(55.0D, 35.0D, 11.0D, 0.0F, 0.0F);
               playerMP.func_71023_q(1);
            } else if (s1 == 0) {
               short m = (short)(s / 120);
               String t1 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter");
               String t2 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter.sec");
               String t3 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter.min");
               String t4 = m <= 0 ? "" + s / 2 + " " + t2 : "" + m + " " + t3;
               String tf = String.format(JRMCoreH.cldr + t1, JRMCoreH.cldr + t4);
               playerMP.func_145747_a(new ChatComponentText(tf));
               JRMCoreH.setByte(1, playerMP, "jrmcMsg");
            }
         }

         if (playerMP.field_71093_bK == 23 && (par2 == 55 || par2 == 54) && par3 == 35 && par4 == 8) {
            playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, 0, new WorldTeleporterDBCTelep(playerMP.field_71133_b.func_71218_a(0)));
            playerMP.field_71135_a.func_147364_a(77.5D, 217.0D, 10.5D, 0.0F, 0.0F);
            playerMP.func_71023_q(1);
         }
      }

   }
}
