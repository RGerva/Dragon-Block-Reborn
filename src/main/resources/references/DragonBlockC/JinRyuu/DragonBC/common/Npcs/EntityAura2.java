package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.JRMCore.mod_JRMCore;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.entity.EntityCusPar;
import JinRyuu.JRMCore.entity.EntityCusPars;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAura2 extends Entity {
   public static final int NORMAL = -1;
   public static final int SSJ_GOD = 0;
   public static final int SSJ_BLUE = 1;
   public static final int SSJ_BLUE_EVO = 2;
   public static final int SSJ_ROSE = 3;
   public static final int GOLDEN = 4;
   public static final int SSJ_ROSE_SHINKA = 5;
   public static final int GOD_OF_DESTRUCTION = 6;
   public final int number_of_lightVerts;
   public long[] lightVert;
   private int lightLivingTime;
   public int rm;
   private String mot;
   private boolean rot;
   private int Age;
   private int color;
   private int colorl2;
   private int colorl3;
   private float state;
   private float state2;
   private int crel;
   private float yaw;
   private float pitch;
   private float alpha;
   private String tex;
   private String texl2;
   private String texl3;
   private int speed;
   private boolean inner;
   private int rendpass;
   private boolean bol;
   private boolean bol2;
   private boolean bol3;
   private boolean bol4;
   private boolean bol4a;
   private byte bol6;
   private boolean bol7;
   public byte kettleMode;

   public int getLightLivingTime() {
      return this.lightLivingTime;
   }

   public EntityAura2(World par1World) {
      super(par1World);
      this.number_of_lightVerts = 10;
      this.lightVert = new long[10];
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.colorl3 = -1;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.texl3 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
      this.bol = false;
      this.bol2 = false;
      this.bol3 = false;
      this.bol4 = false;
      this.bol4a = false;
      this.bol6 = -1;
      this.bol7 = false;
      this.kettleMode = 0;
   }

   public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b, float a) {
      this(par1World, dbcCharger, c, s, s2, cr, b);
      this.alpha = a;
   }

   public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b) {
      this(par1World, dbcCharger, c, s, s2, cr);
      this.rot = b;
   }

   public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr) {
      super(par1World);
      this.number_of_lightVerts = 10;
      this.lightVert = new long[10];
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.colorl3 = -1;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.texl3 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
      this.bol = false;
      this.bol2 = false;
      this.bol3 = false;
      this.bol4 = false;
      this.bol4a = false;
      this.bol6 = -1;
      this.bol7 = false;
      this.kettleMode = 0;
      this.mot = dbcCharger;
      this.color = c;
      this.state = s;
      this.state2 = s2;
      this.crel = cr;
      this.rm = this.rand.nextInt(10);
      int i = 0;

      while(true) {
         this.getClass();
         if (i >= 10) {
            this.lightLivingTime = this.rand.nextInt(4) + 0;
            if (this.mot.length() > 1) {
               Entity other = this.world.getPlayerEntityByName(this.mot);
               if (other != null) {
                  if (this.rot) {
                     this.yaw = other.rotationYaw;
                     this.pitch = other.rotationPitch;
                  }

                  this.func_70080_a(other.posX, other.posY + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F), other.posZ, other.rotationYaw, other.rotationPitch);
               }
            }

            return;
         }

         this.lightVert[i] = this.rand.nextLong();
         ++i;
      }
   }

   public boolean shouldRenderInPass(int pass) {
      return pass == this.rendpass;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean getRot() {
      return this.rot;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public int getAge() {
      return this.Age;
   }

   public float getState() {
      return this.state;
   }

   public float getState2() {
      return this.state2;
   }

   public float getCRel() {
      return (float)this.crel;
   }

   public int getCol() {
      return this.color;
   }

   public void setCol(int c) {
      this.color = c;
   }

   public int getColL2() {
      return this.colorl2;
   }

   public void setColL2(int c) {
      this.colorl2 = c;
   }

   public int getColL3() {
      return this.colorl3;
   }

   public void setColL3(int c) {
      this.colorl3 = c;
   }

   public float getAlp() {
      return this.alpha;
   }

   public void setAlp(float f) {
      this.alpha = f;
   }

   public String getTex() {
      return this.tex;
   }

   public void setTex(String s) {
      this.tex = s;
   }

   public String getTexL2() {
      return this.texl2;
   }

   public void setTexL2(String s) {
      this.texl2 = s;
   }

   public String getTexL3() {
      return this.texl3;
   }

   public void setTexL3(String s) {
      this.texl3 = s;
   }

   public int getSpd() {
      return this.speed;
   }

   public void setSpd(int s) {
      this.speed = s;
   }

   public boolean getInner() {
      return this.inner;
   }

   public void setInner(boolean s) {
      this.inner = s;
   }

   public void setRendPass(int s) {
      this.rendpass = s;
   }

   public String getmot() {
      return this.mot;
   }

   public void setBol(boolean b) {
      this.bol = b;
   }

   public void setBol2(boolean b) {
      this.bol2 = b;
   }

   public void setBol3(boolean b) {
      this.bol3 = b;
   }

   public void setBol4(boolean b) {
      this.bol4 = b;
   }

   public void setBol4a(boolean b) {
      this.bol4a = b;
   }

   public void setBol6(int b) {
      this.bol6 = (byte)b;
   }

   public void setBol7(boolean b) {
      this.bol7 = b;
   }

   public boolean getBol() {
      return this.bol;
   }

   public boolean getBol2() {
      return this.bol2;
   }

   public boolean getBol3() {
      return this.bol3;
   }

   public boolean getBol4() {
      return this.bol4;
   }

   public boolean getBol4a() {
      return this.bol4a;
   }

   public byte getBol6() {
      return this.bol6;
   }

   public boolean getBol7() {
      return this.bol7;
   }

   public void onUpdate() {
      boolean aura_type = JGConfigClientSettings.CLIENT_DA13;
      boolean aura_type2 = JGConfigClientSettings.CLIENT_DA20;
      if (this.mot.length() > 1) {
         Entity other = this.world.getPlayerEntityByName(this.mot);
         if (other != null) {
            int sneak = other.func_70093_af() ? 0 : 1;
            int k;
            double x;
            double y;
            double z;
            double x;
            double y;
            float red;
            float green;
            float blue;
            float red2;
            float green2;
            float green;
            float blue;
            float blue3;
            EntityCusPar entity2;
            if (this.kettleMode > 0) {
               for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
                  if (this.ticksExisted < 15) {
                     double posXOth = other.posX;
                     x = other.posY + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F);
                     y = other.posZ;
                     float red = 250.0F;
                     red = 250.0F;
                     green = 250.0F;
                     blue = 0.9F;
                     red2 = 0.8F * other.field_70131_O;
                     green2 = 1.2F;
                     int dea = true;
                     green = 0.9F;
                     blue = 1.0F;
                     blue3 = 1.2F;
                     green = 0.99F;
                     y = (double)(other.field_70131_O * 0.8F);
                     x = Math.random() * (double)green - (double)(green / 2.0F);
                     z = Math.random() * (double)green - (double)(green / 2.0F);
                     entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, x, y, x, y, z, Math.random() * 0.30000001192092896D - 0.15000000596046448D, 0.25D + Math.random() * 0.125D * (double)blue3, Math.random() * 0.30000001192092896D - 0.15000000596046448D, -0.02F * blue3, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, 0.05F + ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * red2 * 1.2F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * red2 * 1.2F / 2.0F, 0.3F * red2 * 1.2F, 0, red, red, green, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.1F, 0.0F, 0.4F * blue, 0.45F * blue, 0.02F * blue, false, -1, false, (Entity)null);
                     entity2.world.func_72838_d(entity2);
                  }
               }
            }

            double posXOth;
            double posYOth;
            double posZOth;
            EntityCusPar entity;
            if (this.kettleMode != 1 && aura_type) {
               for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
                  for(int i = 0; (float)i < (float)((int)other.field_70131_O) / 2.0F + 1.0F; ++i) {
                     if (this.ticksExisted < 5) {
                        Entity pl = other;
                        posXOth = other.posX;
                        posYOth = other.posY + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F);
                        posZOth = other.posZ;
                        double x;
                        double y;
                        double z;
                        float red;
                        float life;
                        float extra_scale;
                        float life;
                        if (this.bol4) {
                           if (this.bol4a) {
                              red = 87.0F;
                              green = 200.0F;
                              blue = 208.0F;
                              red2 = 203.0F;
                              green2 = 137.0F;
                              red = 234.0F;
                              green = 245.0F;
                              blue = 250.0F;
                              blue3 = 252.0F;
                           } else {
                              red = 141.0F;
                              green = 158.0F;
                              blue = 210.0F;
                              red2 = 215.0F;
                              green2 = 152.0F;
                              red = 219.0F;
                              green = 243.0F;
                              blue = 247.0F;
                              blue3 = 250.0F;
                           }

                           life = 1.6F;
                           extra_scale = 1.5F;
                           life = 0.8F * other.field_70131_O;
                           float extra_scale = 0.5F;
                           int dea = true;
                           float outNew = 1.6F;
                           float target_fullsize_one1 = 0.32F;
                           float targetsizeMin = other.field_70131_O * (8.0F / target_fullsize_one1) * 0.01F;
                           float target_fullsize_one2 = 0.32F;
                           float targetsizeMax = other.field_70131_O * (26.0F / target_fullsize_one2) * 0.01F;
                           float alpha = 0.7F;

                           int repeat2;
                           EntityCusPar entity2;
                           for(repeat2 = 0; repeat2 < 4; ++repeat2) {
                              outNew = 1.7600001F;
                              y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                              x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 150.0F, 186.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.01F * alpha, false, -1, true, pl);
                              entity2.world.func_72838_d(entity2);
                           }

                           for(repeat2 = 0; repeat2 < 4; ++repeat2) {
                              outNew = 1.7600001F;
                              y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                              x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.01F * alpha, false, -1, true, pl);
                              entity2.world.func_72838_d(entity2);
                           }

                           EntityCusPar entity2;
                           if (this.ticksExisted % 4 == 0) {
                              x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              y = Math.random() * (double)other.field_70131_O - 0.5D;
                              z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, pl);
                              entity2.world.func_72838_d(entity2);
                           }

                           EntityCusPar entity3;
                           int repeat2;
                           if (this.bol4) {
                              if (this.bol4a) {
                                 outNew = 1.8000001F;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                 z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                 entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, red, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, pl);
                                 entity2.world.func_72838_d(entity2);

                                 for(repeat2 = 0; repeat2 < 1 + (this.bol4a ? 1 : 0); ++repeat2) {
                                    y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
                                    y -= 0.30000001192092896D;
                                    outNew = 1.9499999F;
                                    x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                    z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                    entity3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, red, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, pl);
                                    entity3.world.func_72838_d(entity3);
                                 }
                              }

                              if (this.ticksExisted % (this.bol4a ? 1 : 4) == 0) {
                                 x = Math.random() * 1.5D - 0.75D;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 z = Math.random() * 1.5D - 0.75D;
                                 entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red2, green2, red, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * (this.bol4a ? 1.2F : 1.0F) * alpha, 0.45F * (this.bol4a ? 1.2F : 1.0F) * alpha, 0.015F * (this.bol4a ? 1.2F : 1.0F) * alpha, false, -1, true, pl);
                                 entity2.world.func_72838_d(entity2);
                              }
                           }

                           float in2 = 0.6F;

                           for(repeat2 = 0; repeat2 < 3; ++repeat2) {
                              outNew = 0.6F;
                              x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D - 0.30000001192092896D;
                              z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              entity3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.2F * alpha, 0.25F * alpha, 0.005F * alpha, false, -1, true, pl);
                              entity3.world.func_72838_d(entity3);

                              for(int repeat2 = 0; repeat2 < 2; ++repeat2) {
                                 y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
                                 y -= 0.30000001192092896D;
                                 outNew = 1.26F;
                                 x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                 z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                                 Entity entity1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 32, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, green, blue, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.02F * alpha, false, -1, true, pl);
                                 entity1.world.func_72838_d(entity1);
                              }
                           }

                           if (this.ticksExisted % 4 == 0) {
                              x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
                              y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                              z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
                              entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, green, blue, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, pl);
                              entity2.world.func_72838_d(entity2);
                              y = Math.random() * (double)(targetsizeMax - targetsizeMin) + (double)targetsizeMin;
                              y -= 0.30000001192092896D;
                              outNew = 1.26F;
                              x = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              z = Math.random() * (double)outNew - (double)(outNew / 2.0F);
                              entity3 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, green, blue, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, pl);
                              entity3.world.func_72838_d(entity3);
                           }
                        } else {
                           int gh;
                           if (this.bol6 == -1 && !aura_type2) {
                              red = this.alpha;
                              green = 1.0F;
                              blue = (float)(this.color >> 16 & 255) / 255.0F;
                              red2 = (float)(this.color >> 8 & 255) / 255.0F;
                              green2 = (float)(this.color & 255) / 255.0F;
                              red = green * blue;
                              green = green * red2;
                              blue = green * green2;
                              if (red > 1.0F) {
                                 red = 1.0F;
                              }

                              if (green > 1.0F) {
                                 green = 1.0F;
                              }

                              if (blue > 1.0F) {
                                 blue = 1.0F;
                              }

                              for(gh = 0; gh < 3; ++gh) {
                                 life = 0.8F * pl.field_70131_O;
                                 extra_scale = 1.0F + (pl.field_70131_O > 2.1F ? pl.field_70131_O / 2.0F : 0.0F) / 5.0F;
                                 life = pl.field_70130_N * 3.0F;
                                 x = (Math.random() * 1.0D - 0.5D) * (double)(life * 1.3F);
                                 y = Math.random() * (double)(other.field_70131_O * 1.4F) - (double)(other.field_70131_O / 2.0F) - 0.30000001192092896D;
                                 z = (Math.random() * 1.0D - 0.5D) * (double)(life * 1.3F);
                                 double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
                                 double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (double)(life * extra_scale) * 0.07D;
                                 double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
                                 Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", pl.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, pl);
                                 pl.world.func_72838_d(entity);
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", pl.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, pl);
                                 pl.world.func_72838_d(entity);
                                 if (this.getColL3() > 0) {
                                    life *= 0.8F;
                                    life *= 0.8F;
                                    x = (Math.random() * 1.0D - 0.5D) * (double)(life * 0.8F);
                                    y = -1.0D;
                                    z = (Math.random() * 1.0D - 0.5D) * (double)(life * 0.8F);
                                    blue = (float)(this.colorl3 >> 16 & 255) / 255.0F;
                                    red2 = (float)(this.colorl3 >> 8 & 255) / 255.0F;
                                    green2 = (float)(this.colorl3 & 255) / 255.0F;
                                    red = green * blue;
                                    green = green * red2;
                                    blue = green * green2;
                                    if (red > 1.0F) {
                                       red = 1.0F;
                                    }

                                    if (green > 1.0F) {
                                       green = 1.0F;
                                    }

                                    if (blue > 1.0F) {
                                       blue = 1.0F;
                                    }

                                    life *= 0.95F;
                                    moty = (Math.random() * 0.10000000149011612D + 0.10000000149011612D) * (double)life * 0.57D;
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", pl.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 1.6F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, true, pl);
                                    pl.world.func_72838_d(entity);
                                    entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", pl.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 1.6F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, true, pl);
                                    pl.world.func_72838_d(entity);
                                 }
                              }
                           } else if (this.bol6 == 6) {
                              red = 1.25F;

                              for(int j = 0; j < 2; ++j) {
                                 x = Math.random() * 1.25D - 0.625D;
                                 y = Math.random() * (double)this.field_70131_O - 0.5D;
                                 z = Math.random() * 1.25D - 0.625D;
                                 entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, true, pl);
                                 entity.world.func_72838_d(entity);
                                 x = Math.random() * 1.0D - 0.5D;
                                 y = Math.random() * (double)this.field_70131_O - 0.5D;
                                 z = Math.random() * 1.0D - 0.5D;
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, true, pl);
                                 entity.world.func_72838_d(entity);
                              }
                           } else {
                              boolean dea;
                              EntityCusPar entity;
                              EntityCusPar entity2;
                              if (this.bol6 == 0) {
                                 red = 215.0F;
                                 green = 107.0F;
                                 blue = 61.0F;
                                 red2 = 218.0F;
                                 green2 = 209.0F;
                                 red = 71.0F;
                                 green = 1.6F;
                                 blue = 1.5F;
                                 blue3 = 0.8F * other.field_70131_O;
                                 life = 0.5F;
                                 dea = true;
                                 x = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                 y = Math.random() * (double)other.field_70131_O - 0.5D;
                                 z = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                 entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                 x = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                 y = Math.random() * (double)other.field_70131_O - 0.5D;
                                 z = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                 entity.world.func_72838_d(entity);
                                 entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                 entity.world.func_72838_d(entity2);
                                 x = Math.random() * 1.5D - 0.75D;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 z = Math.random() * 1.5D - 0.75D;
                                 entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                 x = Math.random() * 1.5D - 0.75D;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 z = Math.random() * 1.5D - 0.75D;
                                 entity.world.func_72838_d(entity);
                                 entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                 entity.world.func_72838_d(entity2);
                              } else if (this.bol6 == 1) {
                                 red = 48.0F;
                                 green = 208.0F;
                                 blue = 232.0F;
                                 red2 = 1.6F;
                                 green2 = 1.0F;
                                 red = 0.8F * other.field_70131_O;
                                 green = 0.5F;
                                 int dea = true;

                                 for(gh = 0; gh < 2; ++gh) {
                                    x = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                    entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * red * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * red * 0.5F, 0.2F * red * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * 1.600000023841858D - 0.800000011920929D;
                                    entity2.world.func_72838_d(entity2);
                                    Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * red * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * red * 0.5F, 0.2F * red * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity2.world.func_72838_d(entity2);
                                 }

                                 x = Math.random() * 1.0D - 0.5D;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 z = Math.random() * 1.0D - 0.5D;
                                 Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * red * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * red * 0.5F, 0.2F * red * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                 x = Math.random() * 1.0D - 0.5D;
                                 y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                 z = Math.random() * 1.0D - 0.5D;
                                 entity.world.func_72838_d(entity);
                                 entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * red * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * red * 0.5F, 0.2F * red * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                 entity.world.func_72838_d(entity2);
                              } else {
                                 EntityCusPar entity2;
                                 int gh;
                                 if (this.bol6 == 2) {
                                    red = 80.0F;
                                    green = 179.0F;
                                    blue = 215.0F;
                                    red2 = 46.0F;
                                    green2 = 46.0F;
                                    red = 211.0F;
                                    green = 1.0F;
                                    blue = 1.6F;
                                    blue3 = 0.8F * other.field_70131_O;
                                    life = 0.5F;
                                    dea = true;

                                    for(gh = 0; gh < 2; ++gh) {
                                       x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                       entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 80.0F, 179.0F, 215.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                       entity2.world.func_72838_d(entity2);
                                       entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 80.0F, 179.0F, 215.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       entity2.world.func_72838_d(entity2);
                                    }

                                    blue *= 1.4F;
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 46.0F, 46.0F, 211.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 46.0F, 46.0F, 211.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                    x = Math.random() * 1.0D - 0.5D;
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * 1.0D - 0.5D;
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * 1.0D - 0.5D;
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * 1.0D - 0.5D;
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                 } else if (this.bol6 == 3 && this.ticksExisted < 3) {
                                    red = 186.0F;
                                    green = 37.0F;
                                    blue = 197.0F;
                                    red2 = 140.0F;
                                    green2 = 8.0F;
                                    red = 62.0F;
                                    green = 1.6F;
                                    blue = 1.0F;
                                    blue3 = 0.8F * other.field_70131_O;
                                    life = 0.5F;
                                    dea = true;

                                    for(gh = 0; gh < 2; ++gh) {
                                       x = Math.random() * (double)green - (double)(green / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)green - (double)(green / 2.0F);
                                       entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       x = Math.random() * (double)green - (double)(green / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)green - (double)(green / 2.0F);
                                       entity2.world.func_72838_d(entity2);
                                       entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       entity2.world.func_72838_d(entity2);
                                    }

                                    green *= 1.4F;
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                    blue *= 1.2F;
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                 } else if (this.bol6 == 5 && this.ticksExisted < 3) {
                                    red = 191.0F;
                                    green = 5.0F;
                                    blue = 184.0F;
                                    red2 = 90.0F;
                                    green2 = 19.0F;
                                    red = 2.0F;
                                    green = 1.6F;
                                    blue = 1.0F;
                                    blue3 = 0.8F * other.field_70131_O;
                                    life = 0.5F;
                                    dea = true;

                                    for(gh = 0; gh < 2; ++gh) {
                                       x = Math.random() * (double)green - (double)(green / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)green - (double)(green / 2.0F);
                                       entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 191.0F, 5.0F, 184.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       x = Math.random() * (double)green - (double)(green / 2.0F);
                                       y = Math.random() * (double)other.field_70131_O - 0.5D;
                                       z = Math.random() * (double)green - (double)(green / 2.0F);
                                       entity2.world.func_72838_d(entity2);
                                       entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 191.0F, 5.0F, 184.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                       entity2.world.func_72838_d(entity2);
                                    }

                                    green *= 1.4F;
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 90.0F, 19.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 90.0F, 19.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 215.0F, 154.0F, 251.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 215.0F, 154.0F, 251.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                    blue *= 1.2F;
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 158.0F, 0.0F, 216.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    x = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * (double)blue - (double)(blue / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 158.0F, 0.0F, 216.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, pl);
                                    entity.world.func_72838_d(entity2);
                                 } else if (this.bol6 == 4) {
                                    red = 249.0F;
                                    green = 212.0F;
                                    blue = 33.0F;
                                    red2 = 234.0F;
                                    green2 = 134.0F;
                                    red = 34.0F;
                                    green = 1.6F;
                                    blue = 1.0F;
                                    blue3 = 0.8F * other.field_70131_O;
                                    life = 0.5F;
                                    dea = true;
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    entity.world.func_72838_d(entity2);
                                    green *= 1.3F;
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    x = Math.random() * (double)green - (double)(green / 2.0F);
                                    y = Math.random() * (double)other.field_70131_O - 0.5D;
                                    z = Math.random() * (double)green - (double)(green / 2.0F);
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    entity.world.func_72838_d(entity2);
                                    x = Math.random() * 1.0D - 0.5D;
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * 1.0D - 0.5D;
                                    entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    x = Math.random() * 1.0D - 0.5D;
                                    y = (Math.random() * (double)other.field_70131_O - 0.5D) * 0.800000011920929D;
                                    z = Math.random() * 1.0D - 0.5D;
                                    entity.world.func_72838_d(entity);
                                    entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * blue3 * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * blue3 * 0.5F, 0.2F * blue3 * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, other);
                                    entity.world.func_72838_d(entity2);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            float h1;
            float h2;
            float h4;
            float green;
            float spe;
            float spe2;
            float red;
            float spe2;
            if (JGConfigClientSettings.CLIENT_GR0) {
               for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
                  if (this.kettleMode != 1 && (this.texl2.equals("aurai2") || this.texl3.equals("auragb")) && this.bol6 != 6) {
                     float blue;
                     double z;
                     if (!this.bol4) {
                        if (this.ticksExisted % 2 == 0) {
                           h1 = this.alpha;
                           h2 = 1.0F;
                           spe2 = 1.3F;
                           h4 = (float)(this.color >> 16 & 255) / 255.0F;
                           red = (float)(this.color >> 8 & 255) / 255.0F;
                           green = (float)(this.color & 255) / 255.0F;
                           spe2 = h2 * h4 + 0.6F;
                           spe = h2 * red + 0.6F;
                           blue = h2 * green + 0.6F;
                           if (spe2 > 1.0F) {
                              spe2 = 1.0F;
                           }

                           if (spe > 1.0F) {
                              spe = 1.0F;
                           }

                           if (blue > 1.0F) {
                              blue = 1.0F;
                           }

                           posYOth = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                           posZOth = -0.30000001192092896D;
                           z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                           entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, posYOth, posZOth, z, 0.0D, 0.05D + Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 35, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, spe2, spe, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.018F, false, -1, true, other);
                           entity.world.func_72838_d(entity);
                        }
                     } else if (this.ticksExisted % 10 == 0) {
                        h1 = this.alpha;
                        h2 = 1.0F;
                        spe2 = 1.3F;
                        h4 = (float)(this.color >> 16 & 255) / 255.0F;
                        red = (float)(this.color >> 8 & 255) / 255.0F;
                        green = (float)(this.color & 255) / 255.0F;
                        spe2 = h2 * h4 + 0.6F;
                        spe = h2 * red + 0.6F;
                        blue = h2 * green + 0.6F;
                        if (spe2 > 1.0F) {
                           spe2 = 1.0F;
                        }

                        if (spe > 1.0F) {
                           spe = 1.0F;
                        }

                        if (blue > 1.0F) {
                           blue = 1.0F;
                        }

                        posYOth = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                        posZOth = -0.30000001192092896D;
                        z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                        entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, super.posX, super.posY, super.posZ, posYOth, posZOth, z, 0.0D, 0.05D + Math.random() * 0.10000000149011612D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 20, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.05F, false, -1, true, other);
                        entity.world.func_72838_d(entity);
                     }
                  }
               }
            }

            EntityCusPar entity;
            EntityCusPar entity2;
            if (this.kettleMode != 1 && JGConfigClientSettings.CLIENT_GR7) {
               for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
                  if ((this.texl2.equals("aurai2") || this.texl3.equals("auragb")) && this.bol4 && this.ticksExisted % 10 == 0) {
                     x = Math.random() * 1.0D - 0.5D;
                     y = Math.random() * (double)other.field_70131_O - 0.5D;
                     z = Math.random() * 1.0D - 0.5D;
                     Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, other.posX, other.posY, other.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.05000000074505806D), (float)(Math.random() * 0.07999999821186066D) + 0.1F, 0.1F, 2, 105.0F, 40.0F, 148.0F, 0.0F, 0.0F, 0.0F, 105.0F, 40.0F, 148.0F, 1, 0.5F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, other);
                     entity.world.func_72838_d(entity);
                     x = Math.random() * 1.0D - 0.5D;
                     y = Math.random() * (double)other.field_70131_O - 0.5D;
                     z = Math.random() * 1.0D - 0.5D;
                     posXOth = Math.random() * 0.029999999329447746D + 0.0010000000474974513D;
                     int image = (int)(Math.random() * 8.0D) + 32;
                     float sizem = (float)(Math.random() * 0.029999999329447746D);
                     float sizemm = (float)(Math.random() * 0.029999999329447746D) + 0.05F;
                     Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, other.posX, other.posY, other.posZ, x, y, z, 0.0D, posXOth, 0.0D, 0.0F, image, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, sizem, sizemm, 0.1F, 0, 80.0F, 156.0F, 186.0F, 0.0F, 0.0F, 0.0F, 80.0F, 156.0F, 186.0F, 1, 0.8F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, other);
                     entity2.world.func_72838_d(entity2);
                     entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, other.posX, other.posY, other.posZ, x, y, z, 0.0D, posXOth, 0.0D, 0.0F, image, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, sizem * 0.9F, sizemm * 0.9F, 0.1F, 1, 1.0F, 1.0F, 1.0F, -0.03F, -0.02F, -0.01F, 80.0F, 156.0F, 186.0F, 1, 0.65F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, other);
                     entity2.world.func_72838_d(entity2);
                     x = Math.random() * 1.0D - 0.5D;
                     y = Math.random() * (double)other.field_70131_O - 0.20000000298023224D;
                     z = Math.random() * 1.0D - 0.5D;
                     entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 0.2F, 0.2F, other.posX, other.posY, other.posZ, x, y, z, 0.0D, Math.random() * 0.004999999888241291D, 0.0D, 0.0F, 8, 8, 1, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.10000000149011612D), (float)(Math.random() * 0.20000000298023224D) + 0.5F, 0.1F, 2, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1, 0.4F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, other);
                     entity.world.func_72838_d(entity);
                     x = Math.random() * 1.0D - 0.5D;
                     y = Math.random() * (double)other.field_70131_O - 0.5D;
                     z = Math.random() * 1.0D - 0.5D;
                     entity2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 0.2F, 0.2F, other.posX, other.posY, other.posZ, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 189.0F, 138.0F, 227.0F, 0.0F, 0.0F, 0.0F, 189.0F, 138.0F, 227.0F, 1, 0.7F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, other);
                     entity2.world.func_72838_d(entity2);
                  }
               }
            }

            if (JGConfigClientSettings.CLIENT_GR1 || JGConfigClientSettings.CLIENT_GR8 || JGConfigClientSettings.CLIENT_GR9) {
               for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
                  int[] tavolsagok = new int[]{5, 6, 8, 10, 20};
                  int tav = 20;
                  boolean b1 = false;
                  boolean b1 = false;
                  String[] s = new String[]{"dirt", "grass", "rock", "stone"};

                  int j;
                  for(int j = 0; j < 5; ++j) {
                     if (!b1 && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains("grass")) {
                        b1 = true;
                        tav = tavolsagok[j];
                     }

                     for(j = 0; j < s.length; ++j) {
                        if (!b1 && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains(s[j])) {
                           b1 = true;
                           tav = tavolsagok[j];
                        }
                     }
                  }

                  int j;
                  boolean b1;
                  if (this.ticksExisted == 1) {
                     int spwnd = 0;
                     b1 = false;
                     b1 = false;
                     String[] s = new String[]{"dirt", "grass", "rock", "stone"};
                     j = 0;

                     while(true) {
                        if (j >= 5) {
                           EntityCusPar entity;
                           double z;
                           if (JGConfigClientSettings.CLIENT_GR8 && b1) {
                              spe2 = 10.0F;
                              if (!JGConfigClientSettings.CLIENT_GR11) {
                                 x = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 y = (double)(-0.2F - (float)spwnd);
                                 z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 1.0F, 1.0F, super.posX, super.posY, super.posZ, x, y, z, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + Math.random() * 0.20000000298023224D, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, (float)(Math.random() * 0.0010000000474974513D) - 5.0E-4F, (int)(Math.random() * 8.0D) + 16, 16, 8, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.009999999776482582D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, false, -1, false, (Entity)null);
                              } else {
                                 x = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 y = (double)(-0.2F - (float)spwnd);
                                 z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 1.0F, 1.0F, super.posX, super.posY, super.posZ, x, y, z, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + Math.random() * 0.20000000298023224D, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, (float)(Math.random() * 0.0010000000474974513D) - 5.0E-4F, (int)(Math.random() * 8.0D) + 16, 16, 8, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.009999999776482582D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, true, 0, false, (Entity)null);
                              }

                              entity.world.func_72838_d(entity);
                           }

                           if (JGConfigClientSettings.CLIENT_GR1 && b1) {
                              spe2 = 10.0F;
                              if (!JGConfigClientSettings.CLIENT_GR11) {
                                 x = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 y = (double)(-0.2F - (float)spwnd);
                                 z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 1.0F, 1.0F, super.posX, super.posY, super.posZ, x, y, z, 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + (double)((float)(Math.random() * 0.20000000298023224D)), 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.0F, (int)(Math.random() * 13.0D), 0, 13, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.019999999552965164D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, false, -1, false, (Entity)null);
                                 entity.world.func_72838_d(entity);
                              } else {
                                 x = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 y = (double)(-0.2F - (float)spwnd);
                                 z = Math.random() * (double)spe2 - (double)(spe2 / 2.0F);
                                 entity = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.world, 1.0F, 1.0F, super.posX, super.posY, super.posZ, x, y, z, 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + (double)((float)(Math.random() * 0.20000000298023224D)), 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.0F, (int)(Math.random() * 13.0D), 0, 13, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.019999999552965164D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, true, 1, false, (Entity)null);
                                 entity.world.func_72838_d(entity);
                              }
                           }
                           break;
                        }

                        if (!b1 && (this.bol2 || this.bol) && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains("grass")) {
                           b1 = true;
                           spwnd = j;
                        }

                        for(j = 0; j < s.length; ++j) {
                           if (!b1 && (this.bol2 || this.bol) && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains(s[j])) {
                              b1 = true;
                              spwnd = j;
                           }
                        }

                        ++j;
                     }
                  }

                  b1 = JGConfigClientSettings.CLIENT_GR9;
                  if (this.bol4) {
                     b1 = (int)(Math.random() * 3.0D) == 0;
                  }

                  if (b1 && this.ticksExisted % tav == 0) {
                     int spwnd = 0;
                     b1 = false;
                     boolean b2 = false;
                     String[] s = new String[]{"dirt", "grass", "rock", "stone"};

                     for(j = 0; j < 5; ++j) {
                        if (!b2 && (this.bol2 || this.bol) && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains("grass")) {
                           b2 = true;
                           spwnd = j;
                        }

                        for(int i = 0; i < s.length; ++i) {
                           if (!b1 && (this.bol3 || this.bol2 || this.bol) && this.world.func_147439_a((int)this.posX, (int)this.posY - (sneak + j), (int)this.posZ).func_149739_a().toLowerCase().contains(s[i])) {
                              b1 = true;
                              spwnd = j;
                           }
                        }
                     }

                     if (JGConfigClientSettings.CLIENT_GR9 && (b1 || b2)) {
                        spe = (5.0F - (float)spwnd) / 10.0F;
                        mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART6, 0.0D, (double)(-0.2F - (float)spwnd), 0.0D, Math.random() * (double)spe - (double)(spe / 2.0F), 0.0D, Math.random() * (double)spe - (double)(spe / 2.0F), 64);
                     }
                  }
               }
            }

            if (this.kettleMode != 1 && JGConfigClientSettings.CLIENT_DA11 && !other.field_70122_E && (other.field_70142_S != other.posX || other.field_70136_U != other.posZ)) {
               float a = this.alpha;
               h1 = 1.0F;
               if (this.bol4) {
                  red = 215.0F;
                  green = 152.0F;
                  spe2 = 219.0F;
                  a /= 2.0F;
               } else {
                  h2 = (float)(this.color >> 16 & 255) / 255.0F;
                  spe2 = (float)(this.color >> 8 & 255) / 255.0F;
                  h4 = (float)(this.color & 255) / 255.0F;
                  red = h1 * h2;
                  green = h1 * spe2;
                  spe2 = h1 * h4;
               }

               posXOth = -other.field_70159_w * 2.5D + (double)(other.field_70159_w > 0.0D ? -0.2F : 0.2F);
               posYOth = (double)(other.field_70131_O * 0.25F + (other instanceof EntityPlayerSP ? -1.6F : 0.0F)) - other.field_70181_x * 2.5D + (double)(other.field_70181_x > 0.0D ? -0.1F : 0.1F);
               posZOth = -other.field_70179_y * 2.5D + (double)(other.field_70179_y > 0.0D ? -0.2F : 0.2F);
               entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 1.0F, 1.0F, other.posX, other.posY, other.posZ, posXOth, posYOth, posZOth, 0.0D, -0.02D, 0.0D, 0.0F, 8, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 1, 0.09F, 0.001F, -0.0045F, 0, red, green, spe2, 0.0F, 0.0F, 0.0F, red, green, spe2, 1, 0.2F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, true, (Entity)null);
               entity.world.func_72838_d(entity);
               if (this.bol4) {
                  red = 141.0F;
                  green = 158.0F;
                  spe2 = 210.0F;
               } else {
                  h2 = (float)(this.colorl3 >> 16 & 255) / 255.0F;
                  spe2 = (float)(this.colorl3 >> 8 & 255) / 255.0F;
                  h4 = (float)(this.colorl3 & 255) / 255.0F;
                  red = h1 * h2;
                  green = h1 * spe2;
                  spe2 = h1 * h4;
               }

               posXOth = -other.field_70159_w * 2.5D + (double)(other.field_70159_w > 0.0D ? -0.2F : 0.2F);
               posYOth = (double)(other.field_70131_O * 0.25F + (other instanceof EntityPlayerSP ? -1.6F : 0.0F)) - other.field_70181_x * 2.5D + (double)(other.field_70181_x > 0.0D ? -0.1F : 0.1F);
               posZOth = -other.field_70179_y * 2.5D + (double)(other.field_70179_y > 0.0D ? -0.2F : 0.2F);
               entity2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.world, 1.0F, 1.0F, other.posX, other.posY, other.posZ, posXOth, posYOth, posZOth, 0.0D, -0.02D, 0.0D, 0.0F, 8, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 1, 0.06F, 0.001F, -0.003F, 0, red, green, spe2, 0.0F, 0.0F, 0.0F, red, green, spe2, 1, 0.1F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, true, (Entity)null);
               entity.world.func_72838_d(entity2);
            }

            if (this.rot) {
               this.yaw = other.rotationYaw;
               this.pitch = other.rotationPitch;
            }

            this.func_70080_a(other.posX, other.posY + (double)(other instanceof EntityPlayerSP ? -1.6F : 0.0F), other.posZ, other.rotationYaw, other.rotationPitch);
            if (this.getAge() < this.getLightLivingTime() && this.getState() > 4.0F && this.getState() < 7.0F && this.getAge() == 2) {
               other.func_85030_a("jinryuudragonbc:1610.spark", 0.0375F, 0.85F + (float)this.lightLivingTime * 0.05F);
            }
         } else {
            this.setDead();
         }
      }

      if (this.Age++ >= this.speed) {
         this.setDead();
      }

   }

   public boolean getCanSpawnHere() {
      return !this.world.checkNoEntityCollision(this.boundingBox);
   }

   public void onLivingUpdate() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }

   protected void entityInit() {
   }

   public boolean func_70112_a(double par1) {
      if (JGConfigClientSettings.renderdistanceMultiplierAuras == 10000) {
         return true;
      } else {
         double d1 = this.boundingBox.func_72320_b();
         d1 *= 64.0D * this.field_70155_l;
         return par1 < d1 * d1 * ((double)JGConfigClientSettings.renderdistanceMultiplierAuras / 100.0D);
      }
   }
}
