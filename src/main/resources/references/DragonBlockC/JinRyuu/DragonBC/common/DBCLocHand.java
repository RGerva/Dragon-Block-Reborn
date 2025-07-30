package JinRyuu.DragonBC.common;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class DBCLocHand {
   public static void LangLod() {
      String[] var0 = DBCLoc.localFiles;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         String LocFile = var0[var2];
         String File = LocFile.replace("es_AR", "es_ES").replace("es_MX", "es_ES").replace("pt_BR", "pt_PT");
         LanguageRegistry.instance().loadLocalization(File, DBCLocHlp.getLocFrmName(LocFile), DBCLocHlp.isXMLLangFil(File));
      }

   }
}
