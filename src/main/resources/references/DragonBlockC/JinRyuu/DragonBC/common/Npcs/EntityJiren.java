/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityJiren
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 24000;
/*  17 */   public final int HePo = 150000;
/*     */   private int target;
/*     */   
/*     */   public EntityJiren(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "jiren";
/*  24 */     func_70105_a(0.6F, 2.5F);
/*  25 */     setData1(1);
/*  26 */     setData2(8);
/*  27 */     setHardDifficulty();
/*  28 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(150000.0D);
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(24000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  40 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  43 */     int BP = -1554505728;
/*  44 */     int exp = this.field_70728_aV * 100;
/*  45 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  46 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  55 */     if (doBlst()) {
/*  56 */       int r = (int)(Math.random() * 3.0D);
/*  57 */       if (r == 0) {
/*  58 */         setData1(1);
/*  59 */         setData2(8);
/*     */       }
/*  61 */       else if (r == 1) {
/*  62 */         setData1(1);
/*  63 */         setData2(4);
/*     */       } else {
/*     */         
/*  66 */         setData1(5);
/*  67 */         setData2(4);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  92 */     Entity var3 = par1DamageSource.func_76346_g();
/*  93 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 112 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 120 */     this.field_70789_a = par1Entity;
/* 121 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 122 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\Projetos\Dragon-Block-Reborn\src\main\resources\references\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityJiren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */