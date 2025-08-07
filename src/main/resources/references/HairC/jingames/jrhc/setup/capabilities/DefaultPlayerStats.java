package jingames.jrhc.setup.capabilities;

public class DefaultPlayerStats implements IPlayerStats {
   private float redColor;
   private float greenColor;
   private float blueColor;
   private String DNSH;

   public void setRedColor(float redcolor) {
      this.redColor = redcolor;
   }

   public float getRedColor() {
      return this.redColor;
   }

   public void setGreenColor(float greencolor) {
      this.greenColor = greencolor;
   }

   public float getGreenColor() {
      return this.greenColor;
   }

   public void setBlueColor(float bluecolor) {
      this.blueColor = bluecolor;
   }

   public float getBlueColor() {
      return this.blueColor;
   }

   public void setDNSH(String DNSH) {
      this.DNSH = DNSH;
   }

   public String getDNSH() {
      return this.DNSH;
   }
}
