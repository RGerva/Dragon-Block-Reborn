/*    */ package JinRyuu.JRMCore.p.DBC;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBC;
/*    */ import JinRyuu.DragonBC.common.DBCClient;
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class DBCPtick
/*    */   implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPtick(int i) {
/* 16 */     this.i = i;
/*    */   }
/*    */   public DBCPtick() {}
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeInt(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.i = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPtick>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPtick m, MessageContext ctx) {
/* 33 */       DBCClient.phc.handleDBCtick(m.i, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPtick m, MessageContext ctx) {
/* 41 */       DBC.phs.handleDBCtick(m.i, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\.\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPtick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */