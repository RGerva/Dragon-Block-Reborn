package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemBraveSword extends ItemSword {
   private float weaponDamage;

   public ItemBraveSword(ToolMaterial tm) {
      super(tm);
      this.func_77656_e(600);
      this.func_77637_a(mod_DragonBC.DragonBlockC);
      this.weaponDamage = 1.0F;
   }

   public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister par1IconRegister) {
      this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + this.func_77658_a());
   }

   public Multimap func_111205_h() {
      Multimap multimap = super.func_111205_h();
      multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
      return multimap;
   }
}
