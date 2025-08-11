package JinRyuu.JRMCore.entity;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import java.util.ArrayList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEng extends Entity {
   private String mot;
   private int type;
   private int color;
   private int color2;
   private float size;
   private byte partid;
   public boolean destroyer = false;
   public float minScale;
   public float maxScale;
   public float maxDamage;
   public boolean added = false;
   public int animation_speed = 0;
   public long animation_start = 0L;
   public int animation_id = 0;
   public int animation_id_Max = 0;
   public int animation_random_Max = 0;
   public ArrayList<Integer> animation_random = new ArrayList();
   public float render_scale = 0.0F;
   public float render_scale_max = 2.0F;
   public EntityPlayer user;

   public String getmot() {
      return this.mot;
   }

   public int getType() {
      return this.type - 1;
   }

   public int getColor() {
      return this.color;
   }

   public int getColor2() {
      return this.color2;
   }

   public float getSize() {
      return this.size;
   }

   public byte getPartid() {
      return this.partid;
   }

   public void setScales() {
      this.minScale = (float)JRMCoreConfig.KiSizeMin[this.getType()];
      this.maxScale = (float)JRMCoreConfig.KiSizeMax[this.getType()];
      this.maxDamage = JRMCoreH.getMaxEnergyDamage();
   }

   public float setScalesPost() {
      if (this.isWave()) {
         return 100.0F;
      } else if (this.isBlast()) {
         return 5.0F;
      } else if (this.isDisk()) {
         return 5.0F;
      } else if (this.isLaser()) {
         return 5.0F;
      } else if (this.isLargeBlast()) {
         return 10000.0F;
      } else if (this.isSpiral()) {
         return 5.0F;
      } else if (this.isBarrage()) {
         return 5.0F;
      } else if (this.isShield()) {
         return 5.0F;
      } else {
         return this.isExplosion() ? 20.0F : 1.0F;
      }
   }

   public EntityEng(World w, double poX, double poY, double poZ, String mot, int type, int color, float size, int partid) {
      super(w);
      this.func_70105_a(2.0F, 5.0F);
      this.posX = poX;
      this.posY = poY;
      this.posZ = poZ;
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.type = type;
      this.color = color;
      this.color2 = -1;
      if (!this.isShield() && !this.isExplosion()) {
         this.setScales();
         this.size = 0.5F + size;
         if (JRMCoreConfig.eaesl > 0 && size > (float)JRMCoreConfig.eaesl) {
            this.size = (float)JRMCoreConfig.eaesl;
         }

         if (this.isLargeBlast()) {
            this.size *= JRMCoreConfig.ealbm;
         }
      }

      this.partid = (byte)partid;
      this.mot = mot;
      this.func_70107_b(this.posX, this.posY, this.posZ);
      this.moveToUser();
      if (JRMCoreConfig.KiAttackScalesWithUser) {
         this.size *= this.user == null ? 1.0F : this.user.field_70131_O / 1.8F;
      }

      if (this.user != null && (this.isShield() || this.isExplosion())) {
         this.size = this.user.field_70131_O * 3.0F * (!this.isExplosion() ? 1.0F : 2.0F);
      }

   }

   protected void entityInit() {
   }

   protected void readEntityFromNBT(NBTTagCompound nbt) {
   }

   protected void writeEntityToNBT(NBTTagCompound nbt) {
   }

   public boolean isWave() {
      return this.getType() == 0;
   }

   public boolean isBlast() {
      return this.getType() == 1;
   }

   public boolean isDisk() {
      return this.getType() == 2;
   }

   public boolean isLaser() {
      return this.getType() == 3;
   }

   public boolean isLargeBlast() {
      return this.getType() == 5;
   }

   public boolean isSpiral() {
      return this.getType() == 4;
   }

   public boolean isBarrage() {
      return this.getType() == 6;
   }

   public boolean isShield() {
      return this.getType() == 7;
   }

   public boolean isExplosion() {
      return this.getType() == 8;
   }

   public void onUpdate() {
      if (this.world.field_72995_K && !JRMCoreClient.mc.func_147113_T()) {
         if (this.user == null) {
            this.moveToUser();
         }

         if (this.user != null) {
            this.createParticles();
         }

         if (this.user != null && !this.user.field_70128_L) {
            ExtendedPlayer props = ExtendedPlayer.get(this.user);
            if (props.getAnimKiShoot() != 0 && props.getAnimKiShootOn() != 0) {
               this.func_70080_a(this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, 0.0F, 0.0F);
            } else {
               this.setDead();
            }
         } else {
            this.setDead();
         }
      }

   }

   private void moveToUser() {
      if (this.mot.length() > 1) {
         this.user = this.world.getPlayerEntityByName(this.mot);
         if (this.user != null) {
            this.func_70080_a(this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, 0.0F, 0.0F);
         } else {
            this.setDead();
         }
      } else {
         this.setDead();
      }

   }

   private void createParticles() {
      int k;
      if (this.user != null && this.user.world.field_72995_K && (this.isWave() || this.isBlast() || this.isLargeBlast() || this.isLaser() || this.isSpiral())) {
         k = JRMCoreH.techCol[this.getColor()];
         int coloring2 = JRMCoreH.techCol2[this.getColor()];
         this.generateParticles(this, this.user, k, coloring2);
      }

      if (JGConfigClientSettings.CLIENT_DA16) {
         for(k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
            float h1;
            float scale;
            float pl_s;
            double x;
            double y;
            double z;
            float rota4;
            float scalem;
            float rota;
            float h2;
            float h3;
            float a;
            float scales;
            if (this.getPartid() == 1) {
               a = 1.0F;
               h1 = 2.0F;
               h1 = this.user.field_70131_O;
               scale = (float)this.ticksExisted * (this.size / 100.0F);
               if (scale > this.size) {
                  scale = this.size;
               }

               pl_s = 4.0F * scale + 2.0F + h1 / 2.0F;
               x = Math.random() * (double)pl_s - (double)(pl_s / 2.0F);
               y = -1.0499999523162842D;
               z = Math.random() * (double)pl_s - (double)(pl_s / 2.0F);
               double motx = -x / 50.0D / (double)(h1 / 2.0F);
               double motz = -z / 50.0D / (double)(h1 / 2.0F);
               rota4 = (float)(JRMCoreH.techCol[this.color] >> 16 & 255) / 255.0F;
               scalem = (float)(JRMCoreH.techCol[this.color] >> 8 & 255) / 255.0F;
               scales = (float)(JRMCoreH.techCol[this.color] & 255) / 255.0F;
               rota = a * rota4;
               h2 = a * scalem;
               h3 = a * scales;
               Entity entity7 = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.world, 0.2F, 0.2F, this.user.posX, this.user.posY, this.user.posZ, x, y, z, motx, 0.1D + Math.random() * 0.02500000037252903D, motz, 0.0F, (int)(Math.random() * 3.0D) + 56, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (27 + (int)pl_s) * ((int)(h1 / 3.0F) + 1), 0, 0.001F + (float)(Math.random() * 0.0020000000949949026D), 0.0F, 0.0F, 0, rota, h2, h3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F, false, -1, true, this.user);
               entity7.world.func_72838_d(entity7);
            } else {
               int num;
               int i;
               int id;
               float rota;
               float red;
               float green;
               float transp_sp;
               float transp_min;
               float transp_max;
               EntityCusPar entity;
               float blue;
               if (this.getPartid() != 4) {
                  if (this.getPartid() == 2) {
                     if (this.ticksExisted % 5 == 0) {
                        a = 1.0F;
                        h1 = 1.0F;
                        scale = (float)this.ticksExisted * (this.field_70131_O / 100.0F);
                        pl_s = 1.0F;
                        x = 0.0D;
                        y = (double)(this.user.field_70131_O * 0.7F - 1.5F);
                        y = (double)(this.user.field_70131_O * 0.7F - 1.0F);
                        pl_s = this.user.field_70131_O / 2.0F;
                        z = 0.0D;
                        num = (int)(Math.random() * 4.0D) + 1;

                        for(i = 0; i < num; ++i) {
                           id = (int)(Math.random() * 4.0D);
                           rota = (float)(Math.random() * 0.4000000059604645D) + 0.4F;
                           rota4 = (float)(Math.random() * 0.4000000059604645D) + 0.4F;
                           scalem = ((float)(Math.random() * 0.019999999552965164D) + 0.04F) * pl_s;
                           scales = ((float)(Math.random() * 0.0020000000949949026D) + 0.001F) * pl_s;
                           int rota1 = (int)(Math.random() * 360.0D);
                           int rota2 = (int)(Math.random() * 360.0D);
                           int rota3 = (int)(Math.random() * 360.0D);
                           boolean rot = (int)(Math.random() * 2.0D) == 0;
                           red = (float)(Math.random() * (double)rota) + 0.001F;
                           green = (float)(JRMCoreH.techCol2[this.color] >> 16 & 255) / 255.0F;
                           blue = (float)(JRMCoreH.techCol2[this.color] >> 8 & 255) / 255.0F;
                           float h4 = (float)(JRMCoreH.techCol2[this.color] & 255) / 255.0F;
                           transp_sp = h1 * green;
                           transp_min = h1 * blue;
                           transp_max = h1 * h4;
                           entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.world, 2.0F, 2.0F, this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, true, 0.0F, true, 0.0F, 1, "", 25, 0, 0.1F, scalem, scales, 0, transp_sp, transp_min, transp_max, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.95F, 0.98F, 0.2F, false, -1, true, this.user);
                           ((EntityCusPar)entity).setdata39((float)rota1);
                           ((EntityCusPar)entity).setdata40((float)rota2);
                           ((EntityCusPar)entity).setdata41((float)rota3);
                           ((EntityCusPar)entity).setdata42(3);
                           ((EntityCusPar)entity).setdata45(1.5F);
                           ((EntityCusPar)entity).setRotate(rot);
                           ((EntityCusPar)entity).setRotation_Sp(red);
                           entity.world.func_72838_d(entity);
                        }
                     }
                  } else if (this.getPartid() == 3 && this.ticksExisted % 2 == 0) {
                     a = 0.8F * this.user.field_70131_O;
                     h1 = 1.0F + (this.user.field_70131_O > 2.1F ? this.user.field_70131_O / 2.0F : 0.0F) / 5.0F;
                     scale = this.user.field_70130_N * 3.0F;
                     double x = (Math.random() * 1.0D - 0.5D) * (double)(scale * 0.8F);
                     double y = Math.random() * (double)(this.field_70131_O * 0.8F) - 0.6000000238418579D;
                     double z = (Math.random() * 1.0D - 0.5D) * (double)(scale * 0.8F);
                     double motx = Math.random() * 0.05000000074505806D - 0.029999999329447746D;
                     double moty = (Math.random() * 0.10000000149011612D + 0.10000000149011612D) * (double)(a * h1) * 0.18D;
                     double motz = Math.random() * 0.05000000074505806D - 0.029999999329447746D;
                     scalem = 255.0F;
                     scales = 217.0F;
                     rota = 25.0F;
                     Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.user.world, 0.2F, 0.2F, this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, x, y, z, motx, moty, motz, (float)(Math.random() * 0.009999999776482582D) - 0.005F, (int)(Math.random() * 3.0D) + 59, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * a * 1.6F), 2, ((float)(Math.random() * 0.009999999776482582D) + 0.01F) * a * h1, ((float)(Math.random() * 0.004999999888241291D) + 0.005F) * a * h1, 0.03F * a * h1, 0, scalem, scales, rota, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, false, (Entity)null);
                     this.user.world.func_72838_d(entity);
                  }
               } else {
                  float h4;
                  if (this.ticksExisted % 2 == 0) {
                     a = 1.0F;
                     h1 = 1.0F;
                     scale = (float)this.ticksExisted * (this.field_70131_O / 100.0F);
                     pl_s = 1.0F;
                     x = 0.0D;
                     y = (double)(this.user.field_70131_O * 0.7F - 1.0F);
                     pl_s = this.user.field_70131_O / 2.0F;
                     z = 0.0D;
                     num = (int)(Math.random() * 4.0D) + 1;

                     for(i = 0; i < num; ++i) {
                        id = (int)(Math.random() * 3.0D) + 4;
                        rota = (float)(Math.random() * 0.019999999552965164D) + 0.01F;
                        rota4 = ((float)(Math.random() * 0.15000000596046448D) + 0.155F) * pl_s;
                        scalem = rota4 * 0.01F;
                        boolean forg = (int)(Math.random() * 2.0D) == 0;
                        rota = (float)(JRMCoreH.techCol[this.color] >> 16 & 255) / 255.0F;
                        h2 = (float)(JRMCoreH.techCol[this.color] >> 8 & 255) / 255.0F;
                        h3 = (float)(JRMCoreH.techCol[this.color] & 255) / 255.0F;
                        h4 = h1 * rota;
                        red = h1 * h2;
                        green = h1 * h3;
                        Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.world, 2.0F, 2.0F, this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, forg, rota, false, 0.0F, 1, "", 5, 1, 0.145F * pl_s, rota4, scalem, 0, h4, red, green, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.3F, false, -1, true, this.user);
                        ((EntityCusPar)entity).setdata39((float)((int)(Math.random() * 360.0D)));
                        entity.world.func_72838_d(entity);
                     }
                  }

                  if (this.ticksExisted % 3 == 0) {
                     a = 1.0F;
                     h1 = 1.0F;
                     scale = (float)this.ticksExisted * (this.field_70131_O / 100.0F);
                     pl_s = 1.0F;
                     x = 0.0D;
                     y = (double)(this.user.field_70131_O * 0.7F - 1.0F);
                     pl_s = this.user.field_70131_O / 2.0F;
                     z = 0.0D;
                     pl_s = this.user.field_70131_O / 2.0F;
                     int num = 4;
                     boolean forg = (int)(Math.random() * 2.0D) == 0;
                     float rot = (float)(Math.random() * 0.019999999552965164D) + 0.01F;

                     for(int i = 0; i < num; ++i) {
                        int id = 7;
                        scalem = ((float)(Math.random() * 0.029999999329447746D) + 0.13F) * pl_s;
                        scales = scalem * 0.1F;
                        rota = 360.0F / (float)num * (float)i + (float)((int)(Math.random() * (double)(360 / num)));
                        h2 = (float)(JRMCoreH.techCol[this.color] >> 16 & 255) / 255.0F;
                        h3 = (float)(JRMCoreH.techCol[this.color] >> 8 & 255) / 255.0F;
                        h4 = (float)(JRMCoreH.techCol[this.color] & 255) / 255.0F;
                        red = h1 * h2;
                        green = h1 * h3;
                        blue = h1 * h4;
                        int life = true;
                        transp_sp = 0.18F;
                        transp_min = 0.75F;
                        transp_max = 0.78F;
                        entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.world, 2.0F, 2.0F, this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, forg, rot, false, 0.0F, 1, "", 30, 1, 0.12F * pl_s, scalem, scales, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.18F, false, -1, true, this.user);
                        ((EntityCusPar)entity).setdata39(rota);
                        entity.world.func_72838_d(entity);
                        h2 = (float)(JRMCoreH.techCol2[this.color] >> 16 & 255) / 255.0F;
                        h3 = (float)(JRMCoreH.techCol2[this.color] >> 8 & 255) / 255.0F;
                        h4 = (float)(JRMCoreH.techCol2[this.color] & 255) / 255.0F;
                        red = h1 * h2;
                        green = h1 * h3;
                        blue = h1 * h4;
                        Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.world, 2.0F, 2.0F, this.user.posX, this.user.posY + (double)(this.user instanceof EntityPlayerSP ? -1.6F : 0.0F), this.user.posZ, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, true, rot, false, 0.0F, 1, "", 30, 1, 0.096F * pl_s, scalem * 0.8F, scales * 0.8F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.18F, false, -1, true, this.user);
                        ((EntityCusPar)entity2).setdata39(rota);
                        entity2.world.func_72838_d(entity2);
                     }
                  }
               }
            }
         }
      }

   }

   public void generateParticles(EntityEng entityBlast, Entity entity, int color, int color2) {
      if (entityBlast != null && entity != null && entityBlast.world.field_72995_K) {
         EntityPlayer user = entityBlast.user;
         int ticksExisted = entityBlast.ticksExisted;
         float scale = (float)ticksExisted * (entityBlast.getSize() / 100.0F);
         if (scale > entityBlast.getSize()) {
            scale = entityBlast.getSize();
         }

         for(int i = 0; (float)i < 1.0F + scale; ++i) {
            for(int k = 0; k < JGConfigClientSettings.get_da1(); ++k) {
               float colorFixer = 0.7F;
               float red = (float)(color >> 16 & 255) / 255.0F;
               float green = (float)(color >> 8 & 255) / 255.0F;
               float blue = (float)(color & 255) / 255.0F;
               red *= 0.7F;
               green *= 0.7F;
               blue *= 0.7F;
               float red2 = (float)(color2 >> 16 & 255) / 255.0F;
               float green2 = (float)(color2 >> 8 & 255) / 255.0F;
               float blue2 = (float)(color2 & 255) / 255.0F;
               float alpha = scale / 2.0F < 1.0F ? scale / 2.0F : 1.0F;
               float out = 1.5F * scale;
               float in = 1.5F;
               float life = 0.4F * entity.field_70131_O;
               float extra_scale = 0.2F;
               int dea = true;
               float target_fullsize_one1 = 0.32F;
               float targetsizeMin = entity.field_70131_O * (8.0F / target_fullsize_one1) * 0.01F;
               float target_fullsize_one2 = 0.32F;
               float targetsizeMax = entity.field_70131_O * (26.0F / target_fullsize_one2) * 0.01F;
               double x = Math.random() * (double)out - (double)(out / 2.0F);
               double y = Math.random() * (double)out - (double)(out / 2.0F);
               double z = Math.random() * (double)out - (double)(out / 2.0F);
               double x2 = 0.0D;
               double y2 = 0.0D;
               double z2 = 0.0D;
               x2 = entity.posX;
               y2 = entity.posY;
               z2 = entity.posZ;
               y2 += (double)(entity instanceof EntityPlayerSP ? -1.6F : 0.0F);
               double motionX = 0.0D;
               double motionZ = 0.0D;
               double motionY = 0.0D;
               float height = user.field_70131_O;
               float height2 = height * 0.8F;
               float width = user.field_70130_N;
               float width2 = width * 0.8F;
               Vec3 vec3;
               double kiX;
               double kiY;
               double d8;
               double d9;
               if (entityBlast.isWave()) {
                  vec3 = entity.func_70040_Z();
                  kiX = 0.0D;
                  kiY = 0.0D;
                  kiX = 1.0D;
                  kiY = -1.0D;
                  d8 = (double)entity.field_70130_N + kiX;
                  d9 = (double)entity.field_70131_O;
                  x2 += vec3.field_72450_a * d8;
                  y2 += vec3.field_72448_b * d8 + (double)(height2 * 0.92F);
                  z2 += vec3.field_72449_c * d8;
               } else if (!entityBlast.isBlast() && !entityBlast.isSpiral() && !entityBlast.isLaser()) {
                  if (!entityBlast.isDisk()) {
                     if (entityBlast.isLargeBlast()) {
                        double kiX = 0.0D;
                        double kiY = 0.0D;
                        kiX = 1.0D;
                        kiY = -1.0D;
                        y2 += (double)(entity.field_70131_O + 1.0F + scale / 2.0F);
                     } else if (!entityBlast.isShield() && entityBlast.isExplosion()) {
                     }
                  }
               } else {
                  vec3 = entity.func_70040_Z();
                  kiX = 0.0D;
                  kiY = 0.0D;
                  kiX = 1.0D;
                  kiY = -1.0D;
                  d8 = (double)entity.field_70130_N + kiX;
                  d9 = (double)entity.field_70131_O;
                  x2 += vec3.field_72450_a * d8;
                  y2 += vec3.field_72448_b * d8 + (double)(height2 * 0.92F);
                  z2 += vec3.field_72449_c * d8;
               }

               x2 += x;
               y2 += y;
               z2 += z;
               motionX = x * 0.02D;
               motionY = y * 0.02D;
               motionZ = z * 0.02D;
               float scaleStart = ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.2F;
               float scaleEnd = ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.2F;
               float scaleSpeed = 0.2F * life * 0.2F;
               int textureID = (int)(Math.random() * 3.0D) + 8;
               Entity particle = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.world, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart, scaleEnd, scaleStart, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F * alpha, 0.0F * alpha, 0.9F * alpha, 0.95F * alpha, 0.06F * alpha, false, -1, true, (Entity)null);
               entity.world.func_72838_d(particle);
               Entity particle2 = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.world, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart * 0.8F, scaleEnd * 0.8F, scaleStart * 0.8F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F * alpha, 0.0F * alpha, 0.9F * alpha, 0.95F * alpha, 0.06F * alpha, false, -1, true, (Entity)null);
               entity.world.func_72838_d(particle2);
               if (!entityBlast.isWave() && !entityBlast.isBlast() && !entityBlast.isSpiral() && !entityBlast.isLaser() && !entityBlast.isDisk() && !entityBlast.isLargeBlast() && !entityBlast.isShield() && entityBlast.isExplosion()) {
               }
            }
         }
      }

   }

   public float rad(float angle) {
      return angle * 3.1415927F / 180.0F;
   }

   public boolean func_70112_a(double par1) {
      if (JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge == 10000) {
         return true;
      } else {
         double d1 = this.boundingBox.func_72320_b();
         d1 *= 64.0D * this.field_70155_l;
         return par1 < d1 * d1 * ((double)JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge / 100.0D);
      }
   }
}
