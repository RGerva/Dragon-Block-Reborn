package jingames.jrhc.items;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class ItemBarberSnC extends Item {
   public ItemBarberSnC(int i, float f, boolean b, Properties p_41383_) {
      super(p_41383_);
   }

   public InteractionResult use(Level p_41432_, Player player, InteractionHand p_41434_) {
      ItemStack itemstack = player.getItemInHand(p_41434_);
      player.openItemGui(itemstack, p_41434_);
      player.awardStat(Stats.ITEM_USED.get(this));
      return InteractionResult.SUCCESS;
   }
}
