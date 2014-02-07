



// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc

import javalib.worldimages.FromFileImage;
import javalib.worldimages.WorldImage;

// To represent an obstacle
abstract class AObstacle {
    CartPt loc;

    AObstacle(CartPt loc) {
        this.loc = loc;
    }
    
    /* Template:
    Fields:
    ... this.loc ...       -- CartPt
    
    Methods:
    ... this.obstacleImage() ...             -- WorldImage
    
  */
    
    // abstract method for returning obstacle image
    abstract WorldImage obstacleImage(boolean rl);


}

// To represent a Truck
class Truck extends AObstacle{

    Truck(CartPt loc) {
        super(loc);
    }
    
    /* Template:
    Fields:
    ... this.loc ...       -- CartPt
    
    Methods:
    ... this.obstacleImage() ...             -- WorldImage
    
  */

    // Returns truck image
    WorldImage obstacleImage(boolean rl) {

        if (rl) {
            return new FromFileImage(this.loc, "p135-truck2.png");
        } else {
            return new FromFileImage(this.loc, "p135-truck.png");
        }

    }

}

// To represent a car
class Car extends AObstacle{

    Car(CartPt loc) {
        super(loc);
    }
    
    /* Template:
    Fields:
    ... this.loc ...       -- CartPt
    
    Methods:
    ... this.obstacleImage() ...             -- WorldImage
    
  */

    // Returns image of a car
    WorldImage obstacleImage(boolean rl) {
        if (rl) {
            return new FromFileImage(this.loc, "p135-car2.png");
        } else {
            return new FromFileImage(this.loc, "p135-car.png");
        }

    }

}

// To Represent a log
class Log extends AObstacle{

    Log(CartPt loc) {
        super(loc);
    }
    
    /* Template:
    Fields:
    ... this.loc ...       -- CartPt
    
    Methods:
    ... this.obstacleImage() ...             -- WorldImage
    
  */

    // Returns image of a log
    WorldImage obstacleImage(boolean rl) {

        return new FromFileImage(this.loc, "p135-log.png");

    }


}

// To represent a lilly pad
class LillyPad extends AObstacle{

    LillyPad(CartPt loc) {
        super(loc);
    }
    
    /* Template:
    Fields:
    ... this.loc ...       -- CartPt
    
    Methods:
    ... this.obstacleImage() ...             -- WorldImage
    
  */

    // Returns the image of a lillypad
    WorldImage obstacleImage(boolean rl) {

        return new FromFileImage(this.loc, "p135-lillypad.png");

    }

}