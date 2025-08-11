package JinRyuu.DragonBC.common.Npcs;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCWildlifeA extends EntityDBCWildlife {
   public EntityDBCWildlifeA(World par1World) {
      super(par1World);
   }

   public void func_70645_a(DamageSource par1DamageSource) {
      Entity var3 = par1DamageSource.func_76346_g();
      if (var3 instanceof EntityPlayer) {
         List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            Entity var6 = (Entity)var4.get(var5);
            if (var6 instanceof EntityDBCWildlifeA) {
               EntityDBCWildlifeA var7 = (EntityDBCWildlifeA)var6;
               var7.becomeAngryAt(var3);
            }
         }

         this.becomeAngryAt(var3);
      }

      super.func_70645_a(par1DamageSource);
   }

   protected Entity func_70782_k() {
      return super.func_70782_k();
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (this.func_85032_ar()) {
         return false;
      } else {
         Entity var3 = par1DamageSource.func_76346_g();
         if (var3 instanceof EntityPlayer) {
            List var4 = this.world.func_72839_b(this, this.boundingBox.func_72314_b(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if (var6 instanceof EntityDBCWildlifeA) {
                  EntityDBCWildlifeA var7 = (EntityDBCWildlifeA)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.func_70097_a(par1DamageSource, par2);
      }
   }
}
