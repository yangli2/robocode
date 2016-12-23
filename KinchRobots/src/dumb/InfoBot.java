package dumb;

import java.util.*;
import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class InfoBot extends AdvancedRobot {
	public static final int GUN = 0;
	public static final int MOVEMENT = 1;
	public static final int RADAR = 2;
	
	public Vector<BotInfo> enemies;
	
	public void init() {
		clear();
		enemies.add(new BotInfo());
	}
	
	public void clear() {
		enemies = new Vector<BotInfo>();
		gunDiff = 0.0;
		pointingAtEnemy = false;
	}
	
	public void updateEnemyInfo(ScannedRobotEvent e) {
		enemies.get(0).angleFromFront = e.getBearingRadians();
		enemies.get(0).angleFromGun = getHeadingRadians() + e.getBearingRadians()
				- getGunHeadingRadians();
		enemies.get(0).distance = e.getDistance();
		enemies.get(0).energy = e.getEnergy();
	}

	public double gunDiff = 0.0;
	public boolean pointingAtEnemy = false;
}
