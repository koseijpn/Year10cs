package firsttry;

public class Health1 {

	   private int hpn;

	   public Health1(int hpn) {
	      if (hpn < 0 || hpn > 100) {
	         throw new IllegalArgumentException();
	      } else {
	         this.hpn = hpn;
	      }
	   }

	   public int getHealthhpn() {
	      return hpn;
	   }


	   public void setHealthhpn(int newhpn) {
	    if (newhpn < 0 || newhpn > 100) {
	         throw new IllegalArgumentException();
	      } else {
	      hpn = newhpn;
	    }
	   }

	}
