
// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc

import javalib.worldcanvas.WorldCanvas;
import javax.swing.*;


// test the display of images for the frogger and run the game
public class GameRunner{
  
  InitialWorld init = new InitialWorld();
  Universe start = init.initialWorld;
  

  WorldCanvas c1 = new WorldCanvas(550, 550);
  WorldCanvas c2 = new WorldCanvas(550, 550);
  
  /* Template:
  Fields: 
  Methods:
  ... this.run() ...                   -- Boolean
  ... this.main(String [] argv) ...    -- static void
*/

  
  
  // Its impossible/unneccessary to have to run tests on game runner
  // run the game
  boolean run() {
      return this.start.bigBang(550, 550, .1);    
  }
  
  // invoke this method to run the apple orchard game
  public static void main(String [] argv) {
    GameRunner aor = new GameRunner();
    aor.run();
  }
  
}