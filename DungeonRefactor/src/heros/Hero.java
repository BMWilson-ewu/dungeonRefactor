package heros;

import common.AttackResult;
import common.DungeonCharacter;

public abstract class Hero extends DungeonCharacter {

	private double chanceToBlock;
	private int numTurns;
	private HeroType type;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, HeroType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.type = type;
	}

	public HeroType getType() {
		return this.type;
	}

	public int getTurns() {
		return this.numTurns;
	}

	public void incrementTurnCount() {
		this.numTurns += 1;
	}

	public void decrementTurnCount() {
		this.numTurns -= 1;
	}

	public boolean defend() {
		return Math.random() <= chanceToBlock;
	}

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(this.getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}

	public int determinTurns(DungeonCharacter opponent) {
		return numTurns = this.getAttackSpeed() / opponent.getAttackSpeed() != 0 ? numTurns : 1;
	}

	public abstract AttackResult specialAttack(DungeonCharacter opponent);

}