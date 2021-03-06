package dumb;

import robocode.HitWallEvent;
//import org.opencv.core.Core;
import robocode.ScannedRobotEvent;

public class DumbBot extends InfoBot {
	private Gun gun;
	private Movement movement;
	private Radar radar;
	
	public void init() {
		super.init();
		gun = new Gun(this);
		movement = new Movement(this);
		radar = new Radar(this);
	}
	
	public void run() {
		init();
		while (true) {
			radar.run();
			gun.run();
			movement.run();
			execute();
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		radar.onScannedRobot(e);
	}
	
	public void onHitWall(HitWallEvent e) {
		movement.onHitWall(e);
	}
}
