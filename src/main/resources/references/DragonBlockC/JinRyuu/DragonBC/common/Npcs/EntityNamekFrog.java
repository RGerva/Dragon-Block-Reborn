package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityNamekFrog extends EntityAnimal {
   private boolean j;

   public EntityNamekFrog(World par1World) {
      super(par1World);
      this.field_70728_aV = 0;
      this.func_70606_j(2.0F);
      this.func_70105_a(1.0F, 1.0F);
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public void func_70071_h_() {
      if (this.j && this.field_70122_E && !this.field_70703_bu) {
         this.j = false;
      }

      if (!this.j && !this.field_70703_bu && (int)(Math.random() * 10.0D) == 0 && this.field_70173_aa % 100 == 0) {
         this.func_70664_aZ();
      }

      if (!this.j && this.field_70703_bu) {
         this.field_70159_w = Math.random() * 1.0D - 0.5D;
         this.field_70181_x = Math.random() * 1.0D;
         this.field_70179_y = Math.random() * 1.0D - 0.5D;
         float min = 0.2F;
         float min2 = -0.2F;
         if (this.field_70159_w > 0.0D) {
            if (this.field_70159_w < (double)min) {
               this.field_70159_w += (double)min;
            }
         } else if (this.field_70159_w < 0.0D && this.field_70159_w > (double)min2) {
            this.field_70159_w += (double)min2;
         }

         if (this.field_70181_x > 0.0D) {
            if (this.field_70181_x < (double)min) {
               this.field_70181_x += (double)min;
            }
         } else if (this.field_70181_x < 0.0D && this.field_70181_x > (double)min2) {
            this.field_70181_x += (double)min2;
         }

         this.field_70133_I = true;
         this.j = true;
      }

      super.func_70071_h_();
   }

   protected void func_70069_a(float p_70069_1_) {
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/NamekFrog.png";
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   protected void func_70628_a(boolean par1, int par2) {
   }

   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   protected boolean func_70692_ba() {
      return false;
   }

   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return null;
   }
}
