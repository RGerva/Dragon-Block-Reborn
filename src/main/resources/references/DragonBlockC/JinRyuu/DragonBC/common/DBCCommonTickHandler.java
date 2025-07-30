package JinRyuu.DragonBC.common;

import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DBCCommonTickHandler {
   boolean charge = false;
   EntityPlayer player;
   protected WorldGenerator ChkInSt;
   protected WorldGenerator KiLt;
   protected WorldGenerator SnkWy;
   protected WorldGenerator TiCha;
   private int tick;

   public void onPlayerTick(EntityPlayer Player) {
   }

   public String getLabel() {
      return null;
   }

   private NBTTagCompound nbt(EntityPlayer p, String s) {
      NBTTagCompound nbt;
      if (s.contains("pres")) {
         if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
            nbt = new NBTTagCompound();
            p.getEntityData().func_74782_a("PlayerPersisted", nbt);
         } else {
            nbt = p.getEntityData().func_74775_l("PlayerPersisted");
         }
      } else {
         nbt = p.getEntityData();
      }

      return nbt;
   }

   public void onTickInGame() {
   }

   @SubscribeEvent
   public void onTick(ServerTickEvent event) {
      if (event.phase.equals(Phase.START) && !JRMCoreH.paused) {
         this.onTickInGame();
      }

   }
}
