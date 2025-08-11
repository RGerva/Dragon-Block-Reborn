package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ItemDBCModel1 extends ModelBase {
   public ModelRenderer Handle;
   public ModelRenderer Handle2;
   public ModelRenderer Handle3;
   public ModelRenderer Handle4;
   public ModelRenderer Handle5;
   public ModelRenderer Handle7;
   public ModelRenderer Blade1;
   public ModelRenderer Handle6;
   public ModelRenderer Handle8;
   public ModelRenderer Blade2;
   public ModelRenderer Blade3;

   public ItemDBCModel1() {
      this.field_78090_t = 128;
      this.field_78089_u = 128;
      this.Handle = new ModelRenderer(this, 0, 0);
      this.Handle.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Handle.func_78790_a(0.0F, 0.0F, 0.0F, 3, 20, 3, 0.0F);
      this.Handle8 = new ModelRenderer(this, 112, 6);
      this.Handle8.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Handle8.func_78790_a(-2.0F, -2.5F, 0.0F, 3, 6, 4, 0.0F);
      this.setRotateAngle(this.Handle8, 0.0F, 0.0F, -0.40578905F);
      this.Handle4 = new ModelRenderer(this, 32, 0);
      this.Handle4.func_78793_a(1.5F, -8.0F, -0.5F);
      this.Handle4.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
      this.setRotateAngle(this.Handle4, 0.0F, 0.0F, 0.7853982F);
      this.Handle7 = new ModelRenderer(this, 66, 0);
      this.Handle7.func_78793_a(9.5F, -4.0F, 3.5F);
      this.Handle7.func_78790_a(0.0F, 0.0F, 0.0F, 6, 3, 4, 0.0F);
      this.setRotateAngle(this.Handle7, 0.0F, -3.1415927F, 0.0F);
      this.Blade3 = new ModelRenderer(this, 54, 7);
      this.Blade3.func_78793_a(-11.1F, 0.8F, 0.0F);
      this.Blade3.func_78790_a(-50.0F, -70.0F, 0.0F, 6, 6, 2, 0.0F);
      this.setRotateAngle(this.Blade3, 0.0F, 0.0F, 0.7853982F);
      this.Handle3 = new ModelRenderer(this, 16, 0);
      this.Handle3.func_78793_a(-0.5F, -6.0F, -0.5F);
      this.Handle3.func_78790_a(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
      this.Handle2 = new ModelRenderer(this, 12, 0);
      this.Handle2.func_78793_a(0.5F, 20.0F, 0.5F);
      this.Handle2.func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
      this.Blade2 = new ModelRenderer(this, 32, 7);
      this.Blade2.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Blade2.func_78790_a(-1.5F, -80.0F, 0.0F, 9, 80, 2, 0.0F);
      this.Blade1 = new ModelRenderer(this, 86, 0);
      this.Blade1.func_78793_a(-1.5F, -11.0F, 0.5F);
      this.Blade1.func_78790_a(0.0F, 0.0F, 0.0F, 6, 7, 2, 0.0F);
      this.Handle5 = new ModelRenderer(this, 46, 0);
      this.Handle5.func_78793_a(-6.5F, -4.0F, -0.5F);
      this.Handle5.func_78790_a(0.0F, 0.0F, 0.0F, 6, 3, 4, 0.0F);
      this.Handle6 = new ModelRenderer(this, 102, 0);
      this.Handle6.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Handle6.func_78790_a(-2.0F, -2.5F, 0.0F, 3, 6, 4, 0.0F);
      this.setRotateAngle(this.Handle6, 0.0F, 0.0F, -0.40578905F);
      this.Handle7.func_78792_a(this.Handle8);
      this.Handle.func_78792_a(this.Handle4);
      this.Handle.func_78792_a(this.Handle7);
      this.Blade1.func_78792_a(this.Blade3);
      this.Handle.func_78792_a(this.Handle3);
      this.Handle.func_78792_a(this.Handle2);
      this.Blade1.func_78792_a(this.Blade2);
      this.Handle.func_78792_a(this.Blade1);
      this.Handle.func_78792_a(this.Handle5);
      this.Handle5.func_78792_a(this.Handle6);
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
