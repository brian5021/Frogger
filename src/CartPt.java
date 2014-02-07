// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc


import javalib.worldimages.Posn;


public class CartPt extends Posn {

	public CartPt(int x, int y) {
		super(x, y);
		
	}
	
	/* Template:
    Fields:
    ... this.x ...       -- int
    ... this.y ...       -- int
    
    Methods:
    ... this.distanceTo(CartPt other,
						int sizeF, int sizeO)   -- int
    ... this.isCollided(CartPt other, 
              int sizeF, int sizeO) ...         -- Boolean
    ... this.offScreen() ...                    -- Boolean
    
  */
	
	// Find the positive difference between the frog image and the object image
	public int distanceTo(CartPt other, int sizeF, int sizeO) {
		int halfSF = sizeF / 2; // half of the frog image size
		int halfSO = sizeO / 2; // half of the object image size
		if (other.x < this.x) {
			return (this.x - halfSF) - (other.x + halfSO);
		} else return (other.x - halfSO) - (this.x + halfSF);
	}
	
	// Determine if the difference between the two objects is less than 
	// half the size of the frog image
	public boolean isCollided(CartPt other, int sizeF, int sizeO) {
		return (this.distanceTo(other, sizeF, sizeO) < -1);
	}

	//is this location off the screen
	public boolean offScreen() {
	    return ((this.x < 20) || (this.x > 530)) ||
	            ((this.y < 20) || (this.y > 530));
	}
	
}
