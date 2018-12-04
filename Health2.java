package firsttry;

public class Health2 {

	   private int hpr;

	   public Health2(int hpr) {
	      if (hpr < 0 || hpr > 100) {
	         throw new IllegalArgumentException();
	      } else {
	         this.hpr = hpr;
	      }
	   }

	   public int getHealthhpr() {
	      return hpr;
	   }


	   public void setHealthhpr(int newhpr) {
	    if (newhpr < 0 || newhpr > 100) {
	         throw new IllegalArgumentException();
	      } else {
	      hpr = newhpr;
	    }
	   }

	}