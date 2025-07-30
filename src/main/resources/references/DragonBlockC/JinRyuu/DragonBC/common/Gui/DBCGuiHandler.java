package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.Render.ArtGravDevContainer;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DBCGuiHandler implements IGuiHandler {
   public static final int ArtGravDevGui = 5;

   public Object getServerGuiElement(int id, EntityPlayer p, World world, int x, int y, int z) {
      if (id == 5) {
         TileEntity tile_entity = world.func_147438_o(x, y, z);
         return new ArtGravDevContainer(p.field_71071_by, (ArtGravDevTileEntity)tile_entity);
      } else {
         if (id == 13) {
            PD.sendTo(new DBCPspacepod1(JRMCoreH.getInt(p, "DBCSenzu")), (EntityPlayerMP)p);
         }

         return null;
      }
   }

   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      TileEntity te = world.func_147438_o(x, y, z);
      Object Gui = null;
      if (id == 0) {
         Gui = new DBCGuiSpacePod01(x, y, z);
      }

      if (id == 1) {
         Gui = new DBCKiGui(player.getEntityData().func_74762_e("DBCKiCharge"));
      }

      if (id == 2) {
         Gui = new DBCWishGui(1);
      }

      if (id == 3) {
         Gui = new DBCWishGui(2);
      }

      if (id == 5) {
         Gui = new DBCGuiArtGravDev(player.field_71071_by, (ArtGravDevTileEntity)te);
      }

      if (id == 6) {
         Gui = new DBCSAAGui(1);
      }

      if (id == 7) {
         Gui = new DBCSAAGui(5);
      }

      if (id >= 10) {
         Gui = new DBCTalkGui(id, world, x, y, z);
      }

      return Gui;
   }
}
