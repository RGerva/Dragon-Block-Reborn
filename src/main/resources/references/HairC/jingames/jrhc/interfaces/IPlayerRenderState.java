package jingames.jrhc.interfaces;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;

public interface IPlayerRenderState {
   Player getPlayer();

   void setPlayer(AbstractClientPlayer var1);
}
