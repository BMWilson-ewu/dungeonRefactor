package heros;

import common.AttackResult;
import common.DungeonCharacter;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero {
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
	public Sorceress() {
		super("Sorceress", 75, 5, .7, 25, 50, .3, HeroType.SORCERESS);

	}// end constructor

//-----------------------------------------------------------------

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		boolean couldHeal = true;
		int hPoints;

		hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);

		return new AttackResult(hPoints, couldHeal);
	}

}// end class