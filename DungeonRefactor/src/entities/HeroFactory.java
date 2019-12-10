package entities;
import specials.*;
import weapons.*;

public class HeroFactory {

	public Hero createHero(String type) {

		if (type.equals("Warrior")) {
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2, new CrushingBlow(), new GreatSword());
		} else if (type.equals("Sorceress")) {
			return new Hero("Sorceress", 75, 5, .7, 25, 50, .3, new HeroHeal(), new FireStaff());
		} else if (type.equals("Thief")) {
			return new Hero("Thief", 75, 6, .8, 20, 40, .5, new SneakAttack(), new Dagger());
		} else if (type.equals("Paladin")) {
			return new Hero("Paladin", 140, 3, .6, 40, 60, .2, new Smite(), new Flail());
		} else if (type.equals("Ranger")) {
			return new Hero("Ranger", 80, 5, .8, 30, 55, .4, new TwinStrike(), new ShortBow());
		} else {
			System.out.println("Unexpected input, returning a Warrior...");
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2, new CrushingBlow(), new GreatSword());
		}
	}

}
