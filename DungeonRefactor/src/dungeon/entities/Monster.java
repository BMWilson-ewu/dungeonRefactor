package dungeon.entities;

import java.io.Serializable;

import dungeon.abilities.AttackPool;
import dungeon.enums.Weapons;

public class Monster extends DungeonCharacter implements Serializable {

	private static final long serialVersionUID = -4784406317110797124L;
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