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
/*    */ public class EntityCymbal
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 80;
/* 15 */   public final int HePo = 300;
/*    */ 
/*    */   
/*    */   public EntityCymbal(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.tex = "cymbal";
/* 22 */     func_70105_a(0.90000004F, 3.0F);
/* 23 */     setData2(2);
/* 24 */     this.canFireKiAttacks = false;
/* 25 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 31 */     super.func_110147_ax();
/* 32 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
/* 33 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(80.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 37 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 40 */     int BP = 4800000;
/* 41 */     int exp = this.field_70728_aV * 100;
/* 42 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 43 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 48 */     becomeAngryAtAllPlayer();
/* 49 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 54 */     Entity var3 = par1DamageSource.func_76346_g();
/* 55 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 57 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 60 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 68 */     this.field_70789_a = par1Entity;
/* 69 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\EntityCymbal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */