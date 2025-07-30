package JinRyuu.DragonBC.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class DBCHandlerBucket {
   public static DBCHandlerBucket INSTANCE = new DBCHandlerBucket();
   public Map<Block, Item> buckets = new HashMap();

   @SubscribeEvent
   public void onBucketFill(FillBucketEvent event) {
      ItemStack result = this.fillBucket(event.world, event.target);
      if (result != null) {
         event.result = result;
         event.setResult(Result.ALLOW);
      }
   }

   private ItemStack fillBucket(World world, MovingObjectPosition pos) {
      Block block = world.func_147439_a(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d);
      Item bucket = (Item)this.buckets.get(block);
      if (bucket != null && world.func_72805_g(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d) == 0) {
         world.func_147468_f(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d);
         return new ItemStack(bucket);
      } else {
         return null;
      }
   }
}
