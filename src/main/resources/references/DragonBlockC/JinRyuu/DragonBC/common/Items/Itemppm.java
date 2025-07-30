package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class Itemppm extends Itemm {
   ModelRenderer sw;

   public Itemppm() {
      this(0.0F);
   }

   public Itemppm(float par1) {
      this(par1, 0.0F, 64, 32);
   }

   public Itemppm(float par1, float par2, int par3, int par4) {
      this.field_78090_t = par3;
      this.field_78089_u = par4;
      this.sw = new ModelRenderer(this, 0, 0);
      this.sw.func_78789_a(-0.5F, -10.0F, -0.5F, 1, 18, 1);
      this.sw.func_78793_a(0.0F, 0.0F, 0.0F);
      this.sw.func_78787_b(64, 32);
      this.setRotation(this.sw, 0.0F, 0.0F, 0.0F);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void render(String s) {
      float par1 = 0.0625F;
      this.sw.field_78796_g = 0.5F;
      this.sw.func_78785_a(par1);
   }
}
