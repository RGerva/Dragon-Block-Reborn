package jingames.jrhc.setup.helper;

import jingames.jrhc.hairmodel.HairRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.resources.PlayerSkin.Model;
import net.minecraftforge.client.event.EntityRenderersEvent.AddLayers;

public class ClientHelper {
   public static void addPlayerLayer(AddLayers evt, String skin) {
      EntityRenderer renderer = evt.getPlayerSkin(Model.byName(skin));
      if (renderer instanceof LivingEntityRenderer) {
         Minecraft minecraft = Minecraft.getInstance();
         LivingEntityRenderer livingRenderer = (LivingEntityRenderer)renderer;
         livingRenderer.addLayer(new HairRenderer(livingRenderer));
      }

   }
}
