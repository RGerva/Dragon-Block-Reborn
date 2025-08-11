package JinRyuu.JRMCore.manager;

import JinRyuu.JRMCore.entity.EntitySafeZone;
import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaFugaku;
import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaHiashi;
import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaSarutobi;
import net.minecraft.entity.player.EntityPlayerMP;

public class JRMCoreManagerNC {
   public static String[] getMasterNames() {
      String[] entityNames = new String[]{"Fugaku", "Hiashi", "Sarutobi"};
      return entityNames;
   }

   public static EntitySafeZone[] getMasters(EntityPlayerMP entityplayermp) {
      EntitySafeZone[] entities = new EntitySafeZone[]{new EntityKonohaFugaku(entityplayermp.world), new EntityKonohaHiashi(entityplayermp.world), new EntityKonohaSarutobi(entityplayermp.world)};
      return entities;
   }
}
