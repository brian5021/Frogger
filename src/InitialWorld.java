import java.util.ArrayList;



public class InitialWorld {

	CartPt frogc = new CartPt(275, 525);
	CartPt truck1c = new CartPt(0, 475);
	CartPt truck2c = new CartPt(190, 475);
	CartPt truck3c = new CartPt(380, 475);
	CartPt car1c = new CartPt(150, 425);
	CartPt car2c = new CartPt(310, 425);
	CartPt car3c = new CartPt(490, 425);
	CartPt truck4c = new CartPt(140, 375);
	CartPt truck5c = new CartPt(330, 375);
	CartPt truck6c = new CartPt(530, 375);
	CartPt car4c = new CartPt(80, 325);
	CartPt car5c = new CartPt(230, 325);
	CartPt car6c = new CartPt(380, 325);
	CartPt lilly1c = new CartPt(80, 225);
	CartPt lilly2c = new CartPt(280, 225);
	CartPt lilly3c = new CartPt(480, 225);
	CartPt log1c = new CartPt(180, 175);
	CartPt log2c = new CartPt(360, 175);
	CartPt log3c = new CartPt(540, 175);
	CartPt lilly4c = new CartPt(40, 125);
	CartPt lilly5c = new CartPt(275, 125);
	CartPt lilly6c = new CartPt(460, 125);
	CartPt log4c = new CartPt(150, 75);
	CartPt log5c = new CartPt(300, 75);
	CartPt log6c = new CartPt(450, 75);
	
	Frog fstart = new Frog(frogc, 0);
	
	AObstacle truck1 = new Truck(truck1c);
	AObstacle truck2 = new Truck(truck2c);
	AObstacle truck3 = new Truck(truck3c);
	AObstacle truck4 = new Truck(truck4c);
	AObstacle truck5 = new Truck(truck5c);
	AObstacle truck6 = new Truck(truck6c);
	
	AObstacle car1 = new Car(car1c);
	AObstacle car2 = new Car(car2c);
	AObstacle car3 = new Car(car3c);
	AObstacle car4 = new Car(car4c);
	AObstacle car5 = new Car(car5c);
	AObstacle car6 = new Car(car6c);
	
	AObstacle lilly1 = new LillyPad(lilly1c);
	AObstacle lilly2 = new LillyPad(lilly2c);
	AObstacle lilly3 = new LillyPad(lilly3c);
	AObstacle lilly4 = new LillyPad(lilly4c);
	AObstacle lilly5 = new LillyPad(lilly5c);
	AObstacle lilly6 = new LillyPad(lilly6c);
	
	AObstacle log1 = new Log(log1c);
	AObstacle log2 = new Log(log2c);
	AObstacle log3 = new Log(log3c);
	AObstacle log4 = new Log(log4c);
	AObstacle log5 = new Log(log5c);
	AObstacle log6 = new Log(log6c);
	
	ArrayList<AObstacle> safeArray = new ArrayList<AObstacle>();
	ArrayList<AObstacle> lane1Array = new ArrayList<AObstacle>();
	AObstacle [] lane1set = {truck1, truck2}; {
    for (AObstacle x: lane1set) 
        lane1Array.add(x);
	}
	ArrayList<AObstacle> lane2Array = new ArrayList<AObstacle>();
	AObstacle [] lane2set = {car1, car2}; {
	    for (AObstacle x: lane2set) 
	        lane2Array.add(x);
		}
	ArrayList<AObstacle> lane3Array = new ArrayList<AObstacle>();
	AObstacle [] lane3set = {truck6, truck5, truck4}; {
	    for (AObstacle x: lane3set) 
	        lane3Array.add(x);
		}
	ArrayList<AObstacle> lane4Array = new ArrayList<AObstacle>();
	AObstacle [] lane4set = {car6, car5}; {
	    for (AObstacle x: lane4set) 
	        lane4Array.add(x);
		}
	ArrayList<AObstacle> lane6Array = new ArrayList<AObstacle>();
	AObstacle [] lane6set = {lilly3, lilly2, lilly1}; {
	    for (AObstacle x: lane6set) 
	        lane6Array.add(x);
		}
	ArrayList<AObstacle> lane7Array = new ArrayList<AObstacle>();
	AObstacle [] lane7set = {log3, log2, log1}; {
	    for (AObstacle x: lane7set) 
	        lane7Array.add(x);
		}
	ArrayList<AObstacle> lane8Array = new ArrayList<AObstacle>();
	AObstacle [] lane8set = {lilly4, lilly5, lilly6}; {
	    for (AObstacle x: lane8set) 
	        lane8Array.add(x);
		}
	ArrayList<AObstacle> lane9Array = new ArrayList<AObstacle>();
	AObstacle [] lane9set = {log4, log5, log6}; {
	    for (AObstacle x: lane9set) 
	        lane9Array.add(x);
		}
	
	
	
	ALane lane0 = new SafeLane(safeArray, 
            0, 
            0,
            true,
            0, 
            50);
	ALane lane1 = new TLane(lane1Array, 
            0, 
            1,
            false,
            2, 
            100);
	ALane lane2 = new CLane(lane2Array, 
            0, 
            2,
            false,
            3, 
            50);
	ALane lane3 = new TLane(lane3Array, 
            0, 
            3,
            true,
            3, 
            100);
	ALane lane4 = new CLane(lane4Array, 
            0, 
            4,
            true,
            4, 
            50);
	ALane lane5 = new SafeLane(safeArray, 
            0, 
            5,
            true,
            0, 
            50);
	ALane lane6 = new LilLane(lane6Array, 
            0, 
            6,
            false,
            3, 
            50);
	ALane lane7 = new LogLane(lane7Array, 
            0, 
            7,
            false,
            2, 
            100);
	ALane lane8 = new LilLane(lane8Array, 
            0, 
            8,
            true,
            4, 
            50);
	ALane lane9 = new LogLane(lane9Array, 
            0, 
            9,
            true,
            2, 
            100);
	ALane lane10 = new SafeLane(safeArray, 
            0, 
            10,
            true,
            0, 
            50);
	
	ArrayList<ALane> allLanes = new ArrayList<ALane>();
	ALane [] allset = {lane0, lane1, lane2, lane3,
			lane4, lane5, lane6, lane7, lane8, lane9, lane10}; {
	    for (ALane x: allset) 
	        allLanes.add(x);
		}
	
	Universe initialWorld = new Universe(3, 0, fstart, allLanes);
}
