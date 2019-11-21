package heros;

import common.AttackResult;
import common.DungeonCharacter;

public class Sorceress extends Hero {
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

	public Sorceress(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, HeroType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, type);
	}

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		boolean couldHeal = true;
		int hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		return new AttackResult(hPoints, couldHeal);
	}

}