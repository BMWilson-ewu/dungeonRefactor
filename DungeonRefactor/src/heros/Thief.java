package heros;
import java.util.Random;

import common.AttackResult;
import common.DungeonCharacter;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5, HeroType.THIEF);



    }//end constructor

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		Random rnjesus = new Random();
		AttackResult grabDamage;
		double surprise = rnjesus.nextDouble();
		boolean couldLandSpecialAttack = surprise <= .4;
		int damage = 0;
		if (couldLandSpecialAttack)
		{
			this.incrementTurnCount();
			grabDamage = attack(opponent);
			damage = grabDamage.getDamageDone();
		}//end surprise
		else if (surprise < .9)
		{
			grabDamage = attack(opponent);
			damage = grabDamage.getDamageDone();
		}
		return new AttackResult(damage, couldLandSpecialAttack);
	}

}