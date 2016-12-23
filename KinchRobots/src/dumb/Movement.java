package dumb;

import java.util.Vector;
import java.util.Random;
import robocode.HitWallEvent;
import robocode.util.Utils;

public class Movement {
	private static final double PI_OVER_TWO = 1.5707963267948966;
	//private static final double PI = 2 * PI_OVER_TWO;
	
	public Movement(InfoBot newBot) {
		bot = newBot;
        bot.setAdjustGunForRobotTurn(true);
        bot.setAdjustRadarForGunTurn(true);
        rng = new Random();
	}
	
	public void run() {
		double turningAngle = Utils.normalRelativeAngle(
				bot.enemies.get(0).angleFromFront	+ PI_OVER_TWO);
		bot.setTurnLeftRadians(turningAngle);
		bot.setAhead(rng.nextInt(20) * sheerDirection);
		if (rng.nextInt(100) < 1) {
			sheerDirection *= -1;
		}
	}
	
	public void onHitWall(HitWallEvent e) {
		sheerDirection *= -1;
	}
	
	//private double distanceToWall = 0;
	private double sheerDirection = 1;
	private InfoBot bot;
	private Random rng;
}
