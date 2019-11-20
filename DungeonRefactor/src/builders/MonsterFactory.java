package builders;

import monsters.Gremlin;
import monsters.Monster;
import monsters.MonsterType;
import monsters.Ogre;
import monsters.Skeleton;

public class MonsterFactory {

	public Monster createMonster(int choice) {
		String name;
		int hitPoints;
		int attackSpeed;
		double chanceToHit;
		double chanceToHeal;
		int damageMin;
		int damageMax;
		int minHeal;
		int maxHeal;
		MonsterType type;

		switch (choice) {
		case 1:
			name = "Gnarltooth the Gremlin";
			hitPoints = 70;
			attackSpeed = 5;
			chanceToHit = .8;
			chanceToHeal = .4;
			damageMin = 15;
			damageMax = 30;
			minHeal = 20;
			maxHeal = 40;
			type = MonsterType.GREMLIN;

			return new Gremlin(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal,
					maxHeal, type);

		case 2:
			name = "Oscar the Ogre";
			hitPoints = 200;
			attackSpeed = 2;
			chanceToHit = .6;
			chanceToHeal = .1;
			damageMin = 30;
			damageMax = 50;
			minHeal = 30;
			maxHeal = 50;
			type = MonsterType.OGRE;

			return new Ogre(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal,
					maxHeal, type);

		case 3:
			name = "Sargath the Skeleton";
			hitPoints = 100;
			attackSpeed = 3;
			chanceToHit = .8;
			chanceToHeal = .3;
			damageMin = 30;
			damageMax = 50;
			minHeal = 30;
			maxHeal = 50;
			type = MonsterType.SKELETON;
			return new Skeleton(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal,
					maxHeal, type);
		default:
			throw new IllegalArgumentException("A Monster Type must be chosen.");
		}
	}

}
