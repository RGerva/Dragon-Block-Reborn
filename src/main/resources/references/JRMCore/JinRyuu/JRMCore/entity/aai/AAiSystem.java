package JinRyuu.JRMCore.entity.aai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.minecraft.entity.Entity;

public class AAiSystem {
   public Entity entity;
   public ArrayList<AAi> aais;

   public AAiSystem(Entity entity, AAi... aais) {
      this.entity = entity;
      this.aais = new ArrayList();
      this.addAAis(aais);
   }

   public void addAAis(AAi... aais) {
      this.aais.addAll(Arrays.asList(aais));
      AAi[] var2 = aais;
      int var3 = aais.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         AAi aai = var2[var4];
         aai.aaiSystem = this;
      }

   }

   public void addAAi(AAi aai) {
      this.aais.add(aai);
      aai.aaiSystem = this;
   }

   public void update() {
      Iterator var1 = this.aais.iterator();

      while(var1.hasNext()) {
         AAi aai = (AAi)var1.next();
         aai.update();
      }

   }
}
