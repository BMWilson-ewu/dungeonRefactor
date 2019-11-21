package builders;

import heros.Hero;
import heros.HeroType;
import heros.Sorceress;
import heros.Thief;
import heros.Warrior;

public class HeroFactory {

	public Hero createHero(int choice) {
		
		String name;
		int hitPoints;
		int attackSpeed;
		double chanceToHit;
		int damageMin;
		int damageMax;
		double chanceToBlock;
		HeroType type;

		switch (choice) {
		case 1:
			name = "Warrior";
			hitPoints = 125;
			attackSpeed = 4;
			chanceToHit = .8;
			damageMin = 35;
			damageMax = 60;
			chanceToBlock = .2;
			type = HeroType.WARRIOR;

			return new Warrior(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);

		case 2:
			name = "Thief";
			hitPoints = 75;
			attackSpeed = 6;
			chanceToHit = .8;
			damageMin = 20;
			damageMax = 40;
			chanceToBlock = .5;
			type = HeroType.THIEF;

			return new Thief(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);

		case 3:
			name = "Sorceress";
			hitPoints = 75;
			attackSpeed = 5;
			chanceToHit = .7;
			damageMin = 25;
			damageMax = 50;
			chanceToBlock = .3;
			type = HeroType.SORCERESS;
			return new Sorceress(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);
		default:
			throw new IllegalArgumentException("A Hero Type must be chosen.");
		}
	}

}
