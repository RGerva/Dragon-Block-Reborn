package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ItemKatanaModel extends ModelBase {
   ModelRenderer sw;
   ModelRenderer grip;
   ModelRenderer pummel;
   ModelRenderer guard;
   ModelRenderer edge;
   ModelRenderer kat;
   ModelRenderer kgrip;
   ModelRenderer kguard;
   ModelRenderer kedge;

   public ItemKatanaModel() {
      this(0.0F);
   }

   public ItemKatanaModel(float par1) {
      this(par1, 0.0F, 64, 32);
   }

   public ItemKatanaModel(float par1, float par2, int par3, int par4) {
      this.field_78090_t = par3;
      this.field_78089_u = par4;
      this.sw = new ModelRenderer(this, 0, 0);
      this.sw.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
      this.sw.func_78793_a(0.0F, 0.0F + par2, 0.0F);
      this.grip = new ModelRenderer(this, 0, 0);
      this.grip.func_78789_a(0.0F, 13.96667F, 0.0F, 1, 7, 1);
      this.grip.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.grip, 0.0F, 0.0F, 0.0F);
      this.guard = new ModelRenderer(this, 0, 26);
      this.guard.func_78789_a(-2.0F, 9.9F, -10.0F, 5, 1, 1);
      this.guard.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.guard, 0.7853982F, 0.0F, 0.0F);
      this.edge = new ModelRenderer(this, 4, 0);
      this.edge.func_78789_a(-1.0F, -10.1F, 0.5F, 3, 24, 0);
      this.edge.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.edge, 0.0F, 0.0F, 0.0F);
      this.pummel = new ModelRenderer(this, 0, 28);
      this.pummel.func_78789_a(-0.5F, 20.1F, -0.5F, 2, 2, 2);
      this.pummel.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.pummel, 0.0F, 0.0F, 0.0F);
      this.sw.func_78792_a(this.grip);
      this.sw.func_78792_a(this.pummel);
      this.sw.func_78792_a(this.guard);
      this.sw.func_78792_a(this.edge);
      this.kat = new ModelRenderer(this, 0, 0);
      this.kat.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
      this.kat.func_78793_a(0.0F, 0.0F + par2, 0.0F);
      this.kgrip = new ModelRenderer(this, 0, 0);
      this.kgrip.func_78789_a(0.0F, 13.96667F, 0.0F, 1, 7, 1);
      this.kgrip.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kgrip, 0.0F, 0.0F, 0.0F);
      this.kguard = new ModelRenderer(this, 0, 29);
      this.kguard.func_78789_a(-1.0F, 13.9F, -1.0F, 3, 0, 3);
      this.kguard.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kguard, 0.0F, 0.0F, 0.0F);
      this.kedge = new ModelRenderer(this, 4, 0);
      this.kedge.func_78789_a(-1.0F, -10.1F, 0.5F, 3, 24, 0);
      this.kedge.func_78793_a(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kedge, 0.0F, 0.0F, 0.0F);
      this.kat.func_78792_a(this.kgrip);
      this.kat.func_78792_a(this.kguard);
      this.kat.func_78792_a(this.kedge);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.field_78795_f = x;
      model.field_78796_g = y;
      model.field_78808_h = z;
   }

   public void render(String s) {
      float par1 = 0.0625F;
      if (s.contains("S") || s.contains("Z")) {
         this.sw.func_78785_a(par1);
      }

      if (s.contains("K")) {
         this.kat.func_78785_a(par1);
      }

   }
}
