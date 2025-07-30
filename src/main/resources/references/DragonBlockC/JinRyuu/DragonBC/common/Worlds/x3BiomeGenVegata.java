package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import java.awt.Color;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class x3BiomeGenVegata extends BiomeGenBaseDBC {
   BiomeDecoratorDBC customBiomeDecorator;
   final float HUE = Color.RGBtoHSB(255, 102, 102, (float[])null)[0];

   public x3BiomeGenVegata(int par1) {
      super(par1);
      this.func_76735_a("Vegeta");
      this.field_76752_A = BlocksDBC.BlockNamekDirt;
      this.field_76753_B = BlocksDBC.BlockAlienStone;
      this.field_76760_I = new BiomeDecoratorDBC();
      this.customBiomeDecorator = (BiomeDecoratorDBC)this.field_76760_I;
      this.func_76739_b(8368696);
      this.setMinMaxHeight(0.0F, 0.7F);
      this.func_76732_a(0.8F, 0.9F);
      this.field_76750_F = 0.5F;
      this.field_76759_H = 16711680;
      this.field_76761_J.clear();
      this.field_76762_K.clear();
      this.field_76755_L.clear();
      if (DBCConfig.spwnrt_syn > 0) {
         this.field_76761_J.add(new SpawnListEntry(EntitySaiyan01.class, DBCConfig.spwnrt_syn, 1, 3));
      }

      if (DBCConfig.spwnrt_syn2 > 0) {
         this.field_76761_J.add(new SpawnListEntry(EntitySaiyan02.class, DBCConfig.spwnrt_syn2, 1, 3));
      }

   }

   public BiomeGenBase func_76732_a(float par1, float par2) {
      if (par1 > 0.1F && par1 < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.field_76750_F = par1;
         this.field_76751_G = par2;
         return this;
      }
   }

   public BiomeGenBase setMinMaxHeight(float par1, float par2) {
      this.field_76748_D = par1;
      this.field_76749_E = par2;
      return this;
   }

   public final int getIntTemperature2() {
      return (int)(this.field_76750_F * 65536.0F);
   }

   public final float getFloatTemperature2() {
      return this.field_76750_F;
   }

   public BiomeGenBase func_76739_b(int par1) {
      this.field_76790_z = Color.getHSBColor(0.42F - (float)par1 * 0.05F, 0.5F + (float)par1 * 0.1F, 1.0F).getRGB();
      return this;
   }

   public int func_76731_a(float par1) {
      par1 /= 3.0F;
      if (par1 < -1.0F) {
         par1 = -1.0F;
      }

      if (par1 > 1.0F) {
         par1 = 1.0F;
      }

      return Color.getHSBColor(this.HUE, 0.5F + par1 * 0.1F, 1.0F).getRGB();
   }

   public int getBiomeFoliageColor() {
      double var1 = (double)MathHelper.func_76131_a(this.getFloatTemperature2(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
      return ColorizerFoliage.func_77470_a(var1, var3);
   }
}
