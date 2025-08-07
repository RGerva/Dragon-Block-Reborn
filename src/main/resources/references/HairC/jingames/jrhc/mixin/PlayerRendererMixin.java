package jingames.jrhc.mixin;

import jingames.jrhc.interfaces.IPlayerRenderState;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {PlayerRenderer.class},
   remap = false
)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerRenderState, PlayerModel> {
   public PlayerRendererMixin(Context p_174289_, PlayerModel p_174290_, float p_174291_) {
      super(p_174289_, p_174290_, p_174291_);
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"extractRenderState"},
      cancellable = true
   )
   public void extractRenderState(AbstractClientPlayer p_366577_, PlayerRenderState p_364437_, float p_365590_, CallbackInfo ci) {
      ((IPlayerRenderState)p_364437_).setPlayer(p_366577_);
   }
}
