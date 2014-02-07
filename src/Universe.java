// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc


import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javalib.funworld.World;
import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;

// To represent the game universe
public class Universe extends World{

    int lives; 
    int score;
    Frog frog;
    ArrayList<ALane> lanes;
    int bLOCKSIZE = 50; // pixels
    int height = 550; // pixels
    int width = 550; // pixels
    
    
    Universe(int lives, int score, Frog frog, ArrayList<ALane> lanes) {
        this.lives = lives;
        this.score = score;
        this.frog = frog;
        this.lanes = lanes;
        
    }
    
    /* Template:
    Fields:
    ... this.lives ...     -- int
    ... this.score ...     -- int
    ... this.frog ...      -- Frog
    ... this.lanes ...     -- ArrayList<Alane>
    
    Methods:
    ... this.lastImage() ...             -- WorldImage
    ... this.moveObjects() ...           -- void
    ... this.moveOnLilog() ...           -- void
    ... this.splat() ...                 -- void
    ... this.dead() ...                  -- void
    ... this.win() ...                   -- void
    ... this.onKeyEvent(String ke) ...   -- World
    ... this.onTick() ...                -- World
    ... this.worldEnds() ...             -- WorldEnd
    ... this.gameOverImage() ...         -- WorldImage
    ... this.makeImage() ...             -- WorldImage
  */
    
    //game over screen  
    public WorldImage lastImage() {
        return this.makeImage().overlayImages(this.gameOverImage(),
            new TextImage( new Posn(width / 2, height - (height / 3)),    
                    "FINAL SCORE:" + score, 
                    Color.red));
      }
    
    
    //HANDLES LANES
    //moves every object in lanes for the onticker
    //creates new objects
    //removes old objects
    //moves the frog if on a lillypad or 
    void moveObjects() {

        this.dead();
        this.moveOnLilog();
        this.win();

        
        for (ALane l : this.lanes) {
            
            l.shift();
            l.spawn();
            l.delete();
            
        }
        
    }
    
    
    // Allows the frog to land on lilly and be moved in the direction
    // the lilly is moving
    void moveOnLilog() {
        ALane frogLane = this.lanes.get(this.frog.lane);
        if (frogLane.isWater &&  this.frog.isCollided(frogLane)) {
            
            this.frog.slideFrog(frogLane);
        }
        
    }

    //kills the frog and resets the game with one less life
    public void splat() {
        this.frog.loc = new CartPt(width / 2, height - (bLOCKSIZE / 2));
        this.lives = this.lives - 1;
        this.frog.lane = 0;
    }
   
    
    
    //checks to see if the frog has hit a car of fallen into the water
    public void dead() {
        ALane frogLane = this.lanes.get(this.frog.lane);
       
        
        
        if (
                //the frog is in a water lane and not on an object
                (frogLane.isWater && !(this.frog.isCollided(frogLane))) ||
                
                //the frog is not in a water lane, but is colliding 
                //with an object
                (!(frogLane.isWater) && this.frog.isCollided(frogLane))) {
                
                //then the frog dies
                this.splat();
        } 
        
        
    }
    
    // This is the scoring condition of the game. 
    public void win() {
        if (this.frog.lane >= 10) {
            this.frog.loc = new CartPt(width / 2, height - (bLOCKSIZE / 2));
            this.frog.lane = 0;
            this.score++;
        }
    }
    
    
    
Color white = new Color(100, 255, 255);
    // Background of game
    WorldImage background = 
            new RectangleImage(new CartPt (width / 2, height / 2) ,
                    width, height, white);
        
    
    
    //Moves the frog in the World based on which key is pressed
    public World onKeyEvent(String ke) {
        
        this.frog.jump(ke);
        //if the frog jumps off screen the player goes splat
        if (this.frog.loc.offScreen()) {
            this.splat();
        }
        
        return this;         
    }
    
    
    
    
    
    
    
    //on each tick, the objects move and if the frog is on a log or lilly
    //he will shift with the lane
    public World onTick() {
        this.moveObjects();
        
        return this;
    
    }    
    
    // After each tick, check if the Ship hit a block - 
    // if yes, end the game
    public WorldEnd worldEnds() {
        if (this.lives <= 0) { 
             
            return new WorldEnd (true, this.lastImage());
        } else {
            return (new WorldEnd(false, this.makeImage()));
        }
    }
        
    // Image at the game over screen
    WorldImage gameOverImage() {
        
        return new FromFileImage(new CartPt(width / 2, height / 2),
                "p135-gameover.png");

    }   
    
    
    
   
    
    
    
    //Displays the images for all elements, including score counter
    public WorldImage makeImage() {
         
        WorldImage temp = background;
        
        //creates the background by laying the lane images over the background
        for (ALane lane : this.lanes) {
            temp = temp.overlayImages(lane.placedLaneImage());
        }
        
        //adds the objects to the now developed background
        for (ALane lane : this.lanes) {
            for (AObstacle ao : lane.obstacles) {
                temp = temp.overlayImages(ao.obstacleImage(lane.rl));
            }

        }
    
        //displays the score in the upper right hand corner
        temp = temp.overlayImages(new TextImage(new Posn(510, 25),  
                "score:" + this.score, Color.white));
        
        //displays the lives to the left of the score
        temp = temp.overlayImages(new TextImage(new Posn(460, 25),  
                "lives:" + this.lives, Color.white));
        
        //lays frog image down last
        temp = temp.overlayImages(this.frog.frogImage());
        
        return temp;
    }
            
            
       
    //game over screen  
   
    /*public WorldImage lastImage() {
        return this.makeImage().overlayImages(this.gameOverImage(),
            new TextImage( new Posn(width / 2, height - 75), 
                    "FINAL SCORE:" + score, 
                    Color.red));
      }
    */

}    
    

