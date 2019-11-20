package heros;

import common.AttackResult;
import common.DungeonCharacter;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Warrior extends Hero {

	public Warrior() {

		super("Warrior", 125, 4, .8, 35, 60, .2, HeroType.WARRIOR);

	}// end constructor

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

}// end Hero class