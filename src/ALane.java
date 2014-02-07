// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc



import java.util.ArrayList;

import javalib.worldimages.FromFileImage;
import javalib.worldimages.WorldImage;

// To represent a Lane
public abstract class ALane {

    ArrayList<AObstacle> obstacles;
    int counter;
    int laneNum;
    boolean rl;
    int speed;
    int size;
    boolean isWater;

    ALane(ArrayList<AObstacle> obstacles, 
            int counter, // spawn time
            int laneNum,
            boolean rl,  // true if right
            int speed,   // in pixels per tick
            int size,    // in pixels
            boolean isWater) { 
        this.obstacles = obstacles;
        this.counter = counter;
        this.laneNum = laneNum;
        this.rl = rl;
        this.speed = speed;
        this.size = size;
        this.isWater = isWater;

    }

    ALane(ArrayList<AObstacle> obstacles, 
            int counter,
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        this.obstacles = obstacles;
        this.counter = counter;
        this.laneNum = laneNum;
        this.rl = rl;
        this.speed = speed;
        this.size = size;
        this.isWater = false;
    }


    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
    ... this.createO(int y) ...                    -- AObstacle
    ... this.shift() ...                           -- void
    ... this.spawn() ...                           -- void
    ... this.isSafe() ...                          -- Boolean
    ... this.delete() ...                          -- void
    ... this.placedLaneImage() ...                 -- WorldImage
     
  */

    //returns the image of this lane
    abstract WorldImage laneImage(CartPt loc);

    //makes the correct type of obstacle
    abstract AObstacle makeObstacle(CartPt loc);

    //creates a new obstacle
    AObstacle createO(int y) {
        int startx;
        int starty = 525 - (y * 50);

        if (this.rl) {
            startx = -50;
        } else {
            startx = 600;
        }

        CartPt loc = new CartPt(startx, starty);

        return this.makeObstacle(loc);
    }

    //shifts all objects in this lane
    void shift() {
        for (AObstacle o : this.obstacles) {
            if (this.rl) {
                o.loc.x += this.speed;

            } else {
                o.loc.x -= this.speed;

            }
        }
    }

    //creates new objects off the screen
    void spawn() {

        if (this.counter <= 0) {
            if (!(this.isSafe())) {

                this.obstacles.add(this.createO(this.laneNum));
                this.counter = 200 / this.speed;
            }
        } else {
            counter--;
        }
    }

    //is the lane safe
    boolean isSafe() {
        return false;
    }

    //removes old objects as they leave the screen
    void delete() {
        if (this.obstacles.size() >= 1) { 
            int xloc = this.obstacles.get(0).loc.x;  

            if ((xloc <= -51) || (xloc >= 601)) {
                this.obstacles.remove(0);

            }
        }
    }

    // returns image of the placed lane
    WorldImage placedLaneImage() {
        int pixelLocx = 275;
        int pixelLocy = 525 - (this.laneNum * 50);
        CartPt loc = new CartPt(pixelLocx, pixelLocy); 

        return this.laneImage(loc);
    }




}

// to represent a truck lane
class TLane extends ALane {

    TLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size, 
            boolean isWater) { 
        super(obstacles, counter, laneNum, rl, speed, size, isWater);
        this.isWater = isWater;

    }

    TLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        super(obstacles, counter, laneNum, rl, speed, size);
        this.isWater = false;

    }
    
    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
  */

    // Make a truck
    AObstacle makeObstacle(CartPt loc) {
        return new Truck(loc);

    }

    // returns road image
    WorldImage laneImage(CartPt loc) {


        return new FromFileImage(loc, "p135-road.png");
    }

}

// To represent a lane of cars
class CLane extends ALane {

    CLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed,
            int size, 
            boolean isWater) { 
        super(obstacles, counter, laneNum, rl, speed, size, isWater);
        isWater = false;

    }

    CLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        super(obstacles, counter, laneNum, rl, speed, size);
        this.isWater = false;

    }
    
    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
  */

    // Returns a new car
    AObstacle makeObstacle(CartPt loc) {
        return new Car(loc);

    }

    // Returns the car image
    WorldImage laneImage(CartPt loc) {

        return new FromFileImage(loc, "p135-road.png");
    }

}

// To represent a lane of logs
class LogLane extends ALane {

    LogLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size, 
            boolean isWater) { 
        super(obstacles, counter, laneNum, rl, speed, size, isWater);


    }

    LogLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        super(obstacles, counter, laneNum, rl, speed, size);
        this.isWater = true;

    }
    
    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
  */

    // Returns a new log object
    AObstacle makeObstacle(CartPt loc) {
        return new Log(loc);

    }

    // Returns the water lane image
    WorldImage laneImage(CartPt loc) {

        return new FromFileImage(loc, "p135-waterlane.png");
    }

} 

// To represent a lane of lillypads
class LilLane extends ALane {

    LilLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size, 
            boolean isWater) { 
        super(obstacles, counter, laneNum, rl, speed, size, isWater);
        isWater = true;
    }

    LilLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        super(obstacles, counter, laneNum, rl, speed, size);
        this.isWater = true;

    }
    
    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
  */

    // Returns a new Lillypad
    AObstacle makeObstacle(CartPt loc) {
        return new LillyPad(loc);

    }

    // Returns the lillypad image
    WorldImage laneImage(CartPt loc) {


        return new FromFileImage(loc, "p135-waterlane.png");
    }


}


// To represent a safe lane
class SafeLane extends ALane {

    SafeLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size, 
            boolean isWater) { 
        super(obstacles, counter, laneNum, rl, speed, size, isWater);

    }

    SafeLane(ArrayList<AObstacle> obstacles, 
            int counter, 
            int laneNum,
            boolean rl,
            int speed, 
            int size) { 
        super(obstacles, counter, laneNum, rl, speed, size);
        this.isWater = false;

    }
    
    /* Template:
    Fields:
    ... this.counter ...       -- int
    ... this.laneNum ...       -- int
    ... this.obstacles ...     -- ArrayList<AObstacle>
    ... this.rl ...            -- Boolean
    ... this.speed ...         -- int
    ... this.size ...          -- int
    ... this.isWater ...       -- Boolean
    
    Methods:
    ... this.laneImage(CartPt loc) ...             -- WorldImage
    ... this.makeObstacle(CartPt loc) ...          -- AObstacle
    ... this.isSafe() ...                          -- Boolean
  */

    // to throw a runtime exception
    AObstacle makeObstacle(CartPt loc) {
        throw new RuntimeException("no obstacles in safelane");
    }

    // Return the safe lane image
    WorldImage laneImage(CartPt loc) {

        return new FromFileImage(loc, "p135-safelane.png");
    }

    // Return that it is safe
    boolean isSafe() {
        return true;
    }

}    







