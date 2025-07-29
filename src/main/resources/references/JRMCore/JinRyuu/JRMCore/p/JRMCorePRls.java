/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePRls implements IMessage {
/*    */   byte b;
/*    */   
/*    */   public JRMCorePRls() {}
/*    */   
/*    */   public JRMCorePRls(byte b) {
/* 16 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.b = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePRls> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePRls m, MessageContext ctx) {
/* 32 */       JRMCoreClient.phc.handleRls(m.b, p);
/*    */ 
/*    */       
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePRls m, MessageContext ctx) {
/* 40 */       JRMCore.phs.handleRls(m.b, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\.\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePRls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */