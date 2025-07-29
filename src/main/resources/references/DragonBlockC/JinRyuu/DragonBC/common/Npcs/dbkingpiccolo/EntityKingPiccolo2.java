/*    */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityKingPiccolo2
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 330;
/* 15 */   public final int HePo = 1000;
/*    */ 
/*    */   
/*    */   public EntityKingPiccolo2(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.tex = "king_piccolo_young";
/* 22 */     func_70105_a(0.6F, 2.5F);
/* 23 */     setData2(3);
/* 24 */     this.kiAttackTimer = 240;
/* 25 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 30 */     super.func_110147_ax();
/* 31 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/* 32 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(330.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 36 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 39 */     int BP = 66000000;
/* 40 */     int exp = this.field_70728_aV * 100;
/* 41 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 42 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 47 */     becomeAngryAtAllPlayer();
/* 48 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 53 */     Entity var3 = par1DamageSource.func_76346_g();
/* 54 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 56 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 59 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 67 */     this.field_70789_a = par1Entity;
/* 68 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\EntityKingPiccolo2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */