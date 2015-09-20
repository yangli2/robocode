package dumb;

public class Gun {
	private InfoBot bot;
	
	public Gun(InfoBot newBot) {
		bot = newBot;
        bot.setAdjustGunForRobotTurn(true);
        bot.setAdjustRadarForGunTurn(true);
	}
	
	public void run() {
		double gunDiff = bot.infos[InfoBot.RADAR].info;
		if (Math.abs(gunDiff) < 0.1) {
			bot.turnGunRightRadians(gunDiff);
			bot.fire(1);
    		bot.infos[InfoBot.GUN].info = 1;
        } else {
        	bot.turnGunRightRadians(gunDiff);
        }
	}
}
