package dumb;

import robocode.AdvancedRobot;

public class InfoBot extends AdvancedRobot {
	public static final int NUM_PARTS = 3;
	public static final int GUN = 0;
	public static final int MOVEMENT = 1;
	public static final int RADAR = 2;
	
	public Info infos[];
	
	public void init() {
		infos = new Info[NUM_PARTS];
		for (int i = 0; i < NUM_PARTS; i++) {
			infos[i] = new Info();
		}
		clear();
	}
	
	public void clear() {
		for (int i = 0; i < NUM_PARTS; i++) {
			infos[i].info = 0;
		}
	}
}
