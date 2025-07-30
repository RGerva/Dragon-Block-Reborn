package JinRyuu.JRMCore.p;

import JinRyuu.JRMCore.mod_JRMCore;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

public abstract class Amh<T extends IMessage> implements IMessageHandler<T, IMessage> {
   @SideOnly(Side.CLIENT)
   public abstract IMessage handleClientMessage(EntityPlayer var1, T var2, MessageContext var3);

   public abstract IMessage handleServerMessage(EntityPlayer var1, T var2, MessageContext var3);

   public IMessage onMessage(T message, MessageContext ctx) {
      return ctx.side.isClient() ? this.handleClientMessage(mod_JRMCore.proxy.getPlayerEntity(ctx), message, ctx) : this.handleServerMessage(mod_JRMCore.proxy.getPlayerEntity(ctx), message, ctx);
   }
}
