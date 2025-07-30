package JinRyuu.DragonBC.common;

import net.minecraft.util.StatCollector;

public class Lang {
   public String BigBangName = StatCollector.func_74838_a("dbc.KABigBang.name");
   public String BlastName = StatCollector.func_74838_a("dbc.KABlast.name");
   public String BurningAttName = StatCollector.func_74838_a("dbc.KABurningAtt.name");
   public String DeathBeamName = StatCollector.func_74838_a("dbc.KADeathBeam.name");
   public String DodonName = StatCollector.func_74838_a("dbc.KADodon.name");
   public String EnergyDiskName = StatCollector.func_74838_a("dbc.KAEnergyDisk.name");
   public String FinalFlashName = StatCollector.func_74838_a("dbc.KAFinalFlash.name");
   public String FingerLeserName = StatCollector.func_74838_a("dbc.KAFingerLeser.name");
   public String GalicGunName = StatCollector.func_74838_a("dbc.KAGalicGun.name");
   public String HameName = StatCollector.func_74838_a("dbc.KAHame.name");
   public String Hame10xName = StatCollector.func_74838_a("dbc.KAHame10x.name");
   public String MakankoName = StatCollector.func_74838_a("dbc.KAMakanko.name");
   public String MasenkoName = StatCollector.func_74838_a("dbc.KAMasenko.name");
   public String PlanetDestName = StatCollector.func_74838_a("dbc.KAPlanetDest.name");
   public String SpiritbombName = StatCollector.func_74838_a("dbc.KASpiritbomb.name");

   public static void init() {
   }

   public String KAName(int par1) {
      String ret = "";
      if (par1 == 1) {
         ret = this.BigBangName;
      }

      if (par1 == 2) {
         ret = this.BlastName;
      }

      if (par1 == 3) {
         ret = this.BurningAttName;
      }

      if (par1 == 4) {
         ret = this.DeathBeamName;
      }

      if (par1 == 5) {
         ret = this.DodonName;
      }

      if (par1 == 6) {
         ret = this.EnergyDiskName;
      }

      if (par1 == 7) {
         ret = this.FinalFlashName;
      }

      if (par1 == 8) {
         ret = this.FingerLeserName;
      }

      if (par1 == 9) {
         ret = this.GalicGunName;
      }

      if (par1 == 10) {
         ret = this.HameName;
      }

      if (par1 == 11) {
         ret = this.Hame10xName;
      }

      if (par1 == 12) {
         ret = this.MakankoName;
      }

      if (par1 == 13) {
         ret = this.MasenkoName;
      }

      if (par1 == 14) {
         ret = this.PlanetDestName;
      }

      if (par1 == 15) {
         ret = this.SpiritbombName;
      }

      return ret;
   }
}
