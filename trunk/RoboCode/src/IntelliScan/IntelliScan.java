package IntelliScan;
import robocode.*;
import java.util.TreeMap;

public class IntelliScan extends Robot{

    public void run() {
	opponentMap = new TreeMap<String, Opponent>();
	while(true){
	    turnGunLeft(360);
	    
	}
    }

    public void onScannedRobot(ScannedRobotEvent e) {
	processRobot(e);
	
	if (opponentMap.get(e.getName()).stationary()){
	    System.out.println(getGunHeading());
	    fire(1);
	}
	
    }
    
    public void processRobot(ScannedRobotEvent e){
	if (!opponentMap.containsKey(e.getName()))
	    opponentMap.put(e.getName(), new Opponent(e.getName(), e.getBearing(), e.getHeading(), e.getVelocity(), e.getEnergy()));
	else{
	    opponentMap.get(e.getName()).setBearing(e.getBearing());
	    opponentMap.get(e.getName()).setHeading(e.getHeading());
	    opponentMap.get(e.getName()).setVelocity(e.getVelocity());
	    opponentMap.get(e.getName()).setEnergy(e.getEnergy());
	}
	
    }

    public void onHitByBullet(HitByBulletEvent e) {
	turnLeft(90 - e.getBearing());
    }	
    
    private TreeMap<String, Opponent> opponentMap;
}