package JinRyuu.JRMCore;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class JRMCoreMsn {
   private int id;
   private boolean translated;
   private ArrayList<String> props = Lists.newArrayList();
   private ArrayList<String> align = Lists.newArrayList();
   private ArrayList<String> title = Lists.newArrayList();
   private ArrayList<String> subtitle = Lists.newArrayList();
   private ArrayList<String> description = Lists.newArrayList();
   private ArrayList<ArrayList<String>> objectives = Lists.newArrayList();
   private ArrayList<ArrayList<String>> rewards = Lists.newArrayList();

   public int getProp(int p, int r, int c) {
      int i;
      switch(p) {
      case 1:
         r = r == 2 ? 1 : r;

         for(i = 0; i < this.props.size(); ++i) {
            if (((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.Races[r]) || ((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.ClassesDBC[c])) {
               return i;
            }
         }

         return 0;
      case 2:
         for(i = 0; i < this.props.size(); ++i) {
            if (((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.Races[r]) || ((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.ClassesDBC[c])) {
               return i;
            }
         }

         return 0;
      case 3:
         return 0;
      default:
         return 0;
      }
   }

   public String getTitle(int p, int r, int c) {
      return (String)this.title.get(this.getProp(p, r, c));
   }

   public String getSubtitle(int p, int r, int c) {
      return (String)this.subtitle.get(this.getProp(p, r, c));
   }

   public String getDescription(int p, int r, int c) {
      return (String)this.description.get(this.getProp(p, r, c));
   }

   public String getAlign(int p, int r, int c) {
      return (String)this.align.get(this.getProp(p, r, c));
   }

   public ArrayList<String> getObjectives(int p, int r, int c) {
      return (ArrayList)this.objectives.get(this.getProp(p, r, c));
   }

   public ArrayList<String> getRewards(int p, int r, int c) {
      return (ArrayList)this.rewards.get(this.getProp(p, r, c));
   }

   public int getObjectivesSize(int p, int r, int c) {
      return ((ArrayList)this.objectives.get(this.getProp(p, r, c))).size();
   }

   public int getRewardsSize(int p, int r, int c) {
      return ((ArrayList)this.rewards.get(this.getProp(p, r, c))).size();
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public boolean isTranslated() {
      return this.translated;
   }

   public void setTranslated(boolean translated) {
      this.translated = translated;
   }

   public ArrayList<String> getTitle() {
      return this.title;
   }

   public void setTitle(ArrayList<String> title) {
      this.title = title;
   }

   public ArrayList<String> getSubtitle() {
      return this.subtitle;
   }

   public void setSubtitle(ArrayList<String> subtitle) {
      this.subtitle = subtitle;
   }

   public ArrayList<String> getDescription() {
      return this.description;
   }

   public void setDescription(ArrayList<String> description) {
      this.description = description;
   }

   public ArrayList<String> getAlign() {
      return this.align;
   }

   public void setAlign(ArrayList<String> align) {
      this.align = align;
   }

   public ArrayList<String> getProps() {
      return this.props;
   }

   public void setProps(ArrayList<String> props) {
      this.props = props;
   }

   public ArrayList<ArrayList<String>> getObjectives() {
      return this.objectives;
   }

   public void setObjectives(ArrayList<ArrayList<String>> objectives) {
      this.objectives = objectives;
   }

   public ArrayList<ArrayList<String>> getRewards() {
      return this.rewards;
   }

   public void setRewards(ArrayList<ArrayList<String>> rewards) {
      this.rewards = rewards;
   }
}
