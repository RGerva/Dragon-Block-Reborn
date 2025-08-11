package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCEvil extends EntityDBC implements IEntityAdditionalSpawnData {
   private Entity spwner = null;
   protected Entity target = null;
   private int noSpwnr;

   public EntityDBCEvil(World par1World) {
      super(par1World);
      this.noSpwnr = DBCConfig.mdat;
   }

   protected NBTTagCompound nbt(EntityPlayer p, String s) {
      NBTTagCompound nbt;
      if (s.contains("pres")) {
         if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
            nbt = new NBTTagCompound();
            p.getEntityData().func_74782_a("PlayerPersisted", nbt);
         } else {
            nbt = p.getEntityData().func_74775_l("PlayerPersisted");
         }
      } else {
         nbt = p.getEntityData();
      }

      return nbt;
   }

   public void setSpwner(Entity e) {
      this.spwner = e;
   }

   public Entity getSpwner() {
      return this.spwner;
   }

   public void settarget(Entity e) {
      this.target = e;
   }

   public Entity gettarget() {
      return this.target;
   }

   public void setETA(Entity par1Entity) {
      this.field_70789_a = par1Entity;
   }

   protected Entity func_70782_k() {
      return this.target != null ? this.target : super.func_70782_k();
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      super.func_70645_a(par1DamageSource);
   }

   public void onUpdate() {
      if (!(this instanceof EntitySaiyan01) && !(this instanceof EntitySaiyan02)) {
         double r = (double)DBCConfig.mdal;
         if (this.spwner != null && r != 0.0D) {
            AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.posX - r, this.posY - r, this.posZ - r, this.posX + r, this.posY + r, this.posZ + r);
            List list = this.world.func_72872_a(EntityPlayer.class, aabb);
            boolean b = false;
            int j = 0;
            int sgid = JRMCoreH.getInt((EntityPlayer)this.spwner, "JRMCGID");
            int i = 0;

            while(true) {
               if (i >= list.size()) {
                  if (this.func_145782_y() == this.spwner.func_145782_y()) {
                     ++j;
                  }

                  if (j == 0) {
                     --this.noSpwnr;
                     if (this.noSpwnr <= 0) {
                        this.setDead();
                     }
                  } else if (this.noSpwnr != DBCConfig.mdat) {
                     this.noSpwnr = DBCConfig.mdat;
                  }
                  break;
               }

               EntityPlayer entity2 = (EntityPlayer)list.get(i);
               int ogid = JRMCoreH.getInt(entity2, "JRMCGID");
               if (this.spwner.func_145782_y() == entity2.func_145782_y() || sgid != 0 && sgid == ogid) {
                  ++j;
               }

               ++i;
            }
         }

         if (!this.world.field_72995_K && this.spwner == null) {
            this.setDead();
         }
      }

      super.onUpdate();
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (!super.func_70097_a(par1DamageSource, par2)) {
         return false;
      } else if (this.spwner != null) {
         MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
         EntityPlayer spwnr = (EntityPlayer)this.spwner;
         Entity atckr = par1DamageSource.func_76346_g();
         if (atckr instanceof EntityPlayer) {
            int sgid = JRMCoreH.getInt(spwnr, "JRMCGID");
            EntityLivingBase entitylivingbase;
            if (sgid != 0) {
               this.func_70784_b(atckr);
               this.settarget(atckr);
               entitylivingbase = this.func_70638_az();
               if (entitylivingbase == null && this.func_70777_m() instanceof EntityLivingBase) {
                  entitylivingbase = (EntityLivingBase)this.func_70777_m();
               }

               if (entitylivingbase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase) {
                  entitylivingbase = (EntityLivingBase)par1DamageSource.func_76346_g();
               }

               return true;
            } else if (spwnr.func_145782_y() == atckr.func_145782_y()) {
               this.func_70784_b(atckr);
               this.settarget(atckr);
               entitylivingbase = this.func_70638_az();
               if (entitylivingbase == null && this.func_70777_m() instanceof EntityLivingBase) {
                  entitylivingbase = (EntityLivingBase)this.func_70777_m();
               }

               if (entitylivingbase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase) {
                  entitylivingbase = (EntityLivingBase)par1DamageSource.func_76346_g();
               }

               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         EntityLivingBase entitylivingbase = this.func_70638_az();
         if (entitylivingbase == null && this.func_70777_m() instanceof EntityLivingBase) {
            entitylivingbase = (EntityLivingBase)this.func_70777_m();
         }

         if (entitylivingbase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase) {
            entitylivingbase = (EntityLivingBase)par1DamageSource.func_76346_g();
         }

         return true;
      }
   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.spwner == null ? 0 : this.spwner.func_145782_y());
      data.writeInt(this.target == null ? 0 : this.target.func_145782_y());
      data.writeInt(this.field_70789_a == null ? 0 : this.field_70789_a.func_145782_y());
   }

   public void readSpawnData(ByteBuf data) {
      int e1 = data.readInt();
      int e2 = data.readInt();
      int e3 = data.readInt();
      this.spwner = e1 == 0 ? this.spwner : this.world.func_73045_a(e1);
      this.target = e2 == 0 ? this.target : this.world.func_73045_a(e2);
      this.field_70789_a = e3 == 0 ? this.field_70789_a : this.world.func_73045_a(e3);
   }
}
