package jingames.jrhc.hairmodel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Iterator;
import jingames.jrhc.gui.screens.HairSalonScreen;
import jingames.jrhc.setup.helper.ARGB;
import jingames.yearsc.setup.capabilities.PlayerStatsProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fml.ModList;

public class HairModel extends HumanoidModel<HumanoidRenderState> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.tryBuild("jrhc", "hair2"), "main");
   private static final int hTOP = 4;
   private static final int hRIGHT = 1;
   private static final int hLeft = 2;
   public int age;
   public ModelPart[] hairall = new ModelPart[228];
   public ModelPart base;

   public HairModel(ModelPart p_170821_) {
      super(p_170821_);
      this.base = p_170821_.getChild("basex");

      for(int hossz = 0; hossz < 4; ++hossz) {
         for(int face = 0; face < 56; ++face) {
            String strng = String.valueOf(hossz + face * 4);
            if (hossz != 0) {
               this.hairall[hossz + face * 4] = this.hairall[hossz - 1 + face * 4].getChild(strng);
            } else {
               this.hairall[hossz + face * 4] = this.base.getChild(strng);
            }
         }
      }

   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      CubeDeformation cube = CubeDeformation.NONE;
      meshdefinition = HumanoidModel.createMesh(cube, 0.0F);
      partdefinition = meshdefinition.getRoot();
      PartDefinition base = partdefinition.addOrReplaceChild("basex", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.ZERO);
      PartDefinition[] hairall = new PartDefinition[228];

      for(int hossz = 0; hossz < 4; ++hossz) {
         for(int face = 0; face < 56; ++face) {
            String strng = String.valueOf(hossz + face * 4);
            CubeDeformation cubeDeform = new CubeDeformation(0.0F, 0.0F, 0.0F);
            if (hossz != 0) {
               hairall[hossz + face * 4] = hairall[hossz - 1 + face * 4].addOrReplaceChild(strng, CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, hossz == 0 ? -1.0F : 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubeDeform), PartPose.offset(0.0F, 0.0F, 0.0F));
            } else {
               hairall[hossz + face * 4] = base.addOrReplaceChild(strng, CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, hossz == 0 ? -1.0F : 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubeDeform), PartPose.offset(0.0F, 0.0F, 0.0F));
            }
         }
      }

      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(AbstractClientPlayer p_116954_, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      int grayingStartAtAge = 100;
      int whiteHairAtAge = 250;
      this.age = 0;
      if (ModList.get().isLoaded("yearsc")) {
         p_116954_.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
            this.age = h.getAge();
         });
      }

      if (p_116954_.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && !p_116954_.isInvisible()) {
         p_116954_.getCapability(jingames.jrhc.setup.capabilities.PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent((h) -> {
            float redx = h.getRedColor();
            float greenx = h.getGreenColor();
            float bluex = h.getBlueColor();
            String dnsH = h.getDNSH() != null ? h.getDNSH() : HairSalonScreen.defHairPrsts[0];
            float newRed = h.getRedColor();
            float newGreen = h.getGreenColor();
            float newBlue = h.getBlueColor();
            if (this.age >= grayingStartAtAge && this.age < whiteHairAtAge) {
               newRed = (1.0F - redx) / (float)(whiteHairAtAge - grayingStartAtAge) * (float)(this.age - grayingStartAtAge) + redx;
               newGreen = (1.0F - greenx) / (float)(whiteHairAtAge - grayingStartAtAge) * (float)(this.age - grayingStartAtAge) + greenx;
               newBlue = (1.0F - bluex) / (float)(whiteHairAtAge - grayingStartAtAge) * (float)(this.age - grayingStartAtAge) + bluex;
               newRed = newRed > 1.0F ? 1.0F : newRed;
               newGreen = newGreen > 1.0F ? 1.0F : newGreen;
               newBlue = newBlue > 1.0F ? 1.0F : newBlue;
            } else if (this.age >= whiteHairAtAge) {
               newRed = 1.0F;
               newGreen = 1.0F;
               newBlue = 1.0F;
            }

            for(int hossz = 0; hossz < 4; ++hossz) {
               for(int face = 0; face < 56; ++face) {
                  if (hossz == 0) {
                     this.renderHairsV2(face, poseStack, 0.0145F, dnsH, 1.0F, 0.0F, buffer, packedLight, packedOverlay, newRed, newGreen, newBlue, alpha);
                  }
               }
            }

         });
      }

   }

   public void render(String hairdns, ModelPart modelpart, int face, PoseStack p_104307_, VertexConsumer p_104308_, int p_104309_, int p_104310_, float p_104311_, float p_104312_, float p_104313_, float p_104314_) {
      if (modelpart.visible && (!modelpart.cubes.isEmpty() || !modelpart.children.isEmpty())) {
         p_104307_.pushPose();
         p_104307_.scale(1.01F, 1.0F, 1.01F);
         p_104307_.scale(1.0F, 1.0F, 1.0F);
         p_104307_.translate(0.0F, 0.0F, 0.0F);
         modelpart.translateAndRotate(p_104307_);
         int color = ARGB.colorFromFloat(p_104314_, p_104311_, p_104312_, p_104313_);
         modelpart.compile(p_104307_.last(), p_104308_, p_104309_, p_104310_, color);
         Iterator var13 = modelpart.children.values().iterator();

         while(var13.hasNext()) {
            ModelPart modelpartx = (ModelPart)var13.next();
            float lengthY = 1.0F;
            float sizeXZ = 1.0F;
            float l = (float)HairSalonScreen.dnsHair2(hairdns, face * 14);
            float tincs1 = l < 33.0F ? l / 33.0F : 1.0F;
            float tincs2 = l > 33.0F && l < 66.0F ? (l - 33.0F) / 33.0F : (l < 33.0F ? 0.0F : 1.0F);
            float tincs3 = l > 66.0F ? (l - 66.0F) / 33.0F : (l < 66.0F ? 0.0F : 1.0F);
            if (modelpartx.equals(this.hairall[1 + face * 4])) {
               lengthY = tincs1;
               if (tincs1 < 0.15F) {
                  lengthY = 0.0F;
               }

               sizeXZ = 0.99F;
            }

            if (modelpartx.equals(this.hairall[2 + face * 4])) {
               lengthY = tincs2;
               if (tincs2 < 0.15F) {
                  lengthY = 0.0F;
               }

               sizeXZ = 0.89F;
            }

            if (modelpartx.equals(this.hairall[3 + face * 4])) {
               lengthY = tincs3;
               if (tincs3 < 0.15F) {
                  lengthY = 0.0F;
               }

               sizeXZ = 0.8F;
            }

            this.hairall[1 + face * 4].visible = l > 0.0F;
            this.hairall[2 + face * 4].visible = l > 33.0F;
            this.hairall[3 + face * 4].visible = l > 66.0F;
            p_104307_.scale(sizeXZ, lengthY, sizeXZ);
            p_104307_.scale(1.0F, 1.0F / lengthY, 1.0F);
            p_104307_.translate(0.0F, lengthY * 0.2F - 0.2F, 0.0F);
            if (!(lengthY < 0.15F)) {
               this.render(hairdns, modelpartx, face, p_104307_, p_104308_, p_104309_, p_104310_, p_104311_, p_104312_, p_104313_, p_104314_);
            }
         }

         p_104307_.popPose();
      }

   }

   public void copyPropertiesTo(HumanoidModel<HumanoidRenderState> playermodel) {
      this.head.copyFrom(playermodel.head);
      this.hat.copyFrom(playermodel.hat);
      this.body.copyFrom(playermodel.body);
      this.rightArm.copyFrom(playermodel.rightArm);
      this.leftArm.copyFrom(playermodel.leftArm);
      this.rightLeg.copyFrom(playermodel.rightLeg);
      this.leftLeg.copyFrom(playermodel.leftLeg);
   }

   public void copyPropertiesTo(PlayerModel playermodel) {
      this.head.copyFrom(playermodel.head);
      this.hat.copyFrom(playermodel.hat);
      this.body.copyFrom(playermodel.body);
      this.rightArm.copyFrom(playermodel.rightArm);
      this.leftArm.copyFrom(playermodel.leftArm);
      this.rightLeg.copyFrom(playermodel.rightLeg);
      this.leftLeg.copyFrom(playermodel.leftLeg);
   }

   private void setRotation(ModelPart model, float x, float y, float z) {
      model.xRot = x;
      model.yRot = y;
      model.zRot = z;
   }

   public void renderHairsV2(int face, PoseStack posestack, float par1, String hair, float f, float g, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      posestack.pushPose();
      int[] hairRightPosZ = new int[]{3, 2, 1, 0, 3, 2, 1, 3, 2, 3};
      int[] hairRightPosY = new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2, 3};
      int[] hairLeftPosZ = new int[]{0, 1, 2, 3, 1, 2, 3, 2, 3, 3};
      int[] hairLeftPosY = new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2, 3};
      int[] hairBackPosX = new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
      int[] hairBackPosY = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
      int[] hairTopPosX = new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
      int[] hairTopPosZ = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
      int[] hairPos = new int[]{0, 4, 14, 24, 40, 56};
      int l = HairSalonScreen.dnsHair2(hair, face * 14);
      if (l != 0) {
         int X = HairSalonScreen.dnsHair2(hair, face * 14 + 2);
         int Y = HairSalonScreen.dnsHair2(hair, face * 14 + 4);
         int Z = HairSalonScreen.dnsHair2(hair, face * 14 + 6);
         int B = HairSalonScreen.dnsHair2(hair, face * 14 + 8);
         int P = HairSalonScreen.dnsHair2(hair, face * 14 + 10);
         int T = HairSalonScreen.dnsHair2(hair, face * 14 + 12);
         X = X > 82 ? 82 : (X < 18 ? 18 : X);
         Y = Y > 82 ? 82 : (Y < 18 ? 18 : Y);
         Z = Z > 82 ? 82 : (Z < 18 ? 18 : Z);
         B = B > 82 ? 82 : (B < 18 ? 18 : B);
         P = P > 82 ? 82 : (P < 18 ? 18 : P);
         T = T > 82 ? 82 : (T < 18 ? 18 : T);
         float x = (float)(X - 50) * 0.1F;
         float y = (float)(Y - 50) * 0.1F;
         float z = (float)(Z - 50) * 0.1F;
         float b = (float)(B - 50) * 0.1F;
         float p = (float)(P - 50) * 0.1F;
         int t = (int)((float)(T - 18) * 1.62F);
         float Int = (float)t * 0.01F;
         boolean var10000;
         if (face >= hairPos[0] && face < hairPos[1]) {
            var10000 = true;
         } else {
            var10000 = false;
         }

         boolean hpTop = face >= hairPos[4] && face < hairPos[5];
         boolean hpRight = face >= hairPos[1] && face < hairPos[2];
         boolean hpLeft = face >= hairPos[2] && face < hairPos[3];
         if (face >= hairPos[3] && face < hairPos[4]) {
            var10000 = true;
         } else {
            var10000 = false;
         }

         int lng = 0;
         this.setRotation(this.hairall[lng + face * 4], x, y, z);
         this.hairall[lng + face * 4].x = -2.999F + (float)(face < 4 ? face * 2 : (face >= 14 && face < 24 ? 7 : (face >= 24 && face < 40 ? hairBackPosX[face - 4 - 10 - 10] * 2 : (face >= 40 && face < 56 ? hairTopPosX[face - 4 - 10 - 10 - 16] * 2 : -1))));
         this.hairall[lng + face * 4].z = -3.999F + (face >= 4 && face < 14 ? (float)(hairRightPosZ[face - 4] * 2 + 1) : (face >= 14 && face < 24 ? (float)(hairLeftPosZ[face - 4 - 10] * 2 + 1) : (face >= 24 && face < 40 ? 8.0F : (face >= 40 && face < 56 ? (float)(hairTopPosZ[face - 4 - 10 - 10 - 16] * 2) + 0.9F : 0.0F))));
         this.hairall[lng + face * 4].y = -7.0F + (face >= 4 && face < 14 ? (float)(hairRightPosY[face - 4] * 2) : (face >= 14 && face < 24 ? (float)(hairLeftPosY[face - 4 - 10] * 2) : (face >= 24 && face < 40 ? (float)(hairBackPosY[face - 4 - 10 - 10] * 2) : -0.5F)));
         f = 1.57F;
         this.hairall[1 + face * 4].yRot = 0.0F;
         this.hairall[1 + face * 4].xRot = -0.0F;
         this.hairall[2 + face * 4].yRot = 0.0F;
         this.hairall[2 + face * 4].xRot = 0.0F;
         this.hairall[3 + face * 4].yRot = 0.0F;
         this.hairall[3 + face * 4].xRot = 0.0F;
         if (!hpTop && !hpRight && !hpLeft) {
            this.hairall[1 + face * 4].xRot = b * 0.3F * (p > 0.5F ? 1.0F - p * 0.3F : (p < -0.5F ? 1.0F + -p * 0.1F : 1.0F));
            this.hairall[2 + face * 4].xRot = b * 0.3F;
            this.hairall[3 + face * 4].xRot = b * 0.3F * (p > 0.5F ? 1.0F + p * 0.1F : (p < -0.5F ? 1.0F - -p * 0.3F : 1.0F));
         } else {
            int min = hpLeft ? 1 : -1;
            this.hairall[1 + face * 4].zRot = (float)min * b * 0.3F * (p > 0.5F ? 1.0F - p * 0.3F : (p < -0.5F ? 1.0F + -p * 0.1F : 1.0F));
            this.hairall[2 + face * 4].zRot = (float)min * b * 0.3F;
            this.hairall[3 + face * 4].zRot = (float)min * b * 0.3F * (p > 0.5F ? 1.0F + p * 0.1F : (p < -0.5F ? 1.0F - -p * 0.3F : 1.0F));
         }

         this.hairall[1 + face * 4].x = 0.0F;
         this.hairall[1 + face * 4].z = 0.0F;
         this.hairall[1 + face * 4].y = 1.5F;
         this.hairall[2 + face * 4].x = 0.0F;
         this.hairall[2 + face * 4].z = 0.0F;
         this.hairall[2 + face * 4].y = 2.5F;
         this.hairall[3 + face * 4].x = 0.0F;
         this.hairall[3 + face * 4].z = 0.0F;
         this.hairall[3 + face * 4].y = 2.5F;
         posestack.pushPose();
         posestack.translate(this.getHead().x * par1, this.getHead().y * par1 * 4.2F, this.getHead().z * par1);
         if (this.getHead().zRot != 0.0F) {
            posestack.mulPose(Axis.ZP.rotationDegrees(this.getHead().zRot * 57.295776F));
         }

         if (this.getHead().yRot != 0.0F) {
            posestack.mulPose(Axis.YP.rotationDegrees(this.getHead().yRot * 57.295776F));
         }

         if (this.getHead().xRot != 0.0F) {
            posestack.mulPose(Axis.XP.rotationDegrees(this.getHead().xRot * 57.295776F));
         }

         this.render(hair, this.hairall[0 + face * 4], face, posestack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
         posestack.popPose();
      }

      posestack.popPose();
   }
}
