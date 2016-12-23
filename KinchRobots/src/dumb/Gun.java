package dumb;

public class Gun {
	private InfoBot bot;
	
	public Gun(InfoBot newBot) {
		bot = newBot;
        bot.setAdjustGunForRobotTurn(true);
        bot.setAdjustRadarForGunTurn(true);
	}
	
	public void run() {
		if (Math.abs(bot.gunDiff) < 0.1) {
			bot.setTurnGunRightRadians(bot.gunDiff);
			bot.setFire(1);
    		bot.pointingAtEnemy = true;
        } else {
        	bot.setTurnGunRightRadians(bot.gunDiff);
        }
	}
}
