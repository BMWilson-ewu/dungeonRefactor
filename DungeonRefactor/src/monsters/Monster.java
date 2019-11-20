package monsters;

import java.util.Random;

import common.AttackResult;
import common.DungeonCharacter;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class Monster extends DungeonCharacter {
	private double chanceToHeal;
	private int minHeal, maxHeal;
	private MonsterType type;

//-----------------------------------------------------------------
	public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal, MonsterType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
		this.type = type;

	}// end monster constructor

//-----------------------------------------------------------------
	public MonsterType getType() {
		return this.type;
	}
	
	public AttackResult heal() {
		Random rnjesus = new Random();
		boolean canHeal = (rnjesus.nextDouble() <= chanceToHeal) && (this.getHitPoints() > 0);
		int healPoints = 0;

		if (canHeal) {
			healPoints = (int) (rnjesus.nextDouble() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
		}

		return new AttackResult(healPoints, canHeal);
	}// end heal method

//-----------------------------------------------------------------
	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		heal();

	}// end method

}// end Monster class