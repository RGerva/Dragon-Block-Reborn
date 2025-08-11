package JinRyuu.JRMCore.p;

import JinRyuu.JRMCore.mod_JRMCore;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class OpenGuiMessage implements IMessage {
   private int id;

   public OpenGuiMessage() {
   }

   public OpenGuiMessage(int id) {
      this.id = id;
   }

   public void fromBytes(ByteBuf buffer) {
      this.id = buffer.readInt();
   }

   public void toBytes(ByteBuf buffer) {
      buffer.writeInt(this.id);
   }

   public static class Handler extends SAmh<OpenGuiMessage> {
      public IMessage handleServerMessage(EntityPlayer player, OpenGuiMessage message, MessageContext ctx) {
         player.openGui(mod_JRMCore.instance, message.id, player.world, (int)player.posX, (int)player.posY, (int)player.posZ);
         return null;
      }
   }
}
