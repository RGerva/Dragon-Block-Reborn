/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityRedRibbon
/*    */   extends EntityDBCEvil {
/*    */   public String texture;
/* 14 */   public final int AttPow = 30;
/* 15 */   public final int HePo = 200;
/*    */ 
/*    */   
/*    */   public EntityRedRibbon(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.texture = "";
/* 22 */     func_70105_a(0.6F, 2.0F);
/* 23 */     this.canFly = false;
/* 24 */     this.canFireKiAttacks = false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 29 */     super.func_110147_ax();
/* 30 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/* 31 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(30.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 35 */     return "jinryuudragonbc:npcs/" + this.texture + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 38 */     int BP = 1200000;
/* 39 */     int exp = this.field_70728_aV * 100;
/* 40 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 41 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 46 */     becomeAngryAtAllPlayer();
/* 47 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 52 */     Entity var3 = par1DamageSource.func_76346_g();
/* 53 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 55 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 58 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 63 */     this.field_70789_a = par1Entity;
/* 64 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityRedRibbon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */