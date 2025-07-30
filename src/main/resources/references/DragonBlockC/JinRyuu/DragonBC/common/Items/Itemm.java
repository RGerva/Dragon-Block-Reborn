package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class Itemm extends ModelBase {
   public Itemm() {
      this(0.0F);
   }

   public Itemm(float par1) {
      this(par1, 0.0F, 64, 32);
   }

   public Itemm(float par1, float par2, int par3, int par4) {
      this.field_78090_t = par3;
      this.field_78089_u = par4;
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void render(String s) {
   }
}
