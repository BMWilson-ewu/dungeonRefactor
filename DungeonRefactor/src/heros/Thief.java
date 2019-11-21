package heros;

import java.util.Random;

import common.AttackResult;
import common.DungeonCharacter;

public class Thief extends Hero {

	public Thief(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, HeroType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);
	}

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		Random rnjesus = new Random();
		AttackResult grabDamage;
		double surprise = rnjesus.nextDouble();
		boolean couldLandSpecialAttack = surprise <= .4;
		int damage = 0;
		if (couldLandSpecialAttack) {
			this.incrementTurnCount();
			grabDamage = attack(opponent);
			damage = grabDamage.getDamageDone();
		} // end surprise
		else if (surprise < .9) {
			grabDamage = attack(opponent);
			damage = grabDamage.getDamageDone();
		}
		return new AttackResult(damage, couldLandSpecialAttack);
	}

}