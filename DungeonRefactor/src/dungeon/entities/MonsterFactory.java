package dungeon.entities;

import dungeon.enums.Monsters;
import dungeon.enums.Weapons;

public class MonsterFactory {

	public Monster createMonster(Monsters type) {

		if (type == null) {
			throw new IllegalArgumentException("Monster type was null");
		}

		String name = "";
		int hitPoints = 0;
		int attackSpeed = 0;
		double chanceToHit = 0.0;
		double chanceToHeal = 0.0;
		int damageMin = 0;
		int damageMax = 0;
		int minHeal = 0;
		int maxHeal = 0;
		Weapons weapon = Weapons.Club;

		switch (type) {

		case Ogre:
			name = "Oscar the Ogre";
			hitPoints = 200;
			attackSpeed = 2;
			chanceToHit = .6;
			chanceToHeal = .1;
			damageMin = 30;
			damageMax = 50;
			minHeal = 30;
			maxHeal = 50;
			weapon = Weapons.Club;
			break;

		case Skeleton:
			name = "Sargath the Skeleton";
			hitPoints = 100;
			attackSpeed = 3;
			chanceToHit = .8;
			chanceToHeal = .3;
			damageMin = 30;
			damageMax = 50;
			minHeal = 30;
			maxHeal = 50;
			weapon = Weapons.RustyBlade;
			break;

		case Gremlin:
			name = "Gnarltooth the Gremlin";
			hitPoints = 70;
			attackSpeed = 5;
			chanceToHit = .8;
			chanceToHeal = .4;
			damageMin = 15;
			damageMax = 30;
			minHeal = 20;
			maxHeal = 40;
			weapon = Weapons.Kris;
			break;

		case Minotuar:
			name = "Varudak the Minotuar";
			hitPoints = 125;
			attackSpeed = 2;
			chanceToHit = .7;
			chanceToHeal = .2;
			damageMin = 25;
			damageMax = 40;
			minHeal = 20;
			maxHeal = 40;
			weapon = Weapons.GreatAxe;
			break;

		case Bugbear:
			name = "Kesh the Bugbear";
			hitPoints = 90;
			attackSpeed = 4;
			chanceToHit = .8;
			chanceToHeal = .4;
			damageMin = 20;
			damageMax = 40;
			minHeal = 25;
			maxHeal = 45;
			weapon = Weapons.Rapier;
			break;

		default:
			throw new IllegalArgumentException("Monster type is not implemented");

		}

		return new Monster(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal,
				maxHeal, weapon);

	}

}