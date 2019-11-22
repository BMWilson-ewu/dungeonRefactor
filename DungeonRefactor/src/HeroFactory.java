import weapons.Dagger;
import weapons.FireStaff;
import weapons.GreatSword;

public class HeroFactory {

	public Hero createHero(String type) {

		if (type.equals("Warrior")) {
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2, new CrushingBlow(), new GreatSword());
		} else if (type.equals("Sorceress")) {
			return new Hero("Sorceress", 75, 5, .7, 25, 50, .3, new HeroHeal(), new FireStaff());
		} else if (type.equals("Thief")) {
			return new Hero("Thief", 75, 6, .8, 20, 40, .5, new SneakAttack(), new Dagger());
		} else {
			System.out.println("Unexpected input, returning a Warrior...");
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2, new CrushingBlow(), new GreatSword());
		}
	}

}
