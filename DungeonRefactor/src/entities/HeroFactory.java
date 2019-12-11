package entities;

import enums.Abilities;
import enums.Heros;
import enums.Weapons;

public class HeroFactory {

	public Hero createHero(Heros type) {

		if (type == null) {
			throw new IllegalArgumentException("Hero type was null");
		}

		String name = "";
		int hitPoints = 0;
		int attackSpeed = 0;
		double chanceToHit = 0.0;
		int damageMin = 0;
		int damageMax = 0;
		double chanceToBlock = 0.0;
		Abilities ability = Abilities.CrushingBlow;
		Weapons weapon = Weapons.Club;

		switch (type) {

		case Warrior:
			name = "Warrior";
			hitPoints = 125;
			attackSpeed = 4;
			chanceToHit = .8;
			damageMin = 35;
			damageMax = 60;
			chanceToBlock = .2;
			ability = Abilities.CrushingBlow;
			weapon = Weapons.GreatSword;
			break;

		case Sorceress:
			name = "Sorceress";
			hitPoints = 75;
			attackSpeed = 5;
			chanceToHit = .7;
			damageMin = 25;
			damageMax = 50;
			chanceToBlock = .3;
			ability = Abilities.HeroHeal;
			weapon = Weapons.FireStaff;
			break;

		case Thief:
			name = "Thief";
			hitPoints = 75;
			attackSpeed = 6;
			chanceToHit = .8;
			damageMin = 20;
			damageMax = 40;
			chanceToBlock = .5;
			ability = Abilities.SneakAttack;
			weapon = Weapons.Dagger;
			break;

		case Paladin:
			name = "Paladin";
			hitPoints = 140;
			attackSpeed = 3;
			chanceToHit = .6;
			damageMin = 40;
			damageMax = 60;
			chanceToBlock = .2;
			ability = Abilities.Smite;
			weapon = Weapons.Flail;
			break;

		case Ranger:
			name = "Ranger";
			hitPoints = 80;
			attackSpeed = 5;
			chanceToHit = .8;
			damageMin = 30;
			damageMax = 55;
			chanceToBlock = .4;
			ability = Abilities.TwinStrike;
			weapon = Weapons.ShortBow;
			break;
			
		case Floridaman:
			name = "Florida man";
			hitPoints = 9999999;
			attackSpeed = 100;
			chanceToHit = 1;
			damageMin = 500;
			damageMax = 1000;
			chanceToBlock = 1;
			ability = Abilities.Smite;
			weapon = Weapons.RustyBlade;
			break;

		default:
			throw new IllegalArgumentException("Hero type is not implemented");

		}

		return new Hero(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, ability,
				weapon);

	}

}