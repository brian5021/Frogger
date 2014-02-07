// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc


import javalib.worldimages.FromFileImage;
import javalib.worldimages.WorldImage;

// To represent a Frog
public class Frog {

    CartPt loc;
    int lane;
	int size = 30; // in pixels
	int jDIST = 50; // in pixels
	
	Frog(CartPt loc, int lane) {
		
	    this.loc = loc;
		this.lane = lane;
	}
	
	/* Template:
    Fields:
    ... this.loc ...       -- CartPt
    ... this.lanes ...     -- int
    
    Methods:
    ... this.jump(String s) ...              -- void
    ... this.isCollided(ALane lane) ...      -- Boolean
    ... this.slideFrog(ALane lane) ...       -- void
    ... this.frogImage() ...                 -- WorldImage
    
  */
	
	// Advance the frog JDIST in the give direction
	public void jump(String s) {
		if (s.equals("up")) {
			this.loc.y = this.loc.y - jDIST;
			this.lane++;
		} else if (s.equals("down")) {
			this.loc.y = this.loc.y + jDIST;
			this.lane = this.lane - 1;
		} else if (s.equals("left")) {
			this.loc.x = this.loc.x - jDIST;
		} else {
			this.loc.x = this.loc.x + jDIST;
		}
	
	}
	
	// Detect a collision
	public boolean isCollided(ALane lane) {

		for (AObstacle aobs : lane.obstacles) {
			 if (this.loc.isCollided(aobs.loc, this.size, lane.size)) {
					 return true;
			 }	 
		}
		return false;
	}	

	//slides frog the speed of the water lane he is in
	public void slideFrog(ALane lane) {
	    if (lane.rl) {
	        this.loc.x += lane.speed;
	        
	    } else {
	        this.loc.x -= lane.speed;
	    }
	    
	    
	}

	// Return the Frog's image
    WorldImage frogImage() {
        
        return new FromFileImage(this.loc, "p135-husky.png");
    }

    
}