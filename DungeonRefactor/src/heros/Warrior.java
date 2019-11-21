package heros;

import common.AttackResult;
import common.DungeonCharacter;

public class Warrior extends Hero {

	public Warrior(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, HeroType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);
	}

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		boolean couldAttack = Math.random() <= .4;
		int damage = 0;
		if (couldAttack) {
			damage = (int) (Math.random() * 76) + 100;
			opponent.subtractHitPoints(damage);
		}
		return new AttackResult(damage, couldAttack);
	}

}