package entities;

import abilities.AttackPool;
import enums.Weapons;

public class Monster extends DungeonCharacter {

	private double chanceToHeal;
	private int minHeal, maxHeal;

	public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal, Weapons w) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, w);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;

	}

	public double getChanceToHeal() {
		return this.chanceToHeal;
	}

	public int getMinHeal() {
		return this.minHeal;
	}

	public int getMaxHeal() {
		return this.maxHeal;
	}

	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		AttackPool.getInstanceOf().getBasicHeal().heal(this);
	}

}