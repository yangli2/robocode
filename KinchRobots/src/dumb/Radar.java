package dumb;

import robocode.ScannedRobotEvent;
import robocode.util.Utils;

public class Radar {
	private InfoBot bot;
	
	public Radar(InfoBot newBot) {
		bot = newBot;
        bot.setAdjustGunForRobotTurn(true);
        bot.setAdjustRadarForGunTurn(true);
		bot.setTurnRadarLeftRadians(Double.POSITIVE_INFINITY);
	}

	public void run() {
//		bot.scan();
	}
	
	public void onScannedRobot(ScannedRobotEvent e){
		double radarTurn =
	        // Absolute bearing to target
	        bot.getHeadingRadians() + e.getBearingRadians()
	        // Subtract current radar heading to get turn required
	        - bot.getRadarHeadingRadians();
	 
	    bot.setTurnRadarRightRadians(1.9*Utils.normalRelativeAngle(radarTurn));
	    bot.infos[InfoBot.RADAR].info = bot.getRadarHeadingRadians() -
	    		bot.getGunHeadingRadians();
	}
}
