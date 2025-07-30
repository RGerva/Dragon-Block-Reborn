package JinRyuu.JRMCore.items;

import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemHeadwear extends Item {
   public String modid;
   private String armorNamePrefix;
   private String tier;

   public String getTier() {
      return this.tier;
   }

   public ItemHeadwear(String armornamePrefix, String tier, int maxDam) {
      this.armorNamePrefix = armornamePrefix;
      this.tier = tier;
      this.func_77656_e(maxDam);
      this.func_77625_d(1);
      this.modid = JRMCoreH.tjjrmc;
   }

   public String getTextureFile() {
      return this.modid + ":";
   }

   public void func_94581_a(IIconRegister iconRegister) {
      this.field_77791_bV = iconRegister.func_94245_a(this.modid + ":" + this.func_77658_a().replaceAll("item.", "").replaceAll("Scoutera", "Scouter").replaceAll("Scouterb", "Scouter"));
   }
}
