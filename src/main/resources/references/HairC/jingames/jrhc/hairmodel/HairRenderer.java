package jingames.jrhc.hairmodel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jingames.jrhc.interfaces.IPlayerRenderState;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class HairRenderer extends RenderLayer<PlayerRenderState, PlayerModel> {
   private static final ResourceLocation SUIT_TEX = ResourceLocation.tryBuild("jrhc", "textures/gui/allw.png");
   private HairModel suitModel = new HairModel(HairModel.createBodyLayer().bakeRoot());
   public static PoseStack pose;

   public HairRenderer(RenderLayerParent<PlayerRenderState, PlayerModel> renderer) {
      super(renderer);
   }

   public void render(PoseStack poseStack, MultiBufferSource p_116952_, int p_116953_, PlayerRenderState p_116954_, float p_117353_, float p_117354_) {
      poseStack.pushPose();
      pose = poseStack;
      this.suitModel.copyPropertiesTo((PlayerModel)this.getParentModel());
      VertexConsumer vertexConsumer = p_116952_.getBuffer(RenderType.entityCutoutNoCull(SUIT_TEX));
      Player player = ((IPlayerRenderState)p_116954_).getPlayer();
      if (p_116954_.hasRedOverlay) {
         this.suitModel.renderToBuffer((AbstractClientPlayer)player, poseStack, vertexConsumer, p_116953_, 3, 1.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.suitModel.renderToBuffer((AbstractClientPlayer)player, poseStack, vertexConsumer, p_116953_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      }

      poseStack.popPose();
   }
}
