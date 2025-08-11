package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ItemDBCModel2 extends ModelBase {
   public ModelRenderer Handle;
   public ModelRenderer Handle2;
   public ModelRenderer Handle3;
   public ModelRenderer Handle4;
   public ModelRenderer Blade;
   public ModelRenderer Blade2;
   public ModelRenderer Blade3;
   public ModelRenderer Blade4;
   public ModelRenderer Blade5;

   public ItemDBCModel2() {
      this.field_78090_t = 64;
      this.field_78089_u = 256;
      this.Handle = new ModelRenderer(this, 0, 0);
      this.Handle.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Handle.func_78790_a(-0.5F, 68.0F, -0.5F, 7, 2, 5, 0.0F);
      this.Handle2 = new ModelRenderer(this, 19, 0);
      this.Handle2.func_78793_a(1.0F, 20.0F, 0.5F);
      this.Handle2.func_78790_a(0.0F, 50.0F, 0.0F, 4, 2, 3, 0.0F);
      this.Blade = new ModelRenderer(this, 0, 17);
      this.Blade.func_78793_a(-11.0F, 1.0F, 1.0F);
      this.Blade.func_78790_a(-50.0F, -70.0F, 0.0F, 11, 11, 2, 0.0F);
      this.setRotateAngle(this.Blade, 0.0F, 0.0F, 0.7853982F);
      this.Blade4 = new ModelRenderer(this, 22, 5);
      this.Blade4.func_78793_a(2.0F, -77.0F, 1.0F);
      this.Blade4.func_78790_a(0.1F, 6.0F, 0.0F, 2, 8, 2, 0.0F);
      this.setRotateAngle(this.Blade4, 0.0F, 0.0F, 0.6265732F);
      this.Handle3 = new ModelRenderer(this, 33, 0);
      this.Handle3.func_78793_a(1.0F, -72.0F, 0.5F);
      this.Handle3.func_78790_a(0.0F, 10.0F, 0.0F, 4, 130, 3, 0.0F);
      this.Handle4 = new ModelRenderer(this, 0, 7);
      this.Handle4.func_78793_a(0.3F, -77.0F, -0.5F);
      this.Handle4.func_78790_a(0.0F, 10.0F, 0.0F, 5, 5, 5, 0.0F);
      this.Blade2 = new ModelRenderer(this, 47, 0);
      this.Blade2.func_78793_a(24.0F, 1.5F, 6.0F);
      this.Blade2.func_78790_a(-1.3F, -80.0F, -5.0F, 5, 9, 2, 0.0F);
      this.setRotateAngle(this.Blade2, 0.0F, 0.0F, -0.31869712F);
      this.Blade3 = new ModelRenderer(this, 47, 11);
      this.Blade3.func_78793_a(-20.0F, 1.5F, 6.0F);
      this.Blade3.func_78790_a(-1.7F, -80.0F, -5.0F, 5, 9, 2, 0.0F);
      this.setRotateAngle(this.Blade3, 0.0F, 0.0F, 0.31869712F);
      this.Blade5 = new ModelRenderer(this, 47, 22);
      this.Blade5.func_78793_a(2.0F, -76.0F, 1.0F);
      this.Blade5.func_78790_a(0.1F, 6.0F, 0.0F, 2, 8, 2, 0.0F);
      this.setRotateAngle(this.Blade5, 0.0F, 0.0F, -0.6265732F);
      this.Handle.func_78792_a(this.Handle2);
      this.Handle.func_78792_a(this.Blade);
      this.Handle.func_78792_a(this.Blade4);
      this.Handle.func_78792_a(this.Handle3);
      this.Handle.func_78792_a(this.Handle4);
      this.Handle.func_78792_a(this.Blade2);
      this.Handle.func_78792_a(this.Blade3);
      this.Handle.func_78792_a(this.Blade5);
   }

   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }

   public void render() {
      float par1 = 0.0625F;
      this.Handle.render(par1);
   }
}
