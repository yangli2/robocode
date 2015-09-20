package dumb;

public class Movement {
	private InfoBot bot;
	
	public Movement(InfoBot newBot) {
		bot = newBot;
        bot.setAdjustGunForRobotTurn(true);
        bot.setAdjustRadarForGunTurn(true);
	}
	
	public void run() {
		if (bot.infos[InfoBot.GUN].info > 0) {
			bot.ahead(10);
			bot.infos[InfoBot.GUN].info = 0; 
		} else if (bot.infos[InfoBot.RADAR].info > 0) {
			bot.turnLeft(90);
			bot.ahead(10);
			bot.infos[InfoBot.RADAR].info = 0;
		}
	}
}
