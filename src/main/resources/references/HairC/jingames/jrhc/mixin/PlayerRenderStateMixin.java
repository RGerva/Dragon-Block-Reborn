package jingames.jrhc.mixin;

import jingames.jrhc.interfaces.IPlayerRenderState;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(
   value = {PlayerRenderState.class},
   remap = false
)
public abstract class PlayerRenderStateMixin extends HumanoidRenderState implements IPlayerRenderState {
   public Player player;

   public Player getPlayer() {
      return this.player;
   }

   public void setPlayer(AbstractClientPlayer p_366577_) {
      this.player = p_366577_;
   }
}
