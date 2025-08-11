// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

package com.rgerva.dbr.datagen.model.custom;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.entity.AuraState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ModelAura extends EntityModel<AuraState> {
		public static final ModelLayerLocation LAYER_LOCATION =
						new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "aura_template"), "main");

		// Mantendo seus campos
		public float inc = 1.6F;
		public float inc2 = 0.0F;
		public float[] offY = new float[]{-12.0F, -17.0F, -22.0F, -27.0F, -33.0F, -38.0F, -41.0F, -44.0F};
		public float[] offZ = new float[]{-8.0F, -5.5F, -3.0F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F};

		private final ModelPart aura;

		public ModelAura(ModelPart root) {
				super(root);
				this.aura = root.getChild("aura");
		}

		// Define a malha do modelo (64x32 como antes)
		public static LayerDefinition createBodyLayer() {
				MeshDefinition mesh = new MeshDefinition();
				PartDefinition root = mesh.getRoot();

				// No baker novo, “0” de espessura pode não renderizar. Use 1 de espessura bem fininha em Z.
				root.addOrReplaceChild(
								"aura",
								CubeListBuilder.create()
												.texOffs(0, 0)
												// Era: addBox(-10, -17, -8, 20, 20, 0)
												// Agora: z = -0.5F, depth = 1F (uma lâmina fininha)
												.addBox(-10.0F, -17.0F, -0.5F, 20.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)),
								PartPose.offset(0.0F, 20.0F, 0.0F)
				);

				return LayerDefinition.create(mesh, 64, 32);
		}

		@Override
		public void setupAnim(AuraState state) {
				// se quiser preservar comportamento anterior, você pode chamar o super
				super.setupAnim(state);

				// --- portar lógica antiga do setRotationAngles ---
				// Aqui estou assumindo que o AuraState tem algo como: age, maxAge ou ticks
				float maxAge = state.maxAge; // ou outro campo equivalente
				float age    = state.age;    // idem

				float par3 = age;
				if (age > maxAge) {
						par3 = age - maxAge;
				}

				float maxageperc = (maxAge != 0.0F) ? (100.0F / maxAge) : 0.0F;
				float curperc = par3 * maxageperc;
				par3 = curperc * 0.01F * 20.0F;

				this.aura.y = 55.0F + par3;
				this.aura.z = (par3 < 8.0F)
								? 0.4F - par3 * 0.1F
								: -0.3F + (par3 - 7.0F) * 0.053F;

				float ff = par3 * this.inc / 3.2F;
				this.aura.xRot = 0.8726646F - curperc * 0.01F;

		}

		public void renderToBuffer(PoseStack poseStack, VertexConsumer vc, int packedLight, int packedOverlay,
															 float red, float green, float blue, float alpha) {

				int a = (int)(alpha * 255) << 24;
				int r = (int)(red * 255) << 16;
				int g = (int)(green * 255) << 8;
				int b = (int)(blue * 255);

				int color = a | r | g | b;
				aura.render(poseStack, vc, packedLight, packedOverlay);
		}

}