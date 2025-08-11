package JinRyuu.JRMCore.manager;

import JinRyuu.DragonBC.common.Npcs.EntityMasterBabidi;
import JinRyuu.DragonBC.common.Npcs.EntityMasterCell;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterFreeza;
import JinRyuu.DragonBC.common.Npcs.EntityMasterGohan;
import JinRyuu.DragonBC.common.Npcs.EntityMasterGoku;
import JinRyuu.DragonBC.common.Npcs.EntityMasterGuru;
import JinRyuu.DragonBC.common.Npcs.EntityMasterJin;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKami;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKarin;
import JinRyuu.DragonBC.common.Npcs.EntityMasterPiccolo;
import JinRyuu.DragonBC.common.Npcs.EntityMasterRoshi;
import JinRyuu.DragonBC.common.Npcs.EntityMasterTrunksFuture;
import JinRyuu.DragonBC.common.Npcs.EntityMasterVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityMasterWhis;
import JinRyuu.JRMCore.entity.EntitySafeZone;
import net.minecraft.entity.player.EntityPlayerMP;

public class JRMCoreManagerDBC {
   public static String[] getMasterNames() {
      String[] entityNames = new String[]{"Jin", "Babidi", "Cell", "Enma", "Freeza", "Gohan", "Goku", "Guru", "Kaio", "Kami", "Karin", "Piccolo", "Roshi", "Vegeta", "Trunks", "Whis"};
      return entityNames;
   }

   public static EntitySafeZone[] getMasters(EntityPlayerMP entityplayermp) {
      EntitySafeZone[] entities = new EntitySafeZone[]{new EntityMasterJin(entityplayermp.world), new EntityMasterBabidi(entityplayermp.world), new EntityMasterCell(entityplayermp.world), new EntityMasterEnma(entityplayermp.world), new EntityMasterFreeza(entityplayermp.world), new EntityMasterGohan(entityplayermp.world), new EntityMasterGoku(entityplayermp.world), new EntityMasterGuru(entityplayermp.world), new EntityMasterKaio(entityplayermp.world), new EntityMasterKami(entityplayermp.world), new EntityMasterKarin(entityplayermp.world), new EntityMasterPiccolo(entityplayermp.world), new EntityMasterRoshi(entityplayermp.world), new EntityMasterVegeta(entityplayermp.world), new EntityMasterTrunksFuture(entityplayermp.world), new EntityMasterWhis(entityplayermp.world)};
      return entities;
   }
}
