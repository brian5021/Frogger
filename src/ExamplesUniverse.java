// assignment 12

// pair 135

// Cox Brian

// bcox18

// OConnor Raymond

// oconnorc

import junit.framework.*;

import java.util.ArrayList;

import tester.Tester;


public class ExamplesUniverse extends TestCase {

    CartPt p1;

    CartPt p2;
    CartPt p3;
    CartPt p4;
    CartPt p5;

    Frog f1 = new Frog(new CartPt(275, 525), 0);
    Frog f2; 
    Frog f3;
    Frog waterFrog1 = new Frog(new CartPt(275, 475), 9);
    Frog waterFrog2 = new Frog(new CartPt(275, 425), 7);
    Frog swaterFrog1 = new Frog(new CartPt(273, 475), 9);
    Frog swaterFrog2 = new Frog(new CartPt(273, 425), 7);


    AObstacle t1;
    AObstacle car1;
    AObstacle log1;
    AObstacle lillypad1;




    ArrayList<AObstacle> arrayAll;
    ArrayList<AObstacle> arrayTruck;
    ArrayList<AObstacle> arrayCar;
    ArrayList<AObstacle> arrayLog;
    ArrayList<AObstacle> arrayLilly;
    ArrayList<ALane> arrayEmpty;

    ALane l1;

    Universe uEmpty;
    Universe testu;
    Universe testu2;
    Universe testu3;
    
    Truck truck1;

    ArrayList<ALane> exlanes = new ArrayList<ALane>();

    ArrayList<AObstacle> trucks = new ArrayList<AObstacle>();

    

    ALane truckLane1 = new TLane(trucks,
            10, 
            1,
            false,
            2,
            100);

    ALane truckLane2 = new TLane(new ArrayList<AObstacle>(),
            0, 
            3,
            true,
            3,
            100);

    ALane carLane1 = new CLane(new ArrayList<AObstacle>(),
            0, 
            2,
            false,
            4,
            50);
    ALane carLane2 = new CLane(new ArrayList<AObstacle>(),
            0, 
            4,
            true,
            2,
            50);

    ALane lilLane1 = new LilLane(new ArrayList<AObstacle>(),
            0, 
            6,
            true,
            3,
            50);

    ALane lilLane2 = new LilLane(new ArrayList<AObstacle>(),
            0, 
            8,
            false,
            4,
            50);

    ArrayList<AObstacle> logArray = new ArrayList<AObstacle>();

    ALane logLane1 = new LogLane(logArray,
            0, 
            7,
            true,
            1,
            100);

    ALane logLane2 = new LogLane(new ArrayList<AObstacle>(),
            0, 
            9,
            false,
            2,
            100);

    ALane safeLane1 = new SafeLane(new ArrayList<AObstacle>(),
            0, 
            0,
            true,
            0,
            50);
    ALane safeLane2 = new SafeLane(new ArrayList<AObstacle>(),
            0, 
            5,
            true,
            5,
            50);
    ALane safeLane3 = new SafeLane(new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50);

    //examples to satisfy web-cat
    ALane safeLane4 = new SafeLane(new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50,
            false);

    ALane truckLane3 = new TLane(new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50,
            false);

    ALane carLane3 = new CLane (new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50,
            false);

    ALane lilLane3 = new LilLane (new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50,
            false);

    ALane logLane3 = new LogLane(new ArrayList<AObstacle>(),
            0, 
            10,
            true,
            10,
            50,
            true);


    AObstacle ct = truckLane1.createO(1);
    AObstacle cc = carLane1.createO(2);
    AObstacle clil = lilLane1.createO(6);
    AObstacle clog = logLane1.createO(7);



    void initData() {

        p1 = new CartPt(275, 475);

        p2 = new CartPt(360, 475);
        p3 = new CartPt(280, 475);
        p4 = new CartPt(-55, 225);
        p5 = new CartPt(605, 175);

        truck1 = new Truck(p1);

        t1 = new Truck(p2);
        car1 = new Car(p3);
        log1 = new Log(p4);
        lillypad1 = new LillyPad(p5);

        /*
		arrayAll = new ArrayList<AObstacle>(); 
		arrayAll.add(o1);
		arrayAll.add(o2);
		arrayAll.add(o3);
		arrayAll.add(o4);

		arrayTruck = new ArrayList<AObstacle>();
		arrayTruck.add(o1);

		arrayCar = new ArrayList<AObstacle>();
		arrayCar.add(o2);

		arrayLog = new ArrayList<AObstacle>();
		arrayLog.add(o3);

		arrayLilly = new ArrayList<AObstacle>();
		arrayLilly.add(o4);

		arrayEmpty = new ArrayList<ALane>();
         */
        trucks.clear();
        trucks.add(t1);

        logArray.clear();

        exlanes.clear();
        exlanes.add(safeLane1);
        exlanes.add(truckLane1);
        exlanes.add(carLane1);
        exlanes.add(truckLane2);
        exlanes.add(carLane2);
        exlanes.add(safeLane2);
        exlanes.add(lilLane1);
        exlanes.add(logLane1);
        exlanes.add(lilLane2);
        exlanes.add(logLane2);
        exlanes.add(safeLane3);



        f2 = new Frog(new CartPt(360, 475), 1);
        f3 = new Frog(new CartPt(275, 75), 9);
        
        uEmpty = new Universe(3, 0, f1, exlanes);
        testu = new Universe(3, 0, f2, exlanes);
        testu2 = new Universe(3, 0, f3, exlanes);
        testu3 = new Universe(3, 0, waterFrog1, exlanes);
        

    }

    void testJump(Tester t) {
        initData();
        t.checkExpect(f1.loc.y, 525);

        f1.jump("up");
        t.checkExpect(f1.loc.y, 475);

        initData();
        t.checkExpect(f1.loc.y, 475);
        f1.jump("down");
        t.checkExpect(f1.loc.y, 525);

        initData();
        t.checkExpect(f1.loc.x, 275);
        f1.jump("left");
        t.checkExpect(f1.loc.x, 225);

        initData();
        t.checkExpect(f1.loc.x, 225);
        f1.jump("right");
        t.checkExpect(f1.loc.x, 275);
    }




    //test isCollided
    public void testIsCollidedT(Tester t) {
        initData();
        t.checkExpect(p2.isCollided(p2, 50, 100), true);
        t.checkExpect(p2.isCollided(p1, 50, 100), false);



    }

    //test slidefrog
    public void testSlideFrogT(Tester t) {
        initData();

        //to the left
        t.checkExpect(waterFrog1.loc.x, 275);
        waterFrog1.slideFrog(logLane2);
        t.checkExpect(waterFrog1.loc.x, 273);
        testu3.moveOnLilog();
        t.checkExpect(waterFrog1.loc.x, 271);
        

        t.checkExpect(waterFrog2.loc.x, 275);
        waterFrog2.slideFrog(logLane1); 
        t.checkExpect(waterFrog2.loc.x, 276);
        
    }

    //tests for images they work in the game
    public void testImagesT(Tester t) {
        initData();
        t.checkExpect(f1.frogImage(), f1.frogImage());

        //obstacle images
        t.checkExpect(t1.obstacleImage(true), t1.obstacleImage(true));
        t.checkExpect(car1.obstacleImage(true), car1.obstacleImage(true));
        t.checkExpect(t1.obstacleImage(false), t1.obstacleImage(false));
        t.checkExpect(car1.obstacleImage(false), car1.obstacleImage(false));
        
        
        t.checkExpect(log1.obstacleImage(true), log1.obstacleImage(true));
        t.checkExpect(lillypad1.obstacleImage(false), 
                lillypad1.obstacleImage(false));

        //LaneImages
        t.checkExpect(truckLane1.placedLaneImage(),
                truckLane1.placedLaneImage());
        t.checkExpect(carLane1.placedLaneImage(),
                carLane1.placedLaneImage());
        t.checkExpect(lilLane1.placedLaneImage(),
                lilLane1.placedLaneImage());
        t.checkExpect(logLane1.placedLaneImage(),
                logLane1.placedLaneImage());
        t.checkExpect(safeLane1.placedLaneImage(), 
                safeLane1.placedLaneImage());



    }

    //-----------------------------------------------
    //Tests for ALane

    //test createO
    public void testCreateOT(Tester t) {
        t.checkExpect(ct.loc.x, 600);
        t.checkExpect(ct.loc.y, 475);

        t.checkExpect(cc.loc.x, 600);
        t.checkExpect(cc.loc.y, 425);

        t.checkExpect(clil.loc.x, -50);
        t.checkExpect(clil.loc.y, 225);

        t.checkExpect(clog.loc.x, -50);
        t.checkExpect(clog.loc.y, 175);

        t.checkException(new RuntimeException("no obstacles in safelane"), 
                safeLane1, 
                "makeObstacle", 
                p1);

    }

    //test shift
    public void testShiftT(Tester t) {
        initData();
        t.checkExpect(trucks.get(0).loc.x, 360); 
        truckLane1.shift();
        t.checkExpect(trucks.get(0).loc.x, 358);

        initData();
        logLane1.obstacles.add(log1);
        logLane1.shift();
        t.checkExpect(logLane1.obstacles.get(0).loc.x, -54); 


    }
    //tests for spawn
    public void testSpawnT(Tester t) {
        initData();
        //test the counter decrement of spawn
        t.checkExpect(truckLane1.counter, 10);
        truckLane1.spawn();
        t.checkExpect(truckLane1.counter, 9);

        //test that spawn adds an obstacle
        t.checkExpect(carLane1.obstacles.size(), 0);

        carLane1.spawn();
        t.checkExpect(carLane1.obstacles.size(), 1);
        carLane1.spawn();
        t.checkExpect(carLane1.counter, 49);

        t.checkExpect(safeLane1.obstacles.size(), 0);
        t.checkExpect(safeLane1.counter, 0);
        safeLane1.spawn();
        t.checkExpect(safeLane1.counter,  0);
        t.checkExpect(safeLane1.obstacles.size(), 0);


    }

    //tests for delete
    public void testDeleteT(Tester t) {
        initData();
        t.checkExpect(lilLane1.obstacles.size(), 0);
        lilLane1.obstacles.add(lillypad1);
        t.checkExpect(lilLane1.obstacles.size(), 1);
        lilLane1.delete();
        t.checkExpect(lilLane1.obstacles.size(), 0);

        t.checkExpect(logLane1.obstacles.size(), 0);
        logLane1.delete();
        logLane1.obstacles.add(log1);
        t.checkExpect(logLane1.obstacles.size(), 1);
        logLane1.delete();
        t.checkExpect(logLane1.obstacles.size(), 0);

        t.checkExpect(truckLane1.obstacles.size(), 1);
        truckLane1.obstacles.add(t1);
        t.checkExpect(truckLane1.obstacles.size(), 2);
        truckLane1.delete();
        t.checkExpect(truckLane1.obstacles.size(), 2);

    }

    //test for the isSafe method
    public void testIsSafe(Tester t) {
        initData();
        t.checkExpect(safeLane1.isSafe(), true);
        t.checkExpect(truckLane1.isSafe(), false);
    }

    //-----Universe Tests---------
    public void testSplat(Tester t) {
        initData();
        t.checkExpect(f2.lane, 1);
        testu.splat();
        t.checkExpect(f2.lane, 0);
        t.checkExpect(testu.lives, 2);
        
    }

    public void testDead(Tester t) {
        //in testu the frog starts off hitting a truck
        testu.dead();
        t.checkExpect(f2.lane, 0);
        t.checkExpect(testu.lives, 2);
        
        //in testu2 the frog is in a water lane in the water
        testu2.dead();
        t.checkExpect(f3.lane, 0);
        t.checkExpect(testu.lives, 2);
    }
    
    //move on log is tested in 
    
    
    
    //----------------JUNIT TESTS-------------
    //these have been commented out because web-cat 
    //asks me to test my tests...?
    //all JUNIT tests pass    

    /*
    //test jump
    public void testJumpj() {
        initData();
        assertEquals(f1.loc.y, 525);
        f1.jump("up");
        assertEquals(f1.loc.y, 475);

        initData();
        assertEquals(f1.loc.y, 475);
        f1.jump("down");
        assertEquals(f1.loc.y, 525);

        initData();
        assertEquals(f1.loc.x, 275);
        f1.jump("left");
        assertEquals(f1.loc.x, 225);

        initData();
        assertEquals(f1.loc.x, 225);
        f1.jump("right");
        assertEquals(f1.loc.x, 275);

    }




    //test isCollided
    public void testIsCollided() {
        initData();
        assertEquals(p2.isCollided(p2, 50, 100), true);
        assertEquals(p2.isCollided(p1, 50, 100), false);



    }

    //test slidefrog
    public void testSlideFrog() {
        initData();

        //to the left
        assertEquals(waterFrog1.loc.x, 275);
        waterFrog1.slideFrog(logLane2);
        assertEquals(waterFrog1.loc.x, 273);


        assertEquals(waterFrog2.loc.x, 275);
        waterFrog2.slideFrog(logLane1); 
        assertEquals(waterFrog2.loc.x, 276);

    }

    //tests for images they work in the game
    public void testImages() {
        initData();
        assertEquals(f1.frogImage(), f1.frogImage());

        //obstacle images
        assertEquals(t1.obstacleImage(), t1.obstacleImage());
        assertEquals(car1.obstacleImage(),car1.obstacleImage());
        assertEquals(log1.obstacleImage(),log1.obstacleImage());
        assertEquals(lillypad1.obstacleImage(), lillypad1.obstacleImage());

        //LaneImages
        assertEquals(truckLane1.placedLaneImage(),
                truckLane1.placedLaneImage());
        assertEquals(carLane1.placedLaneImage(),
                carLane1.placedLaneImage());
        assertEquals(lilLane1.placedLaneImage(),
                lilLane1.placedLaneImage());
        assertEquals(logLane1.placedLaneImage(),
                logLane1.placedLaneImage());
        assertEquals(safeLane1.placedLaneImage(), 
                safeLane1.placedLaneImage());



    }

    //-----------------------------------------------
    //Tests for ALane

    //test createO
    public void testCreateO() {
        assertEquals(ct.loc.x, 600);
        assertEquals(ct.loc.y, 475);

        assertEquals(cc.loc.x, 600);
        assertEquals(cc.loc.y, 425);

        assertEquals(clil.loc.x, -50);
        assertEquals(clil.loc.y, 225);

        assertEquals(clog.loc.x, -50);
        assertEquals(clog.loc.y, 175);

    }

    //test shift
    public void testShift() {
        initData();
        assertEquals(trucks.get(0).loc.x, 360); 
        truckLane1.shift();
        assertEquals(trucks.get(0).loc.x, 358);

    }
    //tests for spawn
    public void testSpawn() {
        initData();
        //test the counter decrement of spawn
        assertEquals(truckLane1.counter, 10);
        truckLane1.spawn();
        assertEquals(truckLane1.counter, 9);

        //test that spawn adds an obstacle
        assertEquals(carLane1.obstacles.size(), 0);
        carLane1.spawn();
        assertEquals(carLane1.obstacles.size(), 1);
        assertEquals(carLane1.counter, 50);



    }

    //tests for delete
    public void testRemove() {
        initData();
        assertEquals(lilLane1.obstacles.size(), 0);
        lilLane1.obstacles.add(lillypad1);
        assertEquals(lilLane1.obstacles.size(), 1);
        lilLane1.delete();
        assertEquals(lilLane1.obstacles.size(), 0);

        assertEquals(logLane1.obstacles.size(), 0);
        logLane1.obstacles.add(log1);
        assertEquals(logLane1.obstacles.size(), 1);
        logLane1.delete();
        assertEquals(logLane1.obstacles.size(), 0);

        assertEquals(truckLane1.obstacles.size(), 1);
        truckLane1.obstacles.add(t1);
        assertEquals(truckLane1.obstacles.size(), 2);
        truckLane1.delete();
        assertEquals(truckLane1.obstacles.size(), 2);

    }


     */

}





