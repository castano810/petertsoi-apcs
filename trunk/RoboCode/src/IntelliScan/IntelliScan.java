package IntelliScan;
import robocode.*;

public class IntelliScan extends Robot{

    public void run() {
	while(true){
	    ahead(100);
	}
    }

    public void onScannedRobot(ScannedRobotEvent e) {
	fire(1);
    }

    public void onHitByBullet(HitByBulletEvent e) {
	turnLeft(90 - e.getBearing());
    }	
}