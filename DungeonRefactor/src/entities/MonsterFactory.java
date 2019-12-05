package entities;
import weapons.Club;
import weapons.Kris;
import weapons.RustyBlade;

public class MonsterFactory {
	public Monster createMonster(String type) {

		if (type.equals("Ogre")) {
			return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, new Club());
		} else if (type.equals("Skeleton")) {
			return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50, new RustyBlade());
		} else if (type.equals("Gremlin")) {
			return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40, new Kris());
		} else {
			System.out.println("Unexpected input, returning an Ogre...");
			return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, new Club());
		}
	}
}
