package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.mod_JRMCore;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityJRMCexpl extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 1;
   public float explsiz;
   public byte type;
   int Age;
   int MaxAge = 40;

   public EntityJRMCexpl(World par1World, byte type) {
      super(par1World);
      this.type = type;
   }

   public void onUpdate() {
      if (this.world.field_72995_K && JGConfigClientSettings.CLIENT_GR4) {
         for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            float h1;
            double y;
            double z;
            float moty;
            float motz;
            EntityJRMCexpl pl;
            float h1;
            float scale;
            float motx;
            if (this.type == 10) {
               if (this.ticksExisted % 2 == 0 && this.ticksExisted < 10) {
                  pl = this;
                  h1 = this.explsiz;

                  for(int i = 0; i < (int)h1 + 5; ++i) {
                     h1 = 1.0F;
                     scale = 1.0F;
                     float scale = 1.0F + h1;
                     scale *= 0.01F;
                     y = 0.0D;
                     z = 0.0D;
                     double z = 0.0D;
                     motx = 0.3F;
                     moty = ((float)(Math.random() * (double)motx) - motx / 2.0F) * (h1 / 5.0F);
                     motz = (float)(Math.random() * (double)motx / 2.0D) * (h1 / 5.0F);
                     float motz = ((float)(Math.random() * (double)motx) - motx / 2.0F) * (h1 / 5.0F);
                     moty *= 0.1F;
                     motz *= 0.8F;
                     motz *= 0.1F;
                     y = (double)((float)(Math.random() * (double)h1) - h1 / 2.0F);
                     z = (double)((float)(Math.random() * (double)h1) - h1 / 2.0F);
                     z = (double)((float)(Math.random() * (double)h1) - h1 / 2.0F);
                     Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.4F, 0.4F, pl.posX, pl.posY, pl.posZ, y, z, z, (double)moty, (double)motz, (double)motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 0.9647059F, 0.38431373F, 0.98039216F, -0.01F, -0.001F, -0.001F, 0.8392157F, 0.32941177F, 0.9137255F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                     ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                     this.world.func_72838_d(entity7);
                  }
               }
            } else if (this.ticksExisted != 1 || this.type != 3 && this.type != 4) {
               float a;
               int j;
               if (this.ticksExisted == 1) {
                  if (this.type != 5) {
                     if (this.type != 0) {
                        if (JGConfigClientSettings.CLIENT_DA6) {
                           if (this.type != 3 && this.type != 4) {
                              float a = 1.0F;
                              h1 = 1.0F;
                              a = 1.0F + this.explsiz;
                              a *= 1.2F;
                              Entity pl = this;
                              double x = 0.0D;
                              y = 0.0D;
                              z = 0.0D;
                              Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.4F, 0.4F, super.posX, super.posY, super.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 2.0D) + 12, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 30, 1, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * a, ((float)(Math.random() * 0.03999999910593033D) + 0.09F) * a, ((float)(Math.random() * 0.003000000026077032D) + 0.005F) * a, 0, 116.0F, 187.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                              ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                              this.world.func_72838_d(entity7);
                              a *= 0.65F;
                              int num = (int)(Math.random() * 4.0D) + 1;

                              for(int i = 0; i < num; ++i) {
                                 Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.4F, 0.4F, pl.posX, pl.posY, pl.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 2.0D) + 6, 4, 4, 64, true, (float)(Math.random() * 0.20000000298023224D) + 0.2F, false, 0.0F, 1, "", 15, 1, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * a, ((float)(Math.random() * 0.03999999910593033D) + 0.09F) * a, ((float)(Math.random() * 0.003000000026077032D) + 0.005F) * a, 0, 116.0F, 187.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                                 ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                                 this.world.func_72838_d(entity7);
                              }
                           }
                        } else {
                           int i;
                           if (this.type == 5) {
                              for(i = 0; i < 5; ++i) {
                                 if (this.ticksExisted % 2 == 0) {
                                    this.func_exa();
                                    this.func_ex3();
                                 }
                              }
                           }

                           for(i = 0; i < 5; ++i) {
                              if (this.type == 1) {
                                 if (this.explsiz > 0.5F) {
                                    this.func_exa();
                                 }
                              } else if (this.type == 2) {
                                 for(j = 0; j < 2; ++j) {
                                    this.func_ex3();
                                 }
                              }
                           }
                        }
                     }
                  } else if (this.ticksExisted < 15 && this.ticksExisted % 2 == 0) {
                     this.func_exa();
                  }
               }

               if (this.type == 5) {
                  if (this.ticksExisted < 15 && this.ticksExisted % 2 == 0) {
                     this.func_exa();
                  }
               } else {
                  if (JGConfigClientSettings.CLIENT_DA6) {
                     if (this.type != 3 && this.type != 4 && this.type != 0 && this.ticksExisted < 10) {
                        pl = this;

                        double x;
                        double y;
                        double z;
                        EntityCusPar entity7;
                        float size1;
                        for(j = 0; j < (int)this.explsiz + 5; ++j) {
                           a = 1.0F;
                           h1 = 1.0F;
                           scale = 1.0F + this.explsiz;
                           scale *= 0.4F;
                           x = 0.0D;
                           y = 0.0D;
                           z = 0.0D;
                           size1 = 0.5F;
                           motx = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           moty = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           motz = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.4F, 0.4F, pl.posX, pl.posY, pl.posZ, x, y, z, (double)motx, (double)moty, (double)motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 116.0F, 187.0F, 255.0F, -0.02F, -0.02F, -0.03F, 56.0F, 67.0F, 100.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                           ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                           this.world.func_72838_d(entity7);
                        }

                        for(j = 0; j < (int)this.explsiz + 5; ++j) {
                           a = 1.0F;
                           h1 = 1.0F;
                           scale = 1.0F + this.explsiz;
                           scale *= 0.25F;
                           x = 0.0D;
                           y = 0.0D;
                           z = 0.0D;
                           size1 = 0.3F;
                           motx = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           moty = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           motz = ((float)(Math.random() * (double)size1) - size1 / 2.0F) * (this.explsiz / 5.0F);
                           entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.4F, 0.4F, pl.posX, pl.posY, pl.posZ, x, y, z, (double)motx, (double)moty, (double)motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 1.0F, 1.0F, 1.0F, -0.01F, -0.005F, -0.005F, 216.0F, 244.0F, 245.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, (Entity)null);
                           ((EntityCusPar)entity7).setdata39((float)((int)(Math.random() * 360.0D)));
                           this.world.func_72838_d(entity7);
                        }
                     }
                  } else if (this.type == 1 && this.explsiz > 0.5F && (float)this.MaxAge * 0.8F >= (float)this.Age) {
                     this.func_exa();
                  }

                  if (this.type == 0) {
                     this.func_ex1();
                     mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART1, Math.random() * 4.0D - 2.0D, 0.0D + Math.random() * (double)(this.field_70131_O * 0.25F) + (double)(this.field_70131_O / 2.0F) - (double)(this.field_70131_O * 0.25F), Math.random() * 4.0D - 2.0D, Math.random() * 0.05D - 0.025D, Math.random() * 0.1D + 0.05D, Math.random() * 0.05D - 0.025D, 0.5F, 0.5F, 0.5F);
                  }
               }
            } else {
               if (this.type == 3) {
                  this.world.func_72838_d(new EntityEnergyAttJ4(this.world, (byte)0, this.posX, this.posY + 1.0D, this.posZ));
               }

               if (this.type == 4) {
                  this.world.func_72838_d(new EntityEnergyAttJ4(this.world, (byte)1, this.posX, this.posY + 1.0D, this.posZ));
               }
            }
         }
      }

      this.field_70169_q = this.posX;
      this.field_70167_r = this.posY;
      this.field_70166_s = this.posZ;
      if (this.Age++ >= this.MaxAge) {
         this.setDead();
      }

      this.field_70181_x += 0.0D;
      this.func_70091_d(0.0D, 0.0D, 0.0D);
      if (this.posY == this.field_70167_r) {
         this.field_70159_w *= 1.0D;
         this.field_70179_y *= 1.0D;
      }

      this.field_70159_w *= 0.0D;
      this.field_70181_x *= 0.0D;
      this.field_70179_y *= 0.0D;
      if (this.field_70122_E) {
         this.field_70159_w *= 0.0D;
         this.field_70179_y *= 0.0D;
      }

   }

   private void func_exa() {
      this.func_ex1();
      this.func_ex2();
      this.func_ex3();
   }

   private void func_ex1() {
      mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART2, Math.random() * 6.0D - 3.0D, 0.0D + (double)(this.field_70131_O / 2.0F), Math.random() * 6.0D - 3.0D, Math.random() * 0.2D - 0.1D, Math.random() * 0.2D + 0.1D, Math.random() * 0.2D - 0.1D, 1.0F, 1.0F, 1.0F);
   }

   private void func_ex2() {
      mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART3, Math.random() * 6.0D - 3.0D, 0.0D + (double)(this.field_70131_O / 2.0F), Math.random() * 6.0D - 3.0D, Math.random() * 0.1D - 0.075D, Math.random() * 0.2D + 0.1D, Math.random() * 0.15D - 0.075D, 0.5F, 0.5F, 0.5F);
   }

   private void func_ex3() {
      mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART4, Math.random() * 4.0D - 2.0D, 0.0D + (double)(this.field_70131_O / 2.0F), Math.random() * 4.0D - 2.0D, Math.random() * 1.2D - 0.6D, Math.random() * 0.2D + 0.1D, Math.random() * 1.2D - 0.6D, 0.05F, 0.01F, 0.1F);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      String textura = "";
      return textura;
   }

   public boolean getCanSpawnHere() {
      return !this.world.checkNoEntityCollision(this.boundingBox);
   }

   public void onLivingUpdate() {
   }

   protected void entityInit() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }

   @SideOnly(Side.CLIENT)
   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public double getMaxRenderDistanceSquared() {
      return 65536.0D;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }
}
